package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.ttnet.TTConfigManager;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes5.dex */
public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int AWAIT_PING = 3;
    static final int DEGRADED_PING = 2;
    static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    static final int INTERVAL_PING = 1;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService listenerExecutor = null;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    final String hostname;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings;
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    private boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams;
    long unacknowledgedBytesRead;
    final Http2Writer writer;
    private final ScheduledExecutorService writerExecutor;

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener;
        int pingIntervalMillis;
        PushObserver pushObserver;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean r2) {
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
            this.client = r2;
        }

        public Builder socket(Socket r4) throws IOException {
            return socket(r4, ((InetSocketAddress) r4.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(r4)), Okio.buffer(Okio.sink(r4)));
        }

        public Builder socket(Socket r1, String r2, BufferedSource r3, BufferedSink r4) {
            this.socket = r1;
            this.hostname = r2;
            this.source = r3;
            this.sink = r4;
            return this;
        }

        public Builder listener(Listener r1) {
            this.listener = r1;
            return this;
        }

        public Builder pushObserver(PushObserver r1) {
            this.pushObserver = r1;
            return this;
        }

        public Builder pingIntervalMillis(int r1) {
            this.pingIntervalMillis = r1;
            return this;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    final class IntervalPingRunnable extends NamedRunnable {
        final /* synthetic */ Http2Connection this$0;

        IntervalPingRunnable(Http2Connection r3) {
            this.this$0 = r3;
            super("OkHttp %s ping", new Object[]{r3.hostname});
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            if (TTConfigManager.inst().getAppResume() == true) goto L5;
            return;
        L5:
            Http2Connection r0 = this.this$0;
            monitor-enter(r0);
        L16:
            th = move-exception;
            throw th;
        L8:
            if (Http2Connection.access$100(this.this$0) >= Http2Connection.access$200(this.this$0)) goto L10;
            boolean r1 = true;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L16
            if (r1 == false) goto L14;
            Http2Connection.access$000(this.this$0);
            return;
        L14:
            this.this$0.writePing(false, 1, 0);
            return;
        L10:
            Http2Connection.access$208(this.this$0);     // Catch: Throwable -> L16
            r1 = false;
            goto L11
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = null;

        public void onSettings(Http2Connection r1) {
        }

        public abstract void onStream(Http2Stream r1) throws IOException;

        public Listener() {
        }

        static {
            REFUSE_INCOMING_STREAMS = new AnonymousClass1();
        }
    }

    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;
        final /* synthetic */ Http2Connection this$0;

        PingRunnable(Http2Connection r3, boolean r4, int r5, int r6) {
            this.this$0 = r3;
            super("OkHttp %s ping %08x%08x", new Object[]{r3.hostname, Integer.valueOf(r5), Integer.valueOf(r6)});
            this.reply = r4;
            this.payload1 = r5;
            this.payload2 = r6;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            this.this$0.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int r1, String r2, ByteString r3, String r4, int r5, long r6) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int r1, int r2, int r3, boolean r4) {
        }

        ReaderRunnable(Http2Connection r3, Http2Reader r4) {
            this.this$0 = r3;
            super("OkHttp %s", new Object[]{r3.hostname});
            this.reader = r4;
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            ErrorCode r0 = ErrorCode.INTERNAL_ERROR;
            ErrorCode r1 = ErrorCode.INTERNAL_ERROR;
            this.reader.readConnectionPreface(this);     // Catch: Throwable -> L10 IOException -> L12
        L5:
            if (this.reader.nextFrame(false, this) == true) goto L5;
            r0 = ErrorCode.NO_ERROR;     // Catch: Throwable -> L10 IOException -> L12
            r1 = ErrorCode.CANCEL;     // Catch: Throwable -> L10 IOException -> L12
            Http2Connection r2 = this.this$0;     // Catch: IOException -> L20
        L14:
            r2.close(r0, r1);     // Catch: IOException -> L20
            goto L15
        L12:
            r0 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L10
            r1 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L10
            r2 = this.this$0;     // Catch: IOException -> L20
        L15:
            Util.closeQuietly(this.reader);
            return;
        L10:
            th = move-exception;
            this.this$0.close(r0, r1);     // Catch: IOException -> L21
        L18:
            Util.closeQuietly(this.reader);
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean r2, int r3, BufferedSource r4, int r5) throws IOException {
            if (this.this$0.pushedStream(r3) == false) goto L6;
            this.this$0.pushDataLater(r3, r4, r5, r2);
            return;
        L6:
            Http2Stream r0 = this.this$0.getStream(r3);
            if (r0 != null) goto L10;
            this.this$0.writeSynResetLater(r3, ErrorCode.PROTOCOL_ERROR);
            long r6 = r5;
            this.this$0.updateConnectionFlowControl(r6);
            r4.skip(r6);
            return;
        L10:
            r0.receiveData(r4, r5);
            if (r2 == false) goto L14;
            r0.receiveFin();
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean r10, int r11, int r12, List<Header> r13) {
            if (this.this$0.pushedStream(r11) == false) goto L6;
            this.this$0.pushHeadersLater(r11, r13, r10);
            return;
        L6:
            Http2Connection r14 = this.this$0;
            monitor-enter(r14);
            Http2Stream r0 = this.this$0.getStream(r11);     // Catch: Throwable -> L30
            if (r0 == null) goto L11;
            monitor-exit(r14);     // Catch: Throwable -> L30
            r0.receiveHeaders(r13);
            if (r10 == false) goto L34;
            r0.receiveFin();
            return;
        L34:
            return;
        L11:
            if (Http2Connection.access$300(this.this$0) == false) goto L15;
            monitor-exit(r14);     // Catch: Throwable -> L30
            return;
        L15:
            if (r11 > this.this$0.lastGoodStreamId) goto L19;
            monitor-exit(r14);     // Catch: Throwable -> L30
            return;
        L19:
            if ((r11 % 2) != (this.this$0.nextStreamId % 2)) goto L22;
            monitor-exit(r14);     // Catch: Throwable -> L30
            return;
        L22:
            final Http2Stream r15 = new Http2Stream(r11, this.this$0, false, r10, Util.toHeaders(r13));     // Catch: Throwable -> L30
            this.this$0.lastGoodStreamId = r11;     // Catch: Throwable -> L30
            this.this$0.streams.put(Integer.valueOf(r11), r15);     // Catch: Throwable -> L30
            ExecutorService r16 = Http2Connection.access$400();     // Catch: Throwable -> L30
            final String r1 = "OkHttp %s stream %d";
            final Object[] r2 = {this.this$0.hostname, Integer.valueOf(r11)};     // Catch: Throwable -> L30
            r16.execute(new AnonymousClass1(this, r1, r2, r15));     // Catch: Throwable -> L30
            monitor-exit(r14);     // Catch: Throwable -> L30
            return;
        L30:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int r2, ErrorCode r3) {
            if (this.this$0.pushedStream(r2) == false) goto L6;
            this.this$0.pushResetLater(r2, r3);
            return;
        L6:
            Http2Stream r1 = this.this$0.removeStream(r2);
            if (r1 == null) goto L10;
            r1.receiveRstStream(r3);
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean r9, final Settings r10) {
            ScheduledExecutorService r0 = Http2Connection.access$500(this.this$0);     // Catch: RejectedExecutionException -> L4
            final String r3 = "OkHttp %s ACK Settings";
            final Object[] r4 = {this.this$0.hostname};     // Catch: RejectedExecutionException -> L4
            r0.execute(new AnonymousClass2(this, r3, r4, r9, r10));     // Catch: RejectedExecutionException -> L4
            return;
        }

        void applyAndAckSettings(boolean r6, Settings r7) {
            Http2Writer r0 = this.this$0.writer;
            monitor-enter(r0);
            Http2Connection r1 = this.this$0;     // Catch: Throwable -> L38
            monitor-enter(r1);     // Catch: Throwable -> L38
            int r2 = this.this$0.peerSettings.getInitialWindowSize();     // Catch: Throwable -> L35
            if (r6 == false) goto L9;
            this.this$0.peerSettings.clear();     // Catch: Throwable -> L35
        L9:
            this.this$0.peerSettings.merge(r7);     // Catch: Throwable -> L35
            int r8 = this.this$0.peerSettings.getInitialWindowSize();     // Catch: Throwable -> L35
            Http2Stream[] r3 = null;
            if (r8 == (-1)) goto L15;
            if (r8 == r2) goto L15;
            long r9 = r8 - r2;     // Catch: Throwable -> L35
            if (this.this$0.streams.isEmpty() == true) goto L16;
            r3 = (Http2Stream[]) this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);     // Catch: Throwable -> L35
        L16:
            monitor-exit(r1);     // Catch: Throwable -> L35
        L43:
            this.this$0.writer.applyAndAckSettings(this.this$0.peerSettings);     // Catch: IOException -> L19 Throwable -> L38
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L38
            if (r3 == null) goto L33;
            int r4 = r3.length;
            int r5 = 0;
        L24:
            if (r5 >= r4) goto L33;
            Http2Stream r10 = r3[r5];
            monitor-enter(r10);
            r10.addBytesToWriteWindow(r9);     // Catch: Throwable -> L30
            monitor-exit(r10);     // Catch: Throwable -> L30
            r5 = r5 + 1;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;
        L33:
            ExecutorService r11 = Http2Connection.access$400();
            final String r12 = "OkHttp %s settings";
            final Object[] r13 = {this.this$0.hostname};
            r11.execute(new AnonymousClass3(this, r12, r13));
            return;
        L19:
            Http2Connection.access$000(this.this$0);     // Catch: Throwable -> L38
        L15:
            r9 = 0;
        L35:
            th = move-exception;
            throw th;     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean r3, int r4, int r5) {
            if (r3 == false) goto L23;
            Http2Connection r6 = this.this$0;
            monitor-enter(r6);
            if (r4 != 1) goto L11;
            Http2Connection.access$108(this.this$0);     // Catch: Throwable -> L8
        L16:
            monitor-exit(r6);     // Catch: Throwable -> L8
            return;
        L11:
            if (r4 != 2) goto L14;
            Http2Connection.access$608(this.this$0);     // Catch: Throwable -> L8
            goto L16
        L14:
            if (r4 != 3) goto L16;
            Http2Connection.access$708(this.this$0);     // Catch: Throwable -> L8
            this.this$0.notifyAll();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        L23:
            Http2Connection.access$500(this.this$0).execute(new PingRunnable(this.this$0, true, r4, r5));     // Catch: RejectedExecutionException -> L22
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int r4, ErrorCode r5, ByteString r6) {
            r6.size();
            Http2Connection r7 = this.this$0;
            monitor-enter(r7);
            Http2Stream[] r8 = (Http2Stream[]) this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);     // Catch: Throwable -> L15
            Http2Connection.access$302(this.this$0, true);     // Catch: Throwable -> L15
            monitor-exit(r7);     // Catch: Throwable -> L15
            int r9 = r8.length;
            int r0 = 0;
        L7:
            if (r0 >= r9) goto L14;
            Http2Stream r1 = r8[r0];
            if (r1.getId() <= r4) goto L13;
            if (r1.isLocallyInitiated() == false) goto L13;
            r1.receiveRstStream(ErrorCode.REFUSED_STREAM);
            this.this$0.removeStream(r1.getId());
        L13:
            r0 = r0 + 1;
            goto L7
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int r4, long r5) {
            if (r4 != 0) goto L11;
            Http2Connection r0 = this.this$0;
            monitor-enter(r0);
            this.this$0.bytesLeftInWriteWindow += r5;     // Catch: Throwable -> L8
            this.this$0.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            Http2Stream r3 = this.this$0.getStream(r4);
            if (r3 == null) goto L25;
            monitor-enter(r3);
            r3.addBytesToWriteWindow(r5);     // Catch: Throwable -> L17
            monitor-exit(r3);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int r1, int r2, List<Header> r3) {
            this.this$0.pushRequestLater(r2, r3);
        }
    }

    boolean pushedStream(int r1) {
        if (r1 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r1 & 1) != 0) goto L6;
        return true;
    }

    static /* synthetic */ void access$000(Http2Connection r0) {
        r0.failConnection();
    }

    static /* synthetic */ long access$100(Http2Connection r2) {
        return r2.intervalPongsReceived;
    }

    static /* synthetic */ long access$108(Http2Connection r4) {
        long r0 = r4.intervalPongsReceived;
        r4.intervalPongsReceived = 1 + r0;
        return r0;
    }

    static /* synthetic */ long access$200(Http2Connection r2) {
        return r2.intervalPingsSent;
    }

    static /* synthetic */ long access$208(Http2Connection r4) {
        long r0 = r4.intervalPingsSent;
        r4.intervalPingsSent = 1 + r0;
        return r0;
    }

    static /* synthetic */ boolean access$300(Http2Connection r0) {
        return r0.shutdown;
    }

    static /* synthetic */ boolean access$302(Http2Connection r0, boolean r1) {
        r0.shutdown = r1;
        return r1;
    }

    static /* synthetic */ ExecutorService access$400() {
        return listenerExecutor;
    }

    static /* synthetic */ ScheduledExecutorService access$500(Http2Connection r0) {
        return r0.writerExecutor;
    }

    static /* synthetic */ long access$608(Http2Connection r4) {
        long r0 = r4.degradedPongsReceived;
        r4.degradedPongsReceived = 1 + r0;
        return r0;
    }

    static /* synthetic */ long access$708(Http2Connection r4) {
        long r0 = r4.awaitPongsReceived;
        r4.awaitPongsReceived = 1 + r0;
        return r0;
    }

    static {
        listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    }

    Http2Connection(Builder r24) {
        this.streams = new LinkedHashMap();
        this.intervalPingsSent = 0;
        this.intervalPongsReceived = 0;
        this.degradedPingsSent = 0;
        this.degradedPongsReceived = 0;
        this.awaitPingsSent = 0;
        this.awaitPongsReceived = 0;
        this.degradedPongDeadlineNs = 0;
        this.unacknowledgedBytesRead = 0;
        this.okHttpSettings = new Settings();
        Settings r2 = new Settings();
        this.peerSettings = r2;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = r24.pushObserver;
        boolean r3 = r24.client;
        this.client = r3;
        this.listener = r24.listener;
        if (r24.client == false) goto L5;
        int r4 = 1;
    L6:
        this.nextStreamId = r4;
        if (r24.client == false) goto L10;
        this.nextStreamId += 2;
    L10:
        if (r24.client == false) goto L12;
        this.okHttpSettings.set(7, 16777216);
    L12:
        String r5 = r24.hostname;
        this.hostname = r5;
        ScheduledThreadPoolExecutor r7 = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", new Object[]{r5}), false));
        this.writerExecutor = r7;
        if (r24.pingIntervalMillis == 0) goto L15;
        r7.scheduleAtFixedRate(new IntervalPingRunnable(this), r24.pingIntervalMillis, r24.pingIntervalMillis, TimeUnit.MILLISECONDS);
    L15:
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", new Object[]{r5}), true));
        r2.set(7, 65535);
        r2.set(5, 16384);
        this.bytesLeftInWriteWindow = r2.getInitialWindowSize();
        this.socket = r24.socket;
        this.writer = new Http2Writer(r24.sink, r3);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(r24.source, r3));
        return;
    L5:
        r4 = 2;
        goto L6
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized int openStreamCount() {
        monitor-enter(this);
        int r0 = this.streams.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Http2Stream getStream(int r2) {
        monitor-enter(this);
        Http2Stream r3 = this.streams.get(Integer.valueOf(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Http2Stream removeStream(int r2) {
        monitor-enter(this);
        Http2Stream r3 = this.streams.remove(Integer.valueOf(r2));     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int maxConcurrentStreams() {
        monitor-enter(this);
        int r0 = this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void updateConnectionFlowControl(long r3) {
        monitor-enter(this);
        long r0 = this.unacknowledgedBytesRead + r3;     // Catch: Throwable -> L8
        this.unacknowledgedBytesRead = r0;     // Catch: Throwable -> L8
        if (r0 < (this.okHttpSettings.getInitialWindowSize() / 2)) goto L6;
        writeWindowUpdateLater(0, this.unacknowledgedBytesRead);     // Catch: Throwable -> L8
        this.unacknowledgedBytesRead = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public Http2Stream pushStream(int r2, List<Header> r3, boolean r4) throws IOException {
        if (this.client == true) goto L7;
        return newStream(r2, r3, r4);
    L7:
        throw new IllegalStateException("Client cannot push requests.");
    }

    public Http2Stream newStream(List<Header> r2, boolean r3) throws IOException {
        return newStream(0, r2, r3);
    }

    private Http2Stream newStream(int r11, List<Header> r12, boolean r13) throws IOException {
        boolean r6 = !r13;
        Http2Writer r7 = this.writer;
        monitor-enter(r7);
        monitor-enter(this);     // Catch: Throwable -> L39
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L6:
        if (this.nextStreamId <= 1073741823) goto L9;
        shutdown(ErrorCode.REFUSED_STREAM);     // Catch: Throwable -> L36
    L9:
        if (this.shutdown == true) goto L35;
        int r8 = this.nextStreamId;     // Catch: Throwable -> L36
        this.nextStreamId = r8 + 2;     // Catch: Throwable -> L36
        Http2Stream r9 = new Http2Stream(r8, this, r6, false, null);     // Catch: Throwable -> L36
        if (r13 == true) goto L13;
    L18:
        boolean r14 = true;
    L20:
        if (r9.isOpen() == false) goto L22;
        this.streams.put(Integer.valueOf(r8), r9);     // Catch: Throwable -> L36
    L22:
        monitor-exit(this);     // Catch: Throwable -> L36
        if (r11 != 0) goto L26;
        this.writer.synStream(r6, r8, r11, r12);     // Catch: Throwable -> L39
    L28:
        monitor-exit(r7);     // Catch: Throwable -> L39
        if (r14 == false) goto L31;
        this.writer.flush();
    L31:
        return r9;
    L26:
        if (this.client == true) goto L33;
        this.writer.pushPromise(r11, r8, r12);     // Catch: Throwable -> L39
        goto L28
    L33:
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");     // Catch: Throwable -> L39
    L13:
        if (this.bytesLeftInWriteWindow == 0) goto L18;
        if (r9.bytesLeftInWriteWindow == 0) goto L18;
        r14 = false;
        goto L20
    L35:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L36
    L39:
        th = move-exception;
        throw th;
    }

    void writeSynReply(int r1, boolean r2, List<Header> r3) throws IOException {
        this.writer.synReply(r2, r1, r3);
    }

    public void writeData(int r9, boolean r10, Buffer r11, long r12) throws IOException {
        if (r12 != 0) goto L7;
        this.writer.data(r10, r9, r11, 0);
        return;
    L7:
        if (r12 <= 0) goto L31;
        monitor-enter(this);
    L32:
        long r4 = this.bytesLeftInWriteWindow;     // Catch: Throwable -> L25 InterruptedException -> L27
        if (r4 > 0) goto L16;
        if (this.streams.containsKey(Integer.valueOf(r9)) == false) goto L15;
        wait();     // Catch: Throwable -> L25 InterruptedException -> L27
        goto L32
    L15:
        throw new IOException("stream closed");     // Catch: Throwable -> L25 InterruptedException -> L27
    L16:
        int r2 = Math.min((int) Math.min(r12, r4), this.writer.maxDataLength());     // Catch: Throwable -> L25
        long r6 = r2;
        this.bytesLeftInWriteWindow -= r6;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        r12 = r12 - r6;
        Http2Writer r5 = this.writer;
        if (r10 == true) goto L21;
    L23:
        boolean r7 = false;
    L24:
        r5.data(r7, r9, r11, r2);
        goto L7
    L21:
        if (r12 != 0) goto L23;
        r7 = true;
    L25:
        th = move-exception;
        throw th;
    L27:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L25
        throw new InterruptedIOException();     // Catch: Throwable -> L25
    }

    void writeSynResetLater(final int r9, final ErrorCode r10) {
        ScheduledExecutorService r0 = this.writerExecutor;     // Catch: RejectedExecutionException -> L4
        final String r3 = "OkHttp %s stream %d";
        final Object[] r4 = {this.hostname, Integer.valueOf(r9)};     // Catch: RejectedExecutionException -> L4
        r0.execute(new AnonymousClass1(this, r3, r4, r9, r10));     // Catch: RejectedExecutionException -> L4
        return;
    }

    void writeSynReset(int r1, ErrorCode r2) throws IOException {
        this.writer.rstStream(r1, r2);
    }

    void writeWindowUpdateLater(final int r10, final long r11) {
        ScheduledExecutorService r0 = this.writerExecutor;     // Catch: RejectedExecutionException -> L4
        final String r3 = "OkHttp Window Update %s stream %d";
        final Object[] r4 = {this.hostname, Integer.valueOf(r10)};     // Catch: RejectedExecutionException -> L4
        r0.execute(new AnonymousClass2(this, r3, r4, r10, r11));     // Catch: RejectedExecutionException -> L4
        return;
    }

    void writePing(boolean r2, int r3, int r4) {
        this.writer.ping(r2, r3, r4);     // Catch: IOException -> L4
        return;
    L4:
        failConnection();
    }

    void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    void writePing() {
        monitor-enter(this);
        this.awaitPingsSent++;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        writePing(false, 3, 1330343787);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized void awaitPong() throws InterruptedException {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.awaitPongsReceived >= this.awaitPingsSent) goto L7;
        wait();     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public void shutdown(ErrorCode r4) throws IOException {
        Http2Writer r0 = this.writer;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L6:
        if (this.shutdown == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L11:
        this.shutdown = true;     // Catch: Throwable -> L16
        int r1 = this.lastGoodStreamId;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        this.writer.goAway(r1, r4, Util.EMPTY_BYTE_ARRAY);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    void close(ErrorCode r5, ErrorCode r6) throws IOException {
        Http2Stream[] r0 = null;
        shutdown(r5);     // Catch: IOException -> L5
        e = null;
    L6:
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L8:
        if (this.streams.isEmpty() == true) goto L10;
        r0 = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);     // Catch: Throwable -> L33
        this.streams.clear();     // Catch: Throwable -> L33
    L10:
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r0 == null) goto L40;
        int r1 = r0.length;
        int r2 = 0;
    L13:
        if (r2 >= r1) goto L40;
        r0[r2].close(r6);     // Catch: IOException -> L17
    L20:
        r2 = r2 + 1;
    L17:
        e = move-exception;
        if (e == null) goto L20;
        e = e;
    L40:
        this.writer.close();     // Catch: IOException -> L23
    L42:
        this.socket.close();     // Catch: IOException -> L28
    L29:
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) goto L32;
        return;
    L32:
        throw e;
    L28:
        e = e;
    L23:
        e = move-exception;
        if (e != null) goto L42;
        e = e;
    L5:
        e = e;
        goto L6
    }

    private void failConnection() {
        close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);     // Catch: IOException -> L4
        return;
    }

    public void start() throws IOException {
        start(true);
    }

    void start(boolean r5) throws IOException {
        if (r5 == false) goto L6;
        this.writer.connectionPreface();
        this.writer.settings(this.okHttpSettings);
        int r6 = this.okHttpSettings.getInitialWindowSize();
        if (r6 == 65535) goto L6;
        this.writer.windowUpdate(0, r6 - 65535);
    L6:
        new Thread(this.readerRunnable).start();
    }

    public void setSettings(Settings r3) throws IOException {
        Http2Writer r0 = this.writer;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L6:
        if (this.shutdown == true) goto L13;
        this.okHttpSettings.merge(r3);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        this.writer.settings(r3);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L13:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L14
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isHealthy(long r7) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.shutdown == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.degradedPongsReceived >= this.degradedPingsSent) goto L15;
        if (r7 < this.degradedPongDeadlineNs) goto L15;
        monitor-exit(this);
        return false;
    L15:
        monitor-exit(this);
        return true;
    }

    void sendDegradedPingLater() {
        monitor-enter(this);
        long r0 = this.degradedPongsReceived;     // Catch: Throwable -> L11
        long r2 = this.degradedPingsSent;     // Catch: Throwable -> L11
        if (r0 >= r2) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.degradedPingsSent = r2 + 1;     // Catch: Throwable -> L11
        this.degradedPongDeadlineNs = System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        ScheduledExecutorService r1 = this.writerExecutor;     // Catch: RejectedExecutionException -> L14
        final String r3 = "OkHttp %s ping";
        final Object[] r4 = {this.hostname};     // Catch: RejectedExecutionException -> L14
        r1.execute(new AnonymousClass3(this, r3, r4));     // Catch: RejectedExecutionException -> L14
        return;
    L18:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void pushRequestLater(final int r9, final List<Header> r10) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.currentPushRequests.contains(Integer.valueOf(r9)) == false) goto L8;
        writeSynResetLater(r9, ErrorCode.PROTOCOL_ERROR);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L8:
        this.currentPushRequests.add(Integer.valueOf(r9));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        final String r4 = "OkHttp %s Push Request[%s]";
        final Object[] r5 = {this.hostname, Integer.valueOf(r9)};     // Catch: RejectedExecutionException -> L15
        pushExecutorExecute(new AnonymousClass4(this, r4, r5, r9, r10));     // Catch: RejectedExecutionException -> L15
        return;
    }

    void pushHeadersLater(final int r9, final List<Header> r10, final boolean r11) {
        final String r2 = "OkHttp %s Push Headers[%s]";
        final Object[] r3 = {this.hostname, Integer.valueOf(r9)};     // Catch: RejectedExecutionException -> L4
        pushExecutorExecute(new AnonymousClass5(this, r2, r3, r9, r10, r11));     // Catch: RejectedExecutionException -> L4
        return;
    }

    void pushDataLater(final int r9, BufferedSource r10, final int r11, final boolean r12) throws IOException {
        final Buffer r5 = new Buffer();
        long r0 = r11;
        r10.require(r0);
        r10.read(r5, r0);
        if (r5.size() != r0) goto L7;
        final String r2 = "OkHttp %s Push Data[%s]";
        final Object[] r3 = {this.hostname, Integer.valueOf(r9)};
        pushExecutorExecute(new AnonymousClass6(this, r2, r3, r9, r5, r11, r12));
        return;
    L7:
        throw new IOException(r5.size() + " != " + r11);
    }

    void pushResetLater(final int r8, final ErrorCode r9) {
        final String r2 = "OkHttp %s Push Reset[%s]";
        final Object[] r3 = {this.hostname, Integer.valueOf(r8)};
        pushExecutorExecute(new AnonymousClass7(this, r2, r3, r8, r9));
    }

    private synchronized void pushExecutorExecute(NamedRunnable r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.shutdown == true) goto L6;
        this.pushExecutor.execute(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
