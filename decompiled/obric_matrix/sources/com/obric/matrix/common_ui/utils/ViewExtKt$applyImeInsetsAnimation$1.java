package com.obric.matrix.common_ui.utils;

import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"com/obric/matrix/common_ui/utils/ViewExtKt$applyImeInsetsAnimation$1", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "onPrepare", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "common_ui_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewExtKt$applyImeInsetsAnimation$1 extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l<Insets, f0> f8955a;

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat r1) {
        o.f(r1, "animation");
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat r2, List<WindowInsetsAnimationCompat> r3) {
        o.f(r2, "insets");
        o.f(r3, "runningAnimations");
        l<Insets, f0> r1 = this.f8955a;
        if (r1 == null) goto L5;
        Insets r4 = r2.getInsets(WindowInsetsCompat.Type.ime());
        o.e(r4, "insets.getInsets(WindowInsetsCompat.Type.ime())");
        r1.invoke(r4);
    L5:
        return r2;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat r1, WindowInsetsAnimationCompat.BoundsCompat r2) {
        o.f(r1, "animation");
        o.f(r2, "bounds");
        return r2;
    }
}
