package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OIconButtonFloating extends OShadowFrame {
    public AppCompatImageView u;

    @JvmOverloads
    public OIconButtonFloating(@NotNull Context r2, @Nullable AttributeSet r3) {
        Intrinsics.f(r2, "context");
        super(r2, r3, 0);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void j(Context r4, FrameLayout r5, TypedArray r6) {
        Intrinsics.f(r4, "context");
        Intrinsics.f(r5, "contentView");
        ColorStateList r0 = r6.getColorStateList(15);
        Drawable r7 = r6.getDrawable(2);
        AppCompatImageView r1 = new AppCompatImageView(r4);
        this.u = r1;
        r1.setDuplicateParentStateEnabled(true);
        if (r7 == null) goto L15;
        AppCompatImageView r2 = this.u;
        if (r2 == null) goto L13;
        r2.setImageDrawable(r7);
        if (r0 == null) goto L15;
        AppCompatImageView r8 = this.u;
        if (r8 == null) goto L11;
        r8.setImageTintList(r0);
        goto L15
    L11:
        Intrinsics.m("iconView");
        throw null;
    L13:
        Intrinsics.m("iconView");
        throw null;
    L15:
        View r3 = this.u;
        if (r3 == null) goto L19;
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, -1);
        r9.gravity = 17;
        r5.addView(r3, r9);
        return;
    L19:
        Intrinsics.m("iconView");
        throw null;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void k(boolean r3) {
        super.k(r3);
        if (r3 == false) goto L9;
        AppCompatImageView r2 = this.u;
        if (r2 == null) goto L7;
        r2.setAlpha(1.0f);
        return;
    L7:
        Intrinsics.m("iconView");
        throw null;
    L9:
        AppCompatImageView r4 = this.u;
        if (r4 == null) goto L13;
        r4.setAlpha(0.3f);
        return;
    L13:
        Intrinsics.m("iconView");
        throw null;
    }

    public final void setIcon(int r1) {
        AppCompatImageView r0 = this.u;
        if (r0 == null) goto L6;
        r0.setImageResource(r1);
        return;
    L6:
        Intrinsics.m("iconView");
        throw null;
    }

    public final void setIconBgColor(@ColorInt int r1) {
        setBgColor(r1);
    }

    public final void setIconTintColor(@ColorInt int r1) {
        AppCompatImageView r0 = this.u;
        if (r0 == null) goto L6;
        r0.setColorFilter(r1);
        return;
    L6:
        Intrinsics.m("iconView");
        throw null;
    }

    public final void setIcon(@NotNull Drawable r2) {
        Intrinsics.f(r2, "drawable");
        AppCompatImageView r1 = this.u;
        if (r1 == null) goto L6;
        r1.setImageDrawable(r2);
        return;
    L6:
        Intrinsics.m("iconView");
        throw null;
    }

    public final void setIconTintColor(@NotNull ColorStateList r2) {
        Intrinsics.f(r2, TypedValues.Custom.S_COLOR);
        AppCompatImageView r1 = this.u;
        if (r1 == null) goto L6;
        r1.setImageTintList(r2);
        return;
    L6:
        Intrinsics.m("iconView");
        throw null;
    }
}
