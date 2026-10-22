package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.ProtocolException;

/* JADX INFO: loaded from: classes5.dex */
public class NonRepeatableRequestException extends ProtocolException {
    private static final long serialVersionUID = 82685265288806048L;

    public NonRepeatableRequestException() {
    }

    public NonRepeatableRequestException(String r1) {
        super(r1);
    }

    public NonRepeatableRequestException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
