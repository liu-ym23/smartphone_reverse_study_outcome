package androidx.preference;

import android.app.AlertDialog;
import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ListPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_ENTRIES = "ListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "ListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_INDEX = "ListPreferenceDialogFragment.index";
    int mClickedDialogEntryIndex;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;

    public void androidx_preference_ListPreferenceDialogFragment__onPause$___twin___() {
        super.onPause();
    }

    public void androidx_preference_ListPreferenceDialogFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle r1) {
        androidx_preference_ListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        androidx_preference_ListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        androidx_preference_ListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
    }

    @Deprecated
    public ListPreferenceDialogFragment() {
    }

    @Deprecated
    public static ListPreferenceDialogFragment newInstance(String r3) {
        ListPreferenceDialogFragment r0 = new ListPreferenceDialogFragment();
        Bundle r1 = new Bundle(1);
        r1.putString("key", r3);
        r0.setArguments(r1);
        return r0;
    }

    public void androidx_preference_ListPreferenceDialogFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        if (r3 != null) goto L11;
        ListPreference r4 = getListPreference();
        if (r4.getEntries() == null) goto L10;
        if (r4.getEntryValues() == null) goto L10;
        this.mClickedDialogEntryIndex = r4.findIndexOfValue(r4.getValue());
        this.mEntries = r4.getEntries();
        this.mEntryValues = r4.getEntryValues();
        return;
    L10:
        throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
    L11:
        this.mClickedDialogEntryIndex = r3.getInt(SAVE_STATE_INDEX, 0);
        this.mEntries = r3.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.mEntryValues = r3.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putInt(SAVE_STATE_INDEX, this.mClickedDialogEntryIndex);
        r3.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        r3.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
    }

    private ListPreference getListPreference() {
        return (ListPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void onPrepareDialogBuilder(AlertDialog.Builder r4) {
        super.onPrepareDialogBuilder(r4);
        r4.setSingleChoiceItems(this.mEntries, this.mClickedDialogEntryIndex, new AnonymousClass1(this));
        r4.setPositiveButton(null, null);
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean r2) {
        ListPreference r0 = getListPreference();
        if (r2 == false) goto L10;
        int r3 = this.mClickedDialogEntryIndex;
        if (r3 < 0) goto L11;
        String r1 = this.mEntryValues[r3].toString();
        if (r0.callChangeListener(r1) == false) goto L12;
        r0.setValue(r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void androidx_preference_ListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(ListPreferenceDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.androidx_preference_ListPreferenceDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void androidx_preference_ListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(ListPreferenceDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.androidx_preference_ListPreferenceDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void androidx_preference_ListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(ListPreferenceDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.androidx_preference_ListPreferenceDialogFragment__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
