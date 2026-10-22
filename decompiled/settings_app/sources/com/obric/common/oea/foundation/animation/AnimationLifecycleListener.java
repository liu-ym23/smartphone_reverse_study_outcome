package com.obric.common.oea.foundation.animation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationLifecycleListener.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000eJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007J\u0014\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/common/oea/foundation/animation/AnimationLifecycleListener;", "", "()V", "TAG", "", "animationManagers", "Ljava/util/ArrayList;", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "Lkotlin/collections/ArrayList;", "isInit", "", "viewAnimationMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "addAnimationInfo", "", "view", "animationInfo", "addAnimationManager", "animationManager", "getAnimationInfo", "init", "application", "Landroid/app/Application;", "removeAnimationInfo", "removeAnimationManager", "ActivityLifeCallback", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimationLifecycleListener {
    public static final AnimationLifecycleListener INSTANCE = null;
    private static final String TAG = "AnimationLifecycleListener";
    private static final ArrayList<AnimationManager> animationManagers = null;
    private static boolean isInit;
    private static final WeakHashMap<View, AnimationInfo<?>> viewAnimationMap = null;

    /* JADX INFO: compiled from: AnimationLifecycleListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/common/oea/foundation/animation/AnimationLifecycleListener$ActivityLifeCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    private static final class ActivityLifeCallback implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            Intrinsics.checkNotNullParameter(r2, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        public ActivityLifeCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            ArrayList r3 = new ArrayList();
            r3.addAll(AnimationLifecycleListener.access$getAnimationManagers$p(AnimationLifecycleListener.INSTANCE));
            Iterator r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            AnimationManager.cancelAnimation$default((AnimationManager) r5.next(), false, 1, null);
            goto L4
        }
    }

    static {
        INSTANCE = new AnimationLifecycleListener();
        animationManagers = new ArrayList();
        viewAnimationMap = new WeakHashMap();
    }

    private AnimationLifecycleListener() {
    }

    public static final /* synthetic */ ArrayList access$getAnimationManagers$p(AnimationLifecycleListener r0) {
        return animationManagers;
    }

    public final void init(Application r1) {
        Intrinsics.checkNotNullParameter(r1, "application");
        if (isInit == false) goto L5;
        return;
    L5:
        isInit = true;
        r1.registerActivityLifecycleCallbacks(new ActivityLifeCallback());
    }

    public final void addAnimationInfo(View r1, AnimationInfo<?> r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "animationInfo");
        viewAnimationMap.put(r1, r2);
    }

    public final AnimationInfo<?> getAnimationInfo(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return viewAnimationMap.get(r1);
    }

    public final void removeAnimationInfo(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        viewAnimationMap.remove(r1);
    }

    public final void addAnimationManager(AnimationManager r3) {
        Intrinsics.checkNotNullParameter(r3, "animationManager");
        ArrayList<AnimationManager> r2 = animationManagers;
        r2.add(r3);
        OEALogger.INSTANCE.v(TAG, "addAnimationManager, size: " + r2.size());
    }

    public final void removeAnimationManager(AnimationManager r3) {
        Intrinsics.checkNotNullParameter(r3, "animationManager");
        ArrayList<AnimationManager> r2 = animationManagers;
        r2.remove(r3);
        OEALogger.INSTANCE.v(TAG, "removeAnimationManager, size: " + r2.size());
    }

    public final boolean isInit() {
        return isInit;
    }
}
