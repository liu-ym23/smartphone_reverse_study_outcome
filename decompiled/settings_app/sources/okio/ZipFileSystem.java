package okio;

import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipKt;

/* JADX INFO: compiled from: ZipFileSystem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u0003H\u0016J \u0010$\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "entries", "", "Lokio/internal/ZipEntry;", ClientCookie.COMMENT_ATTR, "", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "appendingSink", "Lokio/Sink;", "file", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = null;

    @Deprecated
    private static final Path ROOT = null;
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    /* JADX INFO: compiled from: ZipFileSystem.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokio/ZipFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Path getROOT() {
            return ZipFileSystem.access$getROOT$cp();
        }
    }

    public static final /* synthetic */ Path access$getROOT$cp() {
        return ROOT;
    }

    public ZipFileSystem(Path r2, FileSystem r3, Map<Path, ZipEntry> r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "zipPath");
        Intrinsics.checkNotNullParameter(r3, "fileSystem");
        Intrinsics.checkNotNullParameter(r4, "entries");
        this.zipPath = r2;
        this.fileSystem = r3;
        this.entries = r4;
        this.comment = r5;
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Path r0 = canonicalizeInternal(r2);
        if (this.entries.containsKey(r0) == false) goto L6;
        return r0;
    L6:
        throw new FileNotFoundException(String.valueOf(r2));
    }

    private final Path canonicalizeInternal(Path r2) {
        return ROOT.resolve(r2, true);
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path r15) {
        Intrinsics.checkNotNullParameter(r15, "path");
        ZipEntry r16 = this.entries.get(canonicalizeInternal(r15));
        Throwable th = null;
        if (r16 != null) goto L5;
        return null;
    L5:
        boolean r2 = !r16.isDirectory();
        boolean r3 = r16.isDirectory();
        if (r16.isDirectory() == false) goto L8;
        Long r5 = null;
    L9:
        FileMetadata r12 = new FileMetadata(r2, r3, null, r5, null, r16.getLastModifiedAtMillis(), null, null, 128, null);
        if (r16.getOffset() != (-1)) goto L12;
        return r12;
    L12:
        FileHandle r14 = this.fileSystem.openReadOnly(this.zipPath);
        BufferedSource r17 = Okio.buffer(r14.source(r16.getOffset()));     // Catch: Throwable -> L19
        if (r14 != null) goto L32;
    L26:
        if (th != null) goto L29;
        Intrinsics.checkNotNull(r17);
        return ZipKt.readLocalHeader(r17, r12);
    L29:
        throw th;
    L32:
        r14.close();     // Catch: Throwable -> L17
    L17:
        th = th;
    L19:
        th = move-exception;
        if (r14 != null) goto L30;
    L25:
        th = th;
        r17 = null;
        goto L26
    L30:
        r14.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L25
    L8:
        r5 = Long.valueOf(r16.getSize());
        goto L9
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    public List<Path> list(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        List<Path> r1 = list(r2, true);
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        return list(r2, false);
    }

    private final List<Path> list(Path r2, boolean r3) {
        ZipEntry r1 = this.entries.get(canonicalizeInternal(r2));
        if (r1 != null) goto L10;
        if (r3 == true) goto L8;
        return null;
    L8:
        throw new IOException("not a directory: " + r2);
    L10:
        return CollectionsKt.toList(r1.getChildren());
    }

    @Override // okio.FileSystem
    public Source source(Path r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "file");
        ZipEntry r0 = this.entries.get(canonicalizeInternal(r7));
        if (r0 == null) goto L26;
        FileHandle r6 = this.fileSystem.openReadOnly(this.zipPath);
        Throwable th = null;
        BufferedSource r1 = Okio.buffer(r6.source(r0.getOffset()));     // Catch: Throwable -> L11
        if (r6 != null) goto L27;
    L18:
        if (th != null) goto L24;
        Intrinsics.checkNotNull(r1);
        ZipKt.skipLocalHeader(r1);
        if (r0.getCompressionMethod() != 0) goto L23;
        return new FixedLengthSource(r1, r0.getSize(), true);
    L23:
        return new FixedLengthSource(new InflaterSource(new FixedLengthSource(r1, r0.getCompressedSize(), true), new Inflater(true)), r0.getSize(), false);
    L24:
        throw th;
    L27:
        r6.close();     // Catch: Throwable -> L9
    L9:
        th = th;
    L11:
        th = move-exception;
        if (r6 != null) goto L31;
    L17:
        r1 = null;
        th = th;
        goto L18
    L31:
        r6.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L17
    L26:
        throw new FileNotFoundException("no such file: " + r7);
    }

    @Override // okio.FileSystem
    public Sink sink(Path r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path r1, Path r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r2, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path r1, Path r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r2, "target");
        throw new IOException("zip file systems are read-only");
    }

    static {
        Companion = new Companion(null);
        ROOT = Path.Companion.get$default(Path.Companion, LibrarianImpl.Constants.SEPARATOR, false, 1, null);
    }
}
