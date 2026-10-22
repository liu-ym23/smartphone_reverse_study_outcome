package okhttp3;

import com.android.settings.utils.HanziToPinyin;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: MultipartReader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/ResponseBody;", "(Lokhttp3/ResponseBody;)V", "source", "Lokio/BufferedSource;", "boundary", "", "(Lokio/BufferedSource;Ljava/lang/String;)V", "()Ljava/lang/String;", "closed", "", "crlfDashDashBoundary", "Lokio/ByteString;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "dashDashBoundary", "noMoreParts", "partCount", "", "close", "", "currentPartBytesRemaining", "", "maxResult", "nextPart", "Lokhttp3/MultipartReader$Part;", "Companion", "Part", "PartSource", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultipartReader implements Closeable {
    public static final Companion Companion = null;
    private static final Options afterBoundaryOptions = null;
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final BufferedSource source;

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/MultipartReader$Companion;", "", "()V", "afterBoundaryOptions", "Lokio/Options;", "getAfterBoundaryOptions", "()Lokio/Options;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Options getAfterBoundaryOptions() {
            return MultipartReader.access$getAfterBoundaryOptions$cp();
        }
    }

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "headers", "Lokhttp3/Headers;", "body", "Lokio/BufferedSource;", "(Lokhttp3/Headers;Lokio/BufferedSource;)V", "()Lokio/BufferedSource;", "()Lokhttp3/Headers;", "close", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Part implements Closeable {
        private final BufferedSource body;
        private final Headers headers;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        public Part(Headers r2, BufferedSource r3) {
            Intrinsics.checkNotNullParameter(r2, "headers");
            Intrinsics.checkNotNullParameter(r3, "body");
            this.headers = r2;
            this.body = r3;
        }

        public final Headers headers() {
            return this.headers;
        }

        public final BufferedSource body() {
            return this.body;
        }
    }

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/MultipartReader$PartSource;", "Lokio/Source;", "(Lokhttp3/MultipartReader;)V", "timeout", "Lokio/Timeout;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class PartSource implements Source {
        final /* synthetic */ MultipartReader this$0;
        private final Timeout timeout;

        public PartSource(MultipartReader r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.timeout = new Timeout();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (Intrinsics.areEqual(MultipartReader.access$getCurrentPart$p(this.this$0), this) == false) goto L6;
            MultipartReader.access$setCurrentPart$p(this.this$0, null);
            return;
        }

        @Override // okio.Source
        public long read(Buffer r16, long r17) {
            Intrinsics.checkNotNullParameter(r16, "sink");
            if (r17 < 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L46;
            if (Intrinsics.areEqual(MultipartReader.access$getCurrentPart$p(this.this$0), this) == false) goto L44;
            Timeout r7 = MultipartReader.access$getSource$p(this.this$0).timeout();
            Timeout r8 = this.timeout;
            MultipartReader r0 = this.this$0;
            long r9 = r7.timeoutNanos();
            r7.timeout(Timeout.Companion.minTimeout(r8.timeoutNanos(), r7.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (r7.hasDeadline() == false) goto L28;
            long r13 = r7.deadlineNanoTime();
            if (r8.hasDeadline() == false) goto L47;
            r7.deadlineNanoTime(Math.min(r7.deadlineNanoTime(), r8.deadlineNanoTime()));
        L47:
            long r2 = MultipartReader.access$currentPartBytesRemaining(r0, r17);     // Catch: Throwable -> L22
            if (r2 != 0) goto L17;
            long r11 = -1;
        L18:
            r7.timeout(r9, TimeUnit.NANOSECONDS);
            if (r8.hasDeadline() == false) goto L21;
            r7.deadlineNanoTime(r13);
        L21:
            return r11;
        L17:
            r11 = MultipartReader.access$getSource$p(r0).read(r16, r2);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            r7.timeout(r9, TimeUnit.NANOSECONDS);
            if (r8.hasDeadline() == false) goto L26;
            r7.deadlineNanoTime(r13);
        L26:
            throw th;
        L28:
            if (r8.hasDeadline() == false) goto L49;
            r7.deadlineNanoTime(r8.deadlineNanoTime());
        L49:
            long r3 = MultipartReader.access$currentPartBytesRemaining(r0, r17);     // Catch: Throwable -> L38
            if (r3 != 0) goto L33;
            long r12 = -1;
        L34:
            r7.timeout(r9, TimeUnit.NANOSECONDS);
            if (r8.hasDeadline() == false) goto L37;
            r7.clearDeadline();
        L37:
            return r12;
        L33:
            r12 = MultipartReader.access$getSource$p(r0).read(r16, r3);     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            r7.timeout(r9, TimeUnit.NANOSECONDS);
            if (r8.hasDeadline() == false) goto L42;
            r7.clearDeadline();
        L42:
            throw th;
        L44:
            throw new IllegalStateException("closed".toString());
        L46:
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(r17)).toString());
        L5:
            r6 = false;
            goto L6
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public MultipartReader(BufferedSource r2, String r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "boundary");
        this.source = r2;
        this.boundary = r3;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(r3).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(r3).readByteString();
    }

    public static final /* synthetic */ long access$currentPartBytesRemaining(MultipartReader r0, long r1) {
        return r0.currentPartBytesRemaining(r1);
    }

    public static final /* synthetic */ Options access$getAfterBoundaryOptions$cp() {
        return afterBoundaryOptions;
    }

    public static final /* synthetic */ PartSource access$getCurrentPart$p(MultipartReader r0) {
        return r0.currentPart;
    }

    public static final /* synthetic */ BufferedSource access$getSource$p(MultipartReader r0) {
        return r0.source;
    }

    public static final /* synthetic */ void access$setCurrentPart$p(MultipartReader r0, PartSource r1) {
        r0.currentPart = r1;
    }

    public final String boundary() {
        return this.boundary;
    }

    public MultipartReader(ResponseBody r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, ApmTrafficStats.TTNET_RESPONSE);
        BufferedSource r0 = r3.source();
        MediaType r4 = r3.contentType();
        if (r4 != null) goto L5;
        String r5 = null;
    L6:
        if (r5 == null) goto L10;
        this(r0, r5);
        return;
    L10:
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    L5:
        r5 = r4.parameter("boundary");
        goto L6
    }

    public final Part nextPart() throws IOException {
        if ((!this.closed) == false) goto L41;
        if (this.noMoreParts == false) goto L8;
        return null;
    L8:
        if (this.partCount != 0) goto L12;
        if (this.source.rangeEquals(0, this.dashDashBoundary) == false) goto L12;
        this.source.skip(this.dashDashBoundary.size());
    L15:
        boolean r0 = false;
    L16:
        int r3 = this.source.select(afterBoundaryOptions);
        if (r3 == (-1)) goto L38;
        if (r3 == 0) goto L35;
        if (r3 == 1) goto L26;
        if (r3 == 2) goto L25;
        if (r3 != 3) goto L16;
    L25:
        r0 = true;
        goto L16
    L26:
        if (r0 == true) goto L34;
        if (this.partCount == 0) goto L32;
        this.noMoreParts = true;
        return null;
    L32:
        throw new ProtocolException("expected at least 1 part");
    L34:
        throw new ProtocolException("unexpected characters after boundary");
    L35:
        this.partCount++;
        Headers r1 = new HeadersReader(this.source).readHeaders();
        PartSource r2 = new PartSource(this);
        this.currentPart = r2;
        return new Part(r1, Okio.buffer(r2));
    L38:
        throw new ProtocolException("unexpected characters after boundary");
    L12:
        long r5 = currentPartBytesRemaining(8192);
        if (r5 == 0) goto L14;
        this.source.skip(r5);
        goto L12
    L14:
        this.source.skip(this.crlfDashDashBoundary.size());
        goto L15
    L41:
        throw new IllegalStateException("closed".toString());
    }

    private final long currentPartBytesRemaining(long r5) {
        this.source.require(this.crlfDashDashBoundary.size());
        long r0 = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        if (r0 != (-1)) goto L6;
        return Math.min(r5, (this.source.getBuffer().size() - ((long) this.crlfDashDashBoundary.size())) + 1);
    L6:
        return Math.min(r5, r0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    static {
        Companion = new Companion(null);
        afterBoundaryOptions = Options.Companion.of(new ByteString[]{ByteString.Companion.encodeUtf8("\r\n"), ByteString.Companion.encodeUtf8("--"), ByteString.Companion.encodeUtf8(HanziToPinyin.Token.SEPARATOR), ByteString.Companion.encodeUtf8("\t")});
    }
}
