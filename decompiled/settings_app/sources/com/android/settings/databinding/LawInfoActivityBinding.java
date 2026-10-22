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
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LawInfoActivityBinding implements ViewBinding {
    public final LinearLayout itemGoogle;
    public final OCardListItem itemGoogleLegalInfo;
    public final OCardListItem itemLegalNotice;
    public final OCardListItem itemNationLicense;
    public final OCardListItem itemOpenSourceLicense;
    public final OCardListItem itemPrivacyPolicy;
    public final OCardListItem itemSafetyInformation;
    public final OCardListItem itemSettingsAppOpenSource;
    public final OCardListItem itemSettingsAppOtherLaw;
    public final OCardListItem itemSettingsOpenSource;
    public final OCardListItem itemSettingsPrivacyPolicy;
    public final OCardListItem itemUserLicense;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OSectionSupportiveText tvLawModel;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LawInfoActivityBinding(RelativeLayout r3, LinearLayout r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OCardListItem r15, LinearLayout r16, OScrollView r17, OSectionSupportiveText r18, OFloatingTitleBar r19) {
        this.rootView = r3;
        this.itemGoogle = r4;
        this.itemGoogleLegalInfo = r5;
        this.itemLegalNotice = r6;
        this.itemNationLicense = r7;
        this.itemOpenSourceLicense = r8;
        this.itemPrivacyPolicy = r9;
        this.itemSafetyInformation = r10;
        this.itemSettingsAppOpenSource = r11;
        this.itemSettingsAppOtherLaw = r12;
        this.itemSettingsOpenSource = r13;
        this.itemSettingsPrivacyPolicy = r14;
        this.itemUserLicense = r15;
        this.pageContainer = r16;
        this.pageScrollview = r17;
        this.tvLawModel = r18;
        this.viewTitle = r19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LawInfoActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LawInfoActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.law_info_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LawInfoActivityBinding bind(View r21) {
        int r1 = R.id.item_google;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.item_google);
        if (r5 == null) goto L37;
        r1 = R.id.item_google_legal_info;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_google_legal_info);
        if (r6 == null) goto L37;
        r1 = R.id.item_legal_notice;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_legal_notice);
        if (r7 == null) goto L37;
        r1 = R.id.item_nation_license;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_nation_license);
        if (r8 == null) goto L37;
        r1 = R.id.item_open_source_license;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_open_source_license);
        if (r9 == null) goto L37;
        r1 = R.id.item_privacy_policy;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_privacy_policy);
        if (r10 == null) goto L37;
        r1 = R.id.item_safety_information;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_safety_information);
        if (r11 == null) goto L37;
        r1 = R.id.item_settings_app_open_source;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_settings_app_open_source);
        if (r12 == null) goto L37;
        r1 = R.id.item_settings_app_other_law;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_settings_app_other_law);
        if (r13 == null) goto L37;
        r1 = R.id.item_settings_open_source;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_settings_open_source);
        if (r14 == null) goto L37;
        r1 = R.id.item_settings_privacy_policy;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_settings_privacy_policy);
        if (r15 == null) goto L37;
        r1 = R.id.item_user_license;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_user_license);
        if (r16 == null) goto L37;
        r1 = R.id.page_container;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.page_container);
        if (r17 == null) goto L37;
        r1 = R.id.page_scrollview;
        OScrollView r18 = (OScrollView) ViewBindings.findChildViewById(r21, R.id.page_scrollview);
        if (r18 == null) goto L37;
        r1 = R.id.tv_law_model;
        OSectionSupportiveText r19 = (OSectionSupportiveText) ViewBindings.findChildViewById(r21, R.id.tv_law_model);
        if (r19 == null) goto L37;
        r1 = R.id.view_title;
        OFloatingTitleBar r20 = (OFloatingTitleBar) ViewBindings.findChildViewById(r21, R.id.view_title);
        if (r20 == null) goto L37;
        return new LawInfoActivityBinding((RelativeLayout) r21, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r1)));
    }
}
