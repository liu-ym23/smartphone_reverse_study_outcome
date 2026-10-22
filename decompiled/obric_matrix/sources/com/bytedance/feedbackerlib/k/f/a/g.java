package com.bytedance.feedbackerlib.k.f.a;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static int a(Context r0, int r1) {
        int r2 = Math.round(r0.getResources().getDisplayMetrics().widthPixels / r1);
        if (r2 != 0) goto L6;
        return 1;
    L6:
        return r2;
    }
}
