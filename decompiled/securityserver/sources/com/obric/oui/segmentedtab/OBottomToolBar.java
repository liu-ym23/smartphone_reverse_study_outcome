package com.obric.oui.segmentedtab;

import a.a;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBottomToolBar extends OUIFrameLayout implements ValueAnimator.AnimatorUpdateListener {
    public static final /* synthetic */ int t = 0;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public AnimationManager p;
    public AnimationManager q;
    public List r;
    public TabSelectListener s;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class IndicatorPoint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f276a;
        public float b;

        public final String toString() {
            return "(left = " + this.f276a + ", right = " + this.b + ')';
        }
    }

    @Metadata
    public final class PointEvaluator implements TypeEvaluator<IndicatorPoint> {
        @Override // android.animation.TypeEvaluator
        public final IndicatorPoint evaluate(float r2, IndicatorPoint r3, IndicatorPoint r4) {
            IndicatorPoint r5 = r3;
            IndicatorPoint r6 = r4;
            Intrinsics.f(r5, "startValue");
            Intrinsics.f(r6, "endValue");
            float r1 = r5.f276a;
            float r7 = a.a(r6.f276a, r1, r2, r1);
            float r8 = r5.b;
            float r9 = a.a(r6.b, r8, r2, r8);
            IndicatorPoint r10 = new IndicatorPoint();
            r10.f276a = r7;
            r10.b = r9;
            return r10;
        }
    }

    @Metadata
    public interface TabSelectListener {
    }

    public static final List h(OBottomToolBar r1, float r2) {
        r1.getClass();
        RangesKt.a((r2 - 0.0f) / 0.0f, 0.0f, 1.0f);
        return null;
    }

    private final void setFragments(int r1) {
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.f(r3, "event");
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        i(false);
    L11:
        return super.dispatchTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L9:
        i(true);
        goto L11
    }

    @Nullable
    public final Fragment getCurrentFragment() {
        return null;
    }

    public final int getCurrentTab() {
        return this.k;
    }

    public final int getDividerColor() {
        return this.l;
    }

    public final float getDividerPadding() {
        return 0.0f;
    }

    public final float getDividerWidth() {
        return 0.0f;
    }

    public final int getTabCount() {
        return 0;
    }

    @NotNull
    public final List<View> getTabList() {
        return this.r;
    }

    public final float getTabPadding() {
        return 0.0f;
    }

    public final float getTabWidth() {
        return 0.0f;
    }

    public final int getTextBold() {
        return this.o;
    }

    public final int getTextSelectColor() {
        return this.m;
    }

    public final int getTextUnselectColor() {
        return this.n;
    }

    public final float getTextsize() {
        return 0.0f;
    }

    public final void i(boolean r12) {
        AnimationManager r0 = this.p;
        if (r0 == null) goto L5;
        int r2 = AnimationManager.f122d;
        r0.a(false);
    L5:
        AnimationManager r1 = this.q;
        if (r1 == null) goto L8;
        int r3 = AnimationManager.f122d;
        r1.a(false);
    L8:
        AnimationProperty.FloatProperty r4 = AnimationProperty.FloatProperty.e;
        AnimationProperty.FloatProperty r6 = AnimationProperty.FloatProperty.c;
        if (r12 == false) goto L11;
        PropertyAnimatable.Builder r13 = PropertyAnimatableKt.a(this);
        Float r7 = Float.valueOf(getScaleX());
        FloatSpringSpec r9 = AnimationSpecKt.a();
        r9.b = 0.0f;
        r13.b(r6, r7, 0.0f, r9, null);
        Float r5 = Float.valueOf(getScaleY());
        FloatSpringSpec r8 = AnimationSpecKt.a();
        r8.b = 0.0f;
        r13.b(r4, r5, 0.0f, r8, null);
        r13.f105d = new OBottomToolBar$doPressAnim$$inlined$let$lambda$1(this);
        this.p = PropertyAnimatable.a(r13.a());
        return;
    L11:
        PropertyAnimatable.Builder r14 = PropertyAnimatableKt.a(this);
        Float r10 = Float.valueOf(getScaleX());
        FloatSpringSpec r11 = AnimationSpecKt.a();
        r11.b = 0.0f;
        r14.b(r6, r10, 0.0f, r11, null);
        Float r15 = Float.valueOf(getScaleY());
        FloatSpringSpec r16 = AnimationSpecKt.a();
        r16.b = 0.0f;
        r14.b(r4, r15, 0.0f, r16, null);
        r14.f105d = new OBottomToolBar$doPressAnim$$inlined$let$lambda$2(this);
        this.q = PropertyAnimatable.a(r14.a());
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r1) {
        Intrinsics.f(r1, "p0");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.f(r2, "canvas");
        super.onDraw(r2);
        isInEditMode();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        Intrinsics.f(r2, "state");
        if ((r2 instanceof Bundle) == false) goto L9;
        Bundle r3 = (Bundle) r2;
        this.k = r3.getInt("mCurrentTab");
        r2 = r3.getParcelable("instanceState");
        if (this.k == 0) goto L9;
        throw null;
    L9:
        super.onRestoreInstanceState(r2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        r0.putInt("mCurrentTab", this.k);
        return r0;
    }

    public final void setCurrentTab(int r2) {
        if (r2 != this.k) goto L5;
        return;
    L5:
        this.k = r2;
        setFragments(r2);
    }

    public final void setDividerColor(int r1) {
        this.l = r1;
        invalidate();
    }

    public final void setDividerPadding(float r1) {
        throw null;
    }

    public final void setDividerWidth(float r1) {
        throw null;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        Iterator r1 = this.r.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((View) r1.next()).setEnabled(r2);
        goto L4
    }

    public final void setOnTabSelectListener(@Nullable TabSelectListener r1) {
        this.s = r1;
    }

    public final void setTabList(@NotNull List<View> r2) {
        Intrinsics.f(r2, "<set-?>");
        this.r = r2;
    }

    public final void setTabPadding(float r1) {
        throw null;
    }

    public final void setTabSpaceEqual(boolean r1) {
    }

    public final void setTabWidth(float r1) {
        throw null;
    }

    public final void setTextAllCaps(boolean r1) {
    }

    public final void setTextBold(int r1) {
        this.o = r1;
    }

    public final void setTextSelectColor(int r1) {
        this.m = r1;
    }

    public final void setTextUnselectColor(int r1) {
        this.n = r1;
    }

    public final void setTextsize(float r1) {
        throw null;
    }
}
