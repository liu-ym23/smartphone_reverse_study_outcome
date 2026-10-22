package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NioSystemFileSystem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "()V", "atomicMove", "", "source", "Lokio/Path;", "target", "createSymlink", "metadataOrNull", "Lokio/FileMetadata;", "path", "toString", "", "zeroToNull", "", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NioSystemFileSystem extends JvmSystemFileSystem {
    @Override // okio.JvmSystemFileSystem
    public String toString() {
        return "NioSystemFileSystem";
    }

    public NioSystemFileSystem() {
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public FileMetadata metadataOrNull(Path r20) {
        Intrinsics.checkNotNullParameter(r20, "path");
        java.nio.file.Path r1 = r20.toNioPath();
        Long r2 = null;
        BasicFileAttributes r3 = Files.readAttributes(r1, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: Throwable -> L25
        if (r3.isSymbolicLink() == false) goto L7;
        java.nio.file.Path r4 = Files.readSymbolicLink(r1);
    L8:
        boolean r9 = r3.isRegularFile();
        boolean r10 = r3.isDirectory();
        if (r4 == null) goto L11;
        Path r11 = Path.Companion.get$default(Path.Companion, r4, false, 1, null);
    L12:
        Long r12 = Long.valueOf(r3.size());
        FileTime r5 = r3.creationTime();
        if (r5 == null) goto L15;
        Long r13 = zeroToNull(r5);
    L16:
        FileTime r6 = r3.lastModifiedTime();
        if (r6 == null) goto L19;
        Long r14 = zeroToNull(r6);
    L20:
        FileTime r7 = r3.lastAccessTime();
        if (r7 == null) goto L24;
        r2 = zeroToNull(r7);
    L24:
        return new FileMetadata(r9, r10, r11, r12, r13, r14, r2, null, 128, null);
    L19:
        r14 = null;
        goto L20
    L15:
        r13 = null;
        goto L16
    L11:
        r11 = null;
        goto L12
    L7:
        r4 = null;
    L25:
        return null;
    }

    private final Long zeroToNull(FileTime r5) {
        Long r4 = Long.valueOf(r5.toMillis());
        if (r4.longValue() == 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L10;
        return null;
    L10:
        return r4;
    L5:
        r6 = false;
        goto L6
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void atomicMove(Path r3, Path r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "target");
        Files.move(r3.toNioPath(), r4.toNioPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});     // Catch: UnsupportedOperationException -> L5 NoSuchFileException -> L7
        return;
    L7:
        e = move-exception;
        throw new FileNotFoundException(e.getMessage());
    L6:
        throw new IOException("atomic move not supported");
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void createSymlink(Path r1, Path r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r2, "target");
        Files.createSymbolicLink(r1.toNioPath(), r2.toNioPath(), new FileAttribute[0]);
    }
}
