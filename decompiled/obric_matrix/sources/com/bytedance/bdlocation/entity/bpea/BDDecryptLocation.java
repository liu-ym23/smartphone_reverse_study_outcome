package com.bytedance.bdlocation.entity.bpea;

/* JADX INFO: loaded from: classes.dex */
public class BDDecryptLocation {
    private double mLatitude;
    private double mLongitude;

    public BDDecryptLocation(double r1, double r3) {
        this.mLatitude = r1;
        this.mLongitude = r3;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setLatitude(double r1) {
        this.mLatitude = r1;
    }

    public void setLongitude(double r1) {
        this.mLongitude = r1;
    }
}
