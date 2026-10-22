package com.android.settings.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import obric.tablet.navigationlist.HeaderListAdapter;
import obric.tablet.navigationlist.HeaderViewHolder;
import obric.tablet.navigationlist.ItemViewHolder;
import obric.tablet.navigationlist.ViewHolder;

/* JADX INFO: loaded from: classes.dex */
public class SettingLeftMenuAdapter extends HeaderListAdapter {
    public SettingLeftMenuAdapter(Context r1, ArrayList<HeaderViewHolder> r2, HeaderListAdapter.OnItemClickListener r3) {
        super(r1, r2, r3);
    }

    @Override // obric.tablet.navigationlist.HeaderListAdapter, android.widget.Adapter
    public View getView(int r3, View r4, ViewGroup r5) {
        View r6 = super.getView(r3, r4, r5);
        ViewHolder r7 = (ViewHolder) r6.getTag();
        ItemViewHolder r8 = getSelectedItem();
        if (r8 != null) goto L5;
    L11:
        return r6;
    L5:
        if ((r7 instanceof ItemViewHolder) == false) goto L11;
        if (r8.getId() != r7.getId()) goto L11;
        if (r8.isSelected() == false) goto L11;
        setSelectedItem((ItemViewHolder) r7);
        goto L11
    }
}
