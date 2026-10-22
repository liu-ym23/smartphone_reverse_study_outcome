package p000j.k0.g;

import java.net.ProtocolException;
import k.e;
import k.f;
import k.j;
import k.q;
import p000j.d0;
import p000j.f0;
import p000j.g0;
import p000j.k0.f.c;
import p000j.k0.f.g;
import p000j.x;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f17872a;

    static final class a extends j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f17873g;

        a(k.x r1) {
            super(r1);
        }

        @Override // k.j, k.x
        public void J(e r3, long r4) {
            super.J(r3, r4);
            this.f17873g += r4;
        }
    }

    public b(boolean r1) {
        this.f17872a = r1;
    }

    @Override // p000j.x
    public f0 a(x.a r12) {
        g r13 = (g) r12;
        c r0 = r13.i();
        g r1 = r13.k();
        c r2 = (c) r13.e();
        d0 r3 = r13.b();
        long r4 = System.currentTimeMillis();
        r13.h().r(r13.g());
        r0.b(r3);
        r13.h().q(r13.g(), r3);
        f0.a r7 = null;
        if (f.b(r3.f()) == true) goto L5;
    L14:
        r0.a();
        if (r7 != null) goto L17;
        r13.h().v(r13.g());
        r7 = r0.d(false);
    L17:
        r7.p(r3);
        r7.h(r1.d().m());
        r7.q(r4);
        r7.o(System.currentTimeMillis());
        f0 r6 = r7.c();
        int r8 = r6.s();
        if (r8 != 100) goto L20;
        f0.a r5 = r0.d(false);
        r5.p(r3);
        r5.h(r1.d().m());
        r5.q(r4);
        r5.o(System.currentTimeMillis());
        r6 = r5.c();
        r8 = r6.s();
    L20:
        r13.h().u(r13.g(), r6);
        if (this.f17872a == true) goto L23;
    L25:
        f0.a r11 = r6.Q();
        g0 r14 = r0.c(r6);
    L26:
        r11.b(r14);
        f0 r15 = r11.c();
        if ("close".equalsIgnoreCase(r15.Y().c("Connection")) == false) goto L29;
    L30:
        r1.j();
    L32:
        if (r8 == 204) goto L36;
        if (r8 == 205) goto L36;
    L37:
        return r15;
    L36:
        if (r15.a().g() <= 0) goto L37;
        throw new ProtocolException("HTTP " + r8 + " had non-zero Content-Length: " + r15.a().g());
    L29:
        if ("close".equalsIgnoreCase(r15.A("Connection")) == false) goto L32;
    L23:
        if (r8 != 101) goto L25;
        r11 = r6.Q();
        r14 = p000j.k0.c.f17794c;
        goto L26
    L5:
        if (r3.a() == null) goto L14;
        if ("100-continue".equalsIgnoreCase(r3.c("Expect")) == false) goto L9;
        r0.e();
        r13.h().v(r13.g());
        r7 = r0.d(true);
    L9:
        if (r7 != null) goto L12;
        r13.h().p(r13.g());
        a r9 = new a(r0.f(r3, r3.a().a()));
        f r10 = q.a(r9);
        r3.a().f(r10);
        r10.close();
        r13.h().o(r13.g(), r9.f17873g);
        goto L14
    L12:
        if (r2.p() == true) goto L14;
        r1.j();
        goto L14
    }
}
