package com.android.settings.applications;

import android.app.AppGlobals;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.EmptyArray;
import com.android.internal.util.ArrayUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateLongBackgroundTasksBridge extends AppStateBaseBridge {
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_LONG_JOBS_APPS = null;
    private static final String PERMISSION = "android.permission.RUN_USER_INITIATED_JOBS";
    private static final String TAG = "LongBackgroundTasksBridge";
    JobScheduler mJobScheduler;
    String[] mRequesterPackages;

    public static class LongBackgroundTasksState {
        private boolean mPermissionGranted;
        private boolean mPermissionRequested;

        LongBackgroundTasksState(boolean r1, boolean r2) {
            this.mPermissionRequested = r1;
            this.mPermissionGranted = r2;
        }

        public boolean shouldBeVisible() {
            return this.mPermissionRequested;
        }

        public boolean isAllowed() {
            return this.mPermissionGranted;
        }
    }

    public AppStateLongBackgroundTasksBridge(Context r1, com.android.settingslib.applications.ApplicationsState r2, AppStateBaseBridge.Callback r3) {
        super(r2, r3);
        this.mJobScheduler = (JobScheduler) r1.getSystemService(JobScheduler.class);
        IPackageManager r4 = AppGlobals.getPackageManager();
        this.mRequesterPackages = r4.getAppOpPermissionPackages(PERMISSION, r1.getUserId());     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "Cannot reach package manager", e);
        this.mRequesterPackages = EmptyArray.STRING;
    }

    public LongBackgroundTasksState createPermissionState(String r2, int r3) {
        int r4 = UserHandle.getUserId(r3);
        return new LongBackgroundTasksState(ArrayUtils.contains(this.mRequesterPackages, r2), this.mJobScheduler.hasRunUserInitiatedJobsPermission(r2, r4));
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = createPermissionState(r2, r3);
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        com.android.settingslib.applications.ApplicationsState.AppEntry r2 = r0.get(r1);
        updateExtraInfo(r2, r2.info.packageName, r2.info.uid);
        r1 = r1 + 1;
        goto L4
    }

    static {
        FILTER_LONG_JOBS_APPS = new AnonymousClass1();
    }
}
