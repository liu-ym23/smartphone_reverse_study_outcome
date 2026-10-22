package cz.msebera.android.httpclient.conn;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long r1, TimeUnit r3) throws InterruptedException, ConnectionPoolTimeoutException;
}
