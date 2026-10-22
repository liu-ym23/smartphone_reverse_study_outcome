package com.obric.oui.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"AppCompatCustomView"})
public class OButton extends Button implements IOUIAlpha, IOUILayout, IOUIStyleProvider {
    public final OUIAlphaHelper b;
    public final OUIEffectHelper c;
    public Drawable e;
    public final int f;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public final boolean m;
    public final int n;
    public float o;
    public boolean p;
    public final /* synthetic */ OUIAlphaHelper q;
    public final /* synthetic */ OUILayoutHelper r;
    public final /* synthetic */ OUIStyleProvider s;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public OButton(@NotNull Context r7, @Nullable AttributeSet r8) {
        OUIStyleProvider r0 = new OUIStyleProvider(r7, r8, 0, 0);
        super(r7, r8, 0);
        this.q = r0.c;
        OUILayoutHelper r2 = r0.b;
        this.r = r2;
        this.s = r0;
        this.o = 1.0f;
        if (r2 == null) goto L21;
        r2.h0 = true;
        r0.b(this);
        IOUILayout r1 = getLayoutHelper();
        if (r1 == null) goto L19;
        OUILayoutHelper r3 = (OUILayoutHelper) r1;
        IOUIAlpha r4 = getAlphaHelper();
        if (r4 == null) goto L17;
        this.b = (OUIAlphaHelper) r4;
        this.c = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.f152d);
        Intrinsics.e(r9, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.f = r9.getResourceId(0, -1);
        setMImageTintColorId(r9.getResourceId(1, -1));
        int r10 = this.f;
        if (r10 < 0) goto L11;
        setButtonSourceBitmap(r10);
    L11:
        setTextAppearance(r9.getResourceId(3, com.bytedance.securityserver.R.style.Title_Title_M_Thick));
        this.m = r9.getBoolean(2, false);
        int r11 = getCurrentTextColor();
        this.k = r11;
        ColorStateList r12 = ColorStateList.valueOf(r11);
        Intrinsics.e(r12, "ColorStateList.valueOf(textColor)");
        setCompoundDrawableTintList(r12);
        this.n = r9.getDimensionPixelSize(5, 0);
        Drawable[] r13 = getCompoundDrawables();
        Intrinsics.e(r13, "getCompoundDrawables()");
        if (((Drawable) ArraysKt.n(r13, 0)) == null) goto L14;
        g(true);
    L14:
        this.o = r9.getFloat(4, 1.0f);
        r9.recycle();
        h(isEnabled());
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    }

