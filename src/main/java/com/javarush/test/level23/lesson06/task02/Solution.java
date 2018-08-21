package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public static final class Constants {
        public static final String str1 = "Server is not accessible for now.";
        public static final String str2 = "User is not authorized.";
        public static final String str3 = "User is banned.";
        public static final String str4 = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Solution.Constants.str1);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Solution.Constants.str1, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Solution.Constants.str2);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Solution.Constants.str2, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Solution.Constants.str3);
        }

        public BannedUserException(Throwable cause) {
            super(Solution.Constants.str3, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Solution.Constants.str4);
        }

        public RestrictionException(Throwable cause) {
            super(Solution.Constants.str4, cause);
        }
    }
}
