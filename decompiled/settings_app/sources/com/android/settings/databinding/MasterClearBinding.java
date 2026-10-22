package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class MasterClearBinding implements ViewBinding {
    public final OSectionSupportiveText batteryLowerTips;
    public final FrameLayout btnLayout;
    public final OTextView deviceOwnerDisableTips;
    public final OButton initiateMasterClear;
    public final OSectionSupportiveText masterClearWarningTips;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;
    public final TextView workPolicyInfoText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MasterClearBinding(RelativeLayout r1, OSectionSupportiveText r2, FrameLayout r3, OTextView r4, OButton r5, OSectionSupportiveText r6, LinearLayout r7, OScrollView r8, OFloatingTitleBar r9, TextView r10) {
        this.rootView = r1;
        this.batteryLowerTips = r2;
        this.btnLayout = r3;
        this.deviceOwnerDisableTips = r4;
        this.initiateMasterClear = r5;
        this.masterClearWarningTips = r6;
        this.pageContainer = r7;
        this.pageScrollview = r8;
        this.viewTitle = r9;
        this.workPolicyInfoText = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MasterClearBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MasterClearBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.master_clear, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MasterClearBinding bind(View r13) {
        int r0 = R.id.battery_lower_tips;
        OSectionSupportiveText r4 = (OSectionSupportiveText) ViewBindings.findChildViewById(r13, R.id.battery_lower_tips);
        if (r4 == null) goto L23;
        r0 = R.id.btnLayout;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r13, R.id.btnLayout);
        if (r5 == null) goto L23;
        r0 = R.id.device_owner_disable_tips;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r13, R.id.device_owner_disable_tips);
        if (r6 == null) goto L23;
        r0 = R.id.initiate_master_clear;
        OButton r7 = (OButton) ViewBindings.findChildViewById(r13, R.id.initiate_master_clear);
        if (r7 == null) goto L23;
        r0 = R.id.master_clear_warning_tips;
        OSectionSupportiveText r8 = (OSectionSupportiveText) ViewBindings.findChildViewById(r13, R.id.master_clear_warning_tips);
        if (r8 == null) goto L23;
        r0 = R.id.page_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_container);
        if (r9 == null) goto L23;
        r0 = R.id.page_scrollview;
        OScrollView r10 = (OScrollView) ViewBindings.findChildViewById(r13, R.id.page_scrollview);
        if (r10 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r11 == null) goto L23;
        r0 = R.id.work_policy_info_text;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r13, R.id.work_policy_info_text);
        if (r12 == null) goto L23;
        return new MasterClearBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