    private final void setPressState(boolean r2) {
        if (this.j != r2) goto L6;
        L.g("OButton", "setPressState, already set, skip! pressed: " + r2);
        return;
    L6:
        this.j = r2;
        OUIEffectHelper r0 = this.c;
        if (r0 == null) goto L9;
        r0.f(r2);
    L9:
        OUIAlphaHelper r1 = this.b;
        if (r1 == null) goto L13;
        r1.f(r2);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean a() {
        this.r.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void b(View r1, boolean r2) {
        this.q.b(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void c(String r1) {
        this.q.c(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void d(int r13) {
        if (this.m == true) goto L5;
        return;
    L5:
        float r14 = RangesKt.a(r13 / 255.0f, 0.0f, 1.0f);
        int r0 = this.k;
        if (r0 == 0) goto L9;
        int r6 = (r0 >> 24) & 255;
        int r9 = RangesKt.b((int) ((1 - (r14 * 0.7f)) * r6), 0, 255);
        int r7 = ((r0 >> 16) & 255) << 16;
        setTextColor((r0 & 255) | ((r7 | (r9 << 24)) | (((r0 >> 8) & 255) << 8)));
        L.a("OButton", "updateTextColorOnPress, fraction: " + r14 + ", newTextAlpha: " + r9 + ", originTextAlpha: " + r6);
    L9:
        int r1 = this.l;
        if (r1 == 0) goto L17;
        int r2 = RangesKt.b((int) ((1 - (0.7f * r14)) * r1), 0, 255);
        Drawable r3 = this.e;
        if (r3 == null) goto L15;
        r3.setAlpha(r2);
    L15:
        L.a("OButton", "updateIconAlphaOnPress, fraction: " + r14 + ", alpha: " + r2 + ", originIconAlpha: " + this.l);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean e() {
        this.r.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void f(float r1) {
        this.r.f(r1);
    }

    public final void g(boolean r5) {
        int r0 = getPaddingTop();
        int r1 = getPaddingRight();
        int r2 = getPaddingBottom();
        if (r5 == false) goto L5;
        int r6 = getPaddingRight() - this.n;
    L7:
        if (r6 == getPaddingLeft()) goto L10;
        setPadding(r6, r0, r1, r2);
        return;
    L10:
        return;
    L5:
        r6 = getPaddingRight();
        goto L7
    }

    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.s.c;
    }

    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.s.a();
    }

    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.s.b;
    }

    @Nullable
    public final Drawable getMIcon() {
        return this.e;
    }

    public final int getMImageTintColorId() {
        return this.i;
    }

    public int getRadius() {
        return this.r.G;
    }

    public float getShadowAlpha() {
        return this.r.W;
    }

    @Override // android.widget.TextView, com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.r.getShadowColor();
    }

    public int getShadowElevation() {
        return this.r.V;
    }

    public final void h(boolean r6) {
        int r0 = this.k;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r2 = 0;
        if (r6 == true) goto L12;
        int r7 = ViewUtil.a(r0, this.o);
        this.p = true;
        super.setTextColor(r7);
        this.p = false;
        Drawable[] r8 = getCompoundDrawables();
        Intrinsics.e(r8, "compoundDrawables");
        int r1 = r8.length;
    L8:
        if (r2 >= r1) goto L17;
        Drawable r3 = r8[r2];
        r2 = r2 + 1;
        if (r3 == null) goto L8;
        r3.setAlpha((int) (this.o * 255));
    L17:
        invalidate();
        return;
    L12:
        this.p = true;
        super.setTextColor(r0);
        this.p = false;
        Drawable[] r9 = getCompoundDrawables();
        Intrinsics.e(r9, "compoundDrawables");
        int r4 = r9.length;
    L13:
        if (r2 >= r4) goto L17;
        Drawable r5 = r9[r2];
        r2 = r2 + 1;
        if (r5 == null) goto L13;
        r5.setAlpha((int) 255.0f);
        goto L13
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.f(r6, "canvas");
        super.onDraw(r6);
        Drawable r0 = this.e;
        if (r0 == null) goto L9;
        int r1 = (getWidth() - r0.getIntrinsicWidth()) / 2;
        int r2 = (getHeight() - r0.getIntrinsicHeight()) / 2;
        r0.setBounds(r1, r2, r0.getIntrinsicWidth() + r1, r0.getIntrinsicHeight() + r2);
        if (this.i <= 0) goto L7;
        r0.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.i), PorterDuff.Mode.SRC_IN));
    L7:
        r0.draw(r6);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        Drawable r0 = this.e;
        if (r0 == null) goto L5;
        int r1 = r0.getIntrinsicWidth();
        int r2 = getPaddingLeft() + r1;
        r6 = Math.max(r6, getPaddingRight() + r2);
        int r3 = r0.getIntrinsicHeight();
        int r8 = getPaddingTop() + r3;
        r7 = Math.max(r7, getPaddingBottom() + r8);
    L5:
        setMeasuredDimension(r6, r7);
    }

    public void setBorderColor(@ColorInt int r1) {
        this.r.r(r1);
    }

    public void setBorderWidth(int r1) {
        this.r.s(r1);
    }

    public void setBottomDividerAlpha(int r1) {
        this.r.t(r1);
    }

    public final void setButtonSourceBitmap(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.getDrawable(getContext(), r2));
        Drawable r3 = this.e;
        if (r3 == null) goto L7;
        int r4 = r3.getAlpha();
    L8:
        this.l = r4;
        invalidate();
        return;
    L7:
        r4 = 0;
        goto L8
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.q.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r1) {
        this.q.setChangeAlphaWhenPress(r1);
    }

    public void setChangeAlphaWhenSelected(boolean r1) {
        this.q.i = r1;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        g(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        g(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void setDisabledTextAlpha(float r1) {
        this.o = r1;
        if (isEnabled() == true) goto L6;
        h(false);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        OUIAlphaHelper r0 = this.b;
        if (r0 == null) goto L5;
        r0.e(this, r2);
    L5:
        h(r2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r1) {
        this.q.setKeepPressAlpha(r1);
    }

    public void setLeftDividerAlpha(int r1) {
        this.r.u(r1);
    }

    public final void setMIcon(@Nullable Drawable r1) {
        this.e = r1;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r1) {
        this.i = r1;
        invalidate();
    }

    public void setOuterNormalColor(int r1) {
        this.r.v(r1);
    }

    public void setOutlineExcludePadding(boolean r1) {
        this.r.w(r1);
    }

    public void setOverridePressColor(int r1) {
        this.q.k = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        OUIEffectHelper r0 = this.c;
        if (r0 == null) goto L5;
        r0.f(r2);
    L5:
        OUIAlphaHelper r1 = this.b;
        if (r1 == null) goto L9;
        r1.f(r2);
        return;
    }

    public void setRadius(int r1) {
        this.r.x(r1);
    }

    public void setRightDividerAlpha(int r1) {
        this.r.z(r1);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        OUIAlphaHelper r0 = this.b;
        if (r0 == null) goto L6;
        r0.b(this, r2);
        return;
    }

    public void setShadowAlpha(float r1) {
        this.r.B(r1);
    }

    public void setShadowColor(int r1) {
        this.r.C(r1);
    }

    public void setShadowCornerRadius(int r1) {
        this.r.k0 = r1;
    }

    public void setShadowElevation(int r1) {
        this.r.D(r1);
    }

    public void setShadowStyle(@StyleRes int r1) {
        this.r.E(r1);
    }

    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.r.F(r1);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r2) {
        if (this.p == true) goto L5;
        this.k = r2;
    L5:
        super.setTextColor(r2);
    }

    public void setTopDividerAlpha(int r1) {
        this.r.G(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        this.r.f = r1;
    }
}
