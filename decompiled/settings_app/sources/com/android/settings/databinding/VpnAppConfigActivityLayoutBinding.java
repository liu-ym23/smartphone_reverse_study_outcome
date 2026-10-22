package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class VpnAppConfigActivityLayoutBinding implements ViewBinding {
    public final ImageView appIcon;
    public final OTextView appName;
    public final OTextView appVersion;
    public final OButton cancelVpn;
    public final OCardListItem itemVpnAlwaysOn;
    public final LinearLayout layoutHeader;
    public final OCardListItem lockdownVpn;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VpnAppConfigActivityLayoutBinding(RelativeLayout r1, ImageView r2, OTextView r3, OTextView r4, OButton r5, OCardListItem r6, LinearLayout r7, OCardListItem r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.appIcon = r2;
        this.appName = r3;
        this.appVersion = r4;
        this.cancelVpn = r5;
        this.itemVpnAlwaysOn = r6;
        this.layoutHeader = r7;
        this.lockdownVpn = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VpnAppConfigActivityLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VpnAppConfigActivityLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.vpn_app_config_activity_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VpnAppConfigActivityLayoutBinding bind(View r12) {
        int r0 = R.id.app_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r12, R.id.app_icon);
        if (r4 == null) goto L21;
        r0 = R.id.app_name;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r12, R.id.app_name);
        if (r5 == null) goto L21;
        r0 = R.id.app_version;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r12, R.id.app_version);
        if (r6 == null) goto L21;
        r0 = R.id.cancel_vpn;
        OButton r7 = (OButton) ViewBindings.findChildViewById(r12, R.id.cancel_vpn);
        if (r7 == null) goto L21;
        r0 = R.id.item_vpn_always_on;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r12, R.id.item_vpn_always_on);
        if (r8 == null) goto L21;
        r0 = R.id.layout_header;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.layout_header);
        if (r9 == null) goto L21;
        r0 = R.id.lockdown_vpn;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r12, R.id.lockdown_vpn);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new VpnAppConfigActivityLayoutBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
