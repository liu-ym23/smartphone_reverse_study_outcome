package okio;

import com.bytedance.apm.constant.PerfConsts;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JvmFileHandle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\bH\u0014J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokio/JvmFileHandle;", "Lokio/FileHandle;", "readWrite", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "(ZLjava/io/RandomAccessFile;)V", "protectedClose", "", "protectedFlush", "protectedRead", "", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "protectedResize", PerfConsts.PERF_DISK_FILE_SIZE, "protectedSize", "protectedWrite", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JvmFileHandle extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    public JvmFileHandle(boolean r2, RandomAccessFile r3) {
        Intrinsics.checkNotNullParameter(r3, "randomAccessFile");
        super(r2);
        this.randomAccessFile = r3;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedResize(long r8) {
        monitor-enter(this);
        long r1 = size();     // Catch: Throwable -> L9
        long r3 = r8 - r1;     // Catch: Throwable -> L9
        if (r3 <= 0) goto L6;
        int r5 = (int) r3;     // Catch: Throwable -> L9
        protectedWrite(r1, new byte[r5], 0, r5);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        this.randomAccessFile.setLength(r8);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // okio.FileHandle
    protected synchronized long protectedSize() {
        monitor-enter(this);
        long r0 = this.randomAccessFile.length();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okio.FileHandle
    protected synchronized int protectedRead(long r2, byte[] r4, int r5, int r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "array");     // Catch: Throwable -> L14
        this.randomAccessFile.seek(r2);     // Catch: Throwable -> L14
        int r3 = 0;
    L4:
        if (r3 >= r6) goto L12;
        int r7 = this.randomAccessFile.read(r4, r5, r6 - r3);     // Catch: Throwable -> L14
        if (r7 == (-1)) goto L8;
        r3 = r3 + r7;
        goto L4
    L8:
        if (r3 != 0) goto L12;
        monitor-exit(this);
        return -1;
    L12:
        monitor-exit(this);
        return r3;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedWrite(long r2, byte[] r4, int r5, int r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "array");     // Catch: Throwable -> L6
        this.randomAccessFile.seek(r2);     // Catch: Throwable -> L6
        this.randomAccessFile.write(r4, r5, r6);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedFlush() {
        monitor-enter(this);
        this.randomAccessFile.getFD().sync();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okio.FileHandle
    protected synchronized void protectedClose() {
        monitor-enter(this);
        this.randomAccessFile.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
