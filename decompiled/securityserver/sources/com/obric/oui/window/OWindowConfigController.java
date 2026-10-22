package com.obric.oui.window;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsetsController;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OWindowConfigController {
    public static int a(View r7) {
        Intrinsics.f(r7, "rootView");
        WindowInsetsController r8 = r7.getWindowInsetsController();     // Catch: Exception -> L8
        if (r8 == null) goto L33;
        Object r3 = null;
        Method r1 = r8.getClass().getDeclaredMethod("getState", null);     // Catch: Exception -> L8
        Intrinsics.e(r1, "getStateMethod");     // Catch: Exception -> L8
        r1.setAccessible(true);     // Catch: Exception -> L8
        Object r9 = r1.invoke(r8, null);     // Catch: Exception -> L8
        int r2 = Build.VERSION.SDK_INT;     // Catch: Exception -> L8
        if (r2 < 35) goto L10;
        Class<?> r5 = Class.forName("android.view.InsetsSource");     // Catch: Exception -> L8
    L11:
        if (r2 < 35) goto L13;
        Field r4 = r5.getDeclaredField("ID_IME");     // Catch: Exception -> L8
    L14:
        Intrinsics.e(r4, "insetField");     // Catch: Exception -> L8
        r4.setAccessible(true);     // Catch: Exception -> L8
        int r6 = r4.getInt(null);     // Catch: Exception -> L8
        Method r10 = r9.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L8
        Intrinsics.e(r10, "peekSourceMethod");     // Catch: Exception -> L8
        r10.setAccessible(true);     // Catch: Exception -> L8
        Object r11 = r10.invoke(r9, new Object[]{Integer.valueOf(r6)});     // Catch: Exception -> L8
        if ((r11 instanceof Object) == true) goto L17;
        r11 = null;
    L17:
        if (r11 == null) goto L33;
        Method r12 = r11.getClass().getDeclaredMethod("isVisible", null);     // Catch: Exception -> L8
        Intrinsics.e(r12, "isVisibleMethod");     // Catch: Exception -> L8
        r12.setAccessible(true);     // Catch: Exception -> L8
        Object r13 = r12.invoke(r11, null);     // Catch: Exception -> L8
        if ((r13 instanceof Boolean) == true) goto L21;
        r13 = null;
    L21:
        Boolean r14 = (Boolean) r13;     // Catch: Exception -> L8
        if (r14 == null) goto L33;
        if (r14.booleanValue() == false) goto L35;
        Method r15 = r11.getClass().getDeclaredMethod("getFrame", null);     // Catch: Exception -> L8
        Intrinsics.e(r15, "getFrameMethod");     // Catch: Exception -> L8
        r15.setAccessible(true);     // Catch: Exception -> L8
        Object r16 = r15.invoke(r11, null);     // Catch: Exception -> L8
        if ((r16 instanceof Rect) == false) goto L29;
        r3 = r16;
    L29:
        Rect r17 = (Rect) r3;     // Catch: Exception -> L8
        if (r17 == null) goto L33;
        return r17.height();
    L35:
        return 0;
    L13:
        r4 = r5.getDeclaredField("ITYPE_IME");     // Catch: Exception -> L8
        goto L14
    L10:
        r5 = Class.forName("android.view.InsetsState");     // Catch: Exception -> L8
    L33:
        return 0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    public static int b(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = r5.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (r1 > 0) goto L8;
        Class<?> r2 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r3 = r2.newInstance();     // Catch: Exception -> L11
        int r4 = Integer.parseInt(r2.getField("navigation_bar_height").get(r3).toString());     // Catch: Exception -> L11
        return r5.getResources().getDimensionPixelSize(r4);
    L11:
        return 0;
    L8:
        return r5.getResources().getDimensionPixelSize(r1);
    }
}
