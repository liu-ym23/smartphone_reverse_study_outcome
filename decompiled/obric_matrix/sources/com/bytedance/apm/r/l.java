package com.bytedance.apm.r;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.common.utility.Logger;
import com.bytedance.monitor.collector.m;
import com.bytedance.monitor.collector.o;
import com.bytedance.sliver.Sliver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private static long w = 1000;
    private static boolean x = false;
    private static boolean y = false;
    private static volatile l z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm.f0.e f1847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f1849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f1851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f1854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final StringBuilder f1855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final StringBuilder f1856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final StringBuilder f1857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.bytedance.apm.r.d f1858l;
    private com.bytedance.apm.r.d m;
    private volatile boolean n;
    private volatile boolean o;
    private boolean p;
    private boolean q;
    private LinkedList<com.bytedance.apm.t.d.d> r;
    private boolean s;
    private com.bytedance.apm.w.c t;
    private final Runnable u;
    private final Runnable v;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f1859f;

        a(l r1) {
            this.f1859f = r1;
        }

        private void a(StackTraceElement[] r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            TimeoutException r0 = new TimeoutException("main thread task execute more than " + l.a(this.f1859f) + "ms");
            r0.setStackTrace(r5);
            Logger.e("StackThread", "block detected", r0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.b(this.f1859f) != null) goto L43;
            return;
        L43:
            l.b(this.f1859f).b();     // Catch: Throwable -> L40
            int r3 = 0;
            if (l.g(this.f1859f) == false) goto L29;
            String r0 = Sliver.getStackTrace(Looper.getMainLooper().getThread());     // Catch: Throwable -> L40
            if (r0.contains(l.h(this.f1859f)) == false) goto L11;
            return;
        L11:
            String[] r1 = r0.split("\\)\\n");     // Catch: Throwable -> L40
            l.i(this.f1859f).setLength(0);     // Catch: Throwable -> L40
            int r4 = r1.length;     // Catch: Throwable -> L40
        L12:
            if (r3 >= r4) goto L25;
            String r5 = r1[r3];     // Catch: Throwable -> L40
            String r6 = "";
            char[] r7 = r5.toCharArray();     // Catch: Throwable -> L40
            if (r7 == null) goto L24;
            if (r7.length == 0) goto L24;
            if (r7[r7.length - 1] != '(') goto L23;
            String[] r8 = r5.split("\\.");     // Catch: Throwable -> L40
            int r9 = r8.length;     // Catch: Throwable -> L40
            if (r9 <= 2) goto L23;
            r6 = r8[r9 - 2];     // Catch: Throwable -> L40
        L23:
            StringBuilder r10 = l.i(this.f1859f);     // Catch: Throwable -> L40
            r10.append("\tat " + r5);     // Catch: Throwable -> L40
            r10.append(r6);     // Catch: Throwable -> L40
            r10.append(".java:1");     // Catch: Throwable -> L40
            r10.append(")\n");     // Catch: Throwable -> L40
        L24:
            r3 = r3 + 1;     // Catch: Throwable -> L40
            goto L12
        L25:
            l.b(this.f1859f).r = l.i(this.f1859f).toString();     // Catch: Throwable -> L40
            if (com.bytedance.apm.d.C() == false) goto L49;
            Logger.e("StackThread", "block detected: " + l.i(this.f1859f).toString());     // Catch: Throwable -> L40
            return;
        L49:
            return;
        L29:
            StackTraceElement[] r2 = Looper.getMainLooper().getThread().getStackTrace();     // Catch: Throwable -> L40
            if (r2[0].getClassName().startsWith(l.h(this.f1859f)) == false) goto L32;
            return;
        L32:
            l.b(this.f1859f).n = System.currentTimeMillis();     // Catch: Throwable -> L40
            l.b(this.f1859f).p = r2;     // Catch: Throwable -> L40
            if (com.bytedance.apm.d.C() == false) goto L35;
            a(r2);     // Catch: Throwable -> L40
        L35:
            l.i(this.f1859f).setLength(0);     // Catch: Throwable -> L40
            int r11 = r2.length;     // Catch: Throwable -> L40
        L36:
            if (r3 >= r11) goto L38;
            StackTraceElement r12 = r2[r3];     // Catch: Throwable -> L40
            StringBuilder r13 = l.i(this.f1859f);     // Catch: Throwable -> L40
            r13.append("\tat " + r12.getClassName());     // Catch: Throwable -> L40
            r13.append(".");     // Catch: Throwable -> L40
            r13.append(r12.getMethodName());     // Catch: Throwable -> L40
            r13.append("(");     // Catch: Throwable -> L40
            r13.append(r12.getFileName());     // Catch: Throwable -> L40
            r13.append(":");     // Catch: Throwable -> L40
            r13.append(r12.getLineNumber());     // Catch: Throwable -> L40
            r13.append(")\n");     // Catch: Throwable -> L40
            r3 = r3 + 1;     // Catch: Throwable -> L40
            goto L36
        L38:
            l.b(this.f1859f).r = l.i(this.f1859f).toString();     // Catch: Throwable -> L40
            return;
        L40:
            th = move-exception;
            com.bytedance.apm.k.e().d(th, "block_deal_exception");
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f1860f;

        b(l r1) {
            this.f1860f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
        L31:
            th = move-exception;
            com.bytedance.apm.k.e().d(th, "serious_block_deal_exception");
            return;
        L3:
            if (l.b(this.f1860f) != null) goto L5;
            return;
        L5:
            int r1 = 0;
            if (l.g(this.f1860f) == false) goto L26;
            String r0 = Sliver.getStackTrace(Looper.getMainLooper().getThread());     // Catch: Throwable -> L31
            if (r0.contains(l.h(this.f1860f)) == false) goto L10;
            return;
        L10:
            String[] r2 = r0.split("\\)\\n");     // Catch: Throwable -> L31
            l.j(this.f1860f).setLength(0);     // Catch: Throwable -> L31
            int r3 = r2.length;     // Catch: Throwable -> L31
        L11:
            if (r1 >= r3) goto L24;
            String r4 = r2[r1];     // Catch: Throwable -> L31
            String r5 = "";
            char[] r6 = r4.toCharArray();     // Catch: Throwable -> L31
            if (r6 == null) goto L23;
            if (r6.length == 0) goto L23;
            if (r6[r6.length - 1] != '(') goto L22;
            String[] r7 = r4.split("\\.");     // Catch: Throwable -> L31
            int r8 = r7.length;     // Catch: Throwable -> L31
            if (r8 <= 2) goto L22;
            r5 = r7[r8 - 2];     // Catch: Throwable -> L31
        L22:
            StringBuilder r9 = l.j(this.f1860f);     // Catch: Throwable -> L31
            r9.append("\tat " + r4);     // Catch: Throwable -> L31
            r9.append(r5);     // Catch: Throwable -> L31
            r9.append(".java:1");     // Catch: Throwable -> L31
            r9.append(")\n");     // Catch: Throwable -> L31
        L23:
            r1 = r1 + 1;     // Catch: Throwable -> L31
            goto L11
        L24:
            l.b(this.f1860f).r = l.j(this.f1860f).toString();     // Catch: Throwable -> L31
            l.b(this.f1860f).o = System.currentTimeMillis();     // Catch: Throwable -> L31
            l.b(this.f1860f).v = com.bytedance.apm.a0.d.b().a();     // Catch: Throwable -> L31
            l.b(this.f1860f).w = l.k(this.f1860f);     // Catch: Throwable -> L31
            l.b(this.f1860f).f1830j = true;     // Catch: Throwable -> L31
            return;
        L26:
            StackTraceElement[] r10 = Looper.getMainLooper().getThread().getStackTrace();     // Catch: Throwable -> L31
            if (r10[0].getClassName().startsWith(l.h(this.f1860f)) == false) goto L29;
            return;
        L29:
            l.b(this.f1860f).o = System.currentTimeMillis();     // Catch: Throwable -> L31
            l.b(this.f1860f).q = r10;     // Catch: Throwable -> L31
            l.b(this.f1860f).v = com.bytedance.apm.a0.d.b().a();     // Catch: Throwable -> L31
            l.b(this.f1860f).w = l.k(this.f1860f);     // Catch: Throwable -> L31
            l.b(this.f1860f).f1830j = true;     // Catch: Throwable -> L31
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.r.d f1861f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f1862g;

        c(l r1, com.bytedance.apm.r.d r2) {
            this.f1862g = r1;
            this.f1861f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.r.d r0 = this.f1861f;
            if ((r0.f1828h - r0.f1827g) > l.l(this.f1862g)) goto L5;
        L7:
            boolean r1 = false;
            if (this.f1861f.f1832l == true) goto L14;
            com.bytedance.apm.r.d r2 = this.f1861f;
            if (r2.r == null) goto L14;
            if (r2.m == true) goto L14;
        L17:
            com.bytedance.apm.r.d r3 = this.f1861f;
            if ((r3.f1828h - r3.f1827g) > l.l(this.f1862g)) goto L20;
        L34:
            String r4 = o.b(this.f1861f.f1822b);     // Catch: Exception -> L33
            l r5 = this.f1862g;     // Catch: Exception -> L33
            com.bytedance.apm.r.d r6 = this.f1861f;     // Catch: Exception -> L33
            l.c(r5, r6.f1824d, r6, r4);     // Catch: Exception -> L33
            if (this.f1861f.f1830j == true) goto L27;
        L31:
            l.f(this.f1862g, this.f1861f, r4);     // Catch: Exception -> L33
            return;
        L27:
            if (l.d(this.f1862g) == false) goto L31;
            if (l.n(this.f1862g) == false) goto L31;
            l.e(this.f1862g, this.f1861f, r4, r1);     // Catch: Exception -> L33
        L36:
            return;
        L20:
            if (this.f1861f.f1830j == true) goto L34;
            if (l.n(this.f1862g) == false) goto L34;
            this.f1861f.w = l.k(this.f1862g);
            this.f1861f.v = com.bytedance.apm.a0.d.b().a();
            this.f1861f.f1830j = true;
            r1 = true;
        L14:
            if (l.m(this.f1862g) == false) goto L16;
            return;
        L16:
            this.f1861f.r = "Invalid Stack\n";
            goto L17
        L5:
            if (com.bytedance.apm.d0.c.e("serious_block_monitor") == false) goto L7;
            com.bytedance.apm.r.d r7 = l.b(this.f1862g);
            com.bytedance.monitor.collector.k r8 = com.bytedance.monitor.collector.k.n();
            com.bytedance.apm.r.d r9 = this.f1861f;
            r7.x = r8.f(r9.f1827g, r9.f1828h);
            goto L7
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.r.d f1863f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f1864g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l f1865h;

        d(l r1, com.bytedance.apm.r.d r2, boolean r3) {
            this.f1865h = r1;
            this.f1863f = r2;
            this.f1864g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r1 = new JSONObject();
            com.bytedance.monitor.collector.k r2 = com.bytedance.monitor.collector.k.n();
            com.bytedance.apm.r.d r3 = this.f1863f;
            String r4 = r2.i(r3.f1827g, r3.f1828h);
            StringBuilder r5 = new StringBuilder();
            com.bytedance.apm.r.d r6 = this.f1863f;
            long r7 = r6.f1828h - r6.f1827g;
            if (TextUtils.isEmpty(r4) == false) goto L5;
            return;
        L5:
            String r8 = m.c(r4, r5, 1000, r7);
            if (com.bytedance.apm.d.C() == false) goto L13;
            com.bytedance.apm.x.g.c("StackThread", "%s", new Object[]{r4});
        L13:
            r1.put("stack", r5.toString());     // Catch: JSONException -> L10
            r1.put("stack_key", r8);     // Catch: JSONException -> L10
            r1.put("scene", this.f1863f.t);     // Catch: JSONException -> L10
            r1.put("cost_time", r7);     // Catch: JSONException -> L10
            r1.put("method_time", r7);     // Catch: JSONException -> L10
            r1.put("monitor_type", "sampling");     // Catch: JSONException -> L10
            r1.put("message", o.b(this.f1863f.f1822b));     // Catch: JSONException -> L10
            r1.put("event_type", "lag_drop_frame");     // Catch: JSONException -> L10
            JSONObject r9 = d.b.b.m.a.c.a().c(true);     // Catch: JSONException -> L10
            r9.put("crash_section", com.bytedance.apm.d.B(l.b(this.f1865h).f1829i));     // Catch: JSONException -> L10
            r9.put("belong_frame", String.valueOf(this.f1864g));     // Catch: JSONException -> L10
            r9.put("monitor_type", "sample");     // Catch: JSONException -> L10
            r1.put("filters", r9);     // Catch: JSONException -> L10
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d("drop_frame_stack", r1));     // Catch: JSONException -> L10
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
    }

    private l() {
        this.f1848b = false;
        this.f1849c = false;
        this.f1850d = 2500;
        this.f1851e = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.f1852f = false;
        this.f1853g = true;
        this.f1855i = new StringBuilder(1200);
        this.f1856j = new StringBuilder(1200);
        this.f1857k = new StringBuilder(1200);
        this.m = null;
        this.n = false;
        this.o = false;
        this.p = true;
        this.q = true;
        this.r = new LinkedList();
        this.s = false;
        this.t = null;
        this.u = new a(this);
        this.v = new b(this);
        this.f1854h = l.class.getName();
    }

    static boolean A(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    private JSONObject B(@NonNull com.bytedance.apm.r.d r6) {
        long r0 = r6.f1828h - r6.f1827g;
        JSONObject r5 = new JSONObject();
        r5.put("timestamp", r6.f1829i);     // Catch: JSONException -> L5
        r5.put("crash_time", r6.f1829i);     // Catch: JSONException -> L5
        r5.put("is_main_process", com.bytedance.apm.d.G());     // Catch: JSONException -> L5
        r5.put("process_name", com.bytedance.apm.d.i());     // Catch: JSONException -> L5
        r5.put("block_duration", r0);     // Catch: JSONException -> L5
        r5.put("last_scene", r6.t);     // Catch: JSONException -> L5
    L7:
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void E(boolean r7, com.bytedance.apm.r.d r8, String r9) {
        if (this.p == true) goto L5;
        return;
    L5:
        JSONObject r0 = B(r8);
        r0.put("stack", r8.r);
        r0.put("message", r9);
        r0.put("ignore_stack", this.f1858l.m);
        r0.put("event_type", "lag");
        r0.put("filters", u(r7, r8, r9));
        r0.put("custom", t());
        com.bytedance.apm.t.d.d r10 = new com.bytedance.apm.t.d.d("block_monitor", r0, r8.f1827g);
        p(r10);
        com.bytedance.apm.t.c.a.p().e(r10);
        com.bytedance.apm.w.c r1 = this.t;
        if (r1 == null) goto L9;
        r1.b(r8.f1822b, r8.f1828h - r8.f1827g, r8.t, r8.r);
        return;
    }

    private void F(com.bytedance.apm.r.d r4, String r5) {
        if (PerfConfig.a() == false) goto L6;
        JSONObject r3 = B(r4);
        JSONObject r0 = d.b.b.m.a.c.a().c(true);
        r0.put("crash_section", com.bytedance.apm.d.B(r4.f1829i));
        r0.put("belong_frame", String.valueOf(r4.f1824d));
        r0.put("belong_dump", String.valueOf(r4.f1823c));
        r0.put("block_stack_type", "messageKey");
        r3.put("filters", r0);
        r3.put("event_type", "lag");
        r3.put("stack", "at " + r5 + ".*(a.java:-1)");
        com.bytedance.apm.t.d.d r6 = new com.bytedance.apm.t.d.d("block_monitor", r3);
        r6.g();
        com.bytedance.apm.t.c.a.p().e(r6);
        return;
    }

    private void G(com.bytedance.apm.r.d r18, String r19, boolean r20) {
        if (this.q == true) goto L5;
        return;
    L5:
        Logger.e("StackThread", "reportSeriousBlock :" + r18.r);
        JSONObject r3 = u(r18.f1824d, r18, r19);
        r3.put("sbuuid", "empty");
        JSONObject r5 = B(r18);
        r5.put("message", r19);
        StackTraceElement[] r2 = r18.p;
        if (r2 == null) goto L43;
        StackTraceElement[] r7 = r18.q;
        if (r7 == null) goto L43;
        int r4 = r2.length;
        int r8 = r7.length;
        int r9 = 0;
        int r10 = 0;
    L11:
        if (r9 >= Math.min(r4, r8)) goto L19;
        int r12 = (r4 - r9) - 1;
        int r14 = (r8 - r9) - 1;
        if (r18.p[r12].equals(r18.q[r14]) == false) goto L15;
        r10 = r10 + 1;
        r9 = r9 + 1;
        goto L11
    L15:
        if (z(r18.p[r12], r18.q[r14]) == false) goto L19;
        r10 = r10 + 1;
    L19:
        if (r10 != 0) goto L22;
        String r11 = "none";
    L21:
        r3.put("serious_stack_coincide", r11);
        JSONObject r16 = r3;
    L34:
        this.f1857k.setLength(0);
    L35:
        if (r10 <= 0) goto L38;
        StringBuilder r6 = this.f1857k;
        r6.append("\tat ");
        int r13 = r4 - r10;
        r6.append(r18.p[r13].getClassName());
        r6.append(".");
        r6.append(r18.p[r13].getMethodName());
        r6.append("(");
        r6.append(r18.p[r13].getFileName());
        r6.append(":");
        r6.append(r18.p[r13].getLineNumber());
        r6.append(")\n");
        r10 = r10 - 1;
        goto L35
    L38:
        if (this.f1857k.length() != 0) goto L40;
        String r15 = r18.r;
    L41:
        r5.put("stack", r15);
        r3 = r16;
        r3.put("sbuuid", r18.s);
        goto L43
    L40:
        r15 = this.f1857k.toString();
        goto L41
    L22:
        if (r10 != r4) goto L25;
        if (r10 != r8) goto L25;
        r11 = "full";
    L25:
        r3.put("serious_stack_coincide", "part");
        this.f1857k.setLength(0);
        int r17 = 0;
    L27:
        if (r17 > (r4 - r10)) goto L29;
        StringBuilder r110 = this.f1857k;
        r110.append("\tat ");
        r110.append(r18.p[r17].getClassName());
        r110.append(".");
        r110.append(r18.p[r17].getMethodName());
        r110.append("(");
        r110.append(r18.p[r17].getFileName());
        r110.append(":");
        r110.append(r18.p[r17].getLineNumber());
        r110.append(")\n");
        r17 = r17 + 1;
        r3 = r3;
        goto L27
    L29:
        r16 = r3;
        r5.put("stack1", this.f1857k.toString());
        this.f1857k.setLength(0);
        int r111 = 0;
    L31:
        if (r111 > (r8 - r10)) goto L33;
        StringBuilder r21 = this.f1857k;
        r21.append("\tat ");
        r21.append(r18.q[r111].getClassName());
        r21.append(".");
        r21.append(r18.q[r111].getMethodName());
        r21.append("(");
        r21.append(r18.q[r111].getFileName());
        r21.append(":");
        r21.append(r18.q[r111].getLineNumber());
        r21.append(")\n");
        r111 = r111 + 1;
        goto L31
    L33:
        r5.put("stack2", this.f1857k.toString());
    L43:
        if (this.s == false) goto L45;
        r5.put("stack", r18.r);
        r3.put("sbuuid", r18.s);
    L45:
        r5.put("stack_cost", r18.o - r18.n);
        r5.put("filters", r3);
        r5.put("event_type", "serious_lag");
        r5.put("block_looper_info", r18.u);
        r5.put("block_cpu_info", r18.v);
        r5.put("block_memory_info", r18.w);
        r5.put("custom", r18.x);
        r5.put("block_error_info", r20);
        com.bytedance.apm.t.d.d r22 = new com.bytedance.apm.t.d.d("serious_block_monitor", r5, r18.f1827g);
        p(r22);
        com.bytedance.apm.t.c.a.p().e(r22);
        com.bytedance.apm.w.c r23 = this.t;
        if (r23 == null) goto L54;
        r23.a(r18.f1822b, r18.f1828h - r18.f1827g, r18.t, r18.r);
        return;
    }

    private void H(boolean r3, com.bytedance.apm.r.d r4) {
        com.bytedance.apm.f0.b.f().i(new d(this, r4, r3));
    }

    public static void M(long r2) {
        if (r2 >= 70) goto L5;
        r2 = 1000;
    L5:
        w = r2;
    }

    static /* synthetic */ long a(l r2) {
        return r2.f1850d;
    }

    static /* synthetic */ com.bytedance.apm.r.d b(l r0) {
        return r0.f1858l;
    }

    static /* synthetic */ void c(l r0, boolean r1, com.bytedance.apm.r.d r2, String r3) {
        r0.E(r1, r2, r3);
    }

    static /* synthetic */ boolean d(l r0) {
        return r0.f1848b;
    }

    static /* synthetic */ void e(l r0, com.bytedance.apm.r.d r1, String r2, boolean r3) {
        r0.G(r1, r2, r3);
    }

    static /* synthetic */ void f(l r0, com.bytedance.apm.r.d r1, String r2) {
        r0.F(r1, r2);
    }

    static /* synthetic */ boolean g(l r0) {
        return r0.s;
    }

    static /* synthetic */ String h(l r0) {
        return r0.f1854h;
    }

    static /* synthetic */ StringBuilder i(l r0) {
        return r0.f1855i;
    }

    static /* synthetic */ StringBuilder j(l r0) {
        return r0.f1856j;
    }

    static /* synthetic */ JSONObject k(l r0) {
        return r0.w();
    }

    static /* synthetic */ long l(l r2) {
        return r2.f1851e;
    }

    static /* synthetic */ boolean m(l r0) {
        return r0.f1849c;
    }

    static /* synthetic */ boolean n(l r0) {
        return r0.f1853g;
    }

    private StackTraceElement[] o(StackTraceElement[] r6) {
        if (r6 == null) goto L5;
        return r6;
    L5:
        return new StackTraceElement[]{new StackTraceElement("Invalid Stack\n", "a", "a.java", 1)};
    }

    private void p(com.bytedance.apm.t.d.d r5) {
    L3:
        if (this.r.size() == 0) goto L12;
        if ((r5.f() - this.r.getFirst().f()) < 0) goto L11;
        if ((r5.f() - this.r.getFirst().f()) > 60000) goto L11;
        if (this.r.size() <= 60) goto L12;
    L11:
        this.r.removeFirst();
    L12:
        this.r.addLast(r5);
    }

    private void q() {
        long r0 = this.f1851e;
        long r2 = this.f1850d;
        if (r0 >= r2) goto L6;
        this.f1851e = r2 + 50;
        return;
    }

    private void r(com.bytedance.apm.r.d r3) {
        com.bytedance.apm.f0.b.f().i(new c(this, r3));
    }

    private void s(com.bytedance.apm.r.d r2) {
        String r1 = com.bytedance.apm.g0.h.b.b();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        String r3 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L6:
        r2.t = r3;
        return;
    L5:
        r3 = r1 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
        goto L6
    }

    private JSONObject t() {
        JSONObject r3 = new JSONObject();
        Map<String, String> r0 = com.bytedance.apm.r.c.a();     // Catch: JSONException -> L13
        if (r0 == null) goto L12;
        if (r0.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r1 = r0.entrySet().iterator();     // Catch: JSONException -> L13
    L9:
        if (r1.hasNext() == false) goto L12;
        Map.Entry<String, String> r2 = r1.next();     // Catch: JSONException -> L13
        r3.put(r2.getKey(), r2.getValue());     // Catch: JSONException -> L13
    L12:
        return r3;
    }

    private JSONObject u(boolean r3, com.bytedance.apm.r.d r4, String r5) {
        JSONObject r2 = d.b.b.m.a.c.a().c(true);
        r2.put("crash_section", com.bytedance.apm.d.B(r4.f1829i));
        r2.put("belong_frame", String.valueOf(r3));
        r2.put("belong_dump", String.valueOf(r4.f1823c));
        r2.put("block_input", String.valueOf(r4.f1825e));
        r2.put("block_frame", String.valueOf(r4.f1826f));
        r2.put("block_message", r5);
        r2.put("block_stack_type", "stack");
        r2.put("buuid", r4.s);
        r2.put("belong_poll_once", String.valueOf(r4.f1831k));
        Map<String, String> r6 = com.bytedance.apm.r.c.a();
        if (r6 != null) goto L5;
    L10:
        return r2;
    L5:
        if (r6.isEmpty() == true) goto L10;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<String, String> r8 = r7.next();
        r2.put(r8.getKey(), r8.getValue());
        goto L8
    }

    static l v() {
        if (z != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (z != null) goto L9;
        z = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return z;
    }

    private JSONObject w() {
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L7
        Context r0 = com.bytedance.apm.d.h();     // Catch: Exception -> L7
        if (r0 == null) goto L5;
        ActivityManager r1 = (ActivityManager) r0.getSystemService("activity");     // Catch: Exception -> L7
        ActivityManager.MemoryInfo r2 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L7
        r1.getMemoryInfo(r2);     // Catch: Exception -> L7
        r4.put("availMem", r2.availMem);     // Catch: Exception -> L7
        r4.put("lowMemory", r2.lowMemory);     // Catch: Exception -> L7
        r4.put("threshold", r2.threshold);     // Catch: Exception -> L7
        r4.put("totalMem", d.b.e.a.a.a(r2));     // Catch: Exception -> L7
    L5:
        Runtime r3 = Runtime.getRuntime();     // Catch: Exception -> L7
        r4.put("max_memory", r3.maxMemory());     // Catch: Exception -> L7
        r4.put("free_memory", r3.freeMemory());     // Catch: Exception -> L7
        r4.put("total_memory", r3.totalMemory());     // Catch: Exception -> L7
        return r4;
    L7:
        return null;
    }

    private void x(com.bytedance.apm.r.d r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.f1821a == true) goto L8;
        r6.b();
    L8:
        if ((r6.f1828h - r6.f1827g) < this.f1851e) goto L10;
        boolean r0 = true;
    L11:
        r6.f1830j = r0;
        com.bytedance.monitor.collector.g.i r1 = com.bytedance.monitor.collector.k.n().o();
        if (r1 == null) goto L19;
        StackTraceElement[] r2 = o(r6.p);
        if (r6.f1830j == false) goto L16;
        StackTraceElement[] r3 = o(r6.q);
    L17:
        r1.f("uuid", r2, r3, null);
        goto L19
    L16:
        r3 = null;
    L19:
        if (r6.f1831k == false) goto L21;
        r(r6);
        return;
    L21:
        this.m = r6;
        return;
    L10:
        r0 = false;
        goto L11
    }

    static boolean z(StackTraceElement r4, StackTraceElement r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        if (r4.getClassName().equals(r5.getClassName()) == false) goto L17;
        if (A(r4.getMethodName(), r5.getMethodName()) == false) goto L17;
        if (A(r4.getFileName(), r5.getFileName()) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public void C(boolean r10) {
        if (this.f1847a.e() == false) goto L55;
        com.bytedance.apm.r.d r0 = this.m;     // Catch: Exception -> L52
        if (r0 == null) goto L9;
        if (r10 == false) goto L8;
        r0.f1826f = true;     // Catch: Exception -> L52
    L8:
        r(r0);     // Catch: Exception -> L52
        this.m = null;     // Catch: Exception -> L52
    L9:
        com.bytedance.apm.r.d r1 = this.f1858l;     // Catch: Exception -> L52
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.f1827g >= 0) goto L14;
        return;
    L14:
        if (r1.f1828h != (-1)) goto L58;
        r1.f1828h = com.bytedance.monitor.collector.a.f5105b;     // Catch: Exception -> L52
        if (this.f1853g == false) goto L19;
        this.f1847a.h(this.u);     // Catch: Exception -> L52
        this.f1847a.h(this.v);     // Catch: Exception -> L52
    L19:
        com.bytedance.apm.r.d r2 = this.f1858l;     // Catch: Exception -> L52
        if ((r2.f1828h - r2.f1827g) <= this.f1850d) goto L31;
        s(r2);     // Catch: Exception -> L52
        com.bytedance.apm.r.d r3 = this.f1858l;     // Catch: Exception -> L52
        r3.f1829i = System.currentTimeMillis();     // Catch: Exception -> L52
        if (this.f1853g == true) goto L24;
        this.f1858l.m = true;     // Catch: Exception -> L52
    L24:
        com.bytedance.apm.r.d r4 = this.f1858l;     // Catch: Exception -> L52
        r4.f1824d = r10;     // Catch: Exception -> L52
        r4.f1823c = this.n;     // Catch: Exception -> L52
        x(this.f1858l.a());     // Catch: Exception -> L52
        com.bytedance.apm.r.d r5 = this.f1858l;     // Catch: Exception -> L52
        if ((r5.f1828h - r5.f1827g) <= this.f1851e) goto L31;
        if (r10 == false) goto L31;
        if (this.o == false) goto L31;
        i.a();     // Catch: Exception -> L52
    L31:
        if (x == false) goto L42;
        com.bytedance.apm.r.d r6 = this.f1858l;     // Catch: Exception -> L52
        if ((r6.f1828h - r6.f1827g) <= w) goto L42;
        if (TextUtils.isEmpty(r6.t) == false) goto L37;
        s(this.f1858l);     // Catch: Exception -> L52
    L37:
        com.bytedance.apm.r.d r7 = this.f1858l;     // Catch: Exception -> L52
        if (r7.f1829i != 0) goto L40;
        r7.f1829i = System.currentTimeMillis();     // Catch: Exception -> L52
    L40:
        H(r10, this.f1858l.a());     // Catch: Exception -> L52
    L42:
        if (y == false) goto L59;
        Message r11 = com.bytedance.monitor.collector.i.b(com.bytedance.monitor.collector.i.a());     // Catch: Exception -> L52
        if (r11 != null) goto L46;
        return;
    L46:
        long r8 = SystemClock.uptimeMillis();     // Catch: Exception -> L52
        if (r11.getTarget() != null) goto L49;
        return;
    L49:
        if (r11.getWhen() >= r8) goto L61;
        this.f1852f = true;     // Catch: Exception -> L52
        this.f1858l.c(r8, null);     // Catch: Exception -> L52
        this.f1847a.g(this.u, this.f1850d);     // Catch: Exception -> L52
        return;
    L61:
        return;
    L59:
        return;
    L58:
        return;
    L55:
        return;
    }

    public void D(String r7) {
        if (this.f1847a.e() == true) goto L5;
        return;
    L5:
        if (y == false) goto L12;
        if (this.f1852f == false) goto L12;
        com.bytedance.apm.r.d r0 = this.f1858l;     // Catch: Exception -> L28
        long r2 = com.bytedance.monitor.collector.a.f5105b;     // Catch: Exception -> L28
        r0.f1828h = r2;     // Catch: Exception -> L28
        if ((r2 - r0.f1827g) <= this.f1850d) goto L12;
        r0.f1831k = true;     // Catch: Exception -> L28
        r0.f1824d = false;     // Catch: Exception -> L28
        r0.f1823c = this.n;     // Catch: Exception -> L28
        x(this.f1858l.a());     // Catch: Exception -> L28
    L12:
        if (this.m != null) goto L14;
    L16:
        com.bytedance.apm.r.d r1 = this.f1858l;     // Catch: Exception -> L28
        if (r1 != null) goto L19;
        this.f1858l = new com.bytedance.apm.r.d(com.bytedance.monitor.collector.a.f5105b, r7);     // Catch: Exception -> L28
    L21:
        if (this.f1853g == false) goto L32;
        this.f1847a.g(this.u, this.f1850d);     // Catch: Exception -> L28
        if (this.f1848b == true) goto L25;
        return;
    L25:
        if (this.q == false) goto L34;
        this.f1847a.g(this.v, this.f1851e);     // Catch: Exception -> L28
        return;
    L34:
        return;
    L32:
        return;
    L19:
        r1.c(com.bytedance.monitor.collector.a.f5105b, r7);     // Catch: Exception -> L28
        goto L21
    L14:
        if (com.bytedance.apm.r.m.e.A().f1891b.b() == false) goto L16;
        this.m.f1825e = true;     // Catch: Exception -> L28
    }

    public void I(long r3) {
        if (r3 >= 70) goto L5;
        r3 = 2500;
    L5:
        this.f1850d = r3;
        q();
    }

    public void J(com.bytedance.apm.w.c r1) {
        this.t = r1;
    }

    public void K(boolean r1) {
        this.f1853g = r1;
    }

    public void L(boolean r1) {
        this.o = r1;
    }

    public void N(boolean r1) {
        this.f1849c = r1;
    }

    public void O(boolean r1) {
        this.p = r1;
    }

    public void P(boolean r1) {
        this.q = r1;
    }

    public void Q(long r3) {
        if (r3 >= this.f1850d) goto L5;
        r3 = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    L5:
        this.f1851e = r3;
        q();
    }

    public void R(boolean r1) {
        this.s = r1;
    }

    public void S(boolean r1) {
        this.f1848b = r1;
    }

    public void y() {
        com.bytedance.apm.f0.e r0 = new com.bytedance.apm.f0.e("StackThread");
        this.f1847a = r0;
        r0.k();
    }
}
