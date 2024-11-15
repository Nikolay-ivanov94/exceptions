package test;

import validator.Validator;
import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class ValidatorTest {
    public static void main(String[] args) {
        testValidCredentials();
        testInvalidLogin();
        testInvalidPassword();
        testNonMatchingPasswords();
    }

    public static void testValidCredentials() {
        try {
            Validator.validateCredentials("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
            System.out.println("testValidCredentials passed.");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("testValidCredentials failed: " + e.getMessage());
        }
    }

    public static void testInvalidLogin() {
        try {
            Validator.validateCredentials("java_skypro_go_exceeding_length", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
            System.out.println("testInvalidLogin failed: exception was not thrown.");
        } catch (WrongLoginException e) {
            System.out.println("testInvalidLogin passed: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("testInvalidLogin failed: wrong exception type " + e.getMessage());
        }
    }

    public static void testInvalidPassword() {
        try {
            Validator.validateCredentials("java_skypro_go", "invalid_password_exceeding_length", "invalid_password_exceeding_length");
            System.out.println("testInvalidPassword failed: exception was not thrown.");
        } catch (WrongLoginException e) {
            System.out.println("testInvalidPassword failed: wrong exception type " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("testInvalidPassword passed: " + e.getMessage());
        }
    }

    public static void testNonMatchingPasswords() {
        try {
            Validator.validateCredentials("java_skypro_go", "D_1hWiKjjP_9", "different_password");
            System.out.println("testNonMatchingPasswords failed: exception was not thrown.");
        } catch (WrongLoginException e) {
            System.out.println("testNonMatchingPasswords failed: wrong exception type " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("testNonMatchingPasswords passed: " + e.getMessage());
        }
    }
}