package com.obric.common.oea.foundation.animation.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class AnimationHandler {
    private static final long FRAME_DELAY_MS = 10;
    public static final ThreadLocal<AnimationHandler> sAnimatorHandler = null;
    final ArrayList<AnimationFrameCallback> mAnimationCallbacks;
    private final AnimationCallbackDispatcher mCallbackDispatcher;
    long mCurrentFrameTime;
    private final ArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime;
    private boolean mListDirty;
    private AnimationFrameCallbackProvider mProvider;

    class AnimationCallbackDispatcher {
        final /* synthetic */ AnimationHandler this$0;

        AnimationCallbackDispatcher(AnimationHandler r1) {
            this.this$0 = r1;
        }

        void dispatchAnimationFrame() {
            AnimationHandler r0 = this.this$0;
            r0.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler r1 = this.this$0;
            r1.doAnimationFrame(r1.mCurrentFrameTime);
            if (this.this$0.mAnimationCallbacks.size() <= 0) goto L6;
            this.this$0.getProvider().postFrameCallback();
            return;
        }
    }

    interface AnimationFrameCallback {
        boolean doAnimationFrame(long r1);
    }

    static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher mDispatcher;

        abstract void postFrameCallback();

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher r1) {
            this.mDispatcher = r1;
        }
    }

    private static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        private final Handler mHandler;
        long mLastFrameTime;
        private final Runnable mRunnable;

        FrameCallbackProvider14(AnimationCallbackDispatcher r3) {
            super(r3);
            this.mLastFrameTime = -1;
            this.mRunnable = new AnonymousClass1(this);
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.obric.common.oea.foundation.animation.engine.AnimationHandler.AnimationFrameCallbackProvider
        void postFrameCallback() {
            long r0 = Math.max(10 - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0);
            this.mHandler.postDelayed(this.mRunnable, r0);
        }
    }

    private static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer mChoreographer;
        private final Choreographer.FrameCallback mChoreographerCallback;

        FrameCallbackProvider16(AnimationCallbackDispatcher r1) {
            super(r1);
            this.mChoreographer = Choreographer.getInstance();
            this.mChoreographerCallback = new AnonymousClass1(this);
        }

        @Override // com.obric.common.oea.foundation.animation.engine.AnimationHandler.AnimationFrameCallbackProvider
        void postFrameCallback() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    AnimationHandler() {
        this.mDelayedCallbackStartTime = new ArrayMap();
        this.mAnimationCallbacks = new ArrayList();
        this.mCallbackDispatcher = new AnimationCallbackDispatcher(this);
        this.mCurrentFrameTime = 0;
        this.mListDirty = false;
    }

    static {
        sAnimatorHandler = new ThreadLocal();
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> r0 = sAnimatorHandler;
        if (r0.get() != null) goto L6;
        r0.set(new AnimationHandler());
    L6:
        return r0.get();
    }

    public static long getFrameTime() {
        ThreadLocal<AnimationHandler> r0 = sAnimatorHandler;
        if (r0.get() != null) goto L7;
        return 0;
    L7:
        return r0.get().mCurrentFrameTime;
    }

    public void setProvider(AnimationFrameCallbackProvider r1) {
        this.mProvider = r1;
    }

    AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider != null) goto L6;
        this.mProvider = new FrameCallbackProvider16(this.mCallbackDispatcher);
    L6:
        return this.mProvider;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback r3, long r4) {
        if (this.mAnimationCallbacks.size() != 0) goto L6;
        getProvider().postFrameCallback();
    L6:
        if (this.mAnimationCallbacks.contains(r3) == true) goto L9;
        this.mAnimationCallbacks.add(r3);
    L9:
        if (r4 <= 0) goto L12;
        this.mDelayedCallbackStartTime.put(r3, Long.valueOf(SystemClock.uptimeMillis() + r4));
        return;
    }

    public void removeCallback(AnimationFrameCallback r3) {
        this.mDelayedCallbackStartTime.remove(r3);
        int r4 = this.mAnimationCallbacks.indexOf(r3);
        if (r4 < 0) goto L6;
        this.mAnimationCallbacks.set(r4, null);
        this.mListDirty = true;
        return;
    }

    void doAnimationFrame(long r6) {
        long r0 = SystemClock.uptimeMillis();
        int r2 = 0;
    L4:
        if (r2 >= this.mAnimationCallbacks.size()) goto L12;
        AnimationFrameCallback r3 = this.mAnimationCallbacks.get(r2);
        if (r3 == null) goto L11;
        if (isCallbackDue(r3, r0) == false) goto L11;
        r3.doAnimationFrame(r6);
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        cleanUpList();
    }

    private boolean isCallbackDue(AnimationFrameCallback r5, long r6) {
        Long r0 = this.mDelayedCallbackStartTime.get(r5);
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.longValue() >= r6) goto L9;
        this.mDelayedCallbackStartTime.remove(r5);
        return true;
    L9:
        return false;
    }

    private void cleanUpList() {
        if (this.mListDirty == false) goto L15;
        int r0 = this.mAnimationCallbacks.size() - 1;
    L5:
        if (r0 < 0) goto L10;
        if (this.mAnimationCallbacks.get(r0) != null) goto L9;
        this.mAnimationCallbacks.remove(r0);
    L9:
        r0 = r0 - 1;
        goto L5
    L10:
        this.mListDirty = false;
        return;
    }
}
