package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends kotlin.s0.w.d.l0.e.a.n0.d {

    public static final class a {
        public static e a(h r1, kotlin.s0.w.d.l0.g.c r2) {
            kotlin.n0.d.o.f(r2, "fqName");
            AnnotatedElement r3 = r1.v();
            if (r3 == null) goto L7;
            Annotation[] r4 = r3.getDeclaredAnnotations();
            if (r4 == null) goto L7;
            return i.a(r4, r2);
        L7:
            return null;
        }

        public static List<e> b(h r0) {
            AnnotatedElement r1 = r0.v();
            if (r1 == null) goto L9;
            Annotation[] r2 = r1.getDeclaredAnnotations();
            if (r2 == null) goto L9;
            List<e> r3 = i.b(r2);
            if (r3 == null) goto L9;
            return r3;
        L9:
            return kotlin.i0.r.g();
        }

        public static boolean c(h r0) {
            return false;
        }
    }

    AnnotatedElement v();
}
