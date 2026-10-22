package okhttp3.internal.http2;

import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.google.common.net.HttpHeaders;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.message.TokenParser;
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

/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u0099\u00012\u00020\u0001:\b\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020QH\u0016J'\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010WH\u0000¢\u0006\u0002\bXJ\u0012\u0010Y\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010WH\u0002J\u0006\u0010[\u001a\u00020QJ\u0010\u0010\\\u001a\u0004\u0018\u00010B2\u0006\u0010]\u001a\u00020\u0012J\u000e\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u0006J&\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tH\u0002J\u001c\u0010`\u001a\u00020B2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0006\u0010f\u001a\u00020\u0012J-\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\tH\u0000¢\u0006\u0002\bmJ+\u0010n\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010l\u001a\u00020\tH\u0000¢\u0006\u0002\boJ#\u0010p\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0002\bqJ\u001d\u0010r\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000¢\u0006\u0002\btJ$\u0010u\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0015\u0010v\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u0012H\u0000¢\u0006\u0002\bwJ\u0017\u0010x\u001a\u0004\u0018\u00010B2\u0006\u0010h\u001a\u00020\u0012H\u0000¢\u0006\u0002\byJ\r\u0010z\u001a\u00020QH\u0000¢\u0006\u0002\b{J\u000e\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020&J\u000e\u0010~\u001a\u00020Q2\u0006\u0010\u007f\u001a\u00020TJ\u001e\u0010\u0080\u0001\u001a\u00020Q2\t\b\u0002\u0010\u0081\u0001\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020FH\u0007J\u0018\u0010\u0082\u0001\u001a\u00020Q2\u0007\u0010\u0083\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u0084\u0001J,\u0010\u0085\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u00020\t2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u0006\u0010k\u001a\u00020\u0006J/\u0010\u0089\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u00020\t2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0003\b\u008b\u0001J\u0007\u0010\u008c\u0001\u001a\u00020QJ\"\u0010\u008c\u0001\u001a\u00020Q2\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u00122\u0007\u0010\u008f\u0001\u001a\u00020\u0012J\u0007\u0010\u0090\u0001\u001a\u00020QJ\u001f\u0010\u0091\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010\u007f\u001a\u00020TH\u0000¢\u0006\u0003\b\u0092\u0001J\u001f\u0010\u0093\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000¢\u0006\u0003\b\u0094\u0001J \u0010\u0095\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0096\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u0097\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010(\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0015\u00107\u001a\u000608R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020B0AX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u00104R\u001e\u0010I\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010K\u001a\u00020L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009c\u0001"}, d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "awaitPingsSent", "", "awaitPongsReceived", DeviceInfoProvider.CLIENT, "", "getClient$okhttp", "()Z", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "currentPushRequests", "", "", "degradedPingsSent", "degradedPongDeadlineNs", "degradedPongsReceived", "intervalPingsSent", "intervalPongsReceived", "isShutdown", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "pushQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "settingsListenerQueue", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "streams", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerQueue", "awaitPong", "", "close", "connectionCode", "Lokhttp3/internal/http2/ErrorCode;", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", "flush", "getStream", "id", "isHealthy", "nowNs", "newStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "openStreamCount", "pushDataLater", "streamId", "source", "Lokio/BufferedSource;", "byteCount", "inFinished", "pushDataLater$okhttp", "pushHeadersLater", "pushHeadersLater$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushResetLater", AccountConst.KEY_ERROR_CODE, "pushResetLater$okhttp", "pushStream", "pushedStream", "pushedStream$okhttp", "removeStream", "removeStream$okhttp", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "setSettings", "settings", "shutdown", "statusCode", "start", "sendConnectionPreface", "updateConnectionFlowControl", "read", "updateConnectionFlowControl$okhttp", "writeData", "outFinished", "buffer", "Lokio/Buffer;", "writeHeaders", "alternating", "writeHeaders$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "writeSynReset", "writeSynReset$okhttp", "writeSynResetLater", "writeSynResetLater$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "Builder", "Companion", "Listener", "ReaderRunnable", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = null;
    private static final Settings DEFAULT_SETTINGS = null;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    /* JADX INFO: compiled from: Http2Connection.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00107\u001a\u000208J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ.\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010#\u001a\u00020$H\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", DeviceInfoProvider.CLIENT, "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", IndexDatabaseHelper.MetaColumns.BUILD, "Lokhttp3/internal/http2/Http2Connection;", "peerName", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        private final TaskRunner taskRunner;

        public final Builder socket(Socket r9) throws IOException {
            Intrinsics.checkNotNullParameter(r9, "socket");
            return socket$default(this, r9, null, null, null, 14, null);
        }

        public final Builder socket(Socket r9, String r10) throws IOException {
            Intrinsics.checkNotNullParameter(r9, "socket");
            Intrinsics.checkNotNullParameter(r10, "peerName");
            return socket$default(this, r9, r10, null, null, 12, null);
        }

        public final Builder socket(Socket r9, String r10, BufferedSource r11) throws IOException {
            Intrinsics.checkNotNullParameter(r9, "socket");
            Intrinsics.checkNotNullParameter(r10, "peerName");
            Intrinsics.checkNotNullParameter(r11, "source");
            return socket$default(this, r9, r10, r11, null, 8, null);
        }

        public Builder(boolean r2, TaskRunner r3) {
            Intrinsics.checkNotNullParameter(r3, "taskRunner");
            this.client = r2;
            this.taskRunner = r3;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final void setClient$okhttp(boolean r1) {
            this.client = r1;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Socket getSocket$okhttp() {
            Socket r0 = this.socket;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final void setSocket$okhttp(Socket r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.socket = r2;
        }

        public final String getConnectionName$okhttp() {
            String r0 = this.connectionName;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final void setConnectionName$okhttp(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.connectionName = r2;
        }

        public final BufferedSource getSource$okhttp() {
            BufferedSource r0 = this.source;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        public final void setSource$okhttp(BufferedSource r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.source = r2;
        }

        public final BufferedSink getSink$okhttp() {
            BufferedSink r0 = this.sink;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final void setSink$okhttp(BufferedSink r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.sink = r2;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final void setListener$okhttp(Listener r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.listener = r2;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final void setPushObserver$okhttp(PushObserver r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.pushObserver = r2;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final void setPingIntervalMillis$okhttp(int r1) {
            this.pingIntervalMillis = r1;
        }

        public static /* synthetic */ Builder socket$default(Builder r0, Socket r1, String r2, BufferedSource r3, BufferedSink r4, int r5, Object r6) throws IOException {
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

        public final Builder socket(Socket r2, String r3, BufferedSource r4, BufferedSink r5) throws IOException {
            Intrinsics.checkNotNullParameter(r2, "socket");
            Intrinsics.checkNotNullParameter(r3, "peerName");
            Intrinsics.checkNotNullParameter(r4, "source");
            Intrinsics.checkNotNullParameter(r5, "sink");
            setSocket$okhttp(r2);
            if (getClient$okhttp() == false) goto L5;
            String r6 = Util.okHttpName + TokenParser.SP + r3;
        L6:
            setConnectionName$okhttp(r6);
            setSource$okhttp(r4);
            setSink$okhttp(r5);
            return this;
        L5:
            r6 = Intrinsics.stringPlus("MockWebServer ", r3);
            goto L6
        }

        public final Builder listener(Listener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            setListener$okhttp(r2);
            return this;
        }

        public final Builder pushObserver(PushObserver r2) {
            Intrinsics.checkNotNullParameter(r2, "pushObserver");
            setPushObserver$okhttp(r2);
            return this;
        }

        public final Builder pingIntervalMillis(int r2) {
            setPingIntervalMillis$okhttp(r2);
            return this;
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "()V", "AWAIT_PING", "", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.access$getDEFAULT_SETTINGS$cp();
        }
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Listener {
        public static final Companion Companion = null;
        public static final Listener REFUSE_INCOMING_STREAMS = null;

        /* JADX INFO: compiled from: Http2Connection.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        public void onSettings(Http2Connection r1, Settings r2) {
            Intrinsics.checkNotNullParameter(r1, WsConstants.KEY_CONNECTION);
            Intrinsics.checkNotNullParameter(r2, "settings");
        }

        public abstract void onStream(Http2Stream r1) throws IOException;

        public Listener() {
        }

        static {
            Companion = new Companion(null);
            REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();
        }
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J.\u0010$\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\t\u0010)\u001a\u00020\u0003H\u0096\u0002J \u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0016J(\u0010.\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0017H\u0016J&\u00102\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u00068"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "reader", "Lokhttp3/internal/http2/Http2Reader;", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "ackSettings", "alternateService", "streamId", "", HttpHeaders.ReferrerPolicyValues.ORIGIN, "", "protocol", "Lokio/ByteString;", WifiAuthorizeUtils.AUTO_LOGIN_HOST, ClientCookie.PORT_ATTR, "maxAge", "", "applyAndAckSettings", "clearPrevious", "", "settings", "Lokhttp3/internal/http2/Settings;", "data", "inFinished", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", AccountConst.KEY_ERROR_CODE, "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "invoke", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "windowUpdate", "windowSizeIncrement", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int r1, String r2, ByteString r3, String r4, int r5, long r6) {
            Intrinsics.checkNotNullParameter(r2, HttpHeaders.ReferrerPolicyValues.ORIGIN);
            Intrinsics.checkNotNullParameter(r3, "protocol");
            Intrinsics.checkNotNullParameter(r4, WifiAuthorizeUtils.AUTO_LOGIN_HOST);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int r1, int r2, int r3, boolean r4) {
        }

        public ReaderRunnable(Http2Connection r2, Http2Reader r3) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "reader");
            this.this$0 = r2;
            this.reader = r3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2() {
            ErrorCode r0 = ErrorCode.INTERNAL_ERROR;
            ErrorCode r1 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            this.reader.readConnectionPreface(this);     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (this.reader.nextFrame(false, this) == true) goto L5;
            r0 = ErrorCode.NO_ERROR;     // Catch: Throwable -> L9 IOException -> L11
            ErrorCode r2 = ErrorCode.CANCEL;     // Catch: Throwable -> L9 IOException -> L11
        L13:
            this.this$0.close$okhttp(r0, r2, e);
            Util.closeQuietly(this.reader);
            return;
        L11:
            e = e;
            r0 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L9
            r2 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.this$0.close$okhttp(r0, r1, e);
            Util.closeQuietly(this.reader);
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean r2, int r3, BufferedSource r4, int r5) throws IOException {
            Intrinsics.checkNotNullParameter(r4, "source");
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

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean r7, int r8, int r9, List<Header> r10) {
            Intrinsics.checkNotNullParameter(r10, "headerBlock");
            if (this.this$0.pushedStream$okhttp(r8) == false) goto L6;
            this.this$0.pushHeadersLater$okhttp(r8, r10, r7);
            return;
        L6:
            final Http2Connection r6 = this.this$0;
            monitor-enter(r6);
            Http2Stream r11 = r6.getStream(r8);     // Catch: Throwable -> L29
            if (r11 == null) goto L11;
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L29
            monitor-exit(r6);
            r11.receiveHeaders(Util.toHeaders(r10), r7);
            return;
        L11:
            if (Http2Connection.access$isShutdown$p(r6) == false) goto L15;
            monitor-exit(r6);
            return;
        L15:
            if (r8 > r6.getLastGoodStreamId$okhttp()) goto L19;
            monitor-exit(r6);
            return;
        L19:
            if ((r8 % 2) != (r6.getNextStreamId$okhttp() % 2)) goto L22;
            monitor-exit(r6);
            return;
        L22:
            final Http2Stream r13 = new Http2Stream(r8, r6, false, r7, Util.toHeaders(r10));     // Catch: Throwable -> L29
            r6.setLastGoodStreamId$okhttp(r8);     // Catch: Throwable -> L29
            r6.getStreams$okhttp().put(Integer.valueOf(r8), r13);     // Catch: Throwable -> L29
            TaskQueue r14 = Http2Connection.access$getTaskRunner$p(r6).newQueue();     // Catch: Throwable -> L29
            final String r15 = r6.getConnectionName$okhttp() + '[' + r8 + "] onStream";     // Catch: Throwable -> L29
            final boolean r0 = true;
            r14.schedule(new Http2Connection$ReaderRunnable$headers$lambda2$$inlined$execute$default$1(r15, r0, r6, r13), 0);     // Catch: Throwable -> L29
            monitor-exit(r6);
            return;
        L29:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int r2, ErrorCode r3) {
            Intrinsics.checkNotNullParameter(r3, AccountConst.KEY_ERROR_CODE);
            if (this.this$0.pushedStream$okhttp(r2) == false) goto L6;
            this.this$0.pushResetLater$okhttp(r2, r3);
            return;
        L6:
            Http2Stream r1 = this.this$0.removeStream$okhttp(r2);
            if (r1 == null) goto L11;
            r1.receiveRstStream(r3);
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean r10, final Settings r11) {
            Intrinsics.checkNotNullParameter(r11, "settings");
            TaskQueue r0 = Http2Connection.access$getWriterQueue$p(this.this$0);
            final String r4 = Intrinsics.stringPlus(this.this$0.getConnectionName$okhttp(), " applyAndAckSettings");
            final boolean r5 = true;
            r0.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(r4, r5, this, r10, r11), 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void applyAndAckSettings(boolean r11, Settings r12) {
            Intrinsics.checkNotNullParameter(r12, "settings");
            final Ref.ObjectRef r0 = new Ref.ObjectRef();
            Http2Writer r1 = this.this$0.getWriter();
            final Http2Connection r10 = this.this$0;
            monitor-enter(r1);
            monitor-enter(r10);     // Catch: Throwable -> L43
            Settings r2 = r10.getPeerSettings();     // Catch: Throwable -> L40
            if (r11 == false) goto L8;
            T r13 = r12;
        L9:
            r0.element = r13;     // Catch: Throwable -> L40
            long r14 = ((long) ((Settings) r0.element).getInitialWindowSize()) - ((long) r2.getInitialWindowSize());     // Catch: Throwable -> L40
            int r5 = 0;
            if (r14 != 0) goto L12;
        L19:
            Http2Stream[] r4 = null;
        L20:
            r10.setPeerSettings((Settings) r0.element);     // Catch: Throwable -> L40
            TaskQueue r6 = Http2Connection.access$getSettingsListenerQueue$p(r10);     // Catch: Throwable -> L40
            final String r7 = Intrinsics.stringPlus(r10.getConnectionName$okhttp(), " onSettings");     // Catch: Throwable -> L40
            final boolean r9 = true;
            r6.schedule(new Http2Connection$ReaderRunnable$applyAndAckSettings$lambda7$lambda6$$inlined$execute$default$1(r7, r9, r10, r0), 0);     // Catch: Throwable -> L40
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L40
            monitor-exit(r10);     // Catch: Throwable -> L43
            r10.getWriter().applyAndAckSettings((Settings) r0.element);     // Catch: IOException -> L24 Throwable -> L43
        L26:
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L43
            monitor-exit(r1);
            if (r4 == null) goto L39;
            int r16 = r4.length;
        L30:
            if (r5 >= r16) goto L53;
            Http2Stream r8 = r4[r5];
            r5 = r5 + 1;
            monitor-enter(r8);
            r8.addBytesToWriteWindow(r14);     // Catch: Throwable -> L36
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L36
            monitor-exit(r8);
        L36:
            th = move-exception;
            throw th;
        L53:
            return;
        L39:
            return;
        L24:
            e = move-exception;
            Http2Connection.access$failConnection(r10, e);     // Catch: Throwable -> L43
            goto L26
        L12:
            if (r10.getStreams$okhttp().isEmpty() == true) goto L19;
            Object[] r18 = r10.getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L40
            if (r18 == null) goto L18;
            r4 = (Http2Stream[]) r18;     // Catch: Throwable -> L40
            goto L20
        L18:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L40
        L8:
            Settings r19 = new Settings();     // Catch: Throwable -> L40
            r19.merge(r2);     // Catch: Throwable -> L40
            r19.merge(r12);     // Catch: Throwable -> L40
            r13 = r19;
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean r9, final int r10, final int r11) {
            if (r9 == false) goto L20;
            Http2Connection r8 = this.this$0;
            monitor-enter(r8);
            if (r10 != 1) goto L8;
            long r12 = Http2Connection.access$getIntervalPongsReceived$p(r8);     // Catch: Throwable -> L17
            Http2Connection.access$setIntervalPongsReceived$p(r8, 1 + r12);     // Catch: Throwable -> L17
            Long.valueOf(r12);     // Catch: Throwable -> L17
        L15:
            monitor-exit(r8);
            return;
        L8:
            if (r10 != 2) goto L10;
            long r13 = Http2Connection.access$getDegradedPongsReceived$p(r8);     // Catch: Throwable -> L17
            Http2Connection.access$setDegradedPongsReceived$p(r8, 1 + r13);     // Catch: Throwable -> L17
            Long.valueOf(r13);     // Catch: Throwable -> L17
            goto L15
        L10:
            if (r10 == 3) goto L12;
        L11:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L17
            goto L15
        L12:
            Http2Connection.access$setAwaitPongsReceived$p(r8, Http2Connection.access$getAwaitPongsReceived$p(r8) + 1);     // Catch: Throwable -> L17
            r8.notifyAll();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        L20:
            TaskQueue r15 = Http2Connection.access$getWriterQueue$p(this.this$0);
            final String r3 = Intrinsics.stringPlus(this.this$0.getConnectionName$okhttp(), " ping");
            final Http2Connection r5 = this.this$0;
            final boolean r4 = true;
            r15.schedule(new Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1(r3, r4, r5, r10, r11), 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int r4, ErrorCode r5, ByteString r6) {
            Intrinsics.checkNotNullParameter(r5, AccountConst.KEY_ERROR_CODE);
            Intrinsics.checkNotNullParameter(r6, "debugData");
            r6.size();
            Http2Connection r7 = this.this$0;
            monitor-enter(r7);
            int r0 = 0;
            Object[] r8 = r7.getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L18
            if (r8 == null) goto L17;
            Http2Connection.access$setShutdown$p(r7, true);     // Catch: Throwable -> L18
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L18
            monitor-exit(r7);
            Http2Stream[] r9 = (Http2Stream[]) r8;
            int r10 = r9.length;
        L9:
            if (r0 >= r10) goto L15;
            Http2Stream r2 = r9[r0];
            r0 = r0 + 1;
            if (r2.getId() <= r4) goto L9;
            if (r2.isLocallyInitiated() == false) goto L9;
            r2.receiveRstStream(ErrorCode.REFUSED_STREAM);
            this.this$0.removeStream$okhttp(r2.getId());
            goto L9
        L15:
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int r3, long r4) {
            if (r3 != 0) goto L11;
            Http2Connection r2 = this.this$0;
            monitor-enter(r2);
            Http2Connection.access$setWriteBytesMaximum$p(r2, r2.getWriteBytesMaximum() + r4);     // Catch: Throwable -> L8
            r2.notifyAll();     // Catch: Throwable -> L8
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r2);
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            Http2Stream r6 = this.this$0.getStream(r3);
            if (r6 == null) goto L20;
            monitor-enter(r6);
            r6.addBytesToWriteWindow(r4);     // Catch: Throwable -> L17
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(r6);
            return;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int r1, int r2, List<Header> r3) {
            Intrinsics.checkNotNullParameter(r3, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(r2, r3);
        }
    }

    public final boolean pushedStream$okhttp(int r1) {
        if (r1 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r1 & 1) != 0) goto L6;
        return true;
    }

    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    public final void start(boolean r3) throws IOException {
        start$default(this, r3, null, 2, null);
    }

    public Http2Connection(Builder r7) {
        Intrinsics.checkNotNullParameter(r7, "builder");
        boolean r0 = r7.getClient$okhttp();
        this.client = r0;
        this.listener = r7.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String r1 = r7.getConnectionName$okhttp();
        this.connectionName = r1;
        if (r7.getClient$okhttp() == false) goto L5;
        int r2 = 3;
    L6:
        this.nextStreamId = r2;
        TaskRunner r3 = r7.getTaskRunner$okhttp();
        this.taskRunner = r3;
        TaskQueue r4 = r3.newQueue();
        this.writerQueue = r4;
        this.pushQueue = r3.newQueue();
        this.settingsListenerQueue = r3.newQueue();
        this.pushObserver = r7.getPushObserver$okhttp();
        Settings r5 = new Settings();
        if (r7.getClient$okhttp() == false) goto L9;
        r5.set(7, 16777216);
    L9:
        this.okHttpSettings = r5;
        Settings r6 = DEFAULT_SETTINGS;
        this.peerSettings = r6;
        this.writeBytesMaximum = r6.getInitialWindowSize();
        this.socket = r7.getSocket$okhttp();
        this.writer = new Http2Writer(r7.getSink$okhttp(), r0);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(r7.getSource$okhttp(), r0));
        this.currentPushRequests = new LinkedHashSet();
        if (r7.getPingIntervalMillis$okhttp() == 0) goto L13;
        final long r8 = TimeUnit.MILLISECONDS.toNanos(r7.getPingIntervalMillis$okhttp());
        final String r9 = Intrinsics.stringPlus(r1, " ping");
        r4.schedule(new Http2Connection$special$$inlined$schedule$1(r9, this, r8), r8);
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

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final void setLastGoodStreamId$okhttp(int r1) {
        this.lastGoodStreamId = r1;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final void setNextStreamId$okhttp(int r1) {
        this.nextStreamId = r1;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final void setPeerSettings(Settings r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.peerSettings = r2;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
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

    public final synchronized Http2Stream getStream(int r2) {
        monitor-enter(this);
        Http2Stream r3 = this.streams.get(Integer.valueOf(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

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

    public final synchronized void updateConnectionFlowControl$okhttp(long r3) {
        monitor-enter(this);
        long r0 = this.readBytesTotal + r3;     // Catch: Throwable -> L8
        this.readBytesTotal = r0;     // Catch: Throwable -> L8
        long r1 = r0 - this.readBytesAcknowledged;     // Catch: Throwable -> L8
        if (r1 < (this.okHttpSettings.getInitialWindowSize() / 2)) goto L6;
        writeWindowUpdateLater$okhttp(0, r1);     // Catch: Throwable -> L8
        this.readBytesAcknowledged += r1;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final Http2Stream pushStream(int r2, List<Header> r3, boolean r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "requestHeaders");
        if ((!this.client) == false) goto L7;
        return newStream(r2, r3, r4);
    L7:
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final Http2Stream newStream(List<Header> r2, boolean r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "requestHeaders");
        return newStream(0, r2, r3);
    }

    private final Http2Stream newStream(int r11, List<Header> r12, boolean r13) throws IOException {
        boolean r6 = !r13;
        Http2Writer r7 = this.writer;
        monitor-enter(r7);
        monitor-enter(this);     // Catch: Throwable -> L41
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L6:
        if (getNextStreamId$okhttp() <= 1073741823) goto L9;
        shutdown(ErrorCode.REFUSED_STREAM);     // Catch: Throwable -> L38
    L9:
        if (this.isShutdown == true) goto L37;
        int r8 = getNextStreamId$okhttp();     // Catch: Throwable -> L38
        setNextStreamId$okhttp(getNextStreamId$okhttp() + 2);     // Catch: Throwable -> L38
        Http2Stream r9 = new Http2Stream(r8, this, r6, false, null);     // Catch: Throwable -> L38
        if (r13 == true) goto L13;
    L18:
        boolean r14 = true;
    L20:
        if (r9.isOpen() == false) goto L22;
        getStreams$okhttp().put(Integer.valueOf(r8), r9);     // Catch: Throwable -> L38
    L22:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L41
        if (r11 != 0) goto L27;
        getWriter().headers(r6, r8, r12);     // Catch: Throwable -> L41
    L29:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r7);
        if (r14 == false) goto L33;
        this.writer.flush();
    L33:
        return r9;
    L27:
        if ((true ^ getClient$okhttp()) == false) goto L35;
        getWriter().pushPromise(r11, r8, r12);     // Catch: Throwable -> L41
        goto L29
    L35:
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());     // Catch: Throwable -> L41
    L13:
        if (getWriteBytesTotal() >= getWriteBytesMaximum()) goto L18;
        if (r9.getWriteBytesTotal() >= r9.getWriteBytesMaximum()) goto L18;
        r14 = false;
        goto L20
    L37:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L38
    L41:
        th = move-exception;
        throw th;
    }

    public final void writeHeaders$okhttp(int r2, boolean r3, List<Header> r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "alternating");
        this.writer.headers(r3, r2, r4);
    }

    public final void writeData(int r9, boolean r10, Buffer r11, long r12) throws IOException {
        if (r12 != 0) goto L7;
        this.writer.data(r10, r9, r11, 0);
        return;
    L7:
        if (r12 <= 0) goto L31;
        monitor-enter(this);
    L32:
    L25:
        th = move-exception;
        throw th;
    L27:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L25
        throw new InterruptedIOException();     // Catch: Throwable -> L25
    L10:
        if (getWriteBytesTotal() < getWriteBytesMaximum()) goto L16;
        if (getStreams$okhttp().containsKey(Integer.valueOf(r9)) == false) goto L15;
        wait();     // Catch: Throwable -> L25 InterruptedException -> L27
        goto L32
    L15:
        throw new IOException("stream closed");     // Catch: Throwable -> L25 InterruptedException -> L27
    L16:
        int r2 = Math.min((int) Math.min(r12, getWriteBytesMaximum() - getWriteBytesTotal()), getWriter().maxDataLength());     // Catch: Throwable -> L25
        long r6 = r2;
        this.writeBytesTotal = getWriteBytesTotal() + r6;     // Catch: Throwable -> L25
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(this);
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
        goto L24
    }

    public final void writeSynResetLater$okhttp(final int r9, final ErrorCode r10) {
        Intrinsics.checkNotNullParameter(r10, AccountConst.KEY_ERROR_CODE);
        TaskQueue r0 = this.writerQueue;
        final String r3 = this.connectionName + '[' + r9 + "] writeSynReset";
        final boolean r4 = true;
        r0.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$default$1(r3, r4, this, r9, r10), 0);
    }

    public final void writeSynReset$okhttp(int r2, ErrorCode r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "statusCode");
        this.writer.rstStream(r2, r3);
    }

    public final void writeWindowUpdateLater$okhttp(final int r10, final long r11) {
        TaskQueue r0 = this.writerQueue;
        final String r3 = this.connectionName + '[' + r10 + "] windowUpdate";
        final boolean r4 = true;
        r0.schedule(new Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1(r3, r4, this, r10, r11), 0);
    }

    public final void writePing(boolean r2, int r3, int r4) {
        this.writer.ping(r2, r3, r4);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        failConnection(e);
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writePing() throws InterruptedException {
        monitor-enter(this);
        this.awaitPingsSent++;     // Catch: Throwable -> L7
        monitor-exit(this);
        writePing(false, 3, 1330343787);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void awaitPong() throws InterruptedException {
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

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final void shutdown(ErrorCode r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "statusCode");
        Http2Writer r0 = this.writer;
        monitor-enter(r0);
        Ref.IntRef r1 = new Ref.IntRef();     // Catch: Throwable -> L20
        monitor-enter(this);     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L7:
        if (this.isShutdown == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L12:
        this.isShutdown = true;     // Catch: Throwable -> L17
        r1.element = getLastGoodStreamId$okhttp();     // Catch: Throwable -> L17
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L20
        getWriter().goAway(r1.element, r4, Util.EMPTY_BYTE_ARRAY);     // Catch: Throwable -> L20
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    private final void failConnection(IOException r3) {
        close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, r3);
    }

    public static /* synthetic */ void start$default(Http2Connection r0, boolean r1, TaskRunner r2, int r3, Object r4) throws IOException {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = TaskRunner.INSTANCE;
    L8:
        r0.start(r1, r2);
    }

    public final void start(boolean r5, TaskRunner r6) throws IOException {
        Intrinsics.checkNotNullParameter(r6, "taskRunner");
        if (r5 == false) goto L7;
        this.writer.connectionPreface();
        this.writer.settings(this.okHttpSettings);
        int r7 = this.okHttpSettings.getInitialWindowSize();
        if (r7 == 65535) goto L7;
        this.writer.windowUpdate(0, r7 - 65535);
    L7:
        r6.newQueue().schedule(new TaskQueue.AnonymousClass1(this.connectionName, true, this.readerRunnable), 0);
    }

    public final void setSettings(Settings r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "settings");
        Http2Writer r0 = this.writer;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L6:
        if (this.isShutdown == true) goto L13;
        getOkHttpSettings().merge(r3);     // Catch: Throwable -> L14
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L17
        getWriter().settings(r3);     // Catch: Throwable -> L17
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L13:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L14
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean isHealthy(long r7) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.isShutdown == false) goto L9;
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

    public final void sendDegradedPingLater$okhttp() {
        monitor-enter(this);
        long r0 = this.degradedPongsReceived;     // Catch: Throwable -> L13
        long r2 = this.degradedPingsSent;     // Catch: Throwable -> L13
        if (r0 >= r2) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.degradedPingsSent = r2 + 1;     // Catch: Throwable -> L13
        this.degradedPongDeadlineNs = System.nanoTime() + ((long) 1000000000);     // Catch: Throwable -> L13
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        TaskQueue r3 = this.writerQueue;
        final String r4 = Intrinsics.stringPlus(this.connectionName, " ping");
        final boolean r5 = true;
        r3.schedule(new Http2Connection$sendDegradedPingLater$$inlined$execute$default$1(r4, r5, this), 0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void pushRequestLater$okhttp(final int r9, final List<Header> r10) {
        Intrinsics.checkNotNullParameter(r10, "requestHeaders");
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.currentPushRequests.contains(Integer.valueOf(r9)) == false) goto L9;
        writeSynResetLater$okhttp(r9, ErrorCode.PROTOCOL_ERROR);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L9:
        this.currentPushRequests.add(Integer.valueOf(r9));     // Catch: Throwable -> L13
        monitor-exit(this);
        TaskQueue r0 = this.pushQueue;
        final String r3 = this.connectionName + '[' + r9 + "] onRequest";
        final boolean r4 = true;
        r0.schedule(new Http2Connection$pushRequestLater$$inlined$execute$default$1(r3, r4, this, r9, r10), 0);
    }

    public final void pushHeadersLater$okhttp(final int r10, final List<Header> r11, final boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "requestHeaders");
        TaskQueue r0 = this.pushQueue;
        final String r3 = this.connectionName + '[' + r10 + "] onHeaders";
        final boolean r4 = true;
        r0.schedule(new Http2Connection$pushHeadersLater$$inlined$execute$default$1(r3, r4, this, r10, r11, r12), 0);
    }

    public final void pushDataLater$okhttp(final int r10, BufferedSource r11, final int r12, final boolean r13) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "source");
        final Buffer r6 = new Buffer();
        long r0 = r12;
        r11.require(r0);
        r11.read(r6, r0);
        TaskQueue r14 = this.pushQueue;
        final String r2 = this.connectionName + '[' + r10 + "] onData";
        final boolean r3 = true;
        r14.schedule(new Http2Connection$pushDataLater$$inlined$execute$default$1(r2, r3, this, r10, r6, r12, r13), 0);
    }

    public final void pushResetLater$okhttp(final int r9, final ErrorCode r10) {
        Intrinsics.checkNotNullParameter(r10, AccountConst.KEY_ERROR_CODE);
        TaskQueue r0 = this.pushQueue;
        final String r3 = this.connectionName + '[' + r9 + "] onReset";
        final boolean r4 = true;
        r0.schedule(new Http2Connection$pushResetLater$$inlined$execute$default$1(r3, r4, this, r9, r10), 0);
    }

    static {
        Companion = new Companion(null);
        Settings r0 = new Settings();
        r0.set(7, 65535);
        r0.set(5, 16384);
        DEFAULT_SETTINGS = r0;
    }

    public final void close$okhttp(ErrorCode r4, ErrorCode r5, IOException r6) {
        Intrinsics.checkNotNullParameter(r4, "connectionCode");
        Intrinsics.checkNotNullParameter(r5, "streamCode");
        if (Util.assertionsEnabled == true) goto L5;
    L44:
        shutdown(r4);     // Catch: IOException -> L36
    L10:
        monitor-enter(this);
        int r0 = 0;
        if ((!getStreams$okhttp().isEmpty()) == false) goto L18;
        Object[] r7 = getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L33
        if (r7 == null) goto L17;
        getStreams$okhttp().clear();     // Catch: Throwable -> L33
    L19:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(this);
        Http2Stream[] r8 = (Http2Stream[]) r7;
        if (r8 == null) goto L40;
        int r2 = r8.length;
    L25:
        if (r0 >= r2) goto L40;
        r8[r0].close(r5, r6);     // Catch: IOException -> L37
    L28:
        r0 = r0 + 1;
    L40:
        getWriter().close();     // Catch: IOException -> L38
    L42:
        getSocket$okhttp().close();     // Catch: IOException -> L39
    L31:
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L33
    L18:
        r7 = null;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L44;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
