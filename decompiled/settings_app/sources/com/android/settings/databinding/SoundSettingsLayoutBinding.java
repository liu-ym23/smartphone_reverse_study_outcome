package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.VolumeSeekBar;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SoundSettingsLayoutBinding implements ViewBinding {
    public final VolumeSeekBar assistantVolume;
    public final FrameLayout banner;
    public final VolumeSeekBar clockVolume;
    public final OUILinearLayout doubaoVolumeBarContainer;
    public final OCardListItem doubaoVolumeBarDisplaySwitch;
    public final OCardListItem dtsSoundEffectItem;
    public final OCardListItem hapticFeedback;
    public final OCardListItem inputMethodHapticFeedback;
    public final OCardListItem itemIdAlarmRing;
    public final OCardListItem itemIdNotificationRing;
    public final OCardListItem itemIdPhoneRing;
    public final OCardListItem itemIdPhoneRingSub2;
    public final OCardListItem itemIdSmsRing;
    public final OCardListItem itemIdSmsRingSub2;
    public final OCardListItem itemNoDisturb;
    public final VolumeSeekBar mediaVolume;
    public final OTextView notificationTips;
    public final VolumeSeekBar notificationVolume;
    public final OCardListItem otherAlertTone;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final VolumeSeekBar ringtoneVolume;
    private final RelativeLayout rootView;
    public final OCardListItem soundWorkSettingsItem;
    public final OCardListItem vibrateOnRing;
    public final OCardListItem vibrationIntensity;
    public final OFloatingTitleBar viewTitle;
    public final OCardListItem volumeButtonDefaultControlItem;
    public final OUILinearLayout volumeContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SoundSettingsLayoutBinding(RelativeLayout r3, VolumeSeekBar r4, FrameLayout r5, VolumeSeekBar r6, OUILinearLayout r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OCardListItem r15, OCardListItem r16, OCardListItem r17, OCardListItem r18, VolumeSeekBar r19, OTextView r20, VolumeSeekBar r21, OCardListItem r22, LinearLayout r23, OScrollView r24, VolumeSeekBar r25, OCardListItem r26, OCardListItem r27, OCardListItem r28, OFloatingTitleBar r29, OCardListItem r30, OUILinearLayout r31) {
        this.rootView = r3;
        this.assistantVolume = r4;
        this.banner = r5;
        this.clockVolume = r6;
        this.doubaoVolumeBarContainer = r7;
        this.doubaoVolumeBarDisplaySwitch = r8;
        this.dtsSoundEffectItem = r9;
        this.hapticFeedback = r10;
        this.inputMethodHapticFeedback = r11;
        this.itemIdAlarmRing = r12;
        this.itemIdNotificationRing = r13;
        this.itemIdPhoneRing = r14;
        this.itemIdPhoneRingSub2 = r15;
        this.itemIdSmsRing = r16;
        this.itemIdSmsRingSub2 = r17;
        this.itemNoDisturb = r18;
        this.mediaVolume = r19;
        this.notificationTips = r20;
        this.notificationVolume = r21;
        this.otherAlertTone = r22;
        this.pageContainer = r23;
        this.pageScrollview = r24;
        this.ringtoneVolume = r25;
        this.soundWorkSettingsItem = r26;
        this.vibrateOnRing = r27;
        this.vibrationIntensity = r28;
        this.viewTitle = r29;
        this.volumeButtonDefaultControlItem = r30;
        this.volumeContainer = r31;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SoundSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SoundSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sound_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SoundSettingsLayoutBinding bind(View r33) {
        int r1 = R.id.assistant_volume;
        VolumeSeekBar r5 = (VolumeSeekBar) ViewBindings.findChildViewById(r33, R.id.assistant_volume);
        if (r5 == null) goto L61;
        r1 = R.id.banner;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r33, R.id.banner);
        if (r6 == null) goto L61;
        r1 = R.id.clock_volume;
        VolumeSeekBar r7 = (VolumeSeekBar) ViewBindings.findChildViewById(r33, R.id.clock_volume);
        if (r7 == null) goto L61;
        r1 = R.id.doubao_volume_bar_container;
        OUILinearLayout r8 = (OUILinearLayout) ViewBindings.findChildViewById(r33, R.id.doubao_volume_bar_container);
        if (r8 == null) goto L61;
        r1 = R.id.doubao_volume_bar_display_switch;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.doubao_volume_bar_display_switch);
        if (r9 == null) goto L61;
        r1 = R.id.dts_sound_effect_item;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.dts_sound_effect_item);
        if (r10 == null) goto L61;
        r1 = R.id.haptic_feedback;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.haptic_feedback);
        if (r11 == null) goto L61;
        r1 = R.id.input_method_haptic_feedback;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.input_method_haptic_feedback);
        if (r12 == null) goto L61;
        r1 = R.id.item_id_alarm_ring;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_id_alarm_ring);
        if (r13 == null) goto L61;
        r1 = R.id.item_id_notification_ring;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_id_notification_ring);
        if (r14 == null) goto L61;
        r1 = R.id.item_id_phone_ring;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_id_phone_ring);
        if (r15 == null) goto L61;
        r1 = R.id.item_id_phone_ring_sub2;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_id_phone_ring_sub2);
        if (r16 == null) goto L61;
        r1 = R.id.item_id_sms_ring;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_id_sms_ring);
        if (r17 == null) goto L61;
        r1 = R.id.item_id_sms_ring_sub2;
        OCardListItem r18 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_id_sms_ring_sub2);
        if (r18 == null) goto L61;
        r1 = R.id.item_noDisturb;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_noDisturb);
        if (r19 == null) goto L61;
        r1 = R.id.media_volume;
        VolumeSeekBar r20 = (VolumeSeekBar) ViewBindings.findChildViewById(r33, R.id.media_volume);
        if (r20 == null) goto L61;
        r1 = R.id.notification_tips;
        OTextView r21 = (OTextView) ViewBindings.findChildViewById(r33, R.id.notification_tips);
        if (r21 == null) goto L61;
        r1 = R.id.notification_volume;
        VolumeSeekBar r22 = (VolumeSeekBar) ViewBindings.findChildViewById(r33, R.id.notification_volume);
        if (r22 == null) goto L61;
        r1 = R.id.other_alert_tone;
        OCardListItem r23 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.other_alert_tone);
        if (r23 == null) goto L61;
        r1 = R.id.page_container;
        LinearLayout r24 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.page_container);
        if (r24 == null) goto L61;
        r1 = R.id.page_scrollview;
        OScrollView r25 = (OScrollView) ViewBindings.findChildViewById(r33, R.id.page_scrollview);
        if (r25 == null) goto L61;
        r1 = R.id.ringtone_volume;
        VolumeSeekBar r26 = (VolumeSeekBar) ViewBindings.findChildViewById(r33, R.id.ringtone_volume);
        if (r26 == null) goto L61;
        r1 = R.id.sound_work_settings_item;
        OCardListItem r27 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.sound_work_settings_item);
        if (r27 == null) goto L61;
        r1 = R.id.vibrate_on_ring;
        OCardListItem r28 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.vibrate_on_ring);
        if (r28 == null) goto L61;
        r1 = R.id.vibration_intensity;
        OCardListItem r29 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.vibration_intensity);
        if (r29 == null) goto L61;
        r1 = R.id.view_title;
        OFloatingTitleBar r30 = (OFloatingTitleBar) ViewBindings.findChildViewById(r33, R.id.view_title);
        if (r30 == null) goto L61;
        r1 = R.id.volume_button_default_control_item;
        OCardListItem r31 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.volume_button_default_control_item);
        if (r31 == null) goto L61;
        r1 = R.id.volume_container;
        OUILinearLayout r32 = (OUILinearLayout) ViewBindings.findChildViewById(r33, R.id.volume_container);
        if (r32 == null) goto L61;
        return new SoundSettingsLayoutBinding((RelativeLayout) r33, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r33.getResources().getResourceName(r1)));
    }
}
