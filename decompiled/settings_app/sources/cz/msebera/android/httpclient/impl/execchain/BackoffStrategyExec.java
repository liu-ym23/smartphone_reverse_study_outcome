package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.client.BackoffManager;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

/* JADX INFO: loaded from: classes5.dex */
public class BackoffStrategyExec implements ClientExecChain {
    private final BackoffManager backoffManager;
    private final ConnectionBackoffStrategy connectionBackoffStrategy;
    private final ClientExecChain requestExecutor;

    public BackoffStrategyExec(ClientExecChain r2, ConnectionBackoffStrategy r3, BackoffManager r4) {
        Args.notNull(r2, "HTTP client request executor");
        Args.notNull(r3, "Connection backoff strategy");
        Args.notNull(r4, "Backoff manager");
        this.requestExecutor = r2;
        this.connectionBackoffStrategy = r3;
        this.backoffManager = r4;
    }

    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute r2, HttpRequestWrapper r3, HttpClientContext r4, HttpExecutionAware r5) throws IOException, HttpException {
        Args.notNull(r2, "HTTP route");
        Args.notNull(r3, "HTTP request");
        Args.notNull(r4, "HTTP context");
        CloseableHttpResponse r6 = this.requestExecutor.execute(r2, r3, r4, r5);     // Catch: Exception -> L9
        if (this.connectionBackoffStrategy.shouldBackoff(r6) == false) goto L7;
        this.backoffManager.backOff(r2);
    L8:
        return r6;
    L7:
        this.backoffManager.probe(r2);
    L9:
        e = move-exception;
        if (this.connectionBackoffStrategy.shouldBackoff(e) == false) goto L14;
        this.backoffManager.backOff(r2);
    L14:
        if ((e instanceof RuntimeException) == true) goto L26;
        if ((e instanceof HttpException) == true) goto L24;
        if ((e instanceof IOException) == false) goto L22;
        throw ((IOException) e);
    L22:
        throw new UndeclaredThrowableException(e);
    L24:
        throw ((HttpException) e);
    L26:
        throw ((RuntimeException) e);
    }
}
