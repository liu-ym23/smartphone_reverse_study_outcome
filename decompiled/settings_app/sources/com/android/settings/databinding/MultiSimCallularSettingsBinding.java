package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiSimCallularSettingsBinding implements ViewBinding {
    public final OListItemSettings autoSwitch;
    public final TextView autoSwitchTips;
    public final TextView defaultSimTitle;
    private final LinearLayout rootView;
    public final ImageView simGuide;
    public final OListItemSettings sub1;
    public final OListItemSettings sub2;
    public final TextView tipsForChooseDataCard;
    public final TextView tipsForItemCheck;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MultiSimCallularSettingsBinding(LinearLayout r1, OListItemSettings r2, TextView r3, TextView r4, ImageView r5, OListItemSettings r6, OListItemSettings r7, TextView r8, TextView r9) {
        this.rootView = r1;
        this.autoSwitch = r2;
        this.autoSwitchTips = r3;
        this.defaultSimTitle = r4;
        this.simGuide = r5;
        this.sub1 = r6;
        this.sub2 = r7;
        this.tipsForChooseDataCard = r8;
        this.tipsForItemCheck = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MultiSimCallularSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MultiSimCallularSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.multi_sim_callular_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MultiSimCallularSettingsBinding bind(View r12) {
        int r0 = R.id.auto_switch;
        OListItemSettings r4 = (OListItemSettings) ViewBindings.findChildViewById(r12, R.id.auto_switch);
        if (r4 == null) goto L21;
        r0 = R.id.auto_switch_tips;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, R.id.auto_switch_tips);
        if (r5 == null) goto L21;
        r0 = R.id.default_sim_title;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r12, R.id.default_sim_title);
        if (r6 == null) goto L21;
        r0 = R.id.sim_guide;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r12, R.id.sim_guide);
        if (r7 == null) goto L21;
        r0 = R.id.sub_1;
        OListItemSettings r8 = (OListItemSettings) ViewBindings.findChildViewById(r12, R.id.sub_1);
        if (r8 == null) goto L21;
        r0 = R.id.sub_2;
        OListItemSettings r9 = (OListItemSettings) ViewBindings.findChildViewById(r12, R.id.sub_2);
        if (r9 == null) goto L21;
        r0 = R.id.tips_for_choose_data_card;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, R.id.tips_for_choose_data_card);
        if (r10 == null) goto L21;
        r0 = R.id.tips_for_item_check;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r12, R.id.tips_for_item_check);
        if (r11 == null) goto L21;
        return new MultiSimCallularSettingsBinding((LinearLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
