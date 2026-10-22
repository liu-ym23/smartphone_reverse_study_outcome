package com.bytedance.frameworks.baselib.network.http.util;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public class NetworklibUtils {
    private static final String TAG = "NetworklibUtils";

    static {
    }

    public NetworklibUtils() {
    }

    public static boolean splitStringIntoKeyValuePairs(String r5, String r6, String r7, List<Pair<String, String>> r8) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L44;
        if (r8 == null) goto L46;
        String[] r9 = r5.split(r6);
        if (r9 != null) goto L13;
        return false;
    L13:
        int r10 = 0;
    L15:
        if (r10 >= r9.length) goto L32;
        if (TextUtils.isEmpty(r9[r10]) == true) goto L30;
        String[] r0 = r9[r10].trim().split(r7);
        if (r0 == null) goto L30;
        if (r0.length != 2) goto L30;
        if (TextUtils.isEmpty(r0[0]) == true) goto L30;
        if (TextUtils.isEmpty(r0[1]) == true) goto L30;
        r8.add(new Pair(r0[0].trim(), r0[1].trim()));
    L30:
        r10 = r10 + 1;
        goto L15
    L32:
        if (r8.size() != 0) goto L34;
        return false;
    L34:
        return true;
    L46:
        return false;
    L44:
        return false;
    }

    public static boolean splitUTCTimeSegmentToList(String r8, List<Long> r9) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return false;
    L6:
        if (r8.contains("~") == true) goto L8;
        return false;
    L8:
        String[] r10 = r8.split("~");
        if (r10.length == 2) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r10[0]) == false) goto L14;
    L27:
        return false;
    L14:
        if (TextUtils.isEmpty(r10[1]) == true) goto L27;
        if (r9 != null) goto L18;
        r9 = new ArrayList();
    L18:
        long r2 = parseUTCTimeToLocal(r10[0]);
        long r4 = parseUTCTimeToLocal(r10[1]);
        if (r2 <= 0) goto L27;
        if (r4 <= 0) goto L27;
        if (r2 >= r4) goto L27;
        r9.add(Long.valueOf(r2));
        r9.add(Long.valueOf(r4));
        return true;
    }

    public static long parseUTCTimeToLocal(String r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "utcTime " + r3);
    L5:
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        r0.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date r4 = r0.parse(r3);     // Catch: ParseException -> L10
        if (r4 == null) goto L15;
        return r4.getTime();
    L15:
        return 0;
    L10:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }
}
