package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class JsonTreeReader extends JsonReader {
    private static final Object SENTINEL_CLOSED = null;
    private static final Reader UNREADABLE_READER = null;
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;

    static {
        UNREADABLE_READER = new AnonymousClass1();
        SENTINEL_CLOSED = new Object();
    }

    public JsonTreeReader(JsonElement r3) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(r3);
    }

    private void expect(JsonToken r4) {
        if (peek() != r4) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r4 + " but was " + peek() + locationString());
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] r0 = this.stack;
        int r1 = this.stackSize - 1;
        this.stackSize = r1;
        Object r3 = r0[r1];
        r0[r1] = null;
        return r3;
    }

    private void push(Object r4) {
        int r0 = this.stackSize;
        Object[] r1 = this.stack;
        if (r0 != r1.length) goto L5;
        int r2 = r0 * 2;
        this.stack = Arrays.copyOf(r1, r2);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r2);
        this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r2);
    L5:
        Object[] r3 = this.stack;
        int r5 = this.stackSize;
        this.stackSize = r5 + 1;
        r3[r5] = r4;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() {
        expect(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        int r0 = this.stackSize;
        if (r0 <= 0) goto L6;
        int[] r2 = this.pathIndices;
        int r1 = r0 - 1;
        r2[r1] = r2[r1] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() {
        expect(JsonToken.END_OBJECT);
        popStack();
        popStack();
        int r0 = this.stackSize;
        if (r0 <= 0) goto L6;
        int[] r2 = this.pathIndices;
        int r1 = r0 - 1;
        r2[r1] = r2[r1] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder r0 = new StringBuilder("$");
        int r1 = 0;
    L3:
        int r2 = this.stackSize;
        if (r1 >= r2) goto L23;
        Object[] r3 = this.stack;
        Object r4 = r3[r1];
        if ((r4 instanceof JsonArray) == false) goto L13;
        r1 = r1 + 1;
        if (r1 >= r2) goto L21;
        if ((r3[r1] instanceof Iterator) == false) goto L21;
        r0.append('[');
        r0.append(this.pathIndices[r1]);
        r0.append(']');
    L21:
        r1 = r1 + 1;
        goto L3
    L13:
        if ((r4 instanceof JsonObject) == false) goto L21;
        r1 = r1 + 1;
        if (r1 >= r2) goto L21;
        if ((r3[r1] instanceof Iterator) == false) goto L21;
        r0.append('.');
        String r5 = this.pathNames[r1];
        if (r5 == null) goto L21;
        r0.append(r5);
        goto L21
    L23:
        return r0.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() {
        JsonToken r1 = peek();
        if (r1 != JsonToken.END_OBJECT) goto L5;
    L7:
        return false;
    L5:
        if (r1 == JsonToken.END_ARRAY) goto L7;
        return true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() {
        expect(JsonToken.BOOLEAN);
        boolean r0 = ((JsonPrimitive) popStack()).getAsBoolean();
        int r1 = this.stackSize;
        if (r1 <= 0) goto L5;
        int[] r3 = this.pathIndices;
        int r2 = r1 - 1;
        r3[r2] = r3[r2] + 1;
    L5:
        return r0;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() {
        JsonToken r0 = peek();
        JsonToken r1 = JsonToken.NUMBER;
        if (r0 != r1) goto L5;
    L9:
        double r2 = ((JsonPrimitive) peekStack()).getAsDouble();
        if (isLenient() == false) goto L12;
    L18:
        popStack();
        int r3 = this.stackSize;
        if (r3 <= 0) goto L21;
        int[] r5 = this.pathIndices;
        int r4 = r3 - 1;
        r5[r4] = r5[r4] + 1;
    L21:
        return r2;
    L12:
        if (Double.isNaN(r2) == true) goto L17;
        if (Double.isInfinite(r2) == false) goto L18;
    L17:
        throw new NumberFormatException("JSON forbids NaN and infinities: " + r2);
    L5:
        if (r0 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r1 + " but was " + r0 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() {
        JsonToken r0 = peek();
        JsonToken r1 = JsonToken.NUMBER;
        if (r0 != r1) goto L5;
    L9:
        int r2 = ((JsonPrimitive) peekStack()).getAsInt();
        popStack();
        int r3 = this.stackSize;
        if (r3 <= 0) goto L12;
        int[] r5 = this.pathIndices;
        int r4 = r3 - 1;
        r5[r4] = r5[r4] + 1;
    L12:
        return r2;
    L5:
        if (r0 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r1 + " but was " + r0 + locationString());
    }

    public JsonElement nextJsonElement() {
        JsonToken r0 = peek();
        if (r0 == JsonToken.NAME) goto L13;
        if (r0 == JsonToken.END_ARRAY) goto L13;
        if (r0 == JsonToken.END_OBJECT) goto L13;
        if (r0 == JsonToken.END_DOCUMENT) goto L13;
        JsonElement r1 = (JsonElement) peekStack();
        skipValue();
        return r1;
    L13:
        throw new IllegalStateException("Unexpected " + r0 + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() {
        JsonToken r0 = peek();
        JsonToken r1 = JsonToken.NUMBER;
        if (r0 != r1) goto L5;
    L9:
        long r2 = ((JsonPrimitive) peekStack()).getAsLong();
        popStack();
        int r3 = this.stackSize;
        if (r3 <= 0) goto L12;
        int[] r5 = this.pathIndices;
        int r4 = r3 - 1;
        r5[r4] = r5[r4] + 1;
    L12:
        return r2;
    L5:
        if (r0 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r1 + " but was " + r0 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() {
        expect(JsonToken.NAME);
        Map.Entry r0 = (Map.Entry) ((Iterator) peekStack()).next();
        String r1 = (String) r0.getKey();
        this.pathNames[this.stackSize - 1] = r1;
        push(r0.getValue());
        return r1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() {
        expect(JsonToken.NULL);
        popStack();
        int r0 = this.stackSize;
        if (r0 <= 0) goto L6;
        int[] r2 = this.pathIndices;
        int r1 = r0 - 1;
        r2[r1] = r2[r1] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() {
        JsonToken r0 = peek();
        JsonToken r1 = JsonToken.STRING;
        if (r0 != r1) goto L5;
    L9:
        String r2 = ((JsonPrimitive) popStack()).getAsString();
        int r3 = this.stackSize;
        if (r3 <= 0) goto L12;
        int[] r5 = this.pathIndices;
        int r4 = r3 - 1;
        r5[r4] = r5[r4] + 1;
    L12:
        return r2;
    L5:
        if (r0 == JsonToken.NUMBER) goto L9;
        throw new IllegalStateException("Expected " + r1 + " but was " + r0 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() {
        if (this.stackSize == 0) goto L5;
        Object r0 = peekStack();
        if ((r0 instanceof Iterator) == false) goto L20;
        boolean r1 = this.stack[this.stackSize - 2] instanceof JsonObject;
        Iterator r2 = (Iterator) r0;
        if (r2.hasNext() == false) goto L15;
        if (r1 == true) goto L12;
        push(r2.next());
        return peek();
    L12:
        return JsonToken.NAME;
    L15:
        if (r1 == false) goto L18;
        return JsonToken.END_OBJECT;
    L18:
        return JsonToken.END_ARRAY;
    L20:
        if ((r0 instanceof JsonObject) == false) goto L24;
        return JsonToken.BEGIN_OBJECT;
    L24:
        if ((r0 instanceof JsonArray) == false) goto L28;
        return JsonToken.BEGIN_ARRAY;
    L28:
        if ((r0 instanceof JsonPrimitive) == false) goto L44;
        JsonPrimitive r3 = (JsonPrimitive) r0;
        if (r3.isString() == false) goto L34;
        return JsonToken.STRING;
    L34:
        if (r3.isBoolean() == false) goto L38;
        return JsonToken.BOOLEAN;
    L38:
        if (r3.isNumber() == false) goto L42;
        return JsonToken.NUMBER;
    L42:
        throw new AssertionError();
    L44:
        if ((r0 instanceof JsonNull) == false) goto L48;
        return JsonToken.NULL;
    L48:
        if (r0 != SENTINEL_CLOSED) goto L52;
        throw new IllegalStateException("JsonReader is closed");
    L52:
        throw new AssertionError();
    L5:
        return JsonToken.END_DOCUMENT;
    }

    public void promoteNameToValue() {
        expect(JsonToken.NAME);
        Map.Entry r0 = (Map.Entry) ((Iterator) peekStack()).next();
        push(r0.getValue());
        push(new JsonPrimitive((String) r0.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() {
        if (peek() != JsonToken.NAME) goto L5;
        nextName();
        this.pathNames[this.stackSize - 2] = "null";
    L8:
        int r0 = this.stackSize;
        if (r0 <= 0) goto L12;
        int[] r3 = this.pathIndices;
        int r1 = r0 - 1;
        r3[r1] = r3[r1] + 1;
        return;
    L12:
        return;
    L5:
        popStack();
        int r2 = this.stackSize;
        if (r2 <= 0) goto L8;
        this.pathNames[r2 - 1] = "null";
        goto L8
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return "JsonTreeReader" + locationString();
    }
}
