package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageAppsFilterSpinnerBinding implements ViewBinding {
    public final Spinner filterSpinner;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageAppsFilterSpinnerBinding(FrameLayout r1, Spinner r2) {
        this.rootView = r1;
        this.filterSpinner = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ManageAppsFilterSpinnerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageAppsFilterSpinnerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_apps_filter_spinner, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageAppsFilterSpinnerBinding bind(View r2) {
        Spinner r1 = (Spinner) ViewBindings.findChildViewById(r2, R.id.filter_spinner);
        if (r1 == null) goto L7;
        return new ManageAppsFilterSpinnerBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.filter_spinner)));
    }
}
