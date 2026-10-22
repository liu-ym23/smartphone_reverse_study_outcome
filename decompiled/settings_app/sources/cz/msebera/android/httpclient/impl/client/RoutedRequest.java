package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class RoutedRequest {
    protected final RequestWrapper request;
    protected final HttpRoute route;

    public RoutedRequest(RequestWrapper r1, HttpRoute r2) {
        this.request = r1;
        this.route = r2;
    }

    public final RequestWrapper getRequest() {
        return this.request;
    }

    public final HttpRoute getRoute() {
        return this.route;
    }
}
