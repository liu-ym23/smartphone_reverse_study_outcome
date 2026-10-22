package com.obric.oui.popover;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.widget.NestedScrollView;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MaxHeightNestedScrollView extends NestedScrollView {
    public final int b;
    public final int c;

    @JvmOverloads
    public MaxHeightNestedScrollView(@NotNull Context r4, @Nullable AttributeSet r5) {
        Intrinsics.f(r4, "context");
        super(r4, r5, 0);
        this.b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.c = getResources().getDimensionPixelSize(R.dimen.oui_p_container_tiny_2) * 2;
        if (r5 == null) goto L6;
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{android.R.attr.maxHeight});
        Intrinsics.e(r6, "context.obtainStyledAttr…ndroid.R.attr.maxHeight))");
        this.b = r6.getDimensionPixelSize(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        r6.recycle();
        return;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r1 = this.b;
        if (r1 == Integer.MAX_VALUE) goto L8;
        int r0 = View.MeasureSpec.getMode(r5);
        int r6 = View.MeasureSpec.getSize(r5);
        if (r6 <= r1) goto L7;
        r6 = r1;
    L7:
        r5 = View.MeasureSpec.makeMeasureSpec(r6, r0);
    L8:
        super.onMeasure(r4, r5);
        int r7 = 0;
        View r8 = getChildAt(0);
        if (r8 == null) goto L11;
        int r9 = r8.getMeasuredHeight();
    L12:
        int r2 = this.c;
        if (r9 <= (r1 - r2)) goto L16;
        r7 = Math.min(r2, Math.abs(r9 - r1));
    L16:
        if (getPaddingBottom() == r7) goto L19;
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), r7);
        return;
    L19:
        return;
    L11:
        r9 = 0;
        goto L12
    }
}
