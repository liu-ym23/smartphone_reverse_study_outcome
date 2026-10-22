package com.bytedance.apm.agent.v2.instrumentation;

import a.a;
import android.os.SystemClock;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class BatteryAgent {
    private static boolean hasHook;
    private static final Map<String, MethodExecutedValue> sExecutedRecord = null;
    private static ThreadLocal<HashMap<String, MethodExecutingValue>> sExecutingRecord;

    public static class MethodExecutedValue {
        private int cpuCost;
        private int exeCount;

        public MethodExecutedValue() {
            this.exeCount = 0;
            this.cpuCost = 0;
        }

        public static /* synthetic */ int access$300(MethodExecutedValue r0) {
            return r0.cpuCost;
        }

        public void addValue(MethodExecutingValue r7) {
            this.exeCount = MethodExecutingValue.access$000(r7) + this.exeCount;
            this.cpuCost = (int) ((MethodExecutingValue.access$100(r7) - MethodExecutingValue.access$200(r7)) + this.cpuCost);
        }

        public int getCost() {
            return this.cpuCost;
        }

        public int getCount() {
            return this.exeCount;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("MethodExecutedValue{exeCount=");
            r0.append(this.exeCount);
            r0.append(", cpuCost=");
            return a.l(r0, this.cpuCost, '}');
        }
    }

    public static class MethodExecutingValue {
        private long end;
        private int exeCount;
        private int leftCount;
        private long start;

        public MethodExecutingValue() {
            this.start = 0;
            this.end = 0;
            this.leftCount = 0;
            this.exeCount = 0;
        }

        public static /* synthetic */ int access$000(MethodExecutingValue r0) {
            return r0.exeCount;
        }

        public static /* synthetic */ long access$100(MethodExecutingValue r2) {
            return r2.end;
        }

        public static /* synthetic */ long access$200(MethodExecutingValue r2) {
            return r2.start;
        }

        public void methodIn() {
            if (this.exeCount != 0) goto L5;
            this.start = SystemClock.currentThreadTimeMillis();
        L5:
            this.leftCount++;
            this.exeCount++;
        }

        public boolean methodOut() {
            int r0 = this.leftCount - 1;
            this.leftCount = r0;
            if (r0 != 0) goto L6;
            this.end = SystemClock.currentThreadTimeMillis();
            return true;
        L6:
            return false;
        }
    }

    static {
        sExecutedRecord = new HashMap();
        sExecutingRecord = new ThreadLocal();
        hasHook = false;
    }

    public BatteryAgent() {
    }

    @Keep
    public static void e(String r3) {
        HashMap<String, MethodExecutingValue> r0 = sExecutingRecord.get();
        if (r0 != null) goto L5;
        return;
    L5:
        MethodExecutingValue r1 = r0.get(r3);
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.methodOut() == false) goto L22;
        r0.remove(r3);
        Map<String, MethodExecutedValue> r2 = sExecutedRecord;
        monitor-enter(r2);
        MethodExecutedValue r4 = r2.get(r3);     // Catch: Throwable -> L15
        if (r4 != null) goto L17;
        r4 = new MethodExecutedValue();     // Catch: Throwable -> L15
        r2.put(r3, r4);     // Catch: Throwable -> L15
    L17:
        r4.addValue(r1);     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static Map<String, MethodExecutedValue> filterResultAndClear(long r6) {
        HashMap r0 = new HashMap();
        Map<String, MethodExecutedValue> r1 = sExecutedRecord;
        if (r1.isEmpty() == false) goto L5;
        return r0;
    L5:
        monitor-enter(r1);
        Iterator<Map.Entry<String, MethodExecutedValue>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, MethodExecutedValue> r3 = r2.next();     // Catch: Throwable -> L12
        if (MethodExecutedValue.access$300(r3.getValue()) <= r6) goto L8;
        r0.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L12
        goto L8
    L14:
        sExecutedRecord.clear();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    @Keep
    public static void s(String r2) {
        hasHook = true;
        HashMap<String, MethodExecutingValue> r0 = sExecutingRecord.get();
        if (r0 != null) goto L5;
        r0 = new HashMap();
        sExecutingRecord.set(r0);
    L5:
        MethodExecutingValue r1 = r0.get(r2);
        if (r1 != null) goto L8;
        r1 = new MethodExecutingValue();
        r0.put(r2, r1);
    L8:
        r1.methodIn();
    }
}
