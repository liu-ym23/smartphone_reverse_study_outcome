package com.bytedance.bdlocation.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.g;
import com.google.gson.m;
import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class ShakeUploadInfo {

    @c("ble_info_list")
    public g bleInfo;

    @c("busi_name")
    public String busiName;

    @c(WsConstants.KEY_EXTRA)
    public m extra;

    @c("gps_info")
    public LocationInfo locationInfo;

    @c("subdivision_id")
    public long subdivisionId;

    @c("timestamp")
    public long timeStamp;

    @c("wifi_info_list")
    public g wifiInfo;

    public ShakeUploadInfo() {
    }
}
