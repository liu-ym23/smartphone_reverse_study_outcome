package com.obric.oui.dialog.v2.common;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ODialogListItemView extends OUIFrameLayout {
    public OUILinearLayout k;
    public FrameLayout l;
    public FrameLayout m;
    public TextView n;
    public TextView o;

    public static void h(ViewGroup r0, View r1, ViewGroup.LayoutParams r2) {
        if (r1 == null) goto L9;
        if (r0 == null) goto L5;
        ViewExtensionsKt.e(r0);
    L5:
        if (r0 == null) goto L7;
        r0.removeAllViews();
    L7:
        if (r0 == null) goto L12;
        r0.addView(r1, r2);
        return;
    L12:
        return;
    L9:
        if (r0 == null) goto L14;
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

    @NotNull
    public final FrameLayout getLeadingContainer() {
        FrameLayout r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("leadingContainer");
        throw null;
    }

    @NotNull
    public final OUILinearLayout getListItemRoot() {
        OUILinearLayout r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("listItemRoot");
        throw null;
    }

    @NotNull
    public final TextView getSubtitleView() {
        TextView r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("subtitleView");
        throw null;
    }

    @NotNull
    public final TextView getTitleView() {
        TextView r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("titleView");
        throw null;
    }

    @NotNull
    public final FrameLayout getTrailingContainer() {
        FrameLayout r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("trailingContainer");
        throw null;
    }

    public final void setLeadingContainer(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.l = r2;
    }

    public final void setListItemRoot(@NotNull OUILinearLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.k = r2;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        getAlphaHelper().b(this, r2);
    }

    public final void setSubtitle(@Nullable CharSequence r2) {
        TextView r1 = this.o;
        if (r1 == null) goto L11;
        if (r2 != null) goto L6;
    L9:
        ViewExtensionsKt.d(r1);
        return;
    L6:
        if (r2.length() == 0) goto L9;
        r1.setText(r2);
        ViewExtensionsKt.e(r1);
        return;
    L11:
        Intrinsics.m("subtitleView");
        throw null;
    }

    public final void setSubtitleView(@NotNull TextView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.o = r2;
    }

    public final void setTitle(@Nullable CharSequence r2) {
        TextView r1 = this.n;
        if (r1 == null) goto L11;
        if (r2 != null) goto L6;
    L9:
        ViewExtensionsKt.d(r1);
        return;
    L6:
        if (r2.length() == 0) goto L9;
        r1.setText(r2);
        ViewExtensionsKt.e(r1);
        return;
    L11:
        Intrinsics.m("titleView");
        throw null;
    }

    public final void setTitleView(@NotNull TextView r2) {
        Intrinsics.f(r2, "<set-?>");
        this.n = r2;
    }

    public final void setTrailingContainer(@NotNull FrameLayout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.m = r2;
    }

    public final void setTrailingImageView(@Nullable Drawable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ImageView r0 = new ImageView(getContext());
        r0.setImageDrawable(r3);
        setTrailingView(r0);
    }

    public final void setTrailingView(@NotNull View r3) {
        Intrinsics.f(r3, "view");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        FrameLayout r2 = this.m;
        if (r2 == null) goto L6;
        h(r2, r3, r0);
        return;
    L6:
        Intrinsics.m("trailingContainer");
        throw null;
    }
}
