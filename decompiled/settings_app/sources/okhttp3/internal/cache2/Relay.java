package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: Relay.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B3\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u00105\u001a\u0004\u0018\u00010\u0005J \u00106\u001a\u0002032\u0006\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006<"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", "metadata", "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Relay {
    public static final Companion Companion = null;
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN = null;
    public static final ByteString PREFIX_DIRTY = null;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* JADX INFO: compiled from: Relay.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Relay edit(File r10, Source r11, ByteString r12, long r13) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "file");
            Intrinsics.checkNotNullParameter(r11, "upstream");
            Intrinsics.checkNotNullParameter(r12, "metadata");
            RandomAccessFile r9 = new RandomAccessFile(r10, "rw");
            Relay r14 = new Relay(r9, r11, 0, r12, r13, null);
            r9.setLength(0);
            Relay.access$writeHeader(r14, Relay.PREFIX_DIRTY, -1, -1);
            return r14;
        }

        public final Relay read(File r11) throws IOException {
            Intrinsics.checkNotNullParameter(r11, "file");
            RandomAccessFile r1 = new RandomAccessFile(r11, "rw");
            FileChannel r12 = r1.getChannel();
            Intrinsics.checkNotNullExpressionValue(r12, "randomAccessFile.channel");
            FileOperator r10 = new FileOperator(r12);
            Buffer r13 = new Buffer();
            r10.read(0, r13, 32);
            if (Intrinsics.areEqual(r13.readByteString(Relay.PREFIX_CLEAN.size()), Relay.PREFIX_CLEAN) == false) goto L7;
            long r8 = r13.readLong();
            long r6 = r13.readLong();
            Buffer r14 = new Buffer();
            r10.read(r8 + 32, r14, r6);
            return new Relay(r1, null, r8, r14.readByteString(), 0, null);
        L7:
            throw new IOException("unreadable cache file");
        }
    }

    /* JADX INFO: compiled from: Relay.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", "timeout", "Lokio/Timeout;", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        private final Timeout timeout;

        public RelaySource(Relay r3) {
            Intrinsics.checkNotNullParameter(r3, "this$0");
            this.this$0 = r3;
            this.timeout = new Timeout();
            RandomAccessFile r4 = r3.getFile();
            Intrinsics.checkNotNull(r4);
            FileChannel r5 = r4.getChannel();
            Intrinsics.checkNotNullExpressionValue(r5, "file!!.channel");
            this.fileOperator = new FileOperator(r5);
        }

        @Override // okio.Source
        public long read(Buffer r20, long r21) throws IOException {
            Intrinsics.checkNotNullParameter(r20, "sink");
            char r4 = 1;
            if (this.fileOperator == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L73;
            Relay r8 = this.this$0;
            monitor-enter(r8);
        L76:
        L69:
            th = move-exception;
            throw th;
        L10:
            if (this.sourcePos != r8.getUpstreamPos()) goto L11;
            if (r8.getComplete() == true) goto L19;
            if (r8.getUpstreamReader() == null) goto L24;
            this.timeout.waitUntilNotified(r8);     // Catch: Throwable -> L69
            goto L76
        L24:
            r8.setUpstreamReader(Thread.currentThread());     // Catch: Throwable -> L69
        L25:
            monitor-exit(r8);
            if (r4 != 2) goto L83;
            long r9 = Math.min(r21, this.this$0.getUpstreamPos() - this.sourcePos);
            FileOperator r2 = this.fileOperator;
            Intrinsics.checkNotNull(r2);
            r2.read(this.sourcePos + 32, r20, r9);
            this.sourcePos += r9;
            return r9;
        L83:
            Source r1 = this.this$0.getUpstream();     // Catch: Throwable -> L60
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L60
            long r14 = r1.read(this.this$0.getUpstreamBuffer(), this.this$0.getBufferMaxSize());     // Catch: Throwable -> L60
            if (r14 != (-1)) goto L42;
            Relay r3 = this.this$0;     // Catch: Throwable -> L60
            r3.commit(r3.getUpstreamPos());     // Catch: Throwable -> L60
            Relay r5 = this.this$0;
            monitor-enter(r5);
            r5.setUpstreamReader(null);     // Catch: Throwable -> L39
            r5.notifyAll();     // Catch: Throwable -> L39
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L39
            monitor-exit(r5);
            return -1;
        L39:
            th = move-exception;
            throw th;
        L42:
            long r10 = Math.min(r14, r21);     // Catch: Throwable -> L60
            this.this$0.getUpstreamBuffer().copyTo(r20, 0, r10);     // Catch: Throwable -> L60
            this.sourcePos += r10;     // Catch: Throwable -> L60
            FileOperator r13 = this.fileOperator;     // Catch: Throwable -> L60
            Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L60
            r13.write(this.this$0.getUpstreamPos() + 32, this.this$0.getUpstreamBuffer().m3226clone(), r14);     // Catch: Throwable -> L60
            Relay r7 = this.this$0;     // Catch: Throwable -> L60
            monitor-enter(r7);     // Catch: Throwable -> L60
            r7.getBuffer().write(r7.getUpstreamBuffer(), r14);     // Catch: Throwable -> L57
            if (r7.getBuffer().size() <= r7.getBufferMaxSize()) goto L47;
            r7.getBuffer().skip(r7.getBuffer().size() - r7.getBufferMaxSize());     // Catch: Throwable -> L57
        L47:
            r7.setUpstreamPos(r7.getUpstreamPos() + r14);     // Catch: Throwable -> L57
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L57
            monitor-exit(r7);     // Catch: Throwable -> L60
            Relay r12 = this.this$0;
            monitor-enter(r12);
            r12.setUpstreamReader(null);     // Catch: Throwable -> L54
            r12.notifyAll();     // Catch: Throwable -> L54
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L54
            monitor-exit(r12);
            return r10;
        L54:
            th = move-exception;
            throw th;
        L57:
            th = move-exception;
            throw th;     // Catch: Throwable -> L60
        L60:
            th = move-exception;
            Relay r16 = this.this$0;
            monitor-enter(r16);
            r16.setUpstreamReader(null);     // Catch: Throwable -> L66
            r16.notifyAll();     // Catch: Throwable -> L66
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L66
            throw th;
        L66:
            th = move-exception;
            throw th;
        L19:
            monitor-exit(r8);
            return -1;
        L11:
            long r18 = r8.getUpstreamPos() - r8.getBuffer().size();     // Catch: Throwable -> L69
            if (this.sourcePos >= r18) goto L14;
            r4 = 2;
            goto L25
        L14:
            long r19 = Math.min(r21, r8.getUpstreamPos() - this.sourcePos);     // Catch: Throwable -> L69
            r8.getBuffer().copyTo(r20, this.sourcePos - r18, r19);     // Catch: Throwable -> L69
            this.sourcePos += r19;     // Catch: Throwable -> L69
            monitor-exit(r8);
            return r19;
        L73:
            throw new IllegalStateException("Check failed.".toString());
        L5:
            r0 = false;
            goto L6
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator != null) goto L5;
            return;
        L5:
            RandomAccessFile r0 = null;
            this.fileOperator = null;
            Relay r2 = this.this$0;
            monitor-enter(r2);
            r2.setSourceCount(r2.getSourceCount() - 1);     // Catch: Throwable -> L16
            if (r2.getSourceCount() != 0) goto L10;
            RandomAccessFile r1 = r2.getFile();     // Catch: Throwable -> L16
            r2.setFile(null);     // Catch: Throwable -> L16
            r0 = r1;
        L10:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(r2);
            if (r0 == null) goto L21;
            Util.closeQuietly(r0);
            return;
        L21:
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public /* synthetic */ Relay(RandomAccessFile r1, Source r2, long r3, ByteString r5, long r6, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r5, r6);
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

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final void setFile(RandomAccessFile r1) {
        this.file = r1;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final void setUpstream(Source r1) {
        this.upstream = r1;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final void setUpstreamPos(long r1) {
        this.upstreamPos = r1;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final void setUpstreamReader(Thread r1) {
        this.upstreamReader = r1;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final void setComplete(boolean r1) {
        this.complete = r1;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final void setSourceCount(int r1) {
        this.sourceCount = r1;
    }

    public final boolean isClosed() {
        if (this.file != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void writeHeader(ByteString r2, long r3, long r5) throws IOException {
        Buffer r0 = new Buffer();
        r0.write(r2);
        r0.writeLong(r3);
        r0.writeLong(r5);
        if (r0.size() != 32) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L10;
        RandomAccessFile r1 = this.file;
        Intrinsics.checkNotNull(r1);
        FileChannel r6 = r1.getChannel();
        Intrinsics.checkNotNullExpressionValue(r6, "file!!.channel");
        new FileOperator(r6).write(0, r0, 32);
        return;
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r4 = false;
        goto L6
    }

    private final void writeMetadata(long r7) throws IOException {
        Buffer r3 = new Buffer();
        r3.write(this.metadata);
        RandomAccessFile r1 = this.file;
        Intrinsics.checkNotNull(r1);
        FileChannel r2 = r1.getChannel();
        Intrinsics.checkNotNullExpressionValue(r2, "file!!.channel");
        new FileOperator(r2).write(32 + r7, r3, this.metadata.size());
    }

    public final void commit(long r9) throws IOException {
        writeMetadata(r9);
        RandomAccessFile r0 = this.file;
        Intrinsics.checkNotNull(r0);
        r0.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, r9, this.metadata.size());
        RandomAccessFile r10 = this.file;
        Intrinsics.checkNotNull(r10);
        r10.getChannel().force(false);
        monitor-enter(this);
        setComplete(true);     // Catch: Throwable -> L13
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        Source r12 = this.upstream;
        if (r12 == null) goto L11;
        Util.closeQuietly(r12);
    L11:
        this.upstream = null;
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (getFile() != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        setSourceCount(getSourceCount() + 1);     // Catch: Throwable -> L12
        monitor-exit(this);
        return new RelaySource(this);
    }

    static {
        Companion = new Companion(null);
        PREFIX_CLEAN = ByteString.Companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = ByteString.Companion.encodeUtf8("OkHttp DIRTY :(\n");
    }
}
