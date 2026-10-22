package okhttp3.internal.cache;

import a.a;
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
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DiskLruCache implements Closeable, Flushable {

    @JvmField
    public static final long ANY_SEQUENCE_NUMBER = 0;

    @JvmField
    @NotNull
    public static final String CLEAN = null;
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final String DIRTY = null;

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE = null;

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_BACKUP = null;

    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_TEMP = null;

    @JvmField
    @NotNull
    public static final Regex LEGAL_KEY_PATTERN = null;

    @JvmField
    @NotNull
    public static final String MAGIC = null;

    @JvmField
    @NotNull
    public static final String READ = null;

    @JvmField
    @NotNull
    public static final String REMOVE = null;

    @JvmField
    @NotNull
    public static final String VERSION_1 = null;
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;

    @NotNull
    private final File directory;

    @NotNull
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;

    @NotNull
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public final class Editor {
        private boolean done;

        @NotNull
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;

        @Nullable
        private final boolean[] written;

        public Editor(@NotNull DiskLruCache r2, Entry r3) {
            Intrinsics.f(r3, "entry");
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

        public final void abort() {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L15;
            if (Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this) == false) goto L11;
            this.this$0.completeEdit$okhttp(this, false);     // Catch: Throwable -> L9
        L11:
            this.done = true;     // Catch: Throwable -> L9
            monitor-exit(r0);
            return;
        L15:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L9
        }

        public final void commit() {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L15;
            if (Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this) == false) goto L11;
            this.this$0.completeEdit$okhttp(this, true);     // Catch: Throwable -> L9
        L11:
            this.done = true;     // Catch: Throwable -> L9
            monitor-exit(r0);
            return;
        L15:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L9
        }

        public final void detach$okhttp() {
            if (Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this) == true) goto L5;
            return;
        L5:
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L7;
            this.this$0.completeEdit$okhttp(this, false);
            return;
        L7:
            this.entry.setZombie$okhttp(true);
        }

        @NotNull
        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        @Nullable
        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        @NotNull
        public final Sink newSink(final int r5) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L25;
            if ((!Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this)) == false) goto L14;
            Sink r4 = Okio.blackhole();     // Catch: Throwable -> L11
            monitor-exit(r0);
            return r4;
        L14:
            if (this.entry.getReadable$okhttp() == true) goto L28;
            boolean[] r1 = this.written;     // Catch: Throwable -> L11
            Intrinsics.c(r1);     // Catch: Throwable -> L11
            r1[r5] = true;     // Catch: Throwable -> L11
        L28:
            FaultHidingSink r2 = new FaultHidingSink(this.this$0.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(r5)), new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, r5));     // Catch: Throwable -> L11
            monitor-exit(r0);
            return r2;
        L23:
            return Okio.blackhole();
        L25:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L11
        }

        @Nullable
        public final Source newSource(int r4) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L22;
            Source r2 = null;
            if (this.entry.getReadable$okhttp() == true) goto L9;
        L19:
            monitor-exit(r0);
            return null;
        L9:
            if ((!Intrinsics.a(this.entry.getCurrentEditor$okhttp(), this)) == true) goto L19;
            if (this.entry.getZombie$okhttp() == true) goto L19;
            r2 = this.this$0.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(r4));     // Catch: Throwable -> L15 FileNotFoundException -> L25
        L17:
            monitor-exit(r0);
            return r2;
        L22:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L15
        }
    }

    @Metadata
    public final class Entry {

        @NotNull
        private final List<File> cleanFiles;

        @Nullable
        private Editor currentEditor;

        @NotNull
        private final List<File> dirtyFiles;

        @NotNull
        private final String key;

        @NotNull
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(@NotNull DiskLruCache r8, String r9) {
            Intrinsics.f(r9, "key");
            this.this$0 = r8;
            this.key = r9;
            this.lengths = new long[r8.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder r0 = new StringBuilder(r9);
            r0.append('.');
            int r10 = r0.length();
            int r1 = r8.getValueCount$okhttp();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            r0.append(r2);
            this.cleanFiles.add(new File(r8.getDirectory(), r0.toString()));
            r0.append(".tmp");
            this.dirtyFiles.add(new File(r8.getDirectory(), r0.toString()));
            r0.setLength(r10);
            r2 = r2 + 1;
            goto L3
        }

        private final Void invalidLengths(List<String> r3) {
            throw new IOException("unexpected journal line: " + r3);
        }

        private final Source newSource(int r3) {
            final Source r4 = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(r3));
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L5;
            return r4;
        L5:
            this.lockingSourceCount++;
            return new DiskLruCache$Entry$newSource$1(this, r4, r4);
        }

        @NotNull
        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        @Nullable
        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        @NotNull
        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        @NotNull
        public final String getKey$okhttp() {
            return this.key;
        }

        @NotNull
        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(@Nullable Editor r1) {
            this.currentEditor = r1;
        }

        public final void setLengths$okhttp(@NotNull List<String> r6) {
            Intrinsics.f(r6, "strings");
            if (r6.size() == this.this$0.getValueCount$okhttp()) goto L13;
            invalidLengths(r6);
            throw new KotlinNothingValueException();
        L13:
            int r0 = r6.size();     // Catch: NumberFormatException -> L9
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L8;
            this.lengths[r1] = Long.parseLong(r6.get(r1));     // Catch: NumberFormatException -> L9
            r1 = r1 + 1;
            goto L5
        L8:
            return;
        L9:
            invalidLengths(r6);
            throw new KotlinNothingValueException();
        }

        public final void setLockingSourceCount$okhttp(int r1) {
            this.lockingSourceCount = r1;
        }

        public final void setReadable$okhttp(boolean r1) {
            this.readable = r1;
        }

        public final void setSequenceNumber$okhttp(long r1) {
            this.sequenceNumber = r1;
        }

        public final void setZombie$okhttp(boolean r1) {
            this.zombie = r1;
        }

        @Nullable
        public final Snapshot snapshot$okhttp() {
            DiskLruCache r0 = this.this$0;
            if (Util.assertionsEnabled == false) goto L10;
            if (Thread.holdsLock(r0) == true) goto L10;
            StringBuilder r1 = new StringBuilder("Thread ");
            Thread r2 = Thread.currentThread();
            Intrinsics.e(r2, "Thread.currentThread()");
            r1.append(r2.getName());
            r1.append(" MUST hold lock on ");
            r1.append(r0);
            throw new AssertionError(r1.toString());
        L10:
            if (this.readable == true) goto L13;
            return null;
        L13:
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L15;
        L19:
            ArrayList r3 = new ArrayList();
            long[] r8 = (long[]) this.lengths.clone();
            int r4 = this.this$0.getValueCount$okhttp();     // Catch: FileNotFoundException -> L25
            int r5 = 0;
        L21:
            if (r5 >= r4) goto L23;
            r3.add(newSource(r5));     // Catch: FileNotFoundException -> L25
            r5 = r5 + 1;     // Catch: FileNotFoundException -> L25
            goto L21
        L23:
            return new Snapshot(this.this$0, this.key, this.sequenceNumber, r3, r8);
        L25:
            Iterator r6 = r3.iterator();
        L27:
            if (r6.hasNext() == false) goto L32;
            Util.closeQuietly((Source) r6.next());
            goto L27
        L32:
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

        public final void writeLengths$okhttp(@NotNull BufferedSink r6) {
            Intrinsics.f(r6, "writer");
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
    }

    @Metadata
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(@NotNull DiskLruCache r2, String r3, @NotNull long r4, @NotNull List<? extends Source> r6, long[] r7) {
            Intrinsics.f(r3, "key");
            Intrinsics.f(r6, "sources");
            Intrinsics.f(r7, "lengths");
            this.this$0 = r2;
            this.key = r3;
            this.sequenceNumber = r4;
            this.sources = r6;
            this.lengths = r7;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<Source> r1 = this.sources.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Util.closeQuietly(r1.next());
            goto L4
        }

        @Nullable
        public final Editor edit() {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int r1) {
            return this.lengths[r1];
        }

        @NotNull
        public final Source getSource(int r1) {
            return this.sources.get(r1);
        }

        @NotNull
        public final String key() {
            return this.key;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$snapshots$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<Snapshot>, KMutableIterator {
        private final Iterator<Entry> delegate;
        private Snapshot nextSnapshot;
        private Snapshot removeSnapshot;
        final /* synthetic */ DiskLruCache this$0;

        public AnonymousClass1(DiskLruCache r2) {
            this.this$0 = r2;
            Iterator<Entry> r3 = new ArrayList(r2.getLruEntries$okhttp().values()).iterator();
            Intrinsics.e(r3, "ArrayList(lruEntries.values).iterator()");
            this.delegate = r3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextSnapshot == null) goto L5;
            return true;
        L5:
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L21:
            th = move-exception;
            throw th;
        L9:
            if (this.this$0.getClosed$okhttp() == false) goto L13;
            monitor-exit(r0);
            return false;
        L13:
            if (this.delegate.hasNext() == false) goto L23;
            Entry r2 = this.delegate.next();     // Catch: Throwable -> L21
            if (r2 == null) goto L13;
            Snapshot r3 = r2.snapshot$okhttp();     // Catch: Throwable -> L21
            if (r3 == null) goto L13;
            this.nextSnapshot = r3;     // Catch: Throwable -> L21
            monitor-exit(r0);
            return true;
        L23:
            monitor-exit(r0);
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Snapshot next() {
            return next2();
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot r0 = this.removeSnapshot;
            if (r0 == null) goto L12;
            this.this$0.remove(r0.key());     // Catch: IOException -> L13 Throwable -> L7
        L7:
            th = move-exception;
            this.removeSnapshot = null;
            throw th;
        L6:
            this.removeSnapshot = null;
            return;
        L12:
            throw new IllegalStateException("remove() before next()".toString());
        }

        @Override // java.util.Iterator
        @NotNull
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Snapshot next2() {
            if (hasNext() == false) goto L7;
            Snapshot r0 = this.nextSnapshot;
            this.removeSnapshot = r0;
            this.nextSnapshot = null;
            Intrinsics.c(r0);
            return r0;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        Companion = new Companion(null);
        JOURNAL_FILE = "journal";
        JOURNAL_FILE_TEMP = "journal.tmp";
        JOURNAL_FILE_BACKUP = "journal.bkp";
        MAGIC = "libcore.io.DiskLruCache";
        VERSION_1 = "1";
        ANY_SEQUENCE_NUMBER = -1;
        LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
        CLEAN = "CLEAN";
        DIRTY = "DIRTY";
        REMOVE = "REMOVE";
        READ = "READ";
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(@NotNull FileSystem r5, @NotNull File r6, int r7, int r8, long r9, @NotNull TaskRunner r11) {
        Intrinsics.f(r5, "fileSystem");
        Intrinsics.f(r6, "directory");
        Intrinsics.f(r11, "taskRunner");
        this.fileSystem = r5;
        this.directory = r6;
        this.appVersion = r7;
        this.valueCount = r8;
        this.maxSize = r9;
        boolean r10 = false;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupQueue = r11.newQueue();
        final String r12 = a.o(new StringBuilder(), Util.okHttpName, " Cache");
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

    public static final /* synthetic */ boolean access$getHasJournalErrors$p(DiskLruCache r0) {
        return r0.hasJournalErrors;
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache r0) {
        return r0.initialized;
    }

    public static final /* synthetic */ BufferedSink access$getJournalWriter$p(DiskLruCache r0) {
        return r0.journalWriter;
    }

    public static final /* synthetic */ boolean access$getMostRecentRebuildFailed$p(DiskLruCache r0) {
        return r0.mostRecentRebuildFailed;
    }

    public static final /* synthetic */ boolean access$getMostRecentTrimFailed$p(DiskLruCache r0) {
        return r0.mostRecentTrimFailed;
    }

    public static final /* synthetic */ int access$getRedundantOpCount$p(DiskLruCache r0) {
        return r0.redundantOpCount;
    }

    public static final /* synthetic */ boolean access$journalRebuildRequired(DiskLruCache r0) {
        return r0.journalRebuildRequired();
    }

    public static final /* synthetic */ void access$setCivilizedFileSystem$p(DiskLruCache r0, boolean r1) {
        r0.civilizedFileSystem = r1;
    }

    public static final /* synthetic */ void access$setHasJournalErrors$p(DiskLruCache r0, boolean r1) {
        r0.hasJournalErrors = r1;
    }

    public static final /* synthetic */ void access$setInitialized$p(DiskLruCache r0, boolean r1) {
        r0.initialized = r1;
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

    public static /* synthetic */ Editor edit$default(DiskLruCache r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = ANY_SEQUENCE_NUMBER;
    L6:
        return r0.edit(r1, r2);
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

    private final BufferedSink newJournalWriter() {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> r0 = this.lruEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Entry r1 = r0.next();
        Intrinsics.e(r1, "i.next()");
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

    private final void readJournal() {
        BufferedSource r2 = Okio.buffer(this.fileSystem.source(this.journalFile));
        String r3 = r2.readUtf8LineStrict();     // Catch: Throwable -> L16
        String r4 = r2.readUtf8LineStrict();     // Catch: Throwable -> L16
        String r5 = r2.readUtf8LineStrict();     // Catch: Throwable -> L16
        String r6 = r2.readUtf8LineStrict();     // Catch: Throwable -> L16
        String r7 = r2.readUtf8LineStrict();     // Catch: Throwable -> L16
        if ((!Intrinsics.a(MAGIC, r3)) == true) goto L25;
        if ((!Intrinsics.a(VERSION_1, r4)) == true) goto L25;
        if ((!Intrinsics.a(String.valueOf(this.appVersion), r5)) == true) goto L25;
        if ((!Intrinsics.a(String.valueOf(this.valueCount), r6)) == true) goto L25;
        if (r7.length() > 0) goto L25;
        int r0 = 0;
    L31:
        readJournalLine(r2.readUtf8LineStrict());     // Catch: Throwable -> L16 EOFException -> L18
        r0 = r0 + 1;
        goto L31
    L18:
        this.redundantOpCount = r0 - this.lruEntries.size();     // Catch: Throwable -> L16
        if (r2.exhausted() == true) goto L21;
        rebuildJournal$okhttp();     // Catch: Throwable -> L16
    L22:
        CloseableKt.a(r2, null);
        return;
    L21:
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L16
    L25:
        throw new IOException("unexpected journal header: [" + r3 + ", " + r4 + ", " + r6 + ", " + r7 + ']');     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.a(r2, th);
        throw th;
    }

    private final void readJournalLine(String r12) {
        int r3 = StringsKt.r(r12, ' ', 0, false, 6);
        if (r3 == (-1)) goto L37;
        int r6 = r3 + 1;
        int r7 = StringsKt.r(r12, ' ', r6, false, 4);
        if (r7 != (-1)) goto L12;
        String r8 = r12.substring(r6);
        Intrinsics.e(r8, "(this as java.lang.String).substring(startIndex)");
        String r9 = REMOVE;
        if (r3 == r9.length()) goto L9;
    L13:
        Entry r10 = this.lruEntries.get(r8);
        if (r10 != null) goto L16;
        r10 = new Entry(this, r8);
        this.lruEntries.put(r8, r10);
    L16:
        if (r7 == (-1)) goto L22;
        String r11 = CLEAN;
        if (r3 != r11.length()) goto L22;
        if (StringsKt.F(r12, r11, false) == false) goto L22;
        String r13 = r12.substring(r7 + 1);
        Intrinsics.e(r13, "(this as java.lang.String).substring(startIndex)");
        List<String> r14 = StringsKt.C(r13, new char[]{' '});
        r10.setReadable$okhttp(true);
        r10.setCurrentEditor$okhttp(null);
        r10.setLengths$okhttp(r14);
        return;
    L22:
        if (r7 != (-1)) goto L28;
        String r0 = DIRTY;
        if (r3 != r0.length()) goto L28;
        if (StringsKt.F(r12, r0, false) == false) goto L28;
        r10.setCurrentEditor$okhttp(new Editor(this, r10));
        return;
    L28:
        if (r7 != (-1)) goto L35;
        String r15 = READ;
        if (r3 != r15.length()) goto L35;
        if (StringsKt.F(r12, r15, false) == false) goto L35;
        return;
    L35:
        throw new IOException("unexpected journal line: ".concat(r12));
    L9:
        if (StringsKt.F(r12, r9, false) == false) goto L13;
        this.lruEntries.remove(r8);
        return;
    L12:
        r8 = r12.substring(r6, r7);
        Intrinsics.e(r8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        goto L13
    L37:
        throw new IOException("unexpected journal line: ".concat(r12));
    }

    private final boolean removeOldestEntry() {
        Iterator<Entry> r0 = this.lruEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Entry r1 = r0.next();
        if (r1.getZombie$okhttp() == true) goto L4;
        removeEntry$okhttp(r1);
        return true;
    L9:
        return false;
    }

    private final void validateKey(String r2) {
        if (LEGAL_KEY_PATTERN.b(r2) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + r2 + '\"').toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L6;
    L25:
        this.closed = true;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L6:
        if (this.closed == true) goto L25;
        Collection<Entry> r0 = this.lruEntries.values();     // Catch: Throwable -> L17
        Intrinsics.e(r0, "lruEntries.values");     // Catch: Throwable -> L17
        int r2 = 0;
        Object[] r1 = r0.toArray(new Entry[0]);     // Catch: Throwable -> L17
        if (r1 == null) goto L24;
        Entry[] r3 = (Entry[]) r1;     // Catch: Throwable -> L17
        int r4 = r3.length;     // Catch: Throwable -> L17
    L11:
        if (r2 >= r4) goto L20;
        Entry r5 = r3[r2];     // Catch: Throwable -> L17
        if (r5.getCurrentEditor$okhttp() == null) goto L19;
        Editor r6 = r5.getCurrentEditor$okhttp();     // Catch: Throwable -> L17
        if (r6 == null) goto L19;
        r6.detach$okhttp();     // Catch: Throwable -> L17
    L19:
        r2 = r2 + 1;     // Catch: Throwable -> L17
        goto L11
    L20:
        trimToSize();     // Catch: Throwable -> L17
        BufferedSink r7 = this.journalWriter;     // Catch: Throwable -> L17
        Intrinsics.c(r7);     // Catch: Throwable -> L17
        r7.close();     // Catch: Throwable -> L17
        this.journalWriter = null;     // Catch: Throwable -> L17
        this.closed = true;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L17
    }

    public final synchronized void completeEdit$okhttp(@NotNull Editor r9, boolean r10) {
        monitor-enter(this);
        Intrinsics.f(r9, "editor");     // Catch: Throwable -> L18
        Entry r0 = r9.getEntry$okhttp();     // Catch: Throwable -> L18
        if (Intrinsics.a(r0.getCurrentEditor$okhttp(), r9) == false) goto L55;
        int r1 = 0;
        if (r10 == true) goto L8;
    L23:
        int r11 = this.valueCount;     // Catch: Throwable -> L18
    L24:
        if (r1 >= r11) goto L34;
        File r2 = r0.getDirtyFiles$okhttp().get(r1);     // Catch: Throwable -> L18
        if (r10 == true) goto L28;
    L32:
        this.fileSystem.delete(r2);     // Catch: Throwable -> L18
    L33:
        r1 = r1 + 1;     // Catch: Throwable -> L18
        goto L24
    L28:
        if (r0.getZombie$okhttp() == true) goto L32;
        if (this.fileSystem.exists(r2) == false) goto L33;
        File r3 = r0.getCleanFiles$okhttp().get(r1);     // Catch: Throwable -> L18
        this.fileSystem.rename(r2, r3);     // Catch: Throwable -> L18
        long r4 = r0.getLengths$okhttp()[r1];     // Catch: Throwable -> L18
        long r5 = this.fileSystem.size(r3);     // Catch: Throwable -> L18
        r0.getLengths$okhttp()[r1] = r5;     // Catch: Throwable -> L18
        this.size = (this.size - r4) + r5;     // Catch: Throwable -> L18
        goto L33
    L34:
        r0.setCurrentEditor$okhttp(null);     // Catch: Throwable -> L18
        if (r0.getZombie$okhttp() == false) goto L39;
        removeEntry$okhttp(r0);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L39:
        this.redundantOpCount++;     // Catch: Throwable -> L18
        BufferedSink r12 = this.journalWriter;     // Catch: Throwable -> L18
        Intrinsics.c(r12);     // Catch: Throwable -> L18
        if (r0.getReadable$okhttp() == true) goto L44;
        if (r10 == true) goto L44;
        this.lruEntries.remove(r0.getKey$okhttp());     // Catch: Throwable -> L18
        r12.writeUtf8(REMOVE).writeByte(32);     // Catch: Throwable -> L18
        r12.writeUtf8(r0.getKey$okhttp());     // Catch: Throwable -> L18
        r12.writeByte(10);     // Catch: Throwable -> L18
    L47:
        r12.flush();     // Catch: Throwable -> L18
        if (this.size <= this.maxSize) goto L50;
    L51:
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L18
    L52:
        monitor-exit(this);
        return;
    L50:
        if (journalRebuildRequired() == false) goto L52;
    L44:
        r0.setReadable$okhttp(true);     // Catch: Throwable -> L18
        r12.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L18
        r12.writeUtf8(r0.getKey$okhttp());     // Catch: Throwable -> L18
        r0.writeLengths$okhttp(r12);     // Catch: Throwable -> L18
        r12.writeByte(10);     // Catch: Throwable -> L18
        if (r10 == false) goto L47;
        long r6 = this.nextSequenceNumber;     // Catch: Throwable -> L18
        this.nextSequenceNumber = 1 + r6;     // Catch: Throwable -> L18
        r0.setSequenceNumber$okhttp(r6);     // Catch: Throwable -> L18
        goto L47
    L8:
        if (r0.getReadable$okhttp() == true) goto L23;
        int r7 = this.valueCount;     // Catch: Throwable -> L18
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L23;
        boolean[] r13 = r9.getWritten$okhttp();     // Catch: Throwable -> L18
        Intrinsics.c(r13);     // Catch: Throwable -> L18
        if (r13[r8] == false) goto L21;
        if (this.fileSystem.exists(r0.getDirtyFiles$okhttp().get(r8)) == false) goto L15;
        r8 = r8 + 1;
        goto L10
    L15:
        r9.abort();     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L21:
        r9.abort();     // Catch: Throwable -> L18
        throw new IllegalStateException("Newly created entry didn't create value for index " + r8);     // Catch: Throwable -> L18
    L55:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final void delete() {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    @JvmOverloads
    @Nullable
    public final Editor edit(@NotNull String r7) {
        return edit$default(this, r7, 0, 2, null);
    }

    public final synchronized void evictAll() {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L8
        Collection<Entry> r0 = this.lruEntries.values();     // Catch: Throwable -> L8
        Intrinsics.e(r0, "lruEntries.values");     // Catch: Throwable -> L8
        Object[] r1 = r0.toArray(new Entry[0]);     // Catch: Throwable -> L8
        if (r1 == null) goto L14;
        Entry[] r2 = (Entry[]) r1;     // Catch: Throwable -> L8
        int r3 = r2.length;     // Catch: Throwable -> L8
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L10;
        Entry r5 = r2[r4];     // Catch: Throwable -> L8
        Intrinsics.e(r5, "entry");     // Catch: Throwable -> L8
        removeEntry$okhttp(r5);     // Catch: Throwable -> L8
        r4 = r4 + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
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
        Intrinsics.c(r0);     // Catch: Throwable -> L10
        r0.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Nullable
    public final synchronized Snapshot get(@NotNull String r8) {
        monitor-enter(this);
        Intrinsics.f(r8, "key");     // Catch: Throwable -> L11
        initialize();     // Catch: Throwable -> L11
        checkNotClosed();     // Catch: Throwable -> L11
        validateKey(r8);     // Catch: Throwable -> L11
        Entry r0 = this.lruEntries.get(r8);     // Catch: Throwable -> L11
        if (r0 == null) goto L17;
        Snapshot r1 = r0.snapshot$okhttp();     // Catch: Throwable -> L11
        if (r1 == null) goto L15;
        this.redundantOpCount++;     // Catch: Throwable -> L11
        BufferedSink r2 = this.journalWriter;     // Catch: Throwable -> L11
        Intrinsics.c(r2);     // Catch: Throwable -> L11
        r2.writeUtf8(READ).writeByte(32).writeUtf8(r8).writeByte(10);     // Catch: Throwable -> L11
        if (journalRebuildRequired() == false) goto L13;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);
        return r1;
    L15:
        monitor-exit(this);
        return null;
    L17:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    @NotNull
    public final File getDirectory() {
        return this.directory;
    }

    @NotNull
    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    @NotNull
    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
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

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Util.assertionsEnabled == false) goto L14;
        if (Thread.holdsLock(this) == true) goto L14;
        StringBuilder r2 = new StringBuilder("Thread ");     // Catch: Throwable -> L11
        Thread r1 = Thread.currentThread();     // Catch: Throwable -> L11
        Intrinsics.e(r1, "Thread.currentThread()");     // Catch: Throwable -> L11
        r2.append(r1.getName());     // Catch: Throwable -> L11
        r2.append(" MUST hold lock on ");     // Catch: Throwable -> L11
        r2.append(this);     // Catch: Throwable -> L11
        throw new AssertionError(r2.toString());     // Catch: Throwable -> L11
    L14:
        if (this.initialized == false) goto L18;
        monitor-exit(this);
        return;
    L18:
        if (this.fileSystem.exists(this.journalFileBackup) == true) goto L20;
    L23:
        this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);     // Catch: Throwable -> L11
        if (this.fileSystem.exists(this.journalFile) == true) goto L44;
    L37:
        rebuildJournal$okhttp();     // Catch: Throwable -> L11
        this.initialized = true;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L44:
        readJournal();     // Catch: Throwable -> L11 IOException -> L29
        processJournal();     // Catch: Throwable -> L11 IOException -> L29
        this.initialized = true;     // Catch: Throwable -> L11 IOException -> L29
        monitor-exit(this);
        return;
    L29:
        e = move-exception;
        Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);     // Catch: Throwable -> L11
        delete();     // Catch: Throwable -> L34
        this.closed = false;     // Catch: Throwable -> L11
        goto L37
    L34:
        th = move-exception;
        this.closed = false;     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L20:
        if (this.fileSystem.exists(this.journalFile) == false) goto L22;
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L11
        goto L23
    L22:
        this.fileSystem.rename(this.journalFileBackup, this.journalFile);     // Catch: Throwable -> L11
        goto L23
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

    public final synchronized void rebuildJournal$okhttp() {
        monitor-enter(this);
        BufferedSink r0 = this.journalWriter;     // Catch: Throwable -> L6
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L6
    L8:
        BufferedSink r1 = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));     // Catch: Throwable -> L6
        r1.writeUtf8(MAGIC).writeByte(10);     // Catch: Throwable -> L15
        r1.writeUtf8(VERSION_1).writeByte(10);     // Catch: Throwable -> L15
        r1.writeDecimalLong(this.appVersion).writeByte(10);     // Catch: Throwable -> L15
        r1.writeDecimalLong(this.valueCount).writeByte(10);     // Catch: Throwable -> L15
        r1.writeByte(10);     // Catch: Throwable -> L15
        Iterator<Entry> r2 = this.lruEntries.values().iterator();     // Catch: Throwable -> L15
    L10:
        if (r2.hasNext() == false) goto L20;
        Entry r3 = r2.next();     // Catch: Throwable -> L15
        if (r3.getCurrentEditor$okhttp() != null) goto L14;
        r1.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L15
        r1.writeUtf8(r3.getKey$okhttp());     // Catch: Throwable -> L15
        r3.writeLengths$okhttp(r1);     // Catch: Throwable -> L15
        r1.writeByte(10);     // Catch: Throwable -> L15
        goto L10
    L14:
        r1.writeUtf8(DIRTY).writeByte(32);     // Catch: Throwable -> L15
        r1.writeUtf8(r3.getKey$okhttp());     // Catch: Throwable -> L15
        r1.writeByte(10);     // Catch: Throwable -> L15
        goto L10
    L20:
        CloseableKt.a(r1, null);     // Catch: Throwable -> L6
        if (this.fileSystem.exists(this.journalFile) == false) goto L23;
        this.fileSystem.rename(this.journalFile, this.journalFileBackup);     // Catch: Throwable -> L6
    L23:
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);     // Catch: Throwable -> L6
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L6
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L6
        this.hasJournalErrors = false;     // Catch: Throwable -> L6
        this.mostRecentRebuildFailed = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.a(r1, th);     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean remove(@NotNull String r6) {
        monitor-enter(this);
        Intrinsics.f(r6, "key");     // Catch: Throwable -> L11
        initialize();     // Catch: Throwable -> L11
        checkNotClosed();     // Catch: Throwable -> L11
        validateKey(r6);     // Catch: Throwable -> L11
        Entry r7 = this.lruEntries.get(r6);     // Catch: Throwable -> L11
        if (r7 == null) goto L15;
        boolean r8 = removeEntry$okhttp(r7);     // Catch: Throwable -> L11
        if (r8 == true) goto L8;
    L13:
        monitor-exit(this);
        return r8;
    L8:
        if (this.size > this.maxSize) goto L13;
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L11
        goto L13
    L15:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean removeEntry$okhttp(@NotNull Entry r11) {
        Intrinsics.f(r11, "entry");
        if (this.civilizedFileSystem == false) goto L5;
    L15:
        Editor r0 = r11.getCurrentEditor$okhttp();
        if (r0 == null) goto L18;
        r0.detach$okhttp();
    L18:
        int r1 = this.valueCount;
        int r4 = 0;
    L19:
        if (r4 >= r1) goto L21;
        this.fileSystem.delete(r11.getCleanFiles$okhttp().get(r4));
        this.size -= r11.getLengths$okhttp()[r4];
        r11.getLengths$okhttp()[r4] = 0;
        r4 = r4 + 1;
        goto L19
    L21:
        this.redundantOpCount++;
        BufferedSink r2 = this.journalWriter;
        if (r2 == null) goto L24;
        r2.writeUtf8(REMOVE);
        r2.writeByte(32);
        r2.writeUtf8(r11.getKey$okhttp());
        r2.writeByte(10);
    L24:
        this.lruEntries.remove(r11.getKey$okhttp());
        if (journalRebuildRequired() == false) goto L27;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
    L27:
        return true;
    L5:
        if (r11.getLockingSourceCount$okhttp() <= 0) goto L10;
        BufferedSink r3 = this.journalWriter;
        if (r3 == null) goto L10;
        r3.writeUtf8(DIRTY);
        r3.writeByte(32);
        r3.writeUtf8(r11.getKey$okhttp());
        r3.writeByte(10);
        r3.flush();
    L10:
        if (r11.getLockingSourceCount$okhttp() <= 0) goto L12;
    L13:
        r11.setZombie$okhttp(true);
        return true;
    L12:
        if (r11.getCurrentEditor$okhttp() == null) goto L15;
        goto L13
    }

    public final void setClosed$okhttp(boolean r1) {
        this.closed = r1;
    }

    public final synchronized void setMaxSize(long r7) {
        monitor-enter(this);
        this.maxSize = r7;     // Catch: Throwable -> L7
        if (this.initialized == false) goto L9;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
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

    @NotNull
    public final synchronized Iterator<Snapshot> snapshots() {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        AnonymousClass1 r0 = new AnonymousClass1(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void trimToSize() {
    L3:
        if (this.size <= this.maxSize) goto L7;
        if (removeOldestEntry() == true) goto L3;
        return;
    L7:
        this.mostRecentTrimFailed = false;
    }

    @JvmOverloads
    @Nullable
    public final synchronized Editor edit(@NotNull String r10, long r11) {
        monitor-enter(this);
        Intrinsics.f(r10, "key");     // Catch: Throwable -> L10
        initialize();     // Catch: Throwable -> L10
        checkNotClosed();     // Catch: Throwable -> L10
        validateKey(r10);     // Catch: Throwable -> L10
        Entry r0 = this.lruEntries.get(r10);     // Catch: Throwable -> L10
        if (r11 == ANY_SEQUENCE_NUMBER) goto L14;
        if (r0 != null) goto L8;
    L12:
        monitor-exit(this);
        return null;
    L8:
        if (r0.getSequenceNumber$okhttp() != r11) goto L12;
    L14:
        if (r0 == null) goto L17;
        Editor r12 = r0.getCurrentEditor$okhttp();     // Catch: Throwable -> L10
    L18:
        if (r12 == null) goto L21;
        monitor-exit(this);
        return null;
    L21:
        if (r0 == null) goto L27;
        if (r0.getLockingSourceCount$okhttp() == 0) goto L27;
        monitor-exit(this);
        return null;
    L27:
        if (this.mostRecentTrimFailed == false) goto L29;
    L40:
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return null;
    L29:
        if (this.mostRecentRebuildFailed == true) goto L40;
        BufferedSink r13 = this.journalWriter;     // Catch: Throwable -> L10
        Intrinsics.c(r13);     // Catch: Throwable -> L10
        r13.writeUtf8(DIRTY).writeByte(32).writeUtf8(r10).writeByte(10);     // Catch: Throwable -> L10
        r13.flush();     // Catch: Throwable -> L10
        if (this.hasJournalErrors == false) goto L35;
        monitor-exit(this);
        return null;
    L35:
        if (r0 != null) goto L37;
        r0 = new Entry(this, r10);     // Catch: Throwable -> L10
        this.lruEntries.put(r10, r0);     // Catch: Throwable -> L10
    L37:
        Editor r14 = new Editor(this, r0);     // Catch: Throwable -> L10
        r0.setCurrentEditor$okhttp(r14);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r14;
    L17:
        r12 = null;
    L10:
        th = move-exception;
        throw th;
    }
}
