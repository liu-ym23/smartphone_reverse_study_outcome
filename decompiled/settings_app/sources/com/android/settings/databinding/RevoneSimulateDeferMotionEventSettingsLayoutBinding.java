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
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneSimulateDeferMotionEventSettingsLayoutBinding implements ViewBinding {
    public final OButton confirmed2;
    public final SettingItemText delayDuration;
    public final TextView delayTips;
    public final LinearLayout delayValueContainer;
    public final SettingItemText maxDelay;
    public final SettingItemText minDelay;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneSimulateDeferMotionEventSettingsLayoutBinding(RelativeLayout r1, OButton r2, SettingItemText r3, TextView r4, LinearLayout r5, SettingItemText r6, SettingItemText r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.confirmed2 = r2;
        this.delayDuration = r3;
        this.delayTips = r4;
        this.delayValueContainer = r5;
        this.maxDelay = r6;
        this.minDelay = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneSimulateDeferMotionEventSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneSimulateDeferMotionEventSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_simulate_defer_motion_event_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneSimulateDeferMotionEventSettingsLayoutBinding bind(View r11) {
        int r0 = R.id.confirmed2;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r11, R.id.confirmed2);
        if (r4 == null) goto L19;
        r0 = R.id.delay_duration;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.delay_duration);
        if (r5 == null) goto L19;
        r0 = R.id.delay_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, R.id.delay_tips);
        if (r6 == null) goto L19;
        r0 = R.id.delay_value_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.delay_value_container);
        if (r7 == null) goto L19;
        r0 = R.id.max_delay;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.max_delay);
        if (r8 == null) goto L19;
        r0 = R.id.min_delay;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.min_delay);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new RevoneSimulateDeferMotionEventSettingsLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
