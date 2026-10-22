package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemButton;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchHistoryFooterBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SettingItemButton settingItemBtnClearHistory;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SearchHistoryFooterBinding(LinearLayout r1, SettingItemButton r2) {
        this.rootView = r1;
        this.settingItemBtnClearHistory = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SearchHistoryFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SearchHistoryFooterBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.search_history_footer, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SearchHistoryFooterBinding bind(View r2) {
        SettingItemButton r1 = (SettingItemButton) ViewBindings.findChildViewById(r2, R.id.setting_item_btn_clear_history);
        if (r1 == null) goto L7;
        return new SearchHistoryFooterBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.setting_item_btn_clear_history)));
    }
}
