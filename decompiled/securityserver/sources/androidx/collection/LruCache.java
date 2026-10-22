package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

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
    public V create(@NonNull K r1) {
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

    public void entryRemoved(boolean r1, @NonNull K r2, @NonNull V r3, @Nullable V r4) {
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
        if (r5 == null) goto L35;
        monitor-enter(this);
        V r0 = this.map.get(r5);     // Catch: Throwable -> L9
        if (r0 == null) goto L11;
        this.hitCount++;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L11:
        this.missCount++;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        V r1 = create(r5);
        if (r1 != null) goto L17;
        return null;
    L17:
        monitor-enter(this);
        this.createCount++;     // Catch: Throwable -> L21
        V r2 = this.map.put(r5, r1);     // Catch: Throwable -> L21
        if (r2 == null) goto L23;
        this.map.put(r5, r2);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L21
        if (r2 == null) goto L28;
        entryRemoved(false, r5, r1, r2);
        return r2;
    L28:
        trimToSize(this.maxSize);
        return r1;
    L23:
        this.size += safeSizeOf(r5, r1);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    L35:
        throw new NullPointerException("key == null");
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
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        monitor-enter(this);
        this.putCount++;     // Catch: Throwable -> L8
        this.size += safeSizeOf(r4, r5);     // Catch: Throwable -> L8
        V r0 = this.map.put(r4, r5);     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        this.size -= safeSizeOf(r4, r0);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r0 == null) goto L13;
        entryRemoved(false, r4, r0, r5);
    L13:
        trimToSize(this.maxSize);
        return r0;
    L8:
        th = move-exception;
        throw th;
    L18:
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
        if (r4 == null) goto L16;
        monitor-enter(this);
        V r0 = this.map.remove(r4);     // Catch: Throwable -> L7
        if (r0 == null) goto L9;
        this.size -= safeSizeOf(r4, r0);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r0 == null) goto L12;
        entryRemoved(false, r4, r0, null);
    L12:
        return r0;
    L7:
        th = move-exception;
        throw th;
    L16:
        throw new NullPointerException("key == null");
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

    public int sizeOf(@NonNull K r1, @NonNull V r2) {
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
        int r1 = this.hitCount;     // Catch: Throwable -> L7
        int r2 = this.missCount + r1;     // Catch: Throwable -> L7
        if (r2 == 0) goto L9;
        int r3 = (r1 * 100) / r2;     // Catch: Throwable -> L7
    L10:
        Locale r4 = Locale.US;     // Catch: Throwable -> L7
        String r0 = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + r3 + "%]";     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L9:
        r3 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    public void trimToSize(int r5) {
    L2:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.size < 0) goto L23;
        if (this.map.isEmpty() == false) goto L13;
        if (this.size != 0) goto L23;
    L13:
        if (this.size <= r5) goto L20;
        if (this.map.isEmpty() == true) goto L20;
        Map.Entry<K, V> r0 = this.map.entrySet().iterator().next();     // Catch: Throwable -> L10
        K r1 = r0.getKey();     // Catch: Throwable -> L10
        V r2 = r0.getValue();     // Catch: Throwable -> L10
        this.map.remove(r1);     // Catch: Throwable -> L10
        this.size -= safeSizeOf(r1, r2);     // Catch: Throwable -> L10
        this.evictionCount++;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        entryRemoved(true, r1, r2, null);
    L20:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L23:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L10
    }
}
