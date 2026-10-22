package com.android.settings.inputmethod;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.preference.Preference;
import com.android.internal.util.Preconditions;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class VirtualKeyboardFragment extends SettingsPreferenceFragment {
    private static final String ADD_VIRTUAL_KEYBOARD_SCREEN = "add_virtual_keyboard_screen";
    private static final Drawable NO_ICON = null;
    private Preference mAddVirtualKeyboardScreen;
    private DevicePolicyManager mDpm;
    private InputMethodManager mImm;
    private final ArrayList<InputMethodPreference> mInputMethodPreferenceList;

    public void com_android_settings_inputmethod_VirtualKeyboardFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_VirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_VirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public VirtualKeyboardFragment() {
        this.mInputMethodPreferenceList = new ArrayList();
    }

    static {
        NO_ICON = new ColorDrawable(0);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        Activity r3 = (Activity) Preconditions.checkNotNull(getActivity());
        addPreferencesFromResource(R.xml.virtual_keyboard_settings);
        this.mImm = (InputMethodManager) Preconditions.checkNotNull((InputMethodManager) r3.getSystemService(InputMethodManager.class));
        this.mDpm = (DevicePolicyManager) Preconditions.checkNotNull((DevicePolicyManager) r3.getSystemService(DevicePolicyManager.class));
        this.mAddVirtualKeyboardScreen = (Preference) Preconditions.checkNotNull(findPreference(ADD_VIRTUAL_KEYBOARD_SCREEN));
    }

    public void com_android_settings_inputmethod_VirtualKeyboardFragment__onResume$___twin___() {
        super.onResume();
        updateInputMethodPreferenceViews();
    }

    private void updateInputMethodPreferenceViews() {
        this.mInputMethodPreferenceList.clear();
        List r0 = this.mDpm.getPermittedInputMethodsForCurrentUser();
        Context r7 = getPrefContext();
        List<InputMethodInfo> r8 = this.mImm.getEnabledInputMethodList();
        int r9 = 0;
        if (r8 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L19;
        InputMethodInfo r3 = r8.get(r11);
        if (r0 != null) goto L11;
    L14:
        boolean r5 = true;
    L24:
        Drawable r1 = getActivity().getPackageManager().getApplicationIcon(r3.getPackageName());     // Catch: Exception -> L17
    L18:
        InputMethodPreference r13 = new InputMethodPreference(r7, r3, false, r5, null);
        r13.setIcon(r1);
        this.mInputMethodPreferenceList.add(r13);
        r11 = r11 + 1;
    L17:
        r1 = NO_ICON;
        goto L18
    L11:
        if (r0.contains(r3.getPackageName()) == true) goto L14;
        r5 = false;
        goto L24
    L19:
        final Collator r2 = Collator.getInstance();
        Collections.sort(this.mInputMethodPreferenceList, new AnonymousClass1(this, r2));
        getPreferenceScreen().removeAll();
    L20:
        if (r9 >= r10) goto L22;
        InputMethodPreference r4 = this.mInputMethodPreferenceList.get(r9);
        r4.setOrder(r9);
        getPreferenceScreen().addPreference(r4);
        InputMethodAndSubtypeUtil.removeUnnecessaryNonPersistentPreference(r4);
        r4.updatePreferenceViews();
        r9 = r9 + 1;
        goto L20
    L22:
        this.mAddVirtualKeyboardScreen.setIcon(R.drawable.ic_add_24dp);
        this.mAddVirtualKeyboardScreen.setOrder(r10);
        getPreferenceScreen().addPreference(this.mAddVirtualKeyboardScreen);
        return;
    L5:
        r10 = r8.size();
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_VirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(VirtualKeyboardFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_VirtualKeyboardFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_VirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(VirtualKeyboardFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_VirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_VirtualKeyboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(VirtualKeyboardFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_VirtualKeyboardFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
