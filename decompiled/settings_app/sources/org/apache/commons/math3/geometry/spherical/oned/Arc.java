package org.apache.commons.math3.geometry.spherical.oned;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class Arc {
    private final double lower;
    private final double middle;
    private final double tolerance;
    private final double upper;

    public Arc(double r6, double r8, double r10) throws NumberIsTooLargeException {
        this.tolerance = r10;
        if (Precision.equals(r6, r8, 0) == true) goto L12;
        double r11 = r8 - r6;
        if (r11 >= 6.283185307179586d) goto L12;
        if (r6 > r8) goto L11;
        double r7 = MathUtils.normalizeAngle(r6, 3.141592653589793d);
        this.lower = r7;
        double r12 = r11 + r7;
        this.upper = r12;
        this.middle = (r7 + r12) * 0.5d;
        return;
    L11:
        throw new NumberIsTooLargeException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(r6), Double.valueOf(r8), true);
    L12:
        this.lower = 0.0d;
        this.upper = 6.283185307179586d;
        this.middle = 3.141592653589793d;
    }

    public double getInf() {
        return this.lower;
    }

    public double getSup() {
        return this.upper;
    }

    public double getSize() {
        return this.upper - this.lower;
    }

    public double getBarycenter() {
        return this.middle;
    }

    public double getTolerance() {
        return this.tolerance;
    }

    public Region.Location checkPoint(double r9) {
        double r10 = MathUtils.normalizeAngle(r9, this.middle);
        double r0 = this.lower;
        double r2 = this.tolerance;
        if (r10 < (r0 - r2)) goto L19;
        double r4 = this.upper;
        if (r10 > (r4 + r2)) goto L19;
        if (r10 <= (r0 + r2)) goto L14;
        if (r10 >= (r4 - r2)) goto L14;
        return Region.Location.INSIDE;
    L14:
        if (getSize() < (6.283185307179586d - this.tolerance)) goto L17;
        return Region.Location.INSIDE;
    L17:
        return Region.Location.BOUNDARY;
    L19:
        return Region.Location.OUTSIDE;
    }
}
