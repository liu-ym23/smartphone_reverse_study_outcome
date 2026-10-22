package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class ProcessLifecycleOwner implements LifecycleOwner {
    static final long TIMEOUT_MS = 700;
    private static final ProcessLifecycleOwner sInstance = null;
    private Runnable mDelayedPauseRunnable;
    private Handler mHandler;
    ReportFragment.ActivityInitializationListener mInitializationListener;
    private boolean mPauseSent;
    private final LifecycleRegistry mRegistry;
    private int mResumedCounter;
    private int mStartedCounter;
    private boolean mStopSent;

    static {
        sInstance = new ProcessLifecycleOwner();
    }

    public static LifecycleOwner get() {
        return sInstance;
    }

    static void init(Context r1) {
        sInstance.attach(r1);
    }

    void activityStarted() {
        int r0 = this.mStartedCounter + 1;
        this.mStartedCounter = r0;
        if (r0 == 1) goto L5;
        return;
    L5:
        if (this.mStopSent == false) goto L9;
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mStopSent = false;
        return;
    }

    void activityResumed() {
        int r0 = this.mResumedCounter + 1;
        this.mResumedCounter = r0;
        if (r0 == 1) goto L5;
        return;
    L5:
        if (this.mPauseSent == false) goto L7;
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mPauseSent = false;
        return;
    L7:
        this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
    }

    void activityPaused() {
        int r0 = this.mResumedCounter - 1;
        this.mResumedCounter = r0;
        if (r0 != 0) goto L6;
        this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700);
        return;
    }

    void activityStopped() {
        this.mStartedCounter--;
        dispatchStopIfNeeded();
    }

    void dispatchPauseIfNeeded() {
        if (this.mResumedCounter != 0) goto L6;
        this.mPauseSent = true;
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        return;
    }

    void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0) goto L5;
        return;
    L5:
        if (this.mPauseSent == false) goto L9;
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mStopSent = true;
        return;
    }

    private ProcessLifecycleOwner() {
        this.mStartedCounter = 0;
        this.mResumedCounter = 0;
        this.mPauseSent = true;
        this.mStopSent = true;
        this.mRegistry = new LifecycleRegistry(this);
        this.mDelayedPauseRunnable = new AnonymousClass1(this);
        this.mInitializationListener = new AnonymousClass2(this);
    }

    void attach(Context r3) {
        this.mHandler = new Handler();
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application) r3.getApplicationContext()).registerActivityLifecycleCallbacks(new AnonymousClass3(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
