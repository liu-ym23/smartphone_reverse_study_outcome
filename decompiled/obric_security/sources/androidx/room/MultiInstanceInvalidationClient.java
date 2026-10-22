package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiInstanceInvalidationClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u00109\u001a\u00020:R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Landroidx/room/MultiInstanceInvalidationClient;", "", "context", "Landroid/content/Context;", "name", "", "serviceIntent", "Landroid/content/Intent;", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "executor", "Ljava/util/concurrent/Executor;", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroidx/room/InvalidationTracker;Ljava/util/concurrent/Executor;)V", "appContext", "kotlin.jvm.PlatformType", "callback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "getCallback", "()Landroidx/room/IMultiInstanceInvalidationCallback;", "clientId", "", "getClientId", "()I", "setClientId", "(I)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "getName", "()Ljava/lang/String;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "setObserver", "(Landroidx/room/InvalidationTracker$Observer;)V", "removeObserverRunnable", "Ljava/lang/Runnable;", "getRemoveObserverRunnable", "()Ljava/lang/Runnable;", "service", "Landroidx/room/IMultiInstanceInvalidationService;", "getService", "()Landroidx/room/IMultiInstanceInvalidationService;", "setService", "(Landroidx/room/IMultiInstanceInvalidationService;)V", "serviceConnection", "Landroid/content/ServiceConnection;", "getServiceConnection", "()Landroid/content/ServiceConnection;", "setUpRunnable", "getSetUpRunnable", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getStopped", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "stop", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private final IMultiInstanceInvalidationCallback callback;
    private int clientId;
    private final Executor executor;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    public InvalidationTracker.Observer observer;
    private final Runnable removeObserverRunnable;
    private IMultiInstanceInvalidationService service;
    private final ServiceConnection serviceConnection;
    private final Runnable setUpRunnable;
    private final AtomicBoolean stopped;

    public static /* synthetic */ void $r8$lambda$OUFtvTStWETjeJxrBwS2HtXq3VE(MultiInstanceInvalidationClient r0) {
        setUpRunnable$lambda$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$at7cvPuqmY8Y6FAv2N0cZPhRid0(MultiInstanceInvalidationClient r0) {
        removeObserverRunnable$lambda$2(r0);
    }

    public MultiInstanceInvalidationClient(Context r2, String r3, Intent r4, InvalidationTracker r5, Executor r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "serviceIntent");
        Intrinsics.checkNotNullParameter(r5, "invalidationTracker");
        Intrinsics.checkNotNullParameter(r6, "executor");
        this.name = r3;
        this.invalidationTracker = r5;
        this.executor = r6;
        Context r7 = r2.getApplicationContext();
        this.appContext = r7;
        this.callback = new MultiInstanceInvalidationClient$callback$1(this);
        this.stopped = new AtomicBoolean(false);
        ServiceConnection r8 = new MultiInstanceInvalidationClient$serviceConnection$1(this);
        this.serviceConnection = r8;
        this.setUpRunnable = new MultiInstanceInvalidationClient$$ExternalSyntheticLambda0(this);
        this.removeObserverRunnable = new MultiInstanceInvalidationClient$$ExternalSyntheticLambda1(this);
        Object[] r9 = r5.getTableIdLookup$room_runtime_release().keySet().toArray(new String[0]);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        final String[] r10 = (String[]) r9;
        setObserver(new AnonymousClass1(this, r10));
        r7.bindService(r4, r8, 1);
    }

    public final String getName() {
        return this.name;
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final int getClientId() {
        return this.clientId;
    }

    public final void setClientId(int r1) {
        this.clientId = r1;
    }

    public final InvalidationTracker.Observer getObserver() {
        InvalidationTracker.Observer r0 = this.observer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        return null;
    }

    public final void setObserver(InvalidationTracker.Observer r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.observer = r2;
    }

    public final IMultiInstanceInvalidationService getService() {
        return this.service;
    }

    public final void setService(IMultiInstanceInvalidationService r1) {
        this.service = r1;
    }

    public final IMultiInstanceInvalidationCallback getCallback() {
        return this.callback;
    }

    public final AtomicBoolean getStopped() {
        return this.stopped;
    }

    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final Runnable getSetUpRunnable() {
        return this.setUpRunnable;
    }

    private static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        IMultiInstanceInvalidationService r0 = r3.service;     // Catch: RemoteException -> L7
        if (r0 == null) goto L12;
        r3.clientId = r0.registerCallback(r3.callback, r3.name);     // Catch: RemoteException -> L7
        r3.invalidationTracker.addObserver(r3.getObserver());     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
    }

    private static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.invalidationTracker.removeObserver(r1.getObserver());
    }

    public final Runnable getRemoveObserverRunnable() {
        return this.removeObserverRunnable;
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true) == false) goto L15;
        this.invalidationTracker.removeObserver(getObserver());
        IMultiInstanceInvalidationService r0 = this.service;     // Catch: RemoteException -> L9
        if (r0 == null) goto L11;
        r0.unregisterCallback(this.callback, this.clientId);     // Catch: RemoteException -> L9
    L11:
        this.appContext.unbindService(this.serviceConnection);
        return;
    L9:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
        goto L11
    }
}
