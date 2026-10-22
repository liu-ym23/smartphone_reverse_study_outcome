package com.android.settings.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FloatingLabelSeekBar extends LinearLayout implements SeekBar.OnSeekBarChangeListener {
    public static final int DEFAULT_LABEL_FLOATING_DURATION = 300;
    public static final int DEFAULT_LABEL_FLOATING_MAX_HEIGHT = 15;
    public static final int DEFAULT_LABEL_TEXT_SIZE_SP = 10;
    private int mFloatingDuration;
    private int mFloatingMaxHeight;
    private int mLabelTextDownColor;
    private float mLabelTextSize;
    private int mLabelTextUpColor;
    private List<ProgressLabel> mLabels;
    private LinearLayout mLabelsContainer;
    private LabelView mLastFloatingUpLabel;
    private onProgressChangeListener mListener;
    private ProgressingLabelFinder mProgressingLabelFinder;
    private SeekBar mRealSeekBar;

    private class LabelView extends TextView {
        private Animation mDownAnim;
        private int mDownYDelta;
        private ProgressLabel mLabel;
        private Animation mUpAnim;
        private int mUpYDelta;
        final /* synthetic */ FloatingLabelSeekBar this$0;

        static /* synthetic */ void access$000(LabelView r0) {
            r0.updateAppearance();
        }

        static /* synthetic */ ProgressLabel access$100(LabelView r0) {
            return r0.mLabel;
        }

        public LabelView(FloatingLabelSeekBar r2, ProgressLabel r3) {
            this.this$0 = r2;
            super(r2.getContext());
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setGravity(80);
            setLabel(r3);
        }

        public void setLabel(ProgressLabel r1) {
            this.mLabel = r1;
            if (r1 == null) goto L5;
            CharSequence r2 = ProgressLabel.access$300(r1);
        L6:
            setText(r2);
            updateAppearance();
            return;
        L5:
            r2 = null;
            goto L6
        }

        public void floatingUp() {
            if (this.mUpYDelta == FloatingLabelSeekBar.access$400(this.this$0)) goto L6;
            this.mUpYDelta = FloatingLabelSeekBar.access$400(this.this$0);
            this.mUpAnim = null;
        L6:
            if (this.mUpAnim != null) goto L8;
            TranslateAnimation r0 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -FloatingLabelSeekBar.access$400(this.this$0));
            this.mUpAnim = r0;
            r0.setFillAfter(true);
        L8:
            this.mUpAnim.setDuration(FloatingLabelSeekBar.access$500(this.this$0));
            clearAnimation();
            startAnimation(this.mUpAnim);
            setSelected(true);
            updateAppearance();
        }

        public void floatingDown() {
            if (this.mDownYDelta == FloatingLabelSeekBar.access$400(this.this$0)) goto L6;
            this.mDownYDelta = FloatingLabelSeekBar.access$400(this.this$0);
            this.mUpAnim = null;
        L6:
            if (this.mDownAnim != null) goto L8;
            TranslateAnimation r0 = new TranslateAnimation(0.0f, 0.0f, -FloatingLabelSeekBar.access$400(this.this$0), 0.0f);
            this.mDownAnim = r0;
            r0.setFillAfter(true);
        L8:
            this.mDownAnim.setDuration(FloatingLabelSeekBar.access$500(this.this$0));
            clearAnimation();
            startAnimation(this.mDownAnim);
            setSelected(false);
            updateAppearance();
        }

        private void updateAppearance() {
            boolean r0 = isSelected();
            setTextSize(2, FloatingLabelSeekBar.access$600(this.this$0));
            if (r0 == true) goto L5;
        L7:
            int r1 = FloatingLabelSeekBar.access$800(this.this$0);
        L8:
            setTextColor(r1);
            getPaint().setFakeBoldText(r0);
            return;
        L5:
            if (isEnabled() == false) goto L7;
            r1 = FloatingLabelSeekBar.access$700(this.this$0);
            goto L8
        }

        @Override // android.widget.TextView, android.view.View
        protected void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + FloatingLabelSeekBar.access$400(this.this$0));
        }

        @Override // android.widget.TextView, android.view.View
        public void setEnabled(boolean r1) {
            super.setEnabled(r1);
            updateAppearance();
        }
    }

    public static class ProgressLabel {
        private int mProgress;
        private CharSequence mText;

        static /* synthetic */ int access$200(ProgressLabel r0) {
            return r0.mProgress;
        }

        static /* synthetic */ CharSequence access$300(ProgressLabel r0) {
            return r0.mText;
        }

        public ProgressLabel(CharSequence r1, int r2) {
            this.mText = r1;
            this.mProgress = r2;
        }
    }

    public interface ProgressingLabelFinder {
        ProgressLabel findLabelByProgress(List<ProgressLabel> r1, int r2);
    }

    public interface onProgressChangeListener {
        void onProgressChanged(FloatingLabelSeekBar r1, int r2, boolean r3);

        void onStartTrackingTouch(FloatingLabelSeekBar r1);

        void onStopTrackingTouch(FloatingLabelSeekBar r1);
    }

    static /* synthetic */ int access$400(FloatingLabelSeekBar r0) {
        return r0.mFloatingMaxHeight;
    }

    static /* synthetic */ int access$500(FloatingLabelSeekBar r0) {
        return r0.mFloatingDuration;
    }

    static /* synthetic */ float access$600(FloatingLabelSeekBar r0) {
        return r0.mLabelTextSize;
    }

    static /* synthetic */ int access$700(FloatingLabelSeekBar r0) {
        return r0.mLabelTextUpColor;
    }

    static /* synthetic */ int access$800(FloatingLabelSeekBar r0) {
        return r0.mLabelTextDownColor;
    }

    public FloatingLabelSeekBar(Context r2) {
        this(r2, null);
    }

    public FloatingLabelSeekBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FloatingLabelSeekBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mFloatingMaxHeight = 15;
        this.mFloatingDuration = 300;
        this.mLabelTextSize = 10.0f;
        this.mLabelTextUpColor = Color.parseColor("#9a000000");
        this.mLabelTextDownColor = Color.parseColor("#66000000");
        setOrientation(1);
        inflate(r1, R.layout.floating_label_seek_bar, this);
        this.mLabelsContainer = (LinearLayout) NullSafe.nonNull((LinearLayout) findViewById(R.id.labels_container));
        SeekBar r4 = (SeekBar) findViewById(R.id.real_seek_bar);
        this.mRealSeekBar = r4;
        r4.setOnSeekBarChangeListener(this);
        setLabelsInternal();
    }

    private void setLabelsInternal() {
        List<ProgressLabel> r0 = this.mLabels;
        if (r0 != null) goto L5;
    L13:
        this.mLabelsContainer.setVisibility(8);
        return;
    L5:
        if (r0.isEmpty() == true) goto L13;
        this.mLabelsContainer.removeAllViews();
        Iterator<ProgressLabel> r1 = this.mLabels.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        ProgressLabel r2 = r1.next();
        this.mLabelsContainer.addView(new LabelView(this, r2));
        goto L9
    L11:
        this.mLabelsContainer.setVisibility(0);
    }

    public void setLabels(ProgressLabel... r1) {
        setLabels(Arrays.asList(r1));
    }

    public void setLabels(List<ProgressLabel> r1) {
        this.mLabels = r1;
        setLabelsInternal();
    }

    public void setMax(int r1) {
        this.mRealSeekBar.setMax(r1);
    }

    public int getMax() {
        return this.mRealSeekBar.getMax();
    }

    public void setThumb(Drawable r1) {
        this.mRealSeekBar.setThumb(r1);
    }

    public void setProgressDrawable(Drawable r1) {
        this.mRealSeekBar.setProgressDrawable(r1);
    }

    public void setProgress(int r1) {
        this.mRealSeekBar.setProgress(r1);
    }

    public int getProgress() {
        return this.mRealSeekBar.getProgress();
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        super.setEnabled(r3);
        this.mRealSeekBar.setEnabled(r3);
        this.mLabelsContainer.setEnabled(r3);
        int r0 = 0;
    L4:
        if (r0 >= this.mLabelsContainer.getChildCount()) goto L9;
        View r1 = this.mLabelsContainer.getChildAt(r0);
        if (r1 == null) goto L8;
        r1.setEnabled(r3);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public void setLabelFloatingMaxHeight(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 15;
    L4:
        this.mFloatingMaxHeight = r1;
    }

    public void setLabelFloatingDuration(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 300;
    L4:
        this.mFloatingDuration = r1;
    }

    public void setLabelTextColor(int r1, int r2) {
        this.mLabelTextUpColor = r1;
        this.mLabelTextDownColor = r2;
        updateAllLabelsAppearance();
    }

    public SeekBar getRealSeekBar() {
        return this.mRealSeekBar;
    }

    public void setLabelTextSize(int r1) {
        this.mLabelTextSize = r1;
        updateAllLabelsAppearance();
    }

    private void updateAllLabelsAppearance() {
        int r0 = 0;
    L4:
        if (r0 >= this.mLabelsContainer.getChildCount()) goto L6;
        LabelView.access$000((LabelView) this.mLabelsContainer.getChildAt(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        super.onLayout(r8, r9, r10, r11, r12);
        int r13 = getMax();
        int r14 = this.mLabelsContainer.getChildCount();
        if (r13 <= 0) goto L22;
        if (r14 <= 0) goto L27;
        int r15 = this.mLabelsContainer.getMeasuredWidth();
        int r16 = this.mRealSeekBar.getThumbOffset();
        int r17 = this.mRealSeekBar.getMeasuredWidth() - (r16 * 2);
        int r1 = 0;
    L7:
        if (r1 >= r14) goto L28;
        LabelView r2 = (LabelView) this.mLabelsContainer.getChildAt(r1);
        if (r2 == null) goto L21;
        ProgressLabel r3 = LabelView.access$100(r2);
        if (r3 == null) goto L21;
        int r4 = r2.getMeasuredWidth();
        int r5 = (int) (((((ProgressLabel.access$200(r3) / r13) * r17) + r16) - (r4 / 2.0f)) + 0.5f);
        if (r5 >= 0) goto L17;
        r5 = 0;
    L17:
        int r6 = r5 + r4;
        if (r6 <= r15) goto L20;
        r5 = r15 - r4;
        r6 = r15;
    L20:
        r2.layout(r5, 0, r6, r2.getMeasuredHeight());
    L21:
        r1 = r1 + 1;
        goto L7
    L28:
        return;
    L27:
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r2, int r3, boolean r4) {
        LabelView r5 = findLabelViewByProgress(r3);
        if (r5 == null) goto L9;
        LabelView r0 = this.mLastFloatingUpLabel;
        if (r0 == r5) goto L12;
        if (r0 == null) goto L8;
        r0.floatingDown();
    L8:
        r5.floatingUp();
        this.mLastFloatingUpLabel = r5;
    L12:
        onProgressChangeListener r6 = this.mListener;
        if (r6 == null) goto L16;
        r6.onProgressChanged(this, r3, r4);
        return;
    L16:
        return;
    L9:
        LabelView r7 = this.mLastFloatingUpLabel;
        if (r7 == null) goto L12;
        r7.floatingDown();
        this.mLastFloatingUpLabel = null;
        goto L12
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r1) {
        onProgressChangeListener r2 = this.mListener;
        if (r2 == null) goto L6;
        r2.onStartTrackingTouch(this);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r1) {
        onProgressChangeListener r2 = this.mListener;
        if (r2 == null) goto L6;
        r2.onStopTrackingTouch(this);
        return;
    }

    private LabelView findLabelViewByProgress(int r6) {
        int r0 = this.mLabelsContainer.getChildCount();
        ProgressingLabelFinder r1 = this.mProgressingLabelFinder;
        int r3 = 0;
        if (r1 == null) goto L14;
        ProgressLabel r7 = r1.findLabelByProgress(this.mLabels, r6);
        if (r7 != null) goto L7;
        return null;
    L7:
        if (r3 >= r0) goto L23;
        LabelView r2 = (LabelView) this.mLabelsContainer.getChildAt(r3);
        if (r2 == null) goto L13;
        if (LabelView.access$100(r2) != r7) goto L13;
        return r2;
    L13:
        r3 = r3 + 1;
    L23:
        return null;
    L14:
        if (r3 >= r0) goto L23;
        LabelView r4 = (LabelView) this.mLabelsContainer.getChildAt(r3);
        if (r4 == null) goto L22;
        if (LabelView.access$100(r4) == null) goto L22;
        if (ProgressLabel.access$200(LabelView.access$100(r4)) != r6) goto L22;
        return r4;
    L22:
        r3 = r3 + 1;
        goto L14
    }

    public void setOnProgressChangeListener(onProgressChangeListener r1) {
        this.mListener = r1;
    }

    public void setProgressingLabelFinder(ProgressingLabelFinder r1) {
        this.mProgressingLabelFinder = r1;
    }
}
