package cz.msebera.android.httpclient.impl;

import com.android.settingslib.accessibility.AccessibilityUtils;
import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.impl.io.SocketInputBuffer;
import cz.msebera.android.httpclient.impl.io.SocketOutputBuffer;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SocketHttpClientConnection extends AbstractHttpClientConnection implements HttpInetConnection {
    private volatile boolean open;
    private volatile Socket socket;

    public SocketHttpClientConnection() {
        this.socket = null;
    }

    protected void assertNotOpen() {
        Asserts.check(!this.open, "Connection is already open");
    }

    @Override // cz.msebera.android.httpclient.impl.AbstractHttpClientConnection
    protected void assertOpen() {
        Asserts.check(this.open, "Connection is not open");
    }

    protected SessionInputBuffer createSessionInputBuffer(Socket r1, int r2, HttpParams r3) throws IOException {
        return new SocketInputBuffer(r1, r2, r3);
    }

    protected SessionOutputBuffer createSessionOutputBuffer(Socket r1, int r2, HttpParams r3) throws IOException {
        return new SocketOutputBuffer(r1, r2, r3);
    }

    protected void bind(Socket r3, HttpParams r4) throws IOException {
        Args.notNull(r3, "Socket");
        Args.notNull(r4, "HTTP parameters");
        this.socket = r3;
        int r0 = r4.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, -1);
        init(createSessionInputBuffer(r3, r0, r4), createSessionOutputBuffer(r3, r0, r4), r4);
        this.open = true;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isOpen() {
        return this.open;
    }

    protected Socket getSocket() {
        return this.socket;
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getLocalAddress() {
        if (this.socket != null) goto L5;
        return null;
    L5:
        return this.socket.getLocalAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getLocalPort() {
        if (this.socket != null) goto L5;
        return -1;
    L5:
        return this.socket.getLocalPort();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getRemoteAddress() {
        if (this.socket != null) goto L5;
        return null;
    L5:
        return this.socket.getInetAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getRemotePort() {
        if (this.socket != null) goto L5;
        return -1;
    L5:
        return this.socket.getPort();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int r2) {
        assertOpen();
        if (this.socket == null) goto L9;
        this.socket.setSoTimeout(r2);     // Catch: SocketException -> L6
        return;
    L10:
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public int getSocketTimeout() {
        if (this.socket != null) goto L8;
    L6:
        return -1;
    L8:
        return this.socket.getSoTimeout();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        this.open = false;
        Socket r1 = this.socket;
        if (r1 == null) goto L6;
        r1.close();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.open == true) goto L5;
        return;
    L5:
        this.open = false;
        Socket r0 = this.socket;
        doFlush();     // Catch: Throwable -> L11
        r0.shutdownOutput();     // Catch: IOException -> L14 Throwable -> L15 Throwable -> L11
    L8:
        r0.shutdownInput();     // Catch: Throwable -> L15 Throwable -> L11
    L9:
        r0.close();
        return;
    L11:
        th = move-exception;
        r0.close();
        throw th;
    }

    private static void formatAddress(StringBuilder r1, SocketAddress r2) {
        if ((r2 instanceof InetSocketAddress) == false) goto L9;
        InetSocketAddress r3 = (InetSocketAddress) r2;
        if (r3.getAddress() == null) goto L7;
        Object r0 = r3.getAddress().getHostAddress();
    L8:
        r1.append(r0).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r3.getPort());
        return;
    L7:
        r0 = r3.getAddress();
        goto L8
    L9:
        r1.append(r2);
    }

    public String toString() {
        if (this.socket == null) goto L11;
        StringBuilder r0 = new StringBuilder();
        SocketAddress r1 = this.socket.getRemoteSocketAddress();
        SocketAddress r2 = this.socket.getLocalSocketAddress();
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        formatAddress(r0, r2);
        r0.append("<->");
        formatAddress(r0, r1);
    L9:
        return r0.toString();
    L11:
        return super.toString();
    }
}
