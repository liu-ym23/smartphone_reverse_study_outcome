package kotlin.s0.w.d.l0.c.s1.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.e.b.q;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19084a = null;

    static {
        f19084a = new c();
    }

    private c() {
    }

    private final kotlin.s0.w.d.l0.k.r.f a(Class<?> r4) {
        int r3 = 0;
    L4:
        if (r4.isArray() == false) goto L7;
        r3 = r3 + 1;
        r4 = r4.getComponentType();
        o.e(r4, "currentClass.componentType");
        goto L4
    L7:
        if (r4.isPrimitive() == true) goto L9;
        kotlin.s0.w.d.l0.g.b r5 = kotlin.s0.w.d.l0.c.s1.b.d.a(r4);
        kotlin.s0.w.d.l0.b.q.c r0 = kotlin.s0.w.d.l0.b.q.c.f18771a;
        kotlin.s0.w.d.l0.g.c r1 = r5.b();
        o.e(r1, "javaClassId.asSingleFqName()");
        kotlin.s0.w.d.l0.g.b r2 = r0.m(r1);
        if (r2 == null) goto L23;
        r5 = r2;
    L23:
        return new kotlin.s0.w.d.l0.k.r.f(r5, r3);
    L9:
        if (o.a(r4, Void.TYPE) == false) goto L12;
        kotlin.s0.w.d.l0.g.b r6 = kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.b.k.a.f18722e.l());
        o.e(r6, "topLevel(StandardNames.FqNames.unit.toSafe())");
        return new kotlin.s0.w.d.l0.k.r.f(r6, r3);
    L12:
        kotlin.s0.w.d.l0.b.i r7 = kotlin.s0.w.d.l0.k.u.e.b(r4.getName()).k();
        o.e(r7, "get(currentClass.name).primitiveType");
        if (r3 <= 0) goto L16;
        kotlin.s0.w.d.l0.g.b r8 = kotlin.s0.w.d.l0.g.b.m(r7.b());
        o.e(r8, "topLevel(primitiveType.arrayTypeFqName)");
        return new kotlin.s0.w.d.l0.k.r.f(r8, r3 - 1);
    L16:
        kotlin.s0.w.d.l0.g.b r9 = kotlin.s0.w.d.l0.g.b.m(r7.g());
        o.e(r9, "topLevel(primitiveType.typeFqName)");
        return new kotlin.s0.w.d.l0.k.r.f(r9, r3);
    }

    private final void c(Class<?> r20, q.d r21) {
        Constructor<?>[] r0 = r20.getDeclaredConstructors();
        o.e(r0, "klass.declaredConstructors");
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L28;
        Constructor<?> r4 = r0[r3];
        kotlin.s0.w.d.l0.g.f r5 = kotlin.s0.w.d.l0.g.h.f20279f;
        m r6 = m.f19098a;
        o.e(r4, "constructor");
        q.e r7 = r21.b(r5, r6.a(r4));
        if (r7 != null) goto L7;
        Constructor<?>[] r16 = r0;
        int r17 = r1;
    L27:
        r3 = r3 + 1;
        r0 = r16;
        r1 = r17;
        goto L3
    L7:
        Annotation[] r8 = r4.getDeclaredAnnotations();
        o.e(r8, "constructor.declaredAnnotations");
        int r9 = r8.length;
        int r10 = 0;
    L9:
        if (r10 >= r9) goto L11;
        Annotation r11 = r8[r10];
        o.e(r11, "annotation");
        f(r7, r11);
        r10 = r10 + 1;
        goto L9
    L11:
        Annotation[][] r12 = r4.getParameterAnnotations();
        o.e(r12, "parameterAnnotations");
        if (r12.length != 0) goto L14;
        boolean r13 = true;
    L16:
        if ((!r13) == false) goto L26;
        int r14 = r4.getParameterTypes().length - r12.length;
        int r15 = r12.length;
        int r18 = 0;
    L18:
        if (r18 >= r15) goto L26;
        Annotation[] r19 = r12[r18];
        o.e(r19, "annotations");
        int r110 = r19.length;
        int r111 = 0;
    L20:
        if (r111 >= r110) goto L25;
        Annotation r112 = r19[r111];
        Class<?> r2 = kotlin.n0.a.b(kotlin.n0.a.a(r112));
        Constructor<?>[] r113 = r0;
        int r114 = r1;
        kotlin.s0.w.d.l0.g.b r22 = kotlin.s0.w.d.l0.c.s1.b.d.a(r2);
        int r115 = r14;
        o.e(r112, "annotation");
        q.a r23 = r7.c(r18 + r14, r22, new b(r112));
        if (r23 == null) goto L24;
        f19084a.h(r23, r112, r2);
    L24:
        r111 = r111 + 1;
        r0 = r113;
        r1 = r114;
        r14 = r115;
        goto L20
    L25:
        r18 = r18 + 1;
    L26:
        r16 = r0;
        r17 = r1;
        r7.a();
        goto L27
    L14:
        r13 = false;
        goto L16
    }

    private final void d(Class<?> r10, q.d r11) {
        Field[] r12 = r10.getDeclaredFields();
        o.e(r12, "klass.declaredFields");
        int r0 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        Field r3 = r12[r2];
        kotlin.s0.w.d.l0.g.f r4 = kotlin.s0.w.d.l0.g.f.k(r3.getName());
        o.e(r4, "identifier(field.name)");
        m r5 = m.f19098a;
        o.e(r3, "field");
        q.c r6 = r11.a(r4, r5.b(r3), null);
        if (r6 == null) goto L11;
        Annotation[] r7 = r3.getDeclaredAnnotations();
        o.e(r7, "field.declaredAnnotations");
        int r8 = r7.length;
        int r9 = 0;
    L8:
        if (r9 >= r8) goto L10;
        Annotation r13 = r7[r9];
        o.e(r13, "annotation");
        f(r6, r13);
        r9 = r9 + 1;
        goto L8
    L10:
        r6.a();
    L11:
        r2 = r2 + 1;
        goto L3
    }

    private final void e(Class<?> r18, q.d r19) {
        Method[] r0 = r18.getDeclaredMethods();
        o.e(r0, "klass.declaredMethods");
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L22;
        Method r4 = r0[r3];
        kotlin.s0.w.d.l0.g.f r5 = kotlin.s0.w.d.l0.g.f.k(r4.getName());
        o.e(r5, "identifier(method.name)");
        m r6 = m.f19098a;
        o.e(r4, "method");
        q.e r7 = r19.b(r5, r6.c(r4));
        if (r7 != null) goto L7;
        Method[] r16 = r0;
    L21:
        r3 = r3 + 1;
        r0 = r16;
        goto L3
    L7:
        Annotation[] r8 = r4.getDeclaredAnnotations();
        o.e(r8, "method.declaredAnnotations");
        int r9 = r8.length;
        int r10 = 0;
    L9:
        if (r10 >= r9) goto L11;
        Annotation r11 = r8[r10];
        o.e(r11, "annotation");
        f(r7, r11);
        r10 = r10 + 1;
        goto L9
    L11:
        Annotation[][] r12 = r4.getParameterAnnotations();
        o.e(r12, "method.parameterAnnotations");
        int r13 = r12.length;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L20;
        Annotation[] r15 = r12[r14];
        o.e(r15, "annotations");
        int r17 = r15.length;
        int r110 = 0;
    L14:
        if (r110 >= r17) goto L19;
        Annotation r111 = r15[r110];
        Class<?> r112 = kotlin.n0.a.b(kotlin.n0.a.a(r111));
        kotlin.s0.w.d.l0.g.b r2 = kotlin.s0.w.d.l0.c.s1.b.d.a(r112);
        Method[] r113 = r0;
        o.e(r111, "annotation");
        q.a r20 = r7.c(r14, r2, new b(r111));
        if (r20 == null) goto L18;
        f19084a.h(r20, r111, r112);
    L18:
        r110 = r110 + 1;
        r0 = r113;
        goto L14
    L19:
        r14 = r14 + 1;
        goto L12
    L20:
        r16 = r0;
        r7.a();
        goto L21
    }

    private final void f(q.c r3, Annotation r4) {
        Class<?> r2 = kotlin.n0.a.b(kotlin.n0.a.a(r4));
        q.a r5 = r3.b(kotlin.s0.w.d.l0.c.s1.b.d.a(r2), new b(r4));
        if (r5 == null) goto L6;
        f19084a.h(r5, r4, r2);
        return;
    }

    private final void g(q.a r8, kotlin.s0.w.d.l0.g.f r9, Object r10) {
        Class<?> r0 = r10.getClass();
        if (o.a(r0, Class.class) == false) goto L6;
        o.d(r10, "null cannot be cast to non-null type java.lang.Class<*>");
        r8.b(r9, a((Class) r10));
        return;
    L6:
        if (i.a().contains(r0) == false) goto L9;
        r8.c(r9, r10);
        return;
    L9:
        if (kotlin.s0.w.d.l0.c.s1.b.d.g(r0) == false) goto L16;
        if (r0.isEnum() == true) goto L14;
        r0 = r0.getEnclosingClass();
    L14:
        o.e(r0, "if (clazz.isEnum) clazz else clazz.enclosingClass");
        kotlin.s0.w.d.l0.g.b r7 = kotlin.s0.w.d.l0.c.s1.b.d.a(r0);
        o.d(r10, "null cannot be cast to non-null type kotlin.Enum<*>");
        kotlin.s0.w.d.l0.g.f r11 = kotlin.s0.w.d.l0.g.f.k(((Enum) r10).name());
        o.e(r11, "identifier((value as Enum<*>).name)");
        r8.d(r9, r7, r11);
        return;
    L16:
        if (Annotation.class.isAssignableFrom(r0) == false) goto L22;
        Class<?>[] r1 = r0.getInterfaces();
        o.e(r1, "clazz.interfaces");
        Class<?> r2 = (Class) kotlin.i0.i.S(r1);
        o.e(r2, "annotationClass");
        q.a r12 = r8.e(r9, kotlin.s0.w.d.l0.c.s1.b.d.a(r2));
        if (r12 != null) goto L20;
        return;
    L20:
        o.d(r10, "null cannot be cast to non-null type kotlin.Annotation");
        h(r12, (Annotation) r10, r2);
        return;
    L22:
        if (r0.isArray() == false) goto L51;
        q.b r13 = r8.f(r9);
        if (r13 != null) goto L26;
        return;
    L26:
        Class<?> r14 = r0.getComponentType();
        int r5 = 0;
        if (r14.isEnum() == false) goto L32;
        o.e(r14, "componentType");
        kotlin.s0.w.d.l0.g.b r15 = kotlin.s0.w.d.l0.c.s1.b.d.a(r14);
        o.d(r10, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r16 = (Object[]) r10;
        int r17 = r16.length;
    L29:
        if (r5 >= r17) goto L48;
        Object r3 = r16[r5];
        o.d(r3, "null cannot be cast to non-null type kotlin.Enum<*>");
        kotlin.s0.w.d.l0.g.f r4 = kotlin.s0.w.d.l0.g.f.k(((Enum) r3).name());
        o.e(r4, "identifier((element as Enum<*>).name)");
        r13.c(r15, r4);
        r5 = r5 + 1;
    L48:
        r13.a();
        return;
    L32:
        if (o.a(r14, Class.class) == false) goto L36;
        o.d(r10, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r18 = (Object[]) r10;
        int r19 = r18.length;
    L34:
        if (r5 >= r19) goto L48;
        Object r6 = r18[r5];
        o.d(r6, "null cannot be cast to non-null type java.lang.Class<*>");
        r13.e(a((Class) r6));
        r5 = r5 + 1;
        goto L34
    L36:
        boolean r20 = Annotation.class.isAssignableFrom(r14);
        o.d(r10, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r110 = (Object[]) r10;
        if (r20 == false) goto L45;
        int r21 = r110.length;
    L39:
        if (r5 >= r21) goto L48;
        Object r22 = r110[r5];
        o.e(r14, "componentType");
        q.a r23 = r13.d(kotlin.s0.w.d.l0.c.s1.b.d.a(r14));
        if (r23 == null) goto L44;
        o.d(r22, "null cannot be cast to non-null type kotlin.Annotation");
        h(r23, (Annotation) r22, r14);
    L44:
        r5 = r5 + 1;
        goto L39
    L45:
        int r24 = r110.length;
    L46:
        if (r5 >= r24) goto L48;
        r13.b(r110[r5]);
        r5 = r5 + 1;
        goto L46
    L51:
        throw new UnsupportedOperationException("Unsupported annotation argument value (" + r0 + "): " + r10);
    }

    private final void h(q.a r7, Annotation r8, Class<?> r9) {
        Method[] r10 = r9.getDeclaredMethods();
        o.e(r10, "annotationType.declaredMethods");
        int r0 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Method r3 = r10[r2];
        Object r4 = r3.invoke(r8, new Object[0]);     // Catch: IllegalAccessException -> L10
        o.c(r4);     // Catch: IllegalAccessException -> L10
        kotlin.s0.w.d.l0.g.f r5 = kotlin.s0.w.d.l0.g.f.k(r3.getName());
        o.e(r5, "identifier(method.name)");
        g(r7, r5, r4);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        r7.a();
    }

    public final void b(Class<?> r5, q.c r6) {
        o.f(r5, "klass");
        o.f(r6, "visitor");
        Annotation[] r7 = r5.getDeclaredAnnotations();
        o.e(r7, "klass.declaredAnnotations");
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Annotation r2 = r7[r1];
        o.e(r2, "annotation");
        f(r6, r2);
        r1 = r1 + 1;
        goto L3
    L5:
        r6.a();
    }

    public final void i(Class<?> r2, q.d r3) {
        o.f(r2, "klass");
        o.f(r3, "memberVisitor");
        e(r2, r3);
        c(r2, r3);
        d(r2, r3);
    }
}
