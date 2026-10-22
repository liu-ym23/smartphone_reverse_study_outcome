package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RandomKey<T> extends AbstractListChromosome<Double> implements PermutationChromosome<T> {
    private final List<Integer> baseSeqPermutation;
    private final List<Double> sortedRepresentation;

    public RandomKey(List<Double> r3) throws InvalidRepresentationException {
        super(r3);
        ArrayList r4 = new ArrayList(getRepresentation());
        Collections.sort(r4);
        List<Double> r5 = Collections.unmodifiableList(r4);
        this.sortedRepresentation = r5;
        this.baseSeqPermutation = Collections.unmodifiableList(decodeGeneric(baseSequence(getLength()), getRepresentation(), r5));
    }

    public RandomKey(Double[] r1) throws InvalidRepresentationException {
        this(Arrays.asList(r1));
    }

    @Override // org.apache.commons.math3.genetics.PermutationChromosome
    public List<T> decode(List<T> r2) {
        return decodeGeneric(r2, getRepresentation(), this.sortedRepresentation);
    }

    private static <S> List<S> decodeGeneric(List<S> r5, List<Double> r6, List<Double> r7) throws DimensionMismatchException {
        int r0 = r5.size();
        if (r6.size() != r0) goto L13;
        if (r7.size() != r0) goto L11;
        ArrayList r1 = new ArrayList(r6);
        ArrayList r8 = new ArrayList(r0);
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        int r3 = r1.indexOf(r7.get(r2));
        r8.add(r5.get(r3));
        r1.set(r3, null);
        r2 = r2 + 1;
        goto L7
    L9:
        return r8;
    L11:
        throw new DimensionMismatchException(r7.size(), r0);
    L13:
        throw new DimensionMismatchException(r6.size(), r0);
    }

    @Override // org.apache.commons.math3.genetics.Chromosome
    protected boolean isSame(Chromosome r6) {
        if ((r6 instanceof RandomKey) == true) goto L5;
        return false;
    L5:
        RandomKey r7 = (RandomKey) r6;
        if (getLength() == r7.getLength()) goto L8;
        return false;
    L8:
        List<Integer> r0 = this.baseSeqPermutation;
        List<Integer> r8 = r7.baseSeqPermutation;
        int r2 = 0;
    L10:
        if (r2 >= getLength()) goto L15;
        if (r0.get(r2) != r8.get(r2)) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    @Override // org.apache.commons.math3.genetics.AbstractListChromosome
    protected void checkValidity(List<Double> r5) throws InvalidRepresentationException {
        Iterator<Double> r4 = r5.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        double r0 = r4.next().doubleValue();
        if (r0 < 0.0d) goto L11;
        if (r0 <= 1.0d) goto L4;
    L11:
        throw new InvalidRepresentationException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, new Object[]{Double.valueOf(r0), 0, 1});
    }

    public static final List<Double> randomPermutation(int r4) {
        ArrayList r0 = new ArrayList(r4);
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0.add(Double.valueOf(GeneticAlgorithm.getRandomGenerator().nextDouble()));
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final List<Double> identityPermutation(int r6) {
        ArrayList r0 = new ArrayList(r6);
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r0.add(Double.valueOf(((double) r1) / ((double) r6)));
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static <S> List<Double> comparatorPermutation(List<S> r1, Comparator<S> r2) {
        ArrayList r0 = new ArrayList(r1);
        Collections.sort(r0, r2);
        return inducedPermutation(r1, r0);
    }

    public static <S> List<Double> inducedPermutation(List<S> r9, List<S> r10) throws DimensionMismatchException, MathIllegalArgumentException {
        if (r9.size() != r10.size()) goto L14;
        int r0 = r9.size();
        ArrayList r1 = new ArrayList(r9);
        Double[] r11 = new Double[r0];
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L12;
        int r4 = r1.indexOf(r10.get(r3));
        if (r4 == (-1)) goto L10;
        r11[r4] = Double.valueOf(((double) r3) / ((double) r0));
        r1.set(r4, null);
        r3 = r3 + 1;
        goto L5
    L10:
        throw new MathIllegalArgumentException(LocalizedFormats.DIFFERENT_ORIG_AND_PERMUTED_DATA, new Object[0]);
    L12:
        return Arrays.asList(r11);
    L14:
        throw new DimensionMismatchException(r10.size(), r9.size());
    }

    @Override // org.apache.commons.math3.genetics.AbstractListChromosome
    public String toString() {
        return String.format("(f=%s pi=(%s))", new Object[]{Double.valueOf(getFitness()), this.baseSeqPermutation});
    }

    private static List<Integer> baseSequence(int r3) {
        ArrayList r0 = new ArrayList(r3);
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0.add(Integer.valueOf(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }
}
