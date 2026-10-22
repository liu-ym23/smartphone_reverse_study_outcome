package com.obric.oui.segmentedtab;

import a.a;
import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OTabSegmentedLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public static final /* synthetic */ int q = 0;
    public int b;
    public int c;
    public int e;
    public long f;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public List n;
    public TabSelectListener o;
    public TabSelectAnimListener p;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class IndicatorPoint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f277a;
        public float b;

        public final String toString() {
            return "(left = " + this.f277a + ", right = " + this.b + ')';
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
            float r1 = r5.f277a;
            float r7 = a.a(r6.f277a, r1, r2, r1);
            float r8 = r5.b;
            float r9 = a.a(r6.b, r8, r2, r8);
            IndicatorPoint r10 = new IndicatorPoint();
            r10.f277a = r7;
            r10.b = r9;
            return r10;
        }
    }

    @Metadata
    public interface TabSelectAnimListener {
        void a();

        void b();

        void c();
    }

    @Metadata
    public interface TabSelectListener {
    }

    private final void setFragments(int r1) {
    }

    @Nullable
    public final Fragment getCurrentFragment() {
        return null;
    }

    public final int getCurrentTab() {
        return this.b;
    }

    public final int getDividerColor() {
        return this.j;
    }

    public final float getDividerPadding() {
        return 0.0f;
    }

    public final float getDividerWidth() {
        return 0.0f;
    }

    public final long getIndicatorAnimDuration() {
        return this.f;
    }

    public final int getIndicatorColor() {
        return this.e;
    }

    public final float getIndicatorCornerRadius() {
        return 0.0f;
    }

    public final float getIndicatorHeight() {
        return 0.0f;
    }

    public final float getIndicatorSpacing() {
        return 0.0f;
    }

    public final int getTabCount() {
        return 0;
    }

    @NotNull
    public final List<View> getTabList() {
        return this.n;
    }

    public final float getTabPadding() {
        return 0.0f;
    }

    public final float getTabWidth() {
        return 0.0f;
    }

    public final int getTextBold() {
        return this.m;
    }

    public final int getTextSelectColor() {
        return this.k;
    }

    public final int getTextUnselectColor() {
        return this.l;
    }

    public final float getTextsize() {
        return 0.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.f(r2, "animation");
        TabSelectAnimListener r1 = this.p;
        if (r1 == null) goto L6;
        r1.c();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.f(r2, "animation");
        TabSelectAnimListener r1 = this.p;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
        Intrinsics.f(r1, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.f(r2, "animation");
        TabSelectAnimListener r1 = this.p;
        if (r1 == null) goto L6;
        r1.a();
        return;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r1) {
        Intrinsics.f(r1, "animation");
        Object r0 = r1.getAnimatedValue();
        if (r0 == null) goto L5;
        IndicatorPoint r2 = (IndicatorPoint) r0;
        throw null;
    L5:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout.IndicatorPoint");
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

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        Intrinsics.f(r2, "state");
        if ((r2 instanceof Bundle) == false) goto L9;
        Bundle r3 = (Bundle) r2;
        this.b = r3.getInt("mCurrentTab");
        r2 = r3.getParcelable("instanceState");
        if (this.b == 0) goto L9;
        throw null;
    L9:
        super.onRestoreInstanceState(r2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        r0.putInt("mCurrentTab", this.b);
        return r0;
    }

    public final void setCurrentTab(int r3) {
        int r0 = this.b;
        if (r3 != r0) goto L5;
        return;
    L5:
        this.c = r0;
        this.b = r3;
        StringBuilder r1 = a.p(r3, "setCurrentTab, currentTab: ", ", lastTab: ");
        r1.append(this.c);
        Log.d("OTabSegmentedLayout", r1.toString());
        setFragments(r3);
        if (this.i == true) goto L10;
        invalidate();
        return;
    L10:
        throw null;
    }

    public final void setDividerColor(int r1) {
        this.j = r1;
        invalidate();
    }

    public final void setDividerPadding(float r1) {
        throw null;
    }

    public final void setDividerWidth(float r1) {
        throw null;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        Iterator r1 = this.n.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((View) r1.next()).setEnabled(r2);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r1) {
        this.f = r1;
    }

    public final void setIndicatorAnimEnable(boolean r1) {
        this.i = r1;
    }

    public final void setIndicatorBounceEnable(boolean r1) {
    }

    public final void setIndicatorColor(int r1) {
        this.e = r1;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r1) {
        throw null;
    }

    public final void setIndicatorHeight(float r1) {
        throw null;
    }

    public final void setOnTabSelectAnimListener(@Nullable TabSelectAnimListener r1) {
        this.p = r1;
    }

    public final void setOnTabSelectListener(@Nullable TabSelectListener r1) {
        this.o = r1;
    }

    public final void setTabList(@NotNull List<View> r2) {
        Intrinsics.f(r2, "<set-?>");
        this.n = r2;
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
        this.m = r1;
    }

    public final void setTextSelectColor(int r1) {
        this.k = r1;
    }

    public final void setTextUnselectColor(int r1) {
        this.l = r1;
    }

    public final void setTextsize(float r1) {
        throw null;
    }
}
