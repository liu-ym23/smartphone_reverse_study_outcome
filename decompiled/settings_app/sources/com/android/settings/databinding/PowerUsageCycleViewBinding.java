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
public final class PowerUsageCycleViewBinding implements ViewBinding {
    public final TextView powerUsageMonth;
    public final TextView powerUsageToday;
    public final TextView powerUsageWeek;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PowerUsageCycleViewBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.powerUsageMonth = r2;
        this.powerUsageToday = r3;
        this.powerUsageWeek = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PowerUsageCycleViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PowerUsageCycleViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.power_usage_cycle_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PowerUsageCycleViewBinding bind(View r4) {
        int r0 = R.id.power_usage_month;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.power_usage_month);
        if (r1 == null) goto L11;
        r0 = R.id.power_usage_today;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.power_usage_today);
        if (r2 == null) goto L11;
        r0 = R.id.power_usage_week;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.power_usage_week);
        if (r3 == null) goto L11;
        return new PowerUsageCycleViewBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
