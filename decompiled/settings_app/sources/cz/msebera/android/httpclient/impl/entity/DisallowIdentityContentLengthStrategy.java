package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;

/* JADX INFO: loaded from: classes5.dex */
public class DisallowIdentityContentLengthStrategy implements ContentLengthStrategy {
    public static final DisallowIdentityContentLengthStrategy INSTANCE = null;
    private final ContentLengthStrategy contentLengthStrategy;

    static {
        INSTANCE = new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0));
    }

    public DisallowIdentityContentLengthStrategy(ContentLengthStrategy r1) {
        this.contentLengthStrategy = r1;
    }

    @Override // cz.msebera.android.httpclient.entity.ContentLengthStrategy
    public long determineLength(HttpMessage r3) throws HttpException {
        long r2 = this.contentLengthStrategy.determineLength(r3);
        if (r2 == (-1)) goto L6;
        return r2;
    L6:
        throw new ProtocolException("Identity transfer encoding cannot be used");
    }
}
