package com.bytedance.bdlocation.network.model;

import androidx.annotation.NonNull;
import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class WifiInfo implements Comparable<WifiInfo> {

    @c("frequency")
    public long frequency;

    @c("is_current")
    public int isCurrent;

    @c("rssi")
    public long rssi;

    @c("Timestamp")
    public long timeStamp;

    @c("wifi_mac")
    public String wifiMac;

    @c("wifi_name")
    public String wifiName;

    public WifiInfo() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull WifiInfo r3) {
        return Long.compare(r3.rssi, this.rssi);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull WifiInfo r1) {
        return compareTo2(r1);
    }
}
