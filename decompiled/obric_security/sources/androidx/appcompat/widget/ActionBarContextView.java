package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {
    private View mClose;
    private View mCloseButton;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int r1) {
        super.animateToVisibility(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent r1) {
        return super.onHoverEvent(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r1) {
        super.setVisibility(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r1, long r2) {
        return super.setupAnimatorToVisibility(r1, r2);
    }

    public ActionBarContextView(Context r2) {
        this(r2, null);
    }

    public ActionBarContextView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes(r3, r4, R.styleable.ActionMode, r5, 0);
        ViewCompat.setBackground(this, r6.getDrawable(R.styleable.ActionMode_background));
        this.mTitleStyleRes = r6.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = r6.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = r6.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = r6.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        r6.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter == null) goto L6;
        this.mActionMenuPresenter.hideOverflowMenu();
        this.mActionMenuPresenter.hideSubMenus();
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
    }

    public void setCustomView(View r2) {
        View r0 = this.mCustomView;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        this.mCustomView = r2;
        if (r2 == null) goto L10;
        LinearLayout r1 = this.mTitleLayout;
        if (r1 == null) goto L10;
        removeView(r1);
        this.mTitleLayout = null;
    L10:
        if (r2 == null) goto L12;
        addView(r2);
    L12:
        requestLayout();
    }

    public void setTitle(CharSequence r1) {
        this.mTitle = r1;
        initTitle();
        ViewCompat.setAccessibilityPaneTitle(this, r1);
    }

    public void setSubtitle(CharSequence r1) {
        this.mSubtitle = r1;
        initTitle();
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    private void initTitle() {
        if (this.mTitleLayout != null) goto L10;
        LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
        LinearLayout r0 = (LinearLayout) getChildAt(getChildCount() - 1);
        this.mTitleLayout = r0;
        this.mTitleView = (TextView) r0.findViewById(R.id.action_bar_title);
        this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
        if (this.mTitleStyleRes == 0) goto L8;
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
    L8:
        if (this.mSubtitleStyleRes == 0) goto L10;
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
    L10:
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean r1 = !TextUtils.isEmpty(this.mTitle);
        boolean r2 = !TextUtils.isEmpty(this.mSubtitle);
        TextView r3 = this.mSubtitleView;
        int r4 = 0;
        if (r2 == false) goto L13;
        int r5 = 0;
    L14:
        r3.setVisibility(r5);
        LinearLayout r6 = this.mTitleLayout;
        if (r1 == true) goto L19;
        if (r2 == true) goto L19;
        r4 = 8;
    L19:
        r6.setVisibility(r4);
        if (this.mTitleLayout.getParent() != null) goto L23;
        addView(this.mTitleLayout);
        return;
    L23:
        return;
    L13:
        r5 = 8;
        goto L14
    }

    public void initForMode(final ActionMode r4) {
        View r0 = this.mClose;
        if (r0 != null) goto L6;
        View r1 = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
        this.mClose = r1;
        addView(r1);
    L8:
        View r2 = this.mClose.findViewById(R.id.action_mode_close_button);
        this.mCloseButton = r2;
        r2.setOnClickListener(new AnonymousClass1(this, r4));
        MenuBuilder r5 = (MenuBuilder) r4.getMenu();
        if (this.mActionMenuPresenter == null) goto L11;
        this.mActionMenuPresenter.dismissPopupMenus();
    L11:
        this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter.setReserveOverflow(true);
        ViewGroup.LayoutParams r3 = new ViewGroup.LayoutParams(-2, -1);
        r5.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        ViewCompat.setBackground(this.mMenuView, null);
        addView(this.mMenuView, r3);
        return;
    L6:
        if (r0.getParent() != null) goto L8;
        addView(this.mClose);
        goto L8
    }

    public void closeMode() {
        if (this.mClose != null) goto L6;
        killMode();
        return;
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View r1 = this.mCloseButton;
        if (r1 == null) goto L6;
        r1.setOnClickListener(null);
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) goto L5;
        return false;
    L5:
        return this.mActionMenuPresenter.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) goto L5;
        return false;
    L5:
        return this.mActionMenuPresenter.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) goto L5;
        return false;
    L5:
        return this.mActionMenuPresenter.isOverflowMenuShowing();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new ViewGroup.MarginLayoutParams(getContext(), r2);
    }

    @Override // android.view.View
    protected void onMeasure(int r11, int r12) {
        int r1 = 1073741824;
        if (View.MeasureSpec.getMode(r11) != 1073741824) goto L67;
        if (View.MeasureSpec.getMode(r12) == 0) goto L65;
        int r13 = View.MeasureSpec.getSize(r11);
        if (this.mContentHeight <= 0) goto L9;
        int r14 = this.mContentHeight;
    L10:
        int r0 = getPaddingTop() + getPaddingBottom();
        int r2 = (r13 - getPaddingLeft()) - getPaddingRight();
        int r3 = r14 - r0;
        int r5 = View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
        View r6 = this.mClose;
        int r7 = 0;
        if (r6 == null) goto L14;
        int r4 = measureChildView(r6, r2, r5, 0);
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        r2 = r4 - (r8.leftMargin + r8.rightMargin);
    L14:
        if (this.mMenuView != null) goto L16;
    L18:
        LinearLayout r9 = this.mTitleLayout;
        if (r9 != null) goto L21;
    L36:
        View r10 = this.mCustomView;
        if (r10 == null) goto L54;
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
        if (r15.width == (-2)) goto L41;
        int r16 = 1073741824;
    L43:
        if (r15.width < 0) goto L46;
        r2 = Math.min(r15.width, r2);
    L46:
        if (r15.height != (-2)) goto L50;
        r1 = Integer.MIN_VALUE;
    L50:
        if (r15.height < 0) goto L52;
        r3 = Math.min(r15.height, r3);
    L52:
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(r2, r16), View.MeasureSpec.makeMeasureSpec(r3, r1));
        goto L54
    L41:
        r16 = Integer.MIN_VALUE;
    L54:
        if (this.mContentHeight > 0) goto L62;
        int r17 = getChildCount();
        int r18 = 0;
    L56:
        if (r7 >= r17) goto L61;
        int r19 = getChildAt(r7).getMeasuredHeight() + r0;
        if (r19 <= r18) goto L60;
        r18 = r19;
    L60:
        r7 = r7 + 1;
        goto L56
    L61:
        setMeasuredDimension(r13, r18);
        return;
    L62:
        setMeasuredDimension(r13, r14);
        return;
    L21:
        if (this.mCustomView != null) goto L36;
        if (this.mTitleOptional == false) goto L35;
        this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r5);
        int r20 = this.mTitleLayout.getMeasuredWidth();
        if (r20 > r2) goto L27;
        boolean r21 = true;
    L28:
        if (r21 == false) goto L30;
        r2 = r2 - r20;
    L30:
        LinearLayout r22 = this.mTitleLayout;
        if (r21 == false) goto L33;
        int r23 = 0;
    L34:
        r22.setVisibility(r23);
        goto L36
    L33:
        r23 = 8;
        goto L34
    L27:
        r21 = false;
        goto L28
    L35:
        r2 = measureChildView(r9, r2, r5, 0);
        goto L36
    L16:
        if (this.mMenuView.getParent() != this) goto L18;
        r2 = measureChildView(this.mMenuView, r2, r5, 0);
        goto L18
    L9:
        r14 = View.MeasureSpec.getSize(r12);
        goto L10
    L65:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    L67:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        boolean r15 = ViewUtils.isLayoutRtl(this);
        if (r15 == false) goto L5;
        int r0 = (r13 - r11) - getPaddingRight();
    L6:
        int r6 = getPaddingTop();
        int r16 = ((r14 - r12) - getPaddingTop()) - getPaddingBottom();
        View r17 = this.mClose;
        if (r17 != null) goto L9;
    L18:
        int r18 = r0;
        LinearLayout r1 = this.mTitleLayout;
        if (r1 != null) goto L21;
    L25:
        int r2 = r18;
        View r3 = this.mCustomView;
        if (r3 == null) goto L28;
        positionChild(r3, r2, r6, r16, r15);
    L28:
        if (r15 == false) goto L30;
        int r4 = getPaddingLeft();
    L32:
        if (this.mMenuView == null) goto L35;
        positionChild(this.mMenuView, r4, r6, r16, !r15);
        return;
    L35:
        return;
    L30:
        r4 = (r13 - r11) - getPaddingRight();
        goto L32
    L21:
        if (this.mCustomView != null) goto L25;
        if (r1.getVisibility() == 8) goto L25;
        r18 = r18 + positionChild(this.mTitleLayout, r18, r6, r16, r15);
        goto L25
    L9:
        if (r17.getVisibility() == 8) goto L18;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        if (r15 == false) goto L13;
        int r5 = r19.rightMargin;
    L14:
        if (r15 == false) goto L16;
        int r110 = r19.leftMargin;
    L17:
        int r8 = next(r0, r5, r15);
        r0 = next(r8 + positionChild(this.mClose, r8, r6, r16, r15), r110, r15);
        goto L18
    L16:
        r110 = r19.rightMargin;
        goto L17
    L13:
        r5 = r19.leftMargin;
        goto L14
    L5:
        r0 = getPaddingLeft();
        goto L6
    }

    public void setTitleOptional(boolean r2) {
        if (r2 == this.mTitleOptional) goto L5;
        requestLayout();
    L5:
        this.mTitleOptional = r2;
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }
}
