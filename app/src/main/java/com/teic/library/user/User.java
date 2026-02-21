package com.teic.library.user;

import java.util.Scanner;

import static com.teic.library.ANSI.CLEAR_SCREEN;

public class User {
    private final String currentUser;

    public User(String currentUser) {
        this.currentUser = currentUser;
    }

    public void run() {
        menuOptions();
    }

    public void menuOptions() {
        Scanner in = new Scanner(System.in);

        System.out.print(CLEAR_SCREEN);

        System.out.printf(
            "Welcome %s!%n" +
            "1. Book Search%n" +
            "2. Books Borrowed%n" +
            "0. Return to Main Menu%n" +
            "> ",
            currentUser
        );

        in.nextLine();
    }
}
