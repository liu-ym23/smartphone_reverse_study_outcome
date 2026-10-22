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
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LockScreenSettingsLayoutBinding implements ViewBinding {
    public final LinearLayout adsLayout;
    public final LinearLayout biometricsSettingsLayout;
    public final OSectionSupportiveText fingerprintLawTips;
    public final OCardListItem itemAdService;
    public final OCardListItem itemAdvanceSettings;
    public final OCardListItem itemEnrollFaceData;
    public final OCardListItem itemLockScreenPassword;
    public final ItemSubSettingsPaddingLayoutBinding itemOaidShadow;
    public final OCardListItem itemPasswordBook;
    public final OCardListItem itemPrivacyPassword;
    public final TextView itemPrivacyPasswordTips;
    public final OCardListItem itemTrustAgents;
    public final OCardListItem itemWorkProfileUnifiedLock;
    public final OCardListItem itemWorkSettings;
    public final OCardListItem manageFaceData;
    public final OCardListItem manageFingerprint;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final LinearLayout passwordSettingsLayout;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LockScreenSettingsLayoutBinding(RelativeLayout r3, LinearLayout r4, LinearLayout r5, OSectionSupportiveText r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, ItemSubSettingsPaddingLayoutBinding r11, OCardListItem r12, OCardListItem r13, TextView r14, OCardListItem r15, OCardListItem r16, OCardListItem r17, OCardListItem r18, OCardListItem r19, LinearLayout r20, OScrollView r21, LinearLayout r22, OFloatingTitleBar r23) {
        this.rootView = r3;
        this.adsLayout = r4;
        this.biometricsSettingsLayout = r5;
        this.fingerprintLawTips = r6;
        this.itemAdService = r7;
        this.itemAdvanceSettings = r8;
        this.itemEnrollFaceData = r9;
        this.itemLockScreenPassword = r10;
        this.itemOaidShadow = r11;
        this.itemPasswordBook = r12;
        this.itemPrivacyPassword = r13;
        this.itemPrivacyPasswordTips = r14;
        this.itemTrustAgents = r15;
        this.itemWorkProfileUnifiedLock = r16;
        this.itemWorkSettings = r17;
        this.manageFaceData = r18;
        this.manageFingerprint = r19;
        this.pageContainer = r20;
        this.pageScrollview = r21;
        this.passwordSettingsLayout = r22;
        this.viewTitle = r23;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LockScreenSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LockScreenSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.lock_screen_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LockScreenSettingsLayoutBinding bind(View r25) {
        int r1 = R.id.adsLayout;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.adsLayout);
        if (r5 == null) goto L45;
        r1 = R.id.biometrics_settings_layout;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.biometrics_settings_layout);
        if (r6 == null) goto L45;
        r1 = R.id.fingerprint_law_tips;
        OSectionSupportiveText r7 = (OSectionSupportiveText) ViewBindings.findChildViewById(r25, R.id.fingerprint_law_tips);
        if (r7 == null) goto L45;
        r1 = R.id.item_ad_service;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_ad_service);
        if (r8 == null) goto L45;
        r1 = R.id.item_advance_settings;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_advance_settings);
        if (r9 == null) goto L45;
        r1 = R.id.item_enroll_face_data;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_enroll_face_data);
        if (r10 == null) goto L45;
        r1 = R.id.item_lock_screen_password;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_lock_screen_password);
        if (r11 == null) goto L45;
        r1 = R.id.item_oaid_shadow;
        View r2 = ViewBindings.findChildViewById(r25, R.id.item_oaid_shadow);
        if (r2 == null) goto L45;
        ItemSubSettingsPaddingLayoutBinding r12 = ItemSubSettingsPaddingLayoutBinding.bind(r2);
        r1 = R.id.item_password_book;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_password_book);
        if (r13 == null) goto L45;
        r1 = R.id.item_privacy_password;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_privacy_password);
        if (r14 == null) goto L45;
        r1 = R.id.item_privacy_password_tips;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r25, R.id.item_privacy_password_tips);
        if (r15 == null) goto L45;
        r1 = R.id.item_trust_agents;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_trust_agents);
        if (r16 == null) goto L45;
        r1 = R.id.item_work_profile_unified_lock;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_work_profile_unified_lock);
        if (r17 == null) goto L45;
        r1 = R.id.item_work_settings;
        OCardListItem r18 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.item_work_settings);
        if (r18 == null) goto L45;
        r1 = R.id.manage_face_data;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.manage_face_data);
        if (r19 == null) goto L45;
        r1 = R.id.manage_fingerprint;
        OCardListItem r20 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.manage_fingerprint);
        if (r20 == null) goto L45;
        r1 = R.id.page_container;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.page_container);
        if (r21 == null) goto L45;
        r1 = R.id.page_scrollview;
        OScrollView r22 = (OScrollView) ViewBindings.findChildViewById(r25, R.id.page_scrollview);
        if (r22 == null) goto L45;
        r1 = R.id.password_settings_layout;
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.password_settings_layout);
        if (r23 == null) goto L45;
        r1 = R.id.view_title;
        OFloatingTitleBar r24 = (OFloatingTitleBar) ViewBindings.findChildViewById(r25, R.id.view_title);
        if (r24 == null) goto L45;
        return new LockScreenSettingsLayoutBinding((RelativeLayout) r25, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r25.getResources().getResourceName(r1)));
    }
}
