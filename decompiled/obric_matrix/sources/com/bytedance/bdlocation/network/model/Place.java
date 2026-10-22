package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Place {

    @c("AddressLines")
    public List<String> addressLines;

    @c("AdminArea")
    public String adminArea;

    @c("AreasOfInterest")
    public List<String> areasOfInterest;

    @c("FeatureCode")
    public String featureCode;

    @c("GeoNameID")
    public String geoNameID;

    @c("Locality")
    public String locality;

    @c("Name")
    public String name;

    @c("PostalCode")
    public String postalCode;

    @c("SubAdminArea")
    public String subAdminArea;

    @c("SubLocality")
    public String subLocality;

    @c("SubThoroughfare")
    public String subThoroughfare;

    @c("TimeZone")
    public String timeZone;

    public Place() {
    }

    public String toString() {
        return "Place{addressLines=" + this.addressLines + ", adminArea='" + this.adminArea + "', name='" + this.name + "', areasOfInterest='" + this.areasOfInterest + "', subAdminArea='" + this.subAdminArea + "', locality='" + this.locality + "', subLocality='" + this.subLocality + "', subThoroughfare='" + this.subThoroughfare + "', postalCode='" + this.postalCode + "', featureCode='" + this.featureCode + "', geoNameID='" + this.geoNameID + "', timeZone='" + this.timeZone + "'}";
    }
}
