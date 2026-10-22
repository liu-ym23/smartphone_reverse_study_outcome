package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateCallback;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpCacheStorage implements HttpCacheStorage {
    private final CacheMap entries;

    public BasicHttpCacheStorage(CacheConfig r2) {
        this.entries = new CacheMap(r2.getMaxCacheEntries());
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public synchronized void putEntry(String r2, HttpCacheEntry r3) throws IOException {
        monitor-enter(this);
        this.entries.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public synchronized HttpCacheEntry getEntry(String r2) throws IOException {
        monitor-enter(this);
        HttpCacheEntry r3 = this.entries.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public synchronized void removeEntry(String r2) throws IOException {
        monitor-enter(this);
        this.entries.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public synchronized void updateEntry(String r3, HttpCacheUpdateCallback r4) throws IOException {
        monitor-enter(this);
        HttpCacheEntry r0 = this.entries.get(r3);     // Catch: Throwable -> L6
        this.entries.put(r3, r4.update(r0));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
