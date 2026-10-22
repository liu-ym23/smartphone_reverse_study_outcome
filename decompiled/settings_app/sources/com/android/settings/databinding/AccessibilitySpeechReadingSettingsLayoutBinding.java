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
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilitySpeechReadingSettingsLayoutBinding implements ViewBinding {
    public final TextView globalOcrTipsView;
    public final LinearLayout idAccessibilitySpeakerContainer;
    public final SettingItemSwitch idAccessibilitySpeechReading;
    public final LinearLayout idScreenReaderServicesContainer;
    public final TextView idSpeakerCopyright;
    public final SettingItemText idTriggerAccessibilityReportPunctually;
    public final SettingItemText idTriggerAccessibilitySpeaker;
    public final SettingItemSwitch idTriggerGlobalOcr;
    public final SettingItemText idTriggerTalkBack;
    public final SettingItemText idTriggerVoiceCommand;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final View shadowBelowVoiceCommand;
    public final SettingItemText ttsSettings;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccessibilitySpeechReadingSettingsLayoutBinding(RelativeLayout r3, TextView r4, LinearLayout r5, SettingItemSwitch r6, LinearLayout r7, TextView r8, SettingItemText r9, SettingItemText r10, SettingItemSwitch r11, SettingItemText r12, SettingItemText r13, LinearLayout r14, OScrollView r15, View r16, SettingItemText r17, OFloatingTitleBar r18) {
        this.rootView = r3;
        this.globalOcrTipsView = r4;
        this.idAccessibilitySpeakerContainer = r5;
        this.idAccessibilitySpeechReading = r6;
        this.idScreenReaderServicesContainer = r7;
        this.idSpeakerCopyright = r8;
        this.idTriggerAccessibilityReportPunctually = r9;
        this.idTriggerAccessibilitySpeaker = r10;
        this.idTriggerGlobalOcr = r11;
        this.idTriggerTalkBack = r12;
        this.idTriggerVoiceCommand = r13;
        this.pageContainer = r14;
        this.pageScrollview = r15;
        this.shadowBelowVoiceCommand = r16;
        this.ttsSettings = r17;
        this.viewTitle = r18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AccessibilitySpeechReadingSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccessibilitySpeechReadingSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.accessibility_speech_reading_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccessibilitySpeechReadingSettingsLayoutBinding bind(View r20) {
        int r1 = R.id.global_ocr_tips_view;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r20, R.id.global_ocr_tips_view);
        if (r5 == null) goto L35;
        r1 = R.id.id_accessibility_speaker_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.id_accessibility_speaker_container);
        if (r6 == null) goto L35;
        r1 = R.id.id_accessibility_speech_reading;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.id_accessibility_speech_reading);
        if (r7 == null) goto L35;
        r1 = R.id.id_screen_reader_services_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.id_screen_reader_services_container);
        if (r8 == null) goto L35;
        r1 = R.id.id_speaker_copyright;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r20, R.id.id_speaker_copyright);
        if (r9 == null) goto L35;
        r1 = R.id.id_trigger_accessibility_report_punctually;
        SettingItemText r10 = (SettingItemText) ViewBindings.findChildViewById(r20, R.id.id_trigger_accessibility_report_punctually);
        if (r10 == null) goto L35;
        r1 = R.id.id_trigger_accessibility_speaker;
        SettingItemText r11 = (SettingItemText) ViewBindings.findChildViewById(r20, R.id.id_trigger_accessibility_speaker);
        if (r11 == null) goto L35;
        r1 = R.id.id_trigger_global_ocr;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.id_trigger_global_ocr);
        if (r12 == null) goto L35;
        r1 = R.id.id_trigger_talk_back;
        SettingItemText r13 = (SettingItemText) ViewBindings.findChildViewById(r20, R.id.id_trigger_talk_back);
        if (r13 == null) goto L35;
        r1 = R.id.id_trigger_voice_command;
        SettingItemText r14 = (SettingItemText) ViewBindings.findChildViewById(r20, R.id.id_trigger_voice_command);
        if (r14 == null) goto L35;
        r1 = R.id.page_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.page_container);
        if (r15 == null) goto L35;
        r1 = R.id.page_scrollview;
        OScrollView r16 = (OScrollView) ViewBindings.findChildViewById(r20, R.id.page_scrollview);
        if (r16 == null) goto L35;
        r1 = R.id.shadow_below_voice_command;
        View r17 = ViewBindings.findChildViewById(r20, R.id.shadow_below_voice_command);
        if (r17 == null) goto L35;
        r1 = R.id.tts_settings;
        SettingItemText r18 = (SettingItemText) ViewBindings.findChildViewById(r20, R.id.tts_settings);
        if (r18 == null) goto L35;
        r1 = R.id.view_title;
        OFloatingTitleBar r19 = (OFloatingTitleBar) ViewBindings.findChildViewById(r20, R.id.view_title);
        if (r19 == null) goto L35;
        return new AccessibilitySpeechReadingSettingsLayoutBinding((RelativeLayout) r20, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r20.getResources().getResourceName(r1)));
    }
}
