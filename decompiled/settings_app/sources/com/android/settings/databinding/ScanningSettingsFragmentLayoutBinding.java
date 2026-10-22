package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ScanningSettingsFragmentLayoutBinding implements ViewBinding {
    public final LinearLayout bluetoothScanSwitchContainer;
    public final TextView bluetoothScanTv;
    private final RelativeLayout rootView;
    public final LinearLayout wifiScanSwitchContainer;
    public final TextView wifiScanTv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScanningSettingsFragmentLayoutBinding(RelativeLayout r1, LinearLayout r2, TextView r3, LinearLayout r4, TextView r5) {
        this.rootView = r1;
        this.bluetoothScanSwitchContainer = r2;
        this.bluetoothScanTv = r3;
        this.wifiScanSwitchContainer = r4;
        this.wifiScanTv = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ScanningSettingsFragmentLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScanningSettingsFragmentLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.scanning_settings_fragment_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScanningSettingsFragmentLayoutBinding bind(View r8) {
        int r0 = R.id.bluetooth_scan_switch_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.bluetooth_scan_switch_container);
        if (r4 == null) goto L13;
        r0 = R.id.bluetooth_scan_tv;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.bluetooth_scan_tv);
        if (r5 == null) goto L13;
        r0 = R.id.wifi_scan_switch_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.wifi_scan_switch_container);
        if (r6 == null) goto L13;
        r0 = R.id.wifi_scan_tv;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.wifi_scan_tv);
        if (r7 == null) goto L13;
        return new ScanningSettingsFragmentLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
