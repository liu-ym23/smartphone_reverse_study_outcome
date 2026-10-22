package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public static final StrictContentLengthStrategy INSTANCE = null;
    private final int implicitLen;

    static {
        INSTANCE = new StrictContentLengthStrategy();
    }

    public StrictContentLengthStrategy(int r1) {
        this.implicitLen = r1;
    }

    public StrictContentLengthStrategy() {
        this(-1);
    }

    @Override // cz.msebera.android.httpclient.entity.ContentLengthStrategy
    public long determineLength(HttpMessage r6) throws HttpException {
        Args.notNull(r6, "HTTP message");
        Header r1 = r6.getFirstHeader("Transfer-Encoding");
        if (r1 == null) goto L18;
        String r5 = r1.getValue();
        if ("chunked".equalsIgnoreCase(r5) == false) goto L13;
        if (r6.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0) == true) goto L11;
        return -2;
    L11:
        throw new ProtocolException("Chunked transfer encoding not allowed for " + r6.getProtocolVersion());
    L13:
        if ("identity".equalsIgnoreCase(r5) == false) goto L17;
        return -1;
    L17:
        throw new ProtocolException("Unsupported transfer encoding: " + r5);
    L18:
        Header r7 = r6.getFirstHeader("Content-Length");
        if (r7 == null) goto L29;
        String r8 = r7.getValue();
        long r2 = Long.parseLong(r8);     // Catch: NumberFormatException -> L26
        if (r2 < 0) goto L25;
        return r2;
    L25:
        throw new ProtocolException("Negative content length: " + r8);     // Catch: NumberFormatException -> L26
    L27:
        throw new ProtocolException("Invalid content length: " + r8);
    L29:
        return this.implicitLen;
    }
}
