package com.android.settings.net;

import android.app.AppGlobals;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.net.TetheringManager;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.obric.olog.OLog;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UidDetailProvider {
    public static final int OTHER_USER_RANGE_START = -2000;
    private static final String TAG = "DataUsage";
    private final Context mContext;
    private final List<String> mSpecialSystemApps;
    private final SparseArray<UidDetail> mUidDetailCache;

    public static int buildKeyForUser(int r0) {
        return (-2000) - r0;
    }

    public static int getUserIdForKey(int r0) {
        return (-2000) - r0;
    }

    public static boolean isKeyForUser(int r1) {
        if (r1 > (-2000)) goto L5;
        return true;
    L5:
        return false;
    }

    public UidDetailProvider(Context r2) {
        this.mContext = r2.getApplicationContext();
        this.mUidDetailCache = new SparseArray();
        this.mSpecialSystemApps = Arrays.asList(r2.getResources().getStringArray(R.array.data_usage_special_system_apps));
    }

    public void clearCache() {
        SparseArray<UidDetail> r0 = this.mUidDetailCache;
        monitor-enter(r0);
        this.mUidDetailCache.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isSpecialSystemApp(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return this.mSpecialSystemApps.contains(r2);
    }

    public UidDetail getUidDetail(int r3, boolean r4) {
        SparseArray<UidDetail> r0 = this.mUidDetailCache;
        monitor-enter(r0);
        UidDetail r1 = this.mUidDetailCache.get(r3);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (r4 == true) goto L11;
        return null;
    L11:
        UidDetail r5 = buildUidDetail(r3);
        SparseArray<UidDetail> r2 = this.mUidDetailCache;
        monitor-enter(r2);
        this.mUidDetailCache.put(r3, r5);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return r5;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    private UidDetail buildUidDetail(int r17) {
        Resources r4 = this.mContext.getResources();
        PackageManager r5 = this.mContext.getPackageManager();
        UidDetail r6 = new UidDetail();
        r6.label = r5.getNameForUid(r17);
        r6.icon = r5.getDefaultActivityIcon();
        int r8 = 0;
        if (r5.getPackagesForUid(r17) != null) goto L5;
    L7:
        r6.uid = r17;
        if (r17 != (-5)) goto L10;
        r6.label = r4.getString(Utils.getTetheringLabel((TetheringManager) this.mContext.getSystemService(TetheringManager.class)));
        r6.icon = r4.getDrawable(R.drawable.ic_launcher_ap);
        r6.displaySwitch = false;
        return r6;
    L10:
        if (r17 == (-4)) goto L70;
        if (r17 != 1000) goto L14;
        r6.label = r4.getString(R.string.process_kernel_label);
        r6.icon = r5.getDefaultActivityIcon();
        r6.displaySwitch = false;
        return r6;
    L14:
        if (isSpecialSystemApp(r6.packageName) == false) goto L16;
        r6.displaySwitch = false;
    L16:
        UserManager r7 = (UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER);
        if (isKeyForUser(r17) == false) goto L25;
        UserInfo r9 = r7.getUserInfo(getUserIdForKey(r17));
        if (r9 == null) goto L25;
        if (r9.isManagedProfile() == false) goto L23;
        r6.label = r4.getString(R.string.managed_user_title);
        r6.icon = Resources.getSystem().getDrawable(android.R.drawable.ic_zen_mode_icon_group_of_people);
    L24:
        return r6;
    L23:
        r6.label = r4.getString(R.string.running_process_item_user_label, new Object[]{r9.name});
        r6.icon = Utils.getUserIcon(this.mContext, r7, r9);
    L25:
        String[] r0 = r5.getPackagesForUid(r17);
        if (r0 == null) goto L28;
        int r10 = r0.length;
    L77:
        int r11 = UserHandle.getUserId(r17);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        UserHandle r12 = new UserHandle(r11);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        IPackageManager r13 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        long r14 = 0;
        if (r10 != 1) goto L42;
        ApplicationInfo r15 = r13.getApplicationInfo(r0[0], 0, r11);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        if (r15 == null) goto L57;
        r6.label = r15.loadLabel(r5).toString();     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        if ("com.amap.android.location".equals(r0[0]) == false) goto L36;
        r6.icon = r4.getDrawable(R.drawable.ic_settings_gps);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
    L38:
        if ((r15.flags & 1) == 0) goto L40;
    L41:
        r6.displaySwitch = false;     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        goto L57
    L40:
        if (UserHandle.isApp(r15.uid) == true) goto L57;
    L36:
        r6.icon = r7.getBadgedIconForUser(r15.loadIcon(r5), new UserHandle(r11));     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
    L57:
        r6.contentDescription = r7.getBadgedLabelForUser(r6.label, r12);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
    L64:
        if (TextUtils.isEmpty(r6.label) == false) goto L66;
        r6.label = Integer.toString(r17);
    L66:
        return r6;
    L42:
        if (r10 <= 1) goto L57;
        r6.detailLabels = new CharSequence[r10];     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        r6.detailContentDescriptions = new CharSequence[r10];     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        int r16 = 0;
    L44:
        if (r16 >= r10) goto L57;
        String r18 = r0[r16];     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        String[] r19 = r0;
        PackageInfo r1 = r5.getPackageInfo(r18, r8);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        ApplicationInfo r20 = r13.getApplicationInfo(r18, r14, r11);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        if (r20 == null) goto L56;
        if (r1 == null) goto L56;
        r6.detailLabels[r16] = r20.loadLabel(r5).toString();     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        r6.detailContentDescriptions[r16] = r7.getBadgedLabelForUser(r6.detailLabels[r16], r12);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        if (r1.sharedUserLabel == 0) goto L56;
        r6.label = r5.getText(r18, r1.sharedUserLabel, r1.applicationInfo).toString();     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        r6.icon = r7.getBadgedIconForUser(r20.loadIcon(r5), r12);     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        if ((r20.flags & 1) == 0) goto L53;
    L54:
        r6.displaySwitch = false;     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        goto L56
    L53:
        if (UserHandle.isApp(r20.uid) == false) goto L54;
    L56:
        r16 = r16 + 1;     // Catch: RemoteException -> L59 PackageManager.NameNotFoundException -> L61
        r0 = r19;
        r8 = 0;
        r14 = 0;
    L61:
        e = move-exception;
        OLog.w(TAG, "Error while building UI detail for uid " + r17, e);
    L59:
        e = move-exception;
        OLog.w(TAG, "Error while building UI detail for uid " + r17, e);
        goto L64
    L28:
        r10 = 0;
        goto L77
    L70:
        if (UserManager.supportsMultipleUsers() == false) goto L72;
        int r2 = R.string.data_usage_uninstalled_apps_users;
    L73:
        r6.label = r4.getString(r2);
        r6.icon = r4.getDrawable(R.drawable.ic_launcher_deleted);
        r6.displaySwitch = false;
        return r6;
    L72:
        r2 = R.string.data_usage_uninstalled_apps;
        goto L73
    L5:
        if (r5.getPackagesForUid(r17).length <= 0) goto L7;
        r6.packageName = r5.getPackagesForUid(r17)[0];
        goto L7
    }
}
