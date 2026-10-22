package com.android.settings.tts;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TtsEngines;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.widget.SettingCommonSeekBar;
import com.bytedance.bdinstall.Api;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class TTSSettingFragment extends BaseFragment implements SettingCommonSeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private static final boolean DBG = false;
    static final String FRAGMENT_ARGS_LABEL = "label";
    static final String FRAGMENT_ARGS_NAME = "name";
    public static final String FRAGMENT_ARGS_VOICES = "voices";
    private static final int GET_SAMPLE_TEXT = 1983;
    private static final String KEY_DEFAULT_PITCH = "tts_default_pitch";
    private static final String KEY_DEFAULT_RATE = "tts_default_rate";
    static final String LIST_ITEM_TAG_PREFIX = "tts_tag_";
    private static final int MAX_SPEECH_PITCH = 400;
    private static final int MAX_SPEECH_RATE = 600;
    private static final int MIN_SPEECH_PITCH = 25;
    private static final int MIN_SPEECH_RATE = 10;
    private static final int MSG_TTS_INITIALIZE = 20480;
    private static final String TAG = "TextToSpeechSettings";
    public static final String TTS_DEFAULT_SYNTH = "tts_default_synth";
    private static final int VOICE_DATA_INTEGRITY_CHECK = 1977;
    private int bottomBgResId;
    private List<TextToSpeech.EngineInfo> mAvailableEngines;
    private List<String> mAvailableStrLocals;
    private Locale mCurrentDefaultLocale;
    private String mCurrentEngine;
    private int mCurrentTtsIndex;
    private int mDefaultPitch;
    private int mDefaultRate;
    private TtsEngines mEnginesHelper;
    private ImageView mExampleAudioIv;
    private Handler mHandler;
    private final TextToSpeech.OnInitListener mInitListener;
    private Message mInitMessage;
    private volatile boolean mPreventSeekBarCallbacks;
    private String mPreviousEngine;
    private String mSampleText;
    private SettingCommonSeekBar mSpeechPitchSeekbar;
    private SettingCommonSeekBar mSpeechRateSeekbar;
    private TextToSpeech mTts;
    private LinearLayout mTtsEngineContainer;
    private LinearLayout mTtsEngineRootView;
    private TextView mTtsStatusTips;
    private final TextToSpeech.OnInitListener mUpdateListener;
    private int middleBgResId;
    private int singleBgResId;
    private int topBgResId;

    public void com_android_settings_tts_TTSSettingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_tts_TTSSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_tts_TTSSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TTSSettingFragment() {
        this.mDefaultPitch = 100;
        this.mDefaultRate = 100;
        this.mTts = null;
        this.mEnginesHelper = null;
        this.mSampleText = null;
        this.mInitMessage = null;
        this.topBgResId = R.drawable.group_list_item_bg_top;
        this.middleBgResId = R.drawable.group_list_item_bg_mid;
        this.bottomBgResId = R.drawable.group_list_item_bg_bottom;
        this.singleBgResId = R.drawable.group_list_item_bg_single;
        this.mInitListener = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
        this.mUpdateListener = new AnonymousClass3(this);
    }

    static /* synthetic */ Message access$000(TTSSettingFragment r0) {
        return r0.mInitMessage;
    }

    static /* synthetic */ Message access$002(TTSSettingFragment r0, Message r1) {
        r0.mInitMessage = r1;
        return r1;
    }

    static /* synthetic */ Handler access$100(TTSSettingFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ int access$200(TTSSettingFragment r0) {
        return r0.mCurrentTtsIndex;
    }

    static /* synthetic */ int access$202(TTSSettingFragment r0, int r1) {
        r0.mCurrentTtsIndex = r1;
        return r1;
    }

    static /* synthetic */ void access$300(TTSSettingFragment r0, String r1) {
        r0.updateDefaultEngine(r1);
    }

    static /* synthetic */ void access$400(TTSSettingFragment r0) {
        r0.updateCheckStatus();
    }

    public void com_android_settings_tts_TTSSettingFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mTts = new TextToSpeech(this.mContext, this.mInitListener);
        this.mEnginesHelper = new TtsEngines(this.mContext);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.tts_settings_layout, r3, false);
        this.mTtsEngineRootView = (LinearLayout) findViewByIdNullable(R.id.tts_container);
        initView();
        initTts();
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        Locale r3 = this.mTts.getDefaultLanguage();
        Locale r4 = this.mCurrentDefaultLocale;
        if (r4 == null) goto L8;
        if (r4.equals(r3) == true) goto L8;
        checkVoiceData(this.mCurrentEngine);
        return;
    L8:
        if (this.mCurrentDefaultLocale != null) goto L12;
        checkVoiceData(this.mCurrentEngine);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void initView() {
        LayoutInflater r0 = LayoutInflater.from(this.mContext);
        View r1 = r0.inflate(R.layout.tts_settings_list_header, null, false);
        View r2 = r0.inflate(R.layout.tts_settings_list_footer, null, false);
        this.mSpeechRateSeekbar = (SettingCommonSeekBar) r2.findViewById(R.id.id_tts_speech_rate);
        this.mSpeechPitchSeekbar = (SettingCommonSeekBar) r2.findViewById(R.id.id_tts_speech_pitch);
        this.mExampleAudioIv = (ImageView) r2.findViewById(R.id.id_tts_example_audio);
        this.mTtsStatusTips = (TextView) r2.findViewById(R.id.id_tts_engine_status);
        this.mTtsEngineRootView.addView(r1);
        this.mExampleAudioIv.setOnClickListener(this);
        this.mAvailableEngines = this.mEnginesHelper.getEngines();
        LinearLayout r3 = new LinearLayout(this.mContext);
        this.mTtsEngineContainer = r3;
        r3.setOrientation(1);
        this.mTtsEngineContainer.setClipChildren(false);
        this.mTtsEngineContainer.setClipToPadding(false);
        addEngines(this.mAvailableEngines);
        this.mTtsEngineRootView.addView(this.mTtsEngineContainer);
        this.mTtsEngineRootView.addView(r2);
    }

    private void addEngines(final List<TextToSpeech.EngineInfo> r9) {
        this.mTtsEngineContainer.removeAllViews();
        final int r1 = 0;
    L4:
        if (r1 >= r9.size()) goto L19;
        OCardListItem r2 = new OCardListItem(this.mContext);
        r2.setTitle(r9.get(r1).label);
        r2.setDefaultCustomEndView(2);
        r2.showCustomEnd(true);
        r2.setOnContentClickListener(new AnonymousClass4(this, r1, r9));
        r2.setTag(LIST_ITEM_TAG_PREFIX + r1);
        if (this.mCurrentTtsIndex != r1) goto L8;
        boolean r5 = true;
    L9:
        r2.showCustomEnd(r5);
        r2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (r9.size() != 1) goto L12;
        r2.setCardPosition(0);
    L18:
        this.mTtsEngineContainer.addView(r2);
        r1 = r1 + 1;
        goto L4
    L12:
        if (r1 != 0) goto L15;
        r2.setCardPosition(1);
        goto L18
    L15:
        if (r1 != (r9.size() - 1)) goto L17;
        r2.setCardPosition(3);
        goto L18
    L17:
        r2.setCardPosition(2);
        goto L18
    L8:
        r5 = false;
        goto L9
    }

    private void updateCheckStatus() {
        if (this.mTtsEngineContainer != null) goto L5;
        return;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.mTtsEngineContainer.getChildCount()) goto L16;
        View r2 = this.mTtsEngineContainer.getChildAt(r1);
        if ((r2 instanceof OCardListItem) == false) goto L15;
        OCardListItem r3 = (OCardListItem) r2;
        if (this.mCurrentTtsIndex != r1) goto L13;
        boolean r4 = true;
    L14:
        r3.showCustomEnd(r4);
        r2.invalidate();
        goto L15
    L13:
        r4 = false;
    L15:
        r1 = r1 + 1;
        goto L7
    }

    private void initTts() {
        ContentResolver r0 = getContentResolver();
        this.mDefaultRate = Settings.Secure.getInt(r0, KEY_DEFAULT_RATE, 100);
        this.mDefaultPitch = Settings.Secure.getInt(r0, KEY_DEFAULT_PITCH, 100);
        this.mSpeechRateSeekbar.setOnChangeListener(this);
        this.mPreventSeekBarCallbacks = true;
        this.mSpeechRateSeekbar.setMax(getSeekBarProgressFromValue(KEY_DEFAULT_RATE, 600));
        this.mSpeechRateSeekbar.setProgress(getSeekBarProgressFromValue(KEY_DEFAULT_RATE, this.mDefaultRate));
        int r1 = 0;
        this.mPreventSeekBarCallbacks = false;
        this.mSpeechPitchSeekbar.setOnChangeListener(this);
        this.mPreventSeekBarCallbacks = true;
        this.mSpeechPitchSeekbar.setMax(getSeekBarProgressFromValue(KEY_DEFAULT_PITCH, 400));
        this.mSpeechPitchSeekbar.setProgress(getSeekBarProgressFromValue(KEY_DEFAULT_PITCH, this.mDefaultPitch));
        this.mPreventSeekBarCallbacks = false;
        TextToSpeech r2 = this.mTts;
        if (r2 == null) goto L6;
        this.mCurrentEngine = r2.getCurrentEngine();
        this.mTts.setSpeechRate(this.mDefaultRate / 100.0f);
        this.mTts.setPitch(this.mDefaultPitch / 100.0f);
    L6:
        if (r1 >= this.mAvailableEngines.size()) goto L15;
        if (this.mAvailableEngines.get(r1).name.equals(this.mCurrentEngine) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        this.mCurrentTtsIndex = r1;
        updateCheckStatus();
        return;
    }

    private int getValueFromSeekBarProgress(String r1, int r2) {
        if (r1.equals(KEY_DEFAULT_RATE) == false) goto L7;
        return r2 + 10;
    L7:
        if (r1.equals(KEY_DEFAULT_PITCH) == true) goto L9;
        return r2;
    L9:
        return r2 + 25;
    }

    private int getSeekBarProgressFromValue(String r1, int r2) {
        if (r1.equals(KEY_DEFAULT_RATE) == false) goto L7;
        return r2 - 10;
    L7:
        if (r1.equals(KEY_DEFAULT_PITCH) == true) goto L9;
        return r2;
    L9:
        return r2 - 25;
    }

    public void onInitEngine(int r1) {
        if (r1 != 0) goto L8;
        checkDefaultLocale();
        if (evaluateDefaultLocale() == true) goto L6;
        return;
    L6:
        if (this.mSampleText != null) goto L11;
        getSampleText();
        return;
    L11:
        return;
    L8:
        updateWidgetState(false);
    }

    private void checkDefaultLocale() {
        Locale r0 = this.mTts.getDefaultLanguage();
        if (r0 != null) goto L6;
        OLog.e(TAG, "Failed to get default language from engine " + this.mCurrentEngine);
        updateWidgetState(false);
        updateEngineStatus(R.string.tts_status_not_supported);
        return;
    L6:
        Locale r1 = this.mCurrentDefaultLocale;
        Locale r2 = this.mEnginesHelper.parseLocaleString(r0.toString());
        this.mCurrentDefaultLocale = r2;
        if (Objects.equals(r1, r2) == true) goto L9;
        this.mSampleText = null;
    L9:
        this.mTts.setLanguage(r0);
    }

    private boolean evaluateDefaultLocale() {
        Locale r0 = this.mCurrentDefaultLocale;
        if (r0 != null) goto L5;
    L37:
        return false;
    L5:
        if (this.mAvailableStrLocals == null) goto L37;
        String r1 = r0.getISO3Language();     // Catch: MissingResourceException -> L36
        if (TextUtils.isEmpty(this.mCurrentDefaultLocale.getISO3Country()) == true) goto L13;
        r1 = r1 + "-" + this.mCurrentDefaultLocale.getISO3Country();     // Catch: MissingResourceException -> L36
    L13:
        if (TextUtils.isEmpty(this.mCurrentDefaultLocale.getVariant()) == true) goto L15;
        r1 = r1 + "-" + this.mCurrentDefaultLocale.getVariant();     // Catch: MissingResourceException -> L36
    L15:
        Iterator<String> r3 = this.mAvailableStrLocals.iterator();     // Catch: MissingResourceException -> L36
    L16:
        if (r3.hasNext() == false) goto L21;
        if (r3.next().equalsIgnoreCase(r1) == false) goto L16;
        boolean r2 = false;
    L22:
        int r4 = this.mTts.setLanguage(this.mCurrentDefaultLocale);
        if (r4 != (-2)) goto L25;
    L34:
        updateEngineStatus(R.string.tts_status_not_supported);
        updateWidgetState(false);
        return false;
    L25:
        if (r4 == (-1)) goto L34;
        if (r2 == true) goto L34;
        if (isNetworkRequiredForSynthesis() == false) goto L31;
        updateEngineStatus(R.string.tts_status_requires_network);
    L32:
        updateWidgetState(true);
        return true;
    L31:
        updateEngineStatus(R.string.tts_status_ok);
        goto L32
    L21:
        r2 = true;
    L36:
        updateEngineStatus(R.string.tts_status_not_supported);
        updateWidgetState(false);
        goto L37
    }

    private void updateDefaultEngine(String r4) {
        updateWidgetState(false);
        updateEngineStatus(R.string.tts_status_checking);
        this.mPreviousEngine = this.mTts.getCurrentEngine();
        TextToSpeech r0 = this.mTts;
        if (r0 != null) goto L10;
    L8:
        this.mTts = new TextToSpeech(this.mContext, this.mUpdateListener, r4);
        this.mCurrentEngine = r4;
        setTtsUtteranceProgressListener();
        return;
    L10:
        r0.shutdown();     // Catch: Exception -> L6
        this.mTts = null;     // Catch: Exception -> L6
    L6:
        e = move-exception;
        OLog.e(TAG, "Error shutting down TTS engine" + e);
        goto L8
    }

    public void onUpdateEngine(int r4) {
        if (r4 != 0) goto L5;
        checkDefaultLocale();
        checkVoiceData(this.mTts.getCurrentEngine());
        return;
    L5:
        if (this.mPreviousEngine == null) goto L7;
        this.mTts = new TextToSpeech(this.mContext, this.mInitListener, this.mPreviousEngine);
        setTtsUtteranceProgressListener();
    L7:
        this.mPreviousEngine = null;
    }

    private void checkVoiceData(String r3) {
        Intent r0 = new Intent("android.speech.tts.engine.CHECK_TTS_DATA");
        r0.setPackage(r3);
        startActivityForResult(r0, VOICE_DATA_INTEGRITY_CHECK);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        OLog.e(TAG, "Failed to check TTS data, no activity found for " + r0 + ")");
    }

    private void onVoiceDataIntegrityCheckDone(Intent r5) {
        String r0 = this.mTts.getCurrentEngine();
        if (r0 != null) goto L6;
        OLog.e(TAG, "Voice data check complete, but no engine bound");
        return;
    L6:
        if (r5 != null) goto L9;
        OLog.e(TAG, "Engine failed voice data integrity check (null return)" + this.mTts.getCurrentEngine());
        return;
    L9:
        Settings.Secure.putString(getContentResolver(), TTS_DEFAULT_SYNTH, r0);
        ArrayList<String> r6 = r5.getStringArrayListExtra("availableVoices");
        this.mAvailableStrLocals = r6;
        if (r6 != null) goto L13;
        OLog.e(TAG, "Voice data check complete, but no available voices found");
        this.mAvailableStrLocals = new ArrayList();
    L13:
        if (evaluateDefaultLocale() == false) goto L15;
        getSampleText();
    L15:
        LinearLayout r7 = this.mTtsEngineContainer;
        if (r7 != null) goto L18;
        return;
    L18:
        if (this.mCurrentTtsIndex >= r7.getChildCount()) goto L22;
        this.mTtsEngineContainer.getChildAt(this.mCurrentTtsIndex);
        return;
    }

    public void updateViews() {
        Locale r0 = this.mTts.getDefaultLanguage();
        Locale r1 = this.mCurrentDefaultLocale;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.equals(r0) == true) goto L9;
        updateWidgetState(false);
        checkDefaultLocale();
        evaluateDefaultLocale();
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void speakSampleText() {
        boolean r0 = isNetworkRequiredForSynthesis();
        if (r0 == false) goto L9;
        if (r0 == true) goto L6;
    L8:
        OLog.w(TAG, "Network required for sample synthesis for requested language");
        displayNetworkAlert();
        return;
    L6:
        if (this.mTts.isLanguageAvailable(this.mCurrentDefaultLocale) < 0) goto L8;
    L9:
        HashMap<String, String> r1 = new HashMap();
        r1.put("utteranceId", "Sample");
        this.mTts.speak(this.mSampleText, 0, r1);
    }

    private void updateSpeechRate(int r3) {
        this.mDefaultRate = getValueFromSeekBarProgress(KEY_DEFAULT_RATE, r3);
        Settings.Secure.putInt(getContentResolver(), KEY_DEFAULT_RATE, this.mDefaultRate);     // Catch: NumberFormatException -> L7
        TextToSpeech r4 = this.mTts;     // Catch: NumberFormatException -> L7
        if (r4 == null) goto L12;
        r4.setSpeechRate(this.mDefaultRate / 100.0f);     // Catch: NumberFormatException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        OLog.e(TAG, "could not persist default TTS rate setting", e);
    }

    private void updateSpeechPitchValue(int r3) {
        this.mDefaultPitch = getValueFromSeekBarProgress(KEY_DEFAULT_PITCH, r3);
        Settings.Secure.putInt(getContentResolver(), KEY_DEFAULT_PITCH, this.mDefaultPitch);     // Catch: NumberFormatException -> L7
        TextToSpeech r4 = this.mTts;     // Catch: NumberFormatException -> L7
        if (r4 == null) goto L12;
        r4.setPitch(this.mDefaultPitch / 100.0f);     // Catch: NumberFormatException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        OLog.e(TAG, "could not persist default TTS pitch setting", e);
    }

    private void updateWidgetState(boolean r2) {
        this.mExampleAudioIv.setEnabled(r2);
        this.mSpeechRateSeekbar.setEnabled(r2);
        this.mTtsStatusTips.setEnabled(r2);
    }

    private void updateEngineStatus(int r5) {
        Locale r0 = this.mCurrentDefaultLocale;
        if (r0 != null) goto L5;
        r0 = Locale.getDefault();
    L5:
        this.mTtsStatusTips.setText(this.mAvailableEngines.get(this.mCurrentTtsIndex).label + HanziToPinyin.Token.SEPARATOR + getString(r5, new Object[]{r0.getDisplayName()}));
    }

    private void getSampleText() {
        String r0 = this.mTts.getCurrentEngine();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        r0 = this.mTts.getDefaultEngine();
    L5:
        Intent r1 = new Intent("android.speech.tts.engine.GET_SAMPLE_TEXT");
        r1.putExtra(Api.KEY_LANGUAGE, this.mCurrentDefaultLocale.getLanguage());
        r1.putExtra("country", this.mCurrentDefaultLocale.getCountry());
        r1.putExtra("variant", this.mCurrentDefaultLocale.getVariant());
        r1.setPackage(r0);
        startActivityForResult(r1, GET_SAMPLE_TEXT);     // Catch: ActivityNotFoundException -> L8
        return;
    L8:
        OLog.e(TAG, "Failed to get sample text, no activity found for " + r1 + ")");
    }

    private boolean isNetworkRequiredForSynthesis() {
        Set<String> r2 = this.mTts.getFeatures(this.mCurrentDefaultLocale);
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.contains("networkTts") == true) goto L8;
        return false;
    L8:
        if (r2.contains("embeddedTts") == true) goto L12;
        return true;
    L12:
        return false;
    }

    private void setTtsUtteranceProgressListener() {
        TextToSpeech r0 = this.mTts;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setOnUtteranceProgressListener(new AnonymousClass5(this));
    }

    private String getDefaultSampleString() {
        TextToSpeech r0 = this.mTts;
        if (r0 == null) goto L15;
        if (r0.getLanguage() == null) goto L15;
        String r1 = this.mTts.getLanguage().getISO3Language();     // Catch: MissingResourceException -> L16
        String[] r2 = getActivity().getResources().getStringArray(R.array.tts_demo_strings);     // Catch: MissingResourceException -> L16
        String[] r3 = getActivity().getResources().getStringArray(R.array.tts_demo_string_langs);     // Catch: MissingResourceException -> L16
        int r4 = 0;
    L8:
        if (r4 >= r2.length) goto L15;
        if (r3[r4].equals(r1) == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        return r2[r4];
    L15:
        return getString(R.string.tts_default_sample_string);
    }

    private void onSampleTextReceived(int r3, Intent r4) {
        String r0 = getDefaultSampleString();
        if (r3 != 0) goto L9;
        if (r4 == null) goto L9;
        if (r4 == null) goto L9;
        if (r4.getStringExtra("sampleText") == null) goto L9;
        r0 = r4.getStringExtra("sampleText");
    L9:
        this.mSampleText = r0;
        if (r0 == null) goto L12;
        updateWidgetState(true);
        return;
    L12:
        OLog.e(TAG, "Did not have a sample string for the requested language. Using default");
    }

    private void displayNetworkAlert() {
        AlertDialog.Builder r0 = new AlertDialog.Builder(getActivity());
        r0.setTitle(android.R.string.dialog_alert_title).setMessage(getActivity().getString(R.string.tts_engine_network_required)).setCancelable(false).setPositiveButton(android.R.string.ok, null);
        r0.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mExampleAudioIv) goto L6;
        speakSampleText();
        return;
    }

    @Override // com.android.settings.widget.SettingCommonSeekBar.OnProgressChangedListener
    public boolean onChange(SettingCommonSeekBar r3, int r4) {
        if (this.mPreventSeekBarCallbacks == false) goto L6;
        return true;
    L6:
        if (this.mSpeechRateSeekbar != r3) goto L9;
        updateSpeechRate(r4);
    L11:
        return true;
    L9:
        if (this.mSpeechPitchSeekbar != r3) goto L11;
        updateSpeechPitchValue(r4);
        goto L11
    }

    @Override // com.android.settings.widget.SettingCommonSeekBar.OnResetClickListener
    public void onReset(SettingCommonSeekBar r3) {
        if (this.mSpeechRateSeekbar != r3) goto L6;
        updateSpeechRate(100);
        this.mSpeechRateSeekbar.setProgress(100);
        return;
    L6:
        if (this.mSpeechPitchSeekbar != r3) goto L10;
        updateSpeechPitchValue(100);
        this.mSpeechPitchSeekbar.setProgress(100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 != GET_SAMPLE_TEXT) goto L6;
        onSampleTextReceived(r3, r4);
        return;
    L6:
        if (r2 != VOICE_DATA_INTEGRITY_CHECK) goto L13;
        Message r5 = this.mInitMessage;
        if (r5 == null) goto L10;
        r5.sendToTarget();
        this.mInitMessage = null;
    L10:
        onVoiceDataIntegrityCheckDone(r4);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        TextToSpeech r0 = this.mTts;
        if (r0 == null) goto L6;
        r0.shutdown();
        this.mTts = null;
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_tts_TTSSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TTSSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_tts_TTSSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_tts_TTSSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TTSSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_tts_TTSSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_tts_TTSSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TTSSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_tts_TTSSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
