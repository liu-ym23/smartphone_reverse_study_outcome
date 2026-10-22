package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes3.dex */
class ServerTimingInfo {
    boolean mCdnHitCache;
    long mEdge;
    long mInner;
    long mOrigin;
    boolean mPassedCdn;
    long mRtt;

    ServerTimingInfo() {
        this.mPassedCdn = false;
        this.mCdnHitCache = false;
        this.mEdge = -1;
        this.mOrigin = -1;
        this.mInner = -1;
        this.mRtt = -1;
    }
}
