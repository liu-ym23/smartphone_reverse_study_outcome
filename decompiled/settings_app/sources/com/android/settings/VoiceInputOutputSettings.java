package com.android.settings;

import android.speech.tts.TtsEngines;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import com.android.settings.utils.NullSafe;

/* JADX INFO: loaded from: classes2.dex */
public class VoiceInputOutputSettings {
    private static final String KEY_TTS_SETTINGS = "tts_settings";
    private static final String KEY_VOICE_CATEGORY = "voice_category";
    private static final String TAG = "VoiceInputOutputSettings";
    private final SettingsPreferenceFragment mFragment;
    private PreferenceGroup mParent;
    private final TtsEngines mTtsEngines;
    private Preference mTtsSettingsPref;
    private PreferenceCategory mVoiceCategory;
    private Preference mVoiceInputSettingsPref;

    public VoiceInputOutputSettings(SettingsPreferenceFragment r2) {
        this.mFragment = r2;
        this.mTtsEngines = new TtsEngines(r2.getPreferenceScreen().getContext());
    }

    public void onCreate() {
        PreferenceScreen r0 = this.mFragment.getPreferenceScreen();
        this.mParent = r0;
        PreferenceCategory r1 = (PreferenceCategory) NullSafe.nonNull(r0.findPreference(KEY_VOICE_CATEGORY));
        this.mVoiceCategory = r1;
        this.mTtsSettingsPref = r1.findPreference(KEY_TTS_SETTINGS);
        populateOrRemovePreferences();
    }

    private void populateOrRemovePreferences() {
        if (populateOrRemoveTtsPrefs() == true) goto L6;
        this.mFragment.getPreferenceScreen().removePreference(this.mVoiceCategory);
        return;
    }

    private boolean populateOrRemoveTtsPrefs() {
        if (this.mTtsEngines.getEngines().isEmpty() == false) goto L6;
        this.mVoiceCategory.removePreference(this.mTtsSettingsPref);
        return false;
    L6:
        return true;
    }
}
