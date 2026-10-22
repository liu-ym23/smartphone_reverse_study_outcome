package kotlin.s0.w.d.l0.o;

import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.y;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public b() {
    }

    public final g a(y r3) {
        kotlin.n0.d.o.f(r3, "functionDescriptor");
        Iterator<h> r2 = b().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        h r0 = r2.next();
        if (r0.b(r3) == false) goto L4;
        return r0.a(r3);
    L10:
        return g.a.f21214b;
    }

    public abstract List<h> b();
}
