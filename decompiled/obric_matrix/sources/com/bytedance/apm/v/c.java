package com.bytedance.apm.v;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f2089d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f2095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f2096g;

        public a() {
            this.f2090a = false;
            this.f2091b = false;
            this.f2092c = false;
            this.f2093d = false;
            this.f2094e = false;
            this.f2095f = -1;
            this.f2096g = 1000;
        }

        public c a() {
            return new c(this.f2090a, this.f2091b, this.f2092c, this.f2095f, this.f2093d, this.f2096g, this.f2094e);
        }
    }

    public c(boolean r1, boolean r2, boolean r3, long r4, boolean r6, long r7, boolean r9) {
        this.f2086a = r1;
        this.f2087b = r2;
        this.f2089d = r4;
        this.f2088c = r6;
    }

    public long a() {
        return this.f2089d;
    }

    public boolean b() {
        return this.f2088c;
    }

    public boolean c() {
        return this.f2087b;
    }

    public boolean d() {
        return this.f2086a;
    }
}
