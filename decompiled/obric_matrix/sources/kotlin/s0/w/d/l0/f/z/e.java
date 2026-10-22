package kotlin.s0.w.d.l0.f.z;

import java.util.List;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends kotlin.s0.w.d.l0.i.i.d<M>, T> T a(kotlin.s0.w.d.l0.i.i.d<M> r1, kotlin.s0.w.d.l0.i.i.f<M, T> r2) {
        o.f(r1, "<this>");
        o.f(r2, "extension");
        if (r1.w(r2) == true) goto L7;
        return null;
    L7:
        return (T) r1.t(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends kotlin.s0.w.d.l0.i.i.d<M>, T> T b(kotlin.s0.w.d.l0.i.i.d<M> r1, kotlin.s0.w.d.l0.i.i.f<M, List<T>> r2, int r3) {
        o.f(r1, "<this>");
        o.f(r2, "extension");
        if (r3 < r1.v(r2)) goto L7;
        return null;
    L7:
        return (T) r1.u(r2, r3);
    }
}
