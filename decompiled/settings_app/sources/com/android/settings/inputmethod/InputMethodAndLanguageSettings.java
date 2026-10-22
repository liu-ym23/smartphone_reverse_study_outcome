package com.android.settings.inputmethod;

import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputManager;
import android.hardware.input.KeyboardLayout;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.InputDevice;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.android.internal.app.LocaleHelper;
import com.android.internal.app.LocalePicker;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.SubSettings;
import com.android.settings.Utils;
import com.android.settings.VoiceInputOutputSettings;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class InputMethodAndLanguageSettings extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener, InputManager.InputDeviceListener, KeyboardLayoutDialogFragment.OnSetupKeyboardLayoutsListener, Indexable, InputMethodPreference.OnSavePreferenceListener {
    private static final String KEY_CURRENT_INPUT_METHOD = "current_input_method";
    private static final String KEY_INPUT_METHOD_SELECTOR = "input_method_selector";
    private static final String KEY_PHONE_LANGUAGE = "phone_language";
    private static final String KEY_PREVIOUSLY_ENABLED_SUBTYPES = "previously_enabled_subtypes";
    private static final String KEY_SPELL_CHECKERS = "spellcheckers_settings";
    private static final String KEY_USER_DICTIONARY_SETTINGS = "key_user_dictionary_settings";
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    private static final boolean SHOW_INPUT_METHOD_SWITCHER_SETTINGS = false;
    private int mDefaultInputMethodSelectorVisibility;
    private DevicePolicyManager mDpm;
    private PreferenceCategory mGameControllerCategory;
    private Handler mHandler;
    private PreferenceCategory mHardKeyboardCategory;
    private final ArrayList<PreferenceScreen> mHardKeyboardPreferenceList;
    private InputManager mIm;
    private InputMethodManager mImm;
    private final ArrayList<InputMethodPreference> mInputMethodPreferenceList;
    private InputMethodSettingValuesWrapper mInputMethodSettingValues;
    private Intent mIntentWaitingForResult;
    private PreferenceCategory mKeyboardSettingsCategory;
    private Preference mLanguagePref;
    private SettingsObserver mSettingsObserver;
    private ListPreference mShowInputMethodSelectorPref;
    private boolean mShowsOnlyFullImeAndKeyboardList;

    private class SettingsObserver extends ContentObserver {
        private Context mContext;
        final /* synthetic */ InputMethodAndLanguageSettings this$0;

        public SettingsObserver(InputMethodAndLanguageSettings r1, Handler r2, Context r3) {
            this.this$0 = r1;
            super(r2);
            this.mContext = r3;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            InputMethodAndLanguageSettings.access$100(this.this$0);
        }

        public void resume() {
            ContentResolver r0 = this.mContext.getContentResolver();
            r0.registerContentObserver(Settings.Secure.getUriFor("default_input_method"), false, this);
            r0.registerContentObserver(Settings.Secure.getUriFor("selected_input_method_subtype"), false, this);
        }

        public void pause() {
            this.mContext.getContentResolver().unregisterContentObserver(this);
        }
    }

    private void showKeyboardLayoutDialog(InputDeviceIdentifier r1) {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_InputMethodAndLanguageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r1, Object r2) {
        return false;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_InputMethodAndLanguageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.inputmethod.KeyboardLayoutDialogFragment.OnSetupKeyboardLayoutsListener
    public void onSetupKeyboardLayouts(InputDeviceIdentifier r1) {
    }

    public InputMethodAndLanguageSettings() {
        this.mDefaultInputMethodSelectorVisibility = 0;
        this.mInputMethodPreferenceList = new ArrayList();
        this.mHardKeyboardPreferenceList = new ArrayList();
    }

    static /* synthetic */ void access$000(InputMethodAndLanguageSettings r0, InputDeviceIdentifier r1) {
        r0.showKeyboardLayoutDialog(r1);
    }

    static /* synthetic */ void access$100(InputMethodAndLanguageSettings r0) {
        r0.updateCurrentImeName();
    }

    static /* synthetic */ String access$200(Context r0) {
        return getLocaleNames(r0);
    }

    static /* synthetic */ boolean access$300() {
        return haveInputDeviceWithVibrator();
    }

    public void com_android_settings_inputmethod_InputMethodAndLanguageSettings__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        addPreferencesFromResource(R.xml.language_settings);
        FragmentActivity r7 = getActivity();
        this.mImm = (InputMethodManager) getSystemService("input_method");
        this.mInputMethodSettingValues = InputMethodSettingValuesWrapper.getInstance(r7);
        this.mDefaultInputMethodSelectorVisibility = Integer.valueOf(getString(R.string.input_method_selector_visibility_default_value)).intValue();     // Catch: NumberFormatException -> L24
    L5:
        if (r7.getAssets().getLocales().length != 1) goto L7;
        getPreferenceScreen().removePreference(findPreference(KEY_PHONE_LANGUAGE));
    L8:
        new VoiceInputOutputSettings(this).onCreate();
        this.mHardKeyboardCategory = (PreferenceCategory) findPreference("hard_keyboard");
        this.mKeyboardSettingsCategory = (PreferenceCategory) findPreference("keyboard_settings_category");
        this.mGameControllerCategory = (PreferenceCategory) findPreference("game_controller_settings_category");
        Intent r0 = r7.getIntent();
        boolean r1 = "android.settings.INPUT_METHOD_SETTINGS".equals(r0.getAction());
        this.mShowsOnlyFullImeAndKeyboardList = r1;
        if (r1 == false) goto L16;
        getPreferenceScreen().removeAll();
        if (this.mHardKeyboardCategory == null) goto L13;
        getPreferenceScreen().addPreference(this.mHardKeyboardCategory);
    L13:
        PreferenceCategory r2 = this.mKeyboardSettingsCategory;
        if (r2 == null) goto L16;
        r2.removeAll();
        getPreferenceScreen().addPreference(this.mKeyboardSettingsCategory);
    L16:
        this.mIm = (InputManager) r7.getSystemService("input");
        updateInputDevices();
        Preference r3 = findPreference(KEY_SPELL_CHECKERS);
        if (r3 == null) goto L19;
        InputMethodAndSubtypeUtil.removeUnnecessaryNonPersistentPreference(r3);
        Intent r4 = new Intent("android.intent.action.MAIN");
        r4.setClass(r7, SubSettings.class);
        r4.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT, SpellCheckersSettings.class.getName());
        r4.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RESID, R.string.spellcheckers_settings_title);
        r3.setIntent(r4);
    L19:
        this.mHandler = new Handler();
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler, r7);
        this.mDpm = (DevicePolicyManager) getActivity().getSystemService("device_policy");
        InputDeviceIdentifier r8 = (InputDeviceIdentifier) r0.getParcelableExtra("input_device_identifier");
        if (this.mShowsOnlyFullImeAndKeyboardList == false) goto L27;
        if (r8 == null) goto L28;
        showKeyboardLayoutDialog(r8);
        return;
    L28:
        return;
    L27:
        return;
    L7:
        this.mLanguagePref = findPreference(KEY_PHONE_LANGUAGE);
        goto L8
    }

    private void updateInputMethodSelectorSummary(int r3) {
        String[] r0 = getResources().getStringArray(R.array.input_method_selector_titles);
        if (r0.length <= r3) goto L6;
        this.mShowInputMethodSelectorPref.setSummary(r0[r3]);
        this.mShowInputMethodSelectorPref.setValue(String.valueOf(r3));
        return;
    }

    private void updateUserDictionaryPreference(Preference r3) {
        final TreeSet<String> r0 = UserDictionaryList.getUserDictionaryLocalesSet(getActivity());
        if (r0 != null) goto L5;
        getPreferenceScreen().removePreference(r3);
        return;
    L5:
        r3.setOnPreferenceClickListener(new AnonymousClass1(this, r0));
    }

    public void com_android_settings_inputmethod_InputMethodAndLanguageSettings__onResume$___twin___() {
        super.onResume();
        this.mSettingsObserver.resume();
        this.mIm.registerInputDeviceListener(this, null);
        Preference r0 = findPreference(KEY_SPELL_CHECKERS);
        if (r0 == null) goto L17;
        TextServicesManager r1 = (TextServicesManager) getSystemService("textservices");
        if (r1 != null) goto L7;
    L9:
        if (r1 == null) goto L17;
        if (r1.isSpellCheckerEnabled() == false) goto L17;
        SpellCheckerInfo r2 = r1.getCurrentSpellChecker();
        if (r2 == null) goto L15;
        r0.setSummary(r2.loadLabel(getPackageManager()));
        goto L17
    L15:
        r0.setSummary(R.string.spell_checker_not_selected);
        goto L17
    L7:
        if (r1.isSpellCheckerEnabled() == true) goto L9;
        r0.setSummary(R.string.switch_off_text);
    L17:
        if (this.mShowsOnlyFullImeAndKeyboardList == false) goto L19;
    L22:
        updateInputDevices();
        this.mInputMethodSettingValues.refreshAllInputMethodAndSubtypes();
        updateInputMethodPreferenceViews();
        return;
    L19:
        if (this.mLanguagePref == null) goto L21;
        String r3 = getLocaleNames(getActivity());
        this.mLanguagePref.setSummary(r3);
    L21:
        updateUserDictionaryPreference(findPreference(KEY_USER_DICTIONARY_SETTINGS));
        goto L22
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIm.unregisterInputDeviceListener(this);
        this.mSettingsObserver.pause();
        InputMethodAndSubtypeUtil.saveInputMethodSubtypeList(this, getContentResolver(), this.mInputMethodSettingValues.getInputMethodList(), !this.mHardKeyboardPreferenceList.isEmpty());
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int r1) {
        updateInputDevices();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int r1) {
        updateInputDevices();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int r1) {
        updateInputDevices();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r4) {
        if (Utils.isMonkeyRunning() == false) goto L7;
        return false;
    L7:
        if ((r4 instanceof PreferenceScreen) == false) goto L15;
        if (r4.getFragment() != null) goto L21;
        if (KEY_CURRENT_INPUT_METHOD.equals(r4.getKey()) == false) goto L21;
        ((InputMethodManager) getSystemService("input_method")).showInputMethodPicker();
    L21:
        return super.onPreferenceTreeClick(r4);
    L15:
        if ((r4 instanceof SwitchPreference) == false) goto L21;
        SwitchPreference r0 = (SwitchPreference) r4;
        if (r0 != this.mGameControllerCategory.findPreference("vibrate_input_devices")) goto L21;
        Settings.System.putInt(getContentResolver(), "vibrate_input_devices", r0.isChecked() ? 1 : 0);
        return true;
    }

    private static String getLocaleNames(Context r2) {
        LocaleList r3 = LocalePicker.getLocales();
        Locale r0 = Locale.getDefault();
        return LocaleHelper.toSentenceCase(LocaleHelper.getDisplayLocaleList(r3, r0, 2), r0);
    }

    private void saveInputMethodSelectorVisibility(String r3) {
        int r4 = Integer.valueOf(r3).intValue();     // Catch: NumberFormatException -> L4
        Settings.Secure.putInt(getContentResolver(), "input_method_selector_visibility", r4);     // Catch: NumberFormatException -> L4
        updateInputMethodSelectorSummary(r4);     // Catch: NumberFormatException -> L4
        return;
    }

    private int loadInputMethodSelectorVisibility() {
        return Settings.Secure.getInt(getContentResolver(), "input_method_selector_visibility", this.mDefaultInputMethodSelectorVisibility);
    }

    private void updateInputMethodPreferenceViews() {
        if (this.mKeyboardSettingsCategory != null) goto L5;
        return;
    L5:
        ArrayList<InputMethodPreference> r0 = this.mInputMethodPreferenceList;
        monitor-enter(r0);
        Iterator<InputMethodPreference> r1 = this.mInputMethodPreferenceList.iterator();     // Catch: Throwable -> L35
    L9:
        if (r1.hasNext() == false) goto L11;
        this.mKeyboardSettingsCategory.removePreference(r1.next());     // Catch: Throwable -> L35
        goto L9
    L11:
        this.mInputMethodPreferenceList.clear();     // Catch: Throwable -> L35
        List r2 = this.mDpm.getPermittedInputMethodsForCurrentUser();     // Catch: Throwable -> L35
        Context r8 = getPrefContext();     // Catch: Throwable -> L35
        if (this.mShowsOnlyFullImeAndKeyboardList == false) goto L14;
        List<InputMethodInfo> r3 = this.mInputMethodSettingValues.getInputMethodList();     // Catch: Throwable -> L35
    L15:
        List<InputMethodInfo> r9 = r3;
        int r10 = 0;
        if (r9 != null) goto L18;
        int r11 = 0;
    L19:
        int r12 = 0;
    L20:
        if (r12 >= r11) goto L29;
        InputMethodInfo r4 = r9.get(r12);     // Catch: Throwable -> L35
        if (r2 != null) goto L24;
    L27:
        boolean r6 = true;
    L28:
        this.mInputMethodPreferenceList.add(new InputMethodPreference(r8, r4, this.mShowsOnlyFullImeAndKeyboardList, r6, this));     // Catch: Throwable -> L35
        r12 = r12 + 1;     // Catch: Throwable -> L35
        goto L20
    L24:
        if (r2.contains(r4.getPackageName()) == true) goto L27;
        r6 = false;
        goto L28
    L29:
        final Collator r5 = Collator.getInstance();     // Catch: Throwable -> L35
        Collections.sort(this.mInputMethodPreferenceList, new AnonymousClass2(this, r5));     // Catch: Throwable -> L35
    L30:
        if (r10 >= r11) goto L32;
        InputMethodPreference r7 = this.mInputMethodPreferenceList.get(r10);     // Catch: Throwable -> L35
        this.mKeyboardSettingsCategory.addPreference(r7);     // Catch: Throwable -> L35
        InputMethodAndSubtypeUtil.removeUnnecessaryNonPersistentPreference(r7);     // Catch: Throwable -> L35
        r7.updatePreferenceViews();     // Catch: Throwable -> L35
        r10 = r10 + 1;     // Catch: Throwable -> L35
        goto L30
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L35
        updateCurrentImeName();
        InputMethodAndSubtypeUtil.loadInputMethodSubtypeList(this, getContentResolver(), this.mInputMethodSettingValues.getInputMethodList(), null);
        return;
    L18:
        r11 = r9.size();     // Catch: Throwable -> L35
        goto L19
    L14:
        r3 = this.mImm.getEnabledInputMethodList();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    @Override // com.android.settings.inputmethod.InputMethodPreference.OnSavePreferenceListener
    public void onSaveInputMethodPreference(InputMethodPreference r5) {
        InputMethodInfo r0 = r5.getInputMethodInfo();
        if (r5.isChecked() == true) goto L6;
        saveEnabledSubtypesOf(r0);
    L6:
        if (getResources().getConfiguration().keyboard != 2) goto L8;
        boolean r1 = true;
    L9:
        InputMethodAndSubtypeUtil.saveInputMethodSubtypeList(this, getContentResolver(), this.mImm.getInputMethodList(), r1);
        this.mInputMethodSettingValues.refreshAllInputMethodAndSubtypes();
        if (r5.isChecked() == false) goto L12;
        restorePreviouslyEnabledSubtypesOf(r0);
    L12:
        Iterator<InputMethodPreference> r4 = this.mInputMethodPreferenceList.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        r4.next().updatePreferenceViews();
        goto L14
    L16:
        return;
    L8:
        r1 = false;
        goto L9
    }

    private void saveEnabledSubtypesOf(InputMethodInfo r4) {
        HashSet<String> r0 = new HashSet();
        Iterator<InputMethodSubtype> r1 = this.mImm.getEnabledInputMethodSubtypeList(r4, true).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(Integer.toString(r1.next().hashCode()));
        goto L4
    L6:
        HashMap<String, HashSet<String>> r2 = loadPreviouslyEnabledSubtypeIdsMap();
        r2.put(r4.getId(), r0);
        savePreviouslyEnabledSubtypeIdsMap(r2);
    }

    private void restorePreviouslyEnabledSubtypesOf(InputMethodInfo r3) {
        HashMap<String, HashSet<String>> r0 = loadPreviouslyEnabledSubtypeIdsMap();
        String r4 = r3.getId();
        HashSet<String> r1 = r0.remove(r4);
        if (r1 != null) goto L5;
        return;
    L5:
        savePreviouslyEnabledSubtypeIdsMap(r0);
        InputMethodAndSubtypeUtil.enableInputMethodSubtypesOf(getContentResolver(), r4, r1);
    }

    private HashMap<String, HashSet<String>> loadPreviouslyEnabledSubtypeIdsMap() {
        return InputMethodAndSubtypeUtil.parseInputMethodsAndSubtypesString(PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(KEY_PREVIOUSLY_ENABLED_SUBTYPES, null));
    }

    private void savePreviouslyEnabledSubtypeIdsMap(HashMap<String, HashSet<String>> r2) {
        SharedPreferences r1 = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String r3 = InputMethodAndSubtypeUtil.buildInputMethodsAndSubtypesString(r2);
        r1.edit().putString(KEY_PREVIOUSLY_ENABLED_SUBTYPES, r3).apply();
    }

    private void updateCurrentImeName() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mImm == null) goto L24;
        Preference r1 = getPreferenceScreen().findPreference(KEY_CURRENT_INPUT_METHOD);
        if (r1 == null) goto L21;
        CharSequence r2 = this.mInputMethodSettingValues.getCurrentInputMethodName(r0);
        if (TextUtils.isEmpty(r2) == true) goto L22;
        monitor-enter(this);
        r1.setSummary(r2);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L22:
        return;
    L21:
        return;
    }

    private void updateInputDevices() {
        updateHardKeyboards();
        updateGameControllers();
    }

    private void updateHardKeyboards() {
        if (this.mHardKeyboardCategory != null) goto L5;
        return;
    L5:
        this.mHardKeyboardPreferenceList.clear();
        int[] r0 = InputDevice.getDeviceIds();
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r2 >= r0.length) goto L25;
        InputDevice r3 = InputDevice.getDevice(r0[r2]);
        if (r3 == null) goto L23;
        if (r3.isVirtual() == true) goto L23;
        if (r3.isFullKeyboard() == false) goto L23;
        final InputDeviceIdentifier r4 = r3.getIdentifier();
        String r5 = this.mIm.getCurrentKeyboardLayoutForInputDevice(r4);
        if (r5 == null) goto L17;
        KeyboardLayout r6 = this.mIm.getKeyboardLayout(r5);
    L18:
        PreferenceScreen r7 = new PreferenceScreen(getPrefContext(), null);
        r7.setTitle(r3.getName());
        if (r6 == null) goto L21;
        r7.setSummary(r6.toString());
    L22:
        r7.setOnPreferenceClickListener(new AnonymousClass3(this, r4));
        this.mHardKeyboardPreferenceList.add(r7);
        goto L23
    L21:
        r7.setSummary(R.string.keyboard_layout_default_label);
        goto L22
    L17:
        r6 = null;
    L23:
        r2 = r2 + 1;
        goto L7
    L25:
        if (this.mHardKeyboardPreferenceList.isEmpty() == true) goto L37;
        int r8 = this.mHardKeyboardCategory.getPreferenceCount();
    L27:
        int r9 = r8 - 1;
        if (r8 <= 0) goto L33;
        Preference r10 = this.mHardKeyboardCategory.getPreference(r9);
        if (r10.getOrder() >= 1000) goto L32;
        this.mHardKeyboardCategory.removePreference(r10);
    L32:
        r8 = r9;
        goto L27
    L33:
        Collections.sort(this.mHardKeyboardPreferenceList);
        int r11 = this.mHardKeyboardPreferenceList.size();
    L34:
        if (r1 >= r11) goto L36;
        PreferenceScreen r12 = this.mHardKeyboardPreferenceList.get(r1);
        r12.setOrder(r1);
        this.mHardKeyboardCategory.addPreference(r12);
        r1 = r1 + 1;
        goto L34
    L36:
        getPreferenceScreen().addPreference(this.mHardKeyboardCategory);
        return;
    L37:
        getPreferenceScreen().removePreference(this.mHardKeyboardCategory);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        Intent r4 = this.mIntentWaitingForResult;
        if (r4 == null) goto L6;
        InputDeviceIdentifier r5 = (InputDeviceIdentifier) r4.getParcelableExtra("input_device_identifier");
        this.mIntentWaitingForResult = null;
        showKeyboardLayoutDialog(r5);
        return;
    }

    private void updateGameControllers() {
        if (haveInputDeviceWithVibrator() == false) goto L9;
        getPreferenceScreen().addPreference(this.mGameControllerCategory);
        CheckBoxPreference r0 = (CheckBoxPreference) this.mGameControllerCategory.findPreference("vibrate_input_devices");
        boolean r2 = true;
        if (Settings.System.getInt(getContentResolver(), "vibrate_input_devices", 1) > 0) goto L8;
        r2 = false;
    L8:
        r0.setChecked(r2);
        return;
    L9:
        getPreferenceScreen().removePreference(this.mGameControllerCategory);
    }

    private static boolean haveInputDeviceWithVibrator() {
        int[] r0 = InputDevice.getDeviceIds();
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L14;
        InputDevice r3 = InputDevice.getDevice(r0[r2]);
        if (r3 == null) goto L13;
        if (r3.isVirtual() == true) goto L13;
        if (r3.getVibrator().hasVibrator() == false) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L4
    L14:
        return false;
    }

    static {
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass4();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_InputMethodAndLanguageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(InputMethodAndLanguageSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_InputMethodAndLanguageSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_InputMethodAndLanguageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(InputMethodAndLanguageSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_InputMethodAndLanguageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_InputMethodAndLanguageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(InputMethodAndLanguageSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_InputMethodAndLanguageSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
