package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiApSetupBinding implements ViewBinding {
    public final OCardListItem chooseBand;
    public final LinearLayout fields;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OInputLayout password;
    private final RelativeLayout rootView;
    public final OCardListItem security;
    public final OInputLayout ssid;
    public final OCardListItem useOwe;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiApSetupBinding(RelativeLayout r1, OCardListItem r2, LinearLayout r3, LinearLayout r4, OScrollView r5, OInputLayout r6, OCardListItem r7, OInputLayout r8, OCardListItem r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.chooseBand = r2;
        this.fields = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.password = r6;
        this.security = r7;
        this.ssid = r8;
        this.useOwe = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiApSetupBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiApSetupBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_ap_setup, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiApSetupBinding bind(View r13) {
        int r0 = R.id.choose_band;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.choose_band);
        if (r4 == null) goto L23;
        r0 = R.id.fields;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.fields);
        if (r5 == null) goto L23;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_container);
        if (r6 == null) goto L23;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r13, R.id.page_scrollview);
        if (r7 == null) goto L23;
        r0 = R.id.password;
        OInputLayout r8 = (OInputLayout) ViewBindings.findChildViewById(r13, R.id.password);
        if (r8 == null) goto L23;
        r0 = R.id.security;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.security);
        if (r9 == null) goto L23;
        r0 = R.id.ssid;
        OInputLayout r10 = (OInputLayout) ViewBindings.findChildViewById(r13, R.id.ssid);
        if (r10 == null) goto L23;
        r0 = R.id.use_owe;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.use_owe);
        if (r11 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r12 == null) goto L23;
        return new WifiApSetupBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
