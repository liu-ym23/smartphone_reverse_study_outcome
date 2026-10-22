package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.AbstractConnPool;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class HttpConnPool extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry> {
    private static final AtomicLong COUNTER = null;
    private final HttpClientAndroidLog log;
    private final long timeToLive;
    private final TimeUnit timeUnit;

    static class InternalConnFactory implements ConnFactory<HttpRoute, OperatedClientConnection> {
        private final ClientConnectionOperator connOperator;

        @Override // cz.msebera.android.httpclient.pool.ConnFactory
        public /* bridge */ /* synthetic */ OperatedClientConnection create(HttpRoute r1) throws IOException {
            return create2(r1);
        }

        InternalConnFactory(ClientConnectionOperator r1) {
            this.connOperator = r1;
        }

        /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
        public OperatedClientConnection create2(HttpRoute r1) throws IOException {
            return this.connOperator.createConnection();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.AbstractConnPool
    protected /* bridge */ /* synthetic */ PoolEntry createEntry(HttpRoute r1, OperatedClientConnection r2) {
        return createEntry2(r1, r2);
    }

    static {
        COUNTER = new AtomicLong();
    }

    public HttpConnPool(HttpClientAndroidLog r2, ClientConnectionOperator r3, int r4, int r5, long r6, TimeUnit r8) {
        super(new InternalConnFactory(r3), r4, r5);
        this.log = r2;
        this.timeToLive = r6;
        this.timeUnit = r8;
    }

    /* JADX INFO: renamed from: createEntry, reason: avoid collision after fix types in other method */
    protected HttpPoolEntry createEntry2(HttpRoute r11, OperatedClientConnection r12) {
        String r4 = Long.toString(COUNTER.getAndIncrement());
        return new HttpPoolEntry(this.log, r4, r11, r12, this.timeToLive, this.timeUnit);
    }
}
