package androidx.preference;

import android.app.AlertDialog;
import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragment.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragment.values";
    CharSequence[] mEntries;
    CharSequence[] mEntryValues;
    Set<String> mNewValues;
    boolean mPreferenceChanged;

    public void androidx_preference_MultiSelectListPreferenceDialogFragment__onPause$___twin___() {
        super.onPause();
    }

    public void androidx_preference_MultiSelectListPreferenceDialogFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle r1) {
        androidx_preference_MultiSelectListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        androidx_preference_MultiSelectListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        androidx_preference_MultiSelectListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
    }

    @Deprecated
    public MultiSelectListPreferenceDialogFragment() {
        this.mNewValues = new HashSet();
    }

    @Deprecated
    public static MultiSelectListPreferenceDialogFragment newInstance(String r3) {
        MultiSelectListPreferenceDialogFragment r0 = new MultiSelectListPreferenceDialogFragment();
        Bundle r1 = new Bundle(1);
        r1.putString("key", r3);
        r0.setArguments(r1);
        return r0;
    }

    public void androidx_preference_MultiSelectListPreferenceDialogFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        if (r4 != null) goto L11;
        MultiSelectListPreference r5 = getListPreference();
        if (r5.getEntries() == null) goto L10;
        if (r5.getEntryValues() == null) goto L10;
        this.mNewValues.clear();
        this.mNewValues.addAll(r5.getValues());
        this.mPreferenceChanged = false;
        this.mEntries = r5.getEntries();
        this.mEntryValues = r5.getEntryValues();
        return;
    L10:
        throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
    L11:
        this.mNewValues.clear();
        this.mNewValues.addAll(r4.getStringArrayList(SAVE_STATE_VALUES));
        this.mPreferenceChanged = r4.getBoolean(SAVE_STATE_CHANGED, false);
        this.mEntries = r4.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.mEntryValues = r4.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putStringArrayList(SAVE_STATE_VALUES, new ArrayList(this.mNewValues));
        r3.putBoolean(SAVE_STATE_CHANGED, this.mPreferenceChanged);
        r3.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        r3.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
    }

    private MultiSelectListPreference getListPreference() {
        return (MultiSelectListPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void onPrepareDialogBuilder(AlertDialog.Builder r6) {
        super.onPrepareDialogBuilder(r6);
        int r0 = this.mEntryValues.length;
        boolean[] r1 = new boolean[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.mNewValues.contains(this.mEntryValues[r2].toString());
        r2 = r2 + 1;
        goto L3
    L5:
        r6.setMultiChoiceItems(this.mEntries, r1, new AnonymousClass1(this));
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean r3) {
        MultiSelectListPreference r0 = getListPreference();
        if (r3 == true) goto L5;
    L9:
        this.mPreferenceChanged = false;
        return;
    L5:
        if (this.mPreferenceChanged == false) goto L9;
        Set<String> r4 = this.mNewValues;
        if (r0.callChangeListener(r4) == false) goto L9;
        r0.setValues(r4);
        goto L9
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void androidx_preference_MultiSelectListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(MultiSelectListPreferenceDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.androidx_preference_MultiSelectListPreferenceDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void androidx_preference_MultiSelectListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(MultiSelectListPreferenceDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.androidx_preference_MultiSelectListPreferenceDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void androidx_preference_MultiSelectListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(MultiSelectListPreferenceDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.androidx_preference_MultiSelectListPreferenceDialogFragment__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
