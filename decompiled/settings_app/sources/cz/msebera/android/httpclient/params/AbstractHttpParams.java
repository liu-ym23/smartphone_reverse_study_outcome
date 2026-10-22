package cz.msebera.android.httpclient.params;

import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {
    protected AbstractHttpParams() {
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public long getLongParameter(String r1, long r2) {
        Object r0 = getParameter(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        return ((Long) r0).longValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setLongParameter(String r1, long r2) {
        setParameter(r1, Long.valueOf(r2));
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public int getIntParameter(String r1, int r2) {
        Object r0 = getParameter(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        return ((Integer) r0).intValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setIntParameter(String r1, int r2) {
        setParameter(r1, Integer.valueOf(r2));
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public double getDoubleParameter(String r1, double r2) {
        Object r0 = getParameter(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        return ((Double) r0).doubleValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setDoubleParameter(String r1, double r2) {
        setParameter(r1, Double.valueOf(r2));
        return this;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean getBooleanParameter(String r1, boolean r2) {
        Object r0 = getParameter(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        return ((Boolean) r0).booleanValue();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setBooleanParameter(String r1, boolean r2) {
        if (r2 == false) goto L4;
        Boolean r3 = Boolean.TRUE;
    L5:
        setParameter(r1, r3);
        return this;
    L4:
        r3 = Boolean.FALSE;
        goto L5
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean isParameterTrue(String r2) {
        return getBooleanParameter(r2, false);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean isParameterFalse(String r2) {
        return !getBooleanParameter(r2, false);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParamsNames
    public Set<String> getNames() {
        throw new UnsupportedOperationException();
    }
}
