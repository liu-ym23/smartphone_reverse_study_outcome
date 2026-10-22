package com.ss.android.m.a.a;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<k> f12141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f12142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12145f;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<k> f12147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<String> f12148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f12149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f12150e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f12151f;

        private b() {
            this.f12146a = false;
            this.f12147b = Collections.emptyList();
            this.f12148c = Collections.emptyList();
            TimeUnit r0 = TimeUnit.MINUTES;
            this.f12149d = r0.toMillis(5);
            this.f12150e = r0.toMillis(5);
            this.f12151f = r0.toMillis(15);
        }

        /* synthetic */ b(a r1) {
            this();
        }

        static /* synthetic */ boolean a(b r0) {
            return r0.f12146a;
        }

        static /* synthetic */ List b(b r0) {
            return r0.f12147b;
        }

        static /* synthetic */ List c(b r0) {
            return r0.f12148c;
        }

        static /* synthetic */ long d(b r2) {
            return r2.f12149d;
        }

        static /* synthetic */ long e(b r2) {
            return r2.f12150e;
        }

        static /* synthetic */ long f(b r2) {
            return r2.f12151f;
        }

        public g g() {
            return new g(this, null);
        }
    }

    private g(b r3) {
        this.f12140a = b.a(r3);
        this.f12141b = b.b(r3);
        this.f12142c = b.c(r3);
        this.f12143d = b.d(r3);
        this.f12144e = b.e(r3);
        this.f12145f = b.f(r3);
    }

    /* synthetic */ g(b r1, a r2) {
        this(r1);
    }

    public static b g() {
        return new b(null);
    }

    public List<k> a() {
        return this.f12141b;
    }

    public List<String> b() {
        return this.f12142c;
    }

    public long c() {
        return this.f12145f;
    }

    public long d() {
        return this.f12144e;
    }

    public long e() {
        return this.f12143d;
    }

    public boolean f() {
        return this.f12140a;
    }
}
