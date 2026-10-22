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
public final class AdvancedSettingsLayoutBinding implements ViewBinding {
    public final OCardListItem accessibilitySettings;
    public final OCardListItem dateTimeSettings;
    public final OCardListItem eldershipMode;
    public final LinearLayout groupContainer;
    public final OCardListItem idScreenRotation;
    public final OCardListItem imeSettings;
    public final OCardListItem itemAccount;
    public final OCardListItem itemAssisant;
    public final OCardListItem itemBackup;
    public final OCardListItem itemCameraLocation;
    public final OCardListItem itemDataTransfer;
    public final OCardListItem itemDevelopment;
    public final OCardListItem itemGoogleSettings;
    public final OCardListItem itemLedBrightness;
    public final OCardListItem itemNotificationCustom;
    public final OCardListItem itemRestore;
    public final OCardListItem itemStorage;
    public final OCardListItem itemThirdParty;
    public final OCardListItem itemUser;
    public final OCardListItem itemZteBackup;
    public final OCardListItem navbarSettings;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem searchSettings;
    public final OCardListItem swapAiAndPowerKey;
    public final ScrollviewBottomGapLayoutBinding swapAiAndPowerKeyBottomGap;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AdvancedSettingsLayoutBinding(RelativeLayout r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, LinearLayout r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OCardListItem r15, OCardListItem r16, OCardListItem r17, OCardListItem r18, OCardListItem r19, OCardListItem r20, OCardListItem r21, OCardListItem r22, OCardListItem r23, OCardListItem r24, LinearLayout r25, OScrollView r26, OCardListItem r27, OCardListItem r28, ScrollviewBottomGapLayoutBinding r29, OFloatingTitleBar r30) {
        this.rootView = r3;
        this.accessibilitySettings = r4;
        this.dateTimeSettings = r5;
        this.eldershipMode = r6;
        this.groupContainer = r7;
        this.idScreenRotation = r8;
        this.imeSettings = r9;
        this.itemAccount = r10;
        this.itemAssisant = r11;
        this.itemBackup = r12;
        this.itemCameraLocation = r13;
        this.itemDataTransfer = r14;
        this.itemDevelopment = r15;
        this.itemGoogleSettings = r16;
        this.itemLedBrightness = r17;
        this.itemNotificationCustom = r18;
        this.itemRestore = r19;
        this.itemStorage = r20;
        this.itemThirdParty = r21;
        this.itemUser = r22;
        this.itemZteBackup = r23;
        this.navbarSettings = r24;
        this.pageContainer = r25;
        this.pageScrollview = r26;
        this.searchSettings = r27;
        this.swapAiAndPowerKey = r28;
        this.swapAiAndPowerKeyBottomGap = r29;
        this.viewTitle = r30;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AdvancedSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AdvancedSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.advanced_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AdvancedSettingsLayoutBinding bind(View r32) {
        int r1 = R.id.accessibility_settings;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.accessibility_settings);
        if (r5 == null) goto L59;
        r1 = R.id.date_time_settings;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.date_time_settings);
        if (r6 == null) goto L59;
        r1 = R.id.eldership_mode;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.eldership_mode);
        if (r7 == null) goto L59;
        r1 = R.id.group_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r32, R.id.group_container);
        if (r8 == null) goto L59;
        r1 = R.id.id_screen_rotation;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.id_screen_rotation);
        if (r9 == null) goto L59;
        r1 = R.id.ime_settings;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.ime_settings);
        if (r10 == null) goto L59;
        r1 = R.id.item_account;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_account);
        if (r11 == null) goto L59;
        r1 = R.id.item_assisant;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_assisant);
        if (r12 == null) goto L59;
        r1 = R.id.item_backup;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_backup);
        if (r13 == null) goto L59;
        r1 = R.id.item_camera_location;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_camera_location);
        if (r14 == null) goto L59;
        r1 = R.id.item_data_transfer;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_data_transfer);
        if (r15 == null) goto L59;
        r1 = R.id.item_development;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_development);
        if (r16 == null) goto L59;
        r1 = R.id.item_google_settings;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_google_settings);
        if (r17 == null) goto L59;
        r1 = R.id.item_led_brightness;
        OCardListItem r18 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_led_brightness);
        if (r18 == null) goto L59;
        r1 = R.id.item_notification_custom;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_notification_custom);
        if (r19 == null) goto L59;
        r1 = R.id.item_restore;
        OCardListItem r20 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_restore);
        if (r20 == null) goto L59;
        r1 = R.id.item_storage;
        OCardListItem r21 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_storage);
        if (r21 == null) goto L59;
        r1 = R.id.item_third_party;
        OCardListItem r22 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_third_party);
        if (r22 == null) goto L59;
        r1 = R.id.item_user;
        OCardListItem r23 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_user);
        if (r23 == null) goto L59;
        r1 = R.id.item_zte_backup;
        OCardListItem r24 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.item_zte_backup);
        if (r24 == null) goto L59;
        r1 = R.id.navbar_settings;
        OCardListItem r25 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.navbar_settings);
        if (r25 == null) goto L59;
        r1 = R.id.page_container;
        LinearLayout r26 = (LinearLayout) ViewBindings.findChildViewById(r32, R.id.page_container);
        if (r26 == null) goto L59;
        r1 = R.id.page_scrollview;
        OScrollView r27 = (OScrollView) ViewBindings.findChildViewById(r32, R.id.page_scrollview);
        if (r27 == null) goto L59;
        r1 = R.id.search_settings;
        OCardListItem r28 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.search_settings);
        if (r28 == null) goto L59;
        r1 = R.id.swap_ai_and_power_key;
        OCardListItem r29 = (OCardListItem) ViewBindings.findChildViewById(r32, R.id.swap_ai_and_power_key);
        if (r29 == null) goto L59;
        r1 = R.id.swap_ai_and_power_key_bottom_gap;
        View r2 = ViewBindings.findChildViewById(r32, R.id.swap_ai_and_power_key_bottom_gap);
        if (r2 == null) goto L59;
        ScrollviewBottomGapLayoutBinding r30 = ScrollviewBottomGapLayoutBinding.bind(r2);
        r1 = R.id.view_title;
        OFloatingTitleBar r31 = (OFloatingTitleBar) ViewBindings.findChildViewById(r32, R.id.view_title);
        if (r31 == null) goto L59;
        return new AdvancedSettingsLayoutBinding((RelativeLayout) r32, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
    L59:
        throw new NullPointerException("Missing required view with ID: ".concat(r32.getResources().getResourceName(r1)));
    }
}
