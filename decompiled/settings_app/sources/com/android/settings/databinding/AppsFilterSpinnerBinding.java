package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AppsFilterSpinnerBinding implements ViewBinding {
    public final ImageView filterSettings;
    public final Spinner filterSpinner;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppsFilterSpinnerBinding(RelativeLayout r1, ImageView r2, Spinner r3) {
        this.rootView = r1;
        this.filterSettings = r2;
        this.filterSpinner = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppsFilterSpinnerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppsFilterSpinnerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.apps_filter_spinner, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppsFilterSpinnerBinding bind(View r3) {
        int r0 = R.id.filter_settings;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.filter_settings);
        if (r1 == null) goto L9;
        r0 = R.id.filter_spinner;
        Spinner r2 = (Spinner) ViewBindings.findChildViewById(r3, R.id.filter_spinner);
        if (r2 == null) goto L9;
        return new AppsFilterSpinnerBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
