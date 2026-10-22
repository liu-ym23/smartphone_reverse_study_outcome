package com.bumptech.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
final class FirstFrameWaiter implements FrameWaiter {
    volatile boolean isFirstFrameSet;
    final Set<Activity> pendingActivities;

    FirstFrameWaiter() {
        this.pendingActivities = Collections.newSetFromMap(new WeakHashMap());
    }

    @Override // com.bumptech.glide.manager.FrameWaiter
    public void registerSelf(Activity r3) {
        if (this.isFirstFrameSet == false) goto L6;
        return;
    L6:
        if (this.pendingActivities.add(r3) == true) goto L8;
        return;
    L8:
        final View r4 = r3.getWindow().getDecorView();
        r4.getViewTreeObserver().addOnDrawListener(new AnonymousClass1(this, r4));
    }

    static void removeListener(View r0, ViewTreeObserver.OnDrawListener r1) {
        r0.getViewTreeObserver().removeOnDrawListener(r1);
    }
}
