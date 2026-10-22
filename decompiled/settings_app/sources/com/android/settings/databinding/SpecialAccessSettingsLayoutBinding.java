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
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SpecialAccessSettingsLayoutBinding implements ViewBinding {
    public final OCardListItem alarmsAndReminders;
    public final OCardListItem changeNfcTagAppsState;
    public final OCardListItem changeWifiState;
    public final OCardListItem dataSaver;
    public final OCardListItem deviceAdministrators;
    public final OCardListItem enabledVrListeners;
    public final OCardListItem interactAcrossProfiles;
    public final OCardListItem manageExternalSources;
    public final OCardListItem manageExternalStorage;
    public final OCardListItem mediaManagementApps;
    public final OCardListItem mediaRoutingControl;
    public final OCardListItem notificationAccess;
    public final OScrollView permissionContainer;
    public final LinearLayout permissionList;
    public final OCardListItem pictureInPicture;
    public final OCardListItem premiumSms;
    private final RelativeLayout rootView;
    public final OCardListItem specialAppUsageAccess;
    public final OCardListItem systemAlertWindowAppList;
    public final OCardListItem turnScreenOn;
    public final OCardListItem useFullScreenIntent;
    public final OFloatingTitleBar viewTitle;
    public final OCardListItem writeSettingsApps;
    public final OCardListItem zenAccess;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SpecialAccessSettingsLayoutBinding(RelativeLayout r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OCardListItem r15, OScrollView r16, LinearLayout r17, OCardListItem r18, OCardListItem r19, OCardListItem r20, OCardListItem r21, OCardListItem r22, OCardListItem r23, OFloatingTitleBar r24, OCardListItem r25, OCardListItem r26) {
        this.rootView = r3;
        this.alarmsAndReminders = r4;
        this.changeNfcTagAppsState = r5;
        this.changeWifiState = r6;
        this.dataSaver = r7;
        this.deviceAdministrators = r8;
        this.enabledVrListeners = r9;
        this.interactAcrossProfiles = r10;
        this.manageExternalSources = r11;
        this.manageExternalStorage = r12;
        this.mediaManagementApps = r13;
        this.mediaRoutingControl = r14;
        this.notificationAccess = r15;
        this.permissionContainer = r16;
        this.permissionList = r17;
        this.pictureInPicture = r18;
        this.premiumSms = r19;
        this.specialAppUsageAccess = r20;
        this.systemAlertWindowAppList = r21;
        this.turnScreenOn = r22;
        this.useFullScreenIntent = r23;
        this.viewTitle = r24;
        this.writeSettingsApps = r25;
        this.zenAccess = r26;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SpecialAccessSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SpecialAccessSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.special_access_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SpecialAccessSettingsLayoutBinding bind(View r28) {
        int r1 = R.id.alarms_and_reminders;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.alarms_and_reminders);
        if (r5 == null) goto L51;
        r1 = R.id.change_nfc_tag_apps_state;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.change_nfc_tag_apps_state);
        if (r6 == null) goto L51;
        r1 = R.id.change_wifi_state;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.change_wifi_state);
        if (r7 == null) goto L51;
        r1 = R.id.data_saver;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.data_saver);
        if (r8 == null) goto L51;
        r1 = R.id.device_administrators;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.device_administrators);
        if (r9 == null) goto L51;
        r1 = R.id.enabled_vr_listeners;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.enabled_vr_listeners);
        if (r10 == null) goto L51;
        r1 = R.id.interact_across_profiles;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.interact_across_profiles);
        if (r11 == null) goto L51;
        r1 = R.id.manage_external_sources;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.manage_external_sources);
        if (r12 == null) goto L51;
        r1 = R.id.manage_external_storage;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.manage_external_storage);
        if (r13 == null) goto L51;
        r1 = R.id.media_management_apps;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.media_management_apps);
        if (r14 == null) goto L51;
        r1 = R.id.media_routing_control;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.media_routing_control);
        if (r15 == null) goto L51;
        r1 = R.id.notification_access;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.notification_access);
        if (r16 == null) goto L51;
        r1 = R.id.permission_container;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r28, R.id.permission_container);
        if (r17 == null) goto L51;
        r1 = R.id.permission_list;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r28, R.id.permission_list);
        if (r18 == null) goto L51;
        r1 = R.id.picture_in_picture;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.picture_in_picture);
        if (r19 == null) goto L51;
        r1 = R.id.premium_sms;
        OCardListItem r20 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.premium_sms);
        if (r20 == null) goto L51;
        r1 = R.id.special_app_usage_access;
        OCardListItem r21 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.special_app_usage_access);
        if (r21 == null) goto L51;
        r1 = R.id.system_alert_window_app_list;
        OCardListItem r22 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.system_alert_window_app_list);
        if (r22 == null) goto L51;
        r1 = R.id.turn_screen_on;
        OCardListItem r23 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.turn_screen_on);
        if (r23 == null) goto L51;
        r1 = R.id.use_full_screen_intent;
        OCardListItem r24 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.use_full_screen_intent);
        if (r24 == null) goto L51;
        r1 = R.id.view_title;
        OFloatingTitleBar r25 = (OFloatingTitleBar) ViewBindings.findChildViewById(r28, R.id.view_title);
        if (r25 == null) goto L51;
        r1 = R.id.write_settings_apps;
        OCardListItem r26 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.write_settings_apps);
        if (r26 == null) goto L51;
        r1 = R.id.zen_access;
        OCardListItem r27 = (OCardListItem) ViewBindings.findChildViewById(r28, R.id.zen_access);
        if (r27 == null) goto L51;
        return new SpecialAccessSettingsLayoutBinding((RelativeLayout) r28, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(r28.getResources().getResourceName(r1)));
    }
}
