package com.bytedance.ttnet.httpdns;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class TTDnsQuery {
    private Map<String, String> controlHeaders;
    private String host;
    private CountDownLatch latch;
    private TTDnsResult result;
    private int sdkId;
    private String uuid;

    public TTDnsQuery(String r1, int r2, Map<String, String> r3) {
        this.host = r1;
        this.sdkId = r2;
        this.controlHeaders = r3;
        this.uuid = UUID.randomUUID().toString();
        this.latch = new CountDownLatch(1);
    }

    public void await() {
        this.latch.await();
    }

    public void doQuery() {
        SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext()).ttDnsResolve(this.host, this.sdkId, this.uuid, this.controlHeaders);
    }

    public String host() {
        return this.host;
    }

    public TTDnsResult result() {
        return this.result;
    }

    public void resume() {
        this.latch.countDown();
    }

    public int sdkId() {
        return this.sdkId;
    }

    public void setResult(TTDnsResult r1) {
        this.result = r1;
    }

    public String uuid() {
        return this.uuid;
    }
}
