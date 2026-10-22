package com.gyf.barlibrary;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class FlymeOSStatusBarFontUtils {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method mSetStatusBarColorIcon;
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;

    public static int toGrey(int r3) {
        int r0 = r3 & 255;
        int r1 = (65280 & r3) >> 8;
        return (((((r3 & 16711680) >> 16) * 38) + (r1 * 75)) + (r0 * 15)) >> 7;
    }

    public FlymeOSStatusBarFontUtils() {
    }

    static {
        mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L8
    L16:
        mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
    L12:
        mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");     // Catch: NoSuchFieldException -> L10
    L14:
        SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);     // Catch: Throwable -> L11
        return;
    }

    public static boolean isBlackColor(int r0, int r1) {
        if (toGrey(r0) >= r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setStatusBarDarkIcon(Activity r3, int r4) {
        Method r0 = mSetStatusBarColorIcon;
        if (r0 != null) goto L16;
        boolean r1 = isBlackColor(r4, 50);
        if (mStatusBarColorFiled == null) goto L14;
        setStatusBarDarkIcon(r3, r1, r1);
        setStatusBarDarkIcon(r3.getWindow(), r4);
        return;
    L14:
        setStatusBarDarkIcon(r3, r1);
        return;
    L16:
        r0.invoke(r3, new Object[]{Integer.valueOf(r4)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L21:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setStatusBarDarkIcon(Window r0, int r1) {
        setStatusBarColor(r0, r1);     // Catch: Exception -> L4
        setStatusBarDarkIcon(r0.getDecorView(), true);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setStatusBarDarkIcon(Activity r1, boolean r2) {
        setStatusBarDarkIcon(r1, r2, true);
    }

    private static boolean changeMeizuFlag(WindowManager.LayoutParams r3, String r4, boolean r5) {
        Field r6 = r3.getClass().getDeclaredField(r4);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        r6.setAccessible(true);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        int r7 = r6.getInt(r3);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        Field r1 = r3.getClass().getDeclaredField("meizuFlags");     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        r1.setAccessible(true);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        int r2 = r1.getInt(r3);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        if (r5 == false) goto L5;
        int r8 = r7 | r2;     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
    L6:
        if (r2 == r8) goto L21;
        r1.setInt(r3, r8);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        return true;
    L21:
        return false;
    L5:
        r8 = (~r7) & r2;     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private static void setStatusBarDarkIcon(View r1, boolean r2) {
        int r0 = r1.getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | r0;
    L6:
        if (r3 == r0) goto L9;
        r1.setSystemUiVisibility(r3);
        return;
    L9:
        return;
    L5:
        r3 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & r0;
        goto L6
    }

    private static void setStatusBarColor(Window r2, int r3) {
        WindowManager.LayoutParams r0 = r2.getAttributes();
        Field r1 = mStatusBarColorFiled;
        if (r1 == null) goto L13;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r1.getInt(r0) == r3) goto L14;
        mStatusBarColorFiled.set(r0, Integer.valueOf(r3));     // Catch: IllegalAccessException -> L8
        r2.setAttributes(r0);     // Catch: IllegalAccessException -> L8
        return;
    L14:
        return;
    }

    public static void setStatusBarDarkIcon(Window r1, boolean r2) {
        setStatusBarDarkIcon(r1.getDecorView(), r2);
        setStatusBarColor(r1, 0);
    }

    private static void setStatusBarDarkIcon(Activity r2, boolean r3, boolean r4) {
        Method r0 = mSetStatusBarDarkIcon;
        if (r0 != null) goto L14;
        if (r4 == false) goto L18;
        setStatusBarDarkIcon(r2.getWindow(), r3);
        return;
    L18:
        return;
    L14:
        r0.invoke(r2, new Object[]{Boolean.valueOf(r3)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L19:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
