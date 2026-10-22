package cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes5.dex */
public class GZIPInputStreamFactory implements InputStreamFactory {
    private static final GZIPInputStreamFactory INSTANCE = null;

    public GZIPInputStreamFactory() {
    }

    static {
        INSTANCE = new GZIPInputStreamFactory();
    }

    public static GZIPInputStreamFactory getInstance() {
        return INSTANCE;
    }

    @Override // cz.msebera.android.httpclient.client.entity.InputStreamFactory
    public InputStream create(InputStream r1) throws IOException {
        return new GZIPInputStream(r1);
    }
}
