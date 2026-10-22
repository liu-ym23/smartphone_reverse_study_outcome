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
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class InstalledAppDetailsBinding implements ViewBinding {
    public final ManageApplicationsItemBinding appSnippet;
    public final OCardListItem askCompatibilityCb;
    public final OSectionSupportiveText autoLaunch;
    public final OCardListItem clearActivitiesButton;
    public final TextView ctsAllServicesItem;
    public final TextView ctsServicesSummaryItem;
    public final OCardListItem enableCompatibilityCb;
    public final FrameLayout frameLayout;
    public final OCardListItem idBatteryManager;
    public final OCardListItem idDataUsageItem;
    public final OCardListItem idNotificationItem;
    public final OCardListItem idPermManager;
    public final OCardListItem idStorageItem;
    public final LinearLayout itemContainer;
    public final OCardListItem notificationSwitch;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final LinearLayout permissionsSection;
    private final RelativeLayout rootView;
    public final LinearLayout screenCompatibilitySection;
    public final LinearLayout securitySection;
    public final TextView securitySettingsBillingDesc;
    public final LinearLayout securitySettingsBillingList;
    public final TextView securitySettingsDesc;
    public final LinearLayout securitySettingsList;
    public final OCardListItem securitySettingsPremiumSmsList;
    public final OButton specialDisableButton;
    public final OCardListItem unusedAppsSwitch;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private InstalledAppDetailsBinding(RelativeLayout r3, ManageApplicationsItemBinding r4, OCardListItem r5, OSectionSupportiveText r6, OCardListItem r7, TextView r8, TextView r9, OCardListItem r10, FrameLayout r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OCardListItem r15, OCardListItem r16, LinearLayout r17, OCardListItem r18, LinearLayout r19, OScrollView r20, LinearLayout r21, LinearLayout r22, LinearLayout r23, TextView r24, LinearLayout r25, TextView r26, LinearLayout r27, OCardListItem r28, OButton r29, OCardListItem r30, OFloatingTitleBar r31) {
        this.rootView = r3;
        this.appSnippet = r4;
        this.askCompatibilityCb = r5;
        this.autoLaunch = r6;
        this.clearActivitiesButton = r7;
        this.ctsAllServicesItem = r8;
        this.ctsServicesSummaryItem = r9;
        this.enableCompatibilityCb = r10;
        this.frameLayout = r11;
        this.idBatteryManager = r12;
        this.idDataUsageItem = r13;
        this.idNotificationItem = r14;
        this.idPermManager = r15;
        this.idStorageItem = r16;
        this.itemContainer = r17;
        this.notificationSwitch = r18;
        this.pageContainer = r19;
        this.pageScrollview = r20;
        this.permissionsSection = r21;
        this.screenCompatibilitySection = r22;
        this.securitySection = r23;
        this.securitySettingsBillingDesc = r24;
        this.securitySettingsBillingList = r25;
        this.securitySettingsDesc = r26;
        this.securitySettingsList = r27;
        this.securitySettingsPremiumSmsList = r28;
        this.specialDisableButton = r29;
        this.unusedAppsSwitch = r30;
        this.viewTitle = r31;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static InstalledAppDetailsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static InstalledAppDetailsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.installed_app_details, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static InstalledAppDetailsBinding bind(View r33) {
        int r1 = R.id.app_snippet;
        View r2 = ViewBindings.findChildViewById(r33, R.id.app_snippet);
        if (r2 == null) goto L61;
        ManageApplicationsItemBinding r5 = ManageApplicationsItemBinding.bind(r2);
        r1 = R.id.ask_compatibility_cb;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.ask_compatibility_cb);
        if (r6 == null) goto L61;
        r1 = R.id.auto_launch;
        OSectionSupportiveText r7 = (OSectionSupportiveText) ViewBindings.findChildViewById(r33, R.id.auto_launch);
        if (r7 == null) goto L61;
        r1 = R.id.clear_activities_button;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.clear_activities_button);
        if (r8 == null) goto L61;
        r1 = R.id.cts_all_services_item;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r33, R.id.cts_all_services_item);
        if (r9 == null) goto L61;
        r1 = R.id.cts_services_summary_item;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r33, R.id.cts_services_summary_item);
        if (r10 == null) goto L61;
        r1 = R.id.enable_compatibility_cb;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.enable_compatibility_cb);
        if (r11 == null) goto L61;
        r1 = R.id.frame_layout;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r33, R.id.frame_layout);
        if (r12 == null) goto L61;
        r1 = R.id.id_battery_manager;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.id_battery_manager);
        if (r13 == null) goto L61;
        r1 = R.id.id_data_usage_item;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.id_data_usage_item);
        if (r14 == null) goto L61;
        r1 = R.id.id_notification_item;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.id_notification_item);
        if (r15 == null) goto L61;
        r1 = R.id.id_perm_manager;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.id_perm_manager);
        if (r16 == null) goto L61;
        r1 = R.id.id_storage_item;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.id_storage_item);
        if (r17 == null) goto L61;
        r1 = R.id.item_container;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.item_container);
        if (r18 == null) goto L61;
        r1 = R.id.notification_switch;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.notification_switch);
        if (r19 == null) goto L61;
        r1 = R.id.page_container;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.page_container);
        if (r20 == null) goto L61;
        r1 = R.id.page_scrollview;
        OScrollView r21 = (OScrollView) ViewBindings.findChildViewById(r33, R.id.page_scrollview);
        if (r21 == null) goto L61;
        r1 = R.id.permissions_section;
        LinearLayout r22 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.permissions_section);
        if (r22 == null) goto L61;
        r1 = R.id.screen_compatibility_section;
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.screen_compatibility_section);
        if (r23 == null) goto L61;
        r1 = R.id.security_section;
        LinearLayout r24 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.security_section);
        if (r24 == null) goto L61;
        r1 = R.id.security_settings_billing_desc;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r33, R.id.security_settings_billing_desc);
        if (r25 == null) goto L61;
        r1 = R.id.security_settings_billing_list;
        LinearLayout r26 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.security_settings_billing_list);
        if (r26 == null) goto L61;
        r1 = R.id.security_settings_desc;
        TextView r27 = (TextView) ViewBindings.findChildViewById(r33, R.id.security_settings_desc);
        if (r27 == null) goto L61;
        r1 = R.id.security_settings_list;
        LinearLayout r28 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.security_settings_list);
        if (r28 == null) goto L61;
        r1 = R.id.security_settings_premium_sms_list;
        OCardListItem r29 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.security_settings_premium_sms_list);
        if (r29 == null) goto L61;
        r1 = R.id.special_disable_button;
        OButton r30 = (OButton) ViewBindings.findChildViewById(r33, R.id.special_disable_button);
        if (r30 == null) goto L61;
        r1 = R.id.unused_apps_switch;
        OCardListItem r31 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.unused_apps_switch);
        if (r31 == null) goto L61;
        r1 = R.id.view_title;
        OFloatingTitleBar r32 = (OFloatingTitleBar) ViewBindings.findChildViewById(r33, R.id.view_title);
        if (r32 == null) goto L61;
        return new InstalledAppDetailsBinding((RelativeLayout) r33, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r33.getResources().getResourceName(r1)));
    }
}
