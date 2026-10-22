package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class AsynchronousValidationRequest implements Runnable {
    private final HttpCacheEntry cacheEntry;
    private final CachingExec cachingExec;
    private final int consecutiveFailedAttempts;
    private final HttpClientContext context;
    private final HttpExecutionAware execAware;
    private final String identifier;
    public HttpClientAndroidLog log;
    private final AsynchronousValidator parent;
    private final HttpRequestWrapper request;
    private final HttpRoute route;

    private boolean isNotServerError(int r1) {
        if (r1 >= 500) goto L5;
        return true;
    L5:
        return false;
    }

    AsynchronousValidationRequest(AsynchronousValidator r3, CachingExec r4, HttpRoute r5, HttpRequestWrapper r6, HttpClientContext r7, HttpExecutionAware r8, HttpCacheEntry r9, String r10, int r11) {
        this.log = new HttpClientAndroidLog(getClass());
        this.parent = r3;
        this.cachingExec = r4;
        this.route = r5;
        this.request = r6;
        this.context = r7;
        this.execAware = r8;
        this.cacheEntry = r9;
        this.identifier = r10;
        this.consecutiveFailedAttempts = r11;
    }

    @Override // java.lang.Runnable
    public void run() {
    L8:
        th = move-exception;
        this.parent.markComplete(this.identifier);
        throw th;
    L3:
        if (revalidateCacheEntry() == false) goto L5;
        this.parent.jobSuccessful(this.identifier);     // Catch: Throwable -> L8
    L6:
        this.parent.markComplete(this.identifier);
        return;
    L5:
        this.parent.jobFailed(this.identifier);     // Catch: Throwable -> L8
        goto L6
    }

    private boolean revalidateCacheEntry() {
        CloseableHttpResponse r1 = this.cachingExec.revalidateCacheEntry(this.route, this.request, this.context, this.execAware, this.cacheEntry);     // Catch: RuntimeException -> L15 HttpException -> L18 IOException -> L21
    L12:
        th = move-exception;
        r1.close();     // Catch: RuntimeException -> L15 HttpException -> L18 IOException -> L21
        throw th;     // Catch: RuntimeException -> L15 HttpException -> L18 IOException -> L21
    L5:
        if (isNotServerError(r1.getStatusLine().getStatusCode()) == false) goto L9;
        if (isNotStale(r1) == false) goto L9;
        boolean r2 = true;
    L10:
        r1.close();     // Catch: RuntimeException -> L15 HttpException -> L18 IOException -> L21
        return r2;
    L9:
        r2 = false;
    L18:
        e = move-exception;
        this.log.error("HTTP protocol exception during asynchronous revalidation", e);
        return false;
    L21:
        e = move-exception;
        this.log.debug("Asynchronous revalidation failed due to I/O error", e);
        return false;
    L15:
        e = move-exception;
        this.log.error("RuntimeException thrown during asynchronous revalidation: " + e);
        return false;
    }

    private boolean isNotStale(HttpResponse r5) {
        Header[] r4 = r5.getHeaders("Warning");
        if (r4 == null) goto L13;
        int r6 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r6) goto L18;
        String r2 = r4[r1].getValue();
        if (r2.startsWith("110") == true) goto L12;
        if (r2.startsWith("111") == true) goto L12;
        r1 = r1 + 1;
    L12:
        return false;
    L18:
        return true;
    L13:
        return true;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getConsecutiveFailedAttempts() {
        return this.consecutiveFailedAttempts;
    }
}
