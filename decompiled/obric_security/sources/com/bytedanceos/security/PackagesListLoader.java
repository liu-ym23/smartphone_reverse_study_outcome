package com.bytedanceos.security;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.UserHandle;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.application.LabelEntry;
import com.bytedanceos.security.reflect.PackageManagerHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackagesListLoader extends AsyncTaskLoader<List<PackagePermissions>> {
    public static final Comparator<PackagePermissions> ALPHA_COMPARATOR = null;
    private static final String TAG = "PackagesListLoader";
    List<PackagePermissions> mApps;
    final InterestingConfigChanges mLastConfig;
    private PackageManager mPm;

    public static class InterestingConfigChanges {
        final Configuration mLastConfiguration;
        int mLastDensity;

        public InterestingConfigChanges() {
            this.mLastConfiguration = new Configuration();
        }

        boolean applyNewConfig(Resources res) {
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
    public void onCanceled2(List<PackagePermissions> apps) {
    }

    protected void onReleaseResources(List<PackagePermissions> apps) {
    }

    @Override // android.content.Loader
    public void onReset() {
    }

    @Override // android.content.Loader
    public /* bridge */ /* synthetic */ void deliverResult(Object apps) {
        deliverResult((List) apps);
    }

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ List<PackagePermissions> loadInBackground() {
        return loadInBackground2();
    }

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ void onCanceled(List<PackagePermissions> apps) {
        onCanceled2(apps);
    }

    static {
        ALPHA_COMPARATOR = new AnonymousClass1();
    }

    public PackagesListLoader(Context context) {
        super(context);
        this.mLastConfig = new InterestingConfigChanges();
        this.mPm = null;
        this.mPm = context.getPackageManager();
    }

    @Override // android.content.AsyncTaskLoader
    /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
    public List<PackagePermissions> loadInBackground2() {
        List<PackageInfo> r0 = this.mPm.getInstalledPackages(0);
        List<PackageInfo> r1 = new PackageManagerHelper(getContext().getPackageManager()).getInstalledPackages(0, 10);
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        if (r1.size() <= 0) goto L8;
        r0.addAll(r1);
    L8:
        ArrayList r2 = new ArrayList();
        if (r0 == null) goto L24;
        Iterator<PackageInfo> r3 = r0.iterator();
    L12:
        if (r3.hasNext() == false) goto L24;
        PackageInfo r4 = r3.next();
        if ((r4.applicationInfo.flags & 1) != 0) goto L12;
        if (UserHandle.isApp(r4.applicationInfo.uid) == false) goto L12;
        if (Utils.isHiddenApp(r4.packageName) == true) goto L12;
        PackagePermissions r5 = queryEntry(r4, this.mPm);
        if (r5 == null) goto L12;
        r2.add(r5);
    L24:
        Collections.sort(r2, ALPHA_COMPARATOR);
        return r2;
    }

    public PackagePermissions queryEntry(PackageInfo packageInfo, final PackageManager pm) {
        return getEntry(packageInfo, pm);
    }

    public static PackagePermissions getEntry(PackageInfo packageInfo, final PackageManager pm) {
        PackagePermissions r0 = null;
        if (packageInfo == null) goto L53;
        if (pm == null) goto L53;
        PackageInfo r1 = pm.getPackageInfo(packageInfo.packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L51
        if (r1 != null) goto L9;
        return null;
    L9:
        String[] r2 = r1.requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L51
        if (r2 != null) goto L12;
    L50:
        return null;
    L12:
        if (r2.length <= 0) goto L50;
        int r3 = 0;
    L16:
        if (r3 >= 30) goto L45;
        if (Utils.mPermissionIgnore[r3] == true) goto L44;
        String[] r4 = Utils.mMatchedPermissions[r3];     // Catch: PackageManager.NameNotFoundException -> L51
        int r5 = 0;
        boolean r6 = false;
    L22:
        if (r5 >= r2.length) goto L32;
        String r7 = r2[r5];     // Catch: PackageManager.NameNotFoundException -> L51
        int r8 = r4.length;     // Catch: PackageManager.NameNotFoundException -> L51
        int r9 = 0;
    L24:
        if (r9 >= r8) goto L29;
        if (r7.equals(r4[r9]) == true) goto L27;
        r9 = r9 + 1;     // Catch: PackageManager.NameNotFoundException -> L51
        goto L24
    L27:
        r6 = true;
    L29:
        if (r6 == true) goto L32;
        r5 = r5 + 1;     // Catch: PackageManager.NameNotFoundException -> L51
    L32:
        if (r6 == false) goto L44;
        if (r0 != null) goto L43;
        PackagePermissions r10 = new PackagePermissions(packageInfo.packageName, packageInfo.applicationInfo.uid);     // Catch: PackageManager.NameNotFoundException -> L51
        ApplicationInfo r11 = packageInfo.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L41
        LabelEntry r12 = ApplicationLabelCache.getInstance().getLabelEntry(pm, r11.packageName);     // Catch: PackageManager.NameNotFoundException -> L41
        if (r12 == null) goto L38;
        r10.setLabel(r12.label);     // Catch: PackageManager.NameNotFoundException -> L41
    L39:
        r10.setIcon(Utils.getResizedApkIcon(r11, pm));     // Catch: PackageManager.NameNotFoundException -> L41
        r0 = r10;
        goto L43
    L38:
        r10.setLabel(r11.loadLabel(pm).toString());     // Catch: PackageManager.NameNotFoundException -> L41
    L41:
        e = e;
        r0 = r10;
    L52:
        e.printStackTrace();
    L43:
        r0.addPermission(r3);     // Catch: PackageManager.NameNotFoundException -> L51
    L44:
        r3 = r3 + 1;     // Catch: PackageManager.NameNotFoundException -> L51
        goto L16
    L45:
        if (r0 == null) goto L53;
        r0.insertCaptureVideoOutput();     // Catch: PackageManager.NameNotFoundException -> L51
        r0.insertThirdPartyBootable();     // Catch: PackageManager.NameNotFoundException -> L51
        r0.insertBootcomplete();     // Catch: PackageManager.NameNotFoundException -> L51
        r0.insertShowOnKeyguard();     // Catch: PackageManager.NameNotFoundException -> L51
        r0.insertStartOnBackgroundApps();     // Catch: PackageManager.NameNotFoundException -> L51
        if (r0.mLabelEntry != null) goto L53;
        r0.ensureLabelEntry(pm);     // Catch: PackageManager.NameNotFoundException -> L51
    L51:
        e = e;
    L53:
        return r0;
    }

    public void deliverResult(List<PackagePermissions> apps) {
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
        List<PackagePermissions> r0 = this.mApps;
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
