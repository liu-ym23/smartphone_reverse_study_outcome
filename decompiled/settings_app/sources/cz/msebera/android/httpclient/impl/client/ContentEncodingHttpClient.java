package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpProcessor;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ContentEncodingHttpClient extends DefaultHttpClient {
    public ContentEncodingHttpClient(ClientConnectionManager r1, HttpParams r2) {
        super(r1, r2);
    }

    public ContentEncodingHttpClient(HttpParams r2) {
        this(null, r2);
    }

    public ContentEncodingHttpClient() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.impl.client.DefaultHttpClient, cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor r1 = super.createHttpProcessor();
        r1.addRequestInterceptor(new RequestAcceptEncoding());
        r1.addResponseInterceptor(new ResponseContentEncoding());
        return r1;
    }
}
