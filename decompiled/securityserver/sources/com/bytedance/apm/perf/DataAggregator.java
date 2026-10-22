package com.bytedance.apm.perf;

import a.a;
import android.util.Log;
import com.bytedance.apm.logging.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DataAggregator {
    private static final String TAG = "DataAggregator";
    private final HashMap<String, CpuItem> mTimerInfo;

    public static class CpuItem {
        long firstTs;
        double metricCpuStats;
        double metricMaxCpuStats;
        double metricMaxRate;
        double metricRate;
        String sceneString;
        String service;
        Map<String, String> tagMap;
        int times;

        public CpuItem(String r1, long r2, double r4, double r6, double r8, double r10) {
            this.service = r1;
            this.metricRate = r4;
            this.metricCpuStats = r8;
            this.metricMaxCpuStats = r10;
            this.firstTs = r2;
            this.times = 1;
        }

        private CpuItem injectTags(Map<String, String> r1) {
            this.tagMap = r1;
            return this;
        }

        public CpuItem injectScene(String r1) {
            this.sceneString = r1;
            return this;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("CpuItem{service='");
            r0.append(this.service);
            r0.append("', metricRate=");
            r0.append(this.metricRate);
            r0.append(", metricMaxRate=");
            r0.append(this.metricMaxRate);
            r0.append(", metricCpuStats=");
            r0.append(this.metricCpuStats);
            r0.append(", metricMaxCpuStats=");
            r0.append(this.metricMaxCpuStats);
            r0.append(", sceneString='");
            r0.append(this.sceneString);
            r0.append("', tagMap=");
            r0.append(this.tagMap);
            r0.append(", firstTs=");
            r0.append(this.firstTs);
            r0.append(", times=");
            return a.l(r0, this.times, '}');
        }
    }

    public static class Holder {
        private static final DataAggregator sInstance = null;

        static {
            sInstance = new DataAggregator();
        }

        private Holder() {
        }

        public static /* synthetic */ DataAggregator access$000() {
            return sInstance;
        }
    }

    public DataAggregator() {
        this.mTimerInfo = new HashMap();
    }

    public static DataAggregator getInstance() {
        return Holder.access$000();
    }

    private void sendData(String r1, double r2, double r4, double r6, double r8) {
    }

    public void enqueuePerfLog(double r16, double r18, double r20, double r22) {
        String r13 = PerfFilterManager.getInstance().getSceneString();
        CpuItem r1 = this.mTimerInfo.get(r13);
        if (r1 != null) goto L5;
        CpuItem r14 = new CpuItem("cpu", System.currentTimeMillis(), r16, r18, r20, r22);
        r14.injectScene(PerfFilterManager.getInstance().getSceneString());
        this.mTimerInfo.put(r13, r14);
        return;
    L5:
        r1.times++;
        double r2 = r1.metricCpuStats + r20;
        r1.metricCpuStats = r2;
        double r7 = r1.metricRate + r16;
        r1.metricRate = r7;
        if (r7 >= r16) goto L9;
        r1.metricRate = r16;
    L9:
        if (r2 >= r20) goto L11;
        r1.metricCpuStats = r20;
    L11:
        this.mTimerInfo.put(r13, r1);
    }

    public void handleCpuTimer(long r18) {
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L21
        HashMap<String, CpuItem> r13 = this.mTimerInfo;     // Catch: Exception -> L21
        monitor-enter(r13);     // Catch: Exception -> L21
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L6:
        if (this.mTimerInfo.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, CpuItem>> r14 = this.mTimerInfo.entrySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r14.hasNext() == false) goto L17;
        CpuItem r1 = r14.next().getValue();     // Catch: Throwable -> L13
        Logger.d("CpuApm2", new String[]{"cache data: " + r1});     // Catch: Throwable -> L13
        if ((r11 - r1.firstTs) <= r18) goto L16;
        r14.remove();     // Catch: Throwable -> L13
        double r2 = r1.metricRate;     // Catch: Throwable -> L13
        int r4 = r1.times;     // Catch: Throwable -> L13
        double r5 = r2 / ((double) r4);     // Catch: Throwable -> L13
        double r7 = r1.metricMaxRate / ((double) r4);     // Catch: Throwable -> L13
        double r9 = r1.metricCpuStats / ((double) r4);     // Catch: Throwable -> L13
        double r12 = r1.metricMaxCpuStats / ((double) r4);     // Catch: Throwable -> L13
        Logger.d("CpuApm2", new String[]{"assemble cpu data, rate: " + r5 + " maxRate: " + r7 + " speed: " + r9 + " maxSpeed: " + r12});     // Catch: Throwable -> L13
        sendData(r1.sceneString, r5, r7, r9, r12);     // Catch: Throwable -> L13
    L16:
        r11 = r11;
    L17:
        monitor-exit(r13);     // Catch: Throwable -> L13
    L31:
        return;
    L21:
        e = move-exception;
        Log.e(TAG, "handleLogToQueue function failed :" + e.toString());
    }

    public void init() {
    }
}
