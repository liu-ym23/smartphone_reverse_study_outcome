package com.obric.oui.shadow;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActivityChooserView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OShadowLayout extends FrameLayout {

    @Metadata
    public static final class Companion {
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.f(r12, "canvas");
        super.onDraw(r12);
        Path r0 = new Path();
        int r1 = getChildCount();
        int r2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int r5 = Integer.MIN_VALUE;
        int r6 = 0;
        int r3 = Integer.MAX_VALUE;
        int r4 = Integer.MIN_VALUE;
    L3:
        if (r6 >= r1) goto L9;
        View r7 = getChildAt(r6);
        Intrinsics.e(r7, "child");
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L8;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        r2 = Math.min(r2, r7.getLeft() - r9.leftMargin);
        r3 = Math.min(r3, r7.getTop() - r9.topMargin);
        r4 = Math.max(r4, r7.getRight() + r9.rightMargin);
        r5 = Math.max(r5, r7.getBottom() + r9.bottomMargin);
        r6 = r6 + 1;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        r0.addRoundRect(new RectF(r2, r3, r4, r5), 0.0f, 0.0f, Path.Direction.CW);
        RectF r11 = new RectF();
        r0.computeBounds(r11, true);
        r12.save();
        new RectF(r11);
        throw null;
    }
}
