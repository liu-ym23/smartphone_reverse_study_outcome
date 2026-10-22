package androidx.lifecycle;

import a.a;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object NOT_SET = null;
    static final int START_VERSION = -1;
    int mActiveCount;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    public class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        final /* synthetic */ LiveData this$0;

        public AlwaysActiveObserver(LiveData r1, Observer<? super T> r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return true;
        }
    }

    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements GenericLifecycleObserver {

        @NonNull
        final LifecycleOwner mOwner;
        final /* synthetic */ LiveData this$0;

        public LifecycleBoundObserver(@NonNull LiveData r1, LifecycleOwner r2, Observer<? super T> r3) {
            this.this$0 = r1;
            super(r1, r3);
            this.mOwner = r2;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean isAttachedTo(LifecycleOwner r1) {
            if (this.mOwner != r1) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r1, Lifecycle.Event r2) {
            if (this.mOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
            this.this$0.removeObserver(this.mObserver);
            return;
        L6:
            activeStateChanged(shouldBeActive());
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    public abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion;
        final Observer<? super T> mObserver;
        final /* synthetic */ LiveData this$0;

        public ObserverWrapper(LiveData r1, Observer<? super T> r2) {
            this.this$0 = r1;
            this.mLastVersion = -1;
            this.mObserver = r2;
        }

        public void activeStateChanged(boolean r5) {
            if (r5 != this.mActive) goto L5;
            return;
        L5:
            this.mActive = r5;
            LiveData r0 = this.this$0;
            int r1 = r0.mActiveCount;
            int r2 = 1;
            if (r1 != 0) goto L8;
            boolean r3 = true;
        L9:
            if (r5 == true) goto L12;
            r2 = -1;
        L12:
            r0.mActiveCount = r1 + r2;
            if (r3 == false) goto L16;
            if (r5 == false) goto L16;
            r0.onActive();
        L16:
            LiveData r6 = this.this$0;
            if (r6.mActiveCount != 0) goto L22;
            if (this.mActive == true) goto L22;
            r6.onInactive();
        L22:
            if (this.mActive == false) goto L25;
            this.this$0.dispatchingValue(this);
            return;
        L25:
            return;
        L8:
            r3 = false;
            goto L9
        }

        public void detachObserver() {
        }

        public boolean isAttachedTo(LifecycleOwner r1) {
            return false;
        }

        public abstract boolean shouldBeActive();
    }

    static {
        NOT_SET = new Object();
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        Object r0 = NOT_SET;
        this.mData = r0;
        this.mPendingData = r0;
        this.mVersion = -1;
        this.mPostValueRunnable = new AnonymousClass1(this);
    }

    private static void assertMainThread(String r3) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(a.k("Cannot invoke ", r3, " on a background thread"));
    }

    private void considerNotify(LiveData<T>.ObserverWrapper r3) {
        if (r3.mActive == true) goto L6;
        return;
    L6:
        if (r3.shouldBeActive() == true) goto L9;
        r3.activeStateChanged(false);
        return;
    L9:
        int r0 = r3.mLastVersion;
        int r1 = this.mVersion;
        if (r0 < r1) goto L12;
        return;
    L12:
        r3.mLastVersion = r1;
        r3.mObserver.onChanged((Object) this.mData);
    }

    public void dispatchingValue(@Nullable LiveData<T>.ObserverWrapper r4) {
        if (this.mDispatchingValue == false) goto L6;
        this.mDispatchInvalidated = true;
        return;
    L6:
        this.mDispatchingValue = true;
    L7:
        this.mDispatchInvalidated = false;
        if (r4 == null) goto L10;
        considerNotify(r4);
        r4 = null;
    L16:
        if (this.mDispatchInvalidated == true) goto L7;
        this.mDispatchingValue = false;
        return;
    L10:
        SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions r1 = this.mObservers.iteratorWithAdditions();
    L12:
        if (r1.hasNext() == false) goto L16;
        considerNotify((ObserverWrapper) r1.next().getValue());
        if (this.mDispatchInvalidated == false) goto L12;
        goto L16
    }

    @Nullable
    public T getValue() {
        T r1 = (T) this.mData;
        if (r1 == NOT_SET) goto L5;
        return r1;
    L5:
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        if (this.mActiveCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasObservers() {
        if (this.mObservers.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner r3, @NonNull Observer<? super T> r4) {
        assertMainThread("observe");
        if (r3.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleBoundObserver r0 = new LifecycleBoundObserver(this, r3, r4);
        LiveData<T>.ObserverWrapper r2 = this.mObservers.putIfAbsent(r4, r0);
        if (r2 != null) goto L8;
    L12:
        if (r2 == null) goto L14;
        return;
    L14:
        r3.getLifecycle().addObserver(r0);
        return;
    L8:
        if (r2.isAttachedTo(r3) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> r2) {
        assertMainThread("observeForever");
        AlwaysActiveObserver r0 = new AlwaysActiveObserver(this, r2);
        LiveData<T>.ObserverWrapper r1 = this.mObservers.putIfAbsent(r2, r0);
        if (r1 != null) goto L5;
    L9:
        if (r1 == null) goto L11;
        return;
    L11:
        r0.activeStateChanged(true);
        return;
    L5:
        if ((r1 instanceof LifecycleBoundObserver) == false) goto L9;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T r4) {
        Object r0 = this.mDataLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingData != NOT_SET) goto L7;
        boolean r1 = true;
    L8:
        this.mPendingData = r4;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (r1 == true) goto L12;
        return;
    L12:
        ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        return;
    L7:
        r1 = false;
        goto L8
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> r2) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper r1 = this.mObservers.remove(r2);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.detachObserver();
        r1.activeStateChanged(false);
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner r4) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> r0 = this.mObservers.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> r1 = r0.next();
        if (r1.getValue().isAttachedTo(r4) == false) goto L4;
        removeObserver(r1.getKey());
        goto L4
    }

    @MainThread
    public void setValue(T r2) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = r2;
        dispatchingValue(null);
    }
}
