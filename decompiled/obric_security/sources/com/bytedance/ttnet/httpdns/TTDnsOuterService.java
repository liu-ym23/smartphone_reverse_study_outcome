package com.bytedance.ttnet.httpdns;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TTDnsOuterService {
    private static TTDnsOuterService sInstance;
    private Map<String, TTDnsQuery> queryMap;

    public TTDnsOuterService() {
        this.queryMap = new ConcurrentHashMap();
    }

    public static synchronized TTDnsOuterService getInstance() {
        monitor-enter(TTDnsOuterService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new TTDnsOuterService();     // Catch: Throwable -> L10
    L7:
        TTDnsOuterService r1 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(TTDnsOuterService.class);
        return r1;
    }

    public TTDnsResult TTDnsResolve(String r2, int r3, Map<String, String> r4) throws Exception {
        TTDnsQuery r0 = new TTDnsQuery(r2, r3, r4);
        this.queryMap.put(r0.uuid(), r0);
        r0.doQuery();
        r0.await();
        this.queryMap.remove(r0.uuid());
        return r0.result();
    }

    public void HandleHttpdnsResult(String r8, String r9, int r10, int r11, int r12, List<String> r13, String r14) {
        TTDnsQuery r15 = this.queryMap.get(r8);
        if (r15 == null) goto L6;
        r15.setResult(new TTDnsResult(r10, r11, r12, r13, r14));
        r15.resume();
        this.queryMap.remove(r8);
        return;
    }
}
