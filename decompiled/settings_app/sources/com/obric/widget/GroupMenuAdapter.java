package com.obric.widget;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.android.settings.R;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GroupMenuAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private static final String DIVIDER_MENU = "Divider";
    private static final int DIVIDER_TYPE = 1;
    private static final int NORMAL_TYPE = 0;
    private MenuItem mDividerMenuItem;
    private MenuBuilder mMenu;
    private List<MenuItem> mMenuItemList;

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public GroupMenuAdapter(MenuBuilder r2) {
        this.mMenu = r2;
        this.mMenuItemList = new LinkedList(this.mMenu.getVisibleItems());
        this.mDividerMenuItem = this.mMenu.add(DIVIDER_MENU);
        addDividerMenuItem();
    }

    private void addDividerMenuItem() {
        sortByGroup();
        int r0 = this.mMenuItemList.size();
        int r1 = r0 - 2;
        int r2 = r0 - 1;
    L3:
        if (r1 < 0) goto L8;
        if (this.mMenuItemList.get(r1).getGroupId() == this.mMenuItemList.get(r2).getGroupId()) goto L7;
        this.mMenuItemList.add(r2, this.mDividerMenuItem);
    L7:
        r2 = r2 - 1;
        r1 = r1 - 1;
        goto L3
    }

    private void sortByGroup() {
        Collections.sort(this.mMenuItemList, new AnonymousClass1(this));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mMenuItemList.size();
    }

    @Override // android.widget.Adapter
    public MenuItem getItem(int r1) {
        return this.mMenuItemList.get(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        if (getItem(r1) != this.mDividerMenuItem) goto L6;
        return 1;
    L6:
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r3, View r4, ViewGroup r5) {
        if (getItemViewType(r3) != 1) goto L8;
        if (r4 != null) goto L6;
        r4 = new View(r5.getContext());
        r4.setBackgroundResource(R.drawable.popup_menu_item_divider);
    L6:
        r4.setEnabled(false);
        return r4;
    L8:
        if (r4 != null) goto L10;
        PopupMenuLongPressedListItem r6 = new PopupMenuLongPressedListItem(r5.getContext());
    L11:
        r6.initialize((MenuItemImpl) getItem(r3), r3);
        return r6;
    L10:
        r6 = (PopupMenuLongPressedListItem) r4;
        goto L11
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        this.mMenu.performItemAction(getItem(r3), 0);
    }
}
