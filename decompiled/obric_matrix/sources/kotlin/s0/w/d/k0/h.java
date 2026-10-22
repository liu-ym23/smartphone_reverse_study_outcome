package kotlin.s0.w.d.k0;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.s0.w.d.a0;
import kotlin.s0.w.d.i0;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.k1;
import kotlin.s0.w.d.l0.c.l;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.n1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\r*\u00020\u0002H\u0002\u001a\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, d2 = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class h {
    public static final Object a(Object r1, kotlin.s0.w.d.l0.c.b r2) {
        o.f(r2, "descriptor");
        if ((r2 instanceof u0) == true) goto L5;
    L7:
        e0 r0 = e(r2);
        if (r0 == null) goto L16;
        Class<?> r3 = i(r0);
        if (r3 == null) goto L17;
        Method r4 = f(r3, r2);
        if (r4 != null) goto L15;
        return r1;
    L15:
        return r4.invoke(r1, new Object[0]);
    L17:
        return r1;
    L16:
        return r1;
    L5:
        if (kotlin.s0.w.d.l0.k.f.d((k1) r2) == false) goto L7;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> d<M> b(d<? extends M> r5, kotlin.s0.w.d.l0.c.b r6, boolean r7) {
        o.f(r5, "<this>");
        o.f(r6, "descriptor");
        boolean r1 = true;
        if (kotlin.s0.w.d.l0.k.f.a(r6) == true) goto L29;
        List<j1> r0 = r6.h();
        o.e(r0, "descriptor.valueParameters");
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r2 = r0.iterator();
    L11:
        if (r2.hasNext() == false) goto L8;
        e0 r3 = ((j1) r2.next()).b();
        o.e(r3, "it.type");
        if (kotlin.s0.w.d.l0.k.f.c(r3) == false) goto L11;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L29;
        e0 r8 = r6.getReturnType();
        if (r8 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == true) goto L29;
        if ((r5 instanceof c) == false) goto L26;
    L28:
        r1 = false;
        goto L29
    L26:
        if (g(r6) == false) goto L28;
    L19:
        if (kotlin.s0.w.d.l0.k.f.c(r8) != true) goto L21;
        r9 = true;
    L8:
        r4 = false;
        goto L15
    L7:
        if (r0.isEmpty() == false) goto L9;
    L29:
        if (r1 == true) goto L31;
        return r5;
    L31:
        return new g(r6, r5, r7);
    }

    public static /* synthetic */ d c(d r0, kotlin.s0.w.d.l0.c.b r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return b(r0, r1, r2);
    }

    public static final Method d(Class<?> r4, kotlin.s0.w.d.l0.c.b r5) {
        o.f(r4, "<this>");
        o.f(r5, "descriptor");
        Method r0 = r4.getDeclaredMethod("box-impl", new Class[]{f(r4, r5).getReturnType()});     // Catch: NoSuchMethodException -> L5
        o.e(r0, "{\n        getDeclaredMet…riptor).returnType)\n    }");     // Catch: NoSuchMethodException -> L5
        return r0;
    L6:
        throw new a0("No box method found in inline class: " + r4 + " (calling " + r5 + ')');
    }

    private static final e0 e(kotlin.s0.w.d.l0.c.b r3) {
        x0 r0 = r3.m0();
        x0 r1 = r3.f0();
        if (r0 != null) goto L17;
        if (r1 != null) goto L8;
        return null;
    L8:
        if ((r3 instanceof l) == true) goto L18;
        m r4 = r3.c();
        if ((r4 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L13;
        kotlin.s0.w.d.l0.c.e r5 = (kotlin.s0.w.d.l0.c.e) r4;
    L14:
        if (r5 != null) goto L16;
        return null;
    L16:
        return r5.s();
    L13:
        r5 = null;
        goto L14
    L18:
        return r1.b();
    L17:
        return r0.b();
    }

    public static final Method f(Class<?> r3, kotlin.s0.w.d.l0.c.b r4) {
        o.f(r3, "<this>");
        o.f(r4, "descriptor");
        Method r0 = r3.getDeclaredMethod("unbox-impl", new Class[0]);     // Catch: NoSuchMethodException -> L5
        o.e(r0, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");     // Catch: NoSuchMethodException -> L5
        return r0;
    L6:
        throw new a0("No unbox method found in inline class: " + r3 + " (calling " + r4 + ')');
    }

    private static final boolean g(kotlin.s0.w.d.l0.c.b r2) {
        e0 r3 = e(r2);
        if (r3 == null) goto L8;
        if (kotlin.s0.w.d.l0.k.f.c(r3) != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static final Class<?> h(m r4) {
        if ((r4 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L5;
    L11:
        return null;
    L5:
        if (kotlin.s0.w.d.l0.k.f.b(r4) == false) goto L11;
        kotlin.s0.w.d.l0.c.e r0 = (kotlin.s0.w.d.l0.c.e) r4;
        Class<?> r1 = i0.o(r0);
        if (r1 == null) goto L10;
        return r1;
    L10:
        throw new a0("Class object for the class " + r0.getName() + " cannot be found (classId=" + kotlin.s0.w.d.l0.k.t.a.g((kotlin.s0.w.d.l0.c.h) r4) + ')');
    }

    public static final Class<?> i(e0 r3) {
        o.f(r3, "<this>");
        Class<?> r0 = h(r3.O0().d());
        if (r0 != null) goto L6;
        return null;
    L6:
        if (n1.l(r3) == true) goto L8;
        return r0;
    L8:
        e0 r4 = kotlin.s0.w.d.l0.k.f.e(r3);
        if (r4 != null) goto L12;
        return null;
    L12:
        if (n1.l(r4) == false) goto L14;
    L16:
        return null;
    L14:
        if (kotlin.s0.w.d.l0.b.h.r0(r4) == true) goto L16;
        return r0;
    }
}
