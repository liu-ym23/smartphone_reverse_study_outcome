package androidx.room;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class RoomTrackingLiveData<T> extends LiveData<T> {
    final Callable<T> mComputeFunction;
    final AtomicBoolean mComputing;
    private final InvalidationLiveDataContainer mContainer;
    final RoomDatabase mDatabase;
    final boolean mInTransaction;
    final AtomicBoolean mInvalid;
    final Runnable mInvalidationRunnable;
    final InvalidationTracker.Observer mObserver;
    final Runnable mRefreshRunnable;
    final AtomicBoolean mRegisteredObserver;

    @SuppressLint({"RestrictedApi"})
    RoomTrackingLiveData(RoomDatabase r3, InvalidationLiveDataContainer r4, boolean r5, Callable<T> r6, final String[] r7) {
        this.mInvalid = new AtomicBoolean(true);
        this.mComputing = new AtomicBoolean(false);
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mRefreshRunnable = new AnonymousClass1(this);
        this.mInvalidationRunnable = new AnonymousClass2(this);
        this.mDatabase = r3;
        this.mInTransaction = r5;
        this.mComputeFunction = r6;
        this.mContainer = r4;
        this.mObserver = new AnonymousClass3(this, r7);
    }

    static /* synthetic */ void access$000(RoomTrackingLiveData r0, Object r1) {
        r0.postValue(r1);
    }

    Executor getQueryExecutor() {
        boolean r0 = this.mInTransaction;
        RoomDatabase r1 = this.mDatabase;
        if (r0 == false) goto L7;
        return r1.getTransactionExecutor();
    L7:
        return r1.getQueryExecutor();
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }
}
