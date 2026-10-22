package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.PoolEntry;
import cz.msebera.android.httpclient.pool.PoolEntryCallback;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
class CPool extends AbstractConnPool<HttpRoute, ManagedHttpClientConnection, CPoolEntry> {
    private static final AtomicLong COUNTER = null;
    public HttpClientAndroidLog log;
    private final long timeToLive;
    private final TimeUnit timeUnit;

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    protected /* bridge */ /* synthetic */ PoolEntry createEntry(HttpRoute r1, ManagedHttpClientConnection r2) {
        return createEntry2(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    protected /* bridge */ /* synthetic */ boolean validate(PoolEntry r1) {
        return validate((CPoolEntry) r1);
    }

    static {
        COUNTER = new AtomicLong();
    }

    public CPool(ConnFactory<HttpRoute, ManagedHttpClientConnection> r1, int r2, int r3, long r4, TimeUnit r6) {
        super(r1, r2, r3);
        this.log = new HttpClientAndroidLog(CPool.class);
        this.timeToLive = r4;
        this.timeUnit = r6;
    }

    /* JADX INFO: renamed from: createEntry, reason: avoid collision after fix types in other method */
    protected CPoolEntry createEntry2(HttpRoute r11, ManagedHttpClientConnection r12) {
        String r4 = Long.toString(COUNTER.getAndIncrement());
        return new CPoolEntry(this.log, r4, r11, r12, this.timeToLive, this.timeUnit);
    }

    protected boolean validate(CPoolEntry r1) {
        return !r1.getConnection().isStale();
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    protected void enumAvailable(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> r1) {
        super.enumAvailable(r1);
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    protected void enumLeased(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> r1) {
        super.enumLeased(r1);
    }
}
