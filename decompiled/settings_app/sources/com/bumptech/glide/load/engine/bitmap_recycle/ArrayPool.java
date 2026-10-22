package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes3.dex */
public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 65536;

    void clearMemory();

    <T> T get(int r1, Class<T> r2);

    <T> T getExact(int r1, Class<T> r2);

    <T> void put(T r1);

    @Deprecated
    <T> void put(T r1, Class<T> r2);

    void trimMemory(int r1);
}
