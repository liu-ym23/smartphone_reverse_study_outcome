package cz.msebera.android.httpclient.conn;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface EofSensorWatcher {
    boolean eofDetected(InputStream r1) throws IOException;

    boolean streamAbort(InputStream r1) throws IOException;

    boolean streamClosed(InputStream r1) throws IOException;
}
