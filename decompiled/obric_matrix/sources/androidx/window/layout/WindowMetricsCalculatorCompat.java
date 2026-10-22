package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculatorCompat;", "Landroidx/window/layout/WindowMetricsCalculator;", "()V", "TAG", "", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "computeMaximumWindowMetrics", "computeWindowBoundsIceCreamSandwich", "Landroid/graphics/Rect;", "computeWindowBoundsIceCreamSandwich$window_release", "computeWindowBoundsN", "computeWindowBoundsN$window_release", "computeWindowBoundsP", "computeWindowBoundsP$window_release", "computeWindowBoundsQ", "computeWindowBoundsQ$window_release", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "getNavigationBarHeight", "", "context", "Landroid/content/Context;", "getRealSizeForDisplay", "Landroid/graphics/Point;", "getRealSizeForDisplay$window_release", "getRectSizeFromDisplay", "", "bounds", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = null;
    private static final String TAG = null;

    static {
        INSTANCE = new WindowMetricsCalculatorCompat();
        String r0 = WindowMetricsCalculatorCompat.class.getSimpleName();
        o.e(r0, "WindowMetricsCalculatorC…at::class.java.simpleName");
        TAG = r0;
    }

    private WindowMetricsCalculatorCompat() {
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection"})
    private final DisplayCutout getCutoutForDisplay(Display r7) {
        Constructor<?> r6 = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);     // Catch: Throwable -> L6
        r6.setAccessible(true);     // Catch: Throwable -> L6
        Object r8 = r6.newInstance(new Object[0]);     // Catch: Throwable -> L6
        Method r2 = r7.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r8.getClass()});     // Catch: Throwable -> L6
        r2.setAccessible(true);     // Catch: Throwable -> L6
        r2.invoke(r7, new Object[]{r8});     // Catch: Throwable -> L6
        Field r9 = r8.getClass().getDeclaredField("displayCutout");     // Catch: Throwable -> L6
        r9.setAccessible(true);     // Catch: Throwable -> L6
        Object r10 = r9.get(r8);     // Catch: Throwable -> L6
        if ((r10 instanceof DisplayCutout) == false) goto L8;
        return (DisplayCutout) r10;
    L8:
        return null;
    L6:
        e = move-exception;
        Log.w(TAG, e);
        goto L8
    }

    private final int getNavigationBarHeight(Context r3) {
        Resources r2 = r3.getResources();
        int r4 = r2.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r4 > 0) goto L7;
        return 0;
    L7:
        return r2.getDimensionPixelSize(r4);
    }

    private final void getRectSizeFromDisplay(Activity r1, Rect r2) {
        r1.getWindowManager().getDefaultDisplay().getRectSize(r2);
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeCurrentWindowMetrics(Activity r3) {
        o.f(r3, "activity");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L6;
        Rect r2 = ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(r3);
    L16:
        return new WindowMetrics(r2);
    L6:
        if (r0 < 29) goto L9;
        r2 = computeWindowBoundsQ$window_release(r3);
        goto L16
    L9:
        if (r0 < 28) goto L12;
        r2 = computeWindowBoundsP$window_release(r3);
        goto L16
    L12:
        if (r0 < 24) goto L14;
        r2 = computeWindowBoundsN$window_release(r3);
        goto L16
    L14:
        r2 = computeWindowBoundsIceCreamSandwich$window_release(r3);
        goto L16
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeMaximumWindowMetrics(Activity r3) {
        o.f(r3, "activity");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Rect r2 = ActivityCompatHelperApi30.INSTANCE.maximumWindowBounds(r3);
    L7:
        return new WindowMetrics(r2);
    L5:
        Display r4 = r3.getWindowManager().getDefaultDisplay();
        o.e(r4, "display");
        Point r5 = getRealSizeForDisplay$window_release(r4);
        r2 = new Rect(0, 0, r5.x, r5.y);
        goto L7
    }

    @RequiresApi(14)
    public final Rect computeWindowBoundsIceCreamSandwich$window_release(Activity r3) {
        o.f(r3, "activity");
        Display r4 = r3.getWindowManager().getDefaultDisplay();
        o.e(r4, "defaultDisplay");
        Point r2 = getRealSizeForDisplay$window_release(r4);
        Rect r0 = new Rect();
        int r1 = r2.x;
        if (r1 == 0) goto L8;
        int r5 = r2.y;
        if (r5 == 0) goto L8;
        r0.right = r1;
        r0.bottom = r5;
    L9:
        return r0;
    L8:
        r4.getRectSize(r0);
        goto L9
    }

    @RequiresApi(24)
    public final Rect computeWindowBoundsN$window_release(Activity r5) {
        o.f(r5, "activity");
        Rect r0 = new Rect();
        Display r1 = r5.getWindowManager().getDefaultDisplay();
        r1.getRectSize(r0);
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r5) == true) goto L10;
        o.e(r1, "defaultDisplay");
        Point r2 = getRealSizeForDisplay$window_release(r1);
        int r4 = getNavigationBarHeight(r5);
        int r6 = r0.bottom;
        if ((r6 + r4) != r2.y) goto L7;
        r0.bottom = r6 + r4;
        goto L10
    L7:
        int r7 = r0.right;
        if ((r7 + r4) != r2.x) goto L10;
        r0.right = r7 + r4;
    L10:
        return r0;
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect computeWindowBoundsP$window_release(Activity r10) {
        o.f(r10, "activity");
        Rect r0 = new Rect();
        Configuration r1 = r10.getResources().getConfiguration();
        Field r3 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: Throwable -> L17
        r3.setAccessible(true);     // Catch: Throwable -> L17
        Object r2 = r3.get(r1);     // Catch: Throwable -> L17
        if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(r10) == false) goto L12;
        Object r4 = r2.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r2, new Object[0]);     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
        if (r4 == null) goto L11;
        Rect r5 = (Rect) r4;     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
    L9:
        r0.set(r5);     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
    L19:
        Display r6 = r10.getWindowManager().getDefaultDisplay();
        Point r7 = new Point();
        DisplayCompatHelperApi17 r8 = DisplayCompatHelperApi17.INSTANCE;
        o.e(r6, "currentDisplay");
        r8.getRealSize(r6, r7);
        ActivityCompatHelperApi24 r9 = ActivityCompatHelperApi24.INSTANCE;
        if (r9.isInMultiWindowMode(r10) == true) goto L31;
        int r11 = getNavigationBarHeight(r10);
        int r12 = r0.bottom;
        if ((r12 + r11) != r7.y) goto L24;
        r0.bottom = r12 + r11;
        goto L31
    L24:
        int r13 = r0.right;
        if ((r13 + r11) != r7.x) goto L28;
        r0.right = r13 + r11;
        goto L31
    L28:
        if (r0.left != r11) goto L31;
        r0.left = 0;
    L31:
        if (r0.width() < r7.x) goto L35;
        if (r0.height() < r7.y) goto L35;
    L50:
        return r0;
    L35:
        if (r9.isInMultiWindowMode(r10) == true) goto L50;
        DisplayCutout r14 = getCutoutForDisplay(r6);
        if (r14 == null) goto L50;
        int r15 = r0.left;
        DisplayCompatHelperApi28 r16 = DisplayCompatHelperApi28.INSTANCE;
        if (r15 != r16.safeInsetLeft(r14)) goto L42;
        r0.left = 0;
    L42:
        if ((r7.x - r0.right) != r16.safeInsetRight(r14)) goto L45;
        r0.right += r16.safeInsetRight(r14);
    L45:
        if (r0.top != r16.safeInsetTop(r14)) goto L48;
        r0.top = 0;
    L48:
        if ((r7.y - r0.bottom) != r16.safeInsetBottom(r14)) goto L50;
        r0.bottom += r16.safeInsetBottom(r14);
        goto L50
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
    L12:
        Object r17 = r2.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r2, new Object[0]);     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
        if (r17 == null) goto L16;
        r5 = (Rect) r17;     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
        goto L9
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
    L17:
        e = move-exception;
        Log.w(TAG, e);
        getRectSizeFromDisplay(r10, r0);
        goto L19
    }

    @RequiresApi(29)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect computeWindowBoundsQ$window_release(Activity r6) {
        o.f(r6, "activity");
        Configuration r0 = r6.getResources().getConfiguration();
        Field r1 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r2 = r1.get(r0);     // Catch: Throwable -> L8
        Object r3 = r2.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r2, new Object[0]);     // Catch: Throwable -> L8
        if (r3 == null) goto L7;
        return new Rect((Rect) r3);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Throwable -> L8
    L8:
        e = move-exception;
        Log.w(TAG, e);
        return computeWindowBoundsP$window_release(r6);
    }

    @RequiresApi(14)
    @VisibleForTesting
    public final Point getRealSizeForDisplay$window_release(Display r7) {
        o.f(r7, "display");
        Point r6 = new Point();
        if (Build.VERSION.SDK_INT < 17) goto L10;
        DisplayCompatHelperApi17.INSTANCE.getRealSize(r7, r6);
    L9:
        return r6;
    L10:
        Method r0 = Display.class.getDeclaredMethod("getRealSize", new Class[]{Point.class});     // Catch: Throwable -> L7
        r0.setAccessible(true);     // Catch: Throwable -> L7
        r0.invoke(r7, new Object[]{r6});     // Catch: Throwable -> L7
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L9
    }
}
