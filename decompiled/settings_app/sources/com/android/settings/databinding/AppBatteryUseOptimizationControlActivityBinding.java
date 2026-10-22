package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AppBatteryUseOptimizationControlActivityBinding implements ViewBinding {
    public final OCardListItem allowBgPowerHigh;
    public final ManageApplicationsItemBinding appSnippet;
    public final OCardListItem idUseDataBackground;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem percent;
    private final RelativeLayout rootView;
    public final OCardListItem switchControlBackgroundRun;
    public final OCardListItem switchStartBySys;
    public final OCardListItem switchStartByThird;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppBatteryUseOptimizationControlActivityBinding(RelativeLayout r1, OCardListItem r2, ManageApplicationsItemBinding r3, OCardListItem r4, LinearLayout r5, OScrollView r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.allowBgPowerHigh = r2;
        this.appSnippet = r3;
        this.idUseDataBackground = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.percent = r7;
        this.switchControlBackgroundRun = r8;
        this.switchStartBySys = r9;
        this.switchStartByThird = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBatteryUseOptimizationControlActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppBatteryUseOptimizationControlActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_battery_use_optimization_control_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppBatteryUseOptimizationControlActivityBinding bind(View r14) {
        int r0 = R.id.allow_bg_power_high;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.allow_bg_power_high);
        if (r4 == null) goto L25;
        r0 = R.id.app_snippet;
        View r1 = ViewBindings.findChildViewById(r14, R.id.app_snippet);
        if (r1 == null) goto L25;
        ManageApplicationsItemBinding r5 = ManageApplicationsItemBinding.bind(r1);
        r0 = R.id.id_use_data_background;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.id_use_data_background);
        if (r6 == null) goto L25;
        r0 = R.id.page_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.page_container);
        if (r7 == null) goto L25;
        r0 = R.id.page_scrollview;
        OScrollView r8 = (OScrollView) ViewBindings.findChildViewById(r14, R.id.page_scrollview);
        if (r8 == null) goto L25;
        r0 = R.id.percent;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.percent);
        if (r9 == null) goto L25;
        r0 = R.id.switch_control_background_run;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.switch_control_background_run);
        if (r10 == null) goto L25;
        r0 = R.id.switch_start_by_sys;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.switch_start_by_sys);
        if (r11 == null) goto L25;
        r0 = R.id.switch_start_by_third;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.switch_start_by_third);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new AppBatteryUseOptimizationControlActivityBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
