package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    private static final TypeAdapterFactory LAZILY_PARSED_NUMBER_FACTORY = null;
    private final ToNumberStrategy toNumberStrategy;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            r0[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Number read(JsonReader r1) throws IOException {
        return read(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Number r2) throws IOException {
        write2(r1, r2);
    }

    static {
        LAZILY_PARSED_NUMBER_FACTORY = newFactory(ToNumberPolicy.LAZILY_PARSED_NUMBER);
    }

    private NumberTypeAdapter(ToNumberStrategy r1) {
        this.toNumberStrategy = r1;
    }

    private static TypeAdapterFactory newFactory(ToNumberStrategy r1) {
        final NumberTypeAdapter r0 = new NumberTypeAdapter(r1);
        return new AnonymousClass1(r0);
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r1) {
        if (r1 != ToNumberPolicy.LAZILY_PARSED_NUMBER) goto L7;
        return LAZILY_PARSED_NUMBER_FACTORY;
    L7:
        return newFactory(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Number read(JsonReader r4) throws IOException {
        JsonToken r0 = r4.peek();
        int r1 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r0.ordinal()];
        if (r1 != 1) goto L5;
        r4.nextNull();
        return null;
    L5:
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L12;
        throw new JsonSyntaxException("Expecting number, got: " + r0 + "; at path " + r4.getPath());
    L12:
        return this.toNumberStrategy.readNumber(r4);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r1, Number r2) throws IOException {
        r1.value(r2);
    }
}
