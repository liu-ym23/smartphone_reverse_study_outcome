package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpVersion extends ProtocolVersion {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9 = null;
    public static final HttpVersion HTTP_1_0 = null;
    public static final HttpVersion HTTP_1_1 = null;
    private static final long serialVersionUID = -5856653513894415344L;

    static {
        HTTP_0_9 = new HttpVersion(0, 9);
        HTTP_1_0 = new HttpVersion(1, 0);
        HTTP_1_1 = new HttpVersion(1, 1);
    }

    public HttpVersion(int r2, int r3) {
        super(HTTP, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.ProtocolVersion
    public ProtocolVersion forVersion(int r2, int r3) {
        if (r2 != this.major) goto L8;
        if (r3 != this.minor) goto L8;
        return this;
    L8:
        if (r2 != 1) goto L15;
        if (r3 == 0) goto L11;
        if (r3 != 1) goto L15;
        return HTTP_1_1;
    L11:
        return HTTP_1_0;
    L15:
        if (r2 != 0) goto L21;
        if (r3 != 9) goto L21;
        return HTTP_0_9;
    L21:
        return new HttpVersion(r2, r3);
    }
}
