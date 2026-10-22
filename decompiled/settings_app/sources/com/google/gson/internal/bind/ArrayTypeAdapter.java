package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = null;
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    public ArrayTypeAdapter(Gson r2, TypeAdapter<E> r3, Class<E> r4) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r2, r3, r4);
        this.componentType = r4;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r4) throws IOException {
        if (r4.peek() != JsonToken.NULL) goto L6;
        r4.nextNull();
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        r4.beginArray();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(this.componentTypeAdapter.read(r4));
        goto L8
    L10:
        r4.endArray();
        int r5 = r0.size();
        if (this.componentType.isPrimitive() == false) goto L17;
        Object r3 = Array.newInstance(this.componentType, r5);
        int r1 = 0;
    L13:
        if (r1 >= r5) goto L15;
        Array.set(r3, r1, r0.get(r1));
        r1 = r1 + 1;
        goto L13
    L15:
        return r3;
    L17:
        return r0.toArray((Object[]) Array.newInstance(this.componentType, r5));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r5, Object r6) throws IOException {
        if (r6 != null) goto L5;
        r5.nullValue();
        return;
    L5:
        r5.beginArray();
        int r0 = Array.getLength(r6);
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        Object r2 = Array.get(r6, r1);
        this.componentTypeAdapter.write(r5, (E) r2);
        r1 = r1 + 1;
        goto L6
    L8:
        r5.endArray();
    }
}
