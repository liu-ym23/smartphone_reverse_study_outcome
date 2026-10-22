package com.bytedance.bdlocation.network.model;

import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class DeviceStatus {

    @c("is_bluetooth_open")
    public boolean bluetoothSwitch;

    @c("device_type")
    public int deviceType;

    @c("is_strict_restricted_mode")
    public boolean isStrictRestrictedMode;

    @c(LocationMonitorConst.IS_WIFI_CACHE)
    public String isWifiCache;

    @c(LocationMonitorConst.IS_WIFI_OPEN)
    public boolean isWifiOpen;

    @c("system_language")
    public String language;

    @c("locale")
    public String locale;

    @c(LocationMonitorConst.LOCATION_MODE)
    public int locationMode;

    @c("mccmnc")
    public String mccmnc;

    @c("permission")
    public int permission;

    @c("system_region")
    public String region;

    @c("restricted_mode")
    public int restrictedMode;

    public DeviceStatus() {
        this.isWifiCache = EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
