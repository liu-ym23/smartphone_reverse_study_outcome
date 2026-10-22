package com.bytedance.common.wschannel.channel.impl.ok.ws;

import a.a;
import androidx.annotation.Nullable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public class CustomHeartBeatRealWebSocket implements CustomHeartBeatWebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = null;
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final long ioLimitLength;
    private final String key;
    private WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private final Request originalRequest;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private RealWebSocket.Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;

    public final class CancelRunnable implements Runnable {
        final /* synthetic */ CustomHeartBeatRealWebSocket this$0;

        public CancelRunnable(CustomHeartBeatRealWebSocket r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.cancel();
        }
    }

    public static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        public Close(int r1, ByteString r2, long r3) {
            this.code = r1;
            this.reason = r2;
            this.cancelAfterCloseMillis = r3;
        }
    }

    public static final class Message {
        final ByteString data;
        final int formatOpcode;

        public Message(int r1, ByteString r2) {
            this.formatOpcode = r1;
            this.data = r2;
        }
    }

    public final class PingRunnable implements Runnable {
        final /* synthetic */ CustomHeartBeatRealWebSocket this$0;

        public PingRunnable(CustomHeartBeatRealWebSocket r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.writePingFrame(ByteString.EMPTY);
        }
    }

    static {
        ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    }

    public CustomHeartBeatRealWebSocket(Request r3, long r4, WebSocketListener r6, Random r7) {
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if (HttpMethodContrants.GET.equals(r3.method()) == false) goto L7;
        this.originalRequest = r3;
        this.listener = r6;
        this.random = r7;
        this.ioLimitLength = r4;
        byte[] r5 = new byte[16];
        r7.nextBytes(r5);
        this.key = ByteString.of(r5).base64();
        this.writerRunnable = new AnonymousClass1(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r3.method());
    }

    public static /* synthetic */ WebSocketListener access$000(CustomHeartBeatRealWebSocket r0) {
        return r0.listener;
    }

    public static CustomHeartBeatRealWebSocket create(Request r7, long r8, WebSocketListener r10) {
        return new CustomHeartBeatRealWebSocket(r7, r8, r10, new Random());
    }

    private void runWriter() {
        ScheduledExecutorService r0 = this.executor;
        if (r0 == null) goto L6;
        r0.execute(this.writerRunnable);
        return;
    }

    private Request tryAddOkWsRequestOpaque(Request r4) {
        WsChannelSettings.OkOpaqueCallback r3 = WsChannelSettings.getOkOpaqueCallback();
        if (r3 != null) goto L18;
        return r4;
    L18:
        Map<String, String> r5 = r3.onCallToWsRequestOpaque(r4.url().toString(), r4.headers().toMultimap());     // Catch: Exception -> L12
        if (r5 != null) goto L8;
        return r4;
    L8:
        Request.Builder r0 = r4.newBuilder();     // Catch: Exception -> L12
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();     // Catch: Exception -> L12
    L10:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<String, String> r1 = r6.next();     // Catch: Exception -> L12
        r0.addHeader(r1.getKey(), r1.getValue());     // Catch: Exception -> L12
        goto L10
    L14:
        return r0.build();
    L12:
        e = move-exception;
        Logger.w("tryAddOkWsRequestOpaque failed with exception" + e);
        return r4;
    }

    public void awaitTermination(int r3, TimeUnit r4) {
        this.executor.awaitTermination(r3, r4);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public void checkResponse(Response r5) {
        if (r5.code() != 101) goto L18;
        String r0 = r5.header(HTTP.CONN_DIRECTIVE);
        if ("Upgrade".equalsIgnoreCase(r0) == false) goto L16;
        String r1 = r5.header("Upgrade");
        if ("websocket".equalsIgnoreCase(r1) == false) goto L14;
        String r6 = r5.header("Sec-WebSocket-Accept");
        String r4 = ByteString.encodeUtf8(this.key + okhttp3.internal.ws.WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (r4.equals(r6) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r4 + "' but was '" + r6 + "'");
    L14:
        throw new ProtocolException(a.k("Expected 'Upgrade' header value 'websocket' but was '", r1, "'"));
    L16:
        throw new ProtocolException(a.k("Expected 'Connection' header value 'Upgrade' but was '", r0, "'"));
    L18:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r5.code() + " " + r5.message() + "'");
    }

    @Override // okhttp3.WebSocket
    public boolean close(int r3, String r4) {
        return close(r3, r4, 60000);
    }

    public void closeQuietly(int r2, String r3) {
        this.listener = null;
        close(r2, r3);     // Catch: Throwable -> L5
        return;
    }

    public void connect(OkHttpClient r4) {
        final Request r0 = tryAddOkWsRequestOpaque(this.originalRequest.newBuilder().header("Upgrade", "websocket").header(HTTP.CONN_DIRECTIVE, "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build());
        Call r5 = Internal.instance.newWebSocketCall(r4, r0);
        this.call = r5;
        r5.enqueue(new AnonymousClass2(this, r0));
    }

    public void failWebSocket(Exception r4, @Nullable Response r5) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.failed = true;     // Catch: Throwable -> L7
        RealWebSocket.Streams r0 = this.streams;     // Catch: Throwable -> L7
        this.streams = null;     // Catch: Throwable -> L7
        ScheduledFuture<?> r1 = this.cancelFuture;     // Catch: Throwable -> L7
        if (r1 == null) goto L12;
        r1.cancel(false);     // Catch: Throwable -> L7
    L12:
        ScheduledExecutorService r2 = this.executor;     // Catch: Throwable -> L7
        if (r2 == null) goto L15;
        r2.shutdown();     // Catch: Throwable -> L7
    L15:
        monitor-exit(this);     // Catch: Throwable -> L7
        WebSocketListener r3 = this.listener;     // Catch: Throwable -> L20
        if (r3 == null) goto L22;
        r3.onFailure(this, r4, r5);     // Catch: Throwable -> L20
    L22:
        Util.closeQuietly(r0);
        return;
    L20:
        th = move-exception;
        Util.closeQuietly(r0);
        throw th;
    }

    public void initReaderAndWriter(String r7, RealWebSocket.Streams r8) {
        monitor-enter(this);
        this.streams = r8;     // Catch: Throwable -> L6
        this.writer = new WebSocketWriter(r8.client, r8.sink, this.random);     // Catch: Throwable -> L6
        this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(r7, false));     // Catch: Throwable -> L6
        if (this.messageAndCloseQueue.isEmpty() == true) goto L8;
        runWriter();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        this.reader = new WebSocketReader(r8.client, r8.source, this, this.ioLimitLength);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void loopReader() {
    L3:
        if (this.receivedCloseCode != (-1)) goto L5;
        this.reader.processNextFrame();
        goto L3
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r4, String r5) {
        if (r4 == (-1)) goto L35;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.receivedCloseCode != (-1)) goto L31;
        this.receivedCloseCode = r4;     // Catch: Throwable -> L14
        this.receivedCloseReason = r5;     // Catch: Throwable -> L14
        RealWebSocket.Streams r1 = null;
        if (this.enqueuedClose == true) goto L10;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L14
        WebSocketListener r0 = this.listener;     // Catch: Throwable -> L24
        if (r0 == null) goto L26;
        r0.onClosing(this, r4, r5);     // Catch: Throwable -> L24
        if (r1 == null) goto L26;
        this.listener.onClosed(this, r4, r5);     // Catch: Throwable -> L24
    L26:
        Util.closeQuietly(r1);
        return;
    L24:
        th = move-exception;
        Util.closeQuietly(r1);
        throw th;
    L10:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L17;
        RealWebSocket.Streams r2 = this.streams;     // Catch: Throwable -> L14
        this.streams = null;     // Catch: Throwable -> L14
        ScheduledFuture<?> r3 = this.cancelFuture;     // Catch: Throwable -> L14
        if (r3 == null) goto L16;
        r3.cancel(false);     // Catch: Throwable -> L14
    L16:
        this.executor.shutdown();     // Catch: Throwable -> L14
        r1 = r2;
        goto L17
    L31:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L14
    L35:
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String r2) {
        WebSocketListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onMessage(this, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
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
        goto L12
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString r2) {
        monitor-enter(this);
        this.receivedPongCount++;     // Catch: Throwable -> L7
        this.awaitingPong = false;     // Catch: Throwable -> L7
        WebSocketListener r0 = this.listener;     // Catch: Throwable -> L7
        if (r0 == null) goto L9;
        r0.onPong(this, r2);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean processNextFrame() {
        this.reader.processNextFrame();     // Catch: Exception -> L8
        if (this.receivedCloseCode != (-1)) goto L13;
        return true;
    L13:
        return false;
    L8:
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

    public synchronized int receivedPingCount() {
        monitor-enter(this);
        int r0 = this.receivedPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int receivedPongCount() {
        monitor-enter(this);
        int r0 = this.receivedPongCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String r2) {
        if (r2 == null) goto L6;
        return send(ByteString.encodeUtf8(r2), 1);
    L6:
        throw new NullPointerException("text == null");
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket
    public void sendPing() {
        ScheduledExecutorService r0 = this.executor;
        if (r0 == null) goto L6;
        r0.execute(new PingRunnable(this));
        return;
    }

    public synchronized int sentPingCount() {
        monitor-enter(this);
        int r0 = this.sentPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void tearDown() {
        ScheduledFuture<?> r0 = this.cancelFuture;
        if (r0 == null) goto L5;
        r0.cancel(false);
    L5:
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    public boolean writeOneFrame() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L9:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L7
        ByteString r2 = this.pongQueue.poll();     // Catch: Throwable -> L7
        Object r3 = null;
        if (r2 != null) goto L22;
        Object r5 = this.messageAndCloseQueue.poll();     // Catch: Throwable -> L7
        if ((r5 instanceof Close) == false) goto L18;
        int r1 = this.receivedCloseCode;     // Catch: Throwable -> L7
        String r6 = this.receivedCloseReason;     // Catch: Throwable -> L7
        if (r1 == (-1)) goto L17;
        RealWebSocket.Streams r4 = this.streams;     // Catch: Throwable -> L7
        this.streams = null;     // Catch: Throwable -> L7
        this.executor.shutdown();     // Catch: Throwable -> L7
    L16:
        r3 = r5;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r2 == null) goto L29;
        r0.writePong(r2);     // Catch: Throwable -> L26
    L45:
        Util.closeQuietly(r4);
        return true;
    L29:
        if ((r3 instanceof Message) == false) goto L39;
        ByteString r7 = ((Message) r3).data;     // Catch: Throwable -> L26
        BufferedSink r8 = Okio.buffer(r0.newMessageSink(((Message) r3).formatOpcode, r7.size()));     // Catch: Throwable -> L26
        r8.write(r7);     // Catch: Throwable -> L26
        r8.close();     // Catch: Throwable -> L26
        monitor-enter(this);     // Catch: Throwable -> L26
        this.queueSize -= (long) r7.size();     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L39:
        if ((r3 instanceof Close) == false) goto L48;
        Close r9 = (Close) r3;     // Catch: Throwable -> L26
        r0.writeClose(r9.code, r9.reason);     // Catch: Throwable -> L26
        if (r4 == null) goto L45;
        WebSocketListener r10 = this.listener;     // Catch: Throwable -> L26
        if (r10 == null) goto L45;
        r10.onClosed(this, r1, r6);     // Catch: Throwable -> L26
        goto L45
    L48:
        throw new AssertionError();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Util.closeQuietly(r4);
        throw th;
    L17:
        this.cancelFuture = this.executor.schedule(new CancelRunnable(this), ((Close) r5).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
        r4 = null;
        goto L16
    L18:
        if (r5 != null) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L21:
        r6 = null;
        r1 = -1;
        r4 = null;
        goto L16
    L22:
        r6 = null;
        r1 = -1;
        r4 = null;
        goto L23
    }

    public void writePingFrame(ByteString r6) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L7
        if (this.awaitingPong == false) goto L12;
        int r1 = this.sentPingCount;     // Catch: Throwable -> L7
    L13:
        this.sentPingCount++;     // Catch: Throwable -> L7
        this.awaitingPong = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r1 == (-1)) goto L19;
        failWebSocket(new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG), null);
        return;
    L19:
        if (r0 == null) goto L30;
        r0.writePing(r6);     // Catch: IOException -> L22
        return;
    L22:
        e = move-exception;
        failWebSocket(e, null);
        return;
    L30:
        return;
    L12:
        r1 = -1;
        goto L13
    }

    public synchronized boolean close(int r7, String r8, long r9) {
        monitor-enter(this);
        WebSocketProtocol.validateCloseCode(r7);     // Catch: Throwable -> L11
        if (r8 == null) goto L13;
        ByteString r1 = ByteString.encodeUtf8(r8);     // Catch: Throwable -> L11
        if (r1.size() > 123) goto L10;
    L15:
        if (this.failed == false) goto L17;
    L22:
        monitor-exit(this);
        return false;
    L17:
        if (this.enqueuedClose == true) goto L22;
        this.enqueuedClose = true;     // Catch: Throwable -> L11
        this.messageAndCloseQueue.add(new Close(r7, r1, r9));     // Catch: Throwable -> L11
        runWriter();     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L10:
        throw new IllegalArgumentException("reason.size() > 123: ".concat(r8));     // Catch: Throwable -> L11
    L13:
        r1 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString r2) {
        WebSocketListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onMessage(this, r2);
        return;
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString r2) {
        if (r2 == null) goto L6;
        return send(r2, 2);
    L6:
        throw new NullPointerException("bytes == null");
    }

    private synchronized boolean send(ByteString r7, int r8) {
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
