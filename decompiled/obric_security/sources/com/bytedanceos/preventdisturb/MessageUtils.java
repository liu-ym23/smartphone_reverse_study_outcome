package com.bytedanceos.preventdisturb;

import android.content.Context;
import android.database.Cursor;
import android.os.Debug;
import android.os.Environment;
import android.provider.Telephony;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.utils.PhoneNumberUtilsObric;
import com.google.android.mms.pdu.EncodedStringValue;
import com.google.android.mms.pdu.PduPart;
import com.google.android.mms.pdu.PduPersister;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MessageUtils {
    public static final String BLACK_NUMBER_URI = "content://com.obric.nodisturb.provider/blacknumber";
    private static final char[] NUMERIC_CHARS_SUGAR = null;
    private static final String TAG = "MessageUtils";
    private static HashMap numericSugarMap;
    private static String sLocalNumber;
    private static String sNoSubjectString;
    private static final Map<String, String> sRecipientAddress = null;
    public static ArrayList<Long> sSameRecipientList;
    private static final int[] sVideoDuration = null;

    interface ResizeImageResultCallback {
        void onResizeResult(PduPart part, boolean append);
    }

    static {
        sRecipientAddress = new ConcurrentHashMap(20);
        sVideoDuration = new int[]{0, 5, 10, 15, 20, 30, 40, 50, 60, 90, 120};
        char[] r0 = {'-', '.', ',', '(', ')', ' ', IOUtils.DIR_SEPARATOR_UNIX, IOUtils.DIR_SEPARATOR_WINDOWS, '*', '#', '+'};
        NUMERIC_CHARS_SUGAR = r0;
        numericSugarMap = new HashMap(r0.length);
        sSameRecipientList = new ArrayList();
        int r1 = 0;
    L3:
        char[] r2 = NUMERIC_CHARS_SUGAR;
        if (r1 >= r2.length) goto L6;
        numericSugarMap.put(Character.valueOf(r2[r1]), Character.valueOf(r2[r1]));
        r1 = r1 + 1;
        goto L3
    }

    private MessageUtils() {
    }

    public static String cleanseMmsSubject(Context context, String subject) {
        if (TextUtils.isEmpty(subject) == false) goto L6;
        return subject;
    L6:
        if (sNoSubjectString != null) goto L9;
        sNoSubjectString = context.getResources().getString(R.string.empty_subject_strings);
    L9:
        if (subject.equalsIgnoreCase(sNoSubjectString) == false) goto L12;
        return null;
    L12:
        return subject;
    }

    public static String formatTimeStampString(Context context, long when) {
        return formatTimeStampString(context, when, false);
    }

    public static String formatTimeStampString(Context context, long when, boolean fullFormat) {
        Time r0 = new Time();
        r0.set(when);
        Time r1 = new Time();
        r1.setToNow();
        if (r0.year == r1.year) goto L6;
        int r2 = 101140;
    L9:
        if (fullFormat == false) goto L12;
        r2 = r2 | 17;
    L12:
        return DateUtils.formatDateTime(context, when, r2);
    L6:
        if (r0.yearDay == r1.yearDay) goto L8;
        r2 = 101136;
        goto L9
    L8:
        r2 = 101121;
        goto L9
    }

    public static String extractEncStrFromCursor(Cursor cursor, int columnRawBytes, int columnCharset) {
        String r1 = cursor.getString(columnRawBytes);
        int r0 = cursor.getInt(columnCharset);
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return "";
    L6:
        if (r0 != 0) goto L9;
        return r1;
    L9:
        return new EncodedStringValue(r0, PduPersister.getBytes(r1)).getString();
    }

    private static String extractEncStr(Context context, EncodedStringValue value) {
        if (value != null) goto L4;
        return "";
    L4:
        return value.getString();
    }

    public static void writeHprofDataToFile() {
        String r2 = Environment.getExternalStorageDirectory() + "/mms_oom_hprof_data";
        Debug.dumpHprofData(r2);     // Catch: IOException -> L5
        OLog.i(TAG, "##### written hprof data to " + r2);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "writeHprofDataToFile: caught " + e);
    }

    public static final int dp2Pixels(Context context, float dip) {
        return (int) ((dip * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean isAlias(String string) {
        if (string != null) goto L5;
        return false;
    L5:
        int r1 = string.length();
        if (Character.isLetter(string.charAt(0)) == true) goto L8;
        return false;
    L8:
        int r3 = 1;
    L9:
        if (r3 >= r1) goto L16;
        char r4 = string.charAt(r3);
        if (Character.isLetterOrDigit(r4) == true) goto L15;
        if (r4 == '.') goto L15;
        return false;
    L15:
        r3 = r3 + 1;
        goto L9
    L16:
        return true;
    }

    public static String formatPhoneNumber(String number) {
        if (TextUtils.isEmpty(number) == false) goto L7;
        return "";
    L7:
        if (Telephony.Mms.isEmailAddress(number) == false) goto L10;
        return number;
    L10:
        return PhoneNumberUtilsObric.getInstance().formatNumberToLite(SecurityCenterApplication.getApplication(), number, SecurityCenterApplication.getApplication().getCurrentCountryIso());
    }
}
