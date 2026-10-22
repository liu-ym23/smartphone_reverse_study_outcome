package cz.msebera.android.httpclient.impl.client.cache;

import com.android.vcard.VCardConstants;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateCallback;
import cz.msebera.android.httpclient.util.Args;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class ManagedHttpCacheStorage implements HttpCacheStorage, Closeable {
    private final AtomicBoolean active;
    private final CacheMap entries;
    private final ReferenceQueue<HttpCacheEntry> morque;
    private final Set<ResourceReference> resources;

    public ManagedHttpCacheStorage(CacheConfig r2) {
        this.entries = new CacheMap(r2.getMaxCacheEntries());
        this.morque = new ReferenceQueue();
        this.resources = new HashSet();
        this.active = new AtomicBoolean(true);
    }

    private void ensureValidState() throws IllegalStateException {
        if (this.active.get() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cache has been shut down");
    }

    private void keepResourceReference(HttpCacheEntry r3) {
        if (r3.getResource() == null) goto L6;
        ResourceReference r0 = new ResourceReference(r3, this.morque);
        this.resources.add(r0);
        return;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public void putEntry(String r2, HttpCacheEntry r3) throws IOException {
        Args.notNull(r2, VCardConstants.PROPERTY_URL);
        Args.notNull(r3, "Cache entry");
        ensureValidState();
        monitor-enter(this);
        this.entries.put(r2, r3);     // Catch: Throwable -> L7
        keepResourceReference(r3);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public HttpCacheEntry getEntry(String r2) throws IOException {
        Args.notNull(r2, VCardConstants.PROPERTY_URL);
        ensureValidState();
        monitor-enter(this);
        HttpCacheEntry r3 = this.entries.get(r2);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public void removeEntry(String r2) throws IOException {
        Args.notNull(r2, VCardConstants.PROPERTY_URL);
        ensureValidState();
        monitor-enter(this);
        this.entries.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheStorage
    public void updateEntry(String r3, HttpCacheUpdateCallback r4) throws IOException {
        Args.notNull(r3, VCardConstants.PROPERTY_URL);
        Args.notNull(r4, "Callback");
        ensureValidState();
        monitor-enter(this);
        HttpCacheEntry r0 = this.entries.get(r3);     // Catch: Throwable -> L9
        HttpCacheEntry r5 = r4.update(r0);     // Catch: Throwable -> L9
        this.entries.put(r3, r5);     // Catch: Throwable -> L9
        if (r0 == r5) goto L7;
        keepResourceReference(r5);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void cleanResources() {
        if (this.active.get() == false) goto L13;
    L4:
        ResourceReference r0 = (ResourceReference) this.morque.poll();
        if (r0 == null) goto L17;
        monitor-enter(this);
        this.resources.remove(r0);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r0.getResource().dispose();
    L10:
        th = move-exception;
        throw th;
    L17:
        return;
    }

    public void shutdown() {
        if (this.active.compareAndSet(true, false) == false) goto L18;
        monitor-enter(this);
        this.entries.clear();     // Catch: Throwable -> L15
        Iterator<ResourceReference> r0 = this.resources.iterator();     // Catch: Throwable -> L15
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().getResource().dispose();     // Catch: Throwable -> L15
        goto L7
    L9:
        this.resources.clear();     // Catch: Throwable -> L15
    L11:
        if (this.morque.poll() != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.active.compareAndSet(true, false) == false) goto L13;
        monitor-enter(this);
    L14:
        ResourceReference r0 = (ResourceReference) this.morque.poll();     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        this.resources.remove(r0);     // Catch: Throwable -> L10
        r0.getResource().dispose();     // Catch: Throwable -> L10
        goto L14
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
