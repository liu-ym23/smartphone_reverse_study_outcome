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
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class GlobalAssistantLayoutBinding implements ViewBinding {
    public final OListItemSettings assistantAutoRecognitionLabel;
    public final OListItemSettings assistantRecordVoiceKeyphrase;
    public final OListItemSettings assistantSelectModelTypeKey;
    public final OListItemSettings assistantVoiceWakeup;
    public final OListItemSettings assistantVoiceprintRecognition;
    public final TextView assistantVoiceprintRecognitionTips;
    public final OListItemSettings assistantVoiceprintWakeup;
    public final OListItemSettings chooseBotIdKey;
    public final ListContentItemSwitch doubleClickWakeup;
    public final TextView doubleClickWakeupTips;
    public final ListContentItemText faceEyeWakeup;
    public final ListContentItemSwitch fingerprintWakeupKey;
    public final TextView fingerprintWakeupKeyTips;
    public final OListItemSettings idleExitKey;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OListItemSettings playPreference;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private GlobalAssistantLayoutBinding(RelativeLayout r3, OListItemSettings r4, OListItemSettings r5, OListItemSettings r6, OListItemSettings r7, OListItemSettings r8, TextView r9, OListItemSettings r10, OListItemSettings r11, ListContentItemSwitch r12, TextView r13, ListContentItemText r14, ListContentItemSwitch r15, TextView r16, OListItemSettings r17, LinearLayout r18, OScrollView r19, OListItemSettings r20, OFloatingTitleBar r21) {
        this.rootView = r3;
        this.assistantAutoRecognitionLabel = r4;
        this.assistantRecordVoiceKeyphrase = r5;
        this.assistantSelectModelTypeKey = r6;
        this.assistantVoiceWakeup = r7;
        this.assistantVoiceprintRecognition = r8;
        this.assistantVoiceprintRecognitionTips = r9;
        this.assistantVoiceprintWakeup = r10;
        this.chooseBotIdKey = r11;
        this.doubleClickWakeup = r12;
        this.doubleClickWakeupTips = r13;
        this.faceEyeWakeup = r14;
        this.fingerprintWakeupKey = r15;
        this.fingerprintWakeupKeyTips = r16;
        this.idleExitKey = r17;
        this.pageContainer = r18;
        this.pageScrollview = r19;
        this.playPreference = r20;
        this.viewTitle = r21;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static GlobalAssistantLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static GlobalAssistantLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.global_assistant_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static GlobalAssistantLayoutBinding bind(View r23) {
        int r1 = R.id.assistant_auto_recognition_label;
        OListItemSettings r5 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.assistant_auto_recognition_label);
        if (r5 == null) goto L41;
        r1 = R.id.assistant_record_voice_keyphrase;
        OListItemSettings r6 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.assistant_record_voice_keyphrase);
        if (r6 == null) goto L41;
        r1 = R.id.assistant_select_model_type_key;
        OListItemSettings r7 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.assistant_select_model_type_key);
        if (r7 == null) goto L41;
        r1 = R.id.assistant_voice_wakeup;
        OListItemSettings r8 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.assistant_voice_wakeup);
        if (r8 == null) goto L41;
        r1 = R.id.assistant_voiceprint_recognition;
        OListItemSettings r9 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.assistant_voiceprint_recognition);
        if (r9 == null) goto L41;
        r1 = R.id.assistant_voiceprint_recognition_tips;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r23, R.id.assistant_voiceprint_recognition_tips);
        if (r10 == null) goto L41;
        r1 = R.id.assistant_voiceprint_wakeup;
        OListItemSettings r11 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.assistant_voiceprint_wakeup);
        if (r11 == null) goto L41;
        r1 = R.id.choose_bot_id_key;
        OListItemSettings r12 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.choose_bot_id_key);
        if (r12 == null) goto L41;
        r1 = R.id.double_click_wakeup;
        ListContentItemSwitch r13 = (ListContentItemSwitch) ViewBindings.findChildViewById(r23, R.id.double_click_wakeup);
        if (r13 == null) goto L41;
        r1 = R.id.double_click_wakeup_tips;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r23, R.id.double_click_wakeup_tips);
        if (r14 == null) goto L41;
        r1 = R.id.face_eye_wakeup;
        ListContentItemText r15 = (ListContentItemText) ViewBindings.findChildViewById(r23, R.id.face_eye_wakeup);
        if (r15 == null) goto L41;
        r1 = R.id.fingerprint_wakeup_key;
        ListContentItemSwitch r16 = (ListContentItemSwitch) ViewBindings.findChildViewById(r23, R.id.fingerprint_wakeup_key);
        if (r16 == null) goto L41;
        r1 = R.id.fingerprint_wakeup_key_tips;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r23, R.id.fingerprint_wakeup_key_tips);
        if (r17 == null) goto L41;
        r1 = R.id.idle_exit_key;
        OListItemSettings r18 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.idle_exit_key);
        if (r18 == null) goto L41;
        r1 = R.id.page_container;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r23, R.id.page_container);
        if (r19 == null) goto L41;
        r1 = R.id.page_scrollview;
        OScrollView r20 = (OScrollView) ViewBindings.findChildViewById(r23, R.id.page_scrollview);
        if (r20 == null) goto L41;
        r1 = R.id.play_preference;
        OListItemSettings r21 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.play_preference);
        if (r21 == null) goto L41;
        r1 = R.id.view_title;
        OFloatingTitleBar r22 = (OFloatingTitleBar) ViewBindings.findChildViewById(r23, R.id.view_title);
        if (r22 == null) goto L41;
        return new GlobalAssistantLayoutBinding((RelativeLayout) r23, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r23.getResources().getResourceName(r1)));
    }
}
