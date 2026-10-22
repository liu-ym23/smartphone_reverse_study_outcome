package com.google.android.material.color;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicColors {
    private static final Precondition ALWAYS_ALLOW = null;
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION = null;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS = null;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = null;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = null;

    @SuppressLint({"PrivateApi"})
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION = null;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    private interface DeviceSupportCondition {
        boolean isSupported();
    }

    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final int dynamicColorThemeOverlay;
        private final Precondition precondition;

        DynamicColorsActivityLifecycleCallbacks(@StyleRes int r1, @NonNull Precondition r2) {
            this.dynamicColorThemeOverlay = r1;
            this.precondition = r2;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity r1, @Nullable Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(@NonNull Activity r1, @Nullable Bundle r2) {
            DynamicColors.access$000(r1, this.dynamicColorThemeOverlay, this.precondition);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity r1, @NonNull Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity r1) {
        }
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(@NonNull Activity r1, @StyleRes int r2);
    }

    static {
        DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = new int[]{R.attr.dynamicColorThemeOverlay};
        DeviceSupportCondition r0 = new AnonymousClass1();
        DEFAULT_DEVICE_SUPPORT_CONDITION = r0;
        DeviceSupportCondition r1 = new AnonymousClass2();
        SAMSUNG_DEVICE_SUPPORT_CONDITION = r1;
        HashMap r2 = new HashMap();
        r2.put("oppo", r0);
        r2.put("realme", r0);
        r2.put("oneplus", r0);
        r2.put("vivo", r0);
        r2.put("xiaomi", r0);
        r2.put("motorola", r0);
        r2.put("itel", r0);
        r2.put("tecno mobile limited", r0);
        r2.put("infinix mobility limited", r0);
        r2.put("hmd global", r0);
        r2.put("sharp", r0);
        r2.put("sony", r0);
        r2.put("tcl", r0);
        r2.put("lenovo", r0);
        r2.put("lge", r0);
        r2.put("google", r0);
        r2.put("robolectric", r0);
        r2.put("samsung", r1);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(r2);
        HashMap r3 = new HashMap();
        r3.put("asus", r0);
        r3.put("jio", r0);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(r3);
        ALWAYS_ALLOW = new AnonymousClass3();
    }

    private DynamicColors() {
    }

    static /* synthetic */ void access$000(Activity r0, int r1, Precondition r2) {
        applyIfAvailable(r0, r1, r2);
    }

    public static void applyIfAvailable(@NonNull Activity r1) {
        applyIfAvailable(r1, 0);
    }

    public static void applyIfAvailable(@NonNull Activity r1, @StyleRes int r2) {
        applyIfAvailable(r1, r2, ALWAYS_ALLOW);
    }

    private static void applyIfAvailable(@NonNull Activity r1, @StyleRes int r2, @NonNull Precondition r3) {
        if (isDynamicColorAvailable() == true) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        r2 = getDefaultThemeOverlay(r1);
    L7:
        if (r2 != 0) goto L9;
        return;
    L9:
        if (r3.shouldApplyDynamicColors(r1, r2) == false) goto L13;
        r1.setTheme(r2);
        return;
    }

    public static void applyIfAvailable(@NonNull Activity r1, @NonNull Precondition r2) {
        applyIfAvailable(r1, 0, r2);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application r1) {
        applyToActivitiesIfAvailable(r1, 0);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application r1, @StyleRes int r2) {
        applyToActivitiesIfAvailable(r1, r2, ALWAYS_ALLOW);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application r1, @StyleRes int r2, @NonNull Precondition r3) {
        r1.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(r2, r3));
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application r1, @NonNull Precondition r2) {
        applyToActivitiesIfAvailable(r1, 0, r2);
    }

    private static int getDefaultThemeOverlay(@NonNull Context r1) {
        TypedArray r2 = r1.obtainStyledAttributes(DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        int r0 = r2.getResourceId(0, 0);
        r2.recycle();
        return r0;
    }

    @ChecksSdkIntAtLeast(api = 31)
    @SuppressLint({"DefaultLocale"})
    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return false;
    L5:
        DeviceSupportCondition r0 = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase());
        if (r0 != null) goto L8;
        r0 = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase());
    L8:
        if (r0 != null) goto L10;
        return false;
    L10:
        if (r0.isSupported() == false) goto L14;
        return true;
    L14:
        return false;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context r1) {
        return wrapContextIfAvailable(r1, 0);
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context r1, @StyleRes int r2) {
        if (isDynamicColorAvailable() == true) goto L5;
        return r1;
    L5:
        if (r2 != 0) goto L7;
        r2 = getDefaultThemeOverlay(r1);
    L7:
        if (r2 != 0) goto L10;
        return r1;
    L10:
        return new ContextThemeWrapper(r1, r2);
    }
}
