package com.bytedance.sysoptimizer;

import android.app.Activity;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes3.dex */
public class EnterTransitionLancet {
    public EnterTransitionLancet() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public void onStop() {
        Origin.callVoid();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        ((Activity) This.get()).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
