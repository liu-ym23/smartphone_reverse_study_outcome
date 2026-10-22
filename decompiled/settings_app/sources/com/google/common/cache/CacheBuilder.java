package com.google.common.cache;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.errorprone.annotations.CheckReturnValue;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class CacheBuilder<K, V> {
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = null;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final CacheStats EMPTY_STATS = null;
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = null;
    static final Ticker NULL_TICKER = null;
    static final int UNSET_INT = -1;
    private static final Logger logger = null;
    int concurrencyLevel;
    long expireAfterAccessNanos;
    long expireAfterWriteNanos;
    int initialCapacity;
    Equivalence<Object> keyEquivalence;
    LocalCache.Strength keyStrength;
    long maximumSize;
    long maximumWeight;
    long refreshNanos;
    RemovalListener<? super K, ? super V> removalListener;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier;
    boolean strictParsing;
    Ticker ticker;
    Equivalence<Object> valueEquivalence;
    LocalCache.Strength valueStrength;
    Weigher<? super K, ? super V> weigher;

    static final enum NullListener extends Enum<NullListener> implements RemovalListener<Object, Object> {
        private static final /* synthetic */ NullListener[] $VALUES = null;
        public static final NullListener INSTANCE = null;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> r1) {
        }

        private static /* synthetic */ NullListener[] $values() {
            return new NullListener[]{INSTANCE};
        }

        private NullListener(String r1, int r2) {
            super(r1, r2);
        }

        public static NullListener valueOf(String r1) {
            return (NullListener) Enum.valueOf(NullListener.class, r1);
        }

        public static NullListener[] values() {
            return (NullListener[]) $VALUES.clone();
        }

        static {
            INSTANCE = new NullListener("INSTANCE", 0);
            $VALUES = $values();
        }
    }

    static final enum OneWeigher extends Enum<OneWeigher> implements Weigher<Object, Object> {
        private static final /* synthetic */ OneWeigher[] $VALUES = null;
        public static final OneWeigher INSTANCE = null;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object r1, Object r2) {
            return 1;
        }

        private static /* synthetic */ OneWeigher[] $values() {
            return new OneWeigher[]{INSTANCE};
        }

        private OneWeigher(String r1, int r2) {
            super(r1, r2);
        }

        public static OneWeigher valueOf(String r1) {
            return (OneWeigher) Enum.valueOf(OneWeigher.class, r1);
        }

        public static OneWeigher[] values() {
            return (OneWeigher[]) $VALUES.clone();
        }

        static {
            INSTANCE = new OneWeigher("INSTANCE", 0);
            $VALUES = $values();
        }
    }

    static {
        NULL_STATS_COUNTER = Suppliers.ofInstance(new AnonymousClass1());
        EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
        CACHE_STATS_COUNTER = new AnonymousClass2();
        NULL_TICKER = new AnonymousClass3();
        logger = Logger.getLogger(CacheBuilder.class.getName());
    }

    private CacheBuilder() {
        this.strictParsing = true;
        this.initialCapacity = -1;
        this.concurrencyLevel = -1;
        this.maximumSize = -1;
        this.maximumWeight = -1;
        this.expireAfterWriteNanos = -1;
        this.expireAfterAccessNanos = -1;
        this.refreshNanos = -1;
        this.statsCounterSupplier = NULL_STATS_COUNTER;
    }

    @CheckReturnValue
    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder();
    }

    @CheckReturnValue
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec r0) {
        return r0.toCacheBuilder().lenientParsing();
    }

    @CheckReturnValue
    public static CacheBuilder<Object, Object> from(String r0) {
        return from(CacheBuilderSpec.parse(r0));
    }

    CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    CacheBuilder<K, V> keyEquivalence(Equivalence<Object> r4) {
        Equivalence<Object> r0 = this.keyEquivalence;
        if (r0 != null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "key equivalence was already set to %s", r0);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(r4);
        return this;
    L5:
        r1 = false;
        goto L6
    }

    Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    CacheBuilder<K, V> valueEquivalence(Equivalence<Object> r4) {
        Equivalence<Object> r0 = this.valueEquivalence;
        if (r0 != null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "value equivalence was already set to %s", r0);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(r4);
        return this;
    L5:
        r1 = false;
        goto L6
    }

    Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public CacheBuilder<K, V> initialCapacity(int r6) {
        int r0 = this.initialCapacity;
        boolean r2 = true;
        if (r0 != (-1)) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "initial capacity was already set to %s", r0);
        if (r6 >= 0) goto L10;
        r2 = false;
    L10:
        Preconditions.checkArgument(r2);
        this.initialCapacity = r6;
        return this;
    L5:
        r1 = false;
        goto L6
    }

    int getInitialCapacity() {
        int r1 = this.initialCapacity;
        if (r1 != (-1)) goto L6;
        return 16;
    L6:
        return r1;
    }

    public CacheBuilder<K, V> concurrencyLevel(int r6) {
        int r0 = this.concurrencyLevel;
        boolean r2 = true;
        if (r0 != (-1)) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "concurrency level was already set to %s", r0);
        if (r6 > 0) goto L10;
        r2 = false;
    L10:
        Preconditions.checkArgument(r2);
        this.concurrencyLevel = r6;
        return this;
    L5:
        r1 = false;
        goto L6
    }

    int getConcurrencyLevel() {
        int r1 = this.concurrencyLevel;
        if (r1 != (-1)) goto L6;
        return 4;
    L6:
        return r1;
    }

    public CacheBuilder<K, V> maximumSize(long r9) {
        long r0 = this.maximumSize;
        boolean r5 = true;
        if (r0 != (-1)) goto L5;
        boolean r4 = true;
    L6:
        Preconditions.checkState(r4, "maximum size was already set to %s", r0);
        long r1 = this.maximumWeight;
        if (r1 != (-1)) goto L9;
        boolean r2 = true;
    L10:
        Preconditions.checkState(r2, "maximum weight was already set to %s", r1);
        if (this.weigher != null) goto L13;
        boolean r3 = true;
    L14:
        Preconditions.checkState(r3, "maximum size can not be combined with weigher");
        if (r9 >= 0) goto L18;
        r5 = false;
    L18:
        Preconditions.checkArgument(r5, "maximum size must not be negative");
        this.maximumSize = r9;
        return this;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    public CacheBuilder<K, V> maximumWeight(long r9) {
        long r0 = this.maximumWeight;
        boolean r5 = true;
        if (r0 != (-1)) goto L5;
        boolean r4 = true;
    L6:
        Preconditions.checkState(r4, "maximum weight was already set to %s", r0);
        long r1 = this.maximumSize;
        if (r1 != (-1)) goto L9;
        boolean r2 = true;
    L10:
        Preconditions.checkState(r2, "maximum size was already set to %s", r1);
        if (r9 >= 0) goto L14;
        r5 = false;
    L14:
        Preconditions.checkArgument(r5, "maximum weight must not be negative");
        this.maximumWeight = r9;
        return this;
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> r8) {
        boolean r1 = true;
        if (this.weigher != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        if (this.strictParsing == false) goto L13;
        long r3 = this.maximumSize;
        if (r3 == (-1)) goto L12;
        r1 = false;
    L12:
        Preconditions.checkState(r1, "weigher can not be combined with maximum size", r3);
    L13:
        this.weigher = (Weigher) Preconditions.checkNotNull(r8);
        return this;
    L5:
        r0 = false;
        goto L6
    }

    long getMaximumWeight() {
        if (this.expireAfterWriteNanos != 0) goto L5;
    L12:
        return 0;
    L5:
        if (this.expireAfterAccessNanos == 0) goto L12;
        if (this.weigher != null) goto L11;
        return this.maximumSize;
    L11:
        return this.maximumWeight;
    }

    <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    CacheBuilder<K, V> setKeyStrength(LocalCache.Strength r4) {
        LocalCache.Strength r0 = this.keyStrength;
        if (r0 != null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "Key strength was already set to %s", r0);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(r4);
        return this;
    L5:
        r1 = false;
        goto L6
    }

    LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    CacheBuilder<K, V> setValueStrength(LocalCache.Strength r4) {
        LocalCache.Strength r0 = this.valueStrength;
        if (r0 != null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "Value strength was already set to %s", r0);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(r4);
        return this;
    L5:
        r1 = false;
        goto L6
    }

    LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public CacheBuilder<K, V> expireAfterWrite(Duration r3) {
        return expireAfterWrite(toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public CacheBuilder<K, V> expireAfterWrite(long r7, TimeUnit r9) {
        long r0 = this.expireAfterWriteNanos;
        boolean r3 = true;
        if (r0 != (-1)) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "expireAfterWrite was already set to %s ns", r0);
        if (r7 >= 0) goto L10;
        r3 = false;
    L10:
        Preconditions.checkArgument(r3, "duration cannot be negative: %s %s", r7, r9);
        this.expireAfterWriteNanos = r9.toNanos(r7);
        return this;
    L5:
        r2 = false;
        goto L6
    }

    long getExpireAfterWriteNanos() {
        long r0 = this.expireAfterWriteNanos;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    public CacheBuilder<K, V> expireAfterAccess(Duration r3) {
        return expireAfterAccess(toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public CacheBuilder<K, V> expireAfterAccess(long r7, TimeUnit r9) {
        long r0 = this.expireAfterAccessNanos;
        boolean r3 = true;
        if (r0 != (-1)) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "expireAfterAccess was already set to %s ns", r0);
        if (r7 >= 0) goto L10;
        r3 = false;
    L10:
        Preconditions.checkArgument(r3, "duration cannot be negative: %s %s", r7, r9);
        this.expireAfterAccessNanos = r9.toNanos(r7);
        return this;
    L5:
        r2 = false;
        goto L6
    }

    long getExpireAfterAccessNanos() {
        long r0 = this.expireAfterAccessNanos;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    public CacheBuilder<K, V> refreshAfterWrite(Duration r3) {
        return refreshAfterWrite(toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public CacheBuilder<K, V> refreshAfterWrite(long r7, TimeUnit r9) {
        Preconditions.checkNotNull(r9);
        long r0 = this.refreshNanos;
        boolean r3 = true;
        if (r0 != (-1)) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "refresh was already set to %s ns", r0);
        if (r7 > 0) goto L10;
        r3 = false;
    L10:
        Preconditions.checkArgument(r3, "duration must be positive: %s %s", r7, r9);
        this.refreshNanos = r9.toNanos(r7);
        return this;
    L5:
        r2 = false;
        goto L6
    }

    long getRefreshNanos() {
        long r0 = this.refreshNanos;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    public CacheBuilder<K, V> ticker(Ticker r2) {
        if (this.ticker != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        this.ticker = (Ticker) Preconditions.checkNotNull(r2);
        return this;
    L5:
        r0 = false;
        goto L6
    }

    Ticker getTicker(boolean r1) {
        Ticker r0 = this.ticker;
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r1 == false) goto L8;
        return Ticker.systemTicker();
    L8:
        return NULL_TICKER;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> r2) {
        if (this.removalListener != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(r2);
        return this;
    L5:
        r0 = false;
        goto L6
    }

    <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    boolean isRecordingStats() {
        if (this.statsCounterSupplier != CACHE_STATS_COUNTER) goto L5;
        return true;
    L5:
        return false;
    }

    Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> r2) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, r2);
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }

    private void checkNonLoadingCache() {
        if (this.refreshNanos != (-1)) goto L5;
        boolean r4 = true;
    L6:
        Preconditions.checkState(r4, "refreshAfterWrite requires a LoadingCache");
        return;
    L5:
        r4 = false;
        goto L6
    }

    private void checkWeightWithWeigher() {
        boolean r1 = true;
        if (this.weigher != null) goto L10;
        if (this.maximumWeight == (-1)) goto L8;
        r1 = false;
    L8:
        Preconditions.checkState(r1, "maximumWeight requires weigher");
        return;
    L10:
        if (this.strictParsing == false) goto L17;
        if (this.maximumWeight != (-1)) goto L15;
        r1 = false;
    L15:
        Preconditions.checkState(r1, "weigher requires maximumWeight");
        return;
    L17:
        if (this.maximumWeight != (-1)) goto L22;
        logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        return;
    }

    public String toString() {
        MoreObjects.ToStringHelper r0 = MoreObjects.toStringHelper(this);
        int r1 = this.initialCapacity;
        if (r1 == (-1)) goto L5;
        r0.add("initialCapacity", r1);
    L5:
        int r2 = this.concurrencyLevel;
        if (r2 == (-1)) goto L8;
        r0.add("concurrencyLevel", r2);
    L8:
        long r3 = this.maximumSize;
        if (r3 == (-1)) goto L11;
        r0.add("maximumSize", r3);
    L11:
        long r4 = this.maximumWeight;
        if (r4 == (-1)) goto L14;
        r0.add("maximumWeight", r4);
    L14:
        long r5 = this.expireAfterWriteNanos;
        if (r5 == (-1)) goto L17;
        r0.add("expireAfterWrite", new StringBuilder(22).append(r5).append("ns").toString());
    L17:
        long r6 = this.expireAfterAccessNanos;
        if (r6 == (-1)) goto L20;
        r0.add("expireAfterAccess", new StringBuilder(22).append(r6).append("ns").toString());
    L20:
        LocalCache.Strength r7 = this.keyStrength;
        if (r7 == null) goto L23;
        r0.add("keyStrength", Ascii.toLowerCase(r7.toString()));
    L23:
        LocalCache.Strength r8 = this.valueStrength;
        if (r8 == null) goto L27;
        r0.add("valueStrength", Ascii.toLowerCase(r8.toString()));
    L27:
        if (this.keyEquivalence == null) goto L30;
        r0.addValue("keyEquivalence");
    L30:
        if (this.valueEquivalence == null) goto L33;
        r0.addValue("valueEquivalence");
    L33:
        if (this.removalListener == null) goto L36;
        r0.addValue("removalListener");
    L36:
        return r0.toString();
    }

    private static long toNanosSaturated(Duration r2) {
        return r2.toNanos();
    L5:
        if (r2.isNegative() == false) goto L7;
        return Long.MIN_VALUE;
    L7:
        return Long.MAX_VALUE;
    }
}
