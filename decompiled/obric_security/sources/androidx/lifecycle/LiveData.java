package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object NOT_SET = null;
    static final int START_VERSION = -1;
    int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        final /* synthetic */ LiveData this$0;

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean shouldBeActive() {
            return true;
        }

        AlwaysActiveObserver(LiveData r1, Observer<? super T> r2) {
            this.this$0 = r1;
            super(r1, r2);
        }
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        final LifecycleOwner mOwner;
        final /* synthetic */ LiveData this$0;

        LifecycleBoundObserver(LiveData r1, LifecycleOwner r2, Observer<? super T> r3) {
            this.this$0 = r1;
            super(r1, r3);
            this.mOwner = r2;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            Lifecycle.State r4 = this.mOwner.getLifecycle().getCurrentState();
            if (r4 != Lifecycle.State.DESTROYED) goto L6;
            this.this$0.removeObserver(this.mObserver);
            return;
        L6:
            Lifecycle.State r5 = null;
        L7:
            if (r5 == r4) goto L9;
            activeStateChanged(shouldBeActive());
            Lifecycle.State r6 = this.mOwner.getLifecycle().getCurrentState();
            r5 = r4;
            r4 = r6;
            goto L7
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean isAttachedTo(LifecycleOwner r1) {
            if (this.mOwner != r1) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }
    }

    private abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion;
        final Observer<? super T> mObserver;
        final /* synthetic */ LiveData this$0;

        void detachObserver() {
        }

        boolean isAttachedTo(LifecycleOwner r1) {
            return false;
        }

        abstract boolean shouldBeActive();

        ObserverWrapper(LiveData r1, Observer<? super T> r2) {
            this.this$0 = r1;
            this.mLastVersion = -1;
            this.mObserver = r2;
        }

        void activeStateChanged(boolean r2) {
            if (r2 != this.mActive) goto L5;
            return;
        L5:
            this.mActive = r2;
            LiveData r0 = this.this$0;
            if (r2 == false) goto L8;
            int r3 = 1;
        L9:
            r0.changeActiveCounter(r3);
            if (this.mActive == false) goto L13;
            this.this$0.dispatchingValue(this);
            return;
        L13:
            return;
        L8:
            r3 = -1;
            goto L9
        }
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    static {
        NOT_SET = new Object();
    }

    public LiveData(T r3) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r3;
        this.mVersion = 0;
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        Object r0 = NOT_SET;
        this.mPendingData = r0;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r0;
        this.mVersion = -1;
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

    void dispatchingValue(LiveData<T>.ObserverWrapper r4) {
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

    public void observe(LifecycleOwner r3, Observer<? super T> r4) {
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

    public void observeForever(Observer<? super T> r2) {
        assertMainThread("observeForever");
        AlwaysActiveObserver r0 = new AlwaysActiveObserver(this, r2);
        LiveData<T>.ObserverWrapper r1 = this.mObservers.putIfAbsent(r2, r0);
        if ((r1 instanceof LifecycleBoundObserver) == true) goto L9;
        if (r1 == null) goto L6;
        return;
    L6:
        r0.activeStateChanged(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void removeObserver(Observer<? super T> r2) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper r1 = this.mObservers.remove(r2);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.detachObserver();
        r1.activeStateChanged(false);
    }

    public void removeObservers(LifecycleOwner r4) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> r0 = this.mObservers.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> r1 = r0.next();
        if (r1.getValue().isAttachedTo(r4) == false) goto L4;
        removeObserver(r1.getKey());
        goto L4
    }

    protected void postValue(T r4) {
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

    protected void setValue(T r2) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = r2;
        dispatchingValue(null);
    }

    public T getValue() {
        T r1 = (T) this.mData;
        if (r1 == NOT_SET) goto L5;
        return r1;
    L5:
        return null;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasObservers() {
        if (this.mObservers.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasActiveObservers() {
        if (this.mActiveCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void changeActiveCounter(int r5) {
        int r0 = this.mActiveCount;
        this.mActiveCount = r5 + r0;
        if (this.mChangingActiveState == false) goto L5;
        return;
    L5:
        this.mChangingActiveState = true;
    L27:
        int r2 = this.mActiveCount;     // Catch: Throwable -> L24
        if (r0 == r2) goto L22;
        if (r0 != 0) goto L12;
        if (r2 <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r0 <= 0) goto L16;
        if (r2 != 0) goto L16;
        boolean r1 = true;
    L17:
        if (r3 == false) goto L19;
        onActive();     // Catch: Throwable -> L24
    L21:
        r0 = r2;
        goto L27
    L19:
        if (r1 == false) goto L21;
        onInactive();     // Catch: Throwable -> L24
    L16:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    L22:
        this.mChangingActiveState = false;
        return;
    L24:
        th = move-exception;
        this.mChangingActiveState = false;
        throw th;
    }

    static void assertMainThread(String r3) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r3 + " on a background thread");
    }
}
