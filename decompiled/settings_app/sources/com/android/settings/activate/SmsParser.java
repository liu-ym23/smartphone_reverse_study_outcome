package com.android.settings.activate;

import android.os.Bundle;
import com.android.settings.search.Index;
import com.obric.olog.OLog;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class SmsParser {
    private static final int HEXADECIMAL = 16;
    private static final int INDEX_ACCOUNT = 4;
    private static final int INDEX_UID = 3;

    public SmsParser() {
    }

    public static Bundle parseSms(String r14) {
        Bundle r0 = new Bundle();
        String r1 = "";
        if (r14 != null) goto L5;
    L34:
        r0.putInt("result", -1);
        return r0;
    L5:
        if (r14.length() == 0) goto L34;
        String r4 = ActivateService.getImei();
        MessageDigest r7 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L10
        r7.update(r4.getBytes());     // Catch: NoSuchAlgorithmException -> L10
        String r5 = new BigInteger(1, r7.digest()).toString(16);     // Catch: NoSuchAlgorithmException -> L10
    L12:
        if (r5 == null) goto L33;
        String[] r8 = r14.substring(r14.indexOf(Index.ENTRIES_SEPARATOR) + 1).split("\\|");
        if (r8.length >= 3) goto L16;
    L32:
        r0.putInt("result", -1);
        OLog.e("SettingsBytedance", "verify failed, received body is " + r14);
        goto L33
    L16:
        if (ActivateService.ACTIVATE_SMS_TYPE.equals(r8[0]) == false) goto L32;
        if (String.valueOf(1).equals(r8[1]) == false) goto L32;
        if (r5.equals(r8[2]) == false) goto L32;
        long r12 = 0;
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        r0.putInt("result", 0);
        r0.putLong("uid", r12);
        r0.putString("account", r1);
        OLog.d("SettingsBytedance", "verify success.");
        goto L33
    L23:
        if (r8.length <= 3) goto L26;
        r12 = Long.valueOf(r8[3], 16).longValue();     // Catch: NumberFormatException -> L29
    L26:
        if (r8.length <= 4) goto L31;
        r1 = r8[4];     // Catch: NumberFormatException -> L29
    L33:
        return r0;
    L10:
        e = move-exception;
        e.printStackTrace();
        r5 = null;
        goto L12
    }
}
