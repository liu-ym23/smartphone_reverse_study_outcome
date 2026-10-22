package com.bytedanceos.os;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.BatteryStats;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseLongArray;
import com.android.internal.app.IBatteryStats;
import com.android.internal.util.ArrayUtils;
import com.obric.olog.OLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryStatsHelper {
    static final boolean DEBUG = false;
    private static final String TAG = null;
    private static Intent sBatteryBroadcastXfer;
    private static ArrayMap<File, BatteryStats> sFileXfer;
    private static BatteryStats sStatsXfer;
    private Intent mBatteryBroadcast;
    private IBatteryStats mBatteryInfo;
    long mBatteryRealtimeUs;
    long mBatteryTimeRemainingUs;
    long mBatteryUptimeUs;
    private final List<BatterySaver> mBluetoothSippers;
    long mChargeTimeRemainingUs;
    private final boolean mCollectBatteryBroadcast;
    private double mComputedPower;
    private final Context mContext;
    boolean mHasBluetoothPowerReporting;
    boolean mHasWifiPowerReporting;
    private double mMaxDrainedPower;
    private double mMaxPower;
    private double mMaxRealPower;
    private double mMinDrainedPower;
    private final List<BatterySaver> mMobilemsppList;
    private PackageManager mPackageManager;
    long mRawRealtimeUs;
    long mRawUptimeUs;
    private String[] mServicepackageArray;
    private BatteryStats mStats;
    private long mStatsPeriod;
    private int mStatsType;
    private String[] mSystemPackageArray;
    private double mTotalPower;
    long mTypeBatteryRealtimeUs;
    long mTypeBatteryUptimeUs;
    private final List<BatterySaver> mUsageList;
    private final SparseArray<List<BatterySaver>> mUserSippers;
    private final boolean mWifiOnly;
    private final List<BatterySaver> mWifiSippers;

    private void addAmbientDisplayUsage() {
    }

    private void addBluetoothUsage() {
    }

    private void addIdleUsage() {
    }

    private void addMemoryUsage() {
    }

    private void addPhoneUsage() {
    }

    private void addRadioUsage() {
    }

    private void addScreenUsage() {
    }

    private void addUserUsage() {
    }

    private void addWiFiUsage() {
    }

    private void aggregateSippers(BatterySaver bs, List<BatterySaver> from, String tag) {
    }

    private void load() {
    }

    private void processAppUsage(SparseArray<UserHandle> asUsers) {
    }

    private void processMiscUsage() {
    }

    public long convertMsToUs(long timeMs) {
        return timeMs * 1000;
    }

    public void refreshStats(int statsType, SparseArray<UserHandle> asUsers, long rawRealtimeUs, long rawUptimeUs) {
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("persist.sys.bshelper", 0) != 1) goto L5;
        r1 = true;
    L5:
        DEBUG = r1;
        TAG = "BatteryStatsHelper";
        sFileXfer = new ArrayMap();
    }

    public static boolean checkWifiOnly(Context context) {
        ConnectivityManager r1 = (ConnectivityManager) context.getSystemService("connectivity");
        if (r1 != null) goto L6;
        return false;
    L6:
        return !r1.isNetworkSupported(0);
    }

    public BatteryStatsHelper(Context context) {
        this(context, true);
    }

    public BatteryStatsHelper(Context context, boolean collectBatteryBroadcast) {
        this(context, collectBatteryBroadcast, checkWifiOnly(context.getApplicationContext()));
    }

    public BatteryStatsHelper(Context context, boolean collectBatteryBroadcast, boolean wifiOnly) {
        this.mUsageList = new ArrayList();
        this.mWifiSippers = new ArrayList();
        this.mBluetoothSippers = new ArrayList();
        this.mUserSippers = new SparseArray();
        this.mMobilemsppList = new ArrayList();
        this.mStatsType = 0;
        this.mStatsPeriod = 0;
        this.mMaxPower = 1.0d;
        this.mMaxRealPower = 1.0d;
        this.mHasWifiPowerReporting = false;
        this.mHasBluetoothPowerReporting = false;
        this.mContext = context;
        this.mCollectBatteryBroadcast = collectBatteryBroadcast;
        this.mWifiOnly = wifiOnly;
        this.mPackageManager = context.getPackageManager();
        Resources r4 = context.getResources();
        this.mSystemPackageArray = r4.getStringArray(R.array.config_cell_retries_per_error_code);
        this.mServicepackageArray = r4.getStringArray(R.array.config_cdma_international_roaming_indicators);
    }

    public void storeStatsHistoryInFile(String fname) {
        ArrayMap<File, BatteryStats> r0 = sFileXfer;
        monitor-enter(r0);
        File r4 = makeFilePath(this.mContext, fname);     // Catch: Throwable -> L25
        sFileXfer.put(r4, getStats());     // Catch: Throwable -> L25
        FileOutputStream r1 = new FileOutputStream(r4);     // Catch: Throwable -> L12 IOException -> L14
        r1.write(Parcel.obtain().marshall());     // Catch: IOException -> L10 Throwable -> L21
    L30:
        r1.close();     // Catch: IOException -> L28 Throwable -> L25
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L10:
        IOException e = e;
    L16:
        OLog.w(TAG, "Unable to write history to file", e);     // Catch: Throwable -> L21
        if (r1 == null) goto L19;
    L21:
        Throwable th = th;
    L22:
        if (r1 != null) goto L35;
    L24:
        throw th;     // Catch: Throwable -> L25
    L35:
        r1.close();     // Catch: IOException -> L29 Throwable -> L25
        goto L24
    L14:
        e = move-exception;
        r1 = null;
        e = e;
    L12:
        th = move-exception;
        r1 = null;
        th = th;
    L25:
        th = move-exception;
        throw th;
    }

    public static void dropFile(Context context, String fname) {
        makeFilePath(context, fname).delete();
    }

    private static File makeFilePath(Context context, String fname) {
        return new File(context.getFilesDir(), fname);
    }

    public void clearStats() {
        this.mStats = null;
    }

    public BatteryStats getStats() {
        if (this.mStats != null) goto L6;
        load();
    L6:
        return this.mStats;
    }

    public void create(Bundle icicle) {
        if (icicle == null) goto L4;
        this.mStats = sStatsXfer;
        this.mBatteryBroadcast = sBatteryBroadcastXfer;
    L4:
        this.mBatteryInfo = IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats"));
    }

    public void storeState() {
        sStatsXfer = this.mStats;
        sBatteryBroadcastXfer = this.mBatteryBroadcast;
    }

    public static String makemAh(double power) {
        if (power != 0.0d) goto L7;
        return "0";
    L7:
        if (power >= 1.0E-5d) goto L10;
        String r0 = "%.8f";
    L32:
        return String.format(Locale.ENGLISH, r0, new Object[]{Double.valueOf(power)});
    L10:
        if (power >= 1.0E-4d) goto L13;
        r0 = "%.7f";
        goto L32
    L13:
        if (power >= 0.001d) goto L16;
        r0 = "%.6f";
        goto L32
    L16:
        if (power >= 0.01d) goto L19;
        r0 = "%.5f";
        goto L32
    L19:
        if (power >= 0.1d) goto L22;
        r0 = "%.4f";
        goto L32
    L22:
        if (power >= 1.0d) goto L25;
        r0 = "%.3f";
        goto L32
    L25:
        if (power >= 10.0d) goto L28;
        r0 = "%.2f";
        goto L32
    L28:
        if (power >= 100.0d) goto L30;
        r0 = "%.1f";
        goto L32
    L30:
        r0 = "%.0f";
        goto L32
    }

    public void refreshStats(int statsType, int asUser) {
        SparseArray<UserHandle> r0 = new SparseArray(1);
        r0.put(asUser, new UserHandle(asUser));
        refreshStats(statsType, r0);
    }

    public void refreshStats(int statsType, List<UserHandle> asUsers) {
        int r0 = asUsers.size();
        SparseArray<UserHandle> r1 = new SparseArray(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        UserHandle r3 = asUsers.get(r2);
        r1.put(r3.getIdentifier(), r3);
        r2 = r2 + 1;
        goto L3
    L5:
        refreshStats(statsType, r1);
    }

    public void refreshStats(int statsType, SparseArray<UserHandle> asUsers) {
        refreshStats(statsType, asUsers, SystemClock.elapsedRealtime() * 1000, SystemClock.uptimeMillis() * 1000);
    }

    private BatterySaver addEntry(BatterySaver.DrainType drainType, long time, double power) {
        BatterySaver r0 = new BatterySaver(drainType, null, 0.0d);
        r0.powerUse = power;
        r0.usagetimems = time;
        r0.sumPower();
        this.mUsageList.add(r0);
        return r0;
    }

    public List<BatterySaver> getUsageList() {
        return this.mUsageList;
    }

    public List<BatterySaver> getMobilemsppList() {
        return this.mMobilemsppList;
    }

    public long getStatsPeriod() {
        return this.mStatsPeriod;
    }

    public int getStatsType() {
        return this.mStatsType;
    }

    public double getMaxPower() {
        return this.mMaxPower;
    }

    public double getMaxRealPower() {
        return this.mMaxRealPower;
    }

    public double getTotalPower() {
        return this.mTotalPower;
    }

    public double getComputedPower() {
        return this.mComputedPower;
    }

    public double getMinDrainedPower() {
        return this.mMinDrainedPower;
    }

    public double getMaxDrainedPower() {
        return this.mMaxDrainedPower;
    }

    public static byte[] readFully(FileInputStream stream) throws IOException {
        return readFully(stream, stream.available());
    }

    public static byte[] readFully(FileInputStream stream, int avail) throws IOException {
        byte[] r5 = new byte[avail];
        int r1 = 0;
    L3:
        int r2 = stream.read(r5, r1, r5.length - r1);
        if (r2 <= 0) goto L5;
        r1 = r1 + r2;
        int r3 = stream.available();
        if (r3 <= (r5.length - r1)) goto L3;
        byte[] r4 = new byte[r3 + r1];
        System.arraycopy(r5, 0, r4, 0, r1);
        r5 = r4;
        goto L3
    L5:
        return r5;
    }

    public double removeHiddenBatterySippers(List<BatterySaver> sippers) {
        int r0 = sippers.size() - 1;
        double r1 = 0.0d;
        BatterySaver r3 = null;
    L3:
        if (r0 < 0) goto L25;
        BatterySaver r4 = sippers.get(r0);
        r4.isHide = shouldHideSipper(r4);
        if (r4.isHide == false) goto L22;
        if (r4.drainType == BatterySaver.DrainType.OVERCOUNTED) goto L22;
        if (r4.drainType == BatterySaver.DrainType.SCREEN) goto L22;
        if (r4.drainType == BatterySaver.DrainType.AMBIENT_DISPLAY) goto L22;
        if (r4.drainType == BatterySaver.DrainType.UNACCOUNTED) goto L22;
        if (r4.drainType == BatterySaver.DrainType.BLUETOOTH) goto L22;
        if (r4.drainType == BatterySaver.DrainType.WIFI) goto L22;
        if (r4.drainType == BatterySaver.DrainType.IDLE) goto L22;
        r1 = r1 + r4.totalPowerUse;
    L22:
        if (r4.drainType != BatterySaver.DrainType.SCREEN) goto L24;
        r3 = r4;
    L24:
        r0 = r0 - 1;
        goto L3
    L25:
        smearScreenBatterySipper(sippers, r3);
        return r1;
    }

    public void smearScreenBatterySipper(List<BatterySaver> sippers, BatterySaver screenSipper) {
        SparseLongArray r2 = new SparseLongArray();
        int r3 = sippers.size();
        int r6 = 0;
        long r8 = 0;
        int r7 = 0;
    L3:
        if (r7 >= r3) goto L8;
        BatteryStats.Uid r10 = sippers.get(r7).uidObj;
        if (r10 == null) goto L7;
        long r12 = getProcessForegroundTimeMs(r10, 0);
        r2.put(r10.getUid(), r12);
        r8 = r8 + r12;
    L7:
        r7 = r7 + 1;
        goto L3
    L8:
        if (screenSipper != null) goto L10;
        return;
    L10:
        if (r8 < 600000) goto L19;
        double r11 = screenSipper.totalPowerUse;
        int r1 = sippers.size();
    L12:
        if (r6 >= r1) goto L20;
        BatterySaver r4 = sippers.get(r6);
        r4.screenPowerMah = (r2.get(r4.getUid(), 0) * r11) / r8;
        r6 = r6 + 1;
        goto L12
    L20:
        return;
    }

    public boolean shouldHideSipper(BatterySaver sipper) {
        BatterySaver.DrainType r0 = sipper.drainType;
        if (r0 != BatterySaver.DrainType.IDLE) goto L5;
    L20:
        return true;
    L5:
        if (r0 == BatterySaver.DrainType.CELL) goto L20;
        if (r0 == BatterySaver.DrainType.SCREEN) goto L20;
        if (r0 == BatterySaver.DrainType.AMBIENT_DISPLAY) goto L20;
        if (r0 == BatterySaver.DrainType.UNACCOUNTED) goto L20;
        if (r0 == BatterySaver.DrainType.OVERCOUNTED) goto L20;
        if (isTypeService(sipper) == true) goto L20;
        if (isTypeSystem(sipper) == true) goto L20;
        return false;
    }

    public boolean isTypeService(BatterySaver sipper) {
        String[] r6 = this.mPackageManager.getPackagesForUid(sipper.getUid());
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (ArrayUtils.contains(this.mServicepackageArray, r6[r2]) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public boolean isTypeSystem(BatterySaver sipper) {
        if (sipper.uidObj != null) goto L5;
        int r0 = -1;
    L6:
        sipper.mPackages = this.mPackageManager.getPackagesForUid(r0);
        if (r0 < 0) goto L12;
        if (r0 >= 10000) goto L12;
        return true;
    L12:
        if (sipper.mPackages == null) goto L19;
        String[] r7 = sipper.mPackages;
        int r1 = r7.length;
        int r3 = 0;
    L14:
        if (r3 >= r1) goto L19;
        if (ArrayUtils.contains(this.mSystemPackageArray, r7[r3]) == true) goto L17;
        r3 = r3 + 1;
        goto L14
    L17:
        return true;
    L19:
        return false;
    L5:
        r0 = sipper.getUid();
        goto L6
    }

    public long convertUsToMs(long timeUs) {
        return timeUs / 1000;
    }

    public long getForegroundActivityTotalTimeUs(BatteryStats.Uid uid, long rawRealtimeUs) {
        BatteryStats.Timer r0 = uid.getForegroundActivityTimer();
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getTotalTimeLocked(rawRealtimeUs, 0);
    }

    public long getProcessForegroundTimeMs(BatteryStats.Uid uid, int which) {
        long r0 = convertMsToUs(SystemClock.elapsedRealtime());
        return convertUsToMs(Math.min(0 + uid.getProcessStateTime(0, r0, which), getForegroundActivityTotalTimeUs(uid, r0)));
    }

    public void setPackageManager(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    public void setSystemPackageArray(String[] array) {
        this.mSystemPackageArray = array;
    }

    public void setServicePackageArray(String[] array) {
        this.mServicepackageArray = array;
    }
}
