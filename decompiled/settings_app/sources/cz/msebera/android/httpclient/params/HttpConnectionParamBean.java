package cz.msebera.android.httpclient.params;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpConnectionParamBean extends HttpAbstractParamBean {
    public HttpConnectionParamBean(HttpParams r1) {
        super(r1);
    }

    public void setSoTimeout(int r1) {
        HttpConnectionParams.setSoTimeout(this.params, r1);
    }

    public void setTcpNoDelay(boolean r1) {
        HttpConnectionParams.setTcpNoDelay(this.params, r1);
    }

    public void setSocketBufferSize(int r1) {
        HttpConnectionParams.setSocketBufferSize(this.params, r1);
    }

    public void setLinger(int r1) {
        HttpConnectionParams.setLinger(this.params, r1);
    }

    public void setConnectionTimeout(int r1) {
        HttpConnectionParams.setConnectionTimeout(this.params, r1);
    }

    public void setStaleCheckingEnabled(boolean r1) {
        HttpConnectionParams.setStaleCheckingEnabled(this.params, r1);
    }
}
