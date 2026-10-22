package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class NotchLandscapeSettingsHeaderLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SettingItemSwitch swAllowNotch;
    public final TextView tvAllowNotchTips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotchLandscapeSettingsHeaderLayoutBinding(LinearLayout r1, SettingItemSwitch r2, TextView r3) {
        this.rootView = r1;
        this.swAllowNotch = r2;
        this.tvAllowNotchTips = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NotchLandscapeSettingsHeaderLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotchLandscapeSettingsHeaderLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notch_landscape_settings_header_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotchLandscapeSettingsHeaderLayoutBinding bind(View r3) {
        int r0 = R.id.sw_allow_notch;
        SettingItemSwitch r1 = (SettingItemSwitch) ViewBindings.findChildViewById(r3, R.id.sw_allow_notch);
        if (r1 == null) goto L9;
        r0 = R.id.tv_allow_notch_tips;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.tv_allow_notch_tips);
        if (r2 == null) goto L9;
        return new NotchLandscapeSettingsHeaderLayoutBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
