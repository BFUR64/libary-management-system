package com.teic.library;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Login {
    public void run() {
        Scanner in = new Scanner(System.in);

        System.out.println("LOGIN\n");

        while (true) {
            System.out.print("username: ");
            String username = in.nextLine();

            System.out.print("password: ");
            String password = Hashing.sha256()
                .hashString(in.nextLine(), StandardCharsets.UTF_8)
                .toString();

            System.out.print("confirm password: ");

            String confirmPassword = Hashing.sha256()
                    .hashString(in.nextLine(), StandardCharsets.UTF_8)
                    .toString();

            boolean passwordMatched = password.equals(confirmPassword);
            
            System.out.printf(
                "Username: %s\n" +
                "Password Hash: %s\n" +
                "Confirm Password Hash: %s\n" +
                "Passwords Matched: %b",
                username,
                password,
                confirmPassword,
                passwordMatched
            );

            break;
        }

    }
}
