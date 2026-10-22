package com.bytedance.applog.o;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.applog.collector.Collector;
import com.bytedance.applog.l;
import com.bytedance.applog.m;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.r;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements Handler.Callback, Comparator<com.bytedance.applog.w.a> {
    private static volatile e F;
    private volatile com.bytedance.applog.p.a A;
    private volatile l.a B;
    private volatile com.bytedance.applog.p.e C;
    private volatile int D;
    private com.bytedance.applog.x.c E;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bytedance.applog.n.c f2265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Looper f2266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Application f2267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bytedance.applog.q.b f2268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bytedance.applog.o.d f2269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ArrayList<com.bytedance.applog.w.a> f2270k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile com.bytedance.applog.w.b f2271l;
    private com.bytedance.applog.q.c m;
    private volatile Handler n;
    private List<g> o;
    private volatile com.bytedance.applog.o.a p;
    private final h q;
    private m r;
    private Handler s;
    private long t;
    private com.bytedance.applog.o.c u;
    private f v;
    private ArrayList<com.bytedance.applog.o.c> w;
    volatile boolean x;
    private volatile long y;
    private final List<c> z;

    class a implements com.bytedance.applog.n.a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f2272a;

        a(e r1) {
            this.f2272a = r1;
        }

        @Override // com.bytedance.applog.n.a.f
        public void a(JSONObject r2, h0 r3) {
            e r4 = this.f2272a;
            e.b(r4, e.a(r4) | 4);
            e.c(this.f2272a).t(r2);
            n.e("bdinstall onUpdate");
        }

        @Override // com.bytedance.applog.n.a.f
        public void b(JSONObject r2, h0 r3) {
            e r4 = this.f2272a;
            e.b(r4, e.a(r4) | 2);
            e.c(this.f2272a).t(r2);
            n.e("bdinstall onLoad");
        }
    }

    class b extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f2273k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ e f2274l;

        b(e r1, ArrayList r2) {
            this.f2274l = r1;
            this.f2273k = r2;
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            super.run();
            if (e.d(this.f2274l, this.f2273k) == true) goto L5;
            e.e(this.f2274l).obtainMessage(8, this.f2273k).sendToTarget();
            return;
        L5:
            this.f2274l.s().n(this.f2273k);
        }
    }

    abstract class c<T> {
        protected abstract void a();
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        n0 f2276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        CountDownLatch f2278d;

        private d() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.o.e$e, reason: collision with other inner class name */
    public static class C0071e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<com.bytedance.applog.w.g> f2279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<com.bytedance.applog.w.g> f2280b;

        public C0071e() {
            this.f2279a = new ArrayList();
            this.f2280b = new ArrayList();
        }
    }

    public e(Application r8, com.bytedance.applog.q.b r9, com.bytedance.applog.q.c r10, com.bytedance.applog.n.c r11, com.bytedance.applog.b r12) {
        this.f2270k = new ArrayList(32);
        this.w = new ArrayList(4);
        this.z = new ArrayList();
        this.D = 0;
        this.f2267h = r8;
        this.f2268i = r9;
        this.m = r10;
        this.q = new h(this);
        this.f2265f = r11;
        HandlerThread r13 = new HandlerThread("bd_tracker_w");
        r13.start();
        this.s = new Handler(r13.getLooper(), this);
        HandlerThread r14 = new HandlerThread("bd_tracker_n");
        r14.start();
        Looper r5 = r14.getLooper();
        this.f2266g = r5;
        r11.e(r8, r9, z(), r5, r12);
        if (com.bytedance.applog.a.C() == false) goto L6;
        this.C = com.bytedance.applog.p.e.e(this.f2267h);
    L6:
        if (this.f2268i.b() == false) goto L8;
        this.s.sendEmptyMessage(1);
        this.s.sendEmptyMessageDelayed(2, 200);
    L8:
        F = this;
        this.s.sendEmptyMessage(10);
        if (this.f2268i.t().m() != null) goto L11;
    L13:
        new com.bytedance.applog.t.a(this);
        return;
    L11:
        if (this.f2268i.G() == true) goto L13;
        this.B = this.f2268i.t().m();
        goto L13
    }

    private void A(boolean r2) {
        if (com.bytedance.applog.a.z() == true) goto L6;
        n.e("Background session task is not enabled, resume or pause will not work!");
        return;
    L6:
        com.bytedance.applog.x.c r1 = y();
        if (r2 == false) goto L9;
        r1.B();
        return;
    L9:
        r1.A();
    }

    private void B(com.bytedance.applog.w.h r3) {
        if (com.bytedance.applog.a.z() == true) goto L5;
        return;
    L5:
        com.bytedance.applog.x.c r2 = y();
        if (r3.E() == false) goto L8;
        r2.z(r3.f2444g, r3.f2446i);
        return;
    L8:
        r2.y(r3.f2444g, r3.f2446i);
    }

    private void C(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        if ((r1 % 500) != 0) goto L8;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.t, com.bytedance.applog.r.b.d.i0);
        return;
    }

    private void D(com.bytedance.applog.r.b.d r1, int r2) {
        com.bytedance.applog.o.b.f(com.bytedance.applog.r.b.a.f2332h, r1, r2);
        com.bytedance.applog.o.b.f(com.bytedance.applog.r.b.a.m, r1, r2);
    }

    public static void F(com.bytedance.applog.w.a r5) {
        if (r5.f2444g != 0) goto L5;
        n.i(null);
    L5:
        e r0 = F;
        if (r0 != null) goto L8;
        com.bytedance.applog.q.a.a(r5);
        return;
    L8:
        ArrayList<com.bytedance.applog.w.a> r1 = r0.f2270k;
        monitor-enter(r1);
        int r2 = r0.f2270k.size();     // Catch: Throwable -> L30
        r0.f2270k.add(r5);     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L30
        boolean r3 = true;
        if ((r5 instanceof com.bytedance.applog.w.e) == true) goto L15;
    L17:
        if (r3 == false) goto L19;
        n.e("receive data=" + r5 + ", size=" + r2 + ", " + r0.f2270k.size());
    L19:
        boolean r6 = r5 instanceof com.bytedance.applog.w.h;
        if ((r2 % 5) == 0) goto L22;
        if (r6 == true) goto L22;
    L28:
        r0.C(r0.f2270k.size());
        return;
    L22:
        r0.s.removeMessages(4);
        if (r2 != 0) goto L27;
        if (r6 == true) goto L27;
        r0.s.sendEmptyMessageDelayed(4, 200);
    L27:
        r0.s.sendEmptyMessage(4);
        goto L28
    L15:
        if (TextUtils.equals("AppLogTracker", ((com.bytedance.applog.w.e) r5).D()) == false) goto L17;
        r3 = false;
    L30:
        th = move-exception;
        throw th;
    }

    public static void G(String[] r3) {
        e r0 = F;
        if (r0 != null) goto L5;
        com.bytedance.applog.q.a.b(r3);
        return;
    L5:
        r0.s.removeMessages(4);
        r0.s.obtainMessage(4, r3).sendToTarget();
    }

    private void H() {
        File r4 = this.f2267h.getDatabasePath(q().t().k());
        if (r4 == null) goto L6;
        com.bytedance.applog.o.b.l(com.bytedance.applog.r.b.a.o, com.bytedance.applog.r.b.d.f2346g, r4.length());
        return;
    }

    private void I(ArrayList<com.bytedance.applog.w.a> r11) {
        Collections.sort(r11, this);
        ArrayList<com.bytedance.applog.w.a> r0 = new ArrayList(r11.size());
        com.bytedance.applog.s.a r1 = this.f2268i.q();
        Iterator<com.bytedance.applog.w.a> r12 = r11.iterator();
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
        boolean r5 = false;
    L3:
        int r7 = 1;
        if (r12.hasNext() == false) goto L18;
        com.bytedance.applog.w.a r6 = r12.next();
        boolean r8 = this.q.m(r6, r0);
        boolean r9 = h.k(r6);
        if (r8 == false) goto L10;
        if (r9 == false) goto L10;
        r4 = true;
    L10:
        if ((r6 instanceof com.bytedance.applog.w.h) == true) goto L11;
        if ((r6 instanceof com.bytedance.applog.w.e) == true) goto L14;
        if ((r6 instanceof h.a) == false) goto L3;
        r5 = true;
        goto L3
    L14:
        ((com.bytedance.applog.w.e) r6).E(r1);
        goto L3
    L11:
        this.s.obtainMessage(21, r6).sendToTarget();
        r2 = true;
        r3 = r9;
        goto L3
    L18:
        f(r0);
        p(r0);
        s().y(r0);
        if (r2 == false) goto L25;
        Handler r10 = this.s;
        if (r3 == false) goto L23;
        r10.removeMessages(7);
        goto L25
    L23:
        r10.sendEmptyMessageDelayed(7, this.f2268i.y());
    L25:
        if (r4 == true) goto L31;
        if (r5 == true) goto L31;
        if (this.n == null) goto L53;
        this.n.removeMessages(6);
        Message r13 = this.n.obtainMessage(6);
        r13.arg1 = 2;
        this.n.sendMessage(r13);
        return;
    L53:
        return;
    L31:
        if (r4 == true) goto L34;
        r7 = 3;
    L34:
        S(this.o, r7);
        List<g> r14 = this.o;
        if (r14 != null) goto L37;
        return;
    L37:
        if (r14.isEmpty() == false) goto L39;
        return;
    L39:
        if ((2 & this.D) != 0) goto L57;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.t, com.bytedance.applog.r.b.d.h0);
        Bundle r15 = new Bundle();
        r15.putInt("engine_state", this.D);
        com.bytedance.applog.a.E("bdinstall_lost_callback", r15);
        return;
    }

    private boolean K(ArrayList<com.bytedance.applog.w.a> r11) {
        boolean r1 = false;
        com.bytedance.applog.s.b r0 = this.f2268i.r(0);
        String[] r3 = com.bytedance.applog.v.b.a(this, true, r0);
        JSONObject r4 = com.bytedance.applog.util.l.a(this.m.d());
        if (r3.length <= 0) goto L32;
        com.bytedance.applog.w.g r9 = com.bytedance.applog.w.g.L(r11, r4, r0);
        com.bytedance.applog.y.a r5 = null;
        com.bytedance.applog.v.a.m(null, r9, r0);
        if (r0 == null) goto L7;
        r5 = r0.b();
    L7:
        int r12 = r11.size();
        if (r5 != null) goto L10;
    L13:
        byte[] r6 = r9.v;
        if (r6 != null) goto L16;
    L30:
        D(com.bytedance.applog.r.b.d.u, r12);
        return false;
    L16:
        if (r6.length <= 0) goto L30;
        int r7 = com.bytedance.applog.v.a.k(r3, r6, this.f2268i, r9.F(), r9.N, r9.O);
        r9.x = r7;
        if (r7 != 200) goto L21;
        this.t = 0;
        D(com.bytedance.applog.r.b.d.o, r12);
        if (this.m.l() == true) goto L29;
        D(com.bytedance.applog.r.b.d.z, r12);
    L29:
        r1 = true;
        goto L32
    L21:
        if (com.bytedance.applog.v.a.b(r7) == false) goto L23;
        this.t = System.currentTimeMillis();
    L23:
        D(com.bytedance.applog.r.b.d.p, r12);
        if (r0 == null) goto L32;
        r0.a(r7);
        goto L32
    L10:
        if (r5.a(8) == false) goto L13;
        D(com.bytedance.applog.r.b.d.y, r12);
        return false;
    L32:
        n.e("sendRealTime, " + r1);
        return r1;
    }

    public static void M(com.bytedance.applog.p.e r1) {
        e r0 = F;
        if (r0 == null) goto L6;
        r0.C = r1;
        return;
    }

    private void N(String r10, com.bytedance.applog.w.h r11) {
        S(this.o, 10);
        if (r11 != null) goto L7;
        r11 = com.bytedance.applog.collector.a.a();
        if (r11 == null) goto L7;
        r11 = (com.bytedance.applog.w.h) r11.a();
    L7:
        ArrayList<com.bytedance.applog.w.a> r0 = new ArrayList();
        long r2 = System.currentTimeMillis();
        if (r11 == null) goto L14;
        long r4 = r2 - r11.f2444g;
        r11.t(r2);
        if (r4 >= 0) goto L13;
        r4 = 0;
    L13:
        r11.v = r4;
        r11.z = this.q.e();
        this.q.a(r11);
        r0.add(r11);
    L14:
        m(r10);
        if (r11 == null) goto L21;
        com.bytedance.applog.w.h r12 = (com.bytedance.applog.w.h) r11.a();
        r12.t(r2 + 1);
        r12.v = -1;
        com.bytedance.applog.w.f r13 = this.q.n(r12, r0, true);
        if (r13 == null) goto L19;
        r13.y = this.q.e();
    L19:
        this.q.a(r12);
        r0.add(r12);
    L21:
        if (r0.isEmpty() == true) goto L23;
        s().y(r0);
    L23:
        S(this.o, 10);
    }

    private void O(Iterator<com.bytedance.applog.w.a> r1, List<com.bytedance.applog.p.d> r2, com.bytedance.applog.r.b.a r3, String r4, String r5) {
        Iterator<com.bytedance.applog.p.d> r0 = r2.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        if (r0.next().a(r3, r4, r5) == false) goto L4;
        r1.remove();
        return;
    }

    public static void P(com.bytedance.applog.s.b r2, int r3) {
        e r0 = F;
        if (r0 == null) goto L12;
        List<g> r1 = r0.o;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isEmpty() == true) goto L15;
        Iterator<g> r4 = r0.o.iterator();
    L10:
        if (r4.hasNext() == false) goto L16;
        r4.next().q(r2, r3);
        goto L10
    L16:
        return;
    L15:
        return;
    }

    public static void Q() {
        e r0 = F;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.n == null) goto L9;
        r0.n.sendEmptyMessage(17);
        return;
    }

    private void R(com.bytedance.applog.o.c r3, int r4) {
        if (this.n == null) goto L10;
        if (r3 == null) goto L11;
        r3.j();
        if (Looper.myLooper() != this.n.getLooper()) goto L8;
        r3.a(r4);
        return;
    L8:
        this.n.removeMessages(6);
        Message r5 = this.n.obtainMessage(6);
        r5.arg1 = r4;
        this.n.sendMessage(r5);
        return;
    L11:
        return;
    }

    private void S(List<? extends com.bytedance.applog.o.c> r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L11;
        Iterator<? extends com.bytedance.applog.o.c> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        R(r4.next(), r3);
        goto L7
    L12:
        return;
    }

    static /* synthetic */ int a(e r0) {
        return r0.D;
    }

    static /* synthetic */ int b(e r0, int r1) {
        r0.D = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.applog.q.c c(e r0) {
        return r0.m;
    }

    static /* synthetic */ boolean d(e r0, ArrayList r1) {
        return r0.K(r1);
    }

    static /* synthetic */ Handler e(e r0) {
        return r0.s;
    }

    private void f(ArrayList<com.bytedance.applog.w.a> r3) {
        if (com.bytedance.applog.util.g.c() == false) goto L10;
        Iterator<com.bytedance.applog.w.a> r2 = r3.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        com.bytedance.applog.w.a r4 = r2.next();
        String r0 = com.bytedance.applog.util.g.b(r4);
        if (r0 == null) goto L6;
        JSONArray r1 = new JSONArray();
        r1.put(r4.v());
        com.bytedance.applog.util.g.d(r0, r1);
        goto L6
    L16:
        return;
    }

    private void h() {
        if (this.m.e() == this.m.i()) goto L5;
    L10:
        com.bytedance.applog.o.d r0 = this.f2269j;
        if (r0 == null) goto L14;
        r0.j();
    L14:
        if (q().t().M() == false) goto L19;
        com.bytedance.applog.p.a r1 = com.bytedance.applog.p.a.g(this.f2267h, null);
    L16:
        L(r1);
        return;
    L19:
        return;
    L5:
        if (TextUtils.equals(this.f2268i.u(), this.f2268i.i()) == false) goto L10;
        if (q().t().M() == false) goto L18;
        r1 = com.bytedance.applog.p.a.f(this.f2267h);
        goto L16
    }

    private void j(boolean r5) {
        r r0 = z().c();
        com.bytedance.bdinstall.i.f(new r(r0.a(), r0.f(), r0.d(), r5));
        s().d();
        ArrayList<com.bytedance.applog.w.a> r6 = new ArrayList();
        com.bytedance.applog.w.h r1 = com.bytedance.applog.collector.a.a();
        if (r1 == null) goto L5;
        r1 = (com.bytedance.applog.w.h) r1.a();
    L5:
        if (r1 == null) goto L7;
        r1.t(System.currentTimeMillis());
        r1.v = -1;
        this.q.n(r1, r6, true);
        this.q.a(r1);
        r6.add(r1);
    L9:
        if (r6.isEmpty() == true) goto L12;
        s().y(r6);
        return;
    L12:
        return;
    L7:
        this.q.n(null, r6, false);
        goto L9
    }

    private void k(boolean r1, String r2) {
        if (r1 == true) goto L4;
        f r3 = this.v;
        if (r3 == null) goto L12;
        r3.k(true);
        this.w.remove(this.v);
        this.v = null;
        return;
    L12:
        return;
    L4:
        if (this.v != null) goto L10;
        f r4 = new f(this, r2);
        this.v = r4;
        this.w.add(r4);
        this.n.removeMessages(6);
        this.n.sendEmptyMessage(6);
        return;
    }

    private void l(boolean r5, long r6, n0 r8) {
        r r0 = z().c();
        r r1 = new r(r0.a(), r0.f(), r0.d(), r5);
        com.bytedance.bdinstall.i.t(r(), r1, r6, r8);
    }

    private void m(String r3) {
        this.f2265f.b(this.f2267h, r3);
        R(this.p, 10);
    }

    private void o(ArrayList<com.bytedance.applog.w.a> r8) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        List<com.bytedance.applog.p.d> r0 = u();
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        Iterator<com.bytedance.applog.w.a> r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L21;
        com.bytedance.applog.w.a r1 = r9.next();
        if ((r1 instanceof com.bytedance.applog.w.e) == true) goto L13;
        if ((r1 instanceof com.bytedance.applog.w.c) == true) goto L17;
        if ((r1 instanceof com.bytedance.applog.w.d) == false) goto L10;
        com.bytedance.applog.r.b.a r4 = com.bytedance.applog.r.b.a.f2333i;
        String r6 = ((com.bytedance.applog.w.d) r1).i();
        String r5 = "log_data";
    L14:
        O(r9, r0, r4, r5, r6);
        goto L10
    L17:
        com.bytedance.applog.w.c r2 = (com.bytedance.applog.w.c) r1;
        r4 = com.bytedance.applog.r.b.a.f2331g;
        r5 = r2.w;
        r6 = r2.y;
        goto L14
    L13:
        com.bytedance.applog.w.e r3 = (com.bytedance.applog.w.e) r1;
        r5 = r3.D();
        r6 = r3.i();
        r4 = com.bytedance.applog.r.b.a.f2332h;
        goto L14
    }

    private void p(ArrayList<com.bytedance.applog.w.a> r5) {
        if (this.m.k() == true) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - this.t) < 60000) goto L13;
        ArrayList<com.bytedance.applog.w.a> r6 = this.f2268i.d(r5);
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.size() <= 0) goto L15;
        new b(this, r6).b();
        com.bytedance.applog.o.b.f(com.bytedance.applog.r.b.a.m, com.bytedance.applog.r.b.d.f2346g, r6.size());
        return;
    L15:
        return;
    }

    private List<com.bytedance.applog.p.d> u() {
        ArrayList r0 = new ArrayList();
        com.bytedance.applog.p.a r1 = com.bytedance.applog.a.o();
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        boolean r2 = q().t().M();
        com.bytedance.applog.p.a r3 = this.A;
        if (r2 == false) goto L10;
        if (r3 == null) goto L10;
        r0.add(r3);
    L10:
        if (com.bytedance.applog.a.C() == false) goto L14;
        com.bytedance.applog.p.e r4 = this.C;
        if (r4 == null) goto L14;
        r0.add(r4);
    L14:
        return r0;
    }

    public static com.bytedance.applog.p.e v() {
        e r0 = F;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.C;
    }

    private List<g> w() {
        ArrayList r0 = new ArrayList();
        com.bytedance.applog.s.a r1 = this.f2268i.q();
        if (r1 != null) goto L5;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L18;
        r0.add(new g(this));
    L18:
        return r0;
    L5:
        if (r1.d() == false) goto L15;
        Iterator<com.bytedance.applog.s.b> r3 = r1.b().values().iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        com.bytedance.applog.s.b r4 = r3.next();
        if (r4 == null) goto L8;
        if (r4.f() == 0) goto L8;
        r0.add(new g(this, r4));
        goto L8
    L14:
        r2 = true;
        goto L16
    }

    private com.bytedance.applog.x.c y() {
        if (this.E != null) goto L15;
        monitor-enter(this);
        com.bytedance.applog.x.c r0 = this.E;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        r0 = new com.bytedance.applog.x.c(r(), s(), this.m);     // Catch: Throwable -> L11
    L8:
        this.E = r0;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.E;
    }

    public void E(String[] r8, boolean r9) {
        ArrayList<com.bytedance.applog.w.a> r0 = this.f2270k;
        monitor-enter(r0);
        ArrayList<com.bytedance.applog.w.a> r1 = (ArrayList) this.f2270k.clone();     // Catch: Throwable -> L51
        this.f2270k.clear();     // Catch: Throwable -> L51
        monitor-exit(r0);     // Catch: Throwable -> L51
        int r2 = 0;
        if (r8 == null) goto L11;
        r1.ensureCapacity(r1.size() + r8.length);
        int r3 = r8.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L11;
        r1.add(com.bytedance.applog.w.a.f(r8[r4]));
        r4 = r4 + 1;
    L11:
        o(r1);
        boolean r10 = this.f2268i.c(r1);
        if (com.bytedance.applog.a.D() == false) goto L18;
        if (com.bytedance.applog.a.A() == true) goto L18;
        n.h("not process events in tourist mode", null);
        return;
    L18:
        if (r1.size() > 0) goto L20;
    L44:
        if (r9 == true) goto L46;
        return;
    L46:
        if (this.f2268i.G() == false) goto L62;
        long r11 = System.currentTimeMillis();
        if (Math.abs(r11 - this.y) <= BDLocationConfig.sScanBleMaxInterval) goto L63;
        this.y = r11;
        S(this.o, 4);
        return;
    L63:
        return;
    L62:
        return;
    L20:
        if (this.f2268i.G() == false) goto L30;
        if (r10 == false) goto L23;
    L29:
        I(r1);
        goto L44
    L23:
        if (r1.size() > 100) goto L29;
        Iterator<com.bytedance.applog.w.a> r12 = r1.iterator();
    L27:
        if (r12.hasNext() == false) goto L44;
        F(r12.next());
        goto L27
    L30:
        Intent r13 = new Intent(this.f2267h, Collector.class);
        int r5 = r1.size();
        String[] r6 = new String[r5];
        int r7 = 0;
    L31:
        if (r2 >= r5) goto L33;
        r6[r2] = r1.get(r2).u().toString();
        r7 = r7 + r6[r2].length();
        r2 = r2 + 1;
        goto L31
    L33:
        boolean r14 = true;
        if (r7 >= 307200) goto L36;
    L42:
        if (r14 == false) goto L44;
        r13.putExtra("K_DATA", r6);
        this.f2267h.sendBroadcast(r13);
        goto L44
    L36:
        if (this.B == null) goto L42;
        r14 = this.B.a(r6);     // Catch: Throwable -> L39
    L41:
        n.i(null);
    L39:
        th = move-exception;
        n.h("check ipc data", th);
    L51:
        th = move-exception;
        throw th;
    }

    public void J() {
        this.s.removeMessages(14);
        this.s.sendEmptyMessage(14);
    }

    public void L(com.bytedance.applog.p.a r1) {
        this.A = r1;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(com.bytedance.applog.w.a r1, com.bytedance.applog.w.a r2) {
        return i(r1, r2);
    }

    void g() {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        BlockHelper.tryBlock();
        switch(r10.what) {
            case 1: goto L114;
            case 2: goto L101;
            case 3: goto L93;
            case 4: goto L92;
            case 5: goto L4;
            case 6: goto L63;
            case 7: goto L55;
            case 8: goto L48;
            case 9: goto L43;
            case 10: goto L35;
            case 11: goto L4;
            case 12: goto L34;
            case 13: goto L22;
            case 14: goto L20;
            case 15: goto L19;
            case 16: goto L18;
            case 17: goto L17;
            case 18: goto L14;
            case 19: goto L11;
            case 20: goto L8;
            case 21: goto L5;
            default: goto L4;
        };
    L4:
        n.i(null);
    L119:
        return true;
    L5:
        Object r11 = r10.obj;
        if ((r11 instanceof com.bytedance.applog.w.h) == false) goto L119;
        B((com.bytedance.applog.w.h) r11);
        goto L119
    L8:
        Object r12 = r10.obj;
        if ((r12 instanceof Boolean) == false) goto L119;
        A(((Boolean) r12).booleanValue());
        goto L119
    L11:
        d r13 = (d) r10.obj;
        l(r13.f2275a, r13.f2277c, r13.f2276b);
        CountDownLatch r9 = r13.f2278d;
        if (r9 == null) goto L119;
    L16:
        r9.countDown();
        goto L119
    L14:
        d r14 = (d) r10.obj;
        j(r14.f2275a);
        r9 = r14.f2278d;
        if (r9 == null) goto L119;
    L17:
        this.w.removeAll(this.o);
        List<g> r15 = w();
        this.o = r15;
        this.w.addAll(0, r15);
        goto L119
    L18:
        n((C0071e) r10.obj);
        goto L119
    L19:
        Object[] r16 = (Object[]) r10.obj;
        k(((Boolean) r16[0]).booleanValue(), (String) r16[1]);
        goto L119
    L20:
        E(null, true);
        goto L119
    L34:
        Object[] r17 = (Object[]) r10.obj;
        N((String) r17[0], (com.bytedance.applog.w.h) r17[1]);
        goto L119
    L35:
        ArrayList<com.bytedance.applog.w.a> r18 = this.f2270k;
        monitor-enter(r18);
        int r0 = com.bytedance.applog.q.a.c(this.f2270k);     // Catch: Throwable -> L40
        monitor-exit(r18);     // Catch: Throwable -> L40
        n.e("dump cache data count: " + r0);
        E(com.bytedance.applog.q.a.d(), false);
    L40:
        th = move-exception;
        throw th;
    L43:
        com.bytedance.applog.o.c r19 = this.u;
        if (r19.g() == true) goto L119;
        long r1 = r19.a(2);
        if (r19.g() == true) goto L119;
        this.n.sendEmptyMessageDelayed(9, r1 - System.currentTimeMillis());
        goto L119
    L48:
        ArrayList<com.bytedance.applog.w.a> r110 = (ArrayList) r10.obj;
        Iterator<com.bytedance.applog.w.a> r2 = r110.iterator();
    L50:
        if (r2.hasNext() == false) goto L54;
        com.bytedance.applog.w.a r3 = r2.next();
        if (r3.m() != 0) goto L50;
        r3.r(-1);
        goto L50
    L54:
        s().y(r110);
        goto L119
    L55:
        ArrayList<com.bytedance.applog.w.a> r4 = this.f2270k;
        monitor-enter(r4);
        this.f2270k.add(h.h());     // Catch: Throwable -> L60
        monitor-exit(r4);     // Catch: Throwable -> L60
        E(null, false);
    L60:
        th = move-exception;
        throw th;
    L63:
        this.n.removeMessages(6);
        long r5 = this.f2268i.p();
        if (this.f2268i.t().P() == true) goto L66;
    L67:
        long r6 = LocationRequestCompat.PASSIVE_INTERVAL;
        Iterator<com.bytedance.applog.o.c> r7 = this.w.iterator();
    L69:
        if (r7.hasNext() == false) goto L75;
        com.bytedance.applog.o.c r8 = r7.next();
        if (r8.g() == true) goto L69;
        long r20 = r8.a(r10.arg1);
        if (r20 >= r6) goto L69;
        r6 = r20;
        goto L69
    L75:
        r5 = r6 - System.currentTimeMillis();
    L76:
        Message r111 = this.n.obtainMessage(6);
        r111.arg1 = 2;
        this.n.sendMessageDelayed(r111, r5);
        if (this.z.size() <= 0) goto L119;
        List<c> r112 = this.z;
        monitor-enter(r112);
        Iterator<c> r21 = this.z.iterator();     // Catch: Throwable -> L89
    L82:
        if (r21.hasNext() == false) goto L86;
        c r22 = r21.next();     // Catch: Throwable -> L89
        if (r22 == null) goto L82;
        r22.a();     // Catch: Throwable -> L89
        goto L82
    L86:
        this.z.clear();     // Catch: Throwable -> L89
        monitor-exit(r112);     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        throw th;
    L66:
        if (this.q.j() == false) goto L76;
    L92:
        E((String[]) r10.obj, false);
        goto L119
    L93:
        this.D |= 16;
        m r113 = z();
        if (TextUtils.isEmpty(r113.g()) == true) goto L96;
        com.bytedance.applog.o.d r23 = new com.bytedance.applog.o.d(this);
        this.f2269j = r23;
        this.w.add(r23);
    L96:
        List<g> r24 = w();
        this.o = r24;
        this.w.addAll(r24);
        if (TextUtils.isEmpty(r113.d()) == true) goto L99;
        this.w.add(new i(this));
    L99:
        g();
        h();
        this.n.removeMessages(6);
        this.n.sendEmptyMessage(6);
        H();
        goto L119
    L114:
        this.D |= 1;
        com.bytedance.applog.q.b r114 = this.f2268i;
        r114.O(r114.E());
        if (this.f2268i.G() == false) goto L117;
        this.f2265f.d(new a(this));
    L117:
        n.e("start bdinstall service begin");
        this.f2265f.start();
        String r25 = "start bdinstall service end";
    L118:
        n.e(r25);
        goto L119
    L22:
        if (this.f2268i.D() == false) goto L31;
        if (this.f2268i.t().G() == false) goto L31;
        if (TextUtils.isEmpty(z().b()) == true) goto L31;
        if (this.p != null) goto L119;
        this.p = new com.bytedance.applog.o.a(this);
        this.w.add(this.p);
        R(this.p, 0);
    L31:
        if (this.p == null) goto L33;
        this.p.k(true);
        this.w.remove(this.p);
        this.p = null;
    L33:
        this.m.a();
        goto L119
    L101:
        if (this.f2268i.G() == false) goto L119;
        if (this.m.k() == false) goto L108;
        this.D |= 8;
        this.n = new Handler(this.f2266g, this);
        this.n.sendEmptyMessage(3);
        if (this.f2270k.size() <= 0) goto L107;
        this.s.removeMessages(4);
        this.s.sendEmptyMessageDelayed(4, 1000);
    L107:
        r25 = "net handler start work";
        goto L118
    L108:
        this.s.removeMessages(2);
        JSONObject r115 = new JSONObject();
        if (com.bytedance.bdinstall.i.j(r115) == true) goto L111;
    L113:
        this.s.sendEmptyMessageDelayed(2, 1000);
        goto L119
    L111:
        if (this.m.m(r115) == false) goto L113;
        this.m.t(r115);
        this.s.sendEmptyMessage(2);
        goto L119
    }

    public int i(com.bytedance.applog.w.a r3, com.bytedance.applog.w.a r4) {
        long r2 = r3.f2444g - r4.f2444g;
        if (r2 >= 0) goto L6;
        return -1;
    L6:
        if (r2 <= 0) goto L9;
        return 1;
    L9:
        return 0;
    }

    public void n(C0071e r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.f2279a.isEmpty() == true) goto L6;
    L7:
        s().D(r3.f2279a, r3.f2280b);
        com.bytedance.applog.o.b.k(r3.f2279a, r3.f2280b);
        return;
    L6:
        if (r3.f2280b.isEmpty() == false) goto L7;
    }

    public com.bytedance.applog.q.b q() {
        return this.f2268i;
    }

    public Context r() {
        return this.f2267h;
    }

    public com.bytedance.applog.w.b s() {
        if (this.f2271l != null) goto L15;
        monitor-enter(this);
        com.bytedance.applog.w.b r0 = this.f2271l;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        r0 = new com.bytedance.applog.w.b(this, q().t().k());     // Catch: Throwable -> L11
    L8:
        this.f2271l = r0;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.f2271l;
    }

    public com.bytedance.applog.q.c t() {
        return this.m;
    }

    public h x() {
        return this.q;
    }

    public m z() {
        if (this.r != null) goto L8;
        m r0 = q().t().B();
        this.r = r0;
        if (r0 != null) goto L8;
        this.r = o.a(0);
    L8:
        return this.r;
    }
}
