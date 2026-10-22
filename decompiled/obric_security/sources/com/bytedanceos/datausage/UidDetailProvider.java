package com.bytedanceos.datausage;

import android.app.AppGlobals;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.security.Utils;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UidDetailProvider {
    public static final int OTHER_USER_RANGE_START = -2000;
    private static final String TAG = "DataUsage";
    private final Context mContext;
    private final List<String> mSpecialSystemApps;
    private final SparseArray<UidDetail> mUidDetailCache;

    public static int buildKeyForUser(int userHandle) {
        return (-2000) - userHandle;
    }

    public static int getUserIdForKey(int key) {
        return (-2000) - key;
    }

    public static boolean isKeyForUser(int key) {
        if (key > (-2000)) goto L5;
        return true;
    L5:
        return false;
    }

    public UidDetailProvider(Context context) {
        this.mContext = context.getApplicationContext();
        this.mUidDetailCache = new SparseArray();
        this.mSpecialSystemApps = Arrays.asList(context.getResources().getStringArray(R.array.data_usage_special_system_apps));
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

    public boolean isSpecialSystemApp(String packageName) {
        if (TextUtils.isEmpty(packageName) == false) goto L7;
        return false;
    L7:
        return this.mSpecialSystemApps.contains(packageName);
    }

    public UidDetail getUidDetail(int uid, boolean blocking) {
        SparseArray<UidDetail> r0 = this.mUidDetailCache;
        monitor-enter(r0);
        UidDetail r1 = this.mUidDetailCache.get(uid);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (blocking == true) goto L11;
        return null;
    L11:
        UidDetail r4 = buildUidDetail(uid);
        SparseArray<UidDetail> r2 = this.mUidDetailCache;
        monitor-enter(r2);
        this.mUidDetailCache.put(uid, r4);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return r4;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    private UidDetail buildUidDetail(int uid) {
        String r2 = "Error while building UI detail for uid ";
        Resources r4 = this.mContext.getResources();
        PackageManager r5 = this.mContext.getPackageManager();
        UidDetail r6 = new UidDetail();
        if (r5 != null) goto L5;
        return r6;
    L5:
        r6.label = r5.getNameForUid(uid);
        r6.icon = r5.getDefaultActivityIcon();
        if (r5.getPackagesForUid(uid) != null) goto L8;
    L10:
        r6.uid = uid;
        if (uid != (-5)) goto L13;
        r6.label = r4.getString(getTetheringLabel((ConnectivityManager) this.mContext.getSystemService("connectivity")));
        r6.icon = r4.getDrawable(R.drawable.ic_launcher_ap);
        r6.displaySwitch = false;
        return r6;
    L13:
        if (uid == (-4)) goto L128;
        if (uid != 1000) goto L17;
        r6.label = r4.getString(R.string.process_kernel_label);
        r6.icon = r5.getDefaultActivityIcon();
        r6.displaySwitch = false;
        return r6;
    L17:
        if (isSpecialSystemApp(r6.packageName) == false) goto L19;
        r6.displaySwitch = false;
    L19:
        UserManager r7 = (UserManager) this.mContext.getSystemService("user");
        if (isKeyForUser(uid) == false) goto L28;
        UserInfo r0 = r7.getUserInfo(getUserIdForKey(uid));
        if (r0 == null) goto L28;
        if (r0.isManagedProfile() == false) goto L26;
        r6.label = r4.getString(R.string.managed_user_title);
        r6.icon = Resources.getSystem().getDrawable(Utils.getResouceId("android", "ic_corp_icon", "drawable", android.R.drawable.ic_zen_mode_icon_gaming));
    L27:
        return r6;
    L26:
        r6.label = r4.getString(R.string.running_process_item_user_label, new Object[]{r0.name});
        r6.icon = Resources.getSystem().getDrawable(Utils.getResouceId("android", "ic_corp_icon", "drawable", android.R.drawable.ic_zen_mode_icon_gaming));
    L28:
        String[] r10 = r5.getPackagesForUid(uid);
        if (r10 == null) goto L31;
        int r11 = r10.length;
    L143:
        int r12 = UserHandle.getUserId(uid);     // Catch: RemoteException -> L115 PackageManager.NameNotFoundException -> L118
        UserHandle r13 = new UserHandle(r12);     // Catch: PackageManager.NameNotFoundException -> L113 RemoteException -> L115
        IPackageManager r14 = AppGlobals.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L113 RemoteException -> L115
        String r16 = "Error while building UI detail for uid ";
        if (r11 != 1) goto L69;
        ApplicationInfo r1 = r14.getApplicationInfo(r10[0], 0, r12);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        if (r1 == null) goto L111;
        r6.label = r1.loadLabel(r5).toString();     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        if (BatteryEntry.AMAP_LOCATION.equals(r10[0]) == false) goto L145;
        r6.icon = r4.getDrawable(R.drawable.ic_settings_gps);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L61:
        if ((r1.flags & 1) == 0) goto L63;
    L64:
        r6.displaySwitch = false;     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        goto L111
    L63:
        if (UserHandle.isApp(r1.uid) == true) goto L111;
    L145:
    L51:
        e = e;
        Drawable r3 = null;
    L53:
        OLog.w(TAG, "Failed to load icon from resources directly", e);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L54:
        Drawable r8 = r3;
    L55:
        if (r8 != null) goto L57;
        r8 = r1.loadIcon(r5).mutate();     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L57:
        if (r12 == 0) goto L59;
        r6.icon = r7.getBadgedIconForUser(r8, r13);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        goto L61
    L59:
        r6.icon = r8;     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        goto L61
    L43:
        if (r1.icon == 0) goto L50;
        r3 = r5.getResourcesForApplication(r1).getDrawableForDensity(r1.icon, 0, null);     // Catch: Exception -> L51 RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        if (r3 == null) goto L54;
        r8 = r3.mutate();     // Catch: Exception -> L48 RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L48:
        e = e;
        goto L53
    L50:
        r8 = null;
    L111:
        r6.contentDescription = r7.getBadgedLabelForUser(r6.label, r13);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L122:
        if (TextUtils.isEmpty(r6.label) == false) goto L124;
        r6.label = Integer.toString(uid);
    L124:
        return r6;
    L69:
        if (r11 <= 1) goto L111;
        r6.detailLabels = new CharSequence[r11];     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        r6.detailContentDescriptions = new CharSequence[r11];     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        int r9 = 0;
    L71:
        if (r9 >= r11) goto L111;
        String r15 = r10[r9];     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        PackageInfo r17 = r5.getPackageInfo(r15, 0);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        String[] r18 = r10;
        ApplicationInfo r19 = r14.getApplicationInfo(r15, 0, r12);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        if (r19 == null) goto L109;
        r6.detailLabels[r9] = r19.loadLabel(r5).toString();     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        r6.detailContentDescriptions[r9] = r7.getBadgedLabelForUser(r6.detailLabels[r9], r13);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        if (r17 == null) goto L109;
        if (r17.sharedUserLabel == 0) goto L109;
        CharSequence r20 = r5.getText(r15, r17.sharedUserLabel, r17.applicationInfo);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        if (r20 == null) goto L147;
        r6.label = r20.toString();     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L147:
    L94:
        e = e;
        Drawable r21 = null;
    L96:
        Drawable r22 = r21;
    L97:
        OLog.w(TAG, "Failed to load icon from resources directly", e);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L98:
        Drawable r23 = r22;
    L99:
        if (r23 != null) goto L101;
        r23 = r19.loadIcon(r5).mutate();     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L101:
        if (r12 == 0) goto L103;
        r6.icon = r7.getBadgedIconForUser(r23, r13);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L104:
        boolean r24 = true;
        if ((r19.flags & 1) == 0) goto L107;
    L108:
        r6.displaySwitch = false;     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
    L110:
        r9 = r9 + 1;     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        r10 = r18;
        goto L71
    L107:
        if (UserHandle.isApp(r19.uid) == true) goto L110;
    L103:
        r6.icon = r23;     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67
        goto L104
    L82:
        if (r19.icon == 0) goto L93;
        r21 = null;
        r22 = r5.getResourcesForApplication(r19).getDrawableForDensity(r19.icon, 0, null);     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67 Exception -> L91
        if (r22 == null) goto L98;
        r23 = r22.mutate();     // Catch: RemoteException -> L65 PackageManager.NameNotFoundException -> L67 Exception -> L89
    L89:
        e = e;
    L91:
        e = e;
        goto L96
    L93:
        r23 = null;
    L109:
        r24 = true;
    L67:
        e = e;
        int r25 = uid;
        r2 = r16;
    L120:
        OLog.w(TAG, r2 + r25, e);
    L65:
        e = e;
    L117:
        OLog.w(TAG, r16 + uid, e);
        goto L122
    L113:
        e = e;
        r25 = uid;
    L118:
        e = e;
        r25 = uid;
    L115:
        e = e;
        r16 = "Error while building UI detail for uid ";
        goto L117
    L31:
        r11 = 0;
        goto L143
    L128:
        if (UserManager.supportsMultipleUsers() == false) goto L130;
        int r26 = R.string.data_usage_uninstalled_apps_users;
    L131:
        r6.label = r4.getString(r26);
        r6.icon = r4.getDrawable(R.drawable.ic_launcher_deleted);
        r6.displaySwitch = false;
        return r6;
    L130:
        r26 = R.string.data_usage_uninstalled_apps;
        goto L131
    L8:
        if (r5.getPackagesForUid(uid).length <= 0) goto L10;
        r6.packageName = r5.getPackagesForUid(uid)[0];
        goto L10
    }

    public int getTetheringLabel(ConnectivityManager cm) {
        String[] r3 = cm.getTetherableUsbRegexs();
        String[] r0 = cm.getTetherableWifiRegexs();
        String[] r4 = cm.getTetherableBluetoothRegexs();
        boolean r1 = true;
        if (r3.length == 0) goto L5;
        boolean r5 = true;
    L7:
        if (r0.length == 0) goto L9;
        boolean r2 = true;
    L11:
        if (r4.length != 0) goto L15;
        r1 = false;
    L15:
        if (r2 == false) goto L19;
        if (r5 == false) goto L19;
        if (r1 == false) goto L19;
        return R.string.tether_settings_title_all;
    L19:
        if (r2 == false) goto L22;
        if (r5 == false) goto L22;
        return R.string.tether_settings_title_all;
    L22:
        if (r2 == false) goto L25;
        if (r1 == false) goto L25;
        return R.string.tether_settings_title_all;
    L25:
        if (r2 == false) goto L28;
        return R.string.tether_settings_title_wifi;
    L28:
        if (r5 == false) goto L32;
        if (r1 == false) goto L32;
        return R.string.tether_settings_title_usb_bluetooth;
    L32:
        if (r5 == false) goto L35;
        return R.string.tether_settings_title_usb;
    L35:
        return R.string.tether_settings_title_bluetooth;
    L9:
        r2 = false;
        goto L11
    L5:
        r5 = false;
        goto L7
    }
}
