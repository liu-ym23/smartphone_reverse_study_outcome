package com.android.settings.intelligent;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.voice.VoiceInteractionServiceInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.app.AssistUtils;
import com.android.settings.OptionsInfo;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class GlobalAssistantFragment extends BaseFragment implements Serializable, View.OnClickListener, CompoundButton.OnCheckedChangeListener, VoiceWakeupManager.WakeupChangeListener, VoicePrintRecognitionManager.VoicePrintRecognitionChangeListener {
    public static final String ASSISTANT_AUTO_RECOGNITION_LABEL = "assistant_auto_recognition_label";
    public static final String ASSISTANT_IDLE_TIME = "assistant_idle_time";
    public static final String ASSISTANT_SMART_MEMORY_ENABLED = "com.obric.assistant.memoryProduction.enabled";
    public static final String ASSISTANT_VOICE_PLAY_PREFERENCE = "voice_assistant_play_preference";
    public static final String ASSISTANT_WAKEUP_METHOD = "camera_always_on";
    public static final String DOUBLECLICK_ENABLE_ASSIST_ON = "doubleclick_enable_assist_on";
    public static final String FINGERPRINT_WAKEUP_KEY = "fingerprint_wakeup";
    public static final String THE_SETTINGSPROVIDER_KEY = "obric_assistant_select_model_type";
    private OListItemSettings mAutoRecognitionLabel;
    private OSwitch mAutoRecognitionLabelSwitch;
    private String[] mBotIdMap;
    private String[] mBotList;
    private String[] mBotListValue;
    private OListItemSettings mChooseBotId;
    private String mDefaultBotId;
    private int mDefaultBotIdIndex;
    private OAlertDialog mDialog;
    private ListContentItemSwitch mDoubleClickWakeUp;
    private TextView mDoubleClickWakeUpTips;
    private ListContentItemText mFaceEyeWakeUp;
    private String[] mFaceEyeWakeUpEntries;
    private String[] mFaceEyeWakeUpValues;
    private ListContentItemSwitch mFingerprintWakeUp;
    private TextView mFingerprintWakeUpTips;
    private OListItemSettings mIdleExit;
    private String[] mIdleTimeEntries;
    private String[] mIdleTimeValues;
    private OListItemSettings mPlayPreference;
    private String[] mPlayPreferenceEntries;
    private String[] mPlayPreferenceTipEntries;
    private String[] mPlayPreferenceValues;
    private OListItemSettings mRecordVoicePrint;
    private OListItemSettings mSelectModel;
    private String[] mSelectModelEntries;
    private String[] mSelectModelValues;
    private ContentObserver mVoiceAssistantWakeupObserver;
    private TextView mVoicePrintRecogintionTips;
    private VoicePrintRecognitionManager mVoicePrintRecognitionManager;
    private OListItemSettings mVoiceWakeUp;
    private OSwitch mVoiceWakeUpSwitch;
    private VoiceWakeupManager mVoiceWakeupManager;
    private OListItemSettings mVoiceprintRecognition;
    private OSwitch mVoiceprintRecognitionSwitch;
    private OListItemSettings mVoiceprintWakeup;
    private OSwitch mVoiceprintWakeupSwitch;

    private String intToString(int r1) {
        if (r1 != 0) goto L6;
        return "large";
    L6:
        if (r1 != 1) goto L10;
        return "bert-nlu";
    L10:
        if (r1 != 2) goto L14;
        return "chatglm2-6b";
    L14:
        if (r1 != 3) goto L17;
        return "bert-nlu_offline";
    L17:
        return "chatglm3-6b";
    }

    @Override // com.android.settings.intelligent.VoicePrintRecognitionManager.VoicePrintRecognitionChangeListener
    public void OnAssistantWakeUpMethodChanged(boolean r1) {
    }

    public void com_android_settings_intelligent_GlobalAssistantFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_intelligent_GlobalAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_intelligent_GlobalAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ boolean access$000(GlobalAssistantFragment r0) {
        return r0.isWakeUpChecked();
    }

    static /* synthetic */ OSwitch access$100(GlobalAssistantFragment r0) {
        return r0.mVoiceWakeUpSwitch;
    }

    public GlobalAssistantFragment() {
        super(R.layout.global_assistant_layout);
        this.mDefaultBotIdIndex = -1;
        final Handler r1 = null;
        this.mVoiceAssistantWakeupObserver = new AnonymousClass1(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment
    public void initViews(View r4, Bundle r5) {
        super.initViews(r4, r5);
        VoiceWakeupManager r6 = VoiceWakeupManager.getInstance(this.mContext);
        this.mVoiceWakeupManager = r6;
        r6.addListener(this);
        VoicePrintRecognitionManager r7 = new VoicePrintRecognitionManager(getActivity());
        this.mVoicePrintRecognitionManager = r7;
        r7.addListener(this);
        OListItemSettings r8 = (OListItemSettings) findViewByIdNullable(R.id.assistant_record_voice_keyphrase);
        this.mRecordVoicePrint = r8;
        r8.setOnClickListener(this);
        updateRecordVoicePrintButton();
        this.mVoiceWakeUp = (OListItemSettings) findViewByIdNullable(R.id.assistant_voice_wakeup);
        OSwitch r9 = new OSwitch(this.mContext);
        this.mVoiceWakeUpSwitch = r9;
        r9.setClickable(true);
        this.mVoiceWakeUpSwitch.setChecked(isWakeUpChecked());
        this.mVoiceWakeUpSwitch.setOnCheckedChangeListener(this);
        this.mVoiceWakeUp.setTrailingView(this.mVoiceWakeUpSwitch);
        this.mVoiceprintWakeup = (OListItemSettings) findViewByIdNullable(R.id.assistant_voiceprint_wakeup);
        OSwitch r10 = new OSwitch(this.mContext);
        this.mVoiceprintWakeupSwitch = r10;
        r10.setClickable(true);
        this.mVoiceprintWakeupSwitch.setChecked(isWakeupVoicePrintChecked());
        this.mVoiceprintWakeupSwitch.setOnCheckedChangeListener(this);
        this.mVoiceprintWakeup.setTrailingView(this.mVoiceprintWakeupSwitch);
        OListItemSettings r11 = this.mVoiceprintWakeup;
        int r1 = 0;
        if (hasRecordVoicePrint() == true) goto L5;
    L7:
        int r0 = 8;
    L8:
        r11.setVisibility(r0);
        this.mVoiceprintRecognition = (OListItemSettings) findViewByIdNullable(R.id.assistant_voiceprint_recognition);
        OSwitch r12 = new OSwitch(this.mContext);
        this.mVoiceprintRecognitionSwitch = r12;
        r12.setClickable(true);
        this.mVoiceprintRecognitionSwitch.setChecked(isPvadVoicePrintChecked());
        this.mVoiceprintRecognitionSwitch.setOnCheckedChangeListener(this);
        this.mVoiceprintRecognition.setTrailingView(this.mVoiceprintRecognitionSwitch);
        OListItemSettings r13 = this.mVoiceprintRecognition;
        if (hasRecordVoicePrint() == false) goto L11;
        int r2 = 0;
    L12:
        r13.setVisibility(r2);
        this.mVoicePrintRecogintionTips = (TextView) findViewByIdNullable(R.id.assistant_voiceprint_recognition_tips);
        if (hasRecordVoicePrint() == false) goto L15;
    L20:
        boolean r14 = true;
    L21:
        TextView r3 = this.mVoicePrintRecogintionTips;
        if (r14 == true) goto L25;
        r1 = 8;
    L25:
        r3.setVisibility(r1);
        this.mAutoRecognitionLabel = (OListItemSettings) findViewByIdNullable(R.id.assistant_auto_recognition_label);
        OSwitch r15 = new OSwitch(this.mContext);
        this.mAutoRecognitionLabelSwitch = r15;
        r15.setClickable(true);
        this.mAutoRecognitionLabelSwitch.setChecked(isAutoRecognitionLabelChecked());
        this.mAutoRecognitionLabelSwitch.setOnCheckedChangeListener(this);
        this.mAutoRecognitionLabel.setTrailingView(this.mAutoRecognitionLabelSwitch);
        this.mAutoRecognitionLabel.setVisibility(8);
        ListContentItemText r16 = (ListContentItemText) findViewByIdNullable(R.id.face_eye_wakeup);
        this.mFaceEyeWakeUp = r16;
        r16.setOnClickListener(this);
        this.mFaceEyeWakeUpValues = getResources().getStringArray(R.array.face_eye_wakeup_values);
        this.mFaceEyeWakeUpEntries = getResources().getStringArray(R.array.face_eye_wakeup_entries);
        this.mFaceEyeWakeUp.setVisibility(8);
        ListContentItemSwitch r17 = (ListContentItemSwitch) findViewByIdNullable(R.id.double_click_wakeup);
        this.mDoubleClickWakeUp = r17;
        r17.setOnCheckedChangeListener(this);
        this.mDoubleClickWakeUp.setChecked(isDoubleClickWakeUpChecked());
        this.mDoubleClickWakeUp.setVisibility(8);
        TextView r18 = (TextView) findViewByIdNullable(R.id.double_click_wakeup_tips);
        this.mDoubleClickWakeUpTips = r18;
        r18.setVisibility(8);
        ListContentItemSwitch r19 = (ListContentItemSwitch) findViewByIdNullable(R.id.fingerprint_wakeup_key);
        this.mFingerprintWakeUp = r19;
        r19.setOnCheckedChangeListener(this);
        this.mFingerprintWakeUp.setChecked(isFingerprintWakeUpChecked());
        this.mFingerprintWakeUp.setVisibility(8);
        TextView r20 = (TextView) findViewByIdNullable(R.id.fingerprint_wakeup_key_tips);
        this.mFingerprintWakeUpTips = r20;
        r20.setVisibility(8);
        OListItemSettings r21 = (OListItemSettings) findViewByIdNullable(R.id.assistant_select_model_type_key);
        this.mSelectModel = r21;
        r21.setOnClickListener(this);
        this.mSelectModelValues = getResources().getStringArray(R.array.assistant_select_model_type_values);
        this.mSelectModelEntries = getResources().getStringArray(R.array.assistant_select_model_type_entries);
        this.mSelectModel.setVisibility(8);
        OListItemSettings r22 = (OListItemSettings) findViewByIdNullable(R.id.idle_exit_key);
        this.mIdleExit = r22;
        r22.setOnClickListener(this);
        this.mIdleTimeValues = getResources().getStringArray(R.array.assistant_idle_time_values);
        this.mIdleTimeEntries = getResources().getStringArray(R.array.assistant_idle_time_entries);
        OListItemSettings r23 = (OListItemSettings) findViewByIdNullable(R.id.choose_bot_id_key);
        this.mChooseBotId = r23;
        r23.setOnClickListener(this);
        OListItemSettings r24 = (OListItemSettings) findViewByIdNullable(R.id.play_preference);
        this.mPlayPreference = r24;
        r24.setOnClickListener(this);
        this.mPlayPreferenceValues = getResources().getStringArray(R.array.assistant_voice_play_preference_values);
        this.mPlayPreferenceEntries = getResources().getStringArray(R.array.assistant_voice_play_preference_entries);
        this.mPlayPreferenceTipEntries = getResources().getStringArray(R.array.assistant_voice_play_preference_tip_entries);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewByIdNullable(R.id.page_container));
        return;
    L15:
        if (hasRecordVoicePrint() == true) goto L17;
    L19:
        r14 = false;
        goto L21
    L17:
        if (isWakeUpChecked() == false) goto L19;
    L11:
        r2 = 8;
        goto L12
    L5:
        if (isWakeUpChecked() == false) goto L7;
        r0 = 0;
        goto L8
    }

    private void updateRecordVoicePrintButton() {
        if (((UiModeManager) getContext().getSystemService("uimode")).getNightMode() != 2) goto L5;
        boolean r0 = true;
    L7:
        if (hasRecordVoicePrint() == false) goto L13;
        this.mRecordVoicePrint.setTitleString(getResources().getString(R.string.assistant_reset_voice_keyphrase));
        this.mRecordVoicePrint.setSubTitleString("");
        if (r0 == true) goto L11;
        this.mRecordVoicePrint.getMTvTitle().setTextColor(getResources().getColor(R.color.record_voice_print_highlight));
    L12:
        this.mRecordVoicePrint.setTrailingImage(new ColorDrawable(getResources().getColor(R.color.transparent)));
        return;
    L11:
        this.mRecordVoicePrint.getMTvTitle().setTextColor(getResources().getColor(R.color.record_voice_print_highlight_night));
        goto L12
    L13:
        this.mRecordVoicePrint.setTitleString(getResources().getString(R.string.assistant_record_voice_print));
        this.mRecordVoicePrint.setSubTitleString(getResources().getString(R.string.assistant_record_voice_print_summary));
        if (r0 == true) goto L16;
        this.mRecordVoicePrint.getMTvTitle().setTextColor(getResources().getColor(R.color.black_80));
    L17:
        this.mRecordVoicePrint.setTrailingImage(getContext().getDrawable(R.drawable.ic_arrow_forward_list_item));
        return;
    L16:
        this.mRecordVoicePrint.getMTvTitle().setTextColor(getResources().getColor(R.color.white_90));
        goto L17
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updateUI();
    }

    private void registerContentObserver() {
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(VoiceWakeupManager.VOICE_ASSISTANT_WAKEUP_STATUS), true, this.mVoiceAssistantWakeupObserver);
    }

    private void unregisterContentObserver() {
        getContentResolver().unregisterContentObserver(this.mVoiceAssistantWakeupObserver);
    }

    private boolean hasRecordVoicePrint() {
        return this.mVoicePrintRecognitionManager.hasRecordVoicePrint();
    }

    private boolean isWakeUpChecked() {
        if (1 == Settings.Global.getInt(this.mContext.getContentResolver(), VoiceWakeupManager.VOICE_ASSISTANT_WAKEUP_STATUS, 1)) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isWakeupVoicePrintChecked() {
        boolean r0 = hasRecordVoicePrint();
        boolean r1 = this.mVoicePrintRecognitionManager.getWakeupVoicePrintState();
        OLog.d(this.TAG, "isWakeupVoicePrintChecked  voiceprint : " + r0 + " wakeupsid:" + r1);
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isPvadVoicePrintChecked() {
        boolean r0 = hasRecordVoicePrint();
        boolean r1 = this.mVoicePrintRecognitionManager.getSpeechVoicePrintState();
        OLog.d(this.TAG, "isPvadVoicePrintChecked  voiceprint : " + r0 + " speech:" + r1);
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isAutoRecognitionLabelChecked() {
        if (1 == Settings.Global.getInt(this.mContext.getContentResolver(), ASSISTANT_AUTO_RECOGNITION_LABEL, 0)) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isDoubleClickWakeUpChecked() {
        if (1 == Settings.Global.getInt(this.mContext.getContentResolver(), DOUBLECLICK_ENABLE_ASSIST_ON, 0)) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isFingerprintWakeUpChecked() {
        if (1 == Settings.Global.getInt(this.mContext.getContentResolver(), FINGERPRINT_WAKEUP_KEY, 0)) goto L5;
        return false;
    L5:
        return true;
    }

    public void com_android_settings_intelligent_GlobalAssistantFragment__onResume$___twin___() {
        super.onResume();
        updateUI();
        registerContentObserver();
    }

    private void updateUI() {
        updateRecordVoicePrintButton();
        this.mVoiceWakeUpSwitch.setChecked(isWakeUpChecked());
        this.mVoiceprintWakeupSwitch.setChecked(isWakeupVoicePrintChecked());
        this.mVoiceprintRecognitionSwitch.setChecked(isPvadVoicePrintChecked());
        float r0 = Settings.Global.getFloat(getContentResolver(), "camera_always_on", -1.0f);
        this.mFaceEyeWakeUp.setSummary(this.mFaceEyeWakeUpEntries[getIndexOfValue(r0, this.mFaceEyeWakeUpValues)]);
        String r1 = Settings.System.getString(getContentResolver(), THE_SETTINGSPROVIDER_KEY);
        this.mSelectModel.setTrailingText(this.mSelectModelEntries[stringToInt(r1)]);
        float r2 = Settings.System.getFloat(getContentResolver(), ASSISTANT_IDLE_TIME, 0.0f);
        this.mIdleExit.setTrailingText(this.mIdleTimeEntries[getIndexOfValue(r2, this.mIdleTimeValues)]);
        getBotInfo();
        int r3 = this.mDefaultBotIdIndex;
        if (r3 < 0) goto L9;
        String[] r4 = this.mBotList;
        if (r3 >= r4.length) goto L9;
        if (r3 >= this.mBotIdMap.length) goto L9;
        this.mChooseBotId.setSubTitleString(r4[r3]);
    L9:
        float r5 = Settings.System.getFloat(getContentResolver(), ASSISTANT_VOICE_PLAY_PREFERENCE, 1.0f);
        this.mPlayPreference.setTrailingText(this.mPlayPreferenceEntries[getIndexOfValue(r5, this.mPlayPreferenceValues)]);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterContentObserver();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        if (this.mRecordVoicePrint != r8) goto L6;
        this.mVoicePrintRecognitionManager.startVoicePrintRecognition();
        return;
    L6:
        if (this.mFaceEyeWakeUp != r8) goto L9;
        float r9 = Settings.Global.getFloat(getContentResolver(), "camera_always_on", -1.0f);
        OptionsInfo r0 = new OptionsInfo(this.mFaceEyeWakeUpEntries, this.mFaceEyeWakeUpValues, OptionsInfo.SaveTargetTable.Global, "camera_always_on");
        FragmentActivity r1 = getActivity();
        String[] r2 = this.mFaceEyeWakeUpValues;
        Utils.launchOptionsActivity(r1, r0, r2[getIndexOfValue(r9, r2)], getString(R.string.face_eye_wakeup), R.string.face_eye_wakeup);
        return;
    L9:
        if (this.mSelectModel != r8) goto L12;
        String r10 = Settings.System.getString(getContentResolver(), THE_SETTINGSPROVIDER_KEY);
        OptionsInfo r3 = new OptionsInfo(this.mSelectModelEntries, this.mSelectModelValues, OptionsInfo.SaveTargetTable.System, THE_SETTINGSPROVIDER_KEY);
        Utils.launchOptionsActivity(getActivity(), r3, this.mSelectModelValues[stringToInt(r10)], getString(R.string.assistant_select_model_type_title), R.string.assistant_select_model_type_title);
        return;
    L12:
        if (this.mIdleExit != r8) goto L15;
        float r11 = Settings.System.getFloat(getContentResolver(), ASSISTANT_IDLE_TIME, 0.0f);
        OptionsInfo r4 = new OptionsInfo(this.mIdleTimeEntries, this.mIdleTimeValues, OptionsInfo.SaveTargetTable.System, ASSISTANT_IDLE_TIME);
        FragmentActivity r5 = getActivity();
        String[] r6 = this.mIdleTimeValues;
        Utils.launchOptionsActivity(r5, r4, r6[getIndexOfValue(r11, r6)], getString(R.string.idle_exit), R.string.idle_exit);
        return;
    L15:
        if (this.mChooseBotId != r8) goto L18;
        start(BotIdSelectFragment.class);
        return;
    L18:
        if (this.mPlayPreference != r8) goto L26;
        float r12 = Settings.System.getFloat(getContentResolver(), ASSISTANT_VOICE_PLAY_PREFERENCE, 1.0f);
        OptionsInfo r7 = new OptionsInfo(this.mPlayPreferenceEntries, this.mPlayPreferenceTipEntries, this.mPlayPreferenceValues, OptionsInfo.SaveTargetTable.System, ASSISTANT_VOICE_PLAY_PREFERENCE);
        FragmentActivity r13 = getActivity();
        String[] r14 = this.mPlayPreferenceValues;
        Utils.launchOptionsActivity(r13, r7, r14[getIndexOfValue(r12, r14)], getString(R.string.play_preference), R.string.play_preference);
        return;
    }

    private int stringToInt(String r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        if (r2.isEmpty() == false) goto L8;
        return 0;
    L8:
        if (r2.equals("large") == false) goto L11;
        return 0;
    L11:
        if (r2.equals("bert-nlu") == false) goto L15;
        return 1;
    L15:
        if (r2.equals("chatglm2-6b") == false) goto L19;
        return 2;
    L19:
        if (r2.equals("bert-nlu_offline") == false) goto L22;
        return 3;
    L22:
        return 4;
    }

    private int getIndexOfValue(float r3, String[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L9;
        if (Float.valueOf(r4[r0]).floatValue() == r3) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return 0;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (this.mVoiceWakeUpSwitch != r2) goto L11;
        if (r3 == true) goto L6;
    L9:
        Settings.Global.putInt(this.mContext.getContentResolver(), VoiceWakeupManager.VOICE_ASSISTANT_WAKEUP_STATUS, r3 ? 1 : 0);
        return;
    L6:
        if (isPhoneInCallBusy() == false) goto L9;
        showDialog(this.mVoiceWakeUpSwitch);
        OLog.d(this.TAG, "onCheckedChanged and phone is busy , not change the value ");
        return;
    L11:
        if (this.mVoiceprintWakeupSwitch != r2) goto L14;
        this.mVoicePrintRecognitionManager.setWakeupVoicePrintState(r3);
        return;
    L14:
        if (this.mVoiceprintRecognitionSwitch != r2) goto L17;
        this.mVoicePrintRecognitionManager.setSpeechVoicePrintState(r3);
        return;
    L17:
        if (this.mDoubleClickWakeUp.getSwitch() != r2) goto L20;
        Settings.Global.putInt(this.mContext.getContentResolver(), DOUBLECLICK_ENABLE_ASSIST_ON, r3 ? 1 : 0);
        return;
    L20:
        if (this.mFingerprintWakeUp.getSwitch() != r2) goto L23;
        Settings.Global.putInt(this.mContext.getContentResolver(), FINGERPRINT_WAKEUP_KEY, r3 ? 1 : 0);
        return;
    L23:
        if (this.mAutoRecognitionLabelSwitch != r2) goto L31;
        Settings.Global.putInt(this.mContext.getContentResolver(), ASSISTANT_AUTO_RECOGNITION_LABEL, r3 ? 1 : 0);
        return;
    }

    private boolean isPhoneInCallBusy() {
        int r0 = ((AudioManager) getActivity().getSystemService("audio")).getMode();
        OLog.d(this.TAG, "isPhoneInCallBusy audioMode:" + r0);
        if (r0 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 3) goto L8;
        return false;
    }

    private void showDialog(final CompoundButton r4) {
        if (this.mDialog != null) goto L5;
        this.mDialog = (OAlertDialog) new OAlertDialogBuilder(getActivity()).autoDismiss(true).horizontalButton().title(getString(R.string.incall_cannot_proceed_dialog_msg), true).negativeButton(R.string.notification_warning_dialog_cancel_btn, new GlobalAssistantFragment$$ExternalSyntheticLambda0(r4)).positiveButton(R.string.notification_warning_dialog_ok_btn, new GlobalAssistantFragment$$ExternalSyntheticLambda1(r4)).onCancel(new GlobalAssistantFragment$$ExternalSyntheticLambda2(r4)).createDialog();
    L5:
        this.mDialog.show();
    }

    static /* synthetic */ void lambda$showDialog$0(CompoundButton r0, DialogInterface r1, int r2) {
        r0.setChecked(false);
    }

    static /* synthetic */ void lambda$showDialog$1(CompoundButton r0, DialogInterface r1, int r2) {
        r0.setChecked(false);
    }

    static /* synthetic */ void lambda$showDialog$2(CompoundButton r0, DialogInterface r1) {
        r0.setChecked(false);
    }

    private boolean startVoiceAssist() {
        ComponentName r0 = new AssistUtils(this.mContext).getAssistComponentForUser(UserHandle.myUserId());
        if (r0 == null) goto L10;
        OLog.d(this.TAG, "startVoiceAssist getAssistComponentForUser return " + r0);
        PackageManager r2 = this.mContext.getPackageManager();
        String r3 = getAssistSettingsActivity(r0, r2.queryIntentServices(new Intent("android.service.voice.VoiceInteractionService").setPackage(r0.getPackageName()), 128).get(0), r2);
        if (r3 == null) goto L8;
        OLog.d(this.TAG, "startVoiceAssist  getAssistSettingsActivity return " + r3);
        startActivity(new Intent("android.intent.action.MAIN").setComponent(new ComponentName(r0.getPackageName(), r3)));
        return true;
    L8:
        OLog.d(this.TAG, "startVoiceAssist  get assist settings activity return null ");
        return false;
    L10:
        OLog.d(this.TAG, "startVoiceAssist  get assist component fro user return null ");
        return false;
    }

    private String getAssistSettingsActivity(ComponentName r1, ResolveInfo r2, PackageManager r3) {
        VoiceInteractionServiceInfo r0 = new VoiceInteractionServiceInfo(r3, r2.serviceInfo);
        if (r0.getSupportsAssist() == true) goto L7;
        return null;
    L7:
        return r0.getSettingsActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mVoiceWakeupManager.removeListener(this);
        this.mVoicePrintRecognitionManager.removeListener(this);
    }

    @Override // com.android.settings.intelligent.VoiceWakeupManager.WakeupChangeListener
    public void wakeupChanged(boolean r2) {
        if (this.mVoiceWakeupManager.isVoiceWakeupOn() == true) goto L5;
        this.mVoiceprintWakeup.setVisibility(8);
        return;
    L5:
        if (hasRecordVoicePrint() == false) goto L7;
        this.mVoiceprintWakeup.setVisibility(0);
        return;
    L7:
        this.mVoiceprintWakeup.setVisibility(8);
    }

    @Override // com.android.settings.intelligent.VoicePrintRecognitionManager.VoicePrintRecognitionChangeListener
    public void OnVoicePrintRecognitionChanged(boolean r3) {
        if (hasRecordVoicePrint() == true) goto L5;
        this.mVoiceprintWakeup.setVisibility(8);
        this.mVoiceprintRecognition.setVisibility(8);
        this.mVoicePrintRecogintionTips.setVisibility(8);
        return;
    L5:
        if (this.mVoiceWakeUpSwitch.isChecked() == false) goto L7;
        this.mVoiceprintWakeup.setVisibility(0);
    L8:
        this.mVoiceprintRecognition.setVisibility(0);
        this.mVoicePrintRecogintionTips.setVisibility(0);
        return;
    L7:
        this.mVoiceprintWakeup.setVisibility(8);
        goto L8
    }

    @Override // com.android.settings.intelligent.VoicePrintRecognitionManager.VoicePrintRecognitionChangeListener
    public void OnVoicePrintRecognitionModelPathChanged(boolean r1) {
        this.mVoiceprintRecognitionSwitch.setChecked(isPvadVoicePrintChecked());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Bundle] */
    private void getBotInfo() {
        ContentProviderClient r0 = 0;
        Bundle r1 = null;
        r1 = null;
        ContentProviderClient r2 = null;
        OLog.d(this.TAG, "query provider start");     // Catch: Throwable -> L13 RemoteException -> L15
        ContentProviderClient r3 = getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://obric.assistant.data"));     // Catch: Throwable -> L13 RemoteException -> L15
        if (r3 != null) goto L39;
    L6:
        OLog.d(this.TAG, "query provider end");     // Catch: Throwable -> L9 RemoteException -> L11
        r0 = r1;
        if (r3 == null) goto L21;
        r3.close();
        r0 = r1;
    L21:
        if (r0 == 0) goto L44;
        this.mDefaultBotId = r0.getString("default_bot_id");
        OLog.d(this.TAG, "default_bot_id = " + this.mDefaultBotId);
        String[] r4 = r0.getStringArray("bots_list");
        ArrayList r5 = new ArrayList();
        this.mBotListValue = new String[r4.length];
        this.mBotIdMap = new String[r4.length];
        this.mBotList = new String[r4.length];
        if (r4 == null) goto L31;
        int r6 = 0;
    L26:
        if (r6 >= r4.length) goto L31;
        if (r4[r6].contains(this.mDefaultBotId) == false) goto L30;
        this.mDefaultBotIdIndex = r6;
    L30:
        r5.add(r4[r6]);
        this.mBotListValue[r6] = String.valueOf(r6);
        this.mBotIdMap[r6] = getBotIdString(r4[r6]);
        OLog.d(this.TAG, "bot = " + r4[r6]);
        r6 = r6 + 1;
    L31:
        this.mBotList = (String[]) r5.toArray(this.mBotList);
        return;
    L44:
        return;
    L11:
        e = e;
        Bundle r7 = r1;
        r2 = r3;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L13
        if (r2 == null) goto L20;
        r2.close();
    L20:
        r0 = r7;
    L9:
        th = th;
        r0 = r3;
    L33:
        if (r0 == 0) goto L35;
        r0.close();
    L35:
        throw th;
    L39:
        r1 = r3.call("getBotInfo", null, null);     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        th = th;
    L15:
        e = e;
        r7 = null;
        goto L17
    }

    private String getBotIdString(String r1) {
        String[] r0 = r1.split(HanziToPinyin.Token.SEPARATOR);
        return r0[r0.length - 1];
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_intelligent_GlobalAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(GlobalAssistantFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_GlobalAssistantFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_GlobalAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(GlobalAssistantFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_intelligent_GlobalAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_GlobalAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(GlobalAssistantFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_GlobalAssistantFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
