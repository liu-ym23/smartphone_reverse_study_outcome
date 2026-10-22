package com.android.settings.inputmethod;

import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import androidx.preference.Preference;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SpellCheckersSettings extends SettingsPreferenceFragment23 implements Preference.OnPreferenceClickListener {
    private static final boolean DBG = false;
    private static final String TAG = "SpellCheckersSettings";
    private SpellCheckerInfo mCurrentSci;
    private AlertDialog mDialog;
    private SpellCheckerInfo[] mEnabledScis;
    private final ArrayList<SingleSpellCheckerPreference> mSpellCheckers;
    private TextServicesManager mTsm;

    static {
    }

    private void saveState() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_SpellCheckersSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r1) {
        return false;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_SpellCheckersSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SpellCheckersSettings() {
        this.mDialog = null;
        this.mSpellCheckers = new ArrayList();
    }

    static /* synthetic */ void access$000(SpellCheckersSettings r0, SingleSpellCheckerPreference r1) {
        r0.changeCurrentSpellChecker(r1);
    }

    public void com_android_settings_inputmethod_SpellCheckersSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mTsm = (TextServicesManager) getSystemService("textservices");
        addPreferencesFromResource(R.xml.spellchecker_prefs);
        updateScreen();
        setBytedanceStyle(true);
    }

    public void com_android_settings_inputmethod_SpellCheckersSettings__onResume$___twin___() {
        super.onResume();
        updateScreen();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        saveState();
    }

    private void updateScreen() {
        getPreferenceScreen().removeAll();
        updateEnabledSpellCheckers();
    }

    private void updateEnabledSpellCheckers() {
        PackageManager r0 = getPackageManager();
        this.mCurrentSci = this.mTsm.getCurrentSpellChecker();
        SpellCheckerInfo[] r1 = this.mTsm.getEnabledSpellCheckers();
        this.mEnabledScis = r1;
        if (this.mCurrentSci == null) goto L22;
        if (r1 == null) goto L27;
        this.mSpellCheckers.clear();
        int r2 = 0;
        int r3 = 0;
    L7:
        SpellCheckerInfo[] r4 = this.mEnabledScis;
        if (r3 >= r4.length) goto L19;
        SpellCheckerInfo r5 = r4[r3];
        if (TextUtils.isEmpty(r5.loadLabel(r0)) == true) goto L18;
        SingleSpellCheckerPreference r6 = new SingleSpellCheckerPreference(this, null, r5, this.mTsm);
        this.mSpellCheckers.add(r6);
        r6.setTitle(r5.loadLabel(r0));
        SpellCheckerInfo r7 = this.mCurrentSci;
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        r6.setSelected(r8);
        getPreferenceScreen().addPreference(r6);
        goto L18
    L14:
        if (r7.getId().equals(r5.getId()) == false) goto L16;
        r8 = true;
    L18:
        r3 = r3 + 1;
        goto L7
    L19:
        int r9 = this.mSpellCheckers.size();
    L20:
        if (r2 >= r9) goto L28;
        this.mSpellCheckers.get(r2).setBackgroundStyle(r9, r2);
        r2 = r2 + 1;
        goto L20
    L28:
        return;
    L27:
        return;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r5) {
        Iterator<SingleSpellCheckerPreference> r0 = this.mSpellCheckers.iterator();
        SingleSpellCheckerPreference r1 = null;
    L4:
        if (r0.hasNext() == false) goto L8;
        SingleSpellCheckerPreference r2 = r0.next();
        if (r5.equals(r2) == false) goto L4;
        r1 = r2;
        goto L4
    L8:
        if (r1 != null) goto L10;
        return true;
    L10:
        if (isSystemApp(r1.getSpellCheckerInfo()) == true) goto L12;
        showSecurityWarnDialog(r1);
        return true;
    L12:
        changeCurrentSpellChecker(r1);
        return true;
    }

    private void showSecurityWarnDialog(final SingleSpellCheckerPreference r5) {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        AlertDialog r1 = new AlertDialog.Builder(getActivity()).setTitle(android.R.string.dialog_alert_title).setIconAttribute(android.R.attr.alertDialogIcon).setCancelable(true).setPositiveButton(android.R.string.ok, new AnonymousClass2(this, r5)).setNegativeButton(android.R.string.cancel, new AnonymousClass1(this)).create();
        this.mDialog = r1;
        r1.setMessage(getResources().getString(R.string.spellchecker_security_warning, new Object[]{r5.getSpellCheckerInfo().getServiceInfo().applicationInfo.loadLabel(getActivity().getPackageManager())}));
        this.mDialog.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mDialog.dismiss();
        goto L7
    }

    private void changeCurrentSpellChecker(SingleSpellCheckerPreference r2) {
        MultiSDKAdapter.setCurrentSpellChecker(getActivity(), r2.getSpellCheckerInfo());
        updateScreen();
    }

    private static boolean isSystemApp(SpellCheckerInfo r1) {
        if ((r1.getServiceInfo().applicationInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_SpellCheckersSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SpellCheckersSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_SpellCheckersSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_SpellCheckersSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SpellCheckersSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_SpellCheckersSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_SpellCheckersSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SpellCheckersSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_SpellCheckersSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
