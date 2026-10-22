package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class BdLBSResult {

    @c("BaseResp")
    public BaseResp baseResp;

    @c("DeviceIdLocation")
    public LocationResult deviceIdLocation;

    @c("GPSLocation")
    public LocationResult gpsLocation;

    @c("IPLocation")
    public LocationResult ipLocation;

    @c("Location")
    public LocationResult location;

    @c("UserSelectedLocation")
    public LocationResult userSelectedLocation;

    public BdLBSResult() {
    }

    public String toString() {
        return "BdLBSResult{location=" + this.location + ", ipLocation=" + this.ipLocation + ", deviceIdLocation=" + this.deviceIdLocation + ", userSelectedLocation=" + this.userSelectedLocation + ", gpsLocation=" + this.gpsLocation + ", baseResp=" + this.baseResp + '}';
    }
}
