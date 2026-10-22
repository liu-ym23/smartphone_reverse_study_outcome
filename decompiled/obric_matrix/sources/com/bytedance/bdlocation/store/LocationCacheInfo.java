package com.bytedance.bdlocation.store;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;

/* JADX INFO: loaded from: classes.dex */
public class LocationCacheInfo {
    private BDLocation mLatestLocation;
    private BDLocation mMockLocation;

    public LocationCacheInfo() {
    }

    @Nullable
    public BDLocation getLatestLocation() {
        return this.mLatestLocation;
    }

    public BDLocation getMockLocation() {
        return this.mMockLocation;
    }

    public void setLatestLocation(BDLocation r1) {
        this.mLatestLocation = r1;
    }

    public void setMockLocation(BDLocation r1) {
        this.mMockLocation = r1;
    }

    public String toString() {
        return "LocationCacheInfo{, mLatestLocation=" + this.mLatestLocation + ", mMockLocation=" + this.mMockLocation + '}';
    }
}
