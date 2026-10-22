package com.bytedance.monitor.collector;

import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.constant.TraceStatsConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BinderMonitor extends AbsMonitor {
    private static final int MAX_INFO_SIZE = 200;
    private static final Object copyLock = null;
    private static final List<BinderInfo> sBinderInfoList = null;
    private static volatile int sPos;

    public static class BinderInfo {
        long begin;
        StackTraceElement[] elements;
        long end;
        long parcelSize;

        public BinderInfo() {
        }

        public long getBegin() {
            return this.begin;
        }

        public long getEnd() {
            return this.end;
        }

        public StackTraceElement[] getElements() {
            return this.elements;
        }

        public String toString() {
            return "{\"start\":" + this.begin + ",\"end\":" + this.end + ",\"parcel_size\":" + this.parcelSize + ",\"cost_millis\":" + (this.end - this.begin) + ",\"java_stack\":\"" + Util.stackToStringWithESC(BinderMonitor.access$000(this.elements)) + "\"}";
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    protected void updateConfig(int r1) {
    }

    static /* synthetic */ StackTraceElement[] access$000(StackTraceElement[] r0) {
        return removeUselessStackTrace(r0);
    }

    static {
        sBinderInfoList = new ArrayList(200);
        copyLock = new Object();
        sPos = 0;
    }

    BinderMonitor(int r2) {
        super(r2, MonitorType.BINDER_MONITOR);
    }

    void enable() {
        MonitorJni.enableBinderHook();
    }

    void disable() {
        MonitorJni.disableBinderHook();
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair<String, String> dumpInfo() {
        return new Pair(this.mCollectorType, sBinderInfoList.toString());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair<String, String> dumpInfosRange(long r3, long r5) {
        return new Pair(this.mCollectorType, dumpBinderInfo(r3, r5));
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    void dumpInfosToALog(long r4, long r6, long r8) {
        IHyperMonitor.ILogInstance r0 = PerfMonitorManager.getInstance().getLogInstance();
        if (r0 == null) goto L6;
        String r1 = "perf" + this.mCollectorType;
        r0.i(r1, "begin");
        r0.i(r1, dumpBinderInfo(r4 - r8, r6));
        r0.i(r1, TraceStatsConsts.STATS_KEY_END);
        return;
    }

    private String dumpBinderInfo(long r6, long r8) {
        List<BinderInfo> r5 = getBinderInfoListCopy();
        ArrayList r0 = new ArrayList();
        int r1 = r5.size() - 1;
    L3:
        if (r1 < 0) goto L14;
        BinderInfo r2 = r5.get(r1);
        if (r2.begin <= r8) goto L7;
    L8:
        r0.add(r2);
    L10:
        if (r2.end < r6) goto L14;
        r1 = r1 - 1;
        goto L3
    L7:
        if (r2.end <= r6) goto L10;
    L14:
        return r0.toString();
    }

    public List<BinderInfo> getBinderInfoListCopy() {
        ArrayList r6 = new ArrayList();
        Object r0 = copyLock;
        monitor-enter(r0);
        int r1 = 0;
    L6:
        if (r1 >= 200) goto L10;
        int r3 = ((sPos - 1) + r1) % 200;     // Catch: Throwable -> L12
        List<BinderInfo> r4 = sBinderInfoList;     // Catch: Throwable -> L12
        if (r3 >= r4.size()) goto L10;
        r6.add(r4.get(((sPos - 1) + r1) % 200));     // Catch: Throwable -> L12
        r1 = r1 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    }

    public static void saveBinderInfo(long r8, long r10, long r12) {
        addBinderInfo(r8, r10, r12, Thread.currentThread().getStackTrace());
    }

    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    private static void addBinderInfo(long r4, long r6, long r8, StackTraceElement[] r10) {
        Object r0 = copyLock;
        monitor-enter(r0);
        List<BinderInfo> r1 = sBinderInfoList;     // Catch: Throwable -> L11
        if (r1.size() != 200) goto L7;
        BinderInfo r2 = r1.get(sPos % 200);     // Catch: Throwable -> L11
        r2.begin = r4;     // Catch: Throwable -> L11
        r2.end = r6;     // Catch: Throwable -> L11
        r2.parcelSize = r8;     // Catch: Throwable -> L11
        r2.elements = r10;     // Catch: Throwable -> L11
    L8:
        sPos++;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        BinderInfo r3 = new BinderInfo();     // Catch: Throwable -> L11
        r3.begin = r4;     // Catch: Throwable -> L11
        r3.end = r6;     // Catch: Throwable -> L11
        r3.parcelSize = r8;     // Catch: Throwable -> L11
        r3.elements = r10;     // Catch: Throwable -> L11
        r1.add(r3);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static StackTraceElement[] removeUselessStackTrace(StackTraceElement[] r4) {
        if (r4 != null) goto L4;
        return r4;
    L4:
        if (r4.length == 0) goto L21;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L13;
        if ("saveBinderInfo".equals(r4[r1].getMethodName()) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        r0 = r1;
    L13:
        int r2 = r0 + 1;
        if (r2 <= r4.length) goto L16;
        return r4;
    L16:
        return (StackTraceElement[]) Arrays.copyOfRange(r4, r2, r4.length);
    L21:
        return r4;
    }
}
