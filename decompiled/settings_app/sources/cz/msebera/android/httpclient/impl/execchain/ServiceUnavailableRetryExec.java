package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes5.dex */
public class ServiceUnavailableRetryExec implements ClientExecChain {
    public HttpClientAndroidLog log;
    private final ClientExecChain requestExecutor;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public ServiceUnavailableRetryExec(ClientExecChain r3, ServiceUnavailableRetryStrategy r4) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "HTTP request executor");
        Args.notNull(r4, "Retry strategy");
        this.requestExecutor = r3;
        this.retryStrategy = r4;
    }

    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute r9, HttpRequestWrapper r10, HttpClientContext r11, HttpExecutionAware r12) throws IOException, HttpException {
        Header[] r0 = r10.getAllHeaders();
        int r1 = 1;
    L3:
        CloseableHttpResponse r2 = this.requestExecutor.execute(r9, r10, r11, r12);
    L18:
        e = move-exception;
        r2.close();
        throw e;
    L5:
        if (this.retryStrategy.retryRequest(r2, r1, r11) == false) goto L17;
        if (RequestEntityProxy.isRepeatable(r10) == false) goto L17;
        r2.close();     // Catch: RuntimeException -> L18
        long r3 = this.retryStrategy.getRetryInterval();     // Catch: RuntimeException -> L18
        if (r3 > 0) goto L21;
    L15:
        r10.setHeaders(r0);     // Catch: RuntimeException -> L18
        r1 = r1 + 1;
        goto L3
    L21:
        this.log.trace("Wait for " + r3);     // Catch: InterruptedException -> L13 RuntimeException -> L18
        Thread.sleep(r3);     // Catch: InterruptedException -> L13 RuntimeException -> L18
    L13:
        Thread.currentThread().interrupt();     // Catch: RuntimeException -> L18
        throw new InterruptedIOException();     // Catch: RuntimeException -> L18
    L17:
        return r2;
    }
}
