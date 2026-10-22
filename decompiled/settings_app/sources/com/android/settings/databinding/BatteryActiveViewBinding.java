package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.fuelgauge.BatteryActiveView;

/* JADX INFO: loaded from: classes2.dex */
public final class BatteryActiveViewBinding implements ViewBinding {
    public final BatteryActiveView batteryActive;
    private final LinearLayout rootView;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BatteryActiveViewBinding(LinearLayout r1, BatteryActiveView r2, TextView r3) {
        this.rootView = r1;
        this.batteryActive = r2;
        this.title = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BatteryActiveViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BatteryActiveViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.battery_active_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BatteryActiveViewBinding bind(View r3) {
        int r0 = R.id.battery_active;
        BatteryActiveView r1 = (BatteryActiveView) ViewBindings.findChildViewById(r3, R.id.battery_active);
        if (r1 == null) goto L9;
        r0 = android.R.id.title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.title);
        if (r2 == null) goto L9;
        return new BatteryActiveViewBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
