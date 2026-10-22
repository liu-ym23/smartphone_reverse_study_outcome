package com.bytedance.monitor.collector.p;

import android.os.Build;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static Field a(Class<?> r1, String r2) {
        if (c() == false) goto L9;
        return b(r1, r2);
    L6:
        return null;
    L9:
        return d.b.l.a.b.a(r1, r2);
    }

    public static Field b(Class<?> r6, String r7) {
        Field r8 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7});     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static boolean c() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }
}
