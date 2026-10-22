package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.util.Args;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams r2, HttpParams r3) {
        this.local = (HttpParams) Args.notNull(r2, "Local HTTP parameters");
        this.defaults = r3;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public Object getParameter(String r2) {
        Object r0 = this.local.getParameter(r2);
        if (r0 != null) goto L8;
        HttpParams r1 = this.defaults;
        if (r1 != null) goto L7;
        return r0;
    L7:
        return r1.getParameter(r2);
    L8:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean removeParameter(String r1) {
        return this.local.removeParameter(r1);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setParameter(String r1, Object r2) {
        return this.local.setParameter(r1, r2);
    }

    public HttpParams getDefaults() {
        return this.defaults;
    }

    @Override // cz.msebera.android.httpclient.params.AbstractHttpParams, cz.msebera.android.httpclient.params.HttpParamsNames
    public Set<String> getNames() {
        HashSet r0 = new HashSet(getNames(this.defaults));
        r0.addAll(getNames(this.local));
        return r0;
    }

    public Set<String> getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    public Set<String> getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    private Set<String> getNames(HttpParams r1) {
        if ((r1 instanceof HttpParamsNames) == false) goto L7;
        return ((HttpParamsNames) r1).getNames();
    L7:
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }
}
