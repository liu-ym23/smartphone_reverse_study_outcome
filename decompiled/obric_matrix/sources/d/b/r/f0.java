package d.b.r;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f14352a = null;

    class a implements d.b.r.k0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p000j.e0 f14353a;

        a(p000j.e0 r1) {
            this.f14353a = r1;
        }

        @Override // d.b.r.k0.j
        public String a() {
            if (this.f14353a.b() != null) goto L5;
            return "";
        L5:
            return this.f14353a.b().toString();
        }

        @Override // d.b.r.k0.j
        public void b(OutputStream r1) {
            k.f r2 = k.q.a(k.q.f(r1));
            this.f14353a.f(r2);
            r2.flush();
            r2.close();
        }

        @Override // d.b.r.k0.j
        public String c() {
            return null;
        }

        @Override // d.b.r.k0.j
        public String e() {
            return null;
        }

        @Override // d.b.r.k0.j
        public long length() {
            return this.f14353a.a();
        L4:
            return -1;
        }
    }

    private static final class b implements GenericArrayType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f14354f;

        public b(Type r1) {
            this.f14354f = r1;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (f0.e(this, (GenericArrayType) r2) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f14354f;
        }

        public int hashCode() {
            return this.f14354f.hashCode();
        }

        public String toString() {
            return f0.x(this.f14354f) + "[]";
        }
    }

    static final class c implements ParameterizedType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f14355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Type f14356g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Type[] f14357h;

        c(Type r5, Type r6, Type... r7) {
            int r1 = 0;
            if ((r6 instanceof Class) == false) goto L16;
            boolean r0 = true;
            if (r5 != null) goto L7;
            boolean r2 = true;
        L9:
            if (((Class) r6).getEnclosingClass() == null) goto L12;
            r0 = false;
        L12:
            if (r2 == r0) goto L16;
            throw new IllegalArgumentException();
        L7:
            r2 = false;
        L16:
            this.f14355f = r5;
            this.f14356g = r6;
            this.f14357h = (Type[]) r7.clone();
            int r4 = r7.length;
        L17:
            if (r1 >= r4) goto L19;
            Type r8 = r7[r1];
            f0.a(r8, "typeArgument == null");
            f0.b(r8);
            r1 = r1 + 1;
            goto L17
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (f0.e(this, (ParameterizedType) r2) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f14357h.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f14355f;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f14356g;
        }

        public int hashCode() {
            int r0 = Arrays.hashCode(this.f14357h) ^ this.f14356g.hashCode();
            Type r2 = this.f14355f;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r3 ^ r0;
        L5:
            r3 = 0;
            goto L7
        }

        public String toString() {
            int r2 = 1;
            StringBuilder r0 = new StringBuilder((this.f14357h.length + 1) * 30);
            r0.append(f0.x(this.f14356g));
            if (this.f14357h.length == 0) goto L5;
            r0.append("<");
            r0.append(f0.x(this.f14357h[0]));
        L8:
            if (r2 >= this.f14357h.length) goto L10;
            r0.append(", ");
            r0.append(f0.x(this.f14357h[r2]));
            r2 = r2 + 1;
            goto L8
        L10:
            r0.append(">");
            return r0.toString();
        L5:
            return r0.toString();
        }
    }

    private static final class d implements WildcardType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f14358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Type f14359g;

        d(Type[] r5, Type[] r6) {
            if (r6.length > 1) goto L18;
            if (r5.length != 1) goto L16;
            if (r6.length != 1) goto L13;
            Objects.requireNonNull(r6[0]);
            f0.b(r6[0]);
            if (r5[0] != Object.class) goto L12;
            this.f14359g = r6[0];
            this.f14358f = Object.class;
            return;
        L12:
            throw new IllegalArgumentException();
        L13:
            Objects.requireNonNull(r5[0]);
            f0.b(r5[0]);
            this.f14359g = null;
            this.f14358f = r5[0];
            return;
        L16:
            throw new IllegalArgumentException();
        L18:
            throw new IllegalArgumentException();
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (f0.e(this, (WildcardType) r2) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r2 = this.f14359g;
            if (r2 == null) goto L6;
            return new Type[]{r2};
        L6:
            return f0.f14352a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f14358f};
        }

        public int hashCode() {
            Type r0 = this.f14359g;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode() + 31;
        L7:
            return (this.f14358f.hashCode() + 31) ^ r1;
        L5:
            r1 = 1;
            goto L7
        }

        public String toString() {
            if (this.f14359g == null) goto L8;
            StringBuilder r0 = new StringBuilder();
            r0.append("? super ");
            Type r2 = this.f14359g;
        L5:
            r0.append(f0.x(r2));
            return r0.toString();
        L8:
            if (this.f14358f != Object.class) goto L11;
            return "?";
        L11:
            r0 = new StringBuilder();
            r0.append("? extends ");
            r2 = this.f14358f;
            goto L5
        }
    }

    static {
        f14352a = new Type[0];
    }

    static <T> T a(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    static void b(Type r1) {
        if ((r1 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r1).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static d.b.r.k0.j c(p000j.e0 r1) {
        return new a(r1);
    }

    private static Class<?> d(TypeVariable<?> r1) {
        GenericDeclaration r2 = r1.getGenericDeclaration();
        if ((r2 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r2;
    }

    static boolean e(Type r4, Type r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if ((r4 instanceof Class) == false) goto L10;
        return r4.equals(r5);
    L10:
        if ((r4 instanceof ParameterizedType) == false) goto L27;
        if ((r5 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r6 = (ParameterizedType) r4;
        ParameterizedType r7 = (ParameterizedType) r5;
        Type r1 = r6.getOwnerType();
        Type r3 = r7.getOwnerType();
        if (r1 == r3) goto L20;
        if (r1 == null) goto L25;
        if (r1.equals(r3) == true) goto L20;
    L25:
        return false;
    L20:
        if (r6.getRawType().equals(r7.getRawType()) == false) goto L25;
        if (Arrays.equals(r6.getActualTypeArguments(), r7.getActualTypeArguments()) == false) goto L25;
        return true;
    L27:
        if ((r4 instanceof GenericArrayType) == false) goto L34;
        if ((r5 instanceof GenericArrayType) == true) goto L32;
        return false;
    L32:
        return e(((GenericArrayType) r4).getGenericComponentType(), ((GenericArrayType) r5).getGenericComponentType());
    L34:
        if ((r4 instanceof WildcardType) == false) goto L46;
        if ((r5 instanceof WildcardType) == true) goto L38;
        return false;
    L38:
        WildcardType r8 = (WildcardType) r4;
        WildcardType r9 = (WildcardType) r5;
        if (Arrays.equals(r8.getUpperBounds(), r9.getUpperBounds()) == false) goto L44;
        if (Arrays.equals(r8.getLowerBounds(), r9.getLowerBounds()) == false) goto L44;
        return true;
    L44:
        return false;
    L46:
        if ((r4 instanceof TypeVariable) == true) goto L48;
        return false;
    L48:
        if ((r5 instanceof TypeVariable) == true) goto L50;
        return false;
    L50:
        TypeVariable r10 = (TypeVariable) r4;
        TypeVariable r11 = (TypeVariable) r5;
        if (r10.getGenericDeclaration() != r11.getGenericDeclaration()) goto L56;
        if (r10.getName().equals(r11.getName()) == false) goto L56;
        return true;
    L56:
        return false;
    }

    static Type f(Type r1) {
        if ((r1 instanceof ParameterizedType) == false) goto L7;
        return i(0, (ParameterizedType) r1);
    L7:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    static Type g(Type r3, Class<?> r4, Class<?> r5) {
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
        return g(r4.getGenericInterfaces()[r0], r6[r0], r5);
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
        return g(r4.getGenericSuperclass(), r7, r5);
    L24:
        return r4.getGenericSuperclass();
    }

    static Type h(int r0, ParameterizedType r1) {
        Type r2 = r1.getActualTypeArguments()[r0];
        if ((r2 instanceof WildcardType) == true) goto L5;
        return r2;
    L5:
        return ((WildcardType) r2).getLowerBounds()[0];
    }

    static Type i(int r4, ParameterizedType r5) {
        Type[] r0 = r5.getActualTypeArguments();
        if (r4 < 0) goto L11;
        if (r4 >= r0.length) goto L11;
        Type r6 = r0[r4];
        if ((r6 instanceof WildcardType) == true) goto L9;
        return r6;
    L9:
        return ((WildcardType) r6).getUpperBounds()[0];
    L11:
        throw new IllegalArgumentException("Index " + r4 + " not in range [0," + r0.length + ") for " + r5);
    }

    static Class<?> j(Type r3) {
        a(r3, "type == null");
        if ((r3 instanceof Class) == false) goto L7;
        return (Class) r3;
    L7:
        if ((r3 instanceof ParameterizedType) == false) goto L15;
        Type r4 = ((ParameterizedType) r3).getRawType();
        if ((r4 instanceof Class) == false) goto L13;
        return (Class) r4;
    L13:
        throw new IllegalArgumentException();
    L15:
        if ((r3 instanceof GenericArrayType) == false) goto L19;
        return Array.newInstance(j(((GenericArrayType) r3).getGenericComponentType()), 0).getClass();
    L19:
        if ((r3 instanceof TypeVariable) == false) goto L23;
        return Object.class;
    L23:
        if ((r3 instanceof WildcardType) == false) goto L27;
        return j(((WildcardType) r3).getUpperBounds()[0]);
    L27:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r3 + "> is of type " + r3.getClass().getName());
    }

    static Type k(Type r1, Class<?> r2, Class<?> r3) {
        if (r3.isAssignableFrom(r2) == false) goto L7;
        return u(r1, r2, g(r1, r2, r3));
    L7:
        throw new IllegalArgumentException();
    }

    static boolean l(Type r5) {
        if ((r5 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r5 instanceof ParameterizedType) == false) goto L15;
        Type[] r6 = ((ParameterizedType) r5).getActualTypeArguments();
        int r0 = r6.length;
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L13;
        if (l(r6[r3]) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r5 instanceof GenericArrayType) == false) goto L19;
        return l(((GenericArrayType) r5).getGenericComponentType());
    L19:
        if ((r5 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r5 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r5 != null) goto L26;
        String r1 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r1);
    L26:
        r1 = r5.getClass().getName();
        goto L28
    }

    private static int m(Object[] r2, Object r3) {
        int r0 = 0;
    L4:
        if (r0 >= r2.length) goto L10;
        if (r3.equals(r2[r0]) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L10:
        throw new NoSuchElementException();
    }

    static boolean n(Annotation[] r4, Class<? extends Annotation> r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r5.isInstance(r4[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    static RuntimeException o(Method r1, String r2, Object... r3) {
        return p(r1, null, r2, r3);
    }

    static RuntimeException p(Method r1, Throwable r2, String r3, Object... r4) {
        return new IllegalArgumentException(String.format(r3, r4) + "\n    for method " + r1.getDeclaringClass().getSimpleName() + "." + r1.getName(), r2);
    }

    static RuntimeException q(Method r1, int r2, String r3, Object... r4) {
        return o(r1, r3 + " (parameter #" + (r2 + 1) + ")", r4);
    }

    static RuntimeException r(Method r1, Throwable r2, int r3, String r4, Object... r5) {
        return p(r1, r2, r4 + " (parameter #" + (r3 + 1) + ")", r5);
    }

    public static boolean s(String r1) {
        if (t(r1) == false) goto L5;
    L16:
        return true;
    L5:
        if (r1.equals("OPTIONS") == true) goto L16;
        if (r1.equals("DELETE") == true) goto L16;
        if (r1.equals("PROPFIND") == true) goto L16;
        if (r1.equals("MKCOL") == true) goto L16;
        if (r1.equals("LOCK") == true) goto L16;
        return false;
    }

    public static boolean t(String r1) {
        if (r1.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals("PUT") == true) goto L14;
        if (r1.equals("PATCH") == true) goto L14;
        if (r1.equals("PROPPATCH") == true) goto L14;
        if (r1.equals("REPORT") == true) goto L14;
        return false;
    }

    static Type u(Type r8, Class<?> r9, Type r10) {
    L3:
        if ((r10 instanceof TypeVariable) == false) goto L9;
        TypeVariable r11 = (TypeVariable) r10;
        Type r0 = v(r8, r9, r11);
        if (r0 == r11) goto L6;
        Type r12 = r0;
        goto L3
    L6:
        return r0;
    L9:
        if ((r12 instanceof Class) == false) goto L18;
        Class r1 = (Class) r12;
        if (r1.isArray() == false) goto L18;
        Class<?> r13 = r1.getComponentType();
        Type r14 = u(r8, r9, r13);
        if (r13 != r14) goto L16;
        return r1;
    L16:
        return new b(r14);
    L18:
        if ((r12 instanceof GenericArrayType) == false) goto L24;
        GenericArrayType r15 = (GenericArrayType) r12;
        Type r2 = r15.getGenericComponentType();
        Type r16 = u(r8, r9, r2);
        if (r2 != r16) goto L23;
        return r15;
    L23:
        return new b(r16);
    L24:
        int r3 = 0;
        if ((r12 instanceof ParameterizedType) == false) goto L41;
        ParameterizedType r17 = (ParameterizedType) r12;
        Type r4 = r17.getOwnerType();
        Type r5 = u(r8, r9, r4);
        if (r5 == r4) goto L29;
        boolean r6 = true;
    L30:
        Type[] r7 = r17.getActualTypeArguments();
        int r18 = r7.length;
    L31:
        if (r3 >= r18) goto L38;
        Type r19 = u(r8, r9, r7[r3]);
        if (r19 == r7[r3]) goto L37;
        if (r6 == true) goto L36;
        r7 = (Type[]) r7.clone();
        r6 = true;
    L36:
        r7[r3] = r19;
    L37:
        r3 = r3 + 1;
        goto L31
    L38:
        if (r6 == true) goto L40;
        return r17;
    L40:
        return new c(r5, r17.getRawType(), r7);
    L29:
        r6 = false;
        goto L30
    L41:
        boolean r20 = r12 instanceof WildcardType;
        Type r110 = r12;
        if (r20 == false) goto L55;
        WildcardType r111 = (WildcardType) r12;
        Type[] r21 = r111.getLowerBounds();
        Type[] r22 = r111.getUpperBounds();
        if (r21.length != 1) goto L49;
        Type r23 = u(r8, r9, r21[0]);
        r110 = r111;
        if (r23 == r21[0]) goto L55;
        return new d(new Type[]{Object.class}, new Type[]{r23});
    L49:
        r110 = r111;
        if (r22.length != 1) goto L55;
        Type r24 = u(r8, r9, r22[0]);
        r110 = r111;
        if (r24 == r22[0]) goto L55;
        return new d(new Type[]{r24}, f14352a);
    L55:
        return r110;
    }

    private static Type v(Type r1, Class<?> r2, TypeVariable<?> r3) {
        Class<?> r0 = d(r3);
        if (r0 != null) goto L5;
        return r3;
    L5:
        Type r4 = g(r1, r2, r0);
        if ((r4 instanceof ParameterizedType) == false) goto L9;
        int r5 = m(r0.getTypeParameters(), r3);
        return ((ParameterizedType) r4).getActualTypeArguments()[r5];
    L9:
        return r3;
    }

    static byte[] w(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        if (r4 == null) goto L9;
        byte[] r1 = new byte[4096];
    L5:
        int r2 = r4.read(r1);
        if (r2 == (-1)) goto L9;
        r0.write(r1, 0, r2);
    L9:
        return r0.toByteArray();
    }

    static String x(Type r1) {
        if ((r1 instanceof Class) == false) goto L6;
        return ((Class) r1).getName();
    L6:
        return r1.toString();
    }

    static <T> void y(Class<T> r1) {
        if (r1.isInterface() == false) goto L10;
        if (r1.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }
}
