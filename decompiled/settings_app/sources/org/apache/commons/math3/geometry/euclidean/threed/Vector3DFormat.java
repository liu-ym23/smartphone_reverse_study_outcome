package org.apache.commons.math3.geometry.euclidean.threed;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class Vector3DFormat extends VectorFormat<Euclidean3D> {
    @Override // org.apache.commons.math3.geometry.VectorFormat
    public /* bridge */ /* synthetic */ Vector parse(String r1) throws MathParseException {
        return parse(r1);
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public /* bridge */ /* synthetic */ Vector parse(String r1, ParsePosition r2) {
        return parse(r1, r2);
    }

    public Vector3DFormat() {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
    }

    public Vector3DFormat(NumberFormat r4) {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, r4);
    }

    public Vector3DFormat(String r2, String r3, String r4) {
        super(r2, r3, r4, CompositeFormat.getDefaultNumberFormat());
    }

    public Vector3DFormat(String r1, String r2, String r3, NumberFormat r4) {
        super(r1, r2, r3, r4);
    }

    public static Vector3DFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static Vector3DFormat getInstance(Locale r1) {
        return new Vector3DFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public StringBuffer format(Vector<Euclidean3D> r5, StringBuffer r6, FieldPosition r7) {
        Vector3D r8 = (Vector3D) r5;
        return format(r6, r7, new double[]{r8.getX(), r8.getY(), r8.getZ()});
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public Vector3D parse(String r3) throws MathParseException {
        ParsePosition r0 = new ParsePosition(0);
        Vector3D r2 = parse(r3, r0);
        if (r0.getIndex() == 0) goto L6;
        return r2;
    L6:
        throw new MathParseException(r3, r0.getErrorIndex(), Vector3D.class);
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public Vector3D parse(String r8, ParsePosition r9) {
        double[] r7 = parseCoordinates(3, r8, r9);
        if (r7 != null) goto L7;
        return null;
    L7:
        return new Vector3D(r7[0], r7[1], r7[2]);
    }
}
