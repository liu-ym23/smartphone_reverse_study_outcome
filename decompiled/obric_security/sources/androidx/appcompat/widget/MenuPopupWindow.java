package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    static class Api23Impl {
        private Api23Impl() {
        }

        static void setEnterTransition(PopupWindow r0, Transition r1) {
            r0.setEnterTransition(r1);
        }

        static void setExitTransition(PopupWindow r0, Transition r1) {
            r0.setExitTransition(r1);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setTouchModal(PopupWindow r0, boolean r1) {
            r0.setTouchModal(r1);
        }
    }

    public static class MenuDropDownListView extends DropDownListView {
        final int mAdvanceKey;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        static class Api17Impl {
            private Api17Impl() {
            }

            static int getLayoutDirection(Configuration r0) {
                return r0.getLayoutDirection();
            }
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int r1, boolean r2) {
            return super.lookForSelectablePosition(r1, r2);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int r1, int r2, int r3, int r4, int r5) {
            return super.measureHeightOfChildrenCompat(r1, r2, r3, r4, r5);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent r1, int r2) {
            return super.onForwardedEvent(r1, r2);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r1) {
            return super.onTouchEvent(r1);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable r1) {
            super.setSelector(r1);
        }

        public MenuDropDownListView(Context r3, boolean r4) {
            super(r3, r4);
            if (1 != Api17Impl.getLayoutDirection(r3.getResources().getConfiguration())) goto L5;
            this.mAdvanceKey = 21;
            this.mRetreatKey = 22;
            return;
        L5:
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
        }

        public void setHoverListener(MenuItemHoverListener r1) {
            this.mHoverListener = r1;
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int r5, KeyEvent r6) {
            ListMenuItemView r0 = (ListMenuItemView) getSelectedView();
            if (r0 != null) goto L5;
        L12:
            if (r0 == null) goto L22;
            if (r5 != this.mRetreatKey) goto L22;
            setSelection(-1);
            ListAdapter r4 = getAdapter();
            if ((r4 instanceof HeaderViewListAdapter) == false) goto L18;
            MenuAdapter r7 = (MenuAdapter) ((HeaderViewListAdapter) r4).getWrappedAdapter();
        L19:
            r7.getAdapterMenu().close(false);
            return true;
        L18:
            r7 = (MenuAdapter) r4;
        L22:
            return super.onKeyDown(r5, r6);
        L5:
            if (r5 != this.mAdvanceKey) goto L12;
            if (r0.isEnabled() == true) goto L9;
        L11:
            return true;
        L9:
            if (r0.getItemData().hasSubMenu() == false) goto L11;
            performItemClick(r0, getSelectedItemPosition(), getSelectedItemId());
            goto L11
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent r5) {
            if (this.mHoverListener == null) goto L27;
            ListAdapter r0 = getAdapter();
            if ((r0 instanceof HeaderViewListAdapter) == false) goto L7;
            HeaderViewListAdapter r1 = (HeaderViewListAdapter) r0;
            int r2 = r1.getHeadersCount();
            MenuAdapter r3 = (MenuAdapter) r1.getWrappedAdapter();
        L9:
            if (r5.getAction() == 10) goto L17;
            int r4 = pointToPosition((int) r5.getX(), (int) r5.getY());
            if (r4 == (-1)) goto L17;
            int r6 = r4 - r2;
            if (r6 < 0) goto L17;
            if (r6 >= r3.getCount()) goto L17;
            MenuItemImpl r7 = r3.getItem(r6);
        L18:
            MenuItem r8 = this.mHoveredMenuItem;
            if (r8 == r7) goto L27;
            MenuBuilder r9 = r3.getAdapterMenu();
            if (r8 == null) goto L23;
            this.mHoverListener.onItemHoverExit(r9, r8);
        L23:
            this.mHoveredMenuItem = r7;
            if (r7 == null) goto L27;
            this.mHoverListener.onItemHoverEnter(r9, r7);
        L17:
            r7 = null;
            goto L18
        L7:
            r3 = (MenuAdapter) r0;
            r2 = 0;
        L27:
            return super.onHoverEvent(r5);
        }
    }

    static {
    }

    public MenuPopupWindow(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    DropDownListView createDropDownListView(Context r2, boolean r3) {
        MenuDropDownListView r0 = new MenuDropDownListView(r2, r3);
        r0.setHoverListener(this);
        return r0;
    }

    public void setEnterTransition(Object r1) {
        Api23Impl.setEnterTransition(this.mPopup, (Transition) r1);
    }

    public void setExitTransition(Object r1) {
        Api23Impl.setExitTransition(this.mPopup, (Transition) r1);
    }

    public void setHoverListener(MenuItemHoverListener r1) {
        this.mHoverListener = r1;
    }

    public void setTouchModal(boolean r1) {
        Api29Impl.setTouchModal(this.mPopup, r1);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder r1, MenuItem r2) {
        MenuItemHoverListener r0 = this.mHoverListener;
        if (r0 == null) goto L6;
        r0.onItemHoverEnter(r1, r2);
        return;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder r1, MenuItem r2) {
        MenuItemHoverListener r0 = this.mHoverListener;
        if (r0 == null) goto L6;
        r0.onItemHoverExit(r1, r2);
        return;
    }
}
