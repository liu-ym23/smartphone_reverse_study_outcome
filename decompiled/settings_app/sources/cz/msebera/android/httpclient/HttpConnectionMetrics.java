package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpConnectionMetrics {
    Object getMetric(String r1);

    long getReceivedBytesCount();

    long getRequestCount();

    long getResponseCount();

    long getSentBytesCount();

    void reset();
}
