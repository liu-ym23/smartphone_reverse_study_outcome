package com.obric.oui.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import com.bytedance.securityserver.R;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.ss.android.common.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"AppCompatCustomView"})
public class OTextView extends TextView implements IOUIAlpha, IOUILayout, IOUIStyleProvider {
    public final OUILayoutHelper b;
    public final OUIAlphaHelper c;
    public final OUIEffectHelper e;
    public final int f;
    public boolean i;
    public final /* synthetic */ OUIAlphaHelper j;
    public final /* synthetic */ OUILayoutHelper k;
    public final /* synthetic */ OUIStyleProvider l;

    @JvmOverloads
    public OTextView(@NotNull Context r3, @Nullable AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean a() {
        this.k.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void b(View r1, boolean r2) {
        this.j.b(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void c(String r1) {
        this.j.c(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void d(int r1) {
        this.k.getClass();
    }

    @Override // android.view.View
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
    public final void draw(Canvas r2) {
        Intrinsics.f(r2, "canvas");
        OUILayoutHelper r0 = this.b;
        if (r0 == null) goto L5;
        r0.g(r2);
    L5:
        super.draw(r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean e() {
        this.k.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void f(float r1) {
        this.k.f(r1);
    }

    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.l.c;
    }

    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.l.a();
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.i;
    }

    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.l.b;
    }

    public int getRadius() {
        return this.k.G;
    }

    public float getShadowAlpha() {
        return this.k.W;
    }

    @Override // android.widget.TextView, com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.k.getShadowColor();
    }

    public int getShadowElevation() {
        return this.k.V;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.i == false) goto L16;
        int r6 = 1;
        if (getLineCount() > 1) goto L7;
        boolean r7 = true;
    L8:
        int r8 = this.f & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r7 == true) goto L12;
        r6 = 3;
    L12:
        int r9 = r8 | r6;
        if (getGravity() == r9) goto L17;
        setGravity(r9);
        return;
    L17:
        return;
    L7:
        r7 = false;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public void setBorderColor(@ColorInt int r1) {
        this.k.r(r1);
    }

    public void setBorderWidth(int r1) {
        this.k.s(r1);
    }

    public void setBottomDividerAlpha(int r1) {
        this.k.t(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.j.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r1) {
        this.j.setChangeAlphaWhenPress(r1);
    }

    public void setChangeAlphaWhenSelected(boolean r1) {
        this.j.i = r1;
    }

    public final void setEnableAutoAlignLeft(boolean r2) {
        if (this.i == r2) goto L6;
        this.i = r2;
        requestLayout();
        return;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r1) {
        this.j.setKeepPressAlpha(r1);
    }

    public void setLeftDividerAlpha(int r1) {
        this.k.u(r1);
    }

    public void setOuterNormalColor(int r1) {
        this.k.v(r1);
    }

    public void setOutlineExcludePadding(boolean r1) {
        this.k.w(r1);
    }

    public void setOverridePressColor(int r1) {
        this.j.k = r1;
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
        this.k.x(r1);
    }

    public void setRightDividerAlpha(int r1) {
        this.k.z(r1);
    }

    public void setShadowAlpha(float r1) {
        this.k.B(r1);
    }

    public void setShadowColor(int r1) {
        this.k.C(r1);
    }

    public void setShadowCornerRadius(int r1) {
        this.k.k0 = r1;
    }

    public void setShadowElevation(int r1) {
        this.k.D(r1);
    }

    public void setShadowStyle(@StyleRes int r1) {
        this.k.E(r1);
    }

    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.k.F(r1);
    }

    public void setTopDividerAlpha(int r1) {
        this.k.G(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        this.k.f = r1;
    }

    public OTextView(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        OUIStyleProvider r7 = new OUIStyleProvider(r3, r4, r5, 0);
        Intrinsics.f(r3, "context");
        super(r3, r4, r5);
        this.j = r7.c;
        this.k = r7.b;
        this.l = r7;
        this.f = getGravity();
        r7.b(this);
        IOUILayout r8 = getLayoutHelper();
        if (r8 == null) goto L17;
        this.b = (OUILayoutHelper) r8;
        IOUIAlpha r9 = getAlphaHelper();
        if (r9 == null) goto L15;
        OUIAlphaHelper r10 = (OUIAlphaHelper) r9;
        this.c = r10;
        this.e = getEffectHelper();
        r10.setChangeAlphaWhenPress(false);
        r10.setChangeAlphaWhenDisable(false);
        setHighlightColor(r3.getColor(R.color.oui_text_highlight_color));
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    }
}
