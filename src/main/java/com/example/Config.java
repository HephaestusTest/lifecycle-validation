package com.example;

public class Config {
    public static final int MAX_USERS = 10000;
    public static final String DEFAULT_ROLE = "viewer";
    public static final boolean AUDIT_ENABLED = true;
    // TODO: move to config file
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/mydb";
    public static final String DB_PASSWORD = "changeme"; // FIXME: hardcoded credential
}
