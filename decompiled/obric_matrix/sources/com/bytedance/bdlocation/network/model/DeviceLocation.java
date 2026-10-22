package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.sensor.LightInfo;
import com.google.gson.g;
import com.google.gson.y.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DeviceLocation {

    @c("base_station")
    public BaseStation baseLocation;

    @c("light_info_list")
    public List<LightInfo> lightInfoList;

    @c("sys_location")
    public LocationInfo sysLocation;

    @c("wifi_info_list")
    public g wifiInfo;

    public DeviceLocation() {
    }
}
