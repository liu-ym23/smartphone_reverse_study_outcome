package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContextView extends AbsActionBarView {
    private View mClose;
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

    public ActionBarContextView(@NonNull Context r2) {
        this(r2, null);
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
        int r4 = 8;
        if (r2 == false) goto L13;
        int r5 = 0;
    L14:
        r3.setVisibility(r5);
        LinearLayout r6 = this.mTitleLayout;
        if (r1 == true) goto L17;
        if (r2 == true) goto L17;
    L18:
        r6.setVisibility(r4);
        if (this.mTitleLayout.getParent() != null) goto L22;
        addView(this.mTitleLayout);
        return;
    L22:
        return;
    L17:
        r4 = 0;
        goto L18
    L13:
        r5 = 8;
        goto L14
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int r1) {
        super.animateToVisibility(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.mClose != null) goto L6;
        killMode();
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new ViewGroup.MarginLayoutParams(getContext(), r2);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.hideOverflowMenu();
    }

    public void initForMode(final ActionMode r4) {
        View r0 = this.mClose;
        if (r0 != null) goto L6;
        View r1 = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
        this.mClose = r1;
        addView(r1);
    L8:
        this.mClose.findViewById(R.id.action_mode_close_button).setOnClickListener(new AnonymousClass1(this, r4));
        MenuBuilder r5 = (MenuBuilder) r4.getMenu();
        ActionMenuPresenter r2 = this.mActionMenuPresenter;
        if (r2 == null) goto L11;
        r2.dismissPopupMenus();
    L11:
        ActionMenuPresenter r3 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = r3;
        r3.setReserveOverflow(true);
        ViewGroup.LayoutParams r6 = new ViewGroup.LayoutParams(-2, -1);
        r5.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView r7 = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = r7;
        ViewCompat.setBackground(r7, null);
        addView(this.mMenuView, r6);
        return;
    L6:
        if (r0.getParent() != null) goto L8;
        addView(this.mClose);
        goto L8
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 == null) goto L6;
        r0.hideOverflowMenu();
        this.mActionMenuPresenter.hideSubMenus();
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent r1) {
        return super.onHoverEvent(r1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
        if (r3.getEventType() != 32) goto L5;
        r3.setSource(this);
        r3.setClassName(getClass().getName());
        r3.setPackageName(getContext().getPackageName());
        r3.setContentDescription(this.mTitle);
        return;
    L5:
        super.onInitializeAccessibilityEvent(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
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
    L31:
        ActionMenuView r5 = this.mMenuView;
        if (r5 == null) goto L35;
        positionChild(r5, r4, r6, r16, !r15);
        return;
    L35:
        return;
    L30:
        r4 = (r13 - r11) - getPaddingRight();
        goto L31
    L21:
        if (this.mCustomView != null) goto L25;
        if (r1.getVisibility() == 8) goto L25;
        r18 = r18 + positionChild(this.mTitleLayout, r18, r6, r16, r15);
        goto L25
    L9:
        if (r17.getVisibility() == 8) goto L18;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        if (r15 == false) goto L13;
        int r7 = r19.rightMargin;
    L14:
        if (r15 == false) goto L16;
        int r110 = r19.leftMargin;
    L17:
        int r8 = AbsActionBarView.next(r0, r7, r15);
        r0 = AbsActionBarView.next(r8 + positionChild(this.mClose, r8, r6, r16, r15), r110, r15);
        goto L18
    L16:
        r110 = r19.rightMargin;
        goto L17
    L13:
        r7 = r19.leftMargin;
        goto L14
    L5:
        r0 = getPaddingLeft();
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r11, int r12) {
        int r0 = View.MeasureSpec.getMode(r11);
        int r1 = BasicMeasure.EXACTLY;
        if (r0 != 1073741824) goto L65;
        if (View.MeasureSpec.getMode(r12) == 0) goto L63;
        int r13 = View.MeasureSpec.getSize(r11);
        int r2 = this.mContentHeight;
        if (r2 > 0) goto L10;
        r2 = View.MeasureSpec.getSize(r12);
    L10:
        int r3 = getPaddingBottom() + getPaddingTop();
        int r14 = (r13 - getPaddingLeft()) - getPaddingRight();
        int r4 = r2 - r3;
        int r5 = View.MeasureSpec.makeMeasureSpec(r4, Integer.MIN_VALUE);
        View r6 = this.mClose;
        int r7 = 0;
        if (r6 == null) goto L13;
        int r15 = measureChildView(r6, r14, r5, 0);
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        r14 = r15 - (r8.leftMargin + r8.rightMargin);
    L13:
        ActionMenuView r9 = this.mMenuView;
        if (r9 != null) goto L16;
    L18:
        LinearLayout r10 = this.mTitleLayout;
        if (r10 != null) goto L21;
    L36:
        View r16 = this.mCustomView;
        if (r16 == null) goto L52;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        int r18 = r17.width;
        if (r18 == (-2)) goto L41;
        int r19 = 1073741824;
    L42:
        if (r18 < 0) goto L44;
        r14 = Math.min(r18, r14);
    L44:
        int r20 = r17.height;
        if (r20 != (-2)) goto L48;
        r1 = Integer.MIN_VALUE;
    L48:
        if (r20 < 0) goto L50;
        r4 = Math.min(r20, r4);
    L50:
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(r14, r19), View.MeasureSpec.makeMeasureSpec(r4, r1));
        goto L52
    L41:
        r19 = Integer.MIN_VALUE;
    L52:
        if (this.mContentHeight > 0) goto L60;
        int r110 = getChildCount();
        int r21 = 0;
    L54:
        if (r7 >= r110) goto L59;
        int r22 = getChildAt(r7).getMeasuredHeight() + r3;
        if (r22 <= r21) goto L58;
        r21 = r22;
    L58:
        r7 = r7 + 1;
        goto L54
    L59:
        setMeasuredDimension(r13, r21);
        return;
    L60:
        setMeasuredDimension(r13, r2);
        return;
    L21:
        if (this.mCustomView != null) goto L36;
        if (this.mTitleOptional == false) goto L35;
        this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r5);
        int r23 = this.mTitleLayout.getMeasuredWidth();
        if (r23 > r14) goto L27;
        boolean r24 = true;
    L28:
        if (r24 == false) goto L30;
        r14 = r14 - r23;
    L30:
        LinearLayout r25 = this.mTitleLayout;
        if (r24 == false) goto L33;
        int r26 = 0;
    L34:
        r25.setVisibility(r26);
        goto L36
    L33:
        r26 = 8;
        goto L34
    L27:
        r24 = false;
        goto L28
    L35:
        r14 = measureChildView(r10, r14, r5, 0);
        goto L36
    L16:
        if (r9.getParent() != this) goto L18;
        r14 = measureChildView(this.mMenuView, r14, r5, 0);
        goto L18
    L63:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
    L65:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
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

    public void setSubtitle(CharSequence r1) {
        this.mSubtitle = r1;
        initTitle();
    }

    public void setTitle(CharSequence r1) {
        this.mTitle = r1;
        initTitle();
    }

    public void setTitleOptional(boolean r2) {
        if (r2 == this.mTitleOptional) goto L5;
        requestLayout();
    L5:
        this.mTitleOptional = r2;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r1) {
        super.setVisibility(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r1, long r2) {
        return super.setupAnimatorToVisibility(r1, r2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.showOverflowMenu();
    }

    public ActionBarContextView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context r3, @Nullable AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes(r3, r4, R.styleable.ActionMode, r5, 0);
        ViewCompat.setBackground(this, r6.getDrawable(R.styleable.ActionMode_background));
        this.mTitleStyleRes = r6.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = r6.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = r6.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = r6.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        r6.recycle();
    }
}
