package com.bytedance.common.wschannel.channel.impl.ok.ws;

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

    final class CancelRunnable implements Runnable {
        final /* synthetic */ CustomHeartBeatRealWebSocket this$0;

        CancelRunnable(CustomHeartBeatRealWebSocket r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.cancel();
        }
    }

    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        Close(int r1, ByteString r2, long r3) {
            this.code = r1;
            this.reason = r2;
            this.cancelAfterCloseMillis = r3;
        }
    }

    static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int r1, ByteString r2) {
            this.formatOpcode = r1;
            this.data = r2;
        }
    }

    private final class PingRunnable implements Runnable {
        final /* synthetic */ CustomHeartBeatRealWebSocket this$0;

        PingRunnable(CustomHeartBeatRealWebSocket r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.writePingFrame(ByteString.EMPTY);
        }
    }

    static /* synthetic */ WebSocketListener access$000(CustomHeartBeatRealWebSocket r0) {
        return r0.listener;
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

    public static CustomHeartBeatRealWebSocket create(Request r7, long r8, WebSocketListener r10) {
        return new CustomHeartBeatRealWebSocket(r7, r8, r10, new Random());
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
        this.call.cancel();
    }

    private Request tryAddOkWsRequestOpaque(Request r4) {
        WsChannelSettings.OkOpaqueCallback r3 = WsChannelSettings.getOkOpaqueCallback();
        if (r3 != null) goto L17;
        return r4;
    L17:
        Map<String, String> r5 = r3.onCallToWsRequestOpaque(r4.url().toString(), r4.headers().toMultimap());     // Catch: Exception -> L14
        if (r5 != null) goto L8;
        return r4;
    L8:
        Request.Builder r0 = r4.newBuilder();     // Catch: Exception -> L14
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, String> r1 = r6.next();     // Catch: Exception -> L14
        r0.addHeader(r1.getKey(), r1.getValue());     // Catch: Exception -> L14
        goto L10
    L12:
        return r0.build();
    L14:
        e = move-exception;
        Logger.w("tryAddOkWsRequestOpaque failed with exception" + e);
        return r4;
    }

    public void connect(OkHttpClient r4) {
        final Request r0 = tryAddOkWsRequestOpaque(this.originalRequest.newBuilder().header("Upgrade", "websocket").header(HTTP.CONN_DIRECTIVE, "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build());
        Call r5 = Internal.instance.newWebSocketCall(r4, r0);
        this.call = r5;
        r5.enqueue(new AnonymousClass2(this, r0));
    }

    void checkResponse(Response r5) throws ProtocolException {
        if (r5.code() != 101) goto L18;
        String r0 = r5.header(HTTP.CONN_DIRECTIVE);
        if ("Upgrade".equalsIgnoreCase(r0) == false) goto L16;
        String r1 = r5.header("Upgrade");
        if ("websocket".equalsIgnoreCase(r1) == false) goto L14;
        String r6 = r5.header("Sec-WebSocket-Accept");
        String r4 = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (r4.equals(r6) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r4 + "' but was '" + r6 + "'");
    L14:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r1 + "'");
    L16:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r0 + "'");
    L18:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r5.code() + " " + r5.message() + "'");
    }

    public void initReaderAndWriter(String r7, RealWebSocket.Streams r8) throws IOException {
        monitor-enter(this);
        this.streams = r8;     // Catch: Throwable -> L9
        this.writer = new WebSocketWriter(r8.client, r8.sink, this.random);     // Catch: Throwable -> L9
        this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(r7, false));     // Catch: Throwable -> L9
        if (this.messageAndCloseQueue.isEmpty() == true) goto L6;
        runWriter();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.reader = new WebSocketReader(r8.client, r8.source, this, this.ioLimitLength);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void loopReader() throws IOException {
    L3:
        if (this.receivedCloseCode != (-1)) goto L5;
        this.reader.processNextFrame();
        goto L3
    }

    boolean processNextFrame() throws IOException {
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

    void awaitTermination(int r3, TimeUnit r4) throws InterruptedException {
        this.executor.awaitTermination(r3, r4);
    }

    void tearDown() throws InterruptedException {
        ScheduledFuture<?> r0 = this.cancelFuture;
        if (r0 == null) goto L5;
        r0.cancel(false);
    L5:
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    synchronized int sentPingCount() {
        monitor-enter(this);
        int r0 = this.sentPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized int receivedPingCount() {
        monitor-enter(this);
        int r0 = this.receivedPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized int receivedPongCount() {
        monitor-enter(this);
        int r0 = this.receivedPongCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String r2) throws IOException {
        WebSocketListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onMessage(this, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString r2) throws IOException {
        WebSocketListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onMessage(this, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString r2) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
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
        goto L10
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString r2) {
        monitor-enter(this);
        this.receivedPongCount++;     // Catch: Throwable -> L8
        this.awaitingPong = false;     // Catch: Throwable -> L8
        WebSocketListener r0 = this.listener;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.onPong(this, r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r4, String r5) {
        if (r4 == (-1)) goto L32;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L6:
        if (this.receivedCloseCode != (-1)) goto L27;
        this.receivedCloseCode = r4;     // Catch: Throwable -> L28
        this.receivedCloseReason = r5;     // Catch: Throwable -> L28
        RealWebSocket.Streams r1 = null;
        if (this.enqueuedClose == true) goto L10;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L28
        WebSocketListener r0 = this.listener;     // Catch: Throwable -> L23
        if (r0 == null) goto L21;
        r0.onClosing(this, r4, r5);     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        this.listener.onClosed(this, r4, r5);     // Catch: Throwable -> L23
    L21:
        Util.closeQuietly(r1);
        return;
    L23:
        th = move-exception;
        Util.closeQuietly(r1);
        throw th;
    L10:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L15;
        RealWebSocket.Streams r2 = this.streams;     // Catch: Throwable -> L28
        this.streams = null;     // Catch: Throwable -> L28
        ScheduledFuture<?> r3 = this.cancelFuture;     // Catch: Throwable -> L28
        if (r3 == null) goto L14;
        r3.cancel(false);     // Catch: Throwable -> L28
    L14:
        this.executor.shutdown();     // Catch: Throwable -> L28
        r1 = r2;
        goto L15
    L27:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L28
    L32:
        throw new IllegalArgumentException();
    }

    @Override // okhttp3.WebSocket
    public boolean send(String r2) {
        if (r2 == null) goto L6;
        return send(ByteString.encodeUtf8(r2), 1);
    L6:
        throw new NullPointerException("text == null");
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

    @Override // okhttp3.WebSocket
    public boolean close(int r3, String r4) {
        return close(r3, r4, 60000);
    }

    synchronized boolean close(int r7, String r8, long r9) {
        monitor-enter(this);
        WebSocketProtocol.validateCloseCode(r7);     // Catch: Throwable -> L23
        if (r8 == null) goto L11;
        ByteString r1 = ByteString.encodeUtf8(r8);     // Catch: Throwable -> L23
        if (r1.size() > 123) goto L10;
    L13:
        if (this.failed == false) goto L15;
    L20:
        monitor-exit(this);
        return false;
    L15:
        if (this.enqueuedClose == true) goto L20;
        this.enqueuedClose = true;     // Catch: Throwable -> L23
        this.messageAndCloseQueue.add(new Close(r7, r1, r9));     // Catch: Throwable -> L23
        runWriter();     // Catch: Throwable -> L23
        monitor-exit(this);
        return true;
    L10:
        throw new IllegalArgumentException("reason.size() > 123: " + r8);     // Catch: Throwable -> L23
    L11:
        r1 = null;
    L23:
        th = move-exception;
        throw th;
    }

    private void runWriter() {
        ScheduledExecutorService r0 = this.executor;
        if (r0 == null) goto L6;
        r0.execute(this.writerRunnable);
        return;
    }

    boolean writeOneFrame() throws IOException {
        monitor-enter(this);
    L48:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L48
        return false;
    L7:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L48
        ByteString r2 = this.pongQueue.poll();     // Catch: Throwable -> L48
        Object r3 = null;
        if (r2 != null) goto L20;
        Object r5 = this.messageAndCloseQueue.poll();     // Catch: Throwable -> L48
        if ((r5 instanceof Close) == false) goto L15;
        int r1 = this.receivedCloseCode;     // Catch: Throwable -> L48
        String r6 = this.receivedCloseReason;     // Catch: Throwable -> L48
        if (r1 == (-1)) goto L14;
        RealWebSocket.Streams r4 = this.streams;     // Catch: Throwable -> L48
        this.streams = null;     // Catch: Throwable -> L48
        this.executor.shutdown();     // Catch: Throwable -> L48
    L19:
        r3 = r5;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L48
        if (r2 == null) goto L25;
        r0.writePong(r2);     // Catch: Throwable -> L45
    L41:
        Util.closeQuietly(r4);
        return true;
    L25:
        if ((r3 instanceof Message) == false) goto L35;
        ByteString r7 = ((Message) r3).data;     // Catch: Throwable -> L45
        BufferedSink r8 = Okio.buffer(r0.newMessageSink(((Message) r3).formatOpcode, r7.size()));     // Catch: Throwable -> L45
        r8.write(r7);     // Catch: Throwable -> L45
        r8.close();     // Catch: Throwable -> L45
        monitor-enter(this);     // Catch: Throwable -> L45
        this.queueSize -= (long) r7.size();     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L35:
        if ((r3 instanceof Close) == false) goto L44;
        Close r9 = (Close) r3;     // Catch: Throwable -> L45
        r0.writeClose(r9.code, r9.reason);     // Catch: Throwable -> L45
        if (r4 == null) goto L41;
        WebSocketListener r10 = this.listener;     // Catch: Throwable -> L45
        if (r10 == null) goto L41;
        r10.onClosed(this, r1, r6);     // Catch: Throwable -> L45
        goto L41
    L44:
        throw new AssertionError();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Util.closeQuietly(r4);
        throw th;
    L14:
        this.cancelFuture = this.executor.schedule(new CancelRunnable(this), ((Close) r5).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L48
        r4 = null;
        goto L19
    L15:
        if (r5 != null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L48
        return false;
    L18:
        r6 = null;
        r1 = -1;
        r4 = null;
        goto L19
    L20:
        r6 = null;
        r1 = -1;
        r4 = null;
        goto L21
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket
    public void sendPing() {
        ScheduledExecutorService r0 = this.executor;
        if (r0 == null) goto L6;
        r0.execute(new PingRunnable(this));
        return;
    }

    void writePingFrame(ByteString r6) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L7:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L23
        if (this.awaitingPong == false) goto L10;
        int r1 = this.sentPingCount;     // Catch: Throwable -> L23
    L11:
        this.sentPingCount++;     // Catch: Throwable -> L23
        this.awaitingPong = true;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r1 == (-1)) goto L17;
        failWebSocket(new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG), null);
        return;
    L17:
        if (r0 == null) goto L29;
        r0.writePing(r6);     // Catch: IOException -> L20
        return;
    L20:
        e = move-exception;
        failWebSocket(e, null);
        return;
    L29:
        return;
    L10:
        r1 = -1;
        goto L11
    }

    public void failWebSocket(Exception r4, Response r5) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L7:
        this.failed = true;     // Catch: Throwable -> L22
        RealWebSocket.Streams r0 = this.streams;     // Catch: Throwable -> L22
        this.streams = null;     // Catch: Throwable -> L22
        ScheduledFuture<?> r1 = this.cancelFuture;     // Catch: Throwable -> L22
        if (r1 == null) goto L10;
        r1.cancel(false);     // Catch: Throwable -> L22
    L10:
        ScheduledExecutorService r2 = this.executor;     // Catch: Throwable -> L22
        if (r2 == null) goto L13;
        r2.shutdown();     // Catch: Throwable -> L22
    L13:
        monitor-exit(this);     // Catch: Throwable -> L22
        WebSocketListener r3 = this.listener;     // Catch: Throwable -> L19
        if (r3 == null) goto L17;
        r3.onFailure(this, r4, r5);     // Catch: Throwable -> L19
    L17:
        Util.closeQuietly(r0);
        return;
    L19:
        th = move-exception;
        Util.closeQuietly(r0);
        throw th;
    }

    public void closeQuietly(int r2, String r3) {
        this.listener = null;
        close(r2, r3);     // Catch: Throwable -> L5
        return;
    }
}
