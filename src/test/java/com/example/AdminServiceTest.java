package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {

    private UserService userService;
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        adminService = new AdminService(userService);
        userService.createUser("Alice", "alice@example.com");
        userService.createUser("Bob", "bob@example.com");
        userService.createUser("Charlie", "charlie@example.com");
    }

    @Test
    void bulkDeleteShouldRemoveUsers() {
        int deleted = adminService.bulkDeleteUsers(
            List.of("alice@example.com", "bob@example.com")
        );
        assertEquals(2, deleted);
        assertTrue(userService.findByEmail("alice@example.com").isEmpty());
        assertTrue(userService.findByEmail("bob@example.com").isEmpty());
        assertTrue(userService.findByEmail("charlie@example.com").isPresent());
    }

    @Test
    void bulkDeleteShouldRecordAuditLog() {
        adminService.bulkDeleteUsers(List.of("alice@example.com"));
        assertFalse(adminService.getAuditLog().isEmpty());
        assertTrue(adminService.getAuditLog().containsKey("alice@example.com"));
    }

    @Test
    void configShouldReadFromEnvironment() {
        assertEquals(10_000, Config.MAX_USERS);
        assertEquals("viewer", Config.DEFAULT_ROLE);
        assertTrue(Config.AUDIT_ENABLED);
    }
}
