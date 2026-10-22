package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncHttpStack extends BaseHttpStack {
    private ExecutorService mBlockingExecutor;
    private ExecutorService mNonBlockingExecutor;

    public interface OnRequestComplete {
        void onAuthError(AuthFailureError r1);

        void onError(IOException r1);

        void onSuccess(HttpResponse r1);
    }

    private static class Response {
        AuthFailureError authFailureError;
        HttpResponse httpResponse;
        IOException ioException;

        /* synthetic */ Response(HttpResponse r1, IOException r2, AuthFailureError r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private Response(HttpResponse r1, IOException r2, AuthFailureError r3) {
            this.httpResponse = r1;
            this.ioException = r2;
            this.authFailureError = r3;
        }
    }

    public abstract void executeRequest(Request<?> r1, Map<String, String> r2, OnRequestComplete r3);

    public AsyncHttpStack() {
    }

    public void setNonBlockingExecutor(ExecutorService r1) {
        this.mNonBlockingExecutor = r1;
    }

    public void setBlockingExecutor(ExecutorService r1) {
        this.mBlockingExecutor = r1;
    }

    protected ExecutorService getBlockingExecutor() {
        return this.mBlockingExecutor;
    }

    protected ExecutorService getNonBlockingExecutor() {
        return this.mNonBlockingExecutor;
    }

    @Override // com.android.volley.toolbox.BaseHttpStack
    public final HttpResponse executeRequest(Request<?> r4, Map<String, String> r5) throws IOException, AuthFailureError {
        final CountDownLatch r0 = new CountDownLatch(1);
        final AtomicReference r1 = new AtomicReference();
        executeRequest(r4, r5, new AnonymousClass1(this, r1, r0));
        r0.await();     // Catch: InterruptedException -> L14
        Response r3 = (Response) r1.get();
        if (r3.httpResponse == null) goto L9;
        return r3.httpResponse;
    L9:
        if (r3.ioException == null) goto L13;
        throw r3.ioException;
    L13:
        throw r3.authFailureError;
    L14:
        e = move-exception;
        VolleyLog.e(e, "while waiting for CountDownLatch", new Object[0]);
        Thread.currentThread().interrupt();
        throw new InterruptedIOException(e.toString());
    }
}
