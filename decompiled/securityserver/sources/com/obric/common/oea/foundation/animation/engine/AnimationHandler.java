package com.obric.common.oea.foundation.animation.engine;

import android.os.SystemClock;
import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
class AnimationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameCallbackProvider16 f115a;
    public boolean b;

    public class AnimationCallbackDispatcher {
        public final void a() {
            SystemClock.uptimeMillis();
            throw null;
        }
    }

    public interface AnimationFrameCallback {
        boolean a(long r1);
    }

    public static abstract class AnimationFrameCallbackProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimationCallbackDispatcher f116a;

        public AnimationFrameCallbackProvider(AnimationCallbackDispatcher r1) {
            this.f116a = r1;
        }
    }

    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {

        /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.AnimationHandler$FrameCallbackProvider14$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                SystemClock.uptimeMillis();
                throw null;
            }
        }
    }

    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        public final Choreographer b;
        public final Choreographer.FrameCallback c;

        public FrameCallbackProvider16(AnimationCallbackDispatcher r1) {
            super(r1);
            this.b = Choreographer.getInstance();
            this.c = new AnonymousClass1(this);
        }

        public final void a() {
            Choreographer.FrameCallback r0 = this.c;
            this.b.postFrameCallback(r0);
        }
    }

    static {
        new ThreadLocal();
    }
}
