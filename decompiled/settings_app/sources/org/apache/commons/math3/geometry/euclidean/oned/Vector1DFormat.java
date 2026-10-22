package org.apache.commons.math3.geometry.euclidean.oned;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class Vector1DFormat extends VectorFormat<Euclidean1D> {
    @Override // org.apache.commons.math3.geometry.VectorFormat
    public /* bridge */ /* synthetic */ Vector parse(String r1) throws MathParseException {
        return parse(r1);
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public /* bridge */ /* synthetic */ Vector parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    public Vector1DFormat() {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
    }

    public Vector1DFormat(NumberFormat r4) {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, r4);
    }

    public Vector1DFormat(String r3, String r4) {
        super(r3, r4, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
    }

    public Vector1DFormat(String r2, String r3, NumberFormat r4) {
        super(r2, r3, VectorFormat.DEFAULT_SEPARATOR, r4);
    }

    public static Vector1DFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static Vector1DFormat getInstance(Locale r1) {
        return new Vector1DFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public StringBuffer format(Vector<Euclidean1D> r5, StringBuffer r6, FieldPosition r7) {
        return format(r6, r7, new double[]{((Vector1D) r5).getX()});
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public Vector1D parse(String r3) throws MathParseException {
        ParsePosition r0 = new ParsePosition(0);
        Vector1D r2 = parse(r3, r0);
        if (r0.getIndex() == 0) goto L6;
        return r2;
    L6:
        throw new MathParseException(r3, r0.getErrorIndex(), Vector1D.class);
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public Vector1D parse(String r3, ParsePosition r4) {
        double[] r2 = parseCoordinates(1, r3, r4);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new Vector1D(r2[0]);
    }
}
