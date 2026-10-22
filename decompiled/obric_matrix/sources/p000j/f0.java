package p000j;

import java.io.Closeable;
import java.util.Collections;
import java.util.List;
import p000j.k0.g.e;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final d0 f17727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final b0 f17728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f17729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final String f17730i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final u f17731j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final v f17732k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final g0 f17733l;
    final f0 m;
    final f0 n;
    final f0 o;
    final long p;
    final long q;
    private volatile d r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d0 f17734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b0 f17735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f17736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f17737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        u f17738e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        v.a f17739f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        g0 f17740g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        f0 f17741h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        f0 f17742i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        f0 f17743j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f17744k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f17745l;

        public a() {
            this.f17736c = -1;
            this.f17739f = new v.a();
        }

        a(f0 r3) {
            this.f17736c = -1;
            this.f17734a = r3.f17727f;
            this.f17735b = r3.f17728g;
            this.f17736c = r3.f17729h;
            this.f17737d = r3.f17730i;
            this.f17738e = r3.f17731j;
            this.f17739f = r3.f17732k.h();
            this.f17740g = r3.f17733l;
            this.f17741h = r3.m;
            this.f17742i = r3.n;
            this.f17743j = r3.o;
            this.f17744k = r3.p;
            this.f17745l = r3.q;
        }

        private void e(f0 r1) {
            if (r1.f17733l != null) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        private void f(String r1, f0 r2) {
            if (r2.f17733l != null) goto L18;
            if (r2.m != null) goto L16;
            if (r2.n != null) goto L14;
            if (r2.o != null) goto L12;
            return;
        L12:
            throw new IllegalArgumentException(r1 + ".priorResponse != null");
        L14:
            throw new IllegalArgumentException(r1 + ".cacheResponse != null");
        L16:
            throw new IllegalArgumentException(r1 + ".networkResponse != null");
        L18:
            throw new IllegalArgumentException(r1 + ".body != null");
        }

        public a a(String r2, String r3) {
            this.f17739f.a(r2, r3);
            return this;
        }

        public a b(g0 r1) {
            this.f17740g = r1;
            return this;
        }

        public f0 c() {
            if (this.f17734a == null) goto L19;
            if (this.f17735b == null) goto L17;
            if (this.f17736c < 0) goto L15;
            if (this.f17737d == null) goto L13;
            return new f0(this);
        L13:
            throw new IllegalStateException("message == null");
        L15:
            throw new IllegalStateException("code < 0: " + this.f17736c);
        L17:
            throw new IllegalStateException("protocol == null");
        L19:
            throw new IllegalStateException("request == null");
        }

        public a d(f0 r2) {
            if (r2 == null) goto L4;
            f("cacheResponse", r2);
        L4:
            this.f17742i = r2;
            return this;
        }

        public a g(int r1) {
            this.f17736c = r1;
            return this;
        }

        public a h(u r1) {
            this.f17738e = r1;
            return this;
        }

        public a i(String r2, String r3) {
            this.f17739f.f(r2, r3);
            return this;
        }

        public a j(v r1) {
            this.f17739f = r1.h();
            return this;
        }

        public a k(String r1) {
            this.f17737d = r1;
            return this;
        }

        public a l(f0 r2) {
            if (r2 == null) goto L4;
            f("networkResponse", r2);
        L4:
            this.f17741h = r2;
            return this;
        }

        public a m(f0 r1) {
            if (r1 == null) goto L4;
            e(r1);
        L4:
            this.f17743j = r1;
            return this;
        }

        public a n(b0 r1) {
            this.f17735b = r1;
            return this;
        }

        public a o(long r1) {
            this.f17745l = r1;
            return this;
        }

        public a p(d0 r1) {
            this.f17734a = r1;
            return this;
        }

        public a q(long r1) {
            this.f17744k = r1;
            return this;
        }
    }

    f0(a r3) {
        this.f17727f = r3.f17734a;
        this.f17728g = r3.f17735b;
        this.f17729h = r3.f17736c;
        this.f17730i = r3.f17737d;
        this.f17731j = r3.f17738e;
        this.f17732k = r3.f17739f.d();
        this.f17733l = r3.f17740g;
        this.m = r3.f17741h;
        this.n = r3.f17742i;
        this.o = r3.f17743j;
        this.p = r3.f17744k;
        this.q = r3.f17745l;
    }

    public String A(String r2) {
        return C(r2, null);
    }

    public String C(String r1, String r2) {
        String r0 = this.f17732k.d(r1);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0;
    }

    public List<String> E(String r1) {
        return this.f17732k.n(r1);
    }

    public v F() {
        return this.f17732k;
    }

    public boolean L() {
        int r1 = this.f17729h;
        if (r1 != 307) goto L5;
        return true;
    L5:
        if (r1 == 308) goto L11;
        switch(r1) {
            case 300: goto L12;
            case 301: goto L12;
            case 302: goto L12;
            case 303: goto L12;
            default: goto L7;
        };
    L7:
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    public boolean M() {
        int r1 = this.f17729h;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public String N() {
        return this.f17730i;
    }

    public f0 O() {
        return this.m;
    }

    public a Q() {
        return new a(this);
    }

    public f0 S() {
        return this.o;
    }

    public b0 V() {
        return this.f17728g;
    }

    public long X() {
        return this.q;
    }

    public d0 Y() {
        return this.f17727f;
    }

    public g0 a() {
        return this.f17733l;
    }

    public d b() {
        d r0 = this.r;
        if (r0 != null) goto L7;
        d r1 = d.k(this.f17732k);
        this.r = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g0 r1 = this.f17733l;
        if (r1 == null) goto L7;
        r1.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public long d0() {
        return this.p;
    }

    public f0 g() {
        return this.n;
    }

    public List<h> l() {
        int r0 = this.f17729h;
        if (r0 != 401) goto L6;
        String r1 = "WWW-Authenticate";
    L9:
        return e.e(F(), r1);
    L6:
        if (r0 != 407) goto L11;
        r1 = "Proxy-Authenticate";
        goto L9
    L11:
        return Collections.emptyList();
    }

    public int s() {
        return this.f17729h;
    }

    public String toString() {
        return "Response{protocol=" + this.f17728g + ", code=" + this.f17729h + ", message=" + this.f17730i + ", url=" + this.f17727f.k() + '}';
    }

    public u x() {
        return this.f17731j;
    }
}
