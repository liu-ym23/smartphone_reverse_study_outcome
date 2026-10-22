package com.android.settings.inputmethod;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.UserDictionarySettings;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UserDictionaryList extends SettingsPreferenceFragment {
    public static final String USER_DICTIONARY_SETTINGS_INTENT_ACTION = "android.settings.USER_DICTIONARY_SETTINGS";
    private String mLocale;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_UserDictionaryList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_UserDictionaryList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public UserDictionaryList() {
    }

    public void com_android_settings_inputmethod_UserDictionaryList__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        setPreferenceScreen(getPreferenceManager().createPreferenceScreen(getActivity()));
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        getActivity().getActionBar().setTitle(R.string.user_dict_settings_title);
        Intent r5 = getActivity().getIntent();
        String r1 = null;
        if (r5 != null) goto L5;
        String r6 = null;
    L6:
        Bundle r2 = getArguments();
        if (r2 != null) goto L9;
        String r0 = null;
    L10:
        if (r0 == null) goto L12;
        r1 = r0;
    L14:
        this.mLocale = r1;
        return;
    L12:
        if (r6 == null) goto L14;
        r1 = r6;
        goto L14
    L9:
        r0 = r2.getString("locale");
        goto L10
    L5:
        r6 = r5.getStringExtra("locale");
        goto L6
    }

    public static TreeSet<String> getUserDictionaryLocalesSet(Context r7) {
        Cursor r0 = r7.getContentResolver().query(UserDictionary.Words.CONTENT_URI, new String[]{"locale"}, null, null, null);
        TreeSet<String> r1 = new TreeSet();
        if (r0 != null) goto L31;
        return null;
    L31:
    L28:
        th = move-exception;
        r0.close();
        throw th;
    L7:
        if (r0.moveToFirst() == false) goto L15;
        int r2 = r0.getColumnIndex("locale");     // Catch: Throwable -> L28
    L9:
        String r3 = r0.getString(r2);     // Catch: Throwable -> L28
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r1.add(r3);     // Catch: Throwable -> L28
        if (r0.moveToNext() == true) goto L9;
    L15:
        r0.close();
        InputMethodManager r8 = (InputMethodManager) r7.getSystemService("input_method");
        Iterator<InputMethodInfo> r4 = r8.getEnabledInputMethodList().iterator();
    L17:
        if (r4.hasNext() == false) goto L25;
        Iterator<InputMethodSubtype> r5 = r8.getEnabledInputMethodSubtypeList(r4.next(), true).iterator();
    L20:
        if (r5.hasNext() == false) goto L17;
        String r6 = r5.next().getLocale();
        if (TextUtils.isEmpty(r6) == true) goto L20;
        r1.add(r6);
        goto L20
    L25:
        if (r1.contains(Locale.getDefault().getLanguage().toString()) == true) goto L27;
        r1.add(Locale.getDefault().toString());
    L27:
        return r1;
    }

    protected void createUserDictSettings(PreferenceGroup r5) {
        FragmentActivity r0 = getActivity();
        r5.removeAll();
        TreeSet<String> r1 = getUserDictionaryLocalesSet(r0);
        String r2 = this.mLocale;
        if (r2 == null) goto L6;
        r1.add(r2);
    L6:
        if (r1.size() <= 1) goto L9;
        r1.add("");
    L9:
        if (r1.isEmpty() == false) goto L11;
        r5.addPreference(createUserDictionaryPreference(null, r0));
        return;
    L11:
        Iterator<String> r3 = r1.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        r5.addPreference(createUserDictionaryPreference(r3.next(), r0));
        goto L13
    }

    protected Preference createUserDictionaryPreference(String r4, Activity r5) {
        Preference r6 = new Preference(getPrefContext());
        Intent r0 = new Intent(USER_DICTIONARY_SETTINGS_INTENT_ACTION);
        r0.putExtra(Constants.EXTRA_OUTER, false);
        if (r4 != null) goto L6;
        r6.setTitle(Locale.getDefault().getDisplayName());
    L10:
        r6.setIntent(r0);
        r6.setFragment(UserDictionarySettings.class.getName());
        return r6;
    L6:
        if ("".equals(r4) == false) goto L8;
        r6.setTitle(getString(R.string.user_dict_settings_all_languages));
    L9:
        r0.putExtra("locale", r4);
        r6.getExtras().putString("locale", r4);
        goto L10
    L8:
        r6.setTitle(Utils.createLocaleFromString(r4).getDisplayName());
        goto L9
    }

    public void com_android_settings_inputmethod_UserDictionaryList__onResume$___twin___() {
        super.onResume();
        createUserDictSettings(getPreferenceScreen());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_UserDictionaryList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UserDictionaryList r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_UserDictionaryList__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_UserDictionaryList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UserDictionaryList r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_UserDictionaryList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_UserDictionaryList_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UserDictionaryList r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_UserDictionaryList__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
