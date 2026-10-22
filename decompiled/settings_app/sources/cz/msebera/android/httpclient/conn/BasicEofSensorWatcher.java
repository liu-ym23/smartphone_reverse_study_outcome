package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BasicEofSensorWatcher implements EofSensorWatcher {
    protected final boolean attemptReuse;
    protected final ManagedClientConnection managedConn;

    public BasicEofSensorWatcher(ManagedClientConnection r2, boolean r3) {
        Args.notNull(r2, "Connection");
        this.managedConn = r2;
        this.attemptReuse = r3;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean eofDetected(InputStream r2) throws IOException {
    L7:
        th = move-exception;
        this.managedConn.releaseConnection();
        throw th;
    L3:
        if (this.attemptReuse == false) goto L5;
        r2.close();     // Catch: Throwable -> L7
        this.managedConn.markReusable();     // Catch: Throwable -> L7
    L5:
        this.managedConn.releaseConnection();
        return false;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean streamClosed(InputStream r2) throws IOException {
    L7:
        th = move-exception;
        this.managedConn.releaseConnection();
        throw th;
    L3:
        if (this.attemptReuse == false) goto L5;
        r2.close();     // Catch: Throwable -> L7
        this.managedConn.markReusable();     // Catch: Throwable -> L7
    L5:
        this.managedConn.releaseConnection();
        return false;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean streamAbort(InputStream r1) throws IOException {
        this.managedConn.abortConnection();
        return false;
    }
}
