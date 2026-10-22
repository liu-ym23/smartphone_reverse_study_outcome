package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Relay {
    public static final Companion Companion = null;
    private static final long FILE_HEADER_SIZE = 32;

    @JvmField
    @NotNull
    public static final ByteString PREFIX_CLEAN = null;

    @JvmField
    @NotNull
    public static final ByteString PREFIX_DIRTY = null;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;

    @NotNull
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;

    @Nullable
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;

    @Nullable
    private Source upstream;

    @NotNull
    private final Buffer upstreamBuffer;
    private long upstreamPos;

    @Nullable
    private Thread upstreamReader;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Relay edit(@NotNull File r10, @NotNull Source r11, @NotNull ByteString r12, long r13) {
            Intrinsics.f(r10, "file");
            Intrinsics.f(r11, "upstream");
            Intrinsics.f(r12, "metadata");
            RandomAccessFile r9 = new RandomAccessFile(r10, "rw");
            Relay r14 = new Relay(r9, r11, 0, r12, r13, null);
            r9.setLength(0);
            Relay.access$writeHeader(r14, Relay.PREFIX_DIRTY, -1, -1);
            return r14;
        }

        @NotNull
        public final Relay read(@NotNull File r11) {
            Intrinsics.f(r11, "file");
            RandomAccessFile r1 = new RandomAccessFile(r11, "rw");
            FileChannel r12 = r1.getChannel();
            Intrinsics.e(r12, "randomAccessFile.channel");
            FileOperator r10 = new FileOperator(r12);
            Buffer r13 = new Buffer();
            r10.read(0, r13, 32);
            ByteString r0 = Relay.PREFIX_CLEAN;
            if ((!Intrinsics.a(r13.readByteString(r0.size()), r0)) == true) goto L7;
            long r8 = r13.readLong();
            long r6 = r13.readLong();
            Buffer r14 = new Buffer();
            r10.read(r8 + 32, r14, r6);
            return new Relay(r1, null, r8, r14.readByteString(), 0, null);
        L7:
            throw new IOException("unreadable cache file");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        private final Timeout timeout;

        public RelaySource(Relay r3) {
            this.this$0 = r3;
            this.timeout = new Timeout();
            RandomAccessFile r4 = r3.getFile();
            Intrinsics.c(r4);
            FileChannel r5 = r4.getChannel();
            Intrinsics.e(r5, "file!!.channel");
            this.fileOperator = new FileOperator(r5);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.fileOperator != null) goto L5;
            return;
        L5:
            RandomAccessFile r0 = null;
            this.fileOperator = null;
            Relay r1 = this.this$0;
            monitor-enter(r1);
            Relay r2 = this.this$0;     // Catch: Throwable -> L11
            r2.setSourceCount(r2.getSourceCount() - 1);     // Catch: Throwable -> L11
            if (this.this$0.getSourceCount() != 0) goto L13;
            RandomAccessFile r3 = this.this$0.getFile();     // Catch: Throwable -> L11
            this.this$0.setFile(null);     // Catch: Throwable -> L11
            r0 = r3;
        L13:
            monitor-exit(r1);
            if (r0 == null) goto L21;
            Util.closeQuietly(r0);
            return;
        L21:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer r20, long r21) {
            Intrinsics.f(r20, "sink");
            char r4 = 1;
            if (this.fileOperator == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L91;
            Relay r8 = this.this$0;
            monitor-enter(r8);
        L93:
        L17:
            th = move-exception;
            throw th;
        L10:
            if (this.sourcePos != this.this$0.getUpstreamPos()) goto L11;
            if (this.this$0.getComplete() == true) goto L21;
            if (this.this$0.getUpstreamReader() == null) goto L26;
            this.timeout.waitUntilNotified(this.this$0);     // Catch: Throwable -> L17
            goto L93
        L26:
            this.this$0.setUpstreamReader(Thread.currentThread());     // Catch: Throwable -> L17
        L27:
            monitor-exit(r8);
            if (r4 != 2) goto L92;
            long r9 = Math.min(r21, this.this$0.getUpstreamPos() - this.sourcePos);
            FileOperator r2 = this.fileOperator;
            Intrinsics.c(r2);
            r2.read(this.sourcePos + 32, r20, r9);
            this.sourcePos += r9;
            return r9;
        L92:
            Source r1 = this.this$0.getUpstream();     // Catch: Throwable -> L49
            Intrinsics.c(r1);     // Catch: Throwable -> L49
            long r14 = r1.read(this.this$0.getUpstreamBuffer(), this.this$0.getBufferMaxSize());     // Catch: Throwable -> L49
            if (r14 != (-1)) goto L51;
            Relay r3 = this.this$0;     // Catch: Throwable -> L49
            r3.commit(r3.getUpstreamPos());     // Catch: Throwable -> L49
            Relay r5 = this.this$0;
            monitor-enter(r5);
            this.this$0.setUpstreamReader(null);     // Catch: Throwable -> L43
            Relay r6 = this.this$0;     // Catch: Throwable -> L43
            if (r6 == null) goto L46;
            r6.notifyAll();     // Catch: Throwable -> L43
            monitor-exit(r5);
            return -1;
        L46:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            throw th;
        L51:
            long r10 = Math.min(r14, r21);     // Catch: Throwable -> L49
            this.this$0.getUpstreamBuffer().copyTo(r20, 0, r10);     // Catch: Throwable -> L49
            this.sourcePos += r10;     // Catch: Throwable -> L49
            FileOperator r13 = this.fileOperator;     // Catch: Throwable -> L49
            Intrinsics.c(r13);     // Catch: Throwable -> L49
            r13.write(this.this$0.getUpstreamPos() + 32, this.this$0.getUpstreamBuffer().m183clone(), r14);     // Catch: Throwable -> L49
            Relay r7 = this.this$0;     // Catch: Throwable -> L49
            monitor-enter(r7);     // Catch: Throwable -> L49
            this.this$0.getBuffer().write(this.this$0.getUpstreamBuffer(), r14);     // Catch: Throwable -> L56
            if (this.this$0.getBuffer().size() <= this.this$0.getBufferMaxSize()) goto L58;
            this.this$0.getBuffer().skip(this.this$0.getBuffer().size() - this.this$0.getBufferMaxSize());     // Catch: Throwable -> L56
        L58:
            Relay r11 = this.this$0;     // Catch: Throwable -> L56
            r11.setUpstreamPos(r11.getUpstreamPos() + r14);     // Catch: Throwable -> L56
            monitor-exit(r7);     // Catch: Throwable -> L49
            Relay r12 = this.this$0;
            monitor-enter(r12);
            this.this$0.setUpstreamReader(null);     // Catch: Throwable -> L67
            Relay r15 = this.this$0;     // Catch: Throwable -> L67
            if (r15 == null) goto L70;
            r15.notifyAll();     // Catch: Throwable -> L67
            monitor-exit(r12);
            return r10;
        L70:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L67
        L67:
            th = move-exception;
            throw th;
        L56:
            th = move-exception;
            throw th;     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            monitor-enter(this.this$0);
            this.this$0.setUpstreamReader(null);     // Catch: Throwable -> L81
            Relay r16 = this.this$0;     // Catch: Throwable -> L81
            if (r16 == null) goto L80;
            r16.notifyAll();     // Catch: Throwable -> L81
            throw th;
        L80:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L81
        L81:
            th = move-exception;
            throw th;
        L21:
            monitor-exit(r8);
            return -1;
        L11:
            long r17 = this.this$0.getUpstreamPos() - this.this$0.getBuffer().size();     // Catch: Throwable -> L17
            if (this.sourcePos >= r17) goto L14;
            r4 = 2;
            goto L27
        L14:
            long r18 = Math.min(r21, this.this$0.getUpstreamPos() - this.sourcePos);     // Catch: Throwable -> L17
            this.this$0.getBuffer().copyTo(r20, this.sourcePos - r17, r18);     // Catch: Throwable -> L17
            this.sourcePos += r18;     // Catch: Throwable -> L17
            monitor-exit(r8);
            return r18;
        L91:
            throw new IllegalStateException("Check failed.".toString());
        L5:
            r0 = false;
            goto L6
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        Companion = new Companion(null);
        ByteString.Companion r0 = ByteString.Companion;
        PREFIX_CLEAN = r0.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = r0.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile r1, Source r2, long r3, ByteString r5, long r6) {
        this.file = r1;
        this.upstream = r2;
        this.upstreamPos = r3;
        this.metadata = r5;
        this.bufferMaxSize = r6;
        this.upstreamBuffer = new Buffer();
        if (this.upstream != null) goto L5;
        boolean r4 = true;
    L6:
        this.complete = r4;
        this.buffer = new Buffer();
        return;
    L5:
        r4 = false;
        goto L6
    }

    public static final /* synthetic */ void access$writeHeader(Relay r0, ByteString r1, long r2, long r4) {
        r0.writeHeader(r1, r2, r4);
    }

    private final void writeHeader(ByteString r2, long r3, long r5) {
        Buffer r0 = new Buffer();
        r0.write(r2);
        r0.writeLong(r3);
        r0.writeLong(r5);
        if (r0.size() != 32) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L10;
        RandomAccessFile r1 = this.file;
        Intrinsics.c(r1);
        FileChannel r6 = r1.getChannel();
        Intrinsics.e(r6, "file!!.channel");
        new FileOperator(r6).write(0, r0, 32);
        return;
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r4 = false;
        goto L6
    }

    private final void writeMetadata(long r7) {
        Buffer r3 = new Buffer();
        r3.write(this.metadata);
        RandomAccessFile r1 = this.file;
        Intrinsics.c(r1);
        FileChannel r2 = r1.getChannel();
        Intrinsics.e(r2, "file!!.channel");
        new FileOperator(r2).write(32 + r7, r3, this.metadata.size());
    }

    public final void commit(long r9) {
        writeMetadata(r9);
        RandomAccessFile r0 = this.file;
        Intrinsics.c(r0);
        r0.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, r9, this.metadata.size());
        RandomAccessFile r10 = this.file;
        Intrinsics.c(r10);
        r10.getChannel().force(false);
        monitor-enter(this);
        this.complete = true;     // Catch: Throwable -> L12
        monitor-exit(this);
        Source r11 = this.upstream;
        if (r11 == null) goto L10;
        Util.closeQuietly(r11);
    L10:
        this.upstream = null;
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        if (this.file != null) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public final ByteString metadata() {
        return this.metadata;
    }

    @Nullable
    public final Source newSource() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.file != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.sourceCount++;     // Catch: Throwable -> L12
        monitor-exit(this);
        return new RelaySource(this);
    }

    public final void setComplete(boolean r1) {
        this.complete = r1;
    }

    public final void setFile(@Nullable RandomAccessFile r1) {
        this.file = r1;
    }

    public final void setSourceCount(int r1) {
        this.sourceCount = r1;
    }

    public final void setUpstream(@Nullable Source r1) {
        this.upstream = r1;
    }

    public final void setUpstreamPos(long r1) {
        this.upstreamPos = r1;
    }

    public final void setUpstreamReader(@Nullable Thread r1) {
        this.upstreamReader = r1;
    }

    public /* synthetic */ Relay(RandomAccessFile r1, Source r2, long r3, ByteString r5, long r6, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r5, r6);
    }
}
