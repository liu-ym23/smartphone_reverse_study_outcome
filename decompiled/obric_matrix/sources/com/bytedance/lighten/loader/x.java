package com.bytedance.lighten.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
class x {
    static int a(Context r5) {
        ActivityManager r0 = (ActivityManager) c(r5, "activity");
        if ((r5.getApplicationInfo().flags & 1048576) == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        int r2 = r0.getLargeMemoryClass();
    L9:
        int r3 = (int) ((((long) r2) * 1048576) / 10);
        int r6 = b(r5);
        if (r3 > r6) goto L15;
        if (r3 < 6291456) goto L14;
        return r3;
    L14:
        return 6291456;
    L15:
        return r6;
    L8:
        r2 = r0.getMemoryClass();
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    private static int b(Context r1) {
        WindowManager r2 = (WindowManager) r1.getSystemService("window");
        DisplayMetrics r0 = new DisplayMetrics();
        r2.getDefaultDisplay().getMetrics(r0);
        return ((r0.widthPixels * r0.heightPixels) * 4) * 4;
    }

    static <T> T c(Context r0, String r1) {
        return (T) r0.getSystemService(r1);
    }

    static d.c.f.f.d.a d(d.b.k.a.e.d r1) {
        if (r1 != d.b.k.a.e.d.f13998f) goto L7;
        return d.c.f.f.d.a.f15708f;
    L7:
        return d.c.f.f.d.a.f15709g;
    }
}
