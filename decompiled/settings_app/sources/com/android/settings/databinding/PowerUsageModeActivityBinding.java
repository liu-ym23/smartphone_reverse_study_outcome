package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class PowerUsageModeActivityBinding implements ViewBinding {
    public final ListContentItemSwitch powerUsageFeaturePhoneMode;
    public final ListContentItemSwitch powerUsageLowBatteryMode;
    private final RelativeLayout rootView;
    public final OScrollView scrollView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PowerUsageModeActivityBinding(RelativeLayout r1, ListContentItemSwitch r2, ListContentItemSwitch r3, OScrollView r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.powerUsageFeaturePhoneMode = r2;
        this.powerUsageLowBatteryMode = r3;
        this.scrollView = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PowerUsageModeActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PowerUsageModeActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.power_usage_mode_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PowerUsageModeActivityBinding bind(View r8) {
        int r0 = R.id.power_usage_feature_phone_mode;
        ListContentItemSwitch r4 = (ListContentItemSwitch) ViewBindings.findChildViewById(r8, R.id.power_usage_feature_phone_mode);
        if (r4 == null) goto L13;
        r0 = R.id.power_usage_low_battery_mode;
        ListContentItemSwitch r5 = (ListContentItemSwitch) ViewBindings.findChildViewById(r8, R.id.power_usage_low_battery_mode);
        if (r5 == null) goto L13;
        r0 = R.id.scroll_view;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r8, R.id.scroll_view);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new PowerUsageModeActivityBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
