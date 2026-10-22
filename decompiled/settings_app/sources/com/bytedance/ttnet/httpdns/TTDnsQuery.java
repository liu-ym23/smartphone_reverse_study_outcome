package com.bytedance.ttnet.httpdns;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public class TTDnsQuery {
    private Map<String, String> controlHeaders;
    private String host;
    private CountDownLatch latch;
    private TTDnsResult result;
    private int sdkId;
    private String uuid;

    TTDnsQuery(String r1, int r2, Map<String, String> r3) {
        this.host = r1;
        this.sdkId = r2;
        this.controlHeaders = r3;
        this.uuid = UUID.randomUUID().toString();
        this.latch = new CountDownLatch(1);
    }

    public String host() {
        return this.host;
    }

    public int sdkId() {
        return this.sdkId;
    }

    public String uuid() {
        return this.uuid;
    }

    public void await() throws InterruptedException {
        this.latch.await();
    }

    public void resume() {
        this.latch.countDown();
    }

    public TTDnsResult result() {
        return this.result;
    }

    public void setResult(TTDnsResult r1) {
        this.result = r1;
    }

    public void doQuery() throws Exception {
        SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext()).ttDnsResolve(this.host, this.sdkId, this.uuid, this.controlHeaders);
    }
}
