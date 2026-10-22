package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class HotspotCheckboxBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView subsummary;
    public final TextView subtitle;
    public final Switch switchWidget;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private HotspotCheckboxBinding(LinearLayout r1, TextView r2, TextView r3, Switch r4) {
        this.rootView = r1;
        this.subsummary = r2;
        this.subtitle = r3;
        this.switchWidget = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HotspotCheckboxBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static HotspotCheckboxBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.hotspot_checkbox, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static HotspotCheckboxBinding bind(View r4) {
        int r0 = R.id.subsummary;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.subsummary);
        if (r1 == null) goto L11;
        r0 = R.id.subtitle;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.subtitle);
        if (r2 == null) goto L11;
        r0 = R.id.switchWidget;
        Switch r3 = (Switch) ViewBindings.findChildViewById(r4, R.id.switchWidget);
        if (r3 == null) goto L11;
        return new HotspotCheckboxBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
