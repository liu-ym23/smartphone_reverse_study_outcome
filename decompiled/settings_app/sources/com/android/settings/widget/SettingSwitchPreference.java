package com.android.settings.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes.dex */
public class SettingSwitchPreference extends Preference {
    private static final String TAG = "SettingSwitchPreference";
    private CompoundButton.OnCheckedChangeListener mCheckListener;
    private boolean mChecked;
    private SwitchEx mSwitch;
    private Object mSwitchTag;

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        public SavedState(Parcel r2) {
            super(r2);
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.checked = r0;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public SettingSwitchPreference(Context r2) {
        this(r2, null);
    }

    public SettingSwitchPreference(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingSwitchPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setLayoutResource(R.layout.setting_switch_preference_layout);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mCheckListener = r1;
    }

    public void setTagForSwitch(Object r1) {
        this.mSwitchTag = r1;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        SwitchEx r3 = (SwitchEx) r2.itemView.findViewById(R.id.item_switcher);
        this.mSwitch = r3;
        Object r0 = this.mSwitchTag;
        if (r0 == null) goto L5;
        r3.setTag(r0);
    L5:
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mSwitch.setChecked(this.mChecked);
        this.mSwitch.setOnCheckedChangeListener(this.mCheckListener);
    }

    public void setChecked(boolean r1) {
        this.mChecked = r1;
        notifyChanged();
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (isPersistent() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.checked = isChecked();
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
        setChecked(r4.checked);
    }
}
