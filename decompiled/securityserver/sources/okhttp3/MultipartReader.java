package okhttp3;

import a.a;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.Closeable;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MultipartReader implements Closeable {
    public static final Companion Companion = null;

    @NotNull
    private static final Options afterBoundaryOptions = null;

    @NotNull
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final BufferedSource source;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Options getAfterBoundaryOptions() {
            return MultipartReader.access$getAfterBoundaryOptions$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class Part implements Closeable {

        @NotNull
        private final BufferedSource body;

        @NotNull
        private final Headers headers;

        public Part(@NotNull Headers r2, @NotNull BufferedSource r3) {
            Intrinsics.f(r2, "headers");
            Intrinsics.f(r3, "body");
            this.headers = r2;
            this.body = r3;
        }

        @JvmName
        @NotNull
        public final BufferedSource body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        @JvmName
        @NotNull
        public final Headers headers() {
            return this.headers;
        }
    }

    @Metadata
    public final class PartSource implements Source {
        final /* synthetic */ MultipartReader this$0;
        private final Timeout timeout;

        public PartSource(MultipartReader r1) {
            this.this$0 = r1;
            this.timeout = new Timeout();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (Intrinsics.a(MultipartReader.access$getCurrentPart$p(this.this$0), this) == false) goto L6;
            MultipartReader.access$setCurrentPart$p(this.this$0, null);
            return;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer r17, long r18) {
            Intrinsics.f(r17, "sink");
            if (r18 < 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L46;
            if (Intrinsics.a(MultipartReader.access$getCurrentPart$p(this.this$0), this) == false) goto L44;
            Timeout r7 = MultipartReader.access$getSource$p(this.this$0).timeout();
            Timeout r8 = this.timeout;
            long r9 = r7.timeoutNanos();
            long r10 = Timeout.Companion.minTimeout(r8.timeoutNanos(), r7.timeoutNanos());
            TimeUnit r12 = TimeUnit.NANOSECONDS;
            r7.timeout(r10, r12);
            if (r7.hasDeadline() == false) goto L28;
            long r11 = r7.deadlineNanoTime();
            if (r8.hasDeadline() == false) goto L47;
            r7.deadlineNanoTime(Math.min(r7.deadlineNanoTime(), r8.deadlineNanoTime()));
        L47:
            long r2 = MultipartReader.access$currentPartBytesRemaining(this.this$0, r18);     // Catch: Throwable -> L22
            if (r2 != 0) goto L17;
            long r13 = -1;
        L18:
            r7.timeout(r9, r12);
            if (r8.hasDeadline() == false) goto L21;
            r7.deadlineNanoTime(r11);
        L21:
            return r13;
        L17:
            r13 = MultipartReader.access$getSource$p(this.this$0).read(r17, r2);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            r7.timeout(r9, TimeUnit.NANOSECONDS);
            if (r8.hasDeadline() == false) goto L26;
            r7.deadlineNanoTime(r11);
        L26:
            throw th;
        L28:
            if (r8.hasDeadline() == false) goto L49;
            r7.deadlineNanoTime(r8.deadlineNanoTime());
        L49:
            long r3 = MultipartReader.access$currentPartBytesRemaining(this.this$0, r18);     // Catch: Throwable -> L38
            if (r3 != 0) goto L33;
            long r14 = -1;
        L34:
            r7.timeout(r9, r12);
            if (r8.hasDeadline() == false) goto L37;
            r7.clearDeadline();
        L37:
            return r14;
        L33:
            r14 = MultipartReader.access$getSource$p(this.this$0).read(r17, r3);     // Catch: Throwable -> L38
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
            throw new IllegalArgumentException(a.h("byteCount < 0: ", r18).toString());
        L5:
            r6 = false;
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
        Options.Companion r0 = Options.Companion;
        ByteString.Companion r1 = ByteString.Companion;
        afterBoundaryOptions = r0.of(new ByteString[]{r1.encodeUtf8("\r\n"), r1.encodeUtf8("--"), r1.encodeUtf8(" "), r1.encodeUtf8("\t")});
    }

    public MultipartReader(@NotNull BufferedSource r2, @NotNull String r3) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.f(r3, "boundary");
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

    private final long currentPartBytesRemaining(long r5) {
        this.source.require(this.crlfDashDashBoundary.size());
        long r0 = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        if (r0 != (-1)) goto L6;
        return Math.min(r5, (this.source.getBuffer().size() - ((long) this.crlfDashDashBoundary.size())) + 1);
    L6:
        return Math.min(r5, r0);
    }

    @JvmName
    @NotNull
    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    @Nullable
    public final Part nextPart() {
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
        long r5 = currentPartBytesRemaining(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (r5 == 0) goto L14;
        this.source.skip(r5);
        goto L12
    L14:
        this.source.skip(this.crlfDashDashBoundary.size());
        goto L15
    L41:
        throw new IllegalStateException("closed".toString());
    }

    public MultipartReader(@NotNull ResponseBody r3) {
        Intrinsics.f(r3, ApmTrafficStats.TTNET_RESPONSE);
        BufferedSource r0 = r3.source();
        MediaType r4 = r3.contentType();
        if (r4 == null) goto L9;
        String r5 = r4.parameter("boundary");
        if (r5 == null) goto L9;
        this(r0, r5);
        return;
    L9:
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
