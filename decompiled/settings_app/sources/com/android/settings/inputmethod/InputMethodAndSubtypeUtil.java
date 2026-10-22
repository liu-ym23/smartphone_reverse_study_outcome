package com.android.settings.inputmethod;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.icu.text.ListFormatter;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.TwoStatePreference;
import com.android.internal.app.LocaleHelper;
import com.android.internal.inputmethod.InputMethodUtils;
import com.android.settings.Constants;
import com.android.settings.PreferenceMgr;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
class InputMethodAndSubtypeUtil {
    private static final boolean DEBUG = false;
    protected static final String DEF_CHUBAO_IME_ID = "com.cootek.smartinputv5/com.cootek.smartinput5.TouchPalIME";
    protected static final String DEF_CHUBAO_IME_PKG = "com.cootek.smartinputv5";
    protected static final String DEF_GOOGLE_IME_ID = "com.google.android.inputmethod.pinyin/.PinyinIME";
    protected static final String DEF_GOOGLE_IME_PKG = "com.google.android.inputmethod.pinyin";
    protected static final String DEF_LATIN_IME_ID = "com.android.inputmethod.latin/.LatinIME";
    protected static final String DEF_OCEAN_IME_ID = "com.bytedance.android.doubaoime/.ImeService";
    private static final Locale ENGLISH_LOCALE = null;
    private static final char INPUT_METHOD_SEPARATER = ':';
    private static final char INPUT_METHOD_SUBTYPE_SEPARATER = ';';
    private static final int NOT_A_SUBTYPE_ID = -1;
    static final String TAG = "InputMethdAndSubtypeUtil";
    private static final TextUtils.SimpleStringSplitter sStringInputMethodSplitter = null;
    private static final TextUtils.SimpleStringSplitter sStringInputMethodSubtypeSplitter = null;

    public static class ImeSubtypeHolder {
        boolean checked;
        InputMethodInfo imi;

        public ImeSubtypeHolder() {
        }
    }

    InputMethodAndSubtypeUtil() {
    }

