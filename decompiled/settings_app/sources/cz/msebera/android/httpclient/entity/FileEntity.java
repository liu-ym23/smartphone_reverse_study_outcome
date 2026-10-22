package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class FileEntity extends AbstractHttpEntity implements Cloneable {
    protected final File file;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Deprecated
    public FileEntity(File r2, String r3) {
        this.file = (File) Args.notNull(r2, "File");
        setContentType(r3);
    }

    public FileEntity(File r2, ContentType r3) {
        this.file = (File) Args.notNull(r2, "File");
        if (r3 == null) goto L6;
        setContentType(r3.toString());
        return;
    }

    public FileEntity(File r2) {
        this.file = (File) Args.notNull(r2, "File");
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.file.length();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r4) throws IOException {
        Args.notNull(r4, "Output stream");
        FileInputStream r0 = new FileInputStream(this.file);
        byte[] r3 = new byte[4096];     // Catch: Throwable -> L10
    L4:
        int r1 = r0.read(r3);     // Catch: Throwable -> L10
        if (r1 == (-1)) goto L7;
        r4.write(r3, 0, r1);     // Catch: Throwable -> L10
        goto L4
    L7:
        r4.flush();     // Catch: Throwable -> L10
        r0.close();
        return;
    L10:
        th = move-exception;
        r0.close();
        throw th;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
