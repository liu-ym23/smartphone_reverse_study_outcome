package coil.disk;

import coil.util.FileSystems;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.constant.PerfConsts;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* JADX INFO: compiled from: DiskLruCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u0014\b\u0000\u0018\u0000 C2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004CDEFB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0016J\u001c\u0010)\u001a\u00020'2\n\u0010*\u001a\u00060+R\u00020\u00002\u0006\u0010,\u001a\u00020\u0013H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u0014\u0010.\u001a\b\u0018\u00010+R\u00020\u00002\u0006\u0010/\u001a\u00020\u001fJ\u0006\u00100\u001a\u00020'J\b\u00101\u001a\u00020'H\u0016J\u0017\u00102\u001a\b\u0018\u000103R\u00020\u00002\u0006\u0010/\u001a\u00020\u001fH\u0086\u0002J\u0006\u00104\u001a\u00020'J\b\u00105\u001a\u00020\u0013H\u0002J\b\u00106\u001a\u00020'H\u0002J\b\u00107\u001a\u00020\u001cH\u0002J\b\u00108\u001a\u00020'H\u0002J\b\u00109\u001a\u00020'H\u0002J\u0010\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020\u001fH\u0002J\u000e\u0010<\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u001fJ\u0014\u0010=\u001a\u00020\u00132\n\u0010>\u001a\u00060 R\u00020\u0000H\u0002J\b\u0010?\u001a\u00020\u0013H\u0002J\u0006\u0010%\u001a\u00020\u000bJ\b\u0010@\u001a\u00020'H\u0002J\u0010\u0010A\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020'H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u001f\u0012\b\u0012\u00060 R\u00020\u00000\u001ej\u0012\u0012\u0004\u0012\u00020\u001f\u0012\b\u0012\u00060 R\u00020\u0000`!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcoil/disk/DiskLruCache;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokio/FileSystem;", "directory", "Lokio/Path;", "cleanupDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "maxSize", "", "appVersion", "", "valueCount", "(Lokio/FileSystem;Lokio/Path;Lkotlinx/coroutines/CoroutineDispatcher;JII)V", "cleanupScope", "Lkotlinx/coroutines/CoroutineScope;", "closed", "", "coil/disk/DiskLruCache$fileSystem$1", "Lcoil/disk/DiskLruCache$fileSystem$1;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lcoil/disk/DiskLruCache$Entry;", "Lkotlin/collections/LinkedHashMap;", "mostRecentRebuildFailed", "mostRecentTrimFailed", "operationsSinceRewrite", PerfConsts.PERF_DISK_FILE_SIZE, "checkNotClosed", "", "close", "completeEdit", "editor", "Lcoil/disk/DiskLruCache$Editor;", "success", "delete", "edit", "key", "evictAll", "flush", "get", "Lcoil/disk/DiskLruCache$Snapshot;", "initialize", "journalRewriteRequired", "launchCleanup", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "remove", "removeEntry", "entry", "removeOldestEntry", "trimToSize", "validateKey", "writeJournal", "Companion", "Editor", "Entry", "Snapshot", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiskLruCache implements Closeable, Flushable {
    private static final String CLEAN = "CLEAN";
    public static final Companion Companion = null;
    private static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TMP = "journal.tmp";
    private static final Regex LEGAL_KEY_PATTERN = null;
    public static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    public static final String VERSION = "1";
    private final int appVersion;
    private final CoroutineScope cleanupScope;
    private boolean closed;
    private final Path directory;
    private final DiskLruCache$fileSystem$1 fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private final long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private int operationsSinceRewrite;
    private long size;
    private final int valueCount;

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcoil/disk/DiskLruCache$Companion;", "", "()V", DiskLruCache.CLEAN, "", DiskLruCache.DIRTY, "JOURNAL_FILE", "getJOURNAL_FILE$coil_base_release$annotations", "JOURNAL_FILE_BACKUP", "getJOURNAL_FILE_BACKUP$coil_base_release$annotations", "JOURNAL_FILE_TMP", "getJOURNAL_FILE_TMP$coil_base_release$annotations", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "getMAGIC$coil_base_release$annotations", DiskLruCache.READ, DiskLruCache.REMOVE, VCardConstants.PROPERTY_VERSION, "getVERSION$coil_base_release$annotations", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getJOURNAL_FILE$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getJOURNAL_FILE_BACKUP$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getJOURNAL_FILE_TMP$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getMAGIC$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getVERSION$coil_base_release$annotations() {
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcoil/disk/DiskLruCache$Editor;", "", "entry", "Lcoil/disk/DiskLruCache$Entry;", "Lcoil/disk/DiskLruCache;", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$Entry;)V", "closed", "", "getEntry", "()Lcoil/disk/DiskLruCache$Entry;", "written", "", "getWritten", "()[Z", "abort", "", "commit", "commitAndGet", "Lcoil/disk/DiskLruCache$Snapshot;", "complete", "success", "detach", "file", "Lokio/Path;", "index", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Editor {
        private boolean closed;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache r1, Entry r2) {
            this.this$0 = r1;
            this.entry = r2;
            this.written = new boolean[DiskLruCache.access$getValueCount$p(r1)];
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final boolean[] getWritten() {
            return this.written;
        }

        public final Path file(int r4) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if ((!this.closed) == false) goto L10;
            this.written[r4] = true;     // Catch: Throwable -> L11
            Path r3 = this.entry.getDirtyFiles().get(r4);     // Catch: Throwable -> L11
            FileSystems.createFile(DiskLruCache.access$getFileSystem$p(r0), r3);     // Catch: Throwable -> L11
            Path r5 = r3;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return r5;
        L10:
            throw new IllegalStateException("editor is closed".toString());     // Catch: Throwable -> L11
        }

        public final void detach() {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this) == false) goto L6;
            this.entry.setZombie(true);
            return;
        }

        public final void commit() {
            complete(true);
        }

        public final Snapshot commitAndGet() {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
            commit();     // Catch: Throwable -> L7
            Snapshot r1 = r0.get(this.entry.getKey());     // Catch: Throwable -> L7
            monitor-exit(r0);
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public final void abort() {
            complete(false);
        }

        private final void complete(boolean r4) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if ((!this.closed) == false) goto L13;
            if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this) == false) goto L9;
            DiskLruCache.access$completeEdit(r0, this, r4);     // Catch: Throwable -> L14
        L9:
            this.closed = true;     // Catch: Throwable -> L14
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r0);
            return;
        L13:
            throw new IllegalStateException("editor is closed".toString());     // Catch: Throwable -> L14
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030,J\f\u0010-\u001a\b\u0018\u00010.R\u00020\rJ\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0018\u00010\fR\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u00062"}, d2 = {"Lcoil/disk/DiskLruCache$Entry;", "", "key", "", "(Lcoil/disk/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "Ljava/util/ArrayList;", "Lokio/Path;", "Lkotlin/collections/ArrayList;", "getCleanFiles", "()Ljava/util/ArrayList;", "currentEditor", "Lcoil/disk/DiskLruCache$Editor;", "Lcoil/disk/DiskLruCache;", "getCurrentEditor", "()Lcoil/disk/DiskLruCache$Editor;", "setCurrentEditor", "(Lcoil/disk/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles", "getKey", "()Ljava/lang/String;", "lengths", "", "getLengths", "()[J", "lockingSnapshotCount", "", "getLockingSnapshotCount", "()I", "setLockingSnapshotCount", "(I)V", "readable", "", "getReadable", "()Z", "setReadable", "(Z)V", "zombie", "getZombie", "setZombie", "setLengths", "", "strings", "", "snapshot", "Lcoil/disk/DiskLruCache$Snapshot;", "writeLengths", "writer", "Lokio/BufferedSink;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Entry {
        private final ArrayList<Path> cleanFiles;
        private Editor currentEditor;
        private final ArrayList<Path> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSnapshotCount;
        private boolean readable;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache r6, String r7) {
            this.this$0 = r6;
            this.key = r7;
            this.lengths = new long[DiskLruCache.access$getValueCount$p(r6)];
            this.cleanFiles = new ArrayList(DiskLruCache.access$getValueCount$p(r6));
            this.dirtyFiles = new ArrayList(DiskLruCache.access$getValueCount$p(r6));
            StringBuilder r8 = new StringBuilder(r7).append('.');
            int r0 = r8.length();
            int r9 = DiskLruCache.access$getValueCount$p(r6);
            int r1 = 0;
        L3:
            if (r1 >= r9) goto L5;
            r8.append(r1);
            this.cleanFiles.add(DiskLruCache.access$getDirectory$p(this.this$0).resolve(r8.toString()));
            r8.append(".tmp");
            this.dirtyFiles.add(DiskLruCache.access$getDirectory$p(this.this$0).resolve(r8.toString()));
            r8.setLength(r0);
            r1 = r1 + 1;
            goto L3
        }

        public final String getKey() {
            return this.key;
        }

        public final long[] getLengths() {
            return this.lengths;
        }

        public final ArrayList<Path> getCleanFiles() {
            return this.cleanFiles;
        }

        public final ArrayList<Path> getDirtyFiles() {
            return this.dirtyFiles;
        }

        public final boolean getReadable() {
            return this.readable;
        }

        public final void setReadable(boolean r1) {
            this.readable = r1;
        }

        public final boolean getZombie() {
            return this.zombie;
        }

        public final void setZombie(boolean r1) {
            this.zombie = r1;
        }

        public final Editor getCurrentEditor() {
            return this.currentEditor;
        }

        public final void setCurrentEditor(Editor r1) {
            this.currentEditor = r1;
        }

        public final int getLockingSnapshotCount() {
            return this.lockingSnapshotCount;
        }

        public final void setLockingSnapshotCount(int r1) {
            this.lockingSnapshotCount = r1;
        }

        public final void setLengths(List<String> r7) {
            if (r7.size() != DiskLruCache.access$getValueCount$p(this.this$0)) goto L12;
            int r0 = r7.size();     // Catch: NumberFormatException -> L9
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L8;
            this.lengths[r1] = Long.parseLong(r7.get(r1));     // Catch: NumberFormatException -> L9
            r1 = r1 + 1;
            goto L5
        L8:
            return;
        L10:
            throw new IOException("unexpected journal line: " + r7);
        L12:
            throw new IOException("unexpected journal line: " + r7);
        }

        public final void writeLengths(BufferedSink r6) {
            long[] r5 = this.lengths;
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            long r2 = r5[r1];
            r6.writeByte(32).writeDecimalLong(r2);
            r1 = r1 + 1;
            goto L3
        }

        public final Snapshot snapshot() {
            if (this.readable == true) goto L6;
            return null;
        L6:
            if (this.currentEditor == null) goto L8;
        L19:
            return null;
        L8:
            if (this.zombie == true) goto L19;
            ArrayList<Path> r0 = this.cleanFiles;
            DiskLruCache r2 = this.this$0;
            int r3 = r0.size();
            int r4 = 0;
        L11:
            if (r4 >= r3) goto L17;
            if (DiskLruCache.access$getFileSystem$p(r2).exists(r0.get(r4)) == false) goto L21;
            r4 = r4 + 1;
            goto L11
        L21:
            DiskLruCache.access$removeEntry(r2, this);     // Catch: IOException -> L20
        L15:
            return null;
        L17:
            this.lockingSnapshotCount++;
            return new Snapshot(this.this$0, this);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0004R\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\f\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0003\u001a\u00060\u0004R\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcoil/disk/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "Lokio/Closeable;", "entry", "Lcoil/disk/DiskLruCache$Entry;", "Lcoil/disk/DiskLruCache;", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$Entry;)V", "closed", "", "getEntry", "()Lcoil/disk/DiskLruCache$Entry;", "close", "", "closeAndEdit", "Lcoil/disk/DiskLruCache$Editor;", "file", "Lokio/Path;", "index", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Snapshot implements Closeable {
        private boolean closed;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache r1, Entry r2) {
            this.this$0 = r1;
            this.entry = r2;
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final Path file(int r2) {
            if ((!this.closed) == false) goto L7;
            return this.entry.getCleanFiles().get(r2);
        L7:
            throw new IllegalStateException("snapshot is closed".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == true) goto L17;
            this.closed = true;
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
            Entry r1 = this.entry;     // Catch: Throwable -> L14
            r1.setLockingSnapshotCount(r1.getLockingSnapshotCount() - 1);     // Catch: Throwable -> L14
            if (this.entry.getLockingSnapshotCount() == 0) goto L9;
        L11:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r0);
            return;
        L9:
            if (this.entry.getZombie() == false) goto L11;
            DiskLruCache.access$removeEntry(r0, this.entry);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public final Editor closeAndEdit() {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
            close();     // Catch: Throwable -> L7
            Editor r1 = r0.edit(this.entry.getKey());     // Catch: Throwable -> L7
            monitor-exit(r0);
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: coil.disk.DiskLruCache$launchCleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.disk.DiskLruCache$launchCleanup$1", f = "DiskLruCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DiskLruCache this$0;

        AnonymousClass1(DiskLruCache r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L31;
            ResultKt.throwOnFailure(r2);
            DiskLruCache r1 = this.this$0;
            monitor-enter(r1);
        L27:
            th = move-exception;
            throw th;
        L7:
            if (DiskLruCache.access$getInitialized$p(r1) == true) goto L9;
        L24:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L27
            monitor-exit(r1);
            return r3;
        L9:
            if (DiskLruCache.access$getClosed$p(r1) == true) goto L24;
            DiskLruCache.access$trimToSize(r1);     // Catch: IOException -> L14 Throwable -> L27
        L35:
        L19:
            DiskLruCache.access$setMostRecentRebuildFailed$p(r1, true);     // Catch: Throwable -> L27
            DiskLruCache.access$setJournalWriter$p(r1, Okio.buffer(Okio.blackhole()));     // Catch: Throwable -> L27
        L20:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L27
            monitor-exit(r1);
            return Unit.INSTANCE;
        L16:
            if (DiskLruCache.access$journalRewriteRequired(r1) == false) goto L20;
            DiskLruCache.access$writeJournal(r1);     // Catch: IOException -> L19 Throwable -> L27
        L14:
            DiskLruCache.access$setMostRecentTrimFailed$p(r1, true);     // Catch: Throwable -> L27
            goto L35
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [coil.disk.DiskLruCache$fileSystem$1] */
    public DiskLruCache(final FileSystem r3, Path r4, CoroutineDispatcher r5, long r6, int r8, int r9) {
        this.directory = r4;
        this.maxSize = r6;
        this.appVersion = r8;
        this.valueCount = r9;
        if (r6 <= 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L16;
        if (r9 <= 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L14;
        this.journalFile = r4.resolve(JOURNAL_FILE);
        this.journalFileTmp = r4.resolve(JOURNAL_FILE_TMP);
        this.journalFileBackup = r4.resolve(JOURNAL_FILE_BACKUP);
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r5.limitedParallelism(1)));
        this.fileSystem = new DiskLruCache$fileSystem$1(r3);
        return;
    L14:
        throw new IllegalArgumentException("valueCount <= 0".toString());
    L9:
        r10 = false;
        goto L10
    L16:
        throw new IllegalArgumentException("maxSize <= 0".toString());
    L5:
        r7 = false;
        goto L6
    }

    public static final /* synthetic */ void access$completeEdit(DiskLruCache r0, Editor r1, boolean r2) {
        r0.completeEdit(r1, r2);
    }

    public static final /* synthetic */ boolean access$getClosed$p(DiskLruCache r0) {
        return r0.closed;
    }

    public static final /* synthetic */ Path access$getDirectory$p(DiskLruCache r0) {
        return r0.directory;
    }

    public static final /* synthetic */ DiskLruCache$fileSystem$1 access$getFileSystem$p(DiskLruCache r0) {
        return r0.fileSystem;
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache r0) {
        return r0.initialized;
    }

    public static final /* synthetic */ int access$getValueCount$p(DiskLruCache r0) {
        return r0.valueCount;
    }

    public static final /* synthetic */ boolean access$journalRewriteRequired(DiskLruCache r0) {
        return r0.journalRewriteRequired();
    }

    public static final /* synthetic */ boolean access$removeEntry(DiskLruCache r0, Entry r1) {
        return r0.removeEntry(r1);
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

    public static final /* synthetic */ void access$trimToSize(DiskLruCache r0) {
        r0.trimToSize();
    }

    public static final /* synthetic */ void access$writeJournal(DiskLruCache r0) {
        r0.writeJournal();
    }

    public final synchronized void initialize() {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        delete(this.journalFileTmp);     // Catch: Throwable -> L28
        if (exists(this.journalFileBackup) == false) goto L15;
        if (exists(this.journalFile) == false) goto L12;
        delete(this.journalFileBackup);     // Catch: Throwable -> L28
        goto L15
    L12:
        atomicMove(this.journalFileBackup, this.journalFile);     // Catch: Throwable -> L28
    L15:
        if (exists(this.journalFile) == true) goto L31;
    L25:
        writeJournal();     // Catch: Throwable -> L28
        this.initialized = true;     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L31:
        readJournal();     // Catch: IOException -> L19 Throwable -> L28
        processJournal();     // Catch: IOException -> L19 Throwable -> L28
        this.initialized = true;     // Catch: IOException -> L19 Throwable -> L28
        monitor-exit(this);
        return;
    L34:
        delete();     // Catch: Throwable -> L22
        this.closed = false;     // Catch: Throwable -> L28
        goto L25
    L22:
        th = move-exception;
        this.closed = false;     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    }

    private final void readJournal() {
        BufferedSource r2 = Okio.buffer(source(this.journalFile));
        Throwable th = null;
        BufferedSource r4 = r2;     // Catch: Throwable -> L31
        String r5 = r4.readUtf8LineStrict();     // Catch: Throwable -> L31
        String r6 = r4.readUtf8LineStrict();     // Catch: Throwable -> L31
        String r7 = r4.readUtf8LineStrict();     // Catch: Throwable -> L31
        String r8 = r4.readUtf8LineStrict();     // Catch: Throwable -> L31
        String r9 = r4.readUtf8LineStrict();     // Catch: Throwable -> L31
        if (Intrinsics.areEqual(MAGIC, r5) == false) goto L30;
        if (Intrinsics.areEqual("1", r6) == false) goto L30;
        if (Intrinsics.areEqual(String.valueOf(this.appVersion), r7) == false) goto L30;
        if (Intrinsics.areEqual(String.valueOf(this.valueCount), r8) == false) goto L30;
        int r11 = 0;
        if (r9.length() <= 0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == true) goto L30;
    L44:
        readJournalLine(r4.readUtf8LineStrict());     // Catch: EOFException -> L19 Throwable -> L31
        r11 = r11 + 1;
        goto L44
    L19:
        this.operationsSinceRewrite = r11 - this.lruEntries.size();     // Catch: Throwable -> L31
        if (r4.exhausted() == true) goto L22;
        writeJournal();     // Catch: Throwable -> L31
    L23:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L31
        if (r2 != null) goto L47;
    L38:
        if (th != null) goto L41;
        Intrinsics.checkNotNull(r13);
        return;
    L41:
        throw th;
    L47:
        r2.close();     // Catch: Throwable -> L27
    L27:
        th = th;
        goto L38
    L22:
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L31
        goto L23
    L15:
        r10 = false;
    L30:
        throw new IOException("unexpected journal header: [" + r5 + ", " + r6 + ", " + r7 + ", " + r8 + ", " + r9 + ']');     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r2 != null) goto L42;
    L37:
        th = th;
        r13 = null;
        goto L38
    L42:
        r2.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L37
    }

    private final BufferedSink newJournalWriter() {
        return Okio.buffer(new FaultHidingSink(appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void readJournalLine(String r20) {
        String r8 = r20;
        int r9 = StringsKt.indexOf$default(r8, TokenParser.SP, 0, false, 6, null);
        if (r9 == (-1)) goto L36;
        int r12 = r9 + 1;
        int r2 = StringsKt.indexOf$default(r8, TokenParser.SP, r12, false, 4, null);
        if (r2 != (-1)) goto L12;
        String r7 = r20.substring(r12);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).substring(startIndex)");
        if (r9 == 6) goto L9;
    L13:
        LinkedHashMap<String, Entry> r10 = this.lruEntries;
        Entry r13 = r10.get(r7);
        if (r13 != null) goto L16;
        r13 = new Entry(this, r7);
        r10.put(r7, r13);
    L16:
        Entry r14 = r13;
        if (r2 == (-1)) goto L22;
        if (r9 != 5) goto L22;
        if (StringsKt.startsWith$default(r20, CLEAN, false, 2, null) == false) goto L22;
        String r1 = r20.substring(r2 + 1);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).substring(startIndex)");
        List<String> r3 = StringsKt.split$default(r1, new char[]{TokenParser.SP}, false, 0, 6, null);
        r14.setReadable(true);
        r14.setCurrentEditor(null);
        r14.setLengths(r3);
        return;
    L22:
        if (r2 != (-1)) goto L27;
        if (r9 != 5) goto L27;
        if (StringsKt.startsWith$default(r20, DIRTY, false, 2, null) == false) goto L27;
        r14.setCurrentEditor(new Editor(this, r14));
        return;
    L27:
        if (r2 != (-1)) goto L34;
        if (r9 != 4) goto L34;
        if (StringsKt.startsWith$default(r20, READ, false, 2, null) == false) goto L34;
        return;
    L34:
        throw new IOException("unexpected journal line: " + r20);
    L9:
        if (StringsKt.startsWith$default(r20, REMOVE, false, 2, null) == false) goto L13;
        this.lruEntries.remove(r7);
        return;
    L12:
        r7 = r20.substring(r12, r2);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String…ing(startIndex, endIndex)");
        goto L13
    L36:
        throw new IOException("unexpected journal line: " + r20);
    }

    private final void processJournal() {
        Iterator<Entry> r0 = this.lruEntries.values().iterator();
        long r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L14;
        Entry r3 = r0.next();
        int r5 = 0;
        if (r3.getCurrentEditor() == null) goto L7;
        r3.setCurrentEditor(null);
        int r4 = this.valueCount;
    L11:
        if (r5 >= r4) goto L13;
        delete(r3.getCleanFiles().get(r5));
        delete(r3.getDirtyFiles().get(r5));
        r5 = r5 + 1;
        goto L11
    L13:
        r0.remove();
        goto L4
    L7:
        int r6 = this.valueCount;
    L8:
        if (r5 >= r6) goto L4;
        r1 = r1 + r3.getLengths()[r5];
        r5 = r5 + 1;
        goto L8
    L14:
        this.size = r1;
    }

    private final synchronized void writeJournal() {
        monitor-enter(this);
        BufferedSink r0 = this.journalWriter;     // Catch: Throwable -> L37
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L37
    L6:
        BufferedSink r1 = Okio.buffer(sink(this.journalFileTmp, false));     // Catch: Throwable -> L37
        Throwable th = null;
        BufferedSink r3 = r1;     // Catch: Throwable -> L21
        r3.writeUtf8(MAGIC).writeByte(10);     // Catch: Throwable -> L21
        r3.writeUtf8("1").writeByte(10);     // Catch: Throwable -> L21
        r3.writeDecimalLong(this.appVersion).writeByte(10);     // Catch: Throwable -> L21
        r3.writeDecimalLong(this.valueCount).writeByte(10);     // Catch: Throwable -> L21
        r3.writeByte(10);     // Catch: Throwable -> L21
        Iterator<Entry> r4 = this.lruEntries.values().iterator();     // Catch: Throwable -> L21
    L10:
        if (r4.hasNext() == false) goto L15;
        Entry r6 = r4.next();     // Catch: Throwable -> L21
        if (r6.getCurrentEditor() != null) goto L13;
        r3.writeUtf8(CLEAN);     // Catch: Throwable -> L21
        r3.writeByte(32);     // Catch: Throwable -> L21
        r3.writeUtf8(r6.getKey());     // Catch: Throwable -> L21
        r6.writeLengths(r3);     // Catch: Throwable -> L21
        r3.writeByte(10);     // Catch: Throwable -> L21
        goto L10
    L13:
        r3.writeUtf8(DIRTY);     // Catch: Throwable -> L21
        r3.writeByte(32);     // Catch: Throwable -> L21
        r3.writeUtf8(r6.getKey());     // Catch: Throwable -> L21
        r3.writeByte(10);     // Catch: Throwable -> L21
        goto L10
    L15:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L21
        if (r1 != null) goto L42;
    L28:
        if (th != null) goto L36;
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L37
        if (exists(this.journalFile) == false) goto L32;
        atomicMove(this.journalFile, this.journalFileBackup);     // Catch: Throwable -> L37
        atomicMove(this.journalFileTmp, this.journalFile);     // Catch: Throwable -> L37
        delete(this.journalFileBackup);     // Catch: Throwable -> L37
    L33:
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L37
        this.operationsSinceRewrite = 0;     // Catch: Throwable -> L37
        this.hasJournalErrors = false;     // Catch: Throwable -> L37
        this.mostRecentRebuildFailed = false;     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L32:
        atomicMove(this.journalFileTmp, this.journalFile);     // Catch: Throwable -> L37
        goto L33
    L36:
        throw th;     // Catch: Throwable -> L37
    L42:
        r1.close();     // Catch: Throwable -> L19
    L19:
        th = th;
        goto L28
    L21:
        th = move-exception;
        if (r1 != null) goto L40;
    L27:
        r5 = null;
        th = th;
        goto L28
    L40:
        r1.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    public final synchronized Snapshot get(String r4) {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L16
        validateKey(r4);     // Catch: Throwable -> L16
        initialize();     // Catch: Throwable -> L16
        Entry r0 = this.lruEntries.get(r4);     // Catch: Throwable -> L16
        if (r0 == null) goto L13;
        Snapshot r1 = r0.snapshot();     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        this.operationsSinceRewrite++;     // Catch: Throwable -> L16
        BufferedSink r2 = this.journalWriter;     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L16
        r2.writeUtf8(READ);     // Catch: Throwable -> L16
        r2.writeByte(32);     // Catch: Throwable -> L16
        r2.writeUtf8(r4);     // Catch: Throwable -> L16
        r2.writeByte(10);     // Catch: Throwable -> L16
        if (journalRewriteRequired() == false) goto L11;
        launchCleanup();     // Catch: Throwable -> L16
    L11:
        monitor-exit(this);
        return r1;
    L13:
        monitor-exit(this);
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized Editor edit(String r5) {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L33
        validateKey(r5);     // Catch: Throwable -> L33
        initialize();     // Catch: Throwable -> L33
        Entry r0 = this.lruEntries.get(r5);     // Catch: Throwable -> L33
        if (r0 == null) goto L7;
        Editor r2 = r0.getCurrentEditor();     // Catch: Throwable -> L33
    L8:
        if (r2 == null) goto L11;
        monitor-exit(this);
        return null;
    L11:
        if (r0 == null) goto L17;
        if (r0.getLockingSnapshotCount() == 0) goto L17;
        monitor-exit(this);
        return null;
    L17:
        if (this.mostRecentTrimFailed == false) goto L19;
    L30:
        launchCleanup();     // Catch: Throwable -> L33
        monitor-exit(this);
        return null;
    L19:
        if (this.mostRecentRebuildFailed == true) goto L30;
        BufferedSink r3 = this.journalWriter;     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L33
        r3.writeUtf8(DIRTY);     // Catch: Throwable -> L33
        r3.writeByte(32);     // Catch: Throwable -> L33
        r3.writeUtf8(r5);     // Catch: Throwable -> L33
        r3.writeByte(10);     // Catch: Throwable -> L33
        r3.flush();     // Catch: Throwable -> L33
        if (this.hasJournalErrors == false) goto L25;
        monitor-exit(this);
        return null;
    L25:
        if (r0 != null) goto L27;
        r0 = new Entry(this, r5);     // Catch: Throwable -> L33
        this.lruEntries.put(r5, r0);     // Catch: Throwable -> L33
    L27:
        Editor r6 = new Editor(this, r0);     // Catch: Throwable -> L33
        r0.setCurrentEditor(r6);     // Catch: Throwable -> L33
        monitor-exit(this);
        return r6;
    L7:
        r2 = null;
    L33:
        th = move-exception;
        throw th;
    }

    public final synchronized long size() {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        long r0 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private final synchronized void completeEdit(Editor r9, boolean r10) {
        monitor-enter(this);
        Entry r0 = r9.getEntry();     // Catch: Throwable -> L54
        if (Intrinsics.areEqual(r0.getCurrentEditor(), r9) == false) goto L53;
        int r1 = 0;
        if (r10 == true) goto L8;
    L30:
        int r11 = this.valueCount;     // Catch: Throwable -> L54
    L31:
        if (r1 >= r11) goto L33;
        delete(r0.getDirtyFiles().get(r1));     // Catch: Throwable -> L54
        r1 = r1 + 1;     // Catch: Throwable -> L54
    L33:
        r0.setCurrentEditor(null);     // Catch: Throwable -> L54
        if (r0.getZombie() == false) goto L38;
        removeEntry(r0);     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L38:
        this.operationsSinceRewrite++;     // Catch: Throwable -> L54
        BufferedSink r12 = this.journalWriter;     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L54
        if (r10 == false) goto L41;
    L44:
        r0.setReadable(true);     // Catch: Throwable -> L54
        r12.writeUtf8(CLEAN);     // Catch: Throwable -> L54
        r12.writeByte(32);     // Catch: Throwable -> L54
        r12.writeUtf8(r0.getKey());     // Catch: Throwable -> L54
        r0.writeLengths(r12);     // Catch: Throwable -> L54
        r12.writeByte(10);     // Catch: Throwable -> L54
    L45:
        r12.flush();     // Catch: Throwable -> L54
        if (this.size <= this.maxSize) goto L48;
    L49:
        launchCleanup();     // Catch: Throwable -> L54
    L50:
        monitor-exit(this);
        return;
    L48:
        if (journalRewriteRequired() == false) goto L50;
    L41:
        if (r0.getReadable() == true) goto L44;
        this.lruEntries.remove(r0.getKey());     // Catch: Throwable -> L54
        r12.writeUtf8(REMOVE);     // Catch: Throwable -> L54
        r12.writeByte(32);     // Catch: Throwable -> L54
        r12.writeUtf8(r0.getKey());     // Catch: Throwable -> L54
        r12.writeByte(10);     // Catch: Throwable -> L54
        goto L45
    L8:
        if (r0.getZombie() == true) goto L30;
        int r2 = this.valueCount;     // Catch: Throwable -> L54
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L19;
        if (r9.getWritten()[r3] == false) goto L18;
        if (exists(r0.getDirtyFiles().get(r3)) == true) goto L18;
        r9.abort();     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L18:
        r3 = r3 + 1;
        goto L10
    L19:
        int r13 = this.valueCount;     // Catch: Throwable -> L54
    L20:
        if (r1 >= r13) goto L33;
        Path r4 = r0.getDirtyFiles().get(r1);     // Catch: Throwable -> L54
        Path r5 = r0.getCleanFiles().get(r1);     // Catch: Throwable -> L54
        if (exists(r4) == false) goto L24;
        atomicMove(r4, r5);     // Catch: Throwable -> L54
    L25:
        long r6 = r0.getLengths()[r1];     // Catch: Throwable -> L54
        Long r7 = metadata(r5).getSize();     // Catch: Throwable -> L54
        if (r7 == null) goto L28;
        long r8 = r7.longValue();     // Catch: Throwable -> L54
    L29:
        r0.getLengths()[r1] = r8;     // Catch: Throwable -> L54
        this.size = (this.size - r6) + r8;     // Catch: Throwable -> L54
        r1 = r1 + 1;     // Catch: Throwable -> L54
        goto L20
    L28:
        r8 = 0;
        goto L29
    L24:
        FileSystems.createFile(this.fileSystem, r0.getCleanFiles().get(r1));     // Catch: Throwable -> L54
        goto L25
    L53:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    }

    private final boolean journalRewriteRequired() {
        if (this.operationsSinceRewrite < 2000) goto L5;
        return true;
    L5:
        return false;
    }

    public final synchronized boolean remove(String r6) {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L15
        validateKey(r6);     // Catch: Throwable -> L15
        initialize();     // Catch: Throwable -> L15
        Entry r7 = this.lruEntries.get(r6);     // Catch: Throwable -> L15
        if (r7 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r8 = removeEntry(r7);     // Catch: Throwable -> L15
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

    private final boolean removeEntry(Entry r10) {
        if (r10.getLockingSnapshotCount() <= 0) goto L8;
        BufferedSink r0 = this.journalWriter;
        if (r0 == null) goto L8;
        r0.writeUtf8(DIRTY);
        r0.writeByte(32);
        r0.writeUtf8(r10.getKey());
        r0.writeByte(10);
        r0.flush();
    L8:
        if (r10.getLockingSnapshotCount() <= 0) goto L10;
    L22:
        r10.setZombie(true);
        return true;
    L10:
        if (r10.getCurrentEditor() != null) goto L22;
        int r1 = this.valueCount;
        int r4 = 0;
    L13:
        if (r4 >= r1) goto L15;
        delete(r10.getCleanFiles().get(r4));
        this.size -= r10.getLengths()[r4];
        r10.getLengths()[r4] = 0;
        r4 = r4 + 1;
        goto L13
    L15:
        this.operationsSinceRewrite++;
        BufferedSink r2 = this.journalWriter;
        if (r2 == null) goto L18;
        r2.writeUtf8(REMOVE);
        r2.writeByte(32);
        r2.writeUtf8(r10.getKey());
        r2.writeByte(10);
    L18:
        this.lruEntries.remove(r10.getKey());
        if (journalRewriteRequired() == false) goto L21;
        launchCleanup();
    L21:
        return true;
    }

    private final void checkNotClosed() {
        if ((!this.closed) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed".toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L6;
    L17:
        this.closed = true;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L6:
        if (this.closed == true) goto L17;
        int r2 = 0;
        Entry[] r0 = (Entry[]) this.lruEntries.values().toArray(new Entry[0]);     // Catch: Throwable -> L20
        int r3 = r0.length;     // Catch: Throwable -> L20
    L9:
        if (r2 >= r3) goto L14;
        Editor r4 = r0[r2].getCurrentEditor();     // Catch: Throwable -> L20
        if (r4 == null) goto L13;
        r4.detach();     // Catch: Throwable -> L20
    L13:
        r2 = r2 + 1;     // Catch: Throwable -> L20
        goto L9
    L14:
        trimToSize();     // Catch: Throwable -> L20
        CoroutineScopeKt.cancel$default(this.cleanupScope, null, 1, null);     // Catch: Throwable -> L20
        BufferedSink r1 = this.journalWriter;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L20
        r1.close();     // Catch: Throwable -> L20
        this.journalWriter = null;     // Catch: Throwable -> L20
        this.closed = true;     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
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

    private final void trimToSize() {
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
        if (r1.getZombie() == true) goto L4;
        removeEntry(r1);
        return true;
    L9:
        return false;
    }

    private final void delete() {
        close();
        FileSystems.deleteContents(this.fileSystem, this.directory);
    }

    public final synchronized void evictAll() {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L9
        Entry[] r0 = (Entry[]) this.lruEntries.values().toArray(new Entry[0]);     // Catch: Throwable -> L9
        int r2 = r0.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L6;
        removeEntry(r0[r3]);     // Catch: Throwable -> L9
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final void launchCleanup() {
        BuildersKt.launch$default(this.cleanupScope, null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void validateKey(String r2) {
        if (LEGAL_KEY_PATTERN.matches(r2) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + r2 + '\"').toString());
    }

    static {
        Companion = new Companion(null);
        LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    }
}
