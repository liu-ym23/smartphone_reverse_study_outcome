package com.bytedance.common.wschannel.s.g;

import androidx.lifecycle.CoroutineLiveDataKt;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.common.wschannel.s.e.b<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3697b;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.s.g.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0103a {
    }

    private static class b extends a {
        private b() {
            super(-1, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        }

        /* synthetic */ b(C0103a r1) {
            this();
        }
    }

    public a() {
    }

    public a(long r1, long r3) {
        this.f3696a = r1;
        this.f3697b = r3;
    }

    public long a() {
        return this.f3696a;
    }

    public long b() {
        return this.f3697b;
    }

    public a c() {
        return new b(null);
    }

    void d(long r1) {
        this.f3696a = r1;
    }
}
