package coil.util;

import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: renamed from: coil.util.-FileSystems, reason: invalid class name */
/* JADX INFO: compiled from: FileSystems.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¨\u0006\u0007"}, d2 = {"createFile", "", "Lokio/FileSystem;", "file", "Lokio/Path;", "deleteContents", "directory", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FileSystems {
    public static final void createFile(FileSystem r1, Path r2) {
        if (r1.exists(r2) == true) goto L6;
        Utils.closeQuietly(r1.sink(r2));
        return;
    }

    public static final void deleteContents(FileSystem r3, Path r4) {
        Iterator<Path> r5 = r3.list(r4).iterator();
        IOException r0 = null;
    L5:
        if (r5.hasNext() == false) goto L15;
        Path r1 = r5.next();
        if (r3.metadata(r1).isDirectory() == false) goto L10;
        deleteContents(r3, r1);     // Catch: IOException -> L12
    L10:
        r3.delete(r1);     // Catch: IOException -> L12
    L12:
        e = move-exception;
        if (r0 != null) goto L5;
        r0 = e;
        goto L5
    L15:
        if (r0 != null) goto L17;
        return;
    L17:
        throw r0;
    }
}
