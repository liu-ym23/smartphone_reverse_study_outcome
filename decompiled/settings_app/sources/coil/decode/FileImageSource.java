package coil.decode;

import coil.util.Utils;
import java.io.Closeable;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcoil/decode/FileImageSource;", "Lcoil/decode/ImageSource;", "file", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "diskCacheKey", "", "closeable", "Ljava/io/Closeable;", "metadata", "Lcoil/decode/ImageSource$Metadata;", "(Lokio/Path;Lokio/FileSystem;Ljava/lang/String;Ljava/io/Closeable;Lcoil/decode/ImageSource$Metadata;)V", "getDiskCacheKey$coil_base_release", "()Ljava/lang/String;", "getFile$coil_base_release", "()Lokio/Path;", "getFileSystem", "()Lokio/FileSystem;", "isClosed", "", "getMetadata", "()Lcoil/decode/ImageSource$Metadata;", "source", "Lokio/BufferedSource;", "assertNotClosed", "", "close", "fileOrNull", "sourceOrNull", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileImageSource extends ImageSource {
    private final Closeable closeable;
    private final String diskCacheKey;
    private final Path file;
    private final FileSystem fileSystem;
    private boolean isClosed;
    private final ImageSource.Metadata metadata;
    private BufferedSource source;

    public final Path getFile$coil_base_release() {
        return this.file;
    }

    @Override // coil.decode.ImageSource
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public final String getDiskCacheKey$coil_base_release() {
        return this.diskCacheKey;
    }

    @Override // coil.decode.ImageSource
    public ImageSource.Metadata getMetadata() {
        return this.metadata;
    }

    public FileImageSource(Path r2, FileSystem r3, String r4, Closeable r5, ImageSource.Metadata r6) {
        super(null);
        this.file = r2;
        this.fileSystem = r3;
        this.diskCacheKey = r4;
        this.closeable = r5;
        this.metadata = r6;
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
        BufferedSource r1 = Okio.buffer(getFileSystem().source(this.file));     // Catch: Throwable -> L10
        this.source = r1;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // coil.decode.ImageSource
    public synchronized BufferedSource sourceOrNull() {
        monitor-enter(this);
        assertNotClosed();     // Catch: Throwable -> L6
        BufferedSource r0 = this.source;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // coil.decode.ImageSource
    public synchronized Path file() {
        monitor-enter(this);
        assertNotClosed();     // Catch: Throwable -> L6
        Path r0 = this.file;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // coil.decode.ImageSource
    public Path fileOrNull() {
        return file();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.isClosed = true;     // Catch: Throwable -> L12
        BufferedSource r0 = this.source;     // Catch: Throwable -> L12
        if (r0 == null) goto L7;
        Utils.closeQuietly(r0);     // Catch: Throwable -> L12
    L7:
        Closeable r1 = this.closeable;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        Utils.closeQuietly(r1);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final void assertNotClosed() {
        if ((!this.isClosed) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("closed".toString());
    }
}
