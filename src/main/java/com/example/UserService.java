package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Service for managing user accounts.
 */
public class UserService {

    private final Map<String, User> users = new HashMap<>();

    public User createUser(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        User user = new User(name, email);
        users.put(email, user);
        return user;
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(users.get(email));
    }

    public boolean deleteUser(String email) {
        return users.remove(email) != null;
    }

    public record User(String name, String email) {}
}
