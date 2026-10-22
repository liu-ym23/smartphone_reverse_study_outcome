package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final TypeAdapterFactory DOUBLE_FACTORY = null;
    private final Gson gson;
    private final ToNumberStrategy toNumberStrategy;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            r0[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        DOUBLE_FACTORY = newFactory(ToNumberPolicy.DOUBLE);
    }

    public /* synthetic */ ObjectTypeAdapter(Gson r1, ToNumberStrategy r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r1) {
        if (r1 != ToNumberPolicy.DOUBLE) goto L7;
        return DOUBLE_FACTORY;
    L7:
        return newFactory(r1);
    }

    private static TypeAdapterFactory newFactory(final ToNumberStrategy r1) {
        return new AnonymousClass1(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r4) {
        JsonToken r0 = r4.peek();
        switch(AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r0.ordinal()]) {
            case 1: goto L20;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        r4.nextNull();
        return null;
    L14:
        LinkedTreeMap r1 = new LinkedTreeMap();
        r4.beginObject();
    L16:
        if (r4.hasNext() == false) goto L18;
        r1.put(r4.nextName(), read(r4));
        goto L16
    L18:
        r4.endObject();
        return r1;
    L20:
        ArrayList r2 = new ArrayList();
        r4.beginArray();
    L22:
        if (r4.hasNext() == false) goto L24;
        r2.add(read(r4));
        goto L22
    L24:
        r4.endArray();
        return r2;
    L5:
        throw new IllegalStateException();
    L9:
        return Boolean.valueOf(r4.nextBoolean());
    L11:
        return this.toNumberStrategy.readNumber(r4);
    L13:
        return r4.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r2, Object r3) {
        if (r3 != null) goto L5;
        r2.nullValue();
        return;
    L5:
        TypeAdapter r1 = this.gson.getAdapter(r3.getClass());
        if ((r1 instanceof ObjectTypeAdapter) == false) goto L9;
        r2.beginObject();
        r2.endObject();
        return;
    L9:
        r1.write(r2, r3);
    }

    private ObjectTypeAdapter(Gson r1, ToNumberStrategy r2) {
        this.gson = r1;
        this.toNumberStrategy = r2;
    }
}
