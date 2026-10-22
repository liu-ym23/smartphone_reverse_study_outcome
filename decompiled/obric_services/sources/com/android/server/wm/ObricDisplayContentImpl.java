package com.android.server.wm;

import android.content.res.Configuration;
import android.util.Slog;
import android.view.DisplayCutout;

/* JADX INFO: loaded from: classes.dex */
public class ObricDisplayContentImpl implements IObricDisplayContent {
    private static final String TAG = "ObricDisplayContentimpl";
    private final Runnable mApplyObricDisplayOverrideRunnable;
    private final DisplayContent mBase;
    private boolean mHasSecureWindow;

    public static /* synthetic */ void $r8$lambda$dsR3HM9NrGeWBdGWl6SW3lCwfQk(ObricDisplayContentImpl r0) {
        r0.applyObricDisplayOverrideOnAtms();
    }

    public ObricDisplayContentImpl(DisplayContent displayContent) {
        this.mHasSecureWindow = false;
        this.mApplyObricDisplayOverrideRunnable = new ObricDisplayContentImpl$$ExternalSyntheticLambda1(this);
        this.mBase = displayContent;
    }

    public void onWindowSecureChanged(boolean secure) {
        if (this.mBase.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L27;
        WindowManagerGlobalLock r0 = this.mBase.mWmService.mGlobalLock;
        monitor-enter(r0);
        if (secure == false) goto L13;
        Slog.d(TAG, "the window is secure");     // Catch: Throwable -> L24
        if (secure == this.mHasSecureWindow) goto L10;
        this.mBase.mWmService.getObricExt().onDisplaySecureChanged(this.mBase.mDisplayId, secure);     // Catch: Throwable -> L24
    L10:
        this.mHasSecureWindow = secure;     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L13:
        WindowState secureWindow = this.mBase.getWindow(new ObricDisplayContentImpl$$ExternalSyntheticLambda0());     // Catch: Throwable -> L24
        Slog.d(TAG, "the secure window is " + secureWindow);     // Catch: Throwable -> L24
        if (secureWindow == null) goto L16;
        boolean isSecure = true;
    L17:
        boolean isSecure2 = this.mHasSecureWindow;     // Catch: Throwable -> L24
        if (isSecure != isSecure2) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L21:
        this.mHasSecureWindow = isSecure;     // Catch: Throwable -> L24
        Slog.d(TAG, "onRunningActivityChanged mHasSecureWindow=" + this.mHasSecureWindow + " of display=" + this.mBase.mDisplayId);     // Catch: Throwable -> L24
        this.mBase.mWmService.getObricExt().onDisplaySecureChanged(this.mBase.mDisplayId, this.mHasSecureWindow);     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L16:
        isSecure = false;
    L24:
        th = move-exception;
        throw th;
    L27:
        this.mHasSecureWindow = this.mBase.mWmService.getObricExt().onWindowSecureChanged(this.mBase, this.mHasSecureWindow, secure);
    }

    static /* synthetic */ boolean lambda$onWindowSecureChanged$0(WindowState w) {
        if (w.isOnScreen() == true) goto L5;
    L9:
        return false;
    L5:
        if (w.isSecureLocked() == false) goto L9;
        if (w.mWinAnimator.getShown() == false) goto L9;
        return true;
    }

    public DisplayCutout calculateDisplayCutoutForRotation(int rotation) {
        if (this.mBase.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L12;
        WindowManagerGlobalLock r0 = this.mBase.mWmService.mGlobalLock;
        monitor-enter(r0);
        DisplayCutout r1 = this.mBase.mWmService.mRoot.getDisplayContent(0).calculateDisplayCutoutForRotation(rotation);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L12:
        return null;
    }

    public void onDisplayRemoval() {
        if (this.mBase.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L6;
        this.mBase.mWmService.getObricExt().recordObricVirtualDisplayRemoved(this.mBase.mDisplayId);
        this.mBase.mWmService.getObricExt().enableCallUser(false);
        this.mBase.mWmService.getObricExt().hideImeInAuto(this.mBase.mDisplayId);
        this.mBase.mWmService.getObricExt().setAutoFocusedPkg("");
        this.mBase.mAtmService.getObricExt().addDisablePackage(new String[0]);
        this.mBase.mAtmService.getObricExt().cleanupAutoActionSecondaryHomeOnDisplay(this.mBase.mDisplayId);
        this.mBase.mAtmService.getObricExt().resetMuteSessionState();
        this.mBase.mWmService.getObricExt().tryToMuteDelay(500L);
        return;
    }

    public void onFocusChanged(WindowState oldFocus, WindowState newFocus) {
        if (oldFocus == null) goto L4;
        this.mBase.mWmService.getObricExt().onWindowLostFocus(oldFocus);
    L4:
        if (newFocus == null) goto L7;
        this.mBase.mWmService.getObricExt().onWindowGainedFocus(newFocus);
        return;
    }

    public void onWindowRemoved(WindowState window) {
        this.mBase.mWmService.getObricExt().onWindowRemoved(window);
    }

    public void syncObricDisplayOverride() {
        if (inObricVirtualDisplay() == true) goto L5;
        return;
    L5:
        this.mBase.mAtmService.mH.removeCallbacks(this.mApplyObricDisplayOverrideRunnable);
        this.mBase.mAtmService.mH.post(this.mApplyObricDisplayOverrideRunnable);
    }

    public void calculateScreenConfiguration(Configuration config) {
        if (this.mBase.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L8;
        Configuration defaultConfig = this.mBase.mWmService.mRoot.getDisplayContent(0).getConfiguration();
        config.colorMode = defaultConfig.colorMode;
        config.touchscreen = defaultConfig.touchscreen;
        config.fontScale = defaultConfig.fontScale;
        config.fontWeightAdjustment = defaultConfig.fontWeightAdjustment;
        config.setLocales(defaultConfig.getLocales());
        if (defaultConfig.getLocales().isEmpty() == true) goto L9;
        config.setLayoutDirection(defaultConfig.getLocales().get(0));
        return;
    L9:
        return;
    }

    private void applyObricDisplayOverrideOnAtms() {
        WindowManagerGlobalLock r0 = this.mBase.mWmService.mGlobalLock;
        monitor-enter(r0);
        DisplayContent current = this.mBase.mWmService.mRoot.getDisplayContent(this.mBase.mDisplayId);     // Catch: Throwable -> L21
        if (current == this.mBase) goto L7;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L7:
        if (inObricVirtualDisplay() == false) goto L19;
        DisplayContent defaultDisplay = this.mBase.mWmService.mRoot.getDisplayContent(0);     // Catch: Throwable -> L21
        if (defaultDisplay != null) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L13:
        Configuration defaultConfig = defaultDisplay.getConfiguration();     // Catch: Throwable -> L21
        Configuration oldOverride = this.mBase.getRequestedOverrideConfiguration();     // Catch: Throwable -> L21
        Configuration override = new Configuration(oldOverride);     // Catch: Throwable -> L21
        override.setLocales(defaultConfig.getLocales());     // Catch: Throwable -> L21
        override.fontScale = defaultConfig.fontScale;     // Catch: Throwable -> L21
        override.fontWeightAdjustment = defaultConfig.fontWeightAdjustment;     // Catch: Throwable -> L21
        override.colorMode = defaultConfig.colorMode;     // Catch: Throwable -> L21
        override.touchscreen = defaultConfig.touchscreen;     // Catch: Throwable -> L21
        if (defaultConfig.getLocales().isEmpty() == true) goto L16;
        override.setLayoutDirection(defaultConfig.getLocales().get(0));     // Catch: Throwable -> L21
    L16:
        this.mBase.updateDisplayOverrideConfigurationLocked(override, null, false);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private boolean inObricVirtualDisplay() {
        return this.mBase.getObricExtWindowContainer().inObricVirtualDisplay();
    }
}
