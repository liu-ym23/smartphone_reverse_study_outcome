package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class PlaceInfo {

    @c("ASCIName")
    public String asciName;

    @c("Code")
    public String code;

    @c("GeoNameID")
    public long geoNameID;

    @c("LocalID")
    public String localID;

    @c("MetropolitanCode")
    public String metropolitanCode;

    @c("Name")
    public String name;

    public PlaceInfo() {
    }

    public String toString() {
        return "PlaceInfo{code='" + this.code + "', geoNameID=" + this.geoNameID + ", asciName='" + this.asciName + "', name='" + this.name + "', localID='" + this.localID + "', metropolitanCode='" + this.metropolitanCode + "'}";
    }
}
