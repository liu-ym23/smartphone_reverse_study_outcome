package cz.msebera.android.httpclient.auth.params;

import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class AuthParamBean extends HttpAbstractParamBean {
    public AuthParamBean(HttpParams r1) {
        super(r1);
    }

    public void setCredentialCharset(String r1) {
        AuthParams.setCredentialCharset(this.params, r1);
    }
}
