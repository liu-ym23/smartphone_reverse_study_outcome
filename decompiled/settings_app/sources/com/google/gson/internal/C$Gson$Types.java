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
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
public final class C$Gson$Types {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Type[] EMPTY_TYPE_ARRAY = null;

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type r1) {
            Objects.requireNonNull(r1);
            this.componentType = C$Gson$Types.canonicalize(r1);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (GenericArrayType) r2) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return C$Gson$Types.typeToString(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type r5, Type r6, Type... r7) {
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
            C$Gson$Preconditions.checkArgument(r3);
            goto L16
        L7:
            if (r0.getEnclosingClass() == null) goto L10;
            r2 = false;
        L16:
            if (r5 != null) goto L18;
            Type r8 = null;
        L19:
            this.ownerType = r8;
            this.rawType = C$Gson$Types.canonicalize(r6);
            Type[] r9 = (Type[]) r7.clone();
            this.typeArguments = r9;
            int r10 = r9.length;
        L20:
            if (r1 >= r10) goto L22;
            Objects.requireNonNull(this.typeArguments[r1]);
            C$Gson$Types.checkNotPrimitive(this.typeArguments[r1]);
            Type[] r11 = this.typeArguments;
            r11[r1] = C$Gson$Types.canonicalize(r11[r1]);
            r1 = r1 + 1;
            goto L20
        L22:
            return;
        L18:
            r8 = C$Gson$Types.canonicalize(r5);
            goto L19
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (ParameterizedType) r2) == false) goto L7;
            return true;
        }

        private static int hashCodeOrZero(Object r0) {
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public int hashCode() {
            int r0 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            return hashCodeOrZero(this.ownerType) ^ r0;
        }

        public String toString() {
            int r0 = this.typeArguments.length;
            if (r0 == 0) goto L5;
            StringBuilder r1 = new StringBuilder((r0 + 1) * 30);
            r1.append(C$Gson$Types.typeToString(this.rawType)).append("<").append(C$Gson$Types.typeToString(this.typeArguments[0]));
            int r2 = 1;
        L7:
            if (r2 >= r0) goto L10;
            r1.append(", ").append(C$Gson$Types.typeToString(this.typeArguments[r2]));
            r2 = r2 + 1;
            goto L7
        L10:
            return r1.append(">").toString();
        L5:
            return C$Gson$Types.typeToString(this.rawType);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    /* JADX INFO: compiled from: $Gson$Types.java */
    private static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] r4, Type[] r5) {
            boolean r2 = true;
            if (r5.length > 1) goto L5;
            boolean r0 = true;
        L6:
            C$Gson$Preconditions.checkArgument(r0);
            if (r4.length != 1) goto L9;
            boolean r1 = true;
        L10:
            C$Gson$Preconditions.checkArgument(r1);
            if (r5.length != 1) goto L17;
            Objects.requireNonNull(r5[0]);
            C$Gson$Types.checkNotPrimitive(r5[0]);
            if (r4[0] == Object.class) goto L16;
            r2 = false;
        L16:
            C$Gson$Preconditions.checkArgument(r2);
            this.lowerBound = C$Gson$Types.canonicalize(r5[0]);
            this.upperBound = Object.class;
            return;
        L17:
            Objects.requireNonNull(r4[0]);
            C$Gson$Types.checkNotPrimitive(r4[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.canonicalize(r4[0]);
            return;
        L9:
            r1 = false;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r2 = this.lowerBound;
            if (r2 == null) goto L6;
            return new Type[]{r2};
        L6:
            return C$Gson$Types.EMPTY_TYPE_ARRAY;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (WildcardType) r2) == false) goto L7;
            return true;
        }

        public int hashCode() {
            Type r0 = this.lowerBound;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode() + 31;
        L7:
            return (this.upperBound.hashCode() + 31) ^ r1;
        L5:
            r1 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L7;
            return "? super " + C$Gson$Types.typeToString(this.lowerBound);
        L7:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + C$Gson$Types.typeToString(this.upperBound);
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private C$Gson$Types() {
        throw new UnsupportedOperationException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type r1, Type r2, Type... r3) {
        return new ParameterizedTypeImpl(r1, r2, r3);
    }

    public static GenericArrayType arrayOf(Type r1) {
        return new GenericArrayTypeImpl(r1);
    }

    public static WildcardType subtypeOf(Type r2) {
        if ((r2 instanceof WildcardType) == false) goto L5;
        Type[] r3 = ((WildcardType) r2).getUpperBounds();
    L7:
        return new WildcardTypeImpl(r3, EMPTY_TYPE_ARRAY);
    L5:
        r3 = new Type[]{r2};
        goto L7
    }

    public static WildcardType supertypeOf(Type r4) {
        if ((r4 instanceof WildcardType) == false) goto L5;
        Type[] r5 = ((WildcardType) r4).getLowerBounds();
    L7:
        return new WildcardTypeImpl(new Type[]{Object.class}, r5);
    L5:
        r5 = new Type[]{r4};
        goto L7
    }

    public static Type canonicalize(Type r3) {
        if ((r3 instanceof Class) == false) goto L10;
        Class r4 = (Class) r3;
        boolean r0 = r4.isArray();
        Type r5 = r4;
        if (r0 == false) goto L8;
        r5 = new GenericArrayTypeImpl(canonicalize(r4.getComponentType()));
    L8:
        return r5;
    L10:
        if ((r3 instanceof ParameterizedType) == false) goto L14;
        ParameterizedType r6 = (ParameterizedType) r3;
        return new ParameterizedTypeImpl(r6.getOwnerType(), r6.getRawType(), r6.getActualTypeArguments());
    L14:
        if ((r3 instanceof GenericArrayType) == false) goto L18;
        return new GenericArrayTypeImpl(((GenericArrayType) r3).getGenericComponentType());
    L18:
        if ((r3 instanceof WildcardType) == false) goto L21;
        WildcardType r7 = (WildcardType) r3;
        return new WildcardTypeImpl(r7.getUpperBounds(), r7.getLowerBounds());
    L21:
        return r3;
    }

    public static Class<?> getRawType(Type r4) {
        if ((r4 instanceof Class) == false) goto L7;
        return (Class) r4;
    L7:
        if ((r4 instanceof ParameterizedType) == false) goto L11;
        Type r5 = ((ParameterizedType) r4).getRawType();
        C$Gson$Preconditions.checkArgument(r5 instanceof Class);
        return (Class) r5;
    L11:
        if ((r4 instanceof GenericArrayType) == false) goto L15;
        return Array.newInstance(getRawType(((GenericArrayType) r4).getGenericComponentType()), 0).getClass();
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
        return getRawType(((WildcardType) r4).getUpperBounds()[0]);
    }

    private static boolean equal(Object r0, Object r1) {
        return Objects.equals(r0, r1);
    }

    public static boolean equals(Type r4, Type r5) {
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
        if (equal(r6.getOwnerType(), r7.getOwnerType()) == false) goto L22;
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
        return equals(((GenericArrayType) r4).getGenericComponentType(), ((GenericArrayType) r5).getGenericComponentType());
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

    public static String typeToString(Type r1) {
        if ((r1 instanceof Class) == false) goto L6;
        return ((Class) r1).getName();
    L6:
        return r1.toString();
    }

    private static Type getGenericSupertype(Type r3, Class<?> r4, Class<?> r5) {
        if (r5 != r4) goto L5;
        return r3;
    L5:
        if (r5.isInterface() == false) goto L18;
        Class<?>[] r6 = r4.getInterfaces();
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L18;
        Class<?> r2 = r6[r1];
        if (r2 == r5) goto L11;
        if (r5.isAssignableFrom(r2) == true) goto L15;
        r1 = r1 + 1;
        goto L7
    L15:
        return getGenericSupertype(r4.getGenericInterfaces()[r1], r6[r1], r5);
    L11:
        return r4.getGenericInterfaces()[r1];
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
        return getGenericSupertype(r4.getGenericSuperclass(), r7, r5);
    L24:
        return r4.getGenericSuperclass();
    }

    private static Type getSupertype(Type r1, Class<?> r2, Class<?> r3) {
        if ((r1 instanceof WildcardType) == false) goto L5;
        r1 = ((WildcardType) r1).getUpperBounds()[0];
    L5:
        C$Gson$Preconditions.checkArgument(r3.isAssignableFrom(r2));
        return resolve(r1, r2, getGenericSupertype(r1, r2, r3));
    }

    public static Type getArrayComponentType(Type r1) {
        if ((r1 instanceof GenericArrayType) == false) goto L6;
        return ((GenericArrayType) r1).getGenericComponentType();
    L6:
        return ((Class) r1).getComponentType();
    }

    public static Type getCollectionElementType(Type r1, Class<?> r2) {
        Type r3 = getSupertype(r1, r2, Collection.class);
        if ((r3 instanceof ParameterizedType) == true) goto L5;
        return Object.class;
    L5:
        return ((ParameterizedType) r3).getActualTypeArguments()[0];
    }

    public static Type[] getMapKeyAndValueTypes(Type r4, Class<?> r5) {
        if (r4 == Properties.class) goto L5;
        Type r6 = getSupertype(r4, r5, Map.class);
        if ((r6 instanceof ParameterizedType) == false) goto L11;
        return ((ParameterizedType) r6).getActualTypeArguments();
    L11:
        return new Type[]{Object.class, Object.class};
    L5:
        return new Type[]{String.class, String.class};
    }

    public static Type resolve(Type r1, Class<?> r2, Type r3) {
        return resolve(r1, r2, r3, new HashMap());
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
    private static Type resolve(Type r9, Class<?> r10, Type r11, Map<TypeVariable<?>, Type> r12) {
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
        r11 = resolveTypeVariable(r9, r10, r1);
        if (r11 != r1) goto L4;
    L57:
        if (r0 == null) goto L59;
        r12.put(r0, r11);
    L59:
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
        Type r14 = resolve(r9, r10, r13, r12);
        if (equal(r13, r14) == false) goto L25;
        r11 = r3;
        goto L57
    L25:
        Type r15 = arrayOf(r14);
    L26:
        r11 = r15;
    L28:
        if ((r11 instanceof GenericArrayType) == false) goto L33;
        r11 = (GenericArrayType) r11;
        Type r4 = r11.getGenericComponentType();
        Type r16 = resolve(r9, r10, r4, r12);
        if (equal(r4, r16) == true) goto L57;
        r15 = arrayOf(r16);
        goto L26
    L33:
        int r5 = 0;
        if ((r11 instanceof ParameterizedType) == false) goto L46;
        r11 = (ParameterizedType) r11;
        Type r6 = r11.getOwnerType();
        Type r7 = resolve(r9, r10, r6, r12);
        boolean r8 = !equal(r7, r6);
        Type[] r17 = r11.getActualTypeArguments();
        int r18 = r17.length;
    L36:
        if (r5 >= r18) goto L43;
        Type r19 = resolve(r9, r10, r17[r5], r12);
        if (equal(r19, r17[r5]) == true) goto L42;
        if (r8 == true) goto L41;
        r17 = (Type[]) r17.clone();
        r8 = true;
    L41:
        r17[r5] = r19;
    L42:
        r5 = r5 + 1;
        goto L36
    L43:
        if (r8 == false) goto L57;
        r15 = newParameterizedTypeWithOwner(r7, r11.getRawType(), r17);
        goto L26
    L46:
        if ((r11 instanceof WildcardType) == false) goto L57;
        r11 = (WildcardType) r11;
        Type[] r20 = r11.getLowerBounds();
        Type[] r21 = r11.getUpperBounds();
        if (r20.length != 1) goto L53;
        Type r22 = resolve(r9, r10, r20[0], r12);
        if (r22 == r20[0]) goto L57;
        r11 = supertypeOf(r22);
        goto L57
    L53:
        if (r21.length != 1) goto L57;
        Type r23 = resolve(r9, r10, r21[0], r12);
        if (r23 == r21[0]) goto L57;
        r11 = subtypeOf(r23);
        goto L57
    }

    private static Type resolveTypeVariable(Type r1, Class<?> r2, TypeVariable<?> r3) {
        Class<?> r0 = declaringClassOf(r3);
        if (r0 != null) goto L5;
        return r3;
    L5:
        Type r4 = getGenericSupertype(r1, r2, r0);
        if ((r4 instanceof ParameterizedType) == false) goto L9;
        int r5 = indexOf(r0.getTypeParameters(), r3);
        return ((ParameterizedType) r4).getActualTypeArguments()[r5];
    L9:
        return r3;
    }

    private static int indexOf(Object[] r3, Object r4) {
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

    private static Class<?> declaringClassOf(TypeVariable<?> r1) {
        GenericDeclaration r2 = r1.getGenericDeclaration();
        if ((r2 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r2;
    }

    static void checkNotPrimitive(Type r1) {
        if ((r1 instanceof Class) == true) goto L5;
    L8:
        boolean r2 = true;
    L9:
        C$Gson$Preconditions.checkArgument(r2);
        return;
    L5:
        if (((Class) r1).isPrimitive() == false) goto L8;
        r2 = false;
        goto L9
    }
}
