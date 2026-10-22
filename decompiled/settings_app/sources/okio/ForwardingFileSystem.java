package okio;

import android.icu.lang.UCharacter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: ForwardingFileSystem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020 H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006)"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadataOrNull", "Lokio/FileMetadata;", "onPathParameter", "functionName", "", "parameterName", "onPathResult", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public Path onPathParameter(Path r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "path");
        Intrinsics.checkNotNullParameter(r2, "functionName");
        Intrinsics.checkNotNullParameter(r3, "parameterName");
        return r1;
    }

    public Path onPathResult(Path r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "path");
        Intrinsics.checkNotNullParameter(r2, "functionName");
        return r1;
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    public ForwardingFileSystem(FileSystem r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.delegate = r2;
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "path");
        Path r4 = onPathParameter(r3, "canonicalize", "path");
        return onPathResult(this.delegate.canonicalize(r4), "canonicalize");
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path r14) throws IOException {
        Intrinsics.checkNotNullParameter(r14, "path");
        Path r15 = onPathParameter(r14, "metadataOrNull", "path");
        FileMetadata r2 = this.delegate.metadataOrNull(r15);
        if (r2 != null) goto L7;
        return null;
    L7:
        if (r2.getSymlinkTarget() != null) goto L10;
        return r2;
    L10:
        return FileMetadata.copy$default(r2, false, false, onPathResult(r2.getSymlinkTarget(), "metadataOrNull"), null, null, null, null, null, UCharacter.UnicodeBlock.TIRHUTA_ID, null);
    }

    @Override // okio.FileSystem
    public List<Path> list(Path r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "dir");
        Path r5 = onPathParameter(r4, "list", "dir");
        List<Path> r6 = this.delegate.list(r5);
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.add(onPathResult((Path) r7.next(), "list"));
        goto L4
    L6:
        ArrayList r1 = r0;
        CollectionsKt.sort(r1);
        return r1;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path r4) {
        Intrinsics.checkNotNullParameter(r4, "dir");
        Path r5 = onPathParameter(r4, "listOrNull", "dir");
        List<Path> r6 = this.delegate.listOrNull(r5);
        if (r6 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r0.add(onPathResult((Path) r7.next(), "listOrNull"));
        goto L8
    L10:
        ArrayList r1 = r0;
        CollectionsKt.sort(r1);
        return r1;
    }

    @Override // okio.FileSystem
    public Sequence<Path> listRecursively(Path r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "dir");
        Path r5 = onPathParameter(r3, "listRecursively", "dir");
        return SequencesKt.map(this.delegate.listRecursively(r5, r4), new AnonymousClass1(this));
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "file");
        Path r4 = onPathParameter(r3, "openReadOnly", "file");
        return this.delegate.openReadOnly(r4);
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path r3, boolean r4, boolean r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "file");
        Path r6 = onPathParameter(r3, "openReadWrite", "file");
        return this.delegate.openReadWrite(r6, r4, r5);
    }

    @Override // okio.FileSystem
    public Source source(Path r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "file");
        Path r4 = onPathParameter(r3, "source", "file");
        return this.delegate.source(r4);
    }

    @Override // okio.FileSystem
    public Sink sink(Path r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "file");
        Path r5 = onPathParameter(r3, "sink", "file");
        return this.delegate.sink(r5, r4);
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "file");
        Path r5 = onPathParameter(r3, "appendingSink", "file");
        return this.delegate.appendingSink(r5, r4);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "dir");
        Path r5 = onPathParameter(r3, "createDirectory", "dir");
        this.delegate.createDirectory(r5, r4);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path r4, Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "target");
        Path r6 = onPathParameter(r4, "atomicMove", "source");
        Path r7 = onPathParameter(r5, "atomicMove", "target");
        this.delegate.atomicMove(r6, r7);
    }

    @Override // okio.FileSystem
    public void delete(Path r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "path");
        Path r5 = onPathParameter(r3, "delete", "path");
        this.delegate.delete(r5, r4);
    }

    @Override // okio.FileSystem
    public void createSymlink(Path r4, Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "target");
        Path r6 = onPathParameter(r4, "createSymlink", "source");
        Path r7 = onPathParameter(r5, "createSymlink", "target");
        this.delegate.createSymlink(r6, r7);
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
