package com.android.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.RestrictedPreference;

/* JADX INFO: loaded from: classes2.dex */
public class SeekBarPreference extends RestrictedPreference implements SeekBar.OnSeekBarChangeListener, View.OnKeyListener {
    private int mMax;
    private int mProgress;
    private boolean mTrackingTouch;

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int max;
        int progress;

        public SavedState(Parcel r2) {
            super(r2);
            this.progress = r2.readInt();
            this.max = r2.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.progress);
            r1.writeInt(this.max);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        return null;
    }

    public SeekBarPreference(Context r4, AttributeSet r5, int r6, int r7) {
        super(r4, r5, r6, r7);
        TypedArray r0 = r4.obtainStyledAttributes(r5, com.android.internal.R.styleable.ProgressBar, r6, r7);
        setMax(r0.getInt(2, this.mMax));
        r0.recycle();
        TypedArray r8 = r4.obtainStyledAttributes(r5, com.android.internal.R.styleable.SeekBarPreference, r6, r7);
        int r9 = r8.getResourceId(0, android.R.layout.time_picker_header_material);
        r8.recycle();
        setLayoutResource(r9);
    }

    public SeekBarPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public SeekBarPreference(Context r2, AttributeSet r3) {
        this(r2, r3, android.R.^attr-private.trackDrawable);
    }

    public SeekBarPreference(Context r2) {
        this(r2, null);
    }

    @Override // com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        r2.itemView.setOnKeyListener(this);
        SeekBar r3 = (SeekBar) r2.findViewById(android.R.id.time);
        r3.setOnSeekBarChangeListener(this);
        r3.setMax(this.mMax);
        r3.setProgress(this.mProgress);
        r3.setEnabled(isEnabled());
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(boolean r1, Object r2) {
        if (r1 == false) goto L4;
        int r3 = getPersistedInt(this.mProgress);
    L5:
        setProgress(r3);
        return;
    L4:
        r3 = ((Integer) r2).intValue();
        goto L5
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray r1, int r2) {
        return Integer.valueOf(r1.getInt(r2, 0));
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r2, int r3, KeyEvent r4) {
        if (r4.getAction() == 0) goto L5;
        return false;
    L5:
        SeekBar r1 = (SeekBar) r2.findViewById(android.R.id.time);
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.onKeyDown(r3, r4);
    }

    public void setMax(int r2) {
        if (r2 == this.mMax) goto L6;
        this.mMax = r2;
        notifyChanged();
        return;
    }

    public void setProgress(int r2) {
        setProgress(r2, true);
    }

    private void setProgress(int r2, boolean r3) {
        int r0 = this.mMax;
        if (r2 <= r0) goto L5;
        r2 = r0;
    L5:
        if (r2 >= 0) goto L8;
        r2 = 0;
    L8:
        if (r2 == this.mProgress) goto L13;
        this.mProgress = r2;
        persistInt(r2);
        if (r3 == false) goto L14;
        notifyChanged();
        return;
    L14:
        return;
    }

    public int getProgress() {
        return this.mProgress;
    }

    void syncProgress(SeekBar r3) {
        int r0 = r3.getProgress();
        if (r0 != this.mProgress) goto L5;
        return;
    L5:
        if (callChangeListener(Integer.valueOf(r0)) == false) goto L7;
        setProgress(r0, false);
        return;
    L7:
        r3.setProgress(this.mProgress);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        if (r3 == true) goto L4;
        return;
    L4:
        if (this.mTrackingTouch == true) goto L8;
        syncProgress(r1);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r1) {
        this.mTrackingTouch = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r3) {
        this.mTrackingTouch = false;
        if (r3.getProgress() == this.mProgress) goto L6;
        syncProgress(r3);
        return;
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (isPersistent() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.progress = this.mProgress;
        r1.max = this.mMax;
        return r1;
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable r3) {
        if (r3.getClass().equals(SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r3);
        return;
    L6:
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        this.mProgress = r4.progress;
        this.mMax = r4.max;
        notifyChanged();
    }
}
