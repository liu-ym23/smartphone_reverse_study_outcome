package javax.obex;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface BaseStream {
    boolean continueOperation(boolean r1, boolean r2) throws IOException;

    void ensureNotDone() throws IOException;

    void ensureOpen() throws IOException;

    void streamClosed(boolean r1) throws IOException;
}
