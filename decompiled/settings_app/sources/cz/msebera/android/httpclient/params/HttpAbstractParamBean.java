package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class HttpAbstractParamBean {
    protected final HttpParams params;

    public HttpAbstractParamBean(HttpParams r2) {
        this.params = (HttpParams) Args.notNull(r2, "HTTP parameters");
    }
}
