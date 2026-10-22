package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled;
        int mFinalVisibility;
        final /* synthetic */ AbsActionBarView this$0;

        protected VisibilityAnimListener(AbsActionBarView r1) {
            this.this$0 = r1;
            this.mCanceled = false;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r1) {
            this.mCanceled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r2) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            AbsActionBarView r3 = this.this$0;
            r3.mVisibilityAnim = null;
            AbsActionBarView.access$101(r3, this.mFinalVisibility);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r2) {
            AbsActionBarView.access$001(this.this$0, 0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat r2, int r3) {
            this.this$0.mVisibilityAnim = r2;
            this.mFinalVisibility = r3;
            return this;
        }
    }

    AbsActionBarView(@NonNull Context r2) {
        this(r2, null);
    }

    AbsActionBarView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    AbsActionBarView(@NonNull Context r3, @Nullable AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        TypedValue r6 = new TypedValue();
        if (r3.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, r6, true) == true) goto L5;
    L7:
        this.mPopupContext = r3;
        return;
    L5:
        if (r6.resourceId == 0) goto L7;
        this.mPopupContext = new ContextThemeWrapper(r3, r6.resourceId);
    }

    static /* synthetic */ void access$001(AbsActionBarView r0, int r1) {
        super.setVisibility(r1);
    }

    static /* synthetic */ void access$101(AbsActionBarView r0, int r1) {
        super.setVisibility(r1);
    }

    protected static int next(int r0, int r1, boolean r2) {
        if (r2 == false) goto L5;
        return r0 - r1;
    L5:
        return r0 + r1;
    }

    public void animateToVisibility(int r3) {
        setupAnimatorToVisibility(r3, 200).start();
    }

    public boolean canShowOverflowMenu() {
        if (isOverflowReserved() == true) goto L5;
    L7:
        return false;
    L5:
        if (getVisibility() != 0) goto L7;
        return true;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 == null) goto L6;
        r0.dismissPopupMenus();
        return;
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim == null) goto L7;
        return this.mVisAnimListener.mFinalVisibility;
    L7:
        return getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.hideOverflowMenu();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowReserved() == false) goto L7;
        return true;
    }

    protected int measureChildView(View r1, int r2, int r3, int r4) {
        r1.measure(View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE), r3);
        return Math.max(0, (r2 - r1.getMeasuredWidth()) - r4);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r6) {
        super.onConfigurationChanged(r6);
        TypedArray r0 = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(r0.getLayoutDimension(R.styleable.ActionBar_height, 0));
        r0.recycle();
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 == null) goto L6;
        r5.onConfigurationChanged(r6);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (r0 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r7 = super.onHoverEvent(r6);
        if (r0 != 9) goto L12;
        if (r7 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r0 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r0 != 3) goto L16;
        goto L15
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r6 = super.onTouchEvent(r5);
        if (r0 != 0) goto L11;
        if (r6 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r0 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r0 != 3) goto L15;
        goto L14
    }

    protected int positionChild(View r2, int r3, int r4, int r5, boolean r6) {
        int r1 = r2.getMeasuredWidth();
        int r0 = r2.getMeasuredHeight();
        int r7 = r4 + ((r5 - r0) / 2);
        if (r6 == false) goto L5;
        r2.layout(r3 - r1, r7, r3, r0 + r7);
    L6:
        if (r6 == true) goto L8;
        return r1;
    L8:
        return -r1;
    L5:
        r2.layout(r3, r7, r3 + r1, r0 + r7);
        goto L6
    }

    public void postShowOverflowMenu() {
        post(new AnonymousClass1(this));
    }

    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        if (r2 == getVisibility()) goto L9;
        ViewPropertyAnimatorCompat r0 = this.mVisibilityAnim;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        super.setVisibility(r2);
        return;
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r3, long r4) {
        ViewPropertyAnimatorCompat r0 = this.mVisibilityAnim;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r3 == 0) goto L8;
        ViewPropertyAnimatorCompat r1 = ViewCompat.animate(this).alpha(0.0f);
    L11:
        r1.setDuration(r4);
        r1.setListener(this.mVisAnimListener.withFinalVisibility(r1, r3));
        return r1;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        r1 = ViewCompat.animate(this).alpha(1.0f);
        goto L11
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.showOverflowMenu();
    }
}
