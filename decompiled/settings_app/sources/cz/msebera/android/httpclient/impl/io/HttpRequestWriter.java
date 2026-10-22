package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpRequestWriter extends AbstractMessageWriter<HttpRequest> {
    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageWriter
    protected /* bridge */ /* synthetic */ void writeHeadLine(HttpMessage r1) throws IOException {
        writeHeadLine((HttpRequest) r1);
    }

    public HttpRequestWriter(SessionOutputBuffer r1, LineFormatter r2, HttpParams r3) {
        super(r1, r2, r3);
    }

    protected void writeHeadLine(HttpRequest r3) throws IOException {
        this.lineFormatter.formatRequestLine(this.lineBuf, r3.getRequestLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
