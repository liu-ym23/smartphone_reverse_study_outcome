package com.bytedance.applog;

import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.r;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f2233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f2234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final r f2238f;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f2239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f2240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f2241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f2242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f2243e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2244f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private r f2245g;

        public b() {
        }

        static /* synthetic */ r a(b r0) {
            return r0.f2245g;
        }

        static /* synthetic */ String[] b(b r0) {
            return r0.f2239a;
        }

        static /* synthetic */ String[] c(b r0) {
            return r0.f2240b;
        }

        static /* synthetic */ String d(b r0) {
            return r0.f2241c;
        }

        static /* synthetic */ String e(b r0) {
            return r0.f2242d;
        }

        static /* synthetic */ String f(b r0) {
            return r0.f2243e;
        }

        static /* synthetic */ String g(b r0) {
            return r0.f2244f;
        }

        public m h() {
            return new m(this, null);
        }

        public b i(String r1) {
            this.f2242d = r1;
            return this;
        }

        public b j(r r1) {
            this.f2245g = r1;
            return this;
        }

        public b k(String r1) {
            this.f2244f = r1;
            return this;
        }

        public b l(String[] r1) {
            this.f2240b = r1;
            return this;
        }

        public b m(String[] r1) {
            this.f2239a = r1;
            return this;
        }

        public b n(String r1) {
            this.f2241c = r1;
            return this;
        }
    }

    private m(b r2) {
        this.f2238f = b.a(r2);
        this.f2233a = b.b(r2);
        this.f2234b = b.c(r2);
        this.f2235c = b.d(r2);
        this.f2236d = b.e(r2);
        this.f2237e = b.f(r2);
        b.g(r2);
    }

    /* synthetic */ m(b r1, a r2) {
        this(r1);
    }

    public static m a(int r0) {
        return o.a(r0);
    }

    public String b() {
        return this.f2236d;
    }

    public r c() {
        return this.f2238f;
    }

    public String d() {
        return this.f2237e;
    }

    public String[] e() {
        return this.f2234b;
    }

    public String[] f() {
        return this.f2233a;
    }

    public String g() {
        return this.f2235c;
    }
}
