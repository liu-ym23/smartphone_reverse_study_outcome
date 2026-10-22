package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineFormatter;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseWriter extends AbstractMessageWriter<HttpResponse> {
    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageWriter
    protected /* bridge */ /* synthetic */ void writeHeadLine(HttpMessage r1) throws IOException {
        writeHeadLine((HttpResponse) r1);
    }

    public DefaultHttpResponseWriter(SessionOutputBuffer r1, LineFormatter r2) {
        super(r1, r2);
    }

    public DefaultHttpResponseWriter(SessionOutputBuffer r2) {
        super(r2, null);
    }

    protected void writeHeadLine(HttpResponse r3) throws IOException {
        this.lineFormatter.formatStatusLine(this.lineBuf, r3.getStatusLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
