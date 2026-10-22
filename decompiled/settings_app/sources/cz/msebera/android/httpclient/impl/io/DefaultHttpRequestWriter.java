package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineFormatter;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestWriter extends AbstractMessageWriter<HttpRequest> {
    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageWriter
    protected /* bridge */ /* synthetic */ void writeHeadLine(HttpMessage r1) throws IOException {
        writeHeadLine((HttpRequest) r1);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer r1, LineFormatter r2) {
        super(r1, r2);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer r2) {
        this(r2, null);
    }

    protected void writeHeadLine(HttpRequest r3) throws IOException {
        this.lineFormatter.formatRequestLine(this.lineBuf, r3.getRequestLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
