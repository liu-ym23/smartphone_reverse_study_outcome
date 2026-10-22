package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.AboutStaticItem;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SimStatusLayoutBinding implements ViewBinding {
    public final LinearLayout container;
    public final AboutStaticItem dataState;
    public final AboutStaticItem iccId;
    public final AboutStaticItem meidNumber;
    public final AboutStaticItem minNumber;
    public final AboutStaticItem networkType;
    public final AboutStaticItem number;
    public final AboutStaticItem operatorName;
    public final AboutStaticItem prlVersion;
    public final AboutStaticItem roamingState;
    private final LinearLayout rootView;
    public final AboutStaticItem serviceState;
    public final AboutStaticItem signalStrength;
    public final AboutStaticItem volteState;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SimStatusLayoutBinding(LinearLayout r1, LinearLayout r2, AboutStaticItem r3, AboutStaticItem r4, AboutStaticItem r5, AboutStaticItem r6, AboutStaticItem r7, AboutStaticItem r8, AboutStaticItem r9, AboutStaticItem r10, AboutStaticItem r11, AboutStaticItem r12, AboutStaticItem r13, AboutStaticItem r14) {
        this.rootView = r1;
        this.container = r2;
        this.dataState = r3;
        this.iccId = r4;
        this.meidNumber = r5;
        this.minNumber = r6;
        this.networkType = r7;
        this.number = r8;
        this.operatorName = r9;
        this.prlVersion = r10;
        this.roamingState = r11;
        this.serviceState = r12;
        this.signalStrength = r13;
        this.volteState = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SimStatusLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SimStatusLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sim_status_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SimStatusLayoutBinding bind(View r15) {
        LinearLayout r2 = (LinearLayout) r15;
        int r0 = R.id.data_state;
        AboutStaticItem r3 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.data_state);
        if (r3 == null) goto L29;
        r0 = R.id.icc_id;
        AboutStaticItem r4 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.icc_id);
        if (r4 == null) goto L29;
        r0 = R.id.meid_number;
        AboutStaticItem r5 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.meid_number);
        if (r5 == null) goto L29;
        r0 = R.id.min_number;
        AboutStaticItem r6 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.min_number);
        if (r6 == null) goto L29;
        r0 = R.id.network_type;
        AboutStaticItem r7 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.network_type);
        if (r7 == null) goto L29;
        r0 = R.id.number;
        AboutStaticItem r8 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.number);
        if (r8 == null) goto L29;
        r0 = R.id.operator_name;
        AboutStaticItem r9 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.operator_name);
        if (r9 == null) goto L29;
        r0 = R.id.prl_version;
        AboutStaticItem r10 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.prl_version);
        if (r10 == null) goto L29;
        r0 = R.id.roaming_state;
        AboutStaticItem r11 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.roaming_state);
        if (r11 == null) goto L29;
        r0 = R.id.service_state;
        AboutStaticItem r12 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.service_state);
        if (r12 == null) goto L29;
        r0 = R.id.signal_strength;
        AboutStaticItem r13 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.signal_strength);
        if (r13 == null) goto L29;
        r0 = R.id.volte_state;
        AboutStaticItem r14 = (AboutStaticItem) ViewBindings.findChildViewById(r15, R.id.volte_state);
        if (r14 == null) goto L29;
        return new SimStatusLayoutBinding(r2, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
