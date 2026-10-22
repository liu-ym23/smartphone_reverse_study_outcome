package cz.msebera.android.httpclient.impl.pool;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public class BasicConnPool extends AbstractConnPool<HttpHost, HttpClientConnection, BasicPoolEntry> {
    private static final AtomicLong COUNTER = null;

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    protected /* bridge */ /* synthetic */ PoolEntry createEntry(HttpHost r1, HttpClientConnection r2) {
        return createEntry2(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    protected /* bridge */ /* synthetic */ boolean validate(PoolEntry r1) {
        return validate((BasicPoolEntry) r1);
    }

    static {
        COUNTER = new AtomicLong();
    }

    public BasicConnPool(ConnFactory<HttpHost, HttpClientConnection> r3) {
        super(r3, 2, 20);
    }

    @Deprecated
    public BasicConnPool(HttpParams r3) {
        super(new BasicConnFactory(r3), 2, 20);
    }

    public BasicConnPool(SocketConfig r2, ConnectionConfig r3) {
        super(new BasicConnFactory(r2, r3), 2, 20);
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }

    /* JADX INFO: renamed from: createEntry, reason: avoid collision after fix types in other method */
    protected BasicPoolEntry createEntry2(HttpHost r3, HttpClientConnection r4) {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), r3, r4);
    }

    protected boolean validate(BasicPoolEntry r1) {
        return !r1.getConnection().isStale();
    }
}
