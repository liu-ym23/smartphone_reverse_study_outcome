package com.google.common.collect;

import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean supportsFastOffset;

    /* JADX INFO: renamed from: com.google.common.collect.DiscreteDomain$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
        private static final BigIntegerDomain INSTANCE = null;
        private static final BigInteger MAX_LONG = null;
        private static final BigInteger MIN_LONG = null;
        private static final long serialVersionUID = 0;

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }

        static /* synthetic */ BigIntegerDomain access$300() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r1, Comparable r2) {
            return distance((BigInteger) r1, (BigInteger) r2);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable next(Comparable r1) {
            return next((BigInteger) r1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* bridge */ /* synthetic */ Comparable offset(Comparable r1, long r2) {
            return offset((BigInteger) r1, r2);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r1) {
            return previous((BigInteger) r1);
        }

        static {
            INSTANCE = new BigIntegerDomain();
            MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
            MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        }

        BigIntegerDomain() {
            super(true, null);
        }

        public BigInteger next(BigInteger r1) {
            return r1.add(BigInteger.ONE);
        }

        public BigInteger previous(BigInteger r1) {
            return r1.subtract(BigInteger.ONE);
        }

        BigInteger offset(BigInteger r1, long r2) {
            CollectPreconditions.checkNonnegative(r2, RealFpsTracer.SCROLL_DISTANCE);
            return r1.add(BigInteger.valueOf(r2));
        }

        public long distance(BigInteger r1, BigInteger r2) {
            return r2.subtract(r1).max(MIN_LONG).min(MAX_LONG).longValue();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
        private static final IntegerDomain INSTANCE = null;
        private static final long serialVersionUID = 0;

        public String toString() {
            return "DiscreteDomain.integers()";
        }

        static /* synthetic */ IntegerDomain access$000() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r1, Comparable r2) {
            return distance((Integer) r1, (Integer) r2);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable maxValue() {
            return maxValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable minValue() {
            return minValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        public /* bridge */ /* synthetic */ Comparable next(Comparable r1) {
            return next((Integer) r1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* bridge */ /* synthetic */ Comparable offset(Comparable r1, long r2) {
            return offset((Integer) r1, r2);
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r1) {
            return previous((Integer) r1);
        }

        static {
            INSTANCE = new IntegerDomain();
        }

        IntegerDomain() {
            super(true, null);
        }

        @CheckForNull
        public Integer next(Integer r1) {
            int r0 = r1.intValue();
            if (r0 != Integer.MAX_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r0 + 1);
        }

        @CheckForNull
        public Integer previous(Integer r1) {
            int r0 = r1.intValue();
            if (r0 != Integer.MIN_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r0 - 1);
        }

        Integer offset(Integer r1, long r2) {
            CollectPreconditions.checkNonnegative(r2, RealFpsTracer.SCROLL_DISTANCE);
            return Integer.valueOf(Ints.checkedCast(r1.longValue() + r2));
        }

        public long distance(Integer r3, Integer r4) {
            return ((long) r4.intValue()) - ((long) r3.intValue());
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
        private static final LongDomain INSTANCE = null;
        private static final long serialVersionUID = 0;

        public String toString() {
            return "DiscreteDomain.longs()";
        }

        static /* synthetic */ LongDomain access$200() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r1, Comparable r2) {
            return distance((Long) r1, (Long) r2);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable maxValue() {
            return maxValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable minValue() {
            return minValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        public /* bridge */ /* synthetic */ Comparable next(Comparable r1) {
            return next((Long) r1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* bridge */ /* synthetic */ Comparable offset(Comparable r1, long r2) {
            return offset((Long) r1, r2);
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r1) {
            return previous((Long) r1);
        }

        static {
            INSTANCE = new LongDomain();
        }

        LongDomain() {
            super(true, null);
        }

        @CheckForNull
        public Long next(Long r3) {
            long r2 = r3.longValue();
            if (r2 != Long.MAX_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r2 + 1);
        }

        @CheckForNull
        public Long previous(Long r3) {
            long r2 = r3.longValue();
            if (r2 != Long.MIN_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r2 - 1);
        }

        Long offset(Long r3, long r4) {
            CollectPreconditions.checkNonnegative(r4, RealFpsTracer.SCROLL_DISTANCE);
            long r0 = r3.longValue() + r4;
            if (r0 >= 0) goto L10;
            if (r3.longValue() >= 0) goto L7;
            boolean r2 = true;
        L8:
            Preconditions.checkArgument(r2, "overflow");
            goto L10
        L7:
            r2 = false;
        L10:
            return Long.valueOf(r0);
        }

        public long distance(Long r7, Long r8) {
            long r0 = r8.longValue() - r7.longValue();
            if (r8.longValue() <= r7.longValue()) goto L9;
            if (r0 >= 0) goto L9;
            return Long.MAX_VALUE;
        L9:
            if (r8.longValue() < r7.longValue()) goto L11;
        L14:
            return r0;
        L11:
            if (r0 <= 0) goto L14;
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public abstract long distance(C r1, C r2);

    @CheckForNull
    public abstract C next(C r1);

    @CheckForNull
    public abstract C previous(C r1);

    /* synthetic */ DiscreteDomain(boolean r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.access$000();
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.access$200();
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.access$300();
    }

    protected DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean r1) {
        this.supportsFastOffset = r1;
    }

    C offset(C r6, long r7) {
        CollectPreconditions.checkNonnegative(r7, RealFpsTracer.SCROLL_DISTANCE);
        long r0 = 0;
        C r2 = r6;
    L4:
        if (r0 >= r7) goto L10;
        r2 = (C) next(r2);
        if (r2 == null) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        String r8 = String.valueOf(r6);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r8).length() + 51).append("overflowed computing offset(").append(r8).append(", ").append(r7).append(")").toString());
    L10:
        return r2;
    }

    public C minValue() {
        throw new NoSuchElementException();
    }

    public C maxValue() {
        throw new NoSuchElementException();
    }
}
