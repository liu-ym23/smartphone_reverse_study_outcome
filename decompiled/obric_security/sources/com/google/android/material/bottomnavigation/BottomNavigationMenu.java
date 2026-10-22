package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes2.dex */
public final class BottomNavigationMenu extends MenuBuilder {
    public static final int MAX_ITEM_COUNT = 5;

    public BottomNavigationMenu(Context r1) {
        super(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int r1, int r2, int r3, CharSequence r4) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    protected MenuItem addInternal(int r4, int r5, int r6, CharSequence r7) {
        if ((size() + 1) > 5) goto L10;
        stopDispatchingItemsChanged();
        MenuItem r8 = super.addInternal(r4, r5, r6, r7);
        if ((r8 instanceof MenuItemImpl) == false) goto L7;
        ((MenuItemImpl) r8).setExclusiveCheckable(true);
    L7:
        startDispatchingItemsChanged();
        return r8;
    L10:
        throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }
}
