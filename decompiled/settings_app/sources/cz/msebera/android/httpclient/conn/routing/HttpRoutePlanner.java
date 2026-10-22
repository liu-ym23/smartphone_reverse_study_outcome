package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpRoutePlanner {
    HttpRoute determineRoute(HttpHost r1, HttpRequest r2, HttpContext r3) throws HttpException;
}
