package com.bytedance.bdlocation.entity.bpea;

/* JADX INFO: loaded from: classes.dex */
public class BDEncryptLocation {
    private String mLatitude;
    private String mLongitude;

    public BDEncryptLocation(String r1, String r2) {
        this.mLatitude = r1;
        this.mLongitude = r2;
    }

    public String getLatitude() {
        return this.mLatitude;
    }

    public String getLongitude() {
        return this.mLongitude;
    }

    public void setLatitude(String r1) {
        this.mLatitude = r1;
    }

    public void setLongitude(String r1) {
        this.mLongitude = r1;
    }
}
