package com.loopj.android.http;

import android.os.Message;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "DataAsyncHttpRH";
    protected static final int PROGRESS_DATA_MESSAGE = 7;

    public DataAsyncHttpResponseHandler() {
    }

    public static byte[] copyOfRange(byte[] r2, int r3, int r4) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
        if (r3 > r4) goto L11;
        int r0 = r2.length;
        if (r3 < 0) goto L9;
        if (r3 > r0) goto L9;
        int r5 = r4 - r3;
        int r1 = Math.min(r5, r0 - r3);
        byte[] r6 = new byte[r5];
        System.arraycopy(r2, r3, r6, 0, r1);
        return r6;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException();
    }

    public void onProgressData(byte[] r2) {
        AsyncHttpClient.log.d(LOG_TAG, "onProgressData(byte[]) was not overriden, but callback was received");
    }

    public final void sendProgressDataMessage(byte[] r3) {
        sendMessage(obtainMessage(7, new Object[]{r3}));
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    protected void handleMessage(Message r4) {
        super.handleMessage(r4);
        if (r4.what != 7) goto L19;
        Object[] r5 = (Object[]) r4.obj;
        if (r5 != null) goto L8;
    L14:
        AsyncHttpClient.log.e(LOG_TAG, "PROGRESS_DATA_MESSAGE didn't got enough params");
        return;
    L8:
        if (r5.length < 1) goto L14;
        onProgressData((byte[]) r5[0]);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        AsyncHttpClient.log.e(LOG_TAG, "custom onProgressData contains an error", th);
        return;
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    byte[] getResponseData(HttpEntity r7) throws IOException {
        if (r7 == null) goto L27;
        InputStream r0 = r7.getContent();
        if (r0 == null) goto L27;
        long r1 = r7.getContentLength();
        if (r1 > 2147483647L) goto L26;
        if (r1 >= 0) goto L31;
        r1 = 4096;
    L31:
        ByteArrayBuffer r8 = new ByteArrayBuffer((int) r1);     // Catch: OutOfMemoryError -> L23
        byte[] r3 = new byte[4096];     // Catch: Throwable -> L20
    L13:
        int r4 = r0.read(r3);     // Catch: Throwable -> L20
        if (r4 == (-1)) goto L19;
        if (Thread.currentThread().isInterrupted() == true) goto L19;
        r8.append(r3, 0, r4);     // Catch: Throwable -> L20
        sendProgressDataMessage(copyOfRange(r3, 0, r4));     // Catch: Throwable -> L20
        sendProgressMessage(0, r1);     // Catch: Throwable -> L20
    L19:
        AsyncHttpClient.silentCloseInputStream(r0);     // Catch: OutOfMemoryError -> L23
        return r8.toByteArray();
    L20:
        th = move-exception;
        AsyncHttpClient.silentCloseInputStream(r0);     // Catch: OutOfMemoryError -> L23
        throw th;     // Catch: OutOfMemoryError -> L23
    L23:
        System.gc();
        throw new IOException("File too large to fit into available memory");
    L26:
        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
    L27:
        return null;
    }
}
