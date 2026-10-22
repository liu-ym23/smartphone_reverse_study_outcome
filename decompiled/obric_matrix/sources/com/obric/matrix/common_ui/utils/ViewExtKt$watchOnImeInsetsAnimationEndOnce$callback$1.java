package com.obric.matrix.common_ui.utils;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"com/obric/matrix/common_ui/utils/ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "onEnd", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onPrepare", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "common_ui_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1 extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ kotlin.n0.c.a<f0> f8957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f8958b;

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat r2) {
        o.f(r2, "animation");
        kotlin.n0.c.a<f0> r3 = this.f8957a;
        if (r3 == null) goto L5;
        r3.invoke();
    L5:
        ViewCompat.setWindowInsetsAnimationCallback(this.f8958b, null);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat r1) {
        o.f(r1, "animation");
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat r1, List<WindowInsetsAnimationCompat> r2) {
        o.f(r1, "insets");
        o.f(r2, "runningAnimations");
        return r1;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat r1, WindowInsetsAnimationCompat.BoundsCompat r2) {
        o.f(r1, "animation");
        o.f(r2, "bounds");
        return r2;
    }
}
