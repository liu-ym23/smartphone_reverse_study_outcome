package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
class RedirectInfo {
    int mCode;
    boolean mInternal;
    String mMethod;
    String mUrl;

    public RedirectInfo() {
        this.mCode = -1;
        this.mMethod = "";
        this.mUrl = "";
        this.mInternal = false;
    }
}
