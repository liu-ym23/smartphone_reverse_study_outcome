package cz.msebera.android.httpclient;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionClosedException extends IOException {
    private static final long serialVersionUID = 617550366255636674L;

    public ConnectionClosedException() {
        super("Connection is closed");
    }

    public ConnectionClosedException(String r1) {
        super(HttpException.clean(r1));
    }

    public ConnectionClosedException(String r1, Object... r2) {
        super(HttpException.clean(String.format(r1, r2)));
    }
}
