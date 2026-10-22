package d.b.r.j0;

import d.b.r.d;
import d.b.r.d0;
import d.b.r.h0.c;
import d.b.r.x;
import d.b.r.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements a.InterfaceC0391a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f14407g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f14408h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f14409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f14411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.b.r.b f14412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y f14414f;

    static {
    }

    public b(List<a> r1, int r2, c r3, d.b.r.b r4, y r5) {
        this.f14409a = r1;
        this.f14410b = r2;
        this.f14411c = r3;
        this.f14412d = r4;
        this.f14414f = r5;
    }

    public static boolean e() {
        return f14407g;
    }

    public static void f(boolean r0) {
        f14407g = r0;
    }

    @Override // d.b.r.j0.a.InterfaceC0391a
    public y a() {
        return this.f14414f;
    }

    @Override // d.b.r.j0.a.InterfaceC0391a
    public c b() {
        return this.f14411c;
    }

    @Override // d.b.r.j0.a.InterfaceC0391a
    public d0 c(c r11) {
        if (this.f14410b >= this.f14409a.size()) goto L40;
        int r0 = this.f14413e + 1;
        this.f14413e = r0;
        if (r0 <= 1) goto L12;
        Iterator<a> r1 = this.f14409a.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        a r2 = r1.next();
        if ((r2 instanceof d) == false) goto L8;
        ((d) r2).k();
    L12:
        List<a> r3 = this.f14409a;
        int r9 = this.f14410b;
        b r4 = new b(r3, r9 + 1, r11, this.f14412d, this.f14414f);
        a r5 = r3.get(r9);
        if (f14408h == true) goto L20;
        StringBuilder r6 = new StringBuilder();
        r6.append("interceptor = ");
        if (r5 == null) goto L17;
        String r7 = r5.toString();
    L18:
        r6.append(r7);
        r6.append(" url = ");
        r6.append(r11.G());
        x.a("RealInterceptorChain", r6.toString());
        goto L20
    L17:
        r7 = "";
    L20:
        if (r5 == null) goto L38;
        y r8 = this.f14414f;
        if (r8 == null) goto L24;
        r8.g();
        this.f14414f.h(r5);
    L24:
        d0 r10 = r5.a(r4);
        y r12 = this.f14414f;
        if (r12 == null) goto L29;
        r12.i();
        int r13 = this.f14410b;
        if (r13 <= 0) goto L29;
        this.f14414f.j(this.f14409a.get(r13 - 1));
    L29:
        if (r10 == null) goto L36;
        if (r10.g() == null) goto L34;
        return r10;
    L34:
        throw new IllegalStateException("interceptor " + r5 + " returned a ssResponse with no body");
    L36:
        throw new NullPointerException("interceptor " + r5 + " returned null");
    L38:
        throw new NullPointerException("interceptor " + this.f14410b + " is null");
    L40:
        throw new AssertionError();
    }

    @Override // d.b.r.j0.a.InterfaceC0391a
    public d0 d(c r11) {
        if (this.f14410b >= this.f14409a.size()) goto L40;
        int r0 = this.f14413e + 1;
        this.f14413e = r0;
        if (r0 <= 1) goto L12;
        Iterator<a> r1 = this.f14409a.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        a r2 = r1.next();
        if ((r2 instanceof d) == false) goto L8;
        ((d) r2).k();
    L12:
        List<a> r3 = this.f14409a;
        int r9 = this.f14410b;
        b r4 = new b(r3, r9 + 1, r11, this.f14412d, this.f14414f);
        a r5 = r3.get(r9);
        if (f14408h == true) goto L20;
        StringBuilder r6 = new StringBuilder();
        r6.append("interceptor = ");
        if (r5 == null) goto L17;
        String r7 = r5.toString();
    L18:
        r6.append(r7);
        r6.append(" url = ");
        r6.append(r11.G());
        x.a("RealInterceptorChain", r6.toString());
        goto L20
    L17:
        r7 = "";
    L20:
        if (r5 == null) goto L38;
        y r8 = this.f14414f;
        if (r8 == null) goto L24;
        r8.g();
        this.f14414f.h(r5);
    L24:
        d0 r10 = r5.a(r4);
        y r12 = this.f14414f;
        if (r12 == null) goto L29;
        r12.i();
        int r13 = this.f14410b;
        if (r13 <= 0) goto L29;
        this.f14414f.j(this.f14409a.get(r13 - 1));
    L29:
        if (r10 == null) goto L36;
        if (r10.g() == null) goto L34;
        return r10;
    L34:
        throw new IllegalStateException("interceptor " + r5 + " returned a ssResponse with no body");
    L36:
        throw new NullPointerException("interceptor " + r5 + " returned null");
    L38:
        throw new NullPointerException("interceptor " + this.f14410b + " is null");
    L40:
        throw new AssertionError();
    }
}
