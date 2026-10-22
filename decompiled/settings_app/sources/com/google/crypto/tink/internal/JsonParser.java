package com.google.crypto.tink.internal;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonParser {
    private static final JsonElementTypeAdapter JSON_ELEMENT = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.JsonParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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

    private static final class JsonElementTypeAdapter extends TypeAdapter<JsonElement> {
        private static final int RECURSION_LIMIT = 100;

        private JsonElementTypeAdapter() {
        }

        /* synthetic */ JsonElementTypeAdapter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ JsonElement read(JsonReader in) throws IOException {
            return read(in);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter out, JsonElement value) throws IOException {
            write2(out, value);
        }

        @Nullable
        private JsonElement tryBeginNesting(JsonReader in, JsonToken peeked) throws IOException {
            int r0 = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[peeked.ordinal()];
            if (r0 != 1) goto L5;
            in.beginArray();
            return new JsonArray();
        L5:
            if (r0 == 2) goto L8;
            return null;
        L8:
            in.beginObject();
            return new JsonObject();
        }

        private JsonElement readTerminal(JsonReader in, JsonToken peeked) throws IOException {
            int r1 = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[peeked.ordinal()];
            if (r1 != 3) goto L5;
            String r2 = in.nextString();
            if (JsonParser.isValidString(r2) == false) goto L23;
            return new JsonPrimitive(r2);
        L23:
            throw new IOException("illegal characters in string");
        L5:
            if (r1 == 4) goto L17;
            if (r1 == 5) goto L15;
            if (r1 != 6) goto L13;
            in.nextNull();
            return JsonNull.INSTANCE;
        L13:
            throw new IllegalStateException("Unexpected token: " + peeked);
        L15:
            return new JsonPrimitive(Boolean.valueOf(in.nextBoolean()));
        L17:
            return new JsonPrimitive(new LazilyParsedNumber(in.nextString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public JsonElement read(JsonReader in) throws IOException {
            JsonToken r0 = in.peek();
            JsonElement r1 = tryBeginNesting(in, r0);
            if (r1 == null) goto L5;
            ArrayDeque r2 = new ArrayDeque();
        L8:
            if (in.hasNext() == true) goto L10;
            if ((r1 instanceof JsonArray) == false) goto L40;
            in.endArray();
        L42:
            if (r2.isEmpty() == true) goto L43;
            r1 = (JsonElement) r2.removeLast();
            goto L8
        L43:
            return r1;
        L40:
            in.endObject();
            goto L42
        L10:
            if ((r1 instanceof JsonObject) == false) goto L16;
            String r3 = in.nextName();
            if (JsonParser.isValidString(r3) == false) goto L15;
        L17:
            JsonToken r4 = in.peek();
            JsonElement r5 = tryBeginNesting(in, r4);
            if (r5 == null) goto L20;
            boolean r6 = true;
        L21:
            if (r5 != null) goto L24;
            r5 = readTerminal(in, r4);
        L24:
            if ((r1 instanceof JsonArray) == false) goto L26;
            ((JsonArray) r1).add(r5);
        L29:
            if (r6 == false) goto L8;
            r2.addLast(r1);
            if (r2.size() > 100) goto L34;
            r1 = r5;
            goto L8
        L34:
            throw new IOException("too many recursions");
        L26:
            JsonObject r7 = (JsonObject) r1;
            if (r7.has(r3) == true) goto L36;
            r7.add(r3, r5);
            goto L29
        L36:
            throw new IOException("duplicate key: " + r3);
        L20:
            r6 = false;
            goto L21
        L15:
            throw new IOException("illegal characters in string");
        L16:
            r3 = null;
            goto L17
        L5:
            return readTerminal(in, r0);
        }

        /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(JsonWriter out, JsonElement value) {
            throw new UnsupportedOperationException("write is not supported");
        }
    }

    private static final class LazilyParsedNumber extends Number {
        private final String value;

        public LazilyParsedNumber(String value) {
            this.value = value;
        }

        @Override // java.lang.Number
        public int intValue() {
            return Integer.parseInt(this.value);
        L4:
            return (int) Long.parseLong(this.value);
        L8:
            return new BigDecimal(this.value).intValue();
        }

        @Override // java.lang.Number
        public long longValue() {
            return Long.parseLong(this.value);
        L5:
            return new BigDecimal(this.value).longValue();
        }

        @Override // java.lang.Number
        public float floatValue() {
            return Float.parseFloat(this.value);
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return Double.parseDouble(this.value);
        }

        public String toString() {
            return this.value;
        }

        private Object writeReplace() throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        private void readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if ((obj instanceof LazilyParsedNumber) == true) goto L8;
            return false;
        L8:
            return this.value.equals(((LazilyParsedNumber) obj).value);
        }
    }

    public static boolean isValidString(String s) {
        int r0 = s.length();
        int r2 = 0;
    L3:
        if (r2 == r0) goto L4;
        char r3 = s.charAt(r2);
        r2 = r2 + 1;
        if (Character.isSurrogate(r3) == false) goto L3;
        if (Character.isLowSurrogate(r3) == true) goto L15;
        if (r2 == r0) goto L15;
        if (Character.isLowSurrogate(s.charAt(r2)) == false) goto L15;
        r2 = r2 + 1;
    L15:
        return false;
    L4:
        return true;
    }

    static {
        JSON_ELEMENT = new JsonElementTypeAdapter(null);
    }

    public static JsonElement parse(String json) throws IOException {
        JsonReader r0 = new JsonReader(new StringReader(json));     // Catch: NumberFormatException -> L4
        r0.setLenient(false);     // Catch: NumberFormatException -> L4
        return JSON_ELEMENT.read(r0);
    L4:
        e = move-exception;
        throw new IOException(e);
    }

    public static long getParsedNumberAsLongOrThrow(JsonElement element) {
        if ((element.getAsNumber() instanceof LazilyParsedNumber) == false) goto L7;
        return Long.parseLong(element.getAsNumber().toString());
    L7:
        throw new IllegalArgumentException("does not contain a parsed number.");
    }

    private JsonParser() {
    }
}
