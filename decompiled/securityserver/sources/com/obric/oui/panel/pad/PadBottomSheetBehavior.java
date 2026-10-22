package com.obric.oui.panel.pad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.oui.panel.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PadBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public PadBottomSheetBehavior(@NotNull Context r2, @NotNull AttributeSet r3) {
        Intrinsics.f(r2, "context");
        Intrinsics.f(r3, "attributes");
        super(r2, r3);
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior
    public final void calculateCollapsedOffset() {
        if (this.f241a == false) goto L7;
        int r0 = this.v - this.h;
        int r1 = this.i;
        if (r0 >= r1) goto L8;
        r0 = r1;
    L8:
        this.k = r0 / 2;
        return;
    L7:
        r0 = this.v - this.h;
        goto L8
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
        Intrinsics.f(r1, "parent");
        Intrinsics.f(r2, "child");
        Intrinsics.f(r3, "event");
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
        Intrinsics.f(r1, "coordinatorLayout");
        Intrinsics.f(r2, "child");
        Intrinsics.f(r3, "directTargetChild");
        Intrinsics.f(r4, TypedValues.AttributesType.S_TARGET);
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r1, View r2, MotionEvent r3) {
        Intrinsics.f(r1, "parent");
        Intrinsics.f(r2, "child");
        Intrinsics.f(r3, "event");
        return false;
    }
}
