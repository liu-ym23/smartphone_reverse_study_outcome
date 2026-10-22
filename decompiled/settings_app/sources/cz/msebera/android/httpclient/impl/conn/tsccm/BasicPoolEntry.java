package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry;
import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BasicPoolEntry extends AbstractPoolEntry {
    private final long created;
    private long expiry;
    private long updated;
    private final long validUntil;

    protected final BasicPoolEntryRef getWeakRef() {
        return null;
    }

    public BasicPoolEntry(ClientConnectionOperator r1, HttpRoute r2, ReferenceQueue<Object> r3) {
        super(r1, r2);
        Args.notNull(r2, "HTTP route");
        this.created = System.currentTimeMillis();
        this.validUntil = Long.MAX_VALUE;
        this.expiry = Long.MAX_VALUE;
    }

    public BasicPoolEntry(ClientConnectionOperator r7, HttpRoute r8) {
        this(r7, r8, -1, TimeUnit.MILLISECONDS);
    }

    public BasicPoolEntry(ClientConnectionOperator r3, HttpRoute r4, long r5, TimeUnit r7) {
        super(r3, r4);
        Args.notNull(r4, "HTTP route");
        long r6 = System.currentTimeMillis();
        this.created = r6;
        if (r5 <= 0) goto L5;
        this.validUntil = r6 + r7.toMillis(r5);
    L6:
        this.expiry = this.validUntil;
        return;
    L5:
        this.validUntil = Long.MAX_VALUE;
        goto L6
    }

    protected final OperatedClientConnection getConnection() {
        return this.connection;
    }

    protected final HttpRoute getPlannedRoute() {
        return this.route;
    }

    @Override // cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry
    protected void shutdownEntry() {
        super.shutdownEntry();
    }

    public long getCreated() {
        return this.created;
    }

    public long getUpdated() {
        return this.updated;
    }

    public long getExpiry() {
        return this.expiry;
    }

    public long getValidUntil() {
        return this.validUntil;
    }

    public void updateExpiry(long r5, TimeUnit r7) {
        long r0 = System.currentTimeMillis();
        this.updated = r0;
        if (r5 <= 0) goto L5;
        long r1 = r0 + r7.toMillis(r5);
    L6:
        this.expiry = Math.min(this.validUntil, r1);
        return;
    L5:
        r1 = Long.MAX_VALUE;
        goto L6
    }

    public boolean isExpired(long r3) {
        if (r3 < this.expiry) goto L5;
        return true;
    L5:
        return false;
    }
}
