package okhttp3.internal.io;

import com.bytedance.apm.constant.PerfConsts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: FileSystem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/io/FileSystem;", "", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "rename", "from", "to", "sink", PerfConsts.PERF_DISK_FILE_SIZE, "", "source", "Lokio/Source;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FileSystem {
    public static final Companion Companion = null;
    public static final FileSystem SYSTEM = null;

    /* JADX INFO: compiled from: FileSystem.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion;", "", "()V", "SYSTEM", "Lokhttp3/internal/io/FileSystem;", "SystemFileSystem", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        /* JADX INFO: compiled from: FileSystem.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion$SystemFileSystem;", "Lokhttp3/internal/io/FileSystem;", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "rename", "from", "to", "sink", PerfConsts.PERF_DISK_FILE_SIZE, "", "source", "Lokio/Source;", "toString", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
        private static final class SystemFileSystem implements FileSystem {
            public String toString() {
                return "FileSystem.SYSTEM";
            }

            public SystemFileSystem() {
            }

            @Override // okhttp3.internal.io.FileSystem
            public Source source(File r1) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r1, "file");
                return Okio.source(r1);
            }

            @Override // okhttp3.internal.io.FileSystem
            public Sink sink(File r4) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r4, "file");
                return Okio.sink$default(r4, false, 1, null);
            L5:
                r4.getParentFile().mkdirs();
                return Okio.sink$default(r4, false, 1, null);
            }

            @Override // okhttp3.internal.io.FileSystem
            public Sink appendingSink(File r1) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(r1, "file");
                return Okio.appendingSink(r1);
            L5:
                r1.getParentFile().mkdirs();
                return Okio.appendingSink(r1);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(File r2) throws IOException {
                Intrinsics.checkNotNullParameter(r2, "file");
                if (r2.delete() == false) goto L5;
                return;
            L5:
                if (r2.exists() == true) goto L8;
                return;
            L8:
                throw new IOException(Intrinsics.stringPlus("failed to delete ", r2));
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(File r1) {
                Intrinsics.checkNotNullParameter(r1, "file");
                return r1.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(File r1) {
                Intrinsics.checkNotNullParameter(r1, "file");
                return r1.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(File r3, File r4) throws IOException {
                Intrinsics.checkNotNullParameter(r3, "from");
                Intrinsics.checkNotNullParameter(r4, "to");
                delete(r4);
                if (r3.renameTo(r4) == false) goto L6;
                return;
            L6:
                throw new IOException("failed to rename " + r3 + " to " + r4);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(File r5) throws IOException {
                Intrinsics.checkNotNullParameter(r5, "directory");
                File[] r0 = r5.listFiles();
                if (r0 == null) goto L16;
                int r6 = r0.length;
                int r1 = 0;
            L5:
                if (r1 >= r6) goto L14;
                File r2 = r0[r1];
                r1 = r1 + 1;
                if (r2.isDirectory() == false) goto L10;
                Intrinsics.checkNotNullExpressionValue(r2, "file");
                deleteContents(r2);
            L10:
                if (r2.delete() == true) goto L5;
                throw new IOException(Intrinsics.stringPlus("failed to delete ", r2));
            L14:
                return;
            L16:
                throw new IOException(Intrinsics.stringPlus("not a readable directory: ", r5));
            }
        }

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    Sink appendingSink(File r1) throws FileNotFoundException;

    void delete(File r1) throws IOException;

    void deleteContents(File r1) throws IOException;

    boolean exists(File r1);

    void rename(File r1, File r2) throws IOException;

    Sink sink(File r1) throws FileNotFoundException;

    long size(File r1);

    Source source(File r1) throws FileNotFoundException;

    static {
        Companion = Companion.$$INSTANCE;
        SYSTEM = new Companion.SystemFileSystem();
    }
}
