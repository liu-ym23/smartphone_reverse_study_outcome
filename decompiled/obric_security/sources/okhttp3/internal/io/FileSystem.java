package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = null;

    Sink appendingSink(File r1) throws FileNotFoundException;

    void delete(File r1) throws IOException;

    void deleteContents(File r1) throws IOException;

    boolean exists(File r1);

    void rename(File r1, File r2) throws IOException;

    Sink sink(File r1) throws FileNotFoundException;

    long size(File r1);

    Source source(File r1) throws FileNotFoundException;

    static {
        SYSTEM = new AnonymousClass1();
    }
}
