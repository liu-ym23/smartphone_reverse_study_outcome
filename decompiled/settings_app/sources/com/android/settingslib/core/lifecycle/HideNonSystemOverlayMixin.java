package com.android.settingslib.core.lifecycle;

import android.app.Activity;
import android.provider.Settings;
import android.util.EventLog;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.OnLifecycleEvent;

/* JADX INFO: loaded from: classes.dex */
public class HideNonSystemOverlayMixin implements androidx.lifecycle.LifecycleObserver {
    public static final String SECURE_OVERLAY_SETTINGS = "secure_overlay_settings";
    private final Activity mActivity;

    public HideNonSystemOverlayMixin(Activity r1) {
        this.mActivity = r1;
    }

    boolean isEnabled() {
        if (Settings.Secure.getInt(this.mActivity.getContentResolver(), SECURE_OVERLAY_SETTINGS, 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START)
    public void onStart() {
        if (this.mActivity != null) goto L5;
        return;
    L5:
        if (isEnabled() == false) goto L10;
        this.mActivity.getWindow().addSystemFlags(524288);
        EventLog.writeEvent(1397638484, new Object[]{"120484087", -1, ""});
        return;
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public void onStop() {
        if (this.mActivity != null) goto L5;
        return;
    L5:
        if (isEnabled() == false) goto L10;
        Window r3 = this.mActivity.getWindow();
        WindowManager.LayoutParams r0 = r3.getAttributes();
        r0.privateFlags &= -524289;
        r3.setAttributes(r0);
        return;
    }
}
