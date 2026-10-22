package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class BaseResp {

    @c("StatusCode")
    public int statusCode;

    @c("StatusMessage")
    public String statusMessage;

    public BaseResp() {
    }

    public String toString() {
        return "BaseResp{statusMessage='" + this.statusMessage + "', statusCode=" + this.statusCode + '}';
    }
}
