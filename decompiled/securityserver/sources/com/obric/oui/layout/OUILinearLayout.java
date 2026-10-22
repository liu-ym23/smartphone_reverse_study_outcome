package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OUILinearLayout extends LinearLayout implements IOUIAlpha, IOUILayout, IOUIStyleProvider {
    public final OUILayoutHelper b;
    public final OUIAlphaHelper c;
    public final OUIEffectHelper e;
    public final /* synthetic */ OUIAlphaHelper f;
    public final /* synthetic */ OUILayoutHelper i;
    public final /* synthetic */ OUIStyleProvider j;

    @JvmOverloads
    public OUILinearLayout(@NotNull Context r3, @Nullable AttributeSet r4) {
        OUIStyleProvider r0 = new OUIStyleProvider(r3, r4, 0, 0);
        super(r3, r4);
        this.f = r0.c;
        this.i = r0.b;
        this.j = r0;
        r0.b(this);
        IOUILayout r5 = getLayoutHelper();
        if (r5 == null) goto L11;
        this.b = (OUILayoutHelper) r5;
        IOUIAlpha r6 = getAlphaHelper();
        if (r6 == null) goto L9;
        this.c = (OUIAlphaHelper) r6;
        this.e = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean a() {
        this.i.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void b(View r1, boolean r2) {
        this.f.b(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void c(String r1) {
        this.f.c(r1);
    }

    public void d(int r1) {
        this.i.getClass();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r3) {
        Intrinsics.f(r3, "canvas");
        super.dispatchDraw(r3);
        OUILayoutHelper r0 = this.b;
        if (r0 == null) goto L5;
        r0.h(r3, getWidth(), getHeight());
    L5:
        if (r0 == null) goto L8;
        r0.c(r3);
        return;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent r2) {
        Intrinsics.f(r2, "event");
        if (this.e == null) goto L6;
        boolean r0 = OUIEffectHelper.f;
        OUIEffectHelper.k = r2.getDeviceId();
    L6:
        return super.dispatchGenericMotionEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.f(r2, "event");
        if (this.e == null) goto L6;
        boolean r0 = OUIEffectHelper.f;
        OUIEffectHelper.k = r2.getDeviceId();
    L6:
        if (this.c == null) goto L9;
        r2.getAction();
    L9:
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        Intrinsics.f(r2, "canvas");
        OUILayoutHelper r0 = this.b;
        if (r0 == null) goto L5;
        r0.g(r2);
    L5:
        super.draw(r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean e() {
        this.i.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void f(float r1) {
        this.i.f(r1);
    }

    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.j.c;
    }

    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.j.a();
    }

    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.j.b;
    }

    public int getRadius() {
        return this.i.G;
    }

    public float getShadowAlpha() {
        return this.i.W;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.i.getShadowColor();
    }

    public int getShadowElevation() {
        return this.i.V;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onHoverChanged(boolean r1) {
        super.onHoverChanged(r1);
        OUIEffectHelper r0 = this.e;
        if (r0 == null) goto L6;
        r0.d(r1);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        OUILayoutHelper r0 = this.b;
        if (r0 == null) goto L8;
        Intrinsics.c(r0);
        int r6 = r0.l(r4);
        Intrinsics.c(r0);
        int r7 = r0.k(r5);
        super.onMeasure(r6, r7);
        Intrinsics.c(r0);
        int r1 = r0.o(r6, getMeasuredWidth());
        Intrinsics.c(r0);
        int r2 = r0.n(r7, getMeasuredHeight());
        if (r6 != r1) goto L7;
        if (r7 != r2) goto L7;
        return;
    L7:
        super.onMeasure(r1, r2);
        return;
    L8:
        super.onMeasure(r4, r5);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        OUIEffectHelper r0 = this.e;
        if (r0 == null) goto L6;
        r0.e(r1);
        return;
    }

    public void setBorderColor(@ColorInt int r1) {
        this.i.r(r1);
    }

    public void setBorderWidth(int r1) {
        this.i.s(r1);
    }

    public void setBottomDividerAlpha(int r1) {
        this.i.t(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.f.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r1) {
        this.f.setChangeAlphaWhenPress(r1);
    }

    public void setChangeAlphaWhenSelected(boolean r1) {
        this.f.i = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        OUIAlphaHelper r0 = this.c;
        if (r0 == null) goto L6;
        r0.e(this, r2);
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r1) {
        this.f.setKeepPressAlpha(r1);
    }

    public void setLeftDividerAlpha(int r1) {
        this.i.u(r1);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r2) {
        OUILayoutHelper r0 = this.b;
        if (r0 == null) goto L5;
        r0.i = r2;
    L5:
        super.setMinimumHeight(r2);
    }

    public void setOuterNormalColor(int r1) {
        this.i.v(r1);
    }

    public void setOutlineExcludePadding(boolean r1) {
        this.i.w(r1);
    }

    public void setOverridePressColor(int r1) {
        this.f.k = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        OUIEffectHelper r0 = this.e;
        if (r0 == null) goto L5;
        r0.f(r2);
    L5:
        super.setPressed(r2);
        OUIAlphaHelper r1 = this.c;
        if (r1 == null) goto L9;
        r1.f(r2);
        return;
    }

    public void setRadius(int r1) {
        this.i.x(r1);
    }

    public void setRightDividerAlpha(int r1) {
        this.i.z(r1);
    }

    @Override // android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        OUIAlphaHelper r0 = this.c;
        if (r0 == null) goto L6;
        r0.b(this, r2);
        return;
    }

    public void setShadowAlpha(float r1) {
        this.i.B(r1);
    }

    public void setShadowColor(int r1) {
        this.i.C(r1);
    }

    public void setShadowCornerRadius(int r1) {
        this.i.k0 = r1;
    }

    public void setShadowElevation(int r1) {
        this.i.D(r1);
    }

    public void setShadowStyle(@StyleRes int r1) {
        this.i.E(r1);
    }

    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.i.F(r1);
    }

    public final void setSoundEffectEnabled(boolean r1) {
        OUIEffectHelper r0 = this.e;
        if (r0 == null) goto L6;
        r0.f197d = r1;
        return;
    }

    public void setTopDividerAlpha(int r1) {
        this.i.G(r1);
    }

    public final void setVibrateEnabled(boolean r1) {
        OUIEffectHelper r0 = this.e;
        if (r0 == null) goto L6;
        r0.c = r1;
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        this.i.f = r1;
    }
}
