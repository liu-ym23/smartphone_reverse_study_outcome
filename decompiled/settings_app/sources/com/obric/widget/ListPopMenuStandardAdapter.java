package com.obric.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import obric.widget.support.AbsMenuItem;
import obric.widget.support.IMenuItem;

/* JADX INFO: loaded from: classes5.dex */
public class ListPopMenuStandardAdapter extends ArrayAdapter<IMenuItem> {
    public static final int STYLE_REMOVABLE = 2;
    public static final int STYLE_SELECTED = 1;
    private View.OnClickListener mCloseIconClickListener;
    private boolean mCloseIconVisible;
    private int mItemStyle;

    public ListPopMenuStandardAdapter(Context r2, List<IMenuItem> r3) {
        super(r2, 0, r3);
        this.mItemStyle = 1;
        this.mCloseIconVisible = true;
    }

    public ListPopMenuStandardAdapter(Context r1, int r2, List<IMenuItem> r3) {
        super(r1, r2, r3);
        this.mItemStyle = 1;
        this.mCloseIconVisible = true;
    }

    public ListPopMenuStandardAdapter(Context r2, IMenuItem[] r3) {
        super(r2, 0, r3);
        this.mItemStyle = 1;
        this.mCloseIconVisible = true;
    }

    public ListPopMenuStandardAdapter(Context r1, int r2, IMenuItem[] r3) {
        super(r1, r2, r3);
        this.mItemStyle = 1;
        this.mCloseIconVisible = true;
    }

    public void setMenuItemStyle(int r1) {
        this.mItemStyle = r1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int r3, View r4, ViewGroup r5) {
        if (this.mItemStyle != 2) goto L7;
        return getRemovableItemView(r3, r4, r5);
    L7:
        return getSelectedItemView(r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View getSelectedItemView(int r2, View r3, ViewGroup r4) {
        if (r3 != null) goto L4;
        r3 = new PopupMenuStandardListItem(getContext());
        PopupMenuStandardListItem r5 = r3;
    L5:
        r3.setEnabled(isEnabled(r2));
        IMenuItem r1 = getItem(r2);
        if (r1 != null) goto L8;
    L16:
        return r3;
    L8:
        if (r1.hasMenuIcon() == false) goto L10;
        r5.getIconView().setVisibility(0);
        r1.setMenuIcon(r5.getIconView());
    L11:
        r5.setChecked(r1.isSelected());
        r5.setMenuTitle(r1.getTitle());
        if ((r1 instanceof AbsMenuItem) == false) goto L16;
        String r6 = ((AbsMenuItem) r1).getSubtitle();
        if (r6 == null) goto L16;
        r5.setMenuSubtitle(r6);
        goto L16
    L10:
        r5.setMenuIcon(null);
        goto L11
    L4:
        r5 = (PopupMenuStandardListItem) r3;
        goto L5
    }

    private View getRemovableItemView(int r4, View r5, ViewGroup r6) {
        if (r5 != null) goto L4;
        PopupMenuRemovableListItem r7 = new PopupMenuRemovableListItem(getContext());
        View r8 = r7;
    L6:
        if (this.mCloseIconVisible == false) goto L8;
        r7.setCloseIconVisibility(0);
    L9:
        IMenuItem r9 = getItem(r4);
        if (r9 != null) goto L12;
    L19:
        return r8;
    L12:
        if (r9.hasMenuIcon() == false) goto L14;
        r7.getIconView().setVisibility(0);
        r9.setMenuIcon(r7.getIconView());
    L15:
        View r0 = r7.getCloseIconView();
        if (r0 == null) goto L18;
        r0.setTag(r9);
    L18:
        r7.setMenuTitle(r9.getTitle());
        r7.setOnCloseIconClickListener(this.mCloseIconClickListener);
        goto L19
    L14:
        r7.setMenuIcon(null);
        goto L15
    L8:
        r7.setCloseIconVisibility(8);
        goto L9
    L4:
        r8 = r5;
        r7 = (PopupMenuRemovableListItem) r5;
        goto L6
    }

    public void setCloseIconClickListener(View.OnClickListener r1) {
        this.mCloseIconClickListener = r1;
    }

    public void setCloseIconVisible(boolean r1) {
        this.mCloseIconVisible = r1;
    }
}
