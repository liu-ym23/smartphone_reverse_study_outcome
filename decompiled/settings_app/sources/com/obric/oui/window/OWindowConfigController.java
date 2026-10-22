package com.obric.oui.window;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.log.L;
import com.obric.oui.view.Insets;
import com.obric.oui.window.bean.AvailableWindowSize;
import com.obric.oui.window.bean.WindowSizeClass;
import com.obric.oui.window.bean.WindowSizeWithPageSize;
import com.obric.oui.window.calculator.WindowSizeCalculator;
import com.obric.oui.window.interfaces.OnWindowConfigChangeListener;
import com.obric.oui.window.listener.WindowConfigChangeListener;
import com.obric.oui.window.model.AdaptedWindowSize;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OWindowConfigController.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0007J)\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010 \u001a\u00020!2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0007J!\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010*\u001a\u00020\u001fJ\u0012\u0010+\u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u001c\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020%2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007J&\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020%2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\u0004H\u0007J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u00105\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0006\u00106\u001a\u00020\u0004J\b\u00107\u001a\u00020\u0004H\u0007J\u000e\u00107\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u00108\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u00109\u001a\u00020\u0004J\u0012\u0010:\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0017H\u0007JC\u0010;\u001a\u00020\r2\u0006\u0010.\u001a\u00020%2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\u00042\u0017\u0010<\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\r0=¢\u0006\u0002\b>H\u0086\bø\u0001\u0000J\u001e\u0010?\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0010\u0010?\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0007J&\u0010A\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006H"}, d2 = {"Lcom/obric/oui/window/OWindowConfigController;", "", "()V", "mIsInit", "", "Ljava/lang/Boolean;", "addWindowConfigChangeListener", "Landroidx/lifecycle/Observer;", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lcom/obric/oui/window/interfaces/OnWindowConfigChangeListener;", "", "listener", "applyLandscapeCutoutMode", "context", "Landroid/content/Context;", "params", "Landroid/view/WindowManager$LayoutParams;", "includeCutoutInLandscape", "(Landroid/content/Context;Landroid/view/WindowManager$LayoutParams;Ljava/lang/Boolean;)V", "getActivity", "Landroid/app/Activity;", "getBaseGridColumnWidth", "", "getCurrentWindowSize", "Lcom/obric/oui/window/bean/AvailableWindowSize;", "getCurrentWindowSizeClass", "Lcom/obric/oui/window/bean/WindowSizeClass;", "getFullScreenHeight", "", "getFullWindowSize", "Landroid/util/Size;", "getGestureNavigationHeight", "getImeHeight", "rootView", "Landroid/view/View;", "getLandscapeCutoutMode", "activity", "(Landroid/app/Activity;Ljava/lang/Boolean;)I", "getNavigationBarHeight", "getScreenModeInInt", "getStatusBarHeight", "getSystemBarInsets", "Landroidx/core/graphics/Insets;", "view", "windowInsets", "Landroid/view/WindowInsets;", "getSystemBarInsetsInfo", "Lcom/obric/oui/view/Insets;", "excludeIme", "isGestureNavigation", "isGestureNavigationApi29", "isHSplit", "isInMultiWindowMode", "isLandscape", "isVSplit", "isWindowConfigInit", "processSystemBarInsets", DBHelper.BATTERY_COL_PROCESS_NAME, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "removeWindowConfigChangeListener", "observer", "setWindowConfig", "config", "Landroid/content/res/Configuration;", "currentWidth", "currentHeight", "setWindowConfigInitStatus", "isInit", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OWindowConfigController {
    public static final OWindowConfigController INSTANCE = null;
    private static volatile Boolean mIsInit;

    static {
        INSTANCE = new OWindowConfigController();
    }

    @JvmStatic
    public static final Insets getSystemBarInsetsInfo(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        return getSystemBarInsetsInfo$default(r3, null, false, 6, null);
    }

    @JvmStatic
    public static final Insets getSystemBarInsetsInfo(View r3, WindowInsets r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        return getSystemBarInsetsInfo$default(r3, r4, false, 4, null);
    }

    private OWindowConfigController() {
    }

    @JvmStatic
    public static final boolean isWindowConfigInit(Activity r4) {
        if (mIsInit != null) goto L7;
        if (r4 == null) goto L7;
        OWindowConfigController r0 = INSTANCE;
        Configuration r1 = r4.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r1, "resources.configuration");
        r0.setWindowConfig(r4, r1, r4.getWindow().getDecorView().getWidth(), r4.getWindow().getDecorView().getHeight());
    L7:
        Boolean r5 = mIsInit;
        if (r5 != null) goto L11;
        return false;
    L11:
        return r5.booleanValue();
    }

    public final void setWindowConfigInitStatus(boolean r1) {
        mIsInit = Boolean.valueOf(r1);
    }

    public final void setWindowConfig(Activity r1, Configuration r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "config");
        WindowConfigChangeListener.Companion.setConfig(r1, r2, r3, r4);
    }

    public final Observer<WindowSizeWithPageSize> addWindowConfigChangeListener(LifecycleOwner r1, OnWindowConfigChangeListener r2) {
        Intrinsics.checkNotNullParameter(r1, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r2, "callback");
        return WindowConfigChangeListener.Companion.addListener(r1, r2);
    }

    public final void removeWindowConfigChangeListener(LifecycleOwner r1, Observer<WindowSizeWithPageSize> r2) {
        Intrinsics.checkNotNullParameter(r1, "lifecycleOwner");
        WindowConfigChangeListener.Companion.removeListenerByObserver(r2, r1);
    }

    public final AvailableWindowSize getCurrentWindowSize() {
        return AdaptedWindowSize.INSTANCE.getCurrentPageSize();
    }

    public final WindowSizeClass getCurrentWindowSizeClass() {
        return AdaptedWindowSize.INSTANCE.getCurrentWindowSizeClass();
    }

    public final float getBaseGridColumnWidth() {
        return AdaptedWindowSize.INSTANCE.getBaseColumnWidth();
    }

    public final int getScreenModeInInt() {
        return AdaptedWindowSize.INSTANCE.getMScreenMode();
    }

    public final boolean isVSplit() {
        return AdaptedWindowSize.INSTANCE.isVSplit();
    }

    public final boolean isHSplit() {
        return AdaptedWindowSize.INSTANCE.isHSplit();
    }

    @JvmStatic
    public static final boolean isInMultiWindowMode() {
        return AdaptedWindowSize.INSTANCE.isInMultiWindowMode();
    }

    @JvmStatic
    public static final void addWindowConfigChangeListener(OnWindowConfigChangeListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        AdaptedWindowSize.INSTANCE.addListener(r1);
    }

    @JvmStatic
    public static final void removeWindowConfigChangeListener(OnWindowConfigChangeListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        AdaptedWindowSize.INSTANCE.removeListener(r1);
    }

    @JvmStatic
    public static final int getStatusBarHeight(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = r5.getResources().getIdentifier("status_bar_height", "dimen", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        if (r1 > 0) goto L8;
        Class<?> r2 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r3 = r2.newInstance();     // Catch: Exception -> L11
        int r4 = Integer.parseInt(r2.getField("status_bar_height").get(r3).toString());     // Catch: Exception -> L11
        return r5.getResources().getDimensionPixelSize(r4);
    L11:
        return 0;
    L8:
        return r5.getResources().getDimensionPixelSize(r1);
    }

    public final int getNavigationBarHeight(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r0 = r5.getResources().getIdentifier("navigation_bar_height", "dimen", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        if (r0 > 0) goto L8;
        Class<?> r1 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r2 = r1.newInstance();     // Catch: Exception -> L11
        int r3 = Integer.parseInt(r1.getField("navigation_bar_height").get(r2).toString());     // Catch: Exception -> L11
        return r5.getResources().getDimensionPixelSize(r3);
    L14:
        return 0;
    L8:
        return r5.getResources().getDimensionPixelSize(r0);
    }

    public final int getImeHeight(View r8) {
        Intrinsics.checkNotNullParameter(r8, "rootView");
        WindowInsetsController r9 = r8.getWindowInsetsController();     // Catch: Exception -> L35
        if (r9 != null) goto L6;
        return 0;
    L6:
        Method r0 = r9.getClass().getDeclaredMethod("getState", new Class[0]);     // Catch: Exception -> L35
        r0.setAccessible(true);     // Catch: Exception -> L35
        Object r10 = r0.invoke(r9, new Object[0]);     // Catch: Exception -> L35
        if (Build.VERSION.SDK_INT < 35) goto L9;
        Class<?> r1 = Class.forName("android.view.InsetsSource");     // Catch: Exception -> L35
    L11:
        if (Build.VERSION.SDK_INT < 35) goto L13;
        Field r2 = r1.getDeclaredField("ID_IME");     // Catch: Exception -> L35
    L14:
        r2.setAccessible(true);     // Catch: Exception -> L35
        Rect r3 = null;
        int r4 = r2.getInt(null);     // Catch: Exception -> L35
        Method r5 = r10.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L35
        r5.setAccessible(true);     // Catch: Exception -> L35
        Object r11 = r5.invoke(r10, new Object[]{Integer.valueOf(r4)});     // Catch: Exception -> L35
        if (r11 != null) goto L18;
        r11 = null;
    L18:
        if (r11 != null) goto L20;
        return 0;
    L20:
        Method r6 = r11.getClass().getDeclaredMethod("isVisible", new Class[0]);     // Catch: Exception -> L35
        r6.setAccessible(true);     // Catch: Exception -> L35
        Object r7 = r6.invoke(r11, new Object[0]);     // Catch: Exception -> L35
        if ((r7 instanceof Boolean) == false) goto L23;
        Boolean r12 = (Boolean) r7;     // Catch: Exception -> L35
    L24:
        if (r12 != null) goto L27;
        return 0;
    L27:
        if (r12.booleanValue() == false) goto L37;
        Method r13 = r11.getClass().getDeclaredMethod("getFrame", new Class[0]);     // Catch: Exception -> L35
        r13.setAccessible(true);     // Catch: Exception -> L35
        Object r14 = r13.invoke(r11, new Object[0]);     // Catch: Exception -> L35
        if ((r14 instanceof Rect) == false) goto L31;
        r3 = (Rect) r14;     // Catch: Exception -> L35
    L31:
        if (r3 != null) goto L33;
        return 0;
    L33:
        return r3.height();
    L37:
        return 0;
    L23:
        r12 = null;
        goto L24
    L13:
        r2 = r1.getDeclaredField("ITYPE_IME");     // Catch: Exception -> L35
        goto L14
    L9:
        r1 = Class.forName("android.view.InsetsState");     // Catch: Exception -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    }

    public final Activity getActivity(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((r2 instanceof Activity) == false) goto L7;
        return (Activity) r2;
    L7:
        if ((r2 instanceof ContextWrapper) == false) goto L10;
        Context r3 = ((ContextWrapper) r2).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context.baseContext");
        return getActivity(r3);
    L10:
        return null;
    }

    public final boolean isInMultiWindowMode(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Activity r1 = getActivity(r2);
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.isInMultiWindowMode();
    }

    @JvmStatic
    public static final Size getFullWindowSize(Context r3) {
        if (r3 == null) goto L4;
        Activity r0 = INSTANCE.getActivity(r3);
        if (r0 != null) goto L8;
        Object r1 = r3.getSystemService("window");
        Rect r2 = null;
        if ((r1 instanceof WindowManager) == false) goto L12;
        WindowManager r4 = (WindowManager) r1;
    L13:
        if (r4 == null) goto L19;
        WindowMetrics r5 = r4.getCurrentWindowMetrics();
        if (r5 == null) goto L19;
        r2 = r5.getBounds();
    L19:
        if (r2 == null) goto L23;
        return new Size(r2.width(), r2.height());
    L23:
        return new Size(OUnitExtensionKt.getScreenWidth(r3), OUnitExtensionKt.getScreenHeight(r3));
    L12:
        r4 = null;
        goto L13
    L8:
        return new Size(WindowSizeCalculator.INSTANCE.computeCurrentWindowMetrics(r0).getBounds().width(), WindowSizeCalculator.INSTANCE.computeCurrentWindowMetrics(r0).getBounds().height());
    L4:
        return new Size(0, 0);
    }

    @JvmStatic
    public static final int getFullScreenHeight(Context r3) {
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (r3.getApplicationInfo().targetSdkVersion < 35) goto L32;
        if (Build.VERSION.SDK_INT <= 34) goto L32;
        Activity r0 = INSTANCE.getActivity(r3);
        if (r0 != null) goto L13;
        Object r1 = r3.getSystemService("window");
        Integer r2 = null;
        if ((r1 instanceof WindowManager) == false) goto L17;
        WindowManager r4 = (WindowManager) r1;
    L18:
        if (r4 == null) goto L27;
        WindowMetrics r5 = r4.getCurrentWindowMetrics();
        if (r5 == null) goto L27;
        Rect r6 = r5.getBounds();
        if (r6 == null) goto L27;
        r2 = Integer.valueOf(r6.height());
    L27:
        if (r2 != null) goto L30;
        return OUnitExtensionKt.getScreenHeight(r3);
    L30:
        return r2.intValue();
    L17:
        r4 = null;
        goto L18
    L13:
        return WindowSizeCalculator.INSTANCE.computeCurrentWindowMetrics(r0).getBounds().height();
    L32:
        return (OUnitExtensionKt.getScreenHeight(r3) + getStatusBarHeight(r3)) + INSTANCE.getNavigationBarHeight(r3);
    }

    @JvmStatic
    public static final boolean isGestureNavigationApi29(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Resources r4 = r3.getResources();
        int r0 = r4.getIdentifier("config_navBarInteractionMode", "integer", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        if (r0 > 0) goto L5;
        return false;
    L5:
        if (r4.getInteger(r0) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final int getGestureNavigationHeight(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        OWindowConfigController r0 = INSTANCE;
        if (isGestureNavigation(r2) == true) goto L7;
        return 0;
    L7:
        return r0.getNavigationBarHeight(r2);
    }

    @JvmStatic
    public static final boolean isGestureNavigation(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return isGestureNavigationApi29(r1);
    }

    public static /* synthetic */ androidx.core.graphics.Insets getSystemBarInsets$default(View r0, WindowInsets r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return getSystemBarInsets(r0, r1);
    }

    @Deprecated(message = "use getSystemBarInsetsInfo instead")
    @JvmStatic
    public static final androidx.core.graphics.Insets getSystemBarInsets(View r1, WindowInsets r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r2 != null) goto L5;
        r2 = r1.getRootWindowInsets();
    L5:
        if (r2 != null) goto L8;
        androidx.core.graphics.Insets r3 = androidx.core.graphics.Insets.NONE;
        Intrinsics.checkNotNullExpressionValue(r3, "NONE");
        return r3;
    L8:
        androidx.core.graphics.Insets r4 = WindowInsetsCompat.toWindowInsetsCompat(r2).getSystemWindowInsets();
        Intrinsics.checkNotNullExpressionValue(r4, "toWindowInsetsCompat(insets).systemWindowInsets");
        return r4;
    }

    public static /* synthetic */ Insets getSystemBarInsetsInfo$default(View r0, WindowInsets r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = true;
    L9:
        return getSystemBarInsetsInfo(r0, r1, r2);
    }

    @JvmStatic
    public static final Insets getSystemBarInsetsInfo(View r1, WindowInsets r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r2 != null) goto L5;
        r2 = r1.getRootWindowInsets();
    L5:
        if (r2 != null) goto L8;
        Insets r4 = Insets.NONE;
        Intrinsics.checkNotNullExpressionValue(r4, "NONE");
        return r4;
    L8:
        if (r3 == false) goto L11;
        Insets r5 = com.obric.oui.view.WindowInsetsCompat.toWindowInsetsCompat(r2).getInsets(com.obric.oui.view.WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r5, "toWindowInsetsCompat(ins…Compat.Type.systemBars())");
        return r5;
    L11:
        Insets r6 = com.obric.oui.view.WindowInsetsCompat.toWindowInsetsCompat(r2).getSystemWindowInsets();
        Intrinsics.checkNotNullExpressionValue(r6, "toWindowInsetsCompat(insets).systemWindowInsets");
        return r6;
    }

    public static /* synthetic */ void processSystemBarInsets$default(OWindowConfigController r0, View r1, WindowInsets r2, boolean r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = true;
    L8:
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r4, DBHelper.BATTERY_COL_PROCESS_NAME);
        r4.invoke(getSystemBarInsetsInfo(r1, r2, r3));
    }

    public final void processSystemBarInsets(View r1, WindowInsets r2, boolean r3, Function1<? super Insets, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r4, DBHelper.BATTERY_COL_PROCESS_NAME);
        r4.invoke(getSystemBarInsetsInfo(r1, r2, r3));
    }

    public final boolean isLandscape(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r3.getResources().getConfiguration().orientation != 2) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        L.e("OWindowConfigController", "isLandscape error", e);
        return false;
    }

    @JvmStatic
    public static final int getLandscapeCutoutMode(Activity r1, Boolean r2) {
        if (r2 != null) goto L5;
        if (r1 != null) goto L10;
        return 2;
    L10:
        Window r3 = r1.getWindow();
        if (r3 == null) goto L19;
        WindowManager.LayoutParams r4 = r3.getAttributes();
        if (r4 != null) goto L17;
        return 2;
    L17:
        return r4.layoutInDisplayCutoutMode;
    L19:
        return 2;
    L5:
        if (r2.booleanValue() == false) goto L18;
        return 3;
    L18:
        return 2;
    }

    @JvmStatic
    public static final void applyLandscapeCutoutMode(Context r2, WindowManager.LayoutParams r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r2 != null) goto L5;
        return;
    L5:
        OWindowConfigController r0 = INSTANCE;
        if (r0.isLandscape(r2) == true) goto L8;
        return;
    L8:
        r3.layoutInDisplayCutoutMode = getLandscapeCutoutMode(r0.getActivity(r2), r4);
    }
}
