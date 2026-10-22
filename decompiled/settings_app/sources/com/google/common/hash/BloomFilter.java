package com.google.common.hash;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* JADX INFO: renamed from: com.google.common.hash.BloomFilter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> r2) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(BloomFilter.access$000(r2).data);
            this.numHashFunctions = BloomFilter.access$100(r2);
            this.funnel = BloomFilter.access$200(r2);
            this.strategy = BloomFilter.access$300(r2);
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }
    }

    interface Strategy extends Serializable {
        <T> boolean mightContain(@ParametricNullness T r1, Funnel<? super T> r2, int r3, BloomFilterStrategies.LockFreeBitArray r4);

        int ordinal();

        <T> boolean put(@ParametricNullness T r1, Funnel<? super T> r2, int r3, BloomFilterStrategies.LockFreeBitArray r4);
    }

    /* synthetic */ BloomFilter(BloomFilterStrategies.LockFreeBitArray r1, int r2, Funnel r3, Strategy r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    static /* synthetic */ BloomFilterStrategies.LockFreeBitArray access$000(BloomFilter r0) {
        return r0.bits;
    }

    static /* synthetic */ int access$100(BloomFilter r0) {
        return r0.numHashFunctions;
    }

    static /* synthetic */ Funnel access$200(BloomFilter r0) {
        return r0.funnel;
    }

    static /* synthetic */ Strategy access$300(BloomFilter r0) {
        return r0.strategy;
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray r5, int r6, Funnel<? super T> r7, Strategy r8) {
        boolean r0 = true;
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "numHashFunctions (%s) must be > 0", r6);
        if (r6 <= 255) goto L10;
        r0 = false;
    L10:
        Preconditions.checkArgument(r0, "numHashFunctions (%s) must be <= 255", r6);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(r5);
        this.numHashFunctions = r6;
        this.funnel = (Funnel) Preconditions.checkNotNull(r7);
        this.strategy = (Strategy) Preconditions.checkNotNull(r8);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public BloomFilter<T> copy() {
        return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean mightContain(@ParametricNullness T r4) {
        return this.strategy.mightContain(r4, this.funnel, this.numHashFunctions, this.bits);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(@ParametricNullness T r1) {
        return mightContain(r1);
    }

    public boolean put(@ParametricNullness T r4) {
        return this.strategy.put(r4, this.funnel, this.numHashFunctions, this.bits);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
    }

    public long approximateElementCount() {
        double r0 = this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(this.bits.bitCount() / r0))) * r0) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    long bitSize() {
        return this.bits.bitSize();
    }

    public boolean isCompatible(BloomFilter<T> r5) {
        Preconditions.checkNotNull(r5);
        if (this != r5) goto L5;
    L13:
        return false;
    L5:
        if (this.numHashFunctions != r5.numHashFunctions) goto L13;
        if (bitSize() != r5.bitSize()) goto L13;
        if (this.strategy.equals(r5.strategy) == false) goto L13;
        if (this.funnel.equals(r5.funnel) == false) goto L13;
        return true;
    }

    public void putAll(BloomFilter<T> r10) {
        Preconditions.checkNotNull(r10);
        if (this == r10) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "Cannot combine a BloomFilter with itself.");
        int r3 = this.numHashFunctions;
        int r4 = r10.numHashFunctions;
        if (r3 != r4) goto L9;
        boolean r5 = true;
    L10:
        Preconditions.checkArgument(r5, "BloomFilters must have the same number of hash functions (%s != %s)", r3, r4);
        if (bitSize() != r10.bitSize()) goto L13;
        boolean r6 = true;
    L14:
        Preconditions.checkArgument(r6, "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), r10.bitSize());
        Preconditions.checkArgument(this.strategy.equals(r10.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, r10.strategy);
        Preconditions.checkArgument(this.funnel.equals(r10.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, r10.funnel);
        this.bits.putAll(r10.bits);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof BloomFilter) == false) goto L18;
        BloomFilter r6 = (BloomFilter) r5;
        if (this.numHashFunctions != r6.numHashFunctions) goto L17;
        if (this.funnel.equals(r6.funnel) == false) goto L17;
        if (this.bits.equals(r6.bits) == false) goto L17;
        if (this.strategy.equals(r6.strategy) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> r2, long r3) {
        return toBloomFilter(r2, r3, 0.03d);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(final Funnel<? super T> r11, final long r12, final double r14) {
        Preconditions.checkNotNull(r11);
        if (r12 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Expected insertions (%s) must be >= 0", r12);
        if (r14 <= 0.0d) goto L9;
        boolean r1 = true;
    L10:
        Preconditions.checkArgument(r1, "False positive probability (%s) must be > 0.0", Double.valueOf(r14));
        if (r14 >= 1.0d) goto L13;
        boolean r2 = true;
    L14:
        Preconditions.checkArgument(r2, "False positive probability (%s) must be < 1.0", Double.valueOf(r14));
        return Collector.of(new BloomFilter$$ExternalSyntheticLambda0(r11, r12, r14), new BloomFilter$$ExternalSyntheticLambda1(), new BloomFilter$$ExternalSyntheticLambda2(), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT});
    L13:
        r2 = false;
        goto L14
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ BloomFilter lambda$toBloomFilter$0(Funnel r0, long r1, double r3) {
        return create(r0, r1, r3);
    }

    static /* synthetic */ BloomFilter lambda$toBloomFilter$1(BloomFilter r0, BloomFilter r1) {
        r0.putAll(r1);
        return r0;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r2, int r3, double r4) {
        return create(r2, r3, r4);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r6, long r7, double r9) {
        return create(r6, r7, r9, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    static <T> BloomFilter<T> create(Funnel<? super T> r6, long r7, double r9, Strategy r11) {
        Preconditions.checkNotNull(r6);
        boolean r1 = true;
        if (r7 < 0) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkArgument(r3, "Expected insertions (%s) must be >= 0", r7);
        if (r9 <= 0.0d) goto L9;
        boolean r4 = true;
    L10:
        Preconditions.checkArgument(r4, "False positive probability (%s) must be > 0.0", Double.valueOf(r9));
        if (r9 < 1.0d) goto L14;
        r1 = false;
    L14:
        Preconditions.checkArgument(r1, "False positive probability (%s) must be < 1.0", Double.valueOf(r9));
        Preconditions.checkNotNull(r11);
        if (r7 != 0) goto L17;
        r7 = 1;
    L17:
        long r10 = optimalNumOfBits(r7, r9);
        return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(r10), optimalNumOfHashFunctions(r7, r10), r6, r11);
    L20:
        e = move-exception;
        throw new IllegalArgumentException(new StringBuilder(57).append("Could not create BloomFilter of ").append(r10).append(" bits").toString(), e);
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r2, int r3) {
        return create(r2, r3);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r2, long r3) {
        return create(r2, r3, 0.03d);
    }

    static int optimalNumOfHashFunctions(long r0, long r2) {
        return Math.max(1, (int) Math.round((r2 / r0) * Math.log(2.0d)));
    }

    static long optimalNumOfBits(long r2, double r4) {
        if (r4 != 0.0d) goto L6;
        r4 = Double.MIN_VALUE;
    L6:
        return (long) (((-r2) * Math.log(r4)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    public void writeTo(OutputStream r4) throws IOException {
        DataOutputStream r0 = new DataOutputStream(r4);
        r0.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        r0.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        r0.writeInt(this.bits.data.length());
        int r5 = 0;
    L4:
        if (r5 >= this.bits.data.length()) goto L6;
        r0.writeLong(this.bits.data.get(r5));
        r5 = r5 + 1;
        goto L4
    }

    public static <T> BloomFilter<T> readFrom(InputStream r9, Funnel<? super T> r10) throws IOException {
        Preconditions.checkNotNull(r9, "InputStream");
        Preconditions.checkNotNull(r10, "Funnel");
        int r0 = -1;
        DataInputStream r1 = new DataInputStream(r9);     // Catch: RuntimeException -> L14
        byte r11 = r1.readByte();     // Catch: RuntimeException -> L14
        int r2 = UnsignedBytes.toInt(r1.readByte());     // Catch: RuntimeException -> L12
        r0 = r1.readInt();     // Catch: RuntimeException -> L10
        BloomFilterStrategies r3 = BloomFilterStrategies.values()[r11];     // Catch: RuntimeException -> L10
        long[] r4 = new long[r0];     // Catch: RuntimeException -> L10
        int r5 = 0;
    L6:
        if (r5 >= r0) goto L8;
        r4[r5] = r1.readLong();     // Catch: RuntimeException -> L10
        r5 = r5 + 1;     // Catch: RuntimeException -> L10
        goto L6
    L8:
        return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(r4), r2, r10, r3);
    L10:
        e = e;
        int r8 = r0;
        r0 = r11;
        int r12 = r8;
    L17:
        throw new IOException(new StringBuilder(134).append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ").append(r0).append(" numHashFunctions: ").append(r2).append(" dataLength: ").append(r12).toString(), e);
    L12:
        e = e;
        r2 = -1;
        r0 = r11;
        r12 = -1;
    L14:
        e = e;
        r12 = -1;
        r2 = -1;
        goto L17
    }
}
