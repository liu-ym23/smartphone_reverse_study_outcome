package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final long maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker;

    @Deprecated
    public static synchronized DiskCache get(File r2, long r3) {
        monitor-enter(DiskLruCacheWrapper.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (wrapper != null) goto L7;
        wrapper = new DiskLruCacheWrapper(r2, r3);     // Catch: Throwable -> L10
    L7:
        DiskLruCacheWrapper r4 = wrapper;     // Catch: Throwable -> L10
        monitor-exit(DiskLruCacheWrapper.class);
        return r4;
    }

    public static DiskCache create(File r1, long r2) {
        return new DiskLruCacheWrapper(r1, r2);
    }

    @Deprecated
    protected DiskLruCacheWrapper(File r2, long r3) {
        this.writeLocker = new DiskCacheWriteLocker();
        this.directory = r2;
        this.maxSize = r3;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.diskLruCache != null) goto L6;
        this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);     // Catch: Throwable -> L9
    L6:
        DiskLruCache r0 = this.diskLruCache;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key r5) {
        String r0 = this.safeKeyGenerator.getSafeKey(r5);
        if (Log.isLoggable(TAG, 2) == false) goto L15;
        Log.v(TAG, "Get: Obtained: " + r0 + " for for Key: " + r5);
    L15:
        DiskLruCache.Value r4 = getDiskCache().get(r0);     // Catch: IOException -> L10
        if (r4 == null) goto L17;
        return r4.getFile(0);
    L17:
        return null;
    L10:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L19;
        Log.w(TAG, "Unable to get from disk cache", e);
        return null;
    L19:
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key r6, DiskCache.Writer r7) {
        String r3 = this.safeKeyGenerator.getSafeKey(r6);
        this.writeLocker.acquire(r3);
    L29:
        th = move-exception;
        this.writeLocker.release(r3);
        throw th;
    L4:
        if (Log.isLoggable(TAG, 2) == false) goto L33;
        Log.v(TAG, "Put: Obtained: " + r3 + " for for Key: " + r6);     // Catch: Throwable -> L29
    L33:
        DiskLruCache r8 = getDiskCache();     // Catch: IOException -> L22 Throwable -> L29
        if (r8.get(r3) == null) goto L10;
        this.writeLocker.release(r3);
        return;
    L10:
        DiskLruCache.Editor r9 = r8.edit(r3);     // Catch: IOException -> L22 Throwable -> L29
        if (r9 == null) goto L21;
    L17:
        th = move-exception;
        r9.abortUnlessCommitted();     // Catch: IOException -> L22 Throwable -> L29
        throw th;     // Catch: IOException -> L22 Throwable -> L29
    L14:
        if (r7.write(r9.getFile(0)) == false) goto L16;
        r9.commit();     // Catch: Throwable -> L17
    L16:
        r9.abortUnlessCommitted();     // Catch: IOException -> L22 Throwable -> L29
    L27:
        this.writeLocker.release(r3);
        return;
    L21:
        throw new IllegalStateException("Had two simultaneous puts for: " + r3);     // Catch: IOException -> L22 Throwable -> L29
    L22:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L27;
        Log.w(TAG, "Unable to put to disk cache", e);     // Catch: Throwable -> L29
        goto L27
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key r2) {
        String r3 = this.safeKeyGenerator.getSafeKey(r2);
        getDiskCache().remove(r3);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L12;
        Log.w(TAG, "Unable to delete from disk cache", e);
        return;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        monitor-enter(this);
        getDiskCache().delete();     // Catch: Throwable -> L6 IOException -> L8
    L4:
        resetDiskCache();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L8:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L4;
        Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        resetDiskCache();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private synchronized void resetDiskCache() {
        monitor-enter(this);
        this.diskLruCache = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
