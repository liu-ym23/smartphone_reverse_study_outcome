package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.ClientError;
import com.android.volley.Header;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class NetworkUtility {
    private static final int SLOW_REQUEST_THRESHOLD_MS = 3000;

    /* JADX INFO: renamed from: com.android.volley.toolbox.NetworkUtility$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class RetryInfo {
        private final VolleyError errorToRetry;
        private final String logPrefix;

        /* synthetic */ RetryInfo(String r1, VolleyError r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ VolleyError access$000(RetryInfo r0) {
            return r0.errorToRetry;
        }

        static /* synthetic */ String access$100(RetryInfo r0) {
            return r0.logPrefix;
        }

        private RetryInfo(String r1, VolleyError r2) {
            this.logPrefix = r1;
            this.errorToRetry = r2;
        }
    }

    private NetworkUtility() {
    }

    static void logSlowRequests(long r2, Request<?> r4, byte[] r5, int r6) {
        if (VolleyLog.DEBUG == false) goto L5;
    L6:
        Object[] r0 = new Object[5];
        r0[0] = r4;
        r0[1] = Long.valueOf(r2);
        if (r5 == null) goto L9;
        Object r3 = Integer.valueOf(r5.length);
    L10:
        r0[2] = r3;
        r0[3] = Integer.valueOf(r6);
        r0[4] = Integer.valueOf(r4.getRetryPolicy().getCurrentRetryCount());
        VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", r0);
        return;
    L9:
        r3 = "null";
        goto L10
    L5:
        if (r2 > WsConstants.EXIT_DELAY_TIME) goto L6;
    }

    static NetworkResponse getNotModifiedNetworkResponse(Request<?> r11, long r12, List<Header> r14) {
        Cache.Entry r13 = r11.getCacheEntry();
        if (r13 == null) goto L5;
        List<Header> r10 = HttpHeaderParser.combineHeaders(r14, r13);
        return new NetworkResponse(304, r13.data, true, r12, r10);
    L5:
        return new NetworkResponse(304, null, true, r12, r14);
    }

    static byte[] inputStreamToBytes(InputStream r5, int r6, ByteArrayPool r7) throws IOException {
        PoolingByteArrayOutputStream r1 = new PoolingByteArrayOutputStream(r7, r6);
        byte[] r8 = r7.getBuf(1024);     // Catch: Throwable -> L16
    L30:
        int r3 = r5.read(r8);     // Catch: Throwable -> L14
        if (r3 == (-1)) goto L7;
        r1.write(r8, 0, r3);     // Catch: Throwable -> L14
        goto L30
    L7:
        byte[] r4 = r1.toByteArray();     // Catch: Throwable -> L14
        if (r5 != null) goto L28;
    L12:
        r7.returnBuf(r8);
        r1.close();
        return r4;
    L28:
        r5.close();     // Catch: IOException -> L11
    L11:
        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
    L14:
        th = th;
    L18:
        if (r5 != null) goto L24;
    L22:
        r7.returnBuf(r8);
        r1.close();
        throw th;
    L24:
        r5.close();     // Catch: IOException -> L21
    L21:
        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
    L16:
        th = th;
        r8 = null;
        goto L18
    }

    static void attemptRetryOnException(Request<?> r6, RetryInfo r7) throws VolleyError {
        RetryPolicy r0 = r6.getRetryPolicy();
        int r1 = r6.getTimeoutMs();
        r0.retry(RetryInfo.access$000(r7));     // Catch: VolleyError -> L6
        r6.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{RetryInfo.access$100(r7), Integer.valueOf(r1)}));
        return;
    L6:
        e = move-exception;
        r6.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{RetryInfo.access$100(r7), Integer.valueOf(r1)}));
        throw e;
    }

    static RetryInfo shouldRetryException(Request<?> r9, IOException r10, long r11, HttpResponse r13, byte[] r14) throws VolleyError {
        AnonymousClass1 r1 = null;
        if ((r10 instanceof SocketTimeoutException) == false) goto L7;
        return new RetryInfo("socket", new TimeoutError(), r1);
    L7:
        if ((r10 instanceof MalformedURLException) == true) goto L44;
        if (r13 == null) goto L38;
        int r12 = r13.getStatusCode();
        VolleyLog.e("Unexpected response code %d for %s", new Object[]{Integer.valueOf(r12), r9.getUrl()});
        if (r14 == null) goto L36;
        NetworkResponse r15 = new NetworkResponse(r12, r14, false, SystemClock.elapsedRealtime() - r11, r13.getHeaders());
        if (r12 == 401) goto L34;
        if (r12 == 403) goto L34;
        if (r12 < 400) goto L24;
        if (r12 > 499) goto L24;
        throw new ClientError(r15);
    L24:
        if (r12 < 500) goto L32;
        if (r12 > 599) goto L32;
        if (r9.shouldRetryServerErrors() == false) goto L32;
        return new RetryInfo("server", new ServerError(r15), r1);
    L32:
        throw new ServerError(r15);
    L34:
        return new RetryInfo("auth", new AuthFailureError(r15), r1);
    L36:
        return new RetryInfo("network", new NetworkError(), r1);
    L38:
        if (r9.shouldRetryConnectionErrors() == false) goto L42;
        return new RetryInfo(WsConstants.KEY_CONNECTION, new NoConnectionError(), r1);
    L42:
        throw new NoConnectionError(r10);
    L44:
        throw new RuntimeException("Bad URL " + r9.getUrl(), r10);
    }
}
