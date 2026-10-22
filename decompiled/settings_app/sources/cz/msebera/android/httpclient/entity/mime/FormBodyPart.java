package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    FormBodyPart(String r2, ContentBody r3, Header r4) {
        Args.notNull(r2, "Name");
        Args.notNull(r3, "Body");
        this.name = r2;
        this.body = r3;
        if (r4 != null) goto L6;
        r4 = new Header();
    L6:
        this.header = r4;
    }

    @Deprecated
    public FormBodyPart(String r2, ContentBody r3) {
        Args.notNull(r2, "Name");
        Args.notNull(r3, "Body");
        this.name = r2;
        this.body = r3;
        this.header = new Header();
        generateContentDisp(r3);
        generateContentType(r3);
        generateTransferEncoding(r3);
    }

    public String getName() {
        return this.name;
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public void addField(String r2, String r3) {
        Args.notNull(r2, "Field name");
        this.header.addField(new MinimalField(r2, r3));
    }

    @Deprecated
    protected void generateContentDisp(ContentBody r4) {
        StringBuilder r0 = new StringBuilder("form-data; name=\"");
        r0.append(getName());
        r0.append("\"");
        if (r4.getFilename() == null) goto L5;
        r0.append("; filename=\"");
        r0.append(r4.getFilename());
        r0.append("\"");
    L5:
        addField("Content-Disposition", r0.toString());
    }

    @Deprecated
    protected void generateContentType(ContentBody r4) {
        if ((r4 instanceof AbstractContentBody) == false) goto L5;
        ContentType r0 = ((AbstractContentBody) r4).getContentType();
    L7:
        if (r0 == null) goto L9;
        addField("Content-Type", r0.toString());
        return;
    L9:
        StringBuilder r1 = new StringBuilder();
        r1.append(r4.getMimeType());
        if (r4.getCharset() == null) goto L12;
        r1.append("; charset=");
        r1.append(r4.getCharset());
    L12:
        addField("Content-Type", r1.toString());
        return;
    L5:
        r0 = null;
        goto L7
    }

    @Deprecated
    protected void generateTransferEncoding(ContentBody r2) {
        addField(MIME.CONTENT_TRANSFER_ENC, r2.getTransferEncoding());
    }
}
