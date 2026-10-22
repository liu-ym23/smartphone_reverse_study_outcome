package okio;

import com.bytedance.apm.constant.PerfConsts;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileHandle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002-.B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0013H$J\b\u0010\u001b\u001a\u00020\u0013H$J(\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH$J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0016H$J\b\u0010$\u001a\u00020\u0016H$J(\u0010%\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH$J&\u0010&\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rJ\u001e\u0010&\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020'2\u0006\u0010!\u001a\u00020\u0016J \u0010(\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020'2\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0016\u0010)\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010)\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0016J\u0006\u0010#\u001a\u00020\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u0016J&\u0010+\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rJ\u001e\u0010+\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010!\u001a\u00020\u0016J \u0010,\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010!\u001a\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006/"}, d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "readWrite", "", "(Z)V", "closed", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "openStreamCount", "", "getReadWrite", "()Z", "appendingSink", "Lokio/Sink;", "close", "", "flush", "position", "", "sink", "source", "Lokio/Source;", "protectedClose", "protectedFlush", "protectedRead", "fileOffset", "array", "", "arrayOffset", "byteCount", "protectedResize", PerfConsts.PERF_DISK_FILE_SIZE, "protectedSize", "protectedWrite", "read", "Lokio/Buffer;", "readNoCloseCheck", "reposition", "resize", "write", "writeNoCloseCheck", "FileHandleSink", "FileHandleSource", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class FileHandle implements Closeable {
    private boolean closed;
    private final ReentrantLock lock;
    private int openStreamCount;
    private final boolean readWrite;

    /* JADX INFO: compiled from: FileHandle.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "fileHandle");
            this.fileHandle = r2;
            this.position = r3;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long r1) {
            this.position = r1;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean r1) {
            this.closed = r1;
        }

        @Override // okio.Sink
        public void write(Buffer r8, long r9) {
            Intrinsics.checkNotNullParameter(r8, "source");
            if ((!this.closed) == false) goto L7;
            FileHandle.access$writeNoCloseCheck(this.fileHandle, this.position, r8, r9);
            this.position += r9;
            return;
        L7:
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if ((!this.closed) == false) goto L7;
            this.fileHandle.protectedFlush();
            return;
        L7:
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            ReentrantLock r0 = this.fileHandle.getLock();
            r0.lock();
            FileHandle r1 = this.fileHandle;     // Catch: Throwable -> L16
            FileHandle.access$setOpenStreamCount$p(r1, FileHandle.access$getOpenStreamCount$p(r1) - 1);     // Catch: Throwable -> L16
            if (FileHandle.access$getOpenStreamCount$p(this.fileHandle) == 0) goto L9;
        L14:
            r0.unlock();
            return;
        L9:
            if (FileHandle.access$getClosed$p(this.fileHandle) == false) goto L14;
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
            r0.unlock();
            this.fileHandle.protectedClose();
            return;
        L16:
            th = move-exception;
            r0.unlock();
            throw th;
        }
    }

    /* JADX INFO: compiled from: FileHandle.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "fileHandle");
            this.fileHandle = r2;
            this.position = r3;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long r1) {
            this.position = r1;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean r1) {
            this.closed = r1;
        }

        @Override // okio.Source
        public long read(Buffer r8, long r9) {
            Intrinsics.checkNotNullParameter(r8, "sink");
            if ((!this.closed) == false) goto L9;
            long r10 = FileHandle.access$readNoCloseCheck(this.fileHandle, this.position, r8, r9);
            if (r10 == (-1)) goto L7;
            this.position += r10;
        L7:
            return r10;
        L9:
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            ReentrantLock r0 = this.fileHandle.getLock();
            r0.lock();
            FileHandle r1 = this.fileHandle;     // Catch: Throwable -> L16
            FileHandle.access$setOpenStreamCount$p(r1, FileHandle.access$getOpenStreamCount$p(r1) - 1);     // Catch: Throwable -> L16
            if (FileHandle.access$getOpenStreamCount$p(this.fileHandle) == 0) goto L9;
        L14:
            r0.unlock();
            return;
        L9:
            if (FileHandle.access$getClosed$p(this.fileHandle) == false) goto L14;
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
            r0.unlock();
            this.fileHandle.protectedClose();
            return;
        L16:
            th = move-exception;
            r0.unlock();
            throw th;
        }
    }

    protected abstract void protectedClose() throws IOException;

    protected abstract void protectedFlush() throws IOException;

    protected abstract int protectedRead(long r1, byte[] r3, int r4, int r5) throws IOException;

    protected abstract void protectedResize(long r1) throws IOException;

    protected abstract long protectedSize() throws IOException;

    protected abstract void protectedWrite(long r1, byte[] r3, int r4, int r5) throws IOException;

    public FileHandle(boolean r1) {
        this.readWrite = r1;
        this.lock = _JvmPlatformKt.newLock();
    }

    public static final /* synthetic */ boolean access$getClosed$p(FileHandle r0) {
        return r0.closed;
    }

    public static final /* synthetic */ int access$getOpenStreamCount$p(FileHandle r0) {
        return r0.openStreamCount;
    }

    public static final /* synthetic */ long access$readNoCloseCheck(FileHandle r0, long r1, Buffer r3, long r4) {
        return r0.readNoCloseCheck(r1, r3, r4);
    }

    public static final /* synthetic */ void access$setOpenStreamCount$p(FileHandle r0, int r1) {
        r0.openStreamCount = r1;
    }

    public static final /* synthetic */ void access$writeNoCloseCheck(FileHandle r0, long r1, Buffer r3, long r4) {
        r0.writeNoCloseCheck(r1, r3, r4);
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final int read(long r3, byte[] r5, int r6, int r7) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "array");
        ReentrantLock r0 = this.lock;
        r0.lock();
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if ((!this.closed) == false) goto L9;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r0.unlock();
        return protectedRead(r3, r5, r6, r7);
    L9:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L10
    }

    public final long read(long r3, Buffer r5, long r6) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "sink");
        ReentrantLock r0 = this.lock;
        r0.lock();
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if ((!this.closed) == false) goto L9;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r0.unlock();
        return readNoCloseCheck(r3, r5, r6);
    L9:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L10
    }

    public final long size() throws IOException {
        ReentrantLock r0 = this.lock;
        r0.lock();
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if ((!this.closed) == false) goto L9;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r0.unlock();
        return protectedSize();
    L9:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L10
    }

    public final void resize(long r3) throws IOException {
        if (this.readWrite == false) goto L16;
        ReentrantLock r0 = this.lock;
        r0.lock();
    L12:
        th = move-exception;
        r0.unlock();
        throw th;
    L6:
        if ((!this.closed) == false) goto L11;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r0.unlock();
        protectedResize(r3);
        return;
    L11:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L12
    L16:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final void write(long r3, byte[] r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "array");
        if (this.readWrite == false) goto L16;
        ReentrantLock r0 = this.lock;
        r0.lock();
    L12:
        th = move-exception;
        r0.unlock();
        throw th;
    L6:
        if ((!this.closed) == false) goto L11;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r0.unlock();
        protectedWrite(r3, r5, r6, r7);
        return;
    L11:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L12
    L16:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final void write(long r3, Buffer r5, long r6) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (this.readWrite == false) goto L16;
        ReentrantLock r0 = this.lock;
        r0.lock();
    L12:
        th = move-exception;
        r0.unlock();
        throw th;
    L6:
        if ((!this.closed) == false) goto L11;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r0.unlock();
        writeNoCloseCheck(r3, r5, r6);
        return;
    L11:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L12
    L16:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final void flush() throws IOException {
        if (this.readWrite == false) goto L16;
        ReentrantLock r0 = this.lock;
        r0.lock();
    L12:
        th = move-exception;
        r0.unlock();
        throw th;
    L6:
        if ((!this.closed) == false) goto L11;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r0.unlock();
        protectedFlush();
        return;
    L11:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L12
    L16:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public static /* synthetic */ Source source$default(FileHandle r0, long r1, int r3, Object r4) throws IOException {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = 0;
    L7:
        return r0.source(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    public final Source source(long r3) throws IOException {
        ReentrantLock r0 = this.lock;
        r0.lock();
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if ((!this.closed) == false) goto L9;
        this.openStreamCount++;     // Catch: Throwable -> L10
        r0.unlock();
        return new FileHandleSource(this, r3);
    L9:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L10
    }

    public final long position(Source r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "source");
        if ((r5 instanceof RealBufferedSource) == false) goto L5;
        RealBufferedSource r6 = (RealBufferedSource) r5;
        long r0 = r6.bufferField.size();
        r5 = r6.source;
    L7:
        if ((r5 instanceof FileHandleSource) == true) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L20;
        FileHandleSource r7 = (FileHandleSource) r5;
        if ((!r7.getClosed()) == false) goto L18;
        return r7.getPosition() - r0;
    L18:
        throw new IllegalStateException("closed".toString());
    L20:
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    L9:
        if (((FileHandleSource) r5).getFileHandle() != this) goto L11;
        r4 = true;
        goto L12
    L5:
        r0 = 0;
        goto L7
    }

    public final void reposition(Source r10, long r11) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "source");
        boolean r3 = false;
        if ((r10 instanceof RealBufferedSource) == false) goto L26;
        RealBufferedSource r12 = (RealBufferedSource) r10;
        Source r0 = r12.source;
        if ((r0 instanceof FileHandleSource) == true) goto L7;
    L9:
        boolean r9 = false;
    L10:
        if (r9 == false) goto L24;
        FileHandleSource r1 = (FileHandleSource) r0;
        if ((!r1.getClosed()) == false) goto L22;
        long r2 = r12.bufferField.size();
        long r5 = r11 - (r1.getPosition() - r2);
        if (0 <= r5) goto L16;
    L18:
        if (r3 == false) goto L20;
        r12.skip(r5);
        return;
    L20:
        r12.bufferField.clear();
        r1.setPosition(r11);
        return;
    L16:
        if (r5 >= r2) goto L18;
        r3 = true;
        goto L18
    L22:
        throw new IllegalStateException("closed".toString());
    L24:
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    L7:
        if (((FileHandleSource) r0).getFileHandle() != this) goto L9;
        r9 = true;
        goto L10
    L26:
        if ((r10 instanceof FileHandleSource) == true) goto L28;
    L30:
        if (r3 == false) goto L38;
        FileHandleSource r13 = (FileHandleSource) r10;
        if ((!r13.getClosed()) == false) goto L36;
        r13.setPosition(r11);
        return;
    L36:
        throw new IllegalStateException("closed".toString());
    L38:
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    L28:
        if (((FileHandleSource) r10).getFileHandle() != this) goto L30;
        r3 = true;
        goto L30
    }

    public static /* synthetic */ Sink sink$default(FileHandle r0, long r1, int r3, Object r4) throws IOException {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = 0;
    L7:
        return r0.sink(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public final Sink sink(long r3) throws IOException {
        if (this.readWrite == false) goto L16;
        ReentrantLock r0 = this.lock;
        r0.lock();
    L12:
        th = move-exception;
        r0.unlock();
        throw th;
    L6:
        if ((!this.closed) == false) goto L11;
        this.openStreamCount++;     // Catch: Throwable -> L12
        r0.unlock();
        return new FileHandleSink(this, r3);
    L11:
        throw new IllegalStateException("closed".toString());     // Catch: Throwable -> L12
    L16:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final Sink appendingSink() throws IOException {
        return sink(size());
    }

    public final long position(Sink r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "sink");
        if ((r5 instanceof RealBufferedSink) == false) goto L5;
        RealBufferedSink r6 = (RealBufferedSink) r5;
        long r0 = r6.bufferField.size();
        r5 = r6.sink;
    L7:
        if ((r5 instanceof FileHandleSink) == true) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L20;
        FileHandleSink r7 = (FileHandleSink) r5;
        if ((!r7.getClosed()) == false) goto L18;
        return r7.getPosition() + r0;
    L18:
        throw new IllegalStateException("closed".toString());
    L20:
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    L9:
        if (((FileHandleSink) r5).getFileHandle() != this) goto L11;
        r4 = true;
        goto L12
    L5:
        r0 = 0;
        goto L7
    }

    public final void reposition(Sink r7, long r8) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "sink");
        boolean r3 = false;
        if ((r7 instanceof RealBufferedSink) == false) goto L18;
        RealBufferedSink r9 = (RealBufferedSink) r7;
        Sink r0 = r9.sink;
        if ((r0 instanceof FileHandleSink) == true) goto L7;
    L9:
        if (r3 == false) goto L16;
        FileHandleSink r1 = (FileHandleSink) r0;
        if ((!r1.getClosed()) == false) goto L14;
        r9.emit();
        r1.setPosition(r8);
        return;
    L14:
        throw new IllegalStateException("closed".toString());
    L16:
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    L7:
        if (((FileHandleSink) r0).getFileHandle() != this) goto L9;
        r3 = true;
        goto L9
    L18:
        if ((r7 instanceof FileHandleSink) == true) goto L20;
    L22:
        if (r3 == false) goto L30;
        FileHandleSink r10 = (FileHandleSink) r7;
        if ((!r10.getClosed()) == false) goto L28;
        r10.setPosition(r8);
        return;
    L28:
        throw new IllegalStateException("closed".toString());
    L30:
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    L20:
        if (((FileHandleSink) r7).getFileHandle() != this) goto L22;
        r3 = true;
        goto L22
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ReentrantLock r0 = this.lock;
        r0.lock();
    L15:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (this.closed == false) goto L8;
        r0.unlock();
        return;
    L8:
        this.closed = true;     // Catch: Throwable -> L15
        if (this.openStreamCount == 0) goto L12;
        r0.unlock();
        return;
    L12:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r0.unlock();
        protectedClose();
    }

    private final long readNoCloseCheck(long r16, Buffer r18, long r19) {
        if (r19 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L23;
        long r1 = r16 + r19;
        long r11 = r16;
    L9:
        if (r11 >= r1) goto L21;
        Segment r4 = r18.writableSegment$okio(1);
        int r5 = protectedRead(r11, r4.data, r4.limit, (int) Math.min(r1 - r11, 8192 - r4.limit));
        if (r5 == (-1)) goto L13;
        r4.limit += r5;
        long r6 = r5;
        r11 = r11 + r6;
        r18.setSize$okio(r18.size() + r6);
        goto L9
    L13:
        if (r4.pos != r4.limit) goto L16;
        r18.head = r4.pop();
        SegmentPool.recycle(r4);
    L16:
        if (r16 != r11) goto L21;
        return -1;
    L21:
        return r11 - r16;
    L23:
        throw new IllegalArgumentException(("byteCount < 0: " + r19).toString());
    L5:
        r3 = false;
        goto L6
    }

    private final void writeNoCloseCheck(long r9, Buffer r11, long r12) {
        _UtilKt.checkOffsetAndCount(r11.size(), 0, r12);
        long r13 = r12 + r9;
    L4:
        if (r9 >= r13) goto L8;
        Segment r6 = r11.head;
        Intrinsics.checkNotNull(r6);
        int r7 = (int) Math.min(r13 - r9, r6.limit - r6.pos);
        protectedWrite(r9, r6.data, r6.pos, r7);
        r6.pos += r7;
        long r0 = r7;
        r9 = r9 + r0;
        r11.setSize$okio(r11.size() - r0);
        if (r6.pos != r6.limit) goto L4;
        r11.head = r6.pop();
        SegmentPool.recycle(r6);
        goto L4
    }
}
