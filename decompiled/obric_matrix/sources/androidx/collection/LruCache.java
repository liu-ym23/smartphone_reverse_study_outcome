package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int r4) {
        if (r4 <= 0) goto L7;
        this.maxSize = r4;
        this.map = new LinkedHashMap(0, 0.75f, true);
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int safeSizeOf(K r3, V r4) {
        int r2 = sizeOf(r3, r4);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Negative size: " + r3 + "=" + r4);
    }

    @Nullable
    protected V create(@NonNull K r1) {
        return null;
    }

    public final synchronized int createCount() {
        monitor-enter(this);
        int r0 = this.createCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected void entryRemoved(boolean r1, @NonNull K r2, @NonNull V r3, @Nullable V r4) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        monitor-enter(this);
        int r0 = this.evictionCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V get(@NonNull K r5) {
        Objects.requireNonNull(r5, "key == null");
        monitor-enter(this);
        V r0 = this.map.get(r5);     // Catch: Throwable -> L29
        if (r0 == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        return r0;
    L9:
        this.missCount++;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        V r1 = create(r5);
        if (r1 != null) goto L15;
        return null;
    L15:
        monitor-enter(this);
        this.createCount++;     // Catch: Throwable -> L26
        V r2 = this.map.put(r5, r1);     // Catch: Throwable -> L26
        if (r2 == null) goto L19;
        this.map.put(r5, r2);     // Catch: Throwable -> L26
    L20:
        monitor-exit(this);     // Catch: Throwable -> L26
        if (r2 == null) goto L24;
        entryRemoved(false, r5, r1, r2);
        return r2;
    L24:
        trimToSize(this.maxSize);
        return r1;
    L19:
        this.size += safeSizeOf(r5, r1);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    public final synchronized int hitCount() {
        monitor-enter(this);
        int r0 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int maxSize() {
        monitor-enter(this);
        int r0 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int missCount() {
        monitor-enter(this);
        int r0 = this.missCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V put(@NonNull K r4, @NonNull V r5) {
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        monitor-enter(this);
        this.putCount++;     // Catch: Throwable -> L13
        this.size += safeSizeOf(r4, r5);     // Catch: Throwable -> L13
        V r0 = this.map.put(r4, r5);     // Catch: Throwable -> L13
        if (r0 == null) goto L8;
        this.size -= safeSizeOf(r4, r0);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        entryRemoved(false, r4, r0, r5);
    L11:
        trimToSize(this.maxSize);
        return r0;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new NullPointerException("key == null || value == null");
    }

    public final synchronized int putCount() {
        monitor-enter(this);
        int r0 = this.putCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V remove(@NonNull K r4) {
        Objects.requireNonNull(r4, "key == null");
        monitor-enter(this);
        V r0 = this.map.remove(r4);     // Catch: Throwable -> L11
        if (r0 == null) goto L7;
        this.size -= safeSizeOf(r4, r0);     // Catch: Throwable -> L11
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r0 == null) goto L10;
        entryRemoved(false, r4, r0, null);
    L10:
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    public void resize(int r1) {
        if (r1 <= 0) goto L12;
        monitor-enter(this);
        this.maxSize = r1;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        trimToSize(r1);
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized int size() {
        monitor-enter(this);
        int r0 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected int sizeOf(@NonNull K r1, @NonNull V r2) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        monitor-enter(this);
        LinkedHashMap r0 = new LinkedHashMap(this.map);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r0 = this.hitCount;     // Catch: Throwable -> L10
        int r1 = this.missCount + r0;     // Catch: Throwable -> L10
        if (r1 == 0) goto L6;
        int r2 = (r0 * 100) / r1;     // Catch: Throwable -> L10
    L7:
        String r3 = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(r2)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L6:
        r2 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public void trimToSize(int r5) {
    L2:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.size < 0) goto L20;
        if (this.map.isEmpty() == false) goto L10;
        if (this.size != 0) goto L20;
    L10:
        if (this.size <= r5) goto L17;
        if (this.map.isEmpty() == true) goto L17;
        Map.Entry<K, V> r0 = this.map.entrySet().iterator().next();     // Catch: Throwable -> L21
        K r1 = r0.getKey();     // Catch: Throwable -> L21
        V r2 = r0.getValue();     // Catch: Throwable -> L21
        this.map.remove(r1);     // Catch: Throwable -> L21
        this.size -= safeSizeOf(r1, r2);     // Catch: Throwable -> L21
        this.evictionCount++;     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        entryRemoved(true, r1, r2, null);
    L17:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L20:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L21
    }
}
