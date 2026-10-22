package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class RetryExec implements ClientExecChain {
    public HttpClientAndroidLog log;
    private final ClientExecChain requestExecutor;
    private final HttpRequestRetryHandler retryHandler;

    public RetryExec(ClientExecChain r3, HttpRequestRetryHandler r4) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "HTTP request executor");
        Args.notNull(r4, "HTTP request retry handler");
        this.requestExecutor = r3;
        this.retryHandler = r4;
    }

    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute r7, HttpRequestWrapper r8, HttpClientContext r9, HttpExecutionAware r10) throws IOException, HttpException {
        Args.notNull(r7, "HTTP route");
        Args.notNull(r8, "HTTP request");
        Args.notNull(r9, "HTTP context");
        Header[] r0 = r8.getAllHeaders();
        int r1 = 1;
    L33:
        return this.requestExecutor.execute(r7, r8, r9, r10);
    L5:
        e = move-exception;
        if (r10 == null) goto L13;
        if (r10.isAborted() == false) goto L13;
        this.log.debug("Request has been aborted");
        throw e;
    L13:
        if (this.retryHandler.retryRequest(e, r1, r9) == false) goto L29;
        if (this.log.isInfoEnabled() == false) goto L18;
        this.log.info("I/O exception (" + e.getClass().getName() + ") caught when processing request to " + r7 + ": " + e.getMessage());
    L18:
        if (this.log.isDebugEnabled() == false) goto L21;
        this.log.debug(e.getMessage(), e);
    L21:
        if (RequestEntityProxy.isRepeatable(r8) == false) goto L26;
        r8.setHeaders(r0);
        if (this.log.isInfoEnabled() == false) goto L25;
        this.log.info("Retrying request to " + r7);
    L25:
        r1 = r1 + 1;
        goto L33
    L26:
        this.log.debug("Cannot retry non-repeatable request");
        throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity", e);
    L29:
        if ((e instanceof NoHttpResponseException) == false) goto L32;
        NoHttpResponseException r6 = new NoHttpResponseException(r7.getTargetHost().toHostString() + " failed to respond");
        r6.setStackTrace(e.getStackTrace());
        throw r6;
    L32:
        throw e;
    }
}
