package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes4.dex */
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

    TypeAdapter<?> getTypeAdapter(ConstructorConstructor r8, Gson r9, TypeToken<?> r10, JsonAdapter r11) {
        Object r7 = r8.get(TypeToken.get(r11.value())).construct();
        boolean r6 = r11.nullSafe();
        if ((r7 instanceof TypeAdapter) == false) goto L6;
        TypeAdapter<?> r12 = (TypeAdapter) r7;
    L24:
        if (r12 == null) goto L28;
        if (r6 == true) goto L27;
        return r12;
    L27:
        return r12.nullSafe();
    L28:
        return r12;
    L6:
        if ((r7 instanceof TypeAdapterFactory) == false) goto L8;
        r12 = ((TypeAdapterFactory) r7).create(r9, r10);
        goto L24
    L8:
        boolean r13 = r7 instanceof JsonSerializer;
        if (r13 == true) goto L16;
        if ((r7 instanceof JsonDeserializer) == true) goto L16;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r7.getClass().getName() + " as a @JsonAdapter for " + r10.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    L16:
        if (r13 == false) goto L18;
        JsonSerializer r1 = (JsonSerializer) r7;
    L20:
        if ((r7 instanceof JsonDeserializer) == false) goto L22;
        JsonDeserializer r2 = (JsonDeserializer) r7;
    L23:
        r12 = new TreeTypeAdapter(r1, r2, r9, r10, null, r6);
        r6 = false;
        goto L24
    L22:
        r2 = null;
        goto L23
    L18:
        r1 = null;
        goto L20
    }
}
