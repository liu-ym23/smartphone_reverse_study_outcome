package org.apache.commons.math3.linear;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class RealMatrixFormat {
    private static final String DEFAULT_COLUMN_SEPARATOR = ",";
    private static final String DEFAULT_PREFIX = "{";
    private static final String DEFAULT_ROW_PREFIX = "{";
    private static final String DEFAULT_ROW_SEPARATOR = ",";
    private static final String DEFAULT_ROW_SUFFIX = "}";
    private static final String DEFAULT_SUFFIX = "}";
    private final String columnSeparator;
    private final NumberFormat format;
    private final String prefix;
    private final String rowPrefix;
    private final String rowSeparator;
    private final String rowSuffix;
    private final String suffix;

    public RealMatrixFormat() {
        this(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, ",", ",", CompositeFormat.getDefaultNumberFormat());
    }

    public RealMatrixFormat(NumberFormat r9) {
        this(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, ",", ",", r9);
    }

    public RealMatrixFormat(String r9, String r10, String r11, String r12, String r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, CompositeFormat.getDefaultNumberFormat());
    }

    public RealMatrixFormat(String r1, String r2, String r3, String r4, String r5, String r6, NumberFormat r7) {
        this.prefix = r1;
        this.suffix = r2;
        this.rowPrefix = r3;
        this.rowSuffix = r4;
        this.rowSeparator = r5;
        this.columnSeparator = r6;
        this.format = r7;
        r7.setGroupingUsed(false);
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

    public String getRowPrefix() {
        return this.rowPrefix;
    }

    public String getRowSuffix() {
        return this.rowSuffix;
    }

    public String getRowSeparator() {
        return this.rowSeparator;
    }

    public String getColumnSeparator() {
        return this.columnSeparator;
    }

    public NumberFormat getFormat() {
        return this.format;
    }

    public static RealMatrixFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static RealMatrixFormat getInstance(Locale r1) {
        return new RealMatrixFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    public String format(RealMatrix r4) {
        return format(r4, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public StringBuffer format(RealMatrix r8, StringBuffer r9, FieldPosition r10) {
        r10.setBeginIndex(0);
        r10.setEndIndex(0);
        r9.append(this.prefix);
        int r1 = r8.getRowDimension();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        r9.append(this.rowPrefix);
        int r3 = 0;
    L6:
        if (r3 >= r8.getColumnDimension()) goto L10;
        if (r3 <= 0) goto L9;
        r9.append(this.columnSeparator);
    L9:
        CompositeFormat.formatDouble(r8.getEntry(r2, r3), this.format, r9, r10);
        r3 = r3 + 1;
        goto L6
    L10:
        r9.append(this.rowSuffix);
        if (r2 >= (r1 - 1)) goto L13;
        r9.append(this.rowSeparator);
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        r9.append(this.suffix);
        return r9;
    }

    public RealMatrix parse(String r3) {
        ParsePosition r0 = new ParsePosition(0);
        RealMatrix r2 = parse(r3, r0);
        if (r0.getIndex() == 0) goto L6;
        return r2;
    L6:
        throw new MathParseException(r3, r0.getErrorIndex(), Array2DRowRealMatrix.class);
    }

    public RealMatrix parse(String r13, ParsePosition r14) {
        int r0 = r14.getIndex();
        String r1 = this.prefix.trim();
        String r2 = this.suffix.trim();
        String r3 = this.rowPrefix.trim();
        String r4 = this.rowSuffix.trim();
        String r5 = this.columnSeparator.trim();
        String r6 = this.rowSeparator.trim();
        CompositeFormat.parseAndIgnoreWhitespace(r13, r14);
        if (CompositeFormat.parseFixedstring(r13, r1, r14) == true) goto L5;
        return null;
    L5:
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        boolean r9 = true;
    L7:
        if (r9 == false) goto L36;
        if (r8.isEmpty() == true) goto L21;
        CompositeFormat.parseAndIgnoreWhitespace(r13, r14);
        if (CompositeFormat.parseFixedstring(r13, r5, r14) == true) goto L26;
        if (r4.length() != 0) goto L15;
    L17:
        CompositeFormat.parseAndIgnoreWhitespace(r13, r14);
        if (CompositeFormat.parseFixedstring(r13, r6, r14) == true) goto L19;
        r9 = false;
        goto L26
    L19:
        r7.add(r8);
        r8 = new ArrayList();
        goto L7
    L15:
        if (CompositeFormat.parseFixedstring(r13, r4, r14) == true) goto L17;
        return null;
    L26:
        if (r9 == false) goto L7;
        CompositeFormat.parseAndIgnoreWhitespace(r13, r14);
        Number r11 = CompositeFormat.parseNumber(r13, this.format, r14);
        if (r11 != null) goto L29;
        if (r8.isEmpty() == false) goto L33;
        r9 = false;
        goto L7
    L33:
        r14.setIndex(r0);
        return null;
    L29:
        r8.add(r11);
        goto L7
    L21:
        CompositeFormat.parseAndIgnoreWhitespace(r13, r14);
        if (r3.length() == 0) goto L26;
        if (CompositeFormat.parseFixedstring(r13, r3, r14) == true) goto L26;
        return null;
    L36:
        if (r8.isEmpty() == true) goto L38;
        r7.add(r8);
    L38:
        CompositeFormat.parseAndIgnoreWhitespace(r13, r14);
        if (CompositeFormat.parseFixedstring(r13, r2, r14) == true) goto L42;
        return null;
    L42:
        if (r7.isEmpty() == false) goto L45;
        r14.setIndex(r0);
        return null;
    L45:
        double[][] r12 = new double[r7.size()][];
        Iterator r15 = r7.iterator();
        int r16 = 0;
    L47:
        if (r15.hasNext() == false) goto L54;
        List r10 = (List) r15.next();
        r12[r16] = new double[r10.size()];
        int r17 = 0;
    L50:
        if (r17 >= r10.size()) goto L52;
        r12[r16][r17] = ((Number) r10.get(r17)).doubleValue();
        r17 = r17 + 1;
        goto L50
    L52:
        r16 = r16 + 1;
        goto L47
    L54:
        return MatrixUtils.createRealMatrix(r12);
    }
}
