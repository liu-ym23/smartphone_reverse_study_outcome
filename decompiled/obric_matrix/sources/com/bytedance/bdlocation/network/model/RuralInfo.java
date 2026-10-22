package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class RuralInfo {

    @c("ASCIName")
    public String asciName;

    @c("Code")
    public String code;

    @c("GeoNameID")
    public long geoNameID;

    @c("LocalID")
    public String localID;

    @c("Name")
    public String name;

    public RuralInfo() {
    }

    public String toString() {
        return "Town{code=" + this.code + "', geoNameID='" + this.geoNameID + "', asciName='" + this.asciName + "', name='" + this.name + "', localID='" + this.localID + "'}";
    }
}
