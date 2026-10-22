package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.BasicLineFormatter;
import cz.msebera.android.httpclient.message.LineFormatter;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestWriterFactory implements HttpMessageWriterFactory<HttpRequest> {
    public static final DefaultHttpRequestWriterFactory INSTANCE = null;
    private final LineFormatter lineFormatter;

    static {
        INSTANCE = new DefaultHttpRequestWriterFactory();
    }

    public DefaultHttpRequestWriterFactory(LineFormatter r1) {
        if (r1 != null) goto L6;
        r1 = BasicLineFormatter.INSTANCE;
    L6:
        this.lineFormatter = r1;
    }

    public DefaultHttpRequestWriterFactory() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.io.HttpMessageWriterFactory
    public HttpMessageWriter<HttpRequest> create(SessionOutputBuffer r2) {
        return new DefaultHttpRequestWriter(r2, this.lineFormatter);
    }
}
