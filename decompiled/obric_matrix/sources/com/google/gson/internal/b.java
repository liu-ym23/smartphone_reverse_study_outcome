package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f6917a = null;

    private static final class a implements GenericArrayType, Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f6918f;

        public a(Type r1) {
            Objects.requireNonNull(r1);
            this.f6918f = b.b(r1);
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (b.f(this, (GenericArrayType) r2) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f6918f;
        }

        public int hashCode() {
            return this.f6918f.hashCode();
        }

        public String toString() {
            return b.t(this.f6918f) + "[]";
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.b$b, reason: collision with other inner class name */
    private static final class C0210b implements ParameterizedType, Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f6919f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Type f6920g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Type[] f6921h;

        public C0210b(Type r5, Type r6, Type... r7) {
            Objects.requireNonNull(r6);
            int r1 = 0;
            if ((r6 instanceof Class) == false) goto L16;
            Class r0 = (Class) r6;
            boolean r3 = true;
            if (Modifier.isStatic(r0.getModifiers()) == false) goto L7;
        L10:
            boolean r2 = true;
        L11:
            if (r5 != null) goto L15;
            if (r2 == true) goto L15;
            r3 = false;
        L15:
            com.google.gson.internal.a.a(r3);
            goto L16
        L7:
            if (r0.getEnclosingClass() == null) goto L10;
            r2 = false;
        L16:
            if (r5 != null) goto L18;
            Type r8 = null;
        L19:
            this.f6919f = r8;
            this.f6920g = b.b(r6);
            Type[] r9 = (Type[]) r7.clone();
            this.f6921h = r9;
            int r10 = r9.length;
        L20:
            if (r1 >= r10) goto L22;
            Objects.requireNonNull(this.f6921h[r1]);
            b.c(this.f6921h[r1]);
            Type[] r11 = this.f6921h;
            r11[r1] = b.b(r11[r1]);
            r1 = r1 + 1;
            goto L20
        L22:
            return;
        L18:
            r8 = b.b(r5);
            goto L19
        }

        private static int a(Object r0) {
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (b.f(this, (ParameterizedType) r2) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f6921h.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f6919f;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f6920g;
        }

        public int hashCode() {
            int r0 = Arrays.hashCode(this.f6921h) ^ this.f6920g.hashCode();
            return a(this.f6919f) ^ r0;
        }

        public String toString() {
            int r0 = this.f6921h.length;
            if (r0 == 0) goto L5;
            StringBuilder r1 = new StringBuilder((r0 + 1) * 30);
            r1.append(b.t(this.f6920g));
            r1.append("<");
            r1.append(b.t(this.f6921h[0]));
            int r2 = 1;
        L7:
            if (r2 >= r0) goto L9;
            r1.append(", ");
            r1.append(b.t(this.f6921h[r2]));
            r2 = r2 + 1;
            goto L7
        L9:
            r1.append(">");
            return r1.toString();
        L5:
            return b.t(this.f6920g);
        }
    }

    private static final class c implements WildcardType, Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f6922f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Type f6923g;

        public c(Type[] r5, Type[] r6) {
            boolean r2 = true;
            if (r6.length > 1) goto L5;
            boolean r1 = true;
        L6:
            com.google.gson.internal.a.a(r1);
            if (r5.length != 1) goto L9;
            boolean r3 = true;
        L10:
            com.google.gson.internal.a.a(r3);
            if (r6.length != 1) goto L17;
            Objects.requireNonNull(r6[0]);
            b.c(r6[0]);
            if (r5[0] == Object.class) goto L16;
            r2 = false;
        L16:
            com.google.gson.internal.a.a(r2);
            this.f6923g = b.b(r6[0]);
            this.f6922f = Object.class;
            return;
        L17:
            Objects.requireNonNull(r5[0]);
            b.c(r5[0]);
            this.f6923g = null;
            this.f6922f = b.b(r5[0]);
            return;
        L9:
            r3 = false;
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (b.f(this, (WildcardType) r2) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r2 = this.f6923g;
            if (r2 == null) goto L6;
            return new Type[]{r2};
        L6:
            return b.f6917a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f6922f};
        }

        public int hashCode() {
            Type r0 = this.f6923g;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode() + 31;
        L7:
            return (this.f6922f.hashCode() + 31) ^ r1;
        L5:
            r1 = 1;
            goto L7
        }

        public String toString() {
            if (this.f6923g == null) goto L8;
            StringBuilder r0 = new StringBuilder();
            r0.append("? super ");
            Type r2 = this.f6923g;
        L5:
            r0.append(b.t(r2));
            return r0.toString();
        L8:
            if (this.f6922f != Object.class) goto L11;
            return "?";
        L11:
            r0 = new StringBuilder();
            r0.append("? extends ");
            r2 = this.f6922f;
            goto L5
        }
    }

    static {
        f6917a = new Type[0];
    }

    public static GenericArrayType a(Type r1) {
        return new a(r1);
    }

    public static Type b(Type r3) {
        if ((r3 instanceof Class) == false) goto L9;
        Class r4 = (Class) r3;
        if (r4.isArray() == true) goto L7;
        return r4;
    L7:
        return new a(b(r4.getComponentType()));
    L9:
        if ((r3 instanceof ParameterizedType) == false) goto L13;
        ParameterizedType r5 = (ParameterizedType) r3;
        return new C0210b(r5.getOwnerType(), r5.getRawType(), r5.getActualTypeArguments());
    L13:
        if ((r3 instanceof GenericArrayType) == false) goto L17;
        return new a(((GenericArrayType) r3).getGenericComponentType());
    L17:
        if ((r3 instanceof WildcardType) == false) goto L20;
        WildcardType r6 = (WildcardType) r3;
        return new c(r6.getUpperBounds(), r6.getLowerBounds());
    L20:
        return r3;
    }

    static void c(Type r1) {
        if ((r1 instanceof Class) == true) goto L5;
    L8:
        boolean r2 = true;
    L9:
        com.google.gson.internal.a.a(r2);
        return;
    L5:
        if (((Class) r1).isPrimitive() == false) goto L8;
        r2 = false;
        goto L9
    }

    private static Class<?> d(TypeVariable<?> r1) {
        GenericDeclaration r2 = r1.getGenericDeclaration();
        if ((r2 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r2;
    }

    private static boolean e(Object r0, Object r1) {
        return Objects.equals(r0, r1);
    }

    public static boolean f(Type r4, Type r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if ((r4 instanceof Class) == false) goto L10;
        return r4.equals(r5);
    L10:
        if ((r4 instanceof ParameterizedType) == false) goto L24;
        if ((r5 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r6 = (ParameterizedType) r4;
        ParameterizedType r7 = (ParameterizedType) r5;
        if (e(r6.getOwnerType(), r7.getOwnerType()) == false) goto L22;
        if (r6.getRawType().equals(r7.getRawType()) == false) goto L22;
        if (Arrays.equals(r6.getActualTypeArguments(), r7.getActualTypeArguments()) == false) goto L22;
        return true;
    L22:
        return false;
    L24:
        if ((r4 instanceof GenericArrayType) == false) goto L31;
        if ((r5 instanceof GenericArrayType) == true) goto L29;
        return false;
    L29:
        return f(((GenericArrayType) r4).getGenericComponentType(), ((GenericArrayType) r5).getGenericComponentType());
    L31:
        if ((r4 instanceof WildcardType) == false) goto L43;
        if ((r5 instanceof WildcardType) == true) goto L35;
        return false;
    L35:
        WildcardType r8 = (WildcardType) r4;
        WildcardType r9 = (WildcardType) r5;
        if (Arrays.equals(r8.getUpperBounds(), r9.getUpperBounds()) == false) goto L41;
        if (Arrays.equals(r8.getLowerBounds(), r9.getLowerBounds()) == false) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r4 instanceof TypeVariable) == true) goto L45;
        return false;
    L45:
        if ((r5 instanceof TypeVariable) == true) goto L47;
        return false;
    L47:
        TypeVariable r10 = (TypeVariable) r4;
        TypeVariable r11 = (TypeVariable) r5;
        if (r10.getGenericDeclaration() != r11.getGenericDeclaration()) goto L53;
        if (r10.getName().equals(r11.getName()) == false) goto L53;
        return true;
    L53:
        return false;
    }

    public static Type g(Type r1) {
        if ((r1 instanceof GenericArrayType) == false) goto L6;
        return ((GenericArrayType) r1).getGenericComponentType();
    L6:
        return ((Class) r1).getComponentType();
    }

    public static Type h(Type r1, Class<?> r2) {
        Type r3 = l(r1, r2, Collection.class);
        if ((r3 instanceof ParameterizedType) == true) goto L5;
        return Object.class;
    L5:
        return ((ParameterizedType) r3).getActualTypeArguments()[0];
    }

    private static Type i(Type r3, Class<?> r4, Class<?> r5) {
        if (r5 != r4) goto L5;
        return r3;
    L5:
        if (r5.isInterface() == false) goto L18;
        Class<?>[] r6 = r4.getInterfaces();
        int r0 = 0;
        int r1 = r6.length;
    L7:
        if (r0 >= r1) goto L18;
        if (r6[r0] == r5) goto L11;
        if (r5.isAssignableFrom(r6[r0]) == true) goto L15;
        r0 = r0 + 1;
        goto L7
    L15:
        return i(r4.getGenericInterfaces()[r0], r6[r0], r5);
    L11:
        return r4.getGenericInterfaces()[r0];
    L18:
        if (r4.isInterface() == false) goto L20;
    L30:
        return r5;
    L20:
        if (r4 == Object.class) goto L30;
        Class<? super Object> r7 = r4.getSuperclass();
        if (r7 == r5) goto L24;
        if (r5.isAssignableFrom(r7) == true) goto L28;
        r4 = r7;
        goto L20
    L28:
        return i(r4.getGenericSuperclass(), r7, r5);
    L24:
        return r4.getGenericSuperclass();
    }

    public static Type[] j(Type r6, Class<?> r7) {
        if (r6 == Properties.class) goto L5;
        Type r8 = l(r6, r7, Map.class);
        if ((r8 instanceof ParameterizedType) == false) goto L11;
        return ((ParameterizedType) r8).getActualTypeArguments();
    L11:
        return new Type[]{Object.class, Object.class};
    L5:
        return new Type[]{String.class, String.class};
    }

    public static Class<?> k(Type r4) {
        if ((r4 instanceof Class) == false) goto L7;
        return (Class) r4;
    L7:
        if ((r4 instanceof ParameterizedType) == false) goto L11;
        Type r5 = ((ParameterizedType) r4).getRawType();
        com.google.gson.internal.a.a(r5 instanceof Class);
        return (Class) r5;
    L11:
        if ((r4 instanceof GenericArrayType) == false) goto L15;
        return Array.newInstance(k(((GenericArrayType) r4).getGenericComponentType()), 0).getClass();
    L15:
        if ((r4 instanceof TypeVariable) == false) goto L19;
        return Object.class;
    L19:
        if ((r4 instanceof WildcardType) == true) goto L21;
        if (r4 != null) goto L24;
        String r0 = "null";
    L26:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r4 + "> is of type " + r0);
    L24:
        r0 = r4.getClass().getName();
        goto L26
    L21:
        return k(((WildcardType) r4).getUpperBounds()[0]);
    }

    private static Type l(Type r1, Class<?> r2, Class<?> r3) {
        if ((r1 instanceof WildcardType) == false) goto L5;
        r1 = ((WildcardType) r1).getUpperBounds()[0];
    L5:
        com.google.gson.internal.a.a(r3.isAssignableFrom(r2));
        return o(r1, r2, i(r1, r2, r3));
    }

    private static int m(Object[] r3, Object r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r4.equals(r3[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L9:
        throw new NoSuchElementException();
    }

    public static ParameterizedType n(Type r1, Type r2, Type... r3) {
        return new C0210b(r1, r2, r3);
    }

    public static Type o(Type r1, Class<?> r2, Type r3) {
        return p(r1, r2, r3, new HashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Map, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type>] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    private static Type p(Type r9, Class<?> r10, Type r11, Map<TypeVariable<?>, Type> r12) {
        TypeVariable r0 = null;
    L4:
        if ((r11 instanceof TypeVariable) == false) goto L19;
        TypeVariable r1 = (TypeVariable) r11;
        Type r2 = (Type) r12.get(r1);
        if (r2 != null) goto L8;
        r12.put(r1, Void.TYPE);
        if (r0 != null) goto L15;
        r0 = r1;
    L15:
        r11 = q(r9, r10, r1);
        if (r11 != r1) goto L4;
    L56:
        if (r0 == null) goto L58;
        r12.put(r0, r11);
    L58:
        return r11;
    L8:
        if (r2 != Void.TYPE) goto L11;
        return r11;
    L11:
        return r2;
    L19:
        if ((r11 instanceof Class) == false) goto L28;
        Class r3 = (Class) r11;
        if (r3.isArray() == false) goto L28;
        Class<?> r13 = r3.getComponentType();
        Type r14 = p(r9, r10, r13, r12);
        if (e(r13, r14) == false) goto L25;
        r11 = r3;
    L25:
        Type r15 = a(r14);
    L26:
        r11 = r15;
    L28:
        if ((r11 instanceof GenericArrayType) == false) goto L32;
        r11 = (GenericArrayType) r11;
        Type r4 = r11.getGenericComponentType();
        r14 = p(r9, r10, r4, r12);
        if (e(r4, r14) == false) goto L25;
    L32:
        int r5 = 0;
        if ((r11 instanceof ParameterizedType) == false) goto L45;
        r11 = (ParameterizedType) r11;
        Type r6 = r11.getOwnerType();
        Type r7 = p(r9, r10, r6, r12);
        boolean r8 = !e(r7, r6);
        Type[] r16 = r11.getActualTypeArguments();
        int r17 = r16.length;
    L35:
        if (r5 >= r17) goto L42;
        Type r18 = p(r9, r10, r16[r5], r12);
        if (e(r18, r16[r5]) == true) goto L41;
        if (r8 == true) goto L40;
        r16 = (Type[]) r16.clone();
        r8 = true;
    L40:
        r16[r5] = r18;
    L41:
        r5 = r5 + 1;
        goto L35
    L42:
        if (r8 == false) goto L56;
        r15 = n(r7, r11.getRawType(), r16);
        goto L26
    L45:
        if ((r11 instanceof WildcardType) == false) goto L56;
        r11 = (WildcardType) r11;
        Type[] r19 = r11.getLowerBounds();
        Type[] r20 = r11.getUpperBounds();
        if (r19.length != 1) goto L52;
        Type r21 = p(r9, r10, r19[0], r12);
        if (r21 == r19[0]) goto L56;
        r11 = s(r21);
        goto L56
    L52:
        if (r20.length != 1) goto L56;
        Type r22 = p(r9, r10, r20[0], r12);
        if (r22 == r20[0]) goto L56;
        r11 = r(r22);
        goto L56
    }

    private static Type q(Type r1, Class<?> r2, TypeVariable<?> r3) {
        Class<?> r0 = d(r3);
        if (r0 != null) goto L5;
        return r3;
    L5:
        Type r4 = i(r1, r2, r0);
        if ((r4 instanceof ParameterizedType) == false) goto L9;
        int r5 = m(r0.getTypeParameters(), r3);
        return ((ParameterizedType) r4).getActualTypeArguments()[r5];
    L9:
        return r3;
    }

    public static WildcardType r(Type r2) {
        if ((r2 instanceof WildcardType) == false) goto L5;
        Type[] r3 = ((WildcardType) r2).getUpperBounds();
    L7:
        return new c(r3, f6917a);
    L5:
        r3 = new Type[]{r2};
        goto L7
    }

    public static WildcardType s(Type r4) {
        if ((r4 instanceof WildcardType) == false) goto L5;
        Type[] r5 = ((WildcardType) r4).getLowerBounds();
    L7:
        return new c(new Type[]{Object.class}, r5);
    L5:
        r5 = new Type[]{r4};
        goto L7
    }

    public static String t(Type r1) {
        if ((r1 instanceof Class) == false) goto L6;
        return ((Class) r1).getName();
    L6:
        return r1.toString();
    }
}
