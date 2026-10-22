package com.bytedanceos.powerusage;

import android.app.AppGlobals;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import com.bytedanceos.os.BatterySaver;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryEntry implements Comparable<BatteryEntry> {
    public static final String AMAP_LOCATION = "com.amap.android.location";
    public static final String BYTEDANCE_LAUNCHER_PACKAGE = "com.bytedanceos.launcher";
    private static final String CALENDAR_PACKAGE = "com.android.calendar";
    private static final String CALENDAR_PROVIDER_PACKAGE = "com.android.providers.calendar";
    public static final String CAMERA_PACKAGE = "com.android.camera2";
    public static final String CLEANER_PACKAGE = "com.obric.cleaner";
    public static final String CLOUD_SYNC_PACKAGE = "com.bytedanceos.cloudsync";
    private static final String CONTACTSP_ROVIDERS_PACKAGE = "com.android.providers.contacts";
    private static final String CONTACTS_PACKAGE = "com.android.contacts";
    private static final String EMAIL_PACKAGE = "com.android.email";
    private static final String EXCHANGE_PACKAGE = "com.android.exchange";
    private static final String IDEAPILLS_PACKAGE = "com.bytedanceos.ideapills";
    private static final String INCALLUI_PACKAGE = "com.android.incallui";
    private static final String KEYGUARD_PACKAGE = "com.bytedanceos.keyguard";
    public static final String LAUNCHER_PACKAGE = "com.android.launcher3";
    public static final int MSG_REPORT_FULLY_DRAWN = 2;
    public static final int MSG_UPDATE_NAME_ICON = 1;
    public static final String NODISTURB_PACKAGE = "com.obric.nodisturb";
    private static final String ONESTEP_PACKAGE = "com.bytedanceos.sidebar";
    private static final String PHONE_NUMBER_ASSISTANT_PACKAGE = "com.obric.numberassistant";
    private static final String PHONE_PACKAGE = "com.android.phone";
    public static final String SECURITY_CENTER_PACKAGE = "com.obric.security";
    public static final String SETTING_PACKAGE = "com.android.settings";
    private static final String TAG = "BatteryEntry";
    public static final String TORCH_PACKAGE = "com.bytedanceos.torch";
    private static final List<String> asSystemApps = null;
    static final ArrayList<BatteryEntry> mRequestQueue = null;
    private static NameAndIconLoader mRequestThread;
    static Handler sHandler;
    static final HashMap<String, UidToDetail> sUidCache = null;
    public final Context context;
    public String defaultPackageName;
    public Drawable icon;
    public int iconId;
    public int mUid;
    public String name;
    public final BatterySaver sipper;

    /* JADX INFO: renamed from: com.bytedanceos.powerusage.BatteryEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType = null;

        static {
            int[] r0 = new int[BatterySaver.DrainType.values().length];
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType = r0;
            r0[BatterySaver.DrainType.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.CELL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.PHONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.WIFI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.BLUETOOTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.SCREEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.FLASHLIGHT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.APP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.USER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.UNACCOUNTED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.OVERCOUNTED.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[BatterySaver.DrainType.CAMERA.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    private static class NameAndIconLoader extends Thread {
        private boolean mAbort;

        public NameAndIconLoader() {
            super("BatteryUsage Icon Loader");
            this.mAbort = false;
        }

        public void abort() {
            this.mAbort = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            ArrayList<BatteryEntry> r0 = BatteryEntry.mRequestQueue;
            monitor-enter(r0);
        L18:
            th = move-exception;
            throw th;
        L5:
            if (BatteryEntry.mRequestQueue.isEmpty() == true) goto L13;
            if (this.mAbort == true) goto L13;
            BatteryEntry r1 = BatteryEntry.mRequestQueue.remove(0);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            r1.loadNameAndIcon();
        L13:
            if (BatteryEntry.sHandler == null) goto L15;
            BatteryEntry.sHandler.sendEmptyMessage(2);     // Catch: Throwable -> L18
        L15:
            BatteryEntry.mRequestQueue.clear();     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
        }
    }

    static class UidToDetail {
        Drawable icon;
        String name;
        String packageName;

        UidToDetail() {
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BatteryEntry another) {
        return compareTo2(another);
    }

    static {
        sUidCache = new HashMap();
        mRequestQueue = new ArrayList();
        asSystemApps = Arrays.asList(new String[]{"com.bytedance.rem", "com.svox.pico", "com.android.documentsui", "com.bytedanceos.updater", "com.bytedanceos.systemui", "com.android.systemui", "com.android.systemui:screenshot", "com.bytedanceos.tracker", "com.obric.wallpaper", "com.bytedance.crashreport", "com.android.defcontainer", "com.android.printspooler", "com.android.musicfx", "com.android.cellbroadcastreceiver", "android.process.acore", "com.android.externalstorage", "dex2oat", "com.bytedanceos.expandservice", "org.simalliance.openmobileapi.service", "com.android.calllogbackup", "com.android.providers.weather", "com.bytedanceos.bytedancebrain", "com.bytedanceos.intelligenwords", "com.bytedanceos.textparticiple", "com.bytedance.smpush"});
    }

    public static void startRequestQueue() {
        if (sHandler == null) goto L17;
        ArrayList<BatteryEntry> r0 = mRequestQueue;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r0.isEmpty() == true) goto L12;
        NameAndIconLoader r1 = mRequestThread;     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        r1.abort();     // Catch: Throwable -> L14
    L11:
        NameAndIconLoader r2 = new NameAndIconLoader();     // Catch: Throwable -> L14
        mRequestThread = r2;     // Catch: Throwable -> L14
        r2.setPriority(1);     // Catch: Throwable -> L14
        mRequestThread.start();     // Catch: Throwable -> L14
        r0.notify();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    }

    public static void stopRequestQueue() {
        ArrayList<BatteryEntry> r0 = mRequestQueue;
        monitor-enter(r0);
        NameAndIconLoader r1 = mRequestThread;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.abort();     // Catch: Throwable -> L9
        mRequestThread = null;     // Catch: Throwable -> L9
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

    public BatteryEntry(Context context, Handler handler, UserManager um, BatterySaver sipper) {
        sHandler = handler;
        this.context = context;
        this.sipper = sipper;
        switch(AnonymousClass1.$SwitchMap$com$bytedanceos$os$BatterySaver$DrainType[sipper.drainType.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L24;
        };
    L5:
        this.name = context.getResources().getString(R.string.power_camera);
        this.iconId = R.drawable.ic_settings_camera;
        goto L24
    L6:
        this.name = context.getResources().getString(R.string.power_overcounted);
        this.iconId = R.drawable.ic_power_system;
        goto L24
    L7:
        this.name = context.getResources().getString(R.string.power_unaccounted);
        this.iconId = R.drawable.ic_power_system;
        goto L24
    L8:
        UserInfo r5 = um.getUserInfo(sipper.userId);
        if (r5 == null) goto L14;
        String r6 = r5.name;
        this.name = r6;
        if (r6 != null) goto L13;
        this.name = Integer.toString(r5.id);
    L13:
        this.name = context.getResources().getString(R.string.running_process_item_user_label, new Object[]{this.name});
        goto L24
    L14:
        this.icon = null;
        this.name = context.getResources().getString(R.string.running_process_item_removed_user_label);
        goto L24
    L15:
        this.name = sipper.packageWithHighestDrain;
        goto L24
    L16:
        this.name = context.getResources().getString(R.string.power_flashlight);
        this.iconId = R.drawable.ic_settings_display;
        goto L24
    L17:
        this.name = context.getResources().getString(R.string.power_screen);
        this.iconId = R.drawable.ic_settings_display;
        goto L24
    L18:
        this.name = context.getResources().getString(R.string.power_bluetooth);
        this.iconId = R.drawable.ic_settings_bluetooth;
        goto L24
    L19:
        this.name = context.getString(R.string.power_network);
        this.iconId = R.drawable.ic_settings_wifi;
        goto L24
    L20:
        this.name = context.getResources().getString(R.string.power_phone);
        this.iconId = R.drawable.ic_settings_voice_calls;
        goto L24
    L21:
        this.name = context.getResources().getString(R.string.power_cell);
        this.iconId = R.drawable.ic_settings_cell_standby;
        goto L24
    L22:
        this.name = context.getResources().getString(R.string.power_idle);
        this.iconId = R.drawable.ic_settings_phone_idle;
    L24:
        if (isSplitedSystemPackage(sipper.packageWithHighestDrain) == false) goto L32;
        PackageManager r7 = context.getPackageManager();
        if (r7 != null) goto L45;
    L30:
        this.defaultPackageName = sipper.packageWithHighestDrain;     // Catch: PackageManager.NameNotFoundException -> L44
        goto L32
    L45:
        ApplicationInfo r8 = r7.getApplicationInfo(sipper.packageWithHighestDrain, 0);     // Catch: PackageManager.NameNotFoundException -> L44
        if (r8 == null) goto L30;
        this.name = r8.loadLabel(r7).toString();     // Catch: PackageManager.NameNotFoundException -> L44
        this.icon = r8.loadIcon(r7);     // Catch: PackageManager.NameNotFoundException -> L44
    L32:
        if (this.iconId <= 0) goto L35;
        this.icon = context.getResources().getDrawable(this.iconId);
    L35:
        if (this.name == null) goto L41;
        if (this.iconId == 0) goto L39;
        return;
    L39:
        if (this.icon == null) goto L41;
        return;
    L41:
        if (this.sipper.uidObj == null) goto L49;
        getQuickNameIconForUid(this.sipper.uidObj.getUid());
        return;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getLabel() {
        return this.name;
    }

    void getQuickNameIconForUid(final int uid) {
        this.mUid = uid;
        String r0 = Integer.toString(uid);
        UidToDetail r1 = sUidCache.get(r0);
        if (r1 == null) goto L6;
        this.defaultPackageName = r1.packageName;
        this.name = r1.name;
        this.icon = r1.icon;
        return;
    L6:
        PackageManager r2 = this.context.getPackageManager();
        if (r2 == null) goto L20;
        this.icon = r2.getDefaultActivityIcon();
        if (r2.getPackagesForUid(uid) != null) goto L20;
        if (uid != 0) goto L13;
        this.name = this.context.getResources().getString(R.string.system_battery_sipper);
    L18:
        this.iconId = R.drawable.ic_power_system;
        this.icon = this.context.getResources().getDrawable(this.iconId);
        goto L20
    L13:
        if ("mediaserver".equals(this.name) == false) goto L16;
        this.name = this.context.getResources().getString(R.string.process_mediaserver_label);
        goto L18
    L16:
        if ("dex2oat".equals(this.name) == false) goto L18;
        this.name = this.context.getResources().getString(R.string.process_dex2oat_label);
    L20:
        if (uid != 1000) goto L24;
        this.name = this.context.getResources().getString(R.string.system_battery_sipper);
        this.iconId = R.drawable.ic_power_system;
        this.icon = this.context.getResources().getDrawable(this.iconId, null);
        return;
    L24:
        if (sHandler == null) goto L33;
        ArrayList<BatteryEntry> r5 = mRequestQueue;
        monitor-enter(r5);
        r5.add(this);     // Catch: Throwable -> L30
        monitor-exit(r5);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    }

    public static boolean isSplitedSystemPackage(String pacakgeName) {
        if (SETTING_PACKAGE.equals(pacakgeName) == false) goto L5;
        return true;
    L5:
        if (CAMERA_PACKAGE.equals(pacakgeName) == false) goto L7;
        return true;
    L7:
        if (TORCH_PACKAGE.equals(pacakgeName) == false) goto L9;
        return true;
    L9:
        if (KEYGUARD_PACKAGE.equals(pacakgeName) == false) goto L11;
        return true;
    L11:
        if (IDEAPILLS_PACKAGE.equals(pacakgeName) == false) goto L13;
        return true;
    L13:
        if (ONESTEP_PACKAGE.equals(pacakgeName) == true) goto L23;
        return false;
    L23:
        return true;
    }

    private static boolean shouldMergeToSystem(BatterySaver bs) {
        if (shouldMergeToSystemByUid(bs) == false) goto L5;
    L8:
        return true;
    L5:
        if (shouldMergeToSystemByPackage(bs, asSystemApps) == true) goto L8;
        return false;
    }

    private static boolean shouldMergeToSystemByUid(BatterySaver sipper) {
        if (sipper.getUid() < 10000) goto L5;
    L7:
        return false;
    L5:
        if (sipper.drainType != BatterySaver.DrainType.APP) goto L7;
        return true;
    }

    private static boolean shouldMergeToSystemByPackage(BatterySaver bs, List<String> specialPkgs) {
        if (bs.packageWithHighestDrain != null) goto L5;
    L7:
        return false;
    L5:
        if (specialPkgs.contains(bs.packageWithHighestDrain) == false) goto L7;
        return true;
    }

    public void loadNameAndIcon() {
        if (this.sipper.uidObj != null) goto L6;
        return;
    L6:
        if (shouldMergeToSystem(this.sipper) == false) goto L9;
        return;
    L9:
        if (AMAP_LOCATION.equals(this.name) == false) goto L11;
    L12:
        this.iconId = R.drawable.ic_settings_gps;
        this.icon = this.context.getResources().getDrawable(R.drawable.ic_settings_gps);
    L13:
        PackageManager r2 = this.context.getPackageManager();
        if (r2 != null) goto L16;
        return;
    L16:
        int r3 = this.sipper.uidObj.getUid();
        this.sipper.mPackages = r2.getPackagesForUid(r3);
        if (this.sipper.mPackages == null) goto L53;
        int r5 = this.sipper.mPackages.length;
        String[] r6 = new String[r5];
        int r8 = 0;
        System.arraycopy(this.sipper.mPackages, 0, r6, 0, this.sipper.mPackages.length);
        IPackageManager r7 = AppGlobals.getPackageManager();
        int r9 = UserHandle.getUserId(r3);
        int r10 = 0;
    L19:
        long r11 = 0;
        if (r10 >= r5) goto L34;
        ApplicationInfo r0 = r7.getApplicationInfo(r6[r10], 0, r9);     // Catch: RemoteException -> L31
        if (r0 != null) goto L24;
        OLog.d(TAG, "Retrieving null app info for package " + r6[r10] + ", user " + r9);     // Catch: RemoteException -> L31
    L33:
        r10 = r10 + 1;
        goto L19
    L24:
        CharSequence r15 = r0.loadLabel(r2);     // Catch: RemoteException -> L31
        if (r15 == null) goto L28;
        r6[r10] = r15.toString();     // Catch: RemoteException -> L31
    L28:
        if (r0.icon == 0) goto L33;
        this.defaultPackageName = this.sipper.mPackages[r10];     // Catch: RemoteException -> L31
        this.icon = r0.loadIcon(r2);     // Catch: RemoteException -> L31
    L31:
        e = move-exception;
        OLog.d(TAG, "Error while retrieving app info for package " + r6[r10] + ", user " + r9, e);
    L34:
        if (r5 != 1) goto L36;
        this.name = r6[0];
        goto L53
    L36:
        String[] r12 = this.sipper.mPackages;
        int r13 = r12.length;
    L37:
        if (r8 >= r13) goto L53;
        String r14 = r12[r8];
        PackageInfo r1 = r7.getPackageInfo(r14, r11, r9);     // Catch: RemoteException -> L50
        if (r1 != null) goto L43;
        OLog.d(TAG, "Retrieving null package info for package " + r14 + ", user " + r9);     // Catch: RemoteException -> L50
    L52:
        r8 = r8 + 1;
        r11 = 0;
        goto L37
    L43:
        if (r1.sharedUserLabel == 0) goto L52;
        CharSequence r16 = r2.getText(r14, r1.sharedUserLabel, r1.applicationInfo);     // Catch: RemoteException -> L50
        if (r16 == null) goto L52;
        this.name = r16.toString();     // Catch: RemoteException -> L50
        if (r1.applicationInfo.icon == 0) goto L53;
        this.defaultPackageName = r14;     // Catch: RemoteException -> L50
        this.icon = r1.applicationInfo.loadIcon(r2);     // Catch: RemoteException -> L50
    L50:
        e = move-exception;
        OLog.d(TAG, "Error while retrieving package info for package " + r14 + ", user " + r9, e);
    L53:
        filterSpecialApp();
        filterSystemApp();
        String r4 = Integer.toString(r3);
        if (this.name != null) goto L57;
        this.name = r4;
    L57:
        if (this.icon != null) goto L59;
        this.icon = r2.getDefaultActivityIcon();
    L59:
        UidToDetail r17 = new UidToDetail();
        r17.name = this.name;
        r17.icon = this.icon;
        r17.packageName = this.defaultPackageName;
        sUidCache.put(r4, r17);
        Handler r18 = sHandler;
        if (r18 == null) goto L79;
        r18.sendMessage(r18.obtainMessage(1, this));
        return;
    L79:
        return;
    L11:
        if (AMAP_LOCATION.equals(this.defaultPackageName) == false) goto L13;
        goto L12
    }

    public boolean filterSpecialApp() {
        if (BYTEDANCE_LAUNCHER_PACKAGE.equals(this.name) == false) goto L5;
    L18:
        this.iconId = R.drawable.ic_settings_launcher;
        this.icon = this.context.getResources().getDrawable(R.drawable.ic_settings_launcher);
        return true;
    L5:
        if (BYTEDANCE_LAUNCHER_PACKAGE.equals(this.defaultPackageName) == true) goto L18;
        if (LAUNCHER_PACKAGE.equals(this.name) == true) goto L18;
        if (LAUNCHER_PACKAGE.equals(this.defaultPackageName) == true) goto L18;
        if (AMAP_LOCATION.equals(this.name) == false) goto L14;
    L17:
        this.iconId = R.drawable.ic_settings_gps;
        this.icon = this.context.getResources().getDrawable(R.drawable.ic_settings_gps);
        return true;
    L14:
        if (AMAP_LOCATION.equals(this.defaultPackageName) == true) goto L17;
        return false;
    }

    private boolean filterSystemApp() {
        if (shouldMergeToSystem(this.sipper) == false) goto L6;
        this.name = this.context.getResources().getString(R.string.system_battery_sipper);
        this.iconId = R.drawable.ic_power_system;
        this.icon = this.context.getResources().getDrawable(this.iconId);
        return true;
    L6:
        return false;
    }

    public static void updateUsageAsRequire(List<BatterySaver> usageList) {
        Iterator<BatterySaver> r0 = usageList.iterator();
        BatterySaver r1 = null;
        BatterySaver r4 = null;
        BatterySaver r5 = null;
        BatterySaver r6 = null;
        BatterySaver r7 = null;
        BatterySaver r8 = null;
        BatterySaver r9 = null;
        BatterySaver r10 = null;
        BatterySaver r11 = null;
        BatterySaver r12 = null;
        BatterySaver r13 = null;
        BatterySaver r14 = null;
        BatterySaver r15 = null;
        BatterySaver r16 = null;
        BatterySaver r17 = null;
        BatterySaver r18 = null;
        BatterySaver r19 = null;
        double r20 = 0.0d;
        BatterySaver r2 = null;
        BatterySaver r3 = null;
    L4:
        if (r0.hasNext() == false) goto L108;
        BatterySaver r23 = r4;
        r4 = r0.next();
        BatterySaver r22 = r2;
        if (r2 != null) goto L12;
        BatterySaver r24 = r3;
        if (r4.getUid() == 1001) goto L9;
    L13:
        if (r5 == null) goto L15;
    L18:
        if (r8 == null) goto L20;
    L22:
        if (r11 != null) goto L27;
        if (INCALLUI_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L27;
        r11 = r4;
    L17:
        r2 = r22;
    L10:
        r4 = r23;
    L11:
        r3 = r24;
    L27:
        if (r4.drainType == BatterySaver.DrainType.PHONE) goto L28;
        if (r6 == null) goto L31;
    L33:
        if (r7 == null) goto L35;
    L37:
        if (r9 == null) goto L39;
    L41:
        if (r10 != null) goto L46;
        if (CALENDAR_PROVIDER_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L46;
        r0.remove();
        r10 = r4;
    L46:
        if (r4.drainType != BatterySaver.DrainType.WIFI) goto L49;
        r3 = r4;
        r2 = r22;
        r4 = r23;
        goto L4
    L49:
        if (r4.drainType == BatterySaver.DrainType.CELL) goto L50;
        if (r14 == null) goto L53;
    L55:
        if (r15 == null) goto L57;
    L59:
        if (r16 == null) goto L61;
    L63:
        if (r17 != null) goto L68;
        if (NODISTURB_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L68;
        r17 = r4;
    L68:
        if (r4.getUid() != 1000) goto L73;
        if (r4.drainType != BatterySaver.DrainType.APP) goto L73;
        BatterySaver r25 = r14;
        BatterySaver r26 = r15;
    L107:
        r2 = r22;
        r4 = r23;
        r3 = r24;
        r14 = r25;
        r15 = r26;
    L73:
        if (r4.getUid() != 0) goto L79;
        if (r4.drainType != BatterySaver.DrainType.APP) goto L79;
        if (r1 == null) goto L77;
        r25 = r14;
        r26 = r15;
        r1.totalPowerUse += r4.totalPowerUse;
        r0.remove();
        goto L107
    L77:
        r1 = r4;
    L79:
        r25 = r14;
        r26 = r15;
        if (shouldMergeToSystem(r4) == false) goto L83;
        r20 = r20 + r4.totalPowerUse;
        r0.remove();
        goto L107
    L83:
        if (BYTEDANCE_LAUNCHER_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L88;
        if (r13 == null) goto L90;
        r13.totalPowerUse += r4.totalPowerUse;
        r0.remove();
    L90:
        r13 = r4;
        goto L107
    L88:
        if (LAUNCHER_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L92;
        if (r13 == null) goto L90;
        r13.totalPowerUse += r4.totalPowerUse;
        r0.remove();
        goto L107
    L92:
        if (r19 != null) goto L97;
        if (AMAP_LOCATION.equals(r4.packageWithHighestDrain) == false) goto L97;
        r19 = r4;
    L97:
        if (r4.uidObj != null) goto L99;
        if (r12 != null) goto L107;
        if (CONTACTS_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L107;
        r12 = r4;
        goto L107
    L99:
        if (r4.uidObj.getUid() != 10000) goto L107;
        if (r1 == null) goto L102;
        r1.totalPowerUse += r4.totalPowerUse;
    L102:
        r0.remove();
        goto L107
    L61:
        if (CLOUD_SYNC_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L63;
        r16 = r4;
        goto L17
    L57:
        if (CLEANER_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L59;
        r15 = r4;
        goto L17
    L53:
        if ("com.obric.security".equals(r4.packageWithHighestDrain) == false) goto L55;
        r14 = r4;
        goto L17
    L50:
        r0.remove();
        r2 = r22;
        goto L11
    L39:
        if (CALENDAR_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L41;
        r9 = r4;
        goto L17
    L35:
        if (EXCHANGE_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L37;
        r0.remove();
        r7 = r4;
        goto L17
    L31:
        if (EMAIL_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L33;
        r6 = r4;
        goto L17
    L28:
        r18 = r4;
        goto L17
    L20:
        if (PHONE_NUMBER_ASSISTANT_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L22;
        r0.remove();
        r8 = r4;
        goto L17
    L15:
        if (CONTACTSP_ROVIDERS_PACKAGE.equals(r4.packageWithHighestDrain) == false) goto L18;
        r0.remove();
        r5 = r4;
        goto L17
    L9:
        r0.remove();
        r2 = r4;
        goto L10
    L12:
        r24 = r3;
        goto L13
    L108:
        BatterySaver r27 = r2;
        BatterySaver r28 = r3;
        BatterySaver r29 = r4;
        if (r1 == null) goto L111;
        r1.totalPowerUse += r20;
        r1.packageWithHighestDrain = "system";
    L111:
        if (r28 == null) goto L114;
        if (r29 == null) goto L114;
        r28.totalPowerUse += r29.totalPowerUse;
    L114:
        if (r6 == null) goto L117;
        if (r7 == null) goto L117;
        r6.totalPowerUse += r7.totalPowerUse;
    L117:
        if (r9 == null) goto L120;
        if (r10 == null) goto L120;
        r9.totalPowerUse += r10.totalPowerUse;
    L120:
        if (r12 == null) goto L127;
        if (r27 == null) goto L123;
        r12.totalPowerUse += r27.totalPowerUse;
    L123:
        if (r5 == null) goto L125;
        r12.totalPowerUse += r5.totalPowerUse;
    L125:
        if (r8 == null) goto L127;
        r12.totalPowerUse += r8.totalPowerUse;
    L127:
        if (r11 == null) goto L157;
        if (r18 == null) goto L158;
        r18.totalPowerUse += r11.totalPowerUse;
        usageList.remove(r11);
        return;
    L158:
        return;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BatteryEntry another) {
        BatterySaver r0 = this.sipper;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.compareTo2(another.sipper);
    }

    public String toString() {
        return "name:" + this.name + " value " + this.sipper.totalPowerUse + " highestDrain " + this.sipper.packageWithHighestDrain + " uid " + this.sipper.getUid() + " drainType " + this.sipper.drainType + " packageName " + this.defaultPackageName;
    }
}
