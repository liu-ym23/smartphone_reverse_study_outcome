package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    private static final int ACTION_BAR_ANIMATE_DELAY = 600;
    static final int[] ATTRS = null;
    private static final String TAG = "ActionBarOverlayLayout";
    private int mActionBarHeight;
    ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;

    @NonNull
    private WindowInsetsCompat mBaseInnerInsets;
    private final Rect mBaseInnerInsetsRect;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    ViewPropertyAnimator mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private OverScroller mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;

    @NonNull
    private WindowInsetsCompat mInnerInsets;
    private final Rect mInnerInsetsRect;
    private final Rect mLastBaseContentInsets;

    @NonNull
    private WindowInsetsCompat mLastBaseInnerInsets;
    private final Rect mLastBaseInnerInsetsRect;

    @NonNull
    private WindowInsetsCompat mLastInnerInsets;
    private final Rect mLastInnerInsetsRect;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    final AnimatorListenerAdapter mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean r1);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int r1);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }
    }

    static {
        ATTRS = new int[]{R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    }

    public ActionBarOverlayLayout(@NonNull Context r2) {
        this(r2, null);
    }

    private void addActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(@NonNull View r2, @NonNull Rect r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        LayoutParams r1 = (LayoutParams) r2.getLayoutParams();
        if (r4 == false) goto L7;
        int r8 = ((ViewGroup.MarginLayoutParams) r1).leftMargin;
        int r0 = r3.left;
        if (r8 == r0) goto L7;
        ((ViewGroup.MarginLayoutParams) r1).leftMargin = r0;
        boolean r9 = true;
    L8:
        if (r5 == false) goto L12;
        int r10 = ((ViewGroup.MarginLayoutParams) r1).topMargin;
        int r11 = r3.top;
        if (r10 == r11) goto L12;
        ((ViewGroup.MarginLayoutParams) r1).topMargin = r11;
        r9 = true;
    L12:
        if (r7 == false) goto L16;
        int r12 = ((ViewGroup.MarginLayoutParams) r1).rightMargin;
        int r13 = r3.right;
        if (r12 == r13) goto L16;
        ((ViewGroup.MarginLayoutParams) r1).rightMargin = r13;
        r9 = true;
    L16:
        if (r6 == false) goto L21;
        int r14 = ((ViewGroup.MarginLayoutParams) r1).bottomMargin;
        int r15 = r3.bottom;
        if (r14 == r15) goto L21;
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = r15;
        return true;
    L21:
        return r9;
    L7:
        r9 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar getDecorToolbar(View r2) {
        if ((r2 instanceof DecorToolbar) == false) goto L7;
        return (DecorToolbar) r2;
    L7:
        if ((r2 instanceof Toolbar) == false) goto L11;
        return ((Toolbar) r2).getWrapper();
    L11:
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(r2.getClass().getSimpleName()));
    }

    private void init(Context r5) {
        TypedArray r0 = getContext().getTheme().obtainStyledAttributes(ATTRS);
        boolean r1 = false;
        this.mActionBarHeight = r0.getDimensionPixelSize(0, 0);
        Drawable r3 = r0.getDrawable(1);
        this.mWindowContentOverlay = r3;
        if (r3 != null) goto L5;
        boolean r4 = true;
    L6:
        setWillNotDraw(r4);
        r0.recycle();
        if (r5.getApplicationInfo().targetSdkVersion >= 19) goto L9;
        r1 = true;
    L9:
        this.mIgnoreWindowContentOverlay = r1;
        this.mFlingEstimator = new OverScroller(r5);
        return;
    L5:
        r4 = false;
        goto L6
    }

    private void postAddActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mAddActionBarHideOffset, 600);
    }

    private void postRemoveActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mRemoveActionBarHideOffset, 600);
    }

    private void removeActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }

    private boolean shouldHideActionBarOnFling(float r10) {
        this.mFlingEstimator.fling(0, 0, 0, (int) r10, 0, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (this.mFlingEstimator.getFinalY() <= this.mActionBarTop.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    @Override // android.view.View
    public void draw(Canvas r6) {
        super.draw(r6);
        if (this.mWindowContentOverlay != null) goto L5;
        return;
    L5:
        if (this.mIgnoreWindowContentOverlay == false) goto L7;
        return;
    L7:
        if (this.mActionBarTop.getVisibility() != 0) goto L9;
        int r0 = (int) ((this.mActionBarTop.getTranslationY() + this.mActionBarTop.getBottom()) + 0.5f);
    L10:
        this.mWindowContentOverlay.setBounds(0, r0, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + r0);
        this.mWindowContentOverlay.draw(r6);
        return;
    L9:
        r0 = 0;
        goto L10
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r1) {
        return super.fitSystemWindows(r1);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer r0 = this.mActionBarTop;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return -((int) r0.getTranslationY());
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public CharSequence getTitle() {
        pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    public void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator r1 = this.mCurrentActionBarTopAnimator;
        if (r1 == null) goto L6;
        r1.cancel();
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasIcon() {
        pullChildren();
        return this.mDecorToolbar.hasIcon();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasLogo() {
        pullChildren();
        return this.mDecorToolbar.hasLogo();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void initFeature(int r2) {
        pullChildren();
        if (r2 != 2) goto L5;
        this.mDecorToolbar.initProgress();
        return;
    L5:
        if (r2 != 5) goto L7;
        this.mDecorToolbar.initIndeterminateProgress();
        return;
    L7:
        if (r2 != 109) goto L15;
        setOverlayMode(true);
        return;
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets r8) {
        pullChildren();
        WindowInsetsCompat r9 = WindowInsetsCompat.toWindowInsetsCompat(r8);
        boolean r0 = applyInsets(this.mActionBarTop, new Rect(r9.getSystemWindowInsetLeft(), r9.getSystemWindowInsetTop(), r9.getSystemWindowInsetRight(), r9.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, r9, this.mBaseContentInsets);
        Rect r1 = this.mBaseContentInsets;
        WindowInsetsCompat r2 = r9.inset(r1.left, r1.top, r1.right, r1.bottom);
        this.mBaseInnerInsets = r2;
        boolean r3 = true;
        if (this.mLastBaseInnerInsets.equals(r2) == true) goto L6;
        this.mLastBaseInnerInsets = this.mBaseInnerInsets;
        r0 = true;
    L6:
        if (this.mLastBaseContentInsets.equals(this.mBaseContentInsets) == true) goto L8;
        this.mLastBaseContentInsets.set(this.mBaseContentInsets);
    L9:
        if (r3 == false) goto L12;
        requestLayout();
    L12:
        return r9.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    L8:
        r3 = r0;
        goto L9
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L8;
        View r14 = getChildAt(r13);
        if (r14.getVisibility() == 8) goto L7;
        LayoutParams r0 = (LayoutParams) r14.getLayoutParams();
        int r1 = r14.getMeasuredWidth();
        int r2 = r14.getMeasuredHeight();
        int r3 = ((ViewGroup.MarginLayoutParams) r0).leftMargin + r11;
        int r4 = ((ViewGroup.MarginLayoutParams) r0).topMargin + r12;
        r14.layout(r3, r4, r1 + r3, r2 + r4);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r12, int r13) {
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, r12, 0, r13, 0);
        LayoutParams r0 = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int r1 = Math.max(0, (this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r0).leftMargin) + ((ViewGroup.MarginLayoutParams) r0).rightMargin);
        int r2 = Math.max(0, (this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r0).topMargin) + ((ViewGroup.MarginLayoutParams) r0).bottomMargin);
        int r3 = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) == 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L13;
        int r5 = this.mActionBarHeight;
        if (this.mHasNonEmbeddedTabs == true) goto L10;
    L16:
        this.mContentInsets.set(this.mBaseContentInsets);
        WindowInsetsCompat r6 = this.mBaseInnerInsets;
        this.mInnerInsets = r6;
        if (this.mOverlayMode == true) goto L20;
        if (r4 == true) goto L20;
        Rect r7 = this.mContentInsets;
        r7.top += r5;
        r7.bottom = r7.bottom;
        this.mInnerInsets = r6.inset(0, r5, 0, 0);
    L21:
        applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (this.mLastInnerInsets.equals(this.mInnerInsets) == true) goto L24;
        WindowInsetsCompat r8 = this.mInnerInsets;
        this.mLastInnerInsets = r8;
        ViewCompat.dispatchApplyWindowInsets(this.mContent, r8);
    L24:
        measureChildWithMargins(this.mContent, r12, 0, r13, 0);
        LayoutParams r9 = (LayoutParams) this.mContent.getLayoutParams();
        int r10 = Math.max(r1, (this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r9).leftMargin) + ((ViewGroup.MarginLayoutParams) r9).rightMargin);
        int r11 = Math.max(r2, (this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r9).topMargin) + ((ViewGroup.MarginLayoutParams) r9).bottomMargin);
        int r14 = View.combineMeasuredStates(r3, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max((getPaddingRight() + getPaddingLeft()) + r10, getSuggestedMinimumWidth()), r12, r14), View.resolveSizeAndState(Math.max((getPaddingBottom() + getPaddingTop()) + r11, getSuggestedMinimumHeight()), r13, r14 << 16));
        return;
    L20:
        this.mInnerInsets = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets(Insets.of(r6.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + r5, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom())).build();
        goto L21
    L10:
        if (this.mActionBarTop.getTabContainer() == null) goto L16;
        r5 = r5 + this.mActionBarHeight;
        goto L16
    L13:
        if (this.mActionBarTop.getVisibility() == 8) goto L15;
        r5 = this.mActionBarTop.getMeasuredHeight();
        goto L16
    L15:
        r5 = 0;
        goto L16
    L5:
        r4 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        if (this.mHideOnContentScroll == false) goto L12;
        if (r4 == true) goto L7;
        return false;
    L7:
        if (shouldHideActionBarOnFling(r3) == false) goto L9;
        addActionBarHideOffset();
    L10:
        this.mAnimatingForFling = true;
        return true;
    L9:
        removeActionBarHideOffset();
        goto L10
    L12:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r1, int r2, int r3, int[] r4) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        onNestedScroll(r1, r2, r3, r4, r5, r6);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r1, View r2, int r3, int r4) {
        if (r4 != 0) goto L5;
        onNestedScrollAccepted(r1, r2, r3);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        if (r4 == 0) goto L4;
    L6:
        return false;
    L4:
        if (onStartNestedScroll(r1, r2, r3) == false) goto L6;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r1, int r2) {
        if (r2 != 0) goto L5;
        onStopNestedScroll(r1);
        return;
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int r5) {
        super.onWindowSystemUiVisibilityChanged(r5);
        pullChildren();
        int r0 = this.mLastSystemUiVisibility ^ r5;
        this.mLastSystemUiVisibility = r5;
        boolean r2 = false;
        if ((r5 & 4) != 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r5 & 256) == 0) goto L9;
        r2 = true;
    L9:
        ActionBarVisibilityCallback r6 = this.mActionBarVisibilityCallback;
        if (r6 == null) goto L18;
        r6.enableContentAnimations(!r2);
        if (r1 == true) goto L16;
        if (r2 == false) goto L16;
        this.mActionBarVisibilityCallback.hideForSystem();
    L16:
        this.mActionBarVisibilityCallback.showForSystem();
    L18:
        if ((r0 & 256) != 0) goto L20;
        return;
    L20:
        if (this.mActionBarVisibilityCallback == null) goto L24;
        ViewCompat.requestApplyInsets(this);
        return;
    L24:
        return;
    L5:
        r1 = false;
        goto L7
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        this.mWindowVisibility = r1;
        ActionBarVisibilityCallback r0 = this.mActionBarVisibilityCallback;
        if (r0 == null) goto L6;
        r0.onWindowVisibilityChanged(r1);
        return;
    }

    public void pullChildren() {
        if (this.mContent != null) goto L6;
        this.mContent = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
        this.mActionBarTop = (ActionBarContainer) findViewById(R.id.action_bar_container);
        this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> r1) {
        pullChildren();
        this.mDecorToolbar.restoreHierarchyState(r1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> r1) {
        pullChildren();
        this.mDecorToolbar.saveHierarchyState(r1);
    }

    public void setActionBarHideOffset(int r3) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(r3, this.mActionBarTop.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback r2) {
        this.mActionBarVisibilityCallback = r2;
        if (getWindowToken() == null) goto L8;
        this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
        int r3 = this.mLastSystemUiVisibility;
        if (r3 == 0) goto L9;
        onWindowSystemUiVisibilityChanged(r3);
        ViewCompat.requestApplyInsets(this);
        return;
    L9:
        return;
    }

    public void setHasNonEmbeddedTabs(boolean r1) {
        this.mHasNonEmbeddedTabs = r1;
    }

    public void setHideOnContentScrollEnabled(boolean r2) {
        if (r2 == this.mHideOnContentScroll) goto L8;
        this.mHideOnContentScroll = r2;
        if (r2 == true) goto L9;
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(int r1) {
        pullChildren();
        this.mDecorToolbar.setIcon(r1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setLogo(int r1) {
        pullChildren();
        this.mDecorToolbar.setLogo(r1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu r1, MenuPresenter.Callback r2) {
        pullChildren();
        this.mDecorToolbar.setMenu(r1, r2);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean r2) {
        this.mOverlayMode = r2;
        if (r2 == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.mIgnoreWindowContentOverlay = r3;
        return;
    L5:
        if (getContext().getApplicationInfo().targetSdkVersion >= 19) goto L7;
        r3 = true;
        goto L8
    }

    public void setShowingForActionMode(boolean r1) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setUiOptions(int r1) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback r1) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(r1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence r1) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(r1);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean showOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }

    public ActionBarOverlayLayout(@NonNull Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        WindowInsetsCompat r3 = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = r3;
        this.mLastBaseInnerInsets = r3;
        this.mInnerInsets = r3;
        this.mLastInnerInsets = r3;
        this.mTopAnimatorListener = new AnonymousClass1(this);
        this.mRemoveActionBarHideOffset = new AnonymousClass2(this);
        this.mAddActionBarHideOffset = new AnonymousClass3(this);
        init(r1);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        if (r5 != 0) goto L5;
        onNestedPreScroll(r1, r2, r3, r4);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        if (r6 != 0) goto L5;
        onNestedScroll(r1, r2, r3, r4, r5);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.mParentHelper.onNestedScrollAccepted(r2, r3, r4);
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback r1 = this.mActionBarVisibilityCallback;
        if (r1 == null) goto L6;
        r1.onContentScrollStarted();
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r1, View r2, int r3) {
        if ((r3 & 2) != 0) goto L5;
        return false;
    L5:
        if (this.mActionBarTop.getVisibility() == 0) goto L8;
        return false;
    L8:
        return this.mHideOnContentScroll;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r2) {
        if (this.mHideOnContentScroll == true) goto L5;
    L10:
        ActionBarVisibilityCallback r1 = this.mActionBarVisibilityCallback;
        if (r1 == null) goto L14;
        r1.onContentScrollStopped();
        return;
    L14:
        return;
    L5:
        if (this.mAnimatingForFling == true) goto L10;
        if (this.mHideOnContentScrollReference > this.mActionBarTop.getHeight()) goto L9;
        postRemoveActionBarHideOffset();
        goto L10
    L9:
        postAddActionBarHideOffset();
        goto L10
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5) {
        int r6 = this.mHideOnContentScrollReference + r3;
        this.mHideOnContentScrollReference = r6;
        setActionBarHideOffset(r6);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(Drawable r1) {
        pullChildren();
        this.mDecorToolbar.setIcon(r1);
    }
}
