package com.obric.oui.sheet.v2;

import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.oui.button.OIconButtonFloating;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OSheetTitleBar extends FrameLayout {
    public LinearLayout b;
    public LinearLayout c;
    public FrameLayout e;
    public FrameLayout f;
    public OIconButtonFloating i;
    public boolean j;
    public String k;
    public String l;
    public String m;
    public TitlePosition n;
    public float o;
    public float p;
    public VelocityTracker q;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final enum TitlePosition extends Enum<TitlePosition> {
        public static final TitlePosition b = null;
        public static final /* synthetic */ TitlePosition[] c = null;

        static {
            TitlePosition r0 = new TitlePosition("FIXED_CENTER", 0);
            TitlePosition r1 = new TitlePosition("FLOW_WITH_ACTION", 1);
            TitlePosition r2 = new TitlePosition("LEFT_IN_ACTION", 2);
            b = r2;
            c = new TitlePosition[]{r0, r1, r2};
        }

        public static TitlePosition valueOf(String r1) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r1);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) c.clone();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[TitlePosition.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
            int[] r1 = new int[TitlePosition.values().length];
            r1[0] = 1;
            r1[1] = 2;
            r1[2] = 3;
        }
    }

    @Nullable
    public final String getDesText() {
        return this.m;
    }

    @NotNull
    public final FrameLayout getMCenterContainer() {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mCenterContainer");
        throw null;
    }

    @NotNull
    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mFixedCenterContainer");
        throw null;
    }

    @NotNull
    public final OIconButtonFloating getMLeftActionBack() {
        OIconButtonFloating r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mLeftActionBack");
        throw null;
    }

    @NotNull
    public final LinearLayout getMLeftContainer() {
        LinearLayout r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mLeftContainer");
        throw null;
    }

    @NotNull
    public final LinearLayout getMRightContainer() {
        LinearLayout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mRightContainer");
        throw null;
    }

    @NotNull
    public final TitlePosition getMTitlePosition() {
        return this.n;
    }

    @NotNull
    public final TextView getMTitleView() {
        int r2 = this.n.ordinal();
        if (r2 != 0) goto L5;
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    L5:
        if (r2 != 1) goto L7;
        Intrinsics.m("mCenterTitleView");
        throw null;
    L7:
        if (r2 != 2) goto L11;
        Intrinsics.m("mLeftTitleView");
        throw null;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.j;
    }

    @Nullable
    public final String getSubTitleText() {
        return this.k;
    }

    @Nullable
    public final String getTitleText() {
        return this.l;
    }

    @NotNull
    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final float getTouchStartX() {
        return this.o;
    }

    public final float getTouchStartY() {
        return this.p;
    }

    @Nullable
    public final VelocityTracker getVelocityTracker() {
        return this.q;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setCenterText(int r2) {
        String r3 = getResources().getString(r2);
        Intrinsics.e(r3, "resources.getString(resId)");
        setTitleText(r3);
    }

    public final void setDesText(@Nullable String r2) {
        this.m = r2;
        if (r2 != null) goto L5;
    L9:
        Intrinsics.m("mDesContainerView");
        throw null;
    L5:
        if (r2.length() == 0) goto L9;
        Intrinsics.m("mDesContainerView");
        throw null;
    }

    public final void setMCenterContainer(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.e = r2;
    }

    public final void setMFixedCenterContainer(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.f = r2;
    }

    public final void setMLeftActionBack(@NotNull OIconButtonFloating r2) {
        Intrinsics.f(r2, "<set-?>");
        this.i = r2;
    }

    public final void setMLeftContainer(@NotNull LinearLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMRightContainer(@NotNull LinearLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMTitlePosition(@NotNull TitlePosition r4) {
        Intrinsics.f(r4, "value");
        this.n = r4;
        int r5 = r4.ordinal();
        if (r5 != 0) goto L5;
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    L5:
        if (r5 != 1) goto L7;
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    L7:
        if (r5 == 2) goto L10;
        getMTitleView().setText(this.l);
        return;
    L10:
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    }

    public final void setShowLeftBack(boolean r5) {
        this.j = r5;
        OIconButtonFloating r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.m("mLeftActionBack");
        throw null;
    L5:
        if (r5 == false) goto L7;
        int r6 = 0;
    L8:
        r0.setVisibility(r6);
        if (this.n != TitlePosition.b) goto L15;
        OIconButtonFloating r4 = this.i;
        if (r4 == null) goto L13;
        r4.setVisibility(8);
        return;
    L13:
        Intrinsics.m("mLeftActionBack");
        throw null;
    L15:
        return;
    L7:
        r6 = 8;
        goto L8
    }

    public final void setSubTitleText(@Nullable String r2) {
        this.k = r2;
        if (r2 != null) goto L6;
        Intrinsics.m("mFixedCenterSubTitleView");
        throw null;
    L6:
        Intrinsics.m("mFixedCenterSubTitleView");
        throw null;
    }

    public final void setTitleText(@Nullable String r3) {
        this.l = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r3);
    }

    public final void setTouchStartX(float r1) {
        this.o = r1;
    }

    public final void setTouchStartY(float r1) {
        this.p = r1;
    }

    public final void setVelocityTracker(@Nullable VelocityTracker r1) {
        this.q = r1;
    }

    public final void setCenterText(@NotNull String r2) {
        Intrinsics.f(r2, "title");
        setTitleText(r2);
    }
}
