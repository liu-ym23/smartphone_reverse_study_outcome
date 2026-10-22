package okhttp3;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.wifi.WifiAuthorizeUtils;
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
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0019\u0010 \u001a\u00020\u001f2\n\u0010!\u001a\u00060\u001aR\u00020\u001bH\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0000¢\u0006\u0002\b$J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b%J\u0016\u0010&\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0002J)\u0010)\u001a\u00020\u001f\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,2\u0006\u0010!\u001a\u0002H*H\u0002¢\u0006\u0002\u0010-J\u0015\u0010)\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0000¢\u0006\u0002\b.J\u0019\u0010)\u001a\u00020\u001f2\n\u0010!\u001a\u00060\u001aR\u00020\u001bH\u0000¢\u0006\u0002\b.J\b\u0010/\u001a\u000200H\u0002J\f\u00101\u001a\b\u0012\u0004\u0012\u00020302J\u0006\u00104\u001a\u00020\u0010J\f\u00105\u001a\b\u0012\u0004\u0012\u00020302J\u0006\u00106\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lokhttp3/Dispatcher;", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Ljava/util/concurrent/ExecutorService;)V", "()V", "()Ljava/util/concurrent/ExecutorService;", "executorServiceOrNull", "<set-?>", "Ljava/lang/Runnable;", "idleCallback", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "maxRequests", "", "getMaxRequests", "()I", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "runningAsyncCalls", "runningSyncCalls", "cancelAll", "", "enqueue", NotificationCompat.CATEGORY_CALL, "enqueue$okhttp", "executed", "executed$okhttp", "-deprecated_executorService", "findExistingCallWithHost", WifiAuthorizeUtils.AUTO_LOGIN_HOST, "", "finished", ExifInterface.GPS_DIRECTION_TRUE, "calls", "Ljava/util/Deque;", "(Ljava/util/Deque;Ljava/lang/Object;)V", "finished$okhttp", "promoteAndExecute", "", "queuedCalls", "", "Lokhttp3/Call;", "queuedCallsCount", "runningCalls", "runningCallsCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
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

    public final synchronized int getMaxRequests() {
        monitor-enter(this);
        int r0 = this.maxRequests;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
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
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        promoteAndExecute();
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException(Intrinsics.stringPlus("max < 1: ", Integer.valueOf(r2)).toString());
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

    public final void setMaxRequestsPerHost(int r2) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L16;
        monitor-enter(this);
        this.maxRequestsPerHost = r2;     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        promoteAndExecute();
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException(Intrinsics.stringPlus("max < 1: ", Integer.valueOf(r2)).toString());
    }

    public final synchronized Runnable getIdleCallback() {
        monitor-enter(this);
        Runnable r0 = this.idleCallback;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void setIdleCallback(Runnable r1) {
        monitor-enter(this);
        this.idleCallback = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized ExecutorService executorService() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.executorServiceOrNull != null) goto L6;
        this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory(Intrinsics.stringPlus(Util.okHttpName, " Dispatcher"), false));     // Catch: Throwable -> L9
    L6:
        ExecutorService r0 = this.executorServiceOrNull;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public Dispatcher(ExecutorService r2) {
        Intrinsics.checkNotNullParameter(r2, "executorService");
        this();
        this.executorServiceOrNull = r2;
    }

    public final void enqueue$okhttp(RealCall.AsyncCall r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_CALL);
        monitor-enter(this);
        this.readyAsyncCalls.add(r2);     // Catch: Throwable -> L13
        if (r2.getCall().getForWebSocket() == true) goto L9;
        RealCall.AsyncCall r0 = findExistingCallWithHost(r2.getHost());     // Catch: Throwable -> L13
        if (r0 == null) goto L9;
        r2.reuseCallsPerHostFrom(r0);     // Catch: Throwable -> L13
    L9:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        promoteAndExecute();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String r4) {
        Iterator<RealCall.AsyncCall> r0 = this.runningAsyncCalls.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        RealCall.AsyncCall r1 = r0.next();
        if (Intrinsics.areEqual(r1.getHost(), r4) == false) goto L4;
        return r1;
    L8:
        Iterator<RealCall.AsyncCall> r3 = this.readyAsyncCalls.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        RealCall.AsyncCall r2 = r3.next();
        if (Intrinsics.areEqual(r2.getHost(), r4) == false) goto L10;
        return r2;
    L14:
        return null;
    }

    public final synchronized void cancelAll() {
        monitor-enter(this);
        Iterator<RealCall.AsyncCall> r0 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L18
    L5:
        if (r0.hasNext() == false) goto L7;
        r0.next().getCall().cancel();     // Catch: Throwable -> L18
        goto L5
    L7:
        Iterator<RealCall.AsyncCall> r1 = this.runningAsyncCalls.iterator();     // Catch: Throwable -> L18
    L9:
        if (r1.hasNext() == false) goto L11;
        r1.next().getCall().cancel();     // Catch: Throwable -> L18
        goto L9
    L11:
        Iterator<RealCall> r2 = this.runningSyncCalls.iterator();     // Catch: Throwable -> L18
    L12:
        if (r2.hasNext() == false) goto L16;
        r2.next().cancel();     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized void executed$okhttp(RealCall r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L6
        this.runningSyncCalls.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void finished$okhttp(RealCall.AsyncCall r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_CALL);
        r2.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, r2);
    }

    public final void finished$okhttp(RealCall r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_CALL);
        finished(this.runningSyncCalls, r2);
    }

    private final <T> void finished(Deque<T> r1, T r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r1.remove(r2) == false) goto L13;
        Runnable r3 = getIdleCallback();     // Catch: Throwable -> L14
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (promoteAndExecute() == true) goto L18;
        if (r3 == null) goto L19;
        r3.run();
        return;
    L19:
        return;
    L18:
        return;
    L13:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L14
    }

    public final synchronized List<Call> queuedCalls() {
        monitor-enter(this);
        ArrayDeque<RealCall.AsyncCall> r0 = this.readyAsyncCalls;     // Catch: Throwable -> L10
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Throwable -> L10
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L10
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.add(((RealCall.AsyncCall) r2.next()).getCall());     // Catch: Throwable -> L10
        goto L5
    L7:
        List<Call> r3 = Collections.unmodifiableList(r1);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r3, "unmodifiableList(readyAsyncCalls.map { it.call })");     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Call> runningCalls() {
        monitor-enter(this);
        ArrayDeque<RealCall> r0 = this.runningSyncCalls;     // Catch: Throwable -> L10
        ArrayDeque<RealCall.AsyncCall> r1 = this.runningAsyncCalls;     // Catch: Throwable -> L10
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));     // Catch: Throwable -> L10
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L10
    L5:
        if (r3.hasNext() == false) goto L7;
        r2.add(((RealCall.AsyncCall) r3.next()).getCall());     // Catch: Throwable -> L10
        goto L5
    L7:
        List<Call> r4 = Collections.unmodifiableList(CollectionsKt.plus(r0, r2));     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r4, "unmodifiableList(running…yncCalls.map { it.call })");     // Catch: Throwable -> L10
        monitor-exit(this);
        return r4;
    L10:
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

    public final synchronized int runningCallsCount() {
        monitor-enter(this);
        int r0 = this.runningAsyncCalls.size() + this.runningSyncCalls.size();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "executorService", imports = {}))
    /* JADX INFO: renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m3126deprecated_executorService() {
        return executorService();
    }

    private final boolean promoteAndExecute() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        Iterator<RealCall.AsyncCall> r1 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L31
        Intrinsics.checkNotNullExpressionValue(r1, "readyAsyncCalls.iterator()");     // Catch: Throwable -> L31
    L13:
        if (r1.hasNext() == false) goto L21;
        RealCall.AsyncCall r2 = r1.next();     // Catch: Throwable -> L31
        if (this.runningAsyncCalls.size() >= getMaxRequests()) goto L21;
        if (r2.getCallsPerHost().get() >= getMaxRequestsPerHost()) goto L13;
        r1.remove();     // Catch: Throwable -> L31
        r2.getCallsPerHost().incrementAndGet();     // Catch: Throwable -> L31
        Intrinsics.checkNotNullExpressionValue(r2, "asyncCall");     // Catch: Throwable -> L31
        r0.add(r2);     // Catch: Throwable -> L31
        this.runningAsyncCalls.add(r2);     // Catch: Throwable -> L31
    L21:
        int r3 = 0;
        if (runningCallsCount() <= 0) goto L24;
        boolean r4 = true;
    L25:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(this);
        int r6 = r0.size();
    L28:
        if (r3 >= r6) goto L30;
        ((RealCall.AsyncCall) r0.get(r3)).executeOn(executorService());
        r3 = r3 + 1;
        goto L28
    L30:
        return r4;
    L24:
        r4 = false;
    L31:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
