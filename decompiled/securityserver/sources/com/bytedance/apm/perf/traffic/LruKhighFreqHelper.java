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

    public static class Holder {
        private static final LruKhighFreqHelper sInstance = null;

        static {
            sInstance = new LruKhighFreqHelper();
        }

        private Holder() {
        }

        public static /* synthetic */ LruKhighFreqHelper access$000() {
            return sInstance;
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

    public synchronized void add(long r16, String r18, String r19) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.usageStore != null) goto L10;
        this.usageStore = new HashMap();     // Catch: Throwable -> L7
    L10:
        if (this.usageStore.containsKey(r18) == false) goto L14;
        TrafficUsageModel r0 = this.usageStore.get(r18);     // Catch: Throwable -> L7
        r0.requestCount++;     // Catch: Throwable -> L7
        r0.requestTs = System.currentTimeMillis();     // Catch: Throwable -> L7
        int r1 = r0.requestCount;     // Catch: Throwable -> L7
        if (r1 <= this.maxFreq) goto L45;
        this.maxFreq = r1;     // Catch: Throwable -> L7
    L45:
        monitor-exit(this);
        return;
    L14:
        Map<String, TrafficUsageModel> r5 = this.history;     // Catch: Throwable -> L7
        if (r5 == null) goto L44;
        String r6 = null;
        long r7 = Long.MAX_VALUE;
        if (r5.containsKey(r18) == false) goto L34;
        TrafficUsageModel r2 = this.history.get(r18);     // Catch: Throwable -> L7
        int r3 = r2.requestCount;     // Catch: Throwable -> L7
        r2.requestCount = r3 + 1;     // Catch: Throwable -> L7
        r2.requestTs = System.currentTimeMillis();     // Catch: Throwable -> L7
        if (r3 <= this.historyFreqThreshold) goto L45;
        this.history.remove(r18);     // Catch: Throwable -> L7
        if (this.usageStore.size() < this.storeLimitSize) goto L32;
        long r4 = this.intervalStartTs + ((System.currentTimeMillis() - this.intervalStartTs) / 2);     // Catch: Throwable -> L7
        Iterator<Map.Entry<String, TrafficUsageModel>> r8 = this.usageStore.entrySet().iterator();     // Catch: Throwable -> L7
    L24:
        if (r8.hasNext() == false) goto L30;
        Map.Entry<String, TrafficUsageModel> r9 = r8.next();     // Catch: Throwable -> L7
        if (r9.getValue().requestTs >= r4) goto L24;
        if (r9.getValue().requestCount >= r7) goto L24;
        long r10 = r9.getValue().requestCount;     // Catch: Throwable -> L7
        r6 = r9.getValue().path;     // Catch: Throwable -> L7
        r7 = r10;
        goto L24
    L30:
        if (r6 == null) goto L32;
        this.usageStore.remove(r6);     // Catch: Throwable -> L7
    L32:
        this.usageStore.put(r18, r2);     // Catch: Throwable -> L7
        goto L45
    L34:
        if (this.history.size() < this.historyLimitSize) goto L43;
        Iterator<Map.Entry<String, TrafficUsageModel>> r11 = this.history.entrySet().iterator();     // Catch: Throwable -> L7
    L37:
        if (r11.hasNext() == false) goto L41;
        Map.Entry<String, TrafficUsageModel> r12 = r11.next();     // Catch: Throwable -> L7
        if (r12.getValue().requestTs >= r7) goto L37;
        long r13 = r12.getValue().requestTs;     // Catch: Throwable -> L7
        r6 = r12.getValue().path;     // Catch: Throwable -> L7
        r7 = r13;
        goto L37
    L41:
        if (r6 == null) goto L43;
        this.history.remove(r6);     // Catch: Throwable -> L7
    L43:
        this.history.put(r18, new TrafficUsageModel(r18, r16, r19));     // Catch: Throwable -> L7
        goto L45
    L44:
        HashMap r14 = new HashMap();     // Catch: Throwable -> L7
        this.history = r14;     // Catch: Throwable -> L7
        r14.put(r18, new TrafficUsageModel(r18, r16, r19));     // Catch: Throwable -> L7
        goto L45
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

    public void start() {
        this.intervalStartTs = System.currentTimeMillis();
    }
}
