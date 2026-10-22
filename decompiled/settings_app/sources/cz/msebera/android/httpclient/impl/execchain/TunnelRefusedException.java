package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public class TunnelRefusedException extends HttpException {
    private static final long serialVersionUID = -8646722842745617323L;
    private final HttpResponse response;

    public TunnelRefusedException(String r1, HttpResponse r2) {
        super(r1);
        this.response = r2;
    }

    public HttpResponse getResponse() {
        return this.response;
    }
}
