package com.bytedance.bdlocation.network.response;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class LocationResp {

    @c("data")
    public String data;

    @c("err_no")
    public int resultCode;

    @c(LocationMonitorConst.ERR_MSG)
    public String resultMsg;

    @c("err_tip")
    public String resultTip;
    public String submitLogId;

    public LocationResp() {
    }

    public String toString() {
        return "LocationResp{resultCode=" + this.resultCode + ", resultMsg='" + this.resultMsg + "', resultTip='" + this.resultTip + "', data='" + this.data + "', submitLogId='" + this.submitLogId + "'}";
    }
}
