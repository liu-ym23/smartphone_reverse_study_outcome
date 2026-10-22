package okio;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okio.internal.ResourceFileSystem;
import okio.internal._FileSystemKt;

/* JADX INFO: compiled from: FileSystem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u0006J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH&J:\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u0006H&JD\u0010/\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\u0087\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Lokio/FileSystem;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "copy", "createDirectories", "dir", "mustCreate", "createDirectory", "createSymlink", "delete", "deleteRecursively", "fileOrDirectory", "exists", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadata", "Lokio/FileMetadata;", "metadataOrNull", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "read", ExifInterface.GPS_DIRECTION_TRUE, "readerAction", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "-read", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lokio/Source;", "write", "writerAction", "Lokio/BufferedSink;", "-write", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class FileSystem {
    public static final Companion Companion = null;
    public static final FileSystem RESOURCES = null;
    public static final FileSystem SYSTEM = null;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY = null;

    /* JADX INFO: compiled from: FileSystem.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lokio/FileSystem$Companion;", "", "()V", "RESOURCES", "Lokio/FileSystem;", "SYSTEM", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public abstract Sink appendingSink(Path r1, boolean r2) throws IOException;

    public abstract void atomicMove(Path r1, Path r2) throws IOException;

    public abstract Path canonicalize(Path r1) throws IOException;

    public abstract void createDirectory(Path r1, boolean r2) throws IOException;

    public abstract void createSymlink(Path r1, Path r2) throws IOException;

    public abstract void delete(Path r1, boolean r2) throws IOException;

    public abstract List<Path> list(Path r1) throws IOException;

    public abstract List<Path> listOrNull(Path r1);

    public abstract FileMetadata metadataOrNull(Path r1) throws IOException;

    public abstract FileHandle openReadOnly(Path r1) throws IOException;

    public abstract FileHandle openReadWrite(Path r1, boolean r2, boolean r3) throws IOException;

    public abstract Sink sink(Path r1, boolean r2) throws IOException;

    public abstract Source source(Path r1) throws IOException;

    public FileSystem() {
    }

    public final FileMetadata metadata(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "path");
        return _FileSystemKt.commonMetadata(this, r2);
    }

    public final boolean exists(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "path");
        return _FileSystemKt.commonExists(this, r2);
    }

    public static /* synthetic */ Sequence listRecursively$default(FileSystem r0, Path r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = false;
    L7:
        return r0.listRecursively(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public Sequence<Path> listRecursively(Path r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        return _FileSystemKt.commonListRecursively(this, r2, r3);
    }

    public final Sequence<Path> listRecursively(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        return listRecursively(r2, false);
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem r1, Path r2, boolean r3, boolean r4, int r5, Object r6) throws IOException {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = false;
    L7:
        if ((r5 & 4) == 0) goto L10;
        r4 = false;
    L10:
        return r1.openReadWrite(r2, r3, r4);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public final FileHandle openReadWrite(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "file");
        return openReadWrite(r2, false, false);
    }

    public static /* synthetic */ Sink sink$default(FileSystem r0, Path r1, boolean r2, int r3, Object r4) throws IOException {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = false;
    L7:
        return r0.sink(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public final Sink sink(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "file");
        return sink(r2, false);
    }

    /* JADX INFO: renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m3236write$default(FileSystem r1, Path r2, boolean r3, Function1 r4, int r5, Object r6) throws IOException {
        if (r6 != null) goto L27;
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r4, "writerAction");
        BufferedSink r7 = Okio.buffer(r1.sink(r2, r3));
        Throwable th = null;
        Object r8 = r4.invoke(r7);     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (r7 != null) goto L32;
    L13:
        InlineMarker.finallyEnd(1);
    L22:
        if (th != null) goto L25;
        Intrinsics.checkNotNull(r8);
        return r8;
    L25:
        throw th;
    L32:
        r7.close();     // Catch: Throwable -> L12
    L12:
        th = th;
    L14:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r7 != null) goto L30;
    L21:
        InlineMarker.finallyEnd(1);
        r8 = null;
        th = th;
        goto L22
    L30:
        r7.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L21
    L27:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem r0, Path r1, boolean r2, int r3, Object r4) throws IOException {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = false;
    L7:
        return r0.appendingSink(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public final Sink appendingSink(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "file");
        return appendingSink(r2, false);
    }

    public static /* synthetic */ void createDirectory$default(FileSystem r0, Path r1, boolean r2, int r3, Object r4) throws IOException {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.createDirectory(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
    }

    public final void createDirectory(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "dir");
        createDirectory(r2, false);
    }

    public static /* synthetic */ void createDirectories$default(FileSystem r0, Path r1, boolean r2, int r3, Object r4) throws IOException {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.createDirectories(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
    }

    public final void createDirectories(Path r2, boolean r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "dir");
        _FileSystemKt.commonCreateDirectories(this, r2, r3);
    }

    public final void createDirectories(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "dir");
        createDirectories(r2, false);
    }

    public void copy(Path r2, Path r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "target");
        _FileSystemKt.commonCopy(this, r2, r3);
    }

    public static /* synthetic */ void delete$default(FileSystem r0, Path r1, boolean r2, int r3, Object r4) throws IOException {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.delete(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public final void delete(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "path");
        delete(r2, false);
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem r0, Path r1, boolean r2, int r3, Object r4) throws IOException {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.deleteRecursively(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
    }

    public void deleteRecursively(Path r2, boolean r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "fileOrDirectory");
        _FileSystemKt.commonDeleteRecursively(this, r2, r3);
    }

    public final void deleteRecursively(Path r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "fileOrDirectory");
        deleteRecursively(r2, false);
    }

    static {
        Companion = new Companion(null);
        Class.forName("java.nio.file.Files");     // Catch: ClassNotFoundException -> L5
        NioSystemFileSystem r0 = new NioSystemFileSystem();     // Catch: ClassNotFoundException -> L5
    L6:
        SYSTEM = r0;
        Path.Companion r1 = Path.Companion;
        String r2 = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(r2, "getProperty(\"java.io.tmpdir\")");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(r1, r2, false, 1, null);
        ClassLoader r3 = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(r3, "ResourceFileSystem::class.java.classLoader");
        RESOURCES = new ResourceFileSystem(r3, false);
        return;
    L5:
        r0 = new JvmSystemFileSystem();
        goto L6
    }

    /* JADX INFO: renamed from: -read, reason: not valid java name */
    public final <T> T m3237read(Path r4, Function1<? super BufferedSource, ? extends T> r5) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "file");
        Intrinsics.checkNotNullParameter(r5, "readerAction");
        BufferedSource r3 = Okio.buffer(source(r4));
        Throwable th = null;
        T r6 = r5.invoke(r3);     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        if (r3 != null) goto L24;
    L9:
        InlineMarker.finallyEnd(1);
    L18:
        if (th != null) goto L21;
        Intrinsics.checkNotNull(r6);
        return r6;
    L21:
        throw th;
    L24:
        r3.close();     // Catch: Throwable -> L8
    L8:
        th = th;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r3 != null) goto L22;
    L17:
        InlineMarker.finallyEnd(1);
        th = th;
        r6 = null;
        goto L18
    L22:
        r3.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L17
    }

    /* JADX INFO: renamed from: -write, reason: not valid java name */
    public final <T> T m3238write(Path r3, boolean r4, Function1<? super BufferedSink, ? extends T> r5) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r5, "writerAction");
        BufferedSink r2 = Okio.buffer(sink(r3, r4));
        Throwable th = null;
        T r6 = r5.invoke(r2);     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        if (r2 != null) goto L24;
    L9:
        InlineMarker.finallyEnd(1);
    L18:
        if (th != null) goto L21;
        Intrinsics.checkNotNull(r6);
        return r6;
    L21:
        throw th;
    L24:
        r2.close();     // Catch: Throwable -> L8
    L8:
        th = th;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r2 != null) goto L22;
    L17:
        InlineMarker.finallyEnd(1);
        r6 = null;
        th = th;
        goto L18
    L22:
        r2.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L17
    }
}
