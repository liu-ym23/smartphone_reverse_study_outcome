package com.bytedance.monitor.collector;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BinderMonitor extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<a> f5082f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f5083g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f5084h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f5085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f5087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        StackTraceElement[] f5088d;

        public a() {
        }

        public long a() {
            return this.f5085a;
        }

        public StackTraceElement[] b() {
            return this.f5088d;
        }

        public long c() {
            return this.f5086b;
        }

        public String toString() {
            return "{\"start\":" + this.f5085a + ",\"end\":" + this.f5086b + ",\"parcel_size\":" + this.f5087c + ",\"cost_millis\":" + (this.f5086b - this.f5085a) + ",\"java_stack\":\"" + o.d(BinderMonitor.g(this.f5088d)) + "\"}";
        }
    }

    static {
        f5082f = new ArrayList(200);
        f5083g = new Object();
        f5084h = 0;
    }

    BinderMonitor(int r2) {
        super(r2, "binder_monitor");
    }

    static /* synthetic */ StackTraceElement[] g(StackTraceElement[] r0) {
        return l(r0);
    }

    @Keep
    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    private static void h(long r4, long r6, long r8, StackTraceElement[] r10) {
        Object r0 = f5083g;
        monitor-enter(r0);
        List<a> r1 = f5082f;     // Catch: Throwable -> L11
        if (r1.size() != 200) goto L7;
        a r2 = r1.get(f5084h % 200);     // Catch: Throwable -> L11
        r2.f5085a = r4;     // Catch: Throwable -> L11
        r2.f5086b = r6;     // Catch: Throwable -> L11
        r2.f5087c = r8;     // Catch: Throwable -> L11
        r2.f5088d = r10;     // Catch: Throwable -> L11
    L8:
        f5084h++;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        a r3 = new a();     // Catch: Throwable -> L11
        r3.f5085a = r4;     // Catch: Throwable -> L11
        r3.f5086b = r6;     // Catch: Throwable -> L11
        r3.f5087c = r8;     // Catch: Throwable -> L11
        r3.f5088d = r10;     // Catch: Throwable -> L11
        r1.add(r3);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private String i(long r6, long r8) {
        List<a> r5 = k();
        ArrayList r0 = new ArrayList();
        int r1 = r5.size() - 1;
    L3:
        if (r1 < 0) goto L14;
        a r2 = r5.get(r1);
        if (r2.f5085a <= r8) goto L7;
    L8:
        r0.add(r2);
    L10:
        if (r2.f5086b < r6) goto L14;
        r1 = r1 - 1;
        goto L3
    L7:
        if (r2.f5086b <= r6) goto L10;
    L14:
        return r0.toString();
    }

    private static StackTraceElement[] l(StackTraceElement[] r4) {
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

    @Keep
    public static void saveBinderInfo(long r8, long r10, long r12) {
        h(r8, r10, r12, Thread.currentThread().getStackTrace());
    }

    @Override // com.bytedance.monitor.collector.b
    public Pair<String, String> a() {
        return new Pair(this.f5108a, f5082f.toString());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public Pair<String, String> b(long r3, long r5) {
        return new Pair(this.f5108a, i(r3, r5));
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    protected void f(int r1) {
    }

    void j() {
        MonitorJni.enableBinderHook();
    }

    public List<a> k() {
        ArrayList r6 = new ArrayList();
        Object r0 = f5083g;
        monitor-enter(r0);
        int r1 = 0;
    L6:
        if (r1 >= 200) goto L10;
        int r3 = ((f5084h - 1) + r1) % 200;     // Catch: Throwable -> L12
        List<a> r4 = f5082f;     // Catch: Throwable -> L12
        if (r3 >= r4.size()) goto L10;
        r6.add(r4.get(((f5084h - 1) + r1) % 200));     // Catch: Throwable -> L12
        r1 = r1 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    }
}
