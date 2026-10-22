package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class BatteryAgent {
    private static boolean hasHook;
    private static final Map<String, a> sExecutedRecord = null;
    private static ThreadLocal<HashMap<String, b>> sExecutingRecord;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1289b;

        public a() {
            this.f1288a = 0;
            this.f1289b = 0;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f1289b;
        }

        public void b(b r7) {
            this.f1288a += b.a(r7);
            this.f1289b = (int) (((long) this.f1289b) + (b.b(r7) - b.c(r7)));
        }

        public int c() {
            return this.f1289b;
        }

        public int d() {
            return this.f1288a;
        }

        public String toString() {
            return "MethodExecutedValue{exeCount=" + this.f1288a + ", cpuCost=" + this.f1289b + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1293d;

        public b() {
            this.f1290a = 0;
            this.f1291b = 0;
            this.f1292c = 0;
            this.f1293d = 0;
        }

        static /* synthetic */ int a(b r0) {
            return r0.f1293d;
        }

        static /* synthetic */ long b(b r2) {
            return r2.f1291b;
        }

        static /* synthetic */ long c(b r2) {
            return r2.f1290a;
        }

        public void d() {
            if (this.f1293d != 0) goto L5;
            this.f1290a = SystemClock.currentThreadTimeMillis();
        L5:
            this.f1292c++;
            this.f1293d++;
        }

        public boolean e() {
            int r0 = this.f1292c - 1;
            this.f1292c = r0;
            if (r0 != 0) goto L6;
            this.f1291b = SystemClock.currentThreadTimeMillis();
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
        HashMap<String, b> r0 = sExecutingRecord.get();
        if (r0 != null) goto L5;
        return;
    L5:
        b r1 = r0.get(r3);
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.e() == false) goto L21;
        r0.remove(r3);
        Map<String, a> r2 = sExecutedRecord;
        monitor-enter(r2);
        a r4 = r2.get(r3);     // Catch: Throwable -> L18
        if (r4 != null) goto L15;
        r4 = new a();     // Catch: Throwable -> L18
        r2.put(r3, r4);     // Catch: Throwable -> L18
    L15:
        r4.b(r1);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static Map<String, a> filterResultAndClear(long r6) {
        HashMap r0 = new HashMap();
        Map<String, a> r1 = sExecutedRecord;
        if (r1.isEmpty() == false) goto L5;
        return r0;
    L5:
        monitor-enter(r1);
        Iterator<Map.Entry<String, a>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<String, a> r3 = r2.next();     // Catch: Throwable -> L15
        if (a.a(r3.getValue()) <= r6) goto L8;
        r0.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L15
        goto L8
    L12:
        sExecutedRecord.clear();     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return r0;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    @Keep
    public static void s(String r2) {
        hasHook = true;
        HashMap<String, b> r0 = sExecutingRecord.get();
        if (r0 != null) goto L5;
        r0 = new HashMap();
        sExecutingRecord.set(r0);
    L5:
        b r1 = r0.get(r2);
        if (r1 != null) goto L8;
        r1 = new b();
        r0.put(r2, r1);
    L8:
        r1.d();
    }
}
