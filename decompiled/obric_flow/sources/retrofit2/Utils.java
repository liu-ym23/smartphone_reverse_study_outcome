package retrofit2;

import ai.j0;
import java.io.IOException;
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
import nu.j;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
final class Utils {
    static final Type[] EMPTY_TYPE_ARRAY = null;

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public GenericArrayTypeImpl(Type r5) {
            this.componentType = r5;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (GenericArrayType) r5) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return j0.q(new StringBuilder(), Utils.typeToString(this.componentType), "[]");
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type r5, Type r10, Type... r11) {
            int r12 = 0;
            if ((r10 instanceof Class) == false) goto L16;
            boolean r13 = true;
            if (r5 != null) goto L7;
            boolean r14 = true;
        L9:
            if (((Class) r10).getEnclosingClass() == null) goto L12;
            r13 = false;
        L12:
            if (r14 == r13) goto L16;
            throw new IllegalArgumentException();
        L7:
            r14 = false;
        L16:
            int r15 = r11.length;
        L17:
            if (r12 >= r15) goto L19;
            Type r16 = r11[r12];
            Objects.requireNonNull(r16, "typeArgument == null");
            Utils.checkNotPrimitive(r16);
            r12 = r12 + 1;
            goto L17
        L19:
            this.ownerType = r5;
            this.rawType = r10;
            this.typeArguments = (Type[]) r11.clone();
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (ParameterizedType) r5) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            int r5 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            Type r10 = this.ownerType;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode();
        L7:
            return r11 ^ r5;
        L5:
            r11 = 0;
            goto L7
        }

        public String toString() {
            Type[] r5 = this.typeArguments;
            if (r5.length == 0) goto L5;
            int r10 = 1;
            StringBuilder r11 = new StringBuilder((r5.length + 1) * 30);
            r11.append(Utils.typeToString(this.rawType));
            r11.append("<");
            r11.append(Utils.typeToString(this.typeArguments[0]));
        L8:
            if (r10 >= this.typeArguments.length) goto L10;
            r11.append(", ");
            r11.append(Utils.typeToString(this.typeArguments[r10]));
            r10 = r10 + 1;
            goto L8
        L10:
            r11.append(">");
            return r11.toString();
        L5:
            return Utils.typeToString(this.rawType);
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] r5, Type[] r10) {
            if (r10.length > 1) goto L18;
            if (r5.length != 1) goto L16;
            if (r10.length != 1) goto L13;
            r10[0].getClass();
            Utils.checkNotPrimitive(r10[0]);
            if (r5[0] != Object.class) goto L12;
            this.lowerBound = r10[0];
            this.upperBound = Object.class;
            return;
        L12:
            throw new IllegalArgumentException();
        L13:
            r5[0].getClass();
            Utils.checkNotPrimitive(r5[0]);
            this.lowerBound = null;
            this.upperBound = r5[0];
            return;
        L16:
            throw new IllegalArgumentException();
        L18:
            throw new IllegalArgumentException();
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (WildcardType) r5) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r5 = this.lowerBound;
            if (r5 == null) goto L6;
            return new Type[]{r5};
        L6:
            return Utils.EMPTY_TYPE_ARRAY;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type r5 = this.lowerBound;
            if (r5 == null) goto L5;
            int r10 = r5.hashCode() + 31;
        L7:
            return (this.upperBound.hashCode() + 31) ^ r10;
        L5:
            r10 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L7;
            return "? super " + Utils.typeToString(this.lowerBound);
        L7:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + Utils.typeToString(this.upperBound);
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private Utils() {
    }

    public static w0 buffer(w0 r5) throws IOException {
        j r10 = new j();
        r5.source().z(r10);
        return w0.create(r5.contentType(), r5.contentLength(), r10);
    }

    public static void checkNotPrimitive(Type r5) {
        if ((r5 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r5).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    private static Class<?> declaringClassOf(TypeVariable<?> r5) {
        GenericDeclaration r10 = r5.getGenericDeclaration();
        if ((r10 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r10;
    }

    public static boolean equals(Type r5, Type r10) {
        if (r5 != r10) goto L6;
        return true;
    L6:
        if ((r5 instanceof Class) == false) goto L10;
        return r5.equals(r10);
    L10:
        if ((r5 instanceof ParameterizedType) == false) goto L27;
        if ((r10 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r11 = (ParameterizedType) r5;
        ParameterizedType r12 = (ParameterizedType) r10;
        Type r13 = r11.getOwnerType();
        Type r14 = r12.getOwnerType();
        if (r13 == r14) goto L20;
        if (r13 == null) goto L25;
        if (r13.equals(r14) == true) goto L20;
    L25:
        return false;
    L20:
        if (r11.getRawType().equals(r12.getRawType()) == false) goto L25;
        if (Arrays.equals(r11.getActualTypeArguments(), r12.getActualTypeArguments()) == false) goto L25;
        return true;
    L27:
        if ((r5 instanceof GenericArrayType) == false) goto L34;
        if ((r10 instanceof GenericArrayType) == true) goto L32;
        return false;
    L32:
        return equals(((GenericArrayType) r5).getGenericComponentType(), ((GenericArrayType) r10).getGenericComponentType());
    L34:
        if ((r5 instanceof WildcardType) == false) goto L46;
        if ((r10 instanceof WildcardType) == true) goto L38;
        return false;
    L38:
        WildcardType r15 = (WildcardType) r5;
        WildcardType r16 = (WildcardType) r10;
        if (Arrays.equals(r15.getUpperBounds(), r16.getUpperBounds()) == false) goto L44;
        if (Arrays.equals(r15.getLowerBounds(), r16.getLowerBounds()) == false) goto L44;
        return true;
    L44:
        return false;
    L46:
        if ((r5 instanceof TypeVariable) == true) goto L48;
        return false;
    L48:
        if ((r10 instanceof TypeVariable) == true) goto L50;
        return false;
    L50:
        TypeVariable r17 = (TypeVariable) r5;
        TypeVariable r18 = (TypeVariable) r10;
        if (r17.getGenericDeclaration() != r18.getGenericDeclaration()) goto L56;
        if (r17.getName().equals(r18.getName()) == false) goto L56;
        return true;
    L56:
        return false;
    }

    public static Type getGenericSupertype(Type r5, Class<?> r10, Class<?> r11) {
        if (r11 != r10) goto L5;
        return r5;
    L5:
        if (r11.isInterface() == false) goto L18;
        Class<?>[] r12 = r10.getInterfaces();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L18;
        Class<?> r15 = r12[r14];
        if (r15 == r11) goto L11;
        if (r11.isAssignableFrom(r15) == true) goto L15;
        r14 = r14 + 1;
        goto L7
    L15:
        return getGenericSupertype(r10.getGenericInterfaces()[r14], r12[r14], r11);
    L11:
        return r10.getGenericInterfaces()[r14];
    L18:
        if (r10.isInterface() == false) goto L20;
    L30:
        return r11;
    L20:
        if (r10 == Object.class) goto L30;
        Class<? super Object> r16 = r10.getSuperclass();
        if (r16 == r11) goto L24;
        if (r11.isAssignableFrom(r16) == true) goto L28;
        r10 = r16;
        goto L20
    L28:
        return getGenericSupertype(r10.getGenericSuperclass(), r16, r11);
    L24:
        return r10.getGenericSuperclass();
    }

    public static Type getParameterLowerBound(int r5, ParameterizedType r10) {
        Type r11 = r10.getActualTypeArguments()[r5];
        if ((r11 instanceof WildcardType) == true) goto L5;
        return r11;
    L5:
        return ((WildcardType) r11).getLowerBounds()[0];
    }

    public static Type getParameterUpperBound(int r5, ParameterizedType r10) {
        Type[] r11 = r10.getActualTypeArguments();
        if (r5 >= 0) goto L5;
    L10:
        StringBuilder r12 = j0.s(r5, "Index ", " not in range [0,");
        r12.append(r11.length);
        r12.append(") for ");
        r12.append(r10);
        throw new IllegalArgumentException(r12.toString());
    L5:
        if (r5 >= r11.length) goto L10;
        Type r13 = r11[r5];
        if ((r13 instanceof WildcardType) == true) goto L9;
        return r13;
    L9:
        return ((WildcardType) r13).getUpperBounds()[0];
    }

    public static Class<?> getRawType(Type r5) {
        Objects.requireNonNull(r5, "type == null");
        if ((r5 instanceof Class) == false) goto L7;
        return (Class) r5;
    L7:
        if ((r5 instanceof ParameterizedType) == false) goto L15;
        Type r10 = ((ParameterizedType) r5).getRawType();
        if ((r10 instanceof Class) == false) goto L13;
        return (Class) r10;
    L13:
        throw new IllegalArgumentException();
    L15:
        if ((r5 instanceof GenericArrayType) == false) goto L19;
        return Array.newInstance(getRawType(((GenericArrayType) r5).getGenericComponentType()), 0).getClass();
    L19:
        if ((r5 instanceof TypeVariable) == false) goto L23;
        return Object.class;
    L23:
        if ((r5 instanceof WildcardType) == false) goto L27;
        return getRawType(((WildcardType) r5).getUpperBounds()[0]);
    L27:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r5.getClass().getName());
    }

    public static Type getSupertype(Type r5, Class<?> r10, Class<?> r11) {
        if (r11.isAssignableFrom(r10) == false) goto L7;
        return resolve(r5, r10, getGenericSupertype(r5, r10, r11));
    L7:
        throw new IllegalArgumentException();
    }

    public static boolean hasUnresolvableType(Type r5) {
        if ((r5 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r5 instanceof ParameterizedType) == false) goto L15;
        Type[] r10 = ((ParameterizedType) r5).getActualTypeArguments();
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L13;
        if (hasUnresolvableType(r10[r12]) == true) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r5 instanceof GenericArrayType) == false) goto L19;
        return hasUnresolvableType(((GenericArrayType) r5).getGenericComponentType());
    L19:
        if ((r5 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r5 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r5 != null) goto L26;
        String r13 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r13);
    L26:
        r13 = r5.getClass().getName();
        goto L28
    }

    private static int indexOf(Object[] r5, Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L10;
        if (r10.equals(r5[r11]) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L10:
        throw new NoSuchElementException();
    }

    public static boolean isAnnotationPresent(Annotation[] r5, Class<? extends Annotation> r10) {
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r10.isInstance(r5[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static RuntimeException methodError(Method r5, String r10, Object... r11) {
        return methodError(r5, null, r10, r11);
    }

    public static RuntimeException parameterError(Method r5, Throwable r10, int r11, String r12, Object... r13) {
        StringBuilder r14 = j0.w(r12, " (parameter #");
        r14.append(r11 + 1);
        r14.append(")");
        return methodError(r5, r10, r14.toString(), r13);
    }

    public static Type resolve(Type r10, Class<?> r11, Type r12) {
        int r5 = 0;
        Type r13 = r12;
    L4:
        if ((r13 instanceof TypeVariable) == false) goto L10;
        TypeVariable r14 = (TypeVariable) r13;
        Type r15 = resolveTypeVariable(r10, r11, r14);
        if (r15 == r14) goto L7;
        r13 = r15;
        goto L4
    L7:
        return r15;
    L10:
        if ((r13 instanceof Class) == false) goto L19;
        Class r16 = (Class) r13;
        if (r16.isArray() == false) goto L19;
        Class<?> r17 = r16.getComponentType();
        Type r18 = resolve(r10, r11, r17);
        if (r17 != r18) goto L17;
        return r16;
    L17:
        return new GenericArrayTypeImpl(r18);
    L19:
        if ((r13 instanceof GenericArrayType) == false) goto L26;
        GenericArrayType r19 = (GenericArrayType) r13;
        Type r20 = r19.getGenericComponentType();
        Type r21 = resolve(r10, r11, r20);
        if (r20 != r21) goto L24;
        return r19;
    L24:
        return new GenericArrayTypeImpl(r21);
    L26:
        if ((r13 instanceof ParameterizedType) == false) goto L42;
        ParameterizedType r110 = (ParameterizedType) r13;
        Type r22 = r110.getOwnerType();
        Type r23 = resolve(r10, r11, r22);
        if (r23 == r22) goto L30;
        boolean r24 = true;
    L31:
        Type[] r25 = r110.getActualTypeArguments();
        int r26 = r25.length;
    L32:
        if (r5 >= r26) goto L39;
        Type r27 = resolve(r10, r11, r25[r5]);
        if (r27 == r25[r5]) goto L38;
        if (r24 == true) goto L37;
        r25 = (Type[]) r25.clone();
        r24 = true;
    L37:
        r25[r5] = r27;
    L38:
        r5 = r5 + 1;
        goto L32
    L39:
        if (r24 == true) goto L41;
        return r110;
    L41:
        return new ParameterizedTypeImpl(r23, r110.getRawType(), r25);
    L30:
        r24 = false;
        goto L31
    L42:
        boolean r28 = r13 instanceof WildcardType;
        Type r111 = r13;
        if (r28 == false) goto L56;
        WildcardType r112 = (WildcardType) r13;
        Type[] r29 = r112.getLowerBounds();
        Type[] r30 = r112.getUpperBounds();
        if (r29.length != 1) goto L50;
        Type r31 = resolve(r10, r11, r29[0]);
        r111 = r112;
        if (r31 == r29[0]) goto L56;
        return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{r31});
    L50:
        r111 = r112;
        if (r30.length != 1) goto L56;
        Type r32 = resolve(r10, r11, r30[0]);
        r111 = r112;
        if (r32 == r30[0]) goto L56;
        return new WildcardTypeImpl(new Type[]{r32}, EMPTY_TYPE_ARRAY);
    L56:
        return r111;
    }

    private static Type resolveTypeVariable(Type r5, Class<?> r10, TypeVariable<?> r11) {
        Class<?> r12 = declaringClassOf(r11);
        if (r12 != null) goto L5;
        return r11;
    L5:
        Type r13 = getGenericSupertype(r5, r10, r12);
        if ((r13 instanceof ParameterizedType) == false) goto L9;
        int r14 = indexOf(r12.getTypeParameters(), r11);
        return ((ParameterizedType) r13).getActualTypeArguments()[r14];
    L9:
        return r11;
    }

    public static void throwIfFatal(Throwable r5) {
        if ((r5 instanceof VirtualMachineError) == true) goto L14;
        if ((r5 instanceof ThreadDeath) == true) goto L12;
        if ((r5 instanceof LinkageError) == true) goto L10;
        return;
    L10:
        throw ((LinkageError) r5);
    L12:
        throw ((ThreadDeath) r5);
    L14:
        throw ((VirtualMachineError) r5);
    }

    public static String typeToString(Type r5) {
        if ((r5 instanceof Class) == false) goto L6;
        return ((Class) r5).getName();
    L6:
        return r5.toString();
    }

    public static RuntimeException methodError(Method r5, Throwable r10, String r11, Object... r12) {
        StringBuilder r13 = j0.w(String.format(r11, r12), "\n    for method ");
        r13.append(r5.getDeclaringClass().getSimpleName());
        r13.append(".");
        r13.append(r5.getName());
        return new IllegalArgumentException(r13.toString(), r10);
    }

    public static RuntimeException parameterError(Method r5, int r10, String r11, Object... r12) {
        StringBuilder r13 = j0.w(r11, " (parameter #");
        r13.append(r10 + 1);
        r13.append(")");
        return methodError(r5, r13.toString(), r12);
    }
}
