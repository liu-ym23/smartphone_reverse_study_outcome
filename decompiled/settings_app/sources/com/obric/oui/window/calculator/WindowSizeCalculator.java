package com.obric.oui.window.calculator;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.obric.oui.window.model.WindowMetrics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowSizeCalculator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/window/calculator/WindowSizeCalculator;", "", "()V", "TAG", "", "computeCurrentWindowMetrics", "Lcom/obric/oui/window/model/WindowMetrics;", "activity", "Landroid/app/Activity;", "computeWindowBoundsN", "Landroid/graphics/Rect;", "computeWindowBoundsN$OUI_standardRelease", "computeWindowBoundsP", "computeWindowBoundsP$OUI_standardRelease", "computeWindowBoundsQ", "computeWindowBoundsQ$OUI_standardRelease", "computeWindowBoundsUnderN", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "getNavigationBarHeight", "", "context", "Landroid/content/Context;", "getRealSizeForDisplay", "Landroid/graphics/Point;", "getRectSizeFromDisplay", "", "bounds", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowSizeCalculator {
    public static final WindowSizeCalculator INSTANCE = null;
    private static final String TAG = "WindowSizeCalculator";

    static {
        INSTANCE = new WindowSizeCalculator();
    }

    private WindowSizeCalculator() {
    }

    public final WindowMetrics computeCurrentWindowMetrics(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        return new WindowMetrics(ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(r1));
    }

    public final Rect computeWindowBoundsQ$OUI_standardRelease(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Configuration r1 = r7.getResources().getConfiguration();
        Field r2 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        r2.setAccessible(true);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        Object r3 = r2.get(r1);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        Object r4 = r3.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r3, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
        if (r4 == null) goto L7;
        return new Rect((Rect) r4);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 NoSuchFieldException -> L14
    L10:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$OUI_standardRelease(r7);
    L14:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$OUI_standardRelease(r7);
    L12:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$OUI_standardRelease(r7);
    L8:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$OUI_standardRelease(r7);
    }

    public final Rect computeWindowBoundsP$OUI_standardRelease(Activity r9) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Rect r1 = new Rect();
        Configuration r2 = r9.getResources().getConfiguration();
        Field r4 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        r4.setAccessible(true);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        Object r3 = r4.get(r2);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r9) == false) goto L11;
        Object r5 = r3.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r3, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (r5 == null) goto L10;
        r1.set((Rect) r5);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L24:
        Display r0 = r9.getWindowManager().getDefaultDisplay();
        Point r6 = new Point();
        DisplayCompatHelperApi17 r7 = DisplayCompatHelperApi17.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r0, "currentDisplay");
        r7.getRealSize(r0, r6);
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r9) == true) goto L36;
        int r8 = getNavigationBarHeight(r9);
        if ((r1.bottom + r8) != r6.y) goto L30;
        r1.bottom += r8;
        goto L36
    L30:
        if ((r1.right + r8) != r6.x) goto L33;
        r1.right += r8;
        goto L36
    L33:
        if (r1.left != r8) goto L36;
        r1.left = 0;
    L36:
        if (r1.width() < r6.x) goto L40;
        if (r1.height() < r6.y) goto L40;
    L55:
        return r1;
    L40:
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r9) == true) goto L55;
        DisplayCutout r10 = getCutoutForDisplay(r0);
        if (r10 == null) goto L55;
        if (r1.left != DisplayCompatHelperApi28.INSTANCE.safeInsetLeft(r10)) goto L47;
        r1.left = 0;
    L47:
        if ((r6.x - r1.right) != DisplayCompatHelperApi28.INSTANCE.safeInsetRight(r10)) goto L50;
        r1.right += DisplayCompatHelperApi28.INSTANCE.safeInsetRight(r10);
    L50:
        if (r1.top != DisplayCompatHelperApi28.INSTANCE.safeInsetTop(r10)) goto L53;
        r1.top = 0;
    L53:
        if ((r6.y - r1.bottom) != DisplayCompatHelperApi28.INSTANCE.safeInsetBottom(r10)) goto L55;
        r1.bottom += DisplayCompatHelperApi28.INSTANCE.safeInsetBottom(r10);
        goto L55
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L11:
        Object r11 = r3.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r3, new Object[0]);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        if (r11 == null) goto L15;
        r1.set((Rect) r11);     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
        goto L24
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18 NoSuchMethodException -> L20 NoSuchFieldException -> L22
    L18:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r9, r1);
    L22:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r9, r1);
    L20:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r9, r1);
    L16:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r9, r1);
        goto L24
    }

    public final Rect computeWindowBoundsN$OUI_standardRelease(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Rect r0 = new Rect();
        Display r1 = r4.getWindowManager().getDefaultDisplay();
        r1.getRectSize(r0);
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r4) == true) goto L10;
        Intrinsics.checkNotNullExpressionValue(r1, "defaultDisplay");
        Point r2 = getRealSizeForDisplay(r1);
        int r3 = getNavigationBarHeight(r4);
        if ((r0.bottom + r3) != r2.y) goto L8;
        r0.bottom += r3;
        goto L10
    L8:
        if ((r0.right + r3) != r2.x) goto L10;
        r0.right += r3;
    L10:
        return r0;
    }

    private final Rect computeWindowBoundsUnderN(Activity r3) {
        Display r4 = r3.getWindowManager().getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(r4, "defaultDisplay");
        Point r2 = getRealSizeForDisplay(r4);
        Rect r0 = new Rect();
        if (r2.x != 0) goto L5;
    L8:
        r4.getRectSize(r0);
    L9:
        return r0;
    L5:
        if (r2.y == 0) goto L8;
        r0.right = r2.x;
        r0.bottom = r2.y;
        goto L9
    }

    private final void getRectSizeFromDisplay(Activity r1, Rect r2) {
        r1.getWindowManager().getDefaultDisplay().getRectSize(r2);
    }

    private final Point getRealSizeForDisplay(Display r2) {
        Point r1 = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(r2, r1);
        return r1;
    }

    private final int getNavigationBarHeight(Context r3) {
        Resources r2 = r3.getResources();
        int r4 = r2.getIdentifier("navigation_bar_height", "dimen", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        if (r4 > 0) goto L7;
        return 0;
    L7:
        return r2.getDimensionPixelSize(r4);
    }

    private final DisplayCutout getCutoutForDisplay(Display r8) {
        Constructor<?> r0 = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        r0.setAccessible(true);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        Object r1 = r0.newInstance(new Object[0]);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        Method r3 = r8.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r1.getClass()});     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        r3.setAccessible(true);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        r3.invoke(r8, new Object[]{r1});     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        Field r9 = r1.getClass().getDeclaredField("displayCutout");     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        r9.setAccessible(true);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        Object r10 = r9.get(r1);     // Catch: InstantiationException -> L7 InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchFieldException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        if ((r10 instanceof DisplayCutout) == false) goto L19;
    L23:
        return (DisplayCutout) r10;
    L19:
        return null;
    L17:
        e = move-exception;
        Log.w(TAG, e);
    L11:
        e = move-exception;
        Log.w(TAG, e);
    L7:
        e = move-exception;
        Log.w(TAG, e);
    L13:
        e = move-exception;
        Log.w(TAG, e);
    L15:
        e = move-exception;
        Log.w(TAG, e);
    L9:
        e = move-exception;
        Log.w(TAG, e);
        goto L19
    }
}
