package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.protocol.RequestAddCookies;
import cz.msebera.android.httpclient.client.protocol.RequestAuthCache;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.client.protocol.RequestDefaultHeaders;
import cz.msebera.android.httpclient.client.protocol.RequestProxyAuthentication;
import cz.msebera.android.httpclient.client.protocol.RequestTargetAuthentication;
import cz.msebera.android.httpclient.client.protocol.ResponseProcessCookies;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.params.SyncBasicHttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpProcessor;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.RequestContent;
import cz.msebera.android.httpclient.protocol.RequestExpectContinue;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import cz.msebera.android.httpclient.util.VersionInfo;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultHttpClient extends AbstractHttpClient {
    public DefaultHttpClient(ClientConnectionManager r1, HttpParams r2) {
        super(r1, r2);
    }

    public DefaultHttpClient(ClientConnectionManager r2) {
        super(r2, null);
    }

    public DefaultHttpClient(HttpParams r2) {
        super(null, r2);
    }

    public DefaultHttpClient() {
        super(null, null);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    protected HttpParams createHttpParams() {
        SyncBasicHttpParams r0 = new SyncBasicHttpParams();
        setDefaultHttpParams(r0);
        return r0;
    }

    public static void setDefaultHttpParams(HttpParams r3) {
        HttpProtocolParams.setVersion(r3, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(r3, HTTP.DEF_CONTENT_CHARSET.name());
        HttpConnectionParams.setTcpNoDelay(r3, true);
        HttpConnectionParams.setSocketBufferSize(r3, 8192);
        HttpProtocolParams.setUserAgent(r3, VersionInfo.getUserAgent("Apache-HttpClient", "cz.msebera.android.httpclient.client", DefaultHttpClient.class));
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor r1 = new BasicHttpProcessor();
        r1.addInterceptor(new RequestDefaultHeaders());
        r1.addInterceptor(new RequestContent());
        r1.addInterceptor(new RequestTargetHost());
        r1.addInterceptor(new RequestClientConnControl());
        r1.addInterceptor(new RequestUserAgent());
        r1.addInterceptor(new RequestExpectContinue());
        r1.addInterceptor(new RequestAddCookies());
        r1.addInterceptor(new ResponseProcessCookies());
        r1.addInterceptor(new RequestAuthCache());
        r1.addInterceptor(new RequestTargetAuthentication());
        r1.addInterceptor(new RequestProxyAuthentication());
        return r1;
    }
}
