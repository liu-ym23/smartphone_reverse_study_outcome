package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultBackoffStrategy implements ConnectionBackoffStrategy {
    public DefaultBackoffStrategy() {
    }

    @Override // cz.msebera.android.httpclient.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(Throwable r1) {
        if ((r1 instanceof SocketTimeoutException) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof ConnectException) == true) goto L8;
        return false;
    }

    @Override // cz.msebera.android.httpclient.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(HttpResponse r1) {
        if (r1.getStatusLine().getStatusCode() != 503) goto L5;
        return true;
    L5:
        return false;
    }
}
