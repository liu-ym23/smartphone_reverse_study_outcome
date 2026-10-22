package com.obric.oui.swipeaction;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSwipeActionLayout$dragHelperCallback$1 extends ViewDragHelper.Callback {
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View r1, int r2, int r3) {
        Intrinsics.f(r1, "child");
        throw null;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewHorizontalDragRange(View r1) {
        Intrinsics.f(r1, "child");
        throw null;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int r1) {
        throw null;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View r1, int r2, int r3, int r4, int r5) {
        Intrinsics.f(r1, "changedView");
        throw null;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewReleased(View r1, float r2, float r3) {
        Intrinsics.f(r1, "releasedChild");
        throw null;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View r1, int r2) {
        Intrinsics.f(r1, "view");
        int r0 = OSwipeActionLayout.j;
        throw null;
    }
}
