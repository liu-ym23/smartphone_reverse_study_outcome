package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    private final SupportSubMenu mSubMenu;

    SubMenuWrapperICS(Context r1, SupportSubMenu r2) {
        super(r1, r2);
        this.mSubMenu = r2;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.mSubMenu.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return getMenuItemWrapper(this.mSubMenu.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r2) {
        this.mSubMenu.setHeaderIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r2) {
        this.mSubMenu.setHeaderIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r2) {
        this.mSubMenu.setHeaderTitle(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r2) {
        this.mSubMenu.setHeaderTitle(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r2) {
        this.mSubMenu.setHeaderView(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r2) {
        this.mSubMenu.setIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r2) {
        this.mSubMenu.setIcon(r2);
        return this;
    }
}
