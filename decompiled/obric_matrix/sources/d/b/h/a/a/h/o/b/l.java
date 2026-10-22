package d.b.h.a.a.h.o.b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import org.json.JSONObject;
import p000j.b0;
import p000j.d0;
import p000j.f0;

/* JADX INFO: loaded from: classes.dex */
public class l extends p000j.s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f13503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p000j.s f13504c;

    public l(p000j.s r1, n r2) {
        this.f13504c = r1;
        this.f13503b = r2;
    }

    @Override // p000j.s
    public void a(p000j.e r2) {
        super.a(r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        this.f13503b.a();
    }

    @Override // p000j.s
    public void b(p000j.e r2, IOException r3) {
        super.b(r2, r3);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.b(r2, r3);
    L5:
        this.f13503b.b(r3);
    }

    @Override // p000j.s
    public void c(p000j.e r1, JSONObject r2) {
        super.c(r1, r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.c(r1, r2);
    L5:
        d.b.h.a.a.h.o.a r3 = s.p();
        if (r3 == null) goto L9;
        r3.sendAppMonitorEvent(r2.toString(), "ttnet_insec_rect");
        return;
    }

    @Override // p000j.s
    public void d(p000j.e r2) {
        super.d(r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.d(r2);
    L5:
        this.f13503b.c();
    }

    @Override // p000j.s
    public void e(p000j.e r2, InetSocketAddress r3, Proxy r4, b0 r5) {
        super.e(r2, r3, r4, r5);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.e(r2, r3, r4, r5);
    L5:
        this.f13503b.d(r4);
    }

    @Override // p000j.s
    public void f(p000j.e r7, InetSocketAddress r8, Proxy r9, b0 r10, IOException r11) {
        super.f(r7, r8, r9, r10, r11);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L6;
        r0.f(r7, r8, r9, r10, r11);
        return;
    }

    @Override // p000j.s
    public void g(p000j.e r7, InetSocketAddress r8, Proxy r9, b0 r10, IOException r11, String r12) {
        super.g(r7, r8, r9, r10, r11, r12);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.f(r7, r8, r9, r10, r11);
    L5:
        this.f13503b.e(r8, r11, r12);
    }

    @Override // p000j.s
    public void h(p000j.e r2, InetSocketAddress r3, Proxy r4) {
        super.h(r2, r3, r4);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.h(r2, r3, r4);
    L5:
        this.f13503b.f();
    }

    @Override // p000j.s
    public void i(p000j.e r2, p000j.j r3) {
        super.i(r2, r3);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.i(r2, r3);
    L5:
        this.f13503b.g(r3);
    }

    @Override // p000j.s
    public void j(p000j.e r1, p000j.j r2) {
        super.j(r1, r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L6;
        r0.j(r1, r2);
        return;
    }

    @Override // p000j.s
    public void k(p000j.e r2, String r3, List<InetAddress> r4) {
        super.k(r2, r3, r4);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.k(r2, r3, r4);
    L5:
        this.f13503b.l();
    }

    @Override // p000j.s
    public void l(p000j.e r2, String r3, List<InetAddress> r4, String r5) {
        super.l(r2, r3, r4, r5);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.k(r2, r3, r4);
    L5:
        this.f13503b.m(r5);
    }

    @Override // p000j.s
    public void m(p000j.e r2, String r3) {
        super.m(r2, r3);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.m(r2, r3);
    L5:
        this.f13503b.n();
    }

    @Override // p000j.s
    public void o(p000j.e r2, long r3) {
        super.o(r2, r3);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.o(r2, r3);
    L5:
        this.f13503b.t(r3);
    }

    @Override // p000j.s
    public void p(p000j.e r2) {
        super.p(r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.p(r2);
    L5:
        this.f13503b.u();
    }

    @Override // p000j.s
    public void q(p000j.e r2, d0 r3) {
        super.q(r2, r3);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.q(r2, r3);
    L5:
        this.f13503b.v(r3);
    }

    @Override // p000j.s
    public void r(p000j.e r2) {
        super.r(r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.r(r2);
    L5:
        this.f13503b.w();
    }

    @Override // p000j.s
    public void s(p000j.e r2, long r3) {
        super.s(r2, r3);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.s(r2, r3);
    L5:
        this.f13503b.x(r3);
    }

    @Override // p000j.s
    public void t(p000j.e r2) {
        super.t(r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.t(r2);
    L5:
        this.f13503b.y();
    }

    @Override // p000j.s
    public void u(p000j.e r2, f0 r3) {
        super.u(r2, r3);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.u(r2, r3);
    L5:
        this.f13503b.z(r3);
    }

    @Override // p000j.s
    public void v(p000j.e r2) {
        super.v(r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.v(r2);
    L5:
        this.f13503b.A();
    }

    @Override // p000j.s
    public void w(p000j.e r2, p000j.u r3) {
        super.w(r2, r3);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.w(r2, r3);
    L5:
        this.f13503b.B();
    }

    @Override // p000j.s
    public void x(p000j.e r2) {
        super.x(r2);
        p000j.s r0 = this.f13504c;
        if (r0 == null) goto L5;
        r0.x(r2);
    L5:
        this.f13503b.C();
    }
}
