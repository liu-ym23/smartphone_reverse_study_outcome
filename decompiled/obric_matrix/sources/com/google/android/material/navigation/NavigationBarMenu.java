package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;

    @NonNull
    private final Class<?> viewClass;

    public NavigationBarMenu(@NonNull Context r1, @NonNull Class<?> r2, int r3) {
        super(r1);
        this.viewClass = r2;
        this.maxItemCount = r3;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    protected MenuItem addInternal(int r4, int r5, int r6, @NonNull CharSequence r7) {
        if ((size() + 1) > this.maxItemCount) goto L9;
        stopDispatchingItemsChanged();
        MenuItem r8 = super.addInternal(r4, r5, r6, r7);
        if ((r8 instanceof MenuItemImpl) == false) goto L7;
        ((MenuItemImpl) r8).setExclusiveCheckable(true);
    L7:
        startDispatchingItemsChanged();
        return r8;
    L9:
        String r9 = this.viewClass.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + r9 + " is " + this.maxItemCount + ". Limit can be checked with " + r9 + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int r1, int r2, int r3, @NonNull CharSequence r4) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
