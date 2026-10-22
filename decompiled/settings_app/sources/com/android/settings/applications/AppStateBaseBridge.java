package com.android.settings.applications;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.settings.MultiSDKAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppStateBaseBridge implements com.android.settingslib.applications.ApplicationsState.Callbacks {
    protected final com.android.settingslib.applications.ApplicationsState.Session mAppSession;
    protected final com.android.settingslib.applications.ApplicationsState mAppState;
    protected final Callback mCallback;
    private boolean mForceLoadAllApps;
    protected final BackgroundHandler mHandler;
    protected final MainHandler mMainHandler;

    /* JADX INFO: renamed from: com.android.settings.applications.AppStateBaseBridge$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class BackgroundHandler extends Handler {
        private static final int MSG_FORCE_LOAD_PKG = 2;
        private static final int MSG_LOAD_ALL = 1;
        final /* synthetic */ AppStateBaseBridge this$0;

        public BackgroundHandler(AppStateBaseBridge r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r0 = r8.what;
            if (r0 != 1) goto L5;
            this.this$0.loadAllExtraInfo();
            this.this$0.mMainHandler.sendEmptyMessage(1);
            return;
        L5:
            if (r0 != 2) goto L23;
            ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r1 = this.this$0.mAppSession.getAllApps();
            int r2 = r1.size();
            String r3 = (String) r8.obj;
            int r9 = r8.arg1;
            int r4 = 0;
        L8:
            if (r4 >= r2) goto L15;
            com.android.settingslib.applications.ApplicationsState.AppEntry r5 = r1.get(r4);
            if (r5.info.uid != r9) goto L14;
            if (r3.equals(r5.info.packageName) == false) goto L14;
            this.this$0.updateExtraInfo(r5, r3, r9);
        L14:
            r4 = r4 + 1;
            goto L8
        L15:
            this.this$0.mMainHandler.sendEmptyMessage(1);
            return;
        }
    }

    public interface Callback {
        void onExtraInfoUpdated();
    }

    private class MainHandler extends Handler {
        private static final int MSG_INFO_UPDATED = 1;
        final /* synthetic */ AppStateBaseBridge this$0;

        private MainHandler(AppStateBaseBridge r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MainHandler(AppStateBaseBridge r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            if (r2.what != 1) goto L7;
            this.this$0.mCallback.onExtraInfoUpdated();
            return;
        }
    }

    protected abstract void loadAllExtraInfo();

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLauncherInfoChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageIconChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageSizeChanged(String r1) {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r1) {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    protected abstract void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3);

    public AppStateBaseBridge(com.android.settingslib.applications.ApplicationsState r3, Callback r4) {
        this.mForceLoadAllApps = true;
        this.mAppState = r3;
        AnonymousClass1 r0 = null;
        if (r3 == null) goto L5;
        com.android.settingslib.applications.ApplicationsState.Session r1 = r3.newSession(this);
    L6:
        this.mAppSession = r1;
        this.mCallback = r4;
        if (r3 == null) goto L9;
        Looper r5 = r3.getBackgroundLooper();
    L10:
        this.mHandler = new BackgroundHandler(this, r5);
        this.mMainHandler = new MainHandler(this, r0);
        return;
    L9:
        r5 = Looper.getMainLooper();
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public void resume() {
        this.mHandler.sendEmptyMessage(1);
        MultiSDKAdapter.resumeSession(this.mAppSession);
    }

    public void resume(boolean r1) {
        this.mForceLoadAllApps = r1;
        if (r1 == false) goto L5;
        this.mAppSession.onResume();
        return;
    L5:
        this.mAppSession.activateSession();
    }

    public void pause() {
        if (this.mForceLoadAllApps == false) goto L5;
        this.mAppSession.onPause();
        return;
    L5:
        this.mAppSession.deactivateSession();
    }

    public void release() {
        MultiSDKAdapter.releaseSession(this.mAppSession);
    }

    public void forceUpdate(String r3, int r4) {
        this.mHandler.obtainMessage(2, r4, 0, r3).sendToTarget();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageListChanged() {
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLoadEntriesCompleted() {
        this.mHandler.sendEmptyMessage(1);
    }
}
