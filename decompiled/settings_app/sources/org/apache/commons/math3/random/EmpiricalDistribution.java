package org.apache.commons.math3.random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.ConstantRealDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class EmpiricalDistribution extends AbstractRealDistribution {
    public static final int DEFAULT_BIN_COUNT = 1000;
    private static final String FILE_CHARSET = "US-ASCII";
    private static final long serialVersionUID = 5729073523949762654L;
    private final int binCount;
    private final List<SummaryStatistics> binStats;
    private double delta;
    private boolean loaded;
    private double max;
    private double min;
    protected final RandomDataGenerator randomData;
    private SummaryStatistics sampleStats;
    private double[] upperBounds;

    /* JADX INFO: renamed from: org.apache.commons.math3.random.EmpiricalDistribution$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ArrayDataAdapter extends DataAdapter {
        private double[] inputArray;
        final /* synthetic */ EmpiricalDistribution this$0;

        ArrayDataAdapter(EmpiricalDistribution r2, double[] r3) throws NullArgumentException {
            this.this$0 = r2;
            super(r2, null);
            MathUtils.checkNotNull(r3);
            this.inputArray = r3;
        }

        @Override // org.apache.commons.math3.random.EmpiricalDistribution.DataAdapter
        public void computeStats() throws IOException {
            EmpiricalDistribution.access$302(this.this$0, new SummaryStatistics());
            int r0 = 0;
        L4:
            if (r0 >= this.inputArray.length) goto L6;
            EmpiricalDistribution.access$300(this.this$0).addValue(this.inputArray[r0]);
            r0 = r0 + 1;
            goto L4
        }

        @Override // org.apache.commons.math3.random.EmpiricalDistribution.DataAdapter
        public void computeBinStats() throws IOException {
            int r0 = 0;
        L4:
            if (r0 >= this.inputArray.length) goto L6;
            ((SummaryStatistics) EmpiricalDistribution.access$200(this.this$0).get(EmpiricalDistribution.access$100(this.this$0, this.inputArray[r0]))).addValue(this.inputArray[r0]);
            r0 = r0 + 1;
            goto L4
        }
    }

    private abstract class DataAdapter {
        final /* synthetic */ EmpiricalDistribution this$0;

        public abstract void computeBinStats() throws IOException;

        public abstract void computeStats() throws IOException;

        private DataAdapter(EmpiricalDistribution r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DataAdapter(EmpiricalDistribution r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    private class StreamDataAdapter extends DataAdapter {
        private BufferedReader inputStream;
        final /* synthetic */ EmpiricalDistribution this$0;

        StreamDataAdapter(EmpiricalDistribution r2, BufferedReader r3) {
            this.this$0 = r2;
            super(r2, null);
            this.inputStream = r3;
        }

        @Override // org.apache.commons.math3.random.EmpiricalDistribution.DataAdapter
        public void computeBinStats() throws IOException {
        L2:
            String r0 = this.inputStream.readLine();
            if (r0 == null) goto L5;
            double r1 = Double.parseDouble(r0);
            ((SummaryStatistics) EmpiricalDistribution.access$200(this.this$0).get(EmpiricalDistribution.access$100(this.this$0, r1))).addValue(r1);
            goto L2
        L5:
            this.inputStream.close();
            this.inputStream = null;
        }

        @Override // org.apache.commons.math3.random.EmpiricalDistribution.DataAdapter
        public void computeStats() throws IOException {
            EmpiricalDistribution.access$302(this.this$0, new SummaryStatistics());
        L3:
            String r0 = this.inputStream.readLine();
            if (r0 == null) goto L6;
            double r1 = Double.parseDouble(r0);
            EmpiricalDistribution.access$300(this.this$0).addValue(r1);
            goto L3
        L6:
            this.inputStream.close();
            this.inputStream = null;
        }
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double probability(double r1) {
        return 0.0d;
    }

    static /* synthetic */ int access$100(EmpiricalDistribution r0, double r1) {
        return r0.findBin(r1);
    }

    static /* synthetic */ List access$200(EmpiricalDistribution r0) {
        return r0.binStats;
    }

    static /* synthetic */ SummaryStatistics access$300(EmpiricalDistribution r0) {
        return r0.sampleStats;
    }

    static /* synthetic */ SummaryStatistics access$302(EmpiricalDistribution r0, SummaryStatistics r1) {
        r0.sampleStats = r1;
        return r1;
    }

    public EmpiricalDistribution() {
        this(1000);
    }

    public EmpiricalDistribution(int r2) {
        this(r2, new RandomDataGenerator());
    }

    public EmpiricalDistribution(int r2, RandomGenerator r3) {
        this(r2, new RandomDataGenerator(r3));
    }

    public EmpiricalDistribution(RandomGenerator r2) {
        this(1000, r2);
    }

    @Deprecated
    public EmpiricalDistribution(int r1, RandomDataImpl r2) {
        this(r1, r2.getDelegate());
    }

    @Deprecated
    public EmpiricalDistribution(RandomDataImpl r2) {
        this(1000, r2);
    }

    private EmpiricalDistribution(int r4, RandomDataGenerator r5) {
        super(r5.getRandomGenerator());
        this.sampleStats = null;
        this.max = Double.NEGATIVE_INFINITY;
        this.min = Double.POSITIVE_INFINITY;
        this.delta = 0.0d;
        this.loaded = false;
        this.upperBounds = null;
        if (r4 <= 0) goto L7;
        this.binCount = r4;
        this.randomData = r5;
        this.binStats = new ArrayList();
        return;
    L7:
        throw new NotStrictlyPositiveException(Integer.valueOf(r4));
    }

    public void load(double[] r2) throws NullArgumentException {
        new ArrayDataAdapter(this, r2).computeStats();     // Catch: IOException -> L6
        fillBinStats(new ArrayDataAdapter(this, r2));     // Catch: IOException -> L6
        this.loaded = true;
        return;
    L7:
        throw new MathInternalError();
    }

    public void load(URL r7) throws IOException, NullArgumentException, ZeroException {
        MathUtils.checkNotNull(r7);
        Charset r0 = Charset.forName("US-ASCII");
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r7.openStream(), r0));
        new StreamDataAdapter(this, r1).computeStats();     // Catch: Throwable -> L13
        if (this.sampleStats.getN() == 0) goto L12;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r7.openStream(), r0));     // Catch: Throwable -> L13
        fillBinStats(new StreamDataAdapter(this, r2));     // Catch: Throwable -> L9
        this.loaded = true;     // Catch: Throwable -> L9
        r2.close();     // Catch: IOException -> L16
        return;
    L25:
        return;
    L9:
        th = th;
        r1 = r2;
    L23:
        r1.close();     // Catch: IOException -> L17
    L15:
        throw th;
    L12:
        throw new ZeroException(LocalizedFormats.URL_CONTAINS_NO_DATA, new Object[]{r7});     // Catch: Throwable -> L13
    L13:
        th = th;
        goto L23
    }

    public void load(File r5) throws IOException, NullArgumentException {
        MathUtils.checkNotNull(r5);
        Charset r0 = Charset.forName("US-ASCII");
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream(r5), r0));
        new StreamDataAdapter(this, r2).computeStats();     // Catch: Throwable -> L9
        BufferedReader r6 = new BufferedReader(new InputStreamReader(new FileInputStream(r5), r0));     // Catch: Throwable -> L9
        fillBinStats(new StreamDataAdapter(this, r6));     // Catch: Throwable -> L7
        this.loaded = true;     // Catch: Throwable -> L7
        r6.close();     // Catch: IOException -> L12
        return;
    L22:
        return;
    L7:
        th = th;
        r2 = r6;
    L16:
        r2.close();     // Catch: IOException -> L13
    L11:
        throw th;
    L9:
        th = th;
        goto L16
    }

    private void fillBinStats(DataAdapter r9) throws IOException {
        this.min = this.sampleStats.getMin();
        double r0 = this.sampleStats.getMax();
        this.max = r0;
        this.delta = (r0 - this.min) / ((double) this.binCount);
        if (this.binStats.isEmpty() == true) goto L5;
        this.binStats.clear();
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.binCount) goto L9;
        this.binStats.add(r1, new SummaryStatistics());
        r1 = r1 + 1;
        goto L7
    L9:
        r9.computeBinStats();
        double[] r10 = new double[this.binCount];
        this.upperBounds = r10;
        r10[0] = this.binStats.get(0).getN() / this.sampleStats.getN();
        int r2 = 1;
    L10:
        int r3 = this.binCount;
        if (r2 >= (r3 - 1)) goto L13;
        double[] r4 = this.upperBounds;
        r4[r2] = r4[r2 - 1] + (this.binStats.get(r2).getN() / this.sampleStats.getN());
        r2 = r2 + 1;
        goto L10
    L13:
        this.upperBounds[r3 - 1] = 1.0d;
    }

    private int findBin(double r3) {
        return FastMath.min(FastMath.max(((int) FastMath.ceil((r3 - this.min) / this.delta)) - 1, 0), this.binCount - 1);
    }

    public double getNextValue() throws MathIllegalStateException {
        if (this.loaded == false) goto L7;
        return sample();
    L7:
        throw new MathIllegalStateException(LocalizedFormats.DISTRIBUTION_NOT_LOADED, new Object[0]);
    }

    public StatisticalSummary getSampleStats() {
        return this.sampleStats;
    }

    public int getBinCount() {
        return this.binCount;
    }

    public List<SummaryStatistics> getBinStats() {
        return this.binStats;
    }

    public double[] getUpperBounds() {
        double[] r0 = new double[this.binCount];
        int r1 = 0;
    L3:
        int r2 = this.binCount;
        if (r1 >= (r2 - 1)) goto L6;
        int r6 = r1 + 1;
        r0[r1] = this.min + (this.delta * ((double) r6));
        r1 = r6;
        goto L3
    L6:
        r0[r2 - 1] = this.max;
        return r0;
    }

    public double[] getGeneratorUpperBounds() {
        double[] r3 = this.upperBounds;
        int r0 = r3.length;
        double[] r1 = new double[r0];
        System.arraycopy(r3, 0, r1, 0, r0);
        return r1;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void reSeed(long r1) {
        this.randomData.reSeed(r1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r4) {
        if (r4 >= this.min) goto L5;
        return 0.0d;
    L5:
        if (r4 > this.max) goto L11;
        int r0 = findBin(r4);
        return (getKernel(this.binStats.get(r0)).density(r4) * pB(r0)) / kB(r0);
    L11:
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r12) {
        if (r12 >= this.min) goto L7;
        return 0.0d;
    L7:
        if (r12 < this.max) goto L10;
        return 1.0d;
    L10:
        int r0 = findBin(r12);
        double r1 = pBminus(r0);
        double r3 = pB(r0);
        RealDistribution r5 = k(r12);
        if ((r5 instanceof ConstantRealDistribution) == true) goto L13;
        double[] r6 = getUpperBounds();
        double r7 = kB(r0);
        if (r0 != 0) goto L20;
        double r9 = this.min;
    L22:
        return r1 + (r3 * ((r5.cumulativeProbability(r12) - r5.cumulativeProbability(r9)) / r7));
    L20:
        r9 = r6[r0 - 1];
        goto L22
    L13:
        if (r12 >= r5.getNumericalMean()) goto L16;
        return r1;
    L16:
        return r1 + r3;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r16) throws OutOfRangeException {
        int r4 = 0;
        if (r16 < 0.0d) goto L26;
        if (r16 > 1.0d) goto L26;
        if (r16 == 0.0d) goto L9;
        if (r16 != 1.0d) goto L14;
        return getSupportUpperBound();
    L14:
        if (cumBinP(r4) >= r16) goto L16;
        r4 = r4 + 1;
        goto L14
    L16:
        RealDistribution r3 = getKernel(this.binStats.get(r4));
        double r5 = kB(r4);
        double[] r7 = getUpperBounds();
        if (r4 != 0) goto L19;
        double r8 = this.min;
    L20:
        double r9 = r3.cumulativeProbability(r8);
        double r11 = pB(r4);
        double r13 = r16 - pBminus(r4);
        if (r13 > 0.0d) goto L24;
        return r8;
    L24:
        return r3.inverseCumulativeProbability(r9 + ((r13 * r5) / r11));
    L19:
        r8 = r7[r4 - 1];
        goto L20
    L9:
        return getSupportLowerBound();
    L26:
        throw new OutOfRangeException(Double.valueOf(r16), 0, 1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return this.sampleStats.getMean();
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        return this.sampleStats.getVariance();
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.min;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return this.max;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public void reseedRandomGenerator(long r1) {
        this.randomData.reSeed(r1);
    }

    private double pB(int r3) {
        double[] r2 = this.upperBounds;
        if (r3 != 0) goto L6;
        return r2[0];
    L6:
        return r2[r3] - r2[r3 - 1];
    }

    private double pBminus(int r1) {
        if (r1 != 0) goto L5;
        return 0.0d;
    L5:
        return this.upperBounds[r1 - 1];
    }

    private double kB(int r5) {
        double[] r0 = getUpperBounds();
        RealDistribution r1 = getKernel(this.binStats.get(r5));
        if (r5 != 0) goto L6;
        return r1.cumulativeProbability(this.min, r0[0]);
    L6:
        return r1.cumulativeProbability(r0[r5 - 1], r0[r5]);
    }

    private RealDistribution k(double r1) {
        int r2 = findBin(r1);
        return getKernel(this.binStats.get(r2));
    }

    private double cumBinP(int r1) {
        return this.upperBounds[r1];
    }

    protected RealDistribution getKernel(SummaryStatistics r10) {
        if (r10.getN() == 1) goto L10;
        if (r10.getVariance() == 0.0d) goto L10;
        return new NormalDistribution(this.randomData.getRandomGenerator(), r10.getMean(), r10.getStandardDeviation(), 1.0E-9d);
    L10:
        return new ConstantRealDistribution(r10.getMean());
    }
}
