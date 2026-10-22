package p000j.k0.e;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.matrix.common_api.INetworkApi;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import k.a0;
import k.e;
import k.f;
import k.g;
import k.q;
import k.z;
import p000j.b0;
import p000j.d0;
import p000j.f0;
import p000j.k0.c;
import p000j.k0.g.h;
import p000j.v;
import p000j.x;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d f17806a;

    /* JADX INFO: renamed from: j.k0.e.a$a, reason: collision with other inner class name */
    class C0466a implements z {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f17807f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f17808g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f17809h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ f f17810i;

        C0466a(a r1, g r2, b r3, f r4) {
            this.f17808g = r2;
            this.f17809h = r3;
            this.f17810i = r4;
        }

        @Override // k.z
        public long Z(e r9, long r10) {
            long r11 = this.f17808g.Z(r9, r10);     // Catch: IOException -> L12
            if (r11 == (-1)) goto L7;
            r9.L(this.f17810i.c(), r9.k0() - r11, r11);
            this.f17810i.z();
            return r11;
        L7:
            if (this.f17807f == true) goto L9;
            this.f17807f = true;
            this.f17810i.close();
        L9:
            return -1;
        L12:
            e = move-exception;
            if (this.f17807f == true) goto L16;
            this.f17807f = true;
            this.f17809h.a();
        L16:
            throw e;
        }

        @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f17807f == false) goto L5;
        L7:
            this.f17808g.close();
            return;
        L5:
            if (c.p(this, 100, TimeUnit.MILLISECONDS) == true) goto L7;
            this.f17807f = true;
            this.f17809h.a();
            goto L7
        }

        @Override // k.z
        public a0 e() {
            return this.f17808g.e();
        }
    }

    public a(d r1) {
        this.f17806a = r1;
    }

    private f0 b(b r4, f0 r5) {
        if (r4 != null) goto L4;
        return r5;
    L4:
        k.x r0 = r4.b();
        if (r0 != null) goto L7;
        return r5;
    L7:
        C0466a r2 = new C0466a(this, r5.a().A(), r4, q.a(r0));
        String r3 = r5.A(INetworkApi.CONTENT_TYPE);
        long r1 = r5.a().g();
        f0.a r6 = r5.Q();
        r6.b(new h(r3, r1, q.b(r2)));
        return r6.c();
    }

    private static v c(v r7, v r8) {
        v.a r0 = new v.a();
        int r1 = r7.k();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        String r4 = r7.f(r3);
        String r5 = r7.m(r3);
        if ("Warning".equalsIgnoreCase(r4) == false) goto L10;
        if (r5.startsWith(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L10;
    L16:
        r3 = r3 + 1;
    L10:
        if (d(r4) == false) goto L12;
    L15:
        p000j.k0.a.f17790a.b(r0, r4, r5);
        goto L16
    L12:
        if (e(r4) == false) goto L15;
        if (r8.d(r4) != null) goto L16;
    L17:
        int r9 = r8.k();
    L18:
        if (r2 >= r9) goto L26;
        String r6 = r8.f(r2);
        if (d(r6) == true) goto L24;
        if (e(r6) == false) goto L24;
        p000j.k0.a.f17790a.b(r0, r6, r8.m(r2));
    L24:
        r2 = r2 + 1;
        goto L18
    L26:
        return r0.d();
    }

    static boolean d(String r1) {
        if ("Content-Length".equalsIgnoreCase(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if ("Content-Encoding".equalsIgnoreCase(r1) == true) goto L10;
        if (INetworkApi.CONTENT_TYPE.equalsIgnoreCase(r1) == true) goto L10;
        return false;
    }

    static boolean e(String r1) {
        if ("Connection".equalsIgnoreCase(r1) == false) goto L5;
    L19:
        return false;
    L5:
        if ("Keep-Alive".equalsIgnoreCase(r1) == true) goto L19;
        if ("Proxy-Authenticate".equalsIgnoreCase(r1) == true) goto L19;
        if ("Proxy-Authorization".equalsIgnoreCase(r1) == true) goto L19;
        if ("TE".equalsIgnoreCase(r1) == true) goto L19;
        if ("Trailers".equalsIgnoreCase(r1) == true) goto L19;
        if ("Transfer-Encoding".equalsIgnoreCase(r1) == true) goto L19;
        if ("Upgrade".equalsIgnoreCase(r1) == true) goto L19;
        return true;
    }

    private static f0 f(f0 r1) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.a() == null) goto L8;
        f0.a r2 = r1.Q();
        r2.b(null);
        return r2.c();
    L8:
        return r1;
    }

    @Override // p000j.x
    public f0 a(x.a r6) {
        d r0 = this.f17806a;
        if (r0 == null) goto L5;
        f0 r1 = r0.e(r6.b());
    L6:
        c r2 = new c.a(System.currentTimeMillis(), r6.b(), r1).c();
        d0 r3 = r2.f17811a;
        f0 r4 = r2.f17812b;
        d r5 = this.f17806a;
        if (r5 == null) goto L9;
        r5.b(r2);
    L9:
        if (r1 == null) goto L12;
        if (r4 != null) goto L12;
        c.g(r1.a());
    L12:
        if (r3 != null) goto L16;
        if (r4 != null) goto L16;
        f0.a r7 = new f0.a();
        r7.p(r6.b());
        r7.n(b0.f17673h);
        r7.g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
        r7.k("Unsatisfiable Request (only-if-cached)");
        r7.b(c.f17794c);
        r7.q(-1);
        r7.o(System.currentTimeMillis());
        return r7.c();
    L16:
        if (r3 != null) goto L46;
        f0.a r8 = r4.Q();
        r8.d(f(r4));
        return r8.c();
    L46:
        f0 r9 = r6.d(r3);     // Catch: Throwable -> L41
        if (r9 != null) goto L23;
        if (r1 == null) goto L23;
        c.g(r1.a());
    L23:
        if (r4 != null) goto L25;
    L29:
        f0.a r10 = r9.Q();
        r10.d(f(r4));
        r10.l(f(r9));
        f0 r11 = r10.c();
        if (this.f17806a != null) goto L32;
    L40:
        return r11;
    L32:
        if (p000j.k0.g.e.c(r11) == false) goto L38;
        if (c.a(r11, r3) == false) goto L38;
        return b(this.f17806a.d(r11), r11);
    L38:
        if (p000j.k0.g.f.a(r3.f()) == false) goto L40;
        this.f17806a.c(r3);     // Catch: IOException -> L45
        goto L40
    L25:
        if (r9.s() != 304) goto L28;
        f0.a r12 = r4.Q();
        r12.j(c(r4.F(), r9.F()));
        r12.q(r9.d0());
        r12.o(r9.X());
        r12.d(f(r4));
        r12.l(f(r9));
        f0 r13 = r12.c();
        r9.a().close();
        this.f17806a.a();
        this.f17806a.f(r4, r13);
        return r13;
    L28:
        c.g(r4.a());
    L41:
        th = move-exception;
        if (r1 == null) goto L44;
        c.g(r1.a());
    L44:
        throw th;
    L5:
        r1 = null;
        goto L6
    }
}
