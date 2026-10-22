package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    @Deprecated
    public j() {
    }

    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public g b() {
        if (m() == false) goto L7;
        return (g) this;
    L7:
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m c() {
        if (o() == false) goto L7;
        return (m) this;
    L7:
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public p d() {
        if (p() == false) goto L7;
        return (p) this;
    L7:
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String l() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean m() {
        return this instanceof g;
    }

    public boolean n() {
        return this instanceof l;
    }

    public boolean o() {
        return this instanceof m;
    }

    public boolean p() {
        return this instanceof p;
    }

    public String toString() {
        StringWriter r0 = new StringWriter();     // Catch: IOException -> L4
        com.google.gson.a0.c r1 = new com.google.gson.a0.c(r0);     // Catch: IOException -> L4
        r1.g0(true);     // Catch: IOException -> L4
        com.google.gson.internal.l.b(this, r1);     // Catch: IOException -> L4
        return r0.toString();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
