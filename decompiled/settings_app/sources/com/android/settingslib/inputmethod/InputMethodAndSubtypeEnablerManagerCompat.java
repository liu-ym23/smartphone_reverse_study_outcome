package com.android.settingslib.inputmethod;

import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import androidx.preference.TwoStatePreference;
import com.android.settingslib.R;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InputMethodAndSubtypeEnablerManagerCompat implements Preference.OnPreferenceChangeListener {
    private final HashMap<String, TwoStatePreference> mAutoSelectionPrefsMap;
    private final Collator mCollator;
    private final PreferenceFragmentCompat mFragment;
    private boolean mHaveHardKeyboard;
    private InputMethodManager mImm;
    private final HashMap<String, List<Preference>> mInputMethodAndSubtypePrefsMap;
    private List<InputMethodInfo> mInputMethodInfoList;

    public InputMethodAndSubtypeEnablerManagerCompat(PreferenceFragmentCompat r2) {
        this.mInputMethodAndSubtypePrefsMap = new HashMap();
        this.mAutoSelectionPrefsMap = new HashMap();
        this.mCollator = Collator.getInstance();
        this.mFragment = r2;
        InputMethodManager r3 = (InputMethodManager) r2.getContext().getSystemService(InputMethodManager.class);
        this.mImm = r3;
        this.mInputMethodInfoList = r3.getInputMethodList();
    }

    public void init(PreferenceFragmentCompat r4, String r5, PreferenceScreen r6) {
        if (r4.getResources().getConfiguration().keyboard != 2) goto L5;
        boolean r0 = true;
    L6:
        this.mHaveHardKeyboard = r0;
        Iterator<InputMethodInfo> r1 = this.mInputMethodInfoList.iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        InputMethodInfo r2 = r1.next();
        if (r2.getId().equals(r5) == true) goto L13;
        if (TextUtils.isEmpty(r5) == false) goto L8;
    L13:
        addInputMethodSubtypePreferences(r4, r2, r6);
        goto L8
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void refresh(Context r3, PreferenceFragmentCompat r4) {
        InputMethodSettingValuesWrapper.getInstance(r3).refreshAllInputMethodAndSubtypes();
        InputMethodAndSubtypeUtilCompat.loadInputMethodSubtypeList(r4, r3.getContentResolver(), this.mInputMethodInfoList, this.mInputMethodAndSubtypePrefsMap);
        updateAutoSelectionPreferences();
    }

    public void save(Context r2, PreferenceFragmentCompat r3) {
        InputMethodAndSubtypeUtilCompat.saveInputMethodSubtypeList(r3, r2.getContentResolver(), this.mInputMethodInfoList, this.mHaveHardKeyboard);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r6, Object r7) {
        if ((r7 instanceof Boolean) == true) goto L5;
        return true;
    L5:
        boolean r8 = ((Boolean) r7).booleanValue();
        Iterator<String> r0 = this.mAutoSelectionPrefsMap.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        String r2 = r0.next();
        if (this.mAutoSelectionPrefsMap.get(r2) != r6) goto L7;
        TwoStatePreference r9 = (TwoStatePreference) r6;
        r9.setChecked(r8);
        setAutoSelectionSubtypesEnabled(r2, r9.isChecked());
        return false;
    L13:
        if ((r6 instanceof InputMethodSubtypePreference) == false) goto L18;
        InputMethodSubtypePreference r10 = (InputMethodSubtypePreference) r6;
        r10.setChecked(r8);
        if (r10.isChecked() == true) goto L17;
        updateAutoSelectionPreferences();
    L17:
        return false;
    L18:
        return true;
    }

    private void addInputMethodSubtypePreferences(PreferenceFragmentCompat r9, InputMethodInfo r10, PreferenceScreen r11) {
        Context r12 = r9.getPreferenceManager().getContext();
        int r0 = r10.getSubtypeCount();
        if (r0 > 1) goto L5;
        return;
    L5:
        String r1 = r10.getId();
        PreferenceCategory r2 = new PreferenceCategory(r12);
        r11.addPreference(r2);
        r2.setTitle(r10.loadLabel(r12.getPackageManager()));
        r2.setKey(r1);
        SwitchWithNoTextPreference r3 = new SwitchWithNoTextPreference(r12);
        this.mAutoSelectionPrefsMap.put(r1, r3);
        r2.addPreference(r3);
        r3.setOnPreferenceChangeListener(this);
        PreferenceCategory r4 = new PreferenceCategory(r12);
        r4.setTitle(R.string.active_input_method_subtypes);
        r11.addPreference(r4);
        ArrayList r13 = new ArrayList();
        String r5 = null;
        int r6 = 0;
    L6:
        if (r6 >= r0) goto L13;
        InputMethodSubtype r7 = r10.getSubtypeAt(r6);
        if (r7.overridesImplicitlyEnabledSubtype() == false) goto L11;
        if (r5 != null) goto L12;
        r5 = InputMethodAndSubtypeUtil.getSubtypeLocaleNameAsSentence(r7, r12, r10);
    L12:
        r6 = r6 + 1;
        goto L6
    L11:
        r13.add(new InputMethodSubtypePreference(r12, r7, r10));
        goto L12
    L13:
        r13.sort(new InputMethodAndSubtypeEnablerManagerCompat$$ExternalSyntheticLambda0(this));
        Iterator r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        Preference r15 = (Preference) r14.next();
        r4.addPreference(r15);
        r15.setOnPreferenceChangeListener(this);
        InputMethodAndSubtypeUtil.removeUnnecessaryNonPersistentPreference(r15);
        goto L15
    L17:
        this.mInputMethodAndSubtypePrefsMap.put(r1, r13);
        if (TextUtils.isEmpty(r5) == false) goto L20;
        r3.setTitle(R.string.use_system_language_to_select_input_method_subtypes);
        return;
    L20:
        r3.setTitle(r5);
    }

    /* JADX INFO: renamed from: lambda$addInputMethodSubtypePreferences$0$com-android-settingslib-inputmethod-InputMethodAndSubtypeEnablerManagerCompat, reason: not valid java name */
    /* synthetic */ int m761x360cd944(Preference r2, Preference r3) {
        if ((r2 instanceof InputMethodSubtypePreference) == false) goto L7;
        return ((InputMethodSubtypePreference) r2).compareTo(r3, this.mCollator);
    L7:
        return r2.compareTo2(r3);
    }

    private boolean isNoSubtypesExplicitlySelected(String r2) {
        Iterator<Preference> r1 = this.mInputMethodAndSubtypePrefsMap.get(r2).iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Preference r3 = r1.next();
        if ((r3 instanceof TwoStatePreference) == false) goto L4;
        if (((TwoStatePreference) r3).isChecked() == false) goto L4;
        return false;
    L11:
        return true;
    }

    private void setAutoSelectionSubtypesEnabled(String r4, boolean r5) {
        TwoStatePreference r0 = this.mAutoSelectionPrefsMap.get(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setChecked(r5);
        Iterator<Preference> r1 = this.mInputMethodAndSubtypePrefsMap.get(r4).iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        Preference r2 = r1.next();
        if ((r2 instanceof TwoStatePreference) == false) goto L7;
        r2.setEnabled(!r5);
        if (r5 == false) goto L7;
        ((TwoStatePreference) r2).setChecked(false);
        goto L7
    L13:
        if (r5 == false) goto L23;
        PreferenceFragmentCompat r6 = this.mFragment;
        InputMethodAndSubtypeUtilCompat.saveInputMethodSubtypeList(r6, r6.getContext().getContentResolver(), this.mInputMethodInfoList, this.mHaveHardKeyboard);
        updateImplicitlyEnabledSubtypes(r4);
        return;
    }

    private void updateImplicitlyEnabledSubtypes(String r5) {
        Iterator<InputMethodInfo> r0 = this.mInputMethodInfoList.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        InputMethodInfo r1 = r0.next();
        String r2 = r1.getId();
        TwoStatePreference r3 = this.mAutoSelectionPrefsMap.get(r2);
        if (r3 == null) goto L4;
        if (r3.isChecked() == false) goto L4;
        if (r2.equals(r5) == true) goto L13;
        if (r5 != null) goto L4;
    L13:
        updateImplicitlyEnabledSubtypesOf(r1);
        goto L4
    }

    private void updateImplicitlyEnabledSubtypesOf(InputMethodInfo r7) {
        String r0 = r7.getId();
        List<Preference> r1 = this.mInputMethodAndSubtypePrefsMap.get(r0);
        List<InputMethodSubtype> r6 = this.mImm.getEnabledInputMethodSubtypeList(r7, true);
        if (r1 == null) goto L18;
        if (r6 == null) goto L27;
        Iterator<Preference> r8 = r1.iterator();
    L8:
        if (r8.hasNext() == false) goto L28;
        Preference r2 = r8.next();
        if ((r2 instanceof TwoStatePreference) == false) goto L8;
        TwoStatePreference r3 = (TwoStatePreference) r2;
        r3.setChecked(false);
        Iterator<InputMethodSubtype> r4 = r6.iterator();
    L14:
        if (r4.hasNext() == false) goto L8;
        if (r3.getKey().equals(r0 + r4.next().hashCode()) == false) goto L14;
        r3.setChecked(true);
        goto L8
    L28:
        return;
    L27:
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
        updateImplicitlyEnabledSubtypes(null);
    }
}
