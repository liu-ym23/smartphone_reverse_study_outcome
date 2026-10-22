package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class LifecycleDispatcher {
    private static AtomicBoolean sInitialized;

    static class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
        }

        DispatcherActivityCallback() {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            ReportFragment.injectIfNeededIn(r1);
        }
    }

    static {
        sInitialized = new AtomicBoolean(false);
    }

    static void init(Context r2) {
        if (sInitialized.getAndSet(true) == false) goto L5;
        return;
    L5:
        ((Application) r2.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }

    private LifecycleDispatcher() {
    }
}
