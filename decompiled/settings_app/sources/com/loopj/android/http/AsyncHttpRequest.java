package com.loopj.android.http;

import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.obric.capabilitykit.common.Ext;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.impl.client.AbstractHttpClient;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private final AtomicBoolean isCancelled;
    private volatile boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public void onPostProcessRequest(AsyncHttpRequest r1) {
    }

    public void onPreProcessRequest(AsyncHttpRequest r1) {
    }

    public AsyncHttpRequest(AbstractHttpClient r2, HttpContext r3, HttpUriRequest r4, ResponseHandlerInterface r5) {
        this.isCancelled = new AtomicBoolean();
        this.client = (AbstractHttpClient) Utils.notNull(r2, DeviceInfoProvider.CLIENT);
        this.context = (HttpContext) Utils.notNull(r3, "context");
        this.request = (HttpUriRequest) Utils.notNull(r4, Ext.KEY_REQUEST);
        this.responseHandler = (ResponseHandlerInterface) Utils.notNull(r5, "responseHandler");
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isCancelled() == false) goto L6;
        return;
    L6:
        if (this.isRequestPreProcessed == true) goto L9;
        this.isRequestPreProcessed = true;
        onPreProcessRequest(this);
    L9:
        if (isCancelled() == false) goto L11;
        return;
    L11:
        this.responseHandler.sendStartMessage();
        if (isCancelled() == false) goto L29;
        return;
    L29:
        makeRequestWithRetries();     // Catch: IOException -> L16
    L22:
        if (isCancelled() == false) goto L24;
        return;
    L24:
        this.responseHandler.sendFinishMessage();
        if (isCancelled() == false) goto L27;
        return;
    L27:
        onPostProcessRequest(this);
        this.isFinished = true;
        return;
    L16:
        e = move-exception;
        if (isCancelled() == true) goto L20;
        this.responseHandler.sendFailureMessage(0, null, null, e);
        goto L22
    L20:
        AsyncHttpClient.log.e("AsyncHttpRequest", "makeRequestWithRetries returned error", e);
        goto L22
    }

    private void makeRequest() throws IOException {
        if (isCancelled() == false) goto L6;
        return;
    L6:
        if (this.request.getURI().getScheme() == null) goto L22;
        ResponseHandlerInterface r0 = this.responseHandler;
        if ((r0 instanceof RangeFileAsyncHttpResponseHandler) == false) goto L10;
        ((RangeFileAsyncHttpResponseHandler) r0).updateRequestHeaders(this.request);
    L10:
        CloseableHttpResponse r1 = this.client.execute(this.request, this.context);
        if (isCancelled() == false) goto L13;
        return;
    L13:
        ResponseHandlerInterface r2 = this.responseHandler;
        r2.onPreProcessResponse(r2, r1);
        if (isCancelled() == false) goto L16;
        return;
    L16:
        this.responseHandler.sendResponseMessage(r1);
        if (isCancelled() == false) goto L19;
        return;
    L19:
        ResponseHandlerInterface r3 = this.responseHandler;
        r3.onPostProcessResponse(r3, r1);
        return;
    L22:
        throw new MalformedURLException("No valid URI scheme was provided");
    }

    private void makeRequestWithRetries() throws IOException {
        HttpRequestRetryHandler r0 = this.client.getHttpRequestRetryHandler();
        IOException r2 = null;
        boolean r3 = true;
    L3:
        if (r3 == false) goto L50;
        makeRequest();     // Catch: Exception -> L6 IOException -> L8 NullPointerException -> L16 UnknownHostException -> L20
    L5:
        return;
    L16:
        e = move-exception;
        IOException r4 = new IOException("NPE in HttpClient: " + e.getMessage());     // Catch: Exception -> L6
        int r5 = this.executionCount + 1;     // Catch: Exception -> L32
        this.executionCount = r5;     // Catch: Exception -> L32
        boolean r6 = r0.retryRequest(r4, r5, this.context);     // Catch: Exception -> L32
    L28:
        r3 = r6;
        r2 = r4;
    L29:
        if (r3 == false) goto L3;
        this.responseHandler.sendRetryMessage(this.executionCount);     // Catch: Exception -> L6
    L32:
        e = e;
        r2 = r4;
    L34:
        AsyncHttpClient.log.e("AsyncHttpRequest", "Unhandled exception origin cause", e);
        throw new IOException("Unhandled exception: " + e.getMessage(), r2);
    L6:
        e = e;
    L8:
        e = move-exception;
        if (isCancelled() == true) goto L11;
        int r7 = this.executionCount + 1;     // Catch: Exception -> L14
        this.executionCount = r7;     // Catch: Exception -> L14
        r3 = r0.retryRequest(e, r7, this.context);     // Catch: Exception -> L14
        r2 = e;
    L14:
        e = e;
        r2 = e;
        goto L34
    L11:
        return;
    L20:
        e = move-exception;
        r4 = new IOException("UnknownHostException exception: " + e.getMessage(), e);     // Catch: Exception -> L6
        if (this.executionCount <= 0) goto L27;
        int r8 = this.executionCount + 1;     // Catch: Exception -> L32
        this.executionCount = r8;     // Catch: Exception -> L32
        if (r0.retryRequest(e, r8, this.context) == false) goto L27;
        r6 = true;
    L27:
        r6 = false;
        goto L28
    }

    public boolean isCancelled() {
        boolean r0 = this.isCancelled.get();
        if (r0 == false) goto L5;
        sendCancelNotification();
    L5:
        return r0;
    }

    private synchronized void sendCancelNotification() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.isFinished == false) goto L6;
    L10:
        monitor-exit(this);
        return;
    L6:
        if (this.isCancelled.get() == false) goto L10;
        if (this.cancelIsNotified == true) goto L10;
        this.cancelIsNotified = true;     // Catch: Throwable -> L12
        this.responseHandler.sendCancelMessage();     // Catch: Throwable -> L12
        goto L10
    }

    public boolean isDone() {
        if (isCancelled() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isFinished == true) goto L8;
        return false;
    }

    public boolean cancel(boolean r2) {
        this.isCancelled.set(true);
        this.request.abort();
        return isCancelled();
    }

    public AsyncHttpRequest setRequestTag(Object r2) {
        this.responseHandler.setTag(r2);
        return this;
    }

    public Object getTag() {
        return this.responseHandler.getTag();
    }
}
