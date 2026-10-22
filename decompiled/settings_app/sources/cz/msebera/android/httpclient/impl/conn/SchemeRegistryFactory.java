package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class SchemeRegistryFactory {
    public SchemeRegistryFactory() {
    }

    public static SchemeRegistry createDefault() {
        SchemeRegistry r0 = new SchemeRegistry();
        r0.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        r0.register(new Scheme(HttpHeadTimeFetcher.FETCHER_TYPE, 443, SSLSocketFactory.getSocketFactory()));
        return r0;
    }

    public static SchemeRegistry createSystemDefault() {
        SchemeRegistry r0 = new SchemeRegistry();
        r0.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        r0.register(new Scheme(HttpHeadTimeFetcher.FETCHER_TYPE, 443, SSLSocketFactory.getSystemSocketFactory()));
        return r0;
    }
}
