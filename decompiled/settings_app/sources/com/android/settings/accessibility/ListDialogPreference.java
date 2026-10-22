package com.android.settings.accessibility;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.Preference;
import com.android.settings.CustomDialogPreference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ListDialogPreference extends CustomDialogPreference {
    private CharSequence[] mEntryTitles;
    private int[] mEntryValues;
    private int mListItemLayout;
    private OnValueChangedListener mOnValueChangedListener;
    private int mValue;
    private int mValueIndex;
    private boolean mValueSet;

    private class ListPreferenceAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        final /* synthetic */ ListDialogPreference this$0;

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        private ListPreferenceAdapter(ListDialogPreference r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ListPreferenceAdapter(ListDialogPreference r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ListDialogPreference.access$100(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Integer getItem(int r1) {
            return Integer.valueOf(ListDialogPreference.access$100(this.this$0)[r1]);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return ListDialogPreference.access$100(this.this$0)[r1];
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 == null) goto L4;
        L7:
            this.this$0.onBindListItem(r4, r3);
            return r4;
        L4:
            if (this.mInflater != null) goto L6;
            this.mInflater = LayoutInflater.from(r5.getContext());
        L6:
            r4 = this.mInflater.inflate(ListDialogPreference.access$200(this.this$0), r5, false);
            goto L7
        }
    }

    public interface OnValueChangedListener {
        void onValueChanged(ListDialogPreference r1, int r2);
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int value;

        public SavedState(Parcel r1) {
            super(r1);
            this.value = r1.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.value);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    protected abstract void onBindListItem(View r1, int r2);

    static /* synthetic */ int[] access$100(ListDialogPreference r0) {
        return r0.mEntryValues;
    }

    static /* synthetic */ int access$200(ListDialogPreference r0) {
        return r0.mListItemLayout;
    }

    public ListDialogPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void setOnValueChangedListener(OnValueChangedListener r1) {
        this.mOnValueChangedListener = r1;
    }

    public void setListItemLayoutResource(int r1) {
        this.mListItemLayout = r1;
    }

    public void setValues(int[] r2) {
        this.mEntryValues = r2;
        if (this.mValueSet == true) goto L5;
        return;
    L5:
        if (this.mValueIndex != (-1)) goto L9;
        this.mValueIndex = getIndexForValue(this.mValue);
        return;
    }

    public void setTitles(CharSequence[] r1) {
        this.mEntryTitles = r1;
    }

    protected CharSequence getTitleAt(int r2) {
        CharSequence[] r1 = this.mEntryTitles;
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.length > r2) goto L8;
        return null;
    L8:
        return r1[r2];
    }

    protected int getValueAt(int r1) {
        return this.mEntryValues[r1];
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        int r0 = this.mValueIndex;
        if (r0 >= 0) goto L5;
        return null;
    L5:
        return getTitleAt(r0);
    }

    @Override // com.android.settings.CustomDialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder r4, DialogInterface.OnClickListener r5) {
        super.onPrepareDialogBuilder(r4, r5);
        Context r6 = getContext();
        int r0 = getDialogLayoutResource();
        View r7 = LayoutInflater.from(r6).inflate(r0, null);
        ListPreferenceAdapter r1 = new ListPreferenceAdapter(this, null);
        AbsListView r2 = (AbsListView) r7.findViewById(R.id.list);
        r2.setAdapter(r1);
        r2.setOnItemClickListener(new AnonymousClass1(this));
        int r3 = getIndexForValue(this.mValue);
        if (r3 == (-1)) goto L5;
        r2.setSelection(r3);
    L5:
        r4.setView(r7);
        r4.setPositiveButton(null, null);
    }

    protected int getIndexForValue(int r4) {
        int[] r3 = this.mEntryValues;
        if (r3 == null) goto L10;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        if (r3[r1] == r4) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return r1;
    L14:
        return -1;
    L10:
        return -1;
    }

    public void setValue(int r4) {
        if (this.mValue == r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L9:
        this.mValue = r4;
        this.mValueIndex = getIndexForValue(r4);
        this.mValueSet = true;
        persistInt(r4);
        if (r0 == false) goto L12;
        notifyDependencyChange(shouldDisableDependents());
        notifyChanged();
    L12:
        OnValueChangedListener r1 = this.mOnValueChangedListener;
        if (r1 == null) goto L17;
        r1.onValueChanged(this, r4);
        return;
    L17:
        return;
    L8:
        if (this.mValueSet == false) goto L9;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int getValue() {
        return this.mValue;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray r1, int r2) {
        return Integer.valueOf(r1.getInt(r2, 0));
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(boolean r1, Object r2) {
        if (r1 == false) goto L4;
        int r3 = getPersistedInt(this.mValue);
    L5:
        setValue(r3);
        return;
    L4:
        r3 = ((Integer) r2).intValue();
        goto L5
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (isPersistent() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.value = getValue();
        return r1;
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable r3) {
        if (r3 != null) goto L4;
    L8:
        super.onRestoreInstanceState(r3);
        return;
    L4:
        if (r3.getClass().equals(SavedState.class) == false) goto L8;
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        setValue(r4.value);
    }
}
