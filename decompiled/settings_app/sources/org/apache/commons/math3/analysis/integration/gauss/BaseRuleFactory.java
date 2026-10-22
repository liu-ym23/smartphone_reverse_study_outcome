package org.apache.commons.math3.analysis.integration.gauss;

import java.lang.Number;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseRuleFactory<T extends Number> {
    private final Map<Integer, Pair<T[], T[]>> pointsAndWeights;
    private final Map<Integer, Pair<double[], double[]>> pointsAndWeightsDouble;

    protected abstract Pair<T[], T[]> computeRule(int r1) throws DimensionMismatchException;

    public BaseRuleFactory() {
        this.pointsAndWeights = new TreeMap();
        this.pointsAndWeightsDouble = new TreeMap();
    }

    public Pair<double[], double[]> getRule(int r3) throws NotStrictlyPositiveException, DimensionMismatchException {
        if (r3 <= 0) goto L9;
        Pair<double[], double[]> r0 = this.pointsAndWeightsDouble.get(Integer.valueOf(r3));
        if (r0 != null) goto L7;
        r0 = convertToDouble(getRuleInternal(r3));
        this.pointsAndWeightsDouble.put(Integer.valueOf(r3), r0);
    L7:
        return new Pair(r0.getFirst().clone(), r0.getSecond().clone());
    L9:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(r3));
    }

    protected synchronized Pair<T[], T[]> getRuleInternal(int r3) throws DimensionMismatchException {
        monitor-enter(this);
        Pair<T[], T[]> r0 = this.pointsAndWeights.get(Integer.valueOf(r3));     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        addRule(computeRule(r3));     // Catch: Throwable -> L10
        Pair<T[], T[]> r4 = getRuleInternal(r3);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r4;
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    protected void addRule(Pair<T[], T[]> r3) throws DimensionMismatchException {
        if (r3.getFirst().length != r3.getSecond().length) goto L7;
        this.pointsAndWeights.put(Integer.valueOf(r3.getFirst().length), r3);
        return;
    L7:
        throw new DimensionMismatchException(r3.getFirst().length, r3.getSecond().length);
    }

    private static <T extends Number> Pair<double[], double[]> convertToDouble(Pair<T[], T[]> r7) {
        T[] r0 = r7.getFirst();
        T[] r8 = r7.getSecond();
        int r1 = r0.length;
        double[] r2 = new double[r1];
        double[] r3 = new double[r1];
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L6;
        r2[r4] = r0[r4].doubleValue();
        r3[r4] = r8[r4].doubleValue();
        r4 = r4 + 1;
        goto L3
    L6:
        return new Pair(r2, r3);
    }
}
