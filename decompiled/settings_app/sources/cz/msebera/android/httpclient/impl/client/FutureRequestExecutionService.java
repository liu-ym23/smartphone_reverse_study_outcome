package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.concurrent.FutureCallback;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class FutureRequestExecutionService implements Closeable {
    private final AtomicBoolean closed;
    private final ExecutorService executorService;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics;

    public FutureRequestExecutionService(HttpClient r3, ExecutorService r4) {
        this.metrics = new FutureRequestExecutionMetrics();
        this.closed = new AtomicBoolean(false);
        this.httpclient = r3;
        this.executorService = r4;
    }

    public <T> HttpRequestFutureTask<T> execute(HttpUriRequest r2, HttpContext r3, ResponseHandler<T> r4) {
        return execute(r2, r3, r4, null);
    }

    public <T> HttpRequestFutureTask<T> execute(HttpUriRequest r9, HttpContext r10, ResponseHandler<T> r11, FutureCallback<T> r12) {
        if (this.closed.get() == true) goto L7;
        this.metrics.getScheduledConnections().incrementAndGet();
        HttpRequestFutureTask<T> r13 = new HttpRequestFutureTask(r9, new HttpRequestTaskCallable(this.httpclient, r9, r10, r11, r12, this.metrics));
        this.executorService.execute(r13);
        return r13;
    L7:
        throw new IllegalStateException("Close has been called on this httpclient instance.");
    }

    public FutureRequestExecutionMetrics metrics() {
        return this.metrics;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed.set(true);
        this.executorService.shutdownNow();
        HttpClient r2 = this.httpclient;
        if ((r2 instanceof Closeable) == false) goto L6;
        ((Closeable) r2).close();
        return;
    }
}
