package d.b.h.a.a.h.o.b;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p000j.a0;
import p000j.d0;
import p000j.e0;
import p000j.f0;
import p000j.h0;
import p000j.y;

/* JADX INFO: loaded from: classes.dex */
public class f extends d.b.h.a.a.h.m.b implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    a0 f13492l;
    d0 m;
    f0 n;
    p000j.e o;
    volatile n p;
    private final WeakHandler q;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f13493f;

        a(f r1) {
            this.f13493f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            f r1 = this.f13493f;
            f.U(r1, r1.p.q());
        }
    }

    class b extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f13494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.b.r.k0.j f13495b;

        b(y r1, d.b.r.k0.j r2) {
            this.f13494a = r1;
            this.f13495b = r2;
        }

        @Override // p000j.e0
        public long a() {
            return this.f13495b.length();
        }

        @Override // p000j.e0
        public y b() {
            return this.f13494a;
        }

        @Override // p000j.e0
        public void f(k.f r1) {
            this.f13495b.b(r1.e0());
        }
    }

    public f(d.b.r.h0.c r3) {
        super(r3);
        this.f13492l = null;
        this.p = null;
        d.b.h.a.a.h.b r4 = this.f13419g;     // Catch: Exception -> L9
        r4.B = 1;     // Catch: Exception -> L9
        r4.F.put("hc", "SsOkHttp3Client");     // Catch: Exception -> L9
        this.f13419g.F.put("hcv", s.q());     // Catch: Exception -> L9
    L4:
        d.b.h.a.a.h.b r5 = this.f13419g;
        r5.C = s.l();
        d.b.h.a.a.h.b r6 = this.f13419g;
        r6.D = s.k();
        d.b.h.a.a.h.b r7 = this.f13419g;
        d.b.r.y r0 = r7.Y;
        if (r0 == null) goto L7;
        r0.f14619f = r7.C;
        r0.f14620g = r7.D;
    L7:
        this.q = new WeakHandler(d.b.h.a.a.h.o.b.x.e.q().k().getLooper(), this);
        String r8 = this.f13418f.G();
        this.p = new n();
        this.p.E(r8, this.f13418f.y());
    }

    static /* synthetic */ void U(f r0, boolean r1) {
        r0.V(r1);
    }

    private void V(boolean r2) {
        if (r2 == false) goto L4;
        d.b.h.a.a.h.m.b.A(this.f13419g, this);
    L5:
        T r3 = this.f13419g.f13358e;
        if (r3 != 0) goto L8;
    L9:
        d.b.h.a.a.h.g.A(this.f13418f.G(), this.f13419g);
        return;
    L8:
        if (r3.w == true) goto L9;
        return;
    L4:
        d.b.h.a.a.h.m.b.A(this.f13419g, null);
        goto L5
    }

    private void W(d.b.r.h0.c r10, d.b.h.a.a.h.b r11, Map<String, String> r12) {
        a0.b r0 = this.f13492l.v();
        T r1 = r11.f13358e;
        if (r1 == 0) goto L5;
        r0.j(r1.u);
    L5:
        long r2 = d.b.h.a.a.h.g.i();
        TimeUnit r3 = TimeUnit.MILLISECONDS;
        r0.d(r2, r3);
        r0.n(d.b.h.a.a.h.g.o(), r3);
        r0.s(d.b.h.a.a.h.g.o(), r3);
        r0.l(s.r());
        r0.h(d.b.h.a.a.h.s.c.h());
        d.b.h.a.a.h.c r4 = r11.f13358e;
        if (r4 == null) goto L30;
        long r5 = r4.f13368c;
        if (r5 <= 0) goto L10;
        r0.d(r5, r3);
    L10:
        long r6 = r4.f13370e;
        if (r6 <= 0) goto L13;
        r0.s(r6, r3);
    L13:
        long r7 = r4.f13369d;
        if (r7 <= 0) goto L17;
        r0.n(r7, r3);
    L17:
        if (r4.z == false) goto L19;
        r0.l(Proxy.NO_PROXY);
    L19:
        final d.b.h.a.a.h.c.a r8 = r4.A;
        if (r8 != null) goto L22;
    L26:
        d.b.h.a.a.h.c.b r9 = r4.B;
        if (r9 == null) goto L29;
        r9.a(r0);
    L29:
        this.p.G(r4);
        goto L30
    L22:
        if (r8.f13378a == null) goto L26;
        if (r8.f13379b == null) goto L26;
        r0.m(new d.b.h.a.a.h.o.b.a(r8));
    L30:
        String r13 = r10.G();
        String r14 = null;
        if (this.f13492l.n() == null) goto L33;
        a0 r15 = this.f13492l;
        d0.a r16 = new d0.a();
        r16.k(r13);
        p000j.s r17 = this.f13492l.n().a(r15.w(r16.b()));
    L34:
        r0.i(new l(r17, this.p));
        this.f13492l = r0.c();
        ArrayList r18 = new ArrayList();
        if (r10.K() == false) goto L96;
    L37:
        List<d.b.r.h0.b> r19 = new ArrayList();
        long r20 = SystemClock.uptimeMillis();
        d.b.h.a.a.h.o.b.y.b r21 = new d.b.h.a.a.h.o.b.y.b();
        String r22 = d.b.h.a.a.h.o.b.y.c.b().a(r13, r10, r21, r19);
        r21.f13632e = SystemClock.uptimeMillis() - r20;
        this.p.s(r21);
        if (r19.isEmpty() == false) goto L40;
        r19 = r10.v();
    L40:
        String r23 = d.b.h.a.a.h.s.c.o(s.i(), r22, r19);
        d0.a r24 = new d0.a();
        r24.k(r23);
        Iterator<d.b.r.h0.b> r25 = r18.iterator();
    L42:
        if (r25.hasNext() == false) goto L45;
        d.b.r.h0.b r26 = r25.next();
        r24.a(r26.a(), r26.b());
        goto L42
    L45:
        if (Logger.debug() == false) goto L48;
        r24.a("fallback-reason", s.m(r10));
    L48:
        if (p000j.k0.g.f.b(r10.y()) == true) goto L50;
        r24.f(r10.y(), null);
    L52:
        if (r10.s() != null) goto L54;
    L58:
        r24.a("Accept-Encoding", "gzip");
        Iterator<d.b.r.h0.b> r110 = r19.iterator();
    L60:
        if (r110.hasNext() == false) goto L71;
        d.b.r.h0.b r27 = r110.next();
        if (com.bytedance.common.utility.k.c(r27.a()) == true) goto L60;
        if (com.bytedance.common.utility.k.c(r27.b()) == true) goto L60;
        if ("User-Agent".equals(r27.a()) == false) goto L69;
        r14 = r27.b();
    L69:
        r24.d(r27.a(), r27.b());
        goto L60
    L71:
        if (com.bytedance.common.utility.k.c(r14) == false) goto L76;
        r14 = d.b.h.a.a.h.g.r();
        if (com.bytedance.common.utility.k.c(r14) == true) goto L76;
        r14 = r14 + " " + s.q();
        r24.d("User-Agent", r14);
    L76:
        if (com.bytedance.common.utility.k.c(r14) == false) goto L98;
        r14 = s.j();
        if (TextUtils.isEmpty(r14) == true) goto L98;
        r24.d("User-Agent", r14);
    L98:
        r11.F.put("ua", r14);     // Catch: Exception -> L95
    L81:
        if (r12 != null) goto L83;
    L92:
        d0 r111 = r24.b();
        this.m = r111;
        this.o = this.f13492l.w(r111);
        return;
    L83:
        if (r12.isEmpty() == true) goto L92;
        Iterator<Map.Entry<String, String>> r112 = r12.entrySet().iterator();
    L86:
        if (r112.hasNext() == false) goto L92;
        Map.Entry<String, String> r113 = r112.next();
        String r114 = r113.getKey();
        String r115 = r113.getValue();
        if (TextUtils.isEmpty(r114) == true) goto L86;
        if (TextUtils.isEmpty(r115) == true) goto L86;
        r24.a(r114, r115);
        goto L86
    L54:
        if (r10.L() == true) goto L58;
        String r116 = r10.s().e();
        if (r116 == null) goto L58;
        r24.a("X-SS-STUB", r116);
        goto L58
    L50:
        r24.f(r10.y(), Y(r10.s(), r10.D()));
        goto L52
    L96:
        r13 = Z(r13, r10.y(), r18);     // Catch: Exception -> L94
        goto L37
    L33:
        r17 = null;
        goto L34
    }

    private void X() {
        this.f13492l = s.h();
    }

    private static e0 Y(d.b.r.k0.j r1, e0 r2) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        if (r1 != null) goto L8;
        return e0.c(null, "body=null");
    L8:
        return new b(y.d(r1.a()), r1);
    }

    private String Z(String r12, String r13, List<d.b.r.h0.b> r14) {
        if (d.b.h.a.a.h.o.b.z.l.m().n() == true) goto L21;
        long r0 = System.currentTimeMillis();
        d.b.h.a.a.h.o.b.z.e r15 = d.b.h.a.a.h.o.b.z.l.m().e(new d.b.h.a.a.h.o.b.z.m(r12, r13, r14));
        long r2 = System.currentTimeMillis();
        if (r15 == null) goto L27;
        this.p.r(this.f13418f.y(), r15.f13664a, r2 - r0, false, r15.f13666c);
        if (r12.equals(r15.f13664a) == false) goto L9;
        return r12;
    L9:
        if (r15.f13664a.isEmpty() == false) goto L19;
        if (r15.f13665b.isEmpty() == true) goto L19;
        this.p.D(r15.f13667d);
        StringBuilder r16 = new StringBuilder();
        r16.append("ERR_TTNET_TRAFFIC_CONTROL_DROP");
        if (r15.f13667d != (-555)) goto L15;
        String r17 = "";
    L16:
        r16.append(r17);
        r16.append(", ");
        r16.append(r15.f13667d);
        throw new Exception(r16.toString());
    L15:
        r17 = "_" + (-r15.f13667d);
    L19:
        if (d.b.h.a.a.h.s.l.f(r15.f13664a) == true) goto L30;
        return r12;
    L30:
        return r15.f13664a;
    L27:
        return r12;
    L21:
        Logger.debug();
        long r18 = System.currentTimeMillis();
        String r1 = d.b.h.a.a.h.o.b.z.l.m().l(r12);
        long r3 = System.currentTimeMillis();
        if (r12.equals(r1) == false) goto L24;
        return r12;
    L24:
        if (d.b.h.a.a.h.s.l.f(r1) == false) goto L32;
        this.p.r(this.f13418f.y(), r1, r3 - r18, true, null);
        return r1;
    L32:
        return r12;
    }

    static /* synthetic */ d0 a0(d.b.h.a.a.h.c.a r4, h0 r5, f0 r6) {
        Iterator<p000j.h> r7 = r6.l().iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        p000j.h r0 = r7.next();
        if ("Basic".equalsIgnoreCase(r0.b()) == false) goto L4;
        String r8 = p000j.p.a(r4.f13378a, r4.f13379b, r0.a());
        if (TextUtils.equals(r8, r6.Y().c("Proxy-Authorization")) == false) goto L11;
        return null;
    L11:
        d0.a r9 = r6.Y().g();
        r9.d("Proxy-Authorization", r8);
        return r9.b();
    L13:
        return null;
    }

    @Override // d.b.h.a.a.h.m.b
    protected int B(IOException r1) {
        return p000j.l0.e.c(r1);
    }

    @Override // d.b.h.a.a.h.m.b
    protected void E() {
        if (s.n() == true) goto L6;
        return;
    L6:
        throw new d.b.h.a.a.h.l.g("request is not allowed using network");
    }

    @Override // d.b.h.a.a.h.m.b
    protected void F(d.b.h.a.a.h.b r1, d.b.h.a.a.h.m.h r2) {
        super.F(r1, r2);
        if (s.o() == null) goto L6;
        s.o().a(this.m, this.n);
        return;
    }

    @Override // d.b.h.a.a.h.m.b
    protected void G(Exception r2) {
        if (s.o() == null) goto L6;
        s.o().c(this.m, r2);
        return;
    }

    @Override // d.b.h.a.a.h.m.b
    protected void H(d.b.r.k0.i r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f13418f.N() == false) goto L6;
        return;
    L6:
        if ((r3 instanceof d.b.r.k0.g) == false) goto L14;
        d.b.h.a.a.h.r.b.n().u(this.n, this.f13418f.G(), ((d.b.r.k0.g) r3).k());     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    @Override // d.b.h.a.a.h.m.b
    protected void I(String r8, d.b.r.h0.c r9, d.b.h.a.a.h.b r10, Map<String, String> r11) {
        X();     // Catch: Exception -> L4
        W(r9, r10, r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.b.h.a.a.h.m.b.T(r9.G(), r10, this, this, e);
        if ((e instanceof d.b.r.l0.d) == true) goto L8;
        d.b.r.l0.d r7 = new d.b.r.l0.d(e.getMessage(), e.getCause());
        r7.a(true, false, true, r9.G(), r10.Z, r10);
        throw r7;
    L8:
        throw ((IOException) e);
    }

    @Override // d.b.r.l0.c
    public void a(Throwable r4, boolean r5) {
        p000j.e r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.g() == true) goto L15;
        this.o.cancel();
        this.f13421i = true;
        d.b.h.a.a.h.b r1 = this.f13419g;
        r1.m = System.currentTimeMillis();
        d.b.h.a.a.h.b r2 = this.f13419g;
        T r3 = r2.f13358e;
        if (r3 != 0) goto L10;
    L11:
        d.b.h.a.a.h.g.E(this.f13418f, r2, r4, Boolean.valueOf(r5));
        return;
    L10:
        if (r3.w == true) goto L11;
        return;
    }

    @Override // d.b.h.a.a.h.m.j
    public void b(d.b.h.a.a.h.b r2) {
        if (this.p == null) goto L6;
        this.p.F(r2, s.i());
        return;
    }

    @Override // d.b.r.h0.e
    public void cancel() {
        p000j.e r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.g() == true) goto L17;
        this.o.cancel();
        this.f13421i = true;
        if (this.f13418f.N() == false) goto L15;
        d.b.h.a.a.h.b r1 = this.f13419g;
        r1.m = System.currentTimeMillis();
        if (this.p.q() == true) goto L12;
        this.q.postDelayed(new a(this), 500);
        return;
    L12:
        V(true);
        return;
    L15:
        return;
    }

    @Override // d.b.r.h0.e
    public boolean d(long r1) {
        return false;
    }

    @Override // d.b.h.a.a.h.m.b
    protected boolean e() {
        return this.f13420h;
    }

    @Override // d.b.h.a.a.h.m.b
    protected IOException h(Exception r18) {
        if ((r18 instanceof d.b.r.l0.d) == false) goto L6;
        d.b.r.l0.d r1 = (d.b.r.l0.d) r18;
        String r7 = this.f13418f.G();
        d.b.h.a.a.h.b r9 = this.f13419g;
        r1.a(true, false, true, r7, r9.Z, r9);
        return r1;
    L6:
        d.b.r.l0.d r2 = new d.b.r.l0.d(r18.getMessage(), r18.getCause());
        String r14 = this.f13418f.G();
        d.b.h.a.a.h.b r0 = this.f13419g;
        r2.a(true, false, true, r14, r0.Z, r0);
        return r2;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    @Override // d.b.h.a.a.h.m.h
    public InputStream k() {
        f0 r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.a() == null) goto L7;
        return this.n.a().a();
    }

    @Override // d.b.h.a.a.h.m.h
    public int l() {
        f0 r0 = this.n;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.s();
    }

    @Override // d.b.h.a.a.h.m.h
    public String m(String r1) {
        f0 r0 = this.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.A(r1);
    }

    @Override // d.b.h.a.a.h.m.h
    public InputStream n() {
        return null;
    }

    @Override // d.b.h.a.a.h.m.h
    public String o() {
        f0 r0 = this.n;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.a() == null) goto L12;
        y r2 = this.n.a().l();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.toString();
    L12:
        return null;
    }

    @Override // d.b.h.a.a.h.m.h
    public boolean p() {
        return "gzip".equalsIgnoreCase(this.n.A("Content-Encoding"));
    }

    @Override // d.b.h.a.a.h.m.h
    public long q() {
        f0 r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r0.a() == null) goto L7;
        return this.n.a().g();
    }

    @Override // d.b.h.a.a.h.m.h
    public String r() {
        f0 r0 = this.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.N();
    }

    @Override // d.b.h.a.a.h.m.h
    public boolean s() {
        f0 r0 = this.n;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.g() != null) goto L9;
        return false;
    L9:
        if (this.n.O() != null) goto L11;
        return true;
    L11:
        if (this.n.s() == 304) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // d.b.h.a.a.h.m.h
    public void t() {
        f0 r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        p000j.e r1 = this.o;
        if (r1 == null) goto L11;
        r1.cancel();
        return;
    L11:
        return;
    L5:
        if (r0.a() == null) goto L7;
        d.b.h.a.a.h.p.f.l(this.n.a());
        goto L7
    }

    @Override // d.b.h.a.a.h.m.h
    public Map<String, List<String>> u() {
        f0 r0 = this.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.F().l();
    }

    @Override // d.b.h.a.a.h.m.b
    protected void v() {
        p000j.e r0 = this.o;
        if (r0 == null) goto L6;
        this.n = r0.execute();
        this.p.H(this.n);
        return;
    }

    @Override // d.b.h.a.a.h.m.b
    protected Context x() {
        return s.i();
    }
}
