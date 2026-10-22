package com.android.settings.inputmethod;

import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputManager;
import android.hardware.input.KeyboardLayout;
import android.os.Bundle;
import android.view.InputDevice;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class KeyboardLayoutPickerFragment extends SettingsPreferenceFragment implements InputManager.InputDeviceListener {
    public static final String EXTRA_INPUT_DEVICE_IDENTIFIER = "input_device_identifier";
    private InputManager mIm;
    private int mInputDeviceId;
    private InputDeviceIdentifier mInputDeviceIdentifier;
    private KeyboardLayout[] mKeyboardLayouts;
    private HashMap<CheckBoxPreference, KeyboardLayout> mPreferenceMap;

    private void updateCheckedState() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_KeyboardLayoutPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int r1) {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_KeyboardLayoutPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public KeyboardLayoutPickerFragment() {
        this.mInputDeviceId = -1;
        this.mPreferenceMap = new HashMap();
    }

    public void com_android_settings_inputmethod_KeyboardLayoutPickerFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        InputDeviceIdentifier r3 = getActivity().getIntent().getParcelableExtra("input_device_identifier");
        this.mInputDeviceIdentifier = r3;
        if (r3 != null) goto L5;
        getActivity().finish();
    L5:
        this.mIm = (InputManager) getSystemService("input");
        setPreferenceScreen(createPreferenceHierarchy());
    }

    public void com_android_settings_inputmethod_KeyboardLayoutPickerFragment__onResume$___twin___() {
        super.onResume();
        this.mIm.registerInputDeviceListener(this, null);
        InputDevice r0 = this.mIm.getInputDeviceByDescriptor(this.mInputDeviceIdentifier.getDescriptor());
        if (r0 != null) goto L6;
        getActivity().finish();
        return;
    L6:
        this.mInputDeviceId = r0.getId();
        updateCheckedState();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mIm.unregisterInputDeviceListener(this);
        this.mInputDeviceId = -1;
        super.onPause();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r3) {
        if ((r3 instanceof CheckBoxPreference) == false) goto L13;
        CheckBoxPreference r0 = (CheckBoxPreference) r3;
        KeyboardLayout r1 = this.mPreferenceMap.get(r0);
        if (r1 == null) goto L13;
        if (r0.isChecked() == false) goto L9;
        this.mIm.addKeyboardLayoutForInputDevice(this.mInputDeviceIdentifier, r1.getDescriptor());
        return true;
    L9:
        this.mIm.removeKeyboardLayoutForInputDevice(this.mInputDeviceIdentifier, r1.getDescriptor());
        return true;
    L13:
        return super.onPreferenceTreeClick(r3);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int r2) {
        int r0 = this.mInputDeviceId;
        if (r0 < 0) goto L7;
        if (r2 != r0) goto L8;
        updateCheckedState();
        return;
    L8:
        return;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int r2) {
        int r0 = this.mInputDeviceId;
        if (r0 < 0) goto L7;
        if (r2 != r0) goto L8;
        getActivity().finish();
        return;
    L8:
        return;
    }

    private PreferenceScreen createPreferenceHierarchy() {
        PreferenceScreen r0 = getPreferenceManager().createPreferenceScreen(getActivity());
        getActivity();
        KeyboardLayout[] r1 = this.mKeyboardLayouts;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        KeyboardLayout r4 = r1[r3];
        CheckBoxPreference r5 = new CheckBoxPreference(getPrefContext());
        r5.setTitle(r4.getLabel());
        r5.setSummary(r4.getCollection());
        r0.addPreference(r5);
        this.mPreferenceMap.put(r5, r4);
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_KeyboardLayoutPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(KeyboardLayoutPickerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_KeyboardLayoutPickerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_KeyboardLayoutPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(KeyboardLayoutPickerFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_KeyboardLayoutPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_KeyboardLayoutPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(KeyboardLayoutPickerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_KeyboardLayoutPickerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
