package com.bytedance.ttnet.l;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import d.b.r.x;

/* JADX INFO: loaded from: classes.dex */
public class a {
    static {
    }

    private static boolean a() {
        if (TTNetInit.f.f6287g == TTNetInit.getEnv()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(Context r1) {
        if (a() == true) goto L5;
        return;
    L5:
        d(r1);
    }

    public static void c() {
        Logger.setLogLevel(2);
        x.b(Logger.getLogLevel());
    }

    private static void d(Context r0) {
        if (b.c(r0) == false) goto L6;
        c();
        return;
    }

    public static boolean e() {
        if (a() == true) goto L7;
        return false;
    L7:
        return b.d(TTNetInit.getTTNetDepend().getContext());
    }
}
