package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.BasicLineFormatter;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageWriter<T extends HttpMessage> implements HttpMessageWriter<T> {
    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    protected abstract void writeHeadLine(T r1) throws IOException;

    @Deprecated
    public AbstractMessageWriter(SessionOutputBuffer r1, LineFormatter r2, HttpParams r3) {
        Args.notNull(r1, "Session input buffer");
        this.sessionBuffer = r1;
        this.lineBuf = new CharArrayBuffer(128);
        if (r2 != null) goto L6;
        r2 = BasicLineFormatter.INSTANCE;
    L6:
        this.lineFormatter = r2;
    }

    public AbstractMessageWriter(SessionOutputBuffer r2, LineFormatter r3) {
        this.sessionBuffer = (SessionOutputBuffer) Args.notNull(r2, "Session input buffer");
        if (r3 != null) goto L6;
        r3 = BasicLineFormatter.INSTANCE;
    L6:
        this.lineFormatter = r3;
        this.lineBuf = new CharArrayBuffer(128);
    }

    @Override // cz.msebera.android.httpclient.io.HttpMessageWriter
    public void write(T r5) throws IOException, HttpException {
        Args.notNull(r5, "HTTP message");
        writeHeadLine(r5);
        HeaderIterator r6 = r5.headerIterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Header r0 = r6.nextHeader();
        this.sessionBuffer.writeLine(this.lineFormatter.formatHeader(this.lineBuf, r0));
        goto L4
    L6:
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
