package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class IgnoreOptimizationsContentBinding implements ViewBinding {
    public final RadioWithSummaryBinding ignoreOff;
    public final RadioWithSummaryBinding ignoreOn;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private IgnoreOptimizationsContentBinding(LinearLayout r1, RadioWithSummaryBinding r2, RadioWithSummaryBinding r3) {
        this.rootView = r1;
        this.ignoreOff = r2;
        this.ignoreOn = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IgnoreOptimizationsContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static IgnoreOptimizationsContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ignore_optimizations_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static IgnoreOptimizationsContentBinding bind(View r3) {
        int r0 = R.id.ignore_off;
        View r1 = ViewBindings.findChildViewById(r3, R.id.ignore_off);
        if (r1 == null) goto L10;
        RadioWithSummaryBinding r2 = RadioWithSummaryBinding.bind(r1);
        View r4 = ViewBindings.findChildViewById(r3, R.id.ignore_on);
        if (r4 == null) goto L8;
        LinearLayout r5 = (LinearLayout) r3;
        return new IgnoreOptimizationsContentBinding(r5, r2, RadioWithSummaryBinding.bind(r4));
    L8:
        r0 = R.id.ignore_on;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
