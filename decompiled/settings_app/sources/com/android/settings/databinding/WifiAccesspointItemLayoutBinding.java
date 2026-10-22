package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiAccesspointItemLayoutBinding implements ViewBinding {
    public final ImageView apDetail;
    private final RelativeLayout rootView;
    public final ImageView signal;
    public final TextView summary;
    public final TextView title;
    public final ViewStub trustedLabelViewstub;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiAccesspointItemLayoutBinding(RelativeLayout r1, ImageView r2, ImageView r3, TextView r4, TextView r5, ViewStub r6) {
        this.rootView = r1;
        this.apDetail = r2;
        this.signal = r3;
        this.summary = r4;
        this.title = r5;
        this.trustedLabelViewstub = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiAccesspointItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiAccesspointItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_accesspoint_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiAccesspointItemLayoutBinding bind(View r9) {
        int r0 = R.id.ap_detail;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.ap_detail);
        if (r4 == null) goto L15;
        r0 = R.id.signal;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.signal);
        if (r5 == null) goto L15;
        r0 = android.R.id.summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.summary);
        if (r6 == null) goto L15;
        r0 = android.R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.title);
        if (r7 == null) goto L15;
        r0 = R.id.trusted_label_viewstub;
        ViewStub r8 = (ViewStub) ViewBindings.findChildViewById(r9, R.id.trusted_label_viewstub);
        if (r8 == null) goto L15;
        return new WifiAccesspointItemLayoutBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
