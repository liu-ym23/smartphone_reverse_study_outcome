package kotlin.s0.w.d.l0.k.w;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface k {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(k r0, d r1, kotlin.n0.c.l r2, int r3, Object r4) {
            if (r4 != null) goto L12;
            if ((r3 & 1) == 0) goto L7;
            r1 = d.o;
        L7:
            if ((r3 & 2) == 0) goto L10;
            r2 = h.f20646a.a();
        L10:
            return r0.g(r1, r2);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }
    }

    kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2);

    Collection<kotlin.s0.w.d.l0.c.m> g(d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2);
}
