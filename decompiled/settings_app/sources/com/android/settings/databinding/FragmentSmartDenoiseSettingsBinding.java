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
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentSmartDenoiseSettingsBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final TextView smartDenoiseNormalAppsTips;
    public final SettingItemSwitch switchSmartDenoiseNormalApps;
    public final SettingItemSwitch switchSmartDenoisePhoneCall;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentSmartDenoiseSettingsBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, TextView r4, SettingItemSwitch r5, SettingItemSwitch r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.smartDenoiseNormalAppsTips = r4;
        this.switchSmartDenoiseNormalApps = r5;
        this.switchSmartDenoisePhoneCall = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSmartDenoiseSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentSmartDenoiseSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_smart_denoise_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentSmartDenoiseSettingsBinding bind(View r10) {
        int r0 = R.id.page_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r4 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r5 == null) goto L17;
        r0 = R.id.smart_denoise_normal_apps_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, R.id.smart_denoise_normal_apps_tips);
        if (r6 == null) goto L17;
        r0 = R.id.switch_smart_denoise_normal_apps;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.switch_smart_denoise_normal_apps);
        if (r7 == null) goto L17;
        r0 = R.id.switch_smart_denoise_phone_call;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.switch_smart_denoise_phone_call);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new FragmentSmartDenoiseSettingsBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
