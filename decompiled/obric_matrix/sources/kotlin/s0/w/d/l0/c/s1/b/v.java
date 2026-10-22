package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.Modifier;
import kotlin.s0.w.d.l0.c.m1;
import kotlin.s0.w.d.l0.c.n1;

/* JADX INFO: loaded from: classes2.dex */
public interface v extends kotlin.s0.w.d.l0.e.a.n0.s {

    public static final class a {
        public static n1 a(v r1) {
            int r2 = r1.D();
            if (Modifier.isPublic(r2) == false) goto L6;
            return m1.h.f18895c;
        L6:
            if (Modifier.isPrivate(r2) == false) goto L9;
            return m1.e.f18892c;
        L9:
            if (Modifier.isProtected(r2) == false) goto L15;
            if (Modifier.isStatic(r2) == false) goto L19;
            return kotlin.s0.w.d.l0.c.r1.c.f19076c;
        L19:
            return kotlin.s0.w.d.l0.c.r1.b.f19075c;
        L15:
            return kotlin.s0.w.d.l0.c.r1.a.f19074c;
        }

        public static boolean b(v r0) {
            return Modifier.isAbstract(r0.D());
        }

        public static boolean c(v r0) {
            return Modifier.isFinal(r0.D());
        }

        public static boolean d(v r0) {
            return Modifier.isStatic(r0.D());
        }
    }

    int D();
}
