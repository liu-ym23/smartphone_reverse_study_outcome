package com.android.settings.tts;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TtsEngines;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class TTSEngineSettingsFragment extends BaseFragment implements View.OnClickListener {
    private static final boolean DBG = false;
    private static final String IFLYTEK_CLASS_NAME = "com.iflytek.speech.SpeakersActivity";
    static final String KEY_LOCALE_ENTRIES = "tts_entries";
    static final String KEY_LOCALE_ENTRY_VALUES = "tts_entry_values";
    static final String KEY_LOCALE_INDEX = "select_index";
    private static final String PACKAGE_NAME_IFLYTEK = "com.iflytek.speechsuite";
    private static final String TAG = "TTSEngineSettingsFragment";
    private static final int VOICE_DATA_INTEGRITY_CHECK = 1977;
    ListContentItemText mEngineLanguage;
    ListContentItemText mEngineSetting;
    private Intent mEngineSettingsIntent;
    ListContentItemText mEngineVoiceData;
    private TtsEngines mEnginesHelper;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private final BroadcastReceiver mLanguagesChangedReceiver;
    private int mSelectedLocaleIndex;
    private TextToSpeech mTts;
    private final TextToSpeech.OnInitListener mTtsInitListener;
    private Intent mVoiceDataDetails;

    public void com_android_settings_tts_TTSEngineSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_tts_TTSEngineSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_tts_TTSEngineSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(TTSEngineSettingsFragment r0) {
        r0.checkTtsData();
    }

    public TTSEngineSettingsFragment() {
        this.mSelectedLocaleIndex = -1;
        this.mTtsInitListener = new AnonymousClass1(this);
        this.mLanguagesChangedReceiver = new AnonymousClass2(this);
    }

    public void com_android_settings_tts_TTSEngineSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.tts_engine_settings_layout_sm, r4, false);
        this.mEngineLanguage = (ListContentItemText) findViewByIdNullable(R.id.id_engine_language);
        this.mEngineSetting = (ListContentItemText) findViewByIdNullable(R.id.id_engine_setting);
        this.mEngineVoiceData = (ListContentItemText) findViewByIdNullable(R.id.id_engine_voicedata);
        this.mEngineLanguage.setOnClickListener(this);
        this.mEngineSetting.setOnClickListener(this);
        this.mEngineVoiceData.setOnClickListener(this);
        this.mEnginesHelper = new TtsEngines(getActivity());
        this.mEngineSetting.setTitle(getResources().getString(R.string.tts_engine_settings_title, new Object[]{getEngineLabel()}));
        Intent r6 = this.mEnginesHelper.getSettingsIntent(getEngineName());
        this.mEngineSettingsIntent = r6;
        if (r6 != null) goto L5;
        this.mEngineSetting.setEnabled(false);
    L5:
        this.mEngineVoiceData.setEnabled(false);
        this.mVoiceDataDetails = (Intent) getArguments().getParcelable(TTSSettingFragment.FRAGMENT_ARGS_VOICES);
        this.mTts = new TextToSpeech(this.mContext, this.mTtsInitListener, getEngineName());
        checkTtsData();
        this.mEngineVoiceData.setTitle(getString(R.string.tts_install_data_title));
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mLanguagesChangedReceiver, new IntentFilter("android.speech.tts.engine.TTS_DATA_INSTALLED"), 2);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        OFloatingTitleBar r5 = this.mTitleView;
        if (r5 == null) goto L6;
        r5.setCenterTitle(getString(R.string.tts_detail_setting_title, new Object[]{getEngineLabel()}));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.mEngineLanguage != r3) goto L13;
        if (this.mEntries != null) goto L7;
    L10:
        OLog.e(TAG, getEngineName() + "the tts engine language entry is null.");
        return;
    L7:
        if (this.mEntryValues == null) goto L10;
        Bundle r4 = new Bundle();
        r4.putCharSequenceArray(KEY_LOCALE_ENTRIES, this.mEntries);
        r4.putCharSequenceArray(KEY_LOCALE_ENTRY_VALUES, this.mEntryValues);
        r4.putInt(KEY_LOCALE_INDEX, this.mSelectedLocaleIndex);
        r4.putString("name", getEngineName());
        r4.putString("label", getEngineLabel());
        start(TTSEngineLocaleSettingFragment.class, r4);
        return;
    L13:
        if (this.mEngineSetting != r3) goto L19;
        this.mEngineSettingsIntent.putExtra("back_text", getString(R.string.tts_settings_title));
        if (this.mEngineSettingsIntent.getComponent().getPackageName().equals(PACKAGE_NAME_IFLYTEK) == false) goto L17;
        addIflytkData(this.mEngineSettingsIntent);
    L17:
        Utils.startActivity(this._mActivity, this.mEngineSettingsIntent);
        return;
    L19:
        if (this.mEngineVoiceData != r3) goto L24;
        installVoiceData();
        return;
    }

    public void updateViews() {
        if (this.mEntryValues == null) goto L6;
        int r0 = PreferenceMgr.getInstance(this.mContext).getInt(getEngineName() + TTSEngineLocaleSettingFragment.TTS_LOCALE_SUFFIX, this.mSelectedLocaleIndex);
        OLog.d(TAG, "new index: " + r0 + ", " + this.mEntries[r0] + ", " + this.mEntryValues[r0].toString());
        this.mSelectedLocaleIndex = r0;
        this.mEngineLanguage.setSubtitle(this.mEntries[r0]);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mContext.unregisterReceiver(this.mLanguagesChangedReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mTts.shutdown();
        super.onDestroy();
    }

    @Override // com.android.settings.base.BaseFragment
    public void finish() {
        super.finish();
    }

    private final void checkTtsData() {
        Intent r0 = new Intent("android.speech.tts.engine.CHECK_TTS_DATA");
        r0.setPackage(getEngineName());
        startActivityForResult(r0, VOICE_DATA_INTEGRITY_CHECK);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        OLog.e(TAG, "Failed to check TTS data, no activity found for " + r0 + ")");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 != VOICE_DATA_INTEGRITY_CHECK) goto L8;
        if (r3 == 0) goto L6;
        updateVoiceDetails(r4);
        return;
    L6:
        OLog.e(TAG, "CheckVoiceData activity failed");
        return;
    }

    private void updateVoiceDetails(Intent r5) {
        if (r5 != null) goto L6;
        OLog.e(TAG, "Engine failed voice data integrity check (null return)" + this.mTts.getCurrentEngine());
        return;
    L6:
        this.mVoiceDataDetails = r5;
        ArrayList<String> r6 = r5.getStringArrayListExtra("availableVoices");
        ArrayList<String> r1 = this.mVoiceDataDetails.getStringArrayListExtra("unavailableVoices");
        if (r1 != null) goto L9;
    L11:
        this.mEngineVoiceData.setEnabled(false);
    L12:
        if (r6 != null) goto L15;
        OLog.e(TAG, "TTS data check failed (available == null).");
        this.mEngineLanguage.setEnabled(false);
        return;
    L15:
        updateDefaultLocalePref(r6);
        return;
    L9:
        if (r1.size() <= 0) goto L11;
        this.mEngineVoiceData.setEnabled(true);
        goto L12
    }

    private void updateDefaultLocalePref(ArrayList<String> r8) {
        if (r8 != null) goto L5;
    L27:
        this.mEngineLanguage.setEnabled(false);
        return;
    L5:
        if (r8.size() == 0) goto L27;
        if (this.mEnginesHelper.isLocaleSetToDefaultForEngine(getEngineName()) == true) goto L10;
        Locale r1 = this.mEnginesHelper.getLocalePrefForEngine(getEngineName());
    L11:
        ArrayList r2 = new ArrayList(r8.size());
        int r3 = 0;
    L13:
        if (r3 >= r8.size()) goto L18;
        Locale r4 = this.mEnginesHelper.parseLocaleString(r8.get(r3));
        if (r4 == null) goto L17;
        r2.add(new Pair(r4.getDisplayName(), r4));
    L17:
        r3 = r3 + 1;
        goto L13
    L18:
        Collections.sort(r2, new AnonymousClass3(this));
        this.mSelectedLocaleIndex = 0;
        CharSequence[] r5 = new CharSequence[r8.size() + 1];
        CharSequence[] r9 = new CharSequence[r8.size() + 1];
        r5[0] = getActivity().getString(R.string.tts_lang_use_system);
        r9[0] = "";
        Iterator r0 = r2.iterator();
        int r6 = 1;
    L20:
        if (r0.hasNext() == false) goto L25;
        Pair r7 = (Pair) r0.next();
        if (((Locale) r7.second).equals(r1) == false) goto L24;
        this.mSelectedLocaleIndex = r6;
    L24:
        r5[r6] = (CharSequence) r7.first;
        r9[r6] = ((Locale) r7.second).toString();
        r6 = r6 + 1;
        goto L20
    L25:
        this.mEntries = r5;
        this.mEntryValues = r9;
        this.mEngineLanguage.setEnabled(true);
        setLocalePreference(this.mSelectedLocaleIndex);
        return;
    L10:
        r1 = null;
        goto L11
    }

    private void setLocalePreference(int r2) {
        if (r2 >= 0) goto L4;
        this.mEngineLanguage.setSubtitle(R.string.tts_lang_not_selected);
        return;
    L4:
        this.mEngineLanguage.setSubtitle(this.mEntries[r2]);
    }

    private void installVoiceData() {
        String r2 = getEngineName();
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        Intent r3 = new Intent("android.speech.tts.engine.INSTALL_TTS_DATA");
        if (PACKAGE_NAME_IFLYTEK.equals(r2) == false) goto L8;
        addIflytkData(r3);
    L13:
        OLog.v(TAG, "Installing voice data: " + r3.toUri(0));     // Catch: ActivityNotFoundException -> L11
        r3.putExtra("back_text", getString(R.string.tts_settings_title));     // Catch: ActivityNotFoundException -> L11
        Utils.startActivity(getActivity(), r3);     // Catch: ActivityNotFoundException -> L11
        return;
    L11:
        OLog.e(TAG, "Failed to install TTS data, no acitivty found for " + r3 + ")");
        return;
    L8:
        r3.setPackage(r2);
        goto L13
    }

    private void addIflytkData(Intent r2) {
        r2.setClassName("com.bytedanceos.sara", IFLYTEK_CLASS_NAME);
        r2.setPackage("com.bytedanceos.sara");
    }

    private String getEngineName() {
        return getArguments().getString("name");
    }

    private String getEngineLabel() {
        return getArguments().getString("label");
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_tts_TTSEngineSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TTSEngineSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_tts_TTSEngineSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_tts_TTSEngineSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TTSEngineSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_tts_TTSEngineSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_tts_TTSEngineSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TTSEngineSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_tts_TTSEngineSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
