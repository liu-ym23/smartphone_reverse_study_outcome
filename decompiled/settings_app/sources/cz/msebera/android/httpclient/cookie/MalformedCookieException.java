package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.ProtocolException;

/* JADX INFO: loaded from: classes5.dex */
public class MalformedCookieException extends ProtocolException {
    private static final long serialVersionUID = -6695462944287282185L;

    public MalformedCookieException() {
    }

    public MalformedCookieException(String r1) {
        super(r1);
    }

    public MalformedCookieException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
