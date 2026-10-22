package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface AbortableHttpRequest {
    void abort();

    void setConnectionRequest(ClientConnectionRequest r1) throws IOException;

    void setReleaseTrigger(ConnectionReleaseTrigger r1) throws IOException;
}
