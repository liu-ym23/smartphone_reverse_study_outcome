package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionKeepAliveStrategy {
    long getKeepAliveDuration(HttpResponse r1, HttpContext r2);
}
