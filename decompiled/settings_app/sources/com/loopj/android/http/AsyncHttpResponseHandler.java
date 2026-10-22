package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpRH";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String UTF8_BOM = "\ufeff";
    private WeakReference<Object> TAG;
    private Handler handler;
    private Looper looper;
    private Header[] requestHeaders;
    private URI requestURI;
    private String responseCharset;
    private boolean usePoolThread;
    private boolean useSynchronousMode;

    private static class ResponderHandler extends Handler {
        private final AsyncHttpResponseHandler mResponder;

        ResponderHandler(AsyncHttpResponseHandler r1, Looper r2) {
            super(r2);
            this.mResponder = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            this.mResponder.handleMessage(r1);
        }
    }

    public abstract void onFailure(int r1, Header[] r2, byte[] r3, Throwable r4);

    public void onFinish() {
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void onPostProcessResponse(ResponseHandlerInterface r1, HttpResponse r2) {
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void onPreProcessResponse(ResponseHandlerInterface r1, HttpResponse r2) {
    }

    public void onStart() {
    }

    public abstract void onSuccess(int r1, Header[] r2, byte[] r3);

    public AsyncHttpResponseHandler() {
        this(null);
    }

    public AsyncHttpResponseHandler(Looper r2) {
        if (r2 != null) goto L4;
        r2 = Looper.myLooper();
    L4:
        this(r2, false);
    }

    public AsyncHttpResponseHandler(boolean r2) {
        if (r2 == false) goto L4;
        Looper r0 = null;
    L5:
        this(r0, r2);
        return;
    L4:
        r0 = Looper.myLooper();
        goto L5
    }

    private AsyncHttpResponseHandler(Looper r4, boolean r5) {
        this.responseCharset = "UTF-8";
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference(null);
        boolean r1 = true;
        if (r5 == true) goto L8;
        if (r4 != null) goto L7;
        r1 = false;
    L7:
        Utils.asserts(r1, "use looper thread, must call Looper.prepare() first!");
        this.looper = r4;
        this.handler = new ResponderHandler(this, r4);
    L12:
        this.usePoolThread = r5;
        return;
    L8:
        if (r4 == null) goto L11;
        r1 = false;
    L11:
        Utils.asserts(r1, "use pool thread, looper should be null!");
        this.looper = null;
        this.handler = null;
        goto L12
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public Object getTag() {
        return this.TAG.get();
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void setTag(Object r2) {
        this.TAG = new WeakReference(r2);
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public URI getRequestURI() {
        return this.requestURI;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void setRequestURI(URI r1) {
        this.requestURI = r1;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void setRequestHeaders(Header[] r1) {
        this.requestHeaders = r1;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void setUseSynchronousMode(boolean r3) {
        if (r3 == false) goto L4;
    L6:
        if (r3 == false) goto L8;
    L10:
        if (r3 == true) goto L12;
    L14:
        this.useSynchronousMode = r3;
        return;
    L12:
        if (this.handler == null) goto L14;
        this.handler = null;
        goto L14
    L8:
        if (this.handler != null) goto L10;
        this.handler = new ResponderHandler(this, this.looper);
        goto L14
    L4:
        if (this.looper != null) goto L6;
        AsyncHttpClient.log.w(LOG_TAG, "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
        r3 = true;
        goto L6
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public boolean getUsePoolThread() {
        return this.usePoolThread;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void setUsePoolThread(boolean r2) {
        if (r2 == false) goto L4;
        this.looper = null;
        this.handler = null;
    L4:
        this.usePoolThread = r2;
    }

    public String getCharset() {
        String r0 = this.responseCharset;
        if (r0 != null) goto L6;
        return "UTF-8";
    L6:
        return r0;
    }

    public void setCharset(String r1) {
        this.responseCharset = r1;
    }

    public void onProgress(long r5, long r7) {
        LogInterface r4 = AsyncHttpClient.log;
        Locale r0 = Locale.US;
        Object[] r1 = new Object[3];
        r1[0] = Long.valueOf(r5);
        r1[1] = Long.valueOf(r7);
        if (r7 <= 0) goto L5;
        double r6 = ((r5 * 1.0d) / r7) * 100.0d;
    L6:
        r1[2] = Double.valueOf(r6);
        r4.v(LOG_TAG, String.format(r0, "Progress %d from %d (%2.0f%%)", r1));
        return;
    L5:
        r6 = -1.0d;
        goto L6
    }

    public void onRetry(int r4) {
        AsyncHttpClient.log.d(LOG_TAG, String.format(Locale.US, "Request retry no. %d", new Object[]{Integer.valueOf(r4)}));
    }

    public void onCancel() {
        AsyncHttpClient.log.d(LOG_TAG, "Request got cancelled");
    }

    public void onUserException(Throwable r3) {
        AsyncHttpClient.log.e(LOG_TAG, "User-space exception detected!", r3);
        throw new RuntimeException(r3);
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendProgressMessage(long r3, long r5) {
        sendMessage(obtainMessage(4, new Object[]{Long.valueOf(r3), Long.valueOf(r5)}));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendSuccessMessage(int r3, Header[] r4, byte[] r5) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(r3), r4, r5}));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendFailureMessage(int r3, Header[] r4, byte[] r5, Throwable r6) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(r3), r4, r5, r6}));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendRetryMessage(int r3) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(r3)}));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendCancelMessage() {
        sendMessage(obtainMessage(6, null));
    }

    protected void handleMessage(Message r8) {
    L37:
        th = move-exception;
        onUserException(th);
        return;
    L4:
        switch(r8.what) {
            case 0: goto L30;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L13;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L40;
        };
    L6:
        onCancel();     // Catch: Throwable -> L37
        goto L40
    L7:
        Object[] r9 = (Object[]) r8.obj;     // Catch: Throwable -> L37
        if (r9 != null) goto L10;
    L12:
        AsyncHttpClient.log.e(LOG_TAG, "RETRY_MESSAGE didn't get enough params");     // Catch: Throwable -> L37
        goto L40
    L10:
        if (r9.length != 1) goto L12;
        onRetry(((Integer) r9[0]).intValue());     // Catch: Throwable -> L37
        goto L40
    L13:
        Object[] r10 = (Object[]) r8.obj;     // Catch: Throwable -> L37
        if (r10 != null) goto L16;
    L21:
        AsyncHttpClient.log.e(LOG_TAG, "PROGRESS_MESSAGE didn't got enough params");     // Catch: Throwable -> L37
        goto L40
    L16:
        if (r10.length < 2) goto L21;
        onProgress(((Long) r10[0]).longValue(), ((Long) r10[1]).longValue());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        AsyncHttpClient.log.e(LOG_TAG, "custom onProgress contains an error", th);     // Catch: Throwable -> L37
        goto L40
    L22:
        onFinish();     // Catch: Throwable -> L37
        goto L40
    L23:
        onStart();     // Catch: Throwable -> L37
        goto L40
    L24:
        Object[] r11 = (Object[]) r8.obj;     // Catch: Throwable -> L37
        if (r11 != null) goto L27;
    L29:
        AsyncHttpClient.log.e(LOG_TAG, "FAILURE_MESSAGE didn't got enough params");     // Catch: Throwable -> L37
        goto L40
    L27:
        if (r11.length < 4) goto L29;
        onFailure(((Integer) r11[0]).intValue(), (Header[]) r11[1], (byte[]) r11[2], (Throwable) r11[3]);     // Catch: Throwable -> L37
        goto L40
    L30:
        Object[] r12 = (Object[]) r8.obj;     // Catch: Throwable -> L37
        if (r12 != null) goto L33;
    L35:
        AsyncHttpClient.log.e(LOG_TAG, "SUCCESS_MESSAGE didn't got enough params");     // Catch: Throwable -> L37
        goto L40
    L33:
        if (r12.length < 3) goto L35;
        onSuccess(((Integer) r12[0]).intValue(), (Header[]) r12[1], (byte[]) r12[2]);     // Catch: Throwable -> L37
    L40:
    }

    protected void sendMessage(Message r3) {
        if (getUseSynchronousMode() == false) goto L5;
    L14:
        handleMessage(r3);
        return;
    L5:
        if (this.handler == null) goto L14;
        if (Thread.currentThread().isInterrupted() == false) goto L10;
        return;
    L10:
        if (this.handler == null) goto L12;
        boolean r0 = true;
    L13:
        Utils.asserts(r0, "handler should not be null!");
        this.handler.sendMessage(r3);
        return;
    L12:
        r0 = false;
        goto L13
    }

    protected void postRunnable(Runnable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (getUseSynchronousMode() == true) goto L9;
        Handler r1 = this.handler;
        if (r1 == null) goto L9;
        r1.post(r2);
        return;
    L9:
        r2.run();
    }

    protected Message obtainMessage(int r1, Object r2) {
        return Message.obtain(this.handler, r1, r2);
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponse r6) throws IOException {
        if (Thread.currentThread().isInterrupted() == true) goto L11;
        StatusLine r0 = r6.getStatusLine();
        byte[] r1 = getResponseData(r6.getEntity());
        if (Thread.currentThread().isInterrupted() == false) goto L7;
        return;
    L7:
        if (r0.getStatusCode() < 300) goto L9;
        sendFailureMessage(r0.getStatusCode(), r6.getAllHeaders(), r1, new HttpResponseException(r0.getStatusCode(), r0.getReasonPhrase()));
        return;
    L9:
        sendSuccessMessage(r0.getStatusCode(), r6.getAllHeaders(), r1);
        return;
    }

    byte[] getResponseData(HttpEntity r12) throws IOException {
        if (r12 == null) goto L31;
        InputStream r0 = r12.getContent();
        if (r0 == null) goto L31;
        long r1 = r12.getContentLength();
        if (r1 > 2147483647L) goto L30;
        long r3 = 0;
        if (r1 > 0) goto L10;
        int r7 = 4096;
    L35:
        ByteArrayBuffer r8 = new ByteArrayBuffer(r7);     // Catch: OutOfMemoryError -> L27
        byte[] r6 = new byte[4096];     // Catch: Throwable -> L24
    L13:
        int r9 = r0.read(r6);     // Catch: Throwable -> L24
        if (r9 == (-1)) goto L23;
        if (Thread.currentThread().isInterrupted() == true) goto L23;
        r3 = r3 + ((long) r9);     // Catch: Throwable -> L24
        r8.append(r6, 0, r9);     // Catch: Throwable -> L24
        if (r1 > 0) goto L20;
        long r10 = 1;
    L21:
        sendProgressMessage(r3, r10);     // Catch: Throwable -> L24
    L20:
        r10 = r1;
    L23:
        AsyncHttpClient.silentCloseInputStream(r0);     // Catch: OutOfMemoryError -> L27
        AsyncHttpClient.endEntityViaReflection(r12);     // Catch: OutOfMemoryError -> L27
        return r8.toByteArray();
    L24:
        th = move-exception;
        AsyncHttpClient.silentCloseInputStream(r0);     // Catch: OutOfMemoryError -> L27
        AsyncHttpClient.endEntityViaReflection(r12);     // Catch: OutOfMemoryError -> L27
        throw th;     // Catch: OutOfMemoryError -> L27
    L27:
        System.gc();
        throw new IOException("File too large to fit into available memory");
    L10:
        r7 = (int) r1;
        goto L35
    L30:
        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
    L31:
        return null;
    }
}
