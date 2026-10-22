package okhttp3.internal.http2;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.dao.DBHelper;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Http2Reader implements Closeable {
    public static final Companion Companion = null;

    @NotNull
    private static final Logger logger = null;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Logger getLogger() {
            return Http2Reader.access$getLogger$cp();
        }

        public final int lengthWithoutPadding(int r2, int r3, int r4) {
            if ((r3 & 8) == 0) goto L5;
            r2 = r2 - 1;
        L5:
            if (r4 > r2) goto L9;
            return r2 - r4;
        L9:
            throw new IOException("PROTOCOL_ERROR padding " + r4 + " > remaining length " + r2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(@NotNull BufferedSource r2) {
            Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
            this.source = r2;
        }

        private final void readContinuationHeader() {
            int r0 = this.streamId;
            int r1 = Util.readMedium(this.source);
            this.left = r1;
            this.length = r1;
            int r2 = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion r3 = Http2Reader.Companion;
            if (r3.getLogger().isLoggable(Level.FINE) == false) goto L5;
            r3.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, r2, this.flags));
        L5:
            int r4 = this.source.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.streamId = r4;
            if (r2 != 9) goto L12;
            if (r4 != r0) goto L10;
            return;
        L10:
            throw new IOException("TYPE_CONTINUATION streamId changed");
        L12:
            throw new IOException(r2 + " != TYPE_CONTINUATION");
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer r7, long r8) {
            Intrinsics.f(r7, "sink");
        L3:
            int r0 = this.left;
            if (r0 != 0) goto L9;
            this.source.skip(this.padding);
            this.padding = 0;
            if ((this.flags & 4) != 0) goto L7;
            readContinuationHeader();
            goto L3
        L7:
            return -1;
        L9:
            long r9 = this.source.read(r7, Math.min(r8, r0));
            if (r9 != (-1)) goto L12;
            return -1;
        L12:
            this.left -= (int) r9;
            return r9;
        }

        public final void setFlags(int r1) {
            this.flags = r1;
        }

        public final void setLeft(int r1) {
            this.left = r1;
        }

        public final void setLength(int r1) {
            this.length = r1;
        }

        public final void setPadding(int r1) {
            this.padding = r1;
        }

        public final void setStreamId(int r1) {
            this.streamId = r1;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    @Metadata
    public interface Handler {
        void ackSettings();

        void alternateService(int r1, @NotNull String r2, @NotNull ByteString r3, @NotNull String r4, int r5, long r6);

        void data(boolean r1, int r2, @NotNull BufferedSource r3, int r4);

        void goAway(int r1, @NotNull ErrorCode r2, @NotNull ByteString r3);

        void headers(boolean r1, int r2, int r3, @NotNull List<Header> r4);

        void ping(boolean r1, int r2, int r3);

        void priority(int r1, int r2, int r3, boolean r4);

        void pushPromise(int r1, int r2, @NotNull List<Header> r3);

        void rstStream(int r1, @NotNull ErrorCode r2);

        void settings(boolean r1, @NotNull Settings r2);

        void windowUpdate(int r1, long r2);
    }

    static {
        Companion = new Companion(null);
        Logger r0 = Logger.getLogger(Http2.class.getName());
        Intrinsics.e(r0, "Logger.getLogger(Http2::class.java.name)");
        logger = r0;
    }

    public Http2Reader(@NotNull BufferedSource r8, boolean r9) {
        Intrinsics.f(r8, DBHelper.BATTERY_COL_SOURCE);
        this.source = r8;
        this.client = r9;
        ContinuationSource r2 = new ContinuationSource(r8);
        this.continuation = r2;
        this.hpackReader = new Hpack.Reader(r2, 4096, 0, 4, null);
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }

    private final void readData(Handler r4, int r5, int r6, int r7) {
        if (r7 == 0) goto L17;
        int r1 = 0;
        if ((r6 & 1) == 0) goto L6;
        boolean r0 = true;
    L8:
        if ((r6 & 32) != 0) goto L15;
        if ((r6 & 8) == 0) goto L12;
        r1 = Util.and(this.source.readByte(), 255);
    L12:
        r4.data(r0, r7, this.source, Companion.lengthWithoutPadding(r5, r6, r1));
        this.source.skip(r1);
        return;
    L15:
        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
    L6:
        r0 = false;
        goto L8
    L17:
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void readGoAway(Handler r3, int r4, int r5, int r6) {
        if (r4 < 8) goto L17;
        if (r6 != 0) goto L15;
        int r7 = this.source.readInt();
        int r0 = this.source.readInt();
        int r8 = r4 - 8;
        ErrorCode r9 = ErrorCode.Companion.fromHttp2(r0);
        if (r9 == null) goto L13;
        ByteString r1 = ByteString.EMPTY;
        if (r8 <= 0) goto L10;
        r1 = this.source.readByteString(r8);
    L10:
        r3.goAway(r7, r9, r1);
        return;
    L13:
        throw new IOException(a.e(r0, "TYPE_GOAWAY unexpected error code: "));
    L15:
        throw new IOException("TYPE_GOAWAY streamId != 0");
    L17:
        throw new IOException(a.e(r4, "TYPE_GOAWAY length < 8: "));
    }

    private final List<Header> readHeaderBlock(int r2, int r3, int r4, int r5) {
        this.continuation.setLeft(r2);
        ContinuationSource r6 = this.continuation;
        r6.setLength(r6.getLeft());
        this.continuation.setPadding(r3);
        this.continuation.setFlags(r4);
        this.continuation.setStreamId(r5);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler r4, int r5, int r6, int r7) {
        if (r7 == 0) goto L16;
        int r1 = 0;
        if ((r6 & 1) == 0) goto L6;
        boolean r0 = true;
    L8:
        if ((r6 & 8) == 0) goto L11;
        r1 = Util.and(this.source.readByte(), 255);
    L11:
        if ((r6 & 32) == 0) goto L13;
        readPriority(r4, r7);
        r5 = r5 - 5;
    L13:
        r4.headers(r0, r7, -1, readHeaderBlock(Companion.lengthWithoutPadding(r5, r6, r1), r1, r6, r7));
        return;
    L6:
        r0 = false;
        goto L8
    L16:
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void readPing(Handler r2, int r3, int r4, int r5) {
        if (r3 != 8) goto L14;
        if (r5 != 0) goto L12;
        int r6 = this.source.readInt();
        int r1 = this.source.readInt();
        boolean r7 = true;
        if ((r4 & 1) != 0) goto L9;
        r7 = false;
    L9:
        r2.ping(r7, r6, r1);
        return;
    L12:
        throw new IOException("TYPE_PING streamId != 0");
    L14:
        throw new IOException(a.e(r3, "TYPE_PING length != 8: "));
    }

    private final void readPriority(Handler r1, int r2, int r3, int r4) {
        if (r2 != 5) goto L10;
        if (r4 == 0) goto L8;
        readPriority(r1, r4);
        return;
    L8:
        throw new IOException("TYPE_PRIORITY streamId == 0");
    L10:
        throw new IOException(a.f(r2, "TYPE_PRIORITY length: ", " != 5"));
    }

    private final void readPushPromise(Handler r4, int r5, int r6, int r7) {
        if (r7 == 0) goto L10;
        if ((r6 & 8) == 0) goto L6;
        int r0 = Util.and(this.source.readByte(), 255);
    L7:
        r4.pushPromise(r7, this.source.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, readHeaderBlock(Companion.lengthWithoutPadding(r5 - 4, r6, r0), r0, r6, r7));
        return;
    L6:
        r0 = 0;
        goto L7
    L10:
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void readRstStream(Handler r1, int r2, int r3, int r4) {
        if (r2 != 4) goto L14;
        if (r4 == 0) goto L12;
        int r0 = this.source.readInt();
        ErrorCode r5 = ErrorCode.Companion.fromHttp2(r0);
        if (r5 == null) goto L10;
        r1.rstStream(r4, r5);
        return;
    L10:
        throw new IOException(a.e(r0, "TYPE_RST_STREAM unexpected error code: "));
    L12:
        throw new IOException("TYPE_RST_STREAM streamId == 0");
    L14:
        throw new IOException(a.f(r2, "TYPE_RST_STREAM length: ", " != 4"));
    }

    private final void readSettings(Handler r8, int r9, int r10, int r11) {
        if (r11 != 0) goto L50;
        if ((r10 & 1) == 0) goto L11;
        if (r9 != 0) goto L9;
        r8.ackSettings();
        return;
    L9:
        throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
    L11:
        if ((r9 % 6) != 0) goto L48;
        Settings r12 = new Settings();
        IntProgression r13 = RangesKt.d(RangesKt.e(0, r9), 6);
        int r1 = r13.b;
        int r2 = r13.c;
        int r14 = r13.e;
        if (r14 < 0) goto L16;
        if (r1 <= r2) goto L17;
    L45:
        r8.settings(false, r12);
        return;
    L17:
        int r3 = Util.and(this.source.readShort(), 65535);
        int r4 = this.source.readInt();
        if (r3 != 2) goto L20;
        if (r4 == 0) goto L42;
        if (r4 == 1) goto L42;
        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
    L42:
        r12.set(r3, r4);
        if (r1 == r2) goto L45;
        r1 = r1 + r14;
        goto L17
    L20:
        if (r3 == 3) goto L36;
        if (r3 != 4) goto L23;
        if (r4 < 0) goto L35;
        r3 = 7;
        goto L42
    L35:
        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
    L23:
        if (r3 != 5) goto L42;
        if (r4 < 16384) goto L31;
        if (r4 <= 16777215) goto L42;
    L31:
        throw new IOException(a.e(r4, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
    L36:
        r3 = 4;
        goto L42
    L16:
        if (r1 < r2) goto L45;
    L48:
        throw new IOException(a.e(r9, "TYPE_SETTINGS length % 6 != 0: "));
    L50:
        throw new IOException("TYPE_SETTINGS streamId != 0");
    }

    private final void readWindowUpdate(Handler r3, int r4, int r5, int r6) {
        if (r4 != 4) goto L11;
        long r7 = Util.and(this.source.readInt(), 2147483647L);
        if (r7 == 0) goto L9;
        r3.windowUpdate(r6, r7);
        return;
    L9:
        throw new IOException("windowSizeIncrement was 0");
    L11:
        throw new IOException(a.e(r4, "TYPE_WINDOW_UPDATE length !=4: "));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    public final boolean nextFrame(boolean r12, @NotNull Handler r13) {
        Intrinsics.f(r13, "handler");
        this.source.require(9);     // Catch: EOFException -> L30
        int r0 = Util.readMedium(this.source);
        if (r0 > 16384) goto L29;
        int r7 = Util.and(this.source.readByte(), 255);
        int r8 = Util.and(this.source.readByte(), 255);
        int r9 = this.source.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        Logger r10 = logger;
        if (r10.isLoggable(Level.FINE) == false) goto L9;
        r10.fine(Http2.INSTANCE.frameLog(true, r9, r0, r7, r8));
    L9:
        if (r12 == true) goto L11;
    L15:
        switch(r7) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        this.source.skip(r0);
        return true;
    L17:
        readWindowUpdate(r13, r0, r8, r9);
        return true;
    L18:
        readGoAway(r13, r0, r8, r9);
        return true;
    L19:
        readPing(r13, r0, r8, r9);
        return true;
    L20:
        readPushPromise(r13, r0, r8, r9);
        return true;
    L21:
        readSettings(r13, r0, r8, r9);
        return true;
    L22:
        readRstStream(r13, r0, r8, r9);
        return true;
    L23:
        readPriority(r13, r0, r8, r9);
        return true;
    L24:
        readHeaders(r13, r0, r8, r9);
        return true;
    L25:
        readData(r13, r0, r8, r9);
        return true;
    L11:
        if (r7 == 4) goto L15;
        throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(r7));
    L29:
        throw new IOException(a.e(r0, "FRAME_SIZE_ERROR: "));
    L30:
        return false;
    }

    public final void readConnectionPreface(@NotNull Handler r5) {
        Intrinsics.f(r5, "handler");
        if (this.client == true) goto L5;
        BufferedSource r4 = this.source;
        ByteString r6 = Http2.CONNECTION_PREFACE;
        ByteString r7 = r4.readByteString(r6.size());
        Logger r0 = logger;
        if (r0.isLoggable(Level.FINE) == false) goto L13;
        r0.fine(Util.format("<< CONNECTION " + r7.hex(), new Object[0]));
    L13:
        if ((!Intrinsics.a(r6, r7)) == true) goto L16;
        return;
    L16:
        throw new IOException("Expected a connection header but was " + r7.utf8());
    L5:
        if (nextFrame(true, r5) == false) goto L8;
        return;
    L8:
        throw new IOException("Required SETTINGS preface not received");
    }

    private final void readPriority(Handler r5, int r6) {
        int r0 = this.source.readInt();
        if ((((int) 2147483648L) & r0) == 0) goto L5;
        boolean r1 = true;
    L6:
        r5.priority(r6, r0 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Util.and(this.source.readByte(), 255) + 1, r1);
        return;
    L5:
        r1 = false;
        goto L6
    }
}
