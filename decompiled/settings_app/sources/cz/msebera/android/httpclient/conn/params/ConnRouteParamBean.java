package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ConnRouteParamBean extends HttpAbstractParamBean {
    public ConnRouteParamBean(HttpParams r1) {
        super(r1);
    }

    public void setDefaultProxy(HttpHost r2) {
        this.params.setParameter(ConnRoutePNames.DEFAULT_PROXY, r2);
    }

    public void setLocalAddress(InetAddress r2) {
        this.params.setParameter(ConnRoutePNames.LOCAL_ADDRESS, r2);
    }

    public void setForcedRoute(HttpRoute r2) {
        this.params.setParameter(ConnRoutePNames.FORCED_ROUTE, r2);
    }
}
