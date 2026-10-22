package com.bytedance.bdinstall.appstate;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public class AppLifeCycleListener implements Application.ActivityLifecycleCallbacks, AppStateListener {
    private int mForegroundActivityNum;
    private boolean mIsForeground;
    private AppStateListener.OnActivityResumeListener mOnResumeListener;
    private boolean mResumed;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r1) {
    }

    public AppLifeCycleListener() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r2) {
        if (this.mForegroundActivityNum >= 0) goto L6;
        this.mForegroundActivityNum = 0;
    L6:
        if (this.mForegroundActivityNum != 0) goto L8;
        onEnterForeground();
    L8:
        this.mForegroundActivityNum++;
        this.mResumed = true;
        AppStateListener.OnActivityResumeListener r1 = this.mOnResumeListener;
        if (r1 == null) goto L12;
        r1.onResume();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r1) {
        int r2 = this.mForegroundActivityNum - 1;
        this.mForegroundActivityNum = r2;
        if (r2 > 0) goto L6;
        onEnterBackground();
    L6:
        if (this.mForegroundActivityNum >= 0) goto L9;
        this.mForegroundActivityNum = 0;
        return;
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public boolean isForeground() {
        return this.mIsForeground;
    }

    private void onEnterBackground() {
        this.mIsForeground = false;
    }

    private void onEnterForeground() {
        this.mIsForeground = true;
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public void setOnResumeListener(AppStateListener.OnActivityResumeListener r1) {
        this.mOnResumeListener = r1;
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public boolean isActive() {
        return this.mResumed;
    }
}
