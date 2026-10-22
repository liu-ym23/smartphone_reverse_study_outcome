package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {
    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    private View mTabContainer;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void invalidateOutline(ActionBarContainer r0) {
            r0.invalidateOutline();
        }
    }

    public ActionBarContainer(Context r2) {
        this(r2, null);
    }

    public ActionBarContainer(Context r3, AttributeSet r4) {
        super(r3, r4);
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.ActionBar);
        this.mBackground = r5.getDrawable(R.styleable.ActionBar_background);
        this.mStackedBackground = r5.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.mHeight = r5.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean r1 = true;
        if (getId() != R.id.split_action_bar) goto L5;
        this.mIsSplit = true;
        this.mSplitBackground = r5.getDrawable(R.styleable.ActionBar_backgroundSplit);
    L5:
        r5.recycle();
        if (this.mIsSplit == false) goto L11;
        if (this.mSplitBackground == null) goto L16;
    L15:
        r1 = false;
    L16:
        setWillNotDraw(r1);
        return;
    L11:
        if (this.mBackground != null) goto L15;
        if (this.mStackedBackground != null) goto L15;
        goto L15
    }

    private int getMeasuredHeightWithMargins(View r2) {
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r2.getLayoutParams();
        return (r2.getMeasuredHeight() + r1.topMargin) + r1.bottomMargin;
    }

    private boolean isCollapsed(View r2) {
        if (r2 != null) goto L4;
    L9:
        return true;
    L4:
        if (r2.getVisibility() == 8) goto L9;
        if (r2.getMeasuredHeight() == 0) goto L9;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.mBackground;
        if (r0 != null) goto L5;
    L7:
        Drawable r1 = this.mStackedBackground;
        if (r1 != null) goto L10;
    L12:
        Drawable r2 = this.mSplitBackground;
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.isStateful() == false) goto L19;
        this.mSplitBackground.setState(getDrawableState());
        return;
    L19:
        return;
    L10:
        if (r1.isStateful() == false) goto L12;
        this.mStackedBackground.setState(getDrawableState());
        goto L12
    L5:
        if (r0.isStateful() == false) goto L7;
        this.mBackground.setState(getDrawableState());
        goto L7
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.mBackground;
        if (r0 == null) goto L5;
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.mStackedBackground;
        if (r1 == null) goto L8;
        r1.jumpToCurrentState();
    L8:
        Drawable r2 = this.mSplitBackground;
        if (r2 == null) goto L12;
        r2.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(R.id.action_bar);
        this.mContextView = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r1) {
        super.onHoverEvent(r1);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.mIsTransitioning == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        super.onLayout(r5, r6, r7, r8, r9);
        View r10 = this.mTabContainer;
        boolean r11 = true;
        boolean r0 = false;
        if (r10 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r10 == null) goto L13;
        if (r10.getVisibility() == 8) goto L13;
        int r12 = getMeasuredHeight();
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        int r3 = r12 - r10.getMeasuredHeight();
        int r4 = r2.bottomMargin;
        r10.layout(r6, r3 - r4, r8, r12 - r4);
    L13:
        if (this.mIsSplit == false) goto L19;
        Drawable r13 = this.mSplitBackground;
        if (r13 == null) goto L17;
        r13.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L36:
        if (r11 == false) goto L39;
        invalidate();
        return;
    L39:
        return;
    L17:
        r11 = r0;
        goto L36
    L19:
        if (this.mBackground != null) goto L21;
    L31:
        this.mIsStacked = r1;
        if (r1 == false) goto L17;
        Drawable r14 = this.mStackedBackground;
        if (r14 == null) goto L17;
        r14.setBounds(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
        goto L36
    L21:
        if (this.mActionBarView.getVisibility() != 0) goto L24;
        Drawable r15 = this.mBackground;
        int r16 = this.mActionBarView.getLeft();
        int r17 = this.mActionBarView.getTop();
        int r18 = this.mActionBarView.getRight();
        View r19 = this.mActionBarView;
    L23:
        r15.setBounds(r16, r17, r18, r19.getBottom());
    L30:
        r0 = true;
        goto L31
    L24:
        View r20 = this.mContextView;
        if (r20 != null) goto L27;
    L29:
        this.mBackground.setBounds(0, 0, 0, 0);
        goto L30
    L27:
        if (r20.getVisibility() != 0) goto L29;
        r15 = this.mBackground;
        r16 = this.mContextView.getLeft();
        r17 = this.mContextView.getTop();
        r18 = this.mContextView.getRight();
        r19 = this.mContextView;
        goto L23
    L5:
        if (r10.getVisibility() == 8) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        if (this.mActionBarView == null) goto L5;
    L9:
        super.onMeasure(r4, r5);
        if (this.mActionBarView != null) goto L12;
        return;
    L12:
        int r6 = View.MeasureSpec.getMode(r5);
        View r0 = this.mTabContainer;
        if (r0 != null) goto L15;
        return;
    L15:
        if (r0.getVisibility() != 8) goto L17;
        return;
    L17:
        if (r6 != 1073741824) goto L19;
        return;
    L19:
        if (isCollapsed(this.mActionBarView) == true) goto L23;
        View r1 = this.mActionBarView;
    L21:
        int r2 = getMeasuredHeightWithMargins(r1);
    L26:
        if (r6 != Integer.MIN_VALUE) goto L28;
        int r7 = View.MeasureSpec.getSize(r5);
    L29:
        setMeasuredDimension(getMeasuredWidth(), Math.min(r2 + getMeasuredHeightWithMargins(this.mTabContainer), r7));
        return;
    L28:
        r7 = Integer.MAX_VALUE;
        goto L29
    L23:
        if (isCollapsed(this.mContextView) == true) goto L25;
        r1 = this.mContextView;
        goto L21
    L25:
        r2 = 0;
        goto L26
    L5:
        if (View.MeasureSpec.getMode(r5) != Integer.MIN_VALUE) goto L9;
        int r3 = this.mHeight;
        if (r3 < 0) goto L9;
        r5 = View.MeasureSpec.makeMeasureSpec(Math.min(r3, View.MeasureSpec.getSize(r5)), Integer.MIN_VALUE);
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        super.onTouchEvent(r1);
        return true;
    }

    public void setPrimaryBackground(Drawable r5) {
        Drawable r0 = this.mBackground;
        if (r0 == null) goto L5;
        r0.setCallback(null);
        unscheduleDrawable(this.mBackground);
    L5:
        this.mBackground = r5;
        if (r5 == null) goto L10;
        r5.setCallback(this);
        View r6 = this.mActionBarView;
        if (r6 == null) goto L10;
        this.mBackground.setBounds(r6.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
    L10:
        boolean r1 = true;
        if (this.mIsSplit == false) goto L16;
        if (this.mSplitBackground == null) goto L21;
    L20:
        r1 = false;
    L21:
        setWillNotDraw(r1);
        invalidate();
        if (Build.VERSION.SDK_INT < 21) goto L25;
        Api21Impl.invalidateOutline(this);
        return;
    L25:
        return;
    L16:
        if (this.mBackground != null) goto L20;
        if (this.mStackedBackground != null) goto L20;
        goto L20
    }

    public void setSplitBackground(Drawable r4) {
        Drawable r0 = this.mSplitBackground;
        if (r0 == null) goto L5;
        r0.setCallback(null);
        unscheduleDrawable(this.mSplitBackground);
    L5:
        this.mSplitBackground = r4;
        boolean r1 = false;
        if (r4 == null) goto L13;
        r4.setCallback(this);
        if (this.mIsSplit == false) goto L13;
        Drawable r5 = this.mSplitBackground;
        if (r5 == null) goto L13;
        r5.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L13:
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground != null) goto L22;
    L16:
        r1 = true;
    L22:
        setWillNotDraw(r1);
        invalidate();
        if (Build.VERSION.SDK_INT < 21) goto L26;
        Api21Impl.invalidateOutline(this);
        return;
    L26:
        return;
    L18:
        if (this.mBackground != null) goto L22;
        if (this.mStackedBackground != null) goto L22;
        goto L22
    }

    public void setStackedBackground(Drawable r5) {
        Drawable r0 = this.mStackedBackground;
        if (r0 == null) goto L5;
        r0.setCallback(null);
        unscheduleDrawable(this.mStackedBackground);
    L5:
        this.mStackedBackground = r5;
        if (r5 == null) goto L12;
        r5.setCallback(this);
        if (this.mIsStacked == false) goto L12;
        Drawable r6 = this.mStackedBackground;
        if (r6 == null) goto L12;
        r6.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
    L12:
        boolean r1 = true;
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground == null) goto L23;
    L22:
        r1 = false;
    L23:
        setWillNotDraw(r1);
        invalidate();
        if (Build.VERSION.SDK_INT < 21) goto L27;
        Api21Impl.invalidateOutline(this);
        return;
    L27:
        return;
    L18:
        if (this.mBackground != null) goto L22;
        if (this.mStackedBackground != null) goto L22;
        goto L22
    }

    public void setTabContainer(ScrollingTabContainerView r2) {
        View r0 = this.mTabContainer;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        this.mTabContainer = r2;
        if (r2 == null) goto L9;
        addView(r2);
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        r1.width = -1;
        r1.height = -2;
        r2.setAllowCollapse(false);
        return;
    }

    public void setTransitioning(boolean r1) {
        this.mIsTransitioning = r1;
        if (r1 == false) goto L5;
        int r2 = 393216;
    L6:
        setDescendantFocusability(r2);
        return;
    L5:
        r2 = 262144;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        Drawable r1 = this.mBackground;
        if (r1 == null) goto L9;
        r1.setVisible(r4, false);
    L9:
        Drawable r2 = this.mStackedBackground;
        if (r2 == null) goto L12;
        r2.setVisible(r4, false);
    L12:
        Drawable r5 = this.mSplitBackground;
        if (r5 == null) goto L16;
        r5.setVisible(r4, false);
        return;
    L16:
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r1, ActionMode.Callback r2) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r1, ActionMode.Callback r2, int r3) {
        if (r3 != 0) goto L4;
        return null;
    L4:
        return super.startActionModeForChild(r1, r2, r3);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable r2) {
        if (r2 != this.mBackground) goto L7;
        if (this.mIsSplit == true) goto L7;
    L16:
        return true;
    L7:
        if (r2 != this.mStackedBackground) goto L11;
        if (this.mIsStacked == true) goto L16;
    L11:
        if (r2 != this.mSplitBackground) goto L15;
        if (this.mIsSplit == true) goto L16;
    L15:
        if (super.verifyDrawable(r2) == true) goto L16;
        return false;
    }
}
