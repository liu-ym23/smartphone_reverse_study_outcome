package org.apache.commons.math3.geometry;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public abstract class VectorFormat<S extends Space> {
    public static final String DEFAULT_PREFIX = "{";
    public static final String DEFAULT_SEPARATOR = "; ";
    public static final String DEFAULT_SUFFIX = "}";
    private final NumberFormat format;
    private final String prefix;
    private final String separator;
    private final String suffix;
    private final String trimmedPrefix;
    private final String trimmedSeparator;
    private final String trimmedSuffix;

    public abstract StringBuffer format(Vector<S> r1, StringBuffer r2, FieldPosition r3);

    public abstract Vector<S> parse(String r1) throws MathParseException;

    public abstract Vector<S> parse(String r1, ParsePosition r2);

    protected VectorFormat() {
        this(DEFAULT_PREFIX, DEFAULT_SUFFIX, DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
    }

    protected VectorFormat(NumberFormat r4) {
        this(DEFAULT_PREFIX, DEFAULT_SUFFIX, DEFAULT_SEPARATOR, r4);
    }

    protected VectorFormat(String r2, String r3, String r4) {
        this(r2, r3, r4, CompositeFormat.getDefaultNumberFormat());
    }

    protected VectorFormat(String r1, String r2, String r3, NumberFormat r4) {
        this.prefix = r1;
        this.suffix = r2;
        this.separator = r3;
        this.trimmedPrefix = r1.trim();
        this.trimmedSuffix = r2.trim();
        this.trimmedSeparator = r3.trim();
        this.format = r4;
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public String getSeparator() {
        return this.separator;
    }

    public NumberFormat getFormat() {
        return this.format;
    }

    public String format(Vector<S> r4) {
        return format(r4, new StringBuffer(), new FieldPosition(0)).toString();
    }

    protected StringBuffer format(StringBuffer r5, FieldPosition r6, double... r7) {
        int r0 = 0;
        r6.setBeginIndex(0);
        r6.setEndIndex(0);
        r5.append(this.prefix);
    L4:
        if (r0 >= r7.length) goto L8;
        if (r0 <= 0) goto L7;
        r5.append(this.separator);
    L7:
        CompositeFormat.formatDouble(r7[r0], this.format, r5, r6);
        r0 = r0 + 1;
        goto L4
    L8:
        r5.append(this.suffix);
        return r5;
    }

    protected double[] parseCoordinates(int r7, String r8, ParsePosition r9) {
        int r0 = r9.getIndex();
        double[] r1 = new double[r7];
        CompositeFormat.parseAndIgnoreWhitespace(r8, r9);
        if (CompositeFormat.parseFixedstring(r8, this.trimmedPrefix, r9) == true) goto L5;
        return null;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r7) goto L17;
        CompositeFormat.parseAndIgnoreWhitespace(r8, r9);
        if (r2 > 0) goto L10;
    L12:
        CompositeFormat.parseAndIgnoreWhitespace(r8, r9);
        Number r4 = CompositeFormat.parseNumber(r8, this.format, r9);
        if (r4 == null) goto L14;
        r1[r2] = r4.doubleValue();
        r2 = r2 + 1;
        goto L6
    L14:
        r9.setIndex(r0);
        return null;
    L10:
        if (CompositeFormat.parseFixedstring(r8, this.trimmedSeparator, r9) == true) goto L12;
        return null;
    L17:
        CompositeFormat.parseAndIgnoreWhitespace(r8, r9);
        if (CompositeFormat.parseFixedstring(r8, this.trimmedSuffix, r9) == true) goto L20;
        return null;
    L20:
        return r1;
    }
}
