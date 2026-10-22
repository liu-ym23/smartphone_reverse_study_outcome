package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
import com.bytedance.apm.agent.instrumentation.transaction.TransactionState;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes.dex */
public class InterceptorImpl implements Interceptor {
    private static final String TAG = "InterceptorImpl";

    private class ResponseBodyWrapper extends ResponseBody {
        private BufferedSource bufferedSource;
        private final Response response;
        private final ResponseBody responseBody;
        final /* synthetic */ InterceptorImpl this$0;
        private long totalBytesRead;
        private final TransactionState transactionState;

        static /* synthetic */ long access$000(ResponseBodyWrapper r2) {
            return r2.totalBytesRead;
        }

        static /* synthetic */ long access$002(ResponseBodyWrapper r0, long r1) {
            r0.totalBytesRead = r1;
            return r1;
        }

        static /* synthetic */ void access$100(ResponseBodyWrapper r0) {
            r0.end();
        }

        public ResponseBodyWrapper(InterceptorImpl r3, Response r4, TransactionState r5) {
            this.this$0 = r3;
            this.totalBytesRead = 0;
            this.response = r4;
            this.responseBody = r4.body();
            this.transactionState = r5;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.responseBody.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            if (this.bufferedSource != null) goto L6;
            this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
        L6:
            return this.bufferedSource;
        }

        private Source source(final Source r2) {
            return new AnonymousClass1(this, r2);
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.responseBody.close();
            end();
        }

        private void end() {
            if (this.transactionState.isComplete() == false) goto L5;
            return;
        L5:
            this.transactionState.setBytesReceived(this.totalBytesRead);
            MonitorRecorder.reportMonitorData(this.transactionState, this.response);
        }
    }

    public InterceptorImpl() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r7) throws IOException {
        Request r0 = r7.request();
        String r1 = r0.header("User-Agent");
        if (r1 != null) goto L5;
    L8:
        TransactionState r2 = new TransactionState();
        MonitorRecorder.recordRequest(r0, r2);
        Response r8 = r7.proceed(r0);     // Catch: IOException -> L18
        MonitorRecorder.recordResponse(r8, r2);
        if (r2.getReceivedBytes() < 0) goto L13;
    L16:
        MonitorRecorder.reportMonitorData(r2, r8);
        return r8;
    L13:
        if (TextUtils.isEmpty(r8.header(HTTP.TRANSFER_ENCODING)) == true) goto L16;
        r2.addAssistData(HTTP.TRANSFER_ENCODING, r8.header(HTTP.TRANSFER_ENCODING));
        return r8.newBuilder().body(new ResponseBodyWrapper(this, r8, r2)).build();
    L18:
        e = move-exception;
        MonitorRecorder.reportExceptionMonitor(r2, e);
        throw e;
    L5:
        if (r1.contains("tt") == false) goto L8;
        return r7.proceed(r0);
    }
}
