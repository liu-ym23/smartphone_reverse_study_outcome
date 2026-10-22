package kotlin.s0.w.d;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.n.n1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class w {
    public static final /* synthetic */ kotlin.s0.w.d.k0.d a(v.a r0, boolean r1) {
        return b(r0, r1);
    }

    private static final kotlin.s0.w.d.k0.d<?> b(v.a<?, ?> r6, boolean r7) {
        if (i.f18591f.a().d(r6.y().D()) == true) goto L5;
        e r0 = f0.f18547a.f(r6.y().A());
        if ((r0 instanceof e.c) == false) goto L58;
        e.c r1 = (e.c) r0;
        kotlin.s0.w.d.l0.f.a0.a.d r2 = r1.f();
        if (r7 == false) goto L14;
        if (r2.G() == false) goto L16;
        kotlin.s0.w.d.l0.f.a0.a.c r3 = r2.B();
    L17:
        if (r3 == null) goto L19;
        Method r4 = r6.y().s().r(r1.d().b(r3.w()), r1.d().b(r3.v()));
    L20:
        if (r4 != null) goto L41;
        if (kotlin.s0.w.d.l0.k.f.d(r6.y().A()) == true) goto L24;
    L35:
        Field r5 = r6.y().C();
        if (r5 == null) goto L39;
    L60:
        kotlin.s0.w.d.k0.d r8 = c(r6, r7, r5);
    L73:
        return kotlin.s0.w.d.k0.h.c(r8, r6.x(), false, 2, null);
    L39:
        throw new a0("No accessors or field is found for property " + r6.y());
    L24:
        if (kotlin.n0.d.o.a(r6.y().A().getVisibility(), kotlin.s0.w.d.l0.c.t.f19162d) == false) goto L35;
        Class<?> r9 = kotlin.s0.w.d.k0.h.h(r6.y().A().c());
        if (r9 == null) goto L34;
        Method r10 = kotlin.s0.w.d.k0.h.f(r9, r6.y().A());
        if (r10 == null) goto L34;
        if (r6.w() == false) goto L32;
        r8 = new kotlin.s0.w.d.k0.i.a(r10, f(r6));
        goto L73
    L32:
        r8 = new kotlin.s0.w.d.k0.i.b(r10);
    L34:
        throw new a0("Underlying property of inline class " + r6.y() + " should have a field");
    L41:
        if (Modifier.isStatic(r4.getModifiers()) == true) goto L48;
        if (r6.w() == false) goto L45;
        kotlin.s0.w.d.k0.d r11 = new kotlin.s0.w.d.k0.e.h.a(r4, f(r6));
    L46:
        r8 = r11;
        goto L73
    L45:
        r11 = new kotlin.s0.w.d.k0.e.h.d(r4);
        goto L46
    L48:
        if (d(r6) == false) goto L54;
        if (r6.w() == false) goto L52;
        r11 = new kotlin.s0.w.d.k0.e.h.b(r4);
        goto L46
    L52:
        r11 = new kotlin.s0.w.d.k0.e.h.C0492e(r4);
        goto L46
    L54:
        if (r6.w() == false) goto L56;
        r11 = new kotlin.s0.w.d.k0.e.h.c(r4, f(r6));
        goto L46
    L56:
        r11 = new kotlin.s0.w.d.k0.e.h.f(r4);
        goto L46
    L19:
        r4 = null;
    L16:
        r3 = null;
        goto L17
    L14:
        if (r2.H() == false) goto L16;
        r3 = r2.C();
        goto L17
    L58:
        if ((r0 instanceof e.a) == false) goto L62;
        r5 = ((e.a) r0).b();
        goto L60
    L62:
        if ((r0 instanceof e.b) == false) goto L77;
        e.b r12 = (e.b) r0;
        if (r7 == false) goto L66;
        Method r13 = r12.b();
    L69:
        if (r6.w() == false) goto L71;
        r8 = new kotlin.s0.w.d.k0.e.h.a(r13, f(r6));
        goto L73
    L71:
        r8 = new kotlin.s0.w.d.k0.e.h.d(r13);
        goto L73
    L66:
        r13 = r12.c();
        if (r13 != null) goto L69;
        throw new a0("No source found for setter of Java method property: " + r12.b());
    L77:
        if ((r0 instanceof e.d) == false) goto L95;
        e.d r14 = (e.d) r0;
        if (r7 == false) goto L81;
        d.e r15 = r14.b();
    L83:
        Method r16 = r6.y().s().r(r15.c(), r15.b());
        if (r16 == null) goto L91;
        Modifier.isStatic(r16.getModifiers());
        if (r6.w() == false) goto L89;
        return new kotlin.s0.w.d.k0.e.h.a(r16, f(r6));
    L89:
        return new kotlin.s0.w.d.k0.e.h.d(r16);
    L91:
        throw new a0("No accessor found for property " + r6.y());
    L81:
        r15 = r14.c();
        if (r15 != null) goto L83;
        throw new a0("No setter found for property " + r6.y());
    L95:
        throw new kotlin.m();
    L5:
        return kotlin.s0.w.d.k0.j.f18661a;
    }

    private static final kotlin.s0.w.d.k0.e<Field> c(v.a<?, ?> r1, boolean r2, Field r3) {
        if (g(r1.y().A()) == false) goto L5;
    L21:
        if (r2 == false) goto L27;
        if (r1.w() == false) goto L35;
        kotlin.s0.w.d.k0.e<Field> r4 = new kotlin.s0.w.d.k0.e.f.a(r3, f(r1));
    L31:
        return r4;
    L35:
        return new kotlin.s0.w.d.k0.e.f.c(r3);
    L27:
        if (r1.w() == false) goto L29;
        r4 = new kotlin.s0.w.d.k0.e.g.a(r3, e(r1), f(r1));
        goto L31
    L29:
        r4 = new kotlin.s0.w.d.k0.e.g.c(r3, e(r1));
        goto L31
    L5:
        if (Modifier.isStatic(r3.getModifiers()) == false) goto L21;
        if (d(r1) == false) goto L18;
        if (r2 == false) goto L15;
        if (r1.w() == false) goto L33;
        return new kotlin.s0.w.d.k0.e.f.b(r3);
    L33:
        return new kotlin.s0.w.d.k0.e.f.d(r3);
    L15:
        if (r1.w() == false) goto L17;
        r4 = new kotlin.s0.w.d.k0.e.g.b(r3, e(r1));
        goto L31
    L17:
        r4 = new kotlin.s0.w.d.k0.e.g.d(r3, e(r1));
        goto L31
    L18:
        if (r2 == true) goto L34;
        r4 = new kotlin.s0.w.d.k0.e.g.C0491e(r3, e(r1));
        goto L31
    L34:
        return new kotlin.s0.w.d.k0.e.f.C0490e(r3);
    }

    private static final boolean d(v.a<?, ?> r1) {
        return r1.y().A().getAnnotations().k(i0.i());
    }

    private static final boolean e(v.a<?, ?> r0) {
        return !n1.l(r0.y().A().b());
    }

    public static final Object f(v.a<?, ?> r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return r1.y().y();
    }

    private static final boolean g(u0 r4) {
        kotlin.s0.w.d.l0.c.m r0 = r4.c();
        kotlin.n0.d.o.e(r0, "containingDeclaration");
        if (kotlin.s0.w.d.l0.k.d.x(r0) == true) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.c.m r1 = r0.c();
        if (kotlin.s0.w.d.l0.k.d.C(r1) == true) goto L12;
        if (kotlin.s0.w.d.l0.k.d.t(r1) == true) goto L12;
    L16:
        return true;
    L12:
        if ((r4 instanceof kotlin.s0.w.d.l0.l.b.g0.j) == true) goto L14;
        return false;
    L14:
        if (kotlin.s0.w.d.l0.f.a0.b.i.f(((kotlin.s0.w.d.l0.l.b.g0.j) r4).g1()) == true) goto L16;
        return false;
    }
}
