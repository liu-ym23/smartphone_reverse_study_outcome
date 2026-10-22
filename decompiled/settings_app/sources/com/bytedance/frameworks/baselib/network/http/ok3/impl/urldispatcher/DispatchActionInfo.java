package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

/* JADX INFO: loaded from: classes3.dex */
public class DispatchActionInfo {
    public boolean mActionHit;
    public String mDispatchedUrl;
    public boolean mNeedFeedBack;
    public int mPriority;
    public long mRuleid;
    public String mServiceName;
    public int mStrategyType;

    public DispatchActionInfo() {
    }

    public DispatchActionInfo(String r1, long r2, int r4, boolean r5, int r6, boolean r7, String r8) {
        this.mServiceName = r1;
        this.mRuleid = r2;
        this.mPriority = r4;
        this.mActionHit = r5;
        this.mStrategyType = r6;
        this.mNeedFeedBack = r7;
        this.mDispatchedUrl = r8;
    }
}
