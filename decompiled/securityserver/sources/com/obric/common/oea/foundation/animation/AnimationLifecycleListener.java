package com.obric.common.oea.foundation.animation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimationLifecycleListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f101a = null;
    public static final WeakHashMap b = null;

    @Metadata
    public static final class ActivityLifeCallback implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.f(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.f(r2, "activity");
            ArrayList r1 = new ArrayList();
            r1.addAll(AnimationLifecycleListener.f101a);
            Iterator r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            AnimationManager r4 = (AnimationManager) r3.next();
            int r0 = AnimationManager.f122d;
            r4.a(false);
            goto L4
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r1) {
            Intrinsics.f(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r1) {
            Intrinsics.f(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            Intrinsics.f(r1, "activity");
            Intrinsics.f(r2, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r1) {
            Intrinsics.f(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r1) {
            Intrinsics.f(r1, "activity");
        }
    }

    static {
        f101a = new ArrayList();
        b = new WeakHashMap();
    }
}
