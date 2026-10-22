package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f6883a;

    public b(Field r1) {
        Objects.requireNonNull(r1);
        this.f6883a = r1;
    }

    public Class<?> a() {
        return this.f6883a.getDeclaringClass();
    }

    public String b() {
        return this.f6883a.getName();
    }

    public String toString() {
        return this.f6883a.toString();
    }
}
