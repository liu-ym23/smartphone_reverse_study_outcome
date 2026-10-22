package com.android.settings.inputmethod;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingsBottomExtraView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class InputMethodAndSubtypeEnabler extends SettingsPreferenceFragment23 implements CompoundButton.OnCheckedChangeListener {
    private final HashMap<String, SettingItemSwitch> mAutoSelectionPrefsMap;
    private Collator mCollator;
    private boolean mHaveHardKeyboard;
    private LinearLayout mIMSubtypeContainerView;
    private InputMethodManager mImm;
    private final HashMap<String, List<SettingItemSwitch>> mInputMethodAndSubtypePrefsMap;
    private List<InputMethodInfo> mInputMethodInfoList;

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_InputMethodAndSubtypeEnabler_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_InputMethodAndSubtypeEnabler_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public InputMethodAndSubtypeEnabler() {
        this.mInputMethodAndSubtypePrefsMap = new HashMap();
        this.mAutoSelectionPrefsMap = new HashMap();
    }

    static /* synthetic */ Collator access$000(InputMethodAndSubtypeEnabler r0) {
        return r0.mCollator;
    }

    public void com_android_settings_inputmethod_InputMethodAndSubtypeEnabler__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mImm = (InputMethodManager) getSystemService("input_method");
        if (getResources().getConfiguration().keyboard != 2) goto L5;
        boolean r3 = true;
    L6:
        this.mHaveHardKeyboard = r3;
        this.mInputMethodInfoList = this.mImm.getInputMethodList();
        this.mCollator = Collator.getInstance();
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        View r7 = r4.inflate(R.layout.input_method_subtype_enabler_fragment_layout, null);
        this.mIMSubtypeContainerView = (LinearLayout) r7.findViewById(R.id.im_subtype_container);
        String r8 = getStringExtraFromIntentOrArguments("input_method_id");
        int r9 = this.mInputMethodInfoList.size();
        int r0 = 0;
    L3:
        if (r0 >= r9) goto L10;
        InputMethodInfo r1 = this.mInputMethodInfoList.get(r0);
        if (r1.getId().equals(r8) == false) goto L7;
    L8:
        addInputMethodSubtypePreferences(r1);
    L9:
        r0 = r0 + 1;
        goto L3
    L7:
        if (TextUtils.isEmpty(r8) == false) goto L9;
    L10:
        this.mIMSubtypeContainerView.addView(new SettingsBottomExtraView(getActivity()));
        return r7;
    }

    private String getStringExtraFromIntentOrArguments(String r2) {
        String r0 = Utils.getStringExtraSafely(getActivity().getIntent(), r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Bundle r1 = getArguments();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getString(r2);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        String r3 = getStringExtraFromIntentOrArguments("android.intent.extra.TITLE");
        if (TextUtils.isEmpty(r3) == true) goto L6;
        getActivity().setTitle(r3);
        return;
    }

    public void com_android_settings_inputmethod_InputMethodAndSubtypeEnabler__onResume$___twin___() {
        super.onResume();
        InputMethodSettingValuesWrapper.getInstance(getActivity()).refreshAllInputMethodAndSubtypes();
        InputMethodAndSubtypeUtil.loadInputMethodSubtypeList2(this, getContentResolver(), this.mInputMethodInfoList);
        updateAutoSelectionPreferences();
        registerSwitchers(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        registerSwitchers(false);
        updateImplicitlyEnabledSubtypes(null, false);
        InputMethodAndSubtypeUtil.saveInputMethodSubtypeList2(this, getContentResolver(), this.mInputMethodInfoList, this.mHaveHardKeyboard);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r5, boolean r6) {
        registerSwitchers(false);
        Iterator<String> r0 = this.mAutoSelectionPrefsMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();
        if (this.mAutoSelectionPrefsMap.get(r1).getSwitch() != r5) goto L4;
        setAutoSelectionSubtypesEnabled(r1, r6);
        registerSwitchers(true);
        return;
    L9:
        if (r6 == true) goto L11;
        updateAutoSelectionPreferences();
    L11:
        registerSwitchers(true);
    }

    private View createHeaderView(Context r2, CharSequence r3) {
        LinearLayout r1 = (LinearLayout) LayoutInflater.from(r2).inflate(R.layout.header_text_layout, null);
        ((TextView) r1.findViewById(R.id.header_text)).setText(r3);
        return r1;
    }

    private void addInputMethodSubtypePreferences(InputMethodInfo r13) {
        FragmentActivity r0 = getActivity();
        int r1 = r13.getSubtypeCount();
        if (r1 > 1) goto L5;
        return;
    L5:
        String r3 = r13.getId();
        this.mIMSubtypeContainerView.addView(createHeaderView(r0, r13.loadLabel(getPackageManager())));
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -2);
        r4.leftMargin = r0.getResources().getDimensionPixelOffset(R.dimen.list_item_left_right_margin);
        r4.rightMargin = r0.getResources().getDimensionPixelOffset(R.dimen.list_item_left_right_margin);
        SettingItemSwitch r5 = new SettingItemSwitch(r0);
        r5.setBackgroundStyle(1);
        r5.setLayoutParams(r4);
        this.mAutoSelectionPrefsMap.put(r3, r5);
        this.mIMSubtypeContainerView.addView(r5);
        this.mIMSubtypeContainerView.addView(createHeaderView(r0, r0.getString(R.string.active_input_method_subtypes)));
        ArrayList r6 = new ArrayList();
        int r7 = 0;
        String r8 = null;
        int r9 = 0;
    L6:
        if (r9 >= r1) goto L13;
        InputMethodSubtype r10 = r13.getSubtypeAt(r9);
        if (r10.overridesImplicitlyEnabledSubtype() == false) goto L11;
        if (r8 != null) goto L12;
        r8 = InputMethodAndSubtypeUtil.getSubtypeLocaleNameAsSentence(r10, r0, r13);
    L12:
        r9 = r9 + 1;
        goto L6
    L11:
        r6.add(new InputMethodSubtypePreference(r0, r10, r13));
        goto L12
    L13:
        Collections.sort(r6, new AnonymousClass1(this));
        int r14 = r6.size();
    L14:
        if (r7 >= r14) goto L25;
        SettingItemSwitch r2 = (SettingItemSwitch) r6.get(r7);
        if (r1 != 1) goto L18;
        int r11 = 1;
    L24:
        r2.setBackgroundStyle(r11);
        r2.setLayoutParams(r4);
        this.mIMSubtypeContainerView.addView(r2);
        r7 = r7 + 1;
        goto L14
    L18:
        if (r7 != 0) goto L21;
        r11 = 2;
        goto L24
    L21:
        if (r7 != (r1 - 1)) goto L23;
        r11 = 4;
        goto L24
    L23:
        r11 = 3;
        goto L24
    L25:
        this.mInputMethodAndSubtypePrefsMap.put(r3, r6);
        if (TextUtils.isEmpty(r8) == false) goto L28;
        r5.setTitle(R.string.use_system_language_to_select_input_method_subtypes);
        return;
    L28:
        r5.setTitle(r8);
    }

    private boolean isNoSubtypesExplicitlySelected(String r2) {
        Iterator<SettingItemSwitch> r1 = this.mInputMethodAndSubtypePrefsMap.get(r2).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        SettingItemSwitch r3 = r1.next();
        if ((r3 instanceof SettingItemSwitch) == false) goto L4;
        if (r3.isEnabled() == false) goto L4;
        if (r3.isChecked() == false) goto L4;
        return false;
    L13:
        return true;
    }

    private void setAutoSelectionSubtypesEnabled(String r4, boolean r5) {
        SettingItemSwitch r0 = this.mAutoSelectionPrefsMap.get(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setChecked(r5);
        Iterator<SettingItemSwitch> r1 = this.mInputMethodAndSubtypePrefsMap.get(r4).iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        SettingItemSwitch r2 = r1.next();
        if ((r2 instanceof SettingItemSwitch) == false) goto L7;
        r2.setEnabled(!r5);
        if (r5 == false) goto L7;
        r2.setChecked(false);
        goto L7
    L13:
        if (r5 == false) goto L23;
        InputMethodAndSubtypeUtil.saveInputMethodSubtypeList2(this, getContentResolver(), this.mInputMethodInfoList, this.mHaveHardKeyboard);
        updateImplicitlyEnabledSubtypes(r4, true);
        return;
    }

    private void updateImplicitlyEnabledSubtypes(String r5, boolean r6) {
        Iterator<InputMethodInfo> r0 = this.mInputMethodInfoList.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        InputMethodInfo r1 = r0.next();
        String r2 = r1.getId();
        SettingItemSwitch r3 = this.mAutoSelectionPrefsMap.get(r2);
        if (r3 == null) goto L4;
        if (r3.isChecked() == false) goto L4;
        if (r2.equals(r5) == true) goto L13;
        if (r5 != null) goto L4;
    L13:
        updateImplicitlyEnabledSubtypesOf(r1, r6);
        goto L4
    }

    private void updateImplicitlyEnabledSubtypesOf(InputMethodInfo r7, boolean r8) {
        String r0 = r7.getId();
        List<SettingItemSwitch> r1 = this.mInputMethodAndSubtypePrefsMap.get(r0);
        List<InputMethodSubtype> r6 = this.mImm.getEnabledInputMethodSubtypeList(r7, true);
        if (r1 == null) goto L22;
        if (r6 == null) goto L36;
        Iterator<SettingItemSwitch> r9 = r1.iterator();
    L8:
        if (r9.hasNext() == false) goto L37;
        SettingItemSwitch r2 = r9.next();
        if ((r2 instanceof SettingItemSwitch) == false) goto L8;
        r2.setChecked(false);
        if (r8 == false) goto L8;
        Iterator<InputMethodSubtype> r3 = r6.iterator();
    L16:
        if (r3.hasNext() == false) goto L8;
        String r4 = r0 + r3.next().hashCode();
        String r5 = (String) r2.getTag();
        if (r5 == null) goto L16;
        if (r5.equals(r4) == false) goto L16;
        r2.setChecked(true);
        goto L8
    L37:
        return;
    L36:
        return;
    }

    private void updateAutoSelectionPreferences() {
        Iterator<String> r0 = this.mInputMethodAndSubtypePrefsMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        setAutoSelectionSubtypesEnabled(r1, isNoSubtypesExplicitlySelected(r1));
        goto L4
    L6:
        updateImplicitlyEnabledSubtypes(null, true);
    }

    private void registerSwitchers(boolean r4) {
        if (this.mIMSubtypeContainerView == null) goto L15;
        int r0 = 0;
    L6:
        if (r0 >= this.mIMSubtypeContainerView.getChildCount()) goto L19;
        View r1 = this.mIMSubtypeContainerView.getChildAt(r0);
        if ((r1 instanceof SettingItemSwitch) == false) goto L14;
        SettingItemSwitch r2 = (SettingItemSwitch) r1;
        if (r4 == false) goto L12;
        InputMethodAndSubtypeEnabler r3 = this;
    L13:
        r2.setOnCheckedChangeListener(r3);
        goto L14
    L12:
        r3 = null;
    L14:
        r0 = r0 + 1;
        goto L6
    L19:
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.DialogPreference.TargetFragment
    public Preference findPreference(CharSequence r1) {
        throw new RuntimeException("InputMethodAndSubtypeEnabler don't support findPreference");
    }

    public SettingItemSwitch findSwitchViaTag(String r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        List<SettingItemSwitch> r2 = this.mInputMethodAndSubtypePrefsMap.get(r3);
        if (r2 == null) goto L15;
        Iterator<SettingItemSwitch> r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        SettingItemSwitch r6 = r5.next();
        String r0 = (String) r6.getTag();
        if (r0 == null) goto L9;
        if (r0.equals(r4) == false) goto L9;
        return r6;
    L15:
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_InputMethodAndSubtypeEnabler_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(InputMethodAndSubtypeEnabler r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_InputMethodAndSubtypeEnabler__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_InputMethodAndSubtypeEnabler_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(InputMethodAndSubtypeEnabler r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_InputMethodAndSubtypeEnabler_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_InputMethodAndSubtypeEnabler_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(InputMethodAndSubtypeEnabler r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_InputMethodAndSubtypeEnabler__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
