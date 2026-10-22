package com.bytedance.android.sdk.bdticketguard.p1;

import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile e<T> f1019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f1020b;

    static final class a extends q implements kotlin.n0.c.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f1021f;

        a(d r1) {
            this.f1021f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public final T invoke() {
            return (T) d.a(this.f1021f);
        }
    }

    public d(T r1) {
        this.f1020b = r1;
    }

    public static final /* synthetic */ Object a(d r0) {
        return r0.f1020b;
    }

    public final e<T> b(Object r1, kotlin.s0.l<?> r2) {
        o.g(r2, "property");
        e<T> r3 = this.f1019a;
        if (r3 == null) goto L6;
        return r3;
    L6:
        return new c(new a(this));
    }

    public final void c(Object r1, kotlin.s0.l<?> r2, e<T> r3) {
        o.g(r2, "property");
        o.g(r3, "value");
        this.f1019a = r3;
    }
}
