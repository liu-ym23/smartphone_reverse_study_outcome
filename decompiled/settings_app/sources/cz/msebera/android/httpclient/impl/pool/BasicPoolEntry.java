package cz.msebera.android.httpclient.impl.pool;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicPoolEntry extends PoolEntry<HttpHost, HttpClientConnection> {
    public BasicPoolEntry(String r1, HttpHost r2, HttpClientConnection r3) {
        super(r1, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public void close() {
        getConnection().close();     // Catch: IOException -> L4
        return;
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }
}
