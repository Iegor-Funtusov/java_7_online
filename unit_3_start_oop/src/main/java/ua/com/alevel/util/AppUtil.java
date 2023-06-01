package ua.com.alevel.util;

import java.util.UUID;

public final class AppUtil {

    // class - AppUtil, field & method findById()
    // public static (const) - APP_UTIL

    public static final String FIND_BY_ID_MESSAGE = "Please enter id";

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
