package d.b.r;

import com.obric.matrix.common_api.INetworkApi;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f14546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private StringBuilder f14549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<d.b.r.h0.b> f14551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f14553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.b.r.k0.c f14554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d.b.r.k0.e f14555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d.b.r.k0.j f14556l;
    private int m;
    private final int n;
    private final String o;
    private boolean p;
    private int q;
    private boolean r;
    private int s;
    private Object t;
    private final j.z.a u;
    private p000j.e0 v;
    private boolean w;
    private final Map<Class<?>, Object> x;

    private static class a extends p000j.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p000j.e0 f14557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14558b;

        a(p000j.e0 r1, String r2) {
            this.f14557a = r1;
            this.f14558b = r2;
        }

        @Override // p000j.e0
        public long a() {
            return this.f14557a.a();
        }

        @Override // p000j.e0
        public p000j.y b() {
            return p000j.y.d(this.f14558b);
        }

        @Override // p000j.e0
        public void f(k.f r1) {
            this.f14557a.f(r1);
        }
    }

    private static class b extends d.b.r.k0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.b.r.k0.j f14559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f14560e;

        b(d.b.r.k0.j r1, String r2) {
            this.f14559d = r1;
            this.f14560e = r2;
        }

        @Override // d.b.r.k0.a, d.b.r.k0.j
        public String a() {
            return this.f14560e;
        }

        @Override // d.b.r.k0.a, d.b.r.k0.j
        public void b(OutputStream r1) {
            this.f14559d.b(r1);
        }

        @Override // d.b.r.k0.a, d.b.r.k0.j
        public String c() {
            return this.f14559d.c();
        }

        @Override // d.b.r.k0.a, d.b.r.k0.j
        public String e() {
            this.f14417c = this.f14559d.e();
            return this.f14417c;
        }

        @Override // d.b.r.k0.a
        public String f() {
            d.b.r.k0.j r1 = this.f14559d;
            if ((r1 instanceof d.b.r.k0.a) == true) goto L5;
            return null;
        L5:
            return ((d.b.r.k0.a) r1).f();
        }

        @Override // d.b.r.k0.a
        public d.b.r.k0.f.b g(String r2, String r3, boolean r4) {
            d.b.r.k0.j r1 = this.f14559d;
            if ((r1 instanceof d.b.r.k0.a) == true) goto L5;
            return null;
        L5:
            return ((d.b.r.k0.a) r1).g(r2, r3, r4);
        }

        @Override // d.b.r.k0.a
        public boolean i() {
            d.b.r.k0.j r1 = this.f14559d;
            if ((r1 instanceof d.b.r.k0.a) == true) goto L5;
            return false;
        L5:
            return ((d.b.r.k0.a) r1).i();
        }

        @Override // d.b.r.k0.a, d.b.r.k0.j
        public long length() {
            return this.f14559d.length();
        }
    }

    t(String r5, h r6, String r7, List<d.b.r.h0.b> r8, String r9, int r10, int r11, boolean r12, int r13, boolean r14, int r15, Object r16, boolean r17, boolean r18, boolean r19, String r20, boolean r21) {
        this.x = new LinkedHashMap();
        this.f14545a = r5;
        this.f14546b = r6;
        this.f14548d = r7;
        this.f14552h = r9;
        this.m = r10;
        this.n = r11;
        this.p = r12;
        this.q = r13;
        this.r = r14;
        this.s = r15;
        this.t = r16;
        this.f14553i = r17;
        this.f14551g = r8;
        this.o = r20;
        if (r18 == false) goto L6;
        d.b.r.k0.c r2 = new d.b.r.k0.c(r21);
        this.f14554j = r2;
        this.f14555k = null;
        this.f14556l = r2;
    L5:
        this.u = null;
        return;
    L6:
        this.f14554j = null;
        if (r19 == false) goto L9;
        d.b.r.k0.e r1 = new d.b.r.k0.e();
        this.f14555k = r1;
        this.f14556l = r1;
        j.z.a r3 = new j.z.a();
        this.u = r3;
        r3.d(p000j.z.f18224f);
        return;
    L9:
        this.f14555k = null;
        goto L5
    }

    private StringBuilder k(String r2, String r3) {
        StringBuilder r1 = new StringBuilder(r2);
        if (r2.endsWith("/") == false) goto L5;
        r1.deleteCharAt(r1.length() - 1);
    L5:
        r1.append(r3);
        return r1;
    }

    void a(String r1, String r2, boolean r3) {
        this.f14554j.l(r1, r3, r2, r3);
    }

    void b(String r3, String r4) {
        if (r3 == null) goto L13;
        if (INetworkApi.CONTENT_TYPE.equalsIgnoreCase(r3) == false) goto L7;
        this.f14552h = r4;
        return;
    L7:
        List r0 = this.f14551g;
        if (r0 != null) goto L10;
        r0 = new ArrayList(2);
        this.f14551g = r0;
    L10:
        r0.add(new d.b.r.h0.b(r3, r4));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    public void c(String r1, d.b.r.k0.j r2) {
        this.f14555k.g(r1, r2);
    }

    public void d(String r1, String r2, d.b.r.k0.j r3) {
        this.f14555k.h(r1, r2, r3);
    }

    void e(p000j.v r1, p000j.e0 r2) {
        this.u.a(r1, r2);
    }

    void f(j.z.b r1) {
        this.u.b(r1);
    }

    void g(String r5, String r6, boolean r7) {
        String r0 = this.f14548d;
        if (r0 == null) goto L22;
        if (r5 == null) goto L20;
        if (r6 == null) goto L18;
        if (r7 == false) goto L12;
        String r8 = URLEncoder.encode(String.valueOf(r6), "UTF-8").replace("+", "%20");     // Catch: UnsupportedEncodingException -> L10
        String r9 = this.f14548d.replace("{" + r5 + "}", r8);     // Catch: UnsupportedEncodingException -> L10
    L9:
        this.f14548d = r9;     // Catch: UnsupportedEncodingException -> L10
        return;
    L12:
        r9 = r0.replace("{" + r5 + "}", String.valueOf(r6));     // Catch: UnsupportedEncodingException -> L10
    L10:
        e = move-exception;
        throw new RuntimeException("Unable to convert path parameter \"" + r5 + "\" value to UTF-8:" + r6, e);
    L18:
        throw new IllegalArgumentException("Path replacement \"" + r5 + "\" value must not be null.");
    L20:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L22:
        throw new AssertionError();
    }

    void h(String r3, String r4, boolean r5) {
        if (r3 == null) goto L27;
        StringBuilder r0 = this.f14549e;     // Catch: UnsupportedEncodingException -> L23
        if (r0 != null) goto L7;
        r0 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L23
        this.f14549e = r0;     // Catch: UnsupportedEncodingException -> L23
    L7:
        if (r0.length() <= 0) goto L9;
        char r2 = '&';
    L10:
        r0.append(r2);     // Catch: UnsupportedEncodingException -> L23
        if (r5 == false) goto L14;
        r3 = URLEncoder.encode(r3, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L14:
        if (r5 == false) goto L16;
        r4 = URLEncoder.encode(r4, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L16:
        if (r4 != null) goto L18;
    L21:
        r0.append(r3);     // Catch: UnsupportedEncodingException -> L23
        return;
    L18:
        if (r4.isEmpty() == true) goto L21;
        r0.append(r3);     // Catch: UnsupportedEncodingException -> L23
        r0.append('=');     // Catch: UnsupportedEncodingException -> L23
        r0.append(r4);     // Catch: UnsupportedEncodingException -> L23
        return;
    L9:
        r2 = '?';
    L23:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r3 + "\" value to UTF-8: " + r4, e);
    L27:
        throw new IllegalArgumentException("Query param name must not be null.");
    }

    public <T> void i(Class<? super T> r1, T r2) {
        this.x.put(r1, r1.cast(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [d.b.r.t] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [d.b.r.k0.c] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v2, types: [d.b.r.k0.j] */
    d.b.r.h0.c j(k<?> r18) {
        d.b.r.k0.e r2 = this.f14555k;
        if (r2 != null) goto L5;
    L11:
        ?? r3 = this.f14546b.a();
        if (s.j() == false) goto L95;
        p000j.w r4 = p000j.w.r(r3);
        if (r4 == null) goto L28;
        if (r4.h() != null) goto L18;
    L22:
        p000j.w r5 = r4.C(this.f14548d);
        if (r5 == null) goto L26;
        r3 = new StringBuilder(r5.toString());
    L46:
        StringBuilder r6 = this.f14549e;
        if (r6 != null) goto L49;
    L56:
        String r7 = this.f14550f;
        if (r7 == null) goto L59;
        r3.append(r7);
    L59:
        this.f14547c = r3.toString();
        if ((r18 instanceof k) == false) goto L62;
        r18.c(this);
    L62:
        d.b.r.k0.j r1 = this.f14556l;
        List<d.b.r.h0.b> r8 = this.f14551g;
        p000j.e0 r9 = this.v;
        a r10 = null;
        if (this.w == false) goto L76;
        if (r9 != null) goto L71;
        j.z.a r11 = this.u;
        if (r11 == null) goto L69;
        r9 = r11.c();
        goto L71
    L69:
        if (this.f14553i == false) goto L71;
        r9 = p000j.e0.d(null, new byte[0]);
    L71:
        if (r9 == null) goto L75;
        String r12 = this.f14552h;
        if (r12 == null) goto L75;
        r10 = new a(r9, r12);
    L84:
        List<d.b.r.h0.b> r13 = r8;
        d.b.r.k0.j r14 = r1;
    L85:
        p000j.e0 r15 = r10;
        ?? r16 = r14;
    L86:
        if (r16 != 0) goto L93;
        if (f0.t(this.f14545a) == false) goto L93;
        if (this.w == true) goto L93;
        r16 = new d.b.r.k0.c();
        r16.k("body", "null");
    L93:
        return new d.b.r.h0.c(this.f14545a, this.f14547c, r13, r16, r15, this.m, this.n, this.p, this.q, this.r, this.s, this.t, this.o, this.x);
    L75:
        r13 = r8;
        r15 = r9;
        r16 = r1;
        goto L86
    L76:
        String r17 = this.f14552h;
        if (r17 == null) goto L84;
        if (r1 == null) goto L80;
        r13 = r8;
        r14 = new b(r1, r17);
        goto L85
    L80:
        d.b.r.h0.b r19 = new d.b.r.h0.b(INetworkApi.CONTENT_TYPE, r17);
        if (r8 != null) goto L83;
        r8 = Collections.singletonList(r19);
        goto L84
    L83:
        r8.add(r19);
        goto L84
    L49:
        if ('?' != r6.charAt(0)) goto L55;
        String r20 = this.f14548d;
        if (r20 == null) goto L55;
        if (r20.indexOf(63) == (-1)) goto L55;
        r6.setCharAt(0, '&');
    L55:
        r3.append(r6);
        goto L56
    L26:
        throw new IllegalArgumentException("Malformed URL. Base: " + r4 + ", Relative: " + this.f14548d);
    L18:
        if (r4.h().length() <= 0) goto L22;
        ?? r21 = r3;
        if ("/".equals(this.f14548d) == false) goto L22;
    L45:
        r3 = k(r21, this.f14548d);
        goto L46
    L28:
        throw new IllegalArgumentException("Malformed URL. Base: " + r4 + ", Relative: " + this.f14548d);
    L95:
        URI r22 = URI.create(r3);     // Catch: Throwable -> L38
        if (r22.getPath() == null) goto L37;
        if (r22.getPath().length() < 1) goto L37;
        if ("/".equals(this.f14548d) == false) goto L37;
        r3 = k(r3, this.f14548d);     // Catch: Throwable -> L38
    L94:
    L37:
        r3 = new StringBuilder(r22.resolve(this.f14548d).toString());     // Catch: Throwable -> L38
    L38:
        String r23 = this.f14548d;
        r21 = r3;
        if (r23 == null) goto L45;
        if (r23.startsWith("http://") == true) goto L44;
        r21 = r3;
        if (this.f14548d.startsWith("https://") == false) goto L45;
    L44:
        r3 = new StringBuilder(this.f14548d);
        goto L46
    L5:
        if (r2.k() != 0) goto L11;
        if (this.w == true) goto L11;
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }

    public void l(boolean r1) {
        this.r = r1;
    }

    public void m(d.b.r.k0.j r1) {
        this.f14556l = r1;
    }

    void n(p000j.e0 r1) {
        this.v = r1;
    }

    public void o(Object r1) {
        this.t = r1;
    }

    public void p(int r1) {
        this.q = r1;
    }

    void q(String r4, String r5) {
        String r0 = this.f14545a;
        if (r0 == null) goto L7;
        this.f14545a = r0.replace("{" + r4 + "}", r5);
        return;
    L7:
        throw new AssertionError();
    }

    void r(String r1) {
        this.f14550f = r1;
    }

    void s(Object r2) {
        Objects.requireNonNull(r2, "@Url parameter is null.");
        this.f14548d = r2.toString();
    }

    void t() {
        this.w = true;
    }
}
