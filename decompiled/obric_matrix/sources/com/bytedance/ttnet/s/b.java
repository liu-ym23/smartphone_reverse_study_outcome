package com.bytedance.ttnet.s;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(boolean r0) {
        return Boolean.valueOf(r0).toString();
    }

    public static String b(Context r2, int r3) {
        switch(r3) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L14;
        };
    L5:
        com.bytedance.ttnet.e r4 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        String r1 = "is_full_config";
    L6:
        String r5 = r4.h(r2, r1, "");     // Catch: Exception -> L19
    L16:
        if ((r5 instanceof String) == true) goto L18;
        return "";
    L18:
        return String.valueOf(r5);
    L7:
        r4 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "tnc_abtest";
        goto L6
    L8:
        r4 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "tnc_etag";
        goto L6
    L9:
        r4 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "tnc_config";
        goto L6
    L10:
        r4 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "https_dns";
        goto L6
    L11:
        r4 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "dns";
        goto L6
    L12:
        r4 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "ssids";
    L14:
        r5 = "";
        goto L16
    }

    public static void c(Context r1, int r2, String r3) {
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L15
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L13;
        };     // Catch: Exception -> L15
    L5:
        String r4 = "is_full_config";
    L6:
        r0.put(r4, r3);     // Catch: Exception -> L15
        goto L13
    L7:
        r4 = "tnc_abtest";
        goto L6
    L8:
        r4 = "tnc_etag";
        goto L6
    L9:
        r4 = "tnc_config";
        goto L6
    L10:
        r4 = "https_dns";
        goto L6
    L11:
        r4 = "dns";
        goto L6
    L12:
        r4 = "ssids";
    L13:
        Logger.debug();     // Catch: Exception -> L15
        TTNetInit.getTTNetDepend().b(r1, r0);     // Catch: Exception -> L15
        return;
    }

    public static boolean d(String r0) {
        return Boolean.parseBoolean(r0);
    }
}
