package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class LocationInfo {

    @c(LocationMonitorConst.ACCURACY)
    public double accuracy;

    @c("address")
    public String address;

    @c("altitude")
    public double altitude;

    @c("altitude_accuracy")
    public double altitudeAccuracy;

    @c("building_id")
    public String buildingId;

    @c("city")
    public String city;

    @c("coordinate_system")
    public String coordinateSystem;

    @c("country")
    public String country;

    @c("district")
    public String district;

    @c(WsConstants.KEY_EXTRA)
    public String extra;

    @c("floor")
    public String floor;

    @c("is_mock")
    public boolean isMock;

    @c("latitude")
    public double latitude;

    @c(LocationMonitorConst.LOCATE_TYPE)
    public int locateType;

    @c("longitude")
    public double longitude;

    @c("provider")
    public String provider;

    @c("province")
    public String province;

    @c("street")
    public String street;

    @c("street_num")
    public String streetNum;

    @c("timestamp")
    public long timestamp;

    public LocationInfo() {
    }
}
