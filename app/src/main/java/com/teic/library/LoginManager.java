package com.teic.library;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class LoginManager {
    static Map<String, String> users = new HashMap<>();

    static {
        users.put("terrance1120", stringToHash("1234"));
    }

    public static boolean credentialsMatch(String username, String passwordHash) {
        if (!isExistingUser(username)) return false;

        String storedPasswordHash = users.get(username);

        return storedPasswordHash != null && storedPasswordHash.equals(passwordHash);
    }

    public static boolean addUser(String username, String passwordHash) {
        if (isExistingUser(username)) return false;

        users.put(username, passwordHash);
        return true;
    }

    public static boolean isExistingUser(String username) {
        return users.containsKey(username);
    }

    public static String stringToHash(String string) {
        return Hashing.sha256()
            .hashString(string, StandardCharsets.UTF_8)
            .toString();
    }
}
