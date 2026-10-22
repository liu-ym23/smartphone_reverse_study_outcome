package okhttp3.internal.ws;

import a.a;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
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

    @NotNull
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

    @Metadata
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;

        @Nullable
        private final ByteString reason;

        public Close(int r1, @Nullable ByteString r2, long r3) {
            this.code = r1;
            this.reason = r2;
            this.cancelAfterCloseMillis = r3;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final ByteString getReason() {
            return this.reason;
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class Message {

        @NotNull
        private final ByteString data;
        private final int formatOpcode;

        public Message(int r2, @NotNull ByteString r3) {
            Intrinsics.f(r3, "data");
            this.formatOpcode = r2;
            this.data = r3;
        }

        @NotNull
        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata
    public static abstract class Streams implements Closeable {
        private final boolean client;

        @NotNull
        private final BufferedSink sink;

        @NotNull
        private final BufferedSource source;

        public Streams(boolean r2, @NotNull BufferedSource r3, @NotNull BufferedSink r4) {
            Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
            Intrinsics.f(r4, "sink");
            this.client = r2;
            this.source = r3;
            this.sink = r4;
        }

        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final BufferedSink getSink() {
            return this.sink;
        }

        @NotNull
        public final BufferedSource getSource() {
            return this.source;
        }
    }

    @Metadata
    public final class WriterTask extends Task {
        final /* synthetic */ RealWebSocket this$0;

        public WriterTask(RealWebSocket r4) {
            this.this$0 = r4;
            super(RealWebSocket.access$getName$p(r4) + " writer", false, 2, null);
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

    static {
        Companion = new Companion(null);
        ONLY_HTTP1 = CollectionsKt.j(Protocol.HTTP_1_1);
    }

    public RealWebSocket(@NotNull TaskRunner r2, @NotNull Request r3, @NotNull WebSocketListener r4, @NotNull Random r5, long r6, @Nullable WebSocketExtensions r8, long r9) {
        Intrinsics.f(r2, "taskRunner");
        Intrinsics.f(r3, "originalRequest");
        Intrinsics.f(r4, "listener");
        Intrinsics.f(r5, "random");
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
        if (HttpMethodContrants.GET.equals(r3.method()) == false) goto L7;
        ByteString.Companion r7 = ByteString.Companion;
        byte[] r10 = new byte[16];
        r5.nextBytes(r10);
        this.key = ByteString.Companion.of$default(r7, r10, 0, 0, 3, null).base64();
        return;
    L7:
        throw new IllegalArgumentException(("Request must be GET: " + r3.method()).toString());
    }

    public static final /* synthetic */ WebSocketExtensions access$getExtensions$p(RealWebSocket r0) {
        return r0.extensions;
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

    public static final /* synthetic */ void access$setName$p(RealWebSocket r0, String r1) {
        r0.name = r1;
    }

    private final boolean isValid(WebSocketExtensions r2) {
        if (r2.unknownValues == false) goto L6;
        return false;
    L6:
        if (r2.clientMaxWindowBits == null) goto L8;
        return false;
    L8:
        Integer r1 = r2.serverMaxWindowBits;
        if (r1 == null) goto L15;
        int r3 = r1.intValue();
        if (8 <= r3) goto L13;
    L14:
        return false;
    L13:
        if (15 < r3) goto L14;
        return true;
    L15:
        return true;
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
        StringBuilder r1 = new StringBuilder("Thread ");
        Thread r3 = Thread.currentThread();
        Intrinsics.e(r3, "Thread.currentThread()");
        r1.append(r3.getName());
        r1.append(" MUST hold lock on ");
        r1.append(this);
        throw new AssertionError(r1.toString());
    }

    public final void awaitTermination(long r2, @NotNull TimeUnit r4) {
        Intrinsics.f(r4, "timeUnit");
        this.taskQueue.idleLatch().await(r2, r4);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call r0 = this.call;
        Intrinsics.c(r0);
        r0.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull Response r7, @Nullable Exchange r8) {
        Intrinsics.f(r7, ApmTrafficStats.TTNET_RESPONSE);
        if (r7.code() != 101) goto L21;
        String r0 = Response.header$default(r7, HTTP.CONN_DIRECTIVE, null, 2, null);
        if ("Upgrade".equalsIgnoreCase(r0) == false) goto L19;
        String r1 = Response.header$default(r7, "Upgrade", null, 2, null);
        if ("websocket".equalsIgnoreCase(r1) == false) goto L17;
        String r9 = Response.header$default(r7, "Sec-WebSocket-Accept", null, 2, null);
        String r6 = ByteString.Companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if ((!Intrinsics.a(r6, r9)) == true) goto L15;
        if (r8 == null) goto L13;
        return;
    L13:
        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
    L15:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r6 + "' but was '" + r9 + '\'');
    L17:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r1 + '\'');
    L19:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r0 + '\'');
    L21:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r7.code() + ' ' + r7.message() + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int r3, @Nullable String r4) {
        return close(r3, r4, 60000);
    }

    public final void connect(@NotNull OkHttpClient r5) {
        Intrinsics.f(r5, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") == null) goto L6;
        failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        return;
    L6:
        OkHttpClient r6 = r5.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request r0 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header(HTTP.CONN_DIRECTIVE, "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall r1 = new RealCall(r6, r0, true);
        this.call = r1;
        r1.enqueue(new AnonymousClass1(this, r0));
    }

    public final void failWebSocket(@NotNull Exception r5, @Nullable Response r6) {
        Intrinsics.f(r5, "e");
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.failed == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.failed = true;     // Catch: Throwable -> L27
        Streams r0 = this.streams;     // Catch: Throwable -> L27
        this.streams = null;     // Catch: Throwable -> L27
        WebSocketReader r2 = this.reader;     // Catch: Throwable -> L27
        this.reader = null;     // Catch: Throwable -> L27
        WebSocketWriter r3 = this.writer;     // Catch: Throwable -> L27
        this.writer = null;     // Catch: Throwable -> L27
        this.taskQueue.shutdown();     // Catch: Throwable -> L27
        monitor-exit(this);
        this.listener.onFailure(this, r5, r6);     // Catch: Throwable -> L19
        if (r0 == null) goto L14;
        Util.closeQuietly(r0);
    L14:
        if (r2 == null) goto L16;
        Util.closeQuietly(r2);
    L16:
        if (r3 == null) goto L34;
        Util.closeQuietly(r3);
        return;
    L34:
        return;
    L19:
        th = move-exception;
        if (r0 == null) goto L22;
        Util.closeQuietly(r0);
    L22:
        if (r2 == null) goto L24;
        Util.closeQuietly(r2);
    L24:
        if (r3 == null) goto L26;
        Util.closeQuietly(r3);
    L26:
        throw th;
    }

    @NotNull
    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(@NotNull final String r17, @NotNull final Streams r18) {
        Intrinsics.f(r17, "name");
        Intrinsics.f(r18, "streams");
        final WebSocketExtensions r12 = this.extensions;
        Intrinsics.c(r12);
        monitor-enter(this);
        this.name = r17;     // Catch: Throwable -> L7
        this.streams = r18;     // Catch: Throwable -> L7
        this.writer = new WebSocketWriter(r18.getClient(), r18.getSink(), this.random, r12.perMessageDeflate, r12.noContextTakeover(r18.getClient()), this.minimumDeflateSize);     // Catch: Throwable -> L7
        this.writerTask = new WriterTask(this);     // Catch: Throwable -> L7
        long r2 = this.pingIntervalMillis;     // Catch: Throwable -> L7
        if (r2 == 0) goto L10;
        final long r13 = TimeUnit.MILLISECONDS.toNanos(r2);     // Catch: Throwable -> L7
        TaskQueue r15 = this.taskQueue;     // Catch: Throwable -> L7
        final String r3 = r17.concat(" ping");     // Catch: Throwable -> L7
        r15.schedule(new RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1(r3, r3, r13, this, r17, r18, r12), r13);     // Catch: Throwable -> L7
    L10:
        if ((!this.messageAndCloseQueue.isEmpty()) == false) goto L12;
        runWriter();     // Catch: Throwable -> L7
    L12:
        monitor-exit(this);
        this.reader = new WebSocketReader(r18.getClient(), r18.getSource(), this, r12.perMessageDeflate, r12.noContextTakeover(!r18.getClient()));
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void loopReader() {
    L3:
        if (this.receivedCloseCode != (-1)) goto L5;
        WebSocketReader r0 = this.reader;
        Intrinsics.c(r0);
        r0.processNextFrame();
        goto L3
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r5, @NotNull String r6) {
        Intrinsics.f(r6, "reason");
        boolean r0 = false;
        if (r5 == (-1)) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L47;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L9:
        if (this.receivedCloseCode != (-1)) goto L11;
        r0 = true;
    L11:
        if (r0 == false) goto L43;
        this.receivedCloseCode = r5;     // Catch: Throwable -> L18
        this.receivedCloseReason = r6;     // Catch: Throwable -> L18
        Streams r1 = null;
        if (this.enqueuedClose == true) goto L15;
    L20:
        WebSocketReader r2 = null;
        WebSocketWriter r4 = null;
    L21:
        monitor-exit(this);
        this.listener.onClosing(this, r5, r6);     // Catch: Throwable -> L26
        if (r1 == null) goto L28;
        this.listener.onClosed(this, r5, r6);     // Catch: Throwable -> L26
    L28:
        if (r1 == null) goto L30;
        Util.closeQuietly(r1);
    L30:
        if (r2 == null) goto L32;
        Util.closeQuietly(r2);
    L32:
        if (r4 == null) goto L51;
        Util.closeQuietly(r4);
        return;
    L51:
        return;
    L26:
        th = move-exception;
        if (r1 == null) goto L37;
        Util.closeQuietly(r1);
    L37:
        if (r2 == null) goto L39;
        Util.closeQuietly(r2);
    L39:
        if (r4 == null) goto L41;
        Util.closeQuietly(r4);
    L41:
        throw th;
    L15:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L20;
        Streams r7 = this.streams;     // Catch: Throwable -> L18
        this.streams = null;     // Catch: Throwable -> L18
        r2 = this.reader;     // Catch: Throwable -> L18
        this.reader = null;     // Catch: Throwable -> L18
        r4 = this.writer;     // Catch: Throwable -> L18
        this.writer = null;     // Catch: Throwable -> L18
        this.taskQueue.shutdown();     // Catch: Throwable -> L18
        r1 = r7;
        goto L21
    L43:
        throw new IllegalStateException("already closed".toString());     // Catch: Throwable -> L18
    L47:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r3 = false;
        goto L6
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull String r2) {
        Intrinsics.f(r2, "text");
        this.listener.onMessage(this, r2);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(@NotNull ByteString r2) {
        monitor-enter(this);
        Intrinsics.f(r2, WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L10
        if (this.failed == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L12:
        this.pongQueue.add(r2);     // Catch: Throwable -> L10
        runWriter();     // Catch: Throwable -> L10
        this.receivedPingCount++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L12;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(@NotNull ByteString r2) {
        monitor-enter(this);
        Intrinsics.f(r2, WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L6
        this.receivedPongCount++;     // Catch: Throwable -> L6
        this.awaitingPong = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean pong(@NotNull ByteString r2) {
        monitor-enter(this);
        Intrinsics.f(r2, WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L10
        if (this.failed == false) goto L6;
    L16:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L12:
        this.pongQueue.add(r2);     // Catch: Throwable -> L10
        runWriter();     // Catch: Throwable -> L10
        monitor-exit(this);
        return true;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L12;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean processNextFrame() {
        WebSocketReader r1 = this.reader;     // Catch: Exception -> L7
        Intrinsics.c(r1);     // Catch: Exception -> L7
        r1.processNextFrame();     // Catch: Exception -> L7
        if (this.receivedCloseCode != (-1)) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        failWebSocket(e, null);
        return false;
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

    @Override // okhttp3.WebSocket
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull String r2) {
        Intrinsics.f(r2, "text");
        return send(ByteString.Companion.encodeUtf8(r2), 1);
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

    public final void tearDown() {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean writeOneFrame$okhttp() {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.b = null;
        final Ref.IntRef r14 = new Ref.IntRef();
        r14.b = -1;
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.b = null;
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.b = null;
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.b = null;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.b = null;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (this.failed == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        final WebSocketWriter r9 = this.writer;     // Catch: Throwable -> L17
        final ByteString r8 = this.pongQueue.poll();     // Catch: Throwable -> L17
        if (r8 != null) goto L16;
        Object r3 = this.messageAndCloseQueue.poll();     // Catch: Throwable -> L17
        r0.b = r3;     // Catch: Throwable -> L17
        if ((r3 instanceof Close) == false) goto L24;
        int r4 = this.receivedCloseCode;     // Catch: Throwable -> L17
        r14.b = r4;     // Catch: Throwable -> L17
        r13.b = this.receivedCloseReason;     // Catch: Throwable -> L17
        if (r4 == (-1)) goto L19;
        r12.b = this.streams;     // Catch: Throwable -> L17
        this.streams = null;     // Catch: Throwable -> L17
        r11.b = this.reader;     // Catch: Throwable -> L17
        this.reader = null;     // Catch: Throwable -> L17
        r10.b = this.writer;     // Catch: Throwable -> L17
        this.writer = null;     // Catch: Throwable -> L17
        this.taskQueue.shutdown();     // Catch: Throwable -> L17
        goto L16
    L19:
        Object r1 = r0.b;     // Catch: Throwable -> L17
        if (r1 == null) goto L23;
        long r2 = ((Close) r1).getCancelAfterCloseMillis();     // Catch: Throwable -> L17
        TaskQueue r7 = this.taskQueue;     // Catch: Throwable -> L17
        final String r5 = this.name + " cancel";     // Catch: Throwable -> L17
        final boolean r16 = true;
        final Ref.ObjectRef r22 = r10;
        final Ref.ObjectRef r23 = r11;
        r7.schedule(new RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1(r5, r16, r5, r16, this, r9, r8, r0, r14, r13, r12, r23, r22), TimeUnit.MILLISECONDS.toNanos(r2));     // Catch: Throwable -> L17
    L28:
        monitor-exit(this);
        ByteString r6 = r8;
        if (r6 == null) goto L35;
        Intrinsics.c(r9);     // Catch: Throwable -> L33
        r9.writePong(r6);     // Catch: Throwable -> L33
    L32:
        Ref.ObjectRef r15 = r12;
    L59:
        Streams r17 = (Streams) r15.b;
        if (r17 == null) goto L62;
        Util.closeQuietly(r17);
    L62:
        WebSocketReader r18 = (WebSocketReader) r23.b;
        if (r18 == null) goto L65;
        Util.closeQuietly(r18);
    L65:
        WebSocketWriter r19 = (WebSocketWriter) r22.b;
        if (r19 == null) goto L96;
        Util.closeQuietly(r19);
        return true;
    L96:
        return true;
    L35:
        WebSocketWriter r20 = r9;
        Object r21 = r0.b;     // Catch: Throwable -> L33
        if ((r21 instanceof Message) == false) goto L48;
        if (r21 == null) goto L47;
        Message r24 = (Message) r21;     // Catch: Throwable -> L33
        Intrinsics.c(r20);     // Catch: Throwable -> L33
        r20.writeMessageFrame(r24.getFormatOpcode(), r24.getData());     // Catch: Throwable -> L33
        monitor-enter(this);     // Catch: Throwable -> L33
        this.queueSize -= (long) r24.getData().size();     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L33
        goto L32
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L47:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");     // Catch: Throwable -> L33
    L48:
        boolean r25 = r21 instanceof Close;     // Catch: Throwable -> L33
        if (r25 == false) goto L76;
        if (r21 == null) goto L72;
        Close r26 = (Close) r21;     // Catch: Throwable -> L33
        Intrinsics.c(r20);     // Catch: Throwable -> L33
        r20.writeClose(r26.getCode(), r26.getReason());     // Catch: Throwable -> L33
        Ref.ObjectRef r27 = r12;
        Streams r28 = (Streams) r27.b;     // Catch: Throwable -> L57
        r15 = r27;
        if (r28 == null) goto L59;
        WebSocketListener r29 = this.listener;     // Catch: Throwable -> L57
        int r30 = r14.b;     // Catch: Throwable -> L57
        String r31 = (String) r13.b;     // Catch: Throwable -> L57
        Intrinsics.c(r31);     // Catch: Throwable -> L57
        r29.onClosed(this, r30, r31);     // Catch: Throwable -> L57
        r15 = r27;
    L57:
        th = th;
        Ref.ObjectRef r32 = r22;
        Ref.ObjectRef r33 = r23;
        Ref.ObjectRef r34 = r27;
    L77:
        Streams r35 = (Streams) r34.b;
        if (r35 == null) goto L80;
        Util.closeQuietly(r35);
    L80:
        WebSocketReader r36 = (WebSocketReader) r33.b;
        if (r36 == null) goto L83;
        Util.closeQuietly(r36);
    L83:
        WebSocketWriter r37 = (WebSocketWriter) r32.b;
        if (r37 == null) goto L86;
        Util.closeQuietly(r37);
    L86:
        throw th;
    L72:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");     // Catch: Throwable -> L73
    L76:
        throw new AssertionError();     // Catch: Throwable -> L73
    L73:
        th = th;
        r34 = r20;
        r33 = r25;
        r32 = r6;
    L33:
        th = th;
        r32 = r22;
        r33 = r23;
        r34 = r12;
        goto L77
    L23:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");     // Catch: Throwable -> L17
    L24:
        r22 = r10;
        r23 = r11;
        if (r3 != null) goto L28;
        monitor-exit(this);
        return false;
    L16:
        r22 = r10;
        r23 = r11;
        goto L28
    }

    public final void writePingFrame$okhttp() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L12
        if (r0 != null) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (this.awaitingPong == false) goto L14;
        int r1 = this.sentPingCount;     // Catch: Throwable -> L12
    L15:
        this.sentPingCount++;     // Catch: Throwable -> L12
        this.awaitingPong = true;     // Catch: Throwable -> L12
        monitor-exit(this);
        if (r1 == (-1)) goto L30;
        StringBuilder r2 = new StringBuilder("sent ping but didn't receive pong within ");
        r2.append(this.pingIntervalMillis);
        r2.append("ms (after ");
        failWebSocket(new SocketTimeoutException(a.n(r2, " successful ping/pongs)", r1 - 1)), null);
        return;
    L30:
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

    public final synchronized boolean close(int r9, @Nullable String r10, long r11) {
        monitor-enter(this);
        WebSocketProtocol.INSTANCE.validateCloseCode(r9);     // Catch: Throwable -> L14
        if (r10 == null) goto L16;
        ByteString r3 = ByteString.Companion.encodeUtf8(r10);     // Catch: Throwable -> L14
        if (r3.size() > 123) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
    L18:
        if (this.failed == false) goto L20;
    L25:
        monitor-exit(this);
        return false;
    L20:
        if (this.enqueuedClose == true) goto L25;
        this.enqueuedClose = true;     // Catch: Throwable -> L14
        this.messageAndCloseQueue.add(new Close(r9, r3, r11));     // Catch: Throwable -> L14
        runWriter();     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L13:
        throw new IllegalArgumentException("reason.size() > 123: ".concat(r10).toString());     // Catch: Throwable -> L14
    L9:
        r4 = false;
        goto L10
    L16:
        r3 = null;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull ByteString r2) {
        Intrinsics.f(r2, "bytes");
        this.listener.onMessage(this, r2);
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull ByteString r2) {
        Intrinsics.f(r2, "bytes");
        return send(r2, 2);
    }

    private final synchronized boolean send(ByteString r7, int r8) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L19:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L19;
        if ((this.queueSize + ((long) r7.size())) <= MAX_QUEUE_SIZE) goto L15;
        close(1001, null);     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    L15:
        this.queueSize += (long) r7.size();     // Catch: Throwable -> L13
        this.messageAndCloseQueue.add(new Message(r8, r7));     // Catch: Throwable -> L13
        runWriter();     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    }
}
