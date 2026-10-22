package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.EofSensorInputStream;
import cz.msebera.android.httpclient.conn.EofSensorWatcher;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

/* JADX INFO: loaded from: classes5.dex */
class ResponseEntityProxy extends HttpEntityWrapper implements EofSensorWatcher {
    private final ConnectionHolder connHolder;

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    public static void enchance(HttpResponse r2, ConnectionHolder r3) {
        HttpEntity r0 = r2.getEntity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStreaming() == false) goto L10;
        if (r3 == null) goto L11;
        r2.setEntity(new ResponseEntityProxy(r0, r3));
        return;
    L11:
        return;
    }

    ResponseEntityProxy(HttpEntity r1, ConnectionHolder r2) {
        super(r1);
        this.connHolder = r2;
    }

    private void cleanup() throws IOException {
        ConnectionHolder r0 = this.connHolder;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    private void abortConnection() {
        ConnectionHolder r0 = this.connHolder;
        if (r0 == null) goto L6;
        r0.abortConnection();
        return;
    }

    public void releaseConnection() {
        ConnectionHolder r0 = this.connHolder;
        if (r0 == null) goto L6;
        r0.releaseConnection();
        return;
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() throws IOException {
        releaseConnection();
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r2) throws IOException {
        if (r2 != null) goto L18;
    L4:
        releaseConnection();     // Catch: Throwable -> L7 RuntimeException -> L9 IOException -> L12
        cleanup();
        return;
    L12:
        e = move-exception;
        abortConnection();     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L9:
        e = move-exception;
        abortConnection();     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L18:
        this.wrappedEntity.writeTo(r2);     // Catch: Throwable -> L7 RuntimeException -> L9 IOException -> L12
    L7:
        th = move-exception;
        cleanup();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean eofDetected(InputStream r1) throws IOException {
        if (r1 != null) goto L18;
    L4:
        releaseConnection();     // Catch: Throwable -> L7 RuntimeException -> L9 IOException -> L12
        cleanup();
        return false;
    L12:
        e = move-exception;
        abortConnection();     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L9:
        e = move-exception;
        abortConnection();     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L18:
        r1.close();     // Catch: Throwable -> L7 RuntimeException -> L9 IOException -> L12
    L7:
        th = move-exception;
        cleanup();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean streamClosed(InputStream r3) throws IOException {
        ConnectionHolder r0 = this.connHolder;     // Catch: Throwable -> L17 RuntimeException -> L19 IOException -> L22
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r3 != null) goto L27;
    L10:
        releaseConnection();     // Catch: SocketException -> L12 Throwable -> L17 RuntimeException -> L19 IOException -> L22
    L14:
        cleanup();
        return false;
    L12:
        e = move-exception;
        if (r1 == false) goto L14;
        throw e;     // Catch: Throwable -> L17 RuntimeException -> L19 IOException -> L22
    L27:
        r3.close();     // Catch: SocketException -> L12 Throwable -> L17 RuntimeException -> L19 IOException -> L22
        goto L10
    L5:
        if (r0.isReleased() == true) goto L7;
        r1 = true;
    L17:
        th = move-exception;
        cleanup();
        throw th;
    L22:
        e = move-exception;
        abortConnection();     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L19:
        e = move-exception;
        abortConnection();     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean streamAbort(InputStream r1) throws IOException {
        cleanup();
        return false;
    }

    public String toString() {
        return "ResponseEntityProxy{" + this.wrappedEntity + '}';
    }
}
