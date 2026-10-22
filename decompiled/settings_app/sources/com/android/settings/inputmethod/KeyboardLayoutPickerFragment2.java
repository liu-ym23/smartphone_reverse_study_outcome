package com.android.settings.inputmethod;

import android.app.Activity;
import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputManager;
import android.hardware.input.KeyboardLayout;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.internal.util.Preconditions;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyboardLayoutPickerFragment2 extends SettingsPreferenceFragment implements InputManager.InputDeviceListener {
    public static final String EXTRA_INPUT_DEVICE_IDENTIFIER = "input_device_identifier";
    public static final String EXTRA_INPUT_METHOD_INFO = "input_method_info";
    public static final String EXTRA_INPUT_METHOD_SUBTYPE = "input_method_subtype";
    private InputManager mIm;
    private InputMethodInfo mImi;
    private int mInputDeviceId;
    private InputDeviceIdentifier mInputDeviceIdentifier;
    private KeyboardLayout[] mKeyboardLayouts;
    private Map<Preference, KeyboardLayout> mPreferenceMap;
    private InputMethodSubtype mSubtype;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_KeyboardLayoutPickerFragment2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int r1) {
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int r1) {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_KeyboardLayoutPickerFragment2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public KeyboardLayoutPickerFragment2() {
        this.mInputDeviceId = -1;
        this.mPreferenceMap = new HashMap();
    }

    public void com_android_settings_inputmethod_KeyboardLayoutPickerFragment2__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Activity r4 = (Activity) Preconditions.checkNotNull(getActivity());
        this.mInputDeviceIdentifier = r4.getIntent().getParcelableExtra("input_device_identifier");
        this.mImi = (InputMethodInfo) r4.getIntent().getParcelableExtra(EXTRA_INPUT_METHOD_INFO);
        this.mSubtype = (InputMethodSubtype) r4.getIntent().getParcelableExtra(EXTRA_INPUT_METHOD_SUBTYPE);
        if (this.mInputDeviceIdentifier != null) goto L5;
    L6:
        r4.finish();
    L7:
        InputManager r5 = (InputManager) r4.getSystemService(InputManager.class);
        this.mIm = r5;
        KeyboardLayout[] r6 = r5.getKeyboardLayoutsForInputDevice(this.mInputDeviceIdentifier);
        this.mKeyboardLayouts = r6;
        Arrays.sort(r6);
        setPreferenceScreen(createPreferenceHierarchy());
        return;
    L5:
        if (this.mImi != null) goto L7;
        goto L6
    }

    public void com_android_settings_inputmethod_KeyboardLayoutPickerFragment2__onResume$___twin___() {
        super.onResume();
        this.mIm.registerInputDeviceListener(this, null);
        InputDevice r0 = this.mIm.getInputDeviceByDescriptor(this.mInputDeviceIdentifier.getDescriptor());
        if (r0 != null) goto L6;
        getActivity().finish();
        return;
    L6:
        this.mInputDeviceId = r0.getId();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mIm.unregisterInputDeviceListener(this);
        this.mInputDeviceId = -1;
        super.onPause();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r5) {
        KeyboardLayout r0 = this.mPreferenceMap.get(r5);
        if (r0 == null) goto L7;
        MultiSDKAdapter.addKeyboardLayoutForInputDevice(this.mIm, this.mInputDeviceIdentifier, this.mImi, this.mSubtype, r0);
        getActivity().finish();
        return true;
    L7:
        return super.onPreferenceTreeClick(r5);
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
        KeyboardLayout[] r1 = this.mKeyboardLayouts;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        KeyboardLayout r4 = r1[r3];
        Preference r5 = new Preference(getPrefContext());
        r5.setTitle(r4.getLabel());
        r5.setSummary(r4.getCollection());
        r0.addPreference(r5);
        this.mPreferenceMap.put(r5, r4);
        r3 = r3 + 1;
        goto L3
    L5:
        r0.setTitle(PhysicalKeyboardFragment.KeyboardInfoPreference.getDisplayName(getContext(), this.mImi, this.mSubtype));
        return r0;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_KeyboardLayoutPickerFragment2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(KeyboardLayoutPickerFragment2 r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_KeyboardLayoutPickerFragment2__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_KeyboardLayoutPickerFragment2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(KeyboardLayoutPickerFragment2 r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_KeyboardLayoutPickerFragment2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_KeyboardLayoutPickerFragment2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(KeyboardLayoutPickerFragment2 r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_KeyboardLayoutPickerFragment2__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
