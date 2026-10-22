package okhttp3.internal.http2;

import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.google.common.net.HttpHeaders;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import cz.msebera.android.httpclient.cookie.ClientCookie;
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

/* JADX INFO: compiled from: Http2Reader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "source", "Lokio/BufferedSource;", DeviceInfoProvider.CLIENT, "", "(Lokio/BufferedSource;Z)V", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "close", "", "nextFrame", "requireSettings", "handler", "Lokhttp3/internal/http2/Http2Reader$Handler;", "readConnectionPreface", "readData", "length", "", BaseIconCache.IconDB.COLUMN_FLAGS, "streamId", "readGoAway", "readHeaderBlock", "", "Lokhttp3/internal/http2/Header;", "padding", "readHeaders", "readPing", "readPriority", "readPushPromise", "readRstStream", "readSettings", "readWindowUpdate", "Companion", "ContinuationSource", "Handler", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Http2Reader implements Closeable {
    public static final Companion Companion = null;
    private static final Logger logger = null;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* JADX INFO: compiled from: Http2Reader.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", "", "length", BaseIconCache.IconDB.COLUMN_FLAGS, "padding", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Logger getLogger() {
            return Http2Reader.access$getLogger$cp();
        }

        public final int lengthWithoutPadding(int r2, int r3, int r4) throws IOException {
            if ((r3 & 8) == 0) goto L5;
            r2 = r2 - 1;
        L5:
            if (r4 > r2) goto L9;
            return r2 - r4;
        L9:
            throw new IOException("PROTOCOL_ERROR padding " + r4 + " > remaining length " + r2);
        }
    }

    /* JADX INFO: compiled from: Http2Reader.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006!"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", BaseIconCache.IconDB.COLUMN_FLAGS, "", "getFlags", "()I", "setFlags", "(I)V", "left", "getLeft", "setLeft", "length", "getLength", "setLength", "padding", "getPadding", "setPadding", "streamId", "getStreamId", "setStreamId", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readContinuationHeader", "timeout", "Lokio/Timeout;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public ContinuationSource(BufferedSource r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.source = r2;
        }

        public final int getLength() {
            return this.length;
        }

        public final void setLength(int r1) {
            this.length = r1;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final void setFlags(int r1) {
            this.flags = r1;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        public final void setStreamId(int r1) {
            this.streamId = r1;
        }

        public final int getLeft() {
            return this.left;
        }

        public final void setLeft(int r1) {
            this.left = r1;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final void setPadding(int r1) {
            this.padding = r1;
        }

        @Override // okio.Source
        public long read(Buffer r7, long r8) throws IOException {
            Intrinsics.checkNotNullParameter(r7, "sink");
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

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }

        private final void readContinuationHeader() throws IOException {
            int r0 = this.streamId;
            int r1 = Util.readMedium(this.source);
            this.left = r1;
            this.length = r1;
            int r2 = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            if (Http2Reader.Companion.getLogger().isLoggable(Level.FINE) == false) goto L5;
            Http2Reader.Companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, r2, this.flags));
        L5:
            int r3 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = r3;
            if (r2 != 9) goto L12;
            if (r3 != r0) goto L10;
            return;
        L10:
            throw new IOException("TYPE_CONTINUATION streamId changed");
        L12:
            throw new IOException(r2 + " != TYPE_CONTINUATION");
        }
    }

    /* JADX INFO: compiled from: Http2Reader.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J8\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH&J.\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H&J(\u0010#\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0011H&J&\u0010'\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020-H&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000eH&¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "ackSettings", "", "alternateService", "streamId", "", HttpHeaders.ReferrerPolicyValues.ORIGIN, "", "protocol", "Lokio/ByteString;", WifiAuthorizeUtils.AUTO_LOGIN_HOST, ClientCookie.PORT_ATTR, "maxAge", "", "data", "inFinished", "", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", AccountConst.KEY_ERROR_CODE, "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "windowUpdate", "windowSizeIncrement", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Handler {
        void ackSettings();

        void alternateService(int r1, String r2, ByteString r3, String r4, int r5, long r6);

        void data(boolean r1, int r2, BufferedSource r3, int r4) throws IOException;

        void goAway(int r1, ErrorCode r2, ByteString r3);

        void headers(boolean r1, int r2, int r3, List<Header> r4);

        void ping(boolean r1, int r2, int r3);

        void priority(int r1, int r2, int r3, boolean r4);

        void pushPromise(int r1, int r2, List<Header> r3) throws IOException;

        void rstStream(int r1, ErrorCode r2);

        void settings(boolean r1, Settings r2);

        void windowUpdate(int r1, long r2);
    }

    public Http2Reader(BufferedSource r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "source");
        this.source = r7;
        this.client = r8;
        ContinuationSource r9 = new ContinuationSource(r7);
        this.continuation = r9;
        this.hpackReader = new Hpack.Reader(r9, 4096, 0, 4, null);
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }

    public final void readConnectionPreface(Handler r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "handler");
        if (this.client == true) goto L5;
        ByteString r2 = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        Logger r4 = logger;
        if (r4.isLoggable(Level.FINE) == false) goto L13;
        r4.fine(Util.format(Intrinsics.stringPlus("<< CONNECTION ", r2.hex()), new Object[0]));
    L13:
        if (Intrinsics.areEqual(Http2.CONNECTION_PREFACE, r2) == false) goto L16;
        return;
    L16:
        throw new IOException(Intrinsics.stringPlus("Expected a connection header but was ", r2.utf8()));
    L5:
        if (nextFrame(true, r3) == false) goto L8;
        return;
    L8:
        throw new IOException("Required SETTINGS preface not received");
    }

    public final boolean nextFrame(boolean r12, Handler r13) throws IOException {
        Intrinsics.checkNotNullParameter(r13, "handler");
        this.source.require(9);     // Catch: EOFException -> L30
        int r0 = Util.readMedium(this.source);
        if (r0 > 16384) goto L29;
        int r7 = Util.and(this.source.readByte(), 255);
        int r8 = Util.and(this.source.readByte(), 255);
        int r9 = this.source.readInt() & Integer.MAX_VALUE;
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
        throw new IOException(Intrinsics.stringPlus("Expected a SETTINGS frame but was ", Http2.INSTANCE.formattedType$okhttp(r7)));
    L29:
        throw new IOException(Intrinsics.stringPlus("FRAME_SIZE_ERROR: ", Integer.valueOf(r0)));
    L30:
        return false;
    }

    private final void readHeaders(Handler r4, int r5, int r6, int r7) throws IOException {
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

    private final List<Header> readHeaderBlock(int r2, int r3, int r4, int r5) throws IOException {
        this.continuation.setLeft(r2);
        ContinuationSource r6 = this.continuation;
        r6.setLength(r6.getLeft());
        this.continuation.setPadding(r3);
        this.continuation.setFlags(r4);
        this.continuation.setStreamId(r5);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readData(Handler r5, int r6, int r7, int r8) throws IOException {
        if (r8 == 0) goto L20;
        int r1 = 0;
        boolean r2 = true;
        if ((r7 & 1) == 0) goto L6;
        boolean r0 = true;
    L8:
        if ((r7 & 32) != 0) goto L11;
        r2 = false;
    L11:
        if (r2 == true) goto L18;
        if ((r7 & 8) == 0) goto L15;
        r1 = Util.and(this.source.readByte(), 255);
    L15:
        r5.data(r0, r8, this.source, Companion.lengthWithoutPadding(r6, r7, r1));
        this.source.skip(r1);
        return;
    L18:
        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
    L6:
        r0 = false;
        goto L8
    L20:
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void readPriority(Handler r1, int r2, int r3, int r4) throws IOException {
        if (r2 != 5) goto L10;
        if (r4 == 0) goto L8;
        readPriority(r1, r4);
        return;
    L8:
        throw new IOException("TYPE_PRIORITY streamId == 0");
    L10:
        throw new IOException("TYPE_PRIORITY length: " + r2 + " != 5");
    }

    private final void readPriority(Handler r5, int r6) throws IOException {
        int r0 = this.source.readInt();
        if ((Integer.MIN_VALUE & r0) == 0) goto L5;
        boolean r1 = true;
    L6:
        r5.priority(r6, r0 & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void readRstStream(Handler r1, int r2, int r3, int r4) throws IOException {
        if (r2 != 4) goto L14;
        if (r4 == 0) goto L12;
        int r0 = this.source.readInt();
        ErrorCode r5 = ErrorCode.Companion.fromHttp2(r0);
        if (r5 == null) goto L10;
        r1.rstStream(r4, r5);
        return;
    L10:
        throw new IOException(Intrinsics.stringPlus("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(r0)));
    L12:
        throw new IOException("TYPE_RST_STREAM streamId == 0");
    L14:
        throw new IOException("TYPE_RST_STREAM length: " + r2 + " != 4");
    }

    private final void readSettings(Handler r9, int r10, int r11, int r12) throws IOException {
        if (r12 != 0) goto L51;
        if ((r11 & 1) == 0) goto L11;
        if (r10 != 0) goto L9;
        r9.ackSettings();
        return;
    L9:
        throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
    L11:
        if ((r10 % 6) != 0) goto L49;
        Settings r13 = new Settings();
        IntProgression r14 = RangesKt.step(RangesKt.until(0, r10), 6);
        int r1 = r14.getFirst();
        int r2 = r14.getLast();
        int r15 = r14.getStep();
        if (r15 <= 0) goto L15;
        if (r1 > r2) goto L15;
    L17:
        int r3 = r1 + r15;
        int r4 = Util.and(this.source.readShort(), 65535);
        int r5 = this.source.readInt();
        if (r4 != 2) goto L20;
        if (r5 == 0) goto L42;
        if (r5 == 1) goto L42;
        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
    L42:
        r13.set(r4, r5);
        if (r1 == r2) goto L46;
        r1 = r3;
    L46:
        r9.settings(false, r13);
        return;
    L20:
        if (r4 == 3) goto L36;
        if (r4 != 4) goto L23;
        if (r5 < 0) goto L35;
        r4 = 7;
        goto L42
    L35:
        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
    L23:
        if (r4 != 5) goto L42;
        if (r5 < 16384) goto L31;
        if (r5 <= 16777215) goto L42;
    L31:
        throw new IOException(Intrinsics.stringPlus("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(r5)));
    L36:
        r4 = 4;
    L15:
        if (r15 >= 0) goto L46;
        if (r2 > r1) goto L46;
    L49:
        throw new IOException(Intrinsics.stringPlus("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(r10)));
    L51:
        throw new IOException("TYPE_SETTINGS streamId != 0");
    }

    private final void readPushPromise(Handler r4, int r5, int r6, int r7) throws IOException {
        if (r7 == 0) goto L10;
        if ((r6 & 8) == 0) goto L6;
        int r0 = Util.and(this.source.readByte(), 255);
    L7:
        r4.pushPromise(r7, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(r5 - 4, r6, r0), r0, r6, r7));
        return;
    L6:
        r0 = 0;
        goto L7
    L10:
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void readPing(Handler r2, int r3, int r4, int r5) throws IOException {
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
        throw new IOException(Intrinsics.stringPlus("TYPE_PING length != 8: ", Integer.valueOf(r3)));
    }

    private final void readGoAway(Handler r3, int r4, int r5, int r6) throws IOException {
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
        throw new IOException(Intrinsics.stringPlus("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(r0)));
    L15:
        throw new IOException("TYPE_GOAWAY streamId != 0");
    L17:
        throw new IOException(Intrinsics.stringPlus("TYPE_GOAWAY length < 8: ", Integer.valueOf(r4)));
    }

    private final void readWindowUpdate(Handler r3, int r4, int r5, int r6) throws IOException {
        if (r4 != 4) goto L11;
        long r7 = Util.and(this.source.readInt(), 2147483647L);
        if (r7 == 0) goto L9;
        r3.windowUpdate(r6, r7);
        return;
    L9:
        throw new IOException("windowSizeIncrement was 0");
    L11:
        throw new IOException(Intrinsics.stringPlus("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(r4)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    static {
        Companion = new Companion(null);
        Logger r0 = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue(r0, "getLogger(Http2::class.java.name)");
        logger = r0;
    }
}