    static {
        ENGLISH_LOCALE = new Locale("en");
        sStringInputMethodSplitter = new TextUtils.SimpleStringSplitter(':');
        sStringInputMethodSubtypeSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SUBTYPE_SEPARATER);
    }

    static String buildInputMethodsAndSubtypesString(HashMap<String, HashSet<String>> r5) {
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r1 = r5.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();
        if (r0.length() <= 0) goto L8;
        r0.append(':');
    L8:
        HashSet<String> r3 = r5.get(r2);
        r0.append(r2);
        Iterator<String> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L4;
        String r6 = r4.next();
        r0.append(INPUT_METHOD_SUBTYPE_SEPARATER).append(r6);
        goto L10
    L13:
        return r0.toString();
    }

    private static String buildInputMethodsString(HashSet<String> r3) {
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        String r1 = r4.next();
        if (r0.length() <= 0) goto L8;
        r0.append(':');
    L8:
        r0.append(r1);
        goto L4
    L10:
        return r0.toString();
    }

    private static int getInputMethodSubtypeSelected(ContentResolver r1) {
        return Settings.Secure.getInt(r1, "selected_input_method_subtype");
    L4:
        return -1;
    }

    private static boolean isInputMethodSubtypeSelected(ContentResolver r1) {
        if (getInputMethodSubtypeSelected(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private static void putSelectedInputMethodSubtype(ContentResolver r1, int r2) {
        Settings.Secure.putInt(r1, "selected_input_method_subtype", r2);
    }

    public static HashMap<String, HashSet<String>> getEnabledInputMethodsAndSubtypeList(ContentResolver r2) {
        String r3 = Settings.Secure.getString(r2, "enabled_input_methods");
        OLog.d(TAG, "getEnabledInputMethodsAndSubtypeList --- Load enabled input methods: " + r3);
        return parseInputMethodsAndSubtypesString(r3);
    }

    static synchronized HashMap<String, HashSet<String>> parseInputMethodsAndSubtypesString(String r5) {
        monitor-enter(InputMethodAndSubtypeUtil.class);
        HashMap<String, HashSet<String>> r1 = new HashMap();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r5) == false) goto L8;
        monitor-exit(InputMethodAndSubtypeUtil.class);
        return r1;
    L8:
        sStringInputMethodSplitter.setString(r5);     // Catch: Throwable -> L21
    L9:
        TextUtils.SimpleStringSplitter r6 = sStringInputMethodSplitter;     // Catch: Throwable -> L21
        if (r6.hasNext() == false) goto L19;
        String r7 = r6.next();     // Catch: Throwable -> L21
        TextUtils.SimpleStringSplitter r2 = sStringInputMethodSubtypeSplitter;     // Catch: Throwable -> L21
        r2.setString(r7);     // Catch: Throwable -> L21
        if (r2.hasNext() == false) goto L9;
        HashSet<String> r8 = new HashSet();     // Catch: Throwable -> L21
        String r3 = r2.next();     // Catch: Throwable -> L21
    L14:
        TextUtils.SimpleStringSplitter r4 = sStringInputMethodSubtypeSplitter;     // Catch: Throwable -> L21
        if (r4.hasNext() == false) goto L17;
        r8.add(r4.next());     // Catch: Throwable -> L21
        goto L14
    L17:
        r1.put(r3, r8);     // Catch: Throwable -> L21
        goto L9
    L19:
        monitor-exit(InputMethodAndSubtypeUtil.class);
        return r1;
    L21:
        th = move-exception;
        throw th;
    }

    static void enableInputMethodSubtypesOf(ContentResolver r1, String r2, HashSet<String> r3) {
        HashMap<String, HashSet<String>> r0 = getEnabledInputMethodsAndSubtypeList(r1);
        r0.put(r2, r3);
        String r4 = buildInputMethodsAndSubtypesString(r0);
        OLog.d(TAG, "enableInputMethodSubtypesOf :" + r4);
        Settings.Secure.putString(r1, "enabled_input_methods", r4);
    }

    private static HashSet<String> getDisabledSystemIMEs(ContentResolver r2) {
        HashSet<String> r0 = new HashSet();
        String r3 = Settings.Secure.getString(r2, "disabled_system_input_methods");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return r0;
    L5:
        sStringInputMethodSplitter.setString(r3);
    L6:
        TextUtils.SimpleStringSplitter r4 = sStringInputMethodSplitter;
        if (r4.hasNext() == false) goto L9;
        r0.add(r4.next());
        goto L6
    L9:
        return r0;
    }

    public static String getCurrentInputMethodId(Context r1) {
        return Settings.Secure.getString(r1.getContentResolver(), "default_input_method");
    }

    public static void saveInputMethodSubtypeList(SettingsPreferenceFragment r23, ContentResolver r24, List<InputMethodInfo> r25, boolean r26) {
        String r3 = Settings.Secure.getString(r24, "default_input_method");
        int r4 = getInputMethodSubtypeSelected(r24);
        HashMap<String, HashSet<String>> r5 = getEnabledInputMethodsAndSubtypeList(r24);
        HashSet<String> r6 = getDisabledSystemIMEs(r24);
        Iterator<InputMethodInfo> r7 = r25.iterator();
        boolean r9 = false;
    L4:
        if (r7.hasNext() == false) goto L53;
        InputMethodInfo r10 = r7.next();
        String r11 = r10.getId();
        Preference r12 = r23.findPreference(r11);
        if (r12 == null) goto L4;
        if ((r12 instanceof TwoStatePreference) == false) goto L11;
        boolean r13 = ((TwoStatePreference) r12).isChecked();
    L12:
        boolean r14 = r11.equals(r3);
        boolean r15 = InputMethodUtils.isSystemIme(r10);
        if (r26 == false) goto L15;
    L16:
        if (r13 == true) goto L18;
        Iterator<InputMethodInfo> r16 = r7;
        r5.remove(r11);
        if (r14 == false) goto L44;
        r3 = null;
    L44:
        if (r15 == false) goto L52;
        if (r26 == false) goto L52;
        if (r6.contains(r11) == false) goto L50;
        if (r13 == false) goto L52;
        r6.remove(r11);
        goto L52
    L50:
        if (r13 == true) goto L52;
        r6.add(r11);
    L52:
        r7 = r16;
    L18:
        if (r5.containsKey(r11) == true) goto L20;
        r5.put(r11, new HashSet());
    L20:
        HashSet<String> r8 = r5.get(r11);
        int r17 = r10.getSubtypeCount();
        r16 = r7;
        int r18 = 0;
        boolean r19 = false;
    L21:
        if (r18 >= r17) goto L44;
        InputMethodSubtype r110 = r10.getSubtypeAt(r18);
        boolean r20 = r9;
        String r21 = String.valueOf(r110.hashCode());
        InputMethodInfo r111 = r10;
        TwoStatePreference r112 = (TwoStatePreference) r23.findPreference(r11 + r21);
        if (r112 != null) goto L25;
        r9 = r20;
    L39:
        r18 = r18 + 1;
        r10 = r111;
        goto L21
    L25:
        if (r19 == true) goto L27;
        r8.clear();
        boolean r113 = true;
        boolean r22 = true;
    L29:
        if (r112.isEnabled() == true) goto L31;
    L37:
        r8.remove(r21);
    L38:
        r9 = r113;
        r19 = r22;
        goto L39
    L31:
        if (r112.isChecked() == false) goto L37;
        r8.add(r21);
        if (r14 == false) goto L38;
        if (r4 != r110.hashCode()) goto L38;
        r19 = r22;
        r9 = false;
        goto L39
    L27:
        r22 = r19;
        r113 = r20;
        goto L29
    L15:
        if (InputMethodSettingValuesWrapper.getInstance(r23.getActivity()).isAlwaysCheckedIme(r10, r23.getActivity()) == true) goto L18;
    L11:
        r13 = r5.containsKey(r11);
        goto L12
    L53:
        String r0 = buildInputMethodsAndSubtypesString(r5);
        String r27 = buildInputMethodsString(r6);
        OLog.d(TAG, "--- Save enabled inputmethod settings. :" + r0);
        OLog.d(TAG, "--- Save disabled system inputmethod settings. :" + r27);
        OLog.d(TAG, "--- Save default inputmethod settings. :" + r3);
        OLog.d(TAG, "--- Needs to reset the selected subtype :" + r9);
        OLog.d(TAG, "--- Subtype is selected :" + isInputMethodSubtypeSelected(r24));
        if (r9 == false) goto L56;
    L57:
        putSelectedInputMethodSubtype(r24, -1);
    L58:
        Settings.Secure.putString(r24, "enabled_input_methods", r0);
        if (r27.length() <= 0) goto L61;
        Settings.Secure.putString(r24, "disabled_system_input_methods", r27);
    L61:
        if (r3 != null) goto L64;
        r3 = "";
    L64:
        Settings.Secure.putString(r24, "default_input_method", r3);
        return;
    L56:
        if (isInputMethodSubtypeSelected(r24) == true) goto L58;
        goto L57
    }

    static void loadInputMethodSubtypeList(SettingsPreferenceFragment r5, ContentResolver r6, List<InputMethodInfo> r7, Map<String, List<Preference>> r8) {
        HashMap<String, HashSet<String>> r9 = getEnabledInputMethodsAndSubtypeList(r6);
        Iterator<InputMethodInfo> r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        String r1 = r0.next().getId();
        Preference r2 = r5.findPreference(r1);
        if ((r2 instanceof TwoStatePreference) == false) goto L4;
        boolean r3 = r9.containsKey(r1);
        ((TwoStatePreference) r2).setChecked(r3);
        if (r8 == null) goto L13;
        Iterator<Preference> r4 = r8.get(r1).iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r4.next().setEnabled(r3);
    L13:
        setSubtypesPreferenceEnabled(r5, r7, r1, r3);
        goto L4
    L14:
        updateSubtypesPreferenceChecked(r5, r7, r9);
    }

    static void setSubtypesPreferenceEnabled(SettingsPreferenceFragment r5, List<InputMethodInfo> r6, String r7, boolean r8) {
        PreferenceScreen r9 = r5.getPreferenceScreen();
        Iterator<InputMethodInfo> r10 = r6.iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        InputMethodInfo r0 = r10.next();
        if (r7.equals(r0.getId()) == false) goto L4;
        int r1 = r0.getSubtypeCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L4;
        TwoStatePreference r3 = (TwoStatePreference) r9.findPreference(r7 + r0.getSubtypeAt(r2).hashCode());
        if (r3 == null) goto L12;
        r3.setEnabled(r8);
    L12:
        r2 = r2 + 1;
        goto L8
    }

    private static void updateSubtypesPreferenceChecked(SettingsPreferenceFragment r7, List<InputMethodInfo> r8, HashMap<String, HashSet<String>> r9) {
        PreferenceScreen r10 = r7.getPreferenceScreen();
        Iterator<InputMethodInfo> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        InputMethodInfo r0 = r11.next();
        String r1 = r0.getId();
        if (r9.containsKey(r1) == false) goto L4;
        HashSet<String> r2 = r9.get(r1);
        int r3 = r0.getSubtypeCount();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L4;
        String r5 = String.valueOf(r0.getSubtypeAt(r4).hashCode());
        TwoStatePreference r6 = (TwoStatePreference) r10.findPreference(r1 + r5);
        if (r6 == null) goto L13;
        r6.setChecked(r2.contains(r5));
    L13:
        r4 = r4 + 1;
        goto L9
    }

    protected static boolean isPackageInstalledAndIsSystemApp(Context r0, String r1) {
        return Utils.isPackageInstalledAndIsSystemApp(r0, r1);
    }

    public static void saveInputMethodSubtypeList(Context r26, List<ImeSubtypeHolder> r27, ContentResolver r28, boolean r29) {
        String r2 = getCurrentInputMethodId(r26);
        boolean r4 = DEF_GOOGLE_IME_ID.equals(r2);
        String r5 = DEF_CHUBAO_IME_ID;
        if (r4 == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        int r8 = getInputMethodSubtypeSelected(r28);
        HashMap<String, HashSet<String>> r9 = getEnabledInputMethodsAndSubtypeList(r28);
        HashSet<String> r10 = getDisabledSystemIMEs(r28);
        int r11 = r27.size();
        int r12 = 0;
        boolean r13 = false;
    L10:
        if (r12 >= r11) goto L45;
        ImeSubtypeHolder r15 = r27.get(r12);
        InputMethodInfo r7 = r15.imi;
        String r14 = r7.getId();
        boolean r16 = r15.checked;
        boolean r17 = r14.equals(r2);
        boolean r18 = InputMethodUtils.isSystemIme(r7);
        int r19 = r11;
        InputMethodSettingValuesWrapper r110 = InputMethodSettingValuesWrapper.getInstance(r26);
        if (r29 == false) goto L14;
    L15:
        if (r16 == true) goto L17;
        boolean r25 = r6;
        String r111 = r5;
        r9.remove(r14);
        if (r17 == false) goto L36;
        r2 = null;
    L36:
        if (r18 == false) goto L44;
        if (r29 == false) goto L44;
        if (r10.contains(r14) == false) goto L42;
        if (r16 == false) goto L44;
        r10.remove(r14);
        goto L44
    L42:
        if (r16 == true) goto L44;
        r10.add(r14);
    L44:
        r12 = r12 + 1;
        r11 = r19;
        r5 = r111;
        r6 = r25;
    L17:
        if (r9.containsKey(r14) == true) goto L19;
        r9.put(r14, new HashSet());
    L19:
        PreferenceMgr r112 = PreferenceMgr.getInstance(r26);
        HashSet<String> r113 = r9.get(r14);
        r111 = r5;
        int r20 = r7.getSubtypeCount();
        boolean r21 = r13;
        int r114 = 0;
        boolean r22 = false;
    L20:
        if (r114 >= r20) goto L32;
        InputMethodSubtype r23 = r7.getSubtypeAt(r114);
        int r24 = r20;
        String r30 = String.valueOf(r23.hashCode());
        InputMethodInfo r210 = r7;
        boolean r211 = r6;
        boolean r31 = r112.getBoolean(r14 + r30, false);
        if (r22 == true) goto L24;
        r113.clear();
        r21 = true;
        r22 = true;
    L24:
        if (r31 == false) goto L30;
        r113.add(r30);
        if (r17 == false) goto L31;
        if (r8 != r23.hashCode()) goto L31;
        r21 = false;
    L31:
        r114 = r114 + 1;
        r7 = r210;
        r20 = r24;
        r6 = r211;
        goto L20
    L30:
        r113.remove(r30);
        goto L31
    L32:
        r25 = r6;
        r13 = r21;
        goto L36
    L14:
        if (r110.isAlwaysCheckedIme(r7, r26) == true) goto L17;
    L45:
        boolean r212 = r6;
        String r115 = r5;
        String r32 = buildInputMethodsAndSubtypesString(r9);
        String r33 = buildInputMethodsString(r10);
        OLog.d(TAG, "--- Save enabled inputmethod settings. :" + r32);
        OLog.d(TAG, "--- Save disable system inputmethod settings. :" + r33);
        OLog.d(TAG, "--- Save default inputmethod settings. :" + r2);
        OLog.d(TAG, "--- Needs to reset the selected subtype :" + r13);
        OLog.d(TAG, "--- Subtype is selected :" + isInputMethodSubtypeSelected(r28));
        if (r13 == false) goto L48;
    L49:
        putSelectedInputMethodSubtype(r28, -1);
    L50:
        Settings.Secure.putString(r28, "enabled_input_methods", r32);
        if (r33.length() <= 0) goto L53;
        Settings.Secure.putString(r28, "disabled_system_input_methods", r33);
    L53:
        if (r2 != null) goto L60;
        if (r9.containsKey(DEF_GOOGLE_IME_ID) == false) goto L60;
        if (isPackageInstalledAndIsSystemApp(r26, DEF_GOOGLE_IME_PKG) == false) goto L60;
        setDefaultImeWhileChineseLocale(r26, DEF_GOOGLE_IME_ID, r212);
        return;
    L60:
        if (r2 == null) goto L62;
    L66:
        if (r2 != null) goto L69;
        r2 = "";
    L69:
        Settings.Secure.putString(r28, "default_input_method", r2);
        return;
    L62:
        if (r9.containsKey(r115) == false) goto L66;
        if (isPackageInstalledAndIsSystemApp(r26, DEF_CHUBAO_IME_PKG) == false) goto L66;
        setDefaultImeWhileChineseLocale(r26, r115, r212);
        return;
    L48:
        if (isInputMethodSubtypeSelected(r28) == true) goto L50;
    L5:
        if (DEF_CHUBAO_IME_ID.equals(r2) == true) goto L8;
        r6 = false;
        goto L9
    }

    private static void setDefaultImeWhileChineseLocale(Context r2, String r3, boolean r4) {
        ContentResolver r0 = r2.getContentResolver();
        String r5 = r2.getResources().getConfiguration().locale.toString();
        if (r4 == false) goto L5;
    L9:
        Settings.Secure.putString(r0, "default_input_method", "");
        return;
    L5:
        if (Constants.APP_LABELS_OF_ZH_CN.equals(r5) == false) goto L7;
    L8:
        Settings.Secure.putString(r0, "default_input_method", r3);
        return;
    L7:
        if (Constants.APP_LABELS_OF_ZH_TW.equals(r5) == false) goto L9;
        goto L8
    }

    static void removeUnnecessaryNonPersistentPreference(Preference r2) {
        String r0 = r2.getKey();
        if (r2.isPersistent() == true) goto L12;
        if (r0 == null) goto L15;
        SharedPreferences r3 = r2.getSharedPreferences();
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.contains(r0) == false) goto L14;
        r3.edit().remove(r0).apply();
        return;
    L14:
        return;
    L15:
        return;
    }

    static String getSubtypeLocaleNameAsSentence(InputMethodSubtype r2, Context r3, InputMethodInfo r4) {
        if (r2 != null) goto L5;
        return "";
    L5:
        Locale r0 = getDisplayLocale(r3);
        return LocaleHelper.toSentenceCase(r2.getDisplayName(r3, r4.getPackageName(), r4.getServiceInfo().applicationInfo).toString(), r0);
    }

    static String getSubtypeLocaleNameListAsSentence(List<InputMethodSubtype> r7, Context r8, InputMethodInfo r9) {
        if (r7.isEmpty() == false) goto L6;
        return "";
    L6:
        Locale r0 = getDisplayLocale(r8);
        int r1 = r7.size();
        CharSequence[] r2 = new CharSequence[r1];
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L10;
        r2[r3] = r7.get(r3).getDisplayName(r8, r9.getPackageName(), r9.getServiceInfo().applicationInfo);
        r3 = r3 + 1;
        goto L7
    L10:
        return LocaleHelper.toSentenceCase(ListFormatter.getInstance(r0).format(r2), r0);
    }

    private static Locale getDisplayLocale(Context r1) {
        if (r1 != null) goto L6;
        return Locale.getDefault();
    L6:
        if (r1.getResources() == null) goto L8;
        Configuration r2 = r1.getResources().getConfiguration();
        if (r2 == null) goto L12;
        Locale r3 = r2.getLocales().get(0);
        if (r3 == null) goto L16;
        return r3;
    L16:
        return Locale.getDefault();
    L12:
        return Locale.getDefault();
    L8:
        return Locale.getDefault();
    }

    static void loadInputMethodSubtypeList2(InputMethodAndSubtypeEnabler r0, ContentResolver r1, List<InputMethodInfo> r2) {
        updateSubtypesPreferenceChecked2(r0, r2, getEnabledInputMethodsAndSubtypeList(r1));
    }

    private static void updateSubtypesPreferenceChecked2(InputMethodAndSubtypeEnabler r7, List<InputMethodInfo> r8, HashMap<String, HashSet<String>> r9) {
        Iterator<InputMethodInfo> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        InputMethodInfo r0 = r10.next();
        String r1 = r0.getId();
        if (r9.containsKey(r1) == false) goto L4;
        HashSet<String> r2 = r9.get(r1);
        int r3 = r0.getSubtypeCount();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L4;
        String r5 = String.valueOf(r0.getSubtypeAt(r4).hashCode());
        SettingItemSwitch r6 = r7.findSwitchViaTag(r1, r1 + r5);
        if (r6 == null) goto L13;
        r6.setChecked(r2.contains(r5));
    L13:
        r4 = r4 + 1;
        goto L9
    }

    public static void saveInputMethodSubtypeList2(InputMethodAndSubtypeEnabler r22, ContentResolver r23, List<InputMethodInfo> r24, boolean r25) {
        String r2 = Settings.Secure.getString(r23, "default_input_method");
        int r3 = getInputMethodSubtypeSelected(r23);
        HashMap<String, HashSet<String>> r4 = getEnabledInputMethodsAndSubtypeList(r23);
        HashSet<String> r5 = getDisabledSystemIMEs(r23);
        Iterator<InputMethodInfo> r6 = r24.iterator();
        boolean r8 = false;
    L4:
        if (r6.hasNext() == false) goto L44;
        InputMethodInfo r9 = r6.next();
        String r10 = r9.getId();
        boolean r11 = r4.containsKey(r10);
        boolean r12 = r10.equals(r2);
        boolean r13 = InputMethodUtils.isSystemIme(r9);
        if (r25 == false) goto L8;
    L9:
        if (r11 == true) goto L11;
        Iterator<InputMethodInfo> r19 = r6;
        r4.remove(r10);
        if (r12 == false) goto L35;
        r2 = null;
    L35:
        if (r13 == false) goto L43;
        if (r25 == false) goto L43;
        if (r5.contains(r10) == false) goto L41;
        if (r11 == false) goto L43;
        r5.remove(r10);
        goto L43
    L41:
        if (r11 == true) goto L43;
        r5.add(r10);
    L43:
        r6 = r19;
    L11:
        if (r4.containsKey(r10) == true) goto L13;
        r4.put(r10, new HashSet());
    L13:
        HashSet<String> r14 = r4.get(r10);
        int r15 = r9.getSubtypeCount();
        int r7 = 0;
        boolean r16 = false;
    L14:
        if (r7 >= r15) goto L31;
        InputMethodSubtype r17 = r9.getSubtypeAt(r7);
        Iterator<InputMethodInfo> r110 = r6;
        String r18 = String.valueOf(r17.hashCode());
        boolean r111 = r8;
        InputMethodInfo r20 = r9;
        SettingItemSwitch r21 = r22.findSwitchViaTag(r10, r10 + r18);
        if (r21 != null) goto L18;
        r8 = r111;
    L30:
        r7 = r7 + 1;
        r6 = r110;
        r9 = r20;
        goto L14
    L18:
        if (r16 == true) goto L20;
        r14.clear();
        boolean r112 = true;
        boolean r113 = true;
    L22:
        if (r21.isChecked() == false) goto L28;
        r14.add(r18);
        if (r12 == true) goto L26;
    L29:
        r8 = r112;
        r16 = r113;
        goto L30
    L26:
        if (r3 != r17.hashCode()) goto L29;
        r16 = r113;
        r8 = false;
        goto L30
    L28:
        r14.remove(r18);
        goto L29
    L20:
        r113 = r16;
        r112 = r111;
        goto L22
    L31:
        r19 = r6;
        goto L35
    L8:
        if (InputMethodSettingValuesWrapper.getInstance(r22.getActivity()).isAlwaysCheckedIme(r9, r22.getActivity()) == true) goto L11;
    L44:
        String r26 = buildInputMethodsAndSubtypesString(r4);
        String r27 = buildInputMethodsString(r5);
        OLog.d(TAG, "--- Save enabled inputmethod settings. :" + r26);
        OLog.d(TAG, "--- Save disabled system inputmethod settings. :" + r27);
        OLog.d(TAG, "--- Save default inputmethod settings. :" + r2);
        OLog.d(TAG, "--- Needs to reset the selected subtype :" + r8);
        OLog.d(TAG, "--- Subtype is selected :" + isInputMethodSubtypeSelected(r23));
        if (r8 == false) goto L47;
    L48:
        putSelectedInputMethodSubtype(r23, -1);
    L49:
        Settings.Secure.putString(r23, "enabled_input_methods", r26);
        if (r27.length() <= 0) goto L52;
        Settings.Secure.putString(r23, "disabled_system_input_methods", r27);
    L52:
        if (r2 != null) goto L55;
        r2 = "";
    L55:
        Settings.Secure.putString(r23, "default_input_method", r2);
        return;
    L47:
        if (isInputMethodSubtypeSelected(r23) == true) goto L49;
        goto L48
    }
}
