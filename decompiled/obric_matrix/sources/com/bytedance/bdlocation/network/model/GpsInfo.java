package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class GpsInfo {

    @c("address")
    public String address;

    @c("city")
    public String city;

    @c("coordinateSystem")
    public String coordinateSystem;

    @c("country")
    public String country;

    @c("district")
    public String district;

    @c("latitude")
    public double latitude;

    @c("loc_time")
    public long locationTime;

    @c("longitude")
    public double longitude;

    @c("provider")
    public String provider;

    @c("province")
    public String province;

    @c("source")
    public int source;

    public GpsInfo() {
    }
}
