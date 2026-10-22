package com.bytedance.frameworks.baselib.network.http;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RequestRetryResult {
    private Map<String, String> mAddRequestHeaders;
    private boolean mRemoveHitResponseHeaderIfNotRetry;
    private boolean mRequestRetryEnabled;

    public RequestRetryResult(boolean r2, Map<String, String> r3) {
        this.mRemoveHitResponseHeaderIfNotRetry = true;
        this.mRequestRetryEnabled = r2;
        this.mAddRequestHeaders = r3;
    }

    public RequestRetryResult(boolean r2) {
        this.mRemoveHitResponseHeaderIfNotRetry = true;
        this.mRequestRetryEnabled = r2;
    }

    public RequestRetryResult(boolean r1, boolean r2, Map<String, String> r3) {
        this.mRequestRetryEnabled = r1;
        this.mRemoveHitResponseHeaderIfNotRetry = r2;
        this.mAddRequestHeaders = r3;
    }

    public boolean isRequestRetryEnabled() {
        return this.mRequestRetryEnabled;
    }

    public void setRequestRetryEnabled(boolean r1) {
        this.mRequestRetryEnabled = r1;
    }

    public boolean isRemoveHitResponseHeaderIfNotRetry() {
        return this.mRemoveHitResponseHeaderIfNotRetry;
    }

    public void setRemoveHitResponseHeaderIfNotRetry(boolean r1) {
        this.mRemoveHitResponseHeaderIfNotRetry = r1;
    }

    public Map<String, String> getAddRequestHeaders() {
        return this.mAddRequestHeaders;
    }

    public void setAddRequestHeaders(Map<String, String> r1) {
        this.mAddRequestHeaders = r1;
    }
}
