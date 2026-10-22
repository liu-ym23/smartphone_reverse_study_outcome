package com.obric.oui.indicator;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OCarouselIndicator extends OBaseIndicator {
    public int w;

    @Metadata
    public static final class Companion {
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final OCarouselIndicator$buildOnPageChangedListener$1 b() {
        return new OCarouselIndicator$buildOnPageChangedListener$1(this);
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public final void e() {
        if (getInitialized() == true) goto L6;
        setPendingRefreshParentLayout(true);
        return;
    L6:
        setPendingRefreshParentLayout(false);
        if (getType() != 1) goto L10;
        Intrinsics.m("linearLayout");
        throw null;
    L10:
        Intrinsics.m("linearLayout");
        throw null;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    @NotNull
    public OBaseIndicator.CustomDot getCustom() {
        Resources r1 = Resources.getSystem();
        Intrinsics.e(r1, "Resources.getSystem()");
        float r0 = TypedValue.applyDimension(1, 24, r1.getDisplayMetrics());
        Resources r4 = Resources.getSystem();
        Intrinsics.e(r4, "Resources.getSystem()");
        float r2 = TypedValue.applyDimension(1, 4, r4.getDisplayMetrics());
        Resources r5 = Resources.getSystem();
        Intrinsics.e(r5, "Resources.getSystem()");
        return new OBaseIndicator.CustomDot(r0, r2, TypedValue.applyDimension(1, 3, r5.getDisplayMetrics()), R.styleable.g);
    }

    public final int getSelectedDotColor() {
        return this.w;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setSelectedDotColor(int r3) {
        if (getType() != 1) goto L5;
        this.w = (int) 4076863487L;
        c();
        return;
    L5:
        if (this.w == r3) goto L9;
        this.w = r3;
        c();
        return;
    }
}
