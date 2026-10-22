package com.bytedance.bdlocation.scan.gps;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.y.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BDGpsInfo {

    @c(LocationMonitorConst.ACCURACY)
    public float accuracy;

    @c("altitude")
    public double altitude;

    @c("coordinate_system")
    public String coordinateSystem;

    @c("latitude")
    public double latitude;

    @c("log_id")
    public String logId;

    @c("longitude")
    public double longitude;

    @c("orientation")
    public float orientation;

    @c("provider")
    public String provider;

    @c("satellite_num")
    public int satelliteNum;

    @c("snr")
    public List<Float> snr;

    @c("speed")
    public float speed;

    @c("timestamp")
    public long timestamp;

    public BDGpsInfo() {
    }
}
