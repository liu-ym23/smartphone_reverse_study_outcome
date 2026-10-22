package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.settings.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TrackBallGifAnimView extends RelativeLayout {
    private static final DecelerateInterpolator mInterpolator = null;
    private final long ANIMATION_KEEP_TIME;
    private final long ANIMATION_START_DELAY;
    private final float HAND_END_X;
    private final float HAND_END_Y;
    private final float HAND_START_X;
    private final float HAND_START_Y;
    private final float PAGE_EDIT_END_X;
    private final float PAGE_EDIT_START_X;
    private final float TRACKBALL_X;
    private final float TRACKBALL_Y;
    private AnimatorSet mAnimSet;
    private ImageView mHandView;
    private ImageView mHomePage;
    private ImageView mMsgEditPage;
    private ImageView mMsgListPage;
    private ImageView mTrackballHighLight;
    private ImageView mTrackballView;

    static /* synthetic */ long access$000(TrackBallGifAnimView r2) {
        return r2.ANIMATION_KEEP_TIME;
    }

    static {
        mInterpolator = new DecelerateInterpolator(1.5f);
    }

    public TrackBallGifAnimView(Context r2) {
        this(r2, null);
    }

    public TrackBallGifAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TrackBallGifAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(R.layout.trackball_gif_anim_layout, this, true);
        this.mTrackballView = (ImageView) findViewById(R.id.trackball);
        this.mTrackballHighLight = (ImageView) findViewById(R.id.trackball_light);
        this.mMsgEditPage = (ImageView) findViewById(R.id.trackball_msg_edit);
        this.mMsgListPage = (ImageView) findViewById(R.id.trackball_msg_list);
        this.mHandView = (ImageView) findViewById(R.id.trackball_hand);
        this.mHomePage = (ImageView) findViewById(R.id.trackball_page_home);
        this.HAND_START_X = getResources().getDimensionPixelSize(R.dimen.trackball_anim_hand_start_x);
        this.HAND_START_Y = getResources().getDimensionPixelSize(R.dimen.trackball_anim_hand_start_y);
        this.HAND_END_X = getResources().getDimensionPixelSize(R.dimen.trackball_anim_hand_end_x);
        this.HAND_END_Y = getResources().getDimensionPixelSize(R.dimen.trackball_anim_hand_end_y);
        this.PAGE_EDIT_START_X = 0.0f;
        this.PAGE_EDIT_END_X = getResources().getDimensionPixelSize(R.dimen.trackball_anim_page_width);
        this.TRACKBALL_X = getResources().getDimensionPixelSize(R.dimen.trackball_anim_trackball_x);
        this.TRACKBALL_Y = getResources().getDimensionPixelSize(R.dimen.trackball_anim_trackball_y);
        this.ANIMATION_START_DELAY = 1000;
        this.ANIMATION_KEEP_TIME = 1300;
        init();
    }

    private void init() {
        this.mTrackballView.setAlpha(0.4f);
        this.mTrackballView.setX(this.TRACKBALL_X);
        this.mTrackballView.setY(this.TRACKBALL_Y);
        this.mTrackballHighLight.setAlpha(0.0f);
        this.mTrackballHighLight.setScaleX(0.9f);
        this.mTrackballHighLight.setScaleY(0.9f);
        this.mTrackballHighLight.setX(this.TRACKBALL_X);
        this.mTrackballHighLight.setY(this.TRACKBALL_Y);
        this.mHandView.setX(this.HAND_START_X);
        this.mHandView.setY(this.HAND_START_Y);
        this.mMsgListPage.setX(-this.PAGE_EDIT_END_X);
        this.mMsgListPage.setY(0.0f);
        this.mMsgListPage.setScaleX(1.0f);
        this.mMsgListPage.setScaleY(1.0f);
        this.mMsgEditPage.setAlpha(1.0f);
        this.mMsgEditPage.setX(0.0f);
        this.mMsgEditPage.setY(0.0f);
        this.mHomePage.setScaleX(1.3f);
        this.mHomePage.setScaleY(1.3f);
        this.mHomePage.setAlpha(0.0f);
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

    public void startAnim() {
        cancelAnim();
        init();
        ArrayList r0 = new ArrayList();
        r0.add(createHandInAnim());
        r0.add(createTrackballAnim());
        r0.add(createTrackballLightAnim());
        r0.add(createMsgEditExitAnim());
        r0.add(createHandOutAnim());
        r0.add(createHandInAnim2());
        r0.add(createTrackballScaleAnim());
        r0.add(createHandOutAnim2());
        r0.add(createBackToHomeAnim());
        AnimatorSet r1 = new AnimatorSet();
        this.mAnimSet = r1;
        r1.playTogether(r0);
        this.mAnimSet.setStartDelay(this.ANIMATION_START_DELAY);
        this.mAnimSet.addListener(new AnonymousClass1(this));
        this.mAnimSet.start();
    }

    private Animator createHandInAnim() {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mHandView, "X", new float[]{this.HAND_START_X, this.HAND_END_X});
        r1.setDuration(300);
        DecelerateInterpolator r7 = mInterpolator;
        r1.setInterpolator(r7);
        r0.add(r1);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mHandView, "Y", new float[]{this.HAND_START_Y, this.HAND_END_Y});
        r9.setDuration(300);
        r9.setInterpolator(r7);
        r0.add(r9);
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        return r10;
    }

    private Animator createHandInAnim2() {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mHandView, "X", new float[]{this.HAND_START_X, this.HAND_END_X});
        r1.setDuration(400);
        DecelerateInterpolator r7 = mInterpolator;
        r1.setInterpolator(r7);
        r0.add(r1);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mHandView, "Y", new float[]{this.HAND_START_Y, this.HAND_END_Y});
        r9.setDuration(400);
        r9.setInterpolator(r7);
        r0.add(r9);
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(4600);
        return r10;
    }

    private Animator createHandOutAnim() {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mHandView, "X", new float[]{this.HAND_END_X, this.HAND_START_X});
        r1.setDuration(400);
        DecelerateInterpolator r7 = mInterpolator;
        r1.setInterpolator(r7);
        r0.add(r1);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mHandView, "Y", new float[]{this.HAND_END_Y, this.HAND_START_Y});
        r9.setDuration(400);
        r9.setInterpolator(r7);
        r0.add(r9);
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(2600);
        return r10;
    }

    private Animator createHandOutAnim2() {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mHandView, "X", new float[]{this.HAND_END_X, this.HAND_START_X});
        r1.setDuration(400);
        DecelerateInterpolator r7 = mInterpolator;
        r1.setInterpolator(r7);
        r0.add(r1);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mHandView, "Y", new float[]{this.HAND_END_Y, this.HAND_START_Y});
        r9.setDuration(400);
        r9.setInterpolator(r7);
        r0.add(r9);
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(6600);
        return r10;
    }

    private Animator createTrackballAnim() {
        ArrayList r0 = new ArrayList();
        r0.add(createAlphaAnim(this.mTrackballView, 0.4f, 1.0f, 300, 0));
        r0.add(createAlphaAnim(this.mTrackballView, 1.0f, 0.4f, 400, 1000));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(1300);
        return r10;
    }

    private Animator createTrackballLightAnim() {
        ArrayList r0 = new ArrayList();
        r0.add(createAlphaAnim(this.mTrackballHighLight, 0.0f, 1.0f, 400, 0));
        r0.add(createAlphaAnim(this.mTrackballHighLight, 1.0f, 0.0f, 300, 400));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(1600);
        return r10;
    }

    private Animator createMsgEditExitAnim() {
        ArrayList r0 = new ArrayList();
        r0.add(createExitRightAnim(this.mMsgEditPage, this.PAGE_EDIT_START_X, this.PAGE_EDIT_END_X, 400, 0));
        r0.add(createEnterLeftAnim(this.mMsgListPage, -this.PAGE_EDIT_END_X, this.PAGE_EDIT_START_X, 400, 0));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(2600);
        return r10;
    }

    private Animator createTrackballScaleAnim() {
        ArrayList r0 = new ArrayList();
        r0.add(createAlphaAnim(this.mTrackballView, 0.4f, 1.0f, 300, 0));
        r0.add(createAlphaAnim(this.mTrackballView, 1.0f, 0.4f, 1000, 300));
        r0.add(createScaleAnim(this.mTrackballView, 1.0f, 1.4f, 400, 600));
        r0.add(createScaleAnim(this.mTrackballView, 1.4f, 1.0f, 300, 1000));
        r0.add(createAlphaAnim(this.mHomePage, 0.0f, 1.0f, 1, 1599));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(5000);
        return r10;
    }

    private Animator createBackToHomeAnim() {
        ArrayList r0 = new ArrayList();
        r0.add(createScaleAnim(this.mMsgListPage, 1.0f, 0.0f, 400, 0));
        r0.add(createScaleAnim(this.mHomePage, 1.3f, 1.0f, 400, 0));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(6600);
        return r10;
    }

    private Animator createScaleAnim(View r6, float r7, float r8, long r9, long r11) {
        ArrayList r5 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r6, "scaleX", new float[]{r7, r8});
        r1.setDuration(r9);
        DecelerateInterpolator r4 = mInterpolator;
        r1.setInterpolator(r4);
        r5.add(r1);
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r6, "scaleY", new float[]{r7, r8});
        r10.setDuration(r9);
        r10.setInterpolator(r4);
        r5.add(r10);
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(r5);
        r12.setStartDelay(r11);
        return r12;
    }

    private Animator createAlphaAnim(View r2, float r3, float r4, long r5, long r7) {
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{r3, r4});
        r1.setDuration(r5);
        r1.setStartDelay(r7);
        r1.setInterpolator(mInterpolator);
        return r1;
    }

    private Animator createExitRightAnim(View r2, float r3, float r4, long r5, long r7) {
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r2, "X", new float[]{r3, r4});
        r1.setDuration(r5);
        r1.setStartDelay(r7);
        r1.setInterpolator(mInterpolator);
        return r1;
    }

    private Animator createEnterLeftAnim(View r2, float r3, float r4, long r5, long r7) {
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r2, "X", new float[]{r3, r4});
        r1.setDuration(r5);
        r1.setStartDelay(r7);
        r1.setInterpolator(mInterpolator);
        return r1;
    }
}
