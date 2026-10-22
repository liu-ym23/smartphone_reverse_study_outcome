package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class LaxContentLengthStrategy implements ContentLengthStrategy {
    public static final LaxContentLengthStrategy INSTANCE = null;
    private final int implicitLen;

    static {
        INSTANCE = new LaxContentLengthStrategy();
    }

    public LaxContentLengthStrategy(int r1) {
        this.implicitLen = r1;
    }

    public LaxContentLengthStrategy() {
        this(-1);
    }

    @Override // cz.msebera.android.httpclient.entity.ContentLengthStrategy
    public long determineLength(HttpMessage r6) throws HttpException {
        Args.notNull(r6, "HTTP message");
        Header r0 = r6.getFirstHeader("Transfer-Encoding");
        if (r0 == null) goto L18;
        HeaderElement[] r5 = r0.getElements();     // Catch: ParseException -> L14
        int r7 = r5.length;
        if ("identity".equalsIgnoreCase(r0.getValue()) == false) goto L8;
        return -1;
    L8:
        if (r7 > 0) goto L10;
    L13:
        return -1;
    L10:
        if ("chunked".equalsIgnoreCase(r5[r7 - 1].getName()) == false) goto L13;
        return -2;
    L14:
        e = move-exception;
        throw new ProtocolException("Invalid Transfer-Encoding header value: " + r0, e);
    L18:
        if (r6.getFirstHeader("Content-Length") == null) goto L31;
        Header[] r8 = r6.getHeaders("Content-Length");
        int r9 = r8.length - 1;
    L20:
        if (r9 < 0) goto L25;
        long r10 = Long.parseLong(r8[r9].getValue());     // Catch: NumberFormatException -> L24
    L27:
        if (r10 >= 0) goto L29;
        return -1;
    L29:
        return r10;
    L24:
        r9 = r9 - 1;
        goto L20
    L25:
        r10 = -1;
        goto L27
    L31:
        return this.implicitLen;
    }
}
