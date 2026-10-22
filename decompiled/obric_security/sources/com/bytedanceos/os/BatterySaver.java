package com.bytedanceos.os;

import android.os.BatteryStats;
import com.obric.security.safecheckapi.CheckResult;

/* JADX INFO: loaded from: classes2.dex */
public class BatterySaver implements Comparable<BatterySaver> {
    public double audioPowerMah;
    public long audioUseTime;
    public double bluetoothPowerMah;
    public long bluetoothtime;
    public long btRxBytes;
    public long btTxBytes;
    public double cameraPowerMah;
    public long cameratime;
    public long cpuFgtime;
    public double cpuPowerMah;
    public long cputime;
    public DrainType drainType;
    public double flashlightPowerMah;
    public long flashtime;
    public double gpsPowerMah;
    public long gpstime;
    public boolean isHide;
    public String[] mPackages;
    public long mobileAct;
    public int mobileActCount;
    public double mobileRadioPowerMah;
    public long mobileRxBytes;
    public long mobileRxs;
    public long mobileTxBytes;
    public long mobileTxs;
    public double mobilemspp;
    public double noCoveragePercent;
    public String packageWithHighestDrain;
    public double percent;
    public double powerUse;
    public double proportionalSmearMah;
    public double screenPowerMah;
    public double sensorPowerMah;
    public double totalPowerUse;
    public double totalSmearedPowerMah;
    public BatteryStats.Uid uidObj;
    public long usagetimems;
    public int userId;
    public double videoPowerMah;
    public long videotime;
    public double wakeLockPowerMah;
    public long wakelocktime;
    public double wifiPowerMah;
    public long wifiRxBytes;
    public long wifiRxs;
    public long wifiTxBytes;
    public long wifiTxs;
    public long wifitime;

    public static final enum DrainType extends Enum<DrainType> {
        private static final /* synthetic */ DrainType[] $VALUES = null;
        public static final DrainType AMBIENT_DISPLAY = null;
        public static final DrainType APP = null;
        public static final DrainType BLUETOOTH = null;
        public static final DrainType CAMERA = null;
        public static final DrainType CELL = null;
        public static final DrainType FLASHLIGHT = null;
        public static final DrainType IDLE = null;
        public static final DrainType MEMORY = null;
        public static final DrainType OVERCOUNTED = null;
        public static final DrainType PHONE = null;
        public static final DrainType SCREEN = null;
        public static final DrainType UNACCOUNTED = null;
        public static final DrainType USER = null;
        public static final DrainType WIFI = null;

        private static /* synthetic */ DrainType[] $values() {
            return new DrainType[]{AMBIENT_DISPLAY, APP, BLUETOOTH, CAMERA, CELL, FLASHLIGHT, IDLE, MEMORY, OVERCOUNTED, PHONE, SCREEN, UNACCOUNTED, USER, WIFI};
        }

        public static DrainType valueOf(String name) {
            return (DrainType) Enum.valueOf(DrainType.class, name);
        }

        public static DrainType[] values() {
            return (DrainType[]) $VALUES.clone();
        }

        static {
            AMBIENT_DISPLAY = new DrainType("AMBIENT_DISPLAY", 0);
            APP = new DrainType("APP", 1);
            BLUETOOTH = new DrainType("BLUETOOTH", 2);
            CAMERA = new DrainType("CAMERA", 3);
            CELL = new DrainType("CELL", 4);
            FLASHLIGHT = new DrainType("FLASHLIGHT", 5);
            IDLE = new DrainType("IDLE", 6);
            MEMORY = new DrainType("MEMORY", 7);
            OVERCOUNTED = new DrainType("OVERCOUNTED", 8);
            PHONE = new DrainType(CheckResult.TYPE_PHONE, 9);
            SCREEN = new DrainType("SCREEN", 10);
            UNACCOUNTED = new DrainType("UNACCOUNTED", 11);
            USER = new DrainType("USER", 12);
            WIFI = new DrainType("WIFI", 13);
            $VALUES = $values();
        }

