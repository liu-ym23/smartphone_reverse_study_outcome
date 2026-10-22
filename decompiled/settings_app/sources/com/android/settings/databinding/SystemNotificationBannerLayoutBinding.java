package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class SystemNotificationBannerLayoutBinding implements ViewBinding {
    public final SettingItemSwitch bluetoothTransportSwitch;
    public final SettingItemSwitch callMissedSwitch;
    public final SettingItemSwitch contactImportAndExportSwitch;
    public final SettingItemSwitch debugModeSwitch;
    public final SettingItemSwitch drivingModeSwitch;
    public final SettingItemSwitch eyeProtectionModePlanSwitch;
    public final SettingItemSwitch gameSpeedUpSwitch;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final SettingItemSwitch personalHotspotSwitch;
    public final SettingItemSwitch pictureInPictureSwitch;
    public final SettingItemSwitch positioningSwitch;
    public final SettingItemSwitch printerSwitch;
    public final SettingItemSwitch readingModeSwitch;
    private final RelativeLayout rootView;
    public final SettingItemSwitch screenLightSwitch;
    public final SettingItemSwitch screenRecordingSwitch;
    public final SettingItemSwitch simCardUnavailableSwitch;
    public final SettingItemSwitch storageFullSwitch;
    public final TextView systemNotificationTips;
    public final SettingItemSwitch tntModeSwitch;
    public final SettingItemSwitch uploadDownloadSwitch;
    public final SettingItemSwitch usbDeviceConnectionSwitch;
    public final View videoBackground;
    public final ImageView videoDefault;
    public final FrameLayout videoLayout;
    public final VideoView videoView;
    public final OFloatingTitleBar viewTitle;
    public final SettingItemSwitch virtualMemorySwitch;
    public final SettingItemSwitch virtualTouchPadSwitch;
    public final SettingItemSwitch voiceMailboxSwitch;
    public final SettingItemSwitch vpnSwitch;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SystemNotificationBannerLayoutBinding(RelativeLayout r3, SettingItemSwitch r4, SettingItemSwitch r5, SettingItemSwitch r6, SettingItemSwitch r7, SettingItemSwitch r8, SettingItemSwitch r9, SettingItemSwitch r10, LinearLayout r11, OScrollView r12, SettingItemSwitch r13, SettingItemSwitch r14, SettingItemSwitch r15, SettingItemSwitch r16, SettingItemSwitch r17, SettingItemSwitch r18, SettingItemSwitch r19, SettingItemSwitch r20, SettingItemSwitch r21, TextView r22, SettingItemSwitch r23, SettingItemSwitch r24, SettingItemSwitch r25, View r26, ImageView r27, FrameLayout r28, VideoView r29, OFloatingTitleBar r30, SettingItemSwitch r31, SettingItemSwitch r32, SettingItemSwitch r33, SettingItemSwitch r34) {
        this.rootView = r3;
        this.bluetoothTransportSwitch = r4;
        this.callMissedSwitch = r5;
        this.contactImportAndExportSwitch = r6;
        this.debugModeSwitch = r7;
        this.drivingModeSwitch = r8;
        this.eyeProtectionModePlanSwitch = r9;
        this.gameSpeedUpSwitch = r10;
        this.pageContainer = r11;
        this.pageScrollview = r12;
        this.personalHotspotSwitch = r13;
        this.pictureInPictureSwitch = r14;
        this.positioningSwitch = r15;
        this.printerSwitch = r16;
        this.readingModeSwitch = r17;
        this.screenLightSwitch = r18;
        this.screenRecordingSwitch = r19;
        this.simCardUnavailableSwitch = r20;
        this.storageFullSwitch = r21;
        this.systemNotificationTips = r22;
        this.tntModeSwitch = r23;
        this.uploadDownloadSwitch = r24;
        this.usbDeviceConnectionSwitch = r25;
        this.videoBackground = r26;
        this.videoDefault = r27;
        this.videoLayout = r28;
        this.videoView = r29;
        this.viewTitle = r30;
        this.virtualMemorySwitch = r31;
        this.virtualTouchPadSwitch = r32;
        this.voiceMailboxSwitch = r33;
        this.vpnSwitch = r34;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SystemNotificationBannerLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SystemNotificationBannerLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.system_notification_banner_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SystemNotificationBannerLayoutBinding bind(View r36) {
        int r1 = R.id.bluetooth_transport_switch;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.bluetooth_transport_switch);
        if (r5 == null) goto L67;
        r1 = R.id.call_missed_switch;
        SettingItemSwitch r6 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.call_missed_switch);
        if (r6 == null) goto L67;
        r1 = R.id.contact_import_and_export_switch;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.contact_import_and_export_switch);
        if (r7 == null) goto L67;
        r1 = R.id.debug_mode_switch;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.debug_mode_switch);
        if (r8 == null) goto L67;
        r1 = R.id.driving_mode_switch;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.driving_mode_switch);
        if (r9 == null) goto L67;
        r1 = R.id.eye_protection_mode_plan_switch;
        SettingItemSwitch r10 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.eye_protection_mode_plan_switch);
        if (r10 == null) goto L67;
        r1 = R.id.game_speed_up_switch;
        SettingItemSwitch r11 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.game_speed_up_switch);
        if (r11 == null) goto L67;
        r1 = R.id.page_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r36, R.id.page_container);
        if (r12 == null) goto L67;
        r1 = R.id.page_scrollview;
        OScrollView r13 = (OScrollView) ViewBindings.findChildViewById(r36, R.id.page_scrollview);
        if (r13 == null) goto L67;
        r1 = R.id.personal_hotspot_switch;
        SettingItemSwitch r14 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.personal_hotspot_switch);
        if (r14 == null) goto L67;
        r1 = R.id.picture_in_picture_switch;
        SettingItemSwitch r15 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.picture_in_picture_switch);
        if (r15 == null) goto L67;
        r1 = R.id.positioning_switch;
        SettingItemSwitch r16 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.positioning_switch);
        if (r16 == null) goto L67;
        r1 = R.id.printer_switch;
        SettingItemSwitch r17 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.printer_switch);
        if (r17 == null) goto L67;
        r1 = R.id.reading_mode_switch;
        SettingItemSwitch r18 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.reading_mode_switch);
        if (r18 == null) goto L67;
        r1 = R.id.screen_light_switch;
        SettingItemSwitch r19 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.screen_light_switch);
        if (r19 == null) goto L67;
        r1 = R.id.screen_recording_switch;
        SettingItemSwitch r20 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.screen_recording_switch);
        if (r20 == null) goto L67;
        r1 = R.id.sim_card_unavailable_switch;
        SettingItemSwitch r21 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.sim_card_unavailable_switch);
        if (r21 == null) goto L67;
        r1 = R.id.storage_full_switch;
        SettingItemSwitch r22 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.storage_full_switch);
        if (r22 == null) goto L67;
        r1 = R.id.system_notification_tips;
        TextView r23 = (TextView) ViewBindings.findChildViewById(r36, R.id.system_notification_tips);
        if (r23 == null) goto L67;
        r1 = R.id.tnt_mode_switch;
        SettingItemSwitch r24 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.tnt_mode_switch);
        if (r24 == null) goto L67;
        r1 = R.id.upload_download_switch;
        SettingItemSwitch r25 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.upload_download_switch);
        if (r25 == null) goto L67;
        r1 = R.id.usb_device_connection_switch;
        SettingItemSwitch r26 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.usb_device_connection_switch);
        if (r26 == null) goto L67;
        r1 = R.id.video_background;
        View r27 = ViewBindings.findChildViewById(r36, R.id.video_background);
        if (r27 == null) goto L67;
        r1 = R.id.video_default;
        ImageView r28 = (ImageView) ViewBindings.findChildViewById(r36, R.id.video_default);
        if (r28 == null) goto L67;
        r1 = R.id.video_layout;
        FrameLayout r29 = (FrameLayout) ViewBindings.findChildViewById(r36, R.id.video_layout);
        if (r29 == null) goto L67;
        r1 = R.id.video_view;
        VideoView r30 = (VideoView) ViewBindings.findChildViewById(r36, R.id.video_view);
        if (r30 == null) goto L67;
        r1 = R.id.view_title;
        OFloatingTitleBar r31 = (OFloatingTitleBar) ViewBindings.findChildViewById(r36, R.id.view_title);
        if (r31 == null) goto L67;
        r1 = R.id.virtual_memory_switch;
        SettingItemSwitch r32 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.virtual_memory_switch);
        if (r32 == null) goto L67;
        r1 = R.id.virtual_touch_pad_switch;
        SettingItemSwitch r33 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.virtual_touch_pad_switch);
        if (r33 == null) goto L67;
        r1 = R.id.voice_mailbox_switch;
        SettingItemSwitch r34 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.voice_mailbox_switch);
        if (r34 == null) goto L67;
        r1 = R.id.vpn_switch;
        SettingItemSwitch r35 = (SettingItemSwitch) ViewBindings.findChildViewById(r36, R.id.vpn_switch);
        if (r35 == null) goto L67;
        return new SystemNotificationBannerLayoutBinding((RelativeLayout) r36, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
    L67:
        throw new NullPointerException("Missing required view with ID: ".concat(r36.getResources().getResourceName(r1)));
    }
}
