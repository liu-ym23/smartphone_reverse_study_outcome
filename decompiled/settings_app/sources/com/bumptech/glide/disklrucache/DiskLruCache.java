package com.bumptech.glide.disklrucache;

import android.os.StrictMode;
import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    private final File directory;
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    private static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        /* synthetic */ DiskLruCacheThreadFactory(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable r3) {
            monitor-enter(this);
            Thread r0 = new Thread(r3, "glide-disk-lru-cache-thread");     // Catch: Throwable -> L6
            r0.setPriority(1);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        /* synthetic */ Editor(DiskLruCache r1, Entry r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ Entry access$1500(Editor r0) {
            return r0.entry;
        }

        static /* synthetic */ boolean[] access$1600(Editor r0) {
            return r0.written;
        }

        private Editor(DiskLruCache r1, Entry r2) {
            this.this$0 = r1;
            this.entry = r2;
            if (Entry.access$700(r2) == false) goto L5;
            boolean[] r3 = null;
        L6:
            this.written = r3;
            return;
        L5:
            r3 = new boolean[DiskLruCache.access$1900(r1)];
            goto L6
        }

        private InputStream newInputStream(int r4) throws IOException {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L17:
            th = move-exception;
            throw th;
        L5:
            if (Entry.access$800(this.entry) != this) goto L16;
            if (Entry.access$700(this.entry) == true) goto L20;
            monitor-exit(r0);     // Catch: Throwable -> L17
            return null;
        L20:
            FileInputStream r1 = new FileInputStream(this.entry.getCleanFile(r4));     // Catch: FileNotFoundException -> L13 Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            return r1;
        L14:
            return null;
        L16:
            throw new IllegalStateException();     // Catch: Throwable -> L17
        }

        public String getString(int r1) throws IOException {
            InputStream r0 = newInputStream(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return DiskLruCache.access$1800(r0);
        }

        public File getFile(int r4) throws IOException {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (Entry.access$800(this.entry) != this) goto L13;
            if (Entry.access$700(this.entry) == true) goto L9;
            this.written[r4] = true;     // Catch: Throwable -> L14
        L9:
            File r5 = this.entry.getDirtyFile(r4);     // Catch: Throwable -> L14
            DiskLruCache.access$2000(this.this$0).mkdirs();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return r5;
        L13:
            throw new IllegalStateException();     // Catch: Throwable -> L14
        }

        public void set(int r3, String r4) throws IOException {
            OutputStreamWriter r0 = null;
            OutputStreamWriter r2 = new OutputStreamWriter(new FileOutputStream(getFile(r3)), Util.UTF_8);     // Catch: Throwable -> L9
            r2.write(r4);     // Catch: Throwable -> L7
            Util.closeQuietly(r2);
            return;
        L7:
            th = th;
            r0 = r2;
        L10:
            Util.closeQuietly(r0);
            throw th;
        L9:
            th = th;
            goto L10
        }

        public void commit() throws IOException {
            DiskLruCache.access$2100(this.this$0, this, true);
            this.committed = true;
        }

        public void abort() throws IOException {
            DiskLruCache.access$2100(this.this$0, this, false);
        }

        public void abortUnlessCommitted() {
            if (this.committed == true) goto L9;
            abort();     // Catch: IOException -> L6
            return;
        L10:
            return;
        }
    }

    private final class Entry {
        File[] cleanFiles;
        private Editor currentEditor;
        File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        /* synthetic */ Entry(DiskLruCache r1, String r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ long[] access$1100(Entry r0) {
            return r0.lengths;
        }

        static /* synthetic */ String access$1200(Entry r0) {
            return r0.key;
        }

        static /* synthetic */ long access$1300(Entry r2) {
            return r2.sequenceNumber;
        }

        static /* synthetic */ long access$1302(Entry r0, long r1) {
            r0.sequenceNumber = r1;
            return r1;
        }

        static /* synthetic */ boolean access$700(Entry r0) {
            return r0.readable;
        }

        static /* synthetic */ boolean access$702(Entry r0, boolean r1) {
            r0.readable = r1;
            return r1;
        }

        static /* synthetic */ Editor access$800(Entry r0) {
            return r0.currentEditor;
        }

        static /* synthetic */ Editor access$802(Entry r0, Editor r1) {
            r0.currentEditor = r1;
            return r1;
        }

        static /* synthetic */ void access$900(Entry r0, String[] r1) throws IOException {
            r0.setLengths(r1);
        }

        private Entry(DiskLruCache r7, String r8) {
            this.this$0 = r7;
            this.key = r8;
            this.lengths = new long[DiskLruCache.access$1900(r7)];
            this.cleanFiles = new File[DiskLruCache.access$1900(r7)];
            this.dirtyFiles = new File[DiskLruCache.access$1900(r7)];
            StringBuilder r9 = new StringBuilder(r8).append('.');
            int r0 = r9.length();
            int r1 = 0;
        L4:
            if (r1 >= DiskLruCache.access$1900(r7)) goto L6;
            r9.append(r1);
            this.cleanFiles[r1] = new File(DiskLruCache.access$2000(r7), r9.toString());
            r9.append(".tmp");
            this.dirtyFiles[r1] = new File(DiskLruCache.access$2000(r7), r9.toString());
            r9.setLength(r0);
            r1 = r1 + 1;
            goto L4
        }

        public String getLengths() throws IOException {
            StringBuilder r0 = new StringBuilder();
            long[] r6 = this.lengths;
            int r1 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            long r3 = r6[r2];
            r0.append(TokenParser.SP).append(r3);
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.toString();
        }

        private void setLengths(String[] r5) throws IOException {
            if (r5.length != DiskLruCache.access$1900(this.this$0)) goto L13;
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

        private IOException invalidLengths(String[] r3) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(r3));
        }

        public File getCleanFile(int r1) {
            return this.cleanFiles[r1];
        }

        public File getDirtyFile(int r1) {
            return this.dirtyFiles[r1];
        }
    }

    public final class Value {
        private final File[] files;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        /* synthetic */ Value(DiskLruCache r1, String r2, long r3, File[] r5, long[] r6, AnonymousClass1 r7) {
            this(r1, r2, r3, r5, r6);
        }

        private Value(DiskLruCache r1, String r2, long r3, File[] r5, long[] r6) {
            this.this$0 = r1;
            this.key = r2;
            this.sequenceNumber = r3;
            this.files = r5;
            this.lengths = r6;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.access$1700(this.this$0, this.key, this.sequenceNumber);
        }

        public File getFile(int r1) {
            return this.files[r1];
        }

        public String getString(int r2) throws IOException {
            return DiskLruCache.access$1800(new FileInputStream(this.files[r2]));
        }

        public long getLength(int r1) {
            return this.lengths[r1];
        }
    }

    static /* synthetic */ Writer access$100(DiskLruCache r0) {
        return r0.journalWriter;
    }

    static /* synthetic */ Editor access$1700(DiskLruCache r0, String r1, long r2) throws IOException {
        return r0.edit(r1, r2);
    }

    static /* synthetic */ String access$1800(InputStream r0) throws IOException {
        return inputStreamToString(r0);
    }

    static /* synthetic */ int access$1900(DiskLruCache r0) {
        return r0.valueCount;
    }

    static /* synthetic */ void access$200(DiskLruCache r0) throws IOException {
        r0.trimToSize();
    }

    static /* synthetic */ File access$2000(DiskLruCache r0) {
        return r0.directory;
    }

    static /* synthetic */ void access$2100(DiskLruCache r0, Editor r1, boolean r2) throws IOException {
        r0.completeEdit(r1, r2);
    }

    static /* synthetic */ boolean access$300(DiskLruCache r0) {
        return r0.journalRebuildRequired();
    }

    static /* synthetic */ void access$400(DiskLruCache r0) throws IOException {
        r0.rebuildJournal();
    }

    static /* synthetic */ int access$502(DiskLruCache r0, int r1) {
        r0.redundantOpCount = r1;
        return r1;
    }

    private DiskLruCache(File r17, int r18, int r19, long r20) {
        this.size = 0;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = 0;
        this.executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory(null));
        this.cleanupCallable = new AnonymousClass1(this);
        this.directory = r17;
        this.appVersion = r18;
        this.journalFile = new File(r17, "journal");
        this.journalFileTmp = new File(r17, "journal.tmp");
        this.journalFileBackup = new File(r17, "journal.bkp");
        this.valueCount = r19;
        this.maxSize = r20;
    }

    public static DiskLruCache open(File r9, int r10, int r11, long r12) throws IOException {
        if (r12 <= 0) goto L22;
        if (r11 <= 0) goto L20;
        File r0 = new File(r9, "journal.bkp");
        if (r0.exists() == false) goto L11;
        File r1 = new File(r9, "journal");
        if (r1.exists() == false) goto L10;
        r0.delete();
        goto L11
    L10:
        renameTo(r0, r1, false);
    L11:
        DiskLruCache r2 = new DiskLruCache(r9, r10, r11, r12);
        if (r2.journalFile.exists() == true) goto L23;
    L17:
        r9.mkdirs();
        DiskLruCache r3 = new DiskLruCache(r9, r10, r11, r12);
        r3.rebuildJournal();
        return r3;
    L23:
        r2.readJournal();     // Catch: IOException -> L15
        r2.processJournal();     // Catch: IOException -> L15
        return r2;
    L15:
        e = move-exception;
        System.out.println("DiskLruCache " + r9 + " is corrupt: " + e.getMessage() + ", removing");
        r2.delete();
        goto L17
    L20:
        throw new IllegalArgumentException("valueCount <= 0");
    L22:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void readJournal() throws IOException {
        StrictLineReader r2 = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        String r3 = r2.readLine();     // Catch: Throwable -> L24
        String r4 = r2.readLine();     // Catch: Throwable -> L24
        String r5 = r2.readLine();     // Catch: Throwable -> L24
        String r6 = r2.readLine();     // Catch: Throwable -> L24
        String r7 = r2.readLine();     // Catch: Throwable -> L24
        if ("libcore.io.DiskLruCache".equals(r3) == false) goto L23;
        if ("1".equals(r4) == false) goto L23;
        if (Integer.toString(this.appVersion).equals(r5) == false) goto L23;
        if (Integer.toString(this.valueCount).equals(r6) == false) goto L23;
        if ("".equals(r7) == false) goto L23;
        int r0 = 0;
    L28:
        readJournalLine(r2.readLine());     // Catch: EOFException -> L16 Throwable -> L24
        r0 = r0 + 1;
        goto L28
    L16:
        this.redundantOpCount = r0 - this.lruEntries.size();     // Catch: Throwable -> L24
        if (r2.hasUnterminatedLine() == false) goto L19;
        rebuildJournal();     // Catch: Throwable -> L24
    L20:
        Util.closeQuietly(r2);
        return;
    L19:
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));     // Catch: Throwable -> L24
    L23:
        throw new IOException("unexpected journal header: [" + r3 + ", " + r4 + ", " + r6 + ", " + r7 + "]");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Util.closeQuietly(r2);
        throw th;
    }

    private void readJournalLine(String r9) throws IOException {
        int r1 = r9.indexOf(32);
        if (r1 == (-1)) goto L36;
        int r4 = r1 + 1;
        int r0 = r9.indexOf(32, r4);
        if (r0 != (-1)) goto L12;
        String r5 = r9.substring(r4);
        if (r1 == 6) goto L9;
    L13:
        Entry r6 = this.lruEntries.get(r5);
        AnonymousClass1 r7 = null;
        if (r6 != null) goto L17;
        r6 = new Entry(this, r5, r7);
        this.lruEntries.put(r5, r6);
    L17:
        if (r0 == (-1)) goto L22;
        if (r1 != 5) goto L22;
        if (r9.startsWith(CLEAN) == false) goto L22;
        String[] r10 = r9.substring(r0 + 1).split(HanziToPinyin.Token.SEPARATOR);
        Entry.access$702(r6, true);
        Entry.access$802(r6, null);
        Entry.access$900(r6, r10);
        return;
    L22:
        if (r0 != (-1)) goto L27;
        if (r1 != 5) goto L27;
        if (r9.startsWith(DIRTY) == false) goto L27;
        Entry.access$802(r6, new Editor(this, r6, r7));
        return;
    L27:
        if (r0 != (-1)) goto L34;
        if (r1 != 4) goto L34;
        if (r9.startsWith(READ) == false) goto L34;
        return;
    L34:
        throw new IOException("unexpected journal line: " + r9);
    L9:
        if (r9.startsWith(REMOVE) == false) goto L13;
        this.lruEntries.remove(r5);
        return;
    L12:
        r5 = r9.substring(r4, r0);
        goto L13
    L36:
        throw new IOException("unexpected journal line: " + r9);
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> r0 = this.lruEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Entry r1 = r0.next();
        int r3 = 0;
        if (Entry.access$800(r1) == null) goto L8;
        Entry.access$802(r1, null);
    L12:
        if (r3 >= this.valueCount) goto L14;
        deleteIfExists(r1.getCleanFile(r3));
        deleteIfExists(r1.getDirtyFile(r3));
        r3 = r3 + 1;
        goto L12
    L14:
        r0.remove();
    L8:
        if (r3 >= this.valueCount) goto L4;
        this.size += Entry.access$1100(r1)[r3];
        r3 = r3 + 1;
        goto L8
    }

    private synchronized void rebuildJournal() throws IOException {
        monitor-enter(this);
        Writer r0 = this.journalWriter;     // Catch: Throwable -> L24
        if (r0 == null) goto L6;
        closeWriter(r0);     // Catch: Throwable -> L24
    L6:
        BufferedWriter r1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));     // Catch: Throwable -> L24
        r1.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write("1");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write(Integer.toString(this.appVersion));     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write(Integer.toString(this.valueCount));     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        Iterator<Entry> r2 = this.lruEntries.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r2.hasNext() == false) goto L15;
        Entry r3 = r2.next();     // Catch: Throwable -> L21
        if (Entry.access$800(r3) != null) goto L12;
        r1.write("CLEAN " + Entry.access$1200(r3) + r3.getLengths() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r1.write("DIRTY " + Entry.access$1200(r3) + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        closeWriter(r1);     // Catch: Throwable -> L24
        if (this.journalFile.exists() == false) goto L18;
        renameTo(this.journalFile, this.journalFileBackup, true);     // Catch: Throwable -> L24
    L18:
        renameTo(this.journalFileTmp, this.journalFile, false);     // Catch: Throwable -> L24
        this.journalFileBackup.delete();     // Catch: Throwable -> L24
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        closeWriter(r1);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static void deleteIfExists(File r1) throws IOException {
        if (r1.exists() == true) goto L5;
        return;
    L5:
        if (r1.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    private static void renameTo(File r0, File r1, boolean r2) throws IOException {
        if (r2 == false) goto L5;
        deleteIfExists(r1);
    L5:
        if (r0.renameTo(r1) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public synchronized Value get(String r10) throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L25
        Entry r0 = this.lruEntries.get(r10);     // Catch: Throwable -> L25
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (Entry.access$700(r0) == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        File[] r2 = r0.cleanFiles;     // Catch: Throwable -> L25
        int r3 = r2.length;     // Catch: Throwable -> L25
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L19;
        if (r2[r4].exists() == false) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        monitor-exit(this);
        return null;
    L19:
        this.redundantOpCount++;     // Catch: Throwable -> L25
        this.journalWriter.append(READ);     // Catch: Throwable -> L25
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L25
        this.journalWriter.append(r10);     // Catch: Throwable -> L25
        this.journalWriter.append('\n');     // Catch: Throwable -> L25
        if (journalRebuildRequired() == false) goto L22;
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L25
    L22:
        Value r8 = new Value(this, r10, Entry.access$1300(r0), r0.cleanFiles, Entry.access$1100(r0), null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r8;
    L25:
        th = move-exception;
        throw th;
    }

    public Editor edit(String r3) throws IOException {
        return edit(r3, -1);
    }

    private synchronized Editor edit(String r6, long r7) throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L20
        Entry r0 = this.lruEntries.get(r6);     // Catch: Throwable -> L20
        AnonymousClass1 r2 = null;
        if (r7 == (-1)) goto L11;
        if (r0 != null) goto L8;
    L9:
        monitor-exit(this);
        return null;
    L8:
        if (Entry.access$1300(r0) != r7) goto L9;
    L11:
        if (r0 != null) goto L14;
        r0 = new Entry(this, r6, r2);     // Catch: Throwable -> L20
        this.lruEntries.put(r6, r0);     // Catch: Throwable -> L20
    L17:
        Editor r8 = new Editor(this, r0, r2);     // Catch: Throwable -> L20
        Entry.access$802(r0, r8);     // Catch: Throwable -> L20
        this.journalWriter.append(DIRTY);     // Catch: Throwable -> L20
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L20
        this.journalWriter.append(r6);     // Catch: Throwable -> L20
        this.journalWriter.append('\n');     // Catch: Throwable -> L20
        flushWriter(this.journalWriter);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r8;
    L14:
        if (Entry.access$800(r0) == null) goto L17;
        monitor-exit(this);
        return null;
    L20:
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
        this.maxSize = r1;     // Catch: Throwable -> L6
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long size() {
        monitor-enter(this);
        long r0 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void completeEdit(Editor r10, boolean r11) throws IOException {
        monitor-enter(this);
        Entry r0 = Editor.access$1500(r10);     // Catch: Throwable -> L46
        if (Entry.access$800(r0) != r10) goto L45;
        int r1 = 0;
        if (r11 == false) goto L23;
        if (Entry.access$700(r0) == true) goto L23;
        int r2 = 0;
    L11:
        if (r2 >= this.valueCount) goto L23;
        if (Editor.access$1600(r10)[r2] == false) goto L20;
        if (r0.getDirtyFile(r2).exists() == false) goto L16;
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
        File r12 = r0.getDirtyFile(r1);     // Catch: Throwable -> L46
        if (r11 == true) goto L27;
        deleteIfExists(r12);     // Catch: Throwable -> L46
    L30:
        r1 = r1 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r12.exists() == false) goto L30;
        File r3 = r0.getCleanFile(r1);     // Catch: Throwable -> L46
        r12.renameTo(r3);     // Catch: Throwable -> L46
        long r4 = Entry.access$1100(r0)[r1];     // Catch: Throwable -> L46
        long r5 = r3.length();     // Catch: Throwable -> L46
        Entry.access$1100(r0)[r1] = r5;     // Catch: Throwable -> L46
        this.size = (this.size - r4) + r5;     // Catch: Throwable -> L46
        goto L30
    L31:
        this.redundantOpCount++;     // Catch: Throwable -> L46
        Entry.access$802(r0, null);     // Catch: Throwable -> L46
        if ((Entry.access$700(r0) | r11) == false) goto L36;
        Entry.access$702(r0, true);     // Catch: Throwable -> L46
        this.journalWriter.append(CLEAN);     // Catch: Throwable -> L46
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L46
        this.journalWriter.append(Entry.access$1200(r0));     // Catch: Throwable -> L46
        this.journalWriter.append(r0.getLengths());     // Catch: Throwable -> L46
        this.journalWriter.append('\n');     // Catch: Throwable -> L46
        if (r11 == false) goto L37;
        long r13 = this.nextSequenceNumber;     // Catch: Throwable -> L46
        this.nextSequenceNumber = 1 + r13;     // Catch: Throwable -> L46
        Entry.access$1302(r0, r13);     // Catch: Throwable -> L46
    L37:
        flushWriter(this.journalWriter);     // Catch: Throwable -> L46
        if (this.size <= this.maxSize) goto L40;
    L41:
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L46
    L42:
        monitor-exit(this);
        return;
    L40:
        if (journalRebuildRequired() == false) goto L42;
    L36:
        this.lruEntries.remove(Entry.access$1200(r0));     // Catch: Throwable -> L46
        this.journalWriter.append(REMOVE);     // Catch: Throwable -> L46
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L46
        this.journalWriter.append(Entry.access$1200(r0));     // Catch: Throwable -> L46
        this.journalWriter.append('\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    private boolean journalRebuildRequired() {
        int r0 = this.redundantOpCount;
        if (r0 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r0 < this.lruEntries.size()) goto L7;
        return true;
    }

    public synchronized boolean remove(String r7) throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L25
        Entry r0 = this.lruEntries.get(r7);     // Catch: Throwable -> L25
        int r1 = 0;
        if (r0 != null) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (Entry.access$800(r0) != null) goto L23;
    L9:
        if (r1 >= this.valueCount) goto L18;
        File r2 = r0.getCleanFile(r1);     // Catch: Throwable -> L25
        if (r2.exists() == false) goto L17;
        if (r2.delete() == true) goto L17;
        throw new IOException("failed to delete " + r2);     // Catch: Throwable -> L25
    L17:
        this.size -= Entry.access$1100(r0)[r1];     // Catch: Throwable -> L25
        Entry.access$1100(r0)[r1] = 0;     // Catch: Throwable -> L25
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L9
    L18:
        this.redundantOpCount++;     // Catch: Throwable -> L25
        this.journalWriter.append(REMOVE);     // Catch: Throwable -> L25
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L25
        this.journalWriter.append(r7);     // Catch: Throwable -> L25
        this.journalWriter.append('\n');     // Catch: Throwable -> L25
        this.lruEntries.remove(r7);     // Catch: Throwable -> L25
        if (journalRebuildRequired() == false) goto L21;
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return true;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.journalWriter != null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public synchronized void flush() throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L6
        trimToSize();     // Catch: Throwable -> L6
        flushWriter(this.journalWriter);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.journalWriter != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r0 = new ArrayList(this.lruEntries.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r0.hasNext() == false) goto L13;
        Entry r1 = (Entry) r0.next();     // Catch: Throwable -> L16
        if (Entry.access$800(r1) == null) goto L9;
        Entry.access$800(r1).abort();     // Catch: Throwable -> L16
        goto L9
    L13:
        trimToSize();     // Catch: Throwable -> L16
        closeWriter(this.journalWriter);     // Catch: Throwable -> L16
        this.journalWriter = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    private void trimToSize() throws IOException {
    L3:
        if (this.size <= this.maxSize) goto L5;
        remove(this.lruEntries.entrySet().iterator().next().getKey());
        goto L3
    }

    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    private static String inputStreamToString(InputStream r2) throws IOException {
        return Util.readFully(new InputStreamReader(r2, Util.UTF_8));
    }

    private static void closeWriter(Writer r2) throws IOException {
        StrictMode.ThreadPolicy r0 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r0).permitUnbufferedIo().build());
        r2.close();     // Catch: Throwable -> L6
        StrictMode.setThreadPolicy(r0);
        return;
    L6:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    }

    private static void flushWriter(Writer r2) throws IOException {
        StrictMode.ThreadPolicy r0 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r0).permitUnbufferedIo().build());
        r2.flush();     // Catch: Throwable -> L6
        StrictMode.setThreadPolicy(r0);
        return;
    L6:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    }
}
