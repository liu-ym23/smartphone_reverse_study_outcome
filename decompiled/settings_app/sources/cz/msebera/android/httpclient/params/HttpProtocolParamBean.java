package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.HttpVersion;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpProtocolParamBean extends HttpAbstractParamBean {
    public HttpProtocolParamBean(HttpParams r1) {
        super(r1);
    }

    public void setHttpElementCharset(String r1) {
        HttpProtocolParams.setHttpElementCharset(this.params, r1);
    }

    public void setContentCharset(String r1) {
        HttpProtocolParams.setContentCharset(this.params, r1);
    }

    public void setVersion(HttpVersion r1) {
        HttpProtocolParams.setVersion(this.params, r1);
    }

    public void setUserAgent(String r1) {
        HttpProtocolParams.setUserAgent(this.params, r1);
    }

    public void setUseExpectContinue(boolean r1) {
        HttpProtocolParams.setUseExpectContinue(this.params, r1);
    }
}
