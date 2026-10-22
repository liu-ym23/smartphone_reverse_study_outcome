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
import com.android.settings.revone.TNTSoundSettingsFragment;
import com.android.settings.widget.VolumeSeekBar;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class TntSoundSettingsLayoutBinding implements ViewBinding {
    public final SettingItemCheck itemIdDeviceCheck;
    public final TextView itemIdMicrophonePickupMode;
    public final SettingItemCheck itemIdMultiPickupMode;
    public final SettingItemCheck itemIdOutputDeviceCheck;
    public final TextView itemIdOutputDeviceTip;
    public final SettingItemCheck itemIdSinglePickupMode;
    public final LinearLayout microphonePickupModeContainer;
    public final SettingItemSwitch muteEnableSwitch;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final TNTSoundSettingsFragment.SoundDeviceListView soundDevices;
    public final VolumeSeekBar systemVolumeSeekBar;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TntSoundSettingsLayoutBinding(RelativeLayout r1, SettingItemCheck r2, TextView r3, SettingItemCheck r4, SettingItemCheck r5, TextView r6, SettingItemCheck r7, LinearLayout r8, SettingItemSwitch r9, LinearLayout r10, OScrollView r11, TNTSoundSettingsFragment.SoundDeviceListView r12, VolumeSeekBar r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.itemIdDeviceCheck = r2;
        this.itemIdMicrophonePickupMode = r3;
        this.itemIdMultiPickupMode = r4;
        this.itemIdOutputDeviceCheck = r5;
        this.itemIdOutputDeviceTip = r6;
        this.itemIdSinglePickupMode = r7;
        this.microphonePickupModeContainer = r8;
        this.muteEnableSwitch = r9;
        this.pageContainer = r10;
        this.pageScrollview = r11;
        this.soundDevices = r12;
        this.systemVolumeSeekBar = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TntSoundSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TntSoundSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tnt_sound_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TntSoundSettingsLayoutBinding bind(View r18) {
        int r1 = R.id.item_id_device_check;
        SettingItemCheck r5 = (SettingItemCheck) ViewBindings.findChildViewById(r18, R.id.item_id_device_check);
        if (r5 == null) goto L31;
        r1 = R.id.item_id_microphone_pickup_mode;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r18, R.id.item_id_microphone_pickup_mode);
        if (r6 == null) goto L31;
        r1 = R.id.item_id_multi_pickup_mode;
        SettingItemCheck r7 = (SettingItemCheck) ViewBindings.findChildViewById(r18, R.id.item_id_multi_pickup_mode);
        if (r7 == null) goto L31;
        r1 = R.id.item_id_output_device_check;
        SettingItemCheck r8 = (SettingItemCheck) ViewBindings.findChildViewById(r18, R.id.item_id_output_device_check);
        if (r8 == null) goto L31;
        r1 = R.id.item_id_output_device_tip;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r18, R.id.item_id_output_device_tip);
        if (r9 == null) goto L31;
        r1 = R.id.item_id_single_pickup_mode;
        SettingItemCheck r10 = (SettingItemCheck) ViewBindings.findChildViewById(r18, R.id.item_id_single_pickup_mode);
        if (r10 == null) goto L31;
        r1 = R.id.microphone_pickup_mode_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.microphone_pickup_mode_container);
        if (r11 == null) goto L31;
        r1 = R.id.mute_enable_switch;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r18, R.id.mute_enable_switch);
        if (r12 == null) goto L31;
        r1 = R.id.page_container;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.page_container);
        if (r13 == null) goto L31;
        r1 = R.id.page_scrollview;
        OScrollView r14 = (OScrollView) ViewBindings.findChildViewById(r18, R.id.page_scrollview);
        if (r14 == null) goto L31;
        r1 = R.id.sound_devices;
        TNTSoundSettingsFragment.SoundDeviceListView r15 = (TNTSoundSettingsFragment.SoundDeviceListView) ViewBindings.findChildViewById(r18, R.id.sound_devices);
        if (r15 == null) goto L31;
        r1 = R.id.system_volume_seek_bar;
        VolumeSeekBar r16 = (VolumeSeekBar) ViewBindings.findChildViewById(r18, R.id.system_volume_seek_bar);
        if (r16 == null) goto L31;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L31;
        return new TntSoundSettingsLayoutBinding((RelativeLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