        private DrainType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BatterySaver other) {
        return compareTo2(other);
    }

    public BatterySaver() {
    }

    public BatterySaver(DrainType drainType, BatteryStats.Uid uid, double value) {
        this.totalPowerUse = value;
        this.drainType = drainType;
        this.uidObj = uid;
    }

    public void computeMobilemspp() {
        long r0 = this.mobileRxs + this.mobileTxs;
        if (r0 <= 0) goto L5;
        double r2 = this.mobileAct / r0;
    L6:
        this.mobilemspp = r2;
        return;
    L5:
        r2 = 0.0d;
        goto L6
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BatterySaver other) {
        DrainType r0 = this.drainType;
        if (r0 == other.drainType) goto L13;
        if (r0 != DrainType.OVERCOUNTED) goto L9;
        return 1;
    L9:
        if (other.drainType != DrainType.OVERCOUNTED) goto L13;
        return -1;
    L13:
        return Double.compare(other.totalPowerUse, this.totalPowerUse);
    }

    public String[] getPackages() {
        return this.mPackages;
    }

    public int getUid() {
        BatteryStats.Uid r0 = this.uidObj;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getUid();
    }

    public void add(BatterySaver other) {
        this.totalPowerUse += other.totalPowerUse;
        this.usagetimems += other.usagetimems;
        this.powerUse += other.powerUse;
        this.audioUseTime += other.audioUseTime;
        this.cputime += other.cputime;
        this.gpstime += other.gpstime;
        this.wifitime += other.wifitime;
        this.cpuFgtime += other.cpuFgtime;
        this.videotime += other.videotime;
        this.wakelocktime += other.wakelocktime;
        this.cameratime += other.cameratime;
        this.flashtime += other.flashtime;
        this.bluetoothtime += other.bluetoothtime;
        this.mobileRxs += other.mobileRxs;
        this.mobileTxs += other.mobileTxs;
        this.mobileAct += other.mobileAct;
        this.mobileActCount += other.mobileActCount;
        this.wifiRxs += other.wifiRxs;
        this.wifiTxs += other.wifiTxs;
        this.mobileRxBytes += other.mobileRxBytes;
        this.mobileTxBytes += other.mobileTxBytes;
        this.wifiRxBytes += other.wifiRxBytes;
        this.wifiTxBytes += other.wifiTxBytes;
        this.btRxBytes += other.btRxBytes;
        this.btTxBytes += other.btTxBytes;
        this.audioPowerMah += other.audioPowerMah;
        this.wifiPowerMah += other.wifiPowerMah;
        this.gpsPowerMah += other.gpsPowerMah;
        this.cpuPowerMah += other.cpuPowerMah;
        this.sensorPowerMah += other.sensorPowerMah;
        this.mobileRadioPowerMah += other.mobileRadioPowerMah;
        this.wakeLockPowerMah += other.wakeLockPowerMah;
        this.cameraPowerMah += other.cameraPowerMah;
        this.flashlightPowerMah += other.flashlightPowerMah;
        this.bluetoothPowerMah += other.bluetoothPowerMah;
        this.screenPowerMah += other.screenPowerMah;
        this.videoPowerMah += other.videoPowerMah;
        this.proportionalSmearMah += other.proportionalSmearMah;
        this.totalSmearedPowerMah += other.totalSmearedPowerMah;
    }

    public double sumPower() {
        double r0 = ((((((((((this.powerUse + this.wifiPowerMah) + this.gpsPowerMah) + this.cpuPowerMah) + this.sensorPowerMah) + this.mobileRadioPowerMah) + this.wakeLockPowerMah) + this.cameraPowerMah) + this.flashlightPowerMah) + this.bluetoothPowerMah) + this.audioPowerMah) + this.videoPowerMah;
        this.totalPowerUse = r0;
        this.totalSmearedPowerMah = (this.screenPowerMah + r0) + this.proportionalSmearMah;
        return r0;
    }
}
