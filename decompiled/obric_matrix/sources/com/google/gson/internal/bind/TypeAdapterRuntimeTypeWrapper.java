package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.a0.c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f6988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f6989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f6990c;

    TypeAdapterRuntimeTypeWrapper(Gson r1, TypeAdapter<T> r2, Type r3) {
        this.f6988a = r1;
        this.f6989b = r2;
        this.f6990c = r3;
    }

    private static Type e(Type r1, Object r2) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        if ((r1 instanceof Class) == true) goto L8;
        if ((r1 instanceof TypeVariable) == true) goto L8;
        return r1;
    L8:
        return r2.getClass();
    }

    private static boolean f(TypeAdapter<?> r1) {
    L3:
        if ((r1 instanceof SerializationDelegatingTypeAdapter) == false) goto L9;
        TypeAdapter<?> r0 = ((SerializationDelegatingTypeAdapter) r1).e();
        if (r0 == r1) goto L9;
        r1 = r0;
    L9:
        return r1 instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T b(com.google.gson.a0.a r1) {
        return this.f6989b.b(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(c r4, T r5) {
        TypeAdapter<T> r0 = this.f6989b;
        Type r1 = e(this.f6990c, r5);
        if (r1 == this.f6990c) goto L10;
        r0 = this.f6988a.o(com.google.gson.z.a.get(r1));
        if ((r0 instanceof ReflectiveTypeAdapterFactory.Adapter) == false) goto L10;
        if (f(this.f6989b) == true) goto L10;
        r0 = this.f6989b;
    L10:
        r0.d(r4, r5);
    }
}
