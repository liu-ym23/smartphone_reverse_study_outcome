package com.android.setupwizardlib.util;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
public class SystemBarHelper {
    private static final int DEFAULT_IMMERSIVE_FLAGS = 5634;
    private static final int DIALOG_IMMERSIVE_FLAGS = 4098;
    private static final int PEEK_DECOR_VIEW_RETRIES = 3;
    private static final int STATUS_BAR_DISABLE_BACK = 4194304;
    private static final String TAG = "SystemBarHelper";

    private static class DecorViewFinder {
        private OnDecorViewInstalledListener callback;
        private final Runnable checkDecorViewRunnable;
        private final Handler handler;
        private int retries;
        private Window window;

        private DecorViewFinder() {
            this.handler = new Handler();
            this.checkDecorViewRunnable = new AnonymousClass1(this);
        }

        /* synthetic */ DecorViewFinder(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ Window access$200(DecorViewFinder r0) {
            return r0.window;
        }

        static /* synthetic */ OnDecorViewInstalledListener access$300(DecorViewFinder r0) {
            return r0.callback;
        }

        static /* synthetic */ int access$400(DecorViewFinder r0) {
            return r0.retries;
        }

        static /* synthetic */ int access$410(DecorViewFinder r2) {
            int r0 = r2.retries;
            r2.retries = r0 - 1;
            return r0;
        }

        static /* synthetic */ Runnable access$500(DecorViewFinder r0) {
            return r0.checkDecorViewRunnable;
        }

        static /* synthetic */ Handler access$600(DecorViewFinder r0) {
            return r0.handler;
        }

        public void getDecorView(Window r1, OnDecorViewInstalledListener r2, int r3) {
            this.window = r1;
            this.retries = r3;
            this.callback = r2;
            this.checkDecorViewRunnable.run();
        }
    }

    private interface OnDecorViewInstalledListener {
        void onDecorViewInstalled(View r1);
    }

    private static class WindowInsetsListener implements View.OnApplyWindowInsetsListener {
        private int bottomOffset;
        private boolean hasCalculatedBottomOffset;

        private WindowInsetsListener() {
            this.hasCalculatedBottomOffset = false;
        }

        /* synthetic */ WindowInsetsListener(AnonymousClass1 r1) {
            this();
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View r6, WindowInsets r7) {
            if (this.hasCalculatedBottomOffset == true) goto L5;
            this.bottomOffset = SystemBarHelper.access$700(r6);
            this.hasCalculatedBottomOffset = true;
        L5:
            int r0 = r7.getSystemWindowInsetBottom();
            int r1 = Math.max(r7.getSystemWindowInsetBottom() - this.bottomOffset, 0);
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r6.getLayoutParams();
            if (r1 >= (r2.bottomMargin + r6.getHeight())) goto L9;
            r2.setMargins(r2.leftMargin, r2.topMargin, r2.rightMargin, r1);
            r6.setLayoutParams(r2);
            r0 = 0;
        L9:
            return r7.replaceSystemWindowInsets(r7.getSystemWindowInsetLeft(), r7.getSystemWindowInsetTop(), r7.getSystemWindowInsetRight(), r0);
        }
    }

    public SystemBarHelper() {
    }

    static /* synthetic */ int access$700(View r0) {
        return getBottomDistance(r0);
    }

    public static void hideSystemBars(Dialog r1) {
        Window r2 = r1.getWindow();
        temporarilyDisableDialogFocus(r2);
        addVisibilityFlag(r2, 4098);
        addImmersiveFlagsToDecorView(r2, 4098);
        r2.setNavigationBarColor(0);
        r2.setStatusBarColor(0);
    }

    public static void hideSystemBars(Window r1) {
        addVisibilityFlag(r1, DEFAULT_IMMERSIVE_FLAGS);
        addImmersiveFlagsToDecorView(r1, DEFAULT_IMMERSIVE_FLAGS);
        r1.setNavigationBarColor(0);
        r1.setStatusBarColor(0);
    }

    public static void showSystemBars(Dialog r0, Context r1) {
        showSystemBars(r0.getWindow(), r1);
    }

    public static void showSystemBars(Window r3, Context r4) {
        removeVisibilityFlag(r3, DEFAULT_IMMERSIVE_FLAGS);
        removeImmersiveFlagsFromDecorView(r3, DEFAULT_IMMERSIVE_FLAGS);
        if (r4 == null) goto L6;
        TypedArray r5 = r4.obtainStyledAttributes(new int[]{R.attr.statusBarColor, R.attr.navigationBarColor});
        int r1 = r5.getColor(0, 0);
        int r0 = r5.getColor(1, 0);
        r3.setStatusBarColor(r1);
        r3.setNavigationBarColor(r0);
        r5.recycle();
        return;
    }

    public static void addVisibilityFlag(View r1, int r2) {
        r1.setSystemUiVisibility(r2 | r1.getSystemUiVisibility());
    }

    public static void addVisibilityFlag(Window r2, int r3) {
        WindowManager.LayoutParams r0 = r2.getAttributes();
        r0.systemUiVisibility = r3 | r0.systemUiVisibility;
        r2.setAttributes(r0);
    }

    public static void removeVisibilityFlag(View r1, int r2) {
        int r0 = r1.getSystemUiVisibility();
        r1.setSystemUiVisibility((~r2) & r0);
    }

    public static void removeVisibilityFlag(Window r2, int r3) {
        WindowManager.LayoutParams r0 = r2.getAttributes();
        int r1 = r0.systemUiVisibility;
        r0.systemUiVisibility = (~r3) & r1;
        r2.setAttributes(r0);
    }

    public static void setBackButtonVisible(Window r1, boolean r2) {
        if (r2 == false) goto L5;
        removeVisibilityFlag(r1, 4194304);
        removeImmersiveFlagsFromDecorView(r1, 4194304);
        return;
    L5:
        addVisibilityFlag(r1, 4194304);
        addImmersiveFlagsToDecorView(r1, 4194304);
    }

    public static void setImeInsetView(View r2) {
        r2.setOnApplyWindowInsetsListener(new WindowInsetsListener(null));
    }

    private static void addImmersiveFlagsToDecorView(Window r1, final int r2) {
        getDecorView(r1, new AnonymousClass1(r2));
    }

    private static void removeImmersiveFlagsFromDecorView(Window r1, final int r2) {
        getDecorView(r1, new AnonymousClass2(r2));
    }

    private static void getDecorView(Window r2, OnDecorViewInstalledListener r3) {
        new DecorViewFinder(null).getDecorView(r2, r3, 3);
    }

    private static void temporarilyDisableDialogFocus(final Window r2) {
        r2.setFlags(8, 8);
        r2.setSoftInputMode(256);
        new Handler().post(new AnonymousClass3(r2));
    }

    private static int getBottomDistance(View r3) {
        int[] r0 = new int[2];
        r3.getLocationInWindow(r0);
        return (r3.getRootView().getHeight() - r0[1]) - r3.getHeight();
    }
}
