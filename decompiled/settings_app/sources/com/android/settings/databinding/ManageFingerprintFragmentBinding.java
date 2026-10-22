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
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageFingerprintFragmentBinding implements ViewBinding {
    public final OCardListItem addAiPoweredFpsItem;
    public final OCardListItem addUdfpsItem;
    public final OSectionTitleBar aiPoweredFingerprintOstbText;
    public final LinearLayout aiPoweredFpsContainer;
    public final OSectionSupportiveText aiPoweredFpsTips;
    public final OCardListItem fingerprintAnimationItem;
    public final OCardListItem fingerprintUdfpsDisplayPolicy;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OSectionSupportiveText policyTips;
    private final RelativeLayout rootView;
    public final OCardListItem startAppViaFpItem;
    public final LinearLayout udfpsContainer;
    public final OCardListItem udfpsUnlockScreenEnableItem;
    public final OCardListItem udfpsUnlockScreenTypeItem;
    public final OSectionTitleBar underDisplayFingerprintOstbText;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageFingerprintFragmentBinding(RelativeLayout r3, OCardListItem r4, OCardListItem r5, OSectionTitleBar r6, LinearLayout r7, OSectionSupportiveText r8, OCardListItem r9, OCardListItem r10, LinearLayout r11, OScrollView r12, OSectionSupportiveText r13, OCardListItem r14, LinearLayout r15, OCardListItem r16, OCardListItem r17, OSectionTitleBar r18, OFloatingTitleBar r19) {
        this.rootView = r3;
        this.addAiPoweredFpsItem = r4;
        this.addUdfpsItem = r5;
        this.aiPoweredFingerprintOstbText = r6;
        this.aiPoweredFpsContainer = r7;
        this.aiPoweredFpsTips = r8;
        this.fingerprintAnimationItem = r9;
        this.fingerprintUdfpsDisplayPolicy = r10;
        this.pageContainer = r11;
        this.pageScrollview = r12;
        this.policyTips = r13;
        this.startAppViaFpItem = r14;
        this.udfpsContainer = r15;
        this.udfpsUnlockScreenEnableItem = r16;
        this.udfpsUnlockScreenTypeItem = r17;
        this.underDisplayFingerprintOstbText = r18;
        this.viewTitle = r19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ManageFingerprintFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageFingerprintFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_fingerprint_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageFingerprintFragmentBinding bind(View r21) {
        int r1 = R.id.add_ai_powered_fps_item;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.add_ai_powered_fps_item);
        if (r5 == null) goto L37;
        r1 = R.id.add_udfps_item;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.add_udfps_item);
        if (r6 == null) goto L37;
        r1 = R.id.ai_powered_fingerprint_ostb_text;
        OSectionTitleBar r7 = (OSectionTitleBar) ViewBindings.findChildViewById(r21, R.id.ai_powered_fingerprint_ostb_text);
        if (r7 == null) goto L37;
        r1 = R.id.ai_powered_fps_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.ai_powered_fps_container);
        if (r8 == null) goto L37;
        r1 = R.id.ai_powered_fps_tips;
        OSectionSupportiveText r9 = (OSectionSupportiveText) ViewBindings.findChildViewById(r21, R.id.ai_powered_fps_tips);
        if (r9 == null) goto L37;
        r1 = R.id.fingerprint_animation_item;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.fingerprint_animation_item);
        if (r10 == null) goto L37;
        r1 = R.id.fingerprint_udfps_display_policy;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.fingerprint_udfps_display_policy);
        if (r11 == null) goto L37;
        r1 = R.id.page_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.page_container);
        if (r12 == null) goto L37;
        r1 = R.id.page_scrollview;
        OScrollView r13 = (OScrollView) ViewBindings.findChildViewById(r21, R.id.page_scrollview);
        if (r13 == null) goto L37;
        r1 = R.id.policy_tips;
        OSectionSupportiveText r14 = (OSectionSupportiveText) ViewBindings.findChildViewById(r21, R.id.policy_tips);
        if (r14 == null) goto L37;
        r1 = R.id.start_app_via_fp_item;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.start_app_via_fp_item);
        if (r15 == null) goto L37;
        r1 = R.id.udfps_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.udfps_container);
        if (r16 == null) goto L37;
        r1 = R.id.udfps_unlock_screen_enable_item;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.udfps_unlock_screen_enable_item);
        if (r17 == null) goto L37;
        r1 = R.id.udfps_unlock_screen_type_item;
        OCardListItem r18 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.udfps_unlock_screen_type_item);
        if (r18 == null) goto L37;
        r1 = R.id.under_display_fingerprint_ostb_text;
        OSectionTitleBar r19 = (OSectionTitleBar) ViewBindings.findChildViewById(r21, R.id.under_display_fingerprint_ostb_text);
        if (r19 == null) goto L37;
        r1 = R.id.view_title;
        OFloatingTitleBar r20 = (OFloatingTitleBar) ViewBindings.findChildViewById(r21, R.id.view_title);
        if (r20 == null) goto L37;
        return new ManageFingerprintFragmentBinding((RelativeLayout) r21, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r1)));
    }
}
