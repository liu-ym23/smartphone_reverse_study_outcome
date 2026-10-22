package com.android.settings.fuelgauge;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class BatterySipperInDB implements Comparable<BatterySipperInDB> {
    public long bluetoothRunningTimeMs;
    public long cameraTimeMs;
    public long cpuFgTimeMs;
    public long cpuTimeMs;
    String drainType;
    public long flashlightTimeMs;
    public long gpsTimeMs;
    String name;
    String packageName;
    int uid;
    double value;
    public long wakeLockTimeMs;
    public long wifiRunningTimeMs;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BatterySipperInDB r1) {
        return compareTo2(r1);
    }

    public BatterySipperInDB(Cursor r3) {
        this.value = r3.getDouble(0);
        this.cpuTimeMs = r3.getLong(1);
        this.gpsTimeMs = r3.getLong(2);
        this.wifiRunningTimeMs = r3.getLong(3);
        this.cpuFgTimeMs = r3.getLong(4);
        this.wakeLockTimeMs = r3.getLong(5);
        this.cameraTimeMs = r3.getLong(6);
        this.flashlightTimeMs = r3.getLong(7);
        this.bluetoothRunningTimeMs = r3.getLong(8);
        this.drainType = r3.getString(r3.getColumnIndex("drainType"));
        this.uid = r3.getInt(r3.getColumnIndex("uid"));
        this.name = r3.getString(r3.getColumnIndex("name"));
        this.packageName = r3.getString(r3.getColumnIndex("package_name"));
    }

    public String toString() {
        return "uid=" + this.uid + ",name=" + this.name + ",packageName=" + this.packageName + ",deltaCpuTimeMs=" + this.cpuTimeMs + ",deltaGpsTimeMs=" + this.gpsTimeMs + ",deltaWifiRunningTimeMs=" + this.wifiRunningTimeMs + ",deltaCpuFgTimeMs=" + this.cpuFgTimeMs + ",deltaWakeLockTimeMs=" + this.wakeLockTimeMs + ",deltaCameraTimeMs=" + this.cameraTimeMs + ",deltaFlashlightTimeMs=" + this.flashlightTimeMs + ",deltaBluetoothRunningTimeMs=" + this.bluetoothRunningTimeMs + ",deltaTotalPowerMah=" + this.value;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BatterySipperInDB r3) {
        return Double.compare(r3.value, this.value);
    }
}
