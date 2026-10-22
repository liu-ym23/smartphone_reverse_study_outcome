package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private OnBackInvokedCallback mBackInvokedCallback;
    private boolean mBackInvokedCallbackEnabled;
    private OnBackInvokedDispatcher mBackInvokedDispatcher;
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
    MenuBuilder.Callback mMenuBuilderCallback;
    final MenuHostHelper mMenuHostHelper;
    ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private ArrayList<MenuItem> mProvidedMenuItems;
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

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @Nullable
        @DoNotInline
        static OnBackInvokedDispatcher findOnBackInvokedDispatcher(@NonNull View r0) {
            return r0.findOnBackInvokedDispatcher();
        }

        @NonNull
        @DoNotInline
        static OnBackInvokedCallback newOnBackInvokedCallback(@NonNull final Runnable r1) {
            Objects.requireNonNull(r1);
            return new a(r1);
        }

        @DoNotInline
        static void tryRegisterOnBackInvokedCallback(@NonNull Object r1, @NonNull Object r2) {
            ((OnBackInvokedDispatcher) r1).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) r2);
        }

        @DoNotInline
        static void tryUnregisterOnBackInvokedCallback(@NonNull Object r0, @NonNull Object r1) {
            ((OnBackInvokedDispatcher) r0).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r1);
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;
        final /* synthetic */ Toolbar this$0;

        ExpandedActionViewMenuPresenter(Toolbar r1) {
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
            this.this$0.updateBackInvokedCallbackState();
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
            KeyEvent.Callback r9 = this.this$0.mExpandedActionView;
            if ((r9 instanceof CollapsibleActionView) == false) goto L17;
            ((CollapsibleActionView) r9).onActionViewExpanded();
        L17:
            this.this$0.updateBackInvokedCallbackState();
            return true;
        L11:
            if ((r8 instanceof ViewGroup) == false) goto L13;
            ((ViewGroup) r8).removeView(r1.mExpandedActionView);
        L13:
            LayoutParams r10 = this.this$0.generateDefaultLayoutParams();
            Toolbar r2 = this.this$0;
            r10.gravity = 8388611 | (r2.mButtonGravity & 112);
            r10.mViewType = 2;
            r2.mExpandedActionView.setLayoutParams(r10);
            Toolbar r11 = this.this$0;
            r11.addView(r11.mExpandedActionView);
            goto L14
        L5:
            if ((r6 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r6).removeView(r0.mCollapseButtonView);
        L7:
            Toolbar r12 = this.this$0;
            r12.addView(r12.mCollapseButtonView);
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
        public void updateMenuView(boolean r5) {
            if (this.mCurrentExpandedItem == null) goto L17;
            MenuBuilder r6 = this.mMenu;
            boolean r0 = false;
            if (r6 == null) goto L12;
            int r7 = r6.size();
            int r1 = 0;
        L7:
            if (r1 >= r7) goto L12;
            if (this.mMenu.getItem(r1) == this.mCurrentExpandedItem) goto L10;
            r1 = r1 + 1;
            goto L7
        L10:
            r0 = true;
        L12:
            if (r0 == true) goto L18;
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            return;
        L18:
            return;
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(int r3) {
            this(-2, -1, r3);
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

        public LayoutParams(@NonNull Context r1, AttributeSet r2) {
            super(r1, r2);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            super(r2);
            this.mViewType = 0;
            copyMarginsFromCompat(r2);
        }

        public LayoutParams(ActionBar.LayoutParams r1) {
            super(r1);
            this.mViewType = 0;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.mViewType = 0;
            this.mViewType = r2.mViewType;
        }

        void copyMarginsFromCompat(ViewGroup.MarginLayoutParams r2) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r2.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r2.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r2.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r2.bottomMargin;
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

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.expandedMenuItemId);
            r1.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    public Toolbar(@NonNull Context r2) {
        this(r2, null);
    }

    public Toolbar(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.toolbarStyle);
    }

    public Toolbar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new d(this));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new AnonymousClass1(this);
        this.mShowOverflowMenuRunnable = new AnonymousClass2(this);
        Context r0 = getContext();
        int[] r3 = R.styleable.Toolbar;
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(r0, r11, r3, r12, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r10, r3, r11, r1.getWrappedTypeArray(), r12, 0);
        this.mTitleTextAppearance = r1.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = r1.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = r1.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = r1.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int r13 = r1.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        int r14 = R.styleable.Toolbar_titleMargins;
        if (r1.hasValue(r14) == false) goto L5;
        r13 = r1.getDimensionPixelOffset(r14, r13);
    L5:
        this.mTitleMarginBottom = r13;
        this.mTitleMarginTop = r13;
        this.mTitleMarginEnd = r13;
        this.mTitleMarginStart = r13;
        int r15 = r1.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (r15 < 0) goto L8;
        this.mTitleMarginStart = r15;
    L8:
        int r16 = r1.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (r16 < 0) goto L11;
        this.mTitleMarginEnd = r16;
    L11:
        int r17 = r1.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (r17 < 0) goto L14;
        this.mTitleMarginTop = r17;
    L14:
        int r18 = r1.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (r18 < 0) goto L17;
        this.mTitleMarginBottom = r18;
    L17:
        this.mMaxButtonHeight = r1.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int r19 = r1.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int r110 = r1.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int r2 = r1.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int r4 = r1.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r2, r4);
        if (r19 != Integer.MIN_VALUE) goto L20;
        if (r110 != Integer.MIN_VALUE) goto L20;
    L21:
        this.mContentInsetStartWithNavigation = r1.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = r1.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = r1.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = r1.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence r111 = r1.getText(R.styleable.Toolbar_title);
        if (TextUtils.isEmpty(r111) == true) goto L24;
        setTitle(r111);
    L24:
        CharSequence r112 = r1.getText(R.styleable.Toolbar_subtitle);
        if (TextUtils.isEmpty(r112) == true) goto L27;
        setSubtitle(r112);
    L27:
        this.mPopupContext = getContext();
        setPopupTheme(r1.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable r113 = r1.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (r113 == null) goto L30;
        setNavigationIcon(r113);
    L30:
        CharSequence r114 = r1.getText(R.styleable.Toolbar_navigationContentDescription);
        if (TextUtils.isEmpty(r114) == true) goto L33;
        setNavigationContentDescription(r114);
    L33:
        Drawable r115 = r1.getDrawable(R.styleable.Toolbar_logo);
        if (r115 == null) goto L36;
        setLogo(r115);
    L36:
        CharSequence r116 = r1.getText(R.styleable.Toolbar_logoDescription);
        if (TextUtils.isEmpty(r116) == true) goto L39;
        setLogoDescription(r116);
    L39:
        int r117 = R.styleable.Toolbar_titleTextColor;
        if (r1.hasValue(r117) == false) goto L42;
        setTitleTextColor(r1.getColorStateList(r117));
    L42:
        int r118 = R.styleable.Toolbar_subtitleTextColor;
        if (r1.hasValue(r118) == false) goto L45;
        setSubtitleTextColor(r1.getColorStateList(r118));
    L45:
        int r119 = R.styleable.Toolbar_menu;
        if (r1.hasValue(r119) == false) goto L48;
        inflateMenu(r1.getResourceId(r119, 0));
    L48:
        r1.recycle();
        return;
    L20:
        this.mContentInsets.setRelative(r19, r110);
        goto L21
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
        updateBackInvokedCallbackState();
        return;
    }

    private void ensureMenuView() {
        if (this.mMenuView != null) goto L6;
        ActionMenuView r0 = new ActionMenuView(getContext());
        this.mMenuView = r0;
        r0.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, new AnonymousClass3(this));
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.gravity = 8388613 | (this.mButtonGravity & 112);
        this.mMenuView.setLayoutParams(r1);
        addSystemView(this.mMenuView, false);
        return;
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView != null) goto L6;
        this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        LayoutParams r0 = generateDefaultLayoutParams();
        r0.gravity = 8388611 | (this.mButtonGravity & 112);
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
        int r3 = r2 & 112;
        if (r3 != 16) goto L5;
    L10:
        return r3;
    L5:
        if (r3 == 48) goto L10;
        if (r3 == 80) goto L10;
        return this.mGravity & 112;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> r0 = new ArrayList();
        Menu r3 = getMenu();
        int r1 = 0;
    L4:
        if (r1 >= r3.size()) goto L6;
        r0.add(r3.getItem(r1));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private int getHorizontalMargins(View r1) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(r0) + MarginLayoutParamsCompat.getMarginEnd(r0);
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
        r3 = r3 + ((r11 + r4.getMeasuredWidth()) + r12);
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
        int r9 = r6 + Math.max(0, r1);
        r7[0] = Math.max(0, -r1);
        int r4 = getChildTop(r5, r8);
        int r10 = r5.getMeasuredWidth();
        r5.layout(r9, r4, r9 + r10, r5.getMeasuredHeight() + r4);
        return r9 + (r10 + ((ViewGroup.MarginLayoutParams) r0).rightMargin);
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
        int r5 = Math.max(0, r1) + Math.max(0, r3);
        r13[0] = Math.max(0, -r1);
        r13[1] = Math.max(0, -r3);
        r8.measure(ViewGroup.getChildMeasureSpec(r9, ((getPaddingLeft() + getPaddingRight()) + r5) + r10, r0.width), ViewGroup.getChildMeasureSpec(r11, (((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r12, r0.height));
        return r8.getMeasuredWidth() + r5;
    }

    private void measureChildConstrained(View r4, int r5, int r6, int r7, int r8, int r9) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        int r10 = ViewGroup.getChildMeasureSpec(r5, (((getPaddingLeft() + getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r6, r0.width);
        int r3 = ViewGroup.getChildMeasureSpec(r7, (((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r8, r0.height);
        int r11 = View.MeasureSpec.getMode(r3);
        if (r11 == 1073741824) goto L8;
        if (r9 < 0) goto L8;
        if (r11 == 0) goto L7;
        r9 = Math.min(View.MeasureSpec.getSize(r3), r9);
    L7:
        r3 = View.MeasureSpec.makeMeasureSpec(r9, BasicMeasure.EXACTLY);
    L8:
        r4.measure(r10, r3);
    }

    private void onCreateMenu() {
        Menu r0 = getMenu();
        ArrayList<MenuItem> r1 = getCurrentMenuItems();
        this.mMenuHostHelper.onCreateMenu(r0, getMenuInflater());
        ArrayList<MenuItem> r2 = getCurrentMenuItems();
        r2.removeAll(r1);
        this.mProvidedMenuItems = r2;
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

    void addChildrenForExpandedActionView() {
        int r0 = this.mHiddenViews.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        addView(this.mHiddenViews.get(r0));
        r0 = r0 - 1;
        goto L3
    L5:
        this.mHiddenViews.clear();
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r1) {
        this.mMenuHostHelper.addMenuProvider(r1);
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r1, @NonNull LifecycleOwner r2) {
        this.mMenuHostHelper.addMenuProvider(r1, r2);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r1, @NonNull LifecycleOwner r2, @NonNull Lifecycle.State r3) {
        this.mMenuHostHelper.addMenuProvider(r1, r2, r3);
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
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
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

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) goto L6;
        AppCompatImageButton r0 = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        this.mCollapseButtonView = r0;
        r0.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.gravity = 8388611 | (this.mButtonGravity & 112);
        r1.mViewType = 2;
        this.mCollapseButtonView.setLayoutParams(r1);
        this.mCollapseButtonView.setOnClickListener(new AnonymousClass4(this));
        return;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
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
        if (r0 == null) goto L9;
        MenuBuilder r1 = r0.peekMenu();
        if (r1 == null) goto L9;
        if (r1.hasVisibleItems() == false) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    L13:
        return getContentInsetEnd();
    L9:
        r2 = false;
        goto L10
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
    @RestrictTo({RestrictTo.Scope.TESTS})
    View getNavButtonView() {
        return this.mNavButtonView;
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

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    final TextView getSubtitleTextView() {
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
    final TextView getTitleTextView() {
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

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void invalidateMenu() {
        Iterator<MenuItem> r0 = this.mProvidedMenuItems.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MenuItem r1 = r0.next();
        getMenu().removeItem(r1.getItemId());
        goto L4
    L6:
        onCreateMenu();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
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
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
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
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
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
        ImageButton r14 = this.mNavButtonView;
        if (r1 == false) goto L15;
        int r15 = layoutChildRight(r14, r10, r11, r13);
        int r16 = r6;
    L19:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L25;
        ImageButton r17 = this.mCollapseButtonView;
        if (r1 == false) goto L23;
        r15 = layoutChildRight(r17, r15, r11, r13);
        goto L25
    L23:
        r16 = layoutChildLeft(r17, r16, r11, r13);
    L25:
        if (shouldLayout(this.mMenuView) == false) goto L30;
        ActionMenuView r18 = this.mMenuView;
        if (r1 == false) goto L29;
        r16 = layoutChildLeft(r18, r16, r11, r13);
        goto L30
    L29:
        r15 = layoutChildRight(r18, r15, r11, r13);
    L30:
        int r19 = getCurrentContentInsetLeft();
        int r110 = getCurrentContentInsetRight();
        r11[0] = Math.max(0, r19 - r16);
        r11[1] = Math.max(0, r110 - (r10 - r15));
        int r2 = Math.max(r16, r19);
        int r111 = Math.min(r15, r10 - r110);
        if (shouldLayout(this.mExpandedActionView) == false) goto L37;
        View r112 = this.mExpandedActionView;
        if (r1 == false) goto L35;
        r111 = layoutChildRight(r112, r111, r11, r13);
        goto L37
    L35:
        r2 = layoutChildLeft(r112, r2, r11, r13);
    L37:
        if (shouldLayout(this.mLogoView) == false) goto L42;
        ImageView r113 = this.mLogoView;
        if (r1 == false) goto L41;
        r111 = layoutChildRight(r113, r111, r11, r13);
        goto L42
    L41:
        r2 = layoutChildLeft(r113, r2, r11, r13);
    L42:
        boolean r114 = shouldLayout(this.mTitleTextView);
        boolean r115 = shouldLayout(this.mSubtitleTextView);
        if (r114 == false) goto L45;
        LayoutParams r116 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r3 = ((((ViewGroup.MarginLayoutParams) r116).topMargin + this.mTitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r116).bottomMargin) + 0;
    L46:
        if (r115 == false) goto L49;
        LayoutParams r25 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        r3 = r3 + ((((ViewGroup.MarginLayoutParams) r25).topMargin + this.mSubtitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r25).bottomMargin);
    L49:
        if (r114 == true) goto L54;
        if (r115 == true) goto L54;
        int r117 = r6;
        r13 = r13;
    L53:
        int r26 = 0;
    L108:
        addCustomViewsWithGravity(this.mTempViews, 3);
        int r27 = this.mTempViews.size();
        int r28 = r26;
    L109:
        if (r28 >= r27) goto L111;
        r2 = layoutChildLeft(this.mTempViews.get(r28), r2, r11, r13);
        r28 = r28 + 1;
        goto L109
    L111:
        int r118 = r13;
        addCustomViewsWithGravity(this.mTempViews, 5);
        int r29 = this.mTempViews.size();
        int r30 = r26;
    L112:
        if (r30 >= r29) goto L114;
        r111 = layoutChildRight(this.mTempViews.get(r30), r111, r11, r118);
        r30 = r30 + 1;
        goto L112
    L114:
        addCustomViewsWithGravity(this.mTempViews, 1);
        int r31 = getViewListMeasuredWidth(this.mTempViews, r11);
        int r32 = (r117 + (((r4 - r117) - r7) / 2)) - (r31 / 2);
        int r33 = r31 + r32;
        if (r32 < r2) goto L120;
        if (r33 <= r111) goto L119;
        r2 = r32 - (r33 - r111);
        goto L120
    L119:
        r2 = r32;
    L120:
        int r34 = this.mTempViews.size();
    L121:
        if (r26 >= r34) goto L123;
        r2 = layoutChildLeft(this.mTempViews.get(r26), r2, r11, r118);
        r26 = r26 + 1;
        goto L121
    L123:
        this.mTempViews.clear();
        return;
    L54:
        if (r114 == false) goto L56;
        TextView r35 = this.mTitleTextView;
    L57:
        if (r115 == false) goto L59;
        TextView r36 = this.mSubtitleTextView;
    L60:
        LayoutParams r37 = (LayoutParams) r35.getLayoutParams();
        LayoutParams r38 = (LayoutParams) r36.getLayoutParams();
        if (r114 == true) goto L63;
    L64:
        if (r115 == true) goto L66;
    L68:
        boolean r119 = false;
    L69:
        int r120 = this.mGravity & 112;
        r117 = r6;
        if (r120 != 48) goto L72;
        int r39 = (getPaddingTop() + ((ViewGroup.MarginLayoutParams) r37).topMargin) + this.mTitleMarginTop;
    L82:
        if (r1 == false) goto L96;
        if (r119 == false) goto L85;
        int r40 = this.mTitleMarginStart;
    L86:
        int r41 = r40 - r11[1];
        r111 = r111 - Math.max(0, r41);
        r11[1] = Math.max(0, -r41);
        if (r114 == false) goto L89;
        LayoutParams r42 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r43 = r111 - this.mTitleTextView.getMeasuredWidth();
        int r44 = this.mTitleTextView.getMeasuredHeight() + r39;
        this.mTitleTextView.layout(r43, r39, r111, r44);
        int r45 = r43 - this.mTitleMarginEnd;
        r39 = r44 + ((ViewGroup.MarginLayoutParams) r42).bottomMargin;
    L90:
        if (r115 == false) goto L92;
        LayoutParams r46 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        int r47 = r39 + ((ViewGroup.MarginLayoutParams) r46).topMargin;
        this.mSubtitleTextView.layout(r111 - this.mSubtitleTextView.getMeasuredWidth(), r47, r111, this.mSubtitleTextView.getMeasuredHeight() + r47);
        int r48 = r111 - this.mTitleMarginEnd;
        int r49 = ((ViewGroup.MarginLayoutParams) r46).bottomMargin;
    L93:
        if (r119 == false) goto L95;
        r111 = Math.min(r45, r48);
    L95:
        r2 = r2;
        goto L53
    L92:
        r48 = r111;
        goto L93
    L89:
        r45 = r111;
        goto L90
    L85:
        r40 = 0;
        goto L86
    L96:
        if (r119 == false) goto L98;
        int r50 = this.mTitleMarginStart;
        r26 = 0;
    L99:
        int r51 = r50 - r11[r26];
        r2 = r2 + Math.max(r26, r51);
        r11[r26] = Math.max(r26, -r51);
        if (r114 == false) goto L102;
        LayoutParams r52 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r53 = this.mTitleTextView.getMeasuredWidth() + r2;
        int r54 = this.mTitleTextView.getMeasuredHeight() + r39;
        this.mTitleTextView.layout(r2, r39, r53, r54);
        int r55 = r53 + this.mTitleMarginEnd;
        r39 = r54 + ((ViewGroup.MarginLayoutParams) r52).bottomMargin;
    L103:
        if (r115 == false) goto L105;
        LayoutParams r56 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        int r57 = r39 + ((ViewGroup.MarginLayoutParams) r56).topMargin;
        int r58 = this.mSubtitleTextView.getMeasuredWidth() + r2;
        this.mSubtitleTextView.layout(r2, r57, r58, this.mSubtitleTextView.getMeasuredHeight() + r57);
        int r59 = r58 + this.mTitleMarginEnd;
        int r60 = ((ViewGroup.MarginLayoutParams) r56).bottomMargin;
    L106:
        if (r119 == false) goto L108;
        r2 = Math.max(r55, r59);
        goto L108
    L105:
        r59 = r2;
        goto L106
    L102:
        r55 = r2;
        goto L103
    L98:
        r26 = 0;
        r50 = 0;
        goto L99
    L72:
        if (r120 == 80) goto L80;
        int r61 = (((r5 - r8) - r9) - r3) / 2;
        int r121 = ((ViewGroup.MarginLayoutParams) r37).topMargin;
        int r122 = this.mTitleMarginTop;
        if (r61 >= (r121 + r122)) goto L76;
        r61 = r121 + r122;
    L79:
        r39 = r8 + r61;
        goto L82
    L76:
        int r62 = (((r5 - r9) - r3) - r61) - r8;
        int r63 = ((ViewGroup.MarginLayoutParams) r37).bottomMargin;
        int r64 = this.mTitleMarginBottom;
        if (r62 >= (r63 + r64)) goto L79;
        r61 = Math.max(0, r61 - ((((ViewGroup.MarginLayoutParams) r38).bottomMargin + r64) - r62));
        goto L79
    L80:
        r39 = (((r5 - r9) - ((ViewGroup.MarginLayoutParams) r38).bottomMargin) - this.mTitleMarginBottom) - r3;
        goto L82
    L66:
        if (this.mSubtitleTextView.getMeasuredWidth() <= 0) goto L68;
    L67:
        r119 = true;
        goto L69
    L63:
        if (this.mTitleTextView.getMeasuredWidth() > 0) goto L67;
    L59:
        r36 = this.mTitleTextView;
        goto L60
    L56:
        r35 = this.mSubtitleTextView;
        goto L57
    L45:
        r3 = 0;
        goto L46
    L15:
        r16 = layoutChildLeft(r14, r6, r11, r13);
    L17:
        r15 = r10;
        goto L19
    L16:
        r16 = r6;
        goto L17
    L9:
        r13 = 0;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.view.View
    protected void onMeasure(int r17, int r18) {
        int[] r8 = this.mTempMargins;
        int r9 = 0;
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        char r10 = 1;
        char r11 = 0;
    L7:
        if (shouldLayout(this.mNavButtonView) == false) goto L9;
        measureChildConstrained(this.mNavButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        int r0 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int r12 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        int r13 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    L11:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L13;
        measureChildConstrained(this.mCollapseButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        r0 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        r12 = Math.max(r12, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        r13 = View.combineMeasuredStates(r13, this.mCollapseButtonView.getMeasuredState());
    L13:
        int r1 = getCurrentContentInsetStart();
        int r14 = 0 + Math.max(r1, r0);
        r8[r10] = Math.max(0, r1 - r0);
        if (shouldLayout(this.mMenuView) == false) goto L16;
        measureChildConstrained(this.mMenuView, r17, r14, r18, 0, this.mMaxButtonHeight);
        int r2 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        r12 = Math.max(r12, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        r13 = View.combineMeasuredStates(r13, this.mMenuView.getMeasuredState());
    L17:
        int r3 = getCurrentContentInsetEnd();
        int r15 = r14 + Math.max(r3, r2);
        r8[r11] = Math.max(0, r3 - r2);
        if (shouldLayout(this.mExpandedActionView) == false) goto L21;
        r15 = r15 + measureChildCollapseMargins(this.mExpandedActionView, r17, r15, r18, 0, r8);
        r12 = Math.max(r12, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        r13 = View.combineMeasuredStates(r13, this.mExpandedActionView.getMeasuredState());
    L21:
        if (shouldLayout(this.mLogoView) == false) goto L23;
        r15 = r15 + measureChildCollapseMargins(this.mLogoView, r17, r15, r18, 0, r8);
        r12 = Math.max(r12, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        r13 = View.combineMeasuredStates(r13, this.mLogoView.getMeasuredState());
    L23:
        int r16 = getChildCount();
        int r19 = 0;
    L24:
        if (r19 >= r16) goto L32;
        View r110 = getChildAt(r19);
        if (((LayoutParams) r110.getLayoutParams()).mViewType != 0) goto L31;
        if (shouldLayout(r110) == false) goto L31;
        r15 = r15 + measureChildCollapseMargins(r110, r17, r15, r18, 0, r8);
        r12 = Math.max(r12, r110.getMeasuredHeight() + getVerticalMargins(r110));
        r13 = View.combineMeasuredStates(r13, r110.getMeasuredState());
    L31:
        r19 = r19 + 1;
        goto L24
    L32:
        int r111 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int r112 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView) == false) goto L35;
        measureChildCollapseMargins(this.mTitleTextView, r17, r15 + r112, r18, r111, r8);
        int r4 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        int r113 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        int r6 = View.combineMeasuredStates(r13, this.mTitleTextView.getMeasuredState());
        int r114 = r4;
    L37:
        if (shouldLayout(this.mSubtitleTextView) == false) goto L40;
        r114 = Math.max(r114, measureChildCollapseMargins(this.mSubtitleTextView, r17, r15 + r112, r18, r113 + r111, r8));
        r113 = r113 + (this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView));
        r6 = View.combineMeasuredStates(r6, this.mSubtitleTextView.getMeasuredState());
    L40:
        int r5 = Math.max(r12, r113);
        int r115 = (r15 + r114) + (getPaddingLeft() + getPaddingRight());
        int r7 = r5 + (getPaddingTop() + getPaddingBottom());
        int r20 = View.resolveSizeAndState(Math.max(r115, getSuggestedMinimumWidth()), r17, (-16777216) & r6);
        int r21 = View.resolveSizeAndState(Math.max(r7, getSuggestedMinimumHeight()), r18, r6 << 16);
        if (shouldCollapse() == true) goto L44;
        r9 = r21;
    L44:
        setMeasuredDimension(r20, r9);
        return;
    L35:
        r113 = 0;
        r6 = r13;
        r114 = 0;
        goto L37
    L16:
        r2 = 0;
        goto L17
    L9:
        r0 = 0;
        r12 = 0;
        r13 = 0;
        goto L11
    L5:
        r11 = 1;
        r10 = 0;
        goto L7
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r4) {
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
    public void onRtlPropertiesChanged(int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        super.onRtlPropertiesChanged(r3);
    L5:
        ensureContentInsets();
        RtlSpacingHelper r2 = this.mContentInsets;
        boolean r0 = true;
        if (r3 == 1) goto L9;
        r0 = false;
    L9:
        r2.setDirection(r0);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
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

    void removeChildrenForExpandedActionView() {
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

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void removeMenuProvider(@NonNull MenuProvider r1) {
        this.mMenuHostHelper.removeMenuProvider(r1);
    }

    public void setBackInvokedCallbackEnabled(boolean r2) {
        if (this.mBackInvokedCallbackEnabled == r2) goto L6;
        this.mBackInvokedCallbackEnabled = r2;
        updateBackInvokedCallbackState();
        return;
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

    public void setCollapseContentDescription(@Nullable CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        ensureCollapseButtonView();
    L5:
        ImageButton r1 = this.mCollapseButtonView;
        if (r1 == null) goto L9;
        r1.setContentDescription(r2);
        return;
    }

    public void setCollapseIcon(@DrawableRes int r2) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), r2));
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

    public void setLogoDescription(@StringRes int r2) {
        setLogoDescription(getContext().getText(r2));
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

    @RestrictTo({RestrictTo.Scope.LIBRARY})
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
        updateBackInvokedCallbackState();
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

    public void setNavigationContentDescription(@Nullable CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        ensureNavButtonView();
    L5:
        ImageButton r0 = this.mNavButtonView;
        if (r0 == null) goto L9;
        r0.setContentDescription(r2);
        TooltipCompat.setTooltipText(this.mNavButtonView, r2);
        return;
    }

    public void setNavigationIcon(@DrawableRes int r2) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), r2));
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

    public void setSubtitleTextColor(@NonNull ColorStateList r1) {
        this.mSubtitleTextColor = r1;
        TextView r0 = this.mSubtitleTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
    }

    public void setTitle(@StringRes int r2) {
        setTitle(getContext().getText(r2));
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

    public void setTitleTextColor(@NonNull ColorStateList r1) {
        this.mTitleTextColor = r1;
        TextView r0 = this.mTitleTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
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

    void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L26;
        OnBackInvokedDispatcher r0 = Api33Impl.findOnBackInvokedDispatcher(this);
        if (hasExpandedActionView() == false) goto L12;
        if (r0 == null) goto L12;
        if (ViewCompat.isAttachedToWindow(this) == false) goto L12;
        if (this.mBackInvokedCallbackEnabled == false) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
    L20:
        if (r1 == true) goto L27;
        OnBackInvokedDispatcher r2 = this.mBackInvokedDispatcher;
        if (r2 == null) goto L28;
        Api33Impl.tryUnregisterOnBackInvokedCallback(r2, this.mBackInvokedCallback);
        r0 = null;
    L24:
        this.mBackInvokedDispatcher = r0;
        return;
    L28:
        return;
    L27:
        return;
    L15:
        if (this.mBackInvokedDispatcher != null) goto L20;
        if (this.mBackInvokedCallback != null) goto L19;
        this.mBackInvokedCallback = Api33Impl.newOnBackInvokedCallback(new e(this));
    L19:
        Api33Impl.tryRegisterOnBackInvokedCallback(r0, this.mBackInvokedCallback);
    L12:
        r1 = false;
        goto L13
    }
}
