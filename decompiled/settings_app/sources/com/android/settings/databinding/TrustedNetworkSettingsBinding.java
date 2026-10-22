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
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class TrustedNetworkSettingsBinding implements ViewBinding {
    public final TextView accessPointName;
    public final LinearLayout bottomLayout;
    public final OListItemSettings btnSet;
    public final OListItemSettings btnUnset;
    public final TextView description;
    public final OButton noNotify;
    private final RelativeLayout rootView;
    public final OScrollView scrollView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TrustedNetworkSettingsBinding(RelativeLayout r1, TextView r2, LinearLayout r3, OListItemSettings r4, OListItemSettings r5, TextView r6, OButton r7, OScrollView r8) {
        this.rootView = r1;
        this.accessPointName = r2;
        this.bottomLayout = r3;
        this.btnSet = r4;
        this.btnUnset = r5;
        this.description = r6;
        this.noNotify = r7;
        this.scrollView = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TrustedNetworkSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TrustedNetworkSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.trusted_network_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TrustedNetworkSettingsBinding bind(View r11) {
        int r0 = R.id.access_point_name;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, R.id.access_point_name);
        if (r4 == null) goto L19;
        r0 = R.id.bottom_layout;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.bottom_layout);
        if (r5 == null) goto L19;
        r0 = R.id.btn_set;
        OListItemSettings r6 = (OListItemSettings) ViewBindings.findChildViewById(r11, R.id.btn_set);
        if (r6 == null) goto L19;
        r0 = R.id.btn_unset;
        OListItemSettings r7 = (OListItemSettings) ViewBindings.findChildViewById(r11, R.id.btn_unset);
        if (r7 == null) goto L19;
        r0 = R.id.description;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.description);
        if (r8 == null) goto L19;
        r0 = R.id.no_notify;
        OButton r9 = (OButton) ViewBindings.findChildViewById(r11, R.id.no_notify);
        if (r9 == null) goto L19;
        r0 = R.id.scroll_view;
        OScrollView r10 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.scroll_view);
        if (r10 == null) goto L19;
        return new TrustedNetworkSettingsBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
