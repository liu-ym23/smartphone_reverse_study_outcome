package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class LruArrayPool implements ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final GroupedLinkedMap<Key, Object> groupedMap;
    private final KeyPool keyPool;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    private static final class Key implements Poolable {
        private Class<?> arrayClass;
        private final KeyPool pool;
        int size;

        Key(KeyPool r1) {
            this.pool = r1;
        }

        void init(int r1, Class<?> r2) {
            this.size = r1;
            this.arrayClass = r2;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof Key) == false) goto L10;
            Key r5 = (Key) r4;
            if (this.size == r5.size) goto L7;
            return false;
        L7:
            if (this.arrayClass != r5.arrayClass) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public int hashCode() {
            int r0 = this.size * 31;
            Class<?> r1 = this.arrayClass;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }
    }

    private static final class KeyPool extends BaseKeyPool<Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        protected /* bridge */ /* synthetic */ Poolable create() {
            return create();
        }

        KeyPool() {
        }

        Key get(int r1, Class<?> r2) {
            Key r0 = get();
            r0.init(r1, r2);
            return r0;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        protected Key create() {
            return new Key(this);
        }
    }

    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    public LruArrayPool(int r2) {
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = r2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T r1, Class<T> r2) {
        put(r1);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T r5) {
        monitor-enter(this);
        Class<?> r0 = r5.getClass();     // Catch: Throwable -> L14
        ArrayAdapterInterface<T> r1 = getAdapterFromType(r0);     // Catch: Throwable -> L14
        int r2 = r1.getArrayLength(r5);     // Catch: Throwable -> L14
        int r3 = r1.getElementSizeInBytes() * r2;     // Catch: Throwable -> L14
        if (isSmallEnoughForReuse(r3) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Key r4 = this.keyPool.get(r2, r0);     // Catch: Throwable -> L14
        this.groupedMap.put(r4, r5);     // Catch: Throwable -> L14
        NavigableMap<Integer, Integer> r6 = getSizesForAdapter(r0);     // Catch: Throwable -> L14
        Integer r7 = (Integer) r6.get(Integer.valueOf(r4.size));     // Catch: Throwable -> L14
        Integer r8 = Integer.valueOf(r4.size);     // Catch: Throwable -> L14
        int r9 = 1;
        if (r7 == null) goto L11;
        r9 = 1 + r7.intValue();     // Catch: Throwable -> L14
    L11:
        r6.put(r8, Integer.valueOf(r9));     // Catch: Throwable -> L14
        this.currentSize += r3;     // Catch: Throwable -> L14
        evict();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int r2, Class<T> r3) {
        monitor-enter(this);
        T r4 = (T) getForKey(this.keyPool.get(r2, r3), r3);
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int r3, Class<T> r4) {
        monitor-enter(this);
        Integer r0 = getSizesForAdapter(r4).ceilingKey(Integer.valueOf(r3));     // Catch: Throwable -> L10
        if (mayFillRequest(r3, r0) == false) goto L6;
        Key r5 = this.keyPool.get(r0.intValue(), r4);     // Catch: Throwable -> L10
    L7:
        T r6 = (T) getForKey(r5, r4);
        monitor-exit(this);
        return r6;
    L6:
        r5 = this.keyPool.get(r3, r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private <T> T getForKey(Key r6, Class<T> r7) {
        ArrayAdapterInterface<T> r0 = getAdapterFromType(r7);
        T r1 = (T) getArrayForKey(r6);
        if (r1 == null) goto L5;
        this.currentSize -= r0.getArrayLength(r1) * r0.getElementSizeInBytes();
        decrementArrayOfSize(r0.getArrayLength(r1), r7);
    L5:
        if (r1 == null) goto L7;
        return r1;
    L7:
        if (Log.isLoggable(r0.getTag(), 2) == false) goto L10;
        Log.v(r0.getTag(), "Allocated " + r6.size + " bytes");
    L10:
        return r0.newArray(r6.size);
    }

    private <T> T getArrayForKey(Key r1) {
        return (T) this.groupedMap.get(r1);
    }

    private boolean isSmallEnoughForReuse(int r1) {
        if (r1 > (this.maxSize / 2)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean mayFillRequest(int r1, Integer r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (isNoMoreThanHalfFull() == false) goto L6;
    L7:
        return true;
    L6:
        if (r2.intValue() > (r1 * 8)) goto L8;
        goto L7
    }

    private boolean isNoMoreThanHalfFull() {
        int r0 = this.currentSize;
        if (r0 != 0) goto L5;
    L8:
        return true;
    L5:
        if ((this.maxSize / r0) >= 2) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        monitor-enter(this);
        evictToSize(0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int r2) {
        monitor-enter(this);
        if (r2 < 40) goto L9;
        clearMemory();     // Catch: Throwable -> L6
    L17:
    L13:
        monitor-exit(this);
        return;
    L9:
        if (r2 < 20) goto L11;
    L12:
        evictToSize(this.maxSize / 2);     // Catch: Throwable -> L6
        goto L17
    L11:
        if (r2 != 15) goto L13;
    L6:
        th = move-exception;
        throw th;
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int r6) {
    L3:
        if (this.currentSize <= r6) goto L7;
        Object r0 = this.groupedMap.removeLast();
        Preconditions.checkNotNull(r0);
        ArrayAdapterInterface r1 = getAdapterFromObject(r0);
        this.currentSize -= r1.getArrayLength(r0) * r1.getElementSizeInBytes();
        decrementArrayOfSize(r1.getArrayLength(r0), r0.getClass());
        if (Log.isLoggable(r1.getTag(), 2) == false) goto L3;
        Log.v(r1.getTag(), "evicted: " + r1.getArrayLength(r0));
        goto L3
    }

    private void decrementArrayOfSize(int r3, Class<?> r4) {
        NavigableMap<Integer, Integer> r5 = getSizesForAdapter(r4);
        Integer r0 = (Integer) r5.get(Integer.valueOf(r3));
        if (r0 == null) goto L10;
        if (r0.intValue() != 1) goto L7;
        r5.remove(Integer.valueOf(r3));
        return;
    L7:
        r5.put(Integer.valueOf(r3), Integer.valueOf(r0.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r3 + ", this: " + this);
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> r2) {
        NavigableMap<Integer, Integer> r0 = this.sortedSizes.get(r2);
        if (r0 != null) goto L6;
        TreeMap r1 = new TreeMap();
        this.sortedSizes.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T r1) {
        return getAdapterFromType(r1.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> r3) {
        ArrayAdapterInterface<T> r0 = (ArrayAdapterInterface) this.adapters.get(r3);
        if (r0 == null) goto L5;
    L13:
        return r0;
    L5:
        if (r3.equals(int[].class) == false) goto L8;
        r0 = new IntegerArrayAdapter();
    L10:
        this.adapters.put(r3, r0);
        goto L13
    L8:
        if (r3.equals(byte[].class) == false) goto L12;
        r0 = new ByteArrayAdapter();
        goto L10
    L12:
        throw new IllegalArgumentException("No array pool found for: " + r3.getSimpleName());
    }

    int getCurrentSize() {
        Iterator<Class<?>> r0 = this.sortedSizes.keySet().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Class<?> r2 = r0.next();
        Iterator<Integer> r3 = this.sortedSizes.get(r2).keySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        Integer r4 = r3.next();
        ArrayAdapterInterface r5 = getAdapterFromType(r2);
        r1 = r1 + ((r4.intValue() * ((Integer) this.sortedSizes.get(r2).get(r4)).intValue()) * r5.getElementSizeInBytes());
        goto L7
    L9:
        return r1;
    }
}
