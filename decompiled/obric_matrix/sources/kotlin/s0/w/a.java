package kotlin.s0.w;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.s0.d;
import kotlin.s0.e;
import kotlin.s0.m;
import kotlin.s0.n;
import kotlin.s0.w.d.a0;
import kotlin.s0.w.d.l0.c.f;
import kotlin.s0.w.d.l0.c.h;
import kotlin.s0.w.d.x;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class a {
    public static final d<?> a(e r5) {
        o.f(r5, "<this>");
        if ((r5 instanceof d) == false) goto L6;
        return (d) r5;
    L6:
        if ((r5 instanceof n) == false) goto L31;
        List<m> r6 = ((n) r5).getUpperBounds();
        Iterator<T> r0 = r6.iterator();
    L8:
        Object r2 = null;
        kotlin.s0.w.d.l0.c.e r3 = null;
        if (r0.hasNext() == false) goto L22;
        Object r1 = r0.next();
        m r4 = (m) r1;
        o.d(r4, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        h r7 = ((x) r4).k().O0().d();
        if ((r7 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L13;
        r3 = (kotlin.s0.w.d.l0.c.e) r7;
    L13:
        if (r3 != null) goto L15;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == false) goto L8;
        r2 = r1;
        goto L22
    L15:
        if (r3.i() == f.f18866g) goto L19;
        if (r3.i() == f.f18869j) goto L19;
        r8 = true;
    L22:
        m r9 = (m) r2;
        if (r9 != null) goto L25;
        r9 = (m) r.R(r6);
    L25:
        if (r9 == null) goto L29;
        d<?> r10 = b(r9);
        if (r10 == null) goto L29;
        return r10;
    L29:
        return e0.b(Object.class);
    L31:
        throw new a0("Cannot calculate JVM erasure for type: " + r5);
    }

    public static final d<?> b(m r3) {
        o.f(r3, "<this>");
        e r0 = r3.d();
        if (r0 == null) goto L8;
        d<?> r1 = a(r0);
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new a0("Cannot calculate JVM erasure for type: " + r3);
    }
}
