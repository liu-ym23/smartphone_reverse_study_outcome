package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class SortNetworkListActivityBinding implements ViewBinding {
    public final TextView emptyNetworkTipSummary;
    public final TextView emptyNetworkTipTitle;
    private final RelativeLayout rootView;
    public final TextView sortTips;
    public final SettingItemSwitch switchSortMode;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SortNetworkListActivityBinding(RelativeLayout r1, TextView r2, TextView r3, TextView r4, SettingItemSwitch r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.emptyNetworkTipSummary = r2;
        this.emptyNetworkTipTitle = r3;
        this.sortTips = r4;
        this.switchSortMode = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SortNetworkListActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SortNetworkListActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sort_network_list_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SortNetworkListActivityBinding bind(View r9) {
        int r0 = R.id.empty_network_tip_summary;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, R.id.empty_network_tip_summary);
        if (r4 == null) goto L15;
        r0 = R.id.empty_network_tip_title;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r9, R.id.empty_network_tip_title);
        if (r5 == null) goto L15;
        r0 = R.id.sort_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.sort_tips);
        if (r6 == null) goto L15;
        r0 = R.id.switch_sort_mode;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r9, R.id.switch_sort_mode);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new SortNetworkListActivityBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
