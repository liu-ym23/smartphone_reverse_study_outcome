package okhttp3.internal.connection;

import a.a;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealConnectionPool {
    public static final Companion Companion = null;
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final RealConnectionPool get(@NotNull ConnectionPool r1) {
            Intrinsics.f(r1, "connectionPool");
            return r1.getDelegate$okhttp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(@NotNull TaskRunner r3, int r4, long r5, @NotNull TimeUnit r7) {
        Intrinsics.f(r3, "taskRunner");
        Intrinsics.f(r7, "timeUnit");
        this.maxIdleConnections = r4;
        this.keepAliveDurationNs = r7.toNanos(r5);
        this.cleanupQueue = r3.newQueue();
        final String r6 = a.o(new StringBuilder(), Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new RealConnectionPool$cleanupTask$1(this, r6);
        this.connections = new ConcurrentLinkedQueue();
        if (r5 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(a.h("keepAliveDuration <= 0: ", r5).toString());
    L5:
        r2 = false;
        goto L6
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
        StringBuilder r9 = new StringBuilder("Thread ");
        Thread r10 = Thread.currentThread();
        Intrinsics.e(r10, "Thread.currentThread()");
        r9.append(r10.getName());
        r9.append(" MUST hold lock on ");
        r9.append(r7);
        throw new AssertionError(r9.toString());
    }

    public final boolean callAcquirePooledConnection(@NotNull Address r3, @NotNull RealCall r4, @Nullable List<Route> r5, boolean r6) {
        Intrinsics.f(r3, "address");
        Intrinsics.f(r4, NotificationCompat.CATEGORY_CALL);
        Iterator<RealConnection> r2 = this.connections.iterator();
    L4:
        if (r2.hasNext() == false) goto L23;
        RealConnection r0 = r2.next();
        Intrinsics.e(r0, WsConstants.KEY_CONNECTION);
        monitor-enter(r0);
        if (r6 == false) goto L14;
    L11:
        th = move-exception;
        throw th;
    L9:
        if (r0.isMultiplexed$okhttp() == true) goto L14;
    L15:
        monitor-exit(r0);
    L14:
        if (r0.isEligible$okhttp(r3, r5) == false) goto L15;
        r4.acquireConnectionNoEvents(r0);     // Catch: Throwable -> L11
        monitor-exit(r0);
        return true;
    L23:
        return false;
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
        Intrinsics.e(r6, WsConstants.KEY_CONNECTION);
        monitor-enter(r6);
        if (pruneAndGetAllocationCount(r6, r11) <= 0) goto L10;
        r2 = r2 + 1;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r6);
        goto L4
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L16
        long r7 = r11 - r6.getIdleAtNs$okhttp();
        if (r7 <= r4) goto L14;
        r3 = r6;
        r4 = r7;
    L16:
        th = move-exception;
        throw th;
    L19:
        long r8 = this.keepAliveDurationNs;
        if (r4 < r8) goto L22;
    L31:
        Intrinsics.c(r3);
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
        return r8;
    L29:
        return -1;
    L26:
        return r8 - r4;
    }

    public final boolean connectionBecameIdle(@NotNull RealConnection r8) {
        Intrinsics.f(r8, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(r8) == true) goto L10;
        StringBuilder r0 = new StringBuilder("Thread ");
        Thread r1 = Thread.currentThread();
        Intrinsics.e(r1, "Thread.currentThread()");
        r0.append(r1.getName());
        r0.append(" MUST hold lock on ");
        r0.append(r8);
        throw new AssertionError(r0.toString());
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

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Iterator<RealConnection> r0 = this.connections.iterator();
        Intrinsics.e(r0, "connections.iterator()");
    L4:
        if (r0.hasNext() == false) goto L20;
        RealConnection r1 = r0.next();
        Intrinsics.e(r1, WsConstants.KEY_CONNECTION);
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (r1.getCalls().isEmpty() == false) goto L13;
        r0.remove();     // Catch: Throwable -> L11
        r1.setNoNewExchanges(true);     // Catch: Throwable -> L11
        Socket r2 = r1.socket();     // Catch: Throwable -> L11
    L14:
        monitor-exit(r1);
        if (r2 == null) goto L4;
        Util.closeQuietly(r2);
        goto L4
    L13:
        r2 = null;
        goto L14
    L20:
        if (this.connections.isEmpty() == false) goto L30;
        this.cleanupQueue.cancelAll();
        return;
    }

    public final int idleConnectionCount() {
        ConcurrentLinkedQueue<RealConnection> r3 = this.connections;
        int r1 = 0;
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L23;
        RealConnection r0 = (RealConnection) r4.next();
        Intrinsics.e(r0, "it");
        monitor-enter(r0);
        boolean r2 = r0.getCalls().isEmpty();     // Catch: Throwable -> L20
        monitor-exit(r0);
        if (r2 == false) goto L9;
        r1 = r1 + 1;
        if (r1 >= 0) goto L9;
        throw new ArithmeticException("Count overflow has happened.");
    L20:
        th = move-exception;
        throw th;
    L23:
        return r1;
    L5:
        if (r3.isEmpty() == false) goto L7;
        goto L7
    }

    public final void put(@NotNull RealConnection r8) {
        Intrinsics.f(r8, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        this.connections.add(r8);
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        return;
    L5:
        if (Thread.holdsLock(r8) == true) goto L9;
        StringBuilder r0 = new StringBuilder("Thread ");
        Thread r1 = Thread.currentThread();
        Intrinsics.e(r1, "Thread.currentThread()");
        r0.append(r1.getName());
        r0.append(" MUST hold lock on ");
        r0.append(r8);
        throw new AssertionError(r0.toString());
    }
}
