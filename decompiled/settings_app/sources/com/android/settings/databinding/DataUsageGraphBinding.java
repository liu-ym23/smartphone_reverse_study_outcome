package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.graph.UsageView;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageGraphBinding implements ViewBinding {
    public final UsageView dataUsage;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageGraphBinding(LinearLayout r1, UsageView r2) {
        this.rootView = r1;
        this.dataUsage = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageGraphBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageGraphBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_graph, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageGraphBinding bind(View r2) {
        UsageView r1 = (UsageView) ViewBindings.findChildViewById(r2, R.id.data_usage);
        if (r1 == null) goto L7;
        return new DataUsageGraphBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.data_usage)));
    }
}
