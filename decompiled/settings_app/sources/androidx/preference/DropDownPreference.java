package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    private final ArrayAdapter mAdapter;
    private final Context mContext;
    private final AdapterView.OnItemSelectedListener mItemSelectedListener;
    private Spinner mSpinner;

    public DropDownPreference(Context r2) {
        this(r2, null);
    }

    public DropDownPreference(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public DropDownPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mItemSelectedListener = new AnonymousClass1(this);
        this.mContext = r1;
        this.mAdapter = createAdapter();
        updateEntries();
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void onClick() {
        this.mSpinner.performClick();
    }

    @Override // androidx.preference.ListPreference
    public void setEntries(CharSequence[] r1) {
        super.setEntries(r1);
        updateEntries();
    }

    protected ArrayAdapter createAdapter() {
        return new ArrayAdapter(this.mContext, android.R.layout.simple_spinner_dropdown_item);
    }

    private void updateEntries() {
        this.mAdapter.clear();
        if (getEntries() == null) goto L7;
        CharSequence[] r0 = getEntries();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        CharSequence r3 = r0[r2];
        this.mAdapter.add(r3.toString());
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    @Override // androidx.preference.ListPreference
    public void setValueIndex(int r2) {
        setValue(getEntryValues()[r2].toString());
    }

    @Override // androidx.preference.Preference
    protected void notifyChanged() {
        super.notifyChanged();
        ArrayAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        Spinner r0 = (Spinner) r3.itemView.findViewById(R.id.spinner);
        this.mSpinner = r0;
        r0.setAdapter(this.mAdapter);
        this.mSpinner.setOnItemSelectedListener(this.mItemSelectedListener);
        this.mSpinner.setSelection(findSpinnerIndexOfValue(getValue()));
        super.onBindViewHolder(r3);
    }

    private int findSpinnerIndexOfValue(String r3) {
        CharSequence[] r2 = getEntryValues();
        if (r3 == null) goto L11;
        if (r2 == null) goto L15;
        int r0 = r2.length - 1;
    L6:
        if (r0 < 0) goto L16;
        if (r2[r0].equals(r3) == true) goto L9;
        r0 = r0 - 1;
        goto L6
    L9:
        return r0;
    L16:
        return -1;
    L15:
        return -1;
    L11:
        return -1;
    }
}
