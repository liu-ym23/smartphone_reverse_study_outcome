package org.apache.commons.math3.fraction;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class BigFractionFormat extends AbstractFormat implements Serializable {
    private static final long serialVersionUID = -2932167925527338976L;

    @Override // java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1) throws ParseException {
        return parse(r1);
    }

    @Override // java.text.NumberFormat
    public /* bridge */ /* synthetic */ Number parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    public BigFractionFormat() {
    }

    public BigFractionFormat(NumberFormat r1) {
        super(r1);
    }

    public BigFractionFormat(NumberFormat r1, NumberFormat r2) {
        super(r1, r2);
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public static String formatBigFraction(BigFraction r1) {
        return getImproperInstance().format(r1);
    }

    public static BigFractionFormat getImproperInstance() {
        return getImproperInstance(Locale.getDefault());
    }

    public static BigFractionFormat getImproperInstance(Locale r1) {
        return new BigFractionFormat(getDefaultNumberFormat(r1));
    }

    public static BigFractionFormat getProperInstance() {
        return getProperInstance(Locale.getDefault());
    }

    public static BigFractionFormat getProperInstance(Locale r1) {
        return new ProperBigFractionFormat(getDefaultNumberFormat(r1));
    }

    public StringBuffer format(BigFraction r3, StringBuffer r4, FieldPosition r5) {
        r5.setBeginIndex(0);
        r5.setEndIndex(0);
        getNumeratorFormat().format(r3.getNumerator(), r4, r5);
        r4.append(" / ");
        getDenominatorFormat().format(r3.getDenominator(), r4, r5);
        return r4;
    }

    @Override // java.text.NumberFormat, java.text.Format
    public StringBuffer format(Object r4, StringBuffer r5, FieldPosition r6) {
        if ((r4 instanceof BigFraction) == false) goto L6;
        return format((BigFraction) r4, r5, r6);
    L6:
        if ((r4 instanceof BigInteger) == false) goto L9;
        return format(new BigFraction((BigInteger) r4), r5, r6);
    L9:
        if ((r4 instanceof Number) == false) goto L13;
        return format(new BigFraction(((Number) r4).doubleValue()), r5, r6);
    L13:
        throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION, new Object[0]);
    }

    @Override // java.text.NumberFormat
    public BigFraction parse(String r3) throws MathParseException {
        ParsePosition r0 = new ParsePosition(0);
        BigFraction r2 = parse(r3, r0);
        if (r0.getIndex() == 0) goto L6;
        return r2;
    L6:
        throw new MathParseException(r3, r0.getErrorIndex(), BigFraction.class);
    }

    @Override // java.text.NumberFormat
    public BigFraction parse(String r7, ParsePosition r8) {
        int r0 = r8.getIndex();
        parseAndIgnoreWhitespace(r7, r8);
        BigInteger r1 = parseNextBigInteger(r7, r8);
        if (r1 != null) goto L6;
        r8.setIndex(r0);
        return null;
    L6:
        int r3 = r8.getIndex();
        char r4 = parseNextCharacter(r7, r8);
        if (r4 == 0) goto L19;
        if (r4 == '/') goto L12;
        r8.setIndex(r0);
        r8.setErrorIndex(r3);
        return null;
    L12:
        parseAndIgnoreWhitespace(r7, r8);
        BigInteger r6 = parseNextBigInteger(r7, r8);
        if (r6 != null) goto L17;
        r8.setIndex(r0);
        return null;
    L17:
        return new BigFraction(r1, r6);
    L19:
        return new BigFraction(r1);
    }

    protected BigInteger parseNextBigInteger(String r3, ParsePosition r4) {
        int r2 = r4.getIndex();
        if (r3.charAt(r2) != '-') goto L5;
        int r0 = r2 + 1;
    L7:
        if (r0 < r3.length()) goto L9;
    L15:
        BigInteger r1 = new BigInteger(r3.substring(r2, r0));     // Catch: NumberFormatException -> L13
        r4.setIndex(r0);     // Catch: NumberFormatException -> L13
        return r1;
    L13:
        r4.setErrorIndex(r2);
        return null;
    L9:
        if (Character.isDigit(r3.charAt(r0)) == false) goto L15;
        r0 = r0 + 1;
        goto L7
    L5:
        r0 = r2;
        goto L7
    }
}
