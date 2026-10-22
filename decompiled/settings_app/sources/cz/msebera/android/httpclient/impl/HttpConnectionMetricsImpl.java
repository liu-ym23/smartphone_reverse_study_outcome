package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
    public static final String REQUEST_COUNT = "http.request-count";
    public static final String RESPONSE_COUNT = "http.response-count";
    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
    private final HttpTransportMetrics inTransportMetric;
    private Map<String, Object> metricsCache;
    private final HttpTransportMetrics outTransportMetric;
    private long requestCount;
    private long responseCount;

    public HttpConnectionMetricsImpl(HttpTransportMetrics r3, HttpTransportMetrics r4) {
        this.requestCount = 0;
        this.responseCount = 0;
        this.inTransportMetric = r3;
        this.outTransportMetric = r4;
    }

    @Override // cz.msebera.android.httpclient.HttpConnectionMetrics
    public long getReceivedBytesCount() {
        HttpTransportMetrics r2 = this.inTransportMetric;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getBytesTransferred();
    }

    @Override // cz.msebera.android.httpclient.HttpConnectionMetrics
    public long getSentBytesCount() {
        HttpTransportMetrics r2 = this.outTransportMetric;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getBytesTransferred();
    }

    @Override // cz.msebera.android.httpclient.HttpConnectionMetrics
    public long getRequestCount() {
        return this.requestCount;
    }

    public void incrementRequestCount() {
        this.requestCount++;
    }

    @Override // cz.msebera.android.httpclient.HttpConnectionMetrics
    public long getResponseCount() {
        return this.responseCount;
    }

    public void incrementResponseCount() {
        this.responseCount++;
    }

    @Override // cz.msebera.android.httpclient.HttpConnectionMetrics
    public Object getMetric(String r4) {
        Map<String, Object> r0 = this.metricsCache;
        if (r0 == null) goto L5;
        Object r1 = r0.get(r4);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (REQUEST_COUNT.equals(r4) == false) goto L11;
        return Long.valueOf(this.requestCount);
    L11:
        if (RESPONSE_COUNT.equals(r4) == false) goto L14;
        return Long.valueOf(this.responseCount);
    L14:
        if (RECEIVED_BYTES_COUNT.equals(r4) == false) goto L20;
        HttpTransportMetrics r3 = this.inTransportMetric;
        if (r3 != null) goto L18;
        return null;
    L18:
        return Long.valueOf(r3.getBytesTransferred());
    L20:
        if (SENT_BYTES_COUNT.equals(r4) == false) goto L30;
        HttpTransportMetrics r5 = this.outTransportMetric;
        if (r5 != null) goto L24;
        return null;
    L24:
        return Long.valueOf(r5.getBytesTransferred());
    L30:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public void setMetric(String r2, Object r3) {
        if (this.metricsCache != null) goto L5;
        this.metricsCache = new HashMap();
    L5:
        this.metricsCache.put(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.HttpConnectionMetrics
    public void reset() {
        HttpTransportMetrics r0 = this.outTransportMetric;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        HttpTransportMetrics r1 = this.inTransportMetric;
        if (r1 == null) goto L8;
        r1.reset();
    L8:
        this.requestCount = 0;
        this.responseCount = 0;
        this.metricsCache = null;
    }
}
