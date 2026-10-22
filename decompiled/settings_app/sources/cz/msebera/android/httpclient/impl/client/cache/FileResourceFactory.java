package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.InputLimit;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class FileResourceFactory implements ResourceFactory {
    private final File cacheDir;
    private final BasicIdGenerator idgen;

    public FileResourceFactory(File r1) {
        this.cacheDir = r1;
        this.idgen = new BasicIdGenerator();
    }

    private File generateUniqueCacheFile(String r7) {
        StringBuilder r0 = new StringBuilder();
        this.idgen.generate(r0);
        r0.append('.');
        int r2 = Math.min(r7.length(), 100);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        char r4 = r7.charAt(r3);
        if (Character.isLetterOrDigit(r4) == true) goto L9;
        if (r4 == '.') goto L9;
        r0.append('-');
    L10:
        r3 = r3 + 1;
    L9:
        r0.append(r4);
        goto L10
    L12:
        return new File(this.cacheDir, r0.toString());
    }

    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource generate(String r6, InputStream r7, InputLimit r8) throws IOException {
        File r5 = generateUniqueCacheFile(r6);
        FileOutputStream r9 = new FileOutputStream(r5);
        byte[] r0 = new byte[2048];     // Catch: Throwable -> L13
        long r1 = 0;
    L4:
        int r3 = r7.read(r0);     // Catch: Throwable -> L13
        if (r3 == (-1)) goto L11;
        r9.write(r0, 0, r3);     // Catch: Throwable -> L13
        r1 = r1 + ((long) r3);     // Catch: Throwable -> L13
        if (r8 == null) goto L4;
        if (r1 <= r8.getValue()) goto L4;
        r8.reached();     // Catch: Throwable -> L13
    L11:
        r9.close();
        return new FileResource(r5);
    L13:
        th = move-exception;
        r9.close();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource copy(String r1, Resource r2) throws IOException {
        File r0 = generateUniqueCacheFile(r1);
        if ((r2 instanceof FileResource) == false) goto L5;
        IOUtils.copyFile(((FileResource) r2).getFile(), r0);
    L7:
        return new FileResource(r0);
    L5:
        FileOutputStream r3 = new FileOutputStream(r0);
        IOUtils.copyAndClose(r2.getInputStream(), r3);
        goto L7
    }
}
