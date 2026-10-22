package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes.dex */
public class SettingCommonSeekBar extends RelativeLayout implements SeekBar.OnSeekBarChangeListener {
    private View mGapView;
    private TextView mLeftTips;
    private int mMax;
    private int mMin;
    private OnProgressChangedListener mOnProgressChangedListener;
    private OnResetClickListener mOnResetClickListener;
    private int mProgress;
    private Button mResetBtn;
    private ListContentItemCustom mResetBtnContainer;
    private TextView mRightTips;
    private ListContentItemCustom mSeekBarContainer;
    private SeekBar mSeekbar;
    private TextView mTipsView;
    private TextView mTitleView;
    private boolean mTrackingTouch;

    public interface OnProgressChangedListener {
        boolean onChange(SettingCommonSeekBar r1, int r2);
    }

    public interface OnResetClickListener {
        void onReset(SettingCommonSeekBar r1);
    }

    @Deprecated
    public interface OnSeekBarChangeListener extends OnResetClickListener, OnProgressChangedListener {
    }

    static /* synthetic */ OnResetClickListener access$000(SettingCommonSeekBar r0) {
        return r0.mOnResetClickListener;
    }

    public SettingCommonSeekBar(Context r2) {
        this(r2, null);
    }

    public SettingCommonSeekBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingCommonSeekBar(Context r8, AttributeSet r9, int r10) {
        super(r8, r9, r10);
        View r0 = LayoutInflater.from(r8).inflate(R.layout.setting_common_seekbar, this, true);
        this.mSeekBarContainer = (ListContentItemCustom) r0.findViewById(R.id.id_seekbar_in_layout);
        this.mTitleView = (TextView) r0.findViewById(R.id.id_seekbar_title);
        this.mTipsView = (TextView) r0.findViewById(R.id.id_seekbar_tips);
        this.mLeftTips = (TextView) r0.findViewById(R.id.id_seekbar_left);
        this.mRightTips = (TextView) r0.findViewById(R.id.id_seekbar_right);
        this.mSeekbar = (SeekBar) r0.findViewById(R.id.id_seekbar);
        this.mGapView = r0.findViewById(R.id.id_gap_view);
        this.mResetBtnContainer = (ListContentItemCustom) r0.findViewById(R.id.id_button_container);
        this.mResetBtn = (Button) findViewById(R.id.id_seekbar_reset);
        this.mSeekbar.setOnSeekBarChangeListener(this);
        TypedArray r11 = r8.obtainStyledAttributes(r9, R.styleable.SettingCommonSeekBar, r10, 0);
        String r12 = r11.getString(5);
        String r1 = r11.getString(0);
        String r3 = r11.getString(3);
        String r4 = r11.getString(4);
        String r5 = r11.getString(2);
        boolean r6 = r11.getBoolean(1, true);
        r11.recycle();
        if (r12 == null) goto L5;
        setTitle(r12);
    L5:
        setTipsText(r4);
        if (r1 == null) goto L8;
        this.mLeftTips.setText(r1);
    L8:
        if (r3 == null) goto L11;
        this.mRightTips.setText(r3);
    L11:
        if (r5 == null) goto L13;
        restBtnText(r8.getString(R.string.tts_seekbar_reset, new Object[]{r5}));
    L14:
        setResetButtonVisible(r6);
        init();
        return;
    L13:
        restBtnText(r8.getString(R.string.tts_seekbar_reset, new Object[]{r12}));
        goto L14
    }

    private void init() {
        this.mResetBtnContainer.setOnClickListener(new AnonymousClass1(this));
    }

    @Deprecated
    public void setOnChangeListener(OnSeekBarChangeListener r1) {
        setOnResetClickListener(r1);
        setOnProgressChangedListener(r1);
    }

    public void setOnResetClickListener(OnResetClickListener r1) {
        this.mOnResetClickListener = r1;
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

    public void restBtnText(String r1) {
        this.mResetBtn.setText(r1);
    }

    public void restBtnText(int r2) {
        restBtnText(this.mContext.getString(r2));
    }

    public void setLeftTips(CharSequence r1) {
        this.mLeftTips.setText(r1);
    }

    public void setRightTips(CharSequence r1) {
        this.mRightTips.setText(r1);
    }

    public void setResetButtonVisible(boolean r5) {
        ListContentItemCustom r0 = this.mResetBtnContainer;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        View r2 = this.mGapView;
        if (r5 == false) goto L9;
        r1 = 8;
    L9:
        r2.setVisibility(r1);
        ListContentItemCustom r4 = this.mSeekBarContainer;
        if (r5 == false) goto L12;
        int r6 = 2;
    L13:
        r4.setBackgroundStyle(r6);
        return;
    L12:
        r6 = 1;
        goto L13
    L5:
        r3 = 8;
        goto L6
    }

    public void setTipsText(CharSequence r2) {
        this.mTipsView.setText(r2);
        TextView r1 = this.mTipsView;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
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
