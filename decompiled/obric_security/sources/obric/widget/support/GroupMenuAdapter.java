package obric.widget.support;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class GroupMenuAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private static final String DIVIDER_MENU = "Divider";
    private static final int DIVIDER_TYPE = 1;
    private static final int NORMAL_TYPE = 0;
    private MenuItem mDividerMenuItem;
    private MenuBuilder mMenu;
    private List<MenuItem> mMenuItemList;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int position) {
        return getItem(position);
    }

    public GroupMenuAdapter(MenuBuilder menu) {
        this.mMenu = menu;
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
    public MenuItem getItem(int position) {
        return this.mMenuItemList.get(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        if (getItem(position) != this.mDividerMenuItem) goto L6;
        return 1;
    L6:
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) != 1) goto L8;
        if (convertView != null) goto L6;
        convertView = new View(parent.getContext());
        convertView.setBackgroundResource(R.drawable.popup_menu_item_divider);
    L6:
        convertView.setEnabled(false);
        return convertView;
    L8:
        if (convertView != null) goto L10;
        PopupMenuLongPressedListItem r4 = new PopupMenuLongPressedListItem(parent.getContext());
    L11:
        r4.initialize((MenuItemImpl) getItem(position), position);
        return r4;
    L10:
        r4 = (PopupMenuLongPressedListItem) convertView;
        goto L11
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.mMenu.performItemAction(getItem(position), 0);
    }
}
