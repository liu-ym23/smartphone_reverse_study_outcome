package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ JsonElement next() {
        return next();
    }

    public JsonStreamParser(String r2) {
        this(new StringReader(r2));
    }

    public JsonStreamParser(Reader r2) {
        JsonReader r0 = new JsonReader(r2);
        this.parser = r0;
        r0.setLenient(true);
        this.lock = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext() == false) goto L13;
        return Streams.parse(this.parser);
    L6:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source to Json", e);
    L9:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source to Json", e);
    L13:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Object r0 = this.lock;
        monitor-enter(r0);
        if (this.parser.peek() == JsonToken.END_DOCUMENT) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L10
    L15:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L10
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
