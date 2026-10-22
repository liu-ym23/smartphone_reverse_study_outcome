package kotlin.s0.w.d.l0.o;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.y;

/* JADX INFO: loaded from: classes2.dex */
final class m implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f21231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f21232b = "should not have varargs or parameters with default values";

    static {
        f21231a = new m();
    }

    private m() {
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String a(y r1) {
        return f.a.a(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public boolean b(y r4) {
        kotlin.n0.d.o.f(r4, "functionDescriptor");
        List<j1> r3 = r4.h();
        kotlin.n0.d.o.e(r3, "functionDescriptor.valueParameters");
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L17;
        j1 r6 = (j1) r5.next();
        kotlin.n0.d.o.e(r6, "it");
        if (kotlin.s0.w.d.l0.k.t.a.a(r6) == false) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == true) goto L9;
        return false;
    L13:
        if (r6.l0() != null) goto L15;
        r7 = true;
    L17:
        return true;
    L5:
        if (r3.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // kotlin.s0.w.d.l0.o.f
    public String getDescription() {
        return f21232b;
    }
}
