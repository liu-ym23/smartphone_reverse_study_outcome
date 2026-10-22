package com.android.server.wm;

import android.util.Slog;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes.dex */
public class ObricWindowStateImpl implements IObricWindowState {
    static final String TAG = "WindowManager";
    private WindowState mBase;
    private ObricInputMonitor mInputMonitorManager;
    private boolean mShouldShowWhenLocked;

    public ObricWindowStateImpl(WindowState base) {
        this.mShouldShowWhenLocked = false;
        this.mBase = base;
    }

    public void onAssignLayer(SurfaceControl.Transaction t) {
        switch(this.mBase.mAttrs.type) {
            case 2005: goto L6;
            default: goto L19;
        };
    L19:
        return;
    L6:
        if (this.mBase.mSurfaceControl != null) goto L8;
        return;
    L8:
        if (this.mBase.mWmService.mPolicy.isKeyguardShowing() == false) goto L16;
        WindowState navigationBar = this.mBase.getDisplayContent().getDisplayPolicy().getNavigationBar();
        if (navigationBar != null) goto L12;
        return;
    L12:
        if (navigationBar.getSurfaceControl() == null) goto L18;
        Slog.d(TAG, " the toast is assign under the navigationBar");
        this.mBase.assignRelativeLayer(t, navigationBar.getSurfaceControl(), -1);
        return;
    L18:
        return;
    }

    public void setShouldShowWhenLocked(boolean show) {
        this.mShouldShowWhenLocked = show;
    }

    public boolean shouldShowWhenLocked() {
        return this.mShouldShowWhenLocked;
    }

    public void onSurfaceShownChanged(boolean shown) {
        if (this.mBase.isSecureLocked() == false) goto L6;
        Slog.d(TAG, "onWindowSecureChanged, shown=" + shown + this);
        this.mBase.getDisplayContent().getObricExt().onWindowSecureChanged(shown);
    L6:
        if (this.mBase.mAttrs.type != 2011) goto L9;
        this.mBase.mWmService.getObricExt().onInputMethodShown(shown);
        return;
    }

    public void setInputMonitorManager(ObricInputMonitor manager) {
        this.mInputMonitorManager = manager;
        Slog.d(TAG, "setInputMonitorManager: window=" + this.mBase + ", manager=" + manager);
    }

    public ObricInputMonitor getInputMonitorManager() {
        return this.mInputMonitorManager;
    }
}
