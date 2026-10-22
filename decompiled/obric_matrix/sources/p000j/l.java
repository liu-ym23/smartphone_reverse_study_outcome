package p000j;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final i[] f18120e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final i[] f18121f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final i0[] f18122g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final i0[] f18123h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l f18124i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l f18125j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f18126k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f18127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f18128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String[] f18129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String[] f18130d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f18131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String[] f18132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String[] f18133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f18134d;

        public a(l r2) {
            this.f18131a = r2.f18127a;
            this.f18132b = r2.f18129c;
            this.f18133c = r2.f18130d;
            this.f18134d = r2.f18128b;
        }

        a(boolean r1) {
            this.f18131a = r1;
        }

        public l a() {
            return new l(this);
        }

        public a b(String... r2) {
            if (this.f18131a == false) goto L11;
            if (r2.length == 0) goto L9;
            this.f18132b = (String[]) r2.clone();
            return this;
        L9:
            throw new IllegalArgumentException("At least one cipher suite is required");
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a c(i... r4) {
            if (this.f18131a == false) goto L11;
            String[] r0 = new String[r4.length];
            int r1 = 0;
        L6:
            if (r1 >= r4.length) goto L8;
            r0[r1] = r4[r1].f17774a;
            r1 = r1 + 1;
            goto L6
        L8:
            b(r0);
            return this;
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(boolean r2) {
            if (this.f18131a == false) goto L7;
            this.f18134d = r2;
            return this;
        L7:
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a e(String... r2) {
            if (this.f18131a == false) goto L11;
            if (r2.length == 0) goto L9;
            this.f18133c = (String[]) r2.clone();
            return this;
        L9:
            throw new IllegalArgumentException("At least one TLS version is required");
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a f(i0... r4) {
            if (this.f18131a == false) goto L11;
            String[] r0 = new String[r4.length];
            int r1 = 0;
        L6:
            if (r1 >= r4.length) goto L8;
            r0[r1] = r4[r1].f17781f;
            r1 = r1 + 1;
            goto L6
        L8:
            e(r0);
            return this;
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
    }

    static {
        i r2 = i.q;
        i r4 = i.r;
        i r6 = i.s;
        i r8 = i.t;
        i r10 = i.u;
        i r12 = i.f17772k;
        i r14 = i.m;
        i r16 = i.f17773l;
        i r18 = i.n;
        i r20 = i.p;
        i r22 = i.o;
        i[] r1 = {r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22};
        f18120e = r1;
        i[] r0 = {r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22, i.f17770i, i.f17771j, i.f17768g, i.f17769h, i.f17766e, i.f17767f, i.f17765d};
        f18121f = r0;
        a r3 = new a(true);
        r3.c(r1);
        i0 r5 = i0.f17775g;
        i0 r7 = i0.f17776h;
        r3.f(new i0[]{r5, r7});
        r3.d(true);
        r3.a();
        i0 r9 = i0.f17778j;
        i0[] r11 = {r5, r7, i0.f17777i, r9};
        f18122g = r11;
        i0[] r13 = {r5, r7};
        f18123h = r13;
        a r15 = new a(true);
        r15.c(r0);
        if (p000j.l0.a.j().a() == true) goto L6;
        r11 = r13;
    L6:
        r15.f(r11);
        r15.d(true);
        f18124i = r15.a();
        a r17 = new a(true);
        r17.c(r0);
        r17.f(new i0[]{r9});
        r17.d(true);
        f18125j = r17.a();
        f18126k = new a(false).a();
    }

    l(a r2) {
        this.f18127a = r2.f18131a;
        this.f18129c = r2.f18132b;
        this.f18130d = r2.f18133c;
        this.f18128b = r2.f18134d;
    }

    private l e(SSLSocket r5, boolean r6) {
        if (this.f18129c == null) goto L5;
        String[] r0 = c.z(i.f17763b, r5.getEnabledCipherSuites(), this.f18129c);
    L7:
        if (this.f18130d == null) goto L9;
        String[] r1 = c.z(c.p, r5.getEnabledProtocols(), this.f18130d);
    L10:
        String[] r7 = r5.getSupportedCipherSuites();
        int r2 = c.w(i.f17763b, r7, "TLS_FALLBACK_SCSV");
        if (r6 == true) goto L13;
    L15:
        a r8 = new a(this);
        r8.b(r0);
        r8.e(r1);
        return r8.a();
    L13:
        if (r2 == (-1)) goto L15;
        r0 = c.i(r0, r7[r2]);
        goto L15
    L9:
        r1 = r5.getEnabledProtocols();
        goto L10
    L5:
        r0 = r5.getEnabledCipherSuites();
        goto L7
    }

    void a(SSLSocket r1, boolean r2) {
        l r0 = e(r1, r2);
        String[] r3 = r0.f18130d;
        if (r3 == null) goto L5;
        r1.setEnabledProtocols(r3);
    L5:
        String[] r4 = r0.f18129c;
        if (r4 == null) goto L9;
        r1.setEnabledCipherSuites(r4);
        return;
    }

    public List<i> b() {
        String[] r0 = this.f18129c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return i.b(r0);
    }

    public boolean c(SSLSocket r5) {
        if (this.f18127a == true) goto L5;
        return false;
    L5:
        String[] r0 = this.f18130d;
        if (r0 != null) goto L8;
    L10:
        String[] r4 = this.f18129c;
        if (r4 != null) goto L13;
        return true;
    L13:
        if (c.B(i.f17763b, r4, r5.getEnabledCipherSuites()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (c.B(c.p, r0, r5.getEnabledProtocols()) == true) goto L10;
        return false;
    }

    public boolean d() {
        return this.f18127a;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof l) == true) goto L6;
        return false;
    L6:
        if (r5 != this) goto L8;
        return true;
    L8:
        l r6 = (l) r5;
        boolean r2 = this.f18127a;
        if (r2 == r6.f18127a) goto L11;
        return false;
    L11:
        if (r2 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.f18129c, r6.f18129c) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.f18130d, r6.f18130d) == true) goto L19;
        return false;
    L19:
        if (this.f18128b == r6.f18128b) goto L21;
        return false;
    }

    public boolean f() {
        return this.f18128b;
    }

    public List<i0> g() {
        String[] r0 = this.f18130d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return i0.b(r0);
    }

    public int hashCode() {
        if (this.f18127a == true) goto L7;
        return 17;
    L7:
        return ((((527 + Arrays.hashCode(this.f18129c)) * 31) + Arrays.hashCode(this.f18130d)) * 31) + (!this.f18128b ? 1 : 0);
    }

    public String toString() {
        if (this.f18127a == true) goto L6;
        return "ConnectionSpec()";
    L6:
        String r1 = "[all enabled]";
        if (this.f18129c == null) goto L9;
        String r0 = b().toString();
    L11:
        if (this.f18130d == null) goto L14;
        r1 = g().toString();
    L14:
        return "ConnectionSpec(cipherSuites=" + r0 + ", tlsVersions=" + r1 + ", supportsTlsExtensions=" + this.f18128b + ")";
    L9:
        r0 = "[all enabled]";
        goto L11
    }
}
