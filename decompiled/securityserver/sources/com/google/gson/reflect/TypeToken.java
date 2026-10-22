package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TypeToken<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    public TypeToken() {
        Type r0 = getSuperclassTypeParameter(getClass());
        this.type = r0;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r0);
        this.hashCode = r0.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type r4, Class<?>... r5) {
        StringBuilder r0 = new StringBuilder("Unexpected type. Expected one of: ");
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.append(r5[r2].getName());
        r0.append(", ");
        r2 = r2 + 1;
        goto L3
    L5:
        r0.append("but got: ");
        r0.append(r4.getClass().getName());
        r0.append(", for type token: ");
        r0.append(r4.toString());
        r0.append('.');
        return new AssertionError(r0.toString());
    }

    public static TypeToken<?> get(Type r1) {
        return new TypeToken(r1);
    }

    public static TypeToken<?> getArray(Type r1) {
        return new TypeToken(C$Gson$Types.arrayOf(r1));
    }

    public static TypeToken<?> getParameterized(Type r2, Type... r3) {
        return new TypeToken(C$Gson$Types.newParameterizedTypeWithOwner(null, r2, r3));
    }

    public static Type getSuperclassTypeParameter(Class<?> r1) {
        Type r2 = r1.getGenericSuperclass();
        if ((r2 instanceof Class) == true) goto L7;
        return C$Gson$Types.canonicalize(((ParameterizedType) r2).getActualTypeArguments()[0]);
    L7:
        throw new RuntimeException("Missing type parameter.");
    }

    private static boolean matches(Type r1, Type r2, Map<String, Type> r3) {
        if (r2.equals(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r1 instanceof TypeVariable) == true) goto L7;
    L9:
        return false;
    L7:
        if (r2.equals(r3.get(((TypeVariable) r1).getName())) == false) goto L9;
        goto L9
    }

    private static boolean typeEquals(ParameterizedType r4, ParameterizedType r5, Map<String, Type> r6) {
        if (r4.getRawType().equals(r5.getRawType()) == false) goto L13;
        Type[] r7 = r4.getActualTypeArguments();
        Type[] r8 = r5.getActualTypeArguments();
        int r0 = 0;
    L6:
        if (r0 >= r7.length) goto L11;
        if (matches(r7[r0], r8[r0], r6) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof TypeToken) == true) goto L5;
    L7:
        return false;
    L5:
        if (C$Gson$Types.equals(this.type, ((TypeToken) r2).type) == false) goto L7;
        return true;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> r1) {
        return isAssignableFrom(r1);
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }

    public static <T> TypeToken<T> get(Class<T> r1) {
        return new TypeToken(r1);
    }

    @Deprecated
    public boolean isAssignableFrom(Type r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.type.equals(r5) == false) goto L8;
        return true;
    L8:
        Type r1 = this.type;
        if ((r1 instanceof Class) == false) goto L13;
        return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r5));
    L13:
        if ((r1 instanceof ParameterizedType) == false) goto L17;
        return isAssignableFrom(r5, (ParameterizedType) r1, new HashMap());
    L17:
        if ((r1 instanceof GenericArrayType) == false) goto L25;
        if (this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r5)) == true) goto L21;
        return false;
    L21:
        if (isAssignableFrom(r5, (GenericArrayType) this.type) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        throw buildUnexpectedTypeError(r1, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    public TypeToken(Type r2) {
        Type r3 = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(r2));
        this.type = r3;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r3);
        this.hashCode = r3.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> r1) {
        return isAssignableFrom(r1.getType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(Type r1, GenericArrayType r2) {
        Type r3 = r2.getGenericComponentType();
        if ((r3 instanceof ParameterizedType) == true) goto L5;
        return true;
    L5:
        if ((r1 instanceof GenericArrayType) == false) goto L8;
        r1 = ((GenericArrayType) r1).getGenericComponentType();
    L14:
        return isAssignableFrom(r1, (ParameterizedType) r3, new HashMap());
    L8:
        if ((r1 instanceof Class) == false) goto L14;
        r1 = (Class) r1;
    L11:
        if (r1.isArray() == false) goto L14;
        r1 = r1.getComponentType();
        goto L11
    }

    private static boolean isAssignableFrom(Type r9, ParameterizedType r10, Map<String, Type> r11) {
        int r0 = 0;
        if (r9 != null) goto L6;
        return false;
    L6:
        if (r10.equals(r9) == false) goto L8;
        return true;
    L8:
        Class<?> r1 = C$Gson$Types.getRawType(r9);
        if ((r9 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r12 = (ParameterizedType) r9;
    L12:
        if (r12 == null) goto L24;
        Type[] r3 = r12.getActualTypeArguments();
        TypeVariable<Class<?>>[] r4 = r1.getTypeParameters();
        int r5 = 0;
    L15:
        if (r5 >= r3.length) goto L22;
        Type r6 = r3[r5];
        TypeVariable<Class<?>> r7 = r4[r5];
    L18:
        if ((r6 instanceof TypeVariable) == false) goto L20;
        r6 = r11.get(((TypeVariable) r6).getName());
        goto L18
    L20:
        r11.put(r7.getName(), r6);
        r5 = r5 + 1;
        goto L15
    L22:
        if (typeEquals(r12, r10, r11) == false) goto L24;
        return true;
    L24:
        Type[] r13 = r1.getGenericInterfaces();
        int r8 = r13.length;
    L25:
        if (r0 >= r8) goto L31;
        if (isAssignableFrom(r13[r0], r10, new HashMap(r11)) == true) goto L28;
        r0 = r0 + 1;
        goto L25
    L28:
        return true;
    L31:
        return isAssignableFrom(r1.getGenericSuperclass(), r10, new HashMap(r11));
    L11:
        r12 = null;
        goto L12
    }
}
