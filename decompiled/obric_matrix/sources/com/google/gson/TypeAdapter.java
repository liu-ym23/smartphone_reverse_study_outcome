package com.google.gson;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeAdapter<T> {
    public TypeAdapter() {
    }

    public final TypeAdapter<T> a() {
        return new AnonymousClass1(this);
    }

    public abstract T b(com.google.gson.a0.a r1);

    public final j c(T r2) {
        com.google.gson.internal.bind.b r0 = new com.google.gson.internal.bind.b();     // Catch: IOException -> L4
        d(r0, r2);     // Catch: IOException -> L4
        return r0.q0();
    L4:
        e = move-exception;
        throw new k(e);
    }

    public abstract void d(com.google.gson.a0.c r1, T r2);
}
