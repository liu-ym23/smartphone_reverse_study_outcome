package androidx.preference;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: loaded from: classes.dex */
public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private static final String SAVE_STATE_ENTRIES = "ListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "ListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_INDEX = "ListPreferenceDialogFragment.index";
    int mClickedDialogEntryIndex;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;

    public ListPreferenceDialogFragmentCompat() {
    }

    public static ListPreferenceDialogFragmentCompat newInstance(String r3) {
        ListPreferenceDialogFragmentCompat r0 = new ListPreferenceDialogFragmentCompat();
        Bundle r1 = new Bundle(1);
        r1.putString("key", r3);
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
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

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putInt(SAVE_STATE_INDEX, this.mClickedDialogEntryIndex);
        r3.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        r3.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
    }

    private ListPreference getListPreference() {
        return (ListPreference) getPreference();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void onPrepareDialogBuilder(AlertDialog.Builder r4) {
        super.onPrepareDialogBuilder(r4);
        r4.setSingleChoiceItems(this.mEntries, this.mClickedDialogEntryIndex, new AnonymousClass1(this));
        r4.setPositiveButton(null, null);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean r2) {
        if (r2 == false) goto L9;
        int r3 = this.mClickedDialogEntryIndex;
        if (r3 < 0) goto L10;
        String r4 = this.mEntryValues[r3].toString();
        ListPreference r1 = getListPreference();
        if (r1.callChangeListener(r4) == false) goto L11;
        r1.setValue(r4);
        return;
    L11:
        return;
    L10:
        return;
    }
}
