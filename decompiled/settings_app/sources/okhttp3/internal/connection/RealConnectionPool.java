package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: RealConnectionPool.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0005J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u000e\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "connections", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lokhttp3/internal/connection/RealConnection;", "keepAliveDurationNs", "callAcquirePooledConnection", "", "address", "Lokhttp3/Address;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "routes", "", "Lokhttp3/Route;", "requireMultiplexed", "cleanup", "now", "connectionBecameIdle", WsConstants.KEY_CONNECTION, "connectionCount", "evictAll", "", "idleConnectionCount", "pruneAndGetAllocationCount", "put", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealConnectionPool {
    public static final Companion Companion = null;
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* JADX INFO: compiled from: RealConnectionPool.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "()V", "get", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final RealConnectionPool get(ConnectionPool r1) {
            Intrinsics.checkNotNullParameter(r1, "connectionPool");
            return r1.getDelegate$okhttp();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner r3, int r4, long r5, TimeUnit r7) {
        Intrinsics.checkNotNullParameter(r3, "taskRunner");
        Intrinsics.checkNotNullParameter(r7, "timeUnit");
        this.maxIdleConnections = r4;
        this.keepAliveDurationNs = r7.toNanos(r5);
        this.cleanupQueue = r3.newQueue();
        final String r6 = Intrinsics.stringPlus(Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new RealConnectionPool$cleanupTask$1(this, r6);
        this.connections = new ConcurrentLinkedQueue();
        if (r5 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(Intrinsics.stringPlus("keepAliveDuration <= 0: ", Long.valueOf(r5)).toString());
    L5:
        r2 = false;
        goto L6
    }

    public final int idleConnectionCount() {
        ConcurrentLinkedQueue<RealConnection> r3 = this.connections;
        int r1 = 0;
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L21;
        RealConnection r0 = (RealConnection) r4.next();
        Intrinsics.checkNotNullExpressionValue(r0, "it");
        monitor-enter(r0);
        boolean r2 = r0.getCalls().isEmpty();     // Catch: Throwable -> L18
        monitor-exit(r0);
        if (r2 == false) goto L9;
        r1 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L18:
        th = move-exception;
        throw th;
    L21:
        return r1;
    L5:
        if (r3.isEmpty() == false) goto L7;
        goto L7
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final boolean callAcquirePooledConnection(Address r3, RealCall r4, List<Route> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "address");
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_CALL);
        Iterator<RealConnection> r2 = this.connections.iterator();
    L4:
        if (r2.hasNext() == false) goto L23;
        RealConnection r0 = r2.next();
        Intrinsics.checkNotNullExpressionValue(r0, WsConstants.KEY_CONNECTION);
        monitor-enter(r0);
        if (r6 == false) goto L12;
    L20:
        th = move-exception;
        throw th;
    L9:
        if (r0.isMultiplexed$okhttp() == true) goto L12;
    L13:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
    L12:
        if (r0.isEligible$okhttp(r3, r5) == false) goto L13;
        r4.acquireConnectionNoEvents(r0);     // Catch: Throwable -> L20
        monitor-exit(r0);
        return true;
    L23:
        return false;
    }

    public final void evictAll() {
        Iterator<RealConnection> r0 = this.connections.iterator();
        Intrinsics.checkNotNullExpressionValue(r0, "connections.iterator()");
    L4:
        if (r0.hasNext() == false) goto L20;
        RealConnection r1 = r0.next();
        Intrinsics.checkNotNullExpressionValue(r1, WsConstants.KEY_CONNECTION);
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (r1.getCalls().isEmpty() == false) goto L11;
        r0.remove();     // Catch: Throwable -> L16
        r1.setNoNewExchanges(true);     // Catch: Throwable -> L16
        Socket r2 = r1.socket();     // Catch: Throwable -> L16
    L12:
        monitor-exit(r1);
        if (r2 == null) goto L4;
        Util.closeQuietly(r2);
        goto L4
    L11:
        r2 = null;
        goto L12
    L20:
        if (this.connections.isEmpty() == false) goto L30;
        this.cleanupQueue.cancelAll();
        return;
    }

    public final long cleanup(long r11) {
        Iterator<RealConnection> r0 = this.connections.iterator();
        int r1 = 0;
        long r4 = Long.MIN_VALUE;
        RealConnection r3 = null;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L19;
        RealConnection r6 = r0.next();
        Intrinsics.checkNotNullExpressionValue(r6, WsConstants.KEY_CONNECTION);
        monitor-enter(r6);
        if (pruneAndGetAllocationCount(r6, r11) <= 0) goto L10;
        Integer.valueOf(r2);     // Catch: Throwable -> L16
        r2 = r2 + 1;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r6);
        goto L4
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L16
        long r7 = r11 - r6.getIdleAtNs$okhttp();     // Catch: Throwable -> L16
        if (r7 <= r4) goto L13;
        r3 = r6;
        r4 = r7;
    L13:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        long r9 = this.keepAliveDurationNs;
        if (r4 < r9) goto L22;
    L31:
        Intrinsics.checkNotNull(r3);
        monitor-enter(r3);
    L49:
        th = move-exception;
        throw th;
    L35:
        if ((!r3.getCalls().isEmpty()) == false) goto L40;
        monitor-exit(r3);
        return 0;
    L40:
        if ((r3.getIdleAtNs$okhttp() + r4) == r11) goto L43;
        monitor-exit(r3);
        return 0;
    L43:
        r3.setNoNewExchanges(true);     // Catch: Throwable -> L49
        this.connections.remove(r3);     // Catch: Throwable -> L49
        monitor-exit(r3);
        Util.closeQuietly(r3.socket());
        if (this.connections.isEmpty() == false) goto L48;
        this.cleanupQueue.cancelAll();
    L48:
        return 0;
    L22:
        if (r1 > this.maxIdleConnections) goto L31;
        if (r1 > 0) goto L26;
        if (r2 <= 0) goto L29;
        return r9;
    L29:
        return -1;
    L26:
        return r9 - r4;
    }

    public final void put(RealConnection r8) {
        Intrinsics.checkNotNullParameter(r8, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        this.connections.add(r8);
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        return;
    L5:
        if (Thread.holdsLock(r8) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r8);
    }

    public final boolean connectionBecameIdle(RealConnection r8) {
        Intrinsics.checkNotNullParameter(r8, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(r8) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r8);
    L10:
        if (r8.getNoNewExchanges() == false) goto L12;
    L15:
        r8.setNoNewExchanges(true);
        this.connections.remove(r8);
        if (this.connections.isEmpty() == false) goto L19;
        this.cleanupQueue.cancelAll();
    L19:
        return true;
    L12:
        if (this.maxIdleConnections == 0) goto L15;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        return false;
    }

    private final int pruneAndGetAllocationCount(RealConnection r7, long r8) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        List<Reference<RealCall>> r0 = r7.getCalls();
        int r2 = 0;
    L11:
        if (r2 >= r0.size()) goto L20;
        Reference<RealCall> r3 = r0.get(r2);
        if (r3.get() != null) goto L14;
        Platform.Companion.get().logCloseableLeak("A connection to " + r7.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) r3).getCallStackTrace());
        r0.remove(r2);
        r7.setNoNewExchanges(true);
        if (r0.isEmpty() == false) goto L11;
        r7.setIdleAtNs$okhttp(r8 - this.keepAliveDurationNs);
        return 0;
    L14:
        r2 = r2 + 1;
        goto L11
    L20:
        return r0.size();
    L5:
        if (Thread.holdsLock(r7) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r7);
    }
}
