package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import com.bytedance.retrofit2.client.Header;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class URLRequest {
    private int mDispatchPriority;
    private final List<Header> mHeaders;
    private String mMethod;
    private String mOriginUrl;

    public URLRequest(String r1, String r2) {
        this.mOriginUrl = r1;
        this.mMethod = r2;
        this.mDispatchPriority = 0;
        this.mHeaders = null;
    }

    public URLRequest(String r1, String r2, List<Header> r3) {
        this.mOriginUrl = r1;
        this.mMethod = r2;
        this.mDispatchPriority = 0;
        this.mHeaders = r3;
    }

    public void setMethod(String r1) {
        this.mMethod = r1;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public void setOriginUrl(String r1) {
        this.mOriginUrl = r1;
    }

    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    public void setDispatchPriority(int r1) {
        this.mDispatchPriority = r1;
    }

    public int getDispatchPriority() {
        return this.mDispatchPriority;
    }

    public List<Header> getHeaders() {
        return this.mHeaders;
    }
}
