package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class Option<T> {
    private static final CacheKeyUpdater<Object> EMPTY_UPDATER = null;
    private final CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    public interface CacheKeyUpdater<T> {
        void update(byte[] r1, T r2, MessageDigest r3);
    }

    static {
        EMPTY_UPDATER = new AnonymousClass1();
    }

    public static <T> Option<T> memory(String r3) {
        return new Option(r3, null, emptyUpdater());
    }

    public static <T> Option<T> memory(String r2, T r3) {
        return new Option(r2, r3, emptyUpdater());
    }

    public static <T> Option<T> disk(String r2, CacheKeyUpdater<T> r3) {
        return new Option(r2, null, r3);
    }

    public static <T> Option<T> disk(String r1, T r2, CacheKeyUpdater<T> r3) {
        return new Option(r1, r2, r3);
    }

    private Option(String r1, T r2, CacheKeyUpdater<T> r3) {
        this.key = Preconditions.checkNotEmpty(r1);
        this.defaultValue = r2;
        this.cacheKeyUpdater = (CacheKeyUpdater) Preconditions.checkNotNull(r3);
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public void update(T r2, MessageDigest r3) {
        this.cacheKeyUpdater.update(getKeyBytes(), r2, r3);
    }

    private byte[] getKeyBytes() {
        if (this.keyBytes != null) goto L6;
        this.keyBytes = this.key.getBytes(Key.CHARSET);
    L6:
        return this.keyBytes;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof Option) == true) goto L5;
        return false;
    L5:
        return this.key.equals(((Option) r2).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    private static <T> CacheKeyUpdater<T> emptyUpdater() {
        return (CacheKeyUpdater<T>) EMPTY_UPDATER;
    }

    public String toString() {
        return "Option{key='" + this.key + "'}";
    }
}
