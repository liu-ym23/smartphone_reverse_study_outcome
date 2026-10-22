package com.bytedance.monitor.collector;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f5188g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f5190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f5192d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f5193e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5194f;

        public a() {
        }

        static /* synthetic */ boolean a(a r0) {
            return r0.f5189a;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.f5190b;
        }

        static /* synthetic */ boolean c(a r0) {
            return r0.f5191c;
        }

        static /* synthetic */ long d(a r2) {
            return r2.f5193e;
        }

        static /* synthetic */ int e(a r0) {
            return r0.f5194f;
        }

        static /* synthetic */ boolean f(a r0) {
            return r0.f5192d;
        }

        public a g(long r1) {
            this.f5193e = r1;
            return this;
        }

        public j h() {
            return new j(this);
        }

        public a i(boolean r1) {
            this.f5189a = r1;
            return this;
        }

        public a j(boolean r1) {
            this.f5190b = r1;
            return this;
        }

        @Deprecated
        public a k(boolean r1) {
            return this;
        }

        public a l(boolean r1) {
            this.f5191c = r1;
            return this;
        }

        public a m(boolean r1) {
            this.f5192d = r1;
            return this;
        }

        public a n(int r1) {
            this.f5194f = r1;
            return this;
        }
    }

    public j(a r3) {
        this.f5188g = 0;
        this.f5182a = a.a(r3);
        this.f5183b = a.b(r3);
        this.f5184c = a.c(r3);
        this.f5186e = a.d(r3);
        this.f5187f = a.e(r3);
        this.f5185d = a.f(r3);
    }

    public long a() {
        return this.f5186e;
    }

    public int b() {
        return this.f5187f;
    }

    public boolean c() {
        return this.f5182a;
    }

    public boolean d() {
        return this.f5183b;
    }

    public boolean e() {
        return this.f5184c;
    }

    public boolean f() {
        return this.f5185d;
    }

    public String toString() {
        return "MonitorConfig{enableAtrace=" + this.f5182a + ", enableBinder=" + this.f5183b + ", enableLooperMonitor=" + this.f5184c + ", enableStackSampling=" + this.f5185d + ", atraceTag=" + this.f5186e + ", runMode=" + this.f5187f + ", alogRef=" + this.f5188g + '}';
    }
}
