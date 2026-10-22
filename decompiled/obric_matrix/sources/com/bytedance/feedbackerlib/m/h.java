package com.bytedance.feedbackerlib.m;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static boolean a(Context r2) {
        if (r2.getPackageManager().getApplicationInfo("com.ss.android.lark", 0) == null) goto L11;
        return true;
    L11:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
