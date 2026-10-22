package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedInputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthInputStream;
import cz.msebera.android.httpclient.impl.io.IdentityInputStream;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class EntityDeserializer {
    private final ContentLengthStrategy lenStrategy;

    public EntityDeserializer(ContentLengthStrategy r2) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(r2, "Content length strategy");
    }

    protected BasicHttpEntity doDeserialize(SessionInputBuffer r7, HttpMessage r8) throws HttpException, IOException {
        BasicHttpEntity r0 = new BasicHttpEntity();
        long r1 = this.lenStrategy.determineLength(r8);
        if (r1 != (-2)) goto L6;
        r0.setChunked(true);
        r0.setContentLength(-1);
        r0.setContent(new ChunkedInputStream(r7));
    L9:
        Header r6 = r8.getFirstHeader("Content-Type");
        if (r6 == null) goto L12;
        r0.setContentType(r6);
    L12:
        Header r9 = r8.getFirstHeader("Content-Encoding");
        if (r9 == null) goto L15;
        r0.setContentEncoding(r9);
    L15:
        return r0;
    L6:
        if (r1 != (-1)) goto L8;
        r0.setChunked(false);
        r0.setContentLength(-1);
        r0.setContent(new IdentityInputStream(r7));
        goto L9
    L8:
        r0.setChunked(false);
        r0.setContentLength(r1);
        r0.setContent(new ContentLengthInputStream(r7, r1));
        goto L9
    }

    public HttpEntity deserialize(SessionInputBuffer r2, HttpMessage r3) throws HttpException, IOException {
        Args.notNull(r2, "Session input buffer");
        Args.notNull(r3, "HTTP message");
        return doDeserialize(r2, r3);
    }
}
