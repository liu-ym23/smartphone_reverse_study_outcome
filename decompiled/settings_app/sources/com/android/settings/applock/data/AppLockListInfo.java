package com.android.settings.applock.data;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.UserHandle;
import com.android.settings.Utils;
import com.android.settings.applock.AppLockManager;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppLockListInfo {
    private static final String DUP_LAUNCH_SUFF = "@";
    private static volatile AppLockListInfo sInstance;
    private ArrayList<AppEntry> mAppEntries;
    private IApplockCallback mApplockCallback;
    private final Context mContext;
    private final PackageManager mPm;
    private final List<String> mWhiteApplicationList;
    private final Handler mWorkHandler;

    public interface IApplockCallback {
        void onFinish(ArrayList<AppEntry> r1);
    }

    public static /* synthetic */ void $r8$lambda$0VylfRdbU8s5rcj2T6XCrlGIPuc(AppLockListInfo r0) {
        r0.loadApplication();
    }

    public ArrayList<AppEntry> getAppEntries() {
        return this.mAppEntries;
    }

    public static AppLockListInfo newInstance(Context r2) {
        monitor-enter(AppLockListInfo.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new AppLockListInfo(r2);     // Catch: Throwable -> L10
    L7:
        AppLockListInfo r3 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(AppLockListInfo.class);     // Catch: Throwable -> L10
        return r3;
    }

    private AppLockListInfo(Context r4) {
        this.mAppEntries = new ArrayList();
        this.mContext = r4;
        HandlerThread r0 = new HandlerThread("AppLockListInfo");
        r0.start();
        this.mWorkHandler = new Handler((Looper) NullSafe.nonNull(r0.getLooper()));
        AppLockManager r1 = AppLockManager.getInstance(r4);
        if (r1 == null) goto L7;
        List<String> r2 = r1.getIgnoredAppList();
        this.mWhiteApplicationList = r2;
        if (r2 == null) goto L9;
        r2.forEach(new AnonymousClass1(this));
    L9:
        if (this.mWhiteApplicationList == null) goto L11;
        OLog.d("IgnoredAppList", "init size:" + this.mWhiteApplicationList.size());
    L12:
        this.mPm = r4.getPackageManager();
        return;
    L11:
        OLog.d("IgnoredAppList", "list empty");
        goto L12
    L7:
        this.mWhiteApplicationList = Collections.emptyList();
        goto L9
    }

    public void loadApplicationInBackground() {
        this.mWorkHandler.post(new AppLockListInfo$$ExternalSyntheticLambda1(this));
    }

    public void setApplockCallback(IApplockCallback r1) {
        this.mApplockCallback = r1;
    }

    private void loadApplication() {
        List r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList<AppEntry> r2 = new ArrayList();
        Iterator<PackageInfo> r3 = this.mPm.getInstalledPackages(16).iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        PackageInfo r5 = r3.next();
        if ((1 & r5.applicationInfo.flags) <= 0) goto L7;
        if (appHasIcon(r5.packageName) == false) goto L4;
        r1.add(r5.applicationInfo);
        goto L4
    L7:
        r1.add(r5.applicationInfo);
        goto L4
    L12:
        if (this.mContext.getPackageManager() == null) goto L14;
        r0 = this.mContext.getPackageManager().getInstalledPackagesAsUser(16, 10);
    L14:
        if (r0 == null) goto L21;
        Iterator r4 = r0.iterator();
    L17:
        if (r4.hasNext() == false) goto L21;
        PackageInfo r6 = (PackageInfo) r4.next();
        if ((r6.applicationInfo.flags & 1) != 0) goto L17;
        r1.add(r6.applicationInfo);
    L21:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r1.iterator();
    L23:
        if (r8.hasNext() == false) goto L27;
        ApplicationInfo r9 = (ApplicationInfo) r8.next();
        if (Utils.isPackageAlreadyLocked(this.mContext.getPackageManager(), r9.packageName, r9.uid) == false) goto L23;
        r7.add(r9);
        goto L23
    L27:
        Iterator r10 = r1.iterator();
    L29:
        if (r10.hasNext() == false) goto L46;
        ApplicationInfo r11 = (ApplicationInfo) r10.next();
        List<String> r12 = this.mWhiteApplicationList;
        if (r12 == null) goto L38;
        if (r12.size() <= 0) goto L38;
        if (this.mWhiteApplicationList.contains(r11.packageName) == true) goto L29;
    L38:
        if (r7.size() <= 0) goto L42;
        if (r7.contains(r11) == true) goto L29;
    L42:
        AppEntry r13 = new AppEntry(this.mContext, r11);
        if (r13.mLabelEntry != null) goto L45;
        r13.ensureLabelEntry();
    L45:
        r2.add(r13);
        goto L29
    L46:
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AppLockListInfo$$ExternalSyntheticLambda0(this));
        List<String> r14 = AppLockManager.getInstance(this.mContext).getLockedAppList();
        if (r14 == null) goto L61;
        Iterator<AppEntry> r15 = r2.iterator();
    L50:
        if (r15.hasNext() == false) goto L61;
        AppEntry r16 = r15.next();
        ApplicationInfo r17 = r16.getApplicationInfo();
        int r18 = UserHandle.getUserId(r17.uid);
        if (r18 > 0) goto L53;
        if (r14 == null) goto L50;
        if (r14.contains(r17.packageName) == false) goto L50;
        r16.setAppLockedStatus(true);
        goto L50
    L53:
        if (r14 == null) goto L50;
        if (r14.contains(r17.packageName + DUP_LAUNCH_SUFF + r18) == false) goto L50;
        r16.setAppLockedStatus(true);
    L61:
        this.mAppEntries = r2;
        IApplockCallback r19 = this.mApplockCallback;
        if (r19 == null) goto L107;
        r19.onFinish(r2);
        return;
    }

    /* JADX INFO: renamed from: lambda$loadApplication$0$com-android-settings-applock-data-AppLockListInfo, reason: not valid java name */
    /* synthetic */ void m319xf640ddeb() {
        Object[] r3 = this.mAppEntries.toArray();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((AppEntry) r3[r1]).ensureIcon();
        r1 = r1 + 1;
        goto L3
    }

    private boolean appHasIcon(String r5) {
        List<ResolveInfo> r0 = new ArrayList();
        Intent r1 = new Intent("android.intent.action.MAIN", null);
        r1.addCategory("android.intent.category.LAUNCHER");
        r1.setPackage(r5);
        if (this.mContext.getPackageManager() == null) goto L6;
        r0 = this.mContext.getPackageManager().queryIntentActivities(r1, 0);
    L6:
        if (r0.size() == 0) goto L9;
        return true;
    L9:
        return false;
    }
}
