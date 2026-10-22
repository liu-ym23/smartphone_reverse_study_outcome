package com.obric.oui.segmentedtab;

import a.a;
import android.R;
import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBottomNavActionBar extends OUIFrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public static final /* synthetic */ int S = 0;
    public float A;
    public int B;
    public int C;
    public int D;
    public final ValueAnimator E;
    public final PathInterpolator F;
    public AnimationManager G;
    public AnimationManager H;
    public final float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final float f274J;
    public final float K;
    public float L;
    public final float M;
    public List N;
    public TabSelectListener O;
    public TabSelectAnimListener P;
    public final IndicatorPoint Q;
    public final IndicatorPoint R;
    public final Context k;
    public final LinearLayout l;
    public int m;
    public int n;
    public final Rect o;
    public float p;
    public float q;
    public int r;
    public float s;
    public float t;
    public long u;
    public boolean v;
    public boolean w;
    public int x;
    public float y;
    public float z;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class IndicatorPoint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f275a;
        public float b;

        public final String toString() {
            return "(left = " + this.f275a + ", right = " + this.b + ')';
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
            float r1 = r5.f275a;
            float r7 = a.a(r6.f275a, r1, r2, r1);
            float r8 = r5.b;
            float r9 = a.a(r6.b, r8, r2, r8);
            IndicatorPoint r10 = new IndicatorPoint();
            r10.f275a = r7;
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

    @JvmOverloads
    public OBottomNavActionBar(@NotNull Context r9, @Nullable AttributeSet r10) {
        Intrinsics.f(r9, "context");
        super(r9, r10, 0, 8);
        this.o = new Rect();
        new Rect();
        new Paint();
        new Paint(1);
        this.u = 350;
        this.v = true;
        this.F = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        new Paint(1).setStyle(Paint.Style.FILL);
        new Paint(1).setStyle(Paint.Style.STROKE);
        new RectF();
        new RectF();
        this.I = 0.988f;
        this.f274J = 0.01f;
        this.K = 1.0f;
        this.M = 0.85f;
        this.N = new ArrayList();
        new Paint(1);
        new SparseArray();
        IndicatorPoint r0 = new IndicatorPoint();
        this.Q = r0;
        IndicatorPoint r3 = new IndicatorPoint();
        this.R = r3;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.k = r9;
        this.l = new LinearLayout(r9);
        OUIFrameLayout r4 = new OUIFrameLayout(r9, null, 0, 14);
        Resources r6 = Resources.getSystem();
        Intrinsics.e(r6, "Resources.getSystem()");
        r4.setRadius(MathKt.a(TypedValue.applyDimension(1, 99, r6.getDisplayMetrics())));
        addView(r4);
        Intrinsics.c(r10);
        String r2 = r10.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (r2 == null) goto L16;
        int r5 = r2.hashCode();
        if (r5 == 1444) goto L14;
        if (r5 != 1445) goto L16;
        if (r2.equals("-2") == false) goto L16;
    L17:
        ValueAnimator r11 = ValueAnimator.ofObject(new PointEvaluator(), new Object[]{r3, r0});
        Intrinsics.e(r11, "ValueAnimator.ofObject(P…tor(), mLastP, mCurrentP)");
        this.E = r11;
        r11.addUpdateListener(this);
        r11.addListener(this);
        return;
    L14:
        if (r2.equals("-1") == true) goto L17;
    L16:
        TypedArray r12 = r9.obtainStyledAttributes(r10, new int[]{R.attr.layout_height});
        Intrinsics.e(r12, "context.obtainStyledAttributes(attrs, systemAttrs)");
        r12.getDimensionPixelSize(0, -2);
        r12.recycle();
        goto L17
    }

    public static final List h(OBottomNavActionBar r0, float r1, float r2, float r3) {
        r0.getClass();
        RangesKt.a((r1 - r2) / (r3 - r2), 0.0f, 1.0f);
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
        return this.m;
    }

    public final int getDividerColor() {
        return this.x;
    }

    public final float getDividerPadding() {
        return this.z;
    }

    public final float getDividerWidth() {
        return this.y;
    }

    public final long getIndicatorAnimDuration() {
        return this.u;
    }

    public final int getIndicatorColor() {
        return this.r;
    }

    public final float getIndicatorCornerRadius() {
        return this.t;
    }

    public final float getIndicatorHeight() {
        return this.s;
    }

    public final float getIndicatorSpacing() {
        return 0.0f;
    }

    public final int getTabCount() {
        return 0;
    }

    @NotNull
    public final List<View> getTabList() {
        return this.N;
    }

    public final float getTabPadding() {
        return this.p;
    }

    public final float getTabWidth() {
        return this.q;
    }

    public final int getTextBold() {
        return this.D;
    }

    public final int getTextSelectColor() {
        return this.B;
    }

    public final int getTextUnselectColor() {
        return this.C;
    }

    public final float getTextsize() {
        return this.A;
    }

    public final void i(boolean r12) {
        AnimationManager r0 = this.G;
        if (r0 == null) goto L5;
        int r2 = AnimationManager.f122d;
        r0.a(false);
    L5:
        AnimationManager r1 = this.H;
        if (r1 == null) goto L8;
        int r3 = AnimationManager.f122d;
        r1.a(false);
    L8:
        AnimationProperty.FloatProperty r4 = AnimationProperty.FloatProperty.e;
        AnimationProperty.FloatProperty r6 = AnimationProperty.FloatProperty.c;
        float r5 = this.f274J;
        if (r12 == false) goto L11;
        PropertyAnimatable.Builder r13 = PropertyAnimatableKt.a(this);
        Float r7 = Float.valueOf(getScaleX());
        FloatSpringSpec r9 = AnimationSpecKt.a();
        r9.b = r5;
        r13.b(r6, r7, this.I, r9, null);
        Float r8 = Float.valueOf(getScaleY());
        FloatSpringSpec r10 = AnimationSpecKt.a();
        r10.b = r5;
        r13.b(r4, r8, this.I, r10, null);
        r13.f105d = new OBottomNavActionBar$doPressAnim$$inlined$let$lambda$1(this);
        this.G = PropertyAnimatable.a(r13.a());
        return;
    L11:
        PropertyAnimatable.Builder r14 = PropertyAnimatableKt.a(this);
        Float r11 = Float.valueOf(getScaleX());
        FloatSpringSpec r15 = AnimationSpecKt.a();
        r15.b = r5;
        r14.b(r6, r11, this.K, r15, null);
        Float r16 = Float.valueOf(getScaleY());
        FloatSpringSpec r17 = AnimationSpecKt.a();
        r17.b = r5;
        r14.b(r4, r16, this.K, r17, null);
        r14.f105d = new OBottomNavActionBar$doPressAnim$$inlined$let$lambda$2(this);
        this.H = PropertyAnimatable.a(r14.a());
    }

    public final int j(float r2) {
        Resources r1 = this.k.getResources();
        Intrinsics.e(r1, "mContext.resources");
        return (int) ((r2 * r1.getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.f(r2, "animation");
        TabSelectAnimListener r1 = this.P;
        if (r1 == null) goto L6;
        r1.c();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.f(r2, "animation");
        TabSelectAnimListener r1 = this.P;
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
        TabSelectAnimListener r1 = this.P;
        if (r1 == null) goto L6;
        r1.a();
        return;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.f(r5, "animation");
        Object r0 = r5.getAnimatedValue();
        if (r0 == null) goto L14;
        IndicatorPoint r1 = (IndicatorPoint) r0;
        int r2 = (int) r1.f275a;
        Rect r3 = this.o;
        r3.left = r2;
        r3.right = (int) r1.b;
        float r6 = r5.getAnimatedFraction();
        float r4 = this.s;
        float r7 = this.M * r4;
        if (r6 > 0.7f) goto L7;
        this.L = r4 - ((r4 - r7) * (r6 / 0.7f));
    L8:
        float r8 = this.L;
        float r9 = j(2.0f);
        if (r8 >= r9) goto L11;
        r8 = r9;
    L11:
        this.L = r8;
        invalidate();
        return;
    L7:
        this.L = a.a(r4, r7, (r6 - 0.7f) / 0.3f, r7);
        goto L8
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OBottomNavActionBar.IndicatorPoint");
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
        if ((r2 instanceof Bundle) == false) goto L7;
        Bundle r3 = (Bundle) r2;
        this.m = r3.getInt("mCurrentTab");
        r2 = r3.getParcelable("instanceState");
        if (this.m == 0) goto L7;
        this.l.getChildCount();
    L7:
        super.onRestoreInstanceState(r2);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        r0.putInt("mCurrentTab", this.m);
        return r0;
    }

    public final void setCurrentTab(int r5) {
        int r0 = this.m;
        if (r5 != r0) goto L5;
        return;
    L5:
        this.n = r0;
        this.m = r5;
        StringBuilder r1 = a.p(r5, "setCurrentTab, currentTab: ", ", lastTab: ");
        r1.append(this.n);
        Log.d("OTabSegmentedLayout", r1.toString());
        setFragments(r5);
        if (this.v == false) goto L16;
        LinearLayout r6 = this.l;
        View r2 = r6.getChildAt(this.m);
        Intrinsics.e(r2, "currentTabView");
        float r3 = r2.getLeft();
        IndicatorPoint r4 = this.Q;
        r4.f275a = r3;
        r4.b = r2.getRight();
        View r7 = r6.getChildAt(this.n);
        Intrinsics.e(r7, "lastTabView");
        float r8 = r7.getLeft();
        IndicatorPoint r9 = this.R;
        r9.f275a = r8;
        float r10 = r7.getRight();
        r9.b = r10;
        if (r9.f275a == r4.f275a) goto L10;
    L12:
        ValueAnimator r11 = this.E;
        r11.setObjectValues(new Object[]{r9, r4});
        if (this.w == false) goto L15;
        r11.setInterpolator(this.F);
    L15:
        r11.setDuration(350);
        r11.start();
        return;
    L10:
        if (r10 != r4.b) goto L12;
        invalidate();
        return;
    L16:
        invalidate();
    }

    public final void setDividerColor(int r1) {
        this.x = r1;
        invalidate();
    }

    public final void setDividerPadding(float r1) {
        this.z = j(r1);
        invalidate();
    }

    public final void setDividerWidth(float r1) {
        this.y = j(r1);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        Iterator r1 = this.N.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((View) r1.next()).setEnabled(r2);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r1) {
        this.u = r1;
    }

    public final void setIndicatorAnimEnable(boolean r1) {
        this.v = r1;
    }

    public final void setIndicatorBounceEnable(boolean r1) {
        this.w = r1;
    }

    public final void setIndicatorColor(int r1) {
        this.r = r1;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r1) {
        this.t = j(r1);
        invalidate();
    }

    public final void setIndicatorHeight(float r1) {
        float r2 = j(r1);
        this.s = r2;
        this.L = r2;
        invalidate();
    }

    public final void setOnTabSelectAnimListener(@Nullable TabSelectAnimListener r1) {
        this.P = r1;
    }

    public final void setOnTabSelectListener(@Nullable TabSelectListener r1) {
        this.O = r1;
    }

    public final void setTabList(@NotNull List<View> r2) {
        Intrinsics.f(r2, "<set-?>");
        this.N = r2;
    }

    public final void setTabPadding(float r1) {
        this.p = j(r1);
    }

    public final void setTabSpaceEqual(boolean r1) {
    }

    public final void setTabWidth(float r1) {
        this.q = j(r1);
    }

    public final void setTextAllCaps(boolean r1) {
    }

    public final void setTextBold(int r1) {
        this.D = r1;
    }

    public final void setTextSelectColor(int r1) {
        this.B = r1;
    }

    public final void setTextUnselectColor(int r1) {
        this.C = r1;
    }

    public final void setTextsize(float r3) {
        Resources r0 = this.k.getResources();
        Intrinsics.e(r0, "mContext.resources");
        this.A = (int) ((r3 * r0.getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
