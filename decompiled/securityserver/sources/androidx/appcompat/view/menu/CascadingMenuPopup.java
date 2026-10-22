package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = 0;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener;
    private final int mMenuMaxWidth;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List<MenuBuilder> mPendingMenus;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private int mRawDropDownGravity;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    final List<CascadingMenuInfo> mShowingMenus;
    View mShownAnchorView;
    final Handler mSubMenuHoverHandler;
    ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;

    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(@NonNull MenuPopupWindow r1, @NonNull MenuBuilder r2, int r3) {
            this.window = r1;
            this.menu = r2;
            this.position = r3;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    static {
        ITEM_LAYOUT = R.layout.abc_cascading_menu_item_layout;
    }

    public CascadingMenuPopup(@NonNull Context r2, @NonNull View r3, @AttrRes int r4, @StyleRes int r5, boolean r6) {
        this.mPendingMenus = new ArrayList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mMenuItemHoverListener = new AnonymousClass3(this);
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = r2;
        this.mAnchorView = r3;
        this.mPopupStyleAttr = r4;
        this.mPopupStyleRes = r5;
        this.mOverflowOnly = r6;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources r7 = r2.getResources();
        this.mMenuMaxWidth = Math.max(r7.getDisplayMetrics().widthPixels / 2, r7.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow r0 = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        r0.setHoverListener(this.mMenuItemHoverListener);
        r0.setOnItemClickListener(this);
        r0.setOnDismissListener(this);
        r0.setAnchorView(this.mAnchorView);
        r0.setDropDownGravity(this.mDropDownGravity);
        r0.setModal(true);
        r0.setInputMethodMode(2);
        return r0;
    }

    private int findIndexOfAddedMenu(@NonNull MenuBuilder r4) {
        int r0 = this.mShowingMenus.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4 == this.mShowingMenus.get(r1).menu) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(@NonNull MenuBuilder r4, @NonNull MenuBuilder r5) {
        int r3 = r4.size();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L10;
        MenuItem r1 = r4.getItem(r0);
        if (r1.hasSubMenu() == false) goto L9;
        if (r5 != r1.getSubMenu()) goto L9;
        return r1;
    L9:
        r0 = r0 + 1;
        goto L3
    L10:
        return null;
    }

    @Nullable
    private View findParentViewForSubmenu(@NonNull CascadingMenuInfo r7, @NonNull MenuBuilder r8) {
        MenuItem r6 = findMenuItemForSubmenu(r7.menu, r8);
        if (r6 != null) goto L5;
        return null;
    L5:
        ListView r9 = r7.getListView();
        ListAdapter r0 = r9.getAdapter();
        int r2 = 0;
        if ((r0 instanceof HeaderViewListAdapter) == false) goto L8;
        HeaderViewListAdapter r1 = (HeaderViewListAdapter) r0;
        int r3 = r1.getHeadersCount();
        MenuAdapter r4 = (MenuAdapter) r1.getWrappedAdapter();
    L9:
        int r5 = r4.getCount();
    L11:
        if (r2 >= r5) goto L16;
        if (r6 == r4.getItem(r2)) goto L17;
        r2 = r2 + 1;
    L17:
        if (r2 != (-1)) goto L19;
        return null;
    L19:
        int r10 = (r2 + r3) - r9.getFirstVisiblePosition();
        if (r10 >= 0) goto L22;
    L26:
        return null;
    L22:
        if (r10 >= r9.getChildCount()) goto L26;
        return r9.getChildAt(r10);
    L16:
        r2 = -1;
        goto L17
    L8:
        r4 = (MenuAdapter) r0;
        r3 = 0;
        goto L9
    }

    private int getInitialMenuPosition() {
        if (ViewCompat.getLayoutDirection(this.mAnchorView) != 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    private int getNextMenuPosition(int r6) {
        List<CascadingMenuInfo> r0 = this.mShowingMenus;
        ListView r1 = r0.get(r0.size() - 1).getListView();
        int[] r2 = new int[2];
        r1.getLocationOnScreen(r2);
        Rect r3 = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(r3);
        if (this.mLastPosition != 1) goto L9;
        int r5 = r2[0];
        if (((r1.getWidth() + r5) + r6) <= r3.right) goto L7;
        return 0;
    L7:
        return 1;
    L9:
        if ((r2[0] - r6) >= 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    private void showMenu(@NonNull MenuBuilder r12) {
        LayoutInflater r0 = LayoutInflater.from(this.mContext);
        MenuAdapter r1 = new MenuAdapter(r12, r0, this.mOverflowOnly, ITEM_LAYOUT);
        if (isShowing() == true) goto L8;
        if (this.mForceShowIcon == false) goto L8;
        r1.setForceShowIcon(true);
    L10:
        int r2 = MenuPopup.measureIndividualMenuWidth(r1, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow r4 = createPopupWindow();
        r4.setAdapter(r1);
        r4.setContentWidth(r2);
        r4.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() <= 0) goto L13;
        List<CascadingMenuInfo> r3 = this.mShowingMenus;
        CascadingMenuInfo r5 = r3.get(r3.size() - 1);
        View r6 = findParentViewForSubmenu(r5, r12);
    L15:
        if (r6 == null) goto L30;
        r4.setTouchModal(false);
        r4.setEnterTransition(null);
        int r8 = getNextMenuPosition(r2);
        if (r8 != 1) goto L19;
        boolean r9 = true;
    L20:
        this.mLastPosition = r8;
        r4.setAnchorView(r6);
        if ((this.mDropDownGravity & 5) != 5) goto L25;
        if (r9 == true) goto L28;
        r2 = 0 - r6.getWidth();
    L28:
        r4.setHorizontalOffset(r2);
        r4.setOverlapAnchor(true);
        r4.setVerticalOffset(0);
    L36:
        this.mShowingMenus.add(new CascadingMenuInfo(r4, r12, this.mLastPosition));
        r4.show();
        ListView r7 = r4.getListView();
        r7.setOnKeyListener(this);
        if (r5 == null) goto L39;
        return;
    L39:
        if (this.mShowTitle == true) goto L41;
        return;
    L41:
        if (r12.getHeaderTitle() == null) goto L46;
        FrameLayout r11 = (FrameLayout) r0.inflate(R.layout.abc_popup_menu_header_item_layout, r7, false);
        TextView r10 = (TextView) r11.findViewById(android.R.id.title);
        r11.setEnabled(false);
        r10.setText(r12.getHeaderTitle());
        r7.addHeaderView(r11, null, false);
        r4.show();
        return;
    L46:
        return;
    L25:
        if (r9 == false) goto L27;
        r2 = r6.getWidth();
        goto L28
    L27:
        r2 = 0 - r2;
        goto L28
    L19:
        r9 = false;
        goto L20
    L30:
        if (this.mHasXOffset == false) goto L33;
        r4.setHorizontalOffset(this.mXOffset);
    L33:
        if (this.mHasYOffset == false) goto L35;
        r4.setVerticalOffset(this.mYOffset);
    L35:
        r4.setEpicenterBounds(getEpicenterBounds());
        goto L36
    L13:
        r5 = null;
        r6 = null;
    L8:
        if (isShowing() == false) goto L10;
        r1.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r12));
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r2) {
        r2.addMenuPresenter(this, this.mContext);
        if (isShowing() == false) goto L5;
        showMenu(r2);
        return;
    L5:
        this.mPendingMenus.add(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int r0 = this.mShowingMenus.size();
        if (r0 <= 0) goto L10;
        CascadingMenuInfo[] r3 = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[r0]);
        int r1 = r0 - 1;
    L5:
        if (r1 < 0) goto L14;
        CascadingMenuInfo r2 = r3[r1];
        if (r2.window.isShowing() == false) goto L9;
        r2.window.dismiss();
    L9:
        r1 = r1 - 1;
        goto L5
    L14:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.mShowingMenus.isEmpty() == false) goto L5;
        return null;
    L5:
        List<CascadingMenuInfo> r1 = this.mShowingMenus;
        return r1.get(r1.size() - 1).getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.mShowingMenus.size() > 0) goto L5;
        return false;
    L5:
        if (this.mShowingMenus.get(0).window.isShowing() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r6, boolean r7) {
        int r0 = findIndexOfAddedMenu(r6);
        if (r0 >= 0) goto L5;
        return;
    L5:
        int r1 = r0 + 1;
        if (r1 >= this.mShowingMenus.size()) goto L8;
        this.mShowingMenus.get(r1).menu.close(false);
    L8:
        CascadingMenuInfo r2 = this.mShowingMenus.remove(r0);
        r2.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately == false) goto L11;
        r2.window.setExitTransition(null);
        r2.window.setAnimationStyle(0);
    L11:
        r2.window.dismiss();
        int r3 = this.mShowingMenus.size();
        if (r3 <= 0) goto L14;
        this.mLastPosition = this.mShowingMenus.get(r3 - 1).position;
    L15:
        if (r3 != 0) goto L26;
        dismiss();
        MenuPresenter.Callback r8 = this.mPresenterCallback;
        if (r8 == null) goto L19;
        r8.onCloseMenu(r6, true);
    L19:
        ViewTreeObserver r9 = this.mTreeObserver;
        if (r9 != null) goto L22;
    L25:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
        return;
    L22:
        if (r9.isAlive() == false) goto L24;
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
    L24:
        this.mTreeObserver = null;
        goto L25
    L26:
        if (r7 == false) goto L30;
        this.mShowingMenus.get(0).menu.close(false);
        return;
    L30:
        return;
    L14:
        this.mLastPosition = getInitialMenuPosition();
        goto L15
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int r0 = this.mShowingMenus.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        CascadingMenuInfo r3 = this.mShowingMenus.get(r2);
        if (r3.window.isShowing() == false) goto L9;
        r2 = r2 + 1;
    L9:
        if (r3 == null) goto L14;
        r3.menu.close(false);
        return;
    L14:
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r1, int r2, KeyEvent r3) {
        if (r3.getAction() == 1) goto L5;
        return false;
    L5:
        if (r2 != 82) goto L10;
        dismiss();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r1) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r5) {
        Iterator<CascadingMenuInfo> r0 = this.mShowingMenus.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        CascadingMenuInfo r1 = r0.next();
        if (r5 != r1.menu) goto L4;
        r1.getListView().requestFocus();
        return true;
    L10:
        if (r5.hasVisibleItems() == false) goto L15;
        addMenu(r5);
        MenuPresenter.Callback r4 = this.mPresenterCallback;
        if (r4 == null) goto L14;
        r4.onOpenSubMenu(r5);
    L14:
        return true;
    L15:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(@NonNull View r2) {
        if (this.mAnchorView == r2) goto L6;
        this.mAnchorView = r2;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(r2));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r1) {
        this.mPresenterCallback = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r1) {
        this.mForceShowIcon = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r2) {
        if (this.mRawDropDownGravity == r2) goto L6;
        this.mRawDropDownGravity = r2;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(r2, ViewCompat.getLayoutDirection(this.mAnchorView));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r2) {
        this.mHasXOffset = true;
        this.mXOffset = r2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener r1) {
        this.mOnDismissListener = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean r1) {
        this.mShowTitle = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int r2) {
        this.mHasYOffset = true;
        this.mYOffset = r2;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        Iterator<MenuBuilder> r0 = this.mPendingMenus.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        showMenu(r0.next());
        goto L7
    L9:
        this.mPendingMenus.clear();
        View r1 = this.mAnchorView;
        this.mShownAnchorView = r1;
        if (r1 != null) goto L12;
        return;
    L12:
        if (this.mTreeObserver != null) goto L14;
        boolean r2 = true;
    L15:
        ViewTreeObserver r3 = r1.getViewTreeObserver();
        this.mTreeObserver = r3;
        if (r2 == false) goto L18;
        r3.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L18:
        this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        return;
    L14:
        r2 = false;
        goto L15
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r1) {
        Iterator<CascadingMenuInfo> r0 = this.mShowingMenus.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MenuPopup.toMenuAdapter(r0.next().getListView().getAdapter()).notifyDataSetChanged();
        goto L4
    }
}
