package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = null;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable;
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    int redundantOpCount;
    private long size;
    final int valueCount;

    public final class Editor {
        private boolean done;
        final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        final boolean[] written;

        Editor(DiskLruCache r1, Entry r2) {
            this.this$0 = r1;
            this.entry = r2;
            if (r2.readable == false) goto L5;
            boolean[] r3 = null;
        L6:
            this.written = r3;
            return;
        L5:
            r3 = new boolean[r1.valueCount];
            goto L6
        }

        void detach() {
            if (this.entry.currentEditor != this) goto L16;
            int r0 = 0;
        L6:
            if (r0 >= this.this$0.valueCount) goto L9;
            this.this$0.fileSystem.delete(this.entry.dirtyFiles[r0]);     // Catch: IOException -> L11
        L8:
            r0 = r0 + 1;
            goto L6
        L9:
            this.entry.currentEditor = null;
            return;
        }

        public Source newSource(int r4) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L20:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L19;
            if (this.entry.readable == true) goto L9;
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L20
            return null;
        L9:
            if (this.entry.currentEditor != this) goto L16;
            Source r3 = this.this$0.fileSystem.source(this.entry.cleanFiles[r4]);     // Catch: FileNotFoundException -> L14 Throwable -> L20
            monitor-exit(r0);     // Catch: Throwable -> L20
            return r3;
        L15:
            return null;
        L19:
            throw new IllegalStateException();     // Catch: Throwable -> L20
        }

        public Sink newSink(int r4) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L24:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L23;
            if (this.entry.currentEditor == this) goto L12;
            Sink r3 = Okio.blackhole();     // Catch: Throwable -> L24
            monitor-exit(r0);     // Catch: Throwable -> L24
            return r3;
        L12:
            if (this.entry.readable == true) goto L14;
            this.written[r4] = true;     // Catch: Throwable -> L24
        L14:
            File r5 = this.entry.dirtyFiles[r4];     // Catch: Throwable -> L24
            final Sink r6 = this.this$0.fileSystem.sink(r5);     // Catch: FileNotFoundException -> L19 Throwable -> L24
            FaultHidingSink r1 = new AnonymousClass1(this, r6);     // Catch: Throwable -> L24
            monitor-exit(r0);     // Catch: Throwable -> L24
            return r1;
        L21:
            return Okio.blackhole();
        L23:
            throw new IllegalStateException();     // Catch: Throwable -> L24
        }

        public void commit() throws IOException {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L13;
            if (this.entry.currentEditor != this) goto L9;
            this.this$0.completeEdit(this, true);     // Catch: Throwable -> L14
        L9:
            this.done = true;     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L13:
            throw new IllegalStateException();     // Catch: Throwable -> L14
        }

        public void abort() throws IOException {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L13;
            if (this.entry.currentEditor != this) goto L9;
            this.this$0.completeEdit(this, false);     // Catch: Throwable -> L14
        L9:
            this.done = true;     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L13:
            throw new IllegalStateException();     // Catch: Throwable -> L14
        }

        public void abortUnlessCommitted() {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.done == false) goto L7;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (this.entry.currentEditor != this) goto L9;
            this.this$0.completeEdit(this, false);     // Catch: IOException -> L14 Throwable -> L11
            goto L9
        }
    }

    private final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        Entry(DiskLruCache r7, String r8) {
            this.this$0 = r7;
            this.key = r8;
            this.lengths = new long[r7.valueCount];
            this.cleanFiles = new File[r7.valueCount];
            this.dirtyFiles = new File[r7.valueCount];
            StringBuilder r9 = new StringBuilder(r8).append('.');
            int r0 = r9.length();
            int r1 = 0;
        L4:
            if (r1 >= r7.valueCount) goto L6;
            r9.append(r1);
            this.cleanFiles[r1] = new File(r7.directory, r9.toString());
            r9.append(".tmp");
            this.dirtyFiles[r1] = new File(r7.directory, r9.toString());
            r9.setLength(r0);
            r1 = r1 + 1;
            goto L4
        }

        void setLengths(String[] r5) throws IOException {
            if (r5.length != this.this$0.valueCount) goto L13;
            int r0 = 0;
        L14:
            if (r0 >= r5.length) goto L9;
            this.lengths[r0] = Long.parseLong(r5[r0]);     // Catch: NumberFormatException -> L10
            r0 = r0 + 1;
            goto L14
        L9:
            return;
        L11:
            throw invalidLengths(r5);
        L13:
            throw invalidLengths(r5);
        }

        void writeLengths(BufferedSink r6) throws IOException {
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

        private IOException invalidLengths(String[] r3) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(r3));
        }

        Snapshot snapshot() {
            if (Thread.holdsLock(this.this$0) == false) goto L19;
            Source[] r0 = new Source[this.this$0.valueCount];
            long[] r7 = (long[]) this.lengths.clone();
            int r8 = 0;
            int r1 = 0;
        L22:
            if (r1 >= this.this$0.valueCount) goto L8;
            r0[r1] = this.this$0.fileSystem.source(this.cleanFiles[r1]);     // Catch: FileNotFoundException -> L20
            r1 = r1 + 1;     // Catch: FileNotFoundException -> L20
            goto L22
        L8:
            return new Snapshot(this.this$0, this.key, this.sequenceNumber, r0, r7);
        L11:
            if (r8 >= this.this$0.valueCount) goto L24;
            Source r2 = r0[r8];
            if (r2 == null) goto L24;
            Util.closeQuietly(r2);
            r8 = r8 + 1;
        L24:
            this.this$0.removeEntry(this);     // Catch: IOException -> L21
            return null;
        L27:
            return null;
        L19:
            throw new AssertionError();
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;
        final /* synthetic */ DiskLruCache this$0;

        static /* synthetic */ String access$000(Snapshot r0) {
            return r0.key;
        }

        Snapshot(DiskLruCache r1, String r2, long r3, Source[] r5, long[] r6) {
            this.this$0 = r1;
            this.key = r2;
            this.sequenceNumber = r3;
            this.sources = r5;
            this.lengths = r6;
        }

        public String key() {
            return this.key;
        }

        @Nullable
        public Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public Source getSource(int r1) {
            return this.sources[r1];
        }

        public long getLength(int r1) {
            return this.lengths[r1];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Source[] r3 = this.sources;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            Util.closeQuietly(r3[r1]);
            r1 = r1 + 1;
            goto L3
        }
    }

    static {
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    DiskLruCache(FileSystem r7, File r8, int r9, int r10, long r11, Executor r13) {
        this.size = 0;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = 0;
        this.cleanupRunnable = new AnonymousClass1(this);
        this.fileSystem = r7;
        this.directory = r8;
        this.appVersion = r9;
        this.journalFile = new File(r8, JOURNAL_FILE);
        this.journalFileTmp = new File(r8, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(r8, JOURNAL_FILE_BACKUP);
        this.valueCount = r10;
        this.maxSize = r11;
        this.executor = r13;
    }

    public synchronized void initialize() throws IOException {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.initialized == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.fileSystem.exists(this.journalFileBackup) == false) goto L16;
        if (this.fileSystem.exists(this.journalFile) == false) goto L13;
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L31
        goto L16
    L13:
        this.fileSystem.rename(this.journalFileBackup, this.journalFile);     // Catch: Throwable -> L31
    L16:
        if (this.fileSystem.exists(this.journalFile) == true) goto L37;
    L28:
        rebuildJournal();     // Catch: Throwable -> L31
        this.initialized = true;     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L37:
        readJournal();     // Catch: IOException -> L20 Throwable -> L31
        processJournal();     // Catch: IOException -> L20 Throwable -> L31
        this.initialized = true;     // Catch: IOException -> L20 Throwable -> L31
        monitor-exit(this);
        return;
    L20:
        e = move-exception;
        Platform.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);     // Catch: Throwable -> L31
        delete();     // Catch: Throwable -> L25
        this.closed = false;     // Catch: Throwable -> L31
        goto L28
    L25:
        th = move-exception;
        this.closed = false;     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    }

    public static DiskLruCache create(FileSystem r10, File r11, int r12, int r13, long r14) {
        if (r14 <= 0) goto L10;
        if (r13 <= 0) goto L8;
        return new DiskLruCache(r10, r11, r12, r13, r14, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
    L8:
        throw new IllegalArgumentException("valueCount <= 0");
    L10:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void readJournal() throws IOException {
        BufferedSource r2 = Okio.buffer(this.fileSystem.source(this.journalFile));
        String r3 = r2.readUtf8LineStrict();     // Catch: Throwable -> L24
        String r4 = r2.readUtf8LineStrict();     // Catch: Throwable -> L24
        String r5 = r2.readUtf8LineStrict();     // Catch: Throwable -> L24
        String r6 = r2.readUtf8LineStrict();     // Catch: Throwable -> L24
        String r7 = r2.readUtf8LineStrict();     // Catch: Throwable -> L24
        if (MAGIC.equals(r3) == false) goto L23;
        if ("1".equals(r4) == false) goto L23;
        if (Integer.toString(this.appVersion).equals(r5) == false) goto L23;
        if (Integer.toString(this.valueCount).equals(r6) == false) goto L23;
        if ("".equals(r7) == false) goto L23;
        int r0 = 0;
    L27:
        readJournalLine(r2.readUtf8LineStrict());     // Catch: EOFException -> L16 Throwable -> L24
        r0 = r0 + 1;
        goto L27
    L16:
        this.redundantOpCount = r0 - this.lruEntries.size();     // Catch: Throwable -> L24
        if (r2.exhausted() == true) goto L19;
        rebuildJournal();     // Catch: Throwable -> L24
    L20:
        Util.closeQuietly(r2);
        return;
    L19:
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L24
    L23:
        throw new IOException("unexpected journal header: [" + r3 + ", " + r4 + ", " + r6 + ", " + r7 + "]");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Util.closeQuietly(r2);
        throw th;
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        final Sink r0 = this.fileSystem.appendingSink(this.journalFile);
        return Okio.buffer(new AnonymousClass2(this, r0));
    }

    private void readJournalLine(String r8) throws IOException {
        int r1 = r8.indexOf(32);
        if (r1 == (-1)) goto L36;
        int r4 = r1 + 1;
        int r0 = r8.indexOf(32, r4);
        if (r0 != (-1)) goto L12;
        String r5 = r8.substring(r4);
        if (r1 == 6) goto L9;
    L13:
        Entry r6 = this.lruEntries.get(r5);
        if (r6 != null) goto L17;
        r6 = new Entry(this, r5);
        this.lruEntries.put(r5, r6);
    L17:
        if (r0 == (-1)) goto L22;
        if (r1 != 5) goto L22;
        if (r8.startsWith(CLEAN) == false) goto L22;
        String[] r9 = r8.substring(r0 + 1).split(" ");
        r6.readable = true;
        r6.currentEditor = null;
        r6.setLengths(r9);
        return;
    L22:
        if (r0 != (-1)) goto L27;
        if (r1 != 5) goto L27;
        if (r8.startsWith(DIRTY) == false) goto L27;
        r6.currentEditor = new Editor(this, r6);
        return;
    L27:
        if (r0 != (-1)) goto L34;
        if (r1 != 4) goto L34;
        if (r8.startsWith(READ) == false) goto L34;
        return;
    L34:
        throw new IOException("unexpected journal line: " + r8);
    L9:
        if (r8.startsWith(REMOVE) == false) goto L13;
        this.lruEntries.remove(r5);
        return;
    L12:
        r5 = r8.substring(r4, r0);
        goto L13
    L36:
        throw new IOException("unexpected journal line: " + r8);
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> r0 = this.lruEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Entry r1 = r0.next();
        int r3 = 0;
        if (r1.currentEditor == null) goto L8;
        r1.currentEditor = null;
    L12:
        if (r3 >= this.valueCount) goto L14;
        this.fileSystem.delete(r1.cleanFiles[r3]);
        this.fileSystem.delete(r1.dirtyFiles[r3]);
        r3 = r3 + 1;
        goto L12
    L14:
        r0.remove();
    L8:
        if (r3 >= this.valueCount) goto L4;
        this.size += r1.lengths[r3];
        r3 = r3 + 1;
        goto L8
    }

    synchronized void rebuildJournal() throws IOException {
        monitor-enter(this);
        BufferedSink r0 = this.journalWriter;     // Catch: Throwable -> L24
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L24
    L6:
        BufferedSink r1 = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));     // Catch: Throwable -> L24
        r1.writeUtf8(MAGIC).writeByte(10);     // Catch: Throwable -> L21
        r1.writeUtf8("1").writeByte(10);     // Catch: Throwable -> L21
        r1.writeDecimalLong(this.appVersion).writeByte(10);     // Catch: Throwable -> L21
        r1.writeDecimalLong(this.valueCount).writeByte(10);     // Catch: Throwable -> L21
        r1.writeByte(10);     // Catch: Throwable -> L21
        Iterator<Entry> r2 = this.lruEntries.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r2.hasNext() == false) goto L15;
        Entry r3 = r2.next();     // Catch: Throwable -> L21
        if (r3.currentEditor != null) goto L12;
        r1.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L21
        r1.writeUtf8(r3.key);     // Catch: Throwable -> L21
        r3.writeLengths(r1);     // Catch: Throwable -> L21
        r1.writeByte(10);     // Catch: Throwable -> L21
        goto L8
    L12:
        r1.writeUtf8(DIRTY).writeByte(32);     // Catch: Throwable -> L21
        r1.writeUtf8(r3.key);     // Catch: Throwable -> L21
        r1.writeByte(10);     // Catch: Throwable -> L21
        goto L8
    L15:
        r1.close();     // Catch: Throwable -> L24
        if (this.fileSystem.exists(this.journalFile) == false) goto L18;
        this.fileSystem.rename(this.journalFile, this.journalFileBackup);     // Catch: Throwable -> L24
    L18:
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);     // Catch: Throwable -> L24
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L24
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L24
        this.hasJournalErrors = false;     // Catch: Throwable -> L24
        this.mostRecentRebuildFailed = false;     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized Snapshot get(String r4) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L19
        checkNotClosed();     // Catch: Throwable -> L19
        validateKey(r4);     // Catch: Throwable -> L19
        Entry r0 = this.lruEntries.get(r4);     // Catch: Throwable -> L19
        if (r0 != null) goto L6;
    L17:
        monitor-exit(this);
        return null;
    L6:
        if (r0.readable == false) goto L17;
        Snapshot r1 = r0.snapshot();     // Catch: Throwable -> L19
        if (r1 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        this.redundantOpCount++;     // Catch: Throwable -> L19
        this.journalWriter.writeUtf8(READ).writeByte(32).writeUtf8(r4).writeByte(10);     // Catch: Throwable -> L19
        if (journalRebuildRequired() == false) goto L15;
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L19
    L15:
        monitor-exit(this);
        return r1;
    L19:
        th = move-exception;
        throw th;
    }

    @Nullable
    public Editor edit(String r3) throws IOException {
        return edit(r3, -1);
    }

    synchronized Editor edit(String r6, long r7) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L33
        checkNotClosed();     // Catch: Throwable -> L33
        validateKey(r6);     // Catch: Throwable -> L33
        Entry r0 = this.lruEntries.get(r6);     // Catch: Throwable -> L33
        if (r7 == (-1)) goto L11;
        if (r0 != null) goto L8;
    L9:
        monitor-exit(this);
        return null;
    L8:
        if (r0.sequenceNumber != r7) goto L9;
    L11:
        if (r0 == null) goto L17;
        if (r0.currentEditor == null) goto L17;
        monitor-exit(this);
        return null;
    L17:
        if (this.mostRecentTrimFailed == false) goto L19;
    L30:
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L33
        monitor-exit(this);
        return null;
    L19:
        if (this.mostRecentRebuildFailed == true) goto L30;
        this.journalWriter.writeUtf8(DIRTY).writeByte(32).writeUtf8(r6).writeByte(10);     // Catch: Throwable -> L33
        this.journalWriter.flush();     // Catch: Throwable -> L33
        if (this.hasJournalErrors == false) goto L25;
        monitor-exit(this);
        return null;
    L25:
        if (r0 != null) goto L27;
        r0 = new Entry(this, r6);     // Catch: Throwable -> L33
        this.lruEntries.put(r6, r0);     // Catch: Throwable -> L33
    L27:
        Editor r8 = new Editor(this, r0);     // Catch: Throwable -> L33
        r0.currentEditor = r8;     // Catch: Throwable -> L33
        monitor-exit(this);
        return r8;
    L33:
        th = move-exception;
        throw th;
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        monitor-enter(this);
        long r0 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setMaxSize(long r1) {
        monitor-enter(this);
        this.maxSize = r1;     // Catch: Throwable -> L8
        if (this.initialized == false) goto L6;
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized long size() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        long r0 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void completeEdit(Editor r10, boolean r11) throws IOException {
        monitor-enter(this);
        Entry r0 = r10.entry;     // Catch: Throwable -> L46
        if (r0.currentEditor != r10) goto L45;
        int r1 = 0;
        if (r11 == false) goto L23;
        if (r0.readable == true) goto L23;
        int r2 = 0;
    L11:
        if (r2 >= this.valueCount) goto L23;
        if (r10.written[r2] == false) goto L20;
        if (this.fileSystem.exists(r0.dirtyFiles[r2]) == false) goto L16;
        r2 = r2 + 1;
        goto L11
    L16:
        r10.abort();     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L20:
        r10.abort();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index " + r2);     // Catch: Throwable -> L46
    L23:
        if (r1 >= this.valueCount) goto L31;
        File r12 = r0.dirtyFiles[r1];     // Catch: Throwable -> L46
        if (r11 == true) goto L27;
        this.fileSystem.delete(r12);     // Catch: Throwable -> L46
    L30:
        r1 = r1 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (this.fileSystem.exists(r12) == false) goto L30;
        File r3 = r0.cleanFiles[r1];     // Catch: Throwable -> L46
        this.fileSystem.rename(r12, r3);     // Catch: Throwable -> L46
        long r4 = r0.lengths[r1];     // Catch: Throwable -> L46
        long r5 = this.fileSystem.size(r3);     // Catch: Throwable -> L46
        r0.lengths[r1] = r5;     // Catch: Throwable -> L46
        this.size = (this.size - r4) + r5;     // Catch: Throwable -> L46
        goto L30
    L31:
        this.redundantOpCount++;     // Catch: Throwable -> L46
        r0.currentEditor = null;     // Catch: Throwable -> L46
        if ((r0.readable | r11) == false) goto L36;
        r0.readable = true;     // Catch: Throwable -> L46
        this.journalWriter.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L46
        this.journalWriter.writeUtf8(r0.key);     // Catch: Throwable -> L46
        r0.writeLengths(this.journalWriter);     // Catch: Throwable -> L46
        this.journalWriter.writeByte(10);     // Catch: Throwable -> L46
        if (r11 == false) goto L37;
        long r13 = this.nextSequenceNumber;     // Catch: Throwable -> L46
        this.nextSequenceNumber = 1 + r13;     // Catch: Throwable -> L46
        r0.sequenceNumber = r13;     // Catch: Throwable -> L46
    L37:
        this.journalWriter.flush();     // Catch: Throwable -> L46
        if (this.size <= this.maxSize) goto L40;
    L41:
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L46
    L42:
        monitor-exit(this);
        return;
    L40:
        if (journalRebuildRequired() == false) goto L42;
    L36:
        this.lruEntries.remove(r0.key);     // Catch: Throwable -> L46
        this.journalWriter.writeUtf8(REMOVE).writeByte(32);     // Catch: Throwable -> L46
        this.journalWriter.writeUtf8(r0.key);     // Catch: Throwable -> L46
        this.journalWriter.writeByte(10);     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    boolean journalRebuildRequired() {
        int r0 = this.redundantOpCount;
        if (r0 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r0 < this.lruEntries.size()) goto L7;
        return true;
    }

    public synchronized boolean remove(String r6) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L15
        checkNotClosed();     // Catch: Throwable -> L15
        validateKey(r6);     // Catch: Throwable -> L15
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

    boolean removeEntry(Entry r6) throws IOException {
        if (r6.currentEditor == null) goto L5;
        r6.currentEditor.detach();
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.valueCount) goto L9;
        this.fileSystem.delete(r6.cleanFiles[r0]);
        this.size -= r6.lengths[r0];
        r6.lengths[r0] = 0;
        r0 = r0 + 1;
        goto L7
    L9:
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(r6.key).writeByte(10);
        this.lruEntries.remove(r6.key);
        if (journalRebuildRequired() == false) goto L12;
        this.executor.execute(this.cleanupRunnable);
    L12:
        return true;
    }

    public synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r0 = this.closed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void checkNotClosed() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L9
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
        this.journalWriter.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
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
        Entry[] r0 = (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);     // Catch: Throwable -> L20
        int r2 = r0.length;     // Catch: Throwable -> L20
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L14;
        Entry r4 = r0[r3];     // Catch: Throwable -> L20
        if (r4.currentEditor == null) goto L13;
        r4.currentEditor.abort();     // Catch: Throwable -> L20
    L13:
        r3 = r3 + 1;     // Catch: Throwable -> L20
        goto L9
    L14:
        trimToSize();     // Catch: Throwable -> L20
        this.journalWriter.close();     // Catch: Throwable -> L20
        this.journalWriter = null;     // Catch: Throwable -> L20
        this.closed = true;     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    void trimToSize() throws IOException {
    L3:
        if (this.size <= this.maxSize) goto L5;
        removeEntry(this.lruEntries.values().iterator().next());
        goto L3
    L5:
        this.mostRecentTrimFailed = false;
    }

    public void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public synchronized void evictAll() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L9
        Entry[] r0 = (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);     // Catch: Throwable -> L9
        int r1 = r0.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L6;
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

    private void validateKey(String r3) {
        if (LEGAL_KEY_PATTERN.matcher(r3).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r3 + "\"");
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        Iterator<Snapshot> r0 = new AnonymousClass3(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
