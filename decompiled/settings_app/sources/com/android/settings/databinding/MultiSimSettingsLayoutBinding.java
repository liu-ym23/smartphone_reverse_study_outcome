package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiSimSettingsLayoutBinding implements ViewBinding {
    public final OCardListItem dialSetting;
    public final OListItemSettings habitDualSim;
    public final OListItemSettings habitSingleSim;
    public final OCardListItem mmsSetting;
    public final TextView multiSimUsingHabitTips;
    public final OCardListItem netIntelligentDualSim;
    public final OCardListItem netOnNonDataSim;
    public final OCardListItem networkSetting;
    public final LinearLayout pageContainer;
    public final OCardListItem pin;
    public final RelativeLayout rootContainerRl;
    private final RelativeLayout rootView;
    public final OCardListItem simSub1;
    public final OCardListItem simSub2;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MultiSimSettingsLayoutBinding(RelativeLayout r1, OCardListItem r2, OListItemSettings r3, OListItemSettings r4, OCardListItem r5, TextView r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, LinearLayout r10, OCardListItem r11, RelativeLayout r12, OCardListItem r13, OCardListItem r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.dialSetting = r2;
        this.habitDualSim = r3;
        this.habitSingleSim = r4;
        this.mmsSetting = r5;
        this.multiSimUsingHabitTips = r6;
        this.netIntelligentDualSim = r7;
        this.netOnNonDataSim = r8;
        this.networkSetting = r9;
        this.pageContainer = r10;
        this.pin = r11;
        this.rootContainerRl = r12;
        this.simSub1 = r13;
        this.simSub2 = r14;
        this.viewTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MultiSimSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MultiSimSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.multi_sim_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MultiSimSettingsLayoutBinding bind(View r19) {
        int r1 = R.id.dial_setting;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.dial_setting);
        if (r5 == null) goto L31;
        r1 = R.id.habit_dual_sim;
        OListItemSettings r6 = (OListItemSettings) ViewBindings.findChildViewById(r19, R.id.habit_dual_sim);
        if (r6 == null) goto L31;
        r1 = R.id.habit_single_sim;
        OListItemSettings r7 = (OListItemSettings) ViewBindings.findChildViewById(r19, R.id.habit_single_sim);
        if (r7 == null) goto L31;
        r1 = R.id.mms_setting;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.mms_setting);
        if (r8 == null) goto L31;
        r1 = R.id.multi_sim_using_habit_tips;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r19, R.id.multi_sim_using_habit_tips);
        if (r9 == null) goto L31;
        r1 = R.id.net_intelligent_dual_sim;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.net_intelligent_dual_sim);
        if (r10 == null) goto L31;
        r1 = R.id.net_on_non_data_sim;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.net_on_non_data_sim);
        if (r11 == null) goto L31;
        r1 = R.id.network_setting;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.network_setting);
        if (r12 == null) goto L31;
        r1 = R.id.page_container;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.page_container);
        if (r13 == null) goto L31;
        r1 = R.id.pin;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.pin);
        if (r14 == null) goto L31;
        RelativeLayout r15 = (RelativeLayout) r19;
        r1 = R.id.sim_sub_1;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.sim_sub_1);
        if (r16 == null) goto L31;
        r1 = R.id.sim_sub_2;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.sim_sub_2);
        if (r17 == null) goto L31;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r18 == null) goto L31;
        return new MultiSimSettingsLayoutBinding(r15, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
