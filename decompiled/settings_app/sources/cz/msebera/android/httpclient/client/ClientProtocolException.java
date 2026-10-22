package cz.msebera.android.httpclient.client;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ClientProtocolException extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String r1) {
        super(r1);
    }

    public ClientProtocolException(Throwable r1) {
        initCause(r1);
    }

    public ClientProtocolException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }
}
