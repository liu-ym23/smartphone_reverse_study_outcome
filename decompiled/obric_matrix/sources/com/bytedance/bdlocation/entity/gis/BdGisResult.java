package com.bytedance.bdlocation.entity.gis;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.BaseResp;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class BdGisResult {

    @c("BaseResp")
    public BaseResp baseResp;

    @c("IsDisputed")
    public boolean isDisputed;

    @c(LocationMonitorConst.LOCATION)
    public LocationResult location;

    public BdGisResult() {
    }

    public String toString() {
        return "BdGisResult{location=" + this.location + ", isDisputed=" + this.isDisputed + ", baseResp=" + this.baseResp + '}';
    }
}
