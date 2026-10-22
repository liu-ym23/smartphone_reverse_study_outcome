package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor r1) {
        this.constructorConstructor = r1;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r3, TypeToken<T> r4) {
        JsonAdapter r0 = (JsonAdapter) r4.getRawType().getAnnotation(JsonAdapter.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, r3, r4, r0);
    }

    public TypeAdapter<?> getTypeAdapter(ConstructorConstructor r8, Gson r9, TypeToken<?> r10, JsonAdapter r11) {
        Object r7 = r8.get(TypeToken.get(r11.value())).construct();
        if ((r7 instanceof TypeAdapter) == false) goto L6;
        TypeAdapter<?> r12 = (TypeAdapter) r7;
    L23:
        if (r12 != null) goto L25;
        return r12;
    L25:
        if (r11.nullSafe() == true) goto L27;
        return r12;
    L27:
        return r12.nullSafe();
    L6:
        if ((r7 instanceof TypeAdapterFactory) == false) goto L8;
        r12 = ((TypeAdapterFactory) r7).create(r9, r10);
        goto L23
    L8:
        boolean r13 = r7 instanceof JsonSerializer;
        if (r13 == false) goto L11;
    L15:
        JsonDeserializer r0 = null;
        if (r13 == false) goto L18;
        JsonSerializer r2 = (JsonSerializer) r7;
    L20:
        if ((r7 instanceof JsonDeserializer) == false) goto L22;
        r0 = (JsonDeserializer) r7;
    L22:
        r12 = new TreeTypeAdapter(r2, r0, r9, r10, null);
        goto L23
    L18:
        r2 = null;
        goto L20
    L11:
        if ((r7 instanceof JsonDeserializer) == true) goto L15;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r7.getClass().getName() + " as a @JsonAdapter for " + r10.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    }
}
