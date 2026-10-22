package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.common.oui.R;
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
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OIconButton extends AppCompatImageView implements IOUIAlpha, IOUILayout, IOUIStyleProvider {
    public final OUILayoutHelper b;
    public final OUIAlphaHelper c;
    public final OUIEffectHelper e;
    public boolean f;
    public final boolean i;
    public int j;
    public float k;
    public final /* synthetic */ OUIAlphaHelper l;
    public final /* synthetic */ OUILayoutHelper m;
    public final /* synthetic */ OUIStyleProvider n;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public OIconButton(@NotNull Context r4, @Nullable AttributeSet r5) {
        OUIStyleProvider r0 = new OUIStyleProvider(r4, r5, 0, 0);
        super(r4, r5, 0);
        this.l = r0.c;
        this.m = r0.b;
        this.n = r0;
        this.k = 1.0f;
        r0.b(this);
        IOUILayout r1 = getLayoutHelper();
        if (r1 == null) goto L11;
        this.b = (OUILayoutHelper) r1;
        IOUIAlpha r2 = getAlphaHelper();
        if (r2 == null) goto L9;
        this.c = (OUIAlphaHelper) r2;
        this.e = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.f152d);
        Intrinsics.e(r6, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.i = r6.getBoolean(2, false);
        this.k = r6.getFloat(4, 1.0f);
        r6.recycle();
        g(isEnabled());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
    }

    private final void setPressState(boolean r2) {
        if (this.f != r2) goto L5;
        return;
    L5:
        this.f = r2;
        OUIEffectHelper r0 = this.e;
        if (r0 == null) goto L8;
        r0.f(r2);
    L8:
        OUIAlphaHelper r1 = this.c;
        if (r1 == null) goto L12;
        r1.f(r2);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean a() {
        this.m.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void b(View r1, boolean r2) {
        this.l.b(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void c(String r1) {
        this.l.c(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void d(int r4) {
        if (this.i == true) goto L5;
        return;
    L5:
        float r5 = RangesKt.a(r4 / 255.0f, 0.0f, 1.0f);
        if (this.j != 0) goto L8;
        this.j = getImageAlpha();
    L8:
        int r0 = this.j;
        if (r0 == 0) goto L13;
        setImageAlpha(RangesKt.b((int) ((1 - (r5 * 0.7f)) * r0), 0, 255));
        return;
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
        this.m.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void f(float r1) {
        this.m.f(r1);
    }

    public final void g(boolean r2) {
        if (r2 == true) goto L6;
        Drawable r3 = getDrawable();
        if (r3 == null) goto L10;
        r3.setAlpha((int) (this.k * 255));
        return;
    L10:
        return;
    L6:
        Drawable r1 = getDrawable();
        if (r1 == null) goto L12;
        r1.setAlpha((int) 255.0f);
        return;
    }

    @NotNull
    public IOUIAlpha getAlphaHelper() {
        return this.n.c;
    }

    @NotNull
    public OUIEffectHelper getEffectHelper() {
        return this.n.a();
    }

    @NotNull
    public IOUILayout getLayoutHelper() {
        return this.n.b;
    }

    public int getRadius() {
        return this.m.G;
    }

    public float getShadowAlpha() {
        return this.m.W;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.m.getShadowColor();
    }

    public int getShadowElevation() {
        return this.m.V;
    }

    public void setBorderColor(@ColorInt int r1) {
        this.m.r(r1);
    }

    public void setBorderWidth(int r1) {
        this.m.s(r1);
    }

    public void setBottomDividerAlpha(int r1) {
        this.m.t(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.l.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r1) {
        this.l.setChangeAlphaWhenPress(r1);
    }

    public void setChangeAlphaWhenSelected(boolean r1) {
        this.l.i = r1;
    }

    public final void setDisabledAlpha(float r1) {
        this.k = r1;
        if (isEnabled() == true) goto L6;
        g(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        OUIAlphaHelper r0 = this.c;
        if (r0 == null) goto L5;
        r0.e(this, r2);
    L5:
        g(r2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r1) {
        this.l.setKeepPressAlpha(r1);
    }

    public void setLeftDividerAlpha(int r1) {
        this.m.u(r1);
    }

    public void setOuterNormalColor(int r1) {
        this.m.v(r1);
    }

    public void setOutlineExcludePadding(boolean r1) {
        this.m.w(r1);
    }

    public void setOverridePressColor(int r1) {
        this.l.k = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        OUIEffectHelper r0 = this.e;
        if (r0 == null) goto L5;
        r0.f(r2);
    L5:
        OUIAlphaHelper r1 = this.c;
        if (r1 == null) goto L9;
        r1.f(r2);
        return;
    }

    public void setRadius(int r1) {
        this.m.x(r1);
    }

    public void setRightDividerAlpha(int r1) {
        this.m.z(r1);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        OUIAlphaHelper r0 = this.c;
        if (r0 == null) goto L6;
        r0.b(this, r2);
        return;
    }

    public void setShadowAlpha(float r1) {
        this.m.B(r1);
    }

    public void setShadowColor(int r1) {
        this.m.C(r1);
    }

    public void setShadowCornerRadius(int r1) {
        this.m.k0 = r1;
    }

    public void setShadowElevation(int r1) {
        this.m.D(r1);
    }

    public void setShadowStyle(@StyleRes int r1) {
        this.m.E(r1);
    }

    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.m.F(r1);
    }

    public void setTopDividerAlpha(int r1) {
        this.m.G(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        this.m.f = r1;
    }
}
