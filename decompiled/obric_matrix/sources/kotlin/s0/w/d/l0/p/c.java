package kotlin.s0.w.d.l0.p;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final boolean a(Throwable r2) {
        o.f(r2, "<this>");
        Class<?> r3 = r2.getClass();
    L4:
        if (o.a(r3.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException") == true) goto L5;
        r3 = r3.getSuperclass();
        if (r3 != null) goto L4;
        return false;
    L5:
        return true;
    }

    public static final RuntimeException b(Throwable r1) {
        o.f(r1, "e");
        throw r1;
    }
}
