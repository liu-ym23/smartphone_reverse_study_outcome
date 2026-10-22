package com.android.settings.applications;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureFlags;
import android.content.pm.FeatureFlagsImpl;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.AsyncTask;
import android.os.UserHandle;
import android.os.UserManager;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppCounter extends AsyncTask<Void, Void, Integer> {
    protected final FeatureFlags mFf;
    protected final PackageManager mPm;
    protected final UserManager mUm;

    protected abstract boolean includeInCount(ApplicationInfo r1);

    protected abstract void onCountComplete(int r1);

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Integer doInBackground(Void[] r1) {
        return doInBackground2(r1);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(Integer r1) {
        onPostExecute2(r1);
    }

    AppCounter(Context r1, PackageManager r2, FeatureFlags r3) {
        this.mPm = r2;
        this.mUm = (UserManager) r1.getSystemService(UserManager.class);
        this.mFf = r3;
    }

    public AppCounter(Context r2, PackageManager r3) {
        this(r2, r3, new FeatureFlagsImpl());
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Integer doInBackground2(Void... r8) {
        Iterator r9 = this.mUm.getProfiles(UserHandle.myUserId()).iterator();
        int r1 = 0;
    L4:
        if (r9.hasNext() == false) goto L20;
        UserInfo r2 = (UserInfo) r9.next();
        if (isArchivingEnabled() == false) goto L8;
        long r3 = 4294967296L;
    L9:
        long r4 = r3 | 33280;
        if (r2.isAdmin() == false) goto L12;
        int r5 = 4194304;
    L13:
        Iterator r6 = this.mPm.getInstalledApplicationsAsUser(PackageManager.ApplicationInfoFlags.of(r4 | ((long) r5)), r2.id).iterator();
    L15:
        if (r6.hasNext() == false) goto L4;
        if (includeInCount((ApplicationInfo) r6.next()) == false) goto L15;
        r1 = r1 + 1;
        goto L15
    L12:
        r5 = 0;
        goto L13
    L8:
        r3 = 0;
        goto L9
    L20:
        return Integer.valueOf(r1);
    }

    private boolean isArchivingEnabled() {
        return this.mFf.archiving();
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(Integer r1) {
        onCountComplete(r1.intValue());
    }

    void executeInForeground() {
        onPostExecute2(doInBackground2(new Void[0]));
    }
}
