package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivateHeaderBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView titlebarTitleTv;
    public final TextView wifiStateTips;
    public final TextView wifiStateTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivateHeaderBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.titlebarTitleTv = r2;
        this.wifiStateTips = r3;
        this.wifiStateTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivateHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivateHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activate_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivateHeaderBinding bind(View r4) {
        int r0 = R.id.titlebar_title_tv;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.titlebar_title_tv);
        if (r1 == null) goto L11;
        r0 = R.id.wifi_state_tips;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.wifi_state_tips);
        if (r2 == null) goto L11;
        r0 = R.id.wifi_state_title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.wifi_state_title);
        if (r3 == null) goto L11;
        return new ActivateHeaderBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
