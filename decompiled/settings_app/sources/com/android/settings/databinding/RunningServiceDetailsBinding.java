package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class RunningServiceDetailsBinding implements ViewBinding {
    public final LinearLayout allDetails;
    private final OScrollView rootView;
    public final RunningProcessesItemBinding snippet;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RunningServiceDetailsBinding(OScrollView r1, LinearLayout r2, RunningProcessesItemBinding r3) {
        this.rootView = r1;
        this.allDetails = r2;
        this.snippet = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static RunningServiceDetailsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RunningServiceDetailsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.running_service_details, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RunningServiceDetailsBinding bind(View r3) {
        int r0 = R.id.all_details;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r3, R.id.all_details);
        if (r1 == null) goto L9;
        r0 = R.id.snippet;
        View r2 = ViewBindings.findChildViewById(r3, R.id.snippet);
        if (r2 == null) goto L9;
        OScrollView r4 = (OScrollView) r3;
        return new RunningServiceDetailsBinding(r4, r1, RunningProcessesItemBinding.bind(r2));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
