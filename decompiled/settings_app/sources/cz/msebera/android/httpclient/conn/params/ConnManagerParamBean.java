package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ConnManagerParamBean extends HttpAbstractParamBean {
    public ConnManagerParamBean(HttpParams r1) {
        super(r1);
    }

    public void setTimeout(long r2) {
        this.params.setLongParameter("http.conn-manager.timeout", r2);
    }

    public void setMaxTotalConnections(int r2) {
        this.params.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, r2);
    }

    public void setConnectionsPerRoute(ConnPerRouteBean r2) {
        this.params.setParameter(ConnManagerPNames.MAX_CONNECTIONS_PER_ROUTE, r2);
    }
}
