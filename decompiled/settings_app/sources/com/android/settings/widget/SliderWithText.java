package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class SliderWithText extends RelativeLayout implements SeekBar.OnSeekBarChangeListener {
    private TextView mLeftTips;
    private int mMax;
    private int mMin;
    private OnProgressChangedListener mOnProgressChangedListener;
    private int mProgress;
    private TextView mRightTips;
    private SeekBar mSeekbar;
    private TextView mTitleView;
    private boolean mTrackingTouch;

    public interface OnProgressChangedListener {
        boolean onChange(SliderWithText r1, int r2);
    }

    public interface OnResetClickListener {
        void onReset(SliderWithText r1);
    }

    @Deprecated
    public interface OnSeekBarChangeListener extends OnResetClickListener, OnProgressChangedListener {
    }

    public SliderWithText(Context r2) {
        this(r2, null);
    }

    public SliderWithText(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SliderWithText(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        View r0 = LayoutInflater.from(r4).inflate(R.layout.seekbar_with_text, this, true);
        this.mTitleView = (TextView) r0.findViewById(R.id.id_seekbar_title);
        this.mLeftTips = (TextView) r0.findViewById(R.id.id_seekbar_left);
        this.mRightTips = (TextView) r0.findViewById(R.id.id_seekbar_right);
        SeekBar r1 = (SeekBar) r0.findViewById(R.id.id_seekbar);
        this.mSeekbar = r1;
        r1.setOnSeekBarChangeListener(this);
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.SeekbarWithText, r6, 0);
        String r8 = r7.getString(2);
        String r9 = r7.getString(0);
        String r2 = r7.getString(1);
        r7.recycle();
        if (r8 == null) goto L5;
        setTitle(r8);
    L5:
        if (r9 == null) goto L7;
        this.mLeftTips.setText(r9);
    L7:
        if (r2 == null) goto L10;
        this.mRightTips.setText(r2);
        return;
    }

    public void setOnProgressChangedListener(OnProgressChangedListener r1) {
        this.mOnProgressChangedListener = r1;
    }

    public boolean callChangeListener(int r2) {
        OnProgressChangedListener r0 = this.mOnProgressChangedListener;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.onChange(this, r2) == true) goto L8;
        return false;
    }

    public void setTitle(CharSequence r1) {
        this.mTitleView.setText(r1);
    }

    public void setLeftTips(CharSequence r1) {
        this.mLeftTips.setText(r1);
    }

    public void setRightTips(CharSequence r1) {
        this.mRightTips.setText(r1);
    }

    public void setMax(int r2) {
        if (r2 == this.mMax) goto L6;
        this.mMax = r2;
        this.mSeekbar.setMax(r2);
        return;
    }

    public void setMin(int r2) {
        if (r2 == this.mMin) goto L6;
        this.mMin = r2;
        this.mSeekbar.setMin(r2);
        return;
    }

    public void setProgress(int r2) {
        int r0 = this.mMax;
        if (r2 <= r0) goto L5;
        r2 = r0;
    L5:
        int r1 = this.mMin;
        if (r2 >= r1) goto L9;
        r2 = r1;
    L9:
        if (r2 == this.mProgress) goto L12;
        this.mProgress = r2;
        this.mSeekbar.setProgress(r2);
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
        if (callChangeListener(r0) == false) goto L7;
        setProgress(r0);
        return;
    L7:
        r3.setProgress(this.mProgress);
    }

    public void setProgressDrawable(Drawable r1) {
        this.mSeekbar.setProgressDrawable(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.mLeftTips.setEnabled(r2);
        this.mRightTips.setEnabled(r2);
        this.mSeekbar.setEnabled(r2);
        SeekBar r1 = this.mSeekbar;
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r1.setAlpha(r3);
        return;
    L5:
        r3 = 0.4f;
        goto L6
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
    public void onStopTrackingTouch(SeekBar r2) {
        this.mTrackingTouch = false;
        syncProgress(r2);
    }

    public View getLeftTips() {
        return this.mLeftTips;
    }

    public SeekBar getSeekBar() {
        return this.mSeekbar;
    }
}
