package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {
    private static final String LOG_TAG = "RangeFileAsyncHttpRH";
    private boolean append;
    private long current;

    public RangeFileAsyncHttpResponseHandler(File r3) {
        super(r3);
        this.current = 0;
        this.append = false;
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler, com.loopj.android.http.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponse r6) throws IOException {
        if (Thread.currentThread().isInterrupted() == true) goto L22;
        StatusLine r0 = r6.getStatusLine();
        if (r0.getStatusCode() != 416) goto L10;
        if (Thread.currentThread().isInterrupted() == true) goto L23;
        sendSuccessMessage(r0.getStatusCode(), r6.getAllHeaders(), null);
        return;
    L23:
        return;
    L10:
        if (r0.getStatusCode() < 300) goto L15;
        if (Thread.currentThread().isInterrupted() == true) goto L25;
        sendFailureMessage(r0.getStatusCode(), r6.getAllHeaders(), null, new HttpResponseException(r0.getStatusCode(), r0.getReasonPhrase()));
        return;
    L25:
        return;
    L15:
        if (Thread.currentThread().isInterrupted() == true) goto L27;
        Header r1 = r6.getFirstHeader("Content-Range");
        if (r1 != null) goto L19;
        this.append = false;
        this.current = 0;
    L20:
        sendSuccessMessage(r0.getStatusCode(), r6.getAllHeaders(), getResponseData(r6.getEntity()));
        return;
    L19:
        AsyncHttpClient.log.v(LOG_TAG, "Content-Range: " + r1.getValue());
        goto L20
    L27:
        return;
    }

    @Override // com.loopj.android.http.FileAsyncHttpResponseHandler, com.loopj.android.http.AsyncHttpResponseHandler
    protected byte[] getResponseData(HttpEntity r10) throws IOException {
        if (r10 == null) goto L19;
        InputStream r0 = r10.getContent();
        long r1 = r10.getContentLength() + this.current;
        FileOutputStream r11 = new FileOutputStream(getTargetFile(), this.append);
        if (r0 != null) goto L21;
        return null;
    L21:
        byte[] r3 = new byte[4096];     // Catch: Throwable -> L16
    L8:
        if (this.current >= r1) goto L15;
        int r4 = r0.read(r3);     // Catch: Throwable -> L16
        if (r4 == (-1)) goto L15;
        if (Thread.currentThread().isInterrupted() == true) goto L15;
        this.current += (long) r4;     // Catch: Throwable -> L16
        r11.write(r3, 0, r4);     // Catch: Throwable -> L16
        sendProgressMessage(this.current, r1);     // Catch: Throwable -> L16
    L15:
        r0.close();
        r11.flush();
        r11.close();
        return null;
    L16:
        th = move-exception;
        r0.close();
        r11.flush();
        r11.close();
        throw th;
    L19:
        return null;
    }

    public void updateRequestHeaders(HttpUriRequest r5) {
        if (this.file.exists() == false) goto L8;
        if (this.file.canWrite() == false) goto L8;
        this.current = this.file.length();
    L8:
        if (this.current <= 0) goto L11;
        this.append = true;
        r5.setHeader("Range", "bytes=" + this.current + "-");
        return;
    }
}
