package com.bytedance.feedbackerlib.k.f.a;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static boolean a() {
        if (Build.VERSION.SDK_INT < 14) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        return true;
    L5:
        return false;
    }
}
