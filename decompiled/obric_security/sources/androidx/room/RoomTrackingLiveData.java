package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoomTrackingLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020,H\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010)\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014¨\u0006."}, d2 = {"Landroidx/room/RoomTrackingLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "database", "Landroidx/room/RoomDatabase;", "container", "Landroidx/room/InvalidationLiveDataContainer;", "inTransaction", "", "computeFunction", "Ljava/util/concurrent/Callable;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;ZLjava/util/concurrent/Callable;[Ljava/lang/String;)V", "getComputeFunction", "()Ljava/util/concurrent/Callable;", "computing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getComputing", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getDatabase", "()Landroidx/room/RoomDatabase;", "getInTransaction", "()Z", "invalid", "getInvalid", "invalidationRunnable", "Ljava/lang/Runnable;", "getInvalidationRunnable", "()Ljava/lang/Runnable;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "queryExecutor", "Ljava/util/concurrent/Executor;", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "refreshRunnable", "getRefreshRunnable", "registeredObserver", "getRegisteredObserver", "onActive", "", "onInactive", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoomTrackingLiveData<T> extends LiveData<T> {
    private final Callable<T> computeFunction;
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final Runnable invalidationRunnable;
    private final InvalidationTracker.Observer observer;
    private final Runnable refreshRunnable;
    private final AtomicBoolean registeredObserver;

    public static /* synthetic */ void $r8$lambda$PhMGW5zFk4QWazERd2lfEeLZqW0(RoomTrackingLiveData r0) {
        refreshRunnable$lambda$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$lxd4mQgIWH-4QOUl4ygLPSFohKk, reason: not valid java name */
    public static /* synthetic */ void m57$r8$lambda$lxd4mQgIWH4QOUl4ygLPSFohKk(RoomTrackingLiveData r0) {
        invalidationRunnable$lambda$1(r0);
    }

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    public RoomTrackingLiveData(RoomDatabase r2, InvalidationLiveDataContainer r3, boolean r4, Callable<T> r5, final String[] r6) {
        Intrinsics.checkNotNullParameter(r2, "database");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r5, "computeFunction");
        Intrinsics.checkNotNullParameter(r6, "tableNames");
        this.database = r2;
        this.container = r3;
        this.inTransaction = r4;
        this.computeFunction = r5;
        this.observer = new RoomTrackingLiveData$observer$1(r6, this);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.refreshRunnable = new RoomTrackingLiveData$$ExternalSyntheticLambda0(this);
        this.invalidationRunnable = new RoomTrackingLiveData$$ExternalSyntheticLambda1(this);
    }

    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    private static final void refreshRunnable$lambda$0(RoomTrackingLiveData r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (r5.registeredObserver.compareAndSet(false, true) == false) goto L6;
        r5.database.getInvalidationTracker().addWeakObserver(r5.observer);
    L6:
        if (r5.computing.compareAndSet(false, true) == false) goto L21;
        T r0 = null;
        boolean r3 = false;
    L28:
    L18:
        th = move-exception;
        r5.computing.set(false);
        throw th;
    L9:
        if (r5.invalid.compareAndSet(true, false) == false) goto L15;
        r0 = r5.computeFunction.call();     // Catch: Exception -> L12 Throwable -> L18
        r3 = true;
        goto L28
    L12:
        e = move-exception;
        throw new RuntimeException("Exception while computing database live data.", e);     // Catch: Throwable -> L18
    L15:
        if (r3 == false) goto L17;
        r5.postValue(r0);     // Catch: Throwable -> L18
    L17:
        r5.computing.set(false);
    L22:
        if (r3 == false) goto L25;
        if (r5.invalid.get() == true) goto L6;
        return;
    L25:
        return;
    L21:
        r3 = false;
        goto L22
    }

    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    private static final void invalidationRunnable$lambda$1(RoomTrackingLiveData r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        boolean r0 = r4.hasActiveObservers();
        if (r4.invalid.compareAndSet(false, true) == false) goto L7;
        if (r0 == false) goto L8;
        r4.getQueryExecutor().execute(r4.refreshRunnable);
        return;
    L8:
        return;
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        InvalidationLiveDataContainer r0 = this.container;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        r0.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer r0 = this.container;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        r0.onInactive(this);
    }

    public final Executor getQueryExecutor() {
        if (this.inTransaction == false) goto L6;
        return this.database.getTransactionExecutor();
    L6:
        return this.database.getQueryExecutor();
    }
}
