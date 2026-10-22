package com.google.common.math;

import androidx.slice.core.SliceHints;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    Stats(long r1, double r3, double r5, double r7, double r9) {
        this.count = r1;
        this.mean = r3;
        this.sumOfSquaresOfDeltas = r5;
        this.min = r7;
        this.max = r9;
    }

    public static Stats of(Iterable<? extends Number> r1) {
        StatsAccumulator r0 = new StatsAccumulator();
        r0.addAll(r1);
        return r0.snapshot();
    }

    public static Stats of(Iterator<? extends Number> r1) {
        StatsAccumulator r0 = new StatsAccumulator();
        r0.addAll(r1);
        return r0.snapshot();
    }

    public static Stats of(double... r1) {
        StatsAccumulator r0 = new StatsAccumulator();
        r0.addAll(r1);
        return r0.snapshot();
    }

    public static Stats of(int... r1) {
        StatsAccumulator r0 = new StatsAccumulator();
        r0.addAll(r1);
        return r0.snapshot();
    }

    public static Stats of(long... r1) {
        StatsAccumulator r0 = new StatsAccumulator();
        r0.addAll(r1);
        return r0.snapshot();
    }

    public static Stats of(DoubleStream r3) {
        return ((StatsAccumulator) r3.collect(new Stats$$ExternalSyntheticLambda0(), new Stats$$ExternalSyntheticLambda6(), new Stats$$ExternalSyntheticLambda2())).snapshot();
    }

    public static Stats of(IntStream r3) {
        return ((StatsAccumulator) r3.collect(new Stats$$ExternalSyntheticLambda0(), new Stats$$ExternalSyntheticLambda7(), new Stats$$ExternalSyntheticLambda2())).snapshot();
    }

    public static Stats of(LongStream r3) {
        return ((StatsAccumulator) r3.collect(new Stats$$ExternalSyntheticLambda0(), new Stats$$ExternalSyntheticLambda1(), new Stats$$ExternalSyntheticLambda2())).snapshot();
    }

    public static Collector<Number, StatsAccumulator, Stats> toStats() {
        return Collector.of(new Stats$$ExternalSyntheticLambda0(), new Stats$$ExternalSyntheticLambda3(), new Stats$$ExternalSyntheticLambda4(), new Stats$$ExternalSyntheticLambda5(), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    static /* synthetic */ void lambda$toStats$0(StatsAccumulator r2, Number r3) {
        r2.add(r3.doubleValue());
    }

    static /* synthetic */ StatsAccumulator lambda$toStats$1(StatsAccumulator r0, StatsAccumulator r1) {
        r0.addAll(r1);
        return r0;
    }

    public long count() {
        return this.count;
    }

    public double mean() {
        if (this.count == 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return this.mean;
    L5:
        r0 = false;
        goto L6
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double populationVariance() {
        if (this.count <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        if (this.count != 1) goto L15;
        return 0.0d;
    L15:
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / count();
    L5:
        r0 = false;
        goto L6
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double sampleVariance() {
        if (this.count <= 1) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1);
    L5:
        r0 = false;
        goto L6
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double min() {
        if (this.count == 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return this.min;
    L5:
        r0 = false;
        goto L6
    }

    public double max() {
        if (this.count == 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return this.max;
    L5:
        r0 = false;
        goto L6
    }

    public boolean equals(@CheckForNull Object r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if (getClass() == r6.getClass()) goto L8;
        return false;
    L8:
        Stats r7 = (Stats) r6;
        if (this.count == r7.count) goto L11;
        return false;
    L11:
        if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(r7.mean)) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(r7.sumOfSquaresOfDeltas)) goto L15;
        return false;
    L15:
        if (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(r7.min)) goto L17;
        return false;
    L17:
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(r7.max)) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)});
    }

    public String toString() {
        if (count() <= 0) goto L7;
        return MoreObjects.toStringHelper(this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", populationStandardDeviation()).add(SliceHints.SUBTYPE_MIN, this.min).add("max", this.max).toString();
    L7:
        return MoreObjects.toStringHelper(this).add("count", this.count).toString();
    }

    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public static double meanOf(Iterable<? extends Number> r2) {
        return meanOf(r2.iterator());
    }

    public static double meanOf(Iterator<? extends Number> r10) {
        Preconditions.checkArgument(r10.hasNext());
        double r0 = r10.next().doubleValue();
        long r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L11;
        double r6 = r10.next().doubleValue();
        r4 = r4 + 1;
        if (Doubles.isFinite(r6) == false) goto L10;
        if (Doubles.isFinite(r0) == false) goto L10;
        r0 = r0 + ((r6 - r0) / r4);
    L10:
        r0 = StatsAccumulator.calculateNewMeanNonFinite(r0, r6);
        goto L4
    L11:
        return r0;
    }

    public static double meanOf(double... r7) {
        int r2 = 1;
        if (r7.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        double r1 = r7[0];
    L8:
        if (r2 >= r7.length) goto L16;
        double r3 = r7[r2];
        if (Doubles.isFinite(r3) == true) goto L12;
    L14:
        r1 = StatsAccumulator.calculateNewMeanNonFinite(r1, r3);
    L15:
        r2 = r2 + 1;
        goto L8
    L12:
        if (Doubles.isFinite(r1) == false) goto L14;
        r1 = r1 + ((r3 - r1) / ((double) (r2 + 1)));
        goto L15
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static double meanOf(int... r7) {
        int r2 = 1;
        if (r7.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        double r1 = r7[0];
    L8:
        if (r2 >= r7.length) goto L16;
        double r3 = r7[r2];
        if (Doubles.isFinite(r3) == true) goto L12;
    L14:
        r1 = StatsAccumulator.calculateNewMeanNonFinite(r1, r3);
    L15:
        r2 = r2 + 1;
        goto L8
    L12:
        if (Doubles.isFinite(r1) == false) goto L14;
        r1 = r1 + ((r3 - r1) / ((double) (r2 + 1)));
        goto L15
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static double meanOf(long... r7) {
        int r2 = 1;
        if (r7.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        double r1 = r7[0];
    L8:
        if (r2 >= r7.length) goto L16;
        double r3 = r7[r2];
        if (Doubles.isFinite(r3) == true) goto L12;
    L14:
        r1 = StatsAccumulator.calculateNewMeanNonFinite(r1, r3);
    L15:
        r2 = r2 + 1;
        goto L8
    L12:
        if (Doubles.isFinite(r1) == false) goto L14;
        r1 = r1 + ((r3 - r1) / ((double) (r2 + 1)));
        goto L15
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public byte[] toByteArray() {
        ByteBuffer r0 = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(r0);
        return r0.array();
    }

    void writeTo(ByteBuffer r5) {
        Preconditions.checkNotNull(r5);
        if (r5.remaining() < 40) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Expected at least Stats.BYTES = %s remaining , got %s", 40, r5.remaining());
        r5.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static Stats fromByteArray(byte[] r4) {
        Preconditions.checkNotNull(r4);
        if (r4.length != 40) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Expected Stats.BYTES = %s remaining , got %s", 40, r4.length);
        return readFrom(ByteBuffer.wrap(r4).order(ByteOrder.LITTLE_ENDIAN));
    L5:
        r0 = false;
        goto L6
    }

    static Stats readFrom(ByteBuffer r15) {
        Preconditions.checkNotNull(r15);
        if (r15.remaining() < 40) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Expected at least Stats.BYTES = %s remaining , got %s", 40, r15.remaining());
        return new Stats(r15.getLong(), r15.getDouble(), r15.getDouble(), r15.getDouble(), r15.getDouble());
    L5:
        r0 = false;
        goto L6
    }
}
