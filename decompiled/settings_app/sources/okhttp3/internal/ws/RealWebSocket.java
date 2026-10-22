package okhttp3.internal.ws;

import android.security.bytedance.guard.BDSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.google.common.net.HttpHeaders;
import com.obric.capabilitykit.common.Ext;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0005_`abcB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000203H\u0016J\u001f\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0000¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Gj\u0002`H2\b\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010I\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u0006\u0010J\u001a\u000203J\u0018\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u000e\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020 J\u0006\u0010S\u001a\u00020\u0012J\b\u0010!\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u000203H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010N\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010Y\u001a\u000203J\r\u0010Z\u001a\u00020\u0012H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u000203H\u0000¢\u0006\u0002\b]J\f\u0010^\u001a\u00020\u0012*\u00020\u000eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "awaitingPong", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "checkUpgradeSuccess", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", AlogMonitor.ALOG_RESULT_CODE, "reason", "cancelAfterCloseMillis", "connect", DeviceInfoProvider.CLIENT, "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", Ext.KEY_REQUEST, "runWriter", CommonKey.KEY_SEND, "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "isValid", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = null;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = null;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", AlogMonitor.ALOG_RESULT_CODE, "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int r1, ByteString r2, long r3) {
            this.code = r1;
            this.reason = r2;
            this.cancelAfterCloseMillis = r3;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            this.formatOpcode = r2;
            this.data = r3;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final ByteString getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", DeviceInfoProvider.CLIENT, "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean r2, BufferedSource r3, BufferedSink r4) {
            Intrinsics.checkNotNullParameter(r3, "source");
            Intrinsics.checkNotNullParameter(r4, "sink");
            this.client = r2;
            this.source = r3;
            this.sink = r4;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSource getSource() {
            return this.source;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }
    }

    /* JADX INFO: compiled from: RealWebSocket.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class WriterTask extends Task {
        final /* synthetic */ RealWebSocket this$0;

        public WriterTask(RealWebSocket r4) {
            Intrinsics.checkNotNullParameter(r4, "this$0");
            this.this$0 = r4;
            super(Intrinsics.stringPlus(RealWebSocket.access$getName$p(r4), " writer"), false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            if (this.this$0.writeOneFrame$okhttp() == false) goto L12;
            return 0;
        L12:
            return -1;
        L6:
            e = move-exception;
            this.this$0.failWebSocket(e, null);
            return -1;
        }
    }

    public RealWebSocket(TaskRunner r2, Request r3, WebSocketListener r4, Random r5, long r6, WebSocketExtensions r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "taskRunner");
        Intrinsics.checkNotNullParameter(r3, "originalRequest");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "random");
        this.originalRequest = r3;
        this.listener = r4;
        this.random = r5;
        this.pingIntervalMillis = r6;
        this.extensions = r8;
        this.minimumDeflateSize = r9;
        this.taskQueue = r2.newQueue();
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if (Intrinsics.areEqual("GET", r3.method()) == false) goto L7;
        ByteString.Companion r7 = ByteString.Companion;
        byte[] r10 = new byte[16];
        r5.nextBytes(r10);
        Unit r11 = Unit.INSTANCE;
        this.key = ByteString.Companion.of$default(r7, r10, 0, 0, 3, null).base64();
        return;
    L7:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Request must be GET: ", r3.method()).toString());
    }

    public static final /* synthetic */ ArrayDeque access$getMessageAndCloseQueue$p(RealWebSocket r0) {
        return r0.messageAndCloseQueue;
    }

    public static final /* synthetic */ String access$getName$p(RealWebSocket r0) {
        return r0.name;
    }

    public static final /* synthetic */ boolean access$isValid(RealWebSocket r0, WebSocketExtensions r1) {
        return r0.isValid(r1);
    }

    public static final /* synthetic */ void access$setExtensions$p(RealWebSocket r0, WebSocketExtensions r1) {
        r0.extensions = r1;
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        monitor-enter(this);
        long r0 = this.queueSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call r0 = this.call;
        Intrinsics.checkNotNull(r0);
        r0.cancel();
    }

    public final void connect(OkHttpClient r5) {
        Intrinsics.checkNotNullParameter(r5, DeviceInfoProvider.CLIENT);
        if (this.originalRequest.header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS) == null) goto L6;
        failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        return;
    L6:
        OkHttpClient r6 = r5.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request r0 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).header(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate").build();
        RealCall r1 = new RealCall(r6, r0, true);
        this.call = r1;
        Intrinsics.checkNotNull(r1);
        r1.enqueue(new AnonymousClass1(this, r0));
    }

    private final boolean isValid(WebSocketExtensions r4) {
        if (r4.unknownValues == false) goto L6;
        return false;
    L6:
        if (r4.clientMaxWindowBits == null) goto L9;
        return false;
    L9:
        if (r4.serverMaxWindowBits != null) goto L11;
        return true;
    L11:
        if (new IntRange(8, 15).contains(r4.serverMaxWindowBits.intValue()) == true) goto L15;
        return false;
    L15:
        return true;
    }

    public final void checkUpgradeSuccess$okhttp(Response r8, Exchange r9) throws IOException {
        Intrinsics.checkNotNullParameter(r8, ApmTrafficStats.TTNET_RESPONSE);
        if (r8.code() != 101) goto L21;
        String r0 = Response.header$default(r8, "Connection", null, 2, null);
        if (StringsKt.equals("Upgrade", r0, true) == false) goto L19;
        String r1 = Response.header$default(r8, "Upgrade", null, 2, null);
        if (StringsKt.equals("websocket", r1, true) == false) goto L17;
        String r10 = Response.header$default(r8, HttpHeaders.SEC_WEBSOCKET_ACCEPT, null, 2, null);
        String r7 = ByteString.Companion.encodeUtf8(Intrinsics.stringPlus(this.key, WebSocketProtocol.ACCEPT_MAGIC)).sha1().base64();
        if (Intrinsics.areEqual(r7, r10) == false) goto L15;
        if (r9 == null) goto L13;
        return;
    L13:
        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
    L15:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r7 + "' but was '" + r10 + '\'');
    L17:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r1 + '\'');
    L19:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r0 + '\'');
    L21:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r8.code() + TokenParser.SP + r8.message() + '\'');
    }

    public final void initReaderAndWriter(String r11, Streams r12) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "streams");
        WebSocketExtensions r0 = this.extensions;
        Intrinsics.checkNotNull(r0);
        monitor-enter(this);
        this.name = r11;     // Catch: Throwable -> L14
        this.streams = r12;     // Catch: Throwable -> L14
        this.writer = new WebSocketWriter(r12.getClient(), r12.getSink(), this.random, r0.perMessageDeflate, r0.noContextTakeover(r12.getClient()), this.minimumDeflateSize);     // Catch: Throwable -> L14
        this.writerTask = new WriterTask(this);     // Catch: Throwable -> L14
        if (this.pingIntervalMillis == 0) goto L8;
        final long r1 = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);     // Catch: Throwable -> L14
        TaskQueue r3 = this.taskQueue;     // Catch: Throwable -> L14
        final String r13 = Intrinsics.stringPlus(r11, " ping");     // Catch: Throwable -> L14
        r3.schedule(new RealWebSocket$initReaderAndWriter$lambda3$$inlined$schedule$1(r13, this, r1), r1);     // Catch: Throwable -> L14
    L8:
        if ((!this.messageAndCloseQueue.isEmpty()) == false) goto L10;
        runWriter();     // Catch: Throwable -> L14
    L10:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        this.reader = new WebSocketReader(r12.getClient(), r12.getSource(), this, r0.perMessageDeflate, r0.noContextTakeover(!r12.getClient()));
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void loopReader() throws IOException {
    L3:
        if (this.receivedCloseCode != (-1)) goto L5;
        WebSocketReader r0 = this.reader;
        Intrinsics.checkNotNull(r0);
        r0.processNextFrame();
        goto L3
    }

    public final boolean processNextFrame() throws IOException {
        WebSocketReader r1 = this.reader;     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L7
        r1.processNextFrame();     // Catch: Exception -> L7
        if (this.receivedCloseCode == (-1)) goto L13;
        return false;
    L13:
        return true;
    L7:
        e = move-exception;
        failWebSocket(e, null);
        return false;
    }

    public final void awaitTermination(long r2, TimeUnit r4) throws InterruptedException {
        Intrinsics.checkNotNullParameter(r4, "timeUnit");
        this.taskQueue.idleLatch().await(r2, r4);
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    public final synchronized int sentPingCount() {
        monitor-enter(this);
        int r0 = this.sentPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int receivedPingCount() {
        monitor-enter(this);
        int r0 = this.receivedPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int receivedPongCount() {
        monitor-enter(this);
        int r0 = this.receivedPongCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.listener.onMessage(this, r2);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        this.listener.onMessage(this, r2);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "payload");     // Catch: Throwable -> L15
        if (this.failed == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L10:
        this.pongQueue.add(r2);     // Catch: Throwable -> L15
        runWriter();     // Catch: Throwable -> L15
        this.receivedPingCount++;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L10;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "payload");     // Catch: Throwable -> L6
        this.receivedPongCount++;     // Catch: Throwable -> L6
        this.awaitingPong = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        boolean r0 = true;
        if (r6 == (-1)) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L51;
        monitor-enter(this);
    L47:
        th = move-exception;
        throw th;
    L9:
        if (this.receivedCloseCode == (-1)) goto L12;
        r0 = false;
    L12:
        if (r0 == false) goto L46;
        this.receivedCloseCode = r6;     // Catch: Throwable -> L47
        this.receivedCloseReason = r7;     // Catch: Throwable -> L47
        Streams r1 = null;
        if (this.enqueuedClose == true) goto L16;
    L18:
        WebSocketReader r2 = null;
        WebSocketWriter r4 = null;
    L19:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L47
        monitor-exit(this);
        this.listener.onClosing(this, r6, r7);     // Catch: Throwable -> L34
        if (r1 == null) goto L24;
        this.listener.onClosed(this, r6, r7);     // Catch: Throwable -> L34
    L24:
        if (r1 == null) goto L27;
        Util.closeQuietly(r1);
    L27:
        if (r2 == null) goto L30;
        Util.closeQuietly(r2);
    L30:
        if (r4 == null) goto L55;
        Util.closeQuietly(r4);
        return;
    L55:
        return;
    L34:
        th = move-exception;
        if (r1 == null) goto L38;
        Util.closeQuietly(r1);
    L38:
        if (r2 == null) goto L41;
        Util.closeQuietly(r2);
    L41:
        if (r4 == null) goto L44;
        Util.closeQuietly(r4);
    L44:
        throw th;
    L16:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L18;
        Streams r8 = this.streams;     // Catch: Throwable -> L47
        this.streams = null;     // Catch: Throwable -> L47
        r2 = this.reader;     // Catch: Throwable -> L47
        this.reader = null;     // Catch: Throwable -> L47
        r4 = this.writer;     // Catch: Throwable -> L47
        this.writer = null;     // Catch: Throwable -> L47
        this.taskQueue.shutdown();     // Catch: Throwable -> L47
        r1 = r8;
        goto L19
    L46:
        throw new IllegalStateException("already closed".toString());     // Catch: Throwable -> L47
    L51:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r3 = false;
        goto L6
    }

    @Override // okhttp3.WebSocket
    public boolean send(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        return send(ByteString.Companion.encodeUtf8(r2), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        return send(r2, 2);
    }

    private final synchronized boolean send(ByteString r7, int r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L17;
        if ((this.queueSize + ((long) r7.size())) <= 16777216) goto L13;
        close(1001, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L13:
        this.queueSize += (long) r7.size();     // Catch: Throwable -> L19
        this.messageAndCloseQueue.add(new Message(r8, r7));     // Catch: Throwable -> L19
        runWriter();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    public final synchronized boolean pong(ByteString r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "payload");     // Catch: Throwable -> L17
        if (this.failed == false) goto L6;
    L14:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L10:
        this.pongQueue.add(r2);     // Catch: Throwable -> L17
        runWriter();     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L10;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public boolean close(int r3, String r4) {
        return close(r3, r4, 60000);
    }

    public final synchronized boolean close(int r8, String r9, long r10) {
        monitor-enter(this);
        WebSocketProtocol.INSTANCE.validateCloseCode(r8);     // Catch: Throwable -> L24
        if (r9 == null) goto L13;
        ByteString r2 = ByteString.Companion.encodeUtf8(r9);     // Catch: Throwable -> L24
        if (r2.size() > 123) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
    L15:
        if (this.failed == false) goto L17;
    L22:
        monitor-exit(this);
        return false;
    L17:
        if (this.enqueuedClose == true) goto L22;
        this.enqueuedClose = true;     // Catch: Throwable -> L24
        this.messageAndCloseQueue.add(new Close(r8, r2, r10));     // Catch: Throwable -> L24
        runWriter();     // Catch: Throwable -> L24
        monitor-exit(this);
        return true;
    L12:
        throw new IllegalArgumentException(Intrinsics.stringPlus("reason.size() > 123: ", r9).toString());     // Catch: Throwable -> L24
    L8:
        r3 = false;
        goto L9
    L13:
        r2 = null;
    L24:
        th = move-exception;
        throw th;
    }

    public final boolean writeOneFrame$okhttp() throws IOException {
        monitor-enter(this);
    L65:
        th = move-exception;
        throw th;
    L5:
        if (this.failed == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L65
        ByteString r2 = this.pongQueue.poll();     // Catch: Throwable -> L65
        final boolean r3 = true;
        Object r4 = null;
        if (r2 != null) goto L22;
        Object r6 = this.messageAndCloseQueue.poll();     // Catch: Throwable -> L65
        if ((r6 instanceof Close) == false) goto L17;
        int r1 = this.receivedCloseCode;     // Catch: Throwable -> L65
        String r7 = this.receivedCloseReason;     // Catch: Throwable -> L65
        if (r1 == (-1)) goto L15;
        Streams r5 = this.streams;     // Catch: Throwable -> L65
        this.streams = null;     // Catch: Throwable -> L65
        WebSocketReader r8 = this.reader;     // Catch: Throwable -> L65
        this.reader = null;     // Catch: Throwable -> L65
        WebSocketWriter r9 = this.writer;     // Catch: Throwable -> L65
        this.writer = null;     // Catch: Throwable -> L65
        this.taskQueue.shutdown();     // Catch: Throwable -> L65
    L21:
        r4 = r6;
    L23:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L65
        monitor-exit(this);
        if (r2 == null) goto L28;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L54
        r0.writePong(r2);     // Catch: Throwable -> L54
    L42:
        if (r5 == null) goto L45;
        Util.closeQuietly(r5);
    L45:
        if (r8 == null) goto L48;
        Util.closeQuietly(r8);
    L48:
        if (r9 == null) goto L51;
        Util.closeQuietly(r9);
    L51:
        return true;
    L28:
        if ((r4 instanceof Message) == false) goto L38;
        Message r11 = (Message) r4;     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L54
        r0.writeMessageFrame(r11.getFormatOpcode(), r11.getData());     // Catch: Throwable -> L54
        monitor-enter(this);     // Catch: Throwable -> L54
        this.queueSize -= (long) r11.getData().size();     // Catch: Throwable -> L34
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(this);     // Catch: Throwable -> L54
        goto L42
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L54
    L38:
        if ((r4 instanceof Close) == false) goto L53;
        Close r13 = (Close) r4;     // Catch: Throwable -> L54
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L54
        r0.writeClose(r13.getCode(), r13.getReason());     // Catch: Throwable -> L54
        if (r5 == null) goto L42;
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L54
        this.listener.onClosed(this, r1, r7);     // Catch: Throwable -> L54
        goto L42
    L53:
        throw new AssertionError();     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        if (r5 == null) goto L58;
        Util.closeQuietly(r5);
    L58:
        if (r8 == null) goto L61;
        Util.closeQuietly(r8);
    L61:
        if (r9 == null) goto L64;
        Util.closeQuietly(r9);
    L64:
        throw th;
    L15:
        long r14 = ((Close) r6).getCancelAfterCloseMillis();     // Catch: Throwable -> L65
        TaskQueue r15 = this.taskQueue;     // Catch: Throwable -> L65
        final String r16 = Intrinsics.stringPlus(this.name, " cancel");     // Catch: Throwable -> L65
        r15.schedule(new RealWebSocket$writeOneFrame$lambda8$$inlined$execute$default$1(r16, r3, this), TimeUnit.MILLISECONDS.toNanos(r14));     // Catch: Throwable -> L65
        r5 = null;
        r8 = null;
        r9 = null;
        goto L21
    L17:
        if (r6 != null) goto L20;
        monitor-exit(this);
        return false;
    L20:
        r7 = null;
        r8 = null;
        r9 = null;
        r1 = -1;
        r5 = null;
        goto L21
    L22:
        r7 = null;
        r8 = null;
        r9 = null;
        r1 = -1;
        r5 = null;
        goto L23
    }

    public final void writePingFrame$okhttp() {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L26
        if (r0 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (this.awaitingPong == false) goto L14;
        int r1 = this.sentPingCount;     // Catch: Throwable -> L26
    L15:
        this.sentPingCount++;     // Catch: Throwable -> L26
        this.awaitingPong = true;     // Catch: Throwable -> L26
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(this);
        if (r1 == (-1)) goto L29;
        failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), null);
        return;
    L29:
        r0.writePing(ByteString.EMPTY);     // Catch: IOException -> L23
        return;
    L23:
        e = move-exception;
        failWebSocket(e, null);
        return;
    L14:
        r1 = -1;
        goto L15
    }

    public final void failWebSocket(Exception r5, Response r6) {
        Intrinsics.checkNotNullParameter(r5, "e");
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (this.failed == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.failed = true;     // Catch: Throwable -> L33
        Streams r0 = this.streams;     // Catch: Throwable -> L33
        this.streams = null;     // Catch: Throwable -> L33
        WebSocketReader r2 = this.reader;     // Catch: Throwable -> L33
        this.reader = null;     // Catch: Throwable -> L33
        WebSocketWriter r3 = this.writer;     // Catch: Throwable -> L33
        this.writer = null;     // Catch: Throwable -> L33
        this.taskQueue.shutdown();     // Catch: Throwable -> L33
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(this);
        this.listener.onFailure(this, r5, r6);     // Catch: Throwable -> L22
        if (r0 == null) goto L15;
        Util.closeQuietly(r0);
    L15:
        if (r2 == null) goto L18;
        Util.closeQuietly(r2);
    L18:
        if (r3 == null) goto L40;
        Util.closeQuietly(r3);
        return;
    L40:
        return;
    L22:
        th = move-exception;
        if (r0 == null) goto L26;
        Util.closeQuietly(r0);
    L26:
        if (r2 == null) goto L29;
        Util.closeQuietly(r2);
    L29:
        if (r3 == null) goto L32;
        Util.closeQuietly(r3);
    L32:
        throw th;
    }

    static {
        Companion = new Companion(null);
        ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
    }

    private final void runWriter() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        Task r2 = this.writerTask;
        if (r2 == null) goto L13;
        TaskQueue.schedule$default(this.taskQueue, r2, 0, 2, null);
        return;
    L13:
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }
}
