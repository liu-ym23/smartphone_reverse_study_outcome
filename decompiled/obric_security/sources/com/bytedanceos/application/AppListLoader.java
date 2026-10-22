package com.bytedanceos.application;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.UserHandle;
import android.text.TextUtils;
import bytedanceos.util.Features;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.reflect.PackageManagerHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppListLoader extends AsyncTaskLoader<List<AppEntry>> {
    public static final Comparator<AppEntry> ALPHA_COMPARATOR = null;
    public static final String CMCC10086 = "com.greenpoint.android.mc10086.activity";
    public static final boolean DEBUG = true;
    private static final String TAG = "AppListLoader";
    private static final String TORCH_PACKAGE = "com.bytedanceos.torch";
    private static HashSet<String> mWhitePackageSet;
    private static final String[] sWhitePackages = null;
    List<AppEntry> mApps;
    boolean mIgnorePermission;
    final InterestingConfigChanges mLastConfig;
    int[] mOps;
    OpsManagerHelper mOpsManagerHelper;
    String[] mPermissions;
    PackageManager mPm;

    public static class InterestingConfigChanges {
        final Configuration mLastConfiguration;
        int mLastDensity;

        public InterestingConfigChanges() {
            this.mLastConfiguration = new Configuration();
        }

        public boolean applyNewConfig(Resources res) {
            int r0 = this.mLastConfiguration.updateFrom(res.getConfiguration());
            if (this.mLastDensity == res.getDisplayMetrics().densityDpi) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
        L11:
            this.mLastDensity = res.getDisplayMetrics().densityDpi;
            return true;
        L8:
            if ((r0 & 772) != 0) goto L11;
            return false;
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: onCanceled, reason: avoid collision after fix types in other method */
    public void onCanceled2(List<AppEntry> apps) {
    }

    protected void onReleaseResources(List<AppEntry> apps) {
    }

    @Override // android.content.Loader
    public void onReset() {
    }

    @Override // android.content.Loader
    public /* bridge */ /* synthetic */ void deliverResult(Object apps) {
        deliverResult((List) apps);
    }

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ List<AppEntry> loadInBackground() {
        return loadInBackground2();
    }

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ void onCanceled(List<AppEntry> apps) {
        onCanceled2(apps);
    }

    static {
        String[] r0 = {"com.bytedanceos.keyguard", "com.android.systemui", "android", "com.qualcomm.shutdownlistner", BatteryEntry.LAUNCHER_PACKAGE, BatteryEntry.BYTEDANCE_LAUNCHER_PACKAGE, "com.bytedanceos.weather", "com.google.android.gms", "com.obric.music", "com.android.phone", "com.google.android.gm", "com.google.android.syncadapters.calendar", "com.google.android.gsf", "com.google.android.gsf.login", "com.android.mms", "com.bytedanceos.clock", "com.bytedanceos.setupwizard", "com.bytedanceos.smartfolder", "com.obric.appstore", "com.bytedanceos.gamestore", "com.android.documentsui"};
        sWhitePackages = r0;
        HashSet<String> r1 = new HashSet();
        mWhitePackageSet = r1;
        r1.addAll(Arrays.asList(r0));
        ALPHA_COMPARATOR = new AnonymousClass1();
    }

    public static boolean isWhitePackage(String packageName) {
        if (TextUtils.isEmpty(packageName) == false) goto L5;
    L7:
        return false;
    L5:
        if (mWhitePackageSet.contains(packageName) == false) goto L7;
        return true;
    }

    public AppListLoader(Context context, String[] perms, int[] ops) {
        this(context, perms, ops, false);
    }

    public AppListLoader(Context context, String[] perms, int[] ops, boolean ignore) {
        super(context);
        this.mLastConfig = new InterestingConfigChanges();
        this.mPm = null;
        this.mOpsManagerHelper = null;
        this.mPermissions = null;
        this.mOps = null;
        this.mIgnorePermission = false;
        if (Features.isFeatureCMCCEnabled(context).booleanValue() == false) goto L5;
        mWhitePackageSet.add(CMCC10086);
    L5:
        if (perms != null) goto L7;
        perms = new String[0];
    L7:
        this.mPermissions = perms;
        this.mOps = ops;
        this.mIgnorePermission = ignore;
        this.mPm = context.getPackageManager();
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
    }

    @Override // android.content.AsyncTaskLoader
    /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
    public List<AppEntry> loadInBackground2() {
        final ArrayList r0 = new ArrayList();
        List<PackageInfo> r1 = this.mPm.getInstalledPackages(0);     // Catch: RuntimeException -> L86
        if (r1 != null) goto L6;
        return null;
    L6:
        List<PackageInfo> r4 = new PackageManagerHelper(getContext().getPackageManager()).getInstalledPackages(0, 10);     // Catch: RuntimeException -> L86
        if (r4 != null) goto L9;
    L11:
        String[] r5 = this.mPermissions;
        if (r5.length > 0) goto L14;
    L16:
        boolean r6 = false;
    L17:
        HashSet r7 = new HashSet();
        if (r6 == false) goto L25;
        Intent r8 = new Intent("android.intent.action.MAIN", null);
        r8.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> r9 = this.mPm.queryIntentActivities(r8, 0);
        if (r9 == null) goto L25;
        int r10 = 0;
    L23:
        if (r10 >= r9.size()) goto L25;
        r7.add(r9.get(r10).activityInfo.packageName);
        r10 = r10 + 1;
    L25:
        Iterator<PackageInfo> r2 = r1.iterator();
    L27:
        if (r2.hasNext() == false) goto L79;
        PackageInfo r11 = r2.next();
        ApplicationInfo r12 = r11.applicationInfo;
        if ((r12.flags & 1) == 0) goto L33;
        if ("com.android.vending".equals(r12.packageName) == true) goto L33;
    L34:
        boolean r13 = true;
    L36:
        if (r13 == true) goto L27;
        if (Utils.isHiddenApp(r12.packageName) == true) goto L27;
        if (this.mIgnorePermission == true) goto L43;
        String[] r14 = this.mPm.getPackageInfo(r11.packageName, 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L57
    L59:
        if (r14 == null) goto L27;
        if (r14.length <= 0) goto L27;
        int r15 = 0;
    L65:
        if (r15 >= r14.length) goto L27;
        String r16 = r14[r15];
        int r17 = 0;
        boolean r18 = false;
    L67:
        String[] r19 = this.mPermissions;
        if (r17 >= r19.length) goto L76;
        if (r16.equals(r19[r17]) == false) goto L75;
        AppEntry r110 = new AppEntry(getContext(), r12);
        if (r110.mLabelEntry != null) goto L74;
        r110.ensureLabelEntry();
    L74:
        r110.setMode(OpsManagerHelper.get_MODE_INVALID());
        r0.add(r110);
        r18 = true;
    L75:
        r17 = r17 + 1;
        goto L67
    L76:
        if (r18 == true) goto L27;
        r15 = r15 + 1;
    L57:
        e = move-exception;
        e.printStackTrace();
        r14 = null;
        goto L59
    L43:
        if (r6 == false) goto L52;
        if (mWhitePackageSet.contains(r12.packageName) == true) goto L27;
        if (r12.uid <= 10000) goto L27;
        if (r7.contains(r12.packageName) == false) goto L27;
    L52:
        AppEntry r20 = new AppEntry(getContext(), r12);
        r20.setMode(OpsManagerHelper.get_MODE_INVALID());
        r0.add(r20);
        if (r20.mLabelEntry != null) goto L27;
        r20.ensureLabelEntry();
    L33:
        if (UserHandle.isApp(r12.uid) == false) goto L34;
        r13 = false;
        goto L36
    L79:
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass2(this, r0));
        Collections.sort(r0, ALPHA_COMPARATOR);
        Iterator r3 = r0.iterator();
    L81:
        if (r3.hasNext() == false) goto L85;
        AppEntry r21 = (AppEntry) r3.next();
        ApplicationInfo r22 = r21.getApplicationInfo();
        int r23 = this.mOpsManagerHelper.getMode(r22.uid, r22.packageName, this.mOps);
        if (r23 == OpsManagerHelper.get_MODE_INVALID()) goto L81;
        r21.setMode(r23);
        goto L81
    L85:
        return r0;
    L14:
        if (TextUtils.equals(r5[0], "android.permission.RECEIVE_BOOT_COMPLETED") == false) goto L16;
        r6 = true;
        goto L17
    L9:
        if (r4.size() <= 0) goto L11;
        r1.addAll(r4);     // Catch: RuntimeException -> L86
    L86:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    public void deliverResult(List<AppEntry> apps) {
        if (isReset() == false) goto L6;
        if (apps == null) goto L6;
        onReleaseResources(apps);
    L6:
        this.mApps = apps;
        if (isStarted() == false) goto L9;
        super.deliverResult(apps);
    L9:
        if (apps == null) goto L12;
        onReleaseResources(apps);
        return;
    }

    @Override // android.content.Loader
    protected void onStartLoading() {
        super.onStartLoading();
        List<AppEntry> r0 = this.mApps;
        if (r0 == null) goto L5;
        deliverResult(r0);
    L5:
        boolean r1 = this.mLastConfig.applyNewConfig(getContext().getResources());
        if (takeContentChanged() == false) goto L8;
    L10:
        forceLoad();
        return;
    L8:
        if (this.mApps == null) goto L10;
        if (r1 == true) goto L10;
    }

    @Override // android.content.Loader
    protected void onStopLoading() {
        super.onStopLoading();
    }
}
