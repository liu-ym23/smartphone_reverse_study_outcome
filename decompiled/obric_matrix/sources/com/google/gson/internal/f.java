package com.google.gson.internal;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends Number {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f7043f;

    public f(String r1) {
        this.f7043f = r1;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f7043f);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof f) == false) goto L14;
        String r3 = this.f7043f;
        String r5 = ((f) r4).f7043f;
        if (r3 != r5) goto L10;
        return true;
    L10:
        if (r3.equals(r5) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f7043f);
    }

    public int hashCode() {
        return this.f7043f.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return Integer.parseInt(this.f7043f);
    L4:
        return (int) Long.parseLong(this.f7043f);
    L8:
        return new BigDecimal(this.f7043f).intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return Long.parseLong(this.f7043f);
    L5:
        return new BigDecimal(this.f7043f).longValue();
    }

    public String toString() {
        return this.f7043f;
    }
}
