package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public interface k1 {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(k1 r0, String r1, kotlin.n0.c.l r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            r0.l(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSecTs");
        }
    }

    f0 a(s r1);

    void b(c1 r1, kotlin.n0.c.l<? super Boolean, kotlin.f0> r2);

    void c(String r1, String r2);

    void d(r r1);

    String e(String r1, String r2);

    g f();

    l0 g();

    void h(kotlin.n0.c.q<? super kotlin.v<g>, ? super Integer, ? super Boolean, kotlin.f0> r1);

    d0 i(e0 r1);

    kotlin.u<Boolean, String> j(boolean r1, boolean r2, long r3, long r5, int r7, kotlin.n0.c.q<? super kotlin.v<g>, ? super Integer, ? super Boolean, kotlin.f0> r8);

    String k(String r1, String r2);

    void l(String r1, kotlin.n0.c.l<? super com.bytedance.android.sdk.bdticketguard.m1.c, kotlin.f0> r2);

    String m();

    l n(m r1);

    String o(String r1, String r2);
}
