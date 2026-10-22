package com.ss.android.larksso;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static boolean a() {
        if (Build.DISPLAY.indexOf("Flyme") < 0) goto L5;
        return true;
    L5:
        if (Build.USER.equals("flyme") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean b() {
        if (Class.forName("miui.os.Build") == null) goto L6;
        return true;
    L6:
        return false;
    L11:
        return false;
    }

    static boolean c(boolean r8, Window r9) {
        Class<?> r2 = r9.getClass();     // Catch: Throwable -> L9
        Class<?> r3 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L9
        int r4 = r3.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r3);     // Catch: Throwable -> L9
        Class<?> r7 = Integer.TYPE;     // Catch: Throwable -> L9
        Method r5 = r2.getMethod("setExtraFlags", new Class[]{r7, r7});     // Catch: Throwable -> L9
        Object[] r6 = new Object[2];     // Catch: Throwable -> L9
        if (r8 == false) goto L6;
        int r10 = r4;
    L7:
        r6[0] = Integer.valueOf(r10);     // Catch: Throwable -> L9
        r6[1] = Integer.valueOf(r4);     // Catch: Throwable -> L9
        r5.invoke(r9, r6);     // Catch: Throwable -> L9
        return true;
    L6:
        r10 = 0;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean d(Context r3, Window r4) {
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = false;
        if (r0 < 21) goto L22;
        if (r3 == null) goto L22;
        if (r4 == null) goto L22;
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L8:
        if (b() == false) goto L13;
        if (c(true, r4) == false) goto L16;
        r1 = true;
    L16:
        if (r0 < 23) goto L18;
        View r5 = r4.getDecorView();     // Catch: Throwable -> L20
        r5.setSystemUiVisibility(r5.getSystemUiVisibility() | 8192);     // Catch: Throwable -> L20
        r1 = true;
    L18:
        r4.clearFlags(67108864);     // Catch: Throwable -> L20
        r4.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L20
        goto L22
    L13:
        if (a() == false) goto L16;
        return false;
    L22:
        return r1;
    }
}
