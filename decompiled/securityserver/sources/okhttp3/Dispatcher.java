package okhttp3;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.NotificationCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;

    @Nullable
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String r4) {
        Iterator<RealCall.AsyncCall> r0 = this.runningAsyncCalls.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        RealCall.AsyncCall r1 = r0.next();
        if (Intrinsics.a(r1.getHost(), r4) == false) goto L4;
        return r1;
    L8:
        Iterator<RealCall.AsyncCall> r3 = this.readyAsyncCalls.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        RealCall.AsyncCall r2 = r3.next();
        if (Intrinsics.a(r2.getHost(), r4) == false) goto L10;
        return r2;
    L14:
        return null;
    }

    private final <T> void finished(Deque<T> r1, T r2) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r1.remove(r2) == false) goto L15;
        Runnable r3 = this.idleCallback;     // Catch: Throwable -> L12
        monitor-exit(this);
        if (promoteAndExecute() == true) goto L19;
        if (r3 == null) goto L20;
        r3.run();
        return;
    L20:
        return;
    L19:
        return;
    L15:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L12
    }

    private final boolean promoteAndExecute() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        Iterator<RealCall.AsyncCall> r1 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L21
        Intrinsics.e(r1, "readyAsyncCalls.iterator()");     // Catch: Throwable -> L21
    L13:
        if (r1.hasNext() == false) goto L23;
        RealCall.AsyncCall r2 = r1.next();     // Catch: Throwable -> L21
        if (this.runningAsyncCalls.size() >= this.maxRequests) goto L23;
        if (r2.getCallsPerHost().get() >= this.maxRequestsPerHost) goto L13;
        r1.remove();     // Catch: Throwable -> L21
        r2.getCallsPerHost().incrementAndGet();     // Catch: Throwable -> L21
        r0.add(r2);     // Catch: Throwable -> L21
        this.runningAsyncCalls.add(r2);     // Catch: Throwable -> L21
    L23:
        int r3 = 0;
        if (runningCallsCount() <= 0) goto L27;
        boolean r4 = true;
    L28:
        monitor-exit(this);
        int r5 = r0.size();
    L30:
        if (r3 >= r5) goto L32;
        ((RealCall.AsyncCall) r0.get(r3)).executeOn(executorService());
        r3 = r3 + 1;
        goto L30
    L32:
        return r4;
    L27:
        r4 = false;
    L21:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        StringBuilder r6 = new StringBuilder("Thread ");
        Thread r7 = Thread.currentThread();
        Intrinsics.e(r7, "Thread.currentThread()");
        r6.append(r7.getName());
        r6.append(" MUST NOT hold lock on ");
        r6.append(this);
        throw new AssertionError(r6.toString());
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m84deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        monitor-enter(this);
        Iterator<RealCall.AsyncCall> r0 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L7
    L5:
        if (r0.hasNext() == false) goto L9;
        r0.next().getCall().cancel();     // Catch: Throwable -> L7
        goto L5
    L9:
        Iterator<RealCall.AsyncCall> r1 = this.runningAsyncCalls.iterator();     // Catch: Throwable -> L7
    L11:
        if (r1.hasNext() == false) goto L13;
        r1.next().getCall().cancel();     // Catch: Throwable -> L7
        goto L11
    L13:
        Iterator<RealCall> r2 = this.runningSyncCalls.iterator();     // Catch: Throwable -> L7
    L14:
        if (r2.hasNext() == false) goto L18;
        r2.next().cancel();     // Catch: Throwable -> L7
        goto L14
    L18:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void enqueue$okhttp(@NotNull RealCall.AsyncCall r2) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_CALL);
        monitor-enter(this);
        this.readyAsyncCalls.add(r2);     // Catch: Throwable -> L10
        if (r2.getCall().getForWebSocket() == true) goto L12;
        RealCall.AsyncCall r0 = findExistingCallWithHost(r2.getHost());     // Catch: Throwable -> L10
        if (r0 == null) goto L12;
        r2.reuseCallsPerHostFrom(r0);     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        promoteAndExecute();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void executed$okhttp(@NotNull RealCall r2) {
        monitor-enter(this);
        Intrinsics.f(r2, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L6
        this.runningSyncCalls.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @JvmName
    @NotNull
    public final synchronized ExecutorService executorService() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.executorServiceOrNull != null) goto L8;
        this.executorServiceOrNull = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory(Util.okHttpName + " Dispatcher", false));     // Catch: Throwable -> L6
    L8:
        ExecutorService r0 = this.executorServiceOrNull;     // Catch: Throwable -> L6
        Intrinsics.c(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    }

    public final void finished$okhttp(@NotNull RealCall.AsyncCall r2) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_CALL);
        r2.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, r2);
    }

    @Nullable
    public final synchronized Runnable getIdleCallback() {
        monitor-enter(this);
        Runnable r0 = this.idleCallback;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int getMaxRequests() {
        monitor-enter(this);
        int r0 = this.maxRequests;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int getMaxRequestsPerHost() {
        monitor-enter(this);
        int r0 = this.maxRequestsPerHost;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @NotNull
    public final synchronized List<Call> queuedCalls() {
        monitor-enter(this);
        ArrayDeque<RealCall.AsyncCall> r0 = this.readyAsyncCalls;     // Catch: Throwable -> L7
        ArrayList r1 = new ArrayList(CollectionsKt.e(r0, 10));     // Catch: Throwable -> L7
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L7
    L5:
        if (r2.hasNext() == false) goto L9;
        r1.add(((RealCall.AsyncCall) r2.next()).getCall());     // Catch: Throwable -> L7
        goto L5
    L9:
        List<Call> r3 = Collections.unmodifiableList(r1);     // Catch: Throwable -> L7
        Intrinsics.e(r3, "Collections.unmodifiable…yncCalls.map { it.call })");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized int queuedCallsCount() {
        monitor-enter(this);
        int r0 = this.readyAsyncCalls.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @NotNull
    public final synchronized List<Call> runningCalls() {
        monitor-enter(this);
        ArrayDeque<RealCall> r0 = this.runningSyncCalls;     // Catch: Throwable -> L7
        ArrayDeque<RealCall.AsyncCall> r1 = this.runningAsyncCalls;     // Catch: Throwable -> L7
        ArrayList r2 = new ArrayList(CollectionsKt.e(r1, 10));     // Catch: Throwable -> L7
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L7
    L5:
        if (r3.hasNext() == false) goto L9;
        r2.add(((RealCall.AsyncCall) r3.next()).getCall());     // Catch: Throwable -> L7
        goto L5
    L9:
        List<Call> r4 = Collections.unmodifiableList(CollectionsKt.n(r0, r2));     // Catch: Throwable -> L7
        Intrinsics.e(r4, "Collections.unmodifiable…yncCalls.map { it.call })");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized int runningCallsCount() {
        monitor-enter(this);
        int r0 = this.runningAsyncCalls.size() + this.runningSyncCalls.size();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void setIdleCallback(@Nullable Runnable r1) {
        monitor-enter(this);
        this.idleCallback = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void setMaxRequests(int r2) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L16;
        monitor-enter(this);
        this.maxRequests = r2;     // Catch: Throwable -> L12
        monitor-exit(this);
        promoteAndExecute();
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException(a.e(r2, "max < 1: ").toString());
    }

    public final void setMaxRequestsPerHost(int r2) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L16;
        monitor-enter(this);
        this.maxRequestsPerHost = r2;     // Catch: Throwable -> L12
        monitor-exit(this);
        promoteAndExecute();
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException(a.e(r2, "max < 1: ").toString());
    }

    public final void finished$okhttp(@NotNull RealCall r2) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_CALL);
        finished(this.runningSyncCalls, r2);
    }

    public Dispatcher(@NotNull ExecutorService r2) {
        Intrinsics.f(r2, "executorService");
        this();
        this.executorServiceOrNull = r2;
    }
}
