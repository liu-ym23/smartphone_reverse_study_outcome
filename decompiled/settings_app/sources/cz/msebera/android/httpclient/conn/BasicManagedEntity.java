package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
    protected final boolean attemptReuse;
    protected ManagedClientConnection managedConn;

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    public BasicManagedEntity(HttpEntity r1, ManagedClientConnection r2, boolean r3) {
        super(r1);
        Args.notNull(r2, "Connection");
        this.managedConn = r2;
        this.attemptReuse = r3;
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
    }

    private void ensureConsumed() throws IOException {
        ManagedClientConnection r0 = this.managedConn;
        if (r0 != null) goto L14;
        return;
    L14:
    L11:
        th = move-exception;
        releaseManagedConnection();
        throw th;
    L6:
        if (this.attemptReuse == false) goto L8;
        EntityUtils.consume(this.wrappedEntity);     // Catch: Throwable -> L11
        this.managedConn.markReusable();     // Catch: Throwable -> L11
    L9:
        releaseManagedConnection();
        return;
    L8:
        r0.unmarkReusable();     // Catch: Throwable -> L11
        goto L9
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
        ensureConsumed();
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r1) throws IOException {
        super.writeTo(r1);
        ensureConsumed();
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void releaseConnection() throws IOException {
        ensureConsumed();
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void abortConnection() throws IOException {
        ManagedClientConnection r0 = this.managedConn;
        if (r0 != null) goto L11;
        return;
    L11:
        r0.abortConnection();     // Catch: Throwable -> L7
        this.managedConn = null;
        return;
    L7:
        th = move-exception;
        this.managedConn = null;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean eofDetected(InputStream r3) throws IOException {
        ManagedClientConnection r0 = this.managedConn;     // Catch: Throwable -> L10
        if (r0 != null) goto L5;
    L8:
        releaseManagedConnection();
        return false;
    L5:
        if (this.attemptReuse == false) goto L7;
        r3.close();     // Catch: Throwable -> L10
        this.managedConn.markReusable();     // Catch: Throwable -> L10
        goto L8
    L7:
        r0.unmarkReusable();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        releaseManagedConnection();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean streamClosed(InputStream r3) throws IOException {
        ManagedClientConnection r0 = this.managedConn;     // Catch: Throwable -> L16
        if (r0 != null) goto L5;
    L14:
        releaseManagedConnection();
        return false;
    L5:
        if (this.attemptReuse == false) goto L13;
        boolean r1 = r0.isOpen();     // Catch: Throwable -> L16
        r3.close();     // Catch: SocketException -> L9 Throwable -> L16
        this.managedConn.markReusable();     // Catch: SocketException -> L9 Throwable -> L16
    L9:
        e = move-exception;
        if (r1 == false) goto L14;
        throw e;     // Catch: Throwable -> L16
    L13:
        r0.unmarkReusable();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        releaseManagedConnection();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean streamAbort(InputStream r1) throws IOException {
        ManagedClientConnection r0 = this.managedConn;
        if (r0 == null) goto L7;
        r0.abortConnection();
        return false;
    L7:
        return false;
    }

    protected void releaseManagedConnection() throws IOException {
        ManagedClientConnection r0 = this.managedConn;
        if (r0 != null) goto L11;
        return;
    L11:
        r0.releaseConnection();     // Catch: Throwable -> L7
        this.managedConn = null;
        return;
    L7:
        th = move-exception;
        this.managedConn = null;
        throw th;
    }
}
