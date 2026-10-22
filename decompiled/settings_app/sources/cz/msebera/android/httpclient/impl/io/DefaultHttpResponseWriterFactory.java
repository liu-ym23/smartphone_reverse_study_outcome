package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.BasicLineFormatter;
import cz.msebera.android.httpclient.message.LineFormatter;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory<HttpResponse> {
    public static final DefaultHttpResponseWriterFactory INSTANCE = null;
    private final LineFormatter lineFormatter;

    static {
        INSTANCE = new DefaultHttpResponseWriterFactory();
    }

    public DefaultHttpResponseWriterFactory(LineFormatter r1) {
        if (r1 != null) goto L6;
        r1 = BasicLineFormatter.INSTANCE;
    L6:
        this.lineFormatter = r1;
    }

    public DefaultHttpResponseWriterFactory() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.io.HttpMessageWriterFactory
    public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer r2) {
        return new DefaultHttpResponseWriter(r2, this.lineFormatter);
    }
}
