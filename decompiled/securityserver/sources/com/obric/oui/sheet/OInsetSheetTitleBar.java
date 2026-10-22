package com.obric.oui.sheet;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OInsetSheetTitleBar extends FrameLayout {
    public LinearLayout b;
    public LinearLayout c;
    public FrameLayout e;
    public FrameLayout f;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public FrameLayout m;
    public OTextView n;
    public OButton o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public TitlePosition t;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final enum TitlePosition extends Enum<TitlePosition> {
        public static final TitlePosition b = null;
        public static final TitlePosition c = null;
        public static final /* synthetic */ TitlePosition[] e = null;

        static {
            TitlePosition r0 = new TitlePosition("FIXED_CENTER", 0);
            b = r0;
            TitlePosition r1 = new TitlePosition("FLOW_WITH_ACTION", 1);
            TitlePosition r2 = new TitlePosition("LEFT_IN_ACTION", 2);
            c = r2;
            e = new TitlePosition[]{r0, r1, r2};
        }

        public static TitlePosition valueOf(String r1) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r1);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) e.clone();
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
        return this.s;
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
    public final OButton getMLeftActionBack() {
        OButton r0 = this.o;
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
        return this.t;
    }

    @NotNull
    public final TextView getMTitleView() {
        int r0 = this.t.ordinal();
        if (r0 != 0) goto L5;
        TextView r3 = this.k;
        if (r3 == null) goto L23;
    L22:
        return r3;
    L23:
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    L5:
        if (r0 != 1) goto L7;
        r3 = this.i;
        if (r3 != null) goto L22;
        Intrinsics.m("mCenterTitleView");
        throw null;
    L7:
        if (r0 != 2) goto L14;
        r3 = this.j;
        if (r3 != null) goto L22;
        Intrinsics.m("mLeftTitleView");
        throw null;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.p;
    }

    @Nullable
    public final String getSubTitleText() {
        return this.q;
    }

    @Nullable
    public final String getTitleText() {
        return this.r;
    }

    @NotNull
    public final TextView getTitleView() {
        return getMTitleView();
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

    public final void setDesText(@Nullable String r4) {
        this.s = r4;
        if (r4 != null) goto L5;
    L16:
        FrameLayout r3 = this.m;
        if (r3 == null) goto L20;
        r3.setVisibility(8);
        return;
    L20:
        Intrinsics.m("mDesContainerView");
        throw null;
    L5:
        if (r4.length() == 0) goto L16;
        FrameLayout r2 = this.m;
        if (r2 == null) goto L14;
        r2.setVisibility(0);
        OTextView r5 = this.n;
        if (r5 == null) goto L12;
        r5.setText(r4);
        return;
    L12:
        Intrinsics.m("mDesTextView");
        throw null;
    L14:
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

    public final void setMLeftActionBack(@NotNull OButton r2) {
        Intrinsics.f(r2, "<set-?>");
        this.o = r2;
    }

    public final void setMLeftContainer(@NotNull LinearLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMRightContainer(@NotNull LinearLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMTitlePosition(@NotNull TitlePosition r8) {
        Intrinsics.f(r8, "value");
        this.t = r8;
        int r9 = r8.ordinal();
        if (r9 != 0) goto L5;
        TextView r10 = this.k;
        if (r10 == null) goto L48;
        r10.setVisibility(0);
        TextView r11 = this.i;
        if (r11 == null) goto L46;
        r11.setVisibility(8);
        TextView r12 = this.j;
        if (r12 == null) goto L44;
        r12.setVisibility(8);
    L42:
        getMTitleView().setText(this.r);
        return;
    L44:
        Intrinsics.m("mLeftTitleView");
        throw null;
    L46:
        Intrinsics.m("mCenterTitleView");
        throw null;
    L48:
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    L5:
        if (r9 != 1) goto L7;
        TextView r13 = this.k;
        if (r13 == null) goto L33;
        r13.setVisibility(8);
        TextView r14 = this.i;
        if (r14 == null) goto L31;
        r14.setVisibility(0);
        TextView r15 = this.j;
        if (r15 == null) goto L29;
        r15.setVisibility(8);
        goto L42
    L29:
        Intrinsics.m("mLeftTitleView");
        throw null;
    L31:
        Intrinsics.m("mCenterTitleView");
        throw null;
    L33:
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    L7:
        if (r9 != 2) goto L42;
        TextView r16 = this.k;
        if (r16 == null) goto L20;
        r16.setVisibility(8);
        TextView r17 = this.i;
        if (r17 == null) goto L18;
        r17.setVisibility(8);
        TextView r18 = this.j;
        if (r18 == null) goto L16;
        r18.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L16:
        Intrinsics.m("mLeftTitleView");
        throw null;
    L18:
        Intrinsics.m("mCenterTitleView");
        throw null;
    L20:
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    }

    public final void setShowLeftBack(boolean r5) {
        this.p = r5;
        OButton r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.m("mLeftActionBack");
        throw null;
    L5:
        if (r5 == false) goto L7;
        int r6 = 0;
    L8:
        r0.setVisibility(r6);
        if (this.t != TitlePosition.c) goto L15;
        OButton r4 = this.o;
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

    public final void setSubTitleText(@Nullable String r5) {
        this.q = r5;
        if (r5 != null) goto L9;
        TextView r4 = this.l;
        if (r4 == null) goto L7;
        r4.setVisibility(8);
        return;
    L7:
        Intrinsics.m("mFixedCenterSubTitleView");
        throw null;
    L9:
        TextView r2 = this.l;
        if (r2 == null) goto L17;
        r2.setVisibility(0);
        TextView r6 = this.l;
        if (r6 == null) goto L15;
        r6.setText(r5);
        return;
    L15:
        Intrinsics.m("mFixedCenterSubTitleView");
        throw null;
    L17:
        Intrinsics.m("mFixedCenterSubTitleView");
        throw null;
    }

    public final void setTitleText(@Nullable String r3) {
        this.r = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r3);
    }

    public final void setCenterText(@NotNull String r2) {
        Intrinsics.f(r2, "title");
        setTitleText(r2);
    }
}
