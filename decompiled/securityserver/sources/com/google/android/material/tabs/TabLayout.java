package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;

    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEF_STYLE_RES = 0;

    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";

    @Dimension(unit = 0)
    private static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;

    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = null;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;

    @Nullable
    private BaseOnTabSelectedListener currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;

    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;

    @Nullable
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;

    @Nullable
    private Tab selectedTab;
    private boolean setupViewPagerImplicitly;

    @NonNull
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;

    @Nullable
    Drawable tabSelectedIndicator;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final RectF tabViewContentBounds;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;

    @Nullable
    ViewPager viewPager;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;
        final /* synthetic */ TabLayout this$0;

        public AdapterChangeListener(TabLayout r1) {
            this.this$0 = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager r2, @Nullable PagerAdapter r3, @Nullable PagerAdapter r4) {
            TabLayout r5 = this.this$0;
            if (r5.viewPager != r2) goto L6;
            r5.setPagerAdapter(r4, this.autoRefresh);
            return;
        }

        public void setAutoRefresh(boolean r1) {
            this.autoRefresh = r1;
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T r1);

        void onTabSelected(T r1);

        void onTabUnselected(T r1);
    }

    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    public class PagerAdapterObserver extends DataSetObserver {
        final /* synthetic */ TabLayout this$0;

        public PagerAdapterObserver(TabLayout r1) {
            this.this$0 = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.this$0.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.populateFromPagerAdapter();
        }
    }

    public class SlidingTabIndicator extends LinearLayout {
        private int animationStartLeft;
        private int animationStartRight;

        @NonNull
        private final GradientDrawable defaultSelectionIndicator;
        ValueAnimator indicatorAnimator;
        int indicatorLeft;
        int indicatorRight;
        private int layoutDirection;
        private int selectedIndicatorHeight;

        @NonNull
        private final Paint selectedIndicatorPaint;
        int selectedPosition;
        float selectionOffset;
        final /* synthetic */ TabLayout this$0;

        public SlidingTabIndicator(TabLayout r1, Context r2) {
            this.this$0 = r1;
            super(r2);
            this.selectedPosition = -1;
            this.layoutDirection = -1;
            this.indicatorLeft = -1;
            this.indicatorRight = -1;
            this.animationStartLeft = -1;
            this.animationStartRight = -1;
            setWillNotDraw(false);
            this.selectedIndicatorPaint = new Paint();
            this.defaultSelectionIndicator = new GradientDrawable();
        }

        public static /* synthetic */ int access$1200(SlidingTabIndicator r0) {
            return r0.animationStartLeft;
        }

        public static /* synthetic */ int access$1300(SlidingTabIndicator r0) {
            return r0.animationStartRight;
        }

        private void calculateTabViewContentBounds(@NonNull TabView r3, @NonNull RectF r4) {
            int r0 = TabView.access$1400(r3);
            int r2 = (int) ViewUtils.dpToPx(getContext(), 24);
            if (r0 >= r2) goto L5;
            r0 = r2;
        L5:
            int r5 = (r3.getRight() + r3.getLeft()) / 2;
            int r1 = r0 / 2;
            r4.set(r5 - r1, 0.0f, r5 + r1, 0.0f);
        }

        private void updateIndicatorPosition() {
            View r0 = getChildAt(this.selectedPosition);
            if (r0 != null) goto L5;
        L21:
            int r1 = -1;
            int r2 = -1;
        L22:
            setIndicatorPosition(r1, r2);
            return;
        L5:
            if (r0.getWidth() <= 0) goto L21;
            r1 = r0.getLeft();
            r2 = r0.getRight();
            TabLayout r3 = this.this$0;
            if (r3.tabIndicatorFullWidth == true) goto L12;
            if ((r0 instanceof TabView) == false) goto L12;
            calculateTabViewContentBounds((TabView) r0, TabLayout.access$1100(r3));
            r1 = (int) TabLayout.access$1100(this.this$0).left;
            r2 = (int) TabLayout.access$1100(this.this$0).right;
        L12:
            if (this.selectionOffset <= 0.0f) goto L22;
            if (this.selectedPosition >= (getChildCount() - 1)) goto L22;
            View r4 = getChildAt(this.selectedPosition + 1);
            int r5 = r4.getLeft();
            int r6 = r4.getRight();
            TabLayout r7 = this.this$0;
            if (r7.tabIndicatorFullWidth == false) goto L18;
        L20:
            float r8 = this.selectionOffset;
            r1 = (int) (((1.0f - r8) * r1) + (r5 * r8));
            r2 = (int) (((1.0f - r8) * r2) + (r6 * r8));
            goto L22
        L18:
            if ((r4 instanceof TabView) == false) goto L20;
            calculateTabViewContentBounds((TabView) r4, TabLayout.access$1100(r7));
            r5 = (int) TabLayout.access$1100(this.this$0).left;
            r6 = (int) TabLayout.access$1100(this.this$0).right;
            goto L20
        }

        private void updateOrRecreateIndicatorAnimation(boolean r6, final int r7, int r8) {
            View r0 = getChildAt(r7);
            if (r0 != null) goto L6;
            updateIndicatorPosition();
            return;
        L6:
            final int r1 = r0.getLeft();
            final int r2 = r0.getRight();
            TabLayout r3 = this.this$0;
            if (r3.tabIndicatorFullWidth == false) goto L9;
        L11:
            int r4 = this.indicatorLeft;
            int r5 = this.indicatorRight;
            if (r4 != r1) goto L15;
            if (r5 != r2) goto L15;
            return;
        L15:
            if (r6 == false) goto L17;
            this.animationStartLeft = r4;
            this.animationStartRight = r5;
        L17:
            ValueAnimator.AnimatorUpdateListener r9 = new AnonymousClass1(this, r1, r2);
            if (r6 == false) goto L20;
            ValueAnimator r10 = new ValueAnimator();
            this.indicatorAnimator = r10;
            r10.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            r10.setDuration(r8);
            r10.setFloatValues(new float[]{0.0f, 1.0f});
            r10.addUpdateListener(r9);
            r10.addListener(new AnonymousClass2(this, r7));
            r10.start();
            return;
        L20:
            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(r9);
            return;
        L9:
            if ((r0 instanceof TabView) == false) goto L11;
            calculateTabViewContentBounds((TabView) r0, TabLayout.access$1100(r3));
            r1 = (int) TabLayout.access$1100(this.this$0).left;
            r2 = (int) TabLayout.access$1100(this.this$0).right;
            goto L11
        }

        public void animateIndicatorToPosition(int r2, int r3) {
            ValueAnimator r0 = this.indicatorAnimator;
            if (r0 != null) goto L5;
        L7:
            updateOrRecreateIndicatorAnimation(true, r2, r3);
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        public boolean childrenNeedLayout() {
            int r0 = getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (getChildAt(r2).getWidth() <= 0) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas r6) {
            Drawable r0 = this.this$0.tabSelectedIndicator;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.getIntrinsicHeight();
        L6:
            int r3 = this.selectedIndicatorHeight;
            if (r3 < 0) goto L9;
            r2 = r3;
        L9:
            int r4 = this.this$0.tabIndicatorGravity;
            if (r4 != 0) goto L12;
            r1 = getHeight() - r2;
            r2 = getHeight();
        L20:
            int r5 = this.indicatorLeft;
            if (r5 >= 0) goto L23;
        L32:
            super.draw(r6);
            return;
        L23:
            if (this.indicatorRight <= r5) goto L32;
            Drawable r7 = this.this$0.tabSelectedIndicator;
            if (r7 != null) goto L28;
            r7 = this.defaultSelectionIndicator;
        L28:
            Drawable r8 = DrawableCompat.wrap(r7).mutate();
            r8.setBounds(this.indicatorLeft, r1, this.indicatorRight, r2);
            Paint r9 = this.selectedIndicatorPaint;
            if (r9 == null) goto L31;
            DrawableCompat.setTint(r8, r9.getColor());
        L31:
            r8.draw(r6);
            goto L32
        L12:
            if (r4 == 1) goto L18;
            if (r4 == 2) goto L20;
            if (r4 == 3) goto L17;
            r2 = 0;
            goto L20
        L17:
            r2 = getHeight();
            goto L20
        L18:
            r1 = (getHeight() - r2) / 2;
            r2 = (getHeight() + r2) / 2;
            goto L20
        L5:
            r2 = 0;
            goto L6
        }

        public float getIndicatorPosition() {
            return this.selectedPosition + this.selectionOffset;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            ValueAnimator r6 = this.indicatorAnimator;
            if (r6 != null) goto L5;
        L7:
            updateIndicatorPosition();
            return;
        L5:
            if (r6.isRunning() == false) goto L7;
            updateOrRecreateIndicatorAnimation(false, this.selectedPosition, -1);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r9, int r10) {
            super.onMeasure(r9, r10);
            if (View.MeasureSpec.getMode(r9) == 1073741824) goto L5;
            return;
        L5:
            TabLayout r0 = this.this$0;
            boolean r3 = true;
            if (r0.tabGravity != 1) goto L8;
        L9:
            int r1 = getChildCount();
            int r2 = 0;
            int r4 = 0;
            int r5 = 0;
        L10:
            if (r4 >= r1) goto L15;
            View r6 = getChildAt(r4);
            if (r6.getVisibility() != 0) goto L14;
            r5 = Math.max(r5, r6.getMeasuredWidth());
        L14:
            r4 = r4 + 1;
            goto L10
        L15:
            if (r5 > 0) goto L18;
            return;
        L18:
            if ((r5 * r1) > (getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2))) goto L28;
            boolean r7 = false;
        L20:
            if (r2 >= r1) goto L27;
            LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) getChildAt(r2).getLayoutParams();
            if (r8.width == r5) goto L24;
        L25:
            r8.width = r5;
            r8.weight = 0.0f;
            r7 = true;
        L26:
            r2 = r2 + 1;
            goto L20
        L24:
            if (r8.weight == 0.0f) goto L26;
        L27:
            r3 = r7;
        L29:
            if (r3 == false) goto L39;
            super.onMeasure(r9, r10);
            return;
        L39:
            return;
        L28:
            TabLayout r11 = this.this$0;
            r11.tabGravity = 0;
            r11.updateTabViews(false);
            goto L29
        L8:
            if (r0.mode == 2) goto L9;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r1) {
            super.onRtlPropertiesChanged(r1);
        }

        public void setIndicatorPosition(int r2, int r3) {
            if (r2 == this.indicatorLeft) goto L5;
        L6:
            this.indicatorLeft = r2;
            this.indicatorRight = r3;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L5:
            if (r3 != this.indicatorRight) goto L6;
        }

        public void setIndicatorPositionFromTabPosition(int r2, float r3) {
            ValueAnimator r0 = this.indicatorAnimator;
            if (r0 != null) goto L5;
        L7:
            this.selectedPosition = r2;
            this.selectionOffset = r3;
            updateIndicatorPosition();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        public void setSelectedIndicatorColor(int r2) {
            if (this.selectedIndicatorPaint.getColor() == r2) goto L6;
            this.selectedIndicatorPaint.setColor(r2);
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        public void setSelectedIndicatorHeight(int r2) {
            if (this.selectedIndicatorHeight == r2) goto L6;
            this.selectedIndicatorHeight = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;

        @Nullable
        private CharSequence contentDesc;

        @Nullable
        private View customView;

        @Nullable
        private Drawable icon;

        @LabelVisibility
        private int labelVisibilityMode;

        @Nullable
        public TabLayout parent;
        private int position;

        @Nullable
        private Object tag;

        @Nullable
        private CharSequence text;

        @NonNull
        public TabView view;

        public Tab() {
            this.position = -1;
            this.labelVisibilityMode = 1;
        }

        public static /* synthetic */ CharSequence access$100(Tab r0) {
            return r0.contentDesc;
        }

        public static /* synthetic */ int access$1000(Tab r0) {
            return r0.labelVisibilityMode;
        }

        public static /* synthetic */ CharSequence access$200(Tab r0) {
            return r0.text;
        }

        @Nullable
        public BadgeDrawable getBadge() {
            return TabView.access$800(this.view);
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView r0 = this.view;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return TabView.access$600(this.view);
        }

        public int getPosition() {
            return this.position;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L10;
            if (r0.getSelectedTabPosition() != this.position) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            TabView.access$700(this.view);
        }

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            r0.selectTab(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int r2) {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setContentDescription(r0.getResources().getText(r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View r1) {
            this.customView = r1;
            updateView();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable r4) {
            this.icon = r4;
            TabLayout r5 = this.parent;
            if (r5.tabGravity != 1) goto L5;
        L6:
            r5.updateTabViews(true);
        L7:
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$400(this.view) == false) goto L14;
            if (TabView.access$500(this.view).isVisible() == false) goto L14;
            this.view.invalidate();
            goto L14
        L5:
            if (r5.mode != 2) goto L7;
            goto L6
        }

        public void setPosition(int r1) {
            this.position = r1;
        }

        @NonNull
        public Tab setTabLabelVisibility(@LabelVisibility int r4) {
            this.labelVisibilityMode = r4;
            TabLayout r5 = this.parent;
            if (r5.tabGravity != 1) goto L5;
        L6:
            r5.updateTabViews(true);
        L7:
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
        L14:
            return this;
        L10:
            if (TabView.access$400(this.view) == false) goto L14;
            if (TabView.access$500(this.view).isVisible() == false) goto L14;
            this.view.invalidate();
            goto L14
        L5:
            if (r5.mode != 2) goto L7;
            goto L6
        }

        @NonNull
        public Tab setTag(@Nullable Object r1) {
            this.tag = r1;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence r2) {
            if (TextUtils.isEmpty(this.contentDesc) == true) goto L5;
        L7:
            this.text = r2;
            updateView();
            return this;
        L5:
            if (TextUtils.isEmpty(r2) == true) goto L7;
            this.view.setContentDescription(r2);
            goto L7
        }

        public void updateView() {
            TabView r0 = this.view;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int r4) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(r4, this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence r1) {
            this.contentDesc = r1;
            updateView();
            return this;
        }

        @NonNull
        public Tab setText(@StringRes int r2) {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setText(r0.getResources().getText(r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setIcon(@DrawableRes int r2) {
            TabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setIcon(AppCompatResources.getDrawable(r0.getContext(), r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;

        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout r2) {
            this.tabLayoutRef = new WeakReference(r2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r6, float r7, int r8) {
            TabLayout r9 = this.tabLayoutRef.get();
            if (r9 == null) goto L17;
            int r0 = this.scrollState;
            boolean r1 = false;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L14:
            r1 = true;
        L15:
            r9.setScrollPosition(r6, r7, r4, r1);
            return;
        L13:
            if (this.previousScrollState == 0) goto L15;
        L7:
            if (this.previousScrollState == 1) goto L10;
            r4 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r4) {
            TabLayout r0 = this.tabLayoutRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.scrollState;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.selectTab(r0.getTabAt(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends LinearLayout {

        @Nullable
        private View badgeAnchorView;

        @Nullable
        private BadgeDrawable badgeDrawable;

        @Nullable
        private Drawable baseBackgroundDrawable;

        @Nullable
        private ImageView customIconView;

        @Nullable
        private TextView customTextView;

        @Nullable
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;
        final /* synthetic */ TabLayout this$0;

        public TabView(@NonNull TabLayout r4, Context r5) {
            this.this$0 = r4;
            super(r5);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(r5);
            ViewCompat.setPaddingRelative(this, r4.tabPaddingStart, r4.tabPaddingTop, r4.tabPaddingEnd, r4.tabPaddingBottom);
            setGravity(17);
            setOrientation(!r4.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public static /* synthetic */ void access$000(TabView r0, Context r1) {
            r0.updateBackgroundDrawable(r1);
        }

        public static /* synthetic */ int access$1400(TabView r0) {
            return r0.getContentWidth();
        }

        public static /* synthetic */ void access$300(TabView r0, Canvas r1) {
            r0.drawBackground(r1);
        }

        public static /* synthetic */ boolean access$400(TabView r0) {
            return r0.hasBadgeDrawable();
        }

        public static /* synthetic */ BadgeDrawable access$500(TabView r0) {
            return r0.badgeDrawable;
        }

        public static /* synthetic */ BadgeDrawable access$600(TabView r0) {
            return r0.getOrCreateBadge();
        }

        public static /* synthetic */ void access$700(TabView r0) {
            r0.removeBadge();
        }

        public static /* synthetic */ BadgeDrawable access$800(TabView r0) {
            return r0.getBadge();
        }

        public static /* synthetic */ void access$900(TabView r0, View r1) {
            r0.tryUpdateBadgeDrawableBounds(r1);
        }

        private void addOnLayoutChangeListener(@Nullable final View r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            r2.addOnLayoutChangeListener(new AnonymousClass1(this, r2));
        }

        private float approximateLineWidth(@NonNull Layout r1, int r2, float r3) {
            float r0 = r1.getLineWidth(r2);
            return (r3 / r1.getPaint().getTextSize()) * r0;
        }

        private void clipViewToPaddingForBadge(boolean r1) {
            setClipChildren(r1);
            setClipToPadding(r1);
            ViewGroup r0 = (ViewGroup) getParent();
            if (r0 == null) goto L6;
            r0.setClipChildren(r1);
            r0.setClipToPadding(r1);
            return;
        }

        @NonNull
        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout r0 = new FrameLayout(getContext());
            r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return r0;
        }

        private void drawBackground(@NonNull Canvas r6) {
            Drawable r0 = this.baseBackgroundDrawable;
            if (r0 == null) goto L6;
            r0.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.baseBackgroundDrawable.draw(r6);
            return;
        }

        @Nullable
        private BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        private int getContentWidth() {
            int r4 = 0;
            View[] r3 = {this.textView, this.iconView, this.customView};
            int r8 = 0;
            int r1 = 0;
            boolean r5 = false;
        L3:
            if (r4 >= 3) goto L17;
            View r6 = r3[r4];
            if (r6 == null) goto L15;
            if (r6.getVisibility() != 0) goto L15;
            if (r5 == false) goto L10;
            r1 = Math.min(r1, r6.getLeft());
        L11:
            if (r5 == false) goto L13;
            r8 = Math.max(r8, r6.getRight());
        L14:
            r5 = true;
            goto L15
        L13:
            r8 = r6.getRight();
            goto L14
        L10:
            r1 = r6.getLeft();
        L15:
            r4 = r4 + 1;
            goto L3
        L17:
            return r8 - r1;
        }

        @Nullable
        private FrameLayout getCustomParentForBadge(@NonNull View r3) {
            if (r3 == this.iconView) goto L8;
            if (r3 == this.textView) goto L8;
            return null;
        L8:
            if (BadgeUtils.USE_COMPAT_PARENT == true) goto L10;
            return null;
        L10:
            return (FrameLayout) r3.getParent();
        }

        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable != null) goto L5;
            this.badgeDrawable = BadgeDrawable.create(getContext());
        L5:
            tryUpdateBadgeAnchor();
            BadgeDrawable r1 = this.badgeDrawable;
            if (r1 == null) goto L9;
            return r1;
        L9:
            throw new IllegalStateException("Unable to create badge");
        }

        private boolean hasBadgeDrawable() {
            if (this.badgeDrawable == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void inflateAndAddDefaultIconView() {
            if (BadgeUtils.USE_COMPAT_PARENT == false) goto L5;
            FrameLayout r0 = createPreApi18BadgeAnchorRoot();
            addView(r0, 0);
            ViewGroup r1 = r0;
        L6:
            ImageView r2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, r1, false);
            this.iconView = r2;
            r1.addView(r2, 0);
            return;
        L5:
            r1 = this;
            goto L6
        }

        private void inflateAndAddDefaultTextView() {
            if (BadgeUtils.USE_COMPAT_PARENT == false) goto L5;
            FrameLayout r0 = createPreApi18BadgeAnchorRoot();
            addView(r0);
            ViewGroup r1 = r0;
        L6:
            TextView r2 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, r1, false);
            this.textView = r2;
            r1.addView(r2);
            return;
        L5:
            r1 = this;
            goto L6
        }

        private void removeBadge() {
            if (this.badgeAnchorView == null) goto L5;
            tryRemoveBadgeFromAnchor();
        L5:
            this.badgeDrawable = null;
        }

        private void tryAttachBadgeToAnchor(@Nullable View r3) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r3 == null) goto L8;
            clipViewToPaddingForBadge(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, r3, getCustomParentForBadge(r3));
            this.badgeAnchorView = r3;
            return;
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            clipViewToPaddingForBadge(true);
            View r0 = this.badgeAnchorView;
            if (r0 == null) goto L9;
            BadgeUtils.detachBadgeDrawable(this.badgeDrawable, r0, getCustomParentForBadge(r0));
            this.badgeAnchorView = null;
            return;
        }

        private void tryUpdateBadgeAnchor() {
            if (hasBadgeDrawable() == true) goto L6;
            return;
        L6:
            if (this.customView == null) goto L9;
            tryRemoveBadgeFromAnchor();
            return;
        L9:
            if (this.iconView == null) goto L19;
            Tab r0 = this.tab;
            if (r0 == null) goto L19;
            if (r0.getIcon() == null) goto L19;
            View r1 = this.badgeAnchorView;
            ImageView r2 = this.iconView;
            if (r1 == r2) goto L17;
            tryRemoveBadgeFromAnchor();
            tryAttachBadgeToAnchor(this.iconView);
            return;
        L17:
            tryUpdateBadgeDrawableBounds(r2);
            return;
        L19:
            if (this.textView == null) goto L28;
            Tab r3 = this.tab;
            if (r3 == null) goto L28;
            if (r3.getTabLabelVisibility() != 1) goto L28;
            View r4 = this.badgeAnchorView;
            TextView r5 = this.textView;
            if (r4 == r5) goto L27;
            tryRemoveBadgeFromAnchor();
            tryAttachBadgeToAnchor(this.textView);
            return;
        L27:
            tryUpdateBadgeDrawableBounds(r5);
            return;
        L28:
            tryRemoveBadgeFromAnchor();
        }

        private void tryUpdateBadgeDrawableBounds(@NonNull View r2) {
            if (hasBadgeDrawable() == true) goto L5;
            return;
        L5:
            if (r2 != this.badgeAnchorView) goto L9;
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, r2, getCustomParentForBadge(r2));
            return;
        }

        private void updateBackgroundDrawable(Context r6) {
            int r0 = this.this$0.tabBackgroundResId;
            GradientDrawable r1 = null;
            if (r0 == 0) goto L9;
            Drawable r7 = AppCompatResources.getDrawable(r6, r0);
            this.baseBackgroundDrawable = r7;
            if (r7 != null) goto L7;
        L10:
            GradientDrawable r8 = new GradientDrawable();
            r8.setColor(0);
            Drawable r9 = r8;
            if (this.this$0.tabRippleColorStateList == null) goto L19;
            GradientDrawable r2 = new GradientDrawable();
            r2.setCornerRadius(1.0E-5f);
            r2.setColor(-1);
            ColorStateList r3 = RippleUtils.convertToRippleDrawableColor(this.this$0.tabRippleColorStateList);
            boolean r4 = this.this$0.unboundedRipple;
            GradientDrawable r10 = r8;
            if (r4 == false) goto L15;
            r10 = null;
        L15:
            if (r4 == true) goto L18;
            r1 = r2;
        L18:
            r9 = new RippleDrawable(r3, r10, r1);
        L19:
            ViewCompat.setBackground(this, r9);
            this.this$0.invalidate();
            return;
        L7:
            if (r7.isStateful() == false) goto L10;
            this.baseBackgroundDrawable.setState(getDrawableState());
            goto L10
        L9:
            this.baseBackgroundDrawable = null;
            goto L10
        }

        private void updateTextAndIcon(@Nullable TextView r7, @Nullable ImageView r8) {
            Tab r0 = this.tab;
            CharSequence r1 = null;
            if (r0 != null) goto L5;
        L7:
            Drawable r2 = null;
        L8:
            Tab r3 = this.tab;
            if (r3 == null) goto L11;
            CharSequence r4 = r3.getText();
        L13:
            if (r8 == null) goto L17;
            if (r2 == null) goto L16;
            r8.setImageDrawable(r2);
            r8.setVisibility(0);
            setVisibility(0);
            goto L17
        L16:
            r8.setVisibility(8);
            r8.setImageDrawable(null);
        L17:
            boolean r5 = !TextUtils.isEmpty(r4);
            if (r7 == null) goto L26;
            if (r5 == false) goto L25;
            r7.setText(r4);
            if (Tab.access$1000(this.tab) != 1) goto L23;
            r7.setVisibility(0);
        L24:
            setVisibility(0);
            goto L26
        L23:
            r7.setVisibility(8);
            goto L24
        L25:
            r7.setVisibility(8);
            r7.setText(null);
        L26:
            if (r8 == null) goto L41;
            ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
            if (r5 == true) goto L30;
        L32:
            int r6 = 0;
        L34:
            if (this.this$0.inlineLabel == false) goto L39;
            if (r6 == MarginLayoutParamsCompat.getMarginEnd(r9)) goto L41;
            MarginLayoutParamsCompat.setMarginEnd(r9, r6);
            r9.bottomMargin = 0;
            r8.setLayoutParams(r9);
            r8.requestLayout();
            goto L41
        L39:
            if (r6 == r9.bottomMargin) goto L41;
            r9.bottomMargin = r6;
            MarginLayoutParamsCompat.setMarginEnd(r9, 0);
            r8.setLayoutParams(r9);
            r8.requestLayout();
            goto L41
        L30:
            if (r8.getVisibility() != 0) goto L32;
            r6 = (int) ViewUtils.dpToPx(getContext(), 8);
        L41:
            Tab r10 = this.tab;
            if (r10 == null) goto L44;
            CharSequence r11 = Tab.access$100(r10);
        L45:
            if (r5 == true) goto L48;
            r1 = r11;
        L48:
            TooltipCompat.setTooltipText(this, r1);
            return;
        L44:
            r11 = null;
            goto L45
        L11:
            r4 = null;
            goto L13
        L5:
            if (r0.getIcon() == null) goto L7;
            r2 = DrawableCompat.wrap(this.tab.getIcon()).mutate();
            goto L8
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] r0 = getDrawableState();
            Drawable r1 = this.baseBackgroundDrawable;
            if (r1 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L11;
            invalidate();
            this.this$0.invalidate();
            return;
        L11:
            return;
        L5:
            if (r1.isStateful() == false) goto L7;
            r2 = this.baseBackgroundDrawable.setState(r0);
            goto L8
        }

        @Nullable
        public Tab getTab() {
            return this.tab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r8) {
            super.onInitializeAccessibilityNodeInfo(r8);
            BadgeDrawable r0 = this.badgeDrawable;
            if (r0 != null) goto L5;
        L7:
            AccessibilityNodeInfoCompat r9 = AccessibilityNodeInfoCompat.wrap(r8);
            r9.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected() == false) goto L10;
            r9.setClickable(false);
            r9.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        L10:
            r9.setRoleDescription("Tab");
            return;
        L5:
            if (r0.isVisible() == false) goto L7;
            r8.setContentDescription(getContentDescription() + ", " + this.badgeDrawable.getContentDescription());
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r8, int r9) {
            int r0 = View.MeasureSpec.getSize(r8);
            int r1 = View.MeasureSpec.getMode(r8);
            int r2 = this.this$0.getTabMaxWidth();
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r8 = View.MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r8, r9);
            if (this.textView == null) goto L34;
            float r3 = this.this$0.tabTextSize;
            int r4 = this.defaultMaxLines;
            ImageView r5 = this.iconView;
            if (r5 != null) goto L12;
        L14:
            TextView r6 = this.textView;
            if (r6 != null) goto L17;
        L19:
            float r7 = this.textView.getTextSize();
            int r10 = this.textView.getLineCount();
            int r11 = TextViewCompat.getMaxLines(this.textView);
            if (r3 != r7) goto L24;
            if (r11 < 0) goto L35;
            if (r4 != r11) goto L24;
            return;
        L35:
            return;
        L24:
            if (this.this$0.mode != 1) goto L32;
            if (r3 <= r7) goto L32;
            if (r10 != 1) goto L32;
            Layout r12 = this.textView.getLayout();
            if (r12 != null) goto L30;
            return;
        L30:
            if (approximateLineWidth(r12, 0, r3) <= ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L32;
            return;
        L32:
            this.textView.setTextSize(0, r3);
            this.textView.setMaxLines(r4);
            super.onMeasure(r8, r9);
            return;
        L17:
            if (r6.getLineCount() <= 1) goto L19;
            r3 = this.this$0.tabTextMultiLineSize;
            goto L19
        L12:
            if (r5.getVisibility() != 0) goto L14;
            r4 = 1;
            goto L19
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r0 = super.performClick();
            if (this.tab == null) goto L8;
            if (r0 == true) goto L6;
            playSoundEffect(0);
        L6:
            this.tab.select();
            return true;
        L8:
            return r0;
        }

        public void reset() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean r2) {
            isSelected();
            super.setSelected(r2);
            TextView r0 = this.textView;
            if (r0 == null) goto L5;
            r0.setSelected(r2);
        L5:
            ImageView r1 = this.iconView;
            if (r1 == null) goto L8;
            r1.setSelected(r2);
        L8:
            View r3 = this.customView;
            if (r3 == null) goto L12;
            r3.setSelected(r2);
            return;
        }

        public void setTab(@Nullable Tab r2) {
            if (r2 == this.tab) goto L6;
            this.tab = r2;
            update();
            return;
        }

        public final void update() {
            Tab r0 = this.tab;
            Drawable r1 = null;
            if (r0 == null) goto L5;
            View r2 = r0.getCustomView();
        L6:
            if (r2 == null) goto L22;
            ViewParent r3 = r2.getParent();
            if (r3 == this) goto L12;
            if (r3 == null) goto L11;
            ((ViewGroup) r3).removeView(r2);
        L11:
            addView(r2);
        L12:
            this.customView = r2;
            TextView r4 = this.textView;
            if (r4 == null) goto L15;
            r4.setVisibility(8);
        L15:
            ImageView r5 = this.iconView;
            if (r5 == null) goto L18;
            r5.setVisibility(8);
            this.iconView.setImageDrawable(null);
        L18:
            TextView r6 = (TextView) r2.findViewById(android.R.id.text1);
            this.customTextView = r6;
            if (r6 == null) goto L21;
            this.defaultMaxLines = TextViewCompat.getMaxLines(r6);
        L21:
            this.customIconView = (ImageView) r2.findViewById(android.R.id.icon);
        L27:
            if (this.customView == null) goto L29;
            TextView r7 = this.customTextView;
            if (r7 == null) goto L49;
        L50:
            updateTextAndIcon(r7, this.customIconView);
        L51:
            if (r0 != null) goto L53;
        L55:
            if (r0 != null) goto L57;
        L59:
            boolean r8 = false;
        L60:
            setSelected(r8);
            return;
        L57:
            if (r0.isSelected() == false) goto L59;
            r8 = true;
            goto L60
        L53:
            if (TextUtils.isEmpty(Tab.access$100(r0)) == true) goto L55;
            setContentDescription(Tab.access$100(r0));
            goto L55
        L49:
            if (this.customIconView == null) goto L51;
        L29:
            if (this.iconView != null) goto L31;
            inflateAndAddDefaultIconView();
        L31:
            if (r0 != null) goto L33;
        L35:
            if (r1 == null) goto L40;
            DrawableCompat.setTintList(r1, this.this$0.tabIconTint);
            PorterDuff.Mode r9 = this.this$0.tabIconTintMode;
            if (r9 == null) goto L40;
            DrawableCompat.setTintMode(r1, r9);
        L40:
            if (this.textView != null) goto L42;
            inflateAndAddDefaultTextView();
            this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
        L42:
            TextViewCompat.setTextAppearance(this.textView, this.this$0.tabTextAppearance);
            ColorStateList r10 = this.this$0.tabTextColors;
            if (r10 == null) goto L45;
            this.textView.setTextColor(r10);
        L45:
            updateTextAndIcon(this.textView, this.iconView);
            tryUpdateBadgeAnchor();
            addOnLayoutChangeListener(this.iconView);
            addOnLayoutChangeListener(this.textView);
            goto L51
        L33:
            if (r0.getIcon() == null) goto L35;
            r1 = DrawableCompat.wrap(r0.getIcon()).mutate();
            goto L35
        L22:
            View r11 = this.customView;
            if (r11 == null) goto L25;
            removeView(r11);
            this.customView = null;
        L25:
            this.customTextView = null;
            this.customIconView = null;
            goto L27
        L5:
            r2 = null;
            goto L6
        }

        public final void updateOrientation() {
            setOrientation(!this.this$0.inlineLabel ? 1 : 0);
            TextView r0 = this.customTextView;
            if (r0 == null) goto L5;
        L8:
            updateTextAndIcon(r0, this.customIconView);
            return;
        L5:
            if (this.customIconView != null) goto L8;
            updateTextAndIcon(this.textView, this.iconView);
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager r1) {
            this.viewPager = r1;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab r1) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull Tab r1) {
            this.viewPager.setCurrentItem(r1.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab r1) {
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
        tabPool = new Pools.SynchronizedPool(16);
    }

    public TabLayout(@NonNull Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ RectF access$1100(TabLayout r0) {
        return r0.tabViewContentBounds;
    }

    private void addTabFromItemView(@NonNull TabItem r3) {
        Tab r0 = newTab();
        CharSequence r1 = r3.text;
        if (r1 == null) goto L5;
        r0.setText(r1);
    L5:
        Drawable r2 = r3.icon;
        if (r2 == null) goto L8;
        r0.setIcon(r2);
    L8:
        int r4 = r3.customLayout;
        if (r4 == 0) goto L12;
        r0.setCustomView(r4);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.setContentDescription(r3.getContentDescription());
    L14:
        addTab(r0);
    }

    private void addTabView(@NonNull Tab r3) {
        TabView r0 = r3.view;
        r0.setSelected(false);
        r0.setActivated(false);
        this.slidingTabIndicator.addView(r0, r3.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View r2) {
        if ((r2 instanceof TabItem) == false) goto L7;
        addTabFromItemView((TabItem) r2);
        return;
    L7:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int r4) {
        if (r4 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        setScrollPosition(r4, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        if (this.slidingTabIndicator.childrenNeedLayout() == true) goto L17;
        int r0 = getScrollX();
        int r1 = calculateScrollXForTab(r4, 0.0f);
        if (r0 == r1) goto L15;
        ensureScrollAnimator();
        this.scrollAnimator.setIntValues(new int[]{r0, r1});
        this.scrollAnimator.start();
    L15:
        this.slidingTabIndicator.animateIndicatorToPosition(r4, this.tabIndicatorAnimationDuration);
    }

    private void applyGravityForModeScrollable(int r2) {
        if (r2 != 0) goto L4;
        Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    L10:
        this.slidingTabIndicator.setGravity(GravityCompat.START);
        return;
    L4:
        if (r2 != 1) goto L6;
        this.slidingTabIndicator.setGravity(1);
        return;
    L6:
        if (r2 == 2) goto L10;
    }

    private void applyModeAndGravity() {
        int r0 = this.mode;
        if (r0 == 0) goto L7;
        if (r0 == 2) goto L7;
        int r1 = 0;
    L8:
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, r1, 0, 0, 0);
        int r2 = this.mode;
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L14;
    L18:
        updateTabViews(true);
        return;
    L14:
        if (this.tabGravity != 2) goto L16;
        Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
    L16:
        this.slidingTabIndicator.setGravity(1);
        goto L18
    L17:
        applyGravityForModeScrollable(this.tabGravity);
    L7:
        r1 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
        goto L8
    }

    private int calculateScrollXForTab(int r5, float r6) {
        int r0 = this.mode;
        int r1 = 0;
        if (r0 == 0) goto L7;
        if (r0 == 2) goto L7;
        return 0;
    L7:
        View r2 = this.slidingTabIndicator.getChildAt(r5);
        int r7 = r5 + 1;
        if (r7 >= this.slidingTabIndicator.getChildCount()) goto L10;
        View r8 = this.slidingTabIndicator.getChildAt(r7);
    L11:
        if (r2 == null) goto L13;
        int r3 = r2.getWidth();
    L14:
        if (r8 == null) goto L16;
        r1 = r8.getWidth();
    L16:
        int r4 = ((r3 / 2) + r2.getLeft()) - (getWidth() / 2);
        int r9 = (int) (((r3 + r1) * 0.5f) * r6);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r4 + r9;
    L20:
        return r4 - r9;
    L13:
        r3 = 0;
        goto L14
    L10:
        r8 = null;
        goto L11
    }

    private void configureTab(@NonNull Tab r2, int r3) {
        r2.setPosition(r3);
        this.tabs.add(r3, r2);
        int r4 = this.tabs.size();
    L3:
        r3 = r3 + 1;
        if (r3 >= r4) goto L6;
        this.tabs.get(r3).setPosition(r3);
        goto L3
    }

    @NonNull
    private static ColorStateList createColorStateList(int r4, int r5) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(r0);
        return r0;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab r3) {
        Pools.Pool<TabView> r0 = this.tabViewPool;
        if (r0 == null) goto L5;
        TabView r1 = r0.acquire();
    L6:
        if (r1 != null) goto L8;
        r1 = new TabView(this, getContext());
    L8:
        r1.setTab(r3);
        r1.setFocusable(true);
        r1.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(Tab.access$100(r3)) == false) goto L11;
        r1.setContentDescription(Tab.access$200(r3));
    L12:
        return r1;
    L11:
        r1.setContentDescription(Tab.access$100(r3));
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private void dispatchTabReselected(@NonNull Tab r3) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.selectedListeners.get(r0).onTabReselected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabSelected(@NonNull Tab r3) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.selectedListeners.get(r0).onTabSelected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabUnselected(@NonNull Tab r3) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.selectedListeners.get(r0).onTabUnselected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator != null) goto L6;
        ValueAnimator r0 = new ValueAnimator();
        this.scrollAnimator = r0;
        r0.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
        this.scrollAnimator.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int r0 = this.tabs.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        Tab r2 = this.tabs.get(r1);
        if (r2 == null) goto L13;
        if (r2.getIcon() == null) goto L13;
        if (TextUtils.isEmpty(r2.getText()) == true) goto L13;
        if (this.inlineLabel == true) goto L14;
        return DEFAULT_HEIGHT_WITH_TEXT_ICON;
    L13:
        r1 = r1 + 1;
    L14:
        return 48;
    }

    private int getTabMinWidth() {
        int r0 = this.requestedTabMinWidth;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = this.mode;
        if (r1 == 0) goto L12;
        if (r1 == 2) goto L12;
        return 0;
    L12:
        return this.scrollableTabMinWidth;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int r3) {
        TabView r0 = (TabView) this.slidingTabIndicator.getChildAt(r3);
        this.slidingTabIndicator.removeViewAt(r3);
        if (r0 == null) goto L5;
        r0.reset();
        this.tabViewPool.release(r0);
    L5:
        requestLayout();
    }

    private void setSelectedTabView(int r7) {
        int r0 = this.slidingTabIndicator.getChildCount();
        if (r7 >= r0) goto L15;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L19;
        View r3 = this.slidingTabIndicator.getChildAt(r2);
        boolean r4 = true;
        if (r2 != r7) goto L9;
        boolean r5 = true;
    L10:
        r3.setSelected(r5);
        if (r2 == r7) goto L14;
        r4 = false;
    L14:
        r3.setActivated(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        r5 = false;
        goto L10
    L19:
        return;
    }

    private void updateAllTabs() {
        int r0 = this.tabs.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.tabs.get(r1).updateView();
        r1 = r1 + 1;
        goto L3
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams r3) {
        if (this.mode == 1) goto L5;
    L7:
        r3.width = -2;
        r3.weight = 0.0f;
        return;
    L5:
        if (this.tabGravity != 0) goto L7;
        r3.width = 0;
        r3.weight = 1.0f;
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener r1) {
        addOnTabSelectedListener(r1);
    }

    public void addTab(@NonNull Tab r2) {
        addTab(r2, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1) {
        addViewInternal(r1);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab createTabFromPool() {
        Tab r0 = tabPool.acquire();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Tab();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public int getSelectedTabPosition() {
        Tab r0 = this.selectedTab;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getPosition();
    }

    @Nullable
    public Tab getTabAt(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return this.tabs.get(r2);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @Nullable
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public Tab newTab() {
        Tab r0 = createTabFromPool();
        r0.parent = this;
        r0.view = createTabView(r0);
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager != null) goto L8;
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewPager) == false) goto L9;
        setupWithViewPager((ViewPager) r0, true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly == false) goto L6;
        setupWithViewPager(null);
        this.setupViewPagerImplicitly = false;
        return;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r1 = this.slidingTabIndicator.getChildAt(r0);
        if ((r1 instanceof TabView) == false) goto L8;
        TabView.access$300((TabView) r1, r4);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        super.onDraw(r4);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        AccessibilityNodeInfoCompat.wrap(r3).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        int r0 = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int r1 = View.MeasureSpec.getMode(r8);
        if (r1 == Integer.MIN_VALUE) goto L8;
        if (r1 != 0) goto L12;
        r8 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + (getPaddingTop() + r0), BasicMeasure.EXACTLY);
    L12:
        int r2 = View.MeasureSpec.getSize(r7);
        if (View.MeasureSpec.getMode(r7) == 0) goto L19;
        int r3 = this.requestedTabMaxWidth;
        if (r3 > 0) goto L18;
        r3 = (int) (r2 - ViewUtils.dpToPx(getContext(), TAB_MIN_WIDTH_MARGIN));
    L18:
        this.tabMaxWidth = r3;
    L19:
        super.onMeasure(r7, r8);
        if (getChildCount() != 1) goto L34;
        View r9 = getChildAt(0);
        int r4 = this.mode;
        if (r4 == 0) goto L31;
        if (r4 == 1) goto L28;
        if (r4 == 2) goto L31;
        return;
    L28:
        if (r9.getMeasuredWidth() == getMeasuredWidth()) goto L35;
    L32:
        r9.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), ViewGroup.getChildMeasureSpec(r8, getPaddingBottom() + getPaddingTop(), r9.getLayoutParams().height));
        return;
    L35:
        return;
    L31:
        if (r9.getMeasuredWidth() < getMeasuredWidth()) goto L32;
        return;
    L34:
        return;
    L8:
        if (getChildCount() != 1) goto L12;
        if (View.MeasureSpec.getSize(r8) < r0) goto L12;
        getChildAt(0).setMinimumHeight(r0);
        goto L12
    }

    public void populateFromPagerAdapter() {
        removeAllTabs();
        PagerAdapter r0 = this.pagerAdapter;
        if (r0 == null) goto L17;
        int r1 = r0.getCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        addTab(newTab().setText(this.pagerAdapter.getPageTitle(r2)), false);
        r2 = r2 + 1;
        goto L5
    L7:
        ViewPager r3 = this.viewPager;
        if (r3 == null) goto L18;
        if (r1 <= 0) goto L19;
        int r4 = r3.getCurrentItem();
        if (r4 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r4 >= getTabCount()) goto L21;
        selectTab(getTabAt(r4));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public boolean releaseFromTabPool(Tab r1) {
        return tabPool.release(r1);
    }

    public void removeAllTabs() {
        int r0 = this.slidingTabIndicator.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        removeTabViewAt(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        Iterator<Tab> r1 = this.tabs.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Tab r2 = r1.next();
        r1.remove();
        r2.reset();
        releaseFromTabPool(r2);
        goto L7
    L9:
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener r1) {
        removeOnTabSelectedListener(r1);
    }

    public void removeTab(@NonNull Tab r2) {
        if (r2.parent != this) goto L7;
        removeTabAt(r2.getPosition());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r6) {
        Tab r0 = this.selectedTab;
        if (r0 == null) goto L5;
        int r1 = r0.getPosition();
    L6:
        removeTabViewAt(r6);
        Tab r2 = this.tabs.remove(r6);
        if (r2 == null) goto L9;
        r2.reset();
        releaseFromTabPool(r2);
    L9:
        int r3 = this.tabs.size();
        int r4 = r6;
    L10:
        if (r4 >= r3) goto L12;
        this.tabs.get(r4).setPosition(r4);
        r4 = r4 + 1;
        goto L10
    L12:
        if (r1 == r6) goto L14;
        return;
    L14:
        if (this.tabs.isEmpty() == false) goto L16;
        Tab r7 = null;
    L17:
        selectTab(r7);
        return;
    L16:
        r7 = this.tabs.get(Math.max(0, r6 - 1));
        goto L17
    L5:
        r1 = 0;
        goto L6
    }

    public void selectTab(@Nullable Tab r2) {
        selectTab(r2, true);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    public void setInlineLabel(boolean r3) {
        if (this.inlineLabel == r3) goto L16;
        this.inlineLabel = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L11;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        ((TabView) r0).updateOrientation();
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        applyModeAndGravity();
        return;
    }

    public void setInlineLabelResource(@BoolRes int r2) {
        setInlineLabel(getResources().getBoolean(r2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener r1) {
        setOnTabSelectedListener(r1);
    }

    public void setPagerAdapter(@Nullable PagerAdapter r3, boolean r4) {
        PagerAdapter r0 = this.pagerAdapter;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.pagerAdapterObserver;
        if (r1 == null) goto L7;
        r0.unregisterDataSetObserver(r1);
    L7:
        this.pagerAdapter = r3;
        if (r4 == false) goto L14;
        if (r3 == null) goto L14;
        if (this.pagerAdapterObserver != null) goto L13;
        this.pagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r3.registerDataSetObserver(this.pagerAdapterObserver);
    L14:
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r1) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(r1);
    }

    public void setScrollPosition(int r2, float r3, boolean r4) {
        setScrollPosition(r2, r3, r4, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable r2) {
        if (this.tabSelectedIndicator == r2) goto L6;
        this.tabSelectedIndicator = r2;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        return;
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r1) {
        this.slidingTabIndicator.setSelectedIndicatorColor(r1);
    }

    public void setSelectedTabIndicatorGravity(int r2) {
        if (this.tabIndicatorGravity == r2) goto L6;
        this.tabIndicatorGravity = r2;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        return;
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int r1) {
        this.slidingTabIndicator.setSelectedIndicatorHeight(r1);
    }

    public void setTabGravity(int r2) {
        if (this.tabGravity == r2) goto L6;
        this.tabGravity = r2;
        applyModeAndGravity();
        return;
    }

    public void setTabIconTint(@Nullable ColorStateList r2) {
        if (this.tabIconTint == r2) goto L6;
        this.tabIconTint = r2;
        updateAllTabs();
        return;
    }

    public void setTabIconTintResource(@ColorRes int r2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setTabIndicatorFullWidth(boolean r1) {
        this.tabIndicatorFullWidth = r1;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int r2) {
        if (r2 == this.mode) goto L6;
        this.mode = r2;
        applyModeAndGravity();
        return;
    }

    public void setTabRippleColor(@Nullable ColorStateList r3) {
        if (this.tabRippleColorStateList == r3) goto L11;
        this.tabRippleColorStateList = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        TabView.access$000((TabView) r0, getContext());
    L10:
        r4 = r4 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(@ColorRes int r2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setTabTextColors(@Nullable ColorStateList r2) {
        if (this.tabTextColors == r2) goto L6;
        this.tabTextColors = r2;
        updateAllTabs();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r2) {
        setPagerAdapter(r2, false);
    }

    public void setUnboundedRipple(boolean r3) {
        if (this.unboundedRipple == r3) goto L11;
        this.unboundedRipple = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        TabView.access$000((TabView) r0, getContext());
    L10:
        r4 = r4 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(@BoolRes int r2) {
        setUnboundedRipple(getResources().getBoolean(r2));
    }

    public void setupWithViewPager(@Nullable ViewPager r2) {
        setupWithViewPager(r2, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateTabViews(boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r1 = this.slidingTabIndicator.getChildAt(r0);
        r1.setMinimumWidth(getTabMinWidth());
        updateTabViewLayoutParams((LinearLayout.LayoutParams) r1.getLayoutParams());
        if (r4 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public TabLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r2) {
        if (this.selectedListeners.contains(r2) == true) goto L6;
        this.selectedListeners.add(r2);
        return;
    }

    public void addTab(@NonNull Tab r2, int r3) {
        addTab(r2, r3, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2) {
        addViewInternal(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r1) {
        this.selectedListeners.remove(r1);
    }

    public void selectTab(@Nullable Tab r5, boolean r6) {
        Tab r0 = this.selectedTab;
        if (r0 != r5) goto L7;
        if (r0 == null) goto L25;
        dispatchTabReselected(r5);
        animateToTab(r5.getPosition());
        return;
    L25:
        return;
    L7:
        if (r5 == null) goto L9;
        int r2 = r5.getPosition();
    L10:
        if (r6 == false) goto L19;
        if (r0 != null) goto L13;
    L14:
        if (r2 == (-1)) goto L16;
        setScrollPosition(r2, 0.0f, true);
    L17:
        if (r2 == (-1)) goto L19;
        setSelectedTabView(r2);
    L16:
        animateToTab(r2);
        goto L17
    L13:
        if (r0.getPosition() != (-1)) goto L16;
    L19:
        this.selectedTab = r5;
        if (r0 == null) goto L22;
        dispatchTabUnselected(r0);
    L22:
        if (r5 == null) goto L27;
        dispatchTabSelected(r5);
        return;
    L27:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener r2) {
        BaseOnTabSelectedListener r0 = this.selectedListener;
        if (r0 == null) goto L5;
        removeOnTabSelectedListener(r0);
    L5:
        this.selectedListener = r2;
        if (r2 == null) goto L9;
        addOnTabSelectedListener(r2);
        return;
    }

    public void setScrollPosition(int r3, float r4, boolean r5, boolean r6) {
        int r0 = Math.round(r3 + r4);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L20;
        if (r6 == false) goto L9;
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(r3, r4);
    L9:
        ValueAnimator r7 = this.scrollAnimator;
        if (r7 != null) goto L12;
    L14:
        scrollTo(calculateScrollXForTab(r3, r4), 0);
        if (r5 == false) goto L19;
        setSelectedTabView(r0);
        return;
    L19:
        return;
    L12:
        if (r7.isRunning() == false) goto L14;
        this.scrollAnimator.cancel();
        goto L14
    }

    public void setupWithViewPager(@Nullable ViewPager r2, boolean r3) {
        setupWithViewPager(r2, r3, false);
    }

    public TabLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r4), r11, r12);
        this.tabs = new ArrayList();
        this.tabViewContentBounds = new RectF();
        this.tabMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.selectedListeners = new ArrayList();
        this.tabViewPool = new Pools.SimplePool(12);
        Context r13 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator r7 = new SlidingTabIndicator(this, r13);
        this.slidingTabIndicator = r7;
        super.addView(r7, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.TabLayout, r12, r4, new int[]{R.styleable.TabLayout_tabTextAppearance});
        if ((getBackground() instanceof ColorDrawable) == false) goto L5;
        ColorDrawable r15 = (ColorDrawable) getBackground();
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        r0.setFillColor(ColorStateList.valueOf(r15.getColor()));
        r0.initializeElevationOverlay(r13);
        r0.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, r0);
    L5:
        r7.setSelectedIndicatorHeight(r14.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        r7.setSelectedIndicatorColor(r14.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(MaterialResources.getDrawable(r13, r14, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(r14.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(r14.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int r16 = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = r16;
        this.tabPaddingEnd = r16;
        this.tabPaddingTop = r16;
        this.tabPaddingStart = r16;
        this.tabPaddingStart = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, r16);
        this.tabPaddingTop = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = r14.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        int r17 = r14.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = r17;
        TypedArray r18 = r13.obtainStyledAttributes(r17, androidx.appcompat.R.styleable.TextAppearance);
        this.tabTextSize = r18.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L15
        this.tabTextColors = MaterialResources.getColorStateList(r13, r18, androidx.appcompat.R.styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L15
        r18.recycle();
        if (r14.hasValue(R.styleable.TabLayout_tabTextColor) == false) goto L11;
        this.tabTextColors = MaterialResources.getColorStateList(r13, r14, R.styleable.TabLayout_tabTextColor);
    L11:
        if (r14.hasValue(R.styleable.TabLayout_tabSelectedTextColor) == false) goto L13;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r14.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
    L13:
        this.tabIconTint = MaterialResources.getColorStateList(r13, r14, R.styleable.TabLayout_tabIconTint);
        this.tabIconTintMode = ViewUtils.parseTintMode(r14.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
        this.tabRippleColorStateList = MaterialResources.getColorStateList(r13, r14, R.styleable.TabLayout_tabRippleColor);
        this.tabIndicatorAnimationDuration = r14.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
        this.requestedTabMinWidth = r14.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
        this.requestedTabMaxWidth = r14.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
        this.tabBackgroundResId = r14.getResourceId(R.styleable.TabLayout_tabBackground, 0);
        this.contentInsetStart = r14.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
        this.mode = r14.getInt(R.styleable.TabLayout_tabMode, 1);
        this.tabGravity = r14.getInt(R.styleable.TabLayout_tabGravity, 0);
        this.inlineLabel = r14.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
        this.unboundedRipple = r14.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
        r14.recycle();
        Resources r19 = getResources();
        this.tabTextMultiLineSize = r19.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.scrollableTabMinWidth = r19.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        applyModeAndGravity();
        return;
    L15:
        th = move-exception;
        r18.recycle();
        throw th;
    }

    private void setupWithViewPager(@Nullable ViewPager r3, boolean r4, boolean r5) {
        ViewPager r0 = this.viewPager;
        if (r0 == null) goto L10;
        TabLayoutOnPageChangeListener r1 = this.pageChangeListener;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        AdapterChangeListener r2 = this.adapterChangeListener;
        if (r2 == null) goto L10;
        this.viewPager.removeOnAdapterChangeListener(r2);
    L10:
        BaseOnTabSelectedListener r6 = this.currentVpSelectedListener;
        if (r6 == null) goto L13;
        removeOnTabSelectedListener(r6);
        this.currentVpSelectedListener = null;
    L13:
        if (r3 == null) goto L24;
        this.viewPager = r3;
        if (this.pageChangeListener != null) goto L17;
        this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
    L17:
        this.pageChangeListener.reset();
        r3.addOnPageChangeListener(this.pageChangeListener);
        ViewPagerOnTabSelectedListener r7 = new ViewPagerOnTabSelectedListener(r3);
        this.currentVpSelectedListener = r7;
        addOnTabSelectedListener(r7);
        PagerAdapter r8 = r3.getAdapter();
        if (r8 == null) goto L21;
        setPagerAdapter(r8, r4);
    L21:
        if (this.adapterChangeListener != null) goto L23;
        this.adapterChangeListener = new AdapterChangeListener(this);
    L23:
        this.adapterChangeListener.setAutoRefresh(r4);
        r3.addOnAdapterChangeListener(this.adapterChangeListener);
        setScrollPosition(r3.getCurrentItem(), 0.0f, true);
    L25:
        this.setupViewPagerImplicitly = r5;
        return;
    L24:
        this.viewPager = null;
        setPagerAdapter(null, false);
        goto L25
    }

    public void addTab(@NonNull Tab r2, boolean r3) {
        addTab(r2, this.tabs.size(), r3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r1, ViewGroup.LayoutParams r2) {
        addViewInternal(r1);
    }

    public void addTab(@NonNull Tab r2, int r3, boolean r4) {
        if (r2.parent != this) goto L9;
        configureTab(r2, r3);
        addTabView(r2);
        if (r4 == false) goto L10;
        r2.select();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        addViewInternal(r1);
    }

    public void setSelectedTabIndicator(@DrawableRes int r2) {
        if (r2 == 0) goto L4;
        setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), r2));
        return;
    L4:
        setSelectedTabIndicator(null);
    }

    public void setTabTextColors(int r1, int r2) {
        setTabTextColors(createColorStateList(r1, r2));
    }
}
