package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static JsonElement parseString(String r1) throws JsonSyntaxException {
        return parseReader(new StringReader(r1));
    }

    public static JsonElement parseReader(Reader r2) throws JsonIOException, JsonSyntaxException {
        JsonReader r0 = new JsonReader(r2);     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
        JsonElement r3 = parseReader(r0);     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
        if (r3.isJsonNull() == false) goto L5;
    L9:
        return r3;
    L5:
        if (r0.peek() == JsonToken.END_DOCUMENT) goto L9;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
    L16:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L13:
        e = move-exception;
        throw new JsonIOException(e);
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static JsonElement parseReader(JsonReader r6) throws JsonIOException, JsonSyntaxException {
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

    @Deprecated
    public JsonElement parse(String r1) throws JsonSyntaxException {
        return parseString(r1);
    }

    @Deprecated
    public JsonElement parse(Reader r1) throws JsonIOException, JsonSyntaxException {
        return parseReader(r1);
    }

    @Deprecated
    public JsonElement parse(JsonReader r1) throws JsonIOException, JsonSyntaxException {
        return parseReader(r1);
    }
}
