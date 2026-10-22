package com.bytedance.apm.perf.traffic;

/* JADX INFO: loaded from: classes.dex */
public class TrafficUsageModel implements Comparable {
    public String clientType;
    public String path;
    public int requestCount;
    public long requestTs;
    public long trafficBytes;

    public TrafficUsageModel(String r1, long r2, String r4) {
        this.path = r1;
        this.trafficBytes = r2;
        this.requestTs = System.currentTimeMillis();
        this.requestCount = 1;
        this.clientType = r4;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r4) {
        long r0 = this.trafficBytes;
        long r3 = ((TrafficUsageModel) r4).trafficBytes;
        if (r0 != r3) goto L7;
        return 0;
    L7:
        if (r0 <= r3) goto L10;
        return 1;
    L10:
        return -1;
    }
}
