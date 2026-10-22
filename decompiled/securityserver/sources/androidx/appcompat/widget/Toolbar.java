package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.ss.android.common.ApiConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;
        final /* synthetic */ Toolbar this$0;

        public ExpandedActionViewMenuPresenter(Toolbar r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder r2, MenuItemImpl r3) {
            KeyEvent.Callback r4 = this.this$0.mExpandedActionView;
            if ((r4 instanceof CollapsibleActionView) == false) goto L5;
            ((CollapsibleActionView) r4).onActionViewCollapsed();
        L5:
            Toolbar r5 = this.this$0;
            r5.removeView(r5.mExpandedActionView);
            Toolbar r6 = this.this$0;
            r6.removeView(r6.mCollapseButtonView);
            Toolbar r7 = this.this$0;
            r7.mExpandedActionView = null;
            r7.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            this.this$0.requestLayout();
            r3.setActionViewExpanded(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder r4, MenuItemImpl r5) {
            this.this$0.ensureCollapseButtonView();
            ViewParent r6 = this.this$0.mCollapseButtonView.getParent();
            Toolbar r0 = this.this$0;
            if (r6 != r0) goto L5;
        L8:
            Toolbar r7 = this.this$0;
            r7.mExpandedActionView = r5.getActionView();
            this.mCurrentExpandedItem = r5;
            ViewParent r8 = this.this$0.mExpandedActionView.getParent();
            Toolbar r1 = this.this$0;
            if (r8 != r1) goto L11;
        L14:
            this.this$0.removeChildrenForExpandedActionView();
            this.this$0.requestLayout();
            r5.setActionViewExpanded(true);
            KeyEvent.Callback r3 = this.this$0.mExpandedActionView;
            if ((r3 instanceof CollapsibleActionView) == false) goto L17;
            ((CollapsibleActionView) r3).onActionViewExpanded();
        L17:
            return true;
        L11:
            if ((r8 instanceof ViewGroup) == false) goto L13;
            ((ViewGroup) r8).removeView(r1.mExpandedActionView);
        L13:
            LayoutParams r9 = this.this$0.generateDefaultLayoutParams();
            Toolbar r2 = this.this$0;
            r9.gravity = (r2.mButtonGravity & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) | GravityCompat.START;
            r9.mViewType = 2;
            r2.mExpandedActionView.setLayoutParams(r9);
            Toolbar r10 = this.this$0;
            r10.addView(r10.mExpandedActionView);
            goto L14
        L5:
            if ((r6 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r6).removeView(r0.mCollapseButtonView);
        L7:
            Toolbar r11 = this.this$0;
            r11.addView(r11.mCollapseButtonView);
            goto L8
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup r1) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context r2, MenuBuilder r3) {
            MenuBuilder r4 = this.mMenu;
            if (r4 == null) goto L7;
            MenuItemImpl r0 = this.mCurrentExpandedItem;
            if (r0 == null) goto L7;
            r4.collapseItemActionView(r0);
        L7:
            this.mMenu = r3;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder r1, boolean r2) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable r1) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder r1) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback r1) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean r4) {
            if (this.mCurrentExpandedItem == null) goto L16;
            MenuBuilder r5 = this.mMenu;
            if (r5 == null) goto L12;
            int r6 = r5.size();
            int r0 = 0;
        L7:
            if (r0 >= r6) goto L12;
            if (this.mMenu.getItem(r0) == this.mCurrentExpandedItem) goto L17;
            r0 = r0 + 1;
            goto L7
        L17:
            return;
        L12:
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            return;
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(@NonNull Context r1, AttributeSet r2) {
            super(r1, r2);
            this.mViewType = 0;
        }

        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams r2) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r2.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r2.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r2.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r2.bottomMargin;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2);
            this.mViewType = 0;
            this.gravity = r3;
        }

        public LayoutParams(int r3) {
            this(-2, -1, r3);
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.mViewType = 0;
            this.mViewType = r2.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams r1) {
            super(r1);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            super(r2);
            this.mViewType = 0;
            copyMarginsFromCompat(r2);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mViewType = 0;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r1);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.expandedMenuItemId);
            r1.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.expandedMenuItemId = r1.readInt();
            if (r1.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.isOverflowOpen = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }
    }

    public Toolbar(@NonNull Context r2) {
        this(r2, null);
    }

    private void addCustomViewsWithGravity(List<View> r6, int r7) {
        int r1 = 0;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r0 = true;
    L6:
        int r3 = getChildCount();
        int r8 = GravityCompat.getAbsoluteGravity(r7, ViewCompat.getLayoutDirection(this));
        r6.clear();
        if (r0 == false) goto L18;
        int r4 = r3 - 1;
    L9:
        if (r4 < 0) goto L27;
        View r2 = getChildAt(r4);
        LayoutParams r5 = (LayoutParams) r2.getLayoutParams();
        if (r5.mViewType != 0) goto L17;
        if (shouldLayout(r2) == false) goto L17;
        if (getChildHorizontalGravity(r5.gravity) != r8) goto L17;
        r6.add(r2);
    L17:
        r4 = r4 - 1;
        goto L9
    L27:
        return;
    L18:
        if (r1 >= r3) goto L38;
        View r9 = getChildAt(r1);
        LayoutParams r10 = (LayoutParams) r9.getLayoutParams();
        if (r10.mViewType != 0) goto L26;
        if (shouldLayout(r9) == false) goto L26;
        if (getChildHorizontalGravity(r10.gravity) != r8) goto L26;
        r6.add(r9);
    L26:
        r1 = r1 + 1;
        goto L18
    L38:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void addSystemView(View r3, boolean r4) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 != null) goto L6;
        LayoutParams r1 = generateDefaultLayoutParams();
    L9:
        r1.mViewType = 1;
        if (r4 == true) goto L12;
    L14:
        addView(r3, r1);
        return;
    L12:
        if (this.mExpandedActionView == null) goto L14;
        r3.setLayoutParams(r1);
        this.mHiddenViews.add(r3);
        return;
    L6:
        if (checkLayoutParams(r0) == true) goto L8;
        r1 = generateLayoutParams(r0);
        goto L9
    L8:
        r1 = (LayoutParams) r0;
        goto L9
    }

    private void ensureContentInsets() {
        if (this.mContentInsets != null) goto L6;
        this.mContentInsets = new RtlSpacingHelper();
        return;
    }

    private void ensureLogoView() {
        if (this.mLogoView != null) goto L6;
        this.mLogoView = new AppCompatImageView(getContext());
        return;
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() != null) goto L9;
        MenuBuilder r0 = (MenuBuilder) this.mMenuView.getMenu();
        if (this.mExpandedMenuPresenter != null) goto L7;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L7:
        this.mMenuView.setExpandedActionViewsExclusive(true);
        r0.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        return;
    }

    private void ensureMenuView() {
        if (this.mMenuView != null) goto L6;
        ActionMenuView r0 = new ActionMenuView(getContext());
        this.mMenuView = r0;
        r0.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.gravity = (this.mButtonGravity & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) | GravityCompat.END;
        this.mMenuView.setLayoutParams(r1);
        addSystemView(this.mMenuView, false);
        return;
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView != null) goto L6;
        this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        LayoutParams r0 = generateDefaultLayoutParams();
        r0.gravity = (this.mButtonGravity & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) | GravityCompat.START;
        this.mNavButtonView.setLayoutParams(r0);
        return;
    }

    private int getChildHorizontalGravity(int r4) {
        int r3 = ViewCompat.getLayoutDirection(this);
        int r5 = GravityCompat.getAbsoluteGravity(r4, r3) & 7;
        if (r5 != 1) goto L5;
    L11:
        return r5;
    L5:
        if (r5 == 3) goto L11;
        if (r5 == 5) goto L11;
        if (r3 == 1) goto L10;
        return 3;
    L10:
        return 5;
    }

    private int getChildTop(View r6, int r7) {
        LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
        int r8 = r6.getMeasuredHeight();
        if (r7 <= 0) goto L5;
        int r9 = (r8 - r7) / 2;
    L6:
        int r2 = getChildVerticalGravity(r0.gravity);
        if (r2 == 48) goto L21;
        if (r2 == 80) goto L19;
        int r10 = getPaddingTop();
        int r3 = getPaddingBottom();
        int r5 = getHeight();
        int r4 = (((r5 - r10) - r3) - r8) / 2;
        int r11 = ((ViewGroup.MarginLayoutParams) r0).topMargin;
        if (r4 >= r11) goto L13;
        r4 = r11;
    L17:
        return r10 + r4;
    L13:
        int r12 = (((r5 - r3) - r8) - r4) - r10;
        int r13 = ((ViewGroup.MarginLayoutParams) r0).bottomMargin;
        if (r12 >= r13) goto L17;
        r4 = Math.max(0, r4 - (r13 - r12));
        goto L17
    L19:
        return (((getHeight() - getPaddingBottom()) - r8) - ((ViewGroup.MarginLayoutParams) r0).bottomMargin) - r9;
    L21:
        return getPaddingTop() - r9;
    L5:
        r9 = 0;
        goto L6
    }

    private int getChildVerticalGravity(int r2) {
        int r3 = r2 & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        if (r3 != 16) goto L5;
    L10:
        return r3;
    L5:
        if (r3 == 48) goto L10;
        if (r3 == 80) goto L10;
        return this.mGravity & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
    }

    private int getHorizontalMargins(View r1) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        int r2 = MarginLayoutParamsCompat.getMarginStart(r0);
        return MarginLayoutParamsCompat.getMarginEnd(r0) + r2;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private int getVerticalMargins(View r1) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        return r0.topMargin + r0.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> r8, int[] r9) {
        int r0 = r9[0];
        int r10 = r9[1];
        int r1 = r8.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L5;
        View r4 = r8.get(r2);
        LayoutParams r5 = (LayoutParams) r4.getLayoutParams();
        int r6 = ((ViewGroup.MarginLayoutParams) r5).leftMargin - r0;
        int r7 = ((ViewGroup.MarginLayoutParams) r5).rightMargin - r10;
        int r11 = Math.max(0, r6);
        int r12 = Math.max(0, r7);
        int r13 = Math.max(0, -r6);
        int r14 = Math.max(0, -r7);
        r3 = r3 + ((r4.getMeasuredWidth() + r11) + r12);
        r2 = r2 + 1;
        r10 = r14;
        r0 = r13;
        goto L3
    L5:
        return r3;
    }

    private boolean isChildOrHidden(View r2) {
        if (r2.getParent() != this) goto L5;
    L8:
        return true;
    L5:
        if (this.mHiddenViews.contains(r2) == true) goto L8;
        return false;
    }

    private int layoutChildLeft(View r5, int r6, int[] r7, int r8) {
        LayoutParams r0 = (LayoutParams) r5.getLayoutParams();
        int r1 = ((ViewGroup.MarginLayoutParams) r0).leftMargin - r7[0];
        int r3 = Math.max(0, r1) + r6;
        r7[0] = Math.max(0, -r1);
        int r4 = getChildTop(r5, r8);
        int r9 = r5.getMeasuredWidth();
        r5.layout(r3, r4, r3 + r9, r5.getMeasuredHeight() + r4);
        return (r9 + ((ViewGroup.MarginLayoutParams) r0).rightMargin) + r3;
    }

    private int layoutChildRight(View r6, int r7, int[] r8, int r9) {
        LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
        int r1 = ((ViewGroup.MarginLayoutParams) r0).rightMargin - r8[1];
        int r10 = r7 - Math.max(0, r1);
        r8[1] = Math.max(0, -r1);
        int r5 = getChildTop(r6, r9);
        int r11 = r6.getMeasuredWidth();
        r6.layout(r10 - r11, r5, r10, r6.getMeasuredHeight() + r5);
        return r10 - (r11 + ((ViewGroup.MarginLayoutParams) r0).leftMargin);
    }

    private int measureChildCollapseMargins(View r8, int r9, int r10, int r11, int r12, int[] r13) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        int r1 = r0.leftMargin - r13[0];
        int r3 = r0.rightMargin - r13[1];
        int r5 = Math.max(0, r1);
        int r6 = Math.max(0, r3) + r5;
        r13[0] = Math.max(0, -r1);
        r13[1] = Math.max(0, -r3);
        int r14 = getPaddingLeft();
        int r15 = ViewGroup.getChildMeasureSpec(r9, ((getPaddingRight() + r14) + r6) + r10, r0.width);
        int r16 = getPaddingTop();
        r8.measure(r15, ViewGroup.getChildMeasureSpec(r11, (((getPaddingBottom() + r16) + r0.topMargin) + r0.bottomMargin) + r12, r0.height));
        return r8.getMeasuredWidth() + r6;
    }

    private void measureChildConstrained(View r4, int r5, int r6, int r7, int r8, int r9) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        int r1 = getPaddingLeft();
        int r10 = ViewGroup.getChildMeasureSpec(r5, (((getPaddingRight() + r1) + r0.leftMargin) + r0.rightMargin) + r6, r0.width);
        int r11 = getPaddingTop();
        int r3 = ViewGroup.getChildMeasureSpec(r7, (((getPaddingBottom() + r11) + r0.topMargin) + r0.bottomMargin) + r8, r0.height);
        int r12 = View.MeasureSpec.getMode(r3);
        if (r12 == 1073741824) goto L8;
        if (r9 < 0) goto L8;
        if (r12 == 0) goto L7;
        r9 = Math.min(View.MeasureSpec.getSize(r3), r9);
    L7:
        r3 = View.MeasureSpec.makeMeasureSpec(r9, BasicMeasure.EXACTLY);
    L8:
        r4.measure(r10, r3);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (this.mCollapsible == true) goto L5;
        return false;
    L5:
        int r0 = getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L15;
        View r3 = getChildAt(r2);
        if (shouldLayout(r3) == false) goto L14;
        if (r3.getMeasuredWidth() <= 0) goto L14;
        if (r3.getMeasuredHeight() <= 0) goto L14;
        return false;
    L14:
        r2 = r2 + 1;
        goto L6
    L15:
        return true;
    }

    private boolean shouldLayout(View r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.getParent() != this) goto L8;
        if (r2.getVisibility() == 8) goto L8;
        return true;
    }

    public void addChildrenForExpandedActionView() {
        int r0 = this.mHiddenViews.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        addView(this.mHiddenViews.get(r0));
        r0 = r0 - 1;
        goto L3
    L5:
        this.mHiddenViews.clear();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean canShowOverflowMenu() {
        if (getVisibility() != 0) goto L9;
        ActionMenuView r1 = this.mMenuView;
        if (r1 == null) goto L9;
        if (r1.isOverflowReserved() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        if (super.checkLayoutParams(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    public void collapseActionView() {
        ExpandedActionViewMenuPresenter r0 = this.mExpandedMenuPresenter;
        if (r0 != null) goto L5;
        MenuItemImpl r1 = null;
    L6:
        if (r1 == null) goto L9;
        r1.collapseActionView();
        return;
    L9:
        return;
    L5:
        r1 = r0.mCurrentExpandedItem;
        goto L6
    }

    public void dismissPopupMenus() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L6;
        r0.dismissPopupMenus();
        return;
    }

    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) goto L6;
        AppCompatImageButton r0 = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        this.mCollapseButtonView = r0;
        r0.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.gravity = (this.mButtonGravity & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST) | GravityCompat.START;
        r1.mViewType = 2;
        this.mCollapseButtonView.setLayoutParams(r1);
        this.mCollapseButtonView.setOnClickListener(new AnonymousClass3(this));
        return;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton r0 = this.mCollapseButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton r0 = this.mCollapseButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getEnd();
    }

    public int getContentInsetEndWithActions() {
        int r0 = this.mContentInsetEndWithActions;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLeft();
    }

    public int getContentInsetRight() {
        RtlSpacingHelper r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getRight();
    }

    public int getContentInsetStart() {
        RtlSpacingHelper r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStart();
    }

    public int getContentInsetStartWithNavigation() {
        int r0 = this.mContentInsetStartWithNavigation;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L10;
        MenuBuilder r1 = r0.peekMenu();
        if (r1 == null) goto L10;
        if (r1.hasVisibleItems() == false) goto L10;
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    L10:
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L6;
        return getCurrentContentInsetEnd();
    L6:
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L6;
        return getCurrentContentInsetStart();
    L6:
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() == null) goto L6;
        return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    L6:
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView r0 = this.mLogoView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public CharSequence getLogoDescription() {
        ImageView r0 = this.mLogoView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton r0 = this.mNavButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton r0 = this.mNavButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        if (this.mWrapper != null) goto L6;
        this.mWrapper = new ToolbarWidgetWrapper(this, true);
    L6:
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter r0 = this.mExpandedMenuPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.mCurrentExpandedItem == null) goto L7;
        return true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hideOverflowMenu() == false) goto L7;
        return true;
    }

    public void inflateMenu(@MenuRes int r2) {
        getMenuInflater().inflate(r2, getMenu());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        TextView r4 = this.mTitleTextView;
        if (r4 != null) goto L5;
        return false;
    L5:
        Layout r5 = r4.getLayout();
        if (r5 != null) goto L8;
        return false;
    L8:
        int r1 = r5.getLineCount();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L15;
        if (r5.getEllipsisCount(r2) > 0) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r1 = true;
    L6:
        int r4 = getWidth();
        int r5 = getHeight();
        int r6 = getPaddingLeft();
        int r7 = getPaddingRight();
        int r8 = getPaddingTop();
        int r9 = getPaddingBottom();
        int r10 = r4 - r7;
        int[] r11 = this.mTempMargins;
        r11[1] = 0;
        r11[0] = 0;
        int r12 = ViewCompat.getMinimumHeight(this);
        if (r12 < 0) goto L9;
        int r13 = Math.min(r12, r24 - r22);
    L11:
        if (shouldLayout(this.mNavButtonView) == false) goto L16;
        if (r1 == false) goto L14;
        int r14 = layoutChildRight(this.mNavButtonView, r10, r11, r13);
        int r15 = r6;
    L18:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L23;
        if (r1 == false) goto L21;
        r14 = layoutChildRight(this.mCollapseButtonView, r14, r11, r13);
        goto L23
    L21:
        r15 = layoutChildLeft(this.mCollapseButtonView, r15, r11, r13);
    L23:
        if (shouldLayout(this.mMenuView) == false) goto L27;
        if (r1 == false) goto L26;
        r15 = layoutChildLeft(this.mMenuView, r15, r11, r13);
        goto L27
    L26:
        r14 = layoutChildRight(this.mMenuView, r14, r11, r13);
    L27:
        int r16 = getCurrentContentInsetLeft();
        int r17 = getCurrentContentInsetRight();
        r11[0] = Math.max(0, r16 - r15);
        r11[1] = Math.max(0, r17 - (r10 - r14));
        int r3 = Math.max(r15, r16);
        int r18 = Math.min(r14, r10 - r17);
        if (shouldLayout(this.mExpandedActionView) == false) goto L33;
        if (r1 == false) goto L31;
        r18 = layoutChildRight(this.mExpandedActionView, r18, r11, r13);
        goto L33
    L31:
        r3 = layoutChildLeft(this.mExpandedActionView, r3, r11, r13);
    L33:
        if (shouldLayout(this.mLogoView) == false) goto L37;
        if (r1 == false) goto L36;
        r18 = layoutChildRight(this.mLogoView, r18, r11, r13);
        goto L37
    L36:
        r3 = layoutChildLeft(this.mLogoView, r3, r11, r13);
    L37:
        boolean r19 = shouldLayout(this.mTitleTextView);
        boolean r110 = shouldLayout(this.mSubtitleTextView);
        if (r19 == false) goto L40;
        LayoutParams r111 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r2 = ((ViewGroup.MarginLayoutParams) r111).bottomMargin + (this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r111).topMargin);
    L41:
        if (r110 == false) goto L44;
        LayoutParams r25 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        r2 = r2 + ((this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r25).topMargin) + ((ViewGroup.MarginLayoutParams) r25).bottomMargin);
    L44:
        if (r19 == true) goto L49;
        if (r110 == true) goto L49;
        int r112 = r6;
        r13 = r13;
    L48:
        int r26 = 0;
    L105:
        addCustomViewsWithGravity(this.mTempViews, 3);
        int r27 = this.mTempViews.size();
        int r28 = r3;
        int r29 = r26;
    L106:
        if (r29 >= r27) goto L108;
        r28 = layoutChildLeft(this.mTempViews.get(r29), r28, r11, r13);
        r29 = r29 + 1;
        goto L106
    L108:
        int r113 = r13;
        addCustomViewsWithGravity(this.mTempViews, 5);
        int r30 = this.mTempViews.size();
        int r31 = r26;
    L109:
        if (r31 >= r30) goto L111;
        r18 = layoutChildRight(this.mTempViews.get(r31), r18, r11, r113);
        r31 = r31 + 1;
        goto L109
    L111:
        addCustomViewsWithGravity(this.mTempViews, 1);
        int r32 = getViewListMeasuredWidth(this.mTempViews, r11);
        int r33 = ((((r4 - r112) - r7) / 2) + r112) - (r32 / 2);
        int r34 = r32 + r33;
        if (r33 < r28) goto L117;
        if (r34 <= r18) goto L116;
        r28 = r33 - (r34 - r18);
        goto L117
    L116:
        r28 = r33;
    L117:
        int r35 = this.mTempViews.size();
    L118:
        if (r26 >= r35) goto L120;
        r28 = layoutChildLeft(this.mTempViews.get(r26), r28, r11, r113);
        r26 = r26 + 1;
        goto L118
    L120:
        this.mTempViews.clear();
        return;
    L49:
        if (r19 == false) goto L51;
        TextView r36 = this.mTitleTextView;
    L52:
        if (r110 == false) goto L54;
        TextView r37 = this.mSubtitleTextView;
    L55:
        LayoutParams r38 = (LayoutParams) r36.getLayoutParams();
        LayoutParams r39 = (LayoutParams) r37.getLayoutParams();
        if (r19 == true) goto L58;
    L59:
        if (r110 == true) goto L61;
    L63:
        boolean r114 = false;
    L64:
        int r115 = this.mGravity & ApiConstants.OP_ERROR_UGC_POST_TOO_FAST;
        r112 = r6;
        if (r115 != 48) goto L67;
        int r40 = (getPaddingTop() + ((ViewGroup.MarginLayoutParams) r38).topMargin) + this.mTitleMarginTop;
    L77:
        if (r1 == false) goto L92;
        if (r114 == false) goto L81;
        int r41 = this.mTitleMarginStart;
    L82:
        int r42 = r41 - r11[1];
        r18 = r18 - Math.max(0, r42);
        r11[1] = Math.max(0, -r42);
        if (r19 == false) goto L85;
        LayoutParams r43 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r44 = r18 - this.mTitleTextView.getMeasuredWidth();
        int r45 = this.mTitleTextView.getMeasuredHeight() + r40;
        this.mTitleTextView.layout(r44, r40, r18, r45);
        int r46 = r44 - this.mTitleMarginEnd;
        r40 = r45 + ((ViewGroup.MarginLayoutParams) r43).bottomMargin;
    L86:
        if (r110 == false) goto L88;
        int r47 = r40 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        this.mSubtitleTextView.layout(r18 - this.mSubtitleTextView.getMeasuredWidth(), r47, r18, this.mSubtitleTextView.getMeasuredHeight() + r47);
        int r48 = r18 - this.mTitleMarginEnd;
    L89:
        if (r114 == false) goto L91;
        r18 = Math.min(r46, r48);
    L91:
        r3 = r3;
        goto L48
    L88:
        r48 = r18;
        goto L89
    L85:
        r46 = r18;
        goto L86
    L81:
        r41 = 0;
        goto L82
    L92:
        if (r114 == false) goto L95;
        int r49 = this.mTitleMarginStart;
    L94:
        r26 = 0;
        int r50 = r49 - r11[0];
        r3 = Math.max(0, r50) + r3;
        r11[0] = Math.max(0, -r50);
        if (r19 == false) goto L99;
        LayoutParams r51 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r52 = this.mTitleTextView.getMeasuredWidth() + r3;
        int r53 = this.mTitleTextView.getMeasuredHeight() + r40;
        this.mTitleTextView.layout(r3, r40, r52, r53);
        int r54 = r52 + this.mTitleMarginEnd;
        r40 = r53 + ((ViewGroup.MarginLayoutParams) r51).bottomMargin;
    L100:
        if (r110 == false) goto L102;
        int r55 = r40 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        int r56 = this.mSubtitleTextView.getMeasuredWidth() + r3;
        this.mSubtitleTextView.layout(r3, r55, r56, this.mSubtitleTextView.getMeasuredHeight() + r55);
        int r57 = r56 + this.mTitleMarginEnd;
    L103:
        if (r114 == false) goto L105;
        r3 = Math.max(r54, r57);
        goto L105
    L102:
        r57 = r3;
        goto L103
    L99:
        r54 = r3;
        goto L100
    L95:
        r49 = 0;
        goto L94
    L67:
        if (r115 == 80) goto L75;
        int r58 = (((r5 - r8) - r9) - r2) / 2;
        int r116 = ((ViewGroup.MarginLayoutParams) r38).topMargin;
        int r117 = this.mTitleMarginTop;
        if (r58 >= (r116 + r117)) goto L71;
        r58 = r116 + r117;
    L74:
        r40 = r8 + r58;
        goto L77
    L71:
        int r59 = (((r5 - r9) - r2) - r58) - r8;
        int r60 = ((ViewGroup.MarginLayoutParams) r38).bottomMargin;
        int r61 = this.mTitleMarginBottom;
        if (r59 >= (r60 + r61)) goto L74;
        r58 = Math.max(0, r58 - ((((ViewGroup.MarginLayoutParams) r39).bottomMargin + r61) - r59));
        goto L74
    L75:
        r40 = (((r5 - r9) - ((ViewGroup.MarginLayoutParams) r39).bottomMargin) - this.mTitleMarginBottom) - r2;
        goto L77
    L61:
        if (this.mSubtitleTextView.getMeasuredWidth() <= 0) goto L63;
    L62:
        r114 = true;
        goto L64
    L58:
        if (this.mTitleTextView.getMeasuredWidth() > 0) goto L62;
    L54:
        r37 = this.mTitleTextView;
        goto L55
    L51:
        r36 = this.mSubtitleTextView;
        goto L52
    L40:
        r2 = 0;
        goto L41
    L14:
        r15 = layoutChildLeft(this.mNavButtonView, r6, r11, r13);
    L15:
        r14 = r10;
        goto L18
    L16:
        r15 = r6;
        goto L15
    L9:
        r13 = 0;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        int[] r8 = this.mTempMargins;
        boolean r9 = ViewUtils.isLayoutRtl(this);
        int r10 = 0;
        int r11 = !r9 ? 1 : 0;
        if (shouldLayout(this.mNavButtonView) == false) goto L5;
        measureChildConstrained(this.mNavButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        int r0 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int r13 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        int r14 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    L7:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L9;
        measureChildConstrained(this.mCollapseButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        r0 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        r13 = Math.max(r13, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        r14 = View.combineMeasuredStates(r14, this.mCollapseButtonView.getMeasuredState());
    L9:
        int r1 = getCurrentContentInsetStart();
        int r12 = Math.max(r1, r0);
        r8[r9 ? 1 : 0] = Math.max(0, r1 - r0);
        if (shouldLayout(this.mMenuView) == false) goto L12;
        measureChildConstrained(this.mMenuView, r17, r12, r18, 0, this.mMaxButtonHeight);
        int r2 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        r13 = Math.max(r13, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        r14 = View.combineMeasuredStates(r14, this.mMenuView.getMeasuredState());
    L13:
        int r3 = getCurrentContentInsetEnd();
        int r15 = Math.max(r3, r2) + r12;
        r8[r11] = Math.max(0, r3 - r2);
        if (shouldLayout(this.mExpandedActionView) == false) goto L17;
        r15 = r15 + measureChildCollapseMargins(this.mExpandedActionView, r17, r15, r18, 0, r8);
        r13 = Math.max(r13, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        r14 = View.combineMeasuredStates(r14, this.mExpandedActionView.getMeasuredState());
    L17:
        if (shouldLayout(this.mLogoView) == false) goto L19;
        r15 = r15 + measureChildCollapseMargins(this.mLogoView, r17, r15, r18, 0, r8);
        r13 = Math.max(r13, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        r14 = View.combineMeasuredStates(r14, this.mLogoView.getMeasuredState());
    L19:
        int r16 = getChildCount();
        int r19 = 0;
    L20:
        if (r19 >= r16) goto L28;
        View r110 = getChildAt(r19);
        if (((LayoutParams) r110.getLayoutParams()).mViewType != 0) goto L27;
        if (shouldLayout(r110) == false) goto L27;
        r15 = r15 + measureChildCollapseMargins(r110, r17, r15, r18, 0, r8);
        r13 = Math.max(r13, r110.getMeasuredHeight() + getVerticalMargins(r110));
        r14 = View.combineMeasuredStates(r14, r110.getMeasuredState());
    L27:
        r19 = r19 + 1;
        goto L20
    L28:
        int r111 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int r112 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView) == false) goto L31;
        measureChildCollapseMargins(this.mTitleTextView, r17, r15 + r112, r18, r111, r8);
        int r4 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        int r113 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        int r6 = View.combineMeasuredStates(r14, this.mTitleTextView.getMeasuredState());
        int r114 = r4;
    L33:
        if (shouldLayout(this.mSubtitleTextView) == false) goto L36;
        r114 = Math.max(r114, measureChildCollapseMargins(this.mSubtitleTextView, r17, r15 + r112, r18, r113 + r111, r8));
        r113 = r113 + (this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView));
        r6 = View.combineMeasuredStates(r6, this.mSubtitleTextView.getMeasuredState());
    L36:
        int r5 = Math.max(r13, r113);
        int r7 = getPaddingRight() + getPaddingLeft();
        int r20 = (getPaddingBottom() + getPaddingTop()) + r5;
        int r21 = View.resolveSizeAndState(Math.max(r7 + (r15 + r114), getSuggestedMinimumWidth()), r17, (-16777216) & r6);
        int r22 = View.resolveSizeAndState(Math.max(r20, getSuggestedMinimumHeight()), r18, r6 << 16);
        if (shouldCollapse() == true) goto L40;
        r10 = r22;
    L40:
        setMeasuredDimension(r21, r10);
        return;
    L31:
        r113 = 0;
        r6 = r14;
        r114 = 0;
        goto L33
    L12:
        r2 = 0;
        goto L13
    L5:
        r0 = 0;
        r13 = 0;
        r14 = 0;
        goto L7
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L9;
        MenuBuilder r1 = r0.peekMenu();
    L10:
        int r2 = r5.expandedMenuItemId;
        if (r2 == 0) goto L19;
        if (this.mExpandedMenuPresenter == null) goto L19;
        if (r1 == null) goto L19;
        MenuItem r3 = r1.findItem(r2);
        if (r3 == null) goto L19;
        r3.expandActionView();
    L19:
        if (r5.isOverflowOpen == false) goto L22;
        postShowOverflowMenu();
        return;
    L22:
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r2) {
        super.onRtlPropertiesChanged(r2);
        ensureContentInsets();
        RtlSpacingHelper r1 = this.mContentInsets;
        boolean r0 = true;
        if (r2 == 1) goto L6;
        r0 = false;
    L6:
        r1.setDirection(r0);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter r1 = this.mExpandedMenuPresenter;
        if (r1 == null) goto L7;
        MenuItemImpl r2 = r1.mCurrentExpandedItem;
        if (r2 == null) goto L7;
        r0.expandedMenuItemId = r2.getItemId();
    L7:
        r0.isOverflowOpen = isOverflowMenuShowing();
        return r0;
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

    public void removeChildrenForExpandedActionView() {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L10;
        View r1 = getChildAt(r0);
        if (((LayoutParams) r1.getLayoutParams()).mViewType == 2) goto L9;
        if (r1 == this.mMenuView) goto L9;
        removeViewAt(r0);
        this.mHiddenViews.add(r1);
    L9:
        r0 = r0 - 1;
        goto L3
    }

    public void setCollapseContentDescription(@StringRes int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getContext().getText(r2);
    L5:
        setCollapseContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setCollapseIcon(@DrawableRes int r2) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), r2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean r1) {
        this.mCollapsible = r1;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int r2) {
        if (r2 >= 0) goto L5;
        r2 = Integer.MIN_VALUE;
    L5:
        if (r2 == this.mContentInsetEndWithActions) goto L10;
        this.mContentInsetEndWithActions = r2;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetStartWithNavigation(int r2) {
        if (r2 >= 0) goto L5;
        r2 = Integer.MIN_VALUE;
    L5:
        if (r2 == this.mContentInsetStartWithNavigation) goto L10;
        this.mContentInsetStartWithNavigation = r2;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetsAbsolute(int r1, int r2) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r1, r2);
    }

    public void setContentInsetsRelative(int r1, int r2) {
        ensureContentInsets();
        this.mContentInsets.setRelative(r1, r2);
    }

    public void setLogo(@DrawableRes int r2) {
        setLogo(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setLogoDescription(@StringRes int r2) {
        setLogoDescription(getContext().getText(r2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenu(MenuBuilder r4, ActionMenuPresenter r5) {
        if (r4 == null) goto L4;
    L6:
        ensureMenuView();
        MenuBuilder r0 = this.mMenuView.peekMenu();
        if (r0 != r4) goto L9;
        return;
    L9:
        if (r0 == null) goto L12;
        r0.removeMenuPresenter(this.mOuterActionMenuPresenter);
        r0.removeMenuPresenter(this.mExpandedMenuPresenter);
    L12:
        if (this.mExpandedMenuPresenter != null) goto L14;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L14:
        r5.setExpandedActionViewsExclusive(true);
        if (r4 == null) goto L17;
        r4.addMenuPresenter(r5, this.mPopupContext);
        r4.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    L18:
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(r5);
        this.mOuterActionMenuPresenter = r5;
        return;
    L17:
        r5.initForMenu(this.mPopupContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
        r5.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
        goto L18
    L4:
        if (this.mMenuView != null) goto L6;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback r1, MenuBuilder.Callback r2) {
        this.mActionMenuPresenterCallback = r1;
        this.mMenuBuilderCallback = r2;
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L6;
        r0.setMenuCallbacks(r1, r2);
        return;
    }

    public void setNavigationContentDescription(@StringRes int r2) {
        if (r2 == 0) goto L4;
        CharSequence r3 = getContext().getText(r2);
    L5:
        setNavigationContentDescription(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setNavigationIcon(@DrawableRes int r2) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), r2));
    }

    public void setNavigationOnClickListener(View.OnClickListener r1) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(r1);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r1) {
        this.mOnMenuItemClickListener = r1;
    }

    public void setOverflowIcon(@Nullable Drawable r1) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(r1);
    }

    public void setPopupTheme(@StyleRes int r3) {
        if (this.mPopupTheme == r3) goto L9;
        this.mPopupTheme = r3;
        if (r3 != 0) goto L7;
        this.mPopupContext = getContext();
        return;
    L7:
        this.mPopupContext = new ContextThemeWrapper(getContext(), r3);
        return;
    }

    public void setSubtitle(@StringRes int r2) {
        setSubtitle(getContext().getText(r2));
    }

    public void setSubtitleTextAppearance(Context r1, @StyleRes int r2) {
        this.mSubtitleTextAppearance = r2;
        TextView r0 = this.mSubtitleTextView;
        if (r0 == null) goto L6;
        r0.setTextAppearance(r1, r2);
        return;
    }

    public void setSubtitleTextColor(@ColorInt int r1) {
        setSubtitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setTitle(@StringRes int r2) {
        setTitle(getContext().getText(r2));
    }

    public void setTitleMargin(int r1, int r2, int r3, int r4) {
        this.mTitleMarginStart = r1;
        this.mTitleMarginTop = r2;
        this.mTitleMarginEnd = r3;
        this.mTitleMarginBottom = r4;
        requestLayout();
    }

    public void setTitleMarginBottom(int r1) {
        this.mTitleMarginBottom = r1;
        requestLayout();
    }

    public void setTitleMarginEnd(int r1) {
        this.mTitleMarginEnd = r1;
        requestLayout();
    }

    public void setTitleMarginStart(int r1) {
        this.mTitleMarginStart = r1;
        requestLayout();
    }

    public void setTitleMarginTop(int r1) {
        this.mTitleMarginTop = r1;
        requestLayout();
    }

    public void setTitleTextAppearance(Context r1, @StyleRes int r2) {
        this.mTitleTextAppearance = r2;
        TextView r0 = this.mTitleTextView;
        if (r0 == null) goto L6;
        r0.setTextAppearance(r1, r2);
        return;
    }

    public void setTitleTextColor(@ColorInt int r1) {
        setTitleTextColor(ColorStateList.valueOf(r1));
    }

    public boolean showOverflowMenu() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.showOverflowMenu() == false) goto L7;
        return true;
    }

    public Toolbar(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.toolbarStyle);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public void setCollapseContentDescription(@Nullable CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        ensureCollapseButtonView();
    L5:
        ImageButton r1 = this.mCollapseButtonView;
        if (r1 == null) goto L9;
        r1.setContentDescription(r2);
        return;
    }

    public void setCollapseIcon(@Nullable Drawable r1) {
        if (r1 == null) goto L4;
        ensureCollapseButtonView();
        this.mCollapseButtonView.setImageDrawable(r1);
        return;
    L4:
        ImageButton r2 = this.mCollapseButtonView;
        if (r2 == null) goto L9;
        r2.setImageDrawable(this.mCollapseIcon);
        return;
    }

    public void setLogo(Drawable r3) {
        if (r3 == null) goto L6;
        ensureLogoView();
        if (isChildOrHidden(this.mLogoView) == true) goto L11;
        addSystemView(this.mLogoView, true);
    L11:
        ImageView r2 = this.mLogoView;
        if (r2 == null) goto L15;
        r2.setImageDrawable(r3);
        return;
    L15:
        return;
    L6:
        ImageView r0 = this.mLogoView;
        if (r0 == null) goto L11;
        if (isChildOrHidden(r0) == false) goto L11;
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
        goto L11
    }

    public void setLogoDescription(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        ensureLogoView();
    L5:
        ImageView r1 = this.mLogoView;
        if (r1 == null) goto L9;
        r1.setContentDescription(r2);
        return;
    }

    public void setNavigationContentDescription(@Nullable CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        ensureNavButtonView();
    L5:
        ImageButton r1 = this.mNavButtonView;
        if (r1 == null) goto L9;
        r1.setContentDescription(r2);
        return;
    }

    public void setNavigationIcon(@Nullable Drawable r3) {
        if (r3 == null) goto L6;
        ensureNavButtonView();
        if (isChildOrHidden(this.mNavButtonView) == true) goto L11;
        addSystemView(this.mNavButtonView, true);
    L11:
        ImageButton r2 = this.mNavButtonView;
        if (r2 == null) goto L15;
        r2.setImageDrawable(r3);
        return;
    L15:
        return;
    L6:
        ImageButton r0 = this.mNavButtonView;
        if (r0 == null) goto L11;
        if (isChildOrHidden(r0) == false) goto L11;
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
        goto L11
    }

    public void setSubtitle(CharSequence r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        TextView r0 = this.mSubtitleTextView;
        if (r0 != null) goto L18;
    L20:
        TextView r1 = this.mSubtitleTextView;
        if (r1 == null) goto L23;
        r1.setText(r4);
    L23:
        this.mSubtitleText = r4;
        return;
    L18:
        if (isChildOrHidden(r0) == false) goto L20;
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
        goto L20
    L5:
        if (this.mSubtitleTextView != null) goto L13;
        Context r2 = getContext();
        AppCompatTextView r3 = new AppCompatTextView(r2);
        this.mSubtitleTextView = r3;
        r3.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r5 = this.mSubtitleTextAppearance;
        if (r5 == 0) goto L9;
        this.mSubtitleTextView.setTextAppearance(r2, r5);
    L9:
        ColorStateList r6 = this.mSubtitleTextColor;
        if (r6 == null) goto L13;
        this.mSubtitleTextView.setTextColor(r6);
    L13:
        if (isChildOrHidden(this.mSubtitleTextView) == true) goto L20;
        addSystemView(this.mSubtitleTextView, true);
        goto L20
    }

    public void setSubtitleTextColor(@NonNull ColorStateList r1) {
        this.mSubtitleTextColor = r1;
        TextView r0 = this.mSubtitleTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
    }

    public void setTitle(CharSequence r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        TextView r0 = this.mTitleTextView;
        if (r0 != null) goto L18;
    L20:
        TextView r1 = this.mTitleTextView;
        if (r1 == null) goto L23;
        r1.setText(r4);
    L23:
        this.mTitleText = r4;
        return;
    L18:
        if (isChildOrHidden(r0) == false) goto L20;
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
        goto L20
    L5:
        if (this.mTitleTextView != null) goto L13;
        Context r2 = getContext();
        AppCompatTextView r3 = new AppCompatTextView(r2);
        this.mTitleTextView = r3;
        r3.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r5 = this.mTitleTextAppearance;
        if (r5 == 0) goto L9;
        this.mTitleTextView.setTextAppearance(r2, r5);
    L9:
        ColorStateList r6 = this.mTitleTextColor;
        if (r6 == null) goto L13;
        this.mTitleTextView.setTextColor(r6);
    L13:
        if (isChildOrHidden(this.mTitleTextView) == true) goto L20;
        addSystemView(this.mTitleTextView, true);
        goto L20
    }

    public void setTitleTextColor(@NonNull ColorStateList r1) {
        this.mTitleTextColor = r1;
        TextView r0 = this.mTitleTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
    }

    public Toolbar(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new AnonymousClass1(this);
        this.mShowOverflowMenuRunnable = new AnonymousClass2(this);
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(getContext(), r12, R.styleable.Toolbar, r13, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r11, R.styleable.Toolbar, r12, r0.getWrappedTypeArray(), r13, 0);
        this.mTitleTextAppearance = r0.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = r0.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = r0.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = r0.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int r14 = r0.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        if (r0.hasValue(R.styleable.Toolbar_titleMargins) == false) goto L5;
        r14 = r0.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, r14);
    L5:
        this.mTitleMarginBottom = r14;
        this.mTitleMarginTop = r14;
        this.mTitleMarginEnd = r14;
        this.mTitleMarginStart = r14;
        int r15 = r0.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (r15 < 0) goto L8;
        this.mTitleMarginStart = r15;
    L8:
        int r16 = r0.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (r16 < 0) goto L11;
        this.mTitleMarginEnd = r16;
    L11:
        int r17 = r0.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (r17 < 0) goto L14;
        this.mTitleMarginTop = r17;
    L14:
        int r18 = r0.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (r18 < 0) goto L17;
        this.mTitleMarginBottom = r18;
    L17:
        this.mMaxButtonHeight = r0.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int r19 = r0.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int r110 = r0.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int r1 = r0.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int r3 = r0.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r1, r3);
        if (r19 != Integer.MIN_VALUE) goto L20;
        if (r110 != Integer.MIN_VALUE) goto L20;
    L21:
        this.mContentInsetStartWithNavigation = r0.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = r0.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = r0.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = r0.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence r111 = r0.getText(R.styleable.Toolbar_title);
        if (TextUtils.isEmpty(r111) == true) goto L24;
        setTitle(r111);
    L24:
        CharSequence r112 = r0.getText(R.styleable.Toolbar_subtitle);
        if (TextUtils.isEmpty(r112) == true) goto L27;
        setSubtitle(r112);
    L27:
        this.mPopupContext = getContext();
        setPopupTheme(r0.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable r113 = r0.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (r113 == null) goto L30;
        setNavigationIcon(r113);
    L30:
        CharSequence r114 = r0.getText(R.styleable.Toolbar_navigationContentDescription);
        if (TextUtils.isEmpty(r114) == true) goto L33;
        setNavigationContentDescription(r114);
    L33:
        Drawable r115 = r0.getDrawable(R.styleable.Toolbar_logo);
        if (r115 == null) goto L36;
        setLogo(r115);
    L36:
        CharSequence r116 = r0.getText(R.styleable.Toolbar_logoDescription);
        if (TextUtils.isEmpty(r116) == true) goto L40;
        setLogoDescription(r116);
    L40:
        if (r0.hasValue(R.styleable.Toolbar_titleTextColor) == false) goto L43;
        setTitleTextColor(r0.getColorStateList(R.styleable.Toolbar_titleTextColor));
    L43:
        if (r0.hasValue(R.styleable.Toolbar_subtitleTextColor) == false) goto L46;
        setSubtitleTextColor(r0.getColorStateList(R.styleable.Toolbar_subtitleTextColor));
    L46:
        if (r0.hasValue(R.styleable.Toolbar_menu) == false) goto L48;
        inflateMenu(r0.getResourceId(R.styleable.Toolbar_menu, 0));
    L48:
        r0.recycle();
        return;
    L20:
        this.mContentInsets.setRelative(r19, r110);
        goto L21
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        if ((r1 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r1);
    L7:
        if ((r1 instanceof ActionBar.LayoutParams) == false) goto L11;
        return new LayoutParams((ActionBar.LayoutParams) r1);
    L11:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
    L15:
        return new LayoutParams(r1);
    }
}
