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
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class RejectCallSettingsBinding implements ViewBinding {
    public final SettingItemText allowCalls;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final TextView rejectAllowTips;
    public final SettingItemSwitch rejectCalls;
    public final SettingItemSwitch repeatedCalls;
    public final TextView repeatedCallsTips;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RejectCallSettingsBinding(RelativeLayout r1, SettingItemText r2, LinearLayout r3, OScrollView r4, TextView r5, SettingItemSwitch r6, SettingItemSwitch r7, TextView r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.allowCalls = r2;
        this.pageContainer = r3;
        this.pageScrollview = r4;
        this.rejectAllowTips = r5;
        this.rejectCalls = r6;
        this.repeatedCalls = r7;
        this.repeatedCallsTips = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RejectCallSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RejectCallSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.reject_call_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RejectCallSettingsBinding bind(View r12) {
        int r0 = R.id.allow_calls;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r12, R.id.allow_calls);
        if (r4 == null) goto L21;
        r0 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.page_container);
        if (r5 == null) goto L21;
        r0 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r12, R.id.page_scrollview);
        if (r6 == null) goto L21;
        r0 = R.id.reject_allow_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, R.id.reject_allow_tips);
        if (r7 == null) goto L21;
        r0 = R.id.reject_calls;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r12, R.id.reject_calls);
        if (r8 == null) goto L21;
        r0 = R.id.repeated_calls;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r12, R.id.repeated_calls);
        if (r9 == null) goto L21;
        r0 = R.id.repeated_calls_tips;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, R.id.repeated_calls_tips);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new RejectCallSettingsBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
