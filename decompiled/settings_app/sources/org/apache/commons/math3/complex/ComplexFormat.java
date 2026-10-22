package org.apache.commons.math3.complex;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class ComplexFormat {
    private static final String DEFAULT_IMAGINARY_CHARACTER = "i";
    private final String imaginaryCharacter;
    private final NumberFormat imaginaryFormat;
    private final NumberFormat realFormat;

    public ComplexFormat() {
        this.imaginaryCharacter = DEFAULT_IMAGINARY_CHARACTER;
        NumberFormat r0 = CompositeFormat.getDefaultNumberFormat();
        this.imaginaryFormat = r0;
        this.realFormat = r0;
    }

    public ComplexFormat(NumberFormat r2) throws NullArgumentException {
        if (r2 == null) goto L7;
        this.imaginaryCharacter = DEFAULT_IMAGINARY_CHARACTER;
        this.imaginaryFormat = r2;
        this.realFormat = r2;
        return;
    L7:
        throw new NullArgumentException(LocalizedFormats.IMAGINARY_FORMAT, new Object[0]);
    }

    public ComplexFormat(NumberFormat r2, NumberFormat r3) throws NullArgumentException {
        if (r3 == null) goto L10;
        if (r2 == null) goto L8;
        this.imaginaryCharacter = DEFAULT_IMAGINARY_CHARACTER;
        this.imaginaryFormat = r3;
        this.realFormat = r2;
        return;
    L8:
        throw new NullArgumentException(LocalizedFormats.REAL_FORMAT, new Object[0]);
    L10:
        throw new NullArgumentException(LocalizedFormats.IMAGINARY_FORMAT, new Object[0]);
    }

    public ComplexFormat(String r2) throws NullArgumentException, NoDataException {
        this(r2, CompositeFormat.getDefaultNumberFormat());
    }

    public ComplexFormat(String r1, NumberFormat r2) throws NullArgumentException, NoDataException {
        this(r1, r2, r2);
    }

    public ComplexFormat(String r2, NumberFormat r3, NumberFormat r4) throws NullArgumentException, NoDataException {
        if (r2 == null) goto L18;
        if (r2.length() == 0) goto L16;
        if (r4 == null) goto L14;
        if (r3 == null) goto L12;
        this.imaginaryCharacter = r2;
        this.imaginaryFormat = r4;
        this.realFormat = r3;
        return;
    L12:
        throw new NullArgumentException(LocalizedFormats.REAL_FORMAT, new Object[0]);
    L14:
        throw new NullArgumentException(LocalizedFormats.IMAGINARY_FORMAT, new Object[0]);
    L16:
        throw new NoDataException();
    L18:
        throw new NullArgumentException();
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public String format(Complex r4) {
        return format(r4, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public String format(Double r6) {
        return format(new Complex(r6.doubleValue(), 0.0d), new StringBuffer(), new FieldPosition(0)).toString();
    }

    public StringBuffer format(Complex r5, StringBuffer r6, FieldPosition r7) {
        r7.setBeginIndex(0);
        r7.setEndIndex(0);
        CompositeFormat.formatDouble(r5.getReal(), getRealFormat(), r6, r7);
        double r0 = r5.getImaginary();
        if (r0 >= 0.0d) goto L6;
        r6.append(" - ");
        r6.append(formatImaginary(-r0, new StringBuffer(), r7));
        r6.append(getImaginaryCharacter());
    L10:
        return r6;
    L6:
        if (r0 <= 0.0d) goto L8;
    L9:
        r6.append(" + ");
        r6.append(formatImaginary(r0, new StringBuffer(), r7));
        r6.append(getImaginaryCharacter());
        goto L10
    L8:
        if (Double.isNaN(r0) == false) goto L10;
        goto L9
    }

    private StringBuffer formatImaginary(double r2, StringBuffer r4, FieldPosition r5) {
        r5.setBeginIndex(0);
        r5.setEndIndex(0);
        CompositeFormat.formatDouble(r2, getImaginaryFormat(), r4, r5);
        if (r4.toString().equals("1") == false) goto L5;
        r4.setLength(0);
    L5:
        return r4;
    }

    public StringBuffer format(Object r6, StringBuffer r7, FieldPosition r8) throws MathIllegalArgumentException {
        if ((r6 instanceof Complex) == false) goto L6;
        return format((Complex) r6, r7, r8);
    L6:
        if ((r6 instanceof Number) == false) goto L10;
        return format(new Complex(((Number) r6).doubleValue(), 0.0d), r7, r8);
    L10:
        throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_INSTANCE_AS_COMPLEX, new Object[]{r6.getClass().getName()});
    }

    public String getImaginaryCharacter() {
        return this.imaginaryCharacter;
    }

    public NumberFormat getImaginaryFormat() {
        return this.imaginaryFormat;
    }

    public static ComplexFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static ComplexFormat getInstance(Locale r1) {
        return new ComplexFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    public static ComplexFormat getInstance(String r1, Locale r2) throws NullArgumentException, NoDataException {
        return new ComplexFormat(r1, CompositeFormat.getDefaultNumberFormat(r2));
    }

    public NumberFormat getRealFormat() {
        return this.realFormat;
    }

    public Complex parse(String r3) throws MathParseException {
        ParsePosition r0 = new ParsePosition(0);
        Complex r2 = parse(r3, r0);
        if (r0.getIndex() == 0) goto L6;
        return r2;
    L6:
        throw new MathParseException(r3, r0.getErrorIndex(), Complex.class);
    }

    public Complex parse(String r7, ParsePosition r8) {
        int r0 = r8.getIndex();
        CompositeFormat.parseAndIgnoreWhitespace(r7, r8);
        Number r1 = CompositeFormat.parseNumber(r7, getRealFormat(), r8);
        if (r1 != null) goto L6;
        r8.setIndex(r0);
        return null;
    L6:
        int r3 = r8.getIndex();
        char r4 = CompositeFormat.parseNextCharacter(r7, r8);
        if (r4 == 0) goto L26;
        if (r4 != '+') goto L11;
        int r5 = 1;
    L16:
        CompositeFormat.parseAndIgnoreWhitespace(r7, r8);
        Number r6 = CompositeFormat.parseNumber(r7, getRealFormat(), r8);
        if (r6 != null) goto L21;
        r8.setIndex(r0);
        return null;
    L21:
        if (CompositeFormat.parseFixedstring(r7, getImaginaryCharacter(), r8) == true) goto L24;
        return null;
    L24:
        return new Complex(r1.doubleValue(), r6.doubleValue() * ((double) r5));
    L11:
        if (r4 == '-') goto L14;
        r8.setIndex(r0);
        r8.setErrorIndex(r3);
        return null;
    L14:
        r5 = -1;
        goto L16
    L26:
        return new Complex(r1.doubleValue(), 0.0d);
    }
}
