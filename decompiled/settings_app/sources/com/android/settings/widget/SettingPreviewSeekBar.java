package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Iterator;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes.dex */
public class SettingPreviewSeekBar extends RelativeLayout implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private final int FOCUS_COLOR;
    private final int NON_FOCUS_COLOR;
    private AnimationManager mAnimMgr;
    private ForceTouchSensitivityAnimView mAnimView;
    private TextView mCenterTips;
    private OnItemCheckListener mItemCheckListener;
    private ArrayList<SettingItemCheck> mItemCheckViews;
    private TextView mLeftTips;
    private int mMax;
    private OnSeekBarChangeListener mOnChangeListener;
    private MODE mPreviewMode;
    private int mProgress;
    private TextView mRightTips;
    private SeekBar mSeekbar;
    private TextView mTipsView;
    private TextView mTitleView;
    private FrameLayout mToolsContainer;
    private boolean mTrackingTouch;

    private class AnimationListener implements Animation.AnimationListener {
        private int index;
        private boolean isAnimUp;
        final /* synthetic */ SettingPreviewSeekBar this$0;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }

        public AnimationListener(SettingPreviewSeekBar r1, int r2, boolean r3) {
            this.this$0 = r1;
            this.index = r2;
            this.isAnimUp = r3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r2) {
            if (this.isAnimUp == false) goto L5;
            SettingPreviewSeekBar.access$000(this.this$0, this.index).setTextColor(SettingPreviewSeekBar.access$100(this.this$0));
            return;
        L5:
            SettingPreviewSeekBar.access$000(this.this$0, this.index).setTextColor(SettingPreviewSeekBar.access$200(this.this$0));
        }
    }

    private class AnimationManager {
        int indexUp;
        Context mContext;
        Animation[] pushDown;
        Animation[] pushUp;
        final /* synthetic */ SettingPreviewSeekBar this$0;

        private int progress2AnimTrigger(int r1) {
            return r1;
        }

        public AnimationManager(SettingPreviewSeekBar r6, Context r7) {
            this.this$0 = r6;
            this.pushUp = new Animation[3];
            this.pushDown = new Animation[3];
            this.indexUp = -1;
            this.mContext = r7;
            int r1 = 0;
        L3:
            if (r1 >= 3) goto L5;
            this.pushUp[r1] = AnimationUtils.loadAnimation(this.mContext, R.anim.tv_push_up);
            this.pushDown[r1] = AnimationUtils.loadAnimation(this.mContext, R.anim.tv_push_down);
            this.pushUp[r1].setFillAfter(true);
            this.pushUp[r1].setAnimationListener(new AnimationListener(r6, r1, true));
            this.pushDown[r1].setAnimationListener(new AnimationListener(r6, r1, false));
            r1 = r1 + 1;
            goto L3
        }

        public void onProgressChanged(int r4) {
            int r5 = progress2AnimTrigger(r4);
            int r0 = this.indexUp;
            if (r0 == r5) goto L8;
            if (r0 < 0) goto L6;
            SettingPreviewSeekBar.access$000(this.this$0, r0).startAnimation(this.pushDown[this.indexUp]);
            SettingPreviewSeekBar.access$000(this.this$0, this.indexUp).setTextColor(SettingPreviewSeekBar.access$100(this.this$0));
        L6:
            SettingPreviewSeekBar.access$000(this.this$0, r5).startAnimation(this.pushUp[r5]);
            this.indexUp = r5;
            return;
        }
    }

    public static final enum MODE extends Enum<MODE> {
        private static final /* synthetic */ MODE[] $VALUES = null;
        public static final MODE PROGRESS = null;
        public static final MODE SIMPLE_ITEM = null;

        private static /* synthetic */ MODE[] $values() {
            return new MODE[]{PROGRESS, SIMPLE_ITEM};
        }

        public static MODE valueOf(String r1) {
            return (MODE) Enum.valueOf(MODE.class, r1);
        }

        public static MODE[] values() {
            return (MODE[]) $VALUES.clone();
        }

        static {
            PROGRESS = new MODE("PROGRESS", 0, 0);
            SIMPLE_ITEM = new MODE("SIMPLE_ITEM", 1, 1);
            $VALUES = $values();
        }

        private MODE(String r1, int r2, int r3) {
            super(r1, r2);
        }
    }

    public interface OnItemCheckListener {
        boolean onItemCheck(int r1);
    }

    public interface OnSeekBarChangeListener {
        boolean onChange(SettingPreviewSeekBar r1, int r2);
    }

    static /* synthetic */ TextView access$000(SettingPreviewSeekBar r0, int r1) {
        return r0.getTipsView(r1);
    }

    static /* synthetic */ int access$100(SettingPreviewSeekBar r0) {
        return r0.FOCUS_COLOR;
    }

    static /* synthetic */ int access$200(SettingPreviewSeekBar r0) {
        return r0.NON_FOCUS_COLOR;
    }

    public SettingPreviewSeekBar(Context r2) {
        this(r2, null);
    }

    public SettingPreviewSeekBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingPreviewSeekBar(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.mProgress = -1;
        View r0 = LayoutInflater.from(r11).inflate(R.layout.setting_preview_seekbar, this, true);
        this.mTitleView = (TextView) r0.findViewById(R.id.id_seekbar_title);
        this.mTipsView = (TextView) r0.findViewById(R.id.id_seekbar_tips);
        this.mLeftTips = (TextView) r0.findViewById(R.id.id_seekbar_left);
        this.mRightTips = (TextView) r0.findViewById(R.id.id_seekbar_right);
        this.mCenterTips = (TextView) r0.findViewById(R.id.id_seekbar_center);
        this.mSeekbar = (SeekBar) r0.findViewById(R.id.id_seekbar);
        this.mItemCheckViews = new ArrayList();
        SettingItemCheck r1 = (SettingItemCheck) r0.findViewById(R.id.id_force_touch_pressure_light);
        SettingItemCheck r3 = (SettingItemCheck) r0.findViewById(R.id.id_force_touch_pressure_standard);
        SettingItemCheck r4 = (SettingItemCheck) r0.findViewById(R.id.id_force_touch_pressure_heavy);
        this.mItemCheckViews.add(r1);
        this.mItemCheckViews.add(r3);
        this.mItemCheckViews.add(r4);
        this.mAnimView = (ForceTouchSensitivityAnimView) r0.findViewById(R.id.force_touch_anim_view);
        this.mSeekbar.setOnSeekBarChangeListener(this);
        TypedArray r14 = r11.obtainStyledAttributes(r12, R.styleable.SettingPreviewSeekBar, r13, 0);
        String r15 = r14.getString(9);
        String r16 = r14.getString(4);
        String r2 = r14.getString(2);
        String r6 = r14.getString(7);
        String r7 = r14.getString(8);
        int r8 = r14.getInt(6, 0);
        r14.getInt(3, 0);
        if (r8 != 1) goto L5;
        MODE r9 = MODE.SIMPLE_ITEM;
    L6:
        this.mPreviewMode = r9;
        Drawable r5 = r14.getDrawable(1);
        Drawable r10 = r14.getDrawable(0);
        r14.recycle();
        if (r15 == null) goto L9;
        this.mTitleView.setText(r15);
    L9:
        if (r7 == null) goto L11;
        this.mTipsView.setText(r7);
    L11:
        if (r16 == null) goto L13;
        this.mLeftTips.setText(r16);
    L13:
        if (r2 == null) goto L15;
        this.mCenterTips.setText(r2);
    L15:
        if (r6 == null) goto L17;
        this.mRightTips.setText(r6);
    L17:
        if (r5 == null) goto L19;
        this.mSeekbar.setThumb(r5);
    L19:
        if (r10 == null) goto L22;
        this.mSeekbar.setProgressDrawable(r10);
    L22:
        if (this.mPreviewMode != MODE.SIMPLE_ITEM) goto L24;
        findViewById(R.id.id_preview_mode_simple_item).setVisibility(0);
        r1.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
    L25:
        this.NON_FOCUS_COLOR = getResources().getColor(R.color.force_touch_seekbar_tips_tv_color, null);
        this.FOCUS_COLOR = getResources().getColor(R.color.force_touch_seekbar_tips_center_tv_color, null);
        init();
        return;
    L24:
        findViewById(R.id.id_preview_mode_progress).setVisibility(0);
        goto L25
    L5:
        r9 = MODE.PROGRESS;
        goto L6
    }

    private void init() {
        this.mAnimMgr = new AnimationManager(this, this.mContext);
    }

    public void setOnChangeListener(OnSeekBarChangeListener r1) {
        this.mOnChangeListener = r1;
    }

    public void setItenCheckListener(OnItemCheckListener r1) {
        this.mItemCheckListener = r1;
    }

    public boolean callChangeListener(int r2) {
        OnSeekBarChangeListener r0 = this.mOnChangeListener;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.onChange(this, r2) == true) goto L8;
        return false;
    }

    public void setMax(int r2) {
        if (r2 == this.mMax) goto L6;
        this.mMax = r2;
        this.mSeekbar.setMax(r2);
        return;
    }

    public void setProgress(int r2) {
        int r0 = this.mMax;
        if (r2 <= r0) goto L5;
        r2 = r0;
    L5:
        if (r2 >= 0) goto L8;
        r2 = 0;
    L8:
        if (r2 == this.mProgress) goto L10;
        this.mProgress = r2;
        this.mSeekbar.setProgress(r2);
    L10:
        updateViewStateByProgress(r2);
        this.mAnimMgr.onProgressChanged(r2);
    }

    public void setSelect(int r5) {
        if (r5 >= 0) goto L5;
    L6:
        r5 = 1;
    L7:
        Iterator<SettingItemCheck> r1 = this.mItemCheckViews.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        r1.next().setChecked(false);
        goto L9
    L11:
        this.mItemCheckViews.get(r5).setChecked(true);
        return;
    L5:
        if (r5 < this.mItemCheckViews.size()) goto L7;
        goto L6
    }

    private void updateViewStateByProgress(int r2) {
        resetViewState();
        if (r2 != 0) goto L5;
        setTextViewStyleBold(this.mLeftTips);
        return;
    L5:
        if (r2 != 1) goto L7;
        setTextViewStyleBold(this.mCenterTips);
        return;
    L7:
        if (r2 != 2) goto L15;
        setTextViewStyleBold(this.mRightTips);
        return;
    }

    private void resetViewState() {
        this.mLeftTips.setTypeface(Typeface.defaultFromStyle(0));
        this.mLeftTips.setTextColor(this.NON_FOCUS_COLOR);
        this.mRightTips.setTypeface(Typeface.defaultFromStyle(0));
        this.mRightTips.setTextColor(this.NON_FOCUS_COLOR);
        this.mCenterTips.setTypeface(Typeface.defaultFromStyle(0));
        this.mCenterTips.setTextColor(this.NON_FOCUS_COLOR);
    }

    private void setTextViewStyleBold(TextView r2) {
        r2.setTypeface(Typeface.defaultFromStyle(1));
        r2.setTextColor(this.FOCUS_COLOR);
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
        if (r3 == false) goto L5;
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

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if ((r2 instanceof SettingItemCheck) == false) goto L9;
        int r3 = this.mItemCheckViews.indexOf(r2);
        OnItemCheckListener r0 = this.mItemCheckListener;
        if (r0 == null) goto L7;
        r0.onItemCheck(r3);
    L7:
        setSelect(r3);
        return;
    }

    private TextView getTipsView(int r2) {
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L13;
        return this.mLeftTips;
    L13:
        return this.mRightTips;
    L14:
        return this.mCenterTips;
    L11:
        return this.mLeftTips;
    }
}
