package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String r1) {
        this.value = r1;
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new BigDecimal(this.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof LazilyParsedNumber) == false) goto L14;
        String r3 = this.value;
        String r5 = ((LazilyParsedNumber) r4).value;
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
        return Float.parseFloat(this.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return Integer.parseInt(this.value);
    L4:
        return (int) Long.parseLong(this.value);
    L8:
        return new BigDecimal(this.value).intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return Long.parseLong(this.value);
    L5:
        return new BigDecimal(this.value).longValue();
    }

    public String toString() {
        return this.value;
    }
}
