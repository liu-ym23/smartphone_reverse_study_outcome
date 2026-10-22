package android.icu.math;

import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class BigDecimal extends Number implements Serializable, Comparable<BigDecimal> {
    public static final BigDecimal ONE = null;
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_DOWN = 1;
    public static final int ROUND_FLOOR = 3;
    public static final int ROUND_HALF_DOWN = 5;
    public static final int ROUND_HALF_EVEN = 6;
    public static final int ROUND_HALF_UP = 4;
    public static final int ROUND_UNNECESSARY = 7;
    public static final int ROUND_UP = 0;
    public static final BigDecimal TEN = null;
    public static final BigDecimal ZERO = null;

    static {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BigDecimal r1) {
        return compareTo2(r1);
    }

    public BigDecimal(java.math.BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal(BigInteger r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal(BigInteger r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal(char[] r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal(char[] r1, int r2, int r3) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal(double r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal(int r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal(long r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal(String r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal abs() {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal abs(MathContext r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal add(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal add(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public int compareTo(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal divide(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal divide(BigDecimal r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal divide(BigDecimal r1, int r2, int r3) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal divide(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal divideInteger(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal divideInteger(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal max(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal max(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal min(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal min(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal multiply(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal multiply(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal negate() {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal negate(MathContext r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal plus() {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal plus(MathContext r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal pow(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal pow(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal remainder(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal remainder(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal subtract(BigDecimal r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal subtract(BigDecimal r1, MathContext r2) {
        throw new RuntimeException("Stub!");
    }

    public byte byteValueExact() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Number
    public double doubleValue() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Number
    public float floatValue() {
        throw new RuntimeException("Stub!");
    }

    public String format(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public String format(int r1, int r2, int r3, int r4, int r5, int r6) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Number
    public int intValue() {
        throw new RuntimeException("Stub!");
    }

    public int intValueExact() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Number
    public long longValue() {
        throw new RuntimeException("Stub!");
    }

    public long longValueExact() {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal movePointLeft(int r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal movePointRight(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int scale() {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal setScale(int r1) {
        throw new RuntimeException("Stub!");
    }

    public BigDecimal setScale(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public short shortValueExact() {
        throw new RuntimeException("Stub!");
    }

    public int signum() {
        throw new RuntimeException("Stub!");
    }

    public java.math.BigDecimal toBigDecimal() {
        throw new RuntimeException("Stub!");
    }

    public BigInteger toBigInteger() {
        throw new RuntimeException("Stub!");
    }

    public BigInteger toBigIntegerExact() {
        throw new RuntimeException("Stub!");
    }

    public char[] toCharArray() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public BigInteger unscaledValue() {
        throw new RuntimeException("Stub!");
    }

    public static BigDecimal valueOf(double r0) {
        throw new RuntimeException("Stub!");
    }

    public static BigDecimal valueOf(long r0) {
        throw new RuntimeException("Stub!");
    }

    public static BigDecimal valueOf(long r0, int r2) {
        throw new RuntimeException("Stub!");
    }
}
