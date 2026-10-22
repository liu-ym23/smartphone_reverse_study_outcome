package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class GPSResult {

    @c("Accuracy")
    public String accuracy;

    @c("Altitude")
    public String altitude;

    @c("AltitudeAccurary")
    public String altitudeAccurary;

    @c("CoordinateSystem")
    public String coordinateSystem;

    @c("Latitude")
    public double latitude;

    @c("Source")
    public int locateType;

    @c("Longitude")
    public double longitude;

    @c("Timestamp")
    public String timestamp;

    public GPSResult() {
    }

    public String toString() {
        return "GPSResult{accuracy='" + this.accuracy + "', altitude='" + this.altitude + "', altitudeAccurary='" + this.altitudeAccurary + "', timestamp='" + this.timestamp + "', coordinateSystem='" + this.coordinateSystem + "', locateType='" + this.locateType + "'}";
    }
}
