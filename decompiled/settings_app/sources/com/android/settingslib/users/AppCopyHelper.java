package com.android.settingslib.users;

import android.app.AppGlobals;
import android.bluetooth.client.pbap.BluetoothPbapClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import androidx.core.content.IntentCompat;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppCopyHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "AppCopyHelper";
    private final IPackageManager mIPm;
    private boolean mLeanback;
    private final PackageManager mPackageManager;
    private final ArraySet<String> mSelectedPackages;
    private final UserHandle mUser;
    private List<SelectableAppInfo> mVisibleApps;

    /* JADX INFO: renamed from: com.android.settingslib.users.AppCopyHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AppLabelComparator implements Comparator<SelectableAppInfo> {
        private AppLabelComparator() {
        }

        /* synthetic */ AppLabelComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SelectableAppInfo r1, SelectableAppInfo r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(SelectableAppInfo r1, SelectableAppInfo r2) {
            String r0 = r1.appName.toString();
            String r3 = r2.appName.toString();
            return r0.toLowerCase().compareTo(r3.toLowerCase());
        }
    }

    static class Injector {
        private final Context mContext;
        private final UserHandle mUser;

        Injector(Context r1, UserHandle r2) {
            this.mContext = r1;
            this.mUser = r2;
        }

        UserHandle getUser() {
            return this.mUser;
        }

        PackageManager getPackageManager() {
            return this.mContext.getPackageManager();
        }

        IPackageManager getIPackageManager() {
            return AppGlobals.getPackageManager();
        }
    }

    public static class SelectableAppInfo {
        public CharSequence appName;
        public Drawable icon;
        public String packageName;

        public SelectableAppInfo() {
        }

        public String toString() {
            return this.packageName + ": appName=" + this.appName + "; icon=" + this.icon;
        }
    }

    public AppCopyHelper(Context r2, UserHandle r3) {
        this(new Injector(r2, r3));
    }

    AppCopyHelper(Injector r2) {
        this.mSelectedPackages = new ArraySet();
        this.mPackageManager = r2.getPackageManager();
        this.mIPm = r2.getIPackageManager();
        this.mUser = r2.getUser();
    }

    public void setPackageSelected(String r1, boolean r2) {
        if (r2 == false) goto L4;
        this.mSelectedPackages.add(r1);
        return;
    L4:
        this.mSelectedPackages.remove(r1);
    }

    public void resetSelectedPackages() {
        this.mSelectedPackages.clear();
    }

    public void setLeanback(boolean r1) {
        this.mLeanback = r1;
    }

    public List<SelectableAppInfo> getVisibleApps() {
        return this.mVisibleApps;
    }

    public void installSelectedApps() {
        int r0 = 0;
    L4:
        if (r0 >= this.mSelectedPackages.size()) goto L6;
        installSelectedApp(this.mSelectedPackages.valueAt(r0));
        r0 = r0 + 1;
        goto L4
    }

    private void installSelectedApp(String r13) {
        int r2 = this.mUser.getIdentifier();
        ApplicationInfo r3 = this.mIPm.getApplicationInfo(r13, BluetoothPbapClient.VCARD_ATTR_KEY, r2);     // Catch: RemoteException -> L18
        if (r3 != null) goto L7;
    L10:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "Installing " + r13);     // Catch: RemoteException -> L18
        this.mIPm.installExistingPackageAsUser(r13, this.mUser.getIdentifier(), 4194304, 0, null);     // Catch: RemoteException -> L18
    L11:
        if (r3 != null) goto L13;
        return;
    L13:
        if ((r3.privateFlags & 1) != 0) goto L15;
        return;
    L15:
        if ((r3.flags & 8388608) == 0) goto L23;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "Unhiding " + r13);     // Catch: RemoteException -> L18
        this.mIPm.setApplicationHiddenSettingAsUser(r13, false, r2);     // Catch: RemoteException -> L18
        return;
    L23:
        return;
    L7:
        if (r3.enabled == false) goto L10;
        if ((r3.flags & 8388608) != 0) goto L11;
    }

    public void fetchAndMergeApps() {
        this.mVisibleApps = new ArrayList();
        addCurrentUsersApps();
        removeSecondUsersApp();
    }

    private void addCurrentUsersApps() {
        Intent r0 = new Intent("android.intent.action.MAIN");
        if (this.mLeanback == false) goto L5;
        String r1 = IntentCompat.CATEGORY_LEANBACK_LAUNCHER;
    L6:
        addSystemApps(this.mVisibleApps, r0.addCategory(r1));
        addSystemApps(this.mVisibleApps, new Intent("android.appwidget.action.APPWIDGET_UPDATE"));
        Iterator<ApplicationInfo> r2 = this.mPackageManager.getInstalledApplications(0).iterator();
    L8:
        if (r2.hasNext() == false) goto L17;
        ApplicationInfo r3 = r2.next();
        if ((r3.flags & 8388608) == 0) goto L8;
        if ((r3.flags & 1) != 0) goto L8;
        if ((r3.flags & 128) != 0) goto L8;
        SelectableAppInfo r4 = new SelectableAppInfo();
        r4.packageName = r3.packageName;
        r4.appName = r3.loadLabel(this.mPackageManager);
        r4.icon = r3.loadIcon(this.mPackageManager);
        this.mVisibleApps.add(r4);
        goto L8
    L17:
        HashSet r5 = new HashSet();
        int r6 = this.mVisibleApps.size() - 1;
    L18:
        if (r6 < 0) goto L26;
        SelectableAppInfo r7 = this.mVisibleApps.get(r6);
        if (TextUtils.isEmpty(r7.packageName) == false) goto L22;
    L24:
        r5.add(r7.packageName);
    L25:
        r6 = r6 - 1;
        goto L18
    L22:
        if (r5.contains(r7.packageName) == false) goto L24;
        this.mVisibleApps.remove(r6);
        goto L25
    L26:
        this.mVisibleApps.sort(new AppLabelComparator(null));
        return;
    L5:
        r1 = "android.intent.category.LAUNCHER";
        goto L6
    }

    private void removeSecondUsersApp() {
        HashSet r0 = new HashSet();
        List r1 = this.mPackageManager.getInstalledApplicationsAsUser(8192, this.mUser.getIdentifier());
        int r2 = r1.size() - 1;
    L3:
        if (r2 < 0) goto L9;
        ApplicationInfo r3 = (ApplicationInfo) r1.get(r2);
        if ((r3.flags & 8388608) == 0) goto L8;
        r0.add(r3.packageName);
    L8:
        r2 = r2 - 1;
        goto L3
    L9:
        int r4 = this.mVisibleApps.size() - 1;
    L10:
        if (r4 < 0) goto L17;
        SelectableAppInfo r5 = this.mVisibleApps.get(r4);
        if (TextUtils.isEmpty(r5.packageName) == true) goto L16;
        if (r0.contains(r5.packageName) == false) goto L16;
        this.mVisibleApps.remove(r4);
    L16:
        r4 = r4 - 1;
        goto L10
    }

    private void addSystemApps(List<SelectableAppInfo> r5, Intent r6) {
        Iterator<ResolveInfo> r7 = this.mPackageManager.queryIntentActivities(r6, 0).iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        ResolveInfo r0 = r7.next();
        if (r0.activityInfo == null) goto L4;
        if (r0.activityInfo.applicationInfo == null) goto L4;
        int r1 = r0.activityInfo.applicationInfo.flags;
        if ((r1 & 1) != 0) goto L13;
        if ((r1 & 128) == 0) goto L4;
    L13:
        SelectableAppInfo r2 = new SelectableAppInfo();
        r2.packageName = r0.activityInfo.packageName;
        r2.appName = r0.activityInfo.applicationInfo.loadLabel(this.mPackageManager);
        r2.icon = r0.activityInfo.loadIcon(this.mPackageManager);
        r5.add(r2);
        goto L4
    }
}
