package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void shouldCreateUser() {
        var service = new UserService();
        var user = service.createUser("Alice", "alice@example.com");
        assertEquals("Alice", user.name());
        assertEquals("alice@example.com", user.email());
    }

    @Test
    void shouldFindUserByEmail() {
        var service = new UserService();
        service.createUser("Bob", "bob@example.com");
        var found = service.findByEmail("bob@example.com");
        assertTrue(found.isPresent());
    }
}
