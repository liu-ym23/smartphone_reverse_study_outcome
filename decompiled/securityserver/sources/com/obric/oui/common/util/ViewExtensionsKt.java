package com.obric.oui.common.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ViewExtensionsKt {
    public static final void a(View r1, int r2) {
        Intrinsics.f(r1, "$this$expandTouchArea");
        b(r1, r2, r2, false);
    }

    public static final void b(final View r8, final int r9, final int r10, final boolean r11) {
        Intrinsics.f(r8, "$this$expandTouchArea");
        if (r8.getParent() == null) goto L9;
        ViewParent r0 = r8.getParent();
        if (r0 == null) goto L8;
        ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 == null) goto L13;
        final ViewGroup r6 = r1;
        r1.post(new ViewExtensionsKt$expandTouchArea$1(r8, r9, r10, r11, r6));
        return;
    L13:
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r1 = null;
        goto L10
    }

    public static final void c(final View r7, final int r8, final int r9, final View... r10) {
        Intrinsics.f(r7, "$this$increaseHitAreaForViews");
        final TouchDelegateComposite r6 = new TouchDelegateComposite(r7);
        r7.post(new ViewExtensionsKt$increaseHitAreaForViews$1(r7, r10, r8, r9, r6));
    }

    public static final void d(View r1) {
        Intrinsics.f(r1, "$this$makeGone");
        r1.setVisibility(8);
    }

    public static final void e(View r1) {
        Intrinsics.f(r1, "$this$makeVisible");
        r1.setVisibility(0);
    }

    public static final void f(View r1, boolean r2) {
        Intrinsics.f(r1, "$this$setVisibility");
        if (r2 == false) goto L5;
        e(r1);
        return;
    L5:
        d(r1);
    }
}
