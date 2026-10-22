package com.bytedance.bdlocation.scan.bluetooth;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BDBleInfo implements Comparable<BDBleInfo> {

    @com.google.gson.y.c("beacon_uuid")
    public String beaconUuid;

    @com.google.gson.y.c("ble_mac")
    public String bleMac;

    @com.google.gson.y.c("ble_name")
    public String bleName;

    @com.google.gson.y.c("is_beacon")
    public boolean isBeacon;

    @com.google.gson.y.c("major")
    public int major;

    @com.google.gson.y.c("minor")
    public int minor;

    @com.google.gson.y.c("beacon_data")
    public String rawData;

    @com.google.gson.y.c("rssi")
    public int rssi;

    @com.google.gson.y.c("timestamp")
    public long timeStamp;

    public BDBleInfo() {
        this.bleName = "";
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull BDBleInfo r3) {
        if (Boolean.compare(r3.isBeacon, this.isBeacon) != 0) goto L15;
        if (Boolean.compare(!TextUtils.isEmpty(r3.rawData), !TextUtils.isEmpty(this.rawData)) != 0) goto L13;
        int r0 = r3.rssi;
        int r1 = this.rssi;
        if (r0 != r1) goto L11;
        return Boolean.compare(!TextUtils.isEmpty(r3.bleName), !TextUtils.isEmpty(this.bleName));
    L11:
        return Long.compare(r0, r1);
    L13:
        return Boolean.compare(!TextUtils.isEmpty(r3.rawData), !TextUtils.isEmpty(this.rawData));
    L15:
        return Boolean.compare(r3.isBeacon, this.isBeacon);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull BDBleInfo r1) {
        return compareTo2(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L18;
        String r4 = this.bleMac;
        String r6 = ((BDBleInfo) r5).bleMac;
        if (r4 == r6) goto L19;
        if (r4 == null) goto L17;
        if (r4.equals(r6) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.bleMac});
    }

    public String toString() {
        return "BDBleInfo{bleName='" + this.bleName + "', bleMac='" + this.bleMac + "', major=" + this.major + ", minor=" + this.minor + ", beaconUuid='" + this.beaconUuid + "', rssi=" + this.rssi + ", isBeacon=" + this.isBeacon + ", rawData='" + this.rawData + "', timeStamp=" + this.timeStamp + '}';
    }
}
