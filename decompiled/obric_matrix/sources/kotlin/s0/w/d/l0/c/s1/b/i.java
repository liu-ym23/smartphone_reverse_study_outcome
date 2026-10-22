package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final e a(Annotation[] r5, kotlin.s0.w.d.l0.g.c r6) {
        kotlin.n0.d.o.f(r5, "<this>");
        kotlin.n0.d.o.f(r6, "fqName");
        int r0 = r5.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        Annotation r3 = r5[r1];
        if (kotlin.n0.d.o.a(d.a(kotlin.n0.a.b(kotlin.n0.a.a(r3))).b(), r6) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        return new e(r3);
    L9:
        r3 = null;
        goto L10
    }

    public static final List<e> b(Annotation[] r5) {
        kotlin.n0.d.o.f(r5, "<this>");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(new e(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
