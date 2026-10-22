package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AsyncNetwork;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestTask;
import com.android.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class BasicAsyncNetwork extends AsyncNetwork {
    private final AsyncHttpStack mAsyncStack;
    private final ByteArrayPool mPool;

    public static class Builder {
        private static final int DEFAULT_POOL_SIZE = 4096;
        private AsyncHttpStack mAsyncStack;
        private ByteArrayPool mPool;

        public Builder(AsyncHttpStack r1) {
            this.mAsyncStack = r1;
            this.mPool = null;
        }

        public Builder setPool(ByteArrayPool r1) {
            this.mPool = r1;
            return this;
        }

        public BasicAsyncNetwork build() {
            if (this.mPool != null) goto L6;
            this.mPool = new ByteArrayPool(4096);
        L6:
            return new BasicAsyncNetwork(this.mAsyncStack, this.mPool, null);
        }
    }

    private class InvokeRetryPolicyTask<T> extends RequestTask<T> {
        final AsyncNetwork.OnRequestComplete callback;
        final Request<T> request;
        final NetworkUtility.RetryInfo retryInfo;
        final /* synthetic */ BasicAsyncNetwork this$0;

        InvokeRetryPolicyTask(BasicAsyncNetwork r1, Request<T> r2, NetworkUtility.RetryInfo r3, AsyncNetwork.OnRequestComplete r4) {
            this.this$0 = r1;
            super(r2);
            this.request = r2;
            this.retryInfo = r3;
            this.callback = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkUtility.attemptRetryOnException(this.request, this.retryInfo);     // Catch: VolleyError -> L4
            this.this$0.performRequest(this.request, this.callback);     // Catch: VolleyError -> L4
            return;
        L4:
            e = move-exception;
            this.callback.onError(e);
        }
    }

    private class ResponseParsingTask<T> extends RequestTask<T> {
        AsyncNetwork.OnRequestComplete callback;
        HttpResponse httpResponse;
        InputStream inputStream;
        Request<T> request;
        long requestStartMs;
        List<Header> responseHeaders;
        int statusCode;
        final /* synthetic */ BasicAsyncNetwork this$0;

        ResponseParsingTask(BasicAsyncNetwork r1, InputStream r2, HttpResponse r3, Request<T> r4, AsyncNetwork.OnRequestComplete r5, long r6, List<Header> r8, int r9) {
            this.this$0 = r1;
            super(r4);
            this.inputStream = r2;
            this.httpResponse = r3;
            this.request = r4;
            this.callback = r5;
            this.requestStartMs = r6;
            this.responseHeaders = r8;
            this.statusCode = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] r11 = NetworkUtility.inputStreamToBytes(this.inputStream, this.httpResponse.getContentLength(), BasicAsyncNetwork.access$200(this.this$0));     // Catch: IOException -> L5
            BasicAsyncNetwork.access$300(this.this$0, this.requestStartMs, this.statusCode, this.httpResponse, this.request, this.callback, this.responseHeaders, r11);
            return;
        L5:
            e = move-exception;
            BasicAsyncNetwork.access$100(this.this$0, this.request, this.callback, e, this.requestStartMs, this.httpResponse, null);
        }
    }

    /* synthetic */ BasicAsyncNetwork(AsyncHttpStack r1, ByteArrayPool r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ void access$000(BasicAsyncNetwork r0, Request r1, long r2, HttpResponse r4, AsyncNetwork.OnRequestComplete r5) {
        r0.onRequestSucceeded(r1, r2, r4, r5);
    }

    static /* synthetic */ void access$100(BasicAsyncNetwork r0, Request r1, AsyncNetwork.OnRequestComplete r2, IOException r3, long r4, HttpResponse r6, byte[] r7) {
        r0.onRequestFailed(r1, r2, r3, r4, r6, r7);
    }

    static /* synthetic */ ByteArrayPool access$200(BasicAsyncNetwork r0) {
        return r0.mPool;
    }

    static /* synthetic */ void access$300(BasicAsyncNetwork r0, long r1, int r3, HttpResponse r4, Request r5, AsyncNetwork.OnRequestComplete r6, List r7, byte[] r8) {
        r0.onResponseRead(r1, r3, r4, r5, r6, r7, r8);
    }

    private BasicAsyncNetwork(AsyncHttpStack r1, ByteArrayPool r2) {
        this.mAsyncStack = r1;
        this.mPool = r2;
    }

    @Override // com.android.volley.AsyncNetwork
    public void setBlockingExecutor(ExecutorService r1) {
        super.setBlockingExecutor(r1);
        this.mAsyncStack.setBlockingExecutor(r1);
    }

    @Override // com.android.volley.AsyncNetwork
    public void setNonBlockingExecutor(ExecutorService r1) {
        super.setNonBlockingExecutor(r1);
        this.mAsyncStack.setNonBlockingExecutor(r1);
    }

    private void onRequestSucceeded(Request<?> r13, long r14, HttpResponse r16, AsyncNetwork.OnRequestComplete r17) {
        int r9 = r16.getStatusCode();
        List<Header> r8 = r16.getHeaders();
        if (r9 != 304) goto L6;
        r17.onSuccess(NetworkUtility.getNotModifiedNetworkResponse(r13, SystemClock.elapsedRealtime() - r14, r8));
        return;
    L6:
        byte[] r0 = r16.getContentBytes();
        if (r0 == null) goto L9;
    L11:
        byte[] r10 = r0;
        if (r10 == null) goto L15;
        onResponseRead(r14, r9, r16, r13, r17, r8, r10);
        return;
    L15:
        InputStream r2 = r16.getContent();
        getBlockingExecutor().execute(new ResponseParsingTask(this, r2, r16, r13, r17, r14, r8, r9));
        return;
    L9:
        if (r16.getContent() != null) goto L11;
        r0 = new byte[0];
        goto L11
    }

    private void onRequestFailed(Request<?> r7, AsyncNetwork.OnRequestComplete r8, IOException r9, long r10, HttpResponse r12, byte[] r13) {
        NetworkUtility.RetryInfo r11 = NetworkUtility.shouldRetryException(r7, r9, r10, r12, r13);     // Catch: VolleyError -> L5
        getBlockingExecutor().execute(new InvokeRetryPolicyTask(this, r7, r11, r8));     // Catch: VolleyError -> L5
        return;
    L5:
        e = move-exception;
        r8.onError(e);
    }

    @Override // com.android.volley.AsyncNetwork
    public void performRequest(final Request<?> r10, final AsyncNetwork.OnRequestComplete r11) {
        if (getBlockingExecutor() == null) goto L7;
        final long r4 = SystemClock.elapsedRealtime();
        Map<String, String> r0 = HttpHeaderParser.getCacheHeaders(r10.getCacheEntry());
        this.mAsyncStack.executeRequest(r10, r0, new AnonymousClass1(this, r10, r4, r11));
        return;
    L7:
        throw new IllegalStateException("mBlockingExecuter must be set before making a request");
    }

    private void onResponseRead(long r10, int r12, HttpResponse r13, Request<?> r14, AsyncNetwork.OnRequestComplete r15, List<Header> r16, byte[] r17) {
        NetworkUtility.logSlowRequests(SystemClock.elapsedRealtime() - r10, r14, r17, r12);
        if (r12 >= 200) goto L5;
    L9:
        onRequestFailed(r14, r15, new IOException(), r10, r13, r17);
        return;
    L5:
        if (r12 > 299) goto L9;
        r15.onSuccess(new NetworkResponse(r12, r17, false, SystemClock.elapsedRealtime() - r10, r16));
    }
}
