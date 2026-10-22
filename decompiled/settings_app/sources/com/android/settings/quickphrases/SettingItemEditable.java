package com.android.settings.quickphrases;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class SettingItemEditable extends FrameLayout {
    private static final int DURATION_ANIM_DELETE_GONE = 100;
    private static final int DURATION_ANIM_MOVE_UP = 300;
    private static final int DURATION_APPEAR = 200;
    private static final int DURATION_APPEAR_DELAY = 100;
    private static final int DURATION_DISAPPEAR = 200;
    private static final int DURATION_MOVE = 300;
    private ImageView mArrow;
    private int mDelViewWidth;
    private int mLeftPosition;
    private ImageView mLeftView;
    private TextView mText;

    static /* synthetic */ ImageView access$000(SettingItemEditable r0) {
        return r0.mArrow;
    }

    public SettingItemEditable(Context r3) {
        this(r3, null, -1);
    }

    public SettingItemEditable(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SettingItemEditable(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(R.layout.setting_item_editable_layout, this, true);
        this.mLeftView = (ImageView) findViewById(R.id.cb_del);
        this.mText = (TextView) findViewById(R.id.textview);
        this.mArrow = (ImageView) findViewById(R.id.item_arrow);
        this.mDelViewWidth = 100;
        this.mLeftPosition = (int) r2.getResources().getDimension(R.dimen.settings_item_title_left_margin);
    }

    private int getViewWidth(View r2) {
        r2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r2.getMeasuredWidth();
    }

    public Animator beginEdit() {
        AnimatorSet r0 = new AnimatorSet();
        Animator r1 = makeVisibleAnimator(this.mLeftView);
        Animator r2 = makeExpandAnimator(this.mLeftView);
        r0.playTogether(new Animator[]{makeMoveAnimator(this.mText, true), r1, r2});
        return r0;
    }

    public Animator endEdit() {
        AnimatorSet r0 = new AnimatorSet();
        Animator r1 = makeGoneAnimator(this.mLeftView);
        Animator r2 = makeShrinkAnimator(this.mLeftView);
        r0.playTogether(new Animator[]{makeMoveAnimator(this.mText, false), r1, r2});
        return r0;
    }

    private Animator makeGoneAnimator(final View r4) {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r4, View.ALPHA, new float[]{1.0f, 0.0f});
        r0.setInterpolator(new DecelerateInterpolator(1.5f));
        r0.setDuration(200);
        r0.addListener(new AnonymousClass1(this, r4));
        return r0;
    }

    private Animator makeVisibleAnimator(final View r4) {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r4, View.ALPHA, new float[]{0.0f, 1.0f});
        r0.setStartDelay(100);
        r0.setDuration(200);
        r0.setInterpolator(new DecelerateInterpolator(1.5f));
        r0.addListener(new AnonymousClass2(this, r4));
        return r0;
    }

    private Animator makeExpandAnimator(View r4) {
        AnimatorSet r3 = new AnimatorSet();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r4, View.SCALE_X, new float[]{0.0f, 1.0f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, View.SCALE_Y, new float[]{0.0f, 1.0f});
        r3.setInterpolator(new DecelerateInterpolator(1.5f));
        r3.play(r0).with(r5);
        r3.setDuration(200);
        r3.setStartDelay(100);
        return r3;
    }

    private Animator makeShrinkAnimator(View r4) {
        AnimatorSet r3 = new AnimatorSet();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r4, View.SCALE_X, new float[]{1.0f, 0.0f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, View.SCALE_Y, new float[]{1.0f, 0.0f});
        r3.setInterpolator(new DecelerateInterpolator(1.5f));
        r3.setDuration(200);
        r3.play(r0).with(r5);
        return r3;
    }

    private Animator makeMoveAnimator(final View r4, boolean r5) {
        int r0 = this.mLeftPosition;
        if (r5 == true) goto L6;
        r0 = r0 + this.mDelViewWidth;
    L6:
        if (r5 == false) goto L8;
        int r6 = this.mLeftPosition + this.mDelViewWidth;
    L9:
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r0, r6});
        final ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        r7.addUpdateListener(new AnonymousClass3(this, r1, r4));
        r7.setInterpolator(new DecelerateInterpolator(1.5f));
        r7.setTarget(r4);
        r7.setDuration(300);
        return r7;
    L8:
        r6 = this.mLeftPosition;
        goto L9
    }

    public void switchMode(boolean r4) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.mText.getLayoutParams();
        if (r4 == false) goto L5;
        r0.leftMargin = this.mLeftPosition + this.mDelViewWidth;
        this.mLeftView.setAlpha(1.0f);
        this.mLeftView.setEnabled(true);
        this.mArrow.setVisibility(0);
    L6:
        this.mText.setLayoutParams(r0);
        return;
    L5:
        r0.leftMargin = this.mLeftPosition;
        this.mLeftView.setAlpha(0.0f);
        this.mLeftView.setEnabled(false);
        this.mArrow.setVisibility(8);
        goto L6
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        this.mLeftView.setOnClickListener(r1);
    }

    public TextView getTextView() {
        return this.mText;
    }

    public ImageView getLeftImage() {
        return this.mLeftView;
    }
}
