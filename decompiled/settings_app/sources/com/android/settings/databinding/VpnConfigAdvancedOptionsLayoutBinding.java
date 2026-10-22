package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class VpnConfigAdvancedOptionsLayoutBinding implements ViewBinding {
    public final OCardListItem dnsServers;
    public final View fakeStatusBar;
    public final LinearLayout pageContainer;
    private final RelativeLayout rootView;
    public final OCardListItem routes;
    public final OCardListItem searchDomains;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VpnConfigAdvancedOptionsLayoutBinding(RelativeLayout r1, OCardListItem r2, View r3, LinearLayout r4, OCardListItem r5, OCardListItem r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.dnsServers = r2;
        this.fakeStatusBar = r3;
        this.pageContainer = r4;
        this.routes = r5;
        this.searchDomains = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VpnConfigAdvancedOptionsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VpnConfigAdvancedOptionsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.vpn_config_advanced_options_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VpnConfigAdvancedOptionsLayoutBinding bind(View r10) {
        int r0 = R.id.dns_servers;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.dns_servers);
        if (r4 == null) goto L17;
        r0 = R.id.fake_status_bar;
        View r5 = ViewBindings.findChildViewById(r10, R.id.fake_status_bar);
        if (r5 == null) goto L17;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r6 == null) goto L17;
        r0 = R.id.routes;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.routes);
        if (r7 == null) goto L17;
        r0 = R.id.search_domains;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.search_domains);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new VpnConfigAdvancedOptionsLayoutBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
