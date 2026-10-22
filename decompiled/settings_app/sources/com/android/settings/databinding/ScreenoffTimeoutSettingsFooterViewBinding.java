package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class ScreenoffTimeoutSettingsFooterViewBinding implements ViewBinding {
    public final TextView idWirelessChargingTips;
    private final LinearLayout rootView;
    public final OCardListItem stayAwakeSwitch;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScreenoffTimeoutSettingsFooterViewBinding(LinearLayout r1, TextView r2, OCardListItem r3) {
        this.rootView = r1;
        this.idWirelessChargingTips = r2;
        this.stayAwakeSwitch = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ScreenoffTimeoutSettingsFooterViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScreenoffTimeoutSettingsFooterViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.screenoff_timeout_settings_footer_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScreenoffTimeoutSettingsFooterViewBinding bind(View r3) {
        int r0 = R.id.id_wireless_charging_tips;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.id_wireless_charging_tips);
        if (r1 == null) goto L9;
        r0 = R.id.stay_awake_switch;
        OCardListItem r2 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.stay_awake_switch);
        if (r2 == null) goto L9;
        return new ScreenoffTimeoutSettingsFooterViewBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
