package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context r1) {
        super(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int r1, int r2, int r3, CharSequence r4) {
        MenuItemImpl r5 = (MenuItemImpl) addInternal(r1, r2, r3, r4);
        NavigationSubMenu r6 = new NavigationSubMenu(getContext(), this, r5);
        r5.setSubMenu(r6);
        return r6;
    }
}
