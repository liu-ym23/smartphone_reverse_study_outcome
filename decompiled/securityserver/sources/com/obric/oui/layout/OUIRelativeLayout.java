package com.obric.oui.layout;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIEffectHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OUIRelativeLayout extends RelativeLayout implements IOUIAlpha, IOUILayout, IOUIStyleProvider {
    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean a() {
        throw null;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void b(View r1, boolean r2) {
        throw null;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public final void c(String r1) {
        throw null;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void d(int r1) {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.f(r2, "canvas");
        super.dispatchDraw(r2);
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent r2) {
        Intrinsics.f(r2, "event");
        return super.dispatchGenericMotionEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.f(r2, "event");
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.f(r2, "canvas");
        super.draw(r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final boolean e() {
        throw null;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public final void f(float r1) {
        throw null;
    }

    @NotNull
    public IOUIAlpha getAlphaHelper() {
        throw null;
    }

    @NotNull
    public OUIEffectHelper getEffectHelper() {
        throw null;
    }

    @NotNull
    public IOUILayout getLayoutHelper() {
        throw null;
    }

    public int getRadius() {
        throw null;
    }

    public float getShadowAlpha() {
        throw null;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        throw null;
    }

    public int getShadowElevation() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
    }

    public void setBorderColor(@ColorInt int r1) {
        throw null;
    }

    public void setBorderWidth(int r1) {
        throw null;
    }

    public void setBottomDividerAlpha(int r1) {
        throw null;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r1) {
        throw null;
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r1) {
        throw null;
    }

    public void setChangeAlphaWhenSelected(boolean r1) {
        throw null;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r1) {
        throw null;
    }

    public void setLeftDividerAlpha(int r1) {
        throw null;
    }

    public void setOuterNormalColor(int r1) {
        throw null;
    }

    public void setOutlineExcludePadding(boolean r1) {
        throw null;
    }

    public void setOverridePressColor(int r1) {
        throw null;
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
    }

    public void setRadius(int r1) {
        throw null;
    }

    public void setRightDividerAlpha(int r1) {
        throw null;
    }

    @Override // android.view.View
    public void setSelected(boolean r1) {
        super.setSelected(r1);
    }

    public void setShadowAlpha(float r1) {
        throw null;
    }

    public void setShadowColor(int r1) {
        throw null;
    }

    public void setShadowCornerRadius(int r1) {
        throw null;
    }

    public void setShadowElevation(int r1) {
        throw null;
    }

    public void setShadowStyle(@StyleRes int r1) {
        throw null;
    }

    public void setShowBorderOnlyBeforeL(boolean r1) {
        throw null;
    }

    public final void setSoundEffectEnabled(boolean r1) {
    }

    public void setTopDividerAlpha(int r1) {
        throw null;
    }

    public final void setVibrateEnabled(boolean r1) {
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        throw null;
    }
}
