package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiDisplaySettingsFooterViewBinding implements ViewBinding {
    public final ListContentItemText incallSettings;
    public final ListContentItemText receivedSmsSettings;
    private final LinearLayout rootView;
    public final LinearLayout wifiDisplaySettingsFooterView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiDisplaySettingsFooterViewBinding(LinearLayout r1, ListContentItemText r2, ListContentItemText r3, LinearLayout r4) {
        this.rootView = r1;
        this.incallSettings = r2;
        this.receivedSmsSettings = r3;
        this.wifiDisplaySettingsFooterView = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WifiDisplaySettingsFooterViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiDisplaySettingsFooterViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_display_settings_footer_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiDisplaySettingsFooterViewBinding bind(View r3) {
        int r0 = R.id.incall_settings;
        ListContentItemText r1 = (ListContentItemText) ViewBindings.findChildViewById(r3, R.id.incall_settings);
        if (r1 == null) goto L9;
        r0 = R.id.received_sms_settings;
        ListContentItemText r2 = (ListContentItemText) ViewBindings.findChildViewById(r3, R.id.received_sms_settings);
        if (r2 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r3;
        return new WifiDisplaySettingsFooterViewBinding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
