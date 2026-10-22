package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class ConfidenceInterval {
    private double confidenceLevel;
    private double lowerBound;
    private double upperBound;

    public ConfidenceInterval(double r1, double r3, double r5) {
        checkParameters(r1, r3, r5);
        this.lowerBound = r1;
        this.upperBound = r3;
        this.confidenceLevel = r5;
    }

    public double getLowerBound() {
        return this.lowerBound;
    }

    public double getUpperBound() {
        return this.upperBound;
    }

    public double getConfidenceLevel() {
        return this.confidenceLevel;
    }

    public String toString() {
        return "[" + this.lowerBound + ";" + this.upperBound + "] (confidence level:" + this.confidenceLevel + ")";
    }

    private void checkParameters(double r4, double r6, double r8) {
        if (r4 >= r6) goto L12;
        if (r8 <= 0.0d) goto L10;
        if (r8 >= 1.0d) goto L10;
        return;
    L10:
        throw new MathIllegalArgumentException(LocalizedFormats.OUT_OF_BOUNDS_CONFIDENCE_LEVEL, new Object[]{Double.valueOf(r8), 0, 1});
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, new Object[]{Double.valueOf(r4), Double.valueOf(r6)});
    }
}
