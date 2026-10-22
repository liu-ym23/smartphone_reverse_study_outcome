package d.a.a.k;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
public class a implements Comparable<a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Method f12529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Field f12530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f12531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f12532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Class<?> f12534l;
    public final Type m;
    public final Class<?> n;
    public final boolean o;
    private final d.a.a.h.b p;
    private final d.a.a.h.b q;
    public final boolean r;
    public final String s;
    public final long t;
    public final String[] u;

    public a(String r3, Class<?> r4, Class<?> r5, Type r6, Field r7, int r8, int r9) {
        this.f12533k = 0;
        this.f12528f = r3;
        this.n = r4;
        this.f12534l = r5;
        this.m = r6;
        this.f12529g = null;
        this.f12530h = r7;
        this.f12533k = r8;
        this.r = r5.isEnum();
        this.p = null;
        this.q = null;
        if (r7 == null) goto L5;
        int r10 = r7.getModifiers();
        int r11 = r10 & 1;
        this.f12531i = true;
        this.f12532j = Modifier.isTransient(r10);
    L6:
        this.o = false;
        long r12 = -2128831035;
        int r13 = 0;
    L8:
        if (r13 >= r3.length()) goto L10;
        r12 = (r12 ^ ((long) r3.charAt(r13))) * 16777619;
        r13 = r13 + 1;
        goto L8
    L10:
        this.t = r12;
        this.s = null;
        this.u = new String[0];
        return;
    L5:
        this.f12531i = false;
        this.f12532j = false;
        goto L6
    }

    public a(String r17, Method r18, Field r19, Class<?> r20, Type r21, int r22, int r23, d.a.a.h.b r24, d.a.a.h.b r25, boolean r26) {
        Type r5 = r21;
        boolean r8 = false;
        this.f12533k = 0;
        this.f12528f = r17;
        this.f12529g = r18;
        this.f12530h = r19;
        this.f12533k = r22;
        this.q = r24;
        this.p = r25;
        d.a.a.h.b r9 = g();
        Type r10 = null;
        if (r9 == null) goto L8;
        String r11 = r9.format();
        if (r11.trim().length() != 0) goto L7;
        r11 = null;
    L7:
        this.u = r9.alternateNames();
    L9:
        this.s = r11;
        if (r19 == null) goto L25;
        int r12 = r19.getModifiers();
        if (r18 != null) goto L14;
    L19:
        boolean r13 = true;
    L20:
        this.f12531i = r13;
        if ((r12 & 128) == 0) goto L23;
        boolean r14 = true;
    L24:
        this.f12532j = r14;
    L26:
        long r15 = -2128831035;
        int r16 = 0;
    L28:
        if (r16 >= r17.length()) goto L30;
        r15 = (r15 ^ ((long) r17.charAt(r16))) * 16777619;
        r16 = r16 + 1;
        goto L28
    L30:
        this.t = r15;
        if (r18 == null) goto L51;
        Class<?>[] r1 = r18.getParameterTypes();
        if (r1.length != 1) goto L44;
        Class<?> r2 = r1[0];
        if (r2 == Class.class) goto L42;
        if (r2 == String.class) goto L42;
        if (r2.isPrimitive() == true) goto L42;
        if (r26 == false) goto L42;
        Type r3 = r18.getGenericParameterTypes()[0];
    L43:
        this.o = false;
    L50:
        this.n = r18.getDeclaringClass();
    L61:
        if (r20 == null) goto L90;
        if (r2 != Object.class) goto L90;
        if ((r3 instanceof TypeVariable) == false) goto L90;
        TypeVariable r4 = (TypeVariable) r3;
        if ((r5 instanceof ParameterizedType) == false) goto L68;
        Type[] r7 = ((ParameterizedType) r5).getActualTypeArguments();
    L69:
        Class<?> r110 = r20;
    L70:
        if (r110 == null) goto L78;
        if (r110 == Object.class) goto L78;
        if (r110 == this.n) goto L78;
        Type r111 = r110.getGenericSuperclass();
        if ((r111 instanceof ParameterizedType) == false) goto L77;
        Type[] r112 = ((ParameterizedType) r111).getActualTypeArguments();
        j(r112, r110.getTypeParameters(), r7);
        r7 = r112;
    L77:
        r110 = r110.getSuperclass();
    L78:
        if (r7 == null) goto L86;
        TypeVariable<Class<?>>[] r6 = this.n.getTypeParameters();
        int r113 = 0;
    L81:
        if (r113 >= r6.length) goto L86;
        if (r4.equals(r6[r113]) == true) goto L84;
        r113 = r113 + 1;
        goto L81
    L84:
        r10 = r7[r113];
    L86:
        if (r10 == null) goto L90;
        this.f12534l = d.u(r10);
        this.m = r10;
        this.r = r2.isEnum();
        return;
    L68:
        r7 = null;
    L90:
        if ((r3 instanceof Class) == true) goto L103;
        if (r5 != null) goto L94;
        r5 = r20;
    L94:
        Type r27 = k(r20, r5, r3);
        if (r27 != r3) goto L97;
    L102:
        r3 = r27;
        goto L103
    L97:
        if ((r27 instanceof ParameterizedType) == false) goto L100;
    L98:
        r2 = d.u(r27);
        goto L102
    L100:
        if ((r27 instanceof Class) == false) goto L102;
    L103:
        this.m = r3;
        this.f12534l = r2;
        if (r2.isArray() == false) goto L106;
    L108:
        this.r = r8;
        return;
    L106:
        if (r2.isEnum() == false) goto L108;
        r8 = true;
    L42:
        r3 = r2;
        goto L43
    L44:
        r2 = r18.getReturnType();
        if (r2 != Class.class) goto L47;
    L46:
        r3 = r2;
    L49:
        this.o = true;
        goto L50
    L47:
        if (r26 == false) goto L46;
        r3 = r18.getGenericReturnType();
        goto L49
    L51:
        r2 = r19.getType();
        if (r2.isPrimitive() == true) goto L59;
        if (r2 == String.class) goto L59;
        if (r2.isEnum() == true) goto L59;
        if (r26 == false) goto L59;
        Type r28 = r19.getGenericType();
    L60:
        this.n = r19.getDeclaringClass();
        this.o = Modifier.isFinal(r19.getModifiers());
        r3 = r28;
    L59:
        r28 = r2;
        goto L60
    L23:
        r14 = false;
        goto L24
    L14:
        if ((r12 & 1) != 0) goto L16;
    L18:
        r13 = false;
        goto L20
    L16:
        if (r18.getReturnType() != r19.getType()) goto L18;
    L25:
        this.f12531i = false;
        this.f12532j = false;
        goto L26
    L8:
        this.u = new String[0];
        r11 = null;
        goto L9
    }

    private static boolean j(Type[] r7, TypeVariable[] r8, Type[] r9) {
        if (r9 != null) goto L5;
    L26:
        return false;
    L5:
        if (r8.length == 0) goto L26;
        int r1 = 0;
        boolean r2 = false;
    L9:
        if (r1 >= r7.length) goto L25;
        Type r3 = r7[r1];
        if ((r3 instanceof ParameterizedType) == false) goto L16;
        ParameterizedType r4 = (ParameterizedType) r3;
        Type[] r5 = r4.getActualTypeArguments();
        if (j(r5, r8, r9) == false) goto L24;
        r7[r1] = new c(r5, r4.getOwnerType(), r4.getRawType());
        r2 = true;
    L24:
        r1 = r1 + 1;
        goto L9
    L16:
        if ((r3 instanceof TypeVariable) == false) goto L24;
        int r6 = 0;
    L19:
        if (r6 >= r8.length) goto L24;
        if (r3.equals(r8[r6]) == false) goto L23;
        r7[r1] = r9[r6];
        r2 = true;
    L23:
        r6 = r6 + 1;
        goto L19
    L25:
        return r2;
    }

    public static Type k(Class<?> r10, Type r11, Type r12) {
        if (r10 == null) goto L54;
        if (r11 == null) goto L54;
        if ((r12 instanceof GenericArrayType) == false) goto L13;
        Type r0 = ((GenericArrayType) r12).getGenericComponentType();
        Type r13 = k(r10, r11, r0);
        if (r0 != r13) goto L10;
        return r12;
    L10:
        return Array.newInstance(d.u(r13), 0).getClass();
    L13:
        if (d.A(r11) == true) goto L16;
        return r12;
    L16:
        if ((r12 instanceof TypeVariable) == false) goto L26;
        ParameterizedType r1 = (ParameterizedType) d.y(r11);
        Class<?> r2 = d.u(r1);
        TypeVariable r3 = (TypeVariable) r12;
        int r4 = 0;
    L19:
        if (r4 >= r2.getTypeParameters().length) goto L26;
        if (r2.getTypeParameters()[r4].getName().equals(r3.getName()) == true) goto L23;
        r4 = r4 + 1;
        goto L19
    L23:
        return r1.getActualTypeArguments()[r4];
    L26:
        if ((r12 instanceof ParameterizedType) == false) goto L54;
        ParameterizedType r5 = (ParameterizedType) r12;
        Type[] r6 = r5.getActualTypeArguments();
        Type[] r7 = null;
        if ((r11 instanceof ParameterizedType) == false) goto L32;
        ParameterizedType r14 = (ParameterizedType) r11;
    L30:
        TypeVariable<Class<?>>[] r15 = r10.getTypeParameters();
    L35:
        int r8 = 0;
        boolean r9 = false;
    L37:
        if (r8 >= r6.length) goto L51;
        if (r14 == null) goto L51;
        Type r16 = r6[r8];
        if ((r16 instanceof TypeVariable) == false) goto L50;
        TypeVariable r17 = (TypeVariable) r16;
        int r18 = 0;
    L43:
        if (r18 >= r15.length) goto L50;
        if (r15[r18].getName().equals(r17.getName()) == false) goto L49;
        if (r7 != null) goto L48;
        r7 = r14.getActualTypeArguments();
    L48:
        r6[r8] = r7[r18];
        r9 = true;
    L49:
        r18 = r18 + 1;
    L50:
        r8 = r8 + 1;
    L51:
        if (r9 == false) goto L54;
        return new c(r6, r5.getOwnerType(), r5.getRawType());
    L32:
        if ((r10.getGenericSuperclass() instanceof ParameterizedType) == false) goto L34;
        r14 = (ParameterizedType) r10.getGenericSuperclass();
        r10 = r10.getSuperclass();
        goto L30
    L34:
        r15 = null;
        r14 = null;
    L54:
        return r12;
    }

    public int a(a r3) {
        int r0 = this.f12533k;
        int r1 = r3.f12533k;
        if (r0 >= r1) goto L6;
        return -1;
    L6:
        if (r0 <= r1) goto L10;
        return 1;
    L10:
        return this.f12528f.compareTo(r3.f12528f);
    }

    public boolean b(a r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if (a(r2) == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public Object c(Object r2) {
        if (this.f12531i == false) goto L7;
        return this.f12530h.get(r2);
    L7:
        return this.f12529g.invoke(r2, new Object[0]);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a r1) {
        return a(r1);
    }

    public d.a.a.h.b g() {
        d.a.a.h.b r0 = this.p;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.q;
    }

    public void l(Object r3, Object r4) {
        Method r0 = this.f12529g;
        if (r0 == null) goto L6;
        r0.invoke(r3, new Object[]{r4});
        return;
    L6:
        this.f12530h.set(r3, r4);
    }

    public String toString() {
        return this.f12528f;
    }
}
