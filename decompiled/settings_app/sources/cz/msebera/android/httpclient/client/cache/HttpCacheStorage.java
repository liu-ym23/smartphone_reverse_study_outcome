package cz.msebera.android.httpclient.client.cache;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpCacheStorage {
    HttpCacheEntry getEntry(String r1) throws IOException;

    void putEntry(String r1, HttpCacheEntry r2) throws IOException;

    void removeEntry(String r1) throws IOException;

    void updateEntry(String r1, HttpCacheUpdateCallback r2) throws IOException, HttpCacheUpdateException;
}
