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
public final class WirelessTntAutoLayoutBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;
    public final SettingItemSwitch wirelessLighten;
    public final TextView wirelessLightenTips;
    public final SettingItemSwitch wirelessTntAuto;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WirelessTntAutoLayoutBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, OFloatingTitleBar r4, SettingItemSwitch r5, TextView r6, SettingItemSwitch r7) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.viewTitle = r4;
        this.wirelessLighten = r5;
        this.wirelessLightenTips = r6;
        this.wirelessTntAuto = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WirelessTntAutoLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WirelessTntAutoLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wireless_tnt_auto_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WirelessTntAutoLayoutBinding bind(View r10) {
        int r0 = R.id.page_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r4 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r5 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r6 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r6 == null) goto L17;
        r0 = R.id.wireless_lighten;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.wireless_lighten);
        if (r7 == null) goto L17;
        r0 = R.id.wireless_lighten_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.wireless_lighten_tips);
        if (r8 == null) goto L17;
        r0 = R.id.wireless_tnt_auto;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.wireless_tnt_auto);
        if (r9 == null) goto L17;
        return new WirelessTntAutoLayoutBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
