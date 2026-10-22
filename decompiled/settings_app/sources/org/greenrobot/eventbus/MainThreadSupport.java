package org.greenrobot.eventbus;

import android.os.Looper;

/* JADX INFO: loaded from: classes6.dex */
public interface MainThreadSupport {

    public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {
        private final Looper looper;

        public AndroidHandlerMainThreadSupport(Looper r1) {
            this.looper = r1;
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public boolean isMainThread() {
            if (this.looper != Looper.myLooper()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public Poster createPoster(EventBus r3) {
            return new HandlerPoster(r3, this.looper, 10);
        }
    }

    Poster createPoster(EventBus r1);

    boolean isMainThread();
}
