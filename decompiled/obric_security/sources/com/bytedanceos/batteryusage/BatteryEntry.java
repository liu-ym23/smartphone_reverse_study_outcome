package com.bytedanceos.batteryusage;

import android.app.AppGlobals;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.BatteryConsumer;
import android.os.Handler;
import android.os.RemoteException;
import android.os.UidBatteryConsumer;
import android.os.UserBatteryConsumer;
import android.os.UserHandle;
import android.os.UserManager;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryEntry implements Comparable<BatteryEntry> {
    public static final Comparator<BatteryEntry> COMPARATOR = null;
    public static final int MSG_REPORT_FULLY_DRAWN = 2;
    public static final int MSG_UPDATE_NAME_ICON = 1;
    private static final String PACKAGE_SYSTEM = "android";
    private static final String TAG = "BatteryEntry";
    static Locale sCurrentLocale;
    static Handler sHandler;
    static final ArrayList<BatteryEntry> sRequestQueue = null;
    private static NameAndIconLoader sRequestThread;
    static final HashMap<String, UidToDetail> sUidCache = null;
    private final BatteryConsumer mBatteryConsumer;
    private double mConsumedPower;
    private final int mConsumerType;
    private final Context mContext;
    private String mDefaultPackageName;
    public Drawable mIcon;
    public int mIconId;
    private final boolean mIsHidden;
    public String mName;
    public double mPercent;
    private final int mPowerComponentId;
    private long mTimeInBackgroundMs;
    private long mTimeInForegroundMs;
    private final int mUid;
    private long mUsageDurationMs;

    public static final class NameAndIcon {
        public final Drawable mIcon;
        public final int mIconId;
        public final String mName;
        public final String mPackageName;

        public NameAndIcon(String name, Drawable icon, int iconId) {
            this(name, null, icon, iconId);
        }

        public NameAndIcon(String name, String packageName, Drawable icon, int iconId) {
            this.mName = name;
            this.mIcon = icon;
            this.mIconId = iconId;
            this.mPackageName = packageName;
        }
    }

    private static class NameAndIconLoader extends Thread {
        private boolean mAbort;

        NameAndIconLoader() {
            super("BatteryUsage Icon Loader");
            this.mAbort = false;
        }

        public void abort() {
            this.mAbort = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            ArrayList<BatteryEntry> r0 = BatteryEntry.sRequestQueue;
            monitor-enter(r0);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (BatteryEntry.sRequestQueue.isEmpty() == true) goto L15;
            if (this.mAbort == true) goto L15;
            BatteryEntry r1 = BatteryEntry.sRequestQueue.remove(0);     // Catch: Throwable -> L19
            monitor-exit(r0);     // Catch: Throwable -> L19
            NameAndIcon r2 = BatteryEntry.loadNameAndIcon(BatteryEntry.access$000(r1), r1.getUid(), BatteryEntry.sHandler, r1, BatteryEntry.access$100(r1), r1.mName, r1.mIcon);
            if (r2 == null) goto L2;
            r1.mIcon = r2.mIcon;
            r1.mName = r2.mName;
            BatteryEntry.access$102(r1, r2.mPackageName);
        L15:
            if (BatteryEntry.sHandler == null) goto L17;
            BatteryEntry.sHandler.sendEmptyMessage(2);     // Catch: Throwable -> L19
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
        }
    }

    static class UidToDetail {
        Drawable mIcon;
        String mName;
        String mPackageName;

        UidToDetail() {
        }
    }

    public static boolean isSystemUid(int uid) {
        if (uid != 1000) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ Context access$000(BatteryEntry r0) {
        return r0.mContext;
    }

    static /* synthetic */ String access$100(BatteryEntry r0) {
        return r0.mDefaultPackageName;
    }

    static /* synthetic */ String access$102(BatteryEntry r0, String r1) {
        r0.mDefaultPackageName = r1;
        return r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BatteryEntry another) {
        return compareTo2(another);
    }

    static {
        sUidCache = new HashMap();
        sRequestQueue = new ArrayList();
        sCurrentLocale = null;
        COMPARATOR = new BatteryEntry$$ExternalSyntheticLambda0();
    }

    public static void startRequestQueue() {
        if (sHandler == null) goto L17;
        ArrayList<BatteryEntry> r0 = sRequestQueue;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r0.isEmpty() == true) goto L12;
        NameAndIconLoader r1 = sRequestThread;     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        r1.abort();     // Catch: Throwable -> L14
    L11:
        NameAndIconLoader r2 = new NameAndIconLoader();     // Catch: Throwable -> L14
        sRequestThread = r2;     // Catch: Throwable -> L14
        r2.setPriority(1);     // Catch: Throwable -> L14
        sRequestThread.start();     // Catch: Throwable -> L14
        r0.notify();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    }

    public static void stopRequestQueue() {
        ArrayList<BatteryEntry> r0 = sRequestQueue;
        monitor-enter(r0);
        NameAndIconLoader r1 = sRequestThread;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.abort();     // Catch: Throwable -> L9
        sRequestThread = null;     // Catch: Throwable -> L9
        r0.clear();     // Catch: Throwable -> L9
        sHandler = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void clearUidCache() {
        sUidCache.clear();
    }

    static /* synthetic */ int lambda$static$0(BatteryEntry r2, BatteryEntry r3) {
        return Double.compare(r3.getConsumedPower(), r2.getConsumedPower());
    }

    public BatteryEntry(Context context, Handler handler, UserManager um, BatteryConsumer batteryConsumer, boolean isHidden, int uid, String[] packages, String packageName) {
        this(context, handler, um, batteryConsumer, isHidden, uid, packages, packageName, true);
    }

    public BatteryEntry(Context context, Handler handler, UserManager um, BatteryConsumer batteryConsumer, boolean isHidden, int uid, String[] packages, String packageName, boolean loadDataInBackground) {
        sHandler = handler;
        this.mContext = context;
        this.mBatteryConsumer = batteryConsumer;
        this.mIsHidden = isHidden;
        this.mDefaultPackageName = packageName;
        this.mPowerComponentId = -1;
        if ((batteryConsumer instanceof UidBatteryConsumer) == false) goto L23;
        this.mUid = uid;
        this.mConsumerType = 1;
        this.mConsumedPower = batteryConsumer.getConsumedPower();
        UidBatteryConsumer r6 = (UidBatteryConsumer) batteryConsumer;
        if (this.mDefaultPackageName != null) goto L16;
        if (packages == null) goto L11;
        if (packages.length != 1) goto L11;
        this.mDefaultPackageName = packages[0];
    L11:
        if (isSystemUid(uid) == false) goto L13;
        String r5 = PACKAGE_SYSTEM;
    L14:
        this.mDefaultPackageName = r5;
        goto L16
    L13:
        r5 = r6.getPackageWithHighestDrain();
    L16:
        if (this.mDefaultPackageName == null) goto L21;
        PackageManager r3 = context.getPackageManager();
        this.mName = r3.getApplicationLabel(r3.getApplicationInfo(this.mDefaultPackageName, 0)).toString();     // Catch: PackageManager.NameNotFoundException -> L20
    L20:
        OLog.d(TAG, "PackageManager failed to retrieve ApplicationInfo for: " + this.mDefaultPackageName);
        this.mName = this.mDefaultPackageName;
    L21:
        getQuickNameIconForUid(uid, packages, loadDataInBackground);
        this.mTimeInForegroundMs = r6.getTimeInStateMs(0);
        this.mTimeInBackgroundMs = r6.getTimeInStateMs(1);
        return;
    L23:
        if ((batteryConsumer instanceof UserBatteryConsumer) == false) goto L27;
        this.mUid = -1;
        this.mConsumerType = 2;
        this.mConsumedPower = batteryConsumer.getConsumedPower();
        NameAndIcon r4 = getNameAndIconFromUserId(context, ((UserBatteryConsumer) batteryConsumer).getUserId());
        this.mIcon = r4.mIcon;
        this.mName = r4.mName;
        return;
    L27:
        throw new IllegalArgumentException("Unsupported: " + batteryConsumer);
    }

    public BatteryEntry(Context context, int powerComponentId, double devicePowerMah, double appsPowerMah, long usageDurationMs) {
        this.mContext = context;
        this.mBatteryConsumer = null;
        this.mUid = -1;
        this.mIsHidden = false;
        this.mPowerComponentId = powerComponentId;
        if (powerComponentId == 0) goto L6;
        devicePowerMah = devicePowerMah - appsPowerMah;
    L6:
        this.mConsumedPower = devicePowerMah;
        this.mUsageDurationMs = usageDurationMs;
        this.mConsumerType = 3;
        NameAndIcon r3 = getNameAndIconFromPowerComponent(context, powerComponentId);
        this.mIconId = r3.mIconId;
        this.mName = r3.mName;
        int r4 = this.mIconId;
        if (r4 == 0) goto L10;
        this.mIcon = context.getDrawable(r4);
        return;
    }

    public BatteryEntry(Context context, int powerComponentId, String powerComponentName, double devicePowerMah, double appsPowerMah) {
        this.mContext = context;
        this.mBatteryConsumer = null;
        this.mUid = -1;
        this.mIsHidden = false;
        this.mPowerComponentId = powerComponentId;
        this.mIconId = R.drawable.ic_power_system;
        this.mIcon = context.getDrawable(R.drawable.ic_power_system);
        this.mName = powerComponentName;
        if (powerComponentId == 0) goto L6;
        devicePowerMah = devicePowerMah - appsPowerMah;
    L6:
        this.mConsumedPower = devicePowerMah;
        this.mConsumerType = 3;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BatteryEntry another) {
        return Double.compare(another.getConsumedPower(), this.mConsumedPower);
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public String getLabel() {
        return this.mName;
    }

    public int getConsumerType() {
        return this.mConsumerType;
    }

    public int getPowerComponentId() {
        return this.mPowerComponentId;
    }

    void getQuickNameIconForUid(final int uid, final String[] packages, final boolean loadDataInBackground) {
        Locale r0 = Locale.getDefault();
        if (sCurrentLocale == r0) goto L5;
        clearUidCache();
        sCurrentLocale = r0;
    L5:
        String r1 = Integer.toString(uid);
        HashMap<String, UidToDetail> r2 = sUidCache;
        if (r2.containsKey(r1) == false) goto L9;
        UidToDetail r4 = r2.get(r1);
        this.mDefaultPackageName = r4.mPackageName;
        this.mName = r4.mName;
        this.mIcon = r4.mIcon;
        return;
    L9:
        if (packages != null) goto L11;
    L14:
        NameAndIcon r5 = getNameAndIconFromUid(this.mContext, this.mName, uid);
        this.mIcon = r5.mIcon;
        this.mName = r5.mName;
    L16:
        if (sHandler == null) goto L26;
        if (loadDataInBackground == false) goto L29;
        ArrayList<BatteryEntry> r6 = sRequestQueue;
        monitor-enter(r6);
        r6.add(this);     // Catch: Throwable -> L23
        monitor-exit(r6);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L29:
        return;
    L26:
        return;
    L11:
        if (packages.length == 0) goto L14;
        this.mIcon = this.mContext.getPackageManager().getDefaultActivityIcon();
        goto L16
    }

    public static NameAndIcon loadNameAndIcon(Context context, int uid, Handler handler, BatteryEntry batteryEntry, String defaultPackageName, String name, Drawable icon) {
        if (uid != 0) goto L5;
        return null;
    L5:
        if (uid == (-1)) goto L94;
        PackageManager r3 = context.getPackageManager();
        if (isSystemUid(uid) == false) goto L10;
        String[] r0 = {PACKAGE_SYSTEM};
    L11:
        String[] r4 = r0;
        if (r4 == null) goto L61;
        int r7 = r4.length;
        String[] r8 = new String[r7];
        System.arraycopy(r4, 0, r8, 0, r4.length);
        IPackageManager r9 = AppGlobals.getPackageManager();
        int r10 = UserHandle.getUserId(uid);
        String r11 = defaultPackageName;
        int r12 = 0;
    L14:
        String r6 = TAG;
        if (r12 >= r7) goto L29;
        ApplicationInfo r1 = r9.getApplicationInfo(r8[r12], 0, r10);     // Catch: RemoteException -> L26
        if (r1 != null) goto L19;
        OLog.d(TAG, "Retrieving null app info for package " + r8[r12] + ", user " + r10);     // Catch: RemoteException -> L26
    L28:
        r12 = r12 + 1;
        goto L14
    L19:
        CharSequence r16 = r1.loadLabel(r3);     // Catch: RemoteException -> L26
        if (r16 == null) goto L23;
        r8[r12] = r16.toString();     // Catch: RemoteException -> L26
    L23:
        if (r1.icon == 0) goto L28;
        r11 = r4[r12];     // Catch: RemoteException -> L26
        Drawable r13 = r1.loadIcon(r3);     // Catch: RemoteException -> L26
    L30:
        if (r7 != 1) goto L32;
        String r2 = r8[0];
    L62:
        String r5 = Integer.toString(uid);
        if (r13 != null) goto L65;
        r13 = r3.getDefaultActivityIcon();
    L65:
        UidToDetail r14 = new UidToDetail();
        r14.mName = r2;
        r14.mIcon = r13;
        r14.mPackageName = r11;
        sUidCache.put(r5, r14);
        if (handler == null) goto L69;
        handler.sendMessage(handler.obtainMessage(1, batteryEntry));
    L69:
        return new NameAndIcon(r2, r11, r13, 0);
    L32:
        int r15 = r4.length;
        String r17 = name;
        int r18 = 0;
    L33:
        if (r18 >= r15) goto L60;
        String r19 = r4[r18];
        String r21 = r6;
        PackageInfo r20 = r9.getPackageInfo(r19, 0, r10);     // Catch: RemoteException -> L56
        if (r20 != null) goto L40;
        String r22 = r21;
        OLog.d(r22, "Retrieving null package info for package " + r19 + ", user " + r10);     // Catch: RemoteException -> L54
    L59:
        r18 = r18 + 1;
        r6 = r22;
    L54:
        e = e;
    L58:
        OLog.d(r22, "Error while retrieving package info for package " + r19 + ", user " + r10, e);
        goto L59
    L40:
        r22 = r21;
        if (r20.sharedUserLabel == 0) goto L59;
        CharSequence r23 = r3.getText(r19, r20.sharedUserLabel, r20.applicationInfo);     // Catch: RemoteException -> L54
        if (r23 == null) goto L59;
        String r24 = r23.toString();     // Catch: RemoteException -> L54
        if (r20.applicationInfo.icon == 0) goto L51;
        r13 = r20.applicationInfo.loadIcon(r3);     // Catch: RemoteException -> L49
        r11 = r19;
    L49:
        e = e;
        r17 = r24;
        r11 = r19;
    L51:
        r2 = r24;
    L52:
        e = e;
        r17 = r24;
    L56:
        e = e;
        r22 = r21;
        goto L58
    L60:
        r2 = r17;
    L26:
        e = move-exception;
        OLog.d(TAG, "Error while retrieving app info for package " + r8[r12] + ", user " + r10, e);
        goto L28
    L29:
        r13 = icon;
        goto L30
    L61:
        r11 = defaultPackageName;
        r2 = name;
        r13 = icon;
        goto L62
    L10:
        r0 = r3.getPackagesForUid(uid);
        goto L11
    L94:
        return null;
    }

    public String getKey() {
        BatteryConsumer r0 = this.mBatteryConsumer;
        if ((r0 instanceof UidBatteryConsumer) == false) goto L7;
        return Integer.toString(this.mUid);
    L7:
        if ((r0 instanceof UserBatteryConsumer) == false) goto L11;
        return "U|" + this.mBatteryConsumer.getUserId();
    L11:
        return "S|" + this.mPowerComponentId;
    }

    public boolean isHidden() {
        return this.mIsHidden;
    }

    public boolean isAppEntry() {
        return this.mBatteryConsumer instanceof UidBatteryConsumer;
    }

    public boolean isUserEntry() {
        if ((this.mBatteryConsumer instanceof UserBatteryConsumer) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public String getDefaultPackageName() {
        return this.mDefaultPackageName;
    }

    public int getUid() {
        return this.mUid;
    }

    public long getTimeInForegroundMs() {
        if ((this.mBatteryConsumer instanceof UidBatteryConsumer) == false) goto L7;
        return this.mTimeInForegroundMs;
    L7:
        return this.mUsageDurationMs;
    }

    public long getTimeInBackgroundMs() {
        if ((this.mBatteryConsumer instanceof UidBatteryConsumer) == true) goto L5;
        return 0;
    L5:
        return this.mTimeInBackgroundMs;
    }

    public double getConsumedPower() {
        return this.mConsumedPower;
    }

    public void add(BatteryConsumer batteryConsumer) {
        this.mConsumedPower += batteryConsumer.getConsumedPower();
        if ((batteryConsumer instanceof UidBatteryConsumer) == false) goto L8;
        UidBatteryConsumer r5 = (UidBatteryConsumer) batteryConsumer;
        this.mTimeInForegroundMs += r5.getTimeInStateMs(0);
        this.mTimeInBackgroundMs += r5.getTimeInStateMs(1);
        if (this.mDefaultPackageName != null) goto L9;
        this.mDefaultPackageName = r5.getPackageWithHighestDrain();
        return;
    L9:
        return;
    }

    public static NameAndIcon getNameAndIconFromUserId(Context context, final int userId) {
        if (((UserManager) context.getSystemService(UserManager.class)).getUserInfo(userId) == null) goto L5;
        String r2 = "";
    L7:
        return new NameAndIcon(r2, null, 0);
    L5:
        r2 = context.getResources().getString(R.string.running_process_item_removed_user_label);
        goto L7
    }

    public static NameAndIcon getNameAndIconFromUid(Context context, String name, final int uid) {
        Drawable r0 = context.getDrawable(R.drawable.ic_power_system);
        if (uid != 0) goto L6;
        name = context.getResources().getString(R.string.process_kernel_label);
    L22:
        return new NameAndIcon(name, r0, 0);
    L6:
        if (uid != (-4)) goto L9;
        name = context.getResources().getString(R.string.process_removed_apps);
        goto L22
    L9:
        if (uid != (-5)) goto L12;
        name = context.getResources().getString(R.string.process_network_tethering);
        goto L22
    L12:
        if ("mediaserver".equals(name) == false) goto L15;
        name = context.getResources().getString(R.string.process_mediaserver_label);
        goto L22
    L15:
        if ("dex2oat".equals(name) == false) goto L17;
    L20:
        name = context.getResources().getString(R.string.process_dex2oat_label);
        goto L22
    L17:
        if ("dex2oat32".equals(name) == true) goto L20;
        if ("dex2oat64".equals(name) == false) goto L22;
        goto L20
    }

    public static NameAndIcon getNameAndIconFromPowerComponent(Context context, int powerComponentId) {
        int r1 = R.drawable.ic_settings_display;
        if (powerComponentId != 0) goto L5;
        String r3 = context.getResources().getString(R.string.power_screen);
    L26:
        return new NameAndIcon(r3, null, r1);
    L5:
        if (powerComponentId != 6) goto L7;
        r3 = context.getResources().getString(R.string.power_flashlight);
        goto L26
    L7:
        if (powerComponentId != 8) goto L9;
        r3 = context.getResources().getString(R.string.power_cell);
        r1 = R.drawable.ic_cellular_1_bar;
        goto L26
    L9:
        if (powerComponentId != 11) goto L11;
        r3 = context.getResources().getString(R.string.power_wifi);
        r1 = R.drawable.ic_settings_wireless_no_theme;
        goto L26
    L11:
        if (powerComponentId != 2) goto L13;
        r3 = context.getResources().getString(R.string.power_bluetooth);
        r1 = R.drawable.ic_settings_bluetooth;
        goto L26
    L13:
        if (powerComponentId == 3) goto L19;
        switch(powerComponentId) {
            case 13: goto L18;
            case 14: goto L17;
            case 15: goto L16;
            case 16: goto L18;
            default: goto L15;
        };
    L15:
        OLog.w(TAG, "unknown attribute:" + powerComponentId);
        r1 = R.drawable.ic_power_system;
        r3 = null;
        goto L26
    L16:
        r3 = context.getResources().getString(R.string.ambient_display_screen_title);
        r1 = R.drawable.ic_settings_aod;
        goto L26
    L17:
        r3 = context.getResources().getString(R.string.power_phone);
        r1 = R.drawable.ic_settings_voice_calls;
        goto L26
    L18:
        r3 = context.getResources().getString(R.string.power_idle);
        r1 = R.drawable.ic_settings_phone_idle;
        goto L26
    L19:
        r3 = context.getResources().getString(R.string.power_camera);
        r1 = R.drawable.ic_settings_camera;
        goto L26
    }
}
