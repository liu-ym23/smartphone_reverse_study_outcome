package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    private static final String TAG = "SeekBarPreference";
    boolean mAdjustable;
    private int mMax;
    int mMin;
    SeekBar mSeekBar;
    private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    private int mSeekBarIncrement;
    private View.OnKeyListener mSeekBarKeyListener;
    int mSeekBarValue;
    private TextView mSeekBarValueTextView;
    private boolean mShowSeekBarValue;
    boolean mTrackingTouch;
    boolean mUpdatesContinuously;

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int mMax;
        int mMin;
        int mSeekBarValue;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r2) {
            super(r2);
            this.mSeekBarValue = r2.readInt();
            this.mMin = r2.readInt();
            this.mMax = r2.readInt();
        }

        SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.mSeekBarValue);
            r1.writeInt(this.mMin);
            r1.writeInt(this.mMax);
        }
    }

    public SeekBarPreference(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        this.mSeekBarChangeListener = new AnonymousClass1(this);
        this.mSeekBarKeyListener = new AnonymousClass2(this);
        TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.SeekBarPreference, r4, r5);
        this.mMin = r6.getInt(R.styleable.SeekBarPreference_min, 0);
        setMax(r6.getInt(R.styleable.SeekBarPreference_android_max, 100));
        setSeekBarIncrement(r6.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.mAdjustable = r6.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.mShowSeekBarValue = r6.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.mUpdatesContinuously = r6.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        r6.recycle();
    }

    public SeekBarPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public SeekBarPreference(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.seekBarPreferenceStyle);
    }

    public SeekBarPreference(Context r2) {
        this(r2, null);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        r3.itemView.setOnKeyListener(this.mSeekBarKeyListener);
        this.mSeekBar = (SeekBar) r3.findViewById(R.id.seekbar);
        TextView r4 = (TextView) r3.findViewById(R.id.seekbar_value);
        this.mSeekBarValueTextView = r4;
        if (this.mShowSeekBarValue == false) goto L5;
        r4.setVisibility(0);
    L6:
        SeekBar r5 = this.mSeekBar;
        if (r5 != null) goto L10;
        Log.e(TAG, "SeekBar view is null in onBindViewHolder.");
        return;
    L10:
        r5.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        this.mSeekBar.setMax(this.mMax - this.mMin);
        int r6 = this.mSeekBarIncrement;
        if (r6 == 0) goto L13;
        this.mSeekBar.setKeyProgressIncrement(r6);
    L14:
        this.mSeekBar.setProgress(this.mSeekBarValue - this.mMin);
        updateLabelValue(this.mSeekBarValue);
        this.mSeekBar.setEnabled(isEnabled());
        return;
    L13:
        this.mSeekBarIncrement = this.mSeekBar.getKeyProgressIncrement();
        goto L14
    L5:
        r4.setVisibility(8);
        this.mSeekBarValueTextView = null;
        goto L6
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object r1) {
        if (r1 != null) goto L4;
        r1 = 0;
    L4:
        setValue(getPersistedInt(((Integer) r1).intValue()));
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray r1, int r2) {
        return Integer.valueOf(r1.getInt(r2, 0));
    }

    public int getMin() {
        return this.mMin;
    }

    public void setMin(int r2) {
        int r0 = this.mMax;
        if (r2 <= r0) goto L6;
        r2 = r0;
    L6:
        if (r2 == this.mMin) goto L9;
        this.mMin = r2;
        notifyChanged();
        return;
    }

    public final int getSeekBarIncrement() {
        return this.mSeekBarIncrement;
    }

    public final void setSeekBarIncrement(int r3) {
        if (r3 == this.mSeekBarIncrement) goto L6;
        this.mSeekBarIncrement = Math.min(this.mMax - this.mMin, Math.abs(r3));
        notifyChanged();
        return;
    }

    public int getMax() {
        return this.mMax;
    }

    public final void setMax(int r2) {
        int r0 = this.mMin;
        if (r2 >= r0) goto L6;
        r2 = r0;
    L6:
        if (r2 == this.mMax) goto L9;
        this.mMax = r2;
        notifyChanged();
        return;
    }

    public boolean isAdjustable() {
        return this.mAdjustable;
    }

    public void setAdjustable(boolean r1) {
        this.mAdjustable = r1;
    }

    public boolean getUpdatesContinuously() {
        return this.mUpdatesContinuously;
    }

    public void setUpdatesContinuously(boolean r1) {
        this.mUpdatesContinuously = r1;
    }

    public boolean getShowSeekBarValue() {
        return this.mShowSeekBarValue;
    }

    public void setShowSeekBarValue(boolean r1) {
        this.mShowSeekBarValue = r1;
        notifyChanged();
    }

    private void setValueInternal(int r2, boolean r3) {
        int r0 = this.mMin;
        if (r2 >= r0) goto L5;
        r2 = r0;
    L5:
        int r1 = this.mMax;
        if (r2 <= r1) goto L9;
        r2 = r1;
    L9:
        if (r2 == this.mSeekBarValue) goto L14;
        this.mSeekBarValue = r2;
        updateLabelValue(r2);
        persistInt(r2);
        if (r3 == false) goto L15;
        notifyChanged();
        return;
    L15:
        return;
    }

    public int getValue() {
        return this.mSeekBarValue;
    }

    public void setValue(int r2) {
        setValueInternal(r2, true);
    }

    void syncValueInternal(SeekBar r3) {
        int r0 = this.mMin + r3.getProgress();
        if (r0 != this.mSeekBarValue) goto L5;
        return;
    L5:
        if (callChangeListener(Integer.valueOf(r0)) == false) goto L7;
        setValueInternal(r0, false);
        return;
    L7:
        r3.setProgress(this.mSeekBarValue - this.mMin);
        updateLabelValue(this.mSeekBarValue);
    }

    void updateLabelValue(int r1) {
        TextView r0 = this.mSeekBarValueTextView;
        if (r0 == null) goto L6;
        r0.setText(String.valueOf(r1));
        return;
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (isPersistent() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.mSeekBarValue = this.mSeekBarValue;
        r1.mMin = this.mMin;
        r1.mMax = this.mMax;
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
        this.mSeekBarValue = r4.mSeekBarValue;
        this.mMin = r4.mMin;
        this.mMax = r4.mMax;
        notifyChanged();
    }
}
