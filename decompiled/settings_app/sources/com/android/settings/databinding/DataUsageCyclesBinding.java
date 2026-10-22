package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageCyclesBinding implements ViewBinding {
    public final Spinner cyclesSpinner;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageCyclesBinding(LinearLayout r1, Spinner r2) {
        this.rootView = r1;
        this.cyclesSpinner = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageCyclesBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageCyclesBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_cycles, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageCyclesBinding bind(View r2) {
        Spinner r1 = (Spinner) ViewBindings.findChildViewById(r2, R.id.cycles_spinner);
        if (r1 == null) goto L7;
        return new DataUsageCyclesBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.cycles_spinner)));
    }
}
