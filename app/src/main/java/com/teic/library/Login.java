package com.teic.library;

import com.teic.library.user.User;

import java.util.Scanner;

import static com.teic.library.ANSI.CLEAR_SCREEN;

public class Login {
    public void run() {
        menuOptions();
    }

    private void menuOptions() {
        Scanner in = new Scanner(System.in);

        loop:
        while (true) {
            System.out.print(CLEAR_SCREEN);
            System.out.flush();

            System.out.print(
                "Library Management System:\n" +
                "1. Login as Existing User\n" +
                "2. Make a New Account\n" +
                "0. Exit\n" +
                "> "
            );

            String optionSelected = in.nextLine();

            switch (optionSelected) {
                case "1" -> existingUserLogin();
                case "2" -> newUserLogin();
                case "0" -> { break loop; }
            }
        }
    }

    private void existingUserLogin() {
        Scanner in = new Scanner(System.in);

        System.out.print(CLEAR_SCREEN);

        while (true) {
            System.out.println("Login as Existing User ('0' to return)");
            System.out.print("Username: ");
            String username = in.nextLine();

            if (username.equals("0")) break;

            System.out.print("Password: ");
            String password = LoginManager.stringToHash(in.nextLine());

            if (!LoginManager.credentialsMatch(username, password)) {
                System.out.print(CLEAR_SCREEN);
                System.out.println("Username or Password is incorrect or does not exist!\n");
                continue;
            }

            User user = new User(username);
            user.run();

            break;
        }
    }

    private void newUserLogin() {
        Scanner in = new Scanner(System.in);

        System.out.print(CLEAR_SCREEN);
        while (true) {
            System.out.print("Make a New Account ('0' to return)\n");

            System.out.print("Username: ");
            String username = in.nextLine();

            if (username.equals("0")) break;

            if (LoginManager.isExistingUser(username)) {
                System.out.print(CLEAR_SCREEN);
                System.out.println("Username already exists!\n");
                continue;
            }

            System.out.print("Password: ");
            String password = LoginManager.stringToHash(in.nextLine());

            System.out.print("Confirm Password: ");
            String confirmPassword = LoginManager.stringToHash(in.nextLine());

            if (!password.equals(confirmPassword)) {
                System.out.print(CLEAR_SCREEN);
                System.out.println("Password does not match!\n");
                continue;
            }

            LoginManager.addUser(username, password);

            break;
        }
    }
}
