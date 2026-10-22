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
public final class EnterprisePrivacySettingsLayoutBinding implements ViewBinding {
    public final OSectionTitleBar deviceAccessSectionTitle;
    public final OSectionTitleBar exposureChangesSectionTitle;
    public final OSectionSupportiveText headerSectionTitle;
    public final OCardListItem itemApps;
    public final OCardListItem itemBugReports;
    public final OCardListItem itemCaCertsPersonal;
    public final OCardListItem itemCaCertsWork;
    public final OCardListItem itemCameraAccess;
    public final OCardListItem itemExposureCategory;
    public final OCardListItem itemFailedPasswordWipeDevice;
    public final OCardListItem itemFailedPasswordWipeWork;
    public final OCardListItem itemGlobalHttpProxy;
    public final OCardListItem itemInputMethod;
    public final OCardListItem itemInstalledPackages;
    public final OCardListItem itemLocationAccess;
    public final OCardListItem itemLockDevice;
    public final OCardListItem itemMicrophoneAccess;
    public final OCardListItem itemNetworkLogs;
    public final OCardListItem itemSecurityLogs;
    public final OCardListItem itemSetDefaultApps;
    public final OCardListItem itemUsageStats;
    public final OCardListItem itemVpnAlwaysOnPersonal;
    public final OCardListItem itemVpnAlwaysOnWork;
    public final OCardListItem itemWipeDevice;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OSectionTitleBar seeMessagesSectionTitle;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EnterprisePrivacySettingsLayoutBinding(RelativeLayout r3, OSectionTitleBar r4, OSectionTitleBar r5, OSectionSupportiveText r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OCardListItem r15, OCardListItem r16, OCardListItem r17, OCardListItem r18, OCardListItem r19, OCardListItem r20, OCardListItem r21, OCardListItem r22, OCardListItem r23, OCardListItem r24, OCardListItem r25, OCardListItem r26, OCardListItem r27, LinearLayout r28, OScrollView r29, OSectionTitleBar r30, OFloatingTitleBar r31) {
        this.rootView = r3;
        this.deviceAccessSectionTitle = r4;
        this.exposureChangesSectionTitle = r5;
        this.headerSectionTitle = r6;
        this.itemApps = r7;
        this.itemBugReports = r8;
        this.itemCaCertsPersonal = r9;
        this.itemCaCertsWork = r10;
        this.itemCameraAccess = r11;
        this.itemExposureCategory = r12;
        this.itemFailedPasswordWipeDevice = r13;
        this.itemFailedPasswordWipeWork = r14;
        this.itemGlobalHttpProxy = r15;
        this.itemInputMethod = r16;
        this.itemInstalledPackages = r17;
        this.itemLocationAccess = r18;
        this.itemLockDevice = r19;
        this.itemMicrophoneAccess = r20;
        this.itemNetworkLogs = r21;
        this.itemSecurityLogs = r22;
        this.itemSetDefaultApps = r23;
        this.itemUsageStats = r24;
        this.itemVpnAlwaysOnPersonal = r25;
        this.itemVpnAlwaysOnWork = r26;
        this.itemWipeDevice = r27;
        this.pageContainer = r28;
        this.pageScrollview = r29;
        this.seeMessagesSectionTitle = r30;
        this.viewTitle = r31;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EnterprisePrivacySettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EnterprisePrivacySettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.enterprise_privacy_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EnterprisePrivacySettingsLayoutBinding bind(View r33) {
        int r1 = R.id.device_access_section_title;
        OSectionTitleBar r5 = (OSectionTitleBar) ViewBindings.findChildViewById(r33, R.id.device_access_section_title);
        if (r5 == null) goto L61;
        r1 = R.id.exposure_changes_section_title;
        OSectionTitleBar r6 = (OSectionTitleBar) ViewBindings.findChildViewById(r33, R.id.exposure_changes_section_title);
        if (r6 == null) goto L61;
        r1 = R.id.header_section_title;
        OSectionSupportiveText r7 = (OSectionSupportiveText) ViewBindings.findChildViewById(r33, R.id.header_section_title);
        if (r7 == null) goto L61;
        r1 = R.id.item_apps;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_apps);
        if (r8 == null) goto L61;
        r1 = R.id.item_bug_reports;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_bug_reports);
        if (r9 == null) goto L61;
        r1 = R.id.item_ca_certs_personal;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_ca_certs_personal);
        if (r10 == null) goto L61;
        r1 = R.id.item_ca_certs_work;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_ca_certs_work);
        if (r11 == null) goto L61;
        r1 = R.id.item_camera_access;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_camera_access);
        if (r12 == null) goto L61;
        r1 = R.id.item_exposure_category;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_exposure_category);
        if (r13 == null) goto L61;
        r1 = R.id.item_failed_password_wipe_device;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_failed_password_wipe_device);
        if (r14 == null) goto L61;
        r1 = R.id.item_failed_password_wipe_work;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_failed_password_wipe_work);
        if (r15 == null) goto L61;
        r1 = R.id.item_global_http_proxy;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_global_http_proxy);
        if (r16 == null) goto L61;
        r1 = R.id.item_input_method;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_input_method);
        if (r17 == null) goto L61;
        r1 = R.id.item_installed_packages;
        OCardListItem r18 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_installed_packages);
        if (r18 == null) goto L61;
        r1 = R.id.item_location_access;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_location_access);
        if (r19 == null) goto L61;
        r1 = R.id.item_lock_device;
        OCardListItem r20 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_lock_device);
        if (r20 == null) goto L61;
        r1 = R.id.item_microphone_access;
        OCardListItem r21 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_microphone_access);
        if (r21 == null) goto L61;
        r1 = R.id.item_network_logs;
        OCardListItem r22 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_network_logs);
        if (r22 == null) goto L61;
        r1 = R.id.item_security_logs;
        OCardListItem r23 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_security_logs);
        if (r23 == null) goto L61;
        r1 = R.id.item_set_default_apps;
        OCardListItem r24 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_set_default_apps);
        if (r24 == null) goto L61;
        r1 = R.id.item_usage_stats;
        OCardListItem r25 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_usage_stats);
        if (r25 == null) goto L61;
        r1 = R.id.item_vpn_always_on_personal;
        OCardListItem r26 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_vpn_always_on_personal);
        if (r26 == null) goto L61;
        r1 = R.id.item_vpn_always_on_work;
        OCardListItem r27 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_vpn_always_on_work);
        if (r27 == null) goto L61;
        r1 = R.id.item_wipe_device;
        OCardListItem r28 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_wipe_device);
        if (r28 == null) goto L61;
        r1 = R.id.page_container;
        LinearLayout r29 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.page_container);
        if (r29 == null) goto L61;
        r1 = R.id.page_scrollview;
        OScrollView r30 = (OScrollView) ViewBindings.findChildViewById(r33, R.id.page_scrollview);
        if (r30 == null) goto L61;
        r1 = R.id.see_messages_section_title;
        OSectionTitleBar r31 = (OSectionTitleBar) ViewBindings.findChildViewById(r33, R.id.see_messages_section_title);
        if (r31 == null) goto L61;
        r1 = R.id.view_title;
        OFloatingTitleBar r32 = (OFloatingTitleBar) ViewBindings.findChildViewById(r33, R.id.view_title);
        if (r32 == null) goto L61;
        return new EnterprisePrivacySettingsLayoutBinding((RelativeLayout) r33, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r33.getResources().getResourceName(r1)));
    }
}
