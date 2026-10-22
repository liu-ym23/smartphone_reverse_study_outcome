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
public final class ProcessStatsMemDetailsBinding implements ViewBinding {
    public final LinearLayout allDetails;
    public final LinearLayout memState;
    public final LinearLayout memUse;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ProcessStatsMemDetailsBinding(OScrollView r1, LinearLayout r2, LinearLayout r3, LinearLayout r4) {
        this.rootView = r1;
        this.allDetails = r2;
        this.memState = r3;
        this.memUse = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static ProcessStatsMemDetailsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ProcessStatsMemDetailsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.process_stats_mem_details, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ProcessStatsMemDetailsBinding bind(View r4) {
        int r0 = R.id.all_details;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.all_details);
        if (r1 == null) goto L11;
        r0 = R.id.mem_state;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.mem_state);
        if (r2 == null) goto L11;
        r0 = R.id.mem_use;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.mem_use);
        if (r3 == null) goto L11;
        return new ProcessStatsMemDetailsBinding((OScrollView) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
