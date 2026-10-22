package com.android.settings.applications;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.AsyncTask;
import android.os.UserHandle;
import android.os.UserManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppLister extends AsyncTask<Void, Void, List<UserAppInfo>> {
    protected final PackageManager mPm;
    protected final UserManager mUm;

    protected abstract boolean includeInCount(ApplicationInfo r1);

    protected abstract void onAppListBuilt(List<UserAppInfo> r1);

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ List<UserAppInfo> doInBackground(Void[] r1) {
        return doInBackground2(r1);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(List<UserAppInfo> r1) {
        onPostExecute2(r1);
    }

    public AppLister(PackageManager r1, UserManager r2) {
        this.mPm = r1;
        this.mUm = r2;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected List<UserAppInfo> doInBackground2(Void... r6) {
        ArrayList r7 = new ArrayList();
        Iterator r0 = this.mUm.getProfiles(UserHandle.myUserId()).iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        UserInfo r1 = (UserInfo) r0.next();
        PackageManager r2 = this.mPm;
        if (r1.isAdmin() == false) goto L8;
        int r3 = 4194304;
    L9:
        Iterator r4 = r2.getInstalledApplicationsAsUser(r3 | 33280, r1.id).iterator();
    L11:
        if (r4.hasNext() == false) goto L4;
        ApplicationInfo r5 = (ApplicationInfo) r4.next();
        if (includeInCount(r5) == false) goto L11;
        r7.add(new UserAppInfo(r1, r5));
        goto L11
    L8:
        r3 = 0;
        goto L9
    L15:
        return r7;
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(List<UserAppInfo> r1) {
        onAppListBuilt(r1);
    }
}
