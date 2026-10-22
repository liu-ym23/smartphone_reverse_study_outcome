package com.bytedance.bdinstall.d1;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static boolean a(Context r3, String r4) {
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        return true;
    L12:
        if (r3.checkSelfPermission(r4) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public static boolean b(Context r1) {
        return a(r1, "android.permission.READ_PHONE_STATE");
    }
}
