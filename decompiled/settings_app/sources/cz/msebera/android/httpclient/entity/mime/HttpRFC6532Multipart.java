package cz.msebera.android.httpclient.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class HttpRFC6532Multipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpRFC6532Multipart(Charset r1, String r2, List<FormBodyPart> r3) {
        super(r1, r2);
        this.parts = r3;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    protected void formatMultipartHeader(FormBodyPart r2, OutputStream r3) throws IOException {
        Iterator<MinimalField> r1 = r2.getHeader().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        writeField(r1.next(), MIME.UTF8_CHARSET, r3);
        goto L4
    }
}
