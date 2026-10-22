package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0014\u0010\u001c\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\b\u0010\u001d\u001a\u00020\u001aH&J\b\u0010\u001e\u001a\u00020\u001aH&R\u0014\u0010\b\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/work/impl/constraints/trackers/ConstraintTracker;", ExifInterface.GPS_DIRECTION_TRUE, "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "appContext", "getAppContext", "()Landroid/content/Context;", "currentState", "Ljava/lang/Object;", "initialState", "getInitialState", "()Ljava/lang/Object;", "listeners", "Ljava/util/LinkedHashSet;", "Landroidx/work/impl/constraints/ConstraintListener;", "lock", "newState", "state", "getState", "setState", "(Ljava/lang/Object;)V", "addListener", "", "listener", "removeListener", "startTracking", "stopTracking", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ConstraintTracker<T> {
    private final Context appContext;
    private T currentState;
    private final LinkedHashSet<ConstraintListener<T>> listeners;
    private final Object lock;
    private final TaskExecutor taskExecutor;

    public static /* synthetic */ void $r8$lambda$RK0TULesrSgb2ZBnJ6LX6irCfZ4(List r0, ConstraintTracker r1) {
        _set_state_$lambda$4$lambda$3(r0, r1);
    }

    public abstract T getInitialState();

    public abstract void startTracking();

    public abstract void stopTracking();

    protected ConstraintTracker(Context r2, TaskExecutor r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskExecutor");
        this.taskExecutor = r3;
        Context r4 = r2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context.applicationContext");
        this.appContext = r4;
        this.lock = new Object();
        this.listeners = new LinkedHashSet();
    }

    protected final Context getAppContext() {
        return this.appContext;
    }

    public final void addListener(ConstraintListener<T> r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        Object r0 = this.lock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.listeners.add(r6) == true) goto L7;
    L10:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L7:
        if (this.listeners.size() != 1) goto L9;
        this.currentState = getInitialState();     // Catch: Throwable -> L13
        Logger.get().debug(ConstraintTrackerKt.access$getTAG$p(), getClass().getSimpleName() + ": initial state = " + this.currentState);     // Catch: Throwable -> L13
        startTracking();     // Catch: Throwable -> L13
    L9:
        r6.onConstraintChanged(this.currentState);     // Catch: Throwable -> L13
        goto L10
    }

    public final void removeListener(ConstraintListener<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.lock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.listeners.remove(r3) == true) goto L7;
    L9:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L7:
        if (this.listeners.isEmpty() == false) goto L9;
        stopTracking();     // Catch: Throwable -> L12
        goto L9
    }

    public final T getState() {
        T r0 = this.currentState;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getInitialState();
    }

    public final void setState(T r4) {
        Object r0 = this.lock;
        monitor-enter(r0);
        T r1 = this.currentState;     // Catch: Throwable -> L13
        if (r1 != null) goto L7;
    L10:
        this.currentState = r4;     // Catch: Throwable -> L13
        final List r5 = CollectionsKt.toList(this.listeners);     // Catch: Throwable -> L13
        this.taskExecutor.getMainThreadExecutor().execute(new ConstraintTracker$$ExternalSyntheticLambda0(r5, this));     // Catch: Throwable -> L13
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L7:
        if (Intrinsics.areEqual(r1, r4) == false) goto L10;
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private static final void _set_state_$lambda$4$lambda$3(List r2, ConstraintTracker r3) {
        Intrinsics.checkNotNullParameter(r2, "$listenersList");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((ConstraintListener) r4.next()).onConstraintChanged(r3.currentState);
        goto L4
    }
}
