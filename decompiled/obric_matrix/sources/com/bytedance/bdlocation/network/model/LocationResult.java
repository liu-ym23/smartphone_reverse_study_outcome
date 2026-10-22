package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.entity.PoiInfoEntity;
import com.google.gson.m;
import com.google.gson.y.c;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationResult {

    @c("AoiInfos")
    public List<PoiInfoEntity> aoiList;

    @c("City")
    public PlaceInfo city;

    @c("Continent")
    public PlaceInfo continent;

    @c("Country")
    public PlaceInfo country;

    @c("District")
    public PlaceInfo district;

    @c("Extra")
    public m extra;

    @c("GPS")
    public GPSResult gps;

    @c("IsDisputed")
    public boolean isDisputed;

    @c("ISP")
    public String isp;

    @c("LocateMethod")
    public String locateMethod;

    @c("Place")
    public Place place;

    @c("PoiInfos")
    public List<PoiInfoEntity> poiList;

    @c("Subdivisions")
    public PlaceInfo[] subdivisions;

    @c("Timestamp")
    public String timestamp;

    @c("Town")
    public RuralInfo town;

    @c("Village")
    public RuralInfo village;

    public LocationResult() {
    }

    public String toString() {
        return "LocationResult{continent=" + this.continent + ", country=" + this.country + ", subdivisions=" + Arrays.toString(this.subdivisions) + ", city=" + this.city + ", district=" + this.district + ", place=" + this.place + ", gps=" + this.gps + ", isp='" + this.isp + "', locateMethod='" + this.locateMethod + "', isDisputed='" + this.isDisputed + "', timestamp='" + this.timestamp + "', town'" + this.town + "', PoiInfos'" + this.poiList + "', AoiInfos'" + this.aoiList + "'}";
    }
}
