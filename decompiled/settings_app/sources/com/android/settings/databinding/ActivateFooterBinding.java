package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivateFooterBinding implements ViewBinding {
    public final OButton activateCellular;
    public final OButton activateSms;
    public final TextView noSimTips;
    public final LinearLayout noSimTipsContainer;
    private final LinearLayout rootView;
    public final TextView smsTips;
    public final LinearLayout smsTipsContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivateFooterBinding(LinearLayout r1, OButton r2, OButton r3, TextView r4, LinearLayout r5, TextView r6, LinearLayout r7) {
        this.rootView = r1;
        this.activateCellular = r2;
        this.activateSms = r3;
        this.noSimTips = r4;
        this.noSimTipsContainer = r5;
        this.smsTips = r6;
        this.smsTipsContainer = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivateFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivateFooterBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activate_footer, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivateFooterBinding bind(View r10) {
        int r0 = R.id.activate_cellular;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r10, R.id.activate_cellular);
        if (r4 == null) goto L17;
        r0 = R.id.activate_sms;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r10, R.id.activate_sms);
        if (r5 == null) goto L17;
        r0 = R.id.no_sim_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, R.id.no_sim_tips);
        if (r6 == null) goto L17;
        r0 = R.id.no_sim_tips_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.no_sim_tips_container);
        if (r7 == null) goto L17;
        r0 = R.id.sms_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.sms_tips);
        if (r8 == null) goto L17;
        r0 = R.id.sms_tips_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.sms_tips_container);
        if (r9 == null) goto L17;
        return new ActivateFooterBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
