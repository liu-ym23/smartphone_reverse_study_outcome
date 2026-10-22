package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupHelper implements MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static void getRealSize(Display r0, Point r1) {
            r0.getRealSize(r1);
        }
    }

    public MenuPopupHelper(@NonNull Context r8, @NonNull MenuBuilder r9) {
        this(r8, r9, null, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context r8, @NonNull MenuBuilder r9, @NonNull View r10) {
        this(r8, r9, r10, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context r8, @NonNull MenuBuilder r9, @NonNull View r10, boolean r11, @AttrRes int r12) {
        this(r8, r9, r10, r11, r12, 0);
    }

    public MenuPopupHelper(@NonNull Context r2, @NonNull MenuBuilder r3, @NonNull View r4, boolean r5, @AttrRes int r6, @StyleRes int r7) {
        this.mDropDownGravity = GravityCompat.START;
        this.mInternalOnDismissListener = new AnonymousClass1(this);
        this.mContext = r2;
        this.mMenu = r3;
        this.mAnchorView = r4;
        this.mOverflowOnly = r5;
        this.mPopupStyleAttr = r6;
        this.mPopupStyleRes = r7;
    }

    @NonNull
    private MenuPopup createPopup() {
        Display r0 = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point r1 = new Point();
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.getRealSize(r0, r1);
    L7:
        if (Math.min(r1.x, r1.y) < this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        MenuPopup r3 = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
    L13:
        r3.addMenu(this.mMenu);
        r3.setOnDismissListener(this.mInternalOnDismissListener);
        r3.setAnchorView(this.mAnchorView);
        r3.setCallback(this.mPresenterCallback);
        r3.setForceShowIcon(this.mForceShowIcon);
        r3.setGravity(this.mDropDownGravity);
        return r3;
    L12:
        r3 = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        goto L13
    L9:
        r2 = false;
        goto L10
    L5:
        r0.getSize(r1);
        goto L7
    }

    private void showPopup(int r3, int r4, boolean r5, boolean r6) {
        MenuPopup r0 = getPopup();
        r0.setShowTitle(r6);
        if (r5 == true) goto L5;
    L8:
        r0.show();
        return;
    L5:
        if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L7;
        r3 = r3 - this.mAnchorView.getWidth();
    L7:
        r0.setHorizontalOffset(r3);
        r0.setVerticalOffset(r4);
        int r2 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
        r0.setEpicenterBounds(new Rect(r3 - r2, r4 - r2, r3 + r2, r4 + r2));
        goto L8
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing() == false) goto L6;
        this.mPopup.dismiss();
        return;
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MenuPopup getPopup() {
        if (this.mPopup != null) goto L6;
        this.mPopup = createPopup();
    L6:
        return this.mPopup;
    }

    public boolean isShowing() {
        MenuPopup r0 = this.mPopup;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    protected void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener r1 = this.mOnDismissListener;
        if (r1 == null) goto L6;
        r1.onDismiss();
        return;
    }

    public void setAnchorView(@NonNull View r1) {
        this.mAnchorView = r1;
    }

    public void setForceShowIcon(boolean r1) {
        this.mForceShowIcon = r1;
        MenuPopup r0 = this.mPopup;
        if (r0 == null) goto L6;
        r0.setForceShowIcon(r1);
        return;
    }

    public void setGravity(int r1) {
        this.mDropDownGravity = r1;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener r1) {
        this.mOnDismissListener = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(@Nullable MenuPresenter.Callback r1) {
        this.mPresenterCallback = r1;
        MenuPopup r0 = this.mPopup;
        if (r0 == null) goto L6;
        r0.setCallback(r1);
        return;
    }

    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void show(int r1, int r2) {
        if (tryShow(r1, r2) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean tryShow() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L8;
        return false;
    L8:
        showPopup(0, 0, false, false);
        return true;
    }

    public boolean tryShow(int r3, int r4) {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L9;
        return false;
    L9:
        showPopup(r3, r4, true, true);
        return true;
    }
}
