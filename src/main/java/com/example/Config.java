package com.example;

/**
 * Application configuration constants.
 */
public class Config {
    public static final int MAX_USERS = 10_000;
    public static final String DEFAULT_ROLE = "viewer";
    public static final boolean AUDIT_ENABLED = true;

    // Credentials loaded from environment
    public static String getDbUrl() {
        return System.getenv("DB_URL");
    }

    public static String getDbPassword() {
        return System.getenv("DB_PASSWORD");
    }
}
