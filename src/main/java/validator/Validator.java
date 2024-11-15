package validator;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Validator {
    private static final int MAX_LENGTH = 20;
    private static final String VALID_PATTERN = "[A-Za-z0-9_]+";

    public static void validateCredentials(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        // Проверка логина
        if (login.length() > MAX_LENGTH || !login.matches(VALID_PATTERN)) {
            throw new WrongLoginException("Login is invalid. It should be less than or equal to 20 characters and contain only letters, digits, and underscores.");
        }

        // Проверка пароля
        if (password.length() > MAX_LENGTH || !password.matches(VALID_PATTERN)) {
            throw new WrongPasswordException("Password is invalid. It should be less than or equal to 20 characters and contain only letters, digits, and underscores.");
        }

        // Проверка совпадения паролей
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and confirm password do not match.");
        }
    }
}