package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    public TypeAdapterRuntimeTypeWrapper(Gson r1, TypeAdapter<T> r2, Type r3) {
        this.context = r1;
        this.delegate = r2;
        this.type = r3;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type r1, Object r2) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        if (r1 == Object.class) goto L10;
        if ((r1 instanceof TypeVariable) == true) goto L10;
        if ((r1 instanceof Class) == true) goto L10;
        return r1;
    L10:
        return r2.getClass();
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r1) {
        return this.delegate.read(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r4, T r5) {
        TypeAdapter<T> r0 = this.delegate;
        Type r1 = getRuntimeTypeIfMoreSpecific(this.type, r5);
        if (r1 == this.type) goto L10;
        r0 = this.context.getAdapter(TypeToken.get(r1));
        if ((r0 instanceof ReflectiveTypeAdapterFactory.Adapter) == false) goto L10;
        TypeAdapter<T> r3 = this.delegate;
        if ((r3 instanceof ReflectiveTypeAdapterFactory.Adapter) == true) goto L10;
        r0 = r3;
    L10:
        r0.write(r4, r5);
    }
}
