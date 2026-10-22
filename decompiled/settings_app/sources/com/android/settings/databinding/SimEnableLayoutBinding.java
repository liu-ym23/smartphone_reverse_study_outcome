package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SimEnableLayoutBinding implements ViewBinding {
    public final RelativeLayout rootContainerRl;
    private final RelativeLayout rootView;
    public final OCardListItem simEnableSwitch;
    public final ImageView simGuide;
    public final OCardListItem simNameSetting;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SimEnableLayoutBinding(RelativeLayout r1, RelativeLayout r2, OCardListItem r3, ImageView r4, OCardListItem r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.rootContainerRl = r2;
        this.simEnableSwitch = r3;
        this.simGuide = r4;
        this.simNameSetting = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SimEnableLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SimEnableLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sim_enable_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SimEnableLayoutBinding bind(View r7) {
        RelativeLayout r2 = (RelativeLayout) r7;
        int r0 = R.id.sim_enable_switch;
        OCardListItem r3 = (OCardListItem) ViewBindings.findChildViewById(r7, R.id.sim_enable_switch);
        if (r3 == null) goto L13;
        r0 = R.id.sim_guide;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r7, R.id.sim_guide);
        if (r4 == null) goto L13;
        r0 = R.id.sim_name_setting;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r7, R.id.sim_name_setting);
        if (r5 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r6 = (OFloatingTitleBar) ViewBindings.findChildViewById(r7, R.id.view_title);
        if (r6 == null) goto L13;
        return new SimEnableLayoutBinding(r2, r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
