package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class TypeVisitor {
    private final Set<Type> visited;

    void visitClass(Class<?> r1) {
    }

    void visitGenericArrayType(GenericArrayType r1) {
    }

    void visitParameterizedType(ParameterizedType r1) {
    }

    void visitTypeVariable(TypeVariable<?> r1) {
    }

    void visitWildcardType(WildcardType r1) {
    }

    TypeVisitor() {
        this.visited = Sets.newHashSet();
    }

    public final void visit(Type... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L30;
        Type r2 = r5[r1];
        if (r2 == null) goto L29;
        if (this.visited.add(r2) == false) goto L29;
    L26:
        th = move-exception;
        this.visited.remove(r2);
        throw th;
    L10:
        if ((r2 instanceof TypeVariable) == false) goto L13;
        visitTypeVariable((TypeVariable) r2);     // Catch: Throwable -> L26
        goto L29
    L13:
        if ((r2 instanceof WildcardType) == false) goto L16;
        visitWildcardType((WildcardType) r2);     // Catch: Throwable -> L26
        goto L29
    L16:
        if ((r2 instanceof ParameterizedType) == false) goto L19;
        visitParameterizedType((ParameterizedType) r2);     // Catch: Throwable -> L26
        goto L29
    L19:
        if ((r2 instanceof Class) == false) goto L22;
        visitClass((Class) r2);     // Catch: Throwable -> L26
        goto L29
    L22:
        if ((r2 instanceof GenericArrayType) == false) goto L24;
        visitGenericArrayType((GenericArrayType) r2);     // Catch: Throwable -> L26
        goto L29
    L24:
        String r3 = String.valueOf(r2);     // Catch: Throwable -> L26
        throw new AssertionError(new StringBuilder(String.valueOf(r3).length() + 14).append("Unknown type: ").append(r3).toString());     // Catch: Throwable -> L26
    L29:
        r1 = r1 + 1;
        goto L3
    }
}
