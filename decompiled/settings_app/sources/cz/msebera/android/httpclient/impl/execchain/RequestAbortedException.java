package cz.msebera.android.httpclient.impl.execchain;

import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes5.dex */
public class RequestAbortedException extends InterruptedIOException {
    private static final long serialVersionUID = 4973849966012490112L;

    public RequestAbortedException(String r1) {
        super(r1);
    }

    public RequestAbortedException(String r1, Throwable r2) {
        super(r1);
        if (r2 == null) goto L6;
        initCause(r2);
        return;
    }
}
