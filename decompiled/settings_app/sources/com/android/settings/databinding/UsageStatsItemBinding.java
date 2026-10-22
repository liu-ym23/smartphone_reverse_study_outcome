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
public final class UsageStatsItemBinding implements ViewBinding {
    public final TextView lastTimeUsed;
    public final TextView packageName;
    private final LinearLayout rootView;
    public final TextView usageTime;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UsageStatsItemBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.lastTimeUsed = r2;
        this.packageName = r3;
        this.usageTime = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UsageStatsItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UsageStatsItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.usage_stats_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UsageStatsItemBinding bind(View r4) {
        int r0 = R.id.last_time_used;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.last_time_used);
        if (r1 == null) goto L11;
        r0 = R.id.package_name;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.package_name);
        if (r2 == null) goto L11;
        r0 = R.id.usage_time;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.usage_time);
        if (r3 == null) goto L11;
        return new UsageStatsItemBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
