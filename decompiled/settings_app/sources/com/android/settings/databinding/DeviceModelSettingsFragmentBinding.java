package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceModelSettingsFragmentBinding implements ViewBinding {
    public final LinearLayout deviceModelSettingsLayout;
    public final SettingItemSwitch itemButtonLightsSwitch;
    public final SettingItemSwitch itemLedLightsSwitch;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceModelSettingsFragmentBinding(LinearLayout r1, LinearLayout r2, SettingItemSwitch r3, SettingItemSwitch r4) {
        this.rootView = r1;
        this.deviceModelSettingsLayout = r2;
        this.itemButtonLightsSwitch = r3;
        this.itemLedLightsSwitch = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DeviceModelSettingsFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceModelSettingsFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_model_settings_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceModelSettingsFragmentBinding bind(View r4) {
        LinearLayout r0 = (LinearLayout) r4;
        int r1 = R.id.item_button_lights_switch;
        SettingItemSwitch r2 = (SettingItemSwitch) ViewBindings.findChildViewById(r4, R.id.item_button_lights_switch);
        if (r2 == null) goto L9;
        r1 = R.id.item_led_lights_switch;
        SettingItemSwitch r3 = (SettingItemSwitch) ViewBindings.findChildViewById(r4, R.id.item_led_lights_switch);
        if (r3 == null) goto L9;
        return new DeviceModelSettingsFragmentBinding(r0, r0, r2, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r1)));
    }
}
