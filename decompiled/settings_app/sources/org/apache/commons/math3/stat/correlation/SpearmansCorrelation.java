package org.apache.commons.math3.stat.correlation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.stat.ranking.NaturalRanking;
import org.apache.commons.math3.stat.ranking.RankingAlgorithm;

/* JADX INFO: loaded from: classes6.dex */
public class SpearmansCorrelation {
    private final RealMatrix data;
    private final PearsonsCorrelation rankCorrelation;
    private final RankingAlgorithm rankingAlgorithm;

    public SpearmansCorrelation() {
        this(new NaturalRanking());
    }

    public SpearmansCorrelation(RankingAlgorithm r2) {
        this.data = null;
        this.rankingAlgorithm = r2;
        this.rankCorrelation = null;
    }

    public SpearmansCorrelation(RealMatrix r2) {
        this(r2, new NaturalRanking());
    }

    public SpearmansCorrelation(RealMatrix r1, RankingAlgorithm r2) {
        this.rankingAlgorithm = r2;
        RealMatrix r3 = rankTransform(r1);
        this.data = r3;
        this.rankCorrelation = new PearsonsCorrelation(r3);
    }

    public RealMatrix getCorrelationMatrix() {
        return this.rankCorrelation.getCorrelationMatrix();
    }

    public PearsonsCorrelation getRankCorrelation() {
        return this.rankCorrelation;
    }

    public RealMatrix computeCorrelationMatrix(RealMatrix r1) {
        RealMatrix r0 = rankTransform(r1);
        return new PearsonsCorrelation().computeCorrelationMatrix(r0);
    }

    public RealMatrix computeCorrelationMatrix(double[][] r2) {
        return computeCorrelationMatrix(new BlockRealMatrix(r2));
    }

    public double correlation(double[] r4, double[] r5) {
        if (r4.length != r5.length) goto L16;
        if (r4.length < 2) goto L14;
        if ((this.rankingAlgorithm instanceof NaturalRanking) == false) goto L12;
        if (NaNStrategy.REMOVED != ((NaturalRanking) this.rankingAlgorithm).getNanStrategy()) goto L12;
        HashSet r0 = new HashSet();
        r0.addAll(getNaNPositions(r4));
        r0.addAll(getNaNPositions(r5));
        r4 = removeValues(r4, r0);
        r5 = removeValues(r5, r0);
    L12:
        return new PearsonsCorrelation().correlation(this.rankingAlgorithm.rank(r4), this.rankingAlgorithm.rank(r5));
    L14:
        throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(r4.length), 2});
    L16:
        throw new DimensionMismatchException(r4.length, r5.length);
    }

    private RealMatrix rankTransform(RealMatrix r6) {
        RankingAlgorithm r0 = this.rankingAlgorithm;
        int r2 = 0;
        if ((r0 instanceof NaturalRanking) == true) goto L5;
    L16:
        RealMatrix r1 = null;
    L17:
        if (r1 != null) goto L20;
        r1 = r6.copy();
    L20:
        if (r2 >= r1.getColumnDimension()) goto L22;
        r1.setColumn(r2, this.rankingAlgorithm.rank(r1.getColumn(r2)));
        r2 = r2 + 1;
        goto L20
    L22:
        return r1;
    L5:
        if (((NaturalRanking) r0).getNanStrategy() != NaNStrategy.REMOVED) goto L16;
        HashSet r3 = new HashSet();
        int r4 = 0;
    L8:
        if (r4 >= r6.getColumnDimension()) goto L11;
        r3.addAll(getNaNPositions(r6.getColumn(r4)));
        r4 = r4 + 1;
        goto L8
    L11:
        if (r3.isEmpty() == true) goto L16;
        r1 = new BlockRealMatrix(r6.getRowDimension() - r3.size(), r6.getColumnDimension());
        int r5 = 0;
    L14:
        if (r5 >= r1.getColumnDimension()) goto L17;
        r1.setColumn(r5, removeValues(r6.getColumn(r5), r3));
        r5 = r5 + 1;
        goto L14
    }

    private List<Integer> getNaNPositions(double[] r4) {
        ArrayList r3 = new ArrayList();
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L9;
        if (Double.isNaN(r4[r0]) == false) goto L8;
        r3.add(Integer.valueOf(r0));
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r3;
    }

    private double[] removeValues(double[] r6, Set<Integer> r7) {
        if (r7.isEmpty() == false) goto L5;
        return r6;
    L5:
        double[] r5 = new double[r6.length - r7.size()];
        int r0 = 0;
        int r1 = 0;
    L7:
        if (r0 >= r6.length) goto L12;
        if (r7.contains(Integer.valueOf(r0)) == true) goto L11;
        r5[r1] = r6[r0];
        r1 = r1 + 1;
    L11:
        r0 = r0 + 1;
        goto L7
    L12:
        return r5;
    }
}
