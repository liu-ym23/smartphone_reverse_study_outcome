package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.os.Build;
import androidx.window.embedding.EmbeddingCompat;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class EnterTransitionLancet {
    public EnterTransitionLancet() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public void onStop() {
        Origin.callVoid();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L11;
        Activity r2 = (Activity) This.get();
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    L12:
        return;
    }
}
