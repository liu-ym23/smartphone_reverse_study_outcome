package cz.msebera.android.httpclient.impl.client.cache;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultFailureCache implements FailureCache {
    static final int DEFAULT_MAX_SIZE = 1000;
    static final int MAX_UPDATE_TRIES = 10;
    private final int maxSize;
    private final ConcurrentMap<String, FailureCacheValue> storage;

    public DefaultFailureCache() {
        this(1000);
    }

    public DefaultFailureCache(int r1) {
        this.maxSize = r1;
        this.storage = new ConcurrentHashMap();
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.FailureCache
    public int getErrorCount(String r1) {
        if (r1 == null) goto L9;
        FailureCacheValue r0 = this.storage.get(r1);
        if (r0 != null) goto L10;
        return 0;
    L10:
        return r0.getErrorCount();
    L9:
        throw new IllegalArgumentException("identifier may not be null");
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.FailureCache
    public void resetErrorCount(String r1) {
        if (r1 == null) goto L6;
        this.storage.remove(r1);
        return;
    L6:
        throw new IllegalArgumentException("identifier may not be null");
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.FailureCache
    public void increaseErrorCount(String r1) {
        if (r1 == null) goto L6;
        updateValue(r1);
        removeOldestEntryIfMapSizeExceeded();
        return;
    L6:
        throw new IllegalArgumentException("identifier may not be null");
    }

    private void updateValue(String r5) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L17;
        FailureCacheValue r1 = this.storage.get(r5);
        if (r1 != null) goto L10;
        FailureCacheValue r2 = new FailureCacheValue(r5, 1);
        if (this.storage.putIfAbsent(r5, r2) != null) goto L16;
        return;
    L16:
        r0 = r0 + 1;
        goto L4
    L10:
        int r3 = r1.getErrorCount();
        if (r3 == Integer.MAX_VALUE) goto L12;
        FailureCacheValue r4 = new FailureCacheValue(r5, r3 + 1);
        if (this.storage.replace(r5, r1, r4) == false) goto L16;
        return;
    L12:
        return;
    }

    private void removeOldestEntryIfMapSizeExceeded() {
        if (this.storage.size() <= this.maxSize) goto L8;
        FailureCacheValue r0 = findValueWithOldestTimestamp();
        if (r0 == null) goto L9;
        this.storage.remove(r0.getKey(), r0);
        return;
    L9:
        return;
    }

    private FailureCacheValue findValueWithOldestTimestamp() {
        Iterator<Map.Entry<String, FailureCacheValue>> r7 = this.storage.entrySet().iterator();
        long r0 = Long.MAX_VALUE;
        FailureCacheValue r2 = null;
    L4:
        if (r7.hasNext() == false) goto L8;
        Map.Entry<String, FailureCacheValue> r3 = r7.next();
        long r4 = r3.getValue().getCreationTimeInNanos();
        if (r4 >= r0) goto L4;
        r2 = r3.getValue();
        r0 = r4;
        goto L4
    L8:
        return r2;
    }
}
