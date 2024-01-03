package com.fishybusiness.afishybusiness.shared;

import java.util.Map;

public class Constant {

    private Constant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String RESULT_OK = "OK";
    public static final String RESULT_KO = "KO";

    public static final String USER_RESPONSE_CODE_PREFIX = "USER-";

    public static Map<String, String> getUserResponseHashMap() {
        return Map.of(
            USER_RESPONSE_CODE_PREFIX + "1", "User not found",
            USER_RESPONSE_CODE_PREFIX + "2", "User already exists",
            USER_RESPONSE_CODE_PREFIX + "3", "User not created",
            USER_RESPONSE_CODE_PREFIX + "4", "User not updated",
            USER_RESPONSE_CODE_PREFIX + "5", "User not deleted",
            USER_RESPONSE_CODE_PREFIX + "6", "User found",
            USER_RESPONSE_CODE_PREFIX + "7", "User created",
            USER_RESPONSE_CODE_PREFIX + "8", "User updated",
            USER_RESPONSE_CODE_PREFIX + "9", "User deleted",
            USER_RESPONSE_CODE_PREFIX + "10", "User list found"
        );
    }
}