package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
public final class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static JsonElement parseReader(Reader r2) {
        JsonReader r0 = new JsonReader(r2);     // Catch: NumberFormatException -> L9 IOException -> L11 MalformedJsonException -> L13
        JsonElement r3 = parseReader(r0);     // Catch: NumberFormatException -> L9 IOException -> L11 MalformedJsonException -> L13
        if (r3.isJsonNull() == false) goto L5;
    L15:
        return r3;
    L5:
        if (r0.peek() == JsonToken.END_DOCUMENT) goto L15;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L9 IOException -> L11 MalformedJsonException -> L13
    L13:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L11:
        e = move-exception;
        throw new JsonIOException(e);
    L9:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static JsonElement parseString(String r1) {
        return parseReader(new StringReader(r1));
    }

    @Deprecated
    public JsonElement parse(String r1) {
        return parseString(r1);
    }

    @Deprecated
    public JsonElement parse(Reader r1) {
        return parseReader(r1);
    }

    @Deprecated
    public JsonElement parse(JsonReader r1) {
        return parseReader(r1);
    }

    public static JsonElement parseReader(JsonReader r6) {
        boolean r2 = r6.isLenient();
        r6.setLenient(true);
        JsonElement r0 = Streams.parse(r6);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r6.setLenient(r2);
        return r0;
    L6:
        th = move-exception;
        r6.setLenient(r2);
        throw th;
    L8:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r6 + " to Json", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r6 + " to Json", e);     // Catch: Throwable -> L6
    }
}
