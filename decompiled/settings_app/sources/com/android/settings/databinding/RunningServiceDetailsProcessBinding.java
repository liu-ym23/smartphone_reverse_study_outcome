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
public final class RunningServiceDetailsProcessBinding implements ViewBinding {
    public final TextView compDescription;
    private final LinearLayout rootView;
    public final RunningProcessesItemBinding service;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RunningServiceDetailsProcessBinding(LinearLayout r1, TextView r2, RunningProcessesItemBinding r3) {
        this.rootView = r1;
        this.compDescription = r2;
        this.service = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RunningServiceDetailsProcessBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RunningServiceDetailsProcessBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.running_service_details_process, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RunningServiceDetailsProcessBinding bind(View r3) {
        int r0 = R.id.comp_description;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.comp_description);
        if (r1 == null) goto L9;
        r0 = R.id.service;
        View r2 = ViewBindings.findChildViewById(r3, R.id.service);
        if (r2 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r3;
        return new RunningServiceDetailsProcessBinding(r4, r1, RunningProcessesItemBinding.bind(r2));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
