package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class RegionCountry {

    @c("ASCIName")
    public String asciName;

    @c("Code")
    public String code;

    @c("GeoNameID")
    public String geoNameID;

    @c("Name")
    public String name;

    public RegionCountry() {
    }

    public String toString() {
        return "RegionCountry{code='" + this.code + "', geoNameID=" + this.geoNameID + ", asciName='" + this.asciName + "', name='" + this.name + "'}";
    }
}
