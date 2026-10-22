package com.google.gson.internal;

import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.s;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    static /* synthetic */ class a {
    }

    private static final class b extends Writer {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Appendable f7066f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a f7067g;

        private static class a implements CharSequence {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private char[] f7068f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private String f7069g;

            private a() {
            }

            /* synthetic */ a(a r1) {
                this();
            }

            void a(char[] r1) {
                this.f7068f = r1;
                this.f7069g = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int r1) {
                return this.f7068f[r1];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f7068f.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int r2, int r3) {
                return new String(this.f7068f, r2, r3 - r2);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f7069g != null) goto L6;
                this.f7069g = new String(this.f7068f);
            L6:
                return this.f7069g;
            }
        }

        b(Appendable r3) {
            this.f7067g = new a(null);
            this.f7066f = r3;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r2) {
            this.f7066f.append(r2);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r2, int r3, int r4) {
            this.f7066f.append(r2, r3, r4);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r1) {
            append(r1);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r1, int r2, int r3) {
            append(r1, r2, r3);
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int r1) {
            this.f7066f.append((char) r1);
        }

        @Override // java.io.Writer
        public void write(String r1, int r2, int r3) {
            Objects.requireNonNull(r1);
            this.f7066f.append(r1, r2, r3 + r2);
        }

        @Override // java.io.Writer
        public void write(char[] r2, int r3, int r4) {
            this.f7067g.a(r2);
            this.f7066f.append(this.f7067g, r3, r4 + r3);
        }
    }

    public static com.google.gson.j a(com.google.gson.a0.a r2) {
        r2.k0();     // Catch: NumberFormatException -> L8 IOException -> L11 com.google.gson.a0.d -> L14 EOFException -> L17
        boolean r0 = false;
        return TypeAdapters.V.b(r2);
    L6:
        e = e;
    L19:
        if (r0 == false) goto L23;
        return com.google.gson.l.f7093a;
    L23:
        throw new s(e);
    L17:
        e = e;
        r0 = true;
    L14:
        e = move-exception;
        throw new s(e);
    L11:
        e = move-exception;
        throw new com.google.gson.k(e);
    L8:
        e = move-exception;
        throw new s(e);
    }

    public static void b(com.google.gson.j r1, com.google.gson.a0.c r2) {
        TypeAdapters.V.d(r2, r1);
    }

    public static Writer c(Appendable r1) {
        if ((r1 instanceof Writer) == false) goto L6;
        return (Writer) r1;
    L6:
        return new b(r1);
    }
}
