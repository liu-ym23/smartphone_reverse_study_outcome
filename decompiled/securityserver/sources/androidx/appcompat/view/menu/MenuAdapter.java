package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuAdapter extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder r2, LayoutInflater r3, boolean r4, int r5) {
        this.mExpandedIndex = -1;
        this.mOverflowOnly = r4;
        this.mInflater = r3;
        this.mAdapterMenu = r2;
        this.mItemLayoutRes = r5;
        findExpandedIndex();
    }

    public void findExpandedIndex() {
        MenuItemImpl r0 = this.mAdapterMenu.getExpandedItem();
        if (r0 == null) goto L11;
        ArrayList<MenuItemImpl> r1 = this.mAdapterMenu.getNonActionItems();
        int r2 = r1.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (r1.get(r3) == r0) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        this.mExpandedIndex = r3;
        return;
    L11:
        this.mExpandedIndex = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r0 = this.mAdapterMenu.getNonActionItems();
    L7:
        if (this.mExpandedIndex >= 0) goto L11;
        return r0.size();
    L11:
        return r0.size() - 1;
    L5:
        r0 = this.mAdapterMenu.getVisibleItems();
        goto L7
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.Adapter
    public View getView(int r6, View r7, ViewGroup r8) {
        if (r7 != null) goto L5;
        r7 = this.mInflater.inflate(this.mItemLayoutRes, r8, false);
    L5:
        int r9 = getItem(r6).getGroupId();
        int r1 = r6 - 1;
        if (r1 < 0) goto L8;
        int r2 = getItem(r1).getGroupId();
    L9:
        ListMenuItemView r3 = (ListMenuItemView) r7;
        if (this.mAdapterMenu.isGroupDividerEnabled() == false) goto L13;
        if (r9 == r2) goto L13;
        boolean r10 = true;
    L14:
        r3.setGroupDividerEnabled(r10);
        MenuView.ItemView r11 = (MenuView.ItemView) r7;
        if (this.mForceShowIcon == false) goto L17;
        r3.setForceShowIcon(true);
    L17:
        r11.initialize(getItem(r6), 0);
        return r7;
    L13:
        r10 = false;
        goto L14
    L8:
        r2 = r9;
        goto L9
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean r1) {
        this.mForceShowIcon = r1;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int r2) {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r0 = this.mAdapterMenu.getNonActionItems();
    L6:
        int r1 = this.mExpandedIndex;
        if (r1 < 0) goto L11;
        if (r2 < r1) goto L11;
        r2 = r2 + 1;
    L11:
        return r0.get(r2);
    L5:
        r0 = this.mAdapterMenu.getVisibleItems();
        goto L6
    }
}
