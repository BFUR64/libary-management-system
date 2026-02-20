package com.teic.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        Login login = new Login();
        login.run();
    }
}
