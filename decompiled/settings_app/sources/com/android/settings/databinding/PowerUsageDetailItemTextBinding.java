package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PowerUsageDetailItemTextBinding implements ViewBinding {
    public final TextView label;
    private final RelativeLayout rootView;
    public final TextView value;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PowerUsageDetailItemTextBinding(RelativeLayout r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.label = r2;
        this.value = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PowerUsageDetailItemTextBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PowerUsageDetailItemTextBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.power_usage_detail_item_text, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PowerUsageDetailItemTextBinding bind(View r3) {
        int r0 = R.id.label;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.label);
        if (r1 == null) goto L9;
        r0 = R.id.value;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.value);
        if (r2 == null) goto L9;
        return new PowerUsageDetailItemTextBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
