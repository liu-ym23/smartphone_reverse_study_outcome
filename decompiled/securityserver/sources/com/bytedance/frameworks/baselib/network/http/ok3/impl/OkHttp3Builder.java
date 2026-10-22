package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3Builder {
    private static final int FRAMED_APPLYED = 4;
    private static final int FRAMED_NO_ALL = 3;
    private static final int FRAMED_NO_H2 = 2;
    private static final int FRAMED_NO_SPDY = 1;
    public static final String TAG = "OkHttp3Builder";
    private static int sDisableFramedTransport;
    private static IOkHttpClientBuilderHook sOkHttpClientBuilderHook;
    private Ok3TncBridge mOk3TncBridge;
    private OkHttpClient mOkClient;

    public interface IOkHttpClientBuilderHook {
        void addBuilderConfig(OkHttpClient.Builder r1);
    }

    public OkHttp3Builder() {
    }

    private static OkHttpClient checkDisableFramedTransport(OkHttpClient r2) {
        int r0 = sDisableFramedTransport;
        if (r0 > 0) goto L5;
        return r2;
    L5:
        if (r0 >= 4) goto L10;
        if (r2 == null) goto L11;
        OkHttpClient.Builder r3 = r2.newBuilder();
        setProtocols(r3);
        return r3.build();
    L11:
        return r2;
    L10:
        return r2;
    }

    public static void disableFramedTransport(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        if (sDisableFramedTransport != 0) goto L8;
        sDisableFramedTransport = r1;
        return;
    }

    private static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder r0) {
        return r0;
    }

    private static OkHttpClient.Builder enableTls12WithTwoParamsMethod(OkHttpClient.Builder r3, SSLContext r4) {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init(null);
        TrustManager[] r1 = r0.getTrustManagers();
        if (r1.length != 1) goto L9;
        TrustManager r2 = r1[0];
        if ((r2 instanceof X509TrustManager) == false) goto L9;
        r3.sslSocketFactory(new Tls12SocketFactory(r4.getSocketFactory()), (X509TrustManager) r2);
        return r3;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));
    }

    public static void setOkHttpClientBuilderHook(IOkHttpClientBuilderHook r0) {
        sOkHttpClientBuilderHook = r0;
    }

    private static void setProtocols(OkHttpClient.Builder r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        int r1 = sDisableFramedTransport;
        if (r1 != 1) goto L7;
        r0.add(Protocol.HTTP_2);
    L13:
        sDisableFramedTransport = 4;
        r0.add(Protocol.HTTP_1_1);
        r3.protocols(Collections.unmodifiableList(r0));
        return;
    L7:
        if (r1 != 2) goto L9;
        r0.add(Protocol.SPDY_3);
        goto L13
    L9:
        if (r1 == 3) goto L13;
        r0.add(Protocol.HTTP_2);
        r0.add(Protocol.SPDY_3);
        goto L13
    }

    public OkHttpClient build() {
        return build(true);
    }

    public void setOk3TncBridge(Ok3TncBridge r1) {
        this.mOk3TncBridge = r1;
    }

    public OkHttpClient build(boolean r7) {
        if (r7 == false) goto L5;
        NetworkParams.tryNecessaryInit();
    L5:
        monitor-enter(NetworkParams.class);
        OkHttpClient r0 = this.mOkClient;     // Catch: Throwable -> L11
        if (r0 == null) goto L13;
        checkDisableFramedTransport(r0);     // Catch: Throwable -> L11
        OkHttpClient r6 = this.mOkClient;     // Catch: Throwable -> L11
        monitor-exit(NetworkParams.class);     // Catch: Throwable -> L11
        return r6;
    L13:
        OkHttpClient.Builder r1 = new OkHttpClient.Builder();     // Catch: Throwable -> L11
        int r2 = sDisableFramedTransport;     // Catch: Throwable -> L11
        if (r2 > 0) goto L16;
    L18:
        TimeUnit r3 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L11
        r1.connectionPool(new ConnectionPool(15, 180000, r3));     // Catch: Throwable -> L11
        r1.connectTimeout(15000, r3);     // Catch: Throwable -> L11
        r1.readTimeout(15000, r3);     // Catch: Throwable -> L11
        r1.writeTimeout(15000, r3);     // Catch: Throwable -> L11
        r1.addNetworkInterceptor(new AnonymousClass1(this));     // Catch: Throwable -> L11
        r1.ttnetDns(OkHttp3DnsParserInterceptor.inst());     // Catch: Throwable -> L11
        r1.cookieJar(CookieJar.NO_COOKIES);     // Catch: Throwable -> L11
        r1.addNetworkInterceptor(new OkHttp3CookieInterceptor());     // Catch: Throwable -> L11
        r1.addInterceptor(new OkHttp3SecurityFactorInterceptor());     // Catch: Throwable -> L11
        r1.addInterceptor(new OkHttp3TTPSandBoxInterceptor());     // Catch: Throwable -> L11
        r1.addNetworkInterceptor(new OkHttp3PureControlInterceptor());     // Catch: Throwable -> L11
        OkHttpClient.Builder r4 = enableTls12OnPreLollipop(r1);     // Catch: Throwable -> L11
        r4.followRedirects(true);     // Catch: Throwable -> L11
        IOkHttpClientBuilderHook r5 = sOkHttpClientBuilderHook;     // Catch: Throwable -> L11
        if (r5 == null) goto L21;
        r5.addBuilderConfig(r4);     // Catch: Throwable -> L11
    L21:
        OkHttpClient r8 = r4.build();     // Catch: Throwable -> L11
        this.mOkClient = r8;     // Catch: Throwable -> L11
        monitor-exit(NetworkParams.class);     // Catch: Throwable -> L11
        return r8;
    L16:
        if (r2 >= 4) goto L18;
        setProtocols(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
