package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PoolEntry<T, C> {
    private final C conn;
    private final long created;
    private long expiry;
    private final String id;
    private final T route;
    private volatile Object state;
    private long updated;
    private final long validityDeadline;

    public abstract void close();

    public abstract boolean isClosed();

    public PoolEntry(String r5, T r6, C r7, long r8, TimeUnit r10) {
        Args.notNull(r6, "Route");
        Args.notNull(r7, "Connection");
        Args.notNull(r10, "Time unit");
        this.id = r5;
        this.route = r6;
        this.conn = r7;
        long r9 = System.currentTimeMillis();
        this.created = r9;
        this.updated = r9;
        long r2 = Long.MAX_VALUE;
        if (r8 <= 0) goto L8;
        long r11 = r9 + r10.toMillis(r8);
        if (r11 <= 0) goto L7;
        r2 = r11;
    L7:
        this.validityDeadline = r2;
    L9:
        this.expiry = this.validityDeadline;
        return;
    L8:
        this.validityDeadline = Long.MAX_VALUE;
        goto L9
    }

    public PoolEntry(String r8, T r9, C r10) {
        this(r8, r9, r10, 0, TimeUnit.MILLISECONDS);
    }

    public String getId() {
        return this.id;
    }

    public T getRoute() {
        return this.route;
    }

    public C getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public long getValidityDeadline() {
        return this.validityDeadline;
    }

    @Deprecated
    public long getValidUnit() {
        return this.validityDeadline;
    }

    public Object getState() {
        return this.state;
    }

    public void setState(Object r1) {
        this.state = r1;
    }

    public synchronized long getUpdated() {
        monitor-enter(this);
        long r0 = this.updated;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long getExpiry() {
        monitor-enter(this);
        long r0 = this.expiry;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void updateExpiry(long r5, TimeUnit r7) {
        monitor-enter(this);
        Args.notNull(r7, "Time unit");     // Catch: Throwable -> L10
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L10
        this.updated = r0;     // Catch: Throwable -> L10
        if (r5 <= 0) goto L6;
        long r1 = r0 + r7.toMillis(r5);     // Catch: Throwable -> L10
    L7:
        this.expiry = Math.min(r1, this.validityDeadline);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r1 = Long.MAX_VALUE;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isExpired(long r3) {
        monitor-enter(this);
        if (r3 < this.expiry) goto L7;
        boolean r4 = true;
    L8:
        monitor-exit(this);
        return r4;
    L7:
        r4 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "[id:" + this.id + "][route:" + this.route + "][state:" + this.state + "]";
    }
}
