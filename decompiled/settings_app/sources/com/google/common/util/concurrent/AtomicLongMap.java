package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class AtomicLongMap<K> implements Serializable {

    @CheckForNull
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, Long> map;

    public static /* synthetic */ long $r8$lambda$UBRSyPJ3VlOcJeQkp7RT_cF4kcw(long r0, long r2) {
        return Long.sum(r0, r2);
    }

    public static /* synthetic */ long $r8$lambda$uAjrY3NI4r9F1o9CaCMzj_QnUcY(Long r2) {
        return r2.longValue();
    }

    static /* synthetic */ long lambda$put$4(long r0, long r2) {
        return r0;
    }

    private AtomicLongMap(ConcurrentHashMap<K, Long> r1) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(r1);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> r1) {
        AtomicLongMap<K> r0 = create();
        r0.putAll(r1);
        return r0;
    }

    public long get(K r3) {
        return this.map.getOrDefault(r3, 0L).longValue();
    }

    public long incrementAndGet(K r3) {
        return addAndGet(r3, 1);
    }

    public long decrementAndGet(K r3) {
        return addAndGet(r3, -1);
    }

    public long addAndGet(K r2, long r3) {
        return accumulateAndGet(r2, r3, new AtomicLongMap$$ExternalSyntheticLambda4());
    }

    public long getAndIncrement(K r3) {
        return getAndAdd(r3, 1);
    }

    public long getAndDecrement(K r3) {
        return getAndAdd(r3, -1);
    }

    public long getAndAdd(K r2, long r3) {
        return getAndAccumulate(r2, r3, new AtomicLongMap$$ExternalSyntheticLambda4());
    }

    public long updateAndGet(K r2, final LongUnaryOperator r3) {
        Preconditions.checkNotNull(r3);
        return this.map.compute(r2, new AtomicLongMap$$ExternalSyntheticLambda1(r3)).longValue();
    }

    static /* synthetic */ Long lambda$updateAndGet$0(LongUnaryOperator r0, Object r1, Long r2) {
        if (r2 != null) goto L4;
        long r3 = 0;
    L6:
        return Long.valueOf(r0.applyAsLong(r3));
    L4:
        r3 = r2.longValue();
        goto L6
    }

    public long getAndUpdate(K r3, final LongUnaryOperator r4) {
        Preconditions.checkNotNull(r4);
        final AtomicLong r0 = new AtomicLong();
        this.map.compute(r3, new AtomicLongMap$$ExternalSyntheticLambda3(r0, r4));
        return r0.get();
    }

    static /* synthetic */ Long lambda$getAndUpdate$1(AtomicLong r0, LongUnaryOperator r1, Object r2, Long r3) {
        if (r3 != null) goto L4;
        long r4 = 0;
    L5:
        r0.set(r4);
        return Long.valueOf(r1.applyAsLong(r4));
    L4:
        r4 = r3.longValue();
        goto L5
    }

    public long accumulateAndGet(K r2, final long r3, final LongBinaryOperator r5) {
        Preconditions.checkNotNull(r5);
        return updateAndGet(r2, new AtomicLongMap$$ExternalSyntheticLambda6(r5, r3));
    }

    static /* synthetic */ long lambda$accumulateAndGet$2(LongBinaryOperator r0, long r1, long r3) {
        return r0.applyAsLong(r3, r1);
    }

    public long getAndAccumulate(K r2, final long r3, final LongBinaryOperator r5) {
        Preconditions.checkNotNull(r5);
        return getAndUpdate(r2, new AtomicLongMap$$ExternalSyntheticLambda9(r5, r3));
    }

    static /* synthetic */ long lambda$getAndAccumulate$3(LongBinaryOperator r0, long r1, long r3) {
        return r0.applyAsLong(r3, r1);
    }

    public long put(K r2, final long r3) {
        return getAndUpdate(r2, new AtomicLongMap$$ExternalSyntheticLambda0(r3));
    }

    public void putAll(Map<? extends K, ? extends Long> r2) {
        r2.forEach(new AtomicLongMap$$ExternalSyntheticLambda8(this));
    }

    public long remove(K r1) {
        Long r0 = this.map.remove(r1);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.longValue();
    }

    boolean remove(K r1, long r2) {
        return this.map.remove(r1, Long.valueOf(r2));
    }

    public boolean removeIfZero(K r3) {
        return remove(r3, 0);
    }

    static /* synthetic */ boolean lambda$removeAllZeros$5(Long r4) {
        if (r4.longValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void removeAllZeros() {
        this.map.values().removeIf(new AtomicLongMap$$ExternalSyntheticLambda7());
    }

    public long sum() {
        return this.map.values().stream().mapToLong(new AtomicLongMap$$ExternalSyntheticLambda5()).sum();
    }

    public Map<K, Long> asMap() {
        Map<K, Long> r0 = this.asMap;
        if (r0 != null) goto L6;
        Map<K, Long> r1 = createAsMap();
        this.asMap = r1;
        return r1;
    L6:
        return r0;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(this.map);
    }

    public boolean containsKey(Object r1) {
        return this.map.containsKey(r1);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }

    long putIfAbsent(K r3, final long r4) {
        final AtomicBoolean r0 = new AtomicBoolean(false);
        Long r2 = this.map.compute(r3, new AtomicLongMap$$ExternalSyntheticLambda2(r0, r4));
        if (r0.get() == false) goto L6;
        return 0;
    L6:
        return r2.longValue();
    }

    static /* synthetic */ Long lambda$putIfAbsent$6(AtomicBoolean r4, long r5, Object r7, Long r8) {
        if (r8 != null) goto L4;
    L7:
        r4.set(true);
        return Long.valueOf(r5);
    L4:
        if (r8.longValue() == 0) goto L7;
        return r8;
    }

    boolean replace(K r4, long r5, long r7) {
        if (r5 != 0) goto L10;
        if (putIfAbsent(r4, r7) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.map.replace(r4, Long.valueOf(r5), Long.valueOf(r7));
    }
}
