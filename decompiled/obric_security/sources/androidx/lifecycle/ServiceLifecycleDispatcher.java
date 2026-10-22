package androidx.lifecycle;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class ServiceLifecycleDispatcher {
    private final Handler mHandler;
    private DispatchRunnable mLastDispatchRunnable;
    private final LifecycleRegistry mRegistry;

    static class DispatchRunnable implements Runnable {
        final Lifecycle.Event mEvent;
        private final LifecycleRegistry mRegistry;
        private boolean mWasExecuted;

        DispatchRunnable(LifecycleRegistry r2, Lifecycle.Event r3) {
            this.mWasExecuted = false;
            this.mRegistry = r2;
            this.mEvent = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mWasExecuted == true) goto L6;
            this.mRegistry.handleLifecycleEvent(this.mEvent);
            this.mWasExecuted = true;
            return;
        }
    }

    public ServiceLifecycleDispatcher(LifecycleOwner r2) {
        this.mRegistry = new LifecycleRegistry(r2);
        this.mHandler = new Handler();
    }

    private void postDispatchRunnable(Lifecycle.Event r3) {
        DispatchRunnable r0 = this.mLastDispatchRunnable;
        if (r0 == null) goto L5;
        r0.run();
    L5:
        DispatchRunnable r1 = new DispatchRunnable(this.mRegistry, r3);
        this.mLastDispatchRunnable = r1;
        this.mHandler.postAtFrontOfQueue(r1);
    }

    public void onServicePreSuperOnCreate() {
        postDispatchRunnable(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnBind() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnStart() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnDestroy() {
        postDispatchRunnable(Lifecycle.Event.ON_STOP);
        postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
