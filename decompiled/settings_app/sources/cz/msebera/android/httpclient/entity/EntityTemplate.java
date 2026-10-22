package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class EntityTemplate extends AbstractHttpEntity {
    private final ContentProducer contentproducer;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return -1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    public EntityTemplate(ContentProducer r2) {
        this.contentproducer = (ContentProducer) Args.notNull(r2, "Content producer");
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        writeTo(r0);
        return new ByteArrayInputStream(r0.toByteArray());
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r2) throws IOException {
        Args.notNull(r2, "Output stream");
        this.contentproducer.writeTo(r2);
    }
}
