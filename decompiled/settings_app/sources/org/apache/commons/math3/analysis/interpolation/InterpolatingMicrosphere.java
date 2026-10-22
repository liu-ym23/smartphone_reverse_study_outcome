package org.apache.commons.math3.analysis.interpolation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class InterpolatingMicrosphere {
    private final double background;
    private final double darkThreshold;
    private final int dimension;
    private final double maxDarkFraction;
    private final List<Facet> microsphere;
    private final List<FacetData> microsphereData;
    private final int size;

    private static class Facet {
        private final double[] normal;

        Facet(double[] r1) {
            this.normal = r1;
        }

        public double[] getNormal() {
            return this.normal;
        }
    }

    private static class FacetData {
        private final double illumination;
        private final double sample;

        FacetData(double r1, double r3) {
            this.illumination = r1;
            this.sample = r3;
        }

        public double illumination() {
            return this.illumination;
        }

        public double sample() {
            return this.sample;
        }
    }

    protected InterpolatingMicrosphere(int r5, int r6, double r7, double r9, double r11) {
        if (r5 <= 0) goto L20;
        if (r6 <= 0) goto L18;
        if (r7 < 0.0d) goto L16;
        if (r7 > 1.0d) goto L16;
        if (r9 < 0.0d) goto L14;
        this.dimension = r5;
        this.size = r6;
        this.maxDarkFraction = r7;
        this.darkThreshold = r9;
        this.background = r11;
        this.microsphere = new ArrayList(r6);
        this.microsphereData = new ArrayList(r6);
        return;
    L14:
        throw new NotPositiveException(Double.valueOf(r9));
    L16:
        throw new OutOfRangeException(Double.valueOf(r7), 0, 1);
    L18:
        throw new NotStrictlyPositiveException(Integer.valueOf(r6));
    L20:
        throw new NotStrictlyPositiveException(Integer.valueOf(r5));
    }

    public InterpolatingMicrosphere(int r1, int r2, double r3, double r5, double r7, UnitSphereRandomVectorGenerator r9) {
        this(r1, r2, r3, r5, r7);
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        add(r9.nextVector(), false);
        r4 = r4 + 1;
        goto L3
    }

    protected InterpolatingMicrosphere(InterpolatingMicrosphere r8) {
        this.dimension = r8.dimension;
        int r0 = r8.size;
        this.size = r0;
        this.maxDarkFraction = r8.maxDarkFraction;
        this.darkThreshold = r8.darkThreshold;
        this.background = r8.background;
        this.microsphere = r8.microsphere;
        this.microsphereData = new ArrayList(r0);
        Iterator<FacetData> r9 = r8.microsphereData.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        FacetData r1 = r9.next();
        this.microsphereData.add(new FacetData(r1.illumination(), r1.sample()));
        goto L4
    }

    public InterpolatingMicrosphere copy() {
        return new InterpolatingMicrosphere(this);
    }

    public int getDimension() {
        return this.dimension;
    }

    public int getSize() {
        return this.size;
    }

    public double value(double[] r14, double[][] r15, double[] r16, double r17, double r19) {
        if (r17 < 0.0d) goto L14;
        clear();
        int r3 = r15.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L12;
        double[] r8 = MathArrays.ebeSubtract(r15[r4], r14);
        double r9 = MathArrays.safeNorm(r8);
        if (FastMath.abs(r9) < r19) goto L9;
        double r11 = FastMath.pow(r9, -r17);
        illuminate(r8, r16[r4], r11);
        r4 = r4 + 1;
        goto L5
    L9:
        return r16[r4];
    L12:
        return interpolate();
    L14:
        throw new NotPositiveException(Double.valueOf(r17));
    }

    protected void add(double[] r3, boolean r4) {
        if (this.microsphere.size() >= this.size) goto L14;
        if (r3.length > this.dimension) goto L12;
        List<Facet> r0 = this.microsphere;
        if (r4 == false) goto L9;
        r3 = (double[]) r3.clone();
    L9:
        r0.add(new Facet(r3));
        this.microsphereData.add(new FacetData(0.0d, 0.0d));
        return;
    L12:
        throw new DimensionMismatchException(r3.length, this.dimension);
    L14:
        throw new MaxCountExceededException(Integer.valueOf(this.size));
    }

    private double interpolate() {
        Iterator<FacetData> r0 = this.microsphereData.iterator();
        int r1 = 0;
        double r4 = 0.0d;
        double r6 = 0.0d;
    L4:
        if (r0.hasNext() == false) goto L10;
        FacetData r8 = r0.next();
        double r9 = r8.illumination();
        if (r9 != 0.0d) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        r4 = r4 + (r8.sample() * r9);
        r6 = r6 + r9;
        goto L4
    L10:
        if ((((double) r1) / ((double) this.size)) > this.maxDarkFraction) goto L13;
        return r4 / r6;
    L13:
        return this.background;
    }

    private void illuminate(double[] r6, double r7, double r9) {
        int r0 = 0;
    L4:
        if (r0 >= this.size) goto L13;
        double r1 = MathArrays.cosAngle(this.microsphere.get(r0).getNormal(), r6);
        if (r1 <= 0.0d) goto L12;
        double r2 = r1 * r9;
        if (r2 <= this.darkThreshold) goto L12;
        if (r2 <= this.microsphereData.get(r0).illumination()) goto L12;
        this.microsphereData.set(r0, new FacetData(r2, r7));
    L12:
        r0 = r0 + 1;
        goto L4
    }

    private void clear() {
        int r0 = 0;
    L4:
        if (r0 >= this.size) goto L6;
        this.microsphereData.set(r0, new FacetData(0.0d, 0.0d));
        r0 = r0 + 1;
        goto L4
    }
}
