package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final void a(boolean r6, kotlin.n0.c.a<kotlin.u<Integer, String>> r7) {
        kotlin.n0.d.o.g(r7, "lazyCodeAndMessage");
        if (r6 == false) goto L5;
        return;
    L5:
        kotlin.u<Integer, String> r8 = r7.invoke();
        throw new c(r8.c().intValue(), r8.d(), null, 4, null);
    }
}
