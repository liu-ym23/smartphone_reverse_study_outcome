package p000j;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import p000j.k0.c;
import p000j.k0.g.f;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final w f17710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final w f17711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f17712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final v f17713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final e0 f17714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Map<Class<?>, Object> f17715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile d f17716g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        w f17717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        w f17718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f17719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        v.a f17720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e0 f17721e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Map<Class<?>, Object> f17722f;

        public a() {
            this.f17722f = Collections.emptyMap();
            this.f17719c = "GET";
            this.f17720d = new v.a();
        }

        a(d0 r3) {
            this.f17722f = Collections.emptyMap();
            this.f17717a = r3.f17710a;
            this.f17719c = r3.f17712c;
            this.f17721e = r3.f17714e;
            if (r3.f17715f.isEmpty() == false) goto L5;
            Map<Class<?>, Object> r0 = Collections.emptyMap();
        L6:
            this.f17722f = r0;
            this.f17720d = r3.f17713d.h();
            this.f17718b = r3.f17711b;
            return;
        L5:
            r0 = new LinkedHashMap(r3.f17715f);
            goto L6
        }

        public a a(String r2, String r3) {
            this.f17720d.a(r2, r3);
            return this;
        }

        public d0 b() {
            if (this.f17717a == null) goto L7;
            return new d0(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public a c() {
            f("GET", null);
            return this;
        }

        public a d(String r2, String r3) {
            this.f17720d.f(r2, r3);
            return this;
        }

        public a e(v r1) {
            this.f17720d = r1.h();
            return this;
        }

        public a f(String r3, e0 r4) {
            Objects.requireNonNull(r3, "method == null");
            if (r3.length() == 0) goto L20;
            if (r4 != null) goto L7;
        L11:
            if (r4 == null) goto L13;
        L17:
            this.f17719c = r3;
            this.f17721e = r4;
            return this;
        L13:
            if (f.e(r3) == false) goto L17;
            throw new IllegalArgumentException("method " + r3 + " must have a request body.");
        L7:
            if (f.b(r3) == true) goto L11;
            throw new IllegalArgumentException("method " + r3 + " must not have a request body.");
        L20:
            throw new IllegalArgumentException("method.length() == 0");
        }

        public a g(e0 r2) {
            f("POST", r2);
            return this;
        }

        public a h(String r2) {
            this.f17720d.e(r2);
            return this;
        }

        public <T> a i(Class<? super T> r2, T r3) {
            Objects.requireNonNull(r2, "type == null");
            if (r3 != null) goto L6;
            this.f17722f.remove(r2);
        L9:
            return this;
        L6:
            if (this.f17722f.isEmpty() == false) goto L8;
            this.f17722f = new LinkedHashMap();
        L8:
            this.f17722f.put(r2, r2.cast(r3));
            goto L9
        }

        public a j(Object r2) {
            i(Object.class, r2);
            return this;
        }

        public a k(String r8) {
            Objects.requireNonNull(r8, "url == null");
            if (r8.regionMatches(true, 0, "ws:", 0, 3) == false) goto L7;
            StringBuilder r0 = new StringBuilder();
            r0.append("http:");
            int r1 = 3;
        L5:
            r0.append(r8.substring(r1));
            r8 = r0.toString();
        L9:
            l(w.l(r8));
            return this;
        L7:
            if (r8.regionMatches(true, 0, "wss:", 0, 4) == false) goto L9;
            r0 = new StringBuilder();
            r0.append("https:");
            r1 = 4;
            goto L5
        }

        public a l(w r2) {
            Objects.requireNonNull(r2, "url == null");
            this.f17717a = r2;
            return this;
        }
    }

    d0(a r2) {
        this.f17710a = r2.f17717a;
        this.f17711b = r2.f17718b;
        this.f17712c = r2.f17719c;
        this.f17713d = r2.f17720d.d();
        this.f17714e = r2.f17721e;
        this.f17715f = c.v(r2.f17722f);
    }

    public e0 a() {
        return this.f17714e;
    }

    public d b() {
        d r0 = this.f17716g;
        if (r0 != null) goto L7;
        d r1 = d.k(this.f17713d);
        this.f17716g = r1;
        return r1;
    L7:
        return r0;
    }

    public String c(String r1) {
        return this.f17713d.d(r1);
    }

    public v d() {
        return this.f17713d;
    }

    public boolean e() {
        return this.f17710a.n();
    }

    public String f() {
        return this.f17712c;
    }

    public a g() {
        return new a(this);
    }

    public w h() {
        return this.f17711b;
    }

    public Object i() {
        return j(Object.class);
    }

    public <T> T j(Class<? extends T> r1) {
        return r1.cast(this.f17715f.get(r1));
    }

    public w k() {
        return this.f17710a;
    }

    public String toString() {
        return "Request{method=" + this.f17712c + ", url=" + this.f17710a + ", tags=" + this.f17715f + '}';
    }
}
