package kotlin.s0.w.d.l0.o;

import kotlin.s0.w.d.l0.c.y;

/* JADX INFO: loaded from: classes2.dex */
public interface f {

    public static final class a {
        public static String a(f r1, y r2) {
            kotlin.n0.d.o.f(r2, "functionDescriptor");
            if (r1.b(r2) == false) goto L7;
            return null;
        L7:
            return r1.getDescription();
        }
    }

    String a(y r1);

    boolean b(y r1);

    String getDescription();
}
