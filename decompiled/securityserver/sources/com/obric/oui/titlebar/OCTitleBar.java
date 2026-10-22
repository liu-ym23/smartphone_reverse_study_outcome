package com.obric.oui.titlebar;

import a.a;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OCTitleBar extends FrameLayout {
    public static final /* synthetic */ int p = 0;
    public LinearLayout b;
    public LinearLayout c;
    public FrameLayout e;
    public FrameLayout f;
    public ViewGroup i;
    public OButton j;
    public int k;
    public boolean l;
    public String m;
    public String n;
    public TitlePosition o;

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

    public final void a() {
        TitlePosition r2 = this.o;
        if (r2 != TitlePosition.c) goto L5;
        Intrinsics.m("mLeftTitleView");
        throw null;
    L5:
        if (r2 == TitlePosition.b) goto L7;
        return;
    L7:
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    }

    @NotNull
    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("fixedCenterTitleContainer");
        throw null;
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
        OButton r0 = this.j;
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
        return this.o;
    }

    @NotNull
    public final TextView getMTitleView() {
        int r2 = this.o.ordinal();
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
        return this.l;
    }

    @Nullable
    public final String getSubTitleText() {
        return this.m;
    }

    @Nullable
    public final String getTitleText() {
        return this.n;
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
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        TitlePosition r7 = this.o;
        if (r7 != TitlePosition.c) goto L5;
        Intrinsics.m("mLeftTitleView");
        throw null;
    L5:
        if (r7 != TitlePosition.b) goto L81;
        LinearLayout r8 = this.b;
        if (r8 == null) goto L79;
        int r1 = 0;
        if (r8.getVisibility() != 0) goto L26;
        LinearLayout r9 = this.b;
        if (r9 == null) goto L24;
        int r10 = r9.getMeasuredWidth();
        LinearLayout r2 = this.b;
        if (r2 == null) goto L22;
        ViewGroup.LayoutParams r11 = r2.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r11 = null;
    L17:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r12 == null) goto L20;
        int r13 = r12.leftMargin;
    L21:
        int r14 = r10 + r13;
    L27:
        LinearLayout r15 = this.c;
        if (r15 != null) goto L30;
        Intrinsics.m("mRightContainer");
        throw null;
    L30:
        if (r15.getVisibility() != 0) goto L47;
        LinearLayout r16 = this.c;
        if (r16 == null) goto L45;
        int r17 = r16.getMeasuredWidth();
        LinearLayout r3 = this.c;
        if (r3 == null) goto L43;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L38;
        r4 = null;
    L38:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r4;
        if (r18 == null) goto L41;
        int r19 = r18.rightMargin;
    L42:
        int r20 = r17 + r19;
    L48:
        int r21 = Math.max(r14, r20);
        FrameLayout r22 = this.f;
        if (r22 != null) goto L51;
        Intrinsics.m("mFixedCenterContainer");
        throw null;
    L51:
        if (r22.getVisibility() != 0) goto L84;
        FrameLayout r23 = this.f;
        if (r23 == null) goto L73;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if ((r24 instanceof ViewGroup.MarginLayoutParams) == true) goto L57;
        r24 = null;
    L57:
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r24;
        if (r25 == null) goto L60;
        int r26 = r25.leftMargin;
    L61:
        FrameLayout r27 = this.f;
        if (r27 == null) goto L71;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if ((r28 instanceof ViewGroup.MarginLayoutParams) == true) goto L66;
        r28 = null;
    L66:
        ViewGroup.MarginLayoutParams r29 = (ViewGroup.MarginLayoutParams) r28;
        if (r29 == null) goto L69;
        r1 = r29.rightMargin;
    L69:
        Math.max((getMeasuredWidth() - (r21 * 2)) - (r26 + r1), this.k);
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    L71:
        Intrinsics.m("mFixedCenterContainer");
        throw null;
    L60:
        r26 = 0;
        goto L61
    L73:
        Intrinsics.m("mFixedCenterContainer");
        throw null;
    L84:
        return;
    L41:
        r19 = 0;
        goto L42
    L43:
        Intrinsics.m("mRightContainer");
        throw null;
    L45:
        Intrinsics.m("mRightContainer");
        throw null;
    L47:
        r20 = 0;
        goto L48
    L20:
        r13 = 0;
        goto L21
    L22:
        Intrinsics.m("mLeftContainer");
        throw null;
    L24:
        Intrinsics.m("mLeftContainer");
        throw null;
    L26:
        r14 = 0;
        goto L27
    L79:
        Intrinsics.m("mLeftContainer");
        throw null;
    }

    public final void setCenterText(int r2) {
        String r3 = getResources().getString(r2);
        Intrinsics.e(r3, "resources.getString(resId)");
        setTitleText(r3);
    }

    public final void setFixedCenterTitleContainer(@NotNull ViewGroup r2) {
        Intrinsics.f(r2, "<set-?>");
        this.i = r2;
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
        this.j = r2;
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
        this.o = r4;
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
        getMTitleView().setText(this.n);
        return;
    L10:
        Intrinsics.m("mFixedCenterTitleView");
        throw null;
    }

    public final void setMinCenterTitleWidth(int r3) {
        this.k = a.d("Resources.getSystem()", 1, r3);
        post(new AnonymousClass1(this));
    }

    public final void setShowLeftBack(boolean r5) {
        this.l = r5;
        OButton r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.m("mLeftActionBack");
        throw null;
    L5:
        if (r5 == false) goto L7;
        int r6 = 0;
    L8:
        r0.setVisibility(r6);
        if (this.o != TitlePosition.c) goto L15;
        OButton r4 = this.j;
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
        this.m = r2;
        if (r2 != null) goto L6;
        Intrinsics.m("mFixedCenterSubTitleView");
        throw null;
    L6:
        Intrinsics.m("mFixedCenterSubTitleView");
        throw null;
    }

    public final void setTitleText(@Nullable String r3) {
        this.n = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r3);
        a();
    }

    public final void setCenterText(@NotNull String r2) {
        Intrinsics.f(r2, "title");
        setTitleText(r2);
    }
}
