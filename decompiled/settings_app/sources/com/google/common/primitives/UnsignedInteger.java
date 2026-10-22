package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger MAX_VALUE = null;
    public static final UnsignedInteger ONE = null;
    public static final UnsignedInteger ZERO = null;
    private final int value;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnsignedInteger r1) {
        return compareTo2(r1);
    }

    static {
        ZERO = fromIntBits(0);
        ONE = fromIntBits(1);
        MAX_VALUE = fromIntBits(-1);
    }

    private UnsignedInteger(int r1) {
        this.value = r1 & (-1);
    }

    public static UnsignedInteger fromIntBits(int r1) {
        return new UnsignedInteger(r1);
    }

    public static UnsignedInteger valueOf(long r2) {
        if ((4294967295L & r2) != r2) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "value (%s) is outside the range for an unsigned integer value", r2);
        return fromIntBits((int) r2);
    L5:
        r0 = false;
        goto L6
    }

    public static UnsignedInteger valueOf(BigInteger r2) {
        Preconditions.checkNotNull(r2);
        if (r2.signum() >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "value (%s) is outside the range for an unsigned integer value", r2);
        return fromIntBits(r2.intValue());
    L5:
        if (r2.bitLength() > 32) goto L7;
        r0 = true;
        goto L8
    }

    public static UnsignedInteger valueOf(String r1) {
        return valueOf(r1, 10);
    }

    public static UnsignedInteger valueOf(String r0, int r1) {
        return fromIntBits(UnsignedInts.parseUnsignedInt(r0, r1));
    }

    public UnsignedInteger plus(UnsignedInteger r1) {
        return fromIntBits(this.value + ((UnsignedInteger) Preconditions.checkNotNull(r1)).value);
    }

    public UnsignedInteger minus(UnsignedInteger r1) {
        return fromIntBits(this.value - ((UnsignedInteger) Preconditions.checkNotNull(r1)).value);
    }

    public UnsignedInteger times(UnsignedInteger r1) {
        return fromIntBits(this.value * ((UnsignedInteger) Preconditions.checkNotNull(r1)).value);
    }

    public UnsignedInteger dividedBy(UnsignedInteger r1) {
        return fromIntBits(UnsignedInts.divide(this.value, ((UnsignedInteger) Preconditions.checkNotNull(r1)).value));
    }

    public UnsignedInteger mod(UnsignedInteger r1) {
        return fromIntBits(UnsignedInts.remainder(this.value, ((UnsignedInteger) Preconditions.checkNotNull(r1)).value));
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.toLong(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedInteger r1) {
        Preconditions.checkNotNull(r1);
        return UnsignedInts.compare(this.value, r1.value);
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(@CheckForNull Object r3) {
        if ((r3 instanceof UnsignedInteger) == true) goto L5;
        return false;
    L5:
        if (this.value != ((UnsignedInteger) r3).value) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return toString(10);
    }

    public String toString(int r1) {
        return UnsignedInts.toString(this.value, r1);
    }
}
