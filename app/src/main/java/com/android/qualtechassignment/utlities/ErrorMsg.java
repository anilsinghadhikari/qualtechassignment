package com.android.qualtechassignment.utlities;

import org.jetbrains.annotations.NotNull;

/**
 * Created by qainfotech on 13/4/16.
 */
public class ErrorMsg {
    public static final String ERROR_TITLE = "Error!!";
    public static final String UNKNOWN_ERROR = "Unknown error occured. Please try again";
    public static final String REQUST_CUDNT_PROCESS = "Request couldn't be processed. Try again!";
    public static final String UNABLE_TO_FETCH_INFO = "Failed fetching info. Please fill your self.";
    public static String NO_Internet_TITLE = "Network Error!";
    public static String NO_Internet_MSG = "Internet Not available. Please enable internet and try again!";
    public static String ERROR_NO_Internet_CONTACT_NOT_SYNCED = "Internet Not available. Unable to sync contactsFromPhoneBook";
    public static String ERROR_CONTACT_NOT_SYNC = "Some error occured. Failed syncing contactsFromPhoneBook";
    public static String OnFailureTitle = "Failure!";
    public static String READ_CONTACT_PERMISSION_REQUIRED = "You must grant this permission to use this feature.";
    @NotNull
    public static final String UNKNOWN_ERROR_WHILE_SENDING_SOS = "Some error occured while sending your SOS. Please retry";
}
