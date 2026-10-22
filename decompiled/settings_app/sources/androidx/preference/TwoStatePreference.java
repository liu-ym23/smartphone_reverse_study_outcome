package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    protected boolean mChecked;
    private boolean mCheckedSet;
    private boolean mDisableDependentsState;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mChecked;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r2) {
            super(r2);
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.mChecked = r0;
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.mChecked ? 1 : 0);
        }
    }

    public TwoStatePreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    public TwoStatePreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public TwoStatePreference(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TwoStatePreference(Context r2) {
        this(r2, null);
    }

    @Override // androidx.preference.Preference
    protected void onClick() {
        super.onClick();
        boolean r0 = !isChecked();
        if (callChangeListener(Boolean.valueOf(r0)) == false) goto L6;
        setChecked(r0);
        return;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean r4) {
        if (this.mChecked == r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L9:
        this.mChecked = r4;
        this.mCheckedSet = true;
        persistBoolean(r4);
        if (r0 == false) goto L14;
        notifyDependencyChange(shouldDisableDependents());
        notifyChanged();
        return;
    L14:
        return;
    L8:
        if (this.mCheckedSet == false) goto L9;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        if (this.mDisableDependentsState == false) goto L6;
        boolean r0 = this.mChecked;
    L9:
        if (r0 == false) goto L11;
        return true;
    L11:
        if (super.shouldDisableDependents() == false) goto L14;
        return true;
    L14:
        return false;
    L6:
        if (this.mChecked == true) goto L8;
        r0 = true;
        goto L9
    L8:
        r0 = false;
        goto L9
    }

    public void setSummaryOn(CharSequence r1) {
        this.mSummaryOn = r1;
        if (isChecked() == false) goto L6;
        notifyChanged();
        return;
    }

    public CharSequence getSummaryOn() {
        return this.mSummaryOn;
    }

    public void setSummaryOn(int r2) {
        setSummaryOn(getContext().getString(r2));
    }

    public void setSummaryOff(CharSequence r1) {
        this.mSummaryOff = r1;
        if (isChecked() == true) goto L6;
        notifyChanged();
        return;
    }

    public CharSequence getSummaryOff() {
        return this.mSummaryOff;
    }

    public void setSummaryOff(int r2) {
        setSummaryOff(getContext().getString(r2));
    }

    public boolean getDisableDependentsState() {
        return this.mDisableDependentsState;
    }

    public void setDisableDependentsState(boolean r1) {
        this.mDisableDependentsState = r1;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray r1, int r2) {
        return Boolean.valueOf(r1.getBoolean(r2, false));
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object r1) {
        if (r1 != null) goto L4;
        r1 = false;
    L4:
        setChecked(getPersistedBoolean(((Boolean) r1).booleanValue()));
    }

    protected void syncSummaryView(PreferenceViewHolder r2) {
        syncSummaryView(r2.findViewById(android.R.id.summary));
    }

    protected void syncSummaryView(View r4) {
        if ((r4 instanceof TextView) == true) goto L5;
        return;
    L5:
        TextView r5 = (TextView) r4;
        int r1 = 0;
        if (this.mChecked == false) goto L12;
        if (TextUtils.isEmpty(this.mSummaryOn) == true) goto L12;
        r5.setText(this.mSummaryOn);
    L10:
        boolean r0 = false;
    L17:
        if (r0 == false) goto L21;
        CharSequence r3 = getSummary();
        if (TextUtils.isEmpty(r3) == true) goto L21;
        r5.setText(r3);
        r0 = false;
    L21:
        if (r0 == false) goto L25;
        r1 = 8;
    L25:
        if (r1 == r5.getVisibility()) goto L28;
        r5.setVisibility(r1);
        return;
    L28:
        return;
    L12:
        if (this.mChecked == false) goto L14;
    L16:
        r0 = true;
        goto L17
    L14:
        if (TextUtils.isEmpty(this.mSummaryOff) == true) goto L16;
        r5.setText(this.mSummaryOff);
        goto L10
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (isPersistent() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.mChecked = isChecked();
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
        setChecked(r4.mChecked);
    }
}
