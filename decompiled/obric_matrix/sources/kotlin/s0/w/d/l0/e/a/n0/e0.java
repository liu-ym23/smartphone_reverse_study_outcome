package kotlin.s0.w.d.l0.e.a.n0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public interface e0 extends d {

    public static final class a {
        public static kotlin.s0.w.d.l0.e.a.n0.a a(e0 r3, kotlin.s0.w.d.l0.g.c r4) {
            kotlin.n0.d.o.f(r4, "fqName");
            Iterator<T> r5 = r3.getAnnotations().iterator();
        L3:
            Object r1 = null;
            if (r5.hasNext() == false) goto L12;
            Object r0 = r5.next();
            kotlin.s0.w.d.l0.g.b r2 = ((kotlin.s0.w.d.l0.e.a.n0.a) r0).f();
            if (r2 == null) goto L9;
            r1 = r2.b();
        L9:
            if (kotlin.n0.d.o.a(r1, r4) == false) goto L3;
            r1 = r0;
        L12:
            return (kotlin.s0.w.d.l0.e.a.n0.a) r1;
        }
    }
}
