package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiSwitchBinding implements ViewBinding {
    public final OCardListItem assistant;
    public final ViewStub previewWizard;
    private final RelativeLayout rootView;
    public final OCardListItem switchWifi;
    public final TextView wifiStateTips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiSwitchBinding(RelativeLayout r1, OCardListItem r2, ViewStub r3, OCardListItem r4, TextView r5) {
        this.rootView = r1;
        this.assistant = r2;
        this.previewWizard = r3;
        this.switchWifi = r4;
        this.wifiStateTips = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiSwitchBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiSwitchBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_switch, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiSwitchBinding bind(View r8) {
        int r0 = R.id.assistant;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.assistant);
        if (r4 == null) goto L13;
        r0 = R.id.preview_wizard;
        ViewStub r5 = (ViewStub) ViewBindings.findChildViewById(r8, R.id.preview_wizard);
        if (r5 == null) goto L13;
        r0 = R.id.switch_wifi;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.switch_wifi);
        if (r6 == null) goto L13;
        r0 = R.id.wifi_state_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.wifi_state_tips);
        if (r7 == null) goto L13;
        return new WifiSwitchBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
