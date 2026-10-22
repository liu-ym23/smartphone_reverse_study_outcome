package com.obric.oui.lisitem;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.indicator.IndicatorExternalsKt;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OListItemGeneral extends OUIFrameLayout {
    public FrameLayout k;
    public FrameLayout l;
    public FrameLayout m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public ConstraintLayout q;
    public CharSequence r;
    public CharSequence s;
    public Drawable t;
    public Drawable u;
    public boolean v;
    public boolean w;
    public float x;

    public static void h(ViewGroup r0, View r1, ViewGroup.LayoutParams r2) {
        if (r1 == null) goto L12;
        if (r0 == null) goto L5;
        ViewExtensionsKt.e(r0);
    L5:
        if (r0 == null) goto L7;
        r0.removeAllViews();
    L7:
        if (r2 != null) goto L10;
        if (r0 == null) goto L15;
        r0.addView(r1);
        return;
    L15:
        return;
    L10:
        if (r0 == null) goto L17;
        r0.addView(r1, r2);
        return;
    L17:
        return;
    L12:
        if (r0 == null) goto L19;
        ViewExtensionsKt.d(r0);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.f(r2, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.IOUILayout
    public final boolean e() {
        return true;
    }

    public int getContentDefaultOneChildWidth() {
        return MathKt.a(getResources().getDimension(R.dimen.oui_listitem_content_width_middle));
    }

    @Nullable
    public final Drawable getContentImage() {
        return this.t;
    }

    @NotNull
    public final ConstraintLayout getMClContent() {
        ConstraintLayout r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mClContent");
        throw null;
    }

    @NotNull
    public final FrameLayout getMContentElement() {
        FrameLayout r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mContentElement");
        throw null;
    }

    public final float getMContentElementWidth() {
        return this.x;
    }

    @NotNull
    public final ImageView getMIvContent() {
        ImageView r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mIvContent");
        throw null;
    }

    @NotNull
    public final FrameLayout getMLeadingElement() {
        FrameLayout r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mLeadingElement");
        throw null;
    }

    @NotNull
    public final FrameLayout getMTrailingElement() {
        FrameLayout r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mTrailingElement");
        throw null;
    }

    @NotNull
    public final TextView getMTvSubtitle() {
        TextView r0 = this.p;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mTvSubtitle");
        throw null;
    }

    @NotNull
    public final TextView getMTvTitle() {
        TextView r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("mTvTitle");
        throw null;
    }

    public final boolean getShowBackground() {
        return this.v;
    }

    public final boolean getShowDivider() {
        return this.w;
    }

    public final boolean getShowPreDefineBackground() {
        return this.v;
    }

    @Nullable
    public final CharSequence getSubTitleString() {
        return this.s;
    }

    @Nullable
    public final CharSequence getTitleString() {
        return this.r;
    }

    @Nullable
    public final Drawable getTrailingImage() {
        return this.u;
    }

    public final void i() {
        FrameLayout r0 = this.m;
        if (r0 == null) goto L27;
        Intrinsics.f(r0, "parent");
        int r3 = r0.getChildCount();
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L14;
        View r5 = r0.getChildAt(r4);
        Intrinsics.e(r5, "child");
        if (r5.getVisibility() == 0) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        FrameLayout r1 = this.m;
        if (r1 == null) goto L11;
        IndicatorExternalsKt.b(r1, getContentDefaultOneChildWidth());
    L17:
        float r2 = this.x;
        if (r2 == 0.0f) goto L24;
        FrameLayout r7 = this.m;
        if (r7 == null) goto L22;
        IndicatorExternalsKt.b(r7, (int) r2);
        return;
    L22:
        Intrinsics.m("mContentElement");
        throw null;
    L24:
        return;
    L11:
        Intrinsics.m("mContentElement");
        throw null;
    L14:
        FrameLayout r6 = this.m;
        if (r6 == null) goto L25;
        IndicatorExternalsKt.b(r6, MathKt.a(getResources().getDimension(R.dimen.oui_listitem_content_width_empty)));
        goto L17
    L25:
        Intrinsics.m("mContentElement");
        throw null;
    L27:
        Intrinsics.m("mContentElement");
        throw null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        setShowDivider(this.w);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }

    public final void setAlpha(boolean r1) {
        if (r1 == true) goto L4;
        float r2 = 0.3f;
    L5:
        setAlpha(r2);
        return;
    L4:
        r2 = 1.0f;
        goto L5
    }

    public final void setContentImage(@Nullable Drawable r4) {
        this.t = r4;
        if (r4 == null) goto L17;
        ImageView r2 = this.n;
        if (r2 == null) goto L15;
        r2.setImageDrawable(r4);
        ImageView r5 = this.n;
        if (r5 == null) goto L13;
        r5.setVisibility(0);
        FrameLayout r6 = this.m;
        if (r6 == null) goto L11;
        r6.setVisibility(0);
    L20:
        i();
        return;
    L11:
        Intrinsics.m("mContentElement");
        throw null;
    L13:
        Intrinsics.m("mIvContent");
        throw null;
    L15:
        Intrinsics.m("mIvContent");
        throw null;
    L17:
        ImageView r7 = this.n;
        if (r7 == null) goto L22;
        r7.setVisibility(8);
        goto L20
    L22:
        Intrinsics.m("mIvContent");
        throw null;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        if (r5 == false) goto L17;
        FrameLayout r6 = this.k;
        if (r6 == null) goto L15;
        r6.setAlpha(1.0f);
        ConstraintLayout r7 = this.q;
        if (r7 == null) goto L13;
        r7.setAlpha(1.0f);
        FrameLayout r4 = this.m;
        if (r4 == null) goto L11;
        r4.setAlpha(1.0f);
        return;
    L11:
        Intrinsics.m("mContentElement");
        throw null;
    L13:
        Intrinsics.m("mClContent");
        throw null;
    L15:
        Intrinsics.m("mLeadingElement");
        throw null;
    L17:
        FrameLayout r8 = this.k;
        if (r8 == null) goto L29;
        r8.setAlpha(0.3f);
        ConstraintLayout r9 = this.q;
        if (r9 == null) goto L27;
        r9.setAlpha(0.3f);
        FrameLayout r10 = this.m;
        if (r10 == null) goto L25;
        r10.setAlpha(0.3f);
        return;
    L25:
        Intrinsics.m("mContentElement");
        throw null;
    L27:
        Intrinsics.m("mClContent");
        throw null;
    L29:
        Intrinsics.m("mLeadingElement");
        throw null;
    }

    public final void setLeadingView(@Nullable View r2) {
        if (r2 == null) goto L8;
        FrameLayout r1 = this.k;
        if (r1 == null) goto L6;
        h(r1, r2, null);
        return;
    L6:
        Intrinsics.m("mLeadingElement");
        throw null;
    }

    public final void setMClContent(@NotNull ConstraintLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.q = r2;
    }

    public final void setMContentElement(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.m = r2;
    }

    public final void setMContentElementWidth(float r2) {
        this.x = r2;
        if (r2 == 0.0f) goto L9;
        FrameLayout r1 = this.m;
        if (r1 == null) goto L7;
        IndicatorExternalsKt.b(r1, (int) r2);
        return;
    L7:
        Intrinsics.m("mContentElement");
        throw null;
    }

    public final void setMIvContent(@NotNull ImageView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.n = r2;
    }

    public final void setMLeadingElement(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.k = r2;
    }

    public final void setMTrailingElement(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.l = r2;
    }

    public final void setMTvSubtitle(@NotNull TextView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.p = r2;
    }

    public final void setMTvTitle(@NotNull TextView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.o = r2;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        getAlphaHelper().b(this, r2);
    }

    public final void setShowBackground(boolean r1) {
        setShowPreDefineBackground(r1);
    }

    public final void setShowDivider(final boolean r2) {
        this.w = r2;
        Intrinsics.b(OneShotPreDrawListener.add(this, new OListItemGeneral$showDivider$$inlined$doOnPreDraw$1(this, this, r2)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final void setShowPreDefineBackground(boolean r4) {
        this.v = r4;
        if (getBackground() != null) goto L9;
        ColorDrawable r0 = null;
        if (r4 == false) goto L7;
        r0 = new ColorDrawable(getResources().getColor(R.color.oui_fill_list_item_card, null));
    L7:
        setBackground(r0);
        return;
    }

    public final void setSubTitleString(@Nullable CharSequence r3) {
        this.s = r3;
        if (TextUtils.isEmpty(r3) == false) goto L9;
        TextView r2 = this.p;
        if (r2 == null) goto L7;
        ViewExtensionsKt.d(r2);
        return;
    L7:
        Intrinsics.m("mTvSubtitle");
        throw null;
    L9:
        TextView r4 = this.p;
        if (r4 == null) goto L17;
        ViewExtensionsKt.e(r4);
        TextView r5 = this.p;
        if (r5 == null) goto L15;
        r5.setText(this.s);
        return;
    L15:
        Intrinsics.m("mTvSubtitle");
        throw null;
    L17:
        Intrinsics.m("mTvSubtitle");
        throw null;
    }

    public final void setTitleString(@Nullable CharSequence r1) {
        this.r = r1;
        TextView r0 = this.o;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    L6:
        Intrinsics.m("mTvTitle");
        throw null;
    }

    public final void setTrailingImage(@Nullable Drawable r1) {
        this.u = r1;
        setTrailingImageView(r1);
    }

    public final void setTrailingImageView(@Nullable Drawable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ImageView r0 = new ImageView(getContext());
        r0.setImageDrawable(r3);
        setTrailingView(r0);
    }

    public final void setTrailingView(@Nullable View r3) {
        if (r3 == null) goto L8;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 8388629;
        FrameLayout r2 = this.l;
        if (r2 == null) goto L6;
        h(r2, r3, r0);
        return;
    L6:
        Intrinsics.m("mTrailingElement");
        throw null;
    }
}
