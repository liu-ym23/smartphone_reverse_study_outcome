package com.android.settings.inputmethod;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceScreen;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class AvailableVirtualKeyboardFragment extends SettingsPreferenceFragment implements InputMethodPreference.OnSavePreferenceListener {
    private DevicePolicyManager mDpm;
    private InputMethodManager mImm;
    private final ArrayList<InputMethodPreference> mInputMethodPreferenceList;
    private InputMethodSettingValuesWrapper mInputMethodSettingValues;

    public void com_android_settings_inputmethod_AvailableVirtualKeyboardFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_AvailableVirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_AvailableVirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AvailableVirtualKeyboardFragment() {
        this.mInputMethodPreferenceList = new ArrayList();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r2, String r3) {
        FragmentActivity r4 = getActivity();
        PreferenceScreen r5 = getPreferenceManager().createPreferenceScreen(r4);
        r5.setTitle(r4.getString(R.string.available_virtual_keyboard_category));
        setPreferenceScreen(r5);
        this.mInputMethodSettingValues = InputMethodSettingValuesWrapper.getInstance(r4);
        this.mImm = (InputMethodManager) r4.getSystemService(InputMethodManager.class);
        this.mDpm = (DevicePolicyManager) r4.getSystemService(DevicePolicyManager.class);
    }

    public void com_android_settings_inputmethod_AvailableVirtualKeyboardFragment__onResume$___twin___() {
        super.onResume();
        this.mInputMethodSettingValues.refreshAllInputMethodAndSubtypes();
        updateInputMethodPreferenceViews();
    }

    @Override // com.android.settings.inputmethod.InputMethodPreference.OnSavePreferenceListener
    public void onSaveInputMethodPreference(InputMethodPreference r3) {
        if (getResources().getConfiguration().keyboard != 2) goto L5;
        boolean r4 = true;
    L6:
        InputMethodAndSubtypeUtil.saveInputMethodSubtypeList(this, getContentResolver(), this.mImm.getInputMethodList(), r4);
        this.mInputMethodSettingValues.refreshAllInputMethodAndSubtypes();
        Iterator<InputMethodPreference> r2 = this.mInputMethodPreferenceList.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().updatePreferenceViews();
        goto L8
    L10:
        return;
    L5:
        r4 = false;
        goto L6
    }

    private static Drawable loadDrawable(PackageManager r1, String r2, int r3, ApplicationInfo r4) {
        if (r3 != 0) goto L8;
        return null;
    L8:
        return r1.getDrawable(r2, r3, r4);
    L7:
        return null;
    }

    private static Drawable getInputMethodIcon(PackageManager r4, InputMethodInfo r5) {
        ServiceInfo r0 = r5.getServiceInfo();
        ApplicationInfo r1 = r0.applicationInfo;
        String r6 = r5.getPackageName();
        if (r0 == null) goto L22;
        if (r1 == null) goto L22;
        if (r6 == null) goto L22;
        Drawable r3 = loadDrawable(r4, r6, r0.logo, r1);
        if (r3 == null) goto L10;
        return r3;
    L10:
        Drawable r2 = loadDrawable(r4, r6, r0.icon, r1);
        if (r2 == null) goto L13;
        return r2;
    L13:
        Drawable r7 = loadDrawable(r4, r6, r1.logo, r1);
        if (r7 == null) goto L16;
        return r7;
    L16:
        Drawable r8 = loadDrawable(r4, r6, r1.icon, r1);
        if (r8 == null) goto L20;
        return r8;
    L20:
        return new ColorDrawable(0);
    L22:
        return new ColorDrawable(0);
    }

    private void updateInputMethodPreferenceViews() {
        this.mInputMethodSettingValues.refreshAllInputMethodAndSubtypes();
        this.mInputMethodPreferenceList.clear();
        List r0 = this.mDpm.getPermittedInputMethodsForCurrentUser();
        Context r7 = getPrefContext();
        PackageManager r8 = getActivity().getPackageManager();
        List<InputMethodInfo> r9 = this.mInputMethodSettingValues.getInputMethodList();
        int r10 = 0;
        if (r9 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L16;
        InputMethodInfo r13 = r9.get(r12);
        if (r0 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        InputMethodPreference r14 = new InputMethodPreference(r7, r13, true, r5, this);
        r14.setIcon(getInputMethodIcon(r8, r13));
        this.mInputMethodPreferenceList.add(r14);
        r12 = r12 + 1;
        goto L7
    L11:
        if (r0.contains(r13.getPackageName()) == true) goto L14;
        r5 = false;
        goto L15
    L16:
        final Collator r1 = Collator.getInstance();
        Collections.sort(this.mInputMethodPreferenceList, new AnonymousClass1(this, r1));
        getPreferenceScreen().removeAll();
    L17:
        if (r10 >= r11) goto L19;
        InputMethodPreference r2 = this.mInputMethodPreferenceList.get(r10);
        r2.setOrder(r10);
        getPreferenceScreen().addPreference(r2);
        InputMethodAndSubtypeUtil.removeUnnecessaryNonPersistentPreference(r2);
        r2.updatePreferenceViews();
        r10 = r10 + 1;
        goto L17
    L19:
        return;
    L5:
        r11 = r9.size();
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_AvailableVirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AvailableVirtualKeyboardFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_AvailableVirtualKeyboardFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_AvailableVirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AvailableVirtualKeyboardFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_AvailableVirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_AvailableVirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AvailableVirtualKeyboardFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_AvailableVirtualKeyboardFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
