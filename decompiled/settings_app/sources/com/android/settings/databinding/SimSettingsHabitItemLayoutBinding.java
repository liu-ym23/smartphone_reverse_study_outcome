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

/* JADX INFO: loaded from: classes2.dex */
public final class SimSettingsHabitItemLayoutBinding implements ViewBinding {
    public final ImageView ivSimSettingDialPad;
    public final ImageView ivSimSettingSms;
    public final TextView labelOfDialPad;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SimSettingsHabitItemLayoutBinding(LinearLayout r1, ImageView r2, ImageView r3, TextView r4) {
        this.rootView = r1;
        this.ivSimSettingDialPad = r2;
        this.ivSimSettingSms = r3;
        this.labelOfDialPad = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SimSettingsHabitItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SimSettingsHabitItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sim_settings_habit_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SimSettingsHabitItemLayoutBinding bind(View r4) {
        int r0 = R.id.iv_sim_setting_dial_pad;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.iv_sim_setting_dial_pad);
        if (r1 == null) goto L11;
        r0 = R.id.iv_sim_setting_sms;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.iv_sim_setting_sms);
        if (r2 == null) goto L11;
        r0 = R.id.label_of_dial_pad;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.label_of_dial_pad);
        if (r3 == null) goto L11;
        return new SimSettingsHabitItemLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
