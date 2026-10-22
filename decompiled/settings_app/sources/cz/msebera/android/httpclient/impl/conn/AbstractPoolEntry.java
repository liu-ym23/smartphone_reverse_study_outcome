package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractPoolEntry {
    protected final ClientConnectionOperator connOperator;
    protected final OperatedClientConnection connection;
    protected volatile HttpRoute route;
    protected volatile Object state;
    protected volatile RouteTracker tracker;

    protected AbstractPoolEntry(ClientConnectionOperator r2, HttpRoute r3) {
        Args.notNull(r2, "Connection operator");
        this.connOperator = r2;
        this.connection = r2.createConnection();
        this.route = r3;
        this.tracker = null;
    }

    public Object getState() {
        return this.state;
    }

    public void setState(Object r1) {
        this.state = r1;
    }

    public void open(HttpRoute r8, HttpContext r9, HttpParams r10) throws IOException {
        Args.notNull(r8, "Route");
        Args.notNull(r10, "HTTP parameters");
        if (this.tracker == null) goto L5;
        Asserts.check(!this.tracker.isConnected(), "Connection already open");
    L5:
        this.tracker = new RouteTracker(r8);
        HttpHost r0 = r8.getProxyHost();
        ClientConnectionOperator r1 = this.connOperator;
        OperatedClientConnection r2 = this.connection;
        if (r0 == null) goto L8;
        HttpHost r3 = r0;
    L9:
        r1.openConnection(r2, r3, r8.getLocalAddress(), r9, r10);
        RouteTracker r11 = this.tracker;
        if (r11 == null) goto L16;
        if (r0 != null) goto L13;
        r11.connectTarget(this.connection.isSecure());
        return;
    L13:
        r11.connectProxy(r0, this.connection.isSecure());
        return;
    L16:
        throw new InterruptedIOException("Request aborted");
    L8:
        r3 = r8.getTargetHost();
        goto L9
    }

    public void tunnelTarget(boolean r4, HttpParams r5) throws IOException {
        Args.notNull(r5, "HTTP parameters");
        Asserts.notNull(this.tracker, "Route tracker");
        Asserts.check(this.tracker.isConnected(), "Connection not open");
        Asserts.check(!this.tracker.isTunnelled(), "Connection is already tunnelled");
        this.connection.update(null, this.tracker.getTargetHost(), r4, r5);
        this.tracker.tunnelTarget(r4);
    }

    public void tunnelProxy(HttpHost r3, boolean r4, HttpParams r5) throws IOException {
        Args.notNull(r3, "Next proxy");
        Args.notNull(r5, "Parameters");
        Asserts.notNull(this.tracker, "Route tracker");
        Asserts.check(this.tracker.isConnected(), "Connection not open");
        this.connection.update(null, r3, r4, r5);
        this.tracker.tunnelProxy(r3, r4);
    }

    public void layerProtocol(HttpContext r4, HttpParams r5) throws IOException {
        Args.notNull(r5, "HTTP parameters");
        Asserts.notNull(this.tracker, "Route tracker");
        Asserts.check(this.tracker.isConnected(), "Connection not open");
        Asserts.check(this.tracker.isTunnelled(), "Protocol layering without a tunnel not supported");
        Asserts.check(!this.tracker.isLayered(), "Multiple protocol layering not supported");
        this.connOperator.updateSecureConnection(this.connection, this.tracker.getTargetHost(), r4, r5);
        this.tracker.layerProtocol(this.connection.isSecure());
    }

    protected void shutdownEntry() {
        this.tracker = null;
        this.state = null;
    }
}
