package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionInputBuffer {
    HttpTransportMetrics getMetrics();

    @Deprecated
    boolean isDataAvailable(int r1) throws IOException;

    int read() throws IOException;

    int read(byte[] r1) throws IOException;

    int read(byte[] r1, int r2, int r3) throws IOException;

    int readLine(CharArrayBuffer r1) throws IOException;

    String readLine() throws IOException;
}
