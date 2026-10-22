package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.HttpTransportMetrics;

/* JADX INFO: loaded from: classes5.dex */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred;

    public HttpTransportMetricsImpl() {
        this.bytesTransferred = 0;
    }

    @Override // cz.msebera.android.httpclient.io.HttpTransportMetrics
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(long r1) {
        this.bytesTransferred = r1;
    }

    public void incrementBytesTransferred(long r3) {
        this.bytesTransferred += r3;
    }

    @Override // cz.msebera.android.httpclient.io.HttpTransportMetrics
    public void reset() {
        this.bytesTransferred = 0;
    }
}
