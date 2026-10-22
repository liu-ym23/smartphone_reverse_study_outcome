package com.android.settings;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsAdapter extends BaseAdapter {
    public int getBackgroundRes(int r1, int r2) {
        if (r1 != 1) goto L6;
        return R.drawable.selector_setting_sub_item_bg_single;
    L6:
        if (r2 != 0) goto L10;
        return R.drawable.selector_setting_sub_item_bg_top;
    L10:
        if (r2 != (r1 - 1)) goto L13;
        return R.drawable.selector_setting_sub_item_bg_bottom;
    L13:
        return R.drawable.selector_setting_sub_item_bg_middle;
    }

    public int getBackgroundStyle(int r1, int r2) {
        if (r1 != 1) goto L5;
        return 1;
    L5:
        if (r2 != 0) goto L9;
        return 2;
    L9:
        if (r2 != (r1 - 1)) goto L12;
        return 4;
    L12:
        return 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r1, View r2, ViewGroup r3) {
        return null;
    }

    public int getWifiItemBgRes(int r1, int r2) {
        if (r1 != 1) goto L6;
        return R.drawable.item_bg_single;
    L6:
        if (r2 != 0) goto L10;
        return R.drawable.item_bg_top;
    L10:
        if (r2 != (r1 - 1)) goto L13;
        return R.drawable.item_bg_bottom;
    L13:
        return R.drawable.item_bg_mid;
    }

    public SettingsAdapter() {
    }

    public int getBackgroundRes(int r2) {
        return getBackgroundRes(getCount(), r2);
    }

    public int getBackgroundStyle(int r2) {
        return getBackgroundStyle(getCount(), r2);
    }

    public int getWifiItemBgRes(int r2) {
        return getWifiItemBgRes(getCount(), r2);
    }
}
