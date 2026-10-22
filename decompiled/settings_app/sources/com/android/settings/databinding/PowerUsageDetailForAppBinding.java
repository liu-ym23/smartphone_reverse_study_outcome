package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class PowerUsageDetailForAppBinding implements ViewBinding {
    public final LinearLayout appPowerUsage;
    public final OListItemSettings month;
    public final OListItemSettings percent;
    private final LinearLayout rootView;
    public final OListItemSettings today;
    public final OListItemSettings week;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PowerUsageDetailForAppBinding(LinearLayout r1, LinearLayout r2, OListItemSettings r3, OListItemSettings r4, OListItemSettings r5, OListItemSettings r6) {
        this.rootView = r1;
        this.appPowerUsage = r2;
        this.month = r3;
        this.percent = r4;
        this.today = r5;
        this.week = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PowerUsageDetailForAppBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PowerUsageDetailForAppBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.power_usage_detail_for_app, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PowerUsageDetailForAppBinding bind(View r7) {
        LinearLayout r2 = (LinearLayout) r7;
        int r0 = R.id.month;
        OListItemSettings r3 = (OListItemSettings) ViewBindings.findChildViewById(r7, R.id.month);
        if (r3 == null) goto L13;
        r0 = R.id.percent;
        OListItemSettings r4 = (OListItemSettings) ViewBindings.findChildViewById(r7, R.id.percent);
        if (r4 == null) goto L13;
        r0 = R.id.today;
        OListItemSettings r5 = (OListItemSettings) ViewBindings.findChildViewById(r7, R.id.today);
        if (r5 == null) goto L13;
        r0 = R.id.week;
        OListItemSettings r6 = (OListItemSettings) ViewBindings.findChildViewById(r7, R.id.week);
        if (r6 == null) goto L13;
        return new PowerUsageDetailForAppBinding(r2, r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
