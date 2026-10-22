package com.bytedance.apm.perf;

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

        public CpuItem injectScene(String r1) {
            this.sceneString = r1;
            return this;
        }

        private CpuItem injectTags(Map<String, String> r1) {
            this.tagMap = r1;
            return this;
        }

        public String toString() {
            return "CpuItem{service='" + this.service + "', metricRate=" + this.metricRate + ", metricMaxRate=" + this.metricMaxRate + ", metricCpuStats=" + this.metricCpuStats + ", metricMaxCpuStats=" + this.metricMaxCpuStats + ", sceneString='" + this.sceneString + "', tagMap=" + this.tagMap + ", firstTs=" + this.firstTs + ", times=" + this.times + '}';
        }
    }

    private static class Holder {
        private static final DataAggregator sInstance = null;

        private Holder() {
        }

        static /* synthetic */ DataAggregator access$000() {
            return sInstance;
        }

        static {
            sInstance = new DataAggregator();
        }
    }

    private void sendData(String r1, double r2, double r4, double r6, double r8) {
    }

    public void init() {
    }

    public DataAggregator() {
        this.mTimerInfo = new HashMap();
    }

    public static DataAggregator getInstance() {
        return Holder.access$000();
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
        r1.metricCpuStats += r20;
        r1.metricRate += r16;
        if (r1.metricRate >= r16) goto L9;
        r1.metricRate = r16;
    L9:
        if (r1.metricCpuStats >= r20) goto L11;
        r1.metricCpuStats = r20;
    L11:
        this.mTimerInfo.put(r13, r1);
    }

    public void handleCpuTimer(long r22) {
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L20
        HashMap<String, CpuItem> r13 = this.mTimerInfo;     // Catch: Exception -> L20
        monitor-enter(r13);     // Catch: Exception -> L20
    L17:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L6:
        if (this.mTimerInfo.isEmpty() == true) goto L15;
        Iterator<Map.Entry<String, CpuItem>> r14 = this.mTimerInfo.entrySet().iterator();     // Catch: Throwable -> L17
    L9:
        if (r14.hasNext() == false) goto L15;
        CpuItem r1 = r14.next().getValue();     // Catch: Throwable -> L17
        Logger.d("CpuApm2", new String[]{"cache data: " + r1});     // Catch: Throwable -> L17
        if ((r11 - r1.firstTs) <= r22) goto L14;
        r14.remove();     // Catch: Throwable -> L17
        double r4 = r1.metricRate / ((double) r1.times);     // Catch: Throwable -> L17
        double r7 = r1.metricMaxRate / ((double) r1.times);     // Catch: Throwable -> L17
        double r8 = r1.metricCpuStats / ((double) r1.times);     // Catch: Throwable -> L17
        double r9 = r1.metricMaxCpuStats / ((double) r1.times);     // Catch: Throwable -> L17
        Logger.d("CpuApm2", new String[]{"assemble cpu data, rate: " + r4 + " maxRate: " + r7 + " speed: " + r8 + " maxSpeed: " + r9});     // Catch: Throwable -> L17
        sendData(r1.sceneString, r4, r7, r8, r9);     // Catch: Throwable -> L17
    L14:
        r11 = r11;
    L15:
        monitor-exit(r13);     // Catch: Throwable -> L17
    L29:
        return;
    L20:
        e = move-exception;
        Log.e(TAG, "handleLogToQueue function failed :" + e.toString());
    }
}
