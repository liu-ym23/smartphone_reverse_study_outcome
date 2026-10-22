package org.apache.commons.math3.geometry.euclidean.twod;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class Vector2DFormat extends VectorFormat<Euclidean2D> {
    @Override // org.apache.commons.math3.geometry.VectorFormat
    public /* bridge */ /* synthetic */ Vector parse(String r1) throws MathParseException {
        return parse(r1);
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public /* bridge */ /* synthetic */ Vector parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    public Vector2DFormat() {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
    }

    public Vector2DFormat(NumberFormat r4) {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, r4);
    }

    public Vector2DFormat(String r2, String r3, String r4) {
        super(r2, r3, r4, CompositeFormat.getDefaultNumberFormat());
    }

    public Vector2DFormat(String r1, String r2, String r3, NumberFormat r4) {
        super(r1, r2, r3, r4);
    }

    public static Vector2DFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static Vector2DFormat getInstance(Locale r1) {
        return new Vector2DFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public StringBuffer format(Vector<Euclidean2D> r5, StringBuffer r6, FieldPosition r7) {
        Vector2D r8 = (Vector2D) r5;
        return format(r6, r7, new double[]{r8.getX(), r8.getY()});
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public Vector2D parse(String r3) throws MathParseException {
        ParsePosition r0 = new ParsePosition(0);
        Vector2D r2 = parse(r3, r0);
        if (r0.getIndex() == 0) goto L6;
        return r2;
    L6:
        throw new MathParseException(r3, r0.getErrorIndex(), Vector2D.class);
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public Vector2D parse(String r5, ParsePosition r6) {
        double[] r4 = parseCoordinates(2, r5, r6);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new Vector2D(r4[0], r4[1]);
    }
}
