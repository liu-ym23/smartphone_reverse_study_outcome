package com.obric.oui.tab;

import a.a;
import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.securityserver.R;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.layout.OUILinearLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class OTabLayoutBase extends HorizontalScrollView implements ValueAnimator.AnimatorUpdateListener {
    public static final FastOutSlowInInterpolator D = null;
    public static final Pools.SynchronizedPool E = null;
    public float A;
    public boolean B;
    public OnTabClickListener C;
    public Tab b;
    public int c;
    public int e;
    public int f;
    public int i;
    public int j;
    public ColorStateList k;
    public float l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public OnTabSelectedListener t;
    public ViewPagerOnTabSelectedListener u;
    public ValueAnimator v;
    public ViewPager w;
    public PagerAdapter x;
    public TabLayoutOnPageChangeListener y;
    public float z;

    /* JADX INFO: renamed from: com.obric.oui.tab.OTabLayoutBase$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            r2.getAction();
            throw null;
        }
    }

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public final void onAdapterChanged(ViewPager r1, PagerAdapter r2, PagerAdapter r3) {
            throw null;
        }
    }

    public class IndicatorPoint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f292a;
        public float b;

        public final String toString() {
            return "(left = " + this.f292a + ", right = " + this.b + ")";
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    public interface OnTabClickListener {
        void a();
    }

    public interface OnTabSelectedListener {
    }

    public class PagerAdapterObserver extends DataSetObserver {
        @Override // android.database.DataSetObserver
        public final void onChanged() {
            throw null;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            throw null;
        }
    }

    public class PointEvaluator implements TypeEvaluator<IndicatorPoint> {
        @Override // android.animation.TypeEvaluator
        public final IndicatorPoint evaluate(float r2, IndicatorPoint r3, IndicatorPoint r4) {
            IndicatorPoint r5 = r3;
            IndicatorPoint r6 = r4;
            float r1 = r5.f292a;
            float r7 = a.a(r6.f292a, r1, r2, r1);
            float r8 = r5.b;
            float r9 = a.a(r6.b, r8, r2, r8);
            IndicatorPoint r10 = new IndicatorPoint();
            r10.f292a = r7;
            r10.b = r9;
            return r10;
        }
    }

    public class SlidingTabStrip extends OUILinearLayout {
        public int k;
        public float l;
        public int m;
        public int n;
        public ValueAnimator o;
        public int p;

        public final void g() {
            View r0 = getChildAt(this.k);
            if (r0 != null) goto L5;
        L11:
            int r1 = -1;
            int r2 = -1;
        L13:
            if (r1 == this.m) goto L15;
        L16:
            this.m = r1;
            this.n = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L15:
            if (r2 != this.n) goto L16;
            return;
        L5:
            if (r0.getWidth() <= 0) goto L11;
            r1 = r0.getLeft();
            r2 = r0.getRight();
            if (this.l <= 0.0f) goto L13;
            if (this.k >= (getChildCount() - 1)) goto L13;
            View r3 = getChildAt(this.k + 1);
            float r4 = this.l * r3.getLeft();
            float r5 = this.l;
            r1 = (int) (((1.0f - r5) * r1) + r4);
            r2 = (int) (((1.0f - this.l) * r2) + (r5 * r3.getRight()));
            goto L13
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
            super.onLayout(r7, r8, r9, r10, r11);
            ValueAnimator r12 = this.o;
            if (r12 != null) goto L5;
        L22:
            g();
            return;
        L5:
            if (r12.isRunning() == false) goto L22;
            this.o.cancel();
            int r13 = Math.round((1.0f - this.o.getAnimatedFraction()) * this.o.getDuration());
            ValueAnimator r14 = this.o;
            if (r14 != null) goto L9;
        L11:
            ViewCompat.getLayoutDirection(this);
            View r15 = getChildAt(0);
            if (r15 != null) goto L14;
            g();
            return;
        L14:
            final int r3 = r15.getLeft();
            final int r5 = r15.getRight();
            if (Math.abs(0 - this.k) > 1) goto L21;
            final int r2 = this.m;
            final int r4 = this.n;
            if (r2 != r3) goto L19;
            if (r4 != r5) goto L19;
            return;
        L19:
            ValueAnimator r16 = new ValueAnimator();
            this.o = r16;
            r16.setInterpolator(OTabLayoutBase.D);
            r16.setDuration(r13);
            r16.setFloatValues(new float[]{0.0f, 1.0f});
            r16.addUpdateListener(new AnonymousClass1(this, r2, r3, r4, r5));
            r16.addListener(new AnonymousClass2(this));
            r16.start();
            return;
        L21:
            throw null;
        L9:
            if (r14.isRunning() == false) goto L11;
            this.o.cancel();
            goto L11
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r4, int r5) {
            super.onMeasure(r4, r5);
            if (View.MeasureSpec.getMode(r4) == 1073741824) goto L5;
            return;
        L5:
            Log.d("wjh", "onMeasure " + View.MeasureSpec.getMode(r4));
            int r6 = getChildCount();
            int r7 = 0;
            int r0 = 0;
        L6:
            if (r7 >= r6) goto L12;
            View r1 = getChildAt(r7);
            if (r1.getVisibility() != 0) goto L10;
            r0 = Math.max(r0, r1.getMeasuredWidth());
            this.p = Math.min(this.p, r1.getMeasuredWidth());
        L10:
            r7 = r7 + 1;
            goto L6
        L12:
            throw null;
        }
    }

    public static final class Tab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f293a;
        public CharSequence b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f294d;
        public OTabLayoutBase e;
        public TabView f;
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f295a;
        public int b;
        public int c;

        public TabLayoutOnPageChangeListener(OTabLayoutBase r3) {
            new ArgbEvaluator();
            new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.f295a = new WeakReference(r3);
            r3.getTabTextColors().getColorForState(OTabLayoutBase.a(), 0);
            r3.getTabTextColors().getDefaultColor();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r2) {
            this.b = this.c;
            this.c = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r4, float r5, int r6) {
            if (((OTabLayoutBase) this.f295a.get()) == null) goto L15;
            int r7 = this.c;
            if (r7 != 2) goto L7;
            int r1 = this.b;
        L7:
            if (r7 != 2) goto L9;
            int r8 = this.b;
        L9:
            OTabLayoutBase.h(r4, r5);
            if (this.c == 2) goto L12;
            throw null;
        L12:
            if (this.b != 0) goto L16;
            throw null;
        L16:
            throw null;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r4) {
            OTabLayoutBase r0 = (OTabLayoutBase) this.f295a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L27;
            int r1 = this.c;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L18:
            if (r4 >= 0) goto L20;
        L23:
            r0.f(null, r3);
            return;
        L20:
            if (r4 >= r0.getTabCount()) goto L23;
            throw null;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L18
        L13:
            if (this.b != 0) goto L15;
        }
    }

    public static class TabLayoutOnPageChangeListenerIndependent implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: com.obric.oui.tab.OTabLayoutBase$TabLayoutOnPageChangeListenerIndependent$1, reason: invalid class name */
        class AnonymousClass1 implements Animator.AnimatorListener {
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r1) {
                throw null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r1) {
                throw null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r1) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r1) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r1) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r1, float r2, int r3) {
            throw null;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r1) {
            throw null;
        }
    }

    public class TabView extends LinearLayout {
        public Tab b;
        public TextView c;
        public ImageView e;
        public View f;
        public TextView i;
        public ImageView j;
        public int k;
        public final /* synthetic */ OTabLayoutBase l;

        public TabView(OTabLayoutBase r3, Context r4) {
            this.l = r3;
            super(r4);
            this.k = 2;
            int r0 = r3.m;
            if (r0 == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r4, r0));
        L5:
            ViewCompat.setPaddingRelative(this, r3.c, r3.e, r3.f, r3.i);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public final void a() {
            Tab r0 = this.b;
            if (r0 == null) goto L5;
            View r2 = r0.f294d;
        L6:
            if (r2 == null) goto L22;
            ViewParent r3 = r2.getParent();
            if (r3 == this) goto L12;
            if (r3 == null) goto L11;
            ((ViewGroup) r3).removeView(r2);
        L11:
            addView(r2);
        L12:
            this.f = r2;
            TextView r4 = this.c;
            if (r4 == null) goto L15;
            r4.setVisibility(8);
        L15:
            ImageView r5 = this.e;
            if (r5 == null) goto L18;
            r5.setVisibility(8);
            this.e.setImageDrawable(null);
        L18:
            TextView r1 = (TextView) r2.findViewById(R.id.title);
            this.i = r1;
            if (r1 == null) goto L21;
            this.k = TextViewCompat.getMaxLines(r1);
        L21:
            this.j = (ImageView) r2.findViewById(android.R.id.icon);
        L26:
            boolean r6 = false;
            if (this.f == null) goto L29;
            TextView r7 = this.i;
            if (r7 == null) goto L41;
        L42:
            b(r7, this.j);
        L43:
            if (r0 == null) goto L51;
            OTabLayoutBase r8 = r0.e;
            if (r8 == null) goto L50;
            if (r8.getSelectedTabPosition() != r0.c) goto L51;
            r6 = true;
            goto L51
        L50:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        L51:
            setSelected(r6);
            return;
        L41:
            if (this.j == null) goto L43;
        L29:
            if (this.e != null) goto L32;
            ImageView r9 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
            addView(r9, 0);
            this.e = r9;
        L32:
            if (this.c != null) goto L34;
            TextView r10 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
            addView(r10, new LinearLayout.LayoutParams(-1, -2));
            this.c = r10;
            this.k = TextViewCompat.getMaxLines(r10);
        L34:
            TextView r11 = this.c;
            OTabLayoutBase r12 = this.l;
            TextViewCompat.setTextAppearance(r11, r12.j);
            this.c.setAllCaps(false);
            ColorStateList r13 = r12.k;
            if (r13 == null) goto L37;
            this.c.setTextColor(r13);
        L37:
            b(this.c, this.e);
            goto L43
        L22:
            View r14 = this.f;
            if (r14 == null) goto L25;
            removeView(r14);
            this.f = null;
        L25:
            this.i = null;
            this.j = null;
            goto L26
        L5:
            r2 = null;
            goto L6
        }

        public final void b(TextView r7, ImageView r8) {
            Tab r0 = this.b;
            CharSequence r1 = null;
            if (r0 == null) goto L5;
            CharSequence r2 = r0.f293a;
        L6:
            if (r0 == null) goto L8;
            CharSequence r3 = r0.b;
        L10:
            if (r8 == null) goto L12;
            r8.setVisibility(8);
            r8.setImageDrawable(null);
            r8.setContentDescription(r3);
        L12:
            boolean r4 = !TextUtils.isEmpty(r2);
            int r5 = 0;
            if (r7 == null) goto L18;
            if (r4 == false) goto L16;
            r7.setText(r2);
            r7.setVisibility(0);
            setVisibility(0);
        L17:
            r7.setContentDescription(r3);
            goto L18
        L16:
            r7.setVisibility(8);
            r7.setText(null);
        L18:
            if (r8 == null) goto L27;
            ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
            if (r4 == false) goto L25;
            if (r8.getVisibility() != 0) goto L25;
            r5 = this.l.d(8);
        L25:
            if (r5 == r9.bottomMargin) goto L27;
            r9.bottomMargin = r5;
            r8.requestLayout();
        L27:
            if (r4 == true) goto L30;
            r1 = r3;
        L30:
            TooltipCompat.setTooltipText(this, r1);
            return;
        L8:
            r3 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public int getContentWidth() {
            TextView r0 = this.c;
            boolean r1 = true;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
            int r3 = 0;
            int r4 = 0;
        L8:
            ImageView r5 = this.e;
            if (r5 != null) goto L11;
        L19:
            r1 = r2;
        L20:
            View r6 = this.f;
            if (r6 == null) goto L32;
            if (r6.getVisibility() != 0) goto L32;
            int r7 = this.f.getLeft();
            if (r1 == false) goto L27;
            r7 = Math.min(r3, r7);
        L27:
            r3 = r7;
            int r8 = this.f.getRight();
            if (r1 == false) goto L30;
            r8 = Math.max(r4, r8);
        L30:
            r4 = r8;
        L32:
            return r4 - r3;
        L11:
            if (r5.getVisibility() != 0) goto L19;
            if (r2 == false) goto L14;
            r3 = Math.min(r3, this.e.getLeft());
        L15:
            if (r2 == false) goto L18;
            int r9 = Math.max(r4, this.e.getRight());
        L17:
            r4 = r9;
            goto L20
        L18:
            r9 = this.e.getRight();
            goto L17
        L14:
            r3 = this.e.getLeft();
            goto L15
        L5:
            if (r0.getVisibility() != 0) goto L7;
            int r10 = this.c.getLeft();
            r4 = this.c.getRight();
            r3 = r10;
            r2 = true;
            goto L8
        }

        public Tab getTab() {
            return this.b;
        }

        public TextView getTextView() {
            return this.c;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
            super.onInitializeAccessibilityEvent(r1);
            r1.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
            super.onInitializeAccessibilityNodeInfo(r1);
            r1.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r9, int r10) {
            int r0 = View.MeasureSpec.getSize(r9);
            int r1 = View.MeasureSpec.getMode(r9);
            OTabLayoutBase r2 = this.l;
            int r3 = r2.getTabMaxWidth();
            LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            if (r3 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r3) goto L7;
        L6:
            r9 = View.MeasureSpec.makeMeasureSpec(r2.n, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r9, r10);
            if (this.c == null) goto L39;
            getResources();
            float r5 = r2.l;
            int r6 = this.k;
            r2.getClass();
            r2.getClass();
            ImageView r7 = this.e;
            if (r7 != null) goto L12;
        L14:
            TextView r8 = this.c;
            if (r8 != null) goto L17;
        L20:
            if (this.c != null) goto L22;
        L24:
            float r11 = this.c.getTextSize();
            int r12 = this.c.getLineCount();
            int r13 = TextViewCompat.getMaxLines(this.c);
            if (r5 != r11) goto L29;
            if (r13 < 0) goto L40;
            if (r6 != r13) goto L29;
            return;
        L40:
            return;
        L29:
            if (r2.s != 1) goto L37;
            if (r5 <= r11) goto L37;
            if (r12 != 1) goto L37;
            Layout r14 = this.c.getLayout();
            if (r14 != null) goto L35;
            return;
        L35:
            if (((r5 / r14.getPaint().getTextSize()) * r14.getLineWidth(0)) <= ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L37;
            return;
        L37:
            this.c.setTextSize(0, r5);
            this.c.setMaxLines(r6);
            r4.topMargin = 0;
            r4.leftMargin = 0;
            r4.rightMargin = 0;
            this.c.setLayoutParams(r4);
            super.onMeasure(r9, r10);
            return;
        L22:
            if (isSelected() == false) goto L24;
            r2.getClass();
            goto L24
        L17:
            if (r8.getLineCount() <= 1) goto L20;
            r2.getClass();
            r5 = 0.0f;
            goto L20
        L12:
            if (r7.getVisibility() != 0) goto L14;
            r6 = 1;
            goto L20
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean r0 = super.performClick();
            if (this.b == null) goto L16;
            if (r0 == true) goto L6;
            playSoundEffect(0);
        L6:
            OnTabClickListener r1 = this.l.C;
            if (r1 == null) goto L9;
            r1.a();
        L12:
            VibratorSmt.a(getContext(), 1);
            return true;
        L9:
            Tab r2 = this.b;
            OTabLayoutBase r3 = r2.e;
            if (r3 == null) goto L15;
            r3.f(r2, true);
            goto L12
        L15:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        L16:
            return r0;
        }

        @Override // android.view.View
        public void setSelected(boolean r3) {
            isSelected();
            super.setSelected(r3);
            TextView r0 = this.c;
            if (r0 == null) goto L8;
            r0.setSelected(r3);
            this.c.setTypeface(Typeface.DEFAULT_BOLD);
            OTabLayoutBase r1 = this.l;
            if (r3 == false) goto L7;
            r1.getClass();
        L7:
            this.c.setTextSize(r1.l);
        L8:
            ImageView r2 = this.e;
            if (r2 == null) goto L11;
            r2.setSelected(r3);
        L11:
            View r4 = this.f;
            if (r4 == null) goto L15;
            r4.setSelected(r3);
            return;
        }

        public void setTab(@Nullable Tab r2) {
            if (r2 == this.b) goto L6;
            this.b = r2;
            a();
            return;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
    }

    static {
        D = new FastOutSlowInInterpolator();
        E = new Pools.SynchronizedPool(16);
    }

    public static /* synthetic */ int[] a() {
        return HorizontalScrollView.SELECTED_STATE_SET;
    }

    private int getDefaultHeight() {
        throw null;
    }

    private float getScrollPosition() {
        throw null;
    }

    private int getTabMinWidth() {
        int r1 = this.o;
        if (r1 == (-1)) goto L5;
        return r1;
    L5:
        return 0;
    }

    private int getTabScrollRange() {
        throw null;
    }

    public static void h(int r0, float r1) {
        if (Math.round(r0 + r1) >= 0) goto L6;
        return;
    L6:
        throw null;
    }

    private void setSelectedTabView(int r1) {
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r1) {
        b(r1);
    }

    public final void b(View r6) {
        if ((r6 instanceof OTabItem) == false) goto L11;
        OTabItem r7 = (OTabItem) r6;
        Tab r5 = e();
        r7.getClass();
        if (TextUtils.isEmpty(r7.getContentDescription()) == true) goto L30;
        r5.b = r7.getContentDescription();
        TabView r8 = r5.f;
        if (r8 == null) goto L31;
        r8.a();
        throw null;
    L31:
        throw null;
    L30:
        throw null;
    L11:
        if ((r6 instanceof SlidingTabStrip) == false) goto L16;
        if (indexOfChild(r6) != (-1)) goto L29;
        super.addView(r6, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    L29:
        return;
    L16:
        if ((r6 instanceof OBottomTabItem) == false) goto L34;
        OBottomTabItem r9 = (OBottomTabItem) r6;
        OBottomTabItemCustomView r0 = new OBottomTabItemCustomView(getContext());
        Tab r2 = e();
        if (r9.getText() == null) goto L23;
        r0.getTitle().setText(r9.getText());
        r2.f293a = r9.getText();
        TabView r3 = r2.f;
        if (r3 == null) goto L23;
        r3.a();
    L23:
        if (r9.getIcon() == null) goto L25;
        r0.getIcon().setImageDrawable(r9.getIcon());
    L25:
        r0.setTextColor(this.k);
        r0.setSelectedBgColor(Integer.valueOf(ContextCompat.getColor(getContext(), R.color.oui_accent_bg_light)));
        r2.f294d = r0;
        TabView r10 = r2.f;
        if (r10 == null) goto L32;
        r10.a();
        throw null;
    L32:
        throw null;
    }

    public final void c() {
        if (this.s != 0) goto L5;
        int r0 = Math.max(0, this.q - this.c);
    L6:
        ViewCompat.setPaddingRelative(null, r0, 0, 0, 0);
        int r3 = this.s;
        if (r3 != 0) goto L9;
        throw null;
    L9:
        if (r3 == 1) goto L11;
        throw null;
    L11:
        throw null;
    L5:
        r0 = 0;
        goto L6
    }

    public final int d(int r1) {
        return Math.round(getResources().getDisplayMetrics().density * r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Tab e() {
        Tab r0 = (Tab) E.acquire();
        if (r0 != null) goto L5;
        r0 = new Tab();
        r0.c = -1;
    L5:
        r0.e = this;
        TabView r1 = new TabView(this, getContext());
        r1.setFocusable(true);
        r0.f = r1;
        r1.setTab(r0);
        return r0;
    }

    public final void f(Tab r6, boolean r7) {
        Tab r0 = this.b;
        if (r0 != r6) goto L8;
        if (r0 == null) goto L38;
        throw null;
    L38:
        return;
    L8:
        if (r6 == null) goto L10;
        int r3 = r6.c;
    L11:
        if (r7 == true) goto L13;
    L29:
        if (r0 != null) goto L37;
        this.b = r6;
        if (this.B == true) goto L35;
        if (r6 != null) goto L34;
        return;
    L34:
        throw null;
    L35:
        getSelectedTabPosition();
        throw null;
    L37:
        throw null;
    L13:
        if (r0 != null) goto L15;
    L16:
        if (r3 == (-1)) goto L18;
        h(r3, 0.0f);
    L27:
        if (r3 == (-1)) goto L29;
        setSelectedTabView(r3);
    L18:
        if (r3 == (-1)) goto L27;
        if (getWindowToken() != null) goto L23;
    L26:
        h(r3, 0.0f);
        goto L27
    L23:
        if (ViewCompat.isLaidOut(this) == false) goto L26;
        throw null;
    L15:
        if (r0.c != (-1)) goto L18;
    L10:
        r3 = -1;
        goto L11
    }

    public final void g(PagerAdapter r1) {
        this.x = r1;
        throw null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateDefaultLayoutParams();
    }

    public float getIndicatorCornerRadius() {
        return this.A;
    }

    public int getSelectedTabPosition() {
        Tab r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.c;
    }

    public int getTabCount() {
        throw null;
    }

    public int getTabGravity() {
        return this.r;
    }

    public int getTabMaxWidth() {
        return this.n;
    }

    public int getTabMode() {
        return this.s;
    }

    public int getTabStripLeftPadding() {
        throw null;
    }

    public int getTabStripRightPadding() {
        throw null;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.k;
    }

    public final void i(ViewPager r4) {
        ViewPager r0 = this.w;
        if (r0 == null) goto L8;
        TabLayoutOnPageChangeListener r1 = this.y;
        if (r1 == null) goto L8;
        r0.removeOnPageChangeListener(r1);
    L8:
        if (this.u != null) goto L17;
        if (r4 == null) goto L15;
        this.w = r4;
        if (this.y != null) goto L13;
        this.y = new TabLayoutOnPageChangeListener(this);
    L13:
        TabLayoutOnPageChangeListener r2 = this.y;
        r2.b = 0;
        r2.c = 0;
        r4.addOnPageChangeListener(r2);
        this.u = new ViewPagerOnTabSelectedListener();
        throw null;
    L15:
        this.w = null;
        g(null);
        throw null;
    L17:
        throw null;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r1) {
        float r0 = ((IndicatorPoint) r1.getAnimatedValue()).f292a;
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.w != null) goto L9;
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewPager) == false) goto L10;
        i((ViewPager) r0);
        throw null;
    L10:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        super.onDraw(r3);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (getTabCount() <= 0) goto L21;
        int r4 = getHeight();
        getPaddingLeft();
        getPaddingRight();
        getPaddingTop();
        getPaddingBottom();
        if (this.z >= 0.0f) goto L10;
        this.z = r4 - 0.0f;
    L10:
        float r5 = this.A;
        if (r5 >= 0.0f) goto L13;
    L14:
        this.A = this.z;
    L16:
        if (this.B == false) goto L18;
        return;
    L18:
        getSelectedTabPosition();
        throw null;
    L13:
        if (r5 <= (this.z / 2.0f)) goto L16;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        int r0 = d(getDefaultHeight());
        int r1 = getPaddingTop() + r0;
        int r2 = getPaddingBottom() + r1;
        int r3 = View.MeasureSpec.getMode(r6);
        if (r3 == Integer.MIN_VALUE) goto L7;
        if (r3 != 0) goto L8;
        r6 = View.MeasureSpec.makeMeasureSpec(r2, BasicMeasure.EXACTLY);
    L8:
        int r4 = View.MeasureSpec.getSize(r5);
        if (View.MeasureSpec.getMode(r5) == 0) goto L15;
        int r7 = this.p;
        if (r7 > 0) goto L14;
        r7 = r4 - d(56);
    L14:
        this.n = r7;
    L15:
        super.onMeasure(r5, r6);
        if (getChildCount() != 1) goto L28;
        View r8 = getChildAt(0);
        int r9 = this.s;
        if (r9 == 0) goto L25;
        if (r9 == 1) goto L22;
        return;
    L22:
        if (r8.getMeasuredWidth() == getMeasuredWidth()) goto L29;
    L26:
        int r10 = getPaddingTop();
        int r11 = ViewGroup.getChildMeasureSpec(r6, getPaddingBottom() + r10, r8.getLayoutParams().height);
        r8.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), r11);
        return;
    L29:
        return;
    L25:
        if (r8.getMeasuredWidth() < getMeasuredWidth()) goto L26;
        return;
    L28:
        return;
    L7:
        r6 = View.MeasureSpec.makeMeasureSpec(Math.min(r2, View.MeasureSpec.getSize(r6)), BasicMeasure.EXACTLY);
        goto L8
    }

    @Override // android.view.View
    public final boolean overScrollBy(int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, boolean r19) {
        return super.overScrollBy(r11, r12, r13, r14, r15, r16, 80, r18, r19);
    }

    public void setAutoFillWhenScrollable(boolean r1) {
    }

    public void setContentInsetStart(int r1) {
        this.q = r1;
    }

    public void setCustomTabViewResId(int r1) {
    }

    public void setIndicatorAnimEnable(boolean r1) {
        this.B = r1;
        invalidate();
    }

    public void setIndicatorBounceEnable(boolean r1) {
    }

    public void setIndicatorCornerRadius(float r1) {
        this.A = r1;
        invalidate();
    }

    public void setOnTabClickListener(OnTabClickListener r1) {
        this.C = r1;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener r3) {
        if (this.t != null) goto L8;
        this.t = r3;
        if (r3 != null) goto L7;
        return;
    L7:
        throw null;
    L8:
        throw null;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r4) {
        if (this.v != null) goto L5;
        ValueAnimator r0 = new ValueAnimator();
        this.v = r0;
        r0.setInterpolator(D);
        this.v.setDuration(200);
        this.v.addUpdateListener(new AnonymousClass2(this));
    L5:
        this.v.addListener(r4);
    }

    public void setSelectedTabHorizontalPadding(int r1) {
        throw null;
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r1) {
        throw null;
    }

    public void setSelectedTabIndicatorHeight(int r1) {
        throw null;
    }

    public void setShowSelectedIndicator(Boolean r1) {
        r1.booleanValue();
        throw null;
    }

    public void setShowTopLine(Boolean r1) {
        r1.booleanValue();
        throw null;
    }

    public void setTabBackgroundResId(int r1) {
        this.m = r1;
    }

    public void setTabGravity(int r2) {
        if (this.r != r2) goto L5;
        return;
    L5:
        this.r = r2;
        c();
        throw null;
    }

    public void setTabMargin(int r1) {
        d(r1);
        if (getTabCount() > 0) goto L6;
        return;
    L6:
        throw null;
    }

    public void setTabMaxWidth(int r1) {
        this.p = r1;
    }

    public void setTabMinWidth(int r1) {
        this.o = r1;
    }

    public void setTabMode(int r2) {
        if (r2 != this.s) goto L5;
        return;
    L5:
        this.s = r2;
        c();
        throw null;
    }

    public void setTabPaddingBottom(int r1) {
        this.i = r1;
    }

    public void setTabPaddingEnd(int r1) {
        this.f = r1;
    }

    public void setTabPaddingStart(int r1) {
        this.c = r1;
    }

    public void setTabPaddingTop(int r1) {
        this.e = r1;
    }

    @Deprecated
    public void setTabTextAppearance(int r1) {
        this.j = r1;
    }

    public void setTabTextColors(@Nullable ColorStateList r2) {
        if (this.k != r2) goto L5;
        return;
    L5:
        this.k = r2;
        throw null;
    }

    public void setTabTextSize(float r2) {
        if (this.l != r2) goto L5;
        return;
    L5:
        this.l = r2;
        throw null;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r1) {
        g(r1);
        throw null;
    }

    public void setupWithViewPager(@Nullable ViewPager r1) {
        i(r1);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r1, int r2) {
        b(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r1, ViewGroup.LayoutParams r2) {
        b(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        b(r1);
    }

    public void setTabMode(String r3) {
        r3.getClass();
        if (r3.equals("scrollable") == true) goto L13;
        if (r3.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.s == 1) goto L18;
        this.s = 1;
        c();
        throw null;
    L18:
        return;
    L13:
        if (this.s != 0) goto L15;
        return;
    L15:
        this.s = 0;
        c();
        throw null;
    }
}
