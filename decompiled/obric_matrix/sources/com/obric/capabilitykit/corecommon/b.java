package com.obric.capabilitykit.corecommon;

import com.google.gson.a0.d;
import com.google.gson.internal.l;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.s;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/corecommon/JsonParserExt;", "", "()V", "parseReader", "Lcom/google/gson/JsonElement;", "reader", "Lcom/google/gson/stream/JsonReader;", "Ljava/io/Reader;", "parseString", "json", "", "capabilitykitcorecommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8105a = null;

    static {
        f8105a = new b();
    }

    private b() {
    }

    public final j a(com.google.gson.a0.a r6) {
        o.f(r6, "reader");
        boolean r1 = r6.M();
        r6.p0(true);
        j r2 = l.a(r6);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        o.e(r2, "{\n            Streams.parse(reader)\n        }");     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r6.p0(r1);
        return r2;
    L6:
        th = move-exception;
        r6.p0(r1);
        throw th;
    L8:
        e = move-exception;
        throw new n("Failed parsing JSON source: " + r6 + " to Json", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new n("Failed parsing JSON source: " + r6 + " to Json", e);     // Catch: Throwable -> L6
    }

    public final j b(Reader r2) {
        o.f(r2, "reader");
        com.google.gson.a0.a r0 = new com.google.gson.a0.a(r2);     // Catch: NumberFormatException -> L11 IOException -> L14 d -> L17
        j r1 = a(r0);     // Catch: NumberFormatException -> L11 IOException -> L14 d -> L17
        if (r1.n() == false) goto L6;
    L10:
        return r1;
    L6:
        if (r0.k0() == com.google.gson.a0.b.o) goto L10;
        throw new s("Did not consume the entire document.");     // Catch: NumberFormatException -> L11 IOException -> L14 d -> L17
    L17:
        e = move-exception;
        throw new s(e);
    L14:
        e = move-exception;
        throw new k(e);
    L11:
        e = move-exception;
        throw new s(e);
    }

    public final j c(String r2) {
        return b(new StringReader(r2));
    }
}
