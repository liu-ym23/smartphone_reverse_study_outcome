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
public final class RunningServiceDetailsServiceBinding implements ViewBinding {
    public final TextView compDescription;
    public final TwoButtonsPanelBinding controlButtonsPanel;
    private final LinearLayout rootView;
    public final RunningProcessesItemBinding service;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RunningServiceDetailsServiceBinding(LinearLayout r1, TextView r2, TwoButtonsPanelBinding r3, RunningProcessesItemBinding r4) {
        this.rootView = r1;
        this.compDescription = r2;
        this.controlButtonsPanel = r3;
        this.service = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RunningServiceDetailsServiceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RunningServiceDetailsServiceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.running_service_details_service, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RunningServiceDetailsServiceBinding bind(View r4) {
        int r0 = R.id.comp_description;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.comp_description);
        if (r1 == null) goto L12;
        r0 = R.id.control_buttons_panel;
        View r2 = ViewBindings.findChildViewById(r4, R.id.control_buttons_panel);
        if (r2 == null) goto L12;
        TwoButtonsPanelBinding r3 = TwoButtonsPanelBinding.bind(r2);
        View r5 = ViewBindings.findChildViewById(r4, R.id.service);
        if (r5 == null) goto L10;
        LinearLayout r6 = (LinearLayout) r4;
        return new RunningServiceDetailsServiceBinding(r6, r1, r3, RunningProcessesItemBinding.bind(r5));
    L10:
        r0 = R.id.service;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
