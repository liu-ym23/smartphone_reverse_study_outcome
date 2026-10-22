package com.ss.android.m.a.a;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f12152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BlockingQueue<Runnable> f12155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RejectedExecutionHandler f12156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ThreadFactory f12158g;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private k f12159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f12160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f12161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private BlockingQueue<Runnable> f12162d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private RejectedExecutionHandler f12163e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f12164f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ThreadFactory f12165g;

        private b(k r3) {
            this.f12161c = 1;
            this.f12162d = new LinkedBlockingQueue();
            this.f12163e = new ThreadPoolExecutor.AbortPolicy();
            this.f12164f = -1;
            this.f12159a = r3;
        }

        /* synthetic */ b(k r1, a r2) {
            this(r1);
        }

        static /* synthetic */ k a(b r0) {
            return r0.f12159a;
        }

        static /* synthetic */ String b(b r0) {
            return r0.f12160b;
        }

        static /* synthetic */ int c(b r0) {
            return r0.f12161c;
        }

        static /* synthetic */ BlockingQueue d(b r0) {
            return r0.f12162d;
        }

        static /* synthetic */ RejectedExecutionHandler e(b r0) {
            return r0.f12163e;
        }

        static /* synthetic */ long f(b r2) {
            return r2.f12164f;
        }

        static /* synthetic */ ThreadFactory g(b r0) {
            return r0.f12165g;
        }

        public h h() {
            return new h(this, null);
        }

        public b i(int r1) {
            this.f12161c = r1;
            return this;
        }

        public b j(String r1) {
            this.f12160b = r1;
            return this;
        }
    }

    private h(b r3) {
        this.f12152a = b.a(r3);
        this.f12153b = b.b(r3);
        this.f12154c = b.c(r3);
        this.f12155d = b.d(r3);
        this.f12156e = b.e(r3);
        this.f12157f = b.f(r3);
        this.f12158g = b.g(r3);
    }

    /* synthetic */ h(b r1, a r2) {
        this(r1);
    }

    public static b a(k r2) {
        return new b(r2, null);
    }
}
