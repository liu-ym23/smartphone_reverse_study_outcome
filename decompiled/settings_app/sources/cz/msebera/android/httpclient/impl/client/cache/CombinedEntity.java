package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.util.Args;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/* JADX INFO: loaded from: classes5.dex */
class CombinedEntity extends AbstractHttpEntity {
    private final InputStream combinedStream;
    private final Resource resource;

    class ResourceStream extends FilterInputStream {
        final /* synthetic */ CombinedEntity this$0;

        protected ResourceStream(CombinedEntity r1, InputStream r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();     // Catch: Throwable -> L5
            CombinedEntity.access$000(this.this$0);
            return;
        L5:
            th = move-exception;
            CombinedEntity.access$000(this.this$0);
            throw th;
        }
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return -1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    static /* synthetic */ void access$000(CombinedEntity r0) {
        r0.dispose();
    }

    CombinedEntity(Resource r3, InputStream r4) throws IOException {
        this.resource = r3;
        this.combinedStream = new SequenceInputStream(new ResourceStream(this, r3.getInputStream()), r4);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException, IllegalStateException {
        return this.combinedStream;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r4) throws IOException {
        Args.notNull(r4, "Output stream");
        InputStream r3 = getContent();
        byte[] r0 = new byte[2048];     // Catch: Throwable -> L10
    L4:
        int r1 = r3.read(r0);     // Catch: Throwable -> L10
        if (r1 == (-1)) goto L8;
        r4.write(r0, 0, r1);     // Catch: Throwable -> L10
        goto L4
    L8:
        r3.close();
        return;
    L10:
        th = move-exception;
        r3.close();
        throw th;
    }

    private void dispose() {
        this.resource.dispose();
    }
}
