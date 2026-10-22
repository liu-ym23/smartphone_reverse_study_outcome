package com.obric.oui.tab;

import android.R;
import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class OTabLayoutBase extends HorizontalScrollView {
    private static final Interpolator R = null;
    private static final Pools.Pool<g> S = null;
    private int A;
    int B;
    int C;
    int D;
    private d E;
    private final ArrayList<d> F;
    private d G;
    private ValueAnimator H;
    ViewPager I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private PagerAdapter f11450J;
    private DataSetObserver K;
    TabLayoutOnPageChangeListener L;
    private b M;
    private boolean N;
    private boolean O;
    private c P;
    private final Pools.Pool<h> Q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<g> f11451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f11452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f11453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f11457l;
    int m;
    int n;
    int o;
    int p;

    @Deprecated
    int q;
    ColorStateList r;
    float s;
    float t;
    int u;
    int v;
    int w;
    private int x;
    private int y;
    private final int z;

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final WeakReference<OTabLayoutBase> f11458f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f11459g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f11460h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f11461i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f11462j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ArgbEvaluator f11463k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private AccelerateInterpolator f11464l;

        public TabLayoutOnPageChangeListener(OTabLayoutBase r4) {
            this.f11463k = new ArgbEvaluator();
            this.f11464l = new AccelerateInterpolator();
            new DecelerateInterpolator(1.6f);
            this.f11458f = new WeakReference(r4);
            this.f11462j = r4.getTabTextColors().getColorForState(OTabLayoutBase.e(), 0);
            this.f11461i = r4.getTabTextColors().getDefaultColor();
        }

        private void a(@Nullable ImageView r1, @Nullable TextView r2, @ColorInt int r3) {
            if (r1 == null) goto L7;
            if (r2 == null) goto L8;
            r2.setTextColor(r3);
            r1.setImageAlpha(Color.alpha(r3));
            return;
        L8:
            return;
        }

        void b() {
            this.f11459g = 0;
            this.f11460h = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.f11459g = this.f11460h;
            this.f11460h = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r11, float r12, int r13) {
            OTabLayoutBase r14 = this.f11458f.get();
            if (r14 == null) goto L34;
            int r0 = this.f11460h;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L16:
            boolean r1 = true;
        L17:
            r14.J(r11, r12, r4, r1);
            if (this.f11460h == 2) goto L20;
        L22:
            OTabLayoutBase.d(r14).f11481i = true;
            View r15 = OTabLayoutBase.d(r14).getChildAt(OTabLayoutBase.d(r14).f11478f);
            View r2 = OTabLayoutBase.d(r14).getChildAt(OTabLayoutBase.d(r14).f11478f + 1);
            if (r15 == null) goto L30;
            if (r2 == null) goto L30;
            int r3 = com.obric.common.oui.f.b0;
            View r5 = r15.findViewById(r3);
            View r6 = r2.findViewById(r3);
            if (r5 == null) goto L32;
            if (r6 == null) goto L32;
            float r16 = r15.getLeft() + ((r15.getWidth() - r5.getWidth()) / 2);
            float r7 = r5.getWidth() + r16;
            float r8 = r2.getLeft() + ((r2.getWidth() - r6.getWidth()) / 2);
            float r9 = r6.getWidth() + r8;
            int r10 = com.obric.common.oui.f.N0;
            ImageView r17 = (ImageView) r5.findViewById(r10);
            int r18 = com.obric.common.oui.f.O0;
            TextView r19 = (TextView) r5.findViewById(r18);
            ImageView r20 = (ImageView) r6.findViewById(r10);
            TextView r21 = (TextView) r6.findViewById(r18);
            a(r17, r19, ((Integer) this.f11463k.evaluate(r12, Integer.valueOf(this.f11462j), Integer.valueOf(this.f11461i))).intValue());
            a(r20, r21, ((Integer) this.f11463k.evaluate(r12, Integer.valueOf(this.f11461i), Integer.valueOf(this.f11462j))).intValue());
            f.a(OTabLayoutBase.d(r14), r16 + ((r8 - r16) * this.f11464l.getInterpolation(r12)));
            f.b(OTabLayoutBase.d(r14), r7 + ((r9 - r7) * this.f11464l.getInterpolation(r12)));
        L32:
            ViewCompat.postInvalidateOnAnimation(OTabLayoutBase.d(r14));
            return;
        L30:
            if (OTabLayoutBase.f(r14) == false) goto L32;
        L21:
            OTabLayoutBase.d(r14).f11481i = false;
            goto L32
        L20:
            if (this.f11459g != 0) goto L22;
        L13:
            if (this.f11459g != 0) goto L16;
            r1 = false;
            goto L17
        L7:
            if (this.f11459g == 1) goto L10;
            r4 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            OTabLayoutBase r0 = this.f11458f.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.f11460h;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.G(r0.z(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L17
        L13:
            if (this.f11459g != 0) goto L15;
        }
    }

    public static class TabLayoutOnPageChangeListenerIndependent implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final WeakReference<OTabLayoutBase> f11465f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f11466g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f11467h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f11468i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final boolean f11469j;

        class a implements Animator.AnimatorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OTabLayoutBase f11470a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f11471b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f11472c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f11473d;

            a(TabLayoutOnPageChangeListenerIndependent r1, OTabLayoutBase r2, int r3, boolean r4, boolean r5) {
                this.f11470a = r2;
                this.f11471b = r3;
                this.f11472c = r4;
                this.f11473d = r5;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator r4) {
                this.f11470a.J(this.f11471b, 0.0f, this.f11472c, this.f11473d);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator r4) {
                this.f11470a.J(this.f11471b, 0.0f, this.f11472c, this.f11473d);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator r1) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator r1) {
            }
        }

        private /* synthetic */ void a(int r1, int r2, OTabLayoutBase r3, boolean r4, boolean r5, ValueAnimator r6) {
            float r7 = ((Float) r6.getAnimatedValue()).floatValue();
            if (r1 < r2) goto L5;
        L7:
            r7 = 1.0f - r7;
        L8:
            r3.J(r2, r7, r4, r5);
            return;
        L5:
            if (this.f11469j == true) goto L7;
            r2 = r2 - 1;
            goto L8
        }

        public /* synthetic */ void b(int r1, int r2, OTabLayoutBase r3, boolean r4, boolean r5, ValueAnimator r6) {
            a(r1, r2, r3, r4, r5, r6);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.f11466g = this.f11467h;
            this.f11467h = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(final int r11, float r12, int r13) {
            final OTabLayoutBase r14 = this.f11465f.get();
            if (this.f11468i != r11) goto L5;
            return;
        L5:
            if (r14 == null) goto L21;
            int r15 = this.f11467h;
            if (r15 == 2) goto L9;
        L12:
            boolean r7 = true;
        L13:
            if (r15 == 2) goto L15;
        L18:
            boolean r16 = true;
        L19:
            ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
            final int r2 = this.f11468i;
            final boolean r5 = r7;
            final boolean r6 = r16;
            r8.addUpdateListener(new com.obric.oui.tab.a(this, r2, r11, r14, r5, r6));
            this.f11468i = r11;
            r8.addListener(new a(this, r14, r11, r7, r16));
            r8.start();
            return;
        L15:
            if (this.f11466g != 0) goto L18;
            r16 = false;
            goto L19
        L9:
            if (this.f11466g == 1) goto L12;
            r7 = false;
            goto L13
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            OTabLayoutBase r0 = this.f11465f.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.f11467h;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.G(r0.z(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L17
        L13:
            if (this.f11466g != 0) goto L15;
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f11474a;

        a(OTabLayoutBase r1) {
            this.f11474a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r2) {
            this.f11474a.scrollTo(((Integer) r2.getAnimatedValue()).intValue(), 0);
        }
    }

    private class b implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f11475f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f11476g;

        b(OTabLayoutBase r1) {
            this.f11476g = r1;
        }

        void a(boolean r1) {
            this.f11475f = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager r2, @Nullable PagerAdapter r3, @Nullable PagerAdapter r4) {
            OTabLayoutBase r5 = this.f11476g;
            if (r5.I != r2) goto L6;
            r5.H(r4, this.f11475f);
            return;
        }
    }

    public interface c {
        void a(g r1);
    }

    public interface d {
        void a(g r1);

        void b(g r1);

        void c(g r1);
    }

    private class e extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabLayoutBase f11477a;

        e(OTabLayoutBase r1) {
            this.f11477a = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.f11477a.B();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f11477a.B();
        }
    }

    private class f extends LinearLayout {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f11478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f11479g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f11480h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11481i;

        static /* synthetic */ float a(f r0, float r1) {
            r0.f11479g = r1;
            return r1;
        }

        static /* synthetic */ float b(f r0, float r1) {
            r0.f11480h = r1;
            return r1;
        }

        boolean c() {
            throw null;
        }

        float d() {
            throw null;
        }

        void e(int r1, float r2) {
            throw null;
        }

        void f(int r1) {
            throw null;
        }

        void g(int r1) {
            throw null;
        }

        public void h(int r1) {
            throw null;
        }

        void i(boolean r1) {
            throw null;
        }

        void j(boolean r1) {
            throw null;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f11482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f11483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f11484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f11485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f11486e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        OTabLayoutBase f11487f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        h f11488g;

        g() {
            this.f11485d = -1;
        }

        @Nullable
        public CharSequence a() {
            return this.f11484c;
        }

        @Nullable
        public View b() {
            return this.f11486e;
        }

        @Nullable
        public Drawable c() {
            return this.f11482a;
        }

        public int d() {
            return this.f11485d;
        }

        @Nullable
        public CharSequence e() {
            return this.f11483b;
        }

        public boolean f() {
            OTabLayoutBase r0 = this.f11487f;
            if (r0 == null) goto L10;
            if (r0.getSelectedTabPosition() != this.f11485d) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void g() {
            this.f11487f = null;
            this.f11488g = null;
            this.f11482a = null;
            this.f11483b = null;
            this.f11484c = null;
            this.f11485d = -1;
            this.f11486e = null;
        }

        public void h() {
            OTabLayoutBase r0 = this.f11487f;
            if (r0 == null) goto L7;
            r0.F(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public g i(@Nullable CharSequence r1) {
            this.f11484c = r1;
            o();
            return this;
        }

        @NonNull
        public g j(@LayoutRes int r4) {
            k(LayoutInflater.from(this.f11488g.getContext()).inflate(r4, this.f11488g, false));
            return this;
        }

        @NonNull
        public g k(@Nullable View r1) {
            this.f11486e = r1;
            o();
            return this;
        }

        @NonNull
        public g l(@Nullable Drawable r1) {
            this.f11482a = r1;
            o();
            return this;
        }

        void m(int r1) {
            this.f11485d = r1;
        }

        @NonNull
        public g n(@Nullable CharSequence r1) {
            this.f11483b = r1;
            o();
            return this;
        }

        void o() {
            h r0 = this.f11488g;
            if (r0 == null) goto L6;
            r0.d();
            return;
        }
    }

    public class h extends LinearLayout {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g f11489f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TextView f11490g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ImageView f11491h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private View f11492i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private TextView f11493j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ImageView f11494k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f11495l;
        final /* synthetic */ OTabLayoutBase m;

        public h(OTabLayoutBase r3, Context r4) {
            this.m = r3;
            super(r4);
            this.f11495l = 2;
            int r0 = r3.v;
            if (r0 == 0) goto L5;
            ViewCompat.setBackground(this, AppCompatResources.getDrawable(r4, r0));
        L5:
            ViewCompat.setPaddingRelative(this, r3.f11457l, r3.m, r3.n, r3.o);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private float a(Layout r1, int r2, float r3) {
            return r1.getLineWidth(r2) * (r3 / r1.getPaint().getTextSize());
        }

        private void e(@Nullable TextView r7, @Nullable ImageView r8) {
            g r0 = this.f11489f;
            CharSequence r1 = null;
            if (r0 == null) goto L5;
            Drawable r2 = r0.c();
        L6:
            g r3 = this.f11489f;
            if (r3 == null) goto L9;
            CharSequence r4 = r3.e();
        L10:
            g r5 = this.f11489f;
            if (r5 == null) goto L13;
            CharSequence r6 = r5.a();
        L14:
            int r9 = 0;
            if (r8 == null) goto L20;
            if (r2 == null) goto L18;
            r8.setImageDrawable(r2);
            r8.setVisibility(0);
            setVisibility(0);
        L19:
            r8.setContentDescription(r6);
            goto L20
        L18:
            r8.setVisibility(8);
            r8.setImageDrawable(null);
        L20:
            boolean r10 = !TextUtils.isEmpty(r4);
            if (r7 == null) goto L26;
            if (r10 == false) goto L24;
            r7.setText(r4);
            r7.setVisibility(0);
            setVisibility(0);
        L25:
            r7.setContentDescription(r6);
            goto L26
        L24:
            r7.setVisibility(8);
            r7.setText(null);
        L26:
            if (r8 == null) goto L35;
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
            if (r10 == false) goto L33;
            if (r8.getVisibility() != 0) goto L33;
            r9 = this.m.x(8);
        L33:
            if (r9 == r11.bottomMargin) goto L35;
            r11.bottomMargin = r9;
            r8.requestLayout();
        L35:
            if (r10 == true) goto L38;
            r1 = r6;
        L38:
            TooltipCompat.setTooltipText(this, r1);
            return;
        L13:
            r6 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        void b() {
            setTab(null);
            setSelected(false);
        }

        void c(@Nullable g r2, boolean r3) {
            if (r2 == this.f11489f) goto L8;
            this.f11489f = r2;
            if (r3 == false) goto L9;
            d();
            return;
        L9:
            return;
        }

        final void d() {
            g r0 = this.f11489f;
            ImageView r1 = null;
            if (r0 == null) goto L5;
            View r2 = r0.b();
        L6:
            if (r2 == null) goto L22;
            ViewParent r3 = r2.getParent();
            if (r3 == this) goto L12;
            if (r3 == null) goto L11;
            ((ViewGroup) r3).removeView(r2);
        L11:
            addView(r2);
        L12:
            this.f11492i = r2;
            TextView r4 = this.f11490g;
            if (r4 == null) goto L15;
            r4.setVisibility(8);
        L15:
            ImageView r5 = this.f11491h;
            if (r5 == null) goto L18;
            r5.setVisibility(8);
            this.f11491h.setImageDrawable(null);
        L18:
            TextView r6 = (TextView) r2.findViewById(com.obric.common.oui.f.S0);
            this.f11493j = r6;
            if (r6 == null) goto L21;
            this.f11495l = TextViewCompat.getMaxLines(r6);
        L21:
            r1 = (ImageView) r2.findViewById(R.id.icon);
        L26:
            this.f11494k = r1;
            boolean r7 = false;
            if (this.f11492i == null) goto L29;
            TextView r8 = this.f11493j;
            if (r8 == null) goto L41;
        L42:
            ImageView r9 = this.f11494k;
        L43:
            e(r8, r9);
        L44:
            if (r0 != null) goto L46;
        L48:
            setSelected(r7);
            return;
        L46:
            if (r0.f() == false) goto L48;
            r7 = true;
            goto L48
        L41:
            if (this.f11494k == null) goto L44;
        L29:
            if (this.f11491h != null) goto L32;
            ImageView r10 = (ImageView) LayoutInflater.from(getContext()).inflate(com.obric.common.oui.g.f8254d, this, false);
            addView(r10, 0);
            this.f11491h = r10;
        L32:
            if (this.f11490g != null) goto L34;
            TextView r11 = (TextView) LayoutInflater.from(getContext()).inflate(com.obric.common.oui.g.f8255e, this, false);
            addView(r11);
            this.f11490g = r11;
            this.f11495l = TextViewCompat.getMaxLines(r11);
        L34:
            TextViewCompat.setTextAppearance(this.f11490g, this.m.q);
            ColorStateList r12 = this.m.r;
            if (r12 == null) goto L37;
            this.f11490g.setTextColor(r12);
        L37:
            r8 = this.f11490g;
            r9 = this.f11491h;
            goto L43
        L22:
            View r13 = this.f11492i;
            if (r13 == null) goto L25;
            removeView(r13);
            this.f11492i = null;
        L25:
            this.f11493j = null;
            goto L26
        L5:
            r2 = null;
            goto L6
        }

        public int getContentWidth() {
            TextView r0 = this.f11490g;
            boolean r1 = true;
            boolean r2 = false;
            if (r0 != null) goto L5;
        L7:
            int r3 = 0;
            int r4 = 0;
        L8:
            ImageView r5 = this.f11491h;
            if (r5 != null) goto L11;
        L19:
            r1 = r2;
        L20:
            View r6 = this.f11492i;
            if (r6 == null) goto L32;
            if (r6.getVisibility() != 0) goto L32;
            if (r1 == false) goto L26;
            r3 = Math.min(r3, this.f11492i.getLeft());
        L27:
            int r7 = this.f11492i.getRight();
            if (r1 == false) goto L30;
            r7 = Math.max(r4, r7);
        L30:
            r4 = r7;
            goto L32
        L26:
            r3 = this.f11492i.getLeft();
        L32:
            return r4 - r3;
        L11:
            if (r5.getVisibility() != 0) goto L19;
            if (r2 == false) goto L14;
            r3 = Math.min(r3, this.f11491h.getLeft());
        L15:
            if (r2 == false) goto L17;
            int r8 = Math.max(r4, this.f11491h.getRight());
        L18:
            r4 = r8;
            goto L20
        L17:
            r8 = this.f11491h.getRight();
            goto L18
        L14:
            r3 = this.f11491h.getLeft();
            goto L15
        L5:
            if (r0.getVisibility() != 0) goto L7;
            int r9 = this.f11490g.getLeft();
            r4 = this.f11490g.getRight();
            r3 = r9;
            r2 = true;
            goto L8
        }

        public g getTab() {
            return this.f11489f;
        }

        public TextView getTextView() {
            return this.f11490g;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
            super.onInitializeAccessibilityEvent(r1);
            r1.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
            super.onInitializeAccessibilityNodeInfo(r1);
            r1.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r11, int r12) {
            int r0 = View.MeasureSpec.getSize(r11);
            int r1 = View.MeasureSpec.getMode(r11);
            int r2 = this.m.getTabMaxWidth();
            LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) this.f11490g.getLayoutParams();
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r11 = View.MeasureSpec.makeMeasureSpec(this.m.w, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r11, r12);
            if (this.f11490g == null) goto L42;
            getResources();
            OTabLayoutBase r4 = this.m;
            float r5 = r4.s;
            int r6 = this.f11495l;
            int r7 = OTabLayoutBase.b(r4);
            int r8 = OTabLayoutBase.c(this.m);
            ImageView r9 = this.f11491h;
            boolean r10 = true;
            if (r9 != null) goto L12;
        L14:
            TextView r13 = this.f11490g;
            if (r13 != null) goto L17;
        L20:
            if (this.f11490g != null) goto L22;
        L26:
            float r14 = this.f11490g.getTextSize();
            int r15 = this.f11490g.getLineCount();
            int r16 = TextViewCompat.getMaxLines(this.f11490g);
            if (r5 != r14) goto L31;
            if (r16 < 0) goto L43;
            if (r6 != r16) goto L31;
            return;
        L43:
            return;
        L31:
            if (this.m.C != 1) goto L39;
            if (r5 <= r14) goto L39;
            if (r15 != 1) goto L39;
            Layout r17 = this.f11490g.getLayout();
            if (r17 != null) goto L37;
        L38:
            r10 = false;
            goto L39
        L37:
            if (a(r17, 0, r5) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L38;
        L39:
            if (r10 == false) goto L45;
            this.f11490g.setTextSize(0, r5);
            this.f11490g.setMaxLines(r6);
            r3.topMargin = r7;
            r3.leftMargin = r8;
            r3.rightMargin = r8;
            this.f11490g.setLayoutParams(r3);
            super.onMeasure(r11, r12);
            return;
        L45:
            return;
        L22:
            if (isSelected() == false) goto L26;
            int r18 = this.m.u;
            if (r18 <= 0) goto L26;
            r5 = r18;
            r7 = 0;
            r8 = 0;
            goto L26
        L17:
            if (r13.getLineCount() <= 1) goto L20;
            r5 = this.m.t;
            goto L20
        L12:
            if (r9.getVisibility() != 0) goto L14;
            r6 = 1;
            goto L20
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r0 = super.performClick();
            if (this.f11489f == null) goto L12;
            if (r0 == true) goto L7;
            playSoundEffect(0);
        L7:
            if (OTabLayoutBase.a(this.m) == null) goto L9;
            OTabLayoutBase.a(this.m).a(this.f11489f);
        L10:
            d.g.d.d.a.b(getContext(), 1);
            return true;
        L9:
            this.f11489f.h();
            goto L10
        L12:
            return r0;
        }

        @Override // android.view.View
        public void setSelected(boolean r3) {
            if (isSelected() == r3) goto L5;
            boolean r0 = true;
        L6:
            super.setSelected(r3);
            if (r0 == false) goto L12;
            if (r3 == false) goto L12;
            if (Build.VERSION.SDK_INT >= 16) goto L12;
            sendAccessibilityEvent(4);
        L12:
            TextView r1 = this.f11490g;
            if (r1 == null) goto L20;
            r1.setSelected(r3);
            this.f11490g.setTypeface(Typeface.DEFAULT_BOLD);
            if (r3 == false) goto L19;
            int r2 = this.m.u;
            if (r2 <= 0) goto L19;
            this.f11490g.setTextSize(r2);
        L19:
            this.f11490g.setTextSize(this.m.s);
        L20:
            ImageView r4 = this.f11491h;
            if (r4 == null) goto L23;
            r4.setSelected(r3);
        L23:
            View r5 = this.f11492i;
            if (r5 == null) goto L27;
            r5.setSelected(r3);
            return;
        L27:
            return;
        L5:
            r0 = false;
            goto L6
        }

        void setTab(@Nullable g r2) {
            if (r2 == this.f11489f) goto L6;
            this.f11489f = r2;
            d();
            return;
        }
    }

    public static class i implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f11496a;

        public i(ViewPager r1) {
            this.f11496a = r1;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void a(g r1) {
            this.f11496a.setCurrentItem(r1.d());
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void b(g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.d
        public void c(g r1) {
        }
    }

    static {
        R = new FastOutSlowInInterpolator();
        S = new Pools.SynchronizedPool(16);
    }

    private void E(int r3) {
        h r0 = (h) this.f11453h.getChildAt(r3);
        this.f11453h.removeViewAt(r3);
        if (r0 == null) goto L5;
        r0.b();
        this.Q.release(r0);
    L5:
        requestLayout();
    }

    private void L(@Nullable ViewPager r3, boolean r4, boolean r5) {
        ViewPager r0 = this.I;
        if (r0 == null) goto L10;
        TabLayoutOnPageChangeListener r1 = this.L;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        b r2 = this.M;
        if (r2 == null) goto L10;
        this.I.removeOnAdapterChangeListener(r2);
    L10:
        d r6 = this.G;
        if (r6 == null) goto L13;
        D(r6);
        this.G = null;
    L13:
        if (r3 == null) goto L24;
        this.I = r3;
        if (this.L != null) goto L17;
        this.L = new TabLayoutOnPageChangeListener(this);
    L17:
        this.L.b();
        r3.addOnPageChangeListener(this.L);
        i r7 = new i(r3);
        this.G = r7;
        g(r7);
        PagerAdapter r8 = r3.getAdapter();
        if (r8 == null) goto L21;
        H(r8, r4);
    L21:
        if (this.M != null) goto L23;
        this.M = new b(this);
    L23:
        this.M.a(r4);
        r3.addOnAdapterChangeListener(this.M);
        I(r3.getCurrentItem(), 0.0f, true);
    L25:
        this.N = r5;
        return;
    L24:
        this.I = null;
        H(null, false);
        goto L25
    }

    private void M() {
        int r0 = this.f11451f.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.f11451f.get(r1).o();
        r1 = r1 + 1;
        goto L3
    }

    private void N(LinearLayout.LayoutParams r3) {
        if (this.C == 1) goto L5;
    L7:
        r3.width = -2;
        float r0 = 0.0f;
    L8:
        r3.weight = r0;
        int r2 = this.f11454i;
        if (r2 == 0) goto L12;
        r3.leftMargin = r2;
        r3.rightMargin = r2;
        return;
    L12:
        return;
    L5:
        if (this.B != 0) goto L7;
        r3.width = 0;
        r0 = 1.0f;
        goto L8
    }

    static /* synthetic */ c a(OTabLayoutBase r0) {
        return r0.P;
    }

    static /* synthetic */ int b(OTabLayoutBase r0) {
        return r0.f11456k;
    }

    static /* synthetic */ int c(OTabLayoutBase r0) {
        return r0.f11455j;
    }

    static /* synthetic */ f d(OTabLayoutBase r0) {
        return r0.f11453h;
    }

    static /* synthetic */ int[] e() {
        return HorizontalScrollView.SELECTED_STATE_SET;
    }

    static /* synthetic */ boolean f(OTabLayoutBase r0) {
        return r0.O;
    }

    private int getDefaultHeight() {
        int r0 = this.f11451f.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        g r3 = this.f11451f.get(r2);
        if (r3 == null) goto L13;
        if (r3.c() == null) goto L11;
        if (TextUtils.isEmpty(r3.e()) == true) goto L11;
    L14:
        return 56;
    L11:
        if (r3.b() != null) goto L14;
    L13:
        r2 = r2 + 1;
        goto L3
    L21:
        return 56;
    }

    private float getScrollPosition() {
        return this.f11453h.d();
    }

    private int getTabMinWidth() {
        int r0 = this.x;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (this.C == 0) goto L10;
        return 0;
    L10:
        return this.z;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f11453h.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void k(@NonNull com.obric.oui.tab.b r5) {
        com.obric.oui.tab.c r0 = new com.obric.oui.tab.c(getContext());
        g r1 = A(0);
        if (r5.getText() == null) goto L6;
        r0.getTitle().setText(r5.getText());
        r1.n(r5.getText());
    L6:
        if (r5.getIcon() == null) goto L8;
        r0.getIcon().setImageDrawable(r5.getIcon());
    L8:
        r0.setTextColor(this.r);
        r0.setSelectedBgColor(Integer.valueOf(ContextCompat.getColor(getContext(), com.obric.common.oui.c.x)));
        r1.k(r0);
        h(r1);
    }

    private void l(@NonNull com.obric.oui.tab.d r3) {
        g r0 = A(0);
        CharSequence r1 = r3.f11511f;
        if (r1 == null) goto L5;
        r0.n(r1);
    L5:
        Drawable r2 = r3.f11512g;
        if (r2 == null) goto L8;
        r0.l(r2);
    L8:
        int r4 = r3.f11513h;
        if (r4 == 0) goto L12;
        r0.j(r4);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.i(r3.getContentDescription());
    L14:
        h(r0);
    }

    private void m(g r3) {
        h r0 = r3.f11488g;
        this.f11453h.addView(r0, r3.d(), s());
    }

    private void n(View r2) {
        if ((r2 instanceof com.obric.oui.tab.d) == false) goto L6;
        l((com.obric.oui.tab.d) r2);
        return;
    L6:
        if ((r2 instanceof com.obric.oui.tab.b) == false) goto L10;
        k((com.obric.oui.tab.b) r2);
        return;
    }

    private void o(int r3) {
        if (r3 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L12:
        I(r3, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L12;
        this.f11453h.c();
        throw null;
    }

    private void p() {
        if (this.C != 0) goto L5;
        int r0 = Math.max(0, this.A - this.f11457l);
    L6:
        ViewCompat.setPaddingRelative(this.f11453h, r0, 0, 0, 0);
        int r1 = this.C;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L12;
        this.f11453h.setGravity(1);
    L12:
        O(true);
        return;
    L11:
        this.f11453h.setGravity(GravityCompat.START);
        goto L12
    L5:
        r0 = 0;
        goto L6
    }

    private int q(int r4, float r5) {
        int r1 = 0;
        if (this.C != 0) goto L21;
        View r0 = this.f11453h.getChildAt(r4);
        int r6 = r4 + 1;
        if (r6 >= this.f11453h.getChildCount()) goto L7;
        View r7 = this.f11453h.getChildAt(r6);
    L8:
        if (r0 == null) goto L10;
        int r2 = r0.getWidth();
    L11:
        if (r7 == null) goto L13;
        int r8 = r7.getWidth();
    L14:
        if (r0 == null) goto L16;
        r1 = r0.getLeft();
    L16:
        int r3 = (r1 + (r2 / 2)) - (getWidth() / 2);
        int r9 = (int) ((((r2 + r8) + (this.f11454i * 4)) * 0.5f) * r5);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r3 + r9;
    L20:
        return r3 - r9;
    L13:
        r8 = 0;
        goto L14
    L10:
        r2 = 0;
        goto L11
    L7:
        r7 = null;
        goto L8
    L21:
        return 0;
    }

    private void r(g r2, int r3) {
        r2.m(r3);
        this.f11451f.add(r3, r2);
        int r4 = this.f11451f.size();
    L3:
        r3 = r3 + 1;
        if (r3 >= r4) goto L6;
        this.f11451f.get(r3).m(r3);
        goto L3
    }

    private LinearLayout.LayoutParams s() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        r0.rightMargin = this.p;
        N(r0);
        return r0;
    }

    private void setSelectedTabView(int r6) {
        int r0 = this.f11453h.getChildCount();
        if (r6 >= r0) goto L11;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L15;
        View r3 = this.f11453h.getChildAt(r2);
        if (r2 != r6) goto L9;
        boolean r4 = true;
    L10:
        r3.setSelected(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        r4 = false;
        goto L10
    L15:
        return;
    }

    private h t() {
        Pools.Pool<h> r0 = this.Q;
        if (r0 == null) goto L5;
        h r1 = r0.acquire();
    L6:
        if (r1 != null) goto L8;
        r1 = new h(this, getContext());
    L8:
        r1.setFocusable(true);
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    private void u(@NonNull g r3) {
        int r0 = this.F.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.F.get(r0).c(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void v(@NonNull g r3) {
        int r0 = this.F.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.F.get(r0).a(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void w(@NonNull g r3) {
        int r0 = this.F.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.F.get(r0).b(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void y() {
        if (this.H != null) goto L6;
        ValueAnimator r0 = new ValueAnimator();
        this.H = r0;
        r0.setInterpolator(R);
        this.H.setDuration(200);
        this.H.addUpdateListener(new a(this));
        return;
    }

    @NonNull
    public g A(int r3) {
        g r0 = S.acquire();
        if (r0 != null) goto L5;
        r0 = new g();
    L5:
        r0.f11487f = this;
        h r2 = t();
        r0.f11488g = r2;
        if (r3 <= 0) goto L8;
        r2.c(r0, false);
        r0.j(r3);
    L9:
        return r0;
    L8:
        r2.setTab(r0);
        goto L9
    }

    void B() {
        C();
        PagerAdapter r0 = this.f11450J;
        if (r0 == null) goto L17;
        int r1 = r0.getCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        g r3 = A(this.D);
        r3.n(this.f11450J.getPageTitle(r2));
        j(r3, false);
        r2 = r2 + 1;
        goto L5
    L7:
        ViewPager r4 = this.I;
        if (r4 == null) goto L18;
        if (r1 <= 0) goto L19;
        int r5 = r4.getCurrentItem();
        if (r5 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r5 >= getTabCount()) goto L21;
        F(z(r5));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public void C() {
        int r0 = this.f11453h.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        E(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        Iterator<g> r1 = this.f11451f.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        g r2 = r1.next();
        r1.remove();
        r2.g();
        S.release(r2);
        goto L7
    L9:
        this.f11452g = null;
    }

    public void D(@NonNull d r1) {
        this.F.remove(r1);
    }

    void F(g r2) {
        G(r2, true);
    }

    void G(g r5, boolean r6) {
        g r0 = this.f11452g;
        if (r0 != r5) goto L7;
        if (r0 == null) goto L25;
        u(r5);
        o(r5.d());
        return;
    L25:
        return;
    L7:
        if (r5 == null) goto L9;
        int r2 = r5.d();
    L10:
        if (r6 == false) goto L19;
        if (r0 != null) goto L13;
    L14:
        if (r2 == (-1)) goto L16;
        I(r2, 0.0f, true);
    L17:
        if (r2 == (-1)) goto L19;
        setSelectedTabView(r2);
    L16:
        o(r2);
        goto L17
    L13:
        if (r0.d() != (-1)) goto L16;
    L19:
        if (r0 == null) goto L21;
        w(r0);
    L21:
        this.f11452g = r5;
        if (r5 == null) goto L27;
        v(r5);
        return;
    L27:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    void H(@Nullable PagerAdapter r3, boolean r4) {
        PagerAdapter r0 = this.f11450J;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.K;
        if (r1 == null) goto L7;
        r0.unregisterDataSetObserver(r1);
    L7:
        this.f11450J = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.K != null) goto L13;
        this.K = new e(this);
    L13:
        r3.registerDataSetObserver(this.K);
    L14:
        B();
    }

    public void I(int r2, float r3, boolean r4) {
        J(r2, r3, r4, true);
    }

    void J(int r3, float r4, boolean r5, boolean r6) {
        int r0 = Math.round(r3 + r4);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.f11453h.getChildCount()) goto L21;
        if (r6 == true) goto L17;
        ValueAnimator r7 = this.H;
        if (r7 != null) goto L11;
    L13:
        scrollTo(q(r3, r4), 0);
        if (r5 == false) goto L20;
        setSelectedTabView(r0);
        return;
    L20:
        return;
    L11:
        if (r7.isRunning() == false) goto L13;
        this.H.cancel();
        goto L13
    L17:
        this.f11453h.e(r3, r4);
        throw null;
    }

    public void K(@Nullable ViewPager r2, boolean r3) {
        L(r2, r3, false);
    }

    void O(boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.f11453h.getChildCount()) goto L9;
        View r1 = this.f11453h.getChildAt(r0);
        N((LinearLayout.LayoutParams) r1.getLayoutParams());
        if (r4 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1) {
        n(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2) {
        n(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        n(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r1, ViewGroup.LayoutParams r2) {
        n(r1);
    }

    public void g(@NonNull d r2) {
        if (this.F.contains(r2) == true) goto L6;
        this.F.add(r2);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        g r0 = this.f11452g;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.d();
    }

    public int getTabCount() {
        return this.f11451f.size();
    }

    public int getTabGravity() {
        return this.B;
    }

    int getTabMaxWidth() {
        return this.w;
    }

    public int getTabMode() {
        return this.C;
    }

    public int getTabStripLeftPadding() {
        return this.f11453h.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.f11453h.getPaddingRight();
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.r;
    }

    public void h(@NonNull g r2) {
        j(r2, this.f11451f.isEmpty());
    }

    public void i(@NonNull g r2, int r3, boolean r4) {
        if (r2.f11487f != this) goto L9;
        r(r2, r3);
        m(r2);
        if (r4 == false) goto L10;
        r2.h();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void j(@NonNull g r2, boolean r3) {
        i(r2, this.f11451f.size(), r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.I != null) goto L8;
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewPager) == false) goto L9;
        L((ViewPager) r0, true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N == false) goto L6;
        setupWithViewPager(null);
        this.N = false;
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r6, int r7) {
        int r0 = (x(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r1 = View.MeasureSpec.getMode(r7);
        if (r1 == Integer.MIN_VALUE) goto L7;
        if (r1 != 0) goto L8;
        r7 = View.MeasureSpec.makeMeasureSpec(r0, BasicMeasure.EXACTLY);
    L8:
        int r2 = View.MeasureSpec.getSize(r6);
        if (View.MeasureSpec.getMode(r6) == 0) goto L15;
        int r3 = this.y;
        if (r3 > 0) goto L14;
        r3 = r2 - x(56);
    L14:
        this.w = r3;
    L15:
        super.onMeasure(r6, r7);
        boolean r4 = true;
        if (getChildCount() != 1) goto L32;
        boolean r8 = false;
        View r5 = getChildAt(0);
        int r9 = this.C;
        if (r9 == 0) goto L25;
        if (r9 == 1) goto L22;
    L29:
        if (r8 == false) goto L33;
        r5.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), HorizontalScrollView.getChildMeasureSpec(r7, getPaddingTop() + getPaddingBottom(), r5.getLayoutParams().height));
        return;
    L33:
        return;
    L22:
        if (r5.getMeasuredWidth() != getMeasuredWidth()) goto L28;
    L27:
        r4 = false;
    L28:
        r8 = r4;
        goto L29
    L25:
        if (r5.getMeasuredWidth() >= getMeasuredWidth()) goto L27;
    L32:
        return;
    L7:
        r7 = View.MeasureSpec.makeMeasureSpec(Math.min(r0, View.MeasureSpec.getSize(r7)), BasicMeasure.EXACTLY);
        goto L8
    }

    @Override // android.view.View
    protected boolean overScrollBy(int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, boolean r19) {
        return super.overScrollBy(r11, r12, r13, r14, r15, r16, 80, r18, r19);
    }

    public void setAutoFillWhenScrollable(boolean r1) {
    }

    public void setContentInsetStart(int r1) {
        this.A = r1;
    }

    public void setCustomTabViewResId(int r1) {
        this.D = r1;
    }

    public void setOnTabClickListener(c r1) {
        this.P = r1;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable d r2) {
        d r0 = this.E;
        if (r0 == null) goto L5;
        D(r0);
    L5:
        this.E = r2;
        if (r2 == null) goto L9;
        g(r2);
        return;
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r1) {
        y();
        this.H.addListener(r1);
    }

    public void setSelectedTabHorizontalPadding(int r1) {
        this.f11453h.h(r1);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r1) {
        this.f11453h.f(r1);
    }

    public void setSelectedTabIndicatorHeight(int r1) {
        this.f11453h.g(r1);
    }

    public void setShowSelectedIndicator(Boolean r1) {
        this.f11453h.i(r1.booleanValue());
    }

    public void setShowTopLine(Boolean r1) {
        this.f11453h.j(r1.booleanValue());
    }

    public void setTabBackgroundResId(int r1) {
        this.v = r1;
    }

    public void setTabGravity(int r2) {
        if (this.B == r2) goto L6;
        this.B = r2;
        p();
        return;
    }

    public void setTabMargin(int r5) {
        this.f11454i = x(r5);
        int r0 = 0;
    L4:
        if (r0 >= getTabCount()) goto L6;
        View r1 = this.f11453h.getChildAt(r0);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        r2.leftMargin = x(r5);
        r2.rightMargin = x(r5);
        r1.setLayoutParams(r2);
        r0 = r0 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r1) {
        this.y = r1;
    }

    public void setTabMinWidth(int r1) {
        this.x = r1;
    }

    public void setTabMode(int r2) {
        if (r2 == this.C) goto L6;
        this.C = r2;
        p();
        return;
    }

    public void setTabMode(String r2) {
        r2.hashCode();
        if (r2.equals("scrollable") == true) goto L12;
        if (r2.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.C == 1) goto L14;
        this.C = 1;
    L10:
        p();
        return;
    L14:
        return;
    L12:
        if (this.C == 0) goto L16;
        this.C = 0;
        goto L10
    }

    public void setTabPaddingBottom(int r1) {
        this.o = r1;
    }

    public void setTabPaddingEnd(int r1) {
        this.n = r1;
    }

    public void setTabPaddingStart(int r1) {
        this.f11457l = r1;
    }

    public void setTabPaddingTop(int r1) {
        this.m = r1;
    }

    @Deprecated
    public void setTabTextAppearance(int r1) {
        this.q = r1;
    }

    public void setTabTextColors(@Nullable ColorStateList r2) {
        if (this.r == r2) goto L6;
        this.r = r2;
        M();
        return;
    }

    public void setTabTextSize(float r2) {
        if (this.s == r2) goto L6;
        this.s = r2;
        M();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r2) {
        H(r2, false);
    }

    public void setupWithViewPager(@Nullable ViewPager r2) {
        K(r2, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    int x(int r1) {
        return Math.round(getResources().getDisplayMetrics().density * r1);
    }

    @Nullable
    public g z(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return this.f11451f.get(r2);
    }
}
