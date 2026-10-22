package com.bytedance.bdlocation.utils;

import android.util.Base64;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EncryptUtil {
    public EncryptUtil() {
    }

    @Nullable
    public static String decrypt(String r4) {
        if (r4 != null) goto L5;
    L13:
        return null;
    L5:
        if (r4.isEmpty() == true) goto L13;
        byte[] r5 = Base64.decode(r4, 10);     // Catch: Exception -> L14
        int r1 = r5.length;     // Catch: Exception -> L14
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        r5[r2] = (byte) (r5[r2] ^ (-99));     // Catch: Exception -> L14
        r2 = r2 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        return new String(r5);
    }

    @Nullable
    public static String encrypt(JSONObject r4) {
        if (r4 != null) goto L11;
        return null;
    L11:
        byte[] r5 = r4.toString().getBytes("utf-8");     // Catch: Exception -> L10
        int r1 = r5.length;     // Catch: Exception -> L10
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r5[r2] = (byte) (r5[r2] ^ (-99));     // Catch: Exception -> L10
        r2 = r2 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        return Base64.encodeToString(r5, 10);
    L10:
        return null;
    }
}
