package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bytedanceos.api.VibratorSmt;
import bytedanceos.api.ViewSmt;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ForceTouchSensitivityAnimView extends RelativeLayout {
    private static final int MSG_FAILED_FORCE_TOUCH_FINGER_MOVE_SO_FAR = 2;
    private static final int MSG_FAILED_FORCE_TOUCH_PRESSURE_NOT_ENOUGH = 1;
    private static final int MSG_RESET_ANIM = 5;
    private static final int MSG_SHOW_ERROR_INFO = 3;
    private static final int MSG_START_FORCE_TOUCH = 4;
    private static final long PLAY_FORCE_TOUCH_ANIM_DELAY = 400;
    private static float SCALE_OF_INNER_CIRCLE = 0.7f;
    private static final String TAG = "ltan/ForceTouchSensitivityAnimView";
    private static final float TOUCH_MOVE_BOUNDARY = 500.0f;
    private static long sPressTimeout;
    private SectorManager mAnimController;
    private Context mContext;
    private boolean mForceTouchSucceed;
    private Handler mHandler;
    private boolean mHasError;
    private ImageView mInnerAnimView;
    private boolean mIsFingerDown;
    private boolean mMoveFingerSoFar;
    private Animator mPlayingAnim;
    private Animator mRadiationAnim;
    private ImageView mRadiationAnimView;
    private AnimatorSet mScaleOuterCircleAnim;
    private ImageView mTouchAnimView;
    private int mTouchDownPointX;
    private int mTouchDownPointY;
    private long mTouchDownTime;
    private View mTouchTargetView;

    private class Point {
        final /* synthetic */ ForceTouchSensitivityAnimView this$0;
        float x;
        float y;

        Point(ForceTouchSensitivityAnimView r1, float r2, float r3) {
            this.this$0 = r1;
            this.x = r2;
            this.y = r3;
        }

        Point calculateCoordinate(int r2) {
            float r3 = r2;
            this.x -= r3;
            this.y -= r3;
            return this;
        }

        public String toString() {
            return "[ x:" + this.x + ", y:" + this.y + " ]";
        }
    }

    private class SectorManager {
        private float centerX;
        private float centerY;
        private FrameLayout mAnimFrameContainer;
        private Context mContext;
        private int mEndSectorRadius;
        private int mIconRadius;
        private List<Integer> mIconResourceIds;
        private List<ImageView> mImageVies;
        private int mStartSectorRadius;
        private AnimatorSet mToolsAnimatorSet;
        final /* synthetic */ ForceTouchSensitivityAnimView this$0;

        static /* synthetic */ void access$700(SectorManager r0) {
            r0.initSectorView();
        }

        public SectorManager(ForceTouchSensitivityAnimView r1, Context r2, List<Integer> r3) {
            this.this$0 = r1;
            this.mContext = r2;
            this.mIconResourceIds = r3;
            this.mImageVies = new ArrayList();
        }

        public void setRadius(int r1, int r2, int r3) {
            this.mIconRadius = r1;
            this.mStartSectorRadius = r2;
            this.mEndSectorRadius = r3;
        }

        public void startBigMenu(float r3, float r4) {
            this.centerX = r3;
            this.centerY = r4;
            OLog.d(ForceTouchSensitivityAnimView.TAG, "startBigMenu: centerX:" + r3 + ", centerY:" + r4);
            if (this.mIconResourceIds.isEmpty() == false) goto L5;
        L9:
            OLog.w(ForceTouchSensitivityAnimView.TAG, "startBigMenu: you do not have any icons to show");
            return;
        L5:
            if (this.mImageVies.isEmpty() == true) goto L9;
            startBigMenuAnimator();
            vibrate();
        }

        private void initSectorView() {
            if (this.mAnimFrameContainer != null) goto L5;
            this.mAnimFrameContainer = new FrameLayout(this.mContext);
            RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-1, -1);
            this.mAnimFrameContainer.setLayoutParams(r0);
            this.this$0.addView(this.mAnimFrameContainer);
        L5:
            Iterator<Integer> r1 = this.mIconResourceIds.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            Integer r2 = r1.next();
            ImageView r3 = new ImageView(this.mContext);
            r3.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            r3.setImageResource(r2.intValue());
            r3.setAlpha(0.0f);
            this.mAnimFrameContainer.addView(r3);
            this.mImageVies.add(r3);
            goto L7
        }

        private void startBigMenuAnimator() {
            AnimatorSet r0 = this.mToolsAnimatorSet;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            OvershootInterpolator r1 = new OvershootInterpolator(1.7f);
            this.mToolsAnimatorSet = new AnimatorSet();
            int r2 = 0;
        L7:
            if (r2 >= this.mImageVies.size()) goto L9;
            Point r3 = getTranslation(this.mStartSectorRadius, r2);
            Point r4 = getTranslation(this.mEndSectorRadius, r2);
            OLog.d(ForceTouchSensitivityAnimView.TAG, "item " + r2 + " tartBigMenuAnimator: startPoint:" + r3 + ", endPoint:" + r4);
            buildAnimForItemView(this.mToolsAnimatorSet, this.mImageVies.get(r2), r3, r4);
            r2 = r2 + 1;
            goto L7
        L9:
            this.mToolsAnimatorSet.setInterpolator(r1);
            this.mToolsAnimatorSet.start();
        }

        private AnimatorSet buildAnimForItemView(AnimatorSet r6, View r7, Point r8, Point r9) {
            if (r6 != null) goto L4;
            r6 = new AnimatorSet();
        L4:
            ArrayList r5 = new ArrayList();
            r7.setX(r8.x);
            r7.setY(r8.y);
            ObjectAnimator r1 = ObjectAnimator.ofFloat(r7, "translationX", new float[]{r8.x, r9.x});
            ObjectAnimator r10 = ObjectAnimator.ofFloat(r7, "translationY", new float[]{r8.y, r9.y});
            ObjectAnimator r11 = ObjectAnimator.ofFloat(r7, "alpha", new float[]{0.0f, 1.0f});
            ObjectAnimator r12 = ObjectAnimator.ofFloat(r7, "alpha", new float[]{1.0f, 0.0f});
            r1.setDuration(100);
            r10.setDuration(100);
            r11.setDuration(100);
            r12.setDuration(300);
            r12.setStartDelay(2600);
            r5.add(r1);
            r5.add(r10);
            r5.add(r11);
            r5.add(r12);
            r6.playTogether(r5);
            return r6;
        }

        public void onDestroy() {
            AnimatorSet r0 = this.mToolsAnimatorSet;
            if (r0 == null) goto L5;
            r0.cancel();
            this.mToolsAnimatorSet = null;
        L5:
            FrameLayout r1 = this.mAnimFrameContainer;
            if (r1 == null) goto L8;
            r1.removeAllViews();
            this.this$0.removeView(this.mAnimFrameContainer);
            this.mAnimFrameContainer = null;
        L8:
            this.mImageVies.clear();
        }

        private void vibrate() {
            VibratorSmt.vibrateEffect((Vibrator) this.mContext.getSystemService("vibrator"), 2);
        }

        Point getTranslation(int r8, int r9) {
            Point r0 = new Point(this.this$0, this.centerX, this.centerY);
            double r3 = Math.toRadians(180.0f / (this.mIconResourceIds.size() - 1));
            if (r9 == 0) goto L16;
            if (r9 != 1) goto L6;
            double r10 = r8;
            r0.x = (float) (((double) r0.x) - (Math.cos(r3) * r10));
            r0.y = (float) (((double) r0.y) - (r10 * Math.sin(r3)));
        L17:
            r0.calculateCoordinate(this.mIconRadius);
            return r0;
        L6:
            if (r9 != 2) goto L8;
            r0.y -= r8;
            goto L17
        L8:
            if (r9 != 3) goto L10;
            double r11 = r8;
            r0.x = (float) (((double) r0.x) + (Math.cos(r3) * r11));
            r0.y = (float) (((double) r0.y) - (r11 * Math.sin(r3)));
            goto L17
        L10:
            if (r9 != 4) goto L17;
            r0.x += r8;
            goto L17
        L16:
            r0.x -= r8;
            goto L17
        }
    }

    static {
    }

    public void onForceTouchStart(MotionEvent r1) {
    }

    static /* synthetic */ void access$000(ForceTouchSensitivityAnimView r0, int r1) {
        r0.showToastMsgDelay(r1);
    }

    static /* synthetic */ boolean access$102(ForceTouchSensitivityAnimView r0, boolean r1) {
        r0.mHasError = r1;
        return r1;
    }

    static /* synthetic */ Context access$200(ForceTouchSensitivityAnimView r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$300(ForceTouchSensitivityAnimView r0, boolean r1) {
        r0.forceTouchTestEnd(r1);
    }

    static /* synthetic */ boolean access$400(ForceTouchSensitivityAnimView r0) {
        return r0.mIsFingerDown;
    }

    static /* synthetic */ ImageView access$500(ForceTouchSensitivityAnimView r0) {
        return r0.mRadiationAnimView;
    }

    static /* synthetic */ Animator access$600(ForceTouchSensitivityAnimView r0) {
        return r0.mRadiationAnim;
    }

    public ForceTouchSensitivityAnimView(Context r2) {
        this(r2, null);
    }

    public ForceTouchSensitivityAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ForceTouchSensitivityAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mHandler = new AnonymousClass1(this);
        this.mContext = r1;
        LayoutInflater.from(r1).inflate(R.layout.force_touch_area_anim_view_layout, this, true);
        this.mRadiationAnimView = (ImageView) findViewById(R.id.radiation_circle);
        this.mInnerAnimView = (ImageView) findViewById(R.id.inner_circle);
        this.mTouchAnimView = (ImageView) findViewById(R.id.touch_view);
        this.mTouchTargetView = this.mInnerAnimView;
        sPressTimeout = 5000;
        setTouchAreaType(false);
        playRadiationAnim();
        initAnimController();
    }

    private void initAnimController() {
        List r0 = Arrays.asList(new Integer[]{Integer.valueOf(R.drawable.force_touch_tool_1_large), Integer.valueOf(R.drawable.force_touch_tool_2_large), Integer.valueOf(R.drawable.force_touch_tool_3_large), Integer.valueOf(R.drawable.force_touch_tool_4_large), Integer.valueOf(R.drawable.force_touch_tool_5_large)});
        int r1 = getResources().getDimensionPixelSize(R.dimen.force_touch_preview_seekbar_anim_icon_radius);
        int r3 = getResources().getDimensionPixelSize(R.dimen.force_touch_preview_seekbar_anim_end_radius);
        if (this.mAnimController != null) goto L5;
        this.mAnimController = new SectorManager(this, this.mContext, r0);
    L5:
        this.mAnimController.setRadius(r1, 0, r3);
    }

    public void setTargetTouchView(View r1) {
        this.mTouchTargetView = r1;
    }

    private boolean isIllegalTouch(View r2, MotionEvent r3) {
        Rect r0 = new Rect();
        r2.getGlobalVisibleRect(r0);
        boolean r4 = r0.contains((int) r3.getRawX(), (int) r3.getRawY());
        if (this.mIsFingerDown == true) goto L6;
        if (r4 == true) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r9) {
        if (isIllegalTouch(this.mTouchTargetView, r9) == false) goto L5;
        return true;
    L5:
        int r0 = r9.getAction();
        if (r0 == 0) goto L32;
        if (r0 != 1) goto L9;
        OLog.d(TAG, "ACTION_UP");
    L31:
        OLog.d(TAG, "ACTION_CANCEL");
        forceTouchTestEnd(true);
        onForceTouchCancel(r9);
    L33:
        return true;
    L9:
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L31;
    L14:
        if (this.mIsFingerDown == false) goto L33;
        if ((SystemClock.uptimeMillis() - this.mTouchDownTime) <= sPressTimeout) goto L19;
    L21:
        int r1 = (int) r9.getRawX();
        int r10 = (int) r9.getRawY();
        if (this.mForceTouchSucceed == false) goto L33;
        if (this.mMoveFingerSoFar == true) goto L33;
        if (Math.abs(r1 - this.mTouchDownPointX) <= TOUCH_MOVE_BOUNDARY) goto L28;
    L29:
        OLog.d(TAG, "move distance too large");
        this.mMoveFingerSoFar = true;
        this.mHandler.removeMessages(4);
        this.mHandler.sendEmptyMessage(2);
        goto L33
    L28:
        if (Math.abs(r10 - this.mTouchDownPointY) <= TOUCH_MOVE_BOUNDARY) goto L33;
    L19:
        if (checkTouchPressure(this.mTouchTargetView, r9) == false) goto L21;
        onForceTouchSucceed(r9);
        goto L21
    L32:
        OLog.d(TAG, "ACTION_DOWN");
        this.mTouchDownPointX = (int) r9.getRawX();
        this.mTouchDownPointY = (int) r9.getRawY();
        this.mIsFingerDown = true;
        this.mMoveFingerSoFar = false;
        this.mTouchDownTime = SystemClock.uptimeMillis();
        this.mHandler.sendEmptyMessageDelayed(1, sPressTimeout);
        onForceTouchStart(r9);
        goto L33
    }

    private void forceTouchTestEnd(boolean r3) {
        if (this.mIsFingerDown == true) goto L5;
        return;
    L5:
        this.mIsFingerDown = false;
        this.mForceTouchSucceed = false;
        this.mHandler.removeMessages(1);
        this.mHasError = false;
    }

    private boolean checkTouchPressure(View r3, MotionEvent r4) {
        if (ViewSmt.getInstance().isForceTouch(r3, this.mContext, r4.getPressure()) == true) goto L5;
        return false;
    L5:
        if (this.mForceTouchSucceed == true) goto L10;
        this.mForceTouchSucceed = true;
        OLog.d(TAG, "pressure of force touch is reached...");
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendEmptyMessageDelayed(4, PLAY_FORCE_TOUCH_ANIM_DELAY);
        return true;
    L10:
        return false;
    }

    public void cancelAnims() {
        Animator r0 = this.mRadiationAnim;
        if (r0 == null) goto L5;
        r0.cancel();
        this.mRadiationAnim = null;
    L5:
        Animator r1 = this.mPlayingAnim;
        if (r1 == null) goto L8;
        r1.cancel();
        this.mPlayingAnim = null;
    L8:
        AnimatorSet r2 = this.mScaleOuterCircleAnim;
        if (r2 == null) goto L12;
        r2.cancel();
        this.mScaleOuterCircleAnim = null;
        return;
    }

    private void resetAnimViews() {
        this.mTouchAnimView.setVisibility(8);
        this.mTouchAnimView.setScaleX(1.0f);
        this.mTouchAnimView.setScaleY(1.0f);
        this.mTouchAnimView.setAlpha(1.0f);
        this.mInnerAnimView.setScaleX(SCALE_OF_INNER_CIRCLE);
        this.mInnerAnimView.setScaleY(SCALE_OF_INNER_CIRCLE);
        this.mInnerAnimView.setAlpha(1.0f);
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

    public void setTouchAreaType(boolean r2) {
        if (r2 == false) goto L4;
        playInnerCircleAnim();
        return;
    L4:
        this.mInnerAnimView.setScaleX(SCALE_OF_INNER_CIRCLE);
        this.mInnerAnimView.setScaleY(SCALE_OF_INNER_CIRCLE);
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

    public void onForceTouchSucceed(MotionEvent r3) {
        OLog.d(TAG, "onForceTouchSucceed: x:" + r3.getX() + ", y:" + r3.getY());
        SectorManager.access$700(this.mAnimController);
        this.mAnimController.startBigMenu(getWidth() / 2, getHeight() / 2);
    }

    public void onForceTouchCancel(MotionEvent r1) {
        this.mAnimController.onDestroy();
    }

    private void showToastMsgDelay(int r4) {
        if (this.mHandler.hasMessages(3) == false) goto L5;
        this.mHandler.removeMessages(3);
    L5:
        Message r0 = this.mHandler.obtainMessage(3);
        r0.arg1 = r4;
        this.mHandler.sendMessageDelayed(r0, 300);
    }
}
