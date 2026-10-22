package cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class DeflateInputStreamFactory implements InputStreamFactory {
    private static final DeflateInputStreamFactory INSTANCE = null;

    public DeflateInputStreamFactory() {
    }

    static {
        INSTANCE = new DeflateInputStreamFactory();
    }

    public static DeflateInputStreamFactory getInstance() {
        return INSTANCE;
    }

    @Override // cz.msebera.android.httpclient.client.entity.InputStreamFactory
    public InputStream create(InputStream r1) throws IOException {
        return new DeflateInputStream(r1);
    }
}
