package org.apache.commons.math3.fraction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BigFraction extends Number implements FieldElement<BigFraction>, Comparable<BigFraction>, Serializable {
    public static final BigFraction FOUR_FIFTHS = null;
    public static final BigFraction MINUS_ONE = null;
    public static final BigFraction ONE = null;
    public static final BigFraction ONE_FIFTH = null;
    public static final BigFraction ONE_HALF = null;
    private static final BigInteger ONE_HUNDRED = null;
    public static final BigFraction ONE_QUARTER = null;
    public static final BigFraction ONE_THIRD = null;
    public static final BigFraction THREE_FIFTHS = null;
    public static final BigFraction THREE_QUARTERS = null;
    public static final BigFraction TWO = null;
    public static final BigFraction TWO_FIFTHS = null;
    public static final BigFraction TWO_QUARTERS = null;
    public static final BigFraction TWO_THIRDS = null;
    public static final BigFraction ZERO = null;
    private static final long serialVersionUID = -5630213147331578515L;
    private final BigInteger denominator;
    private final BigInteger numerator;

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction add(BigFraction r1) throws NullArgumentException {
        return add2(r1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BigFraction r1) {
        return compareTo2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction divide(BigFraction r1) throws NullArgumentException, MathArithmeticException {
        return divide2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Field<BigFraction> getField() {
        return getField2();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction multiply(int r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction multiply(BigFraction r1) throws NullArgumentException {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction negate() {
        return negate2();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction reciprocal() throws MathArithmeticException {
        return reciprocal2();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ BigFraction subtract(BigFraction r1) throws NullArgumentException {
        return subtract2(r1);
    }

    static {
        TWO = new BigFraction(2);
        ONE = new BigFraction(1);
        ZERO = new BigFraction(0);
        MINUS_ONE = new BigFraction(-1);
        FOUR_FIFTHS = new BigFraction(4, 5);
        ONE_FIFTH = new BigFraction(1, 5);
        ONE_HALF = new BigFraction(1, 2);
        ONE_QUARTER = new BigFraction(1, 4);
        ONE_THIRD = new BigFraction(1, 3);
        THREE_FIFTHS = new BigFraction(3, 5);
        THREE_QUARTERS = new BigFraction(3, 4);
        TWO_FIFTHS = new BigFraction(2, 5);
        TWO_QUARTERS = new BigFraction(2, 4);
        TWO_THIRDS = new BigFraction(2, 3);
        ONE_HUNDRED = BigInteger.valueOf(100);
    }

    public BigFraction(BigInteger r2) {
        this(r2, BigInteger.ONE);
    }

    public BigFraction(BigInteger r4, BigInteger r5) {
        MathUtils.checkNotNull(r4, LocalizedFormats.NUMERATOR, new Object[0]);
        MathUtils.checkNotNull(r5, LocalizedFormats.DENOMINATOR, new Object[0]);
        if (r5.signum() == 0) goto L16;
        if (r4.signum() != 0) goto L7;
        this.numerator = BigInteger.ZERO;
        this.denominator = BigInteger.ONE;
        return;
    L7:
        BigInteger r0 = r4.gcd(r5);
        if (BigInteger.ONE.compareTo(r0) >= 0) goto L11;
        r4 = r4.divide(r0);
        r5 = r5.divide(r0);
    L11:
        if (r5.signum() != (-1)) goto L13;
        r4 = r4.negate();
        r5 = r5.negate();
    L13:
        this.numerator = r4;
        this.denominator = r5;
        return;
    L16:
        throw new ZeroException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public BigFraction(double r9) throws MathIllegalArgumentException {
        if (Double.isNaN(r9) == true) goto L25;
        if (Double.isInfinite(r9) == true) goto L23;
        long r10 = Double.doubleToLongBits(r9);
        long r0 = Long.MIN_VALUE & r10;
        long r2 = 9218868437227405312L & r10;
        long r11 = r10 & 4503599627370495L;
        if (r2 == 0) goto L10;
        r11 = r11 | 4503599627370496L;
    L10:
        if (r0 == 0) goto L12;
        r11 = -r11;
    L12:
        int r1 = ((int) (r2 >> 52)) - 1075;
    L14:
        if ((9007199254740990L & r11) == 0) goto L18;
        if ((1 & r11) != 0) goto L18;
        r11 = r11 >> 1;
        r1 = r1 + 1;
    L18:
        if (r1 >= 0) goto L20;
        this.numerator = BigInteger.valueOf(r11);
        this.denominator = BigInteger.ZERO.flipBit(-r1);
        return;
    L20:
        this.numerator = BigInteger.valueOf(r11).multiply(BigInteger.ZERO.flipBit(r1));
        this.denominator = BigInteger.ONE;
        return;
    L23:
        throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_VALUE_CONVERSION, new Object[0]);
    L25:
        throw new MathIllegalArgumentException(LocalizedFormats.NAN_VALUE_CONVERSION, new Object[0]);
    }

    public BigFraction(double r8, double r10, int r12) throws FractionConversionException {
        this(r8, r10, Integer.MAX_VALUE, r12);
    }

    private BigFraction(double r36, double r38, int r40, int r41) throws FractionConversionException {
        long r5 = (long) FastMath.floor(r36);
        if (FastMath.abs(r5) > 2147483647L) goto L40;
        if (FastMath.abs(r5 - r36) >= r38) goto L8;
        this.numerator = BigInteger.valueOf(r5);
        this.denominator = BigInteger.ONE;
        return;
    L8:
        double r19 = r36;
        long r15 = 1;
        long r17 = 0;
        long r13 = 1;
        int r11 = 0;
        boolean r12 = false;
        long r7 = r5;
    L9:
        r11 = r11 + 1;
        double r24 = 1.0d / (r19 - r5);
        long r9 = (long) FastMath.floor(r24);
        long r28 = r5;
        long r6 = (r9 * r7) + r13;
        long r30 = r7;
        long r8 = (r9 * r15) + r17;
        if (r6 > 2147483647L) goto L26;
        if (r8 > 2147483647L) goto L26;
        long r26 = r9;
        boolean r32 = r12;
        long r33 = r13;
        double r10 = r6 / r8;
        if (r11 < r41) goto L17;
    L21:
        r12 = true;
        r26 = r28;
        r13 = r33;
    L22:
        if (r12 == true) goto L29;
        r5 = r26;
        r7 = r30;
    L29:
        if (r11 >= r41) goto L36;
        if (r8 >= r40) goto L33;
        this.numerator = BigInteger.valueOf(r6);
        this.denominator = BigInteger.valueOf(r8);
        return;
    L33:
        this.numerator = BigInteger.valueOf(r30);
        this.denominator = BigInteger.valueOf(r15);
        return;
    L36:
        throw new FractionConversionException(r36, r41);
    L17:
        if (FastMath.abs(r10 - r36) <= r38) goto L21;
        if (r8 >= r40) goto L21;
        r17 = r15;
        r19 = r24;
        r13 = r30;
        r12 = r32;
        r30 = r6;
        r15 = r8;
    L26:
        if (r38 != 0.0d) goto L38;
        if (FastMath.abs(r15) < r40) goto L29;
    L38:
        throw new FractionConversionException(r36, r6, r8);
    L40:
        throw new FractionConversionException(r36, r5, 1);
    }

    public BigFraction(double r8, int r10) throws FractionConversionException {
        this(r8, 0.0d, r10, 100);
    }

    public BigFraction(int r3) {
        this(BigInteger.valueOf(r3), BigInteger.ONE);
    }

    public BigFraction(int r3, int r4) {
        this(BigInteger.valueOf(r3), BigInteger.valueOf(r4));
    }

    public BigFraction(long r1) {
        this(BigInteger.valueOf(r1), BigInteger.ONE);
    }

    public BigFraction(long r1, long r3) {
        this(BigInteger.valueOf(r1), BigInteger.valueOf(r3));
    }

    public static BigFraction getReducedFraction(int r1, int r2) {
        if (r1 != 0) goto L6;
        return ZERO;
    L6:
        return new BigFraction(r1, r2);
    }

    public BigFraction abs() {
        if (this.numerator.signum() != 1) goto L6;
        return this;
    L6:
        return negate2();
    }

    public BigFraction add(BigInteger r4) throws NullArgumentException {
        MathUtils.checkNotNull(r4);
        if (this.numerator.signum() != 0) goto L7;
        return new BigFraction(r4);
    L7:
        if (r4.signum() != 0) goto L10;
        return this;
    L10:
        return new BigFraction(this.numerator.add(this.denominator.multiply(r4)), this.denominator);
    }

    public BigFraction add(int r3) {
        return add(BigInteger.valueOf(r3));
    }

    public BigFraction add(long r1) {
        return add(BigInteger.valueOf(r1));
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public BigFraction add2(BigFraction r4) {
        if (r4 == null) goto L20;
        if (r4.numerator.signum() != 0) goto L7;
        return this;
    L7:
        if (this.numerator.signum() != 0) goto L10;
        return r4;
    L10:
        if (this.denominator.equals(r4.denominator) == false) goto L12;
        BigInteger r5 = this.numerator.add(r4.numerator);
        BigInteger r3 = this.denominator;
    L14:
        if (r5.signum() != 0) goto L18;
        return ZERO;
    L18:
        return new BigFraction(r5, r3);
    L12:
        BigInteger r0 = this.numerator.multiply(r4.denominator).add(r4.numerator.multiply(this.denominator));
        r3 = this.denominator.multiply(r4.denominator);
        r5 = r0;
        goto L14
    L20:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public BigDecimal bigDecimalValue() {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator));
    }

    public BigDecimal bigDecimalValue(int r3) {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), r3);
    }

    public BigDecimal bigDecimalValue(int r3, int r4) {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), r3, r4);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BigFraction r3) {
        int r0 = this.numerator.signum();
        int r1 = r3.numerator.signum();
        if (r0 == r1) goto L8;
        if (r0 <= r1) goto L6;
        return 1;
    L6:
        return -1;
    L8:
        if (r0 != 0) goto L12;
        return 0;
    L12:
        return this.numerator.multiply(r3.denominator).compareTo(this.denominator.multiply(r3.numerator));
    }

    public BigFraction divide(BigInteger r3) {
        if (r3 == null) goto L15;
        if (r3.signum() == 0) goto L13;
        if (this.numerator.signum() != 0) goto L11;
        return ZERO;
    L11:
        return new BigFraction(this.numerator, this.denominator.multiply(r3));
    L13:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    L15:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public BigFraction divide(int r3) {
        return divide(BigInteger.valueOf(r3));
    }

    public BigFraction divide(long r1) {
        return divide(BigInteger.valueOf(r1));
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public BigFraction divide2(BigFraction r3) {
        if (r3 == null) goto L15;
        if (r3.numerator.signum() == 0) goto L13;
        if (this.numerator.signum() != 0) goto L11;
        return ZERO;
    L11:
        return multiply2(r3.reciprocal2());
    L13:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    L15:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        double r0 = this.numerator.doubleValue() / this.denominator.doubleValue();
        if (Double.isNaN(r0) == false) goto L6;
        int r1 = FastMath.max(this.numerator.bitLength(), this.denominator.bitLength()) - FastMath.getExponent(Double.MAX_VALUE);
        return this.numerator.shiftRight(r1).doubleValue() / this.denominator.shiftRight(r1).doubleValue();
    L6:
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BigFraction) == false) goto L13;
        BigFraction r6 = ((BigFraction) r5).reduce();
        BigFraction r4 = reduce();
        if (r4.numerator.equals(r6.numerator) == false) goto L13;
        if (r4.denominator.equals(r6.denominator) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        float r0 = this.numerator.floatValue() / this.denominator.floatValue();
        if (Double.isNaN(r0) == false) goto L6;
        int r1 = FastMath.max(this.numerator.bitLength(), this.denominator.bitLength()) - FastMath.getExponent(Float.MAX_VALUE);
        return this.numerator.shiftRight(r1).floatValue() / this.denominator.shiftRight(r1).floatValue();
    L6:
        return r0;
    }

    public BigInteger getDenominator() {
        return this.denominator;
    }

    public int getDenominatorAsInt() {
        return this.denominator.intValue();
    }

    public long getDenominatorAsLong() {
        return this.denominator.longValue();
    }

    public BigInteger getNumerator() {
        return this.numerator;
    }

    public int getNumeratorAsInt() {
        return this.numerator.intValue();
    }

    public long getNumeratorAsLong() {
        return this.numerator.longValue();
    }

    public int hashCode() {
        return ((this.numerator.hashCode() + 629) * 37) + this.denominator.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator.divide(this.denominator).intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.numerator.divide(this.denominator).longValue();
    }

    public BigFraction multiply(BigInteger r3) {
        if (r3 == null) goto L13;
        if (this.numerator.signum() == 0) goto L11;
        if (r3.signum() == 0) goto L11;
        return new BigFraction(r3.multiply(this.numerator), this.denominator);
    L11:
        return ZERO;
    L13:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public BigFraction multiply2(int r3) {
        if (r3 == 0) goto L9;
        if (this.numerator.signum() == 0) goto L9;
        return multiply(BigInteger.valueOf(r3));
    L9:
        return ZERO;
    }

    public BigFraction multiply(long r3) {
        if (r3 == 0) goto L10;
        if (this.numerator.signum() == 0) goto L10;
        return multiply(BigInteger.valueOf(r3));
    L10:
        return ZERO;
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public BigFraction multiply2(BigFraction r4) {
        if (r4 == null) goto L13;
        if (this.numerator.signum() == 0) goto L11;
        if (r4.numerator.signum() == 0) goto L11;
        return new BigFraction(this.numerator.multiply(r4.numerator), this.denominator.multiply(r4.denominator));
    L11:
        return ZERO;
    L13:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: negate, reason: avoid collision after fix types in other method */
    public BigFraction negate2() {
        return new BigFraction(this.numerator.negate(), this.denominator);
    }

    public double percentageValue() {
        return multiply(ONE_HUNDRED).doubleValue();
    }

    public BigFraction pow(int r3) {
        if (r3 != 0) goto L6;
        return ONE;
    L6:
        if (this.numerator.signum() != 0) goto L8;
        return this;
    L8:
        if (r3 >= 0) goto L12;
        int r4 = -r3;
        return new BigFraction(this.denominator.pow(r4), this.numerator.pow(r4));
    L12:
        return new BigFraction(this.numerator.pow(r3), this.denominator.pow(r3));
    }

    public BigFraction pow(long r3) {
        if (r3 != 0) goto L7;
        return ONE;
    L7:
        if (this.numerator.signum() != 0) goto L9;
        return this;
    L9:
        if (r3 >= 0) goto L13;
        long r4 = -r3;
        return new BigFraction(ArithmeticUtils.pow(this.denominator, r4), ArithmeticUtils.pow(this.numerator, r4));
    L13:
        return new BigFraction(ArithmeticUtils.pow(this.numerator, r3), ArithmeticUtils.pow(this.denominator, r3));
    }

    public BigFraction pow(BigInteger r3) {
        if (r3.signum() != 0) goto L7;
        return ONE;
    L7:
        if (this.numerator.signum() != 0) goto L10;
        return this;
    L10:
        if (r3.signum() != (-1)) goto L14;
        BigInteger r4 = r3.negate();
        return new BigFraction(ArithmeticUtils.pow(this.denominator, r4), ArithmeticUtils.pow(this.numerator, r4));
    L14:
        return new BigFraction(ArithmeticUtils.pow(this.numerator, r3), ArithmeticUtils.pow(this.denominator, r3));
    }

    public double pow(double r5) {
        return FastMath.pow(this.numerator.doubleValue(), r5) / FastMath.pow(this.denominator.doubleValue(), r5);
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: reciprocal, reason: avoid collision after fix types in other method */
    public BigFraction reciprocal2() {
        return new BigFraction(this.denominator, this.numerator);
    }

    public BigFraction reduce() {
        BigInteger r0 = this.numerator.gcd(this.denominator);
        if (BigInteger.ONE.compareTo(r0) < 0) goto L5;
        return this;
    L5:
        return new BigFraction(this.numerator.divide(r0), this.denominator.divide(r0));
    }

    public BigFraction subtract(BigInteger r4) {
        if (r4 == null) goto L13;
        if (r4.signum() != 0) goto L7;
        return this;
    L7:
        if (this.numerator.signum() != 0) goto L11;
        return new BigFraction(r4.negate());
    L11:
        return new BigFraction(this.numerator.subtract(this.denominator.multiply(r4)), this.denominator);
    L13:
        throw new NullArgumentException();
    }

    public BigFraction subtract(int r3) {
        return subtract(BigInteger.valueOf(r3));
    }

    public BigFraction subtract(long r1) {
        return subtract(BigInteger.valueOf(r1));
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public BigFraction subtract2(BigFraction r4) {
        if (r4 == null) goto L17;
        if (r4.numerator.signum() != 0) goto L7;
        return this;
    L7:
        if (this.numerator.signum() != 0) goto L11;
        return r4.negate2();
    L11:
        if (this.denominator.equals(r4.denominator) == false) goto L13;
        BigInteger r5 = this.numerator.subtract(r4.numerator);
        BigInteger r3 = this.denominator;
    L15:
        return new BigFraction(r5, r3);
    L13:
        BigInteger r0 = this.numerator.multiply(r4.denominator).subtract(r4.numerator.multiply(this.denominator));
        r3 = this.denominator.multiply(r4.denominator);
        r5 = r0;
        goto L15
    L17:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public String toString() {
        if (BigInteger.ONE.equals(this.denominator) == false) goto L6;
        return this.numerator.toString();
    L6:
        if (BigInteger.ZERO.equals(this.numerator) == false) goto L9;
        return "0";
    L9:
        return this.numerator + " / " + this.denominator;
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: getField, reason: avoid collision after fix types in other method */
    public Field<BigFraction> getField2() {
        return BigFractionField.getInstance();
    }
}
