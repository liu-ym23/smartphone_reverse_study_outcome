package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ForceTouchGifAnimView extends RelativeLayout {
    private final int CIRCLE_X;
    private final int CIRCLE_Y;
    private final int HAND_END_X;
    private final int HAND_END_Y;
    private final int HAND_START_X;
    private final int HAND_START_Y;
    private final Point TOOL1_POINT1;
    private final Point TOOL1_POINT2;
    private final Point TOOL1_POINT3;
    private final Point TOOL2_POINT1;
    private final Point TOOL2_POINT2;
    private final Point TOOL2_POINT3;
    private final Point TOOL3_POINT1;
    private final Point TOOL3_POINT2;
    private final Point TOOL3_POINT3;
    private final Point TOOL4_POINT1;
    private final Point TOOL4_POINT2;
    private final Point TOOL4_POINT3;
    private final Point TOOL5_POINT1;
    private final Point TOOL5_POINT2;
    private final Point TOOL5_POINT3;
    private AnimatorSet mAnimSet;
    private ImageView mCircleView;
    private ImageView mHandView;
    private Handler mHandler;
    private final DecelerateInterpolator mInterpolator;
    private ImageView mToolView1;
    private ImageView mToolView2;
    private ImageView mToolView3;
    private ImageView mToolView4;
    private ImageView mToolView5;
    private final OvershootInterpolator mToolsPopInterpolator;

    private class Point {
        final /* synthetic */ ForceTouchGifAnimView this$0;
        float x;
        float y;

        Point(ForceTouchGifAnimView r1, float r2, float r3) {
            this.this$0 = r1;
            this.x = r2;
            this.y = r3;
        }
    }

    static /* synthetic */ Handler access$000(ForceTouchGifAnimView r0) {
        return r0.mHandler;
    }

    public ForceTouchGifAnimView(Context r2) {
        this(r2, null);
    }

    public ForceTouchGifAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ForceTouchGifAnimView(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.mHandler = new Handler();
        this.mInterpolator = new DecelerateInterpolator(1.5f);
        this.mToolsPopInterpolator = new OvershootInterpolator(1.7f);
        LayoutInflater.from(r5).inflate(R.layout.force_touch_anim_layout, this, true);
        this.HAND_START_X = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_hand_start_x);
        this.HAND_START_Y = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_hand_start_y);
        this.HAND_END_X = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_hand_end_x);
        this.HAND_END_Y = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_hand_end_y);
        this.CIRCLE_X = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_circle_x);
        this.CIRCLE_Y = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_circle_y);
        int r8 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool1_first_x);
        int r9 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool1_first_y);
        int r10 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool1_second_x);
        int r0 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool1_third_x);
        float r11 = r9;
        this.TOOL1_POINT1 = new Point(this, r8, r11);
        this.TOOL1_POINT2 = new Point(this, r10, r11);
        this.TOOL1_POINT3 = new Point(this, r0, r11);
        int r12 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool2_first_x);
        int r13 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool2_first_y);
        int r14 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool2_second_x);
        int r1 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool2_second_y);
        int r2 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool2_third_x);
        int r3 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool2_third_y);
        this.TOOL2_POINT1 = new Point(this, r12, r13);
        this.TOOL2_POINT2 = new Point(this, r14, r1);
        this.TOOL2_POINT3 = new Point(this, r2, r3);
        int r15 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool3_first_x);
        int r16 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool3_first_y);
        int r17 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool3_second_y);
        int r4 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool3_third_y);
        float r18 = r15;
        this.TOOL3_POINT1 = new Point(this, r18, r16);
        this.TOOL3_POINT2 = new Point(this, r18, r17);
        this.TOOL3_POINT3 = new Point(this, r18, r4);
        int r19 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool4_first_x);
        int r20 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool4_first_y);
        int r21 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool4_second_x);
        int r22 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool4_second_y);
        int r23 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool4_third_x);
        int r24 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool4_third_y);
        this.TOOL4_POINT1 = new Point(this, r19, r20);
        this.TOOL4_POINT2 = new Point(this, r21, r22);
        this.TOOL4_POINT3 = new Point(this, r23, r24);
        int r25 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool5_first_x);
        int r26 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool5_first_y);
        int r27 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool5_second_x);
        int r28 = getResources().getDimensionPixelSize(R.dimen.force_touch_anim_tool5_third_x);
        float r29 = r26;
        this.TOOL5_POINT1 = new Point(this, r25, r29);
        this.TOOL5_POINT2 = new Point(this, r27, r29);
        this.TOOL5_POINT3 = new Point(this, r28, r29);
        initView();
        initViewState();
    }

    private void initView() {
        this.mCircleView = (ImageView) findViewById(R.id.circle);
        this.mHandView = (ImageView) findViewById(R.id.hand);
        this.mToolView1 = (ImageView) findViewById(R.id.tool_1);
        this.mToolView2 = (ImageView) findViewById(R.id.tool_2);
        this.mToolView3 = (ImageView) findViewById(R.id.tool_3);
        this.mToolView4 = (ImageView) findViewById(R.id.tool_4);
        this.mToolView5 = (ImageView) findViewById(R.id.tool_5);
    }

    private void initViewState() {
        this.mHandView.setX(this.HAND_START_X);
        this.mHandView.setY(this.HAND_START_Y);
        this.mCircleView.setX(this.CIRCLE_X);
        this.mCircleView.setY(this.CIRCLE_Y);
        this.mCircleView.setScaleX(1.0f);
        this.mCircleView.setScaleY(1.0f);
        this.mCircleView.setAlpha(0.0f);
        this.mToolView1.setX(this.TOOL1_POINT1.x);
        this.mToolView1.setY(this.TOOL1_POINT1.y);
        this.mToolView1.setAlpha(0.0f);
        this.mToolView1.setScaleX(1.0f);
        this.mToolView1.setScaleY(1.0f);
        this.mToolView2.setX(this.TOOL2_POINT1.x);
        this.mToolView2.setY(this.TOOL2_POINT1.y);
        this.mToolView2.setAlpha(0.0f);
        this.mToolView2.setScaleX(1.0f);
        this.mToolView2.setScaleY(1.0f);
        this.mToolView3.setX(this.TOOL3_POINT1.x);
        this.mToolView3.setY(this.TOOL3_POINT1.y);
        this.mToolView3.setAlpha(0.0f);
        this.mToolView3.setScaleX(1.0f);
        this.mToolView3.setScaleY(1.0f);
        this.mToolView4.setX(this.TOOL4_POINT1.x);
        this.mToolView4.setY(this.TOOL4_POINT1.y);
        this.mToolView4.setAlpha(0.0f);
        this.mToolView4.setScaleX(1.0f);
        this.mToolView4.setScaleY(1.0f);
        this.mToolView5.setX(this.TOOL5_POINT1.x);
        this.mToolView5.setY(this.TOOL5_POINT1.y);
        this.mToolView5.setAlpha(0.0f);
        this.mToolView5.setScaleX(1.0f);
        this.mToolView5.setScaleY(1.0f);
    }

    public void startAnim() {
        cancelAnim();
        initViewState();
        ArrayList r0 = new ArrayList();
        r0.add(createHandInAnim());
        r0.add(createCircleFlashAnim());
        r0.add(createToolsPopAnim());
        r0.add(createHandOutAnim());
        r0.add(createToolsDisappearAnim());
        AnimatorSet r1 = new AnimatorSet();
        this.mAnimSet = r1;
        r1.playTogether(r0);
        this.mAnimSet.setStartDelay(300);
        this.mAnimSet.addListener(new AnonymousClass1(this));
        this.mAnimSet.start();
    }

    public void cancelAnim() {
        AnimatorSet r0 = this.mAnimSet;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
        this.mAnimSet.end();
        this.mAnimSet.cancel();
        this.mAnimSet = null;
        return;
    }

    private Animator createHandInAnim() {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mHandView, "X", new float[]{this.HAND_START_X, this.HAND_END_X});
        r1.setDuration(700);
        r1.setInterpolator(this.mInterpolator);
        r0.add(r1);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mHandView, "Y", new float[]{this.HAND_START_Y, this.HAND_END_Y});
        r2.setDuration(700);
        r2.setInterpolator(this.mInterpolator);
        r0.add(r2);
        AnimatorSet r8 = new AnimatorSet();
        r8.playTogether(r0);
        return r8;
    }

    private Animator createHandOutAnim() {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mHandView, "X", new float[]{this.HAND_END_X, this.HAND_START_X});
        r1.setDuration(400);
        r1.setInterpolator(this.mInterpolator);
        r0.add(r1);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mHandView, "Y", new float[]{this.HAND_END_Y, this.HAND_START_Y});
        r2.setDuration(400);
        r2.setInterpolator(this.mInterpolator);
        r0.add(r2);
        AnimatorSet r8 = new AnimatorSet();
        r8.playTogether(r0);
        r8.setStartDelay(TimeUtils.SECONDS_PER_HOUR);
        return r8;
    }

    private Animator createCircleFlashAnim() {
        ArrayList r0 = new ArrayList();
        r0.add(createScaleAnim(this.mCircleView, 3.0f, 1.0f, 300, 0));
        r0.add(createAlphaAnim(this.mCircleView, 0.0f, 1.0f, 300, 0));
        r0.add(createAlphaAnim(this.mCircleView, 1.0f, 0.0f, 300, 300));
        r0.add(createAlphaAnim(this.mCircleView, 0.0f, 1.0f, 400, 600));
        r0.add(createAlphaAnim(this.mCircleView, 1.0f, 0.0f, 300, 1000));
        r0.add(createAlphaAnim(this.mCircleView, 0.0f, 1.0f, 300, 1300));
        r0.add(createAlphaAnim(this.mCircleView, 1.0f, 0.0f, 400, 1600));
        r0.add(createAlphaAnim(this.mCircleView, 0.0f, 1.0f, 300, 2000));
        r0.add(createAlphaAnim(this.mCircleView, 1.0f, 0.0f, 100, 2300));
        r0.add(createScaleAnim(this.mCircleView, 1.0f, 3.0f, 100, 2300));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(1000);
        return r10;
    }

    private Animator createToolsPopAnim() {
        ArrayList r10 = new ArrayList();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.mToolView1, "X", new float[]{this.TOOL1_POINT1.x, this.TOOL1_POINT2.x});
        r0.setDuration(250);
        r0.setInterpolator(this.mToolsPopInterpolator);
        r10.add(r0);
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mToolView1, "X", new float[]{this.TOOL1_POINT2.x, this.TOOL1_POINT3.x});
        r1.setDuration(250);
        r1.setInterpolator(this.mToolsPopInterpolator);
        r1.setStartDelay(250);
        r10.add(r1);
        r10.add(createAlphaAnim(this.mToolView1, 0.0f, 0.5f, 250));
        r10.add(createAlphaAnim(this.mToolView1, 0.5f, 1.0f, 250, 250));
        r10.add(buildToolAnim(this.mToolView2, this.TOOL2_POINT1, this.TOOL2_POINT2, this.TOOL2_POINT3, 250, 0));
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mToolView3, "Y", new float[]{this.TOOL3_POINT1.y, this.TOOL3_POINT2.y});
        r2.setDuration(250);
        r2.setInterpolator(this.mToolsPopInterpolator);
        r10.add(r2);
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.mToolView3, "Y", new float[]{this.TOOL3_POINT2.y, this.TOOL3_POINT3.y});
        r3.setDuration(250);
        r3.setInterpolator(this.mToolsPopInterpolator);
        r3.setStartDelay(250);
        r10.add(r3);
        r10.add(createAlphaAnim(this.mToolView3, 0.0f, 0.5f, 250));
        r10.add(createAlphaAnim(this.mToolView3, 0.5f, 1.0f, 250, 250));
        r10.add(buildToolAnim(this.mToolView4, this.TOOL4_POINT1, this.TOOL4_POINT2, this.TOOL4_POINT3, 250, 0));
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.mToolView5, "X", new float[]{this.TOOL5_POINT1.x, this.TOOL5_POINT2.x});
        r4.setDuration(250);
        r4.setInterpolator(this.mToolsPopInterpolator);
        r10.add(r4);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mToolView5, "X", new float[]{this.TOOL5_POINT2.x, this.TOOL5_POINT3.x});
        r5.setDuration(250);
        r5.setInterpolator(this.mToolsPopInterpolator);
        r5.setStartDelay(250);
        r10.add(r5);
        r10.add(createAlphaAnim(this.mToolView5, 0.0f, 0.5f, 250));
        r10.add(createAlphaAnim(this.mToolView5, 0.5f, 1.0f, 250, 250));
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(r10);
        r6.setStartDelay(3300);
        return r6;
    }

    private Animator createToolsDisappearAnim() {
        ArrayList r0 = new ArrayList();
        DecelerateInterpolator r8 = new DecelerateInterpolator(2.0f);
        r0.add(createAlphaWithInterpolator(this.mToolView1, 1.0f, 0.0f, 300, r8));
        r0.add(createAlphaWithInterpolator(this.mToolView2, 1.0f, 0.0f, 300, r8));
        r0.add(createAlphaWithInterpolator(this.mToolView3, 1.0f, 0.0f, 300, r8));
        r0.add(createAlphaWithInterpolator(this.mToolView4, 1.0f, 0.0f, 300, r8));
        r0.add(createAlphaWithInterpolator(this.mToolView5, 1.0f, 0.0f, 300, r8));
        AnimatorSet r9 = new AnimatorSet();
        r9.playTogether(r0);
        r9.setStartDelay(4600);
        return r9;
    }

    private Animator createAlphaWithInterpolator(View r1, float r2, float r3, long r4, TimeInterpolator r6) {
        Animator r0 = createAlphaAnim(r1, r2, r3, r4);
        r0.setInterpolator(r6);
        return r0;
    }

    private Animator buildToolAnim(View r15, Point r16, Point r17, Point r18, long r19, long r21) {
        ArrayList r10 = new ArrayList();
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r15, "X", new float[]{r16.x, r17.x});
        r4.setDuration(r19);
        r4.setInterpolator(this.mToolsPopInterpolator);
        r10.add(r4);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r15, "Y", new float[]{r16.y, r17.y});
        r5.setDuration(r19);
        r5.setInterpolator(this.mToolsPopInterpolator);
        r10.add(r5);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r15, "X", new float[]{r17.x, r18.x});
        r6.setDuration(r19);
        r6.setInterpolator(this.mToolsPopInterpolator);
        r6.setStartDelay(r19);
        r10.add(r6);
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r15, "Y", new float[]{r17.y, r18.y});
        r0.setDuration(r19);
        r0.setInterpolator(this.mToolsPopInterpolator);
        r0.setStartDelay(r19);
        r10.add(r0);
        r10.add(createAlphaAnim(r15, 0.0f, 0.5f, r19));
        r10.add(createAlphaAnim(r15, 0.5f, 1.0f, r19, r19));
        AnimatorSet r1 = new AnimatorSet();
        r1.playTogether(r10);
        r1.setStartDelay(r21);
        return r1;
    }

    private Animator createScaleAnim(View r7, float r8, float r9, long r10, long r12) {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r7, "scaleX", new float[]{r8, r9});
        r2.setDuration(r10);
        r2.setInterpolator(this.mInterpolator);
        r0.add(r2);
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r7, "scaleY", new float[]{r8, r9});
        r11.setDuration(r10);
        r11.setInterpolator(this.mInterpolator);
        r0.add(r11);
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(r0);
        r6.setStartDelay(r12);
        return r6;
    }

    private Animator createAlphaAnim(View r9, float r10, float r11, long r12) {
        return createAlphaAnim(r9, r10, r11, r12, 0);
    }

    private Animator createAlphaAnim(View r3, float r4, float r5, long r6, long r8) {
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{r4, r5});
        r7.setDuration(r6);
        r7.setStartDelay(r8);
        r7.setInterpolator(this.mInterpolator);
        return r7;
    }
}
