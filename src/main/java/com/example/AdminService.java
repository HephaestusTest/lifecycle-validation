package com.example;

import java.util.*;

public class AdminService {

    private final UserService userService;
    private final Map<String, String> auditLog = new LinkedHashMap<>();

    public AdminService(UserService userService) {
        this.userService = userService;
    }

    // Bulk delete - no validation, no error handling
    public int bulkDeleteUsers(List<String> emails) {
        int count = 0;
        for (String email : emails) {
            userService.deleteUser(email);
            count++;
            auditLog.put(email, "deleted at " + new Date());
        }
        return count;
    }

    // Exports all users as CSV - unbounded, no pagination
    public String exportUsersCsv() {
        StringBuilder sb = new StringBuilder("name,email\n");
        // Bug: this accesses private field directly (won't compile in real scenario)
        // Simulating bad practice of exposing internals
        return sb.toString();
    }

    public Map<String, String> getAuditLog() {
        return auditLog; // Bug: returns mutable internal state
    }
}
