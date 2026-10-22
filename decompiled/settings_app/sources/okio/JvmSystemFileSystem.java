package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JvmSystemFileSystem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\f\u0010!\u001a\u00020\n*\u00020\u0006H\u0002J\f\u0010\"\u001a\u00020\n*\u00020\u0006H\u0002¨\u0006#"}, d2 = {"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "", "requireCreate", "requireExist", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class JvmSystemFileSystem extends FileSystem {
    public String toString() {
        return "JvmSystemFileSystem";
    }

    public JvmSystemFileSystem() {
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        File r3 = r4.toFile().getCanonicalFile();
        if (r3.exists() == false) goto L7;
        Path.Companion r5 = Path.Companion;
        Intrinsics.checkNotNullExpressionValue(r3, "canonicalFile");
        return Path.Companion.get$default(r5, r3, false, 1, null);
    L7:
        throw new FileNotFoundException("no such file");
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path r13) {
        Intrinsics.checkNotNullParameter(r13, "path");
        File r12 = r13.toFile();
        boolean r1 = r12.isFile();
        boolean r2 = r12.isDirectory();
        long r3 = r12.lastModified();
        long r5 = r12.length();
        if (r1 == true) goto L14;
        if (r2 == true) goto L14;
        if (r3 != 0) goto L14;
        if (r5 != 0) goto L14;
        if (r12.exists() == true) goto L14;
        return null;
    L14:
        return new FileMetadata(r1, r2, null, Long.valueOf(r5), null, Long.valueOf(r3), null, null, 128, null);
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

    private final List<Path> list(Path r5, boolean r6) {
        File r4 = r5.toFile();
        String[] r0 = r4.list();
        if (r0 != null) goto L13;
        if (r6 == true) goto L6;
        return null;
    L6:
        if (r4.exists() == true) goto L10;
        throw new FileNotFoundException("no such file: " + r5);
    L10:
        throw new IOException("failed to list " + r5);
    L13:
        ArrayList r7 = new ArrayList();
        int r8 = r0.length;
        int r1 = 0;
    L14:
        if (r1 >= r8) goto L16;
        String r2 = r0[r1];
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r7.add(r5.resolve(r2));
        r1 = r1 + 1;
        goto L14
    L16:
        ArrayList r9 = r7;
        CollectionsKt.sort(r9);
        return r9;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path r3) {
        Intrinsics.checkNotNullParameter(r3, "file");
        return new JvmFileHandle(false, new RandomAccessFile(r3.toFile(), "r"));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "file");
        if (r4 == false) goto L7;
        if (r5 == false) goto L7;
        boolean r1 = false;
    L8:
        if (r1 == false) goto L16;
        if (r4 == false) goto L11;
        requireCreate(r3);
    L11:
        if (r5 == false) goto L14;
        requireExist(r3);
    L14:
        return new JvmFileHandle(true, new RandomAccessFile(r3.toFile(), "rw"));
    L16:
        throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
    L7:
        r1 = true;
        goto L8
    }

    @Override // okio.FileSystem
    public Source source(Path r1) {
        Intrinsics.checkNotNullParameter(r1, "file");
        return Okio.source(r1.toFile());
    }

    @Override // okio.FileSystem
    public Sink sink(Path r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "file");
        if (r3 == false) goto L6;
        requireCreate(r2);
    L6:
        return Okio.sink$default(r2.toFile(), false, 1, null);
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "file");
        if (r3 == false) goto L6;
        requireExist(r2);
    L6:
        return Okio.sink(r2.toFile(), true);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "dir");
        if (r3.toFile().mkdir() == true) goto L16;
        FileMetadata r2 = metadataOrNull(r3);
        boolean r0 = false;
        if (r2 != null) goto L7;
    L9:
        if (r0 == false) goto L15;
        if (r4 == true) goto L13;
        return;
    L13:
        throw new IOException(r3 + " already exist.");
    L15:
        throw new IOException("failed to create directory: " + r3);
    L7:
        if (r2.isDirectory() != true) goto L9;
        r0 = true;
        goto L9
    }

    @Override // okio.FileSystem
    public void atomicMove(Path r3, Path r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "target");
        if (r3.toFile().renameTo(r4.toFile()) == false) goto L6;
        return;
    L6:
        throw new IOException("failed to move " + r3 + " to " + r4);
    }

    @Override // okio.FileSystem
    public void delete(Path r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        if (Thread.interrupted() == true) goto L16;
        File r1 = r2.toFile();
        if (r1.delete() == false) goto L7;
        return;
    L7:
        if (r1.exists() == true) goto L13;
        if (r3 == true) goto L11;
        return;
    L11:
        throw new FileNotFoundException("no such file: " + r2);
    L13:
        throw new IOException("failed to delete " + r2);
    L16:
        throw new InterruptedIOException("interrupted");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path r1, Path r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r2, "target");
        throw new IOException("unsupported");
    }

    private final void requireExist(Path r2) {
        if (exists(r2) == false) goto L6;
        return;
    L6:
        throw new IOException(r2 + " doesn't exist.");
    }

    private final void requireCreate(Path r2) {
        if (exists(r2) == true) goto L6;
        return;
    L6:
        throw new IOException(r2 + " already exists.");
    }
}
