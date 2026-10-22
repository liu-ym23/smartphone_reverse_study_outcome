package com.google.gson;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f7095a;

    public p(Boolean r1) {
        Objects.requireNonNull(r1);
        this.f7095a = r1;
    }

    public p(Number r1) {
        Objects.requireNonNull(r1);
        this.f7095a = r1;
    }

    public p(String r1) {
        Objects.requireNonNull(r1);
        this.f7095a = r1;
    }

    private static boolean v(p r2) {
        Object r3 = r2.f7095a;
        if ((r3 instanceof Number) == false) goto L16;
        Number r4 = (Number) r3;
        if ((r4 instanceof BigInteger) == false) goto L7;
    L14:
        return true;
    L7:
        if ((r4 instanceof Long) == true) goto L14;
        if ((r4 instanceof Integer) == true) goto L14;
        if ((r4 instanceof Short) == true) goto L14;
        if ((r4 instanceof Byte) == true) goto L14;
        return false;
    L16:
        return false;
    }

    @Override // com.google.gson.j
    public int a() {
        if (w() == false) goto L6;
        return t().intValue();
    L6:
        return Integer.parseInt(l());
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
    L41:
        return false;
    L8:
        if (p.class != r6.getClass()) goto L41;
        p r7 = (p) r6;
        if (this.f7095a != null) goto L18;
        if (r7.f7095a != null) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (v(this) == true) goto L20;
    L26:
        Object r2 = this.f7095a;
        if ((r2 instanceof Number) == false) goto L40;
        if ((r7.f7095a instanceof Number) == false) goto L40;
        double r3 = t().doubleValue();
        double r5 = r7.t().doubleValue();
        if (r3 != r5) goto L33;
        return true;
    L33:
        if (Double.isNaN(r3) == false) goto L38;
        if (Double.isNaN(r5) == false) goto L38;
        return true;
    L38:
        return false;
    L40:
        return r2.equals(r7.f7095a);
    L20:
        if (v(r7) == false) goto L26;
        if (t().longValue() != r7.t().longValue()) goto L25;
        return true;
    L25:
        return false;
    }

    @Override // com.google.gson.j
    public long g() {
        if (w() == false) goto L6;
        return t().longValue();
    L6:
        return Long.parseLong(l());
    }

    public int hashCode() {
        if (this.f7095a != null) goto L7;
        return 31;
    L7:
        if (v(this) == false) goto L11;
        long r2 = t().longValue();
    L10:
        return (int) ((r2 >>> 32) ^ r2);
    L11:
        Object r0 = this.f7095a;
        if ((r0 instanceof Number) == false) goto L15;
        r2 = Double.doubleToLongBits(t().doubleValue());
        goto L10
    L15:
        return r0.hashCode();
    }

    @Override // com.google.gson.j
    public String l() {
        Object r0 = this.f7095a;
        if ((r0 instanceof String) == false) goto L7;
        return (String) r0;
    L7:
        if (w() == false) goto L11;
        return t().toString();
    L11:
        if (u() == false) goto L15;
        return ((Boolean) this.f7095a).toString();
    L15:
        throw new AssertionError("Unexpected value type: " + this.f7095a.getClass());
    }

    public boolean q() {
        if (u() == false) goto L7;
        return ((Boolean) this.f7095a).booleanValue();
    L7:
        return Boolean.parseBoolean(l());
    }

    public double r() {
        if (w() == false) goto L6;
        return t().doubleValue();
    L6:
        return Double.parseDouble(l());
    }

    public float s() {
        if (w() == false) goto L6;
        return t().floatValue();
    L6:
        return Float.parseFloat(l());
    }

    public Number t() {
        Object r0 = this.f7095a;
        if ((r0 instanceof Number) == false) goto L7;
        return (Number) r0;
    L7:
        if ((r0 instanceof String) == false) goto L11;
        return new com.google.gson.internal.f((String) this.f7095a);
    L11:
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean u() {
        return this.f7095a instanceof Boolean;
    }

    public boolean w() {
        return this.f7095a instanceof Number;
    }

    public boolean x() {
        return this.f7095a instanceof String;
    }
}
