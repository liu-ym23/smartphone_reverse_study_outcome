package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.InputLimit;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class HeapResourceFactory implements ResourceFactory {
    public HeapResourceFactory() {
    }

    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource generate(String r6, InputStream r7, InputLimit r8) throws IOException {
        ByteArrayOutputStream r9 = new ByteArrayOutputStream();
        byte[] r0 = new byte[2048];
        long r1 = 0;
    L3:
        int r3 = r7.read(r0);
        if (r3 == (-1)) goto L11;
        r9.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        if (r8 == null) goto L3;
        if (r1 <= r8.getValue()) goto L3;
        r8.reached();
    L11:
        return createResource(r9.toByteArray());
    }

    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource copy(String r1, Resource r2) throws IOException {
        if ((r2 instanceof HeapResource) == false) goto L5;
        byte[] r3 = ((HeapResource) r2).getByteArray();
    L7:
        return createResource(r3);
    L5:
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();
        IOUtils.copyAndClose(r2.getInputStream(), r4);
        r3 = r4.toByteArray();
        goto L7
    }

    Resource createResource(byte[] r1) {
        return new HeapResource(r1);
    }
}
