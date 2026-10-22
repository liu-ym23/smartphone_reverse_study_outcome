package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.ProtocolException;

/* JADX INFO: loaded from: classes5.dex */
public class RedirectException extends ProtocolException {
    private static final long serialVersionUID = 4418824536372559326L;

    public RedirectException() {
    }

    public RedirectException(String r1) {
        super(r1);
    }

    public RedirectException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
