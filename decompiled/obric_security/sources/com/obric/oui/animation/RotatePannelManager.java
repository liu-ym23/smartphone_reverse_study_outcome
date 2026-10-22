package com.obric.oui.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.securitycenter.MainActivityTemp;
import com.obric.olog.OLog;
import com.obric.security.R;
import com.obric.security.health.score.HealthModuleIds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class RotatePannelManager {
    public static final int BLUE = -14322203;
    private static final int CLEAN_DATA_LENGTH = 5;
    private static final int COLOR_ANIM_EXTEND_TIME = -500;
    private static final int DEFAULT_MAX_SCORE = 100;
    public static final int LIGHT_BLUE = -8618880;
    public static final int ORANGE = -355840;
    public static final int PRESSED_BLUE = -14983214;
    public static final int PRESSED_RED = -3399134;
    public static final int PRESSED_YELLOW = -1073124;
    public static final int RED = -2085587;
    private static final int[] SCAN_DATA = null;
    private static final String TAG = "RotatePannelManager";
    public static final int YELLOW = -18650;
    private Animator.AnimatorListener mAlphaAnimationListener;
    private Animator.AnimatorListener mCleanAnimationListener;
    private ImageView mCleanDoneImgView;
    private TextView mCleaningText;
    private final CubicBezierInterpolator mInterpolator;
    private int mMaxScore;
    private PieProgressView mPieProgress;
    private PieProgressFullView mPieProgressFull;
    private ScrollingNumbersView mProgressNumberView;
    private RatateDataFactory mRatateDataFactory;
    private RotateListener mRotateListener;
    private RotatePannelView mRotatePannelView;
    private Animator.AnimatorListener mScanAnimationListener;
    private ViewGroup mScanningGroup;
    private TextView mScanningText;
    private int mScore;
    private ViewGroup mScoreGroup;
    private ScrollingNumbersView mScoreNumberView;
    private ScrollingNumbersView mScoreNumberViewFull;
    private TextView mScoreText;
    private boolean mSkipClean;
    private volatile State mState;
    private AnimatorSet tickHeightScaleSet;
    private boolean tickHeightScaleSetStop;

    public class PauseData {
        public int[] newDatas;
        public List<Integer> puaseDatas;
        final /* synthetic */ RotatePannelManager this$0;

        public PauseData(final RotatePannelManager this$0) {
            this.this$0 = this$0;
            this.puaseDatas = new ArrayList();
        }
    }

    private class RatateDataFactory {
        final /* synthetic */ RotatePannelManager this$0;

        private RatateDataFactory(final RotatePannelManager this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ RatateDataFactory(RotatePannelManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        public PauseData generatePauseData(int[] source) {
            if (source != null) goto L4;
            return null;
        L4:
            if (source.length < 10) goto L42;
            PauseData r0 = new PauseData(this.this$0);
            Random r10 = new Random();
            int r1 = 0;
            int r2 = 0;
        L8:
            if (r2 >= 3) goto L15;
            int r4 = 1;
            int r3 = (r10.nextInt(2) + (r2 * 3)) + 1;
            int r5 = source[r3 + 1] - source[r3];
            int r6 = (int) (Math.random() * ((double) r5));
            if (r6 == 0) goto L14;
            if (r6 == r5) goto L14;
            r4 = r6;
        L14:
            r0.puaseDatas.add(Integer.valueOf(source[r3] + r4));
            r2 = r2 + 1;
            goto L8
        L15:
            ArrayList r11 = new ArrayList();
            int r7 = 0;
            int r8 = 0;
        L17:
            if (r7 >= source.length) goto L27;
            if (r8 < r0.puaseDatas.size()) goto L21;
        L25:
            r11.add(Integer.valueOf(source[r7]));
        L26:
            r7 = r7 + 1;
            goto L17
        L21:
            if (source[r7] >= r0.puaseDatas.get(r8).intValue()) goto L25;
            if (source[r7 + 1] <= r0.puaseDatas.get(r8).intValue()) goto L25;
            r11.add(r0.puaseDatas.get(r8));
            r11.add(r0.puaseDatas.get(r8));
            r8 = r8 + 1;
            goto L26
        L27:
            r0.newDatas = new int[r11.size()];
            Iterator r12 = r11.iterator();
        L29:
            if (r12.hasNext() == false) goto L31;
            r0.newDatas[r1] = ((Integer) r12.next()).intValue();
            r1 = r1 + 1;
            goto L29
        L31:
            return r0;
        L42:
            return null;
        }

        public int[] generateData(int startNumber, int endNumber) {
            if (startNumber < endNumber) goto L5;
            return null;
        L5:
            int r4 = (endNumber - startNumber) / 4;
            if (r4 >= 1) goto L8;
            r4 = 1;
        L8:
            int[] r2 = new int[5];
            r2[0] = startNumber;
            r2[4] = endNumber;
            int r5 = 1;
        L10:
            if (r5 >= 2) goto L15;
            r2[r5] = r2[r5 - 1] + r4;
            int r0 = 5 - r5;
            int r3 = r0 - 1;
            int r1 = r2[r0] - r4;
            r2[r3] = r1;
            if (r2[r5] >= r1) goto L13;
            r5 = r5 + 1;
            goto L10
        L13:
            r2[r5] = r1;
        L15:
            if (r5 >= 2) goto L19;
            int r6 = r5 + 1;
        L17:
            if (r6 > 2) goto L19;
            r2[r6] = r2[r5];
            r2[(5 - r6) - 1] = r2[r5];
            r6 = r6 + 1;
        L19:
            return r2;
        }
    }

    public interface RotateListener {
        void onCleanFinish();

        void onCleanStart();

        void onScanEnd();
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CLEANING = null;
        public static final State CLEAN_END = null;
        public static final State NONE = null;
        public static final State SCANNING = null;
        public static final State SCAN_END = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{NONE, SCANNING, SCAN_END, CLEANING, CLEAN_END};
        }

        private State(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static State valueOf(String name) {
            return (State) Enum.valueOf(State.class, name);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            NONE = new State("NONE", 0);
            SCANNING = new State("SCANNING", 1);
            SCAN_END = new State("SCAN_END", 2);
            CLEANING = new State("CLEANING", 3);
            CLEAN_END = new State("CLEAN_END", 4);
            $VALUES = $values();
        }
    }

    private void setColor() {
    }

    static /* synthetic */ void access$100(RotatePannelManager r0) {
        r0.beforeClean();
    }

    static /* synthetic */ ViewGroup access$1000(RotatePannelManager r0) {
        return r0.mScanningGroup;
    }

    static /* synthetic */ Animator.AnimatorListener access$1100(RotatePannelManager r0) {
        return r0.mScanAnimationListener;
    }

    static /* synthetic */ ViewGroup access$1200(RotatePannelManager r0) {
        return r0.mScoreGroup;
    }

    static /* synthetic */ RotatePannelView access$1300(RotatePannelManager r0) {
        return r0.mRotatePannelView;
    }

    static /* synthetic */ int access$1400(RotatePannelManager r0, float r1) {
        return r0.getColorFromProgress(r1);
    }

    static /* synthetic */ int access$1500(RotatePannelManager r0, float r1, Resources r2) {
        return r0.getColorFromProgress(r1, r2);
    }

    static /* synthetic */ TextView access$1600(RotatePannelManager r0) {
        return r0.mScoreText;
    }

    static /* synthetic */ PieProgressView access$1700(RotatePannelManager r0) {
        return r0.mPieProgress;
    }

    static /* synthetic */ CubicBezierInterpolator access$1800(RotatePannelManager r0) {
        return r0.mInterpolator;
    }

    static /* synthetic */ PieProgressFullView access$1900(RotatePannelManager r0) {
        return r0.mPieProgressFull;
    }

    static /* synthetic */ int access$200(RotatePannelManager r0) {
        return r0.mScore;
    }

    static /* synthetic */ boolean access$2000(RotatePannelManager r0) {
        return r0.tickHeightScaleSetStop;
    }

    static /* synthetic */ boolean access$2002(RotatePannelManager r0, boolean r1) {
        r0.tickHeightScaleSetStop = r1;
        return r1;
    }

    static /* synthetic */ AnimatorSet access$2100(RotatePannelManager r0) {
        return r0.tickHeightScaleSet;
    }

    static /* synthetic */ AnimatorSet access$2102(RotatePannelManager r0, AnimatorSet r1) {
        r0.tickHeightScaleSet = r1;
        return r1;
    }

    static /* synthetic */ void access$2200(RotatePannelManager r0) {
        r0.afterClean();
    }

    static /* synthetic */ ScrollingNumbersView access$2300(RotatePannelManager r0) {
        return r0.mScoreNumberViewFull;
    }

    static /* synthetic */ State access$2402(RotatePannelManager r0, State r1) {
        r0.mState = r1;
        return r1;
    }

    static /* synthetic */ void access$2500(RotatePannelManager r0) {
        r0.setColor();
    }

    static /* synthetic */ int access$300(RotatePannelManager r0) {
        return r0.mMaxScore;
    }

    static /* synthetic */ void access$400(RotatePannelManager r0) {
        r0.forceFinish();
    }

    static /* synthetic */ ScrollingNumbersView access$500(RotatePannelManager r0) {
        return r0.mProgressNumberView;
    }

    static /* synthetic */ RotateListener access$600(RotatePannelManager r0) {
        return r0.mRotateListener;
    }

    static /* synthetic */ boolean access$700(RotatePannelManager r0) {
        return r0.mSkipClean;
    }

    static /* synthetic */ ScrollingNumbersView access$800(RotatePannelManager r0) {
        return r0.mScoreNumberView;
    }

    static /* synthetic */ Animator.AnimatorListener access$900(RotatePannelManager r0) {
        return r0.mAlphaAnimationListener;
    }

    static {
        SCAN_DATA = new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 99, 100};
    }

    public RotatePannelManager(RotatePannelView rotatePannelView) {
        this.mState = State.NONE;
        this.mScore = 0;
        this.mSkipClean = false;
        this.mMaxScore = 100;
        this.tickHeightScaleSetStop = false;
        this.mInterpolator = new CubicBezierInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mScanAnimationListener = new AnonymousClass12(this);
        this.mCleanAnimationListener = new AnonymousClass13(this);
        this.mAlphaAnimationListener = new AnonymousClass14(this);
        if (rotatePannelView != null) goto L5;
        OLog.e(TAG, "rotatePannelView is null");
    L5:
        init(rotatePannelView);
    }

    private void init(RotatePannelView rotatePannelView) {
        this.mRatateDataFactory = new RatateDataFactory(this, null);
        this.mRotatePannelView = rotatePannelView;
        this.mScanningGroup = rotatePannelView.mScanningGroup;
        this.mScoreGroup = this.mRotatePannelView.mScoreGroup;
        this.mProgressNumberView = this.mRotatePannelView.mProgressNumberView;
        this.mScanningText = this.mRotatePannelView.mScanningText;
        this.mPieProgress = this.mRotatePannelView.mPieProgress;
        this.mPieProgressFull = this.mRotatePannelView.mPieProgressFull;
        this.mScoreNumberView = this.mRotatePannelView.mScoreNumberView;
        this.mScoreNumberViewFull = this.mRotatePannelView.mScoreNumberFullView;
        this.mScoreText = this.mRotatePannelView.mScoreText;
        this.mCleaningText = this.mRotatePannelView.mCleaningText;
        this.mCleanDoneImgView = this.mRotatePannelView.mCleanDoneImgView;
        this.mScoreNumberView.setShowSubTextByLanguage(true);
        this.mScoreGroup.setOnClickListener(new AnonymousClass1(this));
        this.mScoreNumberView.setScrollNumberListener(new AnonymousClass2(this));
    }

    public boolean isScanning() {
        if (this.mState != State.SCANNING) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isScannEnd() {
        if (this.mState != State.SCAN_END) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCleanning() {
        if (this.mState != State.CLEANING) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCleanEnd() {
        if (this.mState != State.CLEAN_END) goto L5;
        return true;
    L5:
        return false;
    }

    public void skipClean() {
        this.mSkipClean = true;
    }

    public void setMaxScore(int score) {
        this.mMaxScore = score;
    }

    public void continueAnim() {
        if (MainActivityTemp.DBG == false) goto L6;
        OLog.d(TAG, "continueAnim isPause=" + this.mProgressNumberView.isPause());
    L6:
        if (this.mProgressNumberView.isPause() == false) goto L8;
        this.mProgressNumberView.resume();
        return;
    L8:
        this.mProgressNumberView.setNeedPause(false);
    }

    private boolean updateScore(int score) {
        if (score >= 0) goto L5;
        return false;
    L5:
        this.mScore = score;
        int r1 = this.mMaxScore;
        if (score < r1) goto L9;
        this.mScore = r1;
        return true;
    L9:
        return false;
    }

    public void setScore(int score) {
        boolean r3 = updateScore(score);
        if (this.mState != State.CLEAN_END) goto L5;
    L11:
        int r0 = this.mScore;
        this.mScoreNumberView.setInitialValue(r0);
        setColor();
        afterSetScore(r3);
        return;
    L5:
        if (this.mState == State.SCAN_END) goto L11;
        if (this.mState != State.SCANNING) goto L13;
        if (r3 == false) goto L14;
        skipClean();
        return;
    L14:
        return;
    }

    private void afterSetScore(boolean isMax) {
        if (this.mState == State.SCAN_END) goto L5;
        return;
    L5:
        OLog.i(TAG, "afterSetScore");
        Resources r0 = this.mProgressNumberView.getResources();
        float r1 = this.mScore / this.mMaxScore;
        int r2 = getColorFromProgress(r1);
        int r3 = getColorFromProgress(r1, r0);
        this.mScoreNumberView.onColorUpdate(r3);
        this.mScoreText.setTextColor(r3);
        this.mPieProgress.setFinalColor(r2);
        this.mPieProgress.setProgress(r1);
        if (isMax == false) goto L9;
        forceFinish();
        return;
    }

    private void prepare() {
        this.mRotatePannelView.prepare();
        this.mScanningGroup.setAlpha(1.0f);
        this.mScoreGroup.setAlpha(0.0f);
        this.mScanningText.setAlpha(0.0f);
        this.mCleanDoneImgView.setAlpha(0.0f);
        this.mCleanDoneImgView.setScaleX(0.0f);
        this.mCleanDoneImgView.setScaleY(0.0f);
        this.mProgressNumberView.setAlpha(0.0f);
        this.mProgressNumberView.setNeedPause(true);
    }

    private void forceFinish() {
        OLog.i(TAG, "forceFinish");
        this.mState = State.CLEAN_END;
        this.mScoreText.setVisibility(8);
        this.mScoreGroup.setOnClickListener(null);
        this.mPieProgressFull.setVisibility(0);
        this.mPieProgress.setVisibility(8);
        this.mScoreNumberView.setAlpha(0.0f);
        this.mScoreNumberViewFull.setAlpha(1.0f);
    }

    private int getColorFromProgress(float finalProgress) {
        if (finalProgress < 0.95f) goto L6;
        String r0 = "#4D2BD900";
    L13:
        return Color.parseColor(r0);
    L6:
        if (finalProgress < 0.9f) goto L9;
        r0 = "#CCFFDD7E";
        goto L13
    L9:
        if (finalProgress < 0.8f) goto L11;
        r0 = "#CCFFB17D";
        goto L13
    L11:
        r0 = "#CCFFA5A5";
        goto L13
    }

    private int getColorFromProgress(float finalProgress, Resources resources) {
        if (finalProgress < 0.95f) goto L6;
        int r0 = R.color.oui_functional_green_6;
    L13:
        return resources.getColor(r0);
    L6:
        if (finalProgress < 0.9f) goto L9;
        r0 = R.color.oui_functional_yellow_6;
        goto L13
    L9:
        if (finalProgress < 0.8f) goto L11;
        r0 = R.color.oui_functional_orange_6;
        goto L13
    L11:
        r0 = R.color.oui_functional_red_6;
        goto L13
    }

    public void scan() {
        OLog.i(TAG, "scan");
        if (this.mState == State.NONE) goto L5;
        return;
    L5:
        this.mState = State.SCANNING;
        prepare();
        PauseData r0 = this.mRatateDataFactory.generatePauseData(SCAN_DATA);
        if (r0 != null) goto L8;
        return;
    L8:
        int[] r1 = r0.newDatas;
        long r3 = Math.abs(r1[0] - r1[r1.length - 1]) * 100;
        this.mRotatePannelView.scan();
        this.mProgressNumberView.setInitialValue(r1[0]);
        this.mProgressNumberView.addPauseNumber(r0.puaseDatas);
        this.mProgressNumberView.setNumberAnimatorValues(r1);
        this.mProgressNumberView.setNumberAnimatorDuration(r3);
        this.mProgressNumberView.animate().alpha(1.0f).setDuration(300).setListener(new AnonymousClass3(this)).start();
        this.mScanningText.setText(R.string.scaning);
        this.mScanningText.animate().alpha(1.0f).setDuration(300).start();
        this.mProgressNumberView.setScrollNumberListener(new AnonymousClass4(this));
    }

    private void beforeClean() {
        if (this.mState != State.SCAN_END) goto L6;
        OLog.i(TAG, "beforeClean");
        ImageView r0 = this.mRotatePannelView.mInnerBaseBg;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r0, "scaleX", new float[]{1.0f, 0.95f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r0, "scaleY", new float[]{1.0f, 0.95f});
        AnimatorSet r6 = new AnimatorSet();
        r6.setDuration(500);
        r6.playTogether(new Animator[]{r2, r4});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0, "scaleX", new float[]{0.95f, 1.0f});
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0, "scaleY", new float[]{0.95f, 1.0f});
        final AnimatorSet r5 = new AnimatorSet();
        r5.setDuration(300);
        r5.playTogether(new Animator[]{r3, r1});
        r6.addListener(new AnonymousClass5(this, r5));
        r6.start();
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mPieProgress, "progress", new float[]{1.0f});
        ObjectAnimator r8 = ObjectAnimator.ofInt(this.mPieProgress, "finalColor", new int[]{getColorFromProgress(1.0f)});
        r8.setEvaluator(new ArgbEvaluator());
        AnimatorSet r9 = new AnimatorSet();
        r9.playTogether(new Animator[]{r7, r8});
        r9.setDuration(300);
        r9.addListener(new AnonymousClass6(this));
        r9.setInterpolator(this.mInterpolator);
        r9.start();
        return;
    }

    public void clean() {
        if (this.mState == State.SCAN_END) goto L5;
        return;
    L5:
        OLog.i(TAG, HealthModuleIds.CLEAN);
        this.mState = State.CLEANING;
        prepare();
        PauseData r0 = this.mRatateDataFactory.generatePauseData(SCAN_DATA);
        if (r0 != null) goto L8;
        return;
    L8:
        int[] r1 = r0.newDatas;
        long r3 = Math.abs(r1[0] - r1[r1.length - 1]) * 100;
        this.mProgressNumberView.setInitialValue(r1[0]);
        this.mProgressNumberView.addPauseNumber(r0.puaseDatas);
        this.mProgressNumberView.setNumberAnimatorValues(r1);
        this.mProgressNumberView.setNumberAnimatorDuration(r3);
        this.mProgressNumberView.animate().alpha(1.0f).setDuration(300).setListener(new AnonymousClass7(this)).start();
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mPieProgressFull, "tickHeightScale", new float[]{1.0f, 0.25f});
        r2.setDuration(1300);
        r2.setInterpolator(this.mInterpolator);
        r2.addListener(new AnonymousClass8(this));
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mPieProgressFull, "tickHeightScale", new float[]{0.25f, 1.0f});
        r7.setInterpolator(this.mInterpolator);
        r7.setDuration(300);
        AnimatorSet r8 = new AnimatorSet();
        this.tickHeightScaleSet = r8;
        r8.playSequentially(new Animator[]{r2, r7});
        this.tickHeightScaleSet.addListener(new AnonymousClass9(this));
        this.tickHeightScaleSetStop = false;
        this.tickHeightScaleSet.start();
        this.mScanningGroup.setAlpha(0.0f);
        this.mScoreGroup.setAlpha(1.0f);
        this.mScoreNumberView.setAlpha(0.0f);
        this.mScoreText.setVisibility(8);
        this.mCleaningText.setVisibility(0);
        this.mCleaningText.animate().alpha(1.0f).setDuration(300).start();
        this.mProgressNumberView.setScrollNumberListener(new AnonymousClass10(this));
        RotateListener r4 = this.mRotateListener;
        if (r4 == null) goto L11;
        r4.onCleanStart();
    L11:
        this.mRotatePannelView.clean();
    }

    private void afterClean() {
        OLog.i(TAG, "afterClean");
        this.mRotatePannelView.onCleanEnd();
        this.mScoreNumberView.setInitialValue(this.mScore);
        this.mScoreNumberViewFull.setInitialValue(this.mScore);
        this.mCleaningText.setVisibility(8);
        int r1 = getColorFromProgress(this.mScore / this.mMaxScore, this.mProgressNumberView.getResources());
        this.mScoreNumberView.onColorUpdate(r1);
        this.mScoreNumberViewFull.onColorUpdate(r1);
        this.mScoreText.setTextColor(r1);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleX", new float[]{0.0f, 1.12f});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleY", new float[]{0.0f, 1.12f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleX", new float[]{1.12f, 1.0f});
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleY", new float[]{1.12f, 1.0f});
        AnimatorSet r10 = new AnimatorSet();
        r10.setDuration(200);
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleX", new float[]{1.0f, 1.16f});
        ObjectAnimator r12 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleY", new float[]{1.0f, 1.16f});
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "alpha", new float[]{1.0f, 0.0f});
        final AnimatorSet r14 = new AnimatorSet();
        r14.setDuration(400);
        r14.setInterpolator(this.mInterpolator);
        r14.playTogether(new Animator[]{r11, r12, r13});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.mScoreNumberViewFull, "scaleX", new float[]{0.95f, 1.0f});
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mScoreNumberViewFull, "scaleY", new float[]{0.95f, 1.0f});
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.mScoreNumberViewFull, "alpha", new float[]{0.0f, 1.0f});
        final AnimatorSet r15 = new AnimatorSet();
        r15.setDuration(400);
        r15.playTogether(new Animator[]{r4, r6, r8});
        r15.setInterpolator(this.mInterpolator);
        r15.addListener(this.mCleanAnimationListener);
        r10.addListener(new AnonymousClass11(this, r14, r15));
        r10.playTogether(new Animator[]{r7, r9});
        this.mCleanDoneImgView.setVisibility(0);
        AnimatorSet r16 = new AnimatorSet();
        r16.setDuration(300);
        r16.play(r5).with(r2).with(r3).before(r10);
        r16.setInterpolator(this.mInterpolator);
        r16.start();
    }

    public void setRotateListener(RotateListener listener) {
        this.mRotateListener = listener;
    }

    public void onDestory() {
        this.mProgressNumberView.destory();
    }
}
