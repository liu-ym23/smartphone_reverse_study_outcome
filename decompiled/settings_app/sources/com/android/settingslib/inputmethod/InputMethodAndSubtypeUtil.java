package com.android.settingslib.inputmethod;

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
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceScreen;
import androidx.preference.TwoStatePreference;
import com.android.internal.app.LocaleHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InputMethodAndSubtypeUtil {
    private static final boolean DEBUG = false;
    private static final char INPUT_METHOD_SEPARATER = ':';
    private static final char INPUT_METHOD_SUBTYPE_SEPARATER = ';';
    private static final int NOT_A_SUBTYPE_ID = -1;
    private static final String SUBTYPE_MODE_KEYBOARD = "keyboard";
    private static final String TAG = "InputMethdAndSubtypeUtl";
    private static final TextUtils.SimpleStringSplitter sStringInputMethodSplitter = null;
    private static final TextUtils.SimpleStringSplitter sStringInputMethodSubtypeSplitter = null;

    public InputMethodAndSubtypeUtil() {
    }

    static {
        sStringInputMethodSplitter = new TextUtils.SimpleStringSplitter(':');
        sStringInputMethodSubtypeSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SUBTYPE_SEPARATER);
    }

    public static String buildInputMethodsAndSubtypesString(HashMap<String, HashSet<String>> r5) {
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

    static HashMap<String, HashSet<String>> getEnabledInputMethodsAndSubtypeList(ContentResolver r1) {
        return parseInputMethodsAndSubtypesString(Settings.Secure.getString(r1, "enabled_input_methods"));
    }

    public static HashMap<String, HashSet<String>> parseInputMethodsAndSubtypesString(String r4) {
        HashMap<String, HashSet<String>> r0 = new HashMap();
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r0;
    L5:
        sStringInputMethodSplitter.setString(r4);
    L6:
        TextUtils.SimpleStringSplitter r5 = sStringInputMethodSplitter;
        if (r5.hasNext() == false) goto L15;
        String r6 = r5.next();
        TextUtils.SimpleStringSplitter r1 = sStringInputMethodSubtypeSplitter;
        r1.setString(r6);
        if (r1.hasNext() == false) goto L6;
        HashSet<String> r7 = new HashSet();
        String r2 = r1.next();
    L11:
        TextUtils.SimpleStringSplitter r3 = sStringInputMethodSubtypeSplitter;
        if (r3.hasNext() == false) goto L14;
        r7.add(r3.next());
        goto L11
    L14:
        r0.put(r2, r7);
        goto L6
    L15:
        return r0;
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

    public static void saveInputMethodSubtypeList(PreferenceFragment r23, ContentResolver r24, List<InputMethodInfo> r25, boolean r26) {
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
        boolean r15 = r10.isSystem();
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
        HashSet<String> r17 = r5.get(r11);
        int r8 = r10.getSubtypeCount();
        r16 = r7;
        int r18 = 0;
        boolean r19 = false;
    L21:
        if (r18 >= r8) goto L44;
        InputMethodSubtype r110 = r10.getSubtypeAt(r18);
        int r20 = r8;
        String r21 = String.valueOf(r110.hashCode());
        boolean r111 = r9;
        TwoStatePreference r22 = (TwoStatePreference) r23.findPreference(r11 + r21);
        if (r22 != null) goto L25;
        r9 = r111;
    L39:
        r18 = r18 + 1;
        r8 = r20;
        goto L21
    L25:
        if (r19 == true) goto L27;
        r17.clear();
        boolean r112 = true;
        boolean r113 = true;
    L29:
        if (r22.isEnabled() == true) goto L31;
    L37:
        r17.remove(r21);
    L38:
        r9 = r112;
        r19 = r113;
        goto L39
    L31:
        if (r22.isChecked() == false) goto L37;
        r17.add(r21);
        if (r14 == false) goto L38;
        if (r4 != r110.hashCode()) goto L38;
        r19 = r113;
        r9 = false;
        goto L39
    L27:
        r113 = r19;
        r112 = r111;
        goto L29
    L15:
        if (InputMethodSettingValuesWrapper.getInstance(r23.getActivity()).isAlwaysCheckedIme(r10) == true) goto L18;
    L11:
        r13 = r5.containsKey(r11);
        goto L12
    L53:
        String r0 = buildInputMethodsAndSubtypesString(r5);
        String r27 = buildInputMethodsString(r6);
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

    public static void loadInputMethodSubtypeList(PreferenceFragment r5, ContentResolver r6, List<InputMethodInfo> r7, Map<String, List<Preference>> r8) {
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

    private static void setSubtypesPreferenceEnabled(PreferenceFragment r5, List<InputMethodInfo> r6, String r7, boolean r8) {
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

    private static void updateSubtypesPreferenceChecked(PreferenceFragment r7, List<InputMethodInfo> r8, HashMap<String, HashSet<String>> r9) {
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

    public static void removeUnnecessaryNonPersistentPreference(Preference r2) {
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

    public static String getSubtypeLocaleNameAsSentence(InputMethodSubtype r2, Context r3, InputMethodInfo r4) {
        if (r2 != null) goto L5;
        return "";
    L5:
        Locale r0 = getDisplayLocale(r3);
        return LocaleHelper.toSentenceCase(r2.getDisplayName(r3, r4.getPackageName(), r4.getServiceInfo().applicationInfo).toString(), r0);
    }

    public static String getSubtypeLocaleNameListAsSentence(List<InputMethodSubtype> r7, Context r8, InputMethodInfo r9) {
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

    public static boolean isValidNonAuxAsciiCapableIme(InputMethodInfo r6) {
        if (r6.isAuxiliaryIme() == false) goto L5;
        return false;
    L5:
        int r0 = r6.getSubtypeCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L14;
        InputMethodSubtype r3 = r6.getSubtypeAt(r2);
        if ("keyboard".equalsIgnoreCase(r3.getMode()) == false) goto L13;
        if (r3.isAsciiCapable() == false) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L6
    L14:
        return false;
    }
}
