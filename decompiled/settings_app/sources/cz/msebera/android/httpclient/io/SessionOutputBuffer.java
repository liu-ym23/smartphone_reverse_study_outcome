package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionOutputBuffer {
    void flush() throws IOException;

    HttpTransportMetrics getMetrics();

    void write(int r1) throws IOException;

    void write(byte[] r1) throws IOException;

    void write(byte[] r1, int r2, int r3) throws IOException;

    void writeLine(CharArrayBuffer r1) throws IOException;

    void writeLine(String r1) throws IOException;
}
