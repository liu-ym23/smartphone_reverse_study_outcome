package cz.msebera.android.httpclient.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class HttpStrictMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpStrictMultipart(Charset r1, String r2, List<FormBodyPart> r3) {
        super(r1, r2);
        this.parts = r3;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    protected void formatMultipartHeader(FormBodyPart r1, OutputStream r2) throws IOException {
        Iterator<MinimalField> r0 = r1.getHeader().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        writeField(r0.next(), r2);
        goto L4
    }
}
