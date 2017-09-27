package com.android.qualtechassignment.utilities;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by T on 14-04-2016.
 */
public class Logger {
    public static final String COMMON_TAG = "QUA_";

    public static void d(String TAG, String msg) {
        if (isLoggingEnabled())
            Log.d(TAG, msg);
    }

    public static void d(String msg) {
        if (isLoggingEnabled() && !TextUtils.isEmpty(msg))
            Log.d(COMMON_TAG, msg);
    }

    private static boolean isLoggingEnabled() {
        return true;
    }
}
