package cz.msebera.android.httpclient.entity.mime.content;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractContentBody implements ContentBody {
    private final ContentType contentType;

    public AbstractContentBody(ContentType r2) {
        Args.notNull(r2, "Content type");
        this.contentType = r2;
    }

    @Deprecated
    public AbstractContentBody(String r1) {
        this(ContentType.parse(r1));
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getMimeType() {
        return this.contentType.getMimeType();
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getMediaType() {
        String r2 = this.contentType.getMimeType();
        int r0 = r2.indexOf(47);
        if (r0 != (-1)) goto L5;
        return r2;
    L5:
        return r2.substring(0, r0);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getSubType() {
        String r2 = this.contentType.getMimeType();
        int r0 = r2.indexOf(47);
        if (r0 != (-1)) goto L5;
        return null;
    L5:
        return r2.substring(r0 + 1);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getCharset() {
        Charset r0 = this.contentType.getCharset();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.name();
    }
}
