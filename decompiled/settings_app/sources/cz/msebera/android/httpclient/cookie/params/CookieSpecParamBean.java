package cz.msebera.android.httpclient.cookie.params;

import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class CookieSpecParamBean extends HttpAbstractParamBean {
    public CookieSpecParamBean(HttpParams r1) {
        super(r1);
    }

    public void setDatePatterns(Collection<String> r2) {
        this.params.setParameter(CookieSpecPNames.DATE_PATTERNS, r2);
    }

    public void setSingleHeader(boolean r2) {
        this.params.setBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, r2);
    }
}
