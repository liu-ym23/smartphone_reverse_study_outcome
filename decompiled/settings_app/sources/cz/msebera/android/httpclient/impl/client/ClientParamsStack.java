package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.params.AbstractHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ClientParamsStack extends AbstractHttpParams {
    protected final HttpParams applicationParams;
    protected final HttpParams clientParams;
    protected final HttpParams overrideParams;
    protected final HttpParams requestParams;

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams copy() {
        return this;
    }

    public ClientParamsStack(HttpParams r1, HttpParams r2, HttpParams r3, HttpParams r4) {
        this.applicationParams = r1;
        this.clientParams = r2;
        this.requestParams = r3;
        this.overrideParams = r4;
    }

    public ClientParamsStack(ClientParamsStack r4) {
        this(r4.getApplicationParams(), r4.getClientParams(), r4.getRequestParams(), r4.getOverrideParams());
    }

    public ClientParamsStack(ClientParamsStack r1, HttpParams r2, HttpParams r3, HttpParams r4, HttpParams r5) {
        if (r2 != null) goto L5;
        r2 = r1.getApplicationParams();
    L5:
        if (r3 != null) goto L8;
        r3 = r1.getClientParams();
    L8:
        if (r4 != null) goto L11;
        r4 = r1.getRequestParams();
    L11:
        if (r5 != null) goto L14;
        r5 = r1.getOverrideParams();
    L14:
        this(r2, r3, r4, r5);
    }

    public final HttpParams getApplicationParams() {
        return this.applicationParams;
    }

    public final HttpParams getClientParams() {
        return this.clientParams;
    }

    public final HttpParams getRequestParams() {
        return this.requestParams;
    }

    public final HttpParams getOverrideParams() {
        return this.overrideParams;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public Object getParameter(String r3) {
        Args.notNull(r3, "Parameter name");
        HttpParams r0 = this.overrideParams;
        if (r0 == null) goto L5;
        Object r1 = r0.getParameter(r3);
    L6:
        if (r1 != null) goto L10;
        HttpParams r2 = this.requestParams;
        if (r2 == null) goto L10;
        r1 = r2.getParameter(r3);
    L10:
        if (r1 != null) goto L14;
        HttpParams r4 = this.clientParams;
        if (r4 == null) goto L14;
        r1 = r4.getParameter(r3);
    L14:
        if (r1 != null) goto L19;
        HttpParams r5 = this.applicationParams;
        if (r5 != null) goto L18;
        return r1;
    L18:
        return r5.getParameter(r3);
    L19:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setParameter(String r1, Object r2) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean removeParameter(String r1) {
        throw new UnsupportedOperationException("Removing parameters in a stack is not supported.");
    }
}
