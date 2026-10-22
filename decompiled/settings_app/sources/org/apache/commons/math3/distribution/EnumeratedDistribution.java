package org.apache.commons.math3.distribution;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class EnumeratedDistribution<T> implements Serializable {
    private static final long serialVersionUID = 20123308;
    private final double[] cumulativeProbabilities;
    private final double[] probabilities;
    protected final RandomGenerator random;
    private final List<T> singletons;

    public EnumeratedDistribution(List<Pair<T, Double>> r2) throws NotPositiveException, MathArithmeticException, NotFiniteNumberException, NotANumberException {
        this(new Well19937c(), r2);
    }

    public EnumeratedDistribution(RandomGenerator r8, List<Pair<T, Double>> r9) throws NotPositiveException, MathArithmeticException, NotFiniteNumberException, NotANumberException {
        this.random = r8;
        this.singletons = new ArrayList(r9.size());
        double[] r10 = new double[r9.size()];
        int r0 = 0;
        int r1 = 0;
    L3:
        double r3 = 0.0d;
        if (r1 >= r9.size()) goto L18;
        Pair<T, Double> r2 = r9.get(r1);
        this.singletons.add(r2.getKey());
        double r5 = r2.getValue().doubleValue();
        if (r5 < 0.0d) goto L17;
        if (Double.isInfinite(r5) == true) goto L15;
        if (Double.isNaN(r5) == true) goto L13;
        r10[r1] = r5;
        r1 = r1 + 1;
        goto L3
    L13:
        throw new NotANumberException();
    L15:
        throw new NotFiniteNumberException(Double.valueOf(r5), new Object[0]);
    L17:
        throw new NotPositiveException(r2.getValue());
    L18:
        double[] r11 = MathArrays.normalizeArray(r10, 1.0d);
        this.probabilities = r11;
        this.cumulativeProbabilities = new double[r11.length];
    L19:
        double[] r12 = this.probabilities;
        if (r0 >= r12.length) goto L22;
        r3 = r3 + r12[r0];
        this.cumulativeProbabilities[r0] = r3;
        r0 = r0 + 1;
        goto L19
    }

    public void reseedRandomGenerator(long r1) {
        this.random.setSeed(r1);
    }

    double probability(T r6) {
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= this.probabilities.length) goto L13;
        if (r6 == null) goto L7;
    L8:
        if (r6 == null) goto L12;
        if (r6.equals(this.singletons.get(r2)) == false) goto L12;
    L11:
        r0 = r0 + this.probabilities[r2];
    L12:
        r2 = r2 + 1;
        goto L4
    L7:
        if (this.singletons.get(r2) == null) goto L11;
    L13:
        return r0;
    }

    public List<Pair<T, Double>> getPmf() {
        ArrayList r0 = new ArrayList(this.probabilities.length);
        int r1 = 0;
    L4:
        if (r1 >= this.probabilities.length) goto L6;
        r0.add(new Pair(this.singletons.get(r1), Double.valueOf(this.probabilities[r1])));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public T sample() {
        double r0 = this.random.nextDouble();
        int r2 = Arrays.binarySearch(this.cumulativeProbabilities, r0);
        if (r2 >= 0) goto L5;
        r2 = (-r2) - 1;
    L5:
        if (r2 >= 0) goto L7;
    L12:
        List<T> r5 = this.singletons;
        return r5.get(r5.size() - 1);
    L7:
        if (r2 >= this.probabilities.length) goto L12;
        if (r0 >= this.cumulativeProbabilities[r2]) goto L12;
        return this.singletons.get(r2);
    }

    public Object[] sample(int r4) throws NotStrictlyPositiveException {
        if (r4 <= 0) goto L8;
        Object[] r0 = new Object[r4];
        int r1 = 0;
    L4:
        if (r1 >= r4) goto L6;
        r0[r1] = sample();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    L8:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r4));
    }

    public T[] sample(int r3, T[] r4) throws NotStrictlyPositiveException {
        if (r3 <= 0) goto L14;
        int r0 = 0;
        if (r4 == null) goto L12;
        if (r4.length >= r3) goto L8;
        r4 = (T[]) ((Object[]) Array.newInstance(r4.getClass().getComponentType(), r3));
    L8:
        if (r0 >= r3) goto L10;
        T[] r5 = r4;
        r5[r0] = sample();
        r0 = r0 + 1;
        goto L8
    L10:
        return r4;
    L12:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    L14:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r3));
    }
}
