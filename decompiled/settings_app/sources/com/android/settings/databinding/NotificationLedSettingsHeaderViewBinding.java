package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationLedSettingsHeaderViewBinding implements ViewBinding {
    public final SettingItemText ledBrightnessSettings;
    public final SettingItemSwitch ledMms;
    public final SettingItemSwitch ledPhone;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationLedSettingsHeaderViewBinding(LinearLayout r1, SettingItemText r2, SettingItemSwitch r3, SettingItemSwitch r4) {
        this.rootView = r1;
        this.ledBrightnessSettings = r2;
        this.ledMms = r3;
        this.ledPhone = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NotificationLedSettingsHeaderViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationLedSettingsHeaderViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_led_settings_header_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationLedSettingsHeaderViewBinding bind(View r4) {
        int r0 = R.id.led_brightness_settings;
        SettingItemText r1 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.led_brightness_settings);
        if (r1 == null) goto L11;
        r0 = R.id.led_mms;
        SettingItemSwitch r2 = (SettingItemSwitch) ViewBindings.findChildViewById(r4, R.id.led_mms);
        if (r2 == null) goto L11;
        r0 = R.id.led_phone;
        SettingItemSwitch r3 = (SettingItemSwitch) ViewBindings.findChildViewById(r4, R.id.led_phone);
        if (r3 == null) goto L11;
        return new NotificationLedSettingsHeaderViewBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
