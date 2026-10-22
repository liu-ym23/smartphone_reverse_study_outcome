package cz.msebera.android.httpclient.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class HttpBrowserCompatibleMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpBrowserCompatibleMultipart(Charset r1, String r2, List<FormBodyPart> r3) {
        super(r1, r2);
        this.parts = r3;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    protected void formatMultipartHeader(FormBodyPart r4, OutputStream r5) throws IOException {
        Header r0 = r4.getHeader();
        writeField(r0.getField("Content-Disposition"), this.charset, r5);
        if (r4.getBody().getFilename() == null) goto L6;
        writeField(r0.getField("Content-Type"), this.charset, r5);
        return;
    }
}
