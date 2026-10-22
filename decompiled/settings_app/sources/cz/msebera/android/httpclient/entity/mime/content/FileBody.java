package cz.msebera.android.httpclient.entity.mime.content;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class FileBody extends AbstractContentBody {
    private final File file;
    private final String filename;

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Deprecated
    public FileBody(File r1, String r2, String r3, String r4) {
        this(r1, ContentType.create(r3, r4), r2);
    }

    @Deprecated
    public FileBody(File r2, String r3, String r4) {
        this(r2, null, r3, r4);
    }

    @Deprecated
    public FileBody(File r2, String r3) {
        this(r2, ContentType.create(r3), null);
    }

    public FileBody(File r3) {
        ContentType r0 = ContentType.DEFAULT_BINARY;
        if (r3 == null) goto L5;
        String r1 = r3.getName();
    L6:
        this(r3, r0, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public FileBody(File r1, ContentType r2, String r3) {
        super(r2);
        Args.notNull(r1, "File");
        this.file = r1;
        if (r3 != null) goto L5;
        r3 = r1.getName();
    L5:
        this.filename = r3;
    }

    public FileBody(File r2, ContentType r3) {
        if (r2 == null) goto L4;
        String r0 = r2.getName();
    L5:
        this(r2, r3, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
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

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.file.length();
    }

    @Override // cz.msebera.android.httpclient.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public File getFile() {
        return this.file;
    }
}
