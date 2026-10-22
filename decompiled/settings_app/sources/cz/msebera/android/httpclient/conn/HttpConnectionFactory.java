package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.config.ConnectionConfig;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpConnectionFactory<T, C extends HttpConnection> {
    C create(T r1, ConnectionConfig r2);
}
