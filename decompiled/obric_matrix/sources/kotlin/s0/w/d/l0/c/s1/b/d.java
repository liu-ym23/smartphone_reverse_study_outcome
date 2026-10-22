package kotlin.s0.w.d.l0.c.s1.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.i0.m0;
import kotlin.n0.d.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<kotlin.s0.d<? extends Object>> f19121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f19122b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f19123c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<? extends kotlin.c<?>>, Integer> f19124d = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<ParameterizedType, ParameterizedType> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19125f = null;

        static {
            f19125f = new a();
        }

        a() {
            super(1);
        }

        public final ParameterizedType a(ParameterizedType r1) {
            kotlin.n0.d.o.f(r1, "it");
            Type r0 = r1.getOwnerType();
            if ((r0 instanceof ParameterizedType) == true) goto L7;
            return null;
        L7:
            return (ParameterizedType) r0;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ ParameterizedType invoke(ParameterizedType r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<ParameterizedType, kotlin.t0.h<? extends Type>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19126f = null;

        static {
            f19126f = new b();
        }

        b() {
            super(1);
        }

        public final kotlin.t0.h<Type> a(ParameterizedType r1) {
            kotlin.n0.d.o.f(r1, "it");
            Type[] r0 = r1.getActualTypeArguments();
            kotlin.n0.d.o.e(r0, "it.actualTypeArguments");
            return kotlin.i0.i.q(r0);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.t0.h<? extends Type> invoke(ParameterizedType r1) {
            return a(r1);
        }
    }

    static {
        int r3 = 0;
        List<kotlin.s0.d<? extends Object>> r1 = kotlin.i0.r.j(new kotlin.s0.d[]{e0.b(Boolean.TYPE), e0.b(Byte.TYPE), e0.b(Character.TYPE), e0.b(Double.TYPE), e0.b(Float.TYPE), e0.b(Integer.TYPE), e0.b(Long.TYPE), e0.b(Short.TYPE)});
        f19121a = r1;
        ArrayList r2 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator<T> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        kotlin.s0.d r12 = (kotlin.s0.d) r4.next();
        r2.add(kotlin.a0.a(kotlin.n0.a.c(r12), kotlin.n0.a.d(r12)));
        goto L4
    L6:
        f19122b = m0.q(r2);
        List<kotlin.s0.d<? extends Object>> r5 = f19121a;
        ArrayList r6 = new ArrayList(kotlin.i0.r.q(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        kotlin.s0.d r13 = (kotlin.s0.d) r7.next();
        r6.add(kotlin.a0.a(kotlin.n0.a.d(r13), kotlin.n0.a.c(r13)));
        goto L8
    L10:
        f19123c = m0.q(r6);
        List r0 = kotlin.i0.r.j(new Class[]{kotlin.n0.c.a.class, kotlin.n0.c.l.class, kotlin.n0.c.p.class, kotlin.n0.c.q.class, kotlin.n0.c.r.class, kotlin.n0.c.s.class, kotlin.n0.c.t.class, kotlin.n0.c.u.class, kotlin.n0.c.v.class, kotlin.n0.c.w.class, kotlin.n0.c.b.class, kotlin.n0.c.c.class, kotlin.n0.c.d.class, kotlin.n0.c.e.class, kotlin.n0.c.f.class, kotlin.n0.c.g.class, kotlin.n0.c.h.class, kotlin.n0.c.i.class, kotlin.n0.c.j.class, kotlin.n0.c.k.class, kotlin.n0.c.m.class, kotlin.n0.c.n.class, kotlin.n0.c.o.class});
        ArrayList r8 = new ArrayList(kotlin.i0.r.q(r0, 10));
        Iterator r9 = r0.iterator();
    L12:
        if (r9.hasNext() == false) goto L18;
        Object r10 = r9.next();
        int r11 = r3 + 1;
        if (r3 < 0) goto L16;
        r8.add(kotlin.a0.a((Class) r10, Integer.valueOf(r3)));
        r3 = r11;
        goto L12
    L16:
        kotlin.i0.r.p();
        throw null;
    L18:
        f19124d = m0.q(r8);
    }

    public static final kotlin.s0.w.d.l0.g.b a(Class<?> r3) {
        kotlin.n0.d.o.f(r3, "<this>");
        if (r3.isPrimitive() == true) goto L29;
        if (r3.isArray() == true) goto L27;
        if (r3.getEnclosingMethod() == null) goto L9;
    L24:
        kotlin.s0.w.d.l0.g.c r0 = new kotlin.s0.w.d.l0.g.c(r3.getName());
        return new kotlin.s0.w.d.l0.g.b(r0.e(), kotlin.s0.w.d.l0.g.c.k(r0.g()), true);
    L9:
        if (r3.getEnclosingConstructor() != null) goto L24;
        String r1 = r3.getSimpleName();
        kotlin.n0.d.o.e(r1, "simpleName");
        if (r1.length() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L24;
        Class<?> r4 = r3.getDeclaringClass();
        if (r4 == null) goto L22;
        kotlin.s0.w.d.l0.g.b r5 = a(r4);
        if (r5 == null) goto L22;
        kotlin.s0.w.d.l0.g.b r6 = r5.d(kotlin.s0.w.d.l0.g.f.k(r3.getSimpleName()));
        if (r6 == null) goto L22;
    L23:
        kotlin.n0.d.o.e(r6, "declaringClass?.classId?…Id.topLevel(FqName(name))");
        return r6;
    L22:
        r6 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c(r3.getName()));
        goto L23
    L13:
        r2 = false;
        goto L14
    L27:
        throw new IllegalArgumentException("Can't compute ClassId for array type: " + r3);
    L29:
        throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + r3);
    }

    public static final String b(Class<?> r9) {
        kotlin.n0.d.o.f(r9, "<this>");
        if (r9.isPrimitive() == false) goto L39;
        String r0 = r9.getName();
        if (r0 == null) goto L37;
        switch(r0.hashCode()) {
            case -1325958191: goto L34;
            case 104431: goto L31;
            case 3039496: goto L28;
            case 3052374: goto L25;
            case 3327612: goto L22;
            case 3625364: goto L19;
            case 64711720: goto L16;
            case 97526364: goto L13;
            case 109413500: goto L10;
            default: goto L37;
        };
    L10:
        if (r0.equals("short") == false) goto L37;
        return "S";
    L13:
        if (r0.equals(TypedValues.Custom.S_FLOAT) == false) goto L37;
        return "F";
    L16:
        if (r0.equals(TypedValues.Custom.S_BOOLEAN) == false) goto L37;
        return "Z";
    L19:
        if (r0.equals("void") == false) goto L37;
        return "V";
    L22:
        if (r0.equals("long") == false) goto L37;
        return "J";
    L25:
        if (r0.equals("char") == false) goto L37;
        return "C";
    L28:
        if (r0.equals("byte") == false) goto L37;
        return "B";
    L31:
        if (r0.equals("int") == false) goto L37;
        return "I";
    L34:
        if (r0.equals("double") == false) goto L37;
        return "D";
    L37:
        throw new IllegalArgumentException("Unsupported primitive type: " + r9);
    L39:
        if (r9.isArray() == false) goto L41;
        String r2 = r9.getName();
        kotlin.n0.d.o.e(r2, "name");
        return kotlin.u0.k.v(r2, '.', '/', false, 4, null);
    L41:
        StringBuilder r1 = new StringBuilder();
        r1.append('L');
        String r3 = r9.getName();
        kotlin.n0.d.o.e(r3, "name");
        r1.append(kotlin.u0.k.v(r3, '.', '/', false, 4, null));
        r1.append(';');
        return r1.toString();
    }

    public static final List<Type> c(Type r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        if ((r2 instanceof ParameterizedType) == false) goto L5;
        ParameterizedType r0 = (ParameterizedType) r2;
        if (r0.getOwnerType() != null) goto L11;
        Type[] r3 = r0.getActualTypeArguments();
        kotlin.n0.d.o.e(r3, "actualTypeArguments");
        return kotlin.i0.i.e0(r3);
    L11:
        return kotlin.t0.k.z(kotlin.t0.k.r(kotlin.t0.k.h(r2, a.f19125f), b.f19126f));
    L5:
        return kotlin.i0.r.g();
    }

    public static final Class<?> d(Class<?> r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return f19122b.get(r1);
    }

    public static final ClassLoader e(Class<?> r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        ClassLoader r2 = r1.getClassLoader();
        if (r2 != null) goto L6;
        ClassLoader r3 = ClassLoader.getSystemClassLoader();
        kotlin.n0.d.o.e(r3, "getSystemClassLoader()");
        return r3;
    L6:
        return r2;
    }

    public static final Class<?> f(Class<?> r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return f19123c.get(r1);
    }

    public static final boolean g(Class<?> r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return Enum.class.isAssignableFrom(r1);
    }
}
