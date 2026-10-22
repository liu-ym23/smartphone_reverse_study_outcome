package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.graph.UsageView;

/* JADX INFO: loaded from: classes2.dex */
public final class BatteryUsageGraphBinding implements ViewBinding {
    public final UsageView batteryUsage;
    public final TextView charge;
    public final TextView estimation;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BatteryUsageGraphBinding(LinearLayout r1, UsageView r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.batteryUsage = r2;
        this.charge = r3;
        this.estimation = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BatteryUsageGraphBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BatteryUsageGraphBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.battery_usage_graph, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BatteryUsageGraphBinding bind(View r4) {
        int r0 = R.id.battery_usage;
        UsageView r1 = (UsageView) ViewBindings.findChildViewById(r4, R.id.battery_usage);
        if (r1 == null) goto L11;
        r0 = R.id.charge;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.charge);
        if (r2 == null) goto L11;
        r0 = R.id.estimation;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.estimation);
        if (r3 == null) goto L11;
        return new BatteryUsageGraphBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
