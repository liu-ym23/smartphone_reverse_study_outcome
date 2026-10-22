package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseMenuWrapper {
    final Context mContext;
    private SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    private SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(Context r1) {
        this.mContext = r1;
    }

    final MenuItem getMenuItemWrapper(MenuItem r3) {
        if ((r3 instanceof SupportMenuItem) == false) goto L11;
        SupportMenuItem r4 = (SupportMenuItem) r3;
        if (this.mMenuItems != null) goto L7;
        this.mMenuItems = new SimpleArrayMap();
    L7:
        MenuItem r0 = this.mMenuItems.get(r4);
        if (r0 != null) goto L12;
        MenuItemWrapperICS r1 = new MenuItemWrapperICS(this.mContext, r4);
        this.mMenuItems.put(r4, r1);
        return r1;
    L12:
        return r0;
    L11:
        return r3;
    }

    final SubMenu getSubMenuWrapper(SubMenu r3) {
        if ((r3 instanceof SupportSubMenu) == false) goto L11;
        SupportSubMenu r4 = (SupportSubMenu) r3;
        if (this.mSubMenus != null) goto L7;
        this.mSubMenus = new SimpleArrayMap();
    L7:
        SubMenu r0 = this.mSubMenus.get(r4);
        if (r0 != null) goto L12;
        SubMenuWrapperICS r1 = new SubMenuWrapperICS(this.mContext, r4);
        this.mSubMenus.put(r4, r1);
        return r1;
    L12:
        return r0;
    L11:
        return r3;
    }

    final void internalClear() {
        SimpleArrayMap<SupportMenuItem, MenuItem> r0 = this.mMenuItems;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        SimpleArrayMap<SupportSubMenu, SubMenu> r1 = this.mSubMenus;
        if (r1 == null) goto L9;
        r1.clear();
        return;
    }

    final void internalRemoveGroup(int r3) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mMenuItems.size()) goto L12;
        if (this.mMenuItems.keyAt(r0).getGroupId() != r3) goto L11;
        this.mMenuItems.removeAt(r0);
        r0 = r0 - 1;
    L11:
        r0 = r0 + 1;
        goto L7
    }

    final void internalRemoveItem(int r3) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mMenuItems.size()) goto L15;
        if (this.mMenuItems.keyAt(r0).getItemId() == r3) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        this.mMenuItems.removeAt(r0);
        return;
    }
}
