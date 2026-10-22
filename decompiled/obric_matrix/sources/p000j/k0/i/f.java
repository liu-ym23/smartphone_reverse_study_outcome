package p000j.k0.i;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.INetworkApi;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k.e;
import k.h;
import k.k;
import k.q;
import k.z;
import p000j.a0;
import p000j.b0;
import p000j.d0;
import p000j.f0;
import p000j.g0;
import p000j.k0.f.g;
import p000j.k0.g.c;
import p000j.k0.g.i;
import p000j.v;
import p000j.x;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<String> f17965f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f17966g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x.a f17967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g f17968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f17969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i f17970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b0 f17971e;

    class a extends k {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f17972g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f17973h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ f f17974i;

        a(f r1, z r2) {
            this.f17974i = r1;
            super(r2);
            this.f17972g = false;
            this.f17973h = 0;
        }

        private void b(IOException r8) {
            if (this.f17972g == false) goto L5;
            return;
        L5:
            this.f17972g = true;
            f r3 = this.f17974i;
            r3.f17968b.s(false, r3, this.f17973h, r8);
        }

        @Override // k.z
        public long Z(e r3, long r4) {
            long r5 = a().Z(r3, r4);     // Catch: IOException -> L6
            if (r5 <= 0) goto L5;
            this.f17973h += r5;     // Catch: IOException -> L6
        L5:
            return r5;
        L6:
            e = move-exception;
            b(e);
            throw e;
        }

        @Override // k.k, k.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            b(null);
        }
    }

    static {
        f17965f = p000j.k0.c.u(new String[]{WsConstants.KEY_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});
        f17966g = p000j.k0.c.u(new String[]{WsConstants.KEY_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    }

    public f(a0 r1, x.a r2, g r3, g r4) {
        this.f17967a = r2;
        this.f17968b = r3;
        this.f17969c = r4;
        List<b0> r5 = r1.C();
        b0 r6 = b0.f17676k;
        if (r5.contains(r6) == true) goto L6;
        r6 = b0.f17675j;
    L6:
        this.f17971e = r6;
    }

    public static List<c> g(d0 r6) {
        v r0 = r6.d();
        ArrayList r1 = new ArrayList(r0.k() + 4);
        r1.add(new c(c.f17935f, r6.f()));
        r1.add(new c(c.f17936g, i.c(r6.k())));
        String r2 = r6.c("Host");
        if (r2 == null) goto L5;
        r1.add(new c(c.f17938i, r2));
    L5:
        r1.add(new c(c.f17937h, r6.k().D()));
        int r7 = 0;
        int r3 = r0.k();
    L6:
        if (r7 >= r3) goto L11;
        h r4 = h.k(r0.f(r7).toLowerCase(Locale.US));
        if (f17965f.contains(r4.F()) == true) goto L10;
        r1.add(new c(r4, r0.m(r7)));
    L10:
        r7 = r7 + 1;
        goto L6
    L11:
        return r1;
    }

    public static f0.a h(v r7, b0 r8) {
        v.a r0 = new v.a();
        int r1 = r7.k();
        p000j.k0.g.k r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        String r4 = r7.f(r3);
        String r5 = r7.m(r3);
        if (r4.equals(":status") == false) goto L8;
        r2 = p000j.k0.g.k.a("HTTP/1.1 " + r5);
    L10:
        r3 = r3 + 1;
        goto L3
    L8:
        if (f17966g.contains(r4) == true) goto L10;
        p000j.k0.a.f17790a.b(r0, r4, r5);
        goto L10
    L11:
        if (r2 == null) goto L15;
        f0.a r9 = new f0.a();
        r9.n(r8);
        r9.g(r2.f17902b);
        r9.k(r2.f17903c);
        r9.j(r0.d());
        return r9;
    L15:
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // p000j.k0.g.c
    public void a() {
        this.f17970d.j().close();
    }

    @Override // p000j.k0.g.c
    public void b(d0 r4) {
        if (this.f17970d == null) goto L6;
        return;
    L6:
        if (r4.a() == null) goto L8;
        boolean r0 = true;
    L9:
        i r5 = this.f17969c.X(g(r4), r0);
        this.f17970d = r5;
        k.a0 r6 = r5.n();
        long r1 = this.f17967a.a();
        TimeUnit r2 = TimeUnit.MILLISECONDS;
        r6.g(r1, r2);
        this.f17970d.u().g(this.f17967a.c(), r2);
        return;
    L8:
        r0 = false;
        goto L9
    }

    @Override // p000j.k0.g.c
    public g0 c(f0 r5) {
        g r0 = this.f17968b;
        r0.f17863f.t(r0.f17862e);
        return new p000j.k0.g.h(r5.A(INetworkApi.CONTENT_TYPE), p000j.k0.g.e.b(r5), q.b(new a(this, this.f17970d.k())));
    }

    @Override // p000j.k0.g.c
    public void cancel() {
        i r1 = this.f17970d;
        if (r1 == null) goto L6;
        r1.h(b.f17931l);
        return;
    }

    @Override // p000j.k0.g.c
    public f0.a d(boolean r2) {
        f0.a r1 = h(this.f17970d.s(), this.f17971e);
        if (r2 == true) goto L5;
        return r1;
    L5:
        if (p000j.k0.a.f17790a.d(r1) != 100) goto L9;
        return null;
    L9:
        return r1;
    }

    @Override // p000j.k0.g.c
    public void e() {
        this.f17969c.flush();
    }

    @Override // p000j.k0.g.c
    public k.x f(d0 r1, long r2) {
        return this.f17970d.j();
    }
}
