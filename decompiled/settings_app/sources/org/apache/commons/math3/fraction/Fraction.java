package org.apache.commons.math3.fraction;

import java.io.Serializable;
import java.math.BigInteger;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Fraction extends Number implements FieldElement<Fraction>, Comparable<Fraction>, Serializable {
    private static final double DEFAULT_EPSILON = 1.0E-5d;
    public static final Fraction FOUR_FIFTHS = null;
    public static final Fraction MINUS_ONE = null;
    public static final Fraction ONE = null;
    public static final Fraction ONE_FIFTH = null;
    public static final Fraction ONE_HALF = null;
    public static final Fraction ONE_QUARTER = null;
    public static final Fraction ONE_THIRD = null;
    public static final Fraction THREE_FIFTHS = null;
    public static final Fraction THREE_QUARTERS = null;
    public static final Fraction TWO = null;
    public static final Fraction TWO_FIFTHS = null;
    public static final Fraction TWO_QUARTERS = null;
    public static final Fraction TWO_THIRDS = null;
    public static final Fraction ZERO = null;
    private static final long serialVersionUID = 3698073679419233275L;
    private final int denominator;
    private final int numerator;

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Fraction add(Fraction r1) throws NullArgumentException {
        return add2(r1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Fraction r1) {
        return compareTo2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Fraction divide(Fraction r1) throws NullArgumentException, MathArithmeticException {
        return divide2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Field<Fraction> getField() {
        return getField2();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Fraction multiply(int r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Fraction multiply(Fraction r1) throws NullArgumentException {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Fraction negate() {
        return negate2();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Fraction reciprocal() throws MathArithmeticException {
        return reciprocal2();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Fraction subtract(Fraction r1) throws NullArgumentException {
        return subtract2(r1);
    }

    static {
        TWO = new Fraction(2, 1);
        ONE = new Fraction(1, 1);
        ZERO = new Fraction(0, 1);
        FOUR_FIFTHS = new Fraction(4, 5);
        ONE_FIFTH = new Fraction(1, 5);
        ONE_HALF = new Fraction(1, 2);
        ONE_QUARTER = new Fraction(1, 4);
        ONE_THIRD = new Fraction(1, 3);
        THREE_FIFTHS = new Fraction(3, 5);
        THREE_QUARTERS = new Fraction(3, 4);
        TWO_FIFTHS = new Fraction(2, 5);
        TWO_QUARTERS = new Fraction(2, 4);
        TWO_THIRDS = new Fraction(2, 3);
        MINUS_ONE = new Fraction(-1, 1);
    }

    public Fraction(double r7) throws FractionConversionException {
        this(r7, 1.0E-5d, 100);
    }

    public Fraction(double r8, double r10, int r12) throws FractionConversionException {
        this(r8, r10, Integer.MAX_VALUE, r12);
    }

    public Fraction(double r8, int r10) throws FractionConversionException {
        this(r8, 0.0d, r10, 100);
    }

    private Fraction(double r34, double r36, int r38, int r39) throws FractionConversionException {
        long r5 = (long) FastMath.floor(r34);
        if (FastMath.abs(r5) > 2147483647L) goto L41;
        int r8 = 1;
        if (FastMath.abs(r5 - r34) >= r36) goto L8;
        this.numerator = (int) r5;
        this.denominator = 1;
        return;
    L8:
        int r7 = 0;
        double r20 = r34;
        long r16 = 1;
        long r18 = 0;
        boolean r13 = false;
        long r14 = 1;
        long r11 = r5;
    L9:
        r7 = r7 + r8;
        double r24 = 1.0d / (r20 - r5);
        long r9 = (long) FastMath.floor(r24);
        long r28 = r5;
        long r6 = (r9 * r11) + r14;
        long r10 = (r9 * r16) + r18;
        if (FastMath.abs(r6) > 2147483647L) goto L25;
        if (FastMath.abs(r10) > 2147483647L) goto L25;
        long r26 = r11;
        boolean r32 = r13;
        double r12 = r6 / r10;
        if (r7 < r39) goto L17;
    L21:
        r11 = r26;
        r13 = true;
    L22:
        if (r13 == true) goto L23;
        r5 = r28;
        r8 = 1;
        goto L9
    L23:
        long r15 = r16;
    L30:
        if (r7 >= r39) goto L37;
        if (r10 >= r38) goto L34;
        this.numerator = (int) r6;
        this.denominator = (int) r10;
        return;
    L34:
        this.numerator = (int) r11;
        this.denominator = (int) r15;
        return;
    L37:
        throw new FractionConversionException(r34, r39);
    L17:
        if (FastMath.abs(r12 - r34) <= r36) goto L21;
        if (r10 >= r38) goto L21;
        r11 = r6;
        r18 = r16;
        r20 = r24;
        r14 = r26;
        r28 = r9;
        r13 = r32;
        r16 = r10;
    L25:
        long r27 = r11;
        if (r36 != 0.0d) goto L39;
        if (FastMath.abs(r16) >= r38) goto L39;
        r15 = r16;
        r11 = r27;
    L39:
        throw new FractionConversionException(r34, r6, r10);
    L41:
        throw new FractionConversionException(r34, r5, 1);
    }

    public Fraction(int r2) {
        this(r2, 1);
    }

    public Fraction(int r5, int r6) {
        if (r6 == 0) goto L19;
        if (r6 < 0) goto L6;
    L11:
        int r0 = ArithmeticUtils.gcd(r5, r6);
        if (r0 <= 1) goto L14;
        r5 = r5 / r0;
        r6 = r6 / r0;
    L14:
        if (r6 >= 0) goto L16;
        r5 = -r5;
        r6 = -r6;
    L16:
        this.numerator = r5;
        this.denominator = r6;
        return;
    L6:
        if (r5 == Integer.MIN_VALUE) goto L10;
        if (r6 == Integer.MIN_VALUE) goto L10;
        r5 = -r5;
        r6 = -r6;
    L10:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6)});
    L19:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR_IN_FRACTION, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6)});
    }

    public Fraction abs() {
        if (this.numerator < 0) goto L6;
        return this;
    L6:
        return negate2();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Fraction r5) {
        long r0 = ((long) this.numerator) * ((long) r5.denominator);
        long r2 = ((long) this.denominator) * ((long) r5.numerator);
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 <= r2) goto L7;
        return 1;
    L7:
        return 0;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Fraction) == false) goto L14;
        Fraction r6 = (Fraction) r5;
        if (this.numerator != r6.numerator) goto L13;
        if (this.denominator != r6.denominator) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int hashCode() {
        return ((this.numerator + 629) * 37) + this.denominator;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: negate, reason: avoid collision after fix types in other method */
    public Fraction negate2() {
        int r0 = this.numerator;
        if (r0 == Integer.MIN_VALUE) goto L7;
        return new Fraction(-r0, this.denominator);
    L7:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, new Object[]{Integer.valueOf(this.numerator), Integer.valueOf(this.denominator)});
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: reciprocal, reason: avoid collision after fix types in other method */
    public Fraction reciprocal2() {
        return new Fraction(this.denominator, this.numerator);
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public Fraction add2(Fraction r2) {
        return addSub(r2, true);
    }

    public Fraction add(int r3) {
        int r1 = this.numerator;
        int r2 = this.denominator;
        return new Fraction(r1 + (r3 * r2), r2);
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public Fraction subtract2(Fraction r2) {
        return addSub(r2, false);
    }

    public Fraction subtract(int r3) {
        int r1 = this.numerator;
        int r2 = this.denominator;
        return new Fraction(r1 - (r3 * r2), r2);
    }

    private Fraction addSub(Fraction r8, boolean r9) {
        if (r8 == null) goto L36;
        if (this.numerator != 0) goto L11;
        if (r9 == false) goto L9;
        return r8;
    L9:
        return r8.negate2();
    L11:
        if (r8.numerator != 0) goto L13;
        return this;
    L13:
        int r1 = ArithmeticUtils.gcd(this.denominator, r8.denominator);
        if (r1 != 1) goto L21;
        int r0 = ArithmeticUtils.mulAndCheck(this.numerator, r8.denominator);
        int r2 = ArithmeticUtils.mulAndCheck(r8.numerator, this.denominator);
        if (r9 == false) goto L18;
        int r10 = ArithmeticUtils.addAndCheck(r0, r2);
    L20:
        return new Fraction(r10, ArithmeticUtils.mulAndCheck(this.denominator, r8.denominator));
    L18:
        r10 = ArithmeticUtils.subAndCheck(r0, r2);
        goto L20
    L21:
        BigInteger r3 = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(r8.denominator / r1));
        BigInteger r4 = BigInteger.valueOf(r8.numerator).multiply(BigInteger.valueOf(this.denominator / r1));
        if (r9 == false) goto L24;
        BigInteger r11 = r3.add(r4);
    L25:
        int r5 = r11.mod(BigInteger.valueOf(r1)).intValue();
        if (r5 != 0) goto L28;
        int r6 = r1;
    L29:
        BigInteger r12 = r11.divide(BigInteger.valueOf(r6));
        if (r12.bitLength() > 31) goto L34;
        return new Fraction(r12.intValue(), ArithmeticUtils.mulAndCheck(this.denominator / r1, r8.denominator / r6));
    L34:
        throw new MathArithmeticException(LocalizedFormats.NUMERATOR_OVERFLOW_AFTER_MULTIPLY, new Object[]{r12});
    L28:
        r6 = ArithmeticUtils.gcd(r5, r1);
        goto L29
    L24:
        r11 = r3.subtract(r4);
        goto L25
    L36:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Fraction multiply2(Fraction r5) {
        if (r5 == null) goto L13;
        int r0 = this.numerator;
        if (r0 == 0) goto L11;
        if (r5.numerator == 0) goto L11;
        int r1 = ArithmeticUtils.gcd(r0, r5.denominator);
        int r2 = ArithmeticUtils.gcd(r5.numerator, this.denominator);
        return getReducedFraction(ArithmeticUtils.mulAndCheck(this.numerator / r1, r5.numerator / r2), ArithmeticUtils.mulAndCheck(this.denominator / r2, r5.denominator / r1));
    L11:
        return ZERO;
    L13:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Fraction multiply2(int r2) {
        return multiply2(new Fraction(r2));
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public Fraction divide2(Fraction r5) {
        if (r5 == null) goto L11;
        if (r5.numerator == 0) goto L9;
        return multiply2(r5.reciprocal2());
    L9:
        throw new MathArithmeticException(LocalizedFormats.ZERO_FRACTION_TO_DIVIDE_BY, new Object[]{Integer.valueOf(r5.numerator), Integer.valueOf(r5.denominator)});
    L11:
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public Fraction divide(int r2) {
        return divide2(new Fraction(r2));
    }

    public double percentageValue() {
        return doubleValue() * 100.0d;
    }

    public static Fraction getReducedFraction(int r5, int r6) {
        if (r6 == 0) goto L21;
        if (r5 != 0) goto L8;
        return ZERO;
    L8:
        if (r6 == Integer.MIN_VALUE) goto L10;
    L12:
        if (r6 >= 0) goto L18;
        if (r5 == Integer.MIN_VALUE) goto L17;
        if (r6 == Integer.MIN_VALUE) goto L17;
        r5 = -r5;
        r6 = -r6;
    L17:
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6)});
    L18:
        int r0 = ArithmeticUtils.gcd(r5, r6);
        return new Fraction(r5 / r0, r6 / r0);
    L10:
        if ((r5 & 1) != 0) goto L12;
        r5 = r5 / 2;
        r6 = r6 / 2;
        goto L12
    L21:
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR_IN_FRACTION, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6)});
    }

    public String toString() {
        if (this.denominator != 1) goto L6;
        return Integer.toString(this.numerator);
    L6:
        if (this.numerator != 0) goto L9;
        return "0";
    L9:
        return this.numerator + " / " + this.denominator;
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: getField, reason: avoid collision after fix types in other method */
    public Field<Fraction> getField2() {
        return FractionField.getInstance();
    }
}
