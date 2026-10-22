package com.bytedanceos.batteryusage;

import android.content.Context;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageManager;
import android.os.AggregateBatteryConsumer;
import android.os.BatteryConsumer;
import android.os.BatteryStatsManager;
import android.os.BatteryUsageStats;
import android.os.Handler;
import android.os.UidBatteryConsumer;
import android.os.UserBatteryConsumer;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.SparseArray;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryUsageStatsHelper {
    private static final String MEDIASERVER_PACKAGE_NAME = "mediaserver";
    private static final String[] PACKAGES_SYSTEM = null;
    private static final String PACKAGE_CALENDAR_PROVIDER = "com.android.providers.calendar";
    private static final String PACKAGE_MEDIA_PROVIDER = "com.android.providers.media";
    private static final String PACKAGE_SYSTEMUI = "com.android.systemui";
    private BatteryUsageStats mBatteryUsageStats;
    private Context mContext;
    private Handler mHandler;
    private PackageManager mPackageManager;
    private UserManager mUserManager;

    private boolean shouldHideDevicePowerComponent(BatteryConsumer consumer, int powerComponentId) {
        if (powerComponentId != 0) goto L4;
        return true;
    L4:
        if (powerComponentId != 2) goto L6;
        return true;
    L6:
        if (powerComponentId != 8) goto L8;
        return true;
    L8:
        if (powerComponentId != 11) goto L10;
        return true;
    L10:
        if (powerComponentId == 16) goto L18;
        return false;
    L18:
        return true;
    }

    public double calculateBatteryPercent(double powerUsageMah, double totalPowerMah, int dischargeAmount) {
        if (totalPowerMah != 0.0d) goto L6;
        return 0.0d;
    L6:
        return (powerUsageMah / totalPowerMah) * ((double) dischargeAmount);
    }

    static {
        PACKAGES_SYSTEM = new String[]{PACKAGE_MEDIA_PROVIDER, PACKAGE_CALENDAR_PROVIDER, PACKAGE_SYSTEMUI};
    }

    public BatteryUsageStatsHelper(Context context, Handler handler) {
        this.mContext = context;
        this.mBatteryUsageStats = ((BatteryStatsManager) context.getSystemService(BatteryStatsManager.class)).getBatteryUsageStats();
        this.mPackageManager = this.mContext.getPackageManager();
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        this.mHandler = handler;
    }

    public BatteryUsageStats getBatteryUsageStats() {
        return this.mBatteryUsageStats;
    }

    public List<BatteryEntry> getCoalescedUsageList(boolean showAllApps, boolean loadDataInBackground) {
        SparseArray r1 = new SparseArray();
        ArrayList r2 = new ArrayList();
        List r3 = this.mBatteryUsageStats.getUidBatteryConsumers();
        r3.sort(Comparator.comparingInt(new BatteryUsageStatsHelper$$ExternalSyntheticLambda0(this)));
        int r4 = r3.size();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L16;
        BatteryConsumer r12 = (UidBatteryConsumer) r3.get(r6);
        int r7 = getRealUid(r12);
        String[] r15 = this.mPackageManager.getPackagesForUid(r7);
        if (shouldHideUidBatteryConsumerUnconditionally(r12, r15) == true) goto L15;
        boolean r13 = shouldHideUidBatteryConsumer(r12, r15);
        if (r13 == false) goto L11;
        if (showAllApps == false) goto L15;
    L11:
        int r8 = r1.indexOfKey(r7);
        if (r8 >= 0) goto L14;
        r1.put(r7, new BatteryEntry(this.mContext, this.mHandler, this.mUserManager, r12, r13, r7, r15, null, loadDataInBackground));
        goto L15
    L14:
        ((BatteryEntry) r1.valueAt(r8)).add(r12);
    L15:
        r6 = r6 + 1;
        goto L3
    L16:
        AggregateBatteryConsumer r5 = this.mBatteryUsageStats.getAggregateBatteryConsumer(0);
        AggregateBatteryConsumer r9 = this.mBatteryUsageStats.getAggregateBatteryConsumer(1);
        int r16 = 0;
    L18:
        if (r16 >= 19) goto L25;
        if (showAllApps == false) goto L21;
    L23:
        r2.add(new BatteryEntry(this.mContext, r16, r5.getConsumedPower(r16), r9.getConsumedPower(r16), r5.getUsageDurationMillis(r16)));
    L24:
        r16 = r16 + 1;
        goto L18
    L21:
        if (shouldHideDevicePowerComponent(r5, r16) == false) goto L23;
    L25:
        int r14 = 1000;
    L27:
        if (r14 >= (r5.getCustomPowerComponentCount() + 1000)) goto L32;
        if (showAllApps == false) goto L31;
        r2.add(new BatteryEntry(this.mContext, r14, r5.getCustomPowerComponentName(r14), r5.getConsumedPowerForCustomComponent(r14), r9.getConsumedPowerForCustomComponent(r14)));
    L31:
        r14 = r14 + 1;
        goto L27
    L32:
        if (showAllApps == false) goto L36;
        List r10 = this.mBatteryUsageStats.getUserBatteryConsumers();
        int r11 = r10.size();
        int r17 = 0;
    L34:
        if (r17 >= r11) goto L36;
        r2.add(new BatteryEntry(this.mContext, this.mHandler, this.mUserManager, (UserBatteryConsumer) r10.get(r17), true, -1, null, null, loadDataInBackground));
        r17 = r17 + 1;
    L36:
        int r0 = r1.size();
        int r18 = 0;
    L37:
        if (r18 >= r0) goto L39;
        r2.add((BatteryEntry) r1.valueAt(r18));
        r18 = r18 + 1;
        goto L37
    L39:
        r2.sort(BatteryEntry.COMPARATOR);
        return r2;
    }

    /* JADX INFO: renamed from: lambda$getCoalescedUsageList$0$com-bytedanceos-batteryusage-BatteryUsageStatsHelper, reason: not valid java name */
    /* synthetic */ int m85x87d855e7(UidBatteryConsumer r2) {
        if (r2.getUid() != getRealUid(r2)) goto L5;
        return 0;
    L5:
        return 1;
    }

    private int getRealUid(UidBatteryConsumer consumer) {
        int r1 = consumer.getUid();
        if (isSharedGid(consumer.getUid()) == false) goto L6;
        r1 = UserHandle.getUid(0, UserHandle.getAppIdFromSharedAppGid(consumer.getUid()));
    L6:
        if (isSystemUid(r1) == true) goto L8;
        return r1;
    L8:
        if (MEDIASERVER_PACKAGE_NAME.equals(consumer.getPackageWithHighestDrain()) == true) goto L12;
        return 1000;
    L12:
        return r1;
    }

    private static boolean isSharedGid(int uid) {
        if (UserHandle.getAppIdFromSharedAppGid(uid) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isSystemUid(int uid) {
        int r1 = UserHandle.getAppId(uid);
        if (r1 >= 1000) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 10000) goto L7;
        return true;
    }

    private boolean shouldHideUidBatteryConsumer(UidBatteryConsumer consumer, String[] packages) {
        if (isTypeSystem(consumer.getUid(), packages) == false) goto L5;
    L8:
        return true;
    L5:
        if (shouldHideUidBatteryConsumerUnconditionally(consumer, packages) == true) goto L8;
        return false;
    }

    private boolean shouldHideUidBatteryConsumerUnconditionally(UidBatteryConsumer consumer, String[] packages) {
        int r3 = consumer.getUid();
        if (r3 == (-5)) goto L11;
        if (r3 >= 0) goto L7;
    L8:
        return true;
    L7:
        if (isHiddenSystemModule(packages) == true) goto L8;
        return false;
    L11:
        return false;
    }

    private boolean isHiddenSystemModule(String[] packages) {
        if (packages == null) goto L17;
        HashMap r1 = new HashMap();
        Iterator<ModuleInfo> r4 = this.mPackageManager.getInstalledModules(0).iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        ModuleInfo r2 = r4.next();
        r1.put(r2.getPackageName(), Boolean.valueOf(r2.isHidden()));
        goto L6
    L8:
        int r5 = packages.length;
        int r3 = 0;
    L9:
        if (r3 >= r5) goto L17;
        if (r1.containsKey(packages[r3]) == false) goto L16;
        if (((Boolean) r1.get(packages)).booleanValue() == false) goto L16;
        return true;
    L16:
        r3 = r3 + 1;
    L17:
        return false;
    }

    private boolean isTypeSystem(int uid, String[] packages) {
        if (uid < 0) goto L8;
        if (uid >= 10000) goto L8;
        return true;
    L8:
        if (packages == null) goto L15;
        int r0 = packages.length;
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L15;
        if (ArrayUtils.contains(PACKAGES_SYSTEM, packages[r1]) == true) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        return true;
    L15:
        return false;
    }
}
