package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes.dex */
class RedirectInfo {
    int mCode;
    boolean mInternal;
    String mMethod;
    String mUrl;

    RedirectInfo() {
        this.mCode = -1;
        this.mMethod = "";
        this.mUrl = "";
        this.mInternal = false;
    }
}
