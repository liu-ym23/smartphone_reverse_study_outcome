package coil.decode;

import coil.util.Utils;
import java.io.File;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil/decode/SourceImageSource;", "Lcoil/decode/ImageSource;", "source", "Lokio/BufferedSource;", "cacheDirectoryFactory", "Lkotlin/Function0;", "Ljava/io/File;", "metadata", "Lcoil/decode/ImageSource$Metadata;", "(Lokio/BufferedSource;Lkotlin/jvm/functions/Function0;Lcoil/decode/ImageSource$Metadata;)V", "file", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "isClosed", "", "getMetadata", "()Lcoil/decode/ImageSource$Metadata;", "assertNotClosed", "", "close", "createTempFile", "fileOrNull", "sourceOrNull", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SourceImageSource extends ImageSource {
    private Function0<? extends File> cacheDirectoryFactory;
    private Path file;
    private boolean isClosed;
    private final ImageSource.Metadata metadata;
    private BufferedSource source;

    @Override // coil.decode.ImageSource
    public ImageSource.Metadata getMetadata() {
        return this.metadata;
    }

    public SourceImageSource(BufferedSource r2, Function0<? extends File> r3, ImageSource.Metadata r4) {
        super(null);
        this.metadata = r4;
        this.source = r2;
        this.cacheDirectoryFactory = r3;
    }

    @Override // coil.decode.ImageSource
    public FileSystem getFileSystem() {
        return FileSystem.SYSTEM;
    }

    @Override // coil.decode.ImageSource
    public synchronized BufferedSource source() {
        monitor-enter(this);
        assertNotClosed();     // Catch: Throwable -> L10
        BufferedSource r0 = this.source;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        FileSystem r1 = getFileSystem();     // Catch: Throwable -> L10
        Path r2 = this.file;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L10
        BufferedSource r3 = Okio.buffer(r1.source(r2));     // Catch: Throwable -> L10
        this.source = r3;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // coil.decode.ImageSource
    public BufferedSource sourceOrNull() {
        return source();
    }

    @Override // coil.decode.ImageSource
    public synchronized Path file() {
        monitor-enter(this);
        assertNotClosed();     // Catch: Throwable -> L28
        Path r0 = this.file;     // Catch: Throwable -> L28
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        Path r1 = createTempFile();     // Catch: Throwable -> L28
        BufferedSink r2 = Okio.buffer(getFileSystem().sink(r1, false));     // Catch: Throwable -> L28
        BufferedSource r4 = this.source;     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L16
        Long r3 = Long.valueOf(r2.writeAll(r4));     // Catch: Throwable -> L16
        if (r2 != null) goto L34;
    L15:
        Throwable th = null;
    L23:
        if (th != null) goto L27;
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L28
        this.source = null;     // Catch: Throwable -> L28
        this.file = r1;     // Catch: Throwable -> L28
        this.cacheDirectoryFactory = null;     // Catch: Throwable -> L28
        monitor-exit(this);
        return r1;
    L27:
        throw th;     // Catch: Throwable -> L28
    L34:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = th;
        goto L23
    L16:
        th = move-exception;
        if (r2 != null) goto L31;
    L22:
        th = th;
        r3 = null;
        goto L23
    L31:
        r2.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    @Override // coil.decode.ImageSource
    public synchronized Path fileOrNull() {
        monitor-enter(this);
        assertNotClosed();     // Catch: Throwable -> L6
        Path r0 = this.file;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.isClosed = true;     // Catch: Throwable -> L12
        BufferedSource r0 = this.source;     // Catch: Throwable -> L12
        if (r0 == null) goto L7;
        Utils.closeQuietly(r0);     // Catch: Throwable -> L12
    L7:
        Path r1 = this.file;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        getFileSystem().delete(r1);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final Path createTempFile() {
        Function0<? extends File> r4 = this.cacheDirectoryFactory;
        Intrinsics.checkNotNull(r4);
        File r5 = r4.invoke();
        if (r5.isDirectory() == false) goto L7;
        return Path.Companion.get$default(Path.Companion, File.createTempFile("tmp", null, r5), false, 1, null);
    L7:
        throw new IllegalStateException("cacheDirectory must be a directory.".toString());
    }

    private final void assertNotClosed() {
        if ((!this.isClosed) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("closed".toString());
    }
}
