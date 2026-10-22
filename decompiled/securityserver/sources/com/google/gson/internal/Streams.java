package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class Streams {

    public static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        public static class CurrentWrite implements CharSequence {
            char[] chars;

            public CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int r1) {
                return this.chars[r1];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int r2, int r3) {
                return new String(this.chars, r2, r3 - r2);
            }
        }

        public AppendableWriter(Appendable r2) {
            this.currentWrite = new CurrentWrite();
            this.appendable = r2;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] r2, int r3, int r4) {
            CurrentWrite r0 = this.currentWrite;
            r0.chars = r2;
            this.appendable.append(r0, r3, r4 + r3);
        }

        @Override // java.io.Writer
        public void write(int r1) {
            this.appendable.append((char) r1);
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader r2) {
        r2.peek();     // Catch: NumberFormatException -> L6 IOException -> L8 MalformedJsonException -> L10 EOFException -> L20
        boolean r0 = false;
        return TypeAdapters.JSON_ELEMENT.read(r2);
    L12:
        e = e;
    L22:
        if (r0 == false) goto L26;
        return JsonNull.INSTANCE;
    L26:
        throw new JsonSyntaxException(e);
    L20:
        e = e;
        r0 = true;
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L8:
        e = move-exception;
        throw new JsonIOException(e);
    L6:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static void write(JsonElement r1, JsonWriter r2) {
        TypeAdapters.JSON_ELEMENT.write(r2, r1);
    }

    public static Writer writerForAppendable(Appendable r1) {
        if ((r1 instanceof Writer) == false) goto L6;
        return (Writer) r1;
    L6:
        return new AppendableWriter(r1);
    }
}
