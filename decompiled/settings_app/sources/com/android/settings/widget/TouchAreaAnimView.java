package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.security.bytedance.guard.BDSecurityGuardStub;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import com.obric.oui.toast.OToast;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TouchAreaAnimView extends RelativeLayout {
    private static final int MSG_FAILED_TRIGGER_BIGBANG_MOVE_TOO_LARGE = 2;
    private static final int MSG_FAILED_TRIGGER_BIGBANG_TOUCH_AREA_NOT_ENOUGH = 1;
    private static final int MSG_RESET_ANIM = 5;
    private static final int MSG_SHOW_ERROR_INFO = 3;
    private static final int MSG_START_TRIGGER_BIGBANG = 4;
    private static final long PLAY_START_BIGBANG_ANIM_DELAY = 400;
    private static float SCALE_OF_INNER_CIRCLE = 1.0f;
    private static final String TAG = "TouchAreaAnimView";
    private static final float TOUCH_MOVE_BOUND = 200.0f;
    private static float TO_SCALE_OF_ERROR = 1.0f;
    private static float TO_SCALE_OF_PRESSED = 1.1f;
    private static long mPressTimeout;
    private final int RADIUS;
    private int mAreaType;
    private boolean mBigBangTriggering;
    private Context mContext;
    private Handler mHandler;
    private boolean mHasError;
    private ImageView mInnerAnimView;
    private boolean mIsFingerDown;
    private boolean mMoveFingerTooLarge;
    private Animator mPlayingAnim;
    private Animator mRadiationAnim;
    private ImageView mRadiationAnimView;
    private AnimatorSet mScaleOuterCircleAnim;
    private TextView mTargetTestView;
    private float mTextBoomArea;
    private OToast mTipsToast;
    private ImageView mTouchAnimView;
    private int mTouchDownPointX;
    private int mTouchDownPointY;
    private long mTouchDownTime;
    private int mViewScaleSize;

    static {
    }

    static /* synthetic */ void access$000(TouchAreaAnimView r0, int r1) {
        r0.showToastMsgDelay(r1);
    }

    static /* synthetic */ boolean access$102(TouchAreaAnimView r0, boolean r1) {
        r0.mHasError = r1;
        return r1;
    }

    static /* synthetic */ void access$200(TouchAreaAnimView r0, int r1) {
        r0.showErrorToast(r1);
    }

    static /* synthetic */ void access$300(TouchAreaAnimView r0, boolean r1) {
        r0.endTouchTest(r1);
    }

    static /* synthetic */ boolean access$400(TouchAreaAnimView r0) {
        return r0.mIsFingerDown;
    }

    static /* synthetic */ ImageView access$500(TouchAreaAnimView r0) {
        return r0.mRadiationAnimView;
    }

    static /* synthetic */ Animator access$600(TouchAreaAnimView r0) {
        return r0.mRadiationAnim;
    }

    static /* synthetic */ void access$700(TouchAreaAnimView r0) {
        r0.resetAnimViews();
    }

    public TouchAreaAnimView(Context r2) {
        this(r2, null);
    }

    public TouchAreaAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TouchAreaAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.RADIUS = 90;
        this.mHandler = new AnonymousClass1(this);
        this.mContext = r1;
        LayoutInflater.from(r1).inflate(R.layout.touch_area_anim_view_layout, this, true);
        this.mRadiationAnimView = (ImageView) findViewById(R.id.radiation_circle);
        this.mInnerAnimView = (ImageView) findViewById(R.id.inner_circle);
        this.mTouchAnimView = (ImageView) findViewById(R.id.touch_view);
        this.mAreaType = Settings.Global.getInt(this.mContext.getContentResolver(), "boom_text_trigger_area", 2);
        this.mViewScaleSize = getResources().getDimensionPixelSize(R.dimen.touch_anim_view_size);
        OLog.d(TAG, "mPressTimeout " + mPressTimeout);
        setTouchAreaType(this.mAreaType, false);
        playRadiationAnim();
    }

    public void cancelAnims() {
        Animator r0 = this.mRadiationAnim;
        if (r0 == null) goto L5;
        r0.cancel();
        this.mRadiationAnim = null;
    L5:
        Animator r1 = this.mPlayingAnim;
        if (r1 == null) goto L9;
        r1.cancel();
        this.mPlayingAnim = null;
        return;
    }

    private boolean isTouchPointIntoCircle(MotionEvent r5) {
        int r4 = this.mViewScaleSize;
        int r0 = r4 / 2;
        if (Math.sqrt(Math.pow(r5.getX() - r0, 2.0d) + Math.pow(r5.getY() - (r4 / 2), 2.0d)) >= 90.0d) goto L5;
        return true;
    L5:
        return false;
    }

    private void showErrorToast(int r4) {
        ComponentName r0 = Utils.getTopActivity(this.mContext);
        if (r0 == null) goto L5;
        String r1 = r0.getPackageName();
        OLog.d(TAG, "top activity " + r1);
    L7:
        if (this.mContext.getPackageName().equals(r1) == true) goto L9;
        return;
    L9:
        OToast r2 = this.mTipsToast;
        if (r2 == null) goto L12;
        r2.cancel();
    L12:
        this.mTipsToast = ToastUtils.showInView(getContext(), r4);
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r9) {
        Rect r0 = new Rect();
        this.mTargetTestView.getGlobalVisibleRect(r0);
        boolean r1 = r0.contains((int) r9.getRawX(), (int) r9.getRawY());
        if (this.mIsFingerDown == true) goto L6;
        if (r1 == true) goto L6;
        return true;
    L6:
        int r2 = r9.getAction();
        if (r2 == 0) goto L31;
        if (r2 != 1) goto L10;
        OLog.d(TAG, "up");
    L30:
        OLog.d(TAG, BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        endTouchTest(true);
    L32:
        return true;
    L10:
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L30;
    L15:
        if (this.mIsFingerDown == false) goto L32;
        OLog.d(TAG, "move");
        if ((SystemClock.uptimeMillis() - this.mTouchDownTime) > mPressTimeout) goto L20;
        checkTouchArea(r9);
    L20:
        int r3 = (int) r9.getRawX();
        int r10 = (int) r9.getRawY();
        if (this.mBigBangTriggering == false) goto L32;
        if (this.mMoveFingerTooLarge == true) goto L32;
        if (Math.abs(r3 - this.mTouchDownPointX) <= 200.0f) goto L27;
    L28:
        OLog.d(TAG, "move distance too large");
        this.mMoveFingerTooLarge = true;
        this.mHandler.removeMessages(4);
        this.mHandler.sendEmptyMessage(2);
        goto L32
    L27:
        if (Math.abs(r10 - this.mTouchDownPointY) <= 200.0f) goto L32;
    L31:
        OLog.d(TAG, "down");
        this.mTouchDownPointX = (int) r9.getRawX();
        this.mTouchDownPointY = (int) r9.getRawY();
        this.mIsFingerDown = true;
        this.mMoveFingerTooLarge = false;
        this.mTouchDownTime = SystemClock.uptimeMillis();
        this.mHandler.sendEmptyMessageDelayed(1, mPressTimeout);
        checkTouchArea(r9);
        goto L32
    }

    private void endTouchTest(boolean r3) {
        if (this.mIsFingerDown == true) goto L6;
        return;
    L6:
        if (this.mBigBangTriggering == false) goto L10;
        playActionUpAnim();
        if (r3 == false) goto L11;
        showToastMsgDelay(R.string.tips_not_move_finger);
    L11:
        this.mIsFingerDown = false;
        this.mBigBangTriggering = false;
        this.mHandler.removeMessages(1);
        this.mHasError = false;
        return;
    L10:
        showToastMsgDelay(R.string.touch_area_not_enough);
        goto L11
    }

    private void checkTouchArea(MotionEvent r3) {
        if (r3.getSize() > this.mTextBoomArea) goto L5;
        return;
    L5:
        if (this.mBigBangTriggering == true) goto L9;
        this.mBigBangTriggering = true;
        OLog.d(TAG, "BigBang triggering");
        this.mHandler.removeCallbacksAndMessages(null);
        playActionDownAnim();
        this.mHandler.sendEmptyMessageDelayed(4, PLAY_START_BIGBANG_ANIM_DELAY);
        return;
    }

    private void playRadiationAnim() {
        if (this.mRadiationAnim != null) goto L5;
        this.mRadiationAnim = getRadiationAnim();
    L5:
        this.mRadiationAnim.start();
    }

    private Animator getRadiationAnim() {
        Animator r0 = this.mRadiationAnim;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ArrayList r1 = new ArrayList();
        DecelerateInterpolator r2 = new DecelerateInterpolator();
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.mRadiationAnimView, "scaleX", new float[]{0.8f, 1.5f});
        r3.setDuration(700);
        r3.setInterpolator(r2);
        r1.add(r3);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.mRadiationAnimView, "scaleY", new float[]{0.8f, 1.5f});
        r4.setDuration(700);
        r4.setInterpolator(r2);
        r1.add(r4);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mRadiationAnimView, "alpha", new float[]{1.0f, 0.0f});
        r5.setDuration(700);
        r5.setInterpolator(r2);
        r1.add(r5);
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(r1);
        r6.setStartDelay(300);
        ArrayList r7 = new ArrayList();
        LinearInterpolator r8 = new LinearInterpolator();
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mRadiationAnimView, "scaleX", new float[]{1.5f, 0.3f});
        r9.setDuration(300);
        r9.setInterpolator(r8);
        r7.add(r9);
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this.mRadiationAnimView, "scaleY", new float[]{1.5f, 0.3f});
        r10.setDuration(300);
        r10.setInterpolator(r8);
        r7.add(r10);
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(r7);
        ArrayList r12 = new ArrayList();
        DecelerateInterpolator r13 = new DecelerateInterpolator();
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this.mRadiationAnimView, "scaleX", new float[]{0.3f, 0.8f});
        r14.setDuration(600);
        r14.setInterpolator(r13);
        r12.add(r14);
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this.mRadiationAnimView, "scaleY", new float[]{0.3f, 0.8f});
        r15.setDuration(600);
        r15.setInterpolator(r13);
        r12.add(r15);
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.mRadiationAnimView, "alpha", new float[]{0.0f, 1.0f});
        r16.setDuration(600);
        r16.setInterpolator(r13);
        r16.addListener(new AnonymousClass2(this));
        r12.add(r16);
        AnimatorSet r17 = new AnimatorSet();
        r17.playTogether(r12);
        AnimatorSet r18 = new AnimatorSet();
        r18.playSequentially(new Animator[]{r6, r11, r17});
        r18.addListener(new AnonymousClass3(this));
        this.mRadiationAnim = r18;
        return r18;
    }

    private void playActionDownAnim() {
        OLog.d(TAG, "playActionDownAnim");
        cancelCurrentAnim();
        this.mTouchAnimView.setVisibility(0);
        this.mTouchAnimView.setAlpha(0.4f);
        this.mTouchAnimView.setImageResource(R.drawable.range_halo_pressed);
        ArrayList r0 = new ArrayList();
        float r2 = TO_SCALE_OF_PRESSED;
        DecelerateInterpolator r3 = new DecelerateInterpolator();
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.mTouchAnimView, "scaleX", new float[]{0.5f, r2});
        r4.setDuration(300);
        r4.setInterpolator(r3);
        r0.add(r4);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mTouchAnimView, "scaleY", new float[]{0.5f, r2});
        r5.setDuration(300);
        r5.setInterpolator(r3);
        r0.add(r5);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mTouchAnimView, "alpha", new float[]{0.4f, 1.0f});
        r6.setStartDelay(200);
        r6.setDuration(PLAY_START_BIGBANG_ANIM_DELAY);
        r6.setInterpolator(r3);
        r0.add(r6);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleX", new float[]{0.5f, r2});
        r7.setDuration(300);
        r7.setInterpolator(r3);
        r0.add(r7);
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleY", new float[]{0.5f, r2});
        r1.setDuration(300);
        r1.setInterpolator(r3);
        r0.add(r1);
        AnimatorSet r8 = new AnimatorSet();
        r8.playTogether(r0);
        r8.start();
        this.mPlayingAnim = r8;
    }

    public void playActionUpAnim() {
        boolean r0 = cancelCurrentAnim();
        this.mTouchAnimView.setImageResource(R.drawable.range_halo_pressed);
        ArrayList r1 = new ArrayList();
        if (r0 == false) goto L5;
        float r2 = this.mTouchAnimView.getScaleX();
    L6:
        LinearInterpolator r3 = new LinearInterpolator();
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.mTouchAnimView, "scaleX", new float[]{r2, 0.5f});
        r4.setDuration(300);
        r4.setInterpolator(r3);
        r1.add(r4);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mTouchAnimView, "scaleY", new float[]{r2, 0.5f});
        r5.setDuration(300);
        r5.setInterpolator(r3);
        r1.add(r5);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mTouchAnimView, "alpha", new float[]{1.0f, 0.0f});
        r6.setDuration(300);
        r6.setInterpolator(r3);
        r1.add(r6);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleX", new float[]{r2, 0.5f});
        r7.setDuration(300);
        r7.setInterpolator(r3);
        r1.add(r7);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleY", new float[]{r2, 0.5f});
        r8.setDuration(300);
        r8.setInterpolator(r3);
        r1.add(r8);
        AnimatorSet r9 = new AnimatorSet();
        r9.playTogether(r1);
        r9.addListener(new AnonymousClass4(this));
        r9.start();
        this.mPlayingAnim = r9;
        return;
    L5:
        r2 = TO_SCALE_OF_PRESSED;
        goto L6
    }

    @Deprecated
    public void playFailTriggerBigBangAnim() {
        cancelCurrentAnim();
        this.mTouchAnimView.setVisibility(0);
        this.mTouchAnimView.setImageResource(R.drawable.range_halo_wrong);
        this.mTouchAnimView.setScaleX(TO_SCALE_OF_ERROR);
        this.mTouchAnimView.setScaleY(TO_SCALE_OF_ERROR);
        this.mTouchAnimView.setAlpha(0.0f);
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        float r3 = TO_SCALE_OF_ERROR;
        DecelerateInterpolator r4 = new DecelerateInterpolator();
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mTouchAnimView, "alpha", new float[]{0.0f, 1.0f});
        r5.setDuration(200);
        r5.setInterpolator(r4);
        r2.add(r5);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleX", new float[]{0.5f, r3});
        r6.setDuration(300);
        r6.setInterpolator(r4);
        r0.add(r6);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleY", new float[]{0.5f, r3});
        r7.setDuration(300);
        r7.setInterpolator(r4);
        r0.add(r7);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.mInnerAnimView, "alpha", new float[]{1.0f, 0.0f});
        r8.setDuration(200);
        r8.setInterpolator(r4);
        r2.add(r8);
        AnimatorSet r9 = new AnimatorSet();
        AnimatorSet r10 = new AnimatorSet();
        AnimatorSet r11 = new AnimatorSet();
        r10.playTogether(r0);
        r11.playTogether(r2);
        r9.playSequentially(new Animator[]{r10, r11});
        r9.start();
        this.mPlayingAnim = r9;
    }

    @Deprecated
    public void playActionUpAnimWithError() {
        boolean r0 = cancelCurrentAnim();
        this.mTouchAnimView.setImageResource(R.drawable.range_halo_wrong);
        ArrayList r1 = new ArrayList();
        if (r0 == false) goto L5;
        float r2 = this.mTouchAnimView.getScaleX();
    L6:
        LinearInterpolator r3 = new LinearInterpolator();
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.mTouchAnimView, "scaleX", new float[]{r2, 0.5f});
        r4.setDuration(200);
        r4.setInterpolator(r3);
        r1.add(r4);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mTouchAnimView, "scaleY", new float[]{r2, 0.5f});
        r5.setDuration(200);
        r5.setInterpolator(r3);
        r1.add(r5);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mTouchAnimView, "alpha", new float[]{1.0f, 0.0f});
        r6.setDuration(200);
        r6.setInterpolator(r3);
        r1.add(r6);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleX", new float[]{r2, 0.5f});
        r7.setDuration(200);
        r7.setInterpolator(r3);
        r1.add(r7);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleY", new float[]{r2, 0.5f});
        r8.setDuration(200);
        r8.setInterpolator(r3);
        r1.add(r8);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mInnerAnimView, "alpha", new float[]{0.0f, 1.0f});
        r9.setDuration(200);
        r9.setInterpolator(r3);
        r1.add(r9);
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r1);
        r10.addListener(new AnonymousClass5(this));
        r10.start();
        this.mPlayingAnim = r10;
        return;
    L5:
        r2 = TO_SCALE_OF_ERROR;
        goto L6
    }

    private boolean cancelCurrentAnim() {
        Animator r0 = this.mPlayingAnim;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isRunning() == false) goto L10;
        this.mPlayingAnim.cancel();
        return true;
    L10:
        return false;
    }

    private void resetAnimViews() {
        this.mTouchAnimView.setVisibility(8);
        this.mTouchAnimView.setScaleX(1.0f);
        this.mTouchAnimView.setScaleY(1.0f);
        this.mTouchAnimView.setAlpha(1.0f);
        this.mInnerAnimView.setScaleX(0.5f);
        this.mInnerAnimView.setScaleY(0.5f);
        this.mInnerAnimView.setAlpha(1.0f);
    }

    public void setTargetTextView(TextView r1) {
        this.mTargetTestView = r1;
    }

    public void setTouchAreaType(int r2) {
        setTouchAreaType(r2, true);
    }

    public void setTouchAreaType(int r2, boolean r3) {
        this.mAreaType = r2;
        if (r2 != 0) goto L5;
        SCALE_OF_INNER_CIRCLE = 0.5f;
    L18:
        if (r2 >= 0) goto L24;
        if (r3 == false) goto L21;
        playInnerCircleAnim();
        return;
    L21:
        this.mInnerAnimView.setScaleX(SCALE_OF_INNER_CIRCLE);
        this.mInnerAnimView.setScaleY(SCALE_OF_INNER_CIRCLE);
        return;
    L24:
        throw null;
    L5:
        if (r2 != 1) goto L7;
        SCALE_OF_INNER_CIRCLE = 0.6f;
        goto L18
    L7:
        if (r2 != 2) goto L9;
        SCALE_OF_INNER_CIRCLE = 0.7f;
        goto L18
    L9:
        if (r2 != 3) goto L11;
        SCALE_OF_INNER_CIRCLE = 0.8f;
        goto L18
    L11:
        if (r2 != 4) goto L18;
        SCALE_OF_INNER_CIRCLE = 0.9f;
        goto L18
    }

    private void playInnerCircleAnim() {
        AnimatorSet r0 = this.mScaleOuterCircleAnim;
        if (r0 != null) goto L5;
    L7:
        getInnerCircleAnim().start();
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.mScaleOuterCircleAnim.cancel();
        goto L7
    }

    private AnimatorSet getInnerCircleAnim() {
        float r0 = this.mInnerAnimView.getScaleX();
        float r1 = SCALE_OF_INNER_CIRCLE;
        AccelerateDecelerateInterpolator r2 = new AccelerateDecelerateInterpolator();
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleX", new float[]{r0, r1});
        r3.setDuration(300);
        r3.setInterpolator(r2);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.mInnerAnimView, "scaleY", new float[]{r0, r1});
        r4.setDuration(300);
        r4.setInterpolator(r2);
        AnimatorSet r5 = new AnimatorSet();
        this.mScaleOuterCircleAnim = r5;
        r5.playTogether(new Animator[]{r3, r4});
        return this.mScaleOuterCircleAnim;
    }

    private void showToastMsgDelay(int r4) {
        if (this.mHandler.hasMessages(3) == false) goto L5;
        this.mHandler.removeMessages(3);
    L5:
        Message r0 = this.mHandler.obtainMessage();
        r0.what = 3;
        r0.arg1 = r4;
        this.mHandler.sendMessageDelayed(r0, 300);
    }
}
