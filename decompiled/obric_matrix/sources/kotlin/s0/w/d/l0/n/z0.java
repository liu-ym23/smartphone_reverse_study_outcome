package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public interface z0 {

    public static final class a {
        public static /* synthetic */ a1 a(z0 r1, kotlin.s0.w.d.l0.c.o1.g r2, e1 r3, kotlin.s0.w.d.l0.c.m r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r3 = null;
        L7:
            if ((r5 & 4) == 0) goto L10;
            r4 = null;
        L10:
            return r1.a(r2, r3, r4);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
        }
    }

    a1 a(kotlin.s0.w.d.l0.c.o1.g r1, e1 r2, kotlin.s0.w.d.l0.c.m r3);
}
