package com.android.settings.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes.dex */
public class NotificationAccessPreference extends Preference {
    private static final String TAG = "NotificationAccessPreference";
    private CompoundButton.OnCheckedChangeListener mCheckListener;
    private boolean mChecked;
    private Drawable mIcon;
    private int mStyle;
    private ListContentItemSwitch mSwitch;
    private CharSequence mTitle;

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

    public NotificationAccessPreference(Context r2) {
        this(r2, null);
    }

    public NotificationAccessPreference(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public NotificationAccessPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setLayoutResource(R.layout.notification_access_preference_layout);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mCheckListener = r1;
    }

    @Override // androidx.preference.Preference
    public void setIcon(Drawable r1) {
        this.mIcon = r1;
    }

    @Override // androidx.preference.Preference
    public void setTitle(CharSequence r1) {
        this.mTitle = r1;
    }

    public void setBackgroundStyle(int r1) {
        this.mStyle = r1;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        View r4 = r3.itemView;
        this.mSwitch = (ListContentItemSwitch) r4.findViewById(R.id.switcher);
        View r5 = r4.findViewById(R.id.empty_view);
        r5.setVisibility(8);
        this.mSwitch.setBackgroundStyle(this.mStyle);
        this.mSwitch.setIcon(this.mIcon);
        this.mSwitch.setTitle(this.mTitle);
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mSwitch.setChecked(this.mChecked);
        this.mSwitch.setOnCheckedChangeListener(this.mCheckListener);
        int r2 = this.mStyle;
        if (r2 != 4) goto L5;
    L6:
        r5.setVisibility(0);
        return;
    L5:
        if (r2 == 1) goto L6;
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
