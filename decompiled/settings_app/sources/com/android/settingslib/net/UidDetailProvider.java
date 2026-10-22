package com.android.settingslib.net;

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
import com.GlobalProxyLancet;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settingslib.R;
import com.android.settingslib.Utils;

/* JADX INFO: loaded from: classes.dex */
public class UidDetailProvider {
    public static final int OTHER_USER_RANGE_START = -2000;
    private static final String TAG = "DataUsage";
    private final Context mContext;
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

    public UidDetailProvider(Context r1) {
        this.mContext = r1;
        this.mUidDetailCache = new SparseArray();
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
        if (r17 != (-5)) goto L5;
        r6.label = r4.getString(Utils.getTetheringLabel((TetheringManager) this.mContext.getSystemService(TetheringManager.class)));
        r6.icon = r5.getDefaultActivityIcon();
        return r6;
    L5:
        if (r17 == (-4)) goto L50;
        if (r17 != 1000) goto L9;
        r6.label = r4.getString(R.string.process_kernel_label);
        r6.icon = r5.getDefaultActivityIcon();
        return r6;
    L9:
        if (r17 == 1061) goto L45;
        UserManager r7 = (UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER);
        if (isKeyForUser(r17) == false) goto L16;
        UserInfo r8 = r7.getUserInfo(getUserIdForKey(r17));
        if (r8 == null) goto L16;
        r6.label = Utils.getUserLabel(this.mContext, r8);
        r6.icon = Utils.getUserIcon(this.mContext, r7, r8);
        return r6;
    L16:
        String[] r0 = r5.getPackagesForUid(r17);
        int r9 = 0;
        if (r0 == null) goto L19;
        int r10 = r0.length;
    L57:
        int r11 = UserHandle.getUserId(r17);     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        UserHandle r12 = new UserHandle(r11);     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        IPackageManager r13 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        long r14 = 0;
        String r15 = "";
        if (r10 != 1) goto L26;
        ApplicationInfo r16 = r13.getApplicationInfo(r0[0], 0, r11);     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        if (r16 == null) goto L35;
        r6.label = r16.loadLabel(r5).toString();     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        r6.icon = r7.getBadgedIconForUser(r16.loadIcon(r5), new UserHandle(r11));     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        r15 = r0[0];     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
    L35:
        r6.packageName = r15;     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        r6.contentDescription = r7.getBadgedLabelForUser(r6.label, r12);     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
    L42:
        if (TextUtils.isEmpty(r6.label) == false) goto L44;
        r6.label = Integer.toString(r17);
    L44:
        return r6;
    L26:
        if (r10 <= 1) goto L35;
        r6.detailLabels = new CharSequence[r10];     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        r6.detailContentDescriptions = new CharSequence[r10];     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        int r18 = 0;
    L28:
        if (r18 >= r10) goto L35;
        r15 = r0[r18];     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        String[] r19 = r0;
        PackageInfo r1 = r5.getPackageInfo(r15, r9);     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        ApplicationInfo r20 = r13.getApplicationInfo(r15, r14, r11);     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        if (r20 == null) goto L34;
        r6.detailLabels[r18] = r20.loadLabel(r5).toString();     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        r6.detailContentDescriptions[r18] = r7.getBadgedLabelForUser(r6.detailLabels[r18], r12);     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        if (r1.sharedUserLabel == 0) goto L34;
        r6.label = r5.getText(r15, r1.sharedUserLabel, r1.applicationInfo).toString();     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        r6.icon = r7.getBadgedIconForUser(r20.loadIcon(r5), r12);     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
    L34:
        r18 = r18 + 1;     // Catch: RemoteException -> L37 PackageManager.NameNotFoundException -> L39
        r0 = r19;
        r9 = 0;
        r14 = 0;
    L39:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error while building UI detail for uid " + r17, e);
    L37:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error while building UI detail for uid " + r17, e);
        goto L42
    L19:
        r10 = 0;
        goto L57
    L45:
        r6.label = r4.getString(R.string.data_usage_ota);
        r6.icon = this.mContext.getDrawable(R.drawable.ic_system_update);
        return r6;
    L50:
        if (UserManager.supportsMultipleUsers() == false) goto L52;
        int r2 = R.string.data_usage_uninstalled_apps_users;
    L53:
        r6.label = r4.getString(r2);
        r6.icon = r5.getDefaultActivityIcon();
        return r6;
    L52:
        r2 = R.string.data_usage_uninstalled_apps;
        goto L53
    }
}
