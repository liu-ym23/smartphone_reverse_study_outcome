package coil.disk;

import android.os.StatFs;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import java.io.Closeable;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: DiskCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003!\"#J\b\u0010\u0015\u001a\u00020\u0016H'J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH'J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH§\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH'J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH'J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH'R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Lcoil/disk/DiskCache;", "", "directory", "Lokio/Path;", "getDirectory$annotations", "()V", "getDirectory", "()Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "getFileSystem$annotations", "getFileSystem", "()Lokio/FileSystem;", "maxSize", "", "getMaxSize$annotations", "getMaxSize", "()J", PerfConsts.PERF_DISK_FILE_SIZE, "getSize$annotations", "getSize", "clear", "", "edit", "Lcoil/disk/DiskCache$Editor;", "key", "", "get", "Lcoil/disk/DiskCache$Snapshot;", "openEditor", "openSnapshot", "remove", "", "Builder", "Editor", "Snapshot", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DiskCache {

    /* JADX INFO: compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0012J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil/disk/DiskCache$Builder;", "", "()V", "cleanupDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "directory", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "maxSizeBytes", "", "maxSizePercent", "", "maximumMaxSizeBytes", "minimumMaxSizeBytes", IndexDatabaseHelper.MetaColumns.BUILD, "Lcoil/disk/DiskCache;", "dispatcher", "Ljava/io/File;", PerfConsts.PERF_DISK_FILE_SIZE, PowerUsageDetail.EXTRA_PERCENT, "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private CoroutineDispatcher cleanupDispatcher;
        private Path directory;
        private FileSystem fileSystem;
        private long maxSizeBytes;
        private double maxSizePercent;
        private long maximumMaxSizeBytes;
        private long minimumMaxSizeBytes;

        public Builder() {
            this.fileSystem = FileSystem.SYSTEM;
            this.maxSizePercent = 0.02d;
            this.minimumMaxSizeBytes = 10485760;
            this.maximumMaxSizeBytes = 262144000;
            this.cleanupDispatcher = Dispatchers.getIO();
        }

        public final Builder directory(File r5) {
            return directory(Path.Companion.get$default(Path.Companion, r5, false, 1, null));
        }

        public final Builder directory(Path r2) {
            this.directory = r2;
            return this;
        }

        public final Builder fileSystem(FileSystem r2) {
            this.fileSystem = r2;
            return this;
        }

        public final Builder maxSizePercent(double r5) {
            boolean r1 = false;
            if (0.0d <= r5) goto L5;
        L7:
            if (r1 == false) goto L11;
            this.maxSizeBytes = 0;
            this.maxSizePercent = r5;
            return this;
        L11:
            throw new IllegalArgumentException("size must be in the range [0.0, 1.0].".toString());
        L5:
            if (r5 > 1.0d) goto L7;
            r1 = true;
            goto L7
        }

        public final Builder minimumMaxSizeBytes(long r3) {
            if (r3 <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.minimumMaxSizeBytes = r3;
            return this;
        L10:
            throw new IllegalArgumentException("size must be > 0.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder maximumMaxSizeBytes(long r3) {
            if (r3 <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.maximumMaxSizeBytes = r3;
            return this;
        L10:
            throw new IllegalArgumentException("size must be > 0.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder maxSizeBytes(long r3) {
            if (r3 <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.maxSizePercent = 0.0d;
            this.maxSizeBytes = r3;
            return this;
        L10:
            throw new IllegalArgumentException("size must be > 0.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder cleanupDispatcher(CoroutineDispatcher r2) {
            this.cleanupDispatcher = r2;
            return this;
        }

        public final DiskCache build() {
            Path r3 = this.directory;
            if (r3 == null) goto L13;
            if (this.maxSizePercent > 0.0d) goto L14;
            long r0 = this.maxSizeBytes;
        L11:
            return new RealDiskCache(r0, r3, this.fileSystem, this.cleanupDispatcher);
        L14:
            File r1 = r3.toFile();     // Catch: Exception -> L8
            r1.mkdir();     // Catch: Exception -> L8
            StatFs r2 = new StatFs(r1.getAbsolutePath());     // Catch: Exception -> L8
            r0 = RangesKt.coerceIn((long) ((this.maxSizePercent * r2.getBlockCountLong()) * r2.getBlockSizeLong()), this.minimumMaxSizeBytes, this.maximumMaxSizeBytes);     // Catch: Exception -> L8
        L8:
            r0 = this.minimumMaxSizeBytes;
            goto L11
        L13:
            throw new IllegalStateException("directory == null".toString());
        }
    }

    /* JADX INFO: compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH'J\n\u0010\r\u001a\u0004\u0018\u00010\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcoil/disk/DiskCache$Editor;", "", "data", "Lokio/Path;", "getData", "()Lokio/Path;", "metadata", "getMetadata", "abort", "", "commit", "commitAndGet", "Lcoil/disk/DiskCache$Snapshot;", "commitAndOpenSnapshot", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Editor {
        void abort();

        void commit();

        @Deprecated(message = "Renamed to 'commitAndOpenSnapshot'.", replaceWith = @ReplaceWith(expression = "commitAndOpenSnapshot()", imports = {}))
        Snapshot commitAndGet();

        Snapshot commitAndOpenSnapshot();

        Path getData();

        Path getMetadata();
    }

    /* JADX INFO: compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH'J\n\u0010\r\u001a\u0004\u0018\u00010\fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcoil/disk/DiskCache$Snapshot;", "Ljava/io/Closeable;", "Lokio/Closeable;", "data", "Lokio/Path;", "getData", "()Lokio/Path;", "metadata", "getMetadata", "close", "", "closeAndEdit", "Lcoil/disk/DiskCache$Editor;", "closeAndOpenEditor", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Snapshot extends Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();

        @Deprecated(message = "Renamed to 'closeAndOpenEditor'.", replaceWith = @ReplaceWith(expression = "closeAndOpenEditor()", imports = {}))
        Editor closeAndEdit();

        Editor closeAndOpenEditor();

        Path getData();

        Path getMetadata();
    }

    static /* synthetic */ void getDirectory$annotations() {
    }

    static /* synthetic */ void getFileSystem$annotations() {
    }

    static /* synthetic */ void getMaxSize$annotations() {
    }

    static /* synthetic */ void getSize$annotations() {
    }

    void clear();

    @Deprecated(message = "Renamed to 'openEditor'.", replaceWith = @ReplaceWith(expression = "openEditor(key)", imports = {}))
    Editor edit(String r1);

    @Deprecated(message = "Renamed to 'openSnapshot'.", replaceWith = @ReplaceWith(expression = "openSnapshot(key)", imports = {}))
    Snapshot get(String r1);

    Path getDirectory();

    FileSystem getFileSystem();

    long getMaxSize();

    long getSize();

    Editor openEditor(String r1);

    Snapshot openSnapshot(String r1);

    boolean remove(String r1);
}
