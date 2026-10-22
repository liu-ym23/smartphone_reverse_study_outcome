package com.obric.oui.animation.engine;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class AnimationHandler {
    public static final ThreadLocal f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f163a;
    public final ArrayList b;
    public final AnimationCallbackDispatcher c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameCallbackProvider16 f164d;
    public boolean e;

    public class AnimationCallbackDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimationHandler f165a;

        public AnimationCallbackDispatcher(AnimationHandler r1) {
            this.f165a = r1;
        }

        public final void a() {
            long r0 = SystemClock.uptimeMillis();
            AnimationHandler r10 = this.f165a;
            r10.getClass();
            long r2 = SystemClock.uptimeMillis();
            int r5 = 0;
        L3:
            ArrayList r6 = r10.b;
            if (r5 >= r6.size()) goto L17;
            AnimationFrameCallback r7 = (AnimationFrameCallback) r6.get(r5);
            if (r7 == null) goto L15;
            ArrayMap r8 = r10.f163a;
            Long r9 = (Long) r8.get(r7);
            if (r9 != null) goto L12;
        L14:
            r7.a(r0);
            goto L15
        L12:
            if (r9.longValue() >= r2) goto L15;
            r8.remove(r7);
        L15:
            r5 = r5 + 1;
            goto L3
        L17:
            if (r10.e == false) goto L26;
            int r1 = r6.size() - 1;
        L19:
            if (r1 < 0) goto L24;
            if (r6.get(r1) != null) goto L23;
            r6.remove(r1);
        L23:
            r1 = r1 - 1;
            goto L19
        L24:
            r10.e = false;
        L26:
            if (r6.size() > 0) goto L28;
            return;
        L28:
            if (r10.f164d != null) goto L30;
            r10.f164d = new FrameCallbackProvider16(r10.c);
        L30:
            r10.f164d.a();
        }
    }

    public interface AnimationFrameCallback {
        boolean a(long r1);
    }

    public static abstract class AnimationFrameCallbackProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimationCallbackDispatcher f166a;

        public AnimationFrameCallbackProvider(AnimationCallbackDispatcher r1) {
            this.f166a = r1;
        }
    }

    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {

        /* JADX INFO: renamed from: com.obric.oui.animation.engine.AnimationHandler$FrameCallbackProvider14$1, reason: invalid class name */
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
        f = new ThreadLocal();
    }

    public AnimationHandler() {
        this.f163a = new ArrayMap();
        this.b = new ArrayList();
        this.c = new AnimationCallbackDispatcher(this);
        this.e = false;
    }
}
