package com.android.settings.inputmethod;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceFragmentCompat;
import com.android.internal.app.LocalePicker;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UserDictionaryAddWordFragment extends PreferenceFragmentCompat implements AdapterView.OnItemSelectedListener, LocalePicker.LocaleSelectionListener {
    private static final int OPTIONS_MENU_DELETE = 1;
    private UserDictionaryAddWordContents mContents;
    private boolean mIsDeleting;
    private View mRootView;

    public void com_android_settings_inputmethod_UserDictionaryAddWordFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_UserDictionaryAddWordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_UserDictionaryAddWordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public UserDictionaryAddWordFragment() {
        this.mIsDeleting = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        setHasOptionsMenu(true);
        ((FragmentActivity) NullSafe.nonNull(getActivity())).getActionBar().setTitle(R.string.user_dict_settings_title);
        setRetainInstance(true);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        this.mRootView = r1.inflate(R.layout.user_dictionary_add_word_fullscreen, null);
        this.mIsDeleting = false;
        if (this.mContents != null) goto L5;
        this.mContents = new UserDictionaryAddWordContents(this.mRootView, getArguments());
    L6:
        getActivity().getActionBar().setSubtitle(UserDictionarySettingsUtils.getLocaleDisplayName(getActivity(), this.mContents.getCurrentUserDictionaryLocale()));
        return this.mRootView;
    L5:
        this.mContents = new UserDictionaryAddWordContents(this.mRootView, this.mContents);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        super.onCreateOptionsMenu(r2, r3);
        r2.add(0, 1, 0, R.string.delete).setIcon(android.R.drawable.ic_menu_delete).setShowAsAction(5);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 1) goto L6;
        this.mContents.delete(getActivity());
        this.mIsDeleting = true;
        getActivity().onBackPressed();
        return true;
    L6:
        return false;
    }

    public void com_android_settings_inputmethod_UserDictionaryAddWordFragment__onResume$___twin___() {
        super.onResume();
        updateSpinner();
    }

    private void updateSpinner() {
        ArrayList<UserDictionaryAddWordContents.LocaleRenderer> r0 = this.mContents.getLocalesList(getActivity());
        new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, r0).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mIsDeleting == true) goto L6;
        this.mContents.apply(getActivity(), null);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        UserDictionaryAddWordContents.LocaleRenderer r5 = (UserDictionaryAddWordContents.LocaleRenderer) r1.getItemAtPosition(r3);
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isMoreLanguages() == false) goto L8;
        ((SettingsActivity) getActivity()).startPreferenceFragment(new UserDictionaryLocalePicker(this), true);
        return;
    L8:
        this.mContents.updateLocale(r5.getLocaleString());
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r2) {
        Bundle r3 = getArguments();
        this.mContents.updateLocale(r3.getString("locale"));
    }

    public void onLocaleSelected(Locale r2) {
        this.mContents.updateLocale(r2.toString());
        getActivity().onBackPressed();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_UserDictionaryAddWordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UserDictionaryAddWordFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_UserDictionaryAddWordFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_UserDictionaryAddWordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UserDictionaryAddWordFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_UserDictionaryAddWordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_UserDictionaryAddWordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UserDictionaryAddWordFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_UserDictionaryAddWordFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
