package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

/* JADX INFO: loaded from: classes.dex */
public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(PopupMenu r1);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r1);
    }

    public PopupMenu(@NonNull Context r2, @NonNull View r3) {
        this(r2, r3, 0);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener != null) goto L6;
        final View r1 = this.mAnchor;
        this.mDragListener = new AnonymousClass3(this, r1);
    L6:
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    @NonNull
    public Menu getMenu() {
        return this.mMenu;
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ListView getMenuListView() {
        if (this.mPopup.isShowing() == true) goto L7;
        return null;
    L7:
        return this.mPopup.getListView();
    }

    public void inflate(@MenuRes int r2) {
        getMenuInflater().inflate(r2, this.mMenu);
    }

    public void setGravity(int r1) {
        this.mPopup.setGravity(r1);
    }

    public void setOnDismissListener(@Nullable OnDismissListener r1) {
        this.mOnDismissListener = r1;
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener r1) {
        this.mMenuItemClickListener = r1;
    }

    public void show() {
        this.mPopup.show();
    }

    public PopupMenu(@NonNull Context r7, @NonNull View r8, int r9) {
        this(r7, r8, r9, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context r9, @NonNull View r10, int r11, @AttrRes int r12, @StyleRes int r13) {
        this.mContext = r9;
        this.mAnchor = r10;
        MenuBuilder r2 = new MenuBuilder(r9);
        this.mMenu = r2;
        r2.setCallback(new AnonymousClass1(this));
        MenuPopupHelper r7 = new MenuPopupHelper(r9, r2, r10, false, r12, r13);
        this.mPopup = r7;
        r7.setGravity(r11);
        r7.setOnDismissListener(new AnonymousClass2(this));
    }
}
