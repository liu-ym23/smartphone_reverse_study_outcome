package p000j.k0.h;

import com.obric.matrix.common_api.INetworkApi;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import k.l;
import k.q;
import k.x;
import k.z;
import p000j.a0;
import p000j.d0;
import p000j.f0;
import p000j.g0;
import p000j.k0.g.h;
import p000j.k0.g.i;
import p000j.k0.g.k;
import p000j.v;
import p000j.w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements p000j.k0.g.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a0 f17904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final p000j.k0.f.g f17905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final k.g f17906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final k.f f17907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f17908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17909f;

    /* JADX INFO: renamed from: j.k0.h.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0467a {
    }

    private abstract class b implements z {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected final l f17910f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected boolean f17911g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected long f17912h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f17913i;

        private b(a r3) {
            this.f17913i = r3;
            this.f17910f = new l(r3.f17906c.e());
            this.f17912h = 0;
        }

        /* synthetic */ b(a r1, C0467a r2) {
            this(r1);
        }

        @Override // k.z
        public long Z(k.e r3, long r4) {
            long r5 = this.f17913i.f17906c.Z(r3, r4);     // Catch: IOException -> L6
            if (r5 <= 0) goto L5;
            this.f17912h += r5;     // Catch: IOException -> L6
        L5:
            return r5;
        L6:
            e = move-exception;
            a(false, e);
            throw e;
        }

        protected final void a(boolean r10, IOException r11) {
            a r0 = this.f17913i;
            int r1 = r0.f17908e;
            if (r1 != 6) goto L6;
            return;
        L6:
            if (r1 != 5) goto L12;
            r0.g(this.f17910f);
            a r5 = this.f17913i;
            r5.f17908e = 6;
            p000j.k0.f.g r3 = r5.f17905b;
            if (r3 == null) goto L13;
            r3.s(!r10, r5, this.f17912h, r11);
            return;
        L13:
            return;
        L12:
            throw new IllegalStateException("state: " + this.f17913i.f17908e);
        }

        @Override // k.z
        public k.a0 e() {
            return this.f17910f;
        }
    }

    private final class c implements x {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final l f17914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f17915g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f17916h;

        c(a r2) {
            this.f17916h = r2;
            this.f17914f = new l(r2.f17907d.e());
        }

        @Override // k.x
        public void J(k.e r3, long r4) {
            if (this.f17915g == true) goto L10;
            if (r4 != 0) goto L7;
            return;
        L7:
            this.f17916h.f17907d.K(r4);
            this.f17916h.f17907d.D("\r\n");
            this.f17916h.f17907d.J(r3, r4);
            this.f17916h.f17907d.D("\r\n");
            return;
        L10:
            throw new IllegalStateException("closed");
        }

        @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f17915g == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f17915g = true;     // Catch: Throwable -> L11
            this.f17916h.f17907d.D("0\r\n\r\n");     // Catch: Throwable -> L11
            this.f17916h.g(this.f17914f);     // Catch: Throwable -> L11
            this.f17916h.f17908e = 3;     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        @Override // k.x
        public k.a0 e() {
            return this.f17914f;
        }

        @Override // k.x, java.io.Flushable
        public synchronized void flush() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.f17915g == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            this.f17916h.f17907d.flush();     // Catch: Throwable -> L10
            monitor-exit(this);
        }
    }

    private class d extends b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final w f17917j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f17918k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f17919l;
        final /* synthetic */ a m;

        d(a r3, w r4) {
            this.m = r3;
            super(r3, null);
            this.f17918k = -1;
            this.f17919l = true;
            this.f17917j = r4;
        }

        private void b() {
            if (this.f17918k == (-1)) goto L20;
            this.m.f17906c.P();
        L20:
            this.f17918k = this.m.f17906c.f0();     // Catch: NumberFormatException -> L17
            String r0 = this.m.f17906c.P().trim();     // Catch: NumberFormatException -> L17
            if (this.f17918k < 0) goto L16;
            if (r0.isEmpty() == true) goto L12;
            if (r0.startsWith(";") == false) goto L16;
        L12:
            if (this.f17918k != 0) goto L22;
            this.f17919l = false;
            p000j.k0.g.e.i(this.m.f17904a.i(), this.f17917j, this.m.n());
            a(true, null);
            return;
        L22:
            return;
        L16:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f17918k + r0 + "\"");     // Catch: NumberFormatException -> L17
        L17:
            e = move-exception;
            throw new ProtocolException(e.getMessage());
        }

        @Override // j.k0.h.a.b, k.z
        public long Z(k.e r8, long r9) {
            if (r9 < 0) goto L25;
            if (this.f17911g == true) goto L23;
            if (this.f17919l == true) goto L9;
            return -1;
        L9:
            long r5 = this.f17918k;
            if (r5 != 0) goto L12;
        L13:
            b();
            if (this.f17919l == true) goto L16;
            return -1;
        L16:
            long r10 = super.Z(r8, Math.min(r9, this.f17918k));
            if (r10 == (-1)) goto L20;
            this.f17918k -= r10;
            return r10;
        L20:
            ProtocolException r11 = new ProtocolException("unexpected end of stream");
            a(false, r11);
            throw r11;
        L12:
            if (r5 != (-1)) goto L16;
        L23:
            throw new IllegalStateException("closed");
        L25:
            throw new IllegalArgumentException("byteCount < 0: " + r9);
        }

        @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f17911g == false) goto L6;
            return;
        L6:
            if (this.f17919l == true) goto L8;
        L10:
            this.f17911g = true;
            return;
        L8:
            if (p000j.k0.c.p(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            a(false, null);
            goto L10
        }
    }

    private final class e implements x {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final l f17920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f17921g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f17922h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f17923i;

        e(a r2, long r3) {
            this.f17923i = r2;
            this.f17920f = new l(r2.f17907d.e());
            this.f17922h = r3;
        }

        @Override // k.x
        public void J(k.e r8, long r9) {
            if (this.f17921g == true) goto L11;
            p000j.k0.c.f(r8.k0(), 0, r9);
            if (r9 > this.f17922h) goto L9;
            this.f17923i.f17907d.J(r8, r9);
            this.f17922h -= r9;
            return;
        L9:
            throw new ProtocolException("expected " + this.f17922h + " bytes but received " + r9);
        L11:
            throw new IllegalStateException("closed");
        }

        @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f17921g == false) goto L5;
            return;
        L5:
            this.f17921g = true;
            if (this.f17922h > 0) goto L10;
            this.f17923i.g(this.f17920f);
            this.f17923i.f17908e = 3;
            return;
        L10:
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // k.x
        public k.a0 e() {
            return this.f17920f;
        }

        @Override // k.x, java.io.Flushable
        public void flush() {
            if (this.f17921g == false) goto L5;
            return;
        L5:
            this.f17923i.f17907d.flush();
        }
    }

    private class f extends b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f17924j;

        f(a r4, long r5) {
            super(r4, null);
            this.f17924j = r5;
            if (r5 != 0) goto L6;
            a(true, null);
            return;
        }

        @Override // j.k0.h.a.b, k.z
        public long Z(k.e r8, long r9) {
            if (r9 < 0) goto L20;
            if (this.f17911g == true) goto L18;
            long r2 = this.f17924j;
            if (r2 != 0) goto L9;
            return -1;
        L9:
            long r10 = super.Z(r8, Math.min(r2, r9));
            if (r10 == (-1)) goto L15;
            long r3 = this.f17924j - r10;
            this.f17924j = r3;
            if (r3 != 0) goto L14;
            a(true, null);
        L14:
            return r10;
        L15:
            ProtocolException r11 = new ProtocolException("unexpected end of stream");
            a(false, r11);
            throw r11;
        L18:
            throw new IllegalStateException("closed");
        L20:
            throw new IllegalArgumentException("byteCount < 0: " + r9);
        }

        @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f17911g == false) goto L6;
            return;
        L6:
            if (this.f17924j != 0) goto L8;
        L10:
            this.f17911g = true;
            return;
        L8:
            if (p000j.k0.c.p(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            a(false, null);
            goto L10
        }
    }

    private class g extends b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f17925j;

        g(a r2) {
            super(r2, null);
        }

        @Override // j.k0.h.a.b, k.z
        public long Z(k.e r4, long r5) {
            if (r5 < 0) goto L17;
            if (this.f17911g == true) goto L15;
            if (this.f17925j == false) goto L9;
            return -1;
        L9:
            long r6 = super.Z(r4, r5);
            if (r6 != (-1)) goto L13;
            this.f17925j = true;
            a(true, null);
            return -1;
        L13:
            return r6;
        L15:
            throw new IllegalStateException("closed");
        L17:
            throw new IllegalArgumentException("byteCount < 0: " + r5);
        }

        @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f17911g == false) goto L6;
            return;
        L6:
            if (this.f17925j == true) goto L8;
            a(false, null);
        L8:
            this.f17911g = true;
        }
    }

    public a(a0 r3, p000j.k0.f.g r4, k.g r5, k.f r6) {
        this.f17908e = 0;
        this.f17909f = 262144;
        this.f17904a = r3;
        this.f17905b = r4;
        this.f17906c = r5;
        this.f17907d = r6;
    }

    private String m() {
        String r0 = this.f17906c.B(this.f17909f);
        this.f17909f -= (long) r0.length();
        return r0;
    }

    @Override // p000j.k0.g.c
    public void a() {
        this.f17907d.flush();
    }

    @Override // p000j.k0.g.c
    public void b(d0 r2) {
        String r0 = i.a(r2, this.f17905b.d().a().c().type());
        o(r2.d(), r0);
    }

    @Override // p000j.k0.g.c
    public g0 c(f0 r7) {
        p000j.k0.f.g r0 = this.f17905b;
        r0.f17863f.t(r0.f17862e);
        String r1 = r7.A(INetworkApi.CONTENT_TYPE);
        if (p000j.k0.g.e.c(r7) == true) goto L7;
        return new h(r1, 0, q.b(k(0)));
    L7:
        if ("chunked".equalsIgnoreCase(r7.A("Transfer-Encoding")) == true) goto L9;
        long r4 = p000j.k0.g.e.b(r7);
        if (r4 == (-1)) goto L15;
        return new h(r1, r4, q.b(k(r4)));
    L15:
        return new h(r1, -1, q.b(l()));
    L9:
        return new h(r1, -1, q.b(i(r7.Y().k())));
    }

    @Override // p000j.k0.g.c
    public void cancel() {
        p000j.k0.f.c r0 = this.f17905b.d();
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    @Override // p000j.k0.g.c
    public f0.a d(boolean r5) {
        int r0 = this.f17908e;
        if (r0 == 1) goto L23;
        if (r0 == 3) goto L23;
        throw new IllegalStateException("state: " + this.f17908e);
    L23:
        k r1 = k.a(m());     // Catch: EOFException -> L20
        f0.a r2 = new f0.a();     // Catch: EOFException -> L20
        r2.n(r1.f17901a);     // Catch: EOFException -> L20
        r2.g(r1.f17902b);     // Catch: EOFException -> L20
        r2.k(r1.f17903c);     // Catch: EOFException -> L20
        r2.j(n());     // Catch: EOFException -> L20
        if (r5 == false) goto L15;
        if (r1.f17902b != 100) goto L15;
        return null;
    L15:
        if (r1.f17902b != 100) goto L18;
        this.f17908e = 3;     // Catch: EOFException -> L20
        return r2;
    L18:
        this.f17908e = 4;     // Catch: EOFException -> L20
        return r2;
    L20:
        e = move-exception;
        IOException r3 = new IOException("unexpected end of stream on " + this.f17905b);
        r3.initCause(e);
        throw r3;
    }

    @Override // p000j.k0.g.c
    public void e() {
        this.f17907d.flush();
    }

    @Override // p000j.k0.g.c
    public x f(d0 r3, long r4) {
        if ("chunked".equalsIgnoreCase(r3.c("Transfer-Encoding")) == false) goto L7;
        return h();
    L7:
        if (r4 == (-1)) goto L11;
        return j(r4);
    L11:
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    void g(l r2) {
        k.a0 r1 = r2.i();
        r2.j(k.a0.f18238d);
        r1.a();
        r1.b();
    }

    public x h() {
        if (this.f17908e != 1) goto L7;
        this.f17908e = 2;
        return new c(this);
    L7:
        throw new IllegalStateException("state: " + this.f17908e);
    }

    public z i(w r3) {
        if (this.f17908e != 4) goto L7;
        this.f17908e = 5;
        return new d(this, r3);
    L7:
        throw new IllegalStateException("state: " + this.f17908e);
    }

    public x j(long r3) {
        if (this.f17908e != 1) goto L7;
        this.f17908e = 2;
        return new e(this, r3);
    L7:
        throw new IllegalStateException("state: " + this.f17908e);
    }

    public z k(long r3) {
        if (this.f17908e != 4) goto L7;
        this.f17908e = 5;
        return new f(this, r3);
    L7:
        throw new IllegalStateException("state: " + this.f17908e);
    }

    public z l() {
        if (this.f17908e != 4) goto L11;
        p000j.k0.f.g r0 = this.f17905b;
        if (r0 == null) goto L9;
        this.f17908e = 5;
        r0.j();
        return new g(this);
    L9:
        throw new IllegalStateException("streamAllocation == null");
    L11:
        throw new IllegalStateException("state: " + this.f17908e);
    }

    public v n() {
        v.a r0 = new v.a();
    L3:
        String r1 = m();
        if (r1.length() == 0) goto L7;
        p000j.k0.a.f17790a.a(r0, r1);
        goto L3
    L7:
        return r0.d();
    }

    public void o(v r5, String r6) {
        if (this.f17908e != 0) goto L10;
        this.f17907d.D(r6).D("\r\n");
        int r7 = 0;
        int r1 = r5.k();
    L5:
        if (r7 >= r1) goto L7;
        this.f17907d.D(r5.f(r7)).D(": ").D(r5.m(r7)).D("\r\n");
        r7 = r7 + 1;
        goto L5
    L7:
        this.f17907d.D("\r\n");
        this.f17908e = 1;
        return;
    L10:
        throw new IllegalStateException("state: " + this.f17908e);
    }
}
