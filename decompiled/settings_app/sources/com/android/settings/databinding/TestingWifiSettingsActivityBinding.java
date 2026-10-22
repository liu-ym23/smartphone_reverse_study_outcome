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
public final class TestingWifiSettingsActivityBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;
    public final ListContentItemText wifiApiTest;
    public final ListContentItemText wifiConfigInfo;
    public final ListContentItemText wifiStatusTest;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TestingWifiSettingsActivityBinding(RelativeLayout r1, OFloatingTitleBar r2, ListContentItemText r3, ListContentItemText r4, ListContentItemText r5) {
        this.rootView = r1;
        this.viewTitle = r2;
        this.wifiApiTest = r3;
        this.wifiConfigInfo = r4;
        this.wifiStatusTest = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TestingWifiSettingsActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TestingWifiSettingsActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.testing_wifi_settings_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TestingWifiSettingsActivityBinding bind(View r8) {
        int r0 = R.id.view_title;
        OFloatingTitleBar r4 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r4 == null) goto L13;
        r0 = R.id.wifi_api_test;
        ListContentItemText r5 = (ListContentItemText) ViewBindings.findChildViewById(r8, R.id.wifi_api_test);
        if (r5 == null) goto L13;
        r0 = R.id.wifi_config_info;
        ListContentItemText r6 = (ListContentItemText) ViewBindings.findChildViewById(r8, R.id.wifi_config_info);
        if (r6 == null) goto L13;
        r0 = R.id.wifi_status_test;
        ListContentItemText r7 = (ListContentItemText) ViewBindings.findChildViewById(r8, R.id.wifi_status_test);
        if (r7 == null) goto L13;
        return new TestingWifiSettingsActivityBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
