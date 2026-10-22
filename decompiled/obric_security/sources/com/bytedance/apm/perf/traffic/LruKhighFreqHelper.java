package com.bytedance.apm.perf.traffic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LruKhighFreqHelper {
    public int highFreqThreshold;
    public Map<String, TrafficUsageModel> history;
    public int historyFreqThreshold;
    public int historyLimitSize;
    public long intervalStartTs;
    private int maxFreq;
    public int storeLimitSize;
    public Map<String, TrafficUsageModel> usageStore;

    private static class Holder {
        private static final LruKhighFreqHelper sInstance = null;

        private Holder() {
        }

        static /* synthetic */ LruKhighFreqHelper access$000() {
            return sInstance;
        }

        static {
            sInstance = new LruKhighFreqHelper();
        }
    }

    public LruKhighFreqHelper() {
        this.historyLimitSize = 50;
        this.storeLimitSize = 20;
        this.highFreqThreshold = 50;
        this.historyFreqThreshold = Math.min(3, 50 / 2);
        this.maxFreq = 0;
    }

    public static LruKhighFreqHelper getInstance() {
        return Holder.access$000();
    }

    public void start() {
        this.intervalStartTs = System.currentTimeMillis();
    }

    public void clear() {
        this.intervalStartTs = 0;
        this.maxFreq = 0;
        Map<String, TrafficUsageModel> r0 = this.history;
        if (r0 == null) goto L5;
        r0.clear();
        this.history = null;
    L5:
        Map<String, TrafficUsageModel> r1 = this.usageStore;
        if (r1 == null) goto L9;
        r1.clear();
        this.usageStore = null;
        return;
    }

    public synchronized void add(long r11, String r13, String r14) {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L4:
        if (this.usageStore != null) goto L7;
        this.usageStore = new HashMap();     // Catch: Throwable -> L44
    L7:
        if (this.usageStore.containsKey(r13) == false) goto L11;
        TrafficUsageModel r12 = this.usageStore.get(r13);     // Catch: Throwable -> L44
        r12.requestCount++;     // Catch: Throwable -> L44
        r12.requestTs = System.currentTimeMillis();     // Catch: Throwable -> L44
        if (r12.requestCount <= this.maxFreq) goto L42;
        this.maxFreq = r12.requestCount;     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return;
    L11:
        Map<String, TrafficUsageModel> r0 = this.history;     // Catch: Throwable -> L44
        if (r0 == null) goto L41;
        long r1 = Long.MAX_VALUE;
        String r3 = null;
        if (r0.containsKey(r13) == false) goto L31;
        TrafficUsageModel r15 = this.history.get(r13);     // Catch: Throwable -> L44
        int r16 = r15.requestCount;     // Catch: Throwable -> L44
        r15.requestCount = r16 + 1;     // Catch: Throwable -> L44
        r15.requestTs = System.currentTimeMillis();     // Catch: Throwable -> L44
        if (r16 <= this.historyFreqThreshold) goto L42;
        this.history.remove(r13);     // Catch: Throwable -> L44
        if (this.usageStore.size() < this.storeLimitSize) goto L29;
        long r4 = this.intervalStartTs + ((System.currentTimeMillis() - this.intervalStartTs) / 2);     // Catch: Throwable -> L44
        Iterator<Map.Entry<String, TrafficUsageModel>> r17 = this.usageStore.entrySet().iterator();     // Catch: Throwable -> L44
    L21:
        if (r17.hasNext() == false) goto L27;
        Map.Entry<String, TrafficUsageModel> r18 = r17.next();     // Catch: Throwable -> L44
        if (r18.getValue().requestTs >= r4) goto L21;
        if (r18.getValue().requestCount >= r1) goto L21;
        long r2 = r18.getValue().requestCount;     // Catch: Throwable -> L44
        r3 = r18.getValue().path;     // Catch: Throwable -> L44
        r1 = r2;
        goto L21
    L27:
        if (r3 == null) goto L29;
        this.usageStore.remove(r3);     // Catch: Throwable -> L44
    L29:
        this.usageStore.put(r13, r15);     // Catch: Throwable -> L44
        goto L42
    L31:
        if (this.history.size() < this.historyLimitSize) goto L40;
        Iterator<Map.Entry<String, TrafficUsageModel>> r5 = this.history.entrySet().iterator();     // Catch: Throwable -> L44
    L34:
        if (r5.hasNext() == false) goto L38;
        Map.Entry<String, TrafficUsageModel> r6 = r5.next();     // Catch: Throwable -> L44
        if (r6.getValue().requestTs >= r1) goto L34;
        r1 = r6.getValue().requestTs;     // Catch: Throwable -> L44
        r3 = r6.getValue().path;     // Catch: Throwable -> L44
        goto L34
    L38:
        if (r3 == null) goto L40;
        this.history.remove(r3);     // Catch: Throwable -> L44
    L40:
        this.history.put(r13, new TrafficUsageModel(r13, r11, r14));     // Catch: Throwable -> L44
        goto L42
    L41:
        HashMap r7 = new HashMap();     // Catch: Throwable -> L44
        this.history = r7;     // Catch: Throwable -> L44
        r7.put(r13, new TrafficUsageModel(r13, r11, r14));     // Catch: Throwable -> L44
        goto L42
    }

    public synchronized Map<String, TrafficUsageModel> getHighFreqMap() {
        monitor-enter(this);
        Map<String, TrafficUsageModel> r0 = this.usageStore;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int getMaxFreq() {
        return this.maxFreq;
    }
}
