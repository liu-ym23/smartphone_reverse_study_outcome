package okhttp3.internal.cache;

import com.bytedance.apm.constant.PerfConsts;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: DiskLruCache.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010)\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0004[\\]^B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0016J!\u0010;\u001a\u0002092\n\u0010<\u001a\u00060=R\u00020\u00002\u0006\u0010>\u001a\u00020\u0010H\u0000¢\u0006\u0002\b?J\u0006\u0010@\u001a\u000209J \u0010A\u001a\b\u0018\u00010=R\u00020\u00002\u0006\u0010B\u001a\u00020(2\b\b\u0002\u0010C\u001a\u00020\u000bH\u0007J\u0006\u0010D\u001a\u000209J\b\u0010E\u001a\u000209H\u0016J\u0017\u0010F\u001a\b\u0018\u00010GR\u00020\u00002\u0006\u0010B\u001a\u00020(H\u0086\u0002J\u0006\u0010H\u001a\u000209J\u0006\u0010I\u001a\u00020\u0010J\b\u0010J\u001a\u00020\u0010H\u0002J\b\u0010K\u001a\u00020%H\u0002J\b\u0010L\u001a\u000209H\u0002J\b\u0010M\u001a\u000209H\u0002J\u0010\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020(H\u0002J\r\u0010P\u001a\u000209H\u0000¢\u0006\u0002\bQJ\u000e\u0010R\u001a\u00020\u00102\u0006\u0010B\u001a\u00020(J\u0019\u0010S\u001a\u00020\u00102\n\u0010T\u001a\u00060)R\u00020\u0000H\u0000¢\u0006\u0002\bUJ\b\u0010V\u001a\u00020\u0010H\u0002J\u0006\u00105\u001a\u00020\u000bJ\u0010\u0010W\u001a\f\u0012\b\u0012\u00060GR\u00020\u00000XJ\u0006\u0010Y\u001a\u000209J\u0010\u0010Z\u001a\u0002092\u0006\u0010B\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060)R\u00020\u00000'X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R&\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006_"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "directory", "Ljava/io/File;", "appVersion", "", "valueCount", "maxSize", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "civilizedFileSystem", "", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getDirectory", "()Ljava/io/File;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "mostRecentTrimFailed", "nextSequenceNumber", "redundantOpCount", PerfConsts.PERF_DISK_FILE_SIZE, "getValueCount$okhttp", "()I", "checkNotClosed", "", "close", "completeEdit", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "success", "completeEdit$okhttp", "delete", "edit", "key", "expectedSequenceNumber", "evictAll", "flush", "get", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "initialize", "isClosed", "journalRebuildRequired", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "rebuildJournal", "rebuildJournal$okhttp", "remove", "removeEntry", "entry", "removeEntry$okhttp", "removeOldestEntry", "snapshots", "", "trimToSize", "validateKey", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DiskLruCache implements Closeable, Flushable {
    public static final long ANY_SEQUENCE_NUMBER = 0;
    public static final String CLEAN = null;
    public static final Companion Companion = null;
    public static final String DIRTY = null;
    public static final String JOURNAL_FILE = null;
    public static final String JOURNAL_FILE_BACKUP = null;
    public static final String JOURNAL_FILE_TEMP = null;
    public static final Regex LEGAL_KEY_PATTERN = null;
    public static final String MAGIC = null;
    public static final String READ = null;
    public static final String REMOVE = null;
    public static final String VERSION_1 = null;
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "()V", "ANY_SEQUENCE_NUMBER", "", "CLEAN", "", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "READ", "REMOVE", "VERSION_1", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "done", "", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", "", "getWritten$okhttp", "()[Z", "abort", "", "commit", "detach", "detach$okhttp", "newSink", "Lokio/Sink;", "index", "", "newSource", "Lokio/Source;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache r2, Entry r3) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "entry");
            this.this$0 = r2;
            this.entry = r3;
            if (r3.getReadable$okhttp() == false) goto L5;
            boolean[] r4 = null;
        L6:
            this.written = r4;
            return;
        L5:
            r4 = new boolean[r2.getValueCount$okhttp()];
            goto L6
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final void detach$okhttp() {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this) == true) goto L5;
            return;
        L5:
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L7;
            this.this$0.completeEdit$okhttp(this, false);
            return;
        L7:
            this.entry.setZombie$okhttp(true);
        }

        public final Source newSource(int r4) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L22:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L21;
            Source r2 = null;
            if (getEntry$okhttp().getReadable$okhttp() == true) goto L9;
        L18:
            monitor-exit(r0);
            return null;
        L9:
            if (Intrinsics.areEqual(getEntry$okhttp().getCurrentEditor$okhttp(), this) == false) goto L18;
            if (getEntry$okhttp().getZombie$okhttp() == true) goto L18;
            r2 = r0.getFileSystem$okhttp().source(getEntry$okhttp().getCleanFiles$okhttp().get(r4));     // Catch: FileNotFoundException -> L15 Throwable -> L22
        L16:
            monitor-exit(r0);
            return r2;
        L15:
            Source r3 = (Source) null;     // Catch: Throwable -> L22
            goto L16
        L21:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L22
        }

        public final Sink newSink(int r4) {
            final DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L24:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L23;
            if (Intrinsics.areEqual(getEntry$okhttp().getCurrentEditor$okhttp(), this) == true) goto L12;
            Sink r3 = Okio.blackhole();     // Catch: Throwable -> L24
            monitor-exit(r0);
            return r3;
        L12:
            if (getEntry$okhttp().getReadable$okhttp() == true) goto L28;
            boolean[] r1 = getWritten$okhttp();     // Catch: Throwable -> L24
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L24
            r1[r4] = true;     // Catch: Throwable -> L24
        L28:
            FaultHidingSink r2 = new FaultHidingSink(r0.getFileSystem$okhttp().sink(getEntry$okhttp().getDirtyFiles$okhttp().get(r4)), new DiskLruCache$Editor$newSink$1$1(r0, this));     // Catch: Throwable -> L24
            monitor-exit(r0);
            return r2;
        L21:
            return Okio.blackhole();
        L23:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L24
        }

        public final void commit() throws IOException {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L13;
            if (Intrinsics.areEqual(getEntry$okhttp().getCurrentEditor$okhttp(), this) == false) goto L9;
            r0.completeEdit$okhttp(this, true);     // Catch: Throwable -> L14
        L9:
            this.done = true;     // Catch: Throwable -> L14
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r0);
            return;
        L13:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L14
        }

        public final void abort() throws IOException {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L13;
            if (Intrinsics.areEqual(getEntry$okhttp().getCurrentEditor$okhttp(), this) == false) goto L9;
            r0.completeEdit$okhttp(this, false);     // Catch: Throwable -> L14
        L9:
            this.done = true;     // Catch: Throwable -> L14
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r0);
            return;
        L13:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L14
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u001aH\u0002J\u001b\u00105\u001a\u0002062\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H\u0000¢\u0006\u0002\b7J\u0013\u00108\u001a\b\u0018\u000109R\u00020\fH\u0000¢\u0006\u0002\b:J\u0015\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0002\b>R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$¨\u0006?"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "key", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "", "Ljava/io/File;", "getCleanFiles$okhttp", "()Ljava/util/List;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles$okhttp", "getKey$okhttp", "()Ljava/lang/String;", "lengths", "", "getLengths$okhttp", "()[J", "lockingSourceCount", "", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "readable", "", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "sequenceNumber", "", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "invalidLengths", "", "strings", "", "newSource", "Lokio/Source;", "index", "setLengths", "", "setLengths$okhttp", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot$okhttp", "writeLengths", "writer", "Lokio/BufferedSink;", "writeLengths$okhttp", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class Entry {
        private final List<File> cleanFiles;
        private Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "this$0");
            Intrinsics.checkNotNullParameter(r8, "key");
            this.this$0 = r7;
            this.key = r8;
            this.lengths = new long[r7.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder r9 = new StringBuilder(r8).append('.');
            int r0 = r9.length();
            int r10 = r7.getValueCount$okhttp();
            int r1 = 0;
        L3:
            if (r1 >= r10) goto L5;
            int r2 = r1 + 1;
            r9.append(r1);
            this.cleanFiles.add(new File(this.this$0.getDirectory(), r9.toString()));
            r9.append(".tmp");
            this.dirtyFiles.add(new File(this.this$0.getDirectory(), r9.toString()));
            r9.setLength(r0);
            r1 = r2;
            goto L3
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final void setReadable$okhttp(boolean r1) {
            this.readable = r1;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setZombie$okhttp(boolean r1) {
            this.zombie = r1;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final void setCurrentEditor$okhttp(Editor r1) {
            this.currentEditor = r1;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final void setLockingSourceCount$okhttp(int r1) {
            this.lockingSourceCount = r1;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final void setSequenceNumber$okhttp(long r1) {
            this.sequenceNumber = r1;
        }

        public final void setLengths$okhttp(List<String> r7) throws IOException {
            Intrinsics.checkNotNullParameter(r7, "strings");
            if (r7.size() == this.this$0.getValueCount$okhttp()) goto L13;
            invalidLengths(r7);
            throw new KotlinNothingValueException();
        L13:
            int r0 = r7.size();     // Catch: NumberFormatException -> L9
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L8;
            int r2 = r1 + 1;     // Catch: NumberFormatException -> L9
            this.lengths[r1] = Long.parseLong(r7.get(r1));     // Catch: NumberFormatException -> L9
            r1 = r2;
            goto L5
        L8:
            return;
        L9:
            invalidLengths(r7);
            throw new KotlinNothingValueException();
        }

        public final void writeLengths$okhttp(BufferedSink r6) throws IOException {
            Intrinsics.checkNotNullParameter(r6, "writer");
            long[] r5 = this.lengths;
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            long r2 = r5[r1];
            r1 = r1 + 1;
            r6.writeByte(32).writeDecimalLong(r2);
            goto L3
        }

        private final Void invalidLengths(List<String> r2) throws IOException {
            throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", r2));
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache r0 = this.this$0;
            if (Util.assertionsEnabled == false) goto L10;
            if (Thread.holdsLock(r0) == true) goto L10;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r0);
        L10:
            if (this.readable == true) goto L13;
            return null;
        L13:
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L15;
        L19:
            ArrayList r1 = new ArrayList();
            long[] r8 = (long[]) this.lengths.clone();
            int r2 = this.this$0.getValueCount$okhttp();     // Catch: FileNotFoundException -> L25
            int r3 = 0;
        L21:
            if (r3 >= r2) goto L23;
            r1.add(newSource(r3));     // Catch: FileNotFoundException -> L25
            r3 = r3 + 1;     // Catch: FileNotFoundException -> L25
            goto L21
        L23:
            return new Snapshot(this.this$0, this.key, this.sequenceNumber, r1, r8);
        L25:
            Iterator r4 = r1.iterator();
        L27:
            if (r4.hasNext() == false) goto L34;
            Util.closeQuietly((Source) r4.next());
            goto L27
        L34:
            this.this$0.removeEntry$okhttp(this);     // Catch: IOException -> L31
        L30:
            return null;
        L15:
            if (this.currentEditor == null) goto L17;
        L18:
            return null;
        L17:
            if (this.zombie == false) goto L19;
            goto L18
        }

        private final Source newSource(int r3) {
            final Source r4 = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(r3));
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L5;
            return r4;
        L5:
            this.lockingSourceCount++;
            final DiskLruCache r1 = this.this$0;
            return new DiskLruCache$Entry$newSource$1(r4, r1, this);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "key", "", "sequenceNumber", "", "sources", "", "Lokio/Source;", "lengths", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "close", "", "edit", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getLength", "index", "", "getSource", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache r2, String r3, long r4, List<? extends Source> r6, long[] r7) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r6, "sources");
            Intrinsics.checkNotNullParameter(r7, "lengths");
            this.this$0 = r2;
            this.key = r3;
            this.sequenceNumber = r4;
            this.sources = r6;
            this.lengths = r7;
        }

        public final String key() {
            return this.key;
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final Source getSource(int r1) {
            return this.sources.get(r1);
        }

        public final long getLength(int r1) {
            return this.lengths[r1];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<Source> r1 = this.sources.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Util.closeQuietly(r1.next());
            goto L4
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$snapshots$1, reason: invalid class name */
    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\r\u0010\u000b\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012 \u0006*\b\u0018\u00010\u0005R\u00020\u00030\u0005R\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"okhttp3/internal/cache/DiskLruCache$snapshots$1", "", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "delegate", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "kotlin.jvm.PlatformType", "nextSnapshot", "removeSnapshot", "hasNext", "", "next", "remove", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Snapshot>, KMutableIterator {
        private final Iterator<Entry> delegate;
        private Snapshot nextSnapshot;
        private Snapshot removeSnapshot;
        final /* synthetic */ DiskLruCache this$0;

        AnonymousClass1(DiskLruCache r2) {
            this.this$0 = r2;
            Iterator<Entry> r3 = new ArrayList(r2.getLruEntries$okhttp().values()).iterator();
            Intrinsics.checkNotNullExpressionValue(r3, "ArrayList(lruEntries.values).iterator()");
            this.delegate = r3;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Snapshot next() {
            return next2();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextSnapshot == null) goto L5;
            return true;
        L5:
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L26:
            th = move-exception;
            throw th;
        L9:
            if (r0.getClosed$okhttp() == false) goto L13;
            monitor-exit(r0);
            return false;
        L13:
            if (this.delegate.hasNext() == false) goto L23;
            Entry r2 = this.delegate.next();     // Catch: Throwable -> L26
            if (r2 != null) goto L17;
            Snapshot r3 = null;
        L18:
            if (r3 == null) goto L13;
            this.nextSnapshot = r3;     // Catch: Throwable -> L26
            monitor-exit(r0);
            return true;
        L17:
            r3 = r2.snapshot$okhttp();     // Catch: Throwable -> L26
            goto L18
        L23:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L26
            monitor-exit(r0);
            return false;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Snapshot next2() {
            if (hasNext() == false) goto L7;
            Snapshot r0 = this.nextSnapshot;
            this.removeSnapshot = r0;
            this.nextSnapshot = null;
            Intrinsics.checkNotNull(r0);
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot r0 = this.removeSnapshot;
            if (r0 == null) goto L13;
            this.this$0.remove(r0.key());     // Catch: Throwable -> L7 IOException -> L14
        L7:
            th = move-exception;
            this.removeSnapshot = null;
            throw th;
        L10:
            this.removeSnapshot = null;
            return;
        L13:
            throw new IllegalStateException("remove() before next()".toString());
        }
    }

    public final Editor edit(String r8) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "key");
        return edit$default(this, r8, 0, 2, null);
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem r5, File r6, int r7, int r8, long r9, TaskRunner r11) {
        Intrinsics.checkNotNullParameter(r5, "fileSystem");
        Intrinsics.checkNotNullParameter(r6, "directory");
        Intrinsics.checkNotNullParameter(r11, "taskRunner");
        this.fileSystem = r5;
        this.directory = r6;
        this.appVersion = r7;
        this.valueCount = r8;
        this.maxSize = r9;
        boolean r10 = false;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupQueue = r11.newQueue();
        final String r12 = Intrinsics.stringPlus(Util.okHttpName, " Cache");
        this.cleanupTask = new DiskLruCache$cleanupTask$1(this, r12);
        if (r9 <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L15;
        if (r8 <= 0) goto L9;
        r10 = true;
    L9:
        if (r10 == false) goto L13;
        this.journalFile = new File(r6, JOURNAL_FILE);
        this.journalFileTmp = new File(r6, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(r6, JOURNAL_FILE_BACKUP);
        return;
    L13:
        throw new IllegalArgumentException("valueCount <= 0".toString());
    L15:
        throw new IllegalArgumentException("maxSize <= 0".toString());
    L5:
        r13 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$getCivilizedFileSystem$p(DiskLruCache r0) {
        return r0.civilizedFileSystem;
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache r0) {
        return r0.initialized;
    }

    public static final /* synthetic */ boolean access$journalRebuildRequired(DiskLruCache r0) {
        return r0.journalRebuildRequired();
    }

    public static final /* synthetic */ void access$setHasJournalErrors$p(DiskLruCache r0, boolean r1) {
        r0.hasJournalErrors = r1;
    }

    public static final /* synthetic */ void access$setJournalWriter$p(DiskLruCache r0, BufferedSink r1) {
        r0.journalWriter = r1;
    }

    public static final /* synthetic */ void access$setMostRecentRebuildFailed$p(DiskLruCache r0, boolean r1) {
        r0.mostRecentRebuildFailed = r1;
    }

    public static final /* synthetic */ void access$setMostRecentTrimFailed$p(DiskLruCache r0, boolean r1) {
        r0.mostRecentTrimFailed = r1;
    }

    public static final /* synthetic */ void access$setRedundantOpCount$p(DiskLruCache r0, int r1) {
        r0.redundantOpCount = r1;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized long getMaxSize() {
        monitor-enter(this);
        long r0 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void setMaxSize(long r7) {
        monitor-enter(this);
        this.maxSize = r7;     // Catch: Throwable -> L8
        if (this.initialized == false) goto L6;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final void setClosed$okhttp(boolean r1) {
        this.closed = r1;
    }

    private final void readJournal() throws IOException {
        BufferedSource r2 = Okio.buffer(this.fileSystem.source(this.journalFile));
        BufferedSource r3 = r2;     // Catch: Throwable -> L28
        String r4 = r3.readUtf8LineStrict();     // Catch: Throwable -> L28
        String r5 = r3.readUtf8LineStrict();     // Catch: Throwable -> L28
        String r6 = r3.readUtf8LineStrict();     // Catch: Throwable -> L28
        String r7 = r3.readUtf8LineStrict();     // Catch: Throwable -> L28
        String r8 = r3.readUtf8LineStrict();     // Catch: Throwable -> L28
        if (Intrinsics.areEqual(MAGIC, r4) == false) goto L27;
        if (Intrinsics.areEqual(VERSION_1, r5) == false) goto L27;
        if (Intrinsics.areEqual(String.valueOf(this.appVersion), r6) == false) goto L27;
        if (Intrinsics.areEqual(String.valueOf(getValueCount$okhttp()), r7) == false) goto L27;
        int r9 = 0;
        if (r8.length() <= 0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == true) goto L27;
    L36:
        readJournalLine(r3.readUtf8LineStrict());     // Catch: EOFException -> L19 Throwable -> L28
        r9 = r9 + 1;
        goto L36
    L19:
        this.redundantOpCount = r9 - getLruEntries$okhttp().size();     // Catch: Throwable -> L28
        if (r3.exhausted() == true) goto L22;
        rebuildJournal$okhttp();     // Catch: Throwable -> L28
    L23:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r2, null);
        return;
    L22:
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L28
        goto L23
    L15:
        r10 = false;
    L27:
        throw new IOException("unexpected journal header: [" + r4 + ", " + r5 + ", " + r7 + ", " + r8 + ']');     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void readJournalLine(String r14) throws IOException {
        String r6 = r14;
        int r7 = StringsKt.indexOf$default(r6, TokenParser.SP, 0, false, 6, null);
        if (r7 == (-1)) goto L37;
        int r10 = r7 + 1;
        int r0 = StringsKt.indexOf$default(r6, TokenParser.SP, r10, false, 4, null);
        if (r0 != (-1)) goto L12;
        String r5 = r14.substring(r10);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).substring(startIndex)");
        String r8 = REMOVE;
        if (r7 == r8.length()) goto L9;
    L13:
        Entry r9 = this.lruEntries.get(r5);
        if (r9 != null) goto L16;
        r9 = new Entry(this, r5);
        this.lruEntries.put(r5, r9);
    L16:
        if (r0 == (-1)) goto L22;
        String r11 = CLEAN;
        if (r7 != r11.length()) goto L22;
        if (StringsKt.startsWith$default(r14, r11, false, 2, null) == false) goto L22;
        String r15 = r14.substring(r0 + 1);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
        List<String> r16 = StringsKt.split$default(r15, new char[]{TokenParser.SP}, false, 0, 6, null);
        r9.setReadable$okhttp(true);
        r9.setCurrentEditor$okhttp(null);
        r9.setLengths$okhttp(r16);
        return;
    L22:
        if (r0 != (-1)) goto L28;
        String r1 = DIRTY;
        if (r7 != r1.length()) goto L28;
        if (StringsKt.startsWith$default(r14, r1, false, 2, null) == false) goto L28;
        r9.setCurrentEditor$okhttp(new Editor(this, r9));
        return;
    L28:
        if (r0 != (-1)) goto L35;
        String r13 = READ;
        if (r7 != r13.length()) goto L35;
        if (StringsKt.startsWith$default(r14, r13, false, 2, null) == false) goto L35;
        return;
    L35:
        throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", r14));
    L9:
        if (StringsKt.startsWith$default(r14, r8, false, 2, null) == false) goto L13;
        this.lruEntries.remove(r5);
        return;
    L12:
        r5 = r14.substring(r10, r0);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        goto L13
    L37:
        throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", r14));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> r0 = this.lruEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Entry r1 = r0.next();
        Intrinsics.checkNotNullExpressionValue(r1, "i.next()");
        Entry r2 = r1;
        int r3 = 0;
        if (r2.getCurrentEditor$okhttp() == null) goto L7;
        r2.setCurrentEditor$okhttp(null);
        int r4 = this.valueCount;
    L11:
        if (r3 >= r4) goto L13;
        this.fileSystem.delete(r2.getCleanFiles$okhttp().get(r3));
        this.fileSystem.delete(r2.getDirtyFiles$okhttp().get(r3));
        r3 = r3 + 1;
        goto L11
    L13:
        r0.remove();
        goto L4
    L7:
        int r5 = this.valueCount;
    L8:
        if (r3 >= r5) goto L4;
        this.size += r2.getLengths$okhttp()[r3];
        r3 = r3 + 1;
        goto L8
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        monitor-enter(this);
        BufferedSink r0 = this.journalWriter;     // Catch: Throwable -> L28
        if (r0 == null) goto L7;
        r0.close();     // Catch: Throwable -> L28
    L7:
        BufferedSink r1 = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));     // Catch: Throwable -> L28
        BufferedSink r2 = r1;     // Catch: Throwable -> L23
        r2.writeUtf8(MAGIC).writeByte(10);     // Catch: Throwable -> L23
        r2.writeUtf8(VERSION_1).writeByte(10);     // Catch: Throwable -> L23
        r2.writeDecimalLong(this.appVersion).writeByte(10);     // Catch: Throwable -> L23
        r2.writeDecimalLong(getValueCount$okhttp()).writeByte(10);     // Catch: Throwable -> L23
        r2.writeByte(10);     // Catch: Throwable -> L23
        Iterator<Entry> r3 = getLruEntries$okhttp().values().iterator();     // Catch: Throwable -> L23
    L10:
        if (r3.hasNext() == false) goto L15;
        Entry r4 = r3.next();     // Catch: Throwable -> L23
        if (r4.getCurrentEditor$okhttp() != null) goto L13;
        r2.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L23
        r2.writeUtf8(r4.getKey$okhttp());     // Catch: Throwable -> L23
        r4.writeLengths$okhttp(r2);     // Catch: Throwable -> L23
        r2.writeByte(10);     // Catch: Throwable -> L23
        goto L10
    L13:
        r2.writeUtf8(DIRTY).writeByte(32);     // Catch: Throwable -> L23
        r2.writeUtf8(r4.getKey$okhttp());     // Catch: Throwable -> L23
        r2.writeByte(10);     // Catch: Throwable -> L23
        goto L10
    L15:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L17:
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L28
        if (this.fileSystem.exists(this.journalFile) == false) goto L20;
        this.fileSystem.rename(this.journalFile, this.journalFileBackup);     // Catch: Throwable -> L28
    L20:
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);     // Catch: Throwable -> L28
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L28
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L28
        this.hasJournalErrors = false;     // Catch: Throwable -> L28
        this.mostRecentRebuildFailed = false;     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final synchronized Snapshot get(String r8) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "key");     // Catch: Throwable -> L17
        initialize();     // Catch: Throwable -> L17
        checkNotClosed();     // Catch: Throwable -> L17
        validateKey(r8);     // Catch: Throwable -> L17
        Entry r0 = this.lruEntries.get(r8);     // Catch: Throwable -> L17
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Snapshot r1 = r0.snapshot$okhttp();     // Catch: Throwable -> L17
        if (r1 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        this.redundantOpCount++;     // Catch: Throwable -> L17
        BufferedSink r2 = this.journalWriter;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L17
        r2.writeUtf8(READ).writeByte(32).writeUtf8(r8).writeByte(10);     // Catch: Throwable -> L17
        if (journalRebuildRequired() == false) goto L15;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return r1;
    L17:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache r0, String r1, long r2, int r4, Object r5) throws IOException {
        if ((r4 & 2) == 0) goto L6;
        r2 = ANY_SEQUENCE_NUMBER;
    L6:
        return r0.edit(r1, r2);
    }

    public final synchronized Editor edit(String r10, long r11) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "key");     // Catch: Throwable -> L39
        initialize();     // Catch: Throwable -> L39
        checkNotClosed();     // Catch: Throwable -> L39
        validateKey(r10);     // Catch: Throwable -> L39
        Entry r0 = this.lruEntries.get(r10);     // Catch: Throwable -> L39
        if (r11 == ANY_SEQUENCE_NUMBER) goto L11;
        if (r0 != null) goto L8;
    L9:
        monitor-exit(this);
        return null;
    L8:
        if (r0.getSequenceNumber$okhttp() != r11) goto L9;
    L11:
        if (r0 != null) goto L13;
        Editor r12 = null;
    L14:
        if (r12 == null) goto L17;
        monitor-exit(this);
        return null;
    L17:
        if (r0 == null) goto L23;
        if (r0.getLockingSourceCount$okhttp() == 0) goto L23;
        monitor-exit(this);
        return null;
    L23:
        if (this.mostRecentTrimFailed == false) goto L25;
    L36:
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L39
        monitor-exit(this);
        return null;
    L25:
        if (this.mostRecentRebuildFailed == true) goto L36;
        BufferedSink r13 = this.journalWriter;     // Catch: Throwable -> L39
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L39
        r13.writeUtf8(DIRTY).writeByte(32).writeUtf8(r10).writeByte(10);     // Catch: Throwable -> L39
        r13.flush();     // Catch: Throwable -> L39
        if (this.hasJournalErrors == false) goto L31;
        monitor-exit(this);
        return null;
    L31:
        if (r0 != null) goto L33;
        r0 = new Entry(this, r10);     // Catch: Throwable -> L39
        this.lruEntries.put(r10, r0);     // Catch: Throwable -> L39
    L33:
        Editor r14 = new Editor(this, r0);     // Catch: Throwable -> L39
        r0.setCurrentEditor$okhttp(r14);     // Catch: Throwable -> L39
        monitor-exit(this);
        return r14;
    L13:
        r12 = r0.getCurrentEditor$okhttp();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    public final synchronized long size() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        long r0 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void completeEdit$okhttp(Editor r10, boolean r11) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "editor");     // Catch: Throwable -> L54
        Entry r0 = r10.getEntry$okhttp();     // Catch: Throwable -> L54
        if (Intrinsics.areEqual(r0.getCurrentEditor$okhttp(), r10) == false) goto L53;
        int r1 = 0;
        if (r11 == true) goto L8;
    L21:
        int r12 = this.valueCount;     // Catch: Throwable -> L54
    L22:
        if (r1 >= r12) goto L32;
        int r2 = r1 + 1;     // Catch: Throwable -> L54
        File r3 = r0.getDirtyFiles$okhttp().get(r1);     // Catch: Throwable -> L54
        if (r11 == true) goto L26;
    L30:
        this.fileSystem.delete(r3);     // Catch: Throwable -> L54
    L31:
        r1 = r2;
        goto L22
    L26:
        if (r0.getZombie$okhttp() == true) goto L30;
        if (this.fileSystem.exists(r3) == false) goto L31;
        File r4 = r0.getCleanFiles$okhttp().get(r1);     // Catch: Throwable -> L54
        this.fileSystem.rename(r3, r4);     // Catch: Throwable -> L54
        long r5 = r0.getLengths$okhttp()[r1];     // Catch: Throwable -> L54
        long r6 = this.fileSystem.size(r4);     // Catch: Throwable -> L54
        r0.getLengths$okhttp()[r1] = r6;     // Catch: Throwable -> L54
        this.size = (this.size - r5) + r6;     // Catch: Throwable -> L54
        goto L31
    L32:
        r0.setCurrentEditor$okhttp(null);     // Catch: Throwable -> L54
        if (r0.getZombie$okhttp() == false) goto L37;
        removeEntry$okhttp(r0);     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L37:
        this.redundantOpCount++;     // Catch: Throwable -> L54
        BufferedSink r13 = this.journalWriter;     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L54
        if (r0.getReadable$okhttp() == true) goto L42;
        if (r11 == true) goto L42;
        getLruEntries$okhttp().remove(r0.getKey$okhttp());     // Catch: Throwable -> L54
        r13.writeUtf8(REMOVE).writeByte(32);     // Catch: Throwable -> L54
        r13.writeUtf8(r0.getKey$okhttp());     // Catch: Throwable -> L54
        r13.writeByte(10);     // Catch: Throwable -> L54
    L45:
        r13.flush();     // Catch: Throwable -> L54
        if (this.size <= this.maxSize) goto L48;
    L49:
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L54
    L50:
        monitor-exit(this);
        return;
    L48:
        if (journalRebuildRequired() == false) goto L50;
    L42:
        r0.setReadable$okhttp(true);     // Catch: Throwable -> L54
        r13.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L54
        r13.writeUtf8(r0.getKey$okhttp());     // Catch: Throwable -> L54
        r0.writeLengths$okhttp(r13);     // Catch: Throwable -> L54
        r13.writeByte(10);     // Catch: Throwable -> L54
        if (r11 == false) goto L45;
        long r7 = this.nextSequenceNumber;     // Catch: Throwable -> L54
        this.nextSequenceNumber = 1 + r7;     // Catch: Throwable -> L54
        r0.setSequenceNumber$okhttp(r7);     // Catch: Throwable -> L54
        goto L45
    L8:
        if (r0.getReadable$okhttp() == true) goto L21;
        int r8 = this.valueCount;     // Catch: Throwable -> L54
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L21;
        int r14 = r9 + 1;     // Catch: Throwable -> L54
        boolean[] r15 = r10.getWritten$okhttp();     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L54
        if (r15[r9] == false) goto L19;
        if (this.fileSystem.exists(r0.getDirtyFiles$okhttp().get(r9)) == false) goto L15;
        r9 = r14;
        goto L10
    L15:
        r10.abort();     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L19:
        r10.abort();     // Catch: Throwable -> L54
        throw new IllegalStateException(Intrinsics.stringPlus("Newly created entry didn't create value for index ", Integer.valueOf(r9)));     // Catch: Throwable -> L54
    L53:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    }

    private final boolean journalRebuildRequired() {
        int r0 = this.redundantOpCount;
        if (r0 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r0 < this.lruEntries.size()) goto L7;
        return true;
    }

    public final synchronized boolean remove(String r6) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "key");     // Catch: Throwable -> L15
        initialize();     // Catch: Throwable -> L15
        checkNotClosed();     // Catch: Throwable -> L15
        validateKey(r6);     // Catch: Throwable -> L15
        Entry r7 = this.lruEntries.get(r6);     // Catch: Throwable -> L15
        if (r7 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r8 = removeEntry$okhttp(r7);     // Catch: Throwable -> L15
        if (r8 == true) goto L11;
    L13:
        monitor-exit(this);
        return r8;
    L11:
        if (this.size > this.maxSize) goto L13;
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean removeEntry$okhttp(Entry r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "entry");
        if (this.civilizedFileSystem == false) goto L5;
    L16:
        Editor r0 = r11.getCurrentEditor$okhttp();
        if (r0 == null) goto L20;
        r0.detach$okhttp();
    L20:
        int r1 = this.valueCount;
        int r4 = 0;
    L21:
        if (r4 >= r1) goto L23;
        this.fileSystem.delete(r11.getCleanFiles$okhttp().get(r4));
        this.size -= r11.getLengths$okhttp()[r4];
        r11.getLengths$okhttp()[r4] = 0;
        r4 = r4 + 1;
        goto L21
    L23:
        this.redundantOpCount++;
        BufferedSink r2 = this.journalWriter;
        if (r2 == null) goto L27;
        r2.writeUtf8(REMOVE);
        r2.writeByte(32);
        r2.writeUtf8(r11.getKey$okhttp());
        r2.writeByte(10);
    L27:
        this.lruEntries.remove(r11.getKey$okhttp());
        if (journalRebuildRequired() == false) goto L30;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
    L30:
        return true;
    L5:
        if (r11.getLockingSourceCount$okhttp() <= 0) goto L11;
        BufferedSink r3 = this.journalWriter;
        if (r3 == null) goto L11;
        r3.writeUtf8(DIRTY);
        r3.writeByte(32);
        r3.writeUtf8(r11.getKey$okhttp());
        r3.writeByte(10);
        r3.flush();
    L11:
        if (r11.getLockingSourceCount$okhttp() <= 0) goto L13;
    L14:
        r11.setZombie$okhttp(true);
        return true;
    L13:
        if (r11.getCurrentEditor$okhttp() == null) goto L16;
        goto L14
    }

    private final synchronized void checkNotClosed() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((!this.closed) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("cache is closed".toString());     // Catch: Throwable -> L10
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        checkNotClosed();     // Catch: Throwable -> L10
        trimToSize();     // Catch: Throwable -> L10
        BufferedSink r0 = this.journalWriter;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L10
        r0.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r0 = this.closed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L6;
    L23:
        this.closed = true;     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L6:
        if (this.closed == true) goto L23;
        Collection<Entry> r0 = this.lruEntries.values();     // Catch: Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r0, "lruEntries.values");     // Catch: Throwable -> L26
        int r2 = 0;
        Object[] r1 = r0.toArray(new Entry[0]);     // Catch: Throwable -> L26
        if (r1 == null) goto L22;
        Entry[] r3 = (Entry[]) r1;     // Catch: Throwable -> L26
        int r4 = r3.length;     // Catch: Throwable -> L26
    L11:
        if (r2 >= r4) goto L18;
        Entry r5 = r3[r2];     // Catch: Throwable -> L26
        r2 = r2 + 1;     // Catch: Throwable -> L26
        if (r5.getCurrentEditor$okhttp() == null) goto L11;
        Editor r6 = r5.getCurrentEditor$okhttp();     // Catch: Throwable -> L26
        if (r6 == null) goto L11;
        r6.detach$okhttp();     // Catch: Throwable -> L26
        goto L11
    L18:
        trimToSize();     // Catch: Throwable -> L26
        BufferedSink r7 = this.journalWriter;     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L26
        r7.close();     // Catch: Throwable -> L26
        this.journalWriter = null;     // Catch: Throwable -> L26
        this.closed = true;     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L26
    }

    public final void trimToSize() throws IOException {
    L3:
        if (this.size <= this.maxSize) goto L7;
        if (removeOldestEntry() == true) goto L3;
        return;
    L7:
        this.mostRecentTrimFailed = false;
    }

    private final boolean removeOldestEntry() {
        Iterator<Entry> r0 = this.lruEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Entry r1 = r0.next();
        if (r1.getZombie$okhttp() == true) goto L4;
        Intrinsics.checkNotNullExpressionValue(r1, "toEvict");
        removeEntry$okhttp(r1);
        return true;
    L9:
        return false;
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final synchronized void evictAll() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L13
        Collection<Entry> r0 = this.lruEntries.values();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r0, "lruEntries.values");     // Catch: Throwable -> L13
        Object[] r1 = r0.toArray(new Entry[0]);     // Catch: Throwable -> L13
        if (r1 == null) goto L12;
        Entry[] r2 = (Entry[]) r1;     // Catch: Throwable -> L13
        int r3 = r2.length;     // Catch: Throwable -> L13
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        Entry r5 = r2[r4];     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r5, "entry");     // Catch: Throwable -> L13
        removeEntry$okhttp(r5);     // Catch: Throwable -> L13
        goto L6
    L8:
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private final void validateKey(String r2) {
        if (LEGAL_KEY_PATTERN.matches(r2) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + r2 + '\"').toString());
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        AnonymousClass1 r0 = new AnonymousClass1(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        Companion = new Companion(null);
        JOURNAL_FILE = coil.disk.DiskLruCache.JOURNAL_FILE;
        JOURNAL_FILE_TEMP = coil.disk.DiskLruCache.JOURNAL_FILE_TMP;
        JOURNAL_FILE_BACKUP = coil.disk.DiskLruCache.JOURNAL_FILE_BACKUP;
        MAGIC = coil.disk.DiskLruCache.MAGIC;
        VERSION_1 = "1";
        ANY_SEQUENCE_NUMBER = -1;
        LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
        CLEAN = "CLEAN";
        DIRTY = "DIRTY";
        REMOVE = "REMOVE";
        READ = "READ";
    }

    public final synchronized void initialize() throws IOException {
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L5:
        if (Util.assertionsEnabled == false) goto L12;
        if (Thread.holdsLock(this) == true) goto L12;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);     // Catch: Throwable -> L38
    L12:
        if (this.initialized == false) goto L16;
        monitor-exit(this);
        return;
    L16:
        if (this.fileSystem.exists(this.journalFileBackup) == true) goto L18;
    L21:
        this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);     // Catch: Throwable -> L38
        if (this.fileSystem.exists(this.journalFile) == true) goto L44;
    L35:
        rebuildJournal$okhttp();     // Catch: Throwable -> L38
        this.initialized = true;     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L44:
        readJournal();     // Catch: IOException -> L27 Throwable -> L38
        processJournal();     // Catch: IOException -> L27 Throwable -> L38
        this.initialized = true;     // Catch: IOException -> L27 Throwable -> L38
        monitor-exit(this);
        return;
    L27:
        e = move-exception;
        Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);     // Catch: Throwable -> L38
        delete();     // Catch: Throwable -> L32
        this.closed = false;     // Catch: Throwable -> L38
        goto L35
    L32:
        th = move-exception;
        this.closed = false;     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L18:
        if (this.fileSystem.exists(this.journalFile) == false) goto L20;
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L38
        goto L21
    L20:
        this.fileSystem.rename(this.journalFileBackup, this.journalFile);     // Catch: Throwable -> L38
        goto L21
    }
}
