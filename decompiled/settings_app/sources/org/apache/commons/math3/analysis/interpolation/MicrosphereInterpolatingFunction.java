package org.apache.commons.math3.analysis.interpolation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class MicrosphereInterpolatingFunction implements MultivariateFunction {
    private final double brightnessExponent;
    private final int dimension;
    private final List<MicrosphereSurfaceElement> microsphere;
    private final Map<RealVector, Double> samples;

    private static class MicrosphereSurfaceElement {
        private double brightestIllumination;
        private Map.Entry<RealVector, Double> brightestSample;
        private final RealVector normal;

        MicrosphereSurfaceElement(double[] r2) {
            this.normal = new ArrayRealVector(r2);
        }

        RealVector normal() {
            return this.normal;
        }

        void reset() {
            this.brightestIllumination = 0.0d;
            this.brightestSample = null;
        }

        void store(double r3, Map.Entry<RealVector, Double> r5) {
            if (r3 <= this.brightestIllumination) goto L6;
            this.brightestIllumination = r3;
            this.brightestSample = r5;
            return;
        }

        double illumination() {
            return this.brightestIllumination;
        }

        Map.Entry<RealVector, Double> sample() {
            return this.brightestSample;
        }
    }

    public MicrosphereInterpolatingFunction(double[][] r7, double[] r8, int r9, int r10, UnitSphereRandomVectorGenerator r11) throws DimensionMismatchException, NoDataException, NullArgumentException {
        if (r7 == null) goto L34;
        if (r8 == null) goto L34;
        if (r7.length == 0) goto L32;
        if (r7.length != r8.length) goto L30;
        int r0 = 0;
        double[] r1 = r7[0];
        if (r1 == null) goto L28;
        this.dimension = r1.length;
        this.brightnessExponent = r9;
        this.samples = new HashMap(r8.length);
        int r12 = 0;
    L13:
        if (r12 >= r7.length) goto L23;
        double[] r2 = r7[r12];
        if (r2 == null) goto L22;
        if (r2.length != this.dimension) goto L20;
        this.samples.put(new ArrayRealVector(r2), Double.valueOf(r8[r12]));
        r12 = r12 + 1;
        goto L13
    L20:
        throw new DimensionMismatchException(r2.length, this.dimension);
    L22:
        throw new NullArgumentException();
    L23:
        this.microsphere = new ArrayList(r10);
    L24:
        if (r0 >= r10) goto L26;
        this.microsphere.add(new MicrosphereSurfaceElement(r11.nextVector()));
        r0 = r0 + 1;
        goto L24
    L26:
        return;
    L28:
        throw new NullArgumentException();
    L30:
        throw new DimensionMismatchException(r7.length, r8.length);
    L32:
        throw new NoDataException();
    L34:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] r12) throws DimensionMismatchException {
        ArrayRealVector r0 = new ArrayRealVector(r12);
        Iterator<MicrosphereSurfaceElement> r13 = this.microsphere.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r13.next().reset();
        goto L4
    L6:
        Iterator<Map.Entry<RealVector, Double>> r14 = this.samples.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L17;
        Map.Entry<RealVector, Double> r1 = r14.next();
        RealVector r2 = r1.getKey().subtract(r0);
        double r3 = r2.getNorm();
        if (FastMath.abs(r3) < FastMath.ulp(1.0d)) goto L12;
        Iterator<MicrosphereSurfaceElement> r5 = this.microsphere.iterator();
    L15:
        if (r5.hasNext() == false) goto L8;
        MicrosphereSurfaceElement r6 = r5.next();
        r6.store(cosAngle(r2, r6.normal()) * FastMath.pow(r3, -this.brightnessExponent), r1);
        goto L15
    L12:
        return r1.getValue().doubleValue();
    L17:
        Iterator<MicrosphereSurfaceElement> r11 = this.microsphere.iterator();
        double r4 = 0.0d;
        double r7 = 0.0d;
    L19:
        if (r11.hasNext() == false) goto L24;
        MicrosphereSurfaceElement r15 = r11.next();
        double r8 = r15.illumination();
        Map.Entry<RealVector, Double> r16 = r15.sample();
        if (r16 == null) goto L19;
        r4 = r4 + (r16.getValue().doubleValue() * r8);
        r7 = r7 + r8;
        goto L19
    L24:
        return r4 / r7;
    }

    private double cosAngle(RealVector r5, RealVector r6) {
        return r5.dotProduct(r6) / (r5.getNorm() * r6.getNorm());
    }
}
