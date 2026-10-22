package okhttp3.internal.http2;

import a.a;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = null;

    @NotNull
    private static final Settings DEFAULT_SETTINGS = null;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;

    @NotNull
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;

    @NotNull
    private final Listener listener;
    private int nextStreamId;

    @NotNull
    private final Settings okHttpSettings;

    @NotNull
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;

    @NotNull
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;

    @NotNull
    private final Socket socket;

    @NotNull
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;

    @NotNull
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    @Metadata
    public static final class Builder {
        private boolean client;

        @NotNull
        public String connectionName;

        @NotNull
        private Listener listener;
        private int pingIntervalMillis;

        @NotNull
        private PushObserver pushObserver;

        @NotNull
        public BufferedSink sink;

        @NotNull
        public Socket socket;

        @NotNull
        public BufferedSource source;

        @NotNull
        private final TaskRunner taskRunner;

        public Builder(boolean r2, @NotNull TaskRunner r3) {
            Intrinsics.f(r3, "taskRunner");
            this.client = r2;
            this.taskRunner = r3;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder r0, Socket r1, String r2, BufferedSource r3, BufferedSink r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r2 = Util.peerName(r1);
        L6:
            if ((r5 & 4) == 0) goto L9;
            r3 = Okio.buffer(Okio.source(r1));
        L9:
            if ((r5 & 8) == 0) goto L12;
            r4 = Okio.buffer(Okio.sink(r1));
        L12:
            return r0.socket(r1, r2, r3, r4);
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String r0 = this.connectionName;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.m("connectionName");
            throw null;
        }

        @NotNull
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        @NotNull
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        @NotNull
        public final BufferedSink getSink$okhttp() {
            BufferedSink r0 = this.sink;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.m("sink");
            throw null;
        }

        @NotNull
        public final Socket getSocket$okhttp() {
            Socket r0 = this.socket;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.m("socket");
            throw null;
        }

        @NotNull
        public final BufferedSource getSource$okhttp() {
            BufferedSource r0 = this.source;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.m(DBHelper.BATTERY_COL_SOURCE);
            throw null;
        }

        @NotNull
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @NotNull
        public final Builder listener(@NotNull Listener r2) {
            Intrinsics.f(r2, "listener");
            this.listener = r2;
            return this;
        }

        @NotNull
        public final Builder pingIntervalMillis(int r1) {
            this.pingIntervalMillis = r1;
            return this;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver r2) {
            Intrinsics.f(r2, "pushObserver");
            this.pushObserver = r2;
            return this;
        }

        public final void setClient$okhttp(boolean r1) {
            this.client = r1;
        }

        public final void setConnectionName$okhttp(@NotNull String r2) {
            Intrinsics.f(r2, "<set-?>");
            this.connectionName = r2;
        }

        public final void setListener$okhttp(@NotNull Listener r2) {
            Intrinsics.f(r2, "<set-?>");
            this.listener = r2;
        }

        public final void setPingIntervalMillis$okhttp(int r1) {
            this.pingIntervalMillis = r1;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver r2) {
            Intrinsics.f(r2, "<set-?>");
            this.pushObserver = r2;
        }

        public final void setSink$okhttp(@NotNull BufferedSink r2) {
            Intrinsics.f(r2, "<set-?>");
            this.sink = r2;
        }

        public final void setSocket$okhttp(@NotNull Socket r2) {
            Intrinsics.f(r2, "<set-?>");
            this.socket = r2;
        }

        public final void setSource$okhttp(@NotNull BufferedSource r2) {
            Intrinsics.f(r2, "<set-?>");
            this.source = r2;
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket r8) {
            return socket$default(this, r8, null, null, null, 14, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket r8, @NotNull String r9) {
            return socket$default(this, r8, r9, null, null, 12, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket r8, @NotNull String r9, @NotNull BufferedSource r10) {
            return socket$default(this, r8, r9, r10, null, 8, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket r2, @NotNull String r3, @NotNull BufferedSource r4, @NotNull BufferedSink r5) {
            Intrinsics.f(r2, "socket");
            Intrinsics.f(r3, "peerName");
            Intrinsics.f(r4, DBHelper.BATTERY_COL_SOURCE);
            Intrinsics.f(r5, "sink");
            this.socket = r2;
            if (this.client == false) goto L5;
            String r6 = Util.okHttpName + ' ' + r3;
        L6:
            this.connectionName = r6;
            this.source = r4;
            this.sink = r5;
            return this;
        L5:
            r6 = "MockWebServer ".concat(r3);
            goto L6
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.access$getDEFAULT_SETTINGS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static abstract class Listener {
        public static final Companion Companion = null;

        @JvmField
        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS = null;

        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();
        }

        public Listener() {
        }

        public void onSettings(@NotNull Http2Connection r1, @NotNull Settings r2) {
            Intrinsics.f(r1, WsConstants.KEY_CONNECTION);
            Intrinsics.f(r2, "settings");
        }

        public abstract void onStream(@NotNull Http2Stream r1);
    }

    @Metadata
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {

        @NotNull
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(@NotNull Http2Connection r2, Http2Reader r3) {
            Intrinsics.f(r3, "reader");
            this.this$0 = r2;
            this.reader = r3;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int r1, @NotNull String r2, @NotNull ByteString r3, @NotNull String r4, int r5, long r6) {
            Intrinsics.f(r2, "origin");
            Intrinsics.f(r3, "protocol");
            Intrinsics.f(r4, "host");
        }

        public final void applyAndAckSettings(final boolean r22, @NotNull final Settings r23) {
            Intrinsics.f(r23, "settings");
            final Ref.LongRef r13 = new Ref.LongRef();
            final Ref.ObjectRef r14 = new Ref.ObjectRef();
            final Ref.ObjectRef r15 = new Ref.ObjectRef();
            Http2Writer r16 = this.this$0.getWriter();
            monitor-enter(r16);
            Http2Connection r11 = this.this$0;     // Catch: Throwable -> L29
            monitor-enter(r11);     // Catch: Throwable -> L29
            Settings r1 = this.this$0.getPeerSettings();     // Catch: Throwable -> L18
            if (r22 == false) goto L9;
            Settings r2 = r23;
        L10:
            r15.b = r2;     // Catch: Throwable -> L18
            long r3 = ((long) r2.getInitialWindowSize()) - ((long) r1.getInitialWindowSize());     // Catch: Throwable -> L18
            r13.b = r3;     // Catch: Throwable -> L18
            if (r3 != 0) goto L13;
        L22:
            Http2Stream[] r4 = null;
        L23:
            r14.b = r4;     // Catch: Throwable -> L18
            this.this$0.setPeerSettings((Settings) r15.b);     // Catch: Throwable -> L18
            TaskQueue r7 = Http2Connection.access$getSettingsListenerQueue$p(this.this$0);     // Catch: Throwable -> L18
            final String r5 = this.this$0.getConnectionName$okhttp() + " onSettings";     // Catch: Throwable -> L18
            final boolean r6 = true;
            Http2Connection r20 = r11;
            r7.schedule(new Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1(r5, r6, r5, r6, this, r15, r22, r23, r13, r14), 0);     // Catch: Throwable -> L47
            monitor-exit(r20);     // Catch: Throwable -> L29
            this.this$0.getWriter().applyAndAckSettings((Settings) r15.b);     // Catch: Throwable -> L29 IOException -> L31
        L33:
            monitor-exit(r16);
            Object r0 = r14.b;
            if (((Http2Stream[]) r0) == null) goto L46;
            Http2Stream[] r8 = (Http2Stream[]) r0;
            Intrinsics.c(r8);
            int r9 = r8.length;
            int r10 = 0;
        L37:
            if (r10 >= r9) goto L61;
            Http2Stream r12 = r8[r10];
            monitor-enter(r12);
            r12.addBytesToWriteWindow(r13.b);     // Catch: Throwable -> L43
            monitor-exit(r12);
            r10 = r10 + 1;
        L43:
            th = move-exception;
            throw th;
        L61:
            return;
        L46:
            return;
        L31:
            e = move-exception;
            Http2Connection.access$failConnection(this.this$0, e);     // Catch: Throwable -> L29
        L47:
            th = th;
        L48:
            monitor-exit(r20);     // Catch: Throwable -> L29
            throw th;     // Catch: Throwable -> L29
        L13:
            if (this.this$0.getStreams$okhttp().isEmpty() == true) goto L22;
            Object[] r17 = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L18
            if (r17 == null) goto L21;
            r4 = (Http2Stream[]) r17;     // Catch: Throwable -> L18
            goto L23
        L21:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L18
        L9:
            r2 = new Settings();     // Catch: Throwable -> L18
            r2.merge(r1);     // Catch: Throwable -> L18
            r2.merge(r23);     // Catch: Throwable -> L18
        L18:
            th = th;
            r20 = r11;
        L29:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean r2, int r3, @NotNull BufferedSource r4, int r5) {
            Intrinsics.f(r4, DBHelper.BATTERY_COL_SOURCE);
            if (this.this$0.pushedStream$okhttp(r3) == false) goto L6;
            this.this$0.pushDataLater$okhttp(r3, r4, r5, r2);
            return;
        L6:
            Http2Stream r0 = this.this$0.getStream(r3);
            if (r0 != null) goto L10;
            this.this$0.writeSynResetLater$okhttp(r3, ErrorCode.PROTOCOL_ERROR);
            long r6 = r5;
            this.this$0.updateConnectionFlowControl$okhttp(r6);
            r4.skip(r6);
            return;
        L10:
            r0.receiveData(r4, r5);
            if (r2 == false) goto L14;
            r0.receiveHeaders(Util.EMPTY_HEADERS, true);
            return;
        }

        @NotNull
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int r4, @NotNull ErrorCode r5, @NotNull ByteString r6) {
            Intrinsics.f(r5, AccountConst.KEY_ERROR_CODE);
            Intrinsics.f(r6, "debugData");
            r6.size();
            Http2Connection r7 = this.this$0;
            monitor-enter(r7);
            int r0 = 0;
            Object[] r8 = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L17
            if (r8 == null) goto L20;
            Http2Stream[] r9 = (Http2Stream[]) r8;     // Catch: Throwable -> L17
            Http2Connection.access$setShutdown$p(this.this$0, true);     // Catch: Throwable -> L17
            monitor-exit(r7);
            int r10 = r9.length;
        L9:
            if (r0 >= r10) goto L16;
            Http2Stream r1 = r9[r0];
            if (r1.getId() <= r4) goto L15;
            if (r1.isLocallyInitiated() == false) goto L15;
            r1.receiveRstStream(ErrorCode.REFUSED_STREAM);
            this.this$0.removeStream$okhttp(r1.getId());
        L15:
            r0 = r0 + 1;
            goto L9
        L16:
            return;
        L20:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(final boolean r16, final int r17, int r18, @NotNull final List<Header> r19) {
            Intrinsics.f(r19, "headerBlock");
            if (this.this$0.pushedStream$okhttp(r17) == false) goto L6;
            this.this$0.pushHeadersLater$okhttp(r17, r19, r16);
            return;
        L6:
            Http2Connection r12 = this.this$0;
            monitor-enter(r12);
            final Http2Stream r8 = this.this$0.getStream(r17);     // Catch: Throwable -> L25
            if (r8 == null) goto L11;
            monitor-exit(r12);
            r8.receiveHeaders(Util.toHeaders(r19), r16);
            return;
        L11:
            if (Http2Connection.access$isShutdown$p(this.this$0) == false) goto L15;
            monitor-exit(r12);
            return;
        L15:
            if (r17 > this.this$0.getLastGoodStreamId$okhttp()) goto L19;
            monitor-exit(r12);
            return;
        L19:
            if ((r17 % 2) != (this.this$0.getNextStreamId$okhttp() % 2)) goto L22;
            monitor-exit(r12);
            return;
        L22:
            final Http2Stream r7 = new Http2Stream(r17, this.this$0, false, r16, Util.toHeaders(r19));     // Catch: Throwable -> L25
            this.this$0.setLastGoodStreamId$okhttp(r17);     // Catch: Throwable -> L25
            this.this$0.getStreams$okhttp().put(Integer.valueOf(r17), r7);     // Catch: Throwable -> L25
            TaskQueue r13 = Http2Connection.access$getTaskRunner$p(this.this$0).newQueue();     // Catch: Throwable -> L25
            final String r4 = this.this$0.getConnectionName$okhttp() + '[' + r17 + "] onStream";     // Catch: Throwable -> L25
            final boolean r5 = true;
            r13.schedule(new Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1(r4, r5, r4, r5, r7, this, r8, r17, r19, r16), 0);     // Catch: Throwable -> L25
            monitor-exit(r12);
            return;
        L25:
            th = move-exception;
            throw th;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m179invoke();
            return Unit.f330a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean r11, final int r12, final int r13) {
            if (r11 == false) goto L25;
            Http2Connection r14 = this.this$0;
            monitor-enter(r14);
            if (r12 != 1) goto L8;
            Http2Connection r10 = this.this$0;     // Catch: Throwable -> L15
            Http2Connection.access$setIntervalPongsReceived$p(r10, Http2Connection.access$getIntervalPongsReceived$p(r10) + 1);     // Catch: Throwable -> L15
        L21:
            monitor-exit(r14);
            return;
        L8:
            if (r12 != 2) goto L10;
            Http2Connection r15 = this.this$0;     // Catch: Throwable -> L15
            Http2Connection.access$setDegradedPongsReceived$p(r15, Http2Connection.access$getDegradedPongsReceived$p(r15) + 1);     // Catch: Throwable -> L15
            goto L21
        L10:
            if (r12 != 3) goto L21;
            Http2Connection r16 = this.this$0;     // Catch: Throwable -> L15
            Http2Connection.access$setAwaitPongsReceived$p(r16, Http2Connection.access$getAwaitPongsReceived$p(r16) + 1);     // Catch: Throwable -> L15
            Http2Connection r17 = this.this$0;     // Catch: Throwable -> L15
            if (r17 == null) goto L18;
            r17.notifyAll();     // Catch: Throwable -> L15
            goto L21
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        L25:
            TaskQueue r18 = Http2Connection.access$getWriterQueue$p(this.this$0);
            final String r5 = this.this$0.getConnectionName$okhttp() + " ping";
            final boolean r6 = true;
            r18.schedule(new Http2Connection$ReaderRunnable$ping$$inlined$execute$1(r5, r6, r5, r6, this, r12, r13), 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int r1, int r2, int r3, boolean r4) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int r1, int r2, @NotNull List<Header> r3) {
            Intrinsics.f(r3, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(r2, r3);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int r2, @NotNull ErrorCode r3) {
            Intrinsics.f(r3, AccountConst.KEY_ERROR_CODE);
            if (this.this$0.pushedStream$okhttp(r2) == false) goto L6;
            this.this$0.pushResetLater$okhttp(r2, r3);
            return;
        L6:
            Http2Stream r1 = this.this$0.removeStream$okhttp(r2);
            if (r1 == null) goto L10;
            r1.receiveRstStream(r3);
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean r12, @NotNull final Settings r13) {
            Intrinsics.f(r13, "settings");
            TaskQueue r0 = Http2Connection.access$getWriterQueue$p(this.this$0);
            final String r6 = this.this$0.getConnectionName$okhttp() + " applyAndAckSettings";
            final boolean r7 = true;
            r0.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$1(r6, r7, r6, r7, this, r12, r13), 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int r4, long r5) {
            if (r4 != 0) goto L16;
            Http2Connection r6 = this.this$0;
            monitor-enter(r6);
            Http2Connection r0 = this.this$0;     // Catch: Throwable -> L10
            Http2Connection.access$setWriteBytesMaximum$p(r0, r0.getWriteBytesMaximum() + r5);     // Catch: Throwable -> L10
            Http2Connection r3 = this.this$0;     // Catch: Throwable -> L10
            if (r3 == null) goto L13;
            r3.notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r6);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        L16:
            Http2Stream r7 = this.this$0.getStream(r4);
            if (r7 == null) goto L25;
            monitor-enter(r7);
            r7.addBytesToWriteWindow(r5);     // Catch: Throwable -> L22
            monitor-exit(r7);
            return;
        L22:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
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
        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public void m179invoke() {
            ErrorCode r0 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            this.reader.readConnectionPreface(this);     // Catch: Throwable -> L15 IOException -> L17
        L5:
            if (this.reader.nextFrame(false, this) == true) goto L5;
            ErrorCode r2 = ErrorCode.NO_ERROR;     // Catch: Throwable -> L15 IOException -> L17
            r0 = ErrorCode.CANCEL;     // Catch: Throwable -> L11 IOException -> L13
            this.this$0.close$okhttp(r2, r0, null);
            ErrorCode r3 = r2;
        L10:
            ReaderRunnable this = this.reader;
            Util.closeQuietly(this);
            return;
        L13:
            e = e;
        L19:
            r0 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L11
            Http2Connection r4 = this.this$0;
            r4.close$okhttp(r0, r0, e);
            r3 = r4;
            goto L10
        L11:
            th = th;
        L22:
            this.this$0.close$okhttp(r3, r0, e);
            Util.closeQuietly(this.reader);
            throw th;
        L17:
            e = e;
        L15:
            th = th;
            r3 = r0;
            goto L22
        }
    }

    static {
        Companion = new Companion(null);
        Settings r0 = new Settings();
        r0.set(7, 65535);
        r0.set(5, 16384);
        DEFAULT_SETTINGS = r0;
    }

    public Http2Connection(@NotNull Builder r13) {
        Intrinsics.f(r13, "builder");
        boolean r0 = r13.getClient$okhttp();
        this.client = r0;
        this.listener = r13.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String r1 = r13.getConnectionName$okhttp();
        this.connectionName = r1;
        if (r13.getClient$okhttp() == false) goto L5;
        int r2 = 3;
    L6:
        this.nextStreamId = r2;
        TaskRunner r3 = r13.getTaskRunner$okhttp();
        this.taskRunner = r3;
        TaskQueue r4 = r3.newQueue();
        this.writerQueue = r4;
        this.pushQueue = r3.newQueue();
        this.settingsListenerQueue = r3.newQueue();
        this.pushObserver = r13.getPushObserver$okhttp();
        Settings r5 = new Settings();
        if (r13.getClient$okhttp() == false) goto L9;
        r5.set(7, 16777216);
    L9:
        this.okHttpSettings = r5;
        Settings r6 = DEFAULT_SETTINGS;
        this.peerSettings = r6;
        this.writeBytesMaximum = r6.getInitialWindowSize();
        this.socket = r13.getSocket$okhttp();
        this.writer = new Http2Writer(r13.getSink$okhttp(), r0);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(r13.getSource$okhttp(), r0));
        this.currentPushRequests = new LinkedHashSet();
        if (r13.getPingIntervalMillis$okhttp() == 0) goto L13;
        final long r7 = TimeUnit.MILLISECONDS.toNanos(r13.getPingIntervalMillis$okhttp());
        final String r8 = a.j(r1, " ping");
        r4.schedule(new Http2Connection$$special$$inlined$schedule$1(r8, r8, this, r7), r7);
        return;
    L13:
        return;
    L5:
        r2 = 2;
        goto L6
    }

    public static final /* synthetic */ void access$failConnection(Http2Connection r0, IOException r1) {
        r0.failConnection(r1);
    }

    public static final /* synthetic */ long access$getAwaitPongsReceived$p(Http2Connection r2) {
        return r2.awaitPongsReceived;
    }

    public static final /* synthetic */ Set access$getCurrentPushRequests$p(Http2Connection r0) {
        return r0.currentPushRequests;
    }

    public static final /* synthetic */ Settings access$getDEFAULT_SETTINGS$cp() {
        return DEFAULT_SETTINGS;
    }

    public static final /* synthetic */ long access$getDegradedPongsReceived$p(Http2Connection r2) {
        return r2.degradedPongsReceived;
    }

    public static final /* synthetic */ long access$getIntervalPingsSent$p(Http2Connection r2) {
        return r2.intervalPingsSent;
    }

    public static final /* synthetic */ long access$getIntervalPongsReceived$p(Http2Connection r2) {
        return r2.intervalPongsReceived;
    }

    public static final /* synthetic */ PushObserver access$getPushObserver$p(Http2Connection r0) {
        return r0.pushObserver;
    }

    public static final /* synthetic */ TaskQueue access$getSettingsListenerQueue$p(Http2Connection r0) {
        return r0.settingsListenerQueue;
    }

    public static final /* synthetic */ TaskRunner access$getTaskRunner$p(Http2Connection r0) {
        return r0.taskRunner;
    }

    public static final /* synthetic */ long access$getWriteBytesMaximum$p(Http2Connection r2) {
        return r2.writeBytesMaximum;
    }

    public static final /* synthetic */ TaskQueue access$getWriterQueue$p(Http2Connection r0) {
        return r0.writerQueue;
    }

    public static final /* synthetic */ boolean access$isShutdown$p(Http2Connection r0) {
        return r0.isShutdown;
    }

    public static final /* synthetic */ void access$setAwaitPongsReceived$p(Http2Connection r0, long r1) {
        r0.awaitPongsReceived = r1;
    }

    public static final /* synthetic */ void access$setDegradedPongsReceived$p(Http2Connection r0, long r1) {
        r0.degradedPongsReceived = r1;
    }

    public static final /* synthetic */ void access$setIntervalPingsSent$p(Http2Connection r0, long r1) {
        r0.intervalPingsSent = r1;
    }

    public static final /* synthetic */ void access$setIntervalPongsReceived$p(Http2Connection r0, long r1) {
        r0.intervalPongsReceived = r1;
    }

    public static final /* synthetic */ void access$setShutdown$p(Http2Connection r0, boolean r1) {
        r0.isShutdown = r1;
    }

    public static final /* synthetic */ void access$setWriteBytesMaximum$p(Http2Connection r0, long r1) {
        r0.writeBytesMaximum = r1;
    }

    private final void failConnection(IOException r2) {
        ErrorCode r0 = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(r0, r0, r2);
    }

    public static /* synthetic */ void start$default(Http2Connection r0, boolean r1, TaskRunner r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = TaskRunner.INSTANCE;
    L8:
        r0.start(r1, r2);
    }

    public final synchronized void awaitPong() {
        monitor-enter(this);
    L13:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.awaitPongsReceived >= this.awaitPingsSent) goto L9;
        wait();     // Catch: Throwable -> L7
        goto L13
    L9:
        monitor-exit(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(@NotNull ErrorCode r4, @NotNull ErrorCode r5, @Nullable IOException r6) {
        Intrinsics.f(r4, "connectionCode");
        Intrinsics.f(r5, "streamCode");
        if (Util.assertionsEnabled == true) goto L5;
    L45:
        shutdown(r4);     // Catch: IOException -> L34
    L10:
        monitor-enter(this);
        int r0 = 0;
        if ((!this.streams.isEmpty()) == false) goto L20;
        Object[] r7 = this.streams.values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L16
        if (r7 == null) goto L19;
        Http2Stream[] r8 = (Http2Stream[]) r7;     // Catch: Throwable -> L16
        this.streams.clear();     // Catch: Throwable -> L16
    L21:
        monitor-exit(this);
        if (r8 == null) goto L43;
        int r1 = r8.length;
    L24:
        if (r0 >= r1) goto L43;
        r8[r0].close(r5, r6);     // Catch: IOException -> L35
    L27:
        r0 = r0 + 1;
    L43:
        this.writer.close();     // Catch: IOException -> L36
    L41:
        this.socket.close();     // Catch: IOException -> L37
    L30:
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L16
    L20:
        r8 = null;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L45;
        StringBuilder r9 = new StringBuilder("Thread ");
        Thread r10 = Thread.currentThread();
        Intrinsics.e(r10, "Thread.currentThread()");
        r9.append(r10.getName());
        r9.append(" MUST NOT hold lock on ");
        r9.append(this);
        throw new AssertionError(r9.toString());
    }

    public final void flush() {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @NotNull
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    @NotNull
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    @NotNull
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @Nullable
    public final synchronized Http2Stream getStream(int r2) {
        monitor-enter(this);
        Http2Stream r3 = this.streams.get(Integer.valueOf(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    @NotNull
    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long r7) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.isShutdown == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.degradedPongsReceived >= this.degradedPingsSent) goto L17;
        if (r7 < this.degradedPongDeadlineNs) goto L17;
        monitor-exit(this);
        return false;
    L17:
        monitor-exit(this);
        return true;
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List<Header> r2, boolean r3) {
        Intrinsics.f(r2, "requestHeaders");
        return newStream(0, r2, r3);
    }

    public final synchronized int openStreamCount() {
        monitor-enter(this);
        int r0 = this.streams.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void pushDataLater$okhttp(final int r12, @NotNull BufferedSource r13, final int r14, final boolean r15) {
        Intrinsics.f(r13, DBHelper.BATTERY_COL_SOURCE);
        final Buffer r8 = new Buffer();
        long r0 = r14;
        r13.require(r0);
        r13.read(r8, r0);
        TaskQueue r16 = this.pushQueue;
        final String r4 = this.connectionName + '[' + r12 + "] onData";
        final boolean r5 = true;
        r16.schedule(new Http2Connection$pushDataLater$$inlined$execute$1(r4, r5, r4, r5, this, r12, r8, r14, r15), 0);
    }

    public final void pushHeadersLater$okhttp(final int r13, @NotNull final List<Header> r14, final boolean r15) {
        Intrinsics.f(r14, "requestHeaders");
        TaskQueue r0 = this.pushQueue;
        final String r6 = this.connectionName + '[' + r13 + "] onHeaders";
        final boolean r7 = true;
        r0.schedule(new Http2Connection$pushHeadersLater$$inlined$execute$1(r6, r7, r6, r7, this, r13, r14, r15), 0);
    }

    public final void pushRequestLater$okhttp(final int r12, @NotNull final List<Header> r13) {
        Intrinsics.f(r13, "requestHeaders");
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.currentPushRequests.contains(Integer.valueOf(r12)) == false) goto L11;
        writeSynResetLater$okhttp(r12, ErrorCode.PROTOCOL_ERROR);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L11:
        this.currentPushRequests.add(Integer.valueOf(r12));     // Catch: Throwable -> L9
        monitor-exit(this);
        TaskQueue r0 = this.pushQueue;
        final String r6 = this.connectionName + '[' + r12 + "] onRequest";
        final boolean r7 = true;
        r0.schedule(new Http2Connection$pushRequestLater$$inlined$execute$1(r6, r7, r6, r7, this, r12, r13), 0);
    }

    public final void pushResetLater$okhttp(final int r12, @NotNull final ErrorCode r13) {
        Intrinsics.f(r13, AccountConst.KEY_ERROR_CODE);
        TaskQueue r0 = this.pushQueue;
        final String r6 = this.connectionName + '[' + r12 + "] onReset";
        final boolean r7 = true;
        r0.schedule(new Http2Connection$pushResetLater$$inlined$execute$1(r6, r7, r6, r7, this, r12, r13), 0);
    }

    @NotNull
    public final Http2Stream pushStream(int r2, @NotNull List<Header> r3, boolean r4) {
        Intrinsics.f(r3, "requestHeaders");
        if ((!this.client) == false) goto L7;
        return newStream(r2, r3, r4);
    L7:
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int r1) {
        if (r1 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r1 & 1) != 0) goto L6;
        return true;
    }

    @Nullable
    public final synchronized Http2Stream removeStream$okhttp(int r2) {
        monitor-enter(this);
        Http2Stream r3 = this.streams.remove(Integer.valueOf(r2));     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final void sendDegradedPingLater$okhttp() {
        monitor-enter(this);
        long r0 = this.degradedPongsReceived;     // Catch: Throwable -> L13
        long r2 = this.degradedPingsSent;     // Catch: Throwable -> L13
        if (r0 >= r2) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.degradedPingsSent = r2 + 1;     // Catch: Throwable -> L13
        this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);     // Catch: Throwable -> L13
        monitor-exit(this);
        TaskQueue r1 = this.writerQueue;
        final String r7 = a.o(new StringBuilder(), this.connectionName, " ping");
        final boolean r8 = true;
        r1.schedule(new Http2Connection$sendDegradedPingLater$$inlined$execute$1(r7, r8, r7, r8, this), 0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void setLastGoodStreamId$okhttp(int r1) {
        this.lastGoodStreamId = r1;
    }

    public final void setNextStreamId$okhttp(int r1) {
        this.nextStreamId = r1;
    }

    public final void setPeerSettings(@NotNull Settings r2) {
        Intrinsics.f(r2, "<set-?>");
        this.peerSettings = r2;
    }

    public final void setSettings(@NotNull Settings r3) {
        Intrinsics.f(r3, "settings");
        Http2Writer r0 = this.writer;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L6:
        if (this.isShutdown == true) goto L17;
        this.okHttpSettings.merge(r3);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L12
        this.writer.settings(r3);     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L17:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L14
    L12:
        th = move-exception;
        throw th;
    }

    public final void shutdown(@NotNull ErrorCode r4) {
        Intrinsics.f(r4, "statusCode");
        Http2Writer r0 = this.writer;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L10
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L6:
        if (this.isShutdown == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L13:
        this.isShutdown = true;     // Catch: Throwable -> L18
        int r1 = this.lastGoodStreamId;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L10
        this.writer.goAway(r1, r4, Util.EMPTY_BYTE_ARRAY);     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @JvmOverloads
    public final void start() {
        start$default(this, false, null, 3, null);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long r3) {
        monitor-enter(this);
        long r0 = this.readBytesTotal + r3;     // Catch: Throwable -> L7
        this.readBytesTotal = r0;     // Catch: Throwable -> L7
        long r1 = r0 - this.readBytesAcknowledged;     // Catch: Throwable -> L7
        if (r1 < (this.okHttpSettings.getInitialWindowSize() / 2)) goto L9;
        writeWindowUpdateLater$okhttp(0, r1);     // Catch: Throwable -> L7
        this.readBytesAcknowledged += r1;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void writeData(int r9, boolean r10, @Nullable Buffer r11, long r12) {
        if (r12 != 0) goto L7;
        this.writer.data(r10, r9, r11, 0);
        return;
    L7:
        if (r12 <= 0) goto L32;
        monitor-enter(this);
    L33:
        long r4 = this.writeBytesTotal;     // Catch: Throwable -> L14 InterruptedException -> L28
        long r6 = this.writeBytesMaximum;     // Catch: Throwable -> L14 InterruptedException -> L28
        if (r4 < r6) goto L19;
        if (this.streams.containsKey(Integer.valueOf(r9)) == false) goto L17;
        wait();     // Catch: Throwable -> L14 InterruptedException -> L28
        goto L33
    L17:
        throw new IOException("stream closed");     // Catch: Throwable -> L14 InterruptedException -> L28
    L19:
        int r2 = Math.min((int) Math.min(r12, r6 - r4), this.writer.maxDataLength());     // Catch: Throwable -> L14
        long r7 = r2;
        this.writeBytesTotal += r7;     // Catch: Throwable -> L14
        monitor-exit(this);
        r12 = r12 - r7;
        Http2Writer r5 = this.writer;
        if (r10 == true) goto L24;
    L26:
        boolean r8 = false;
    L27:
        r5.data(r8, r9, r11, r2);
        goto L7
    L24:
        if (r12 != 0) goto L26;
        r8 = true;
    L14:
        th = move-exception;
        throw th;
    L28:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L14
        throw new InterruptedIOException();     // Catch: Throwable -> L14
    }

    public final void writeHeaders$okhttp(int r2, boolean r3, @NotNull List<Header> r4) {
        Intrinsics.f(r4, "alternating");
        this.writer.headers(r3, r2, r4);
    }

    public final void writePing(boolean r2, int r3, int r4) {
        this.writer.ping(r2, r3, r4);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        failConnection(e);
    }

    public final void writePingAndAwaitPong() {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int r2, @NotNull ErrorCode r3) {
        Intrinsics.f(r3, "statusCode");
        this.writer.rstStream(r2, r3);
    }

    public final void writeSynResetLater$okhttp(final int r12, @NotNull final ErrorCode r13) {
        Intrinsics.f(r13, AccountConst.KEY_ERROR_CODE);
        TaskQueue r0 = this.writerQueue;
        final String r6 = this.connectionName + '[' + r12 + "] writeSynReset";
        final boolean r7 = true;
        r0.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$1(r6, r7, r6, r7, this, r12, r13), 0);
    }

    public final void writeWindowUpdateLater$okhttp(final int r13, final long r14) {
        TaskQueue r0 = this.writerQueue;
        final String r6 = this.connectionName + '[' + r13 + "] windowUpdate";
        final boolean r7 = true;
        r0.schedule(new Http2Connection$writeWindowUpdateLater$$inlined$execute$1(r6, r7, r6, r7, this, r13, r14), 0);
    }

    private final Http2Stream newStream(int r11, List<Header> r12, boolean r13) {
        boolean r6 = !r13;
        Http2Writer r7 = this.writer;
        monitor-enter(r7);
        monitor-enter(this);     // Catch: Throwable -> L27
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L6:
        if (this.nextStreamId <= 1073741823) goto L11;
        shutdown(ErrorCode.REFUSED_STREAM);     // Catch: Throwable -> L8
    L11:
        if (this.isShutdown == true) goto L39;
        int r8 = this.nextStreamId;     // Catch: Throwable -> L8
        this.nextStreamId = r8 + 2;     // Catch: Throwable -> L8
        Http2Stream r9 = new Http2Stream(r8, this, r6, false, null);     // Catch: Throwable -> L8
        if (r13 == true) goto L15;
    L20:
        boolean r14 = true;
    L22:
        if (r9.isOpen() == false) goto L24;
        this.streams.put(Integer.valueOf(r8), r9);     // Catch: Throwable -> L8
    L24:
        monitor-exit(this);     // Catch: Throwable -> L27
        if (r11 != 0) goto L30;
        this.writer.headers(r6, r8, r12);     // Catch: Throwable -> L27
    L32:
        monitor-exit(r7);
        if (r14 == false) goto L35;
        this.writer.flush();
    L35:
        return r9;
    L30:
        if ((true ^ this.client) == false) goto L37;
        this.writer.pushPromise(r11, r8, r12);     // Catch: Throwable -> L27
        goto L32
    L37:
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());     // Catch: Throwable -> L27
    L15:
        if (this.writeBytesTotal >= this.writeBytesMaximum) goto L20;
        if (r9.getWriteBytesTotal() >= r9.getWriteBytesMaximum()) goto L20;
        r14 = false;
        goto L22
    L39:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L8
    L27:
        th = move-exception;
        throw th;
    }

    @JvmOverloads
    public final void start(boolean r3) {
        start$default(this, r3, null, 2, null);
    }

    @JvmOverloads
    public final void start(boolean r7, @NotNull TaskRunner r8) {
        Intrinsics.f(r8, "taskRunner");
        if (r7 == false) goto L7;
        this.writer.connectionPreface();
        this.writer.settings(this.okHttpSettings);
        int r9 = this.okHttpSettings.getInitialWindowSize();
        if (r9 == 65535) goto L7;
        this.writer.windowUpdate(0, r9 - 65535);
    L7:
        TaskQueue r10 = r8.newQueue();
        String r4 = this.connectionName;
        r10.schedule(new TaskQueue.AnonymousClass1(this.readerRunnable, r4, true, r4, true), 0);
    }

    public final void writePing() {
        monitor-enter(this);
        this.awaitPingsSent++;     // Catch: Throwable -> L7
        monitor-exit(this);
        writePing(false, 3, 1330343787);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
