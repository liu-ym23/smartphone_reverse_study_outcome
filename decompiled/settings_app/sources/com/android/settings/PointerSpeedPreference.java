package com.android.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.hardware.input.InputManager;
import android.hardware.input.InputSettings;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.android.settings.utils.NullSafe;

/* JADX INFO: loaded from: classes2.dex */
public class PointerSpeedPreference extends android.preference.SeekBarDialogPreference implements SeekBar.OnSeekBarChangeListener {
    private final InputManager mIm;
    private int mOldSpeed;
    private boolean mRestoredOldState;
    private SeekBar mSeekBar;
    private ContentObserver mSpeedObserver;
    private boolean mTouchInProgress;

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int oldSpeed;
        int progress;

        public SavedState(Parcel r2) {
            super(r2);
            this.progress = r2.readInt();
            this.oldSpeed = r2.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.progress);
            r1.writeInt(this.oldSpeed);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static /* synthetic */ void access$000(PointerSpeedPreference r0) {
        r0.onSpeedChanged();
    }

    public PointerSpeedPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        final Handler r3 = new Handler();
        this.mSpeedObserver = new AnonymousClass1(this, r3);
        this.mIm = (InputManager) getContext().getSystemService("input");
    }

    protected void onClick() {
        super.onClick();
        getContext().getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor("pointer_speed"), true, this.mSpeedObserver);
        this.mRestoredOldState = false;
    }

    protected void onBindDialogView(View r2) {
        super.onBindDialogView(r2);
        SeekBar r3 = (SeekBar) NullSafe.nonNull(getSeekBar(r2));
        this.mSeekBar = r3;
        r3.setMax(14);
        int r4 = InputSettings.getPointerSpeed(getContext());
        this.mOldSpeed = r4;
        this.mSeekBar.setProgress(r4 + 7);
        this.mSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        if (this.mTouchInProgress == true) goto L6;
        this.mIm.tryPointerSpeed(r2 - 7);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r1) {
        this.mTouchInProgress = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r2) {
        this.mTouchInProgress = false;
        this.mIm.tryPointerSpeed(r2.getProgress() - 7);
    }

    private void onSpeedChanged() {
        int r0 = InputSettings.getPointerSpeed(getContext());
        this.mSeekBar.setProgress(r0 + 7);
    }

    protected void onDialogClosed(boolean r3) {
        super.onDialogClosed(r3);
        ContentResolver r0 = getContext().getContentResolver();
        if (r3 == false) goto L5;
        InputSettings.setPointerSpeed(getContext(), this.mSeekBar.getProgress() - 7);
    L6:
        r0.unregisterContentObserver(this.mSpeedObserver);
        return;
    L5:
        restoreOldState();
        goto L6
    }

    private void restoreOldState() {
        if (this.mRestoredOldState == false) goto L5;
        return;
    L5:
        this.mIm.tryPointerSpeed(this.mOldSpeed);
        this.mRestoredOldState = true;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (getDialog() != null) goto L5;
    L9:
        return r0;
    L5:
        if (getDialog().isShowing() == false) goto L9;
        SavedState r1 = new SavedState(r0);
        r1.progress = this.mSeekBar.getProgress();
        r1.oldSpeed = this.mOldSpeed;
        restoreOldState();
        return r1;
    }

    protected void onRestoreInstanceState(Parcelable r3) {
        if (r3 != null) goto L4;
    L8:
        super.onRestoreInstanceState(r3);
        return;
    L4:
        if (r3.getClass().equals(SavedState.class) == false) goto L8;
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        this.mOldSpeed = r4.oldSpeed;
        this.mIm.tryPointerSpeed(r4.progress - 7);
    }
}
