package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class MultiInstanceInvalidationClient {
    final Context mAppContext;
    final IMultiInstanceInvalidationCallback mCallback;
    int mClientId;
    final Executor mExecutor;
    final InvalidationTracker mInvalidationTracker;
    final String mName;
    final InvalidationTracker.Observer mObserver;
    final Runnable mRemoveObserverRunnable;

    @Nullable
    IMultiInstanceInvalidationService mService;
    final ServiceConnection mServiceConnection;
    final Runnable mSetUpRunnable;
    final AtomicBoolean mStopped;
    private final Runnable mTearDownRunnable;

    MultiInstanceInvalidationClient(Context r4, String r5, InvalidationTracker r6, Executor r7) {
        this.mCallback = new AnonymousClass1(this);
        this.mStopped = new AtomicBoolean(false);
        ServiceConnection r0 = new AnonymousClass2(this);
        this.mServiceConnection = r0;
        this.mSetUpRunnable = new AnonymousClass3(this);
        this.mRemoveObserverRunnable = new AnonymousClass4(this);
        this.mTearDownRunnable = new AnonymousClass5(this);
        Context r8 = r4.getApplicationContext();
        this.mAppContext = r8;
        this.mName = r5;
        this.mInvalidationTracker = r6;
        this.mExecutor = r7;
        final String[] r9 = (String[]) r6.mTableIdLookup.keySet().toArray(new String[0]);
        this.mObserver = new AnonymousClass6(this, r9);
        r8.bindService(new Intent(r8, MultiInstanceInvalidationService.class), r0, 1);
    }

    void stop() {
        if (this.mStopped.compareAndSet(false, true) == false) goto L6;
        this.mExecutor.execute(this.mTearDownRunnable);
        return;
    }
}
