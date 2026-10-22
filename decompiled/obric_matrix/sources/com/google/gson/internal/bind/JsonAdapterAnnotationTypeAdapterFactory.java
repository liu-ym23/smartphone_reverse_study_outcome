package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i;
import com.google.gson.internal.c;
import com.google.gson.r;
import com.google.gson.x;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f6936f;

    public JsonAdapterAnnotationTypeAdapterFactory(c r1) {
        this.f6936f = r1;
    }

    @Override // com.google.gson.x
    public <T> TypeAdapter<T> a(Gson r3, com.google.gson.z.a<T> r4) {
        com.google.gson.y.b r0 = (com.google.gson.y.b) r4.getRawType().getAnnotation(com.google.gson.y.b.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (TypeAdapter<T>) b(this.f6936f, r3, r4, r0);
    }

    TypeAdapter<?> b(c r8, Gson r9, com.google.gson.z.a<?> r10, com.google.gson.y.b r11) {
        Object r7 = r8.b(com.google.gson.z.a.get(r11.value())).a();
        boolean r6 = r11.nullSafe();
        if ((r7 instanceof TypeAdapter) == false) goto L6;
        TypeAdapter<?> r12 = (TypeAdapter) r7;
    L24:
        if (r12 == null) goto L28;
        if (r6 == true) goto L27;
        return r12;
    L27:
        return r12.a();
    L28:
        return r12;
    L6:
        if ((r7 instanceof x) == false) goto L8;
        r12 = ((x) r7).a(r9, r10);
        goto L24
    L8:
        boolean r13 = r7 instanceof r;
        if (r13 == true) goto L16;
        if ((r7 instanceof i) == true) goto L16;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r7.getClass().getName() + " as a @JsonAdapter for " + r10.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    L16:
        if (r13 == false) goto L18;
        r r1 = (r) r7;
    L20:
        if ((r7 instanceof i) == false) goto L22;
        i r2 = (i) r7;
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
