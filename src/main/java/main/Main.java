package main;

import test.ValidatorTest;

public class Main {
    public static void main(String[] args) {
        // Запуск тестов
        ValidatorTest.testValidCredentials();
        ValidatorTest.testInvalidLogin();
        ValidatorTest.testInvalidPassword();
        ValidatorTest.testNonMatchingPasswords();
    }
}