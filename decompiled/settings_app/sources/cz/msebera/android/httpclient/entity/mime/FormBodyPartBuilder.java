package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class FormBodyPartBuilder {
    private ContentBody body;
    private final Header header;
    private String name;

    public static FormBodyPartBuilder create(String r1, ContentBody r2) {
        return new FormBodyPartBuilder(r1, r2);
    }

    public static FormBodyPartBuilder create() {
        return new FormBodyPartBuilder();
    }

    FormBodyPartBuilder(String r1, ContentBody r2) {
        this();
        this.name = r1;
        this.body = r2;
    }

    FormBodyPartBuilder() {
        this.header = new Header();
    }

    public FormBodyPartBuilder setName(String r1) {
        this.name = r1;
        return this;
    }

    public FormBodyPartBuilder setBody(ContentBody r1) {
        this.body = r1;
        return this;
    }

    public FormBodyPartBuilder addField(String r3, String r4) {
        Args.notNull(r3, "Field name");
        this.header.addField(new MinimalField(r3, r4));
        return this;
    }

    public FormBodyPartBuilder setField(String r3, String r4) {
        Args.notNull(r3, "Field name");
        this.header.setField(new MinimalField(r3, r4));
        return this;
    }

    public FormBodyPartBuilder removeFields(String r2) {
        Args.notNull(r2, "Field name");
        this.header.removeFields(r2);
        return this;
    }

    public FormBodyPart build() {
        Asserts.notBlank(this.name, "Name");
        Asserts.notNull(this.body, "Content body");
        Header r0 = new Header();
        Iterator<MinimalField> r1 = this.header.getFields().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.addField(r1.next());
        goto L4
    L7:
        if (r0.getField("Content-Disposition") != null) goto L13;
        StringBuilder r2 = new StringBuilder("form-data; name=\"");
        r2.append(encodeForHeader(this.name));
        r2.append("\"");
        if (this.body.getFilename() == null) goto L11;
        r2.append("; filename=\"");
        r2.append(encodeForHeader(this.body.getFilename()));
        r2.append("\"");
    L11:
        r0.addField(new MinimalField("Content-Disposition", r2.toString()));
    L13:
        if (r0.getField("Content-Type") != null) goto L25;
        ContentBody r3 = this.body;
        if ((r3 instanceof AbstractContentBody) == false) goto L17;
        ContentType r4 = ((AbstractContentBody) r3).getContentType();
    L18:
        if (r4 == null) goto L20;
        r0.addField(new MinimalField("Content-Type", r4.toString()));
        goto L25
    L20:
        StringBuilder r5 = new StringBuilder();
        r5.append(this.body.getMimeType());
        if (this.body.getCharset() == null) goto L23;
        r5.append("; charset=");
        r5.append(this.body.getCharset());
    L23:
        r0.addField(new MinimalField("Content-Type", r5.toString()));
        goto L25
    L17:
        r4 = null;
    L25:
        if (r0.getField(MIME.CONTENT_TRANSFER_ENC) != null) goto L28;
        r0.addField(new MinimalField(MIME.CONTENT_TRANSFER_ENC, this.body.getTransferEncoding()));
    L28:
        return new FormBodyPart(this.name, this.body, r0);
    }

    private static String encodeForHeader(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L7:
        if (r1 >= r4.length()) goto L17;
        char r2 = r4.charAt(r1);
        if (r2 != '\"') goto L11;
    L14:
        r0.append("\\");
    L15:
        r0.append(r2);
        r1 = r1 + 1;
        goto L7
    L11:
        if (r2 == '\\') goto L14;
        if (r2 != '\r') goto L15;
    L17:
        return r0.toString();
    }
}
