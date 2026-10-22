package org.apache.commons.math3.linear;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class RealVectorFormat {
    private static final String DEFAULT_PREFIX = "{";
    private static final String DEFAULT_SEPARATOR = "; ";
    private static final String DEFAULT_SUFFIX = "}";
    private final NumberFormat format;
    private final String prefix;
    private final String separator;
    private final String suffix;
    private final String trimmedPrefix;
    private final String trimmedSeparator;
    private final String trimmedSuffix;

    public RealVectorFormat() {
        this("{", "}", "; ", CompositeFormat.getDefaultNumberFormat());
    }

    public RealVectorFormat(NumberFormat r4) {
        this("{", "}", "; ", r4);
    }

    public RealVectorFormat(String r2, String r3, String r4) {
        this(r2, r3, r4, CompositeFormat.getDefaultNumberFormat());
    }

    public RealVectorFormat(String r1, String r2, String r3, NumberFormat r4) {
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

    public static RealVectorFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static RealVectorFormat getInstance(Locale r1) {
        return new RealVectorFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    public String format(RealVector r4) {
        return format(r4, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public StringBuffer format(RealVector r5, StringBuffer r6, FieldPosition r7) {
        int r0 = 0;
        r7.setBeginIndex(0);
        r7.setEndIndex(0);
        r6.append(this.prefix);
    L4:
        if (r0 >= r5.getDimension()) goto L8;
        if (r0 <= 0) goto L7;
        r6.append(this.separator);
    L7:
        CompositeFormat.formatDouble(r5.getEntry(r0), this.format, r6, r7);
        r0 = r0 + 1;
        goto L4
    L8:
        r6.append(this.suffix);
        return r6;
    }

    public ArrayRealVector parse(String r3) {
        ParsePosition r0 = new ParsePosition(0);
        ArrayRealVector r2 = parse(r3, r0);
        if (r0.getIndex() == 0) goto L6;
        return r2;
    L6:
        throw new MathParseException(r3, r0.getErrorIndex(), ArrayRealVector.class);
    }

    public ArrayRealVector parse(String r7, ParsePosition r8) {
        int r0 = r8.getIndex();
        CompositeFormat.parseAndIgnoreWhitespace(r7, r8);
        if (CompositeFormat.parseFixedstring(r7, this.trimmedPrefix, r8) == true) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        boolean r3 = true;
    L7:
        if (r3 == false) goto L19;
        if (r1.isEmpty() == true) goto L13;
        CompositeFormat.parseAndIgnoreWhitespace(r7, r8);
        if (CompositeFormat.parseFixedstring(r7, this.trimmedSeparator, r8) == true) goto L13;
        r3 = false;
    L13:
        if (r3 == false) goto L7;
        CompositeFormat.parseAndIgnoreWhitespace(r7, r8);
        Number r4 = CompositeFormat.parseNumber(r7, this.format, r8);
        if (r4 == null) goto L17;
        r1.add(r4);
        goto L7
    L17:
        r8.setIndex(r0);
        return null;
    L19:
        CompositeFormat.parseAndIgnoreWhitespace(r7, r8);
        if (CompositeFormat.parseFixedstring(r7, this.trimmedSuffix, r8) == true) goto L22;
        return null;
    L22:
        int r6 = r1.size();
        double[] r9 = new double[r6];
        int r10 = 0;
    L23:
        if (r10 >= r6) goto L26;
        r9[r10] = ((Number) r1.get(r10)).doubleValue();
        r10 = r10 + 1;
        goto L23
    L26:
        return new ArrayRealVector(r9, false);
    }
}
