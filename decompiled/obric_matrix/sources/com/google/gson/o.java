package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static j a(com.google.gson.a0.a r6) {
        boolean r2 = r6.M();
        r6.p0(true);
        j r0 = com.google.gson.internal.l.a(r6);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r6.p0(r2);
        return r0;
    L6:
        th = move-exception;
        r6.p0(r2);
        throw th;
    L8:
        e = move-exception;
        throw new n("Failed parsing JSON source: " + r6 + " to Json", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new n("Failed parsing JSON source: " + r6 + " to Json", e);     // Catch: Throwable -> L6
    }

    public static j b(Reader r2) {
        com.google.gson.a0.a r0 = new com.google.gson.a0.a(r2);     // Catch: NumberFormatException -> L10 IOException -> L13 com.google.gson.a0.d -> L16
        j r3 = a(r0);     // Catch: NumberFormatException -> L10 IOException -> L13 com.google.gson.a0.d -> L16
        if (r3.n() == false) goto L5;
    L9:
        return r3;
    L5:
        if (r0.k0() == com.google.gson.a0.b.o) goto L9;
        throw new s("Did not consume the entire document.");     // Catch: NumberFormatException -> L10 IOException -> L13 com.google.gson.a0.d -> L16
    L16:
        e = move-exception;
        throw new s(e);
    L13:
        e = move-exception;
        throw new k(e);
    L10:
        e = move-exception;
        throw new s(e);
    }

    public static j c(String r1) {
        return b(new StringReader(r1));
    }
}
