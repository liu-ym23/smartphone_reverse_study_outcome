package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedOutputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthOutputStream;
import cz.msebera.android.httpclient.impl.io.IdentityOutputStream;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class EntitySerializer {
    private final ContentLengthStrategy lenStrategy;

    public EntitySerializer(ContentLengthStrategy r2) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(r2, "Content length strategy");
    }

    protected OutputStream doSerialize(SessionOutputBuffer r5, HttpMessage r6) throws HttpException, IOException {
        long r0 = this.lenStrategy.determineLength(r6);
        if (r0 != (-2)) goto L7;
        return new ChunkedOutputStream(r5);
    L7:
        if (r0 != (-1)) goto L11;
        return new IdentityOutputStream(r5);
    L11:
        return new ContentLengthOutputStream(r5, r0);
    }

    public void serialize(SessionOutputBuffer r2, HttpMessage r3, HttpEntity r4) throws HttpException, IOException {
        Args.notNull(r2, "Session output buffer");
        Args.notNull(r3, "HTTP message");
        Args.notNull(r4, "HTTP entity");
        OutputStream r1 = doSerialize(r2, r3);
        r4.writeTo(r1);
        r1.close();
    }
}
