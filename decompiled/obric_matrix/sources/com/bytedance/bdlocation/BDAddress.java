package com.bytedance.bdlocation;

import android.location.Address;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BDAddress extends Address {
    private float accuracy;
    private double altitude;
    private float horizontalAccuracy;
    private float speed;
    private float verticalAccuracy;

    BDAddress(Address r3) {
        super(r3.getLocale());
        setFeatureName(r3.getFeatureName());
        int r0 = 0;
    L4:
        if (r0 > r3.getMaxAddressLineIndex()) goto L6;
        setAddressLine(r0, r3.getAddressLine(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        setAdminArea(r3.getAdminArea());
        setSubAdminArea(r3.getSubAdminArea());
        setLocality(r3.getLocality());
        setSubLocality(r3.getSubLocality());
        setThoroughfare(r3.getThoroughfare());
        setSubThoroughfare(r3.getSubThoroughfare());
        setPremises(r3.getPremises());
        setPostalCode(r3.getPostalCode());
        setCountryCode(r3.getCountryCode());
        setCountryName(r3.getCountryName());
        setLatitude(r3.getLatitude());
        setLongitude(r3.getLongitude());
        setUrl(r3.getUrl());
        setExtras(r3.getExtras());
    }

    public BDAddress(Locale r1) {
        super(r1);
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getHorizontalAccuracy() {
        return this.horizontalAccuracy;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getVerticalAccuracy() {
        return this.verticalAccuracy;
    }

    public void setAccuracy(float r1) {
        this.accuracy = r1;
    }

    public void setAltitude(double r1) {
        this.altitude = r1;
    }

    public void setHorizontalAccuracy(float r1) {
        this.horizontalAccuracy = r1;
    }

    public void setSpeed(float r1) {
        this.speed = r1;
    }

    public void setVerticalAccuracy(float r1) {
        this.verticalAccuracy = r1;
    }

    @Override // android.location.Address
    public String toString() {
        return "BDAddress{speed=" + this.speed + ", accuracy=" + this.accuracy + ", altitude=" + this.altitude + ", verticalAccuracy=" + this.verticalAccuracy + ", horizontalAccuracy=" + this.horizontalAccuracy + ", addr= " + super.toString() + '}';
    }
}
