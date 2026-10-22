package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class TestingSettingsActivityBinding implements ViewBinding {
    public final ListContentItemText itemAppManager;
    public final ListContentItemText itemBatteryInfo;
    public final ListContentItemText itemRadioInfo;
    public final ListContentItemText itemUsageStats;
    public final ListContentItemText itemWifiInfo;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TestingSettingsActivityBinding(RelativeLayout r1, ListContentItemText r2, ListContentItemText r3, ListContentItemText r4, ListContentItemText r5, ListContentItemText r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.itemAppManager = r2;
        this.itemBatteryInfo = r3;
        this.itemRadioInfo = r4;
        this.itemUsageStats = r5;
        this.itemWifiInfo = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TestingSettingsActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TestingSettingsActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.testing_settings_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TestingSettingsActivityBinding bind(View r10) {
        int r0 = R.id.item_app_manager;
        ListContentItemText r4 = (ListContentItemText) ViewBindings.findChildViewById(r10, R.id.item_app_manager);
        if (r4 == null) goto L17;
        r0 = R.id.item_battery_info;
        ListContentItemText r5 = (ListContentItemText) ViewBindings.findChildViewById(r10, R.id.item_battery_info);
        if (r5 == null) goto L17;
        r0 = R.id.item_radio_info;
        ListContentItemText r6 = (ListContentItemText) ViewBindings.findChildViewById(r10, R.id.item_radio_info);
        if (r6 == null) goto L17;
        r0 = R.id.item_usage_stats;
        ListContentItemText r7 = (ListContentItemText) ViewBindings.findChildViewById(r10, R.id.item_usage_stats);
        if (r7 == null) goto L17;
        r0 = R.id.item_wifi_info;
        ListContentItemText r8 = (ListContentItemText) ViewBindings.findChildViewById(r10, R.id.item_wifi_info);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new TestingSettingsActivityBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
