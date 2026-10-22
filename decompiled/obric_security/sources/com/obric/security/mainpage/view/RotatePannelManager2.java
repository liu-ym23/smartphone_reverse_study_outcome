package com.obric.security.mainpage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.olog.OLog;
import com.obric.oui.animation.CubicBezierInterpolator;
import com.obric.oui.animation.ScrollingNumbersView;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public class RotatePannelManager2 {
    private static final int DEFAULT_MAX_SCORE = 100;
    private static final long EXTERNAL_SCAN_PROGRESS_ANIM_DURATION = 250;
    private static final int EXTERNAL_SCAN_PROGRESS_ANIM_STEP = 10;
    private static final int[] SCAN_DATA = null;
    private static final String SOURCE = "RotatePannelManager";
    private static final String TAG = "HealthScore";
    private boolean mAfterCleanStarted;
    private boolean mAnimateRingOnScanEnd;
    private Animator.AnimatorListener mCleanAnimationListener;
    private ImageView mCleanDoneImgView;
    private TextView mCleaningText;
    private int mExternalScanDisplayedProgress;
    private boolean mExternalScanProgressMode;
    private boolean mFinishAfterScan;
    private final CubicBezierInterpolator mInterpolator;
    private int mMaxScore;
    private ScrollingNumbersView mProgressNumberView;
    private RatateDataFactory mRatateDataFactory;
    private RotateListener mRotateListener;
    private RotatePannelView2 mRotatePannelView;
    private boolean mScanFinishDispatched;
    private Integer mScanResultRingColor;
    private ViewGroup mScanningGroup;
    private TextView mScanningText;
    private int mScore;
    private View.OnClickListener mScoreClickListener;
    private ViewGroup mScoreGroup;
    private ScrollingNumbersView mScoreNumberView;
    private ScrollingNumbersView mScoreNumberViewFull;
    private TextView mScoreText;
    private boolean mShowScoreActionOnCleanEnd;
    private boolean mShowScoreActionOnScanEnd;
    private volatile State mState;
    private boolean mSuppressTickHeightClean;
    GlowDotRingProg progressBar;
    private AnimatorSet tickHeightScaleSet;
    private boolean tickHeightScaleSetStop;

    /* JADX INFO: renamed from: com.obric.security.mainpage.view.RotatePannelManager2$18, reason: invalid class name */
    static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$security$mainpage$view$RotatePannelManager2$State = null;

        static {
            int[] r0 = new int[State.values().length];
            $SwitchMap$com$obric$security$mainpage$view$RotatePannelManager2$State = r0;
            r0[State.SCANNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$security$mainpage$view$RotatePannelManager2$State[State.SCAN_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$security$mainpage$view$RotatePannelManager2$State[State.CLEAN_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$obric$security$mainpage$view$RotatePannelManager2$State[State.CLEANING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$obric$security$mainpage$view$RotatePannelManager2$State[State.NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class PauseData {
        public int[] newDatas;
        public List<Integer> puaseDatas;
        final /* synthetic */ RotatePannelManager2 this$0;

        public PauseData(final RotatePannelManager2 this$0) {
            this.this$0 = this$0;
            this.puaseDatas = new ArrayList();
        }
    }

    private class RatateDataFactory {
        final /* synthetic */ RotatePannelManager2 this$0;

        private RatateDataFactory(final RotatePannelManager2 this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ RatateDataFactory(RotatePannelManager2 r1, AnonymousClass1 r2) {
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
    }

    public interface RotateListener {
        void onCleanFinish();

        void onCleanStart();

        void onScanUiEnd();
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

    static /* synthetic */ View.OnClickListener access$100(RotatePannelManager2 r0) {
        return r0.mScoreClickListener;
    }

    static /* synthetic */ void access$1000(RotatePannelManager2 r0) {
        r0.finishScanUiOnce();
    }

    static /* synthetic */ ScrollingNumbersView access$1100(RotatePannelManager2 r0) {
        return r0.mProgressNumberView;
    }

    static /* synthetic */ int access$1200(RotatePannelManager2 r0) {
        return r0.mExternalScanDisplayedProgress;
    }

    static /* synthetic */ void access$1300(RotatePannelManager2 r0, int r1) {
        r0.animateExternalScanNumberTo(r1);
    }

    static /* synthetic */ RotatePannelView2 access$1400(RotatePannelManager2 r0) {
        return r0.mRotatePannelView;
    }

    static /* synthetic */ boolean access$1500(RotatePannelManager2 r0) {
        return r0.tickHeightScaleSetStop;
    }

    static /* synthetic */ boolean access$1502(RotatePannelManager2 r0, boolean r1) {
        r0.tickHeightScaleSetStop = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1600(RotatePannelManager2 r0) {
        return r0.mSuppressTickHeightClean;
    }

    static /* synthetic */ AnimatorSet access$1700(RotatePannelManager2 r0) {
        return r0.tickHeightScaleSet;
    }

    static /* synthetic */ AnimatorSet access$1702(RotatePannelManager2 r0, AnimatorSet r1) {
        r0.tickHeightScaleSet = r1;
        return r1;
    }

    static /* synthetic */ void access$1800(RotatePannelManager2 r0) {
        r0.afterClean();
    }

    static /* synthetic */ boolean access$1900(RotatePannelManager2 r0, int r1) {
        return r0.updateScore(r1);
    }

    static /* synthetic */ String access$200(String r0) {
        return log(r0);
    }

    static /* synthetic */ void access$2000(RotatePannelManager2 r0) {
        r0.startCleanInternal();
    }

    static /* synthetic */ void access$2100(RotatePannelManager2 r0, int r1, boolean r2) {
        r0.applyOptimizeResultByState(r1, r2);
    }

    static /* synthetic */ void access$2200(RotatePannelManager2 r0, int r1, boolean r2) {
        r0.updateResultScoreToInternal(r1, r2);
    }

    static /* synthetic */ void access$2300(RotatePannelManager2 r0) {
        r0.applyFinalScoreState();
    }

    static /* synthetic */ void access$2400(RotatePannelManager2 r0) {
        r0.enterCleanEndState();
    }

    static /* synthetic */ RotateListener access$2500(RotatePannelManager2 r0) {
        return r0.mRotateListener;
    }

    static /* synthetic */ int access$300(RotatePannelManager2 r0) {
        return r0.mScore;
    }

    static /* synthetic */ int access$400(RotatePannelManager2 r0) {
        return r0.mMaxScore;
    }

    static /* synthetic */ void access$500(RotatePannelManager2 r0) {
        r0.forceFinish();
    }

    static /* synthetic */ State access$600(RotatePannelManager2 r0) {
        return r0.mState;
    }

    static /* synthetic */ boolean access$702(RotatePannelManager2 r0, boolean r1) {
        r0.mAnimateRingOnScanEnd = r1;
        return r1;
    }

    static /* synthetic */ boolean access$802(RotatePannelManager2 r0, boolean r1) {
        r0.mShowScoreActionOnScanEnd = r1;
        return r1;
    }

    static /* synthetic */ void access$900(RotatePannelManager2 r0, int r1, boolean r2) {
        r0.applyScanResultByState(r1, r2);
    }

    static {
        SCAN_DATA = new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 99, 100};
    }

    public RotatePannelManager2(RotatePannelView2 rotatePannelView) {
        this.mState = State.NONE;
        this.mScore = 0;
        this.mFinishAfterScan = false;
        this.mMaxScore = 100;
        this.mScanFinishDispatched = false;
        this.mExternalScanProgressMode = false;
        this.mExternalScanDisplayedProgress = 0;
        this.mAfterCleanStarted = false;
        this.mShowScoreActionOnScanEnd = true;
        this.mAnimateRingOnScanEnd = true;
        this.mShowScoreActionOnCleanEnd = true;
        this.tickHeightScaleSetStop = false;
        this.mSuppressTickHeightClean = false;
        this.mInterpolator = new CubicBezierInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mCleanAnimationListener = new AnonymousClass17(this);
        if (rotatePannelView != null) goto L5;
        OLog.e("HealthScore", log("rotatePannelView is null"));
    L5:
        init(rotatePannelView);
    }

    private void init(RotatePannelView2 rotatePannelView) {
        this.mRatateDataFactory = new RatateDataFactory(this, null);
        this.mRotatePannelView = rotatePannelView;
        this.mScanningGroup = rotatePannelView.mScanningGroup;
        this.mScoreGroup = this.mRotatePannelView.mScoreGroup;
        this.mProgressNumberView = this.mRotatePannelView.mProgressNumberView;
        this.mScanningText = this.mRotatePannelView.mScanningText;
        this.mScoreNumberView = this.mRotatePannelView.mScoreNumberView;
        this.mScoreNumberViewFull = this.mRotatePannelView.mScoreNumberFullView;
        this.mScoreText = this.mRotatePannelView.mScoreText;
        this.mCleaningText = this.mRotatePannelView.mCleaningText;
        this.mCleanDoneImgView = this.mRotatePannelView.mCleanDoneImgView;
        this.progressBar = this.mRotatePannelView.progressBar;
        this.mScoreNumberView.setShowSubTextByLanguage(true);
        this.mScoreGroup.setClickable(false);
        this.mScoreGroup.setOnClickListener(null);
        this.mScoreText.setOnClickListener(new AnonymousClass1(this));
        setScoreActionClickable(false);
        this.mScoreNumberView.setScrollNumberListener(new AnonymousClass2(this));
    }

    public boolean isScannEnd() {
        if (this.mState != State.SCAN_END) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isResultState() {
        if (this.mState != State.SCAN_END) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == State.CLEAN_END) goto L8;
        return false;
    }

    public int getScore() {
        return this.mScore;
    }

    private void finishAfterScan() {
        this.mFinishAfterScan = true;
    }

    public void setMaxScore(int score) {
        this.mMaxScore = score;
    }

    public void setScanResultRingColor(Integer color) {
        this.mScanResultRingColor = color;
    }

    private void continueProgressNumberAnimation() {
        if (this.mProgressNumberView.isPause() == false) goto L5;
        this.mProgressNumberView.resume();
        return;
    L5:
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

    public void finishScanToScore(final int score, final boolean animateRing, final boolean showScoreAction) {
        this.mRotatePannelView.post(new AnonymousClass3(this, score, animateRing, showScoreAction));
    }

    private void applyScanResultByState(int score, boolean showScoreAction) {
        int r0 = AnonymousClass18.$SwitchMap$com$obric$security$mainpage$view$RotatePannelManager2$State[this.mState.ordinal()];
        if (r0 != 1) goto L5;
        finishScanningToScore(score);
        return;
    L5:
        if (r0 != 2) goto L7;
    L9:
        updateResultScoreToInternal(score, showScoreAction);
        return;
    L7:
        if (r0 == 3) goto L9;
        OLog.i("HealthScore", log("finishScanToScore ignored state=" + this.mState));
    }

    private void finishScanningToScore(int score) {
        boolean r3 = updateScore(score);
        OLog.i("HealthScore", log("finishScanningToScore score=" + this.mScore + " isMax=" + r3 + " externalProgressMode=" + this.mExternalScanProgressMode));
        if (this.mExternalScanProgressMode == false) goto L5;
        finishExternalProgressScan();
        return;
    L5:
        if (r3 == false) goto L7;
        finishAfterScan();
        continueProgressNumberAnimation();
        return;
    L7:
        continueProgressNumberAnimation();
    }

    private void finishExternalProgressScan() {
        OLog.i("HealthScore", log("finishExternalProgressScan displayedProgress=" + this.mExternalScanDisplayedProgress + " maxScore=" + this.mMaxScore));
        animateExternalScanNumberTo(this.mMaxScore);
        finishAfterScan();
        this.mProgressNumberView.postDelayed(new AnonymousClass4(this), EXTERNAL_SCAN_PROGRESS_ANIM_DURATION);
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
        setScoreActionClickable(false);
    }

    private void forceFinish() {
        OLog.i("HealthScore", log("forceFinish"));
        stopTickHeightScaleAnimation();
        enterCleanEndState();
    }

    private void enterScanningState(boolean externalProgressMode) {
        this.mExternalScanProgressMode = externalProgressMode;
        this.mScanFinishDispatched = false;
        this.mFinishAfterScan = false;
        this.mExternalScanDisplayedProgress = 0;
        this.mAnimateRingOnScanEnd = true;
        this.mShowScoreActionOnScanEnd = true;
        transitionTo(State.SCANNING, "enterScanning externalProgressMode=" + externalProgressMode);
        prepare();
    }

    private void enterScanEndState() {
        transitionTo(State.SCAN_END, "enterScanEnd");
    }

    private void enterCleaningState() {
        transitionTo(State.CLEANING, "enterCleaning");
        this.mAfterCleanStarted = false;
        prepare();
        this.mCleaningText.setText(R.string.cleaning);
    }

    private void enterCleanEndState() {
        transitionTo(State.CLEAN_END, "enterCleanEnd");
        this.mScanningGroup.setAlpha(0.0f);
        this.mScoreGroup.setAlpha(1.0f);
        this.mCleaningText.setVisibility(8);
        this.mCleanDoneImgView.setVisibility(8);
        applyScoreActionVisible(this.mShowScoreActionOnCleanEnd);
        applyResultScoreNumberVisibility();
    }

    private void transitionTo(State newState, String reason) {
        State r0 = this.mState;
        this.mState = newState;
        OLog.i("HealthScore", log("stateTransition " + r0 + " -> " + newState + " reason=" + reason + " score=" + this.mScore + " maxScore=" + this.mMaxScore));
    }

    private void setScoreActionClickable(boolean clickable) {
        TextView r0 = this.mScoreText;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setClickable(clickable);
    }

    private void applyScoreActionVisible(boolean showScoreAction) {
        boolean r3 = shouldShowScoreAction(showScoreAction);
        TextView r0 = this.mScoreText;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        setScoreActionClickable(r3);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    private boolean shouldShowScoreAction(boolean showScoreAction) {
        if (showScoreAction == true) goto L4;
    L6:
        return false;
    L4:
        if (this.mScore >= this.mMaxScore) goto L6;
        return true;
    }

    private void stopTickHeightScaleAnimation() {
        this.tickHeightScaleSetStop = true;
        AnimatorSet r1 = this.tickHeightScaleSet;
        if (r1 == null) goto L5;
        this.mSuppressTickHeightClean = true;
        r1.cancel();
        this.tickHeightScaleSet = null;
        this.mSuppressTickHeightClean = false;
    L5:
        GlowDotRingProg r0 = this.progressBar;
        if (r0 == null) goto L9;
        r0.setScaleAnimationState(false);
        this.progressBar.setDotRadius(1.0f);
        return;
    }

    private int getResultRingColorByProgress(float finalProgress, Resources resources) {
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

    private int getScoreActionBackgroundColorByProgress(float finalProgress, Resources resources) {
        if (finalProgress < 0.95f) goto L6;
        int r0 = R.color.oui_functional_green_1;
    L13:
        return resources.getColor(r0);
    L6:
        if (finalProgress < 0.9f) goto L9;
        r0 = R.color.oui_functional_yellow_1;
        goto L13
    L9:
        if (finalProgress < 0.8f) goto L11;
        r0 = R.color.oui_functional_orange_1;
        goto L13
    L11:
        r0 = R.color.oui_functional_red_1;
        goto L13
    }

    private int getResultRingColor(float finalProgress, Resources resources) {
        Integer r0 = this.mScanResultRingColor;
        if (r0 == null) goto L6;
        return r0.intValue();
    L6:
        return getResultRingColorByProgress(finalProgress, resources);
    }

    public void startScan(boolean externalProgressMode) {
        OLog.i("HealthScore", log("startScan state=" + this.mState + " externalProgressMode=" + externalProgressMode + " score=" + this.mScore + " maxScore=" + this.mMaxScore));
        if (this.mState == State.NONE) goto L5;
        return;
    L5:
        if (externalProgressMode == false) goto L7;
        startExternalProgressScan();
        return;
    L7:
        startInternalProgressScan();
    }

    private void startInternalProgressScan() {
        enterScanningState(false);
        PauseData r1 = this.mRatateDataFactory.generatePauseData(SCAN_DATA);
        if (r1 != null) goto L5;
        return;
    L5:
        int[] r2 = r1.newDatas;
        long r3 = Math.abs(r2[0] - r2[r2.length - 1]) * 100;
        this.mRotatePannelView.scan();
        this.mProgressNumberView.setInitialValue(r2[0]);
        this.mProgressNumberView.addPauseNumber(r1.puaseDatas);
        this.mProgressNumberView.setNumberAnimatorValues(r2);
        this.mProgressNumberView.setNumberAnimatorDuration(r3);
        this.mProgressNumberView.animate().alpha(1.0f).setDuration(300).setListener(new AnonymousClass5(this)).start();
        this.mScanningText.setText(R.string.scaning);
        this.mScanningText.animate().alpha(1.0f).setDuration(300).start();
        this.mProgressNumberView.setScrollNumberListener(new AnonymousClass6(this));
    }

    private void startExternalProgressScan() {
        enterScanningState(true);
        this.mRotatePannelView.scan();
        this.mProgressNumberView.setInitialValue(0);
        this.mProgressNumberView.animate().alpha(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
        this.mScanningText.setText(R.string.scaning);
        this.mScanningText.animate().alpha(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
        this.progressBar.setmProgressmax(this.mMaxScore);
        this.progressBar.setProgress(0);
    }

    public void updateScanProgress(final int progress) {
        if (this.mExternalScanProgressMode == true) goto L5;
        return;
    L5:
        this.mRotatePannelView.post(new AnonymousClass7(this, progress));
    }

    private void animateExternalScanNumberTo(int targetProgress) {
        int r4 = Math.max(0, Math.min(targetProgress, this.mMaxScore));
        int r1 = this.mExternalScanDisplayedProgress;
        if (r4 > r1) goto L5;
        return;
    L5:
        this.mExternalScanDisplayedProgress = r4;
        this.mProgressNumberView.cancelNumberAnimator();
        this.mProgressNumberView.setInitialValue(r1);
        this.mProgressNumberView.setNumberAnimatorValues(new int[]{r4});
        this.mProgressNumberView.setNumberAnimatorDuration(EXTERNAL_SCAN_PROGRESS_ANIM_DURATION);
        this.mProgressNumberView.startNumberAnimator();
    }

    private void finishScanUiOnce() {
        if (this.mScanFinishDispatched == false) goto L6;
        OLog.d("HealthScore", log("finishScanUiOnce ignored alreadyDispatched state=" + this.mState));
        return;
    L6:
        this.mScanFinishDispatched = true;
        OLog.i("HealthScore", log("finishScanUiOnce state=" + this.mState + " score=" + this.mScore + " finishAfterScan=" + this.mFinishAfterScan + " showScoreAction=" + this.mShowScoreActionOnScanEnd + " animateRing=" + this.mAnimateRingOnScanEnd));
        RotateListener r1 = this.mRotateListener;
        if (r1 == null) goto L9;
        r1.onScanUiEnd();
    L9:
        enterScanEndState();
        boolean r2 = this.mShowScoreActionOnScanEnd;
        this.mShowScoreActionOnCleanEnd = r2;
        applyScoreActionVisible(r2);
        applyResultScoreNumberVisibility();
        if (this.mFinishAfterScan == true) goto L12;
    L17:
        this.mScanningGroup.animate().alpha(0.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200).start();
        this.mScoreGroup.animate().alpha(1.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200).start();
        this.mRotatePannelView.onScanEnd();
        boolean r3 = this.mAnimateRingOnScanEnd;
        if (r3 == false) goto L20;
        int r4 = 0;
    L21:
        int r0 = applyScoreVisuals(r4, false, !r3, true);
        if (this.mAnimateRingOnScanEnd == false) goto L25;
        animateRingProgressToScore(r0);
        return;
    L25:
        return;
    L20:
        r4 = this.mScore;
        goto L21
    L12:
        if (this.mScore < this.mMaxScore) goto L17;
        if (this.mShowScoreActionOnScanEnd == false) goto L17;
        forceFinish();
    }

    private void startCleanInternal() {
        if (this.mState != State.NONE) goto L5;
    L7:
        this.mExternalScanProgressMode = false;
        this.mScanFinishDispatched = true;
        this.mFinishAfterScan = false;
        enterCleaningState();
        int r2 = getResultRingColor(1.0f, this.mProgressNumberView.getResources());
        applyRingState(this.mMaxScore, r2, true);
        applyScoreNumberValues();
        applyScoreNumberColor(r2, true);
        this.mCleaningText.setTextColor(r2);
        PauseData r3 = this.mRatateDataFactory.generatePauseData(SCAN_DATA);
        if (r3 != null) goto L10;
        return;
    L10:
        int[] r4 = r3.newDatas;
        int r5 = r4.length;
        int[] r6 = new int[r5];
        int r7 = 0;
    L12:
        if (r7 >= r4.length) goto L14;
        int r8 = this.mScore;
        r6[r7] = r8 + ((int) (((double) ((this.mMaxScore - r8) * r4[r7])) / 100.0d));
        r7 = r7 + 1;
        goto L12
    L14:
        ArrayList r9 = new ArrayList();
        if (r3.puaseDatas == null) goto L22;
        Iterator<Integer> r10 = r3.puaseDatas.iterator();
    L18:
        if (r10.hasNext() == false) goto L22;
        Integer r11 = r10.next();
        if (r11 == null) goto L18;
        int r12 = this.mScore;
        r9.add(Integer.valueOf(r12 + (((this.mMaxScore - r12) * r11.intValue()) / 100)));
    L22:
        long r13 = Math.abs(r6[0] - r6[r5 - 1]) * 100;
        this.mRotatePannelView.clean();
        this.mProgressNumberView.setInitialValue(r6[0]);
        this.mProgressNumberView.addPauseNumber(r9);
        this.mProgressNumberView.setNumberAnimatorValues(r6);
        this.mProgressNumberView.setNumberAnimatorDuration(r13);
        this.mProgressNumberView.animate().alpha(1.0f).setDuration(300).setListener(new AnonymousClass8(this)).start();
        this.progressBar.setScaleAnimationState(true);
        final int[] r14 = {0};
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this.progressBar, "dotRadius", new float[]{1.0f, 0.2f});
        r15.setDuration(1300);
        r15.setInterpolator(this.mInterpolator);
        r15.addListener(new AnonymousClass9(this, r14));
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.progressBar, "dotRadius", new float[]{0.2f, 1.0f});
        r16.setInterpolator(this.mInterpolator);
        r16.setDuration(300);
        AnimatorSet r17 = new AnimatorSet();
        this.tickHeightScaleSet = r17;
        r17.playSequentially(new Animator[]{r15, r16});
        this.tickHeightScaleSet.addListener(new AnonymousClass10(this));
        this.tickHeightScaleSet.start();
        this.tickHeightScaleSetStop = false;
        this.mScanningGroup.setAlpha(0.0f);
        this.mScoreGroup.setAlpha(1.0f);
        this.mScoreNumberView.setAlpha(0.0f);
        this.mScoreNumberViewFull.setAlpha(0.0f);
        this.mScoreText.setVisibility(8);
        this.mCleaningText.setVisibility(0);
        this.mCleaningText.animate().alpha(1.0f).setDuration(300).start();
        this.mProgressNumberView.setScrollNumberListener(new AnonymousClass11(this));
        RotateListener r18 = this.mRotateListener;
        if (r18 == null) goto L32;
        r18.onCleanStart();
        return;
    L32:
        return;
    L5:
        if (this.mState == State.SCAN_END) goto L7;
    }

    public void startOptimizeFromScore(final int score) {
        this.mRotatePannelView.post(new AnonymousClass12(this, score));
    }

    public void finishOptimizeToScore(final int score, final boolean showScoreAction) {
        this.mRotatePannelView.post(new AnonymousClass13(this, score, showScoreAction));
    }

    private void applyOptimizeResultByState(int score, boolean showScoreAction) {
        int r0 = AnonymousClass18.$SwitchMap$com$obric$security$mainpage$view$RotatePannelManager2$State[this.mState.ordinal()];
        if (r0 != 2) goto L5;
    L13:
        updateResultScoreToInternal(score, showScoreAction);
        return;
    L5:
        if (r0 == 3) goto L13;
        if (r0 != 4) goto L9;
        finishOptimizeToScoreInternal(score, showScoreAction);
        return;
    L9:
        if (r0 == 5) goto L11;
        OLog.i("HealthScore", log("finishOptimizeToScore ignored state=" + this.mState));
        return;
    L11:
        showResultScoreInternal(score, showScoreAction);
    }

    public void updateResultScoreTo(final int score, final boolean showScoreAction) {
        this.mRotatePannelView.post(new AnonymousClass14(this, score, showScoreAction));
    }

    private void showResultScoreInternal(int score, boolean showScoreAction) {
        this.mShowScoreActionOnCleanEnd = showScoreAction;
        updateScore(score);
        showCleanEndState();
    }

    private void updateResultScoreToInternal(int score, boolean showScoreAction) {
        if (this.mState != State.SCAN_END) goto L5;
    L8:
        int r0 = this.mScore;
        this.mShowScoreActionOnCleanEnd = showScoreAction;
        this.mShowScoreActionOnScanEnd = showScoreAction;
        updateScore(score);
        this.mScoreGroup.setAlpha(1.0f);
        this.mScanningGroup.setAlpha(0.0f);
        this.mCleaningText.setVisibility(8);
        this.mCleanDoneImgView.setVisibility(8);
        applyScoreActionVisible(showScoreAction);
        applyResultScoreNumberVisibility();
        applyResultAnimationStartVisuals(r0);
        OLog.i("HealthScore", log("updateResultScore oldScore=" + r0 + " newScore=" + this.mScore + " showScoreAction=" + showScoreAction));
        if (r0 != this.mScore) goto L12;
        applyFinalScoreState();
        return;
    L12:
        animateResultScore(r0);
        return;
    L5:
        if (this.mState == State.CLEAN_END) goto L8;
        OLog.i("HealthScore", log("updateResultScore ignored state=" + this.mState + " targetScore=" + score));
    }

    private void animateResultScore(int oldScore) {
        Resources r0 = this.mProgressNumberView.getResources();
        float r1 = scoreProgress(this.mScore);
        int r2 = getResultRingColor(r1, r0);
        ScrollingNumbersView r3 = getResultScoreNumberView();
        this.mScoreNumberView.cancelNumberAnimator();
        this.mScoreNumberViewFull.cancelNumberAnimator();
        r3.setInitialValue(oldScore);
        r3.setNumberAnimatorValues(new int[]{this.mScore});
        r3.setNumberAnimatorDuration(800);
        r3.startNumberAnimator();
        applyScoreNumberColor(r2, true);
        updateScoreActionStyle(r1, r0);
        animateRingProgressToScore(r2);
    }

    private void finishOptimizeToScoreInternal(int score, boolean showScoreAction) {
        this.mShowScoreActionOnCleanEnd = showScoreAction;
        updateScore(score);
        OLog.i("HealthScore", log("finishOptimizeToScoreInternal state=" + this.mState + " score=" + this.mScore + " showScoreAction=" + showScoreAction));
        if (this.mState != State.CLEANING) goto L6;
        stopTickHeightScaleAnimation();
        this.mProgressNumberView.cancelNumberAnimator();
        afterClean();
        return;
    }

    private void showCleanEndState() {
        stopTickHeightScaleAnimation();
        this.mProgressNumberView.cancelNumberAnimator();
        enterCleanEndState();
        applyFinalScoreState();
    }

    private void afterClean() {
        if (this.mAfterCleanStarted == false) goto L5;
        return;
    L5:
        this.mAfterCleanStarted = true;
        OLog.i("HealthScore", log("afterClean"));
        this.mRotatePannelView.onCleanEnd();
        this.mScoreNumberView.setInitialValue(this.mScore);
        this.mScoreNumberViewFull.setInitialValue(this.mScore);
        this.mCleaningText.setVisibility(8);
        this.progressBar.setScaleAnimationState(false);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleX", new float[]{0.0f, 1.12f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleY", new float[]{0.0f, 1.12f});
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleX", new float[]{1.12f, 1.0f});
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleY", new float[]{1.12f, 1.0f});
        AnimatorSet r12 = new AnimatorSet();
        r12.setDuration(200);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleX", new float[]{1.0f, 1.16f});
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "scaleY", new float[]{1.0f, 1.16f});
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mCleanDoneImgView, "alpha", new float[]{1.0f, 0.0f});
        final AnimatorSet r15 = new AnimatorSet();
        r15.setDuration(400);
        r15.setInterpolator(this.mInterpolator);
        r15.playTogether(new Animator[]{r13, r14, r1});
        final ScrollingNumbersView r3 = getResultScoreNumberView();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r3, "scaleX", new float[]{0.95f, 1.0f});
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r3, "scaleY", new float[]{0.95f, 1.0f});
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{0.0f, 1.0f});
        final AnimatorSet r16 = new AnimatorSet();
        r16.setDuration(400);
        r16.playTogether(new Animator[]{r6, r8, r10});
        r16.setInterpolator(this.mInterpolator);
        r16.addListener(this.mCleanAnimationListener);
        r15.addListener(new AnonymousClass15(this, r16));
        r12.addListener(new AnonymousClass16(this, r3, r15));
        r12.playTogether(new Animator[]{r9, r11});
        this.mCleanDoneImgView.setVisibility(0);
        AnimatorSet r4 = new AnimatorSet();
        r4.setDuration(300);
        r4.play(r7).with(r2).with(r5).before(r12);
        r4.setInterpolator(this.mInterpolator);
        r4.start();
    }

    private void applyFinalScoreState() {
        applyScoreVisuals(this.mScore, true, true, true);
    }

    private ScrollingNumbersView getResultScoreNumberView() {
        if (shouldShowScoreAction(this.mShowScoreActionOnCleanEnd) == false) goto L6;
        return this.mScoreNumberView;
    L6:
        return this.mScoreNumberViewFull;
    }

    private void applyResultScoreNumberVisibility() {
        boolean r0 = shouldShowScoreAction(this.mShowScoreActionOnCleanEnd);
        ScrollingNumbersView r1 = this.mScoreNumberView;
        float r2 = 1.0f;
        if (r0 == false) goto L5;
        float r4 = 1.0f;
    L6:
        r1.setAlpha(r4);
        ScrollingNumbersView r5 = this.mScoreNumberViewFull;
        if (r0 == false) goto L9;
        r2 = 0.0f;
    L9:
        r5.setAlpha(r2);
        return;
    L5:
        r4 = 0.0f;
        goto L6
    }

    private int applyScoreVisuals(int ringProgress, boolean includeFullScore, boolean finalDotState, boolean updateActionStyle) {
        Resources r0 = this.mProgressNumberView.getResources();
        float r1 = scoreProgress(this.mScore);
        int r2 = getResultRingColor(r1, r0);
        applyRingState(ringProgress, r2, finalDotState);
        applyScoreNumberValues();
        applyScoreNumberColor(r2, includeFullScore);
        if (updateActionStyle == false) goto L5;
        updateScoreActionStyle(r1, r0);
    L5:
        return r2;
    }

    private int applyResultAnimationStartVisuals(int ringProgress) {
        Resources r0 = this.mProgressNumberView.getResources();
        float r1 = scoreProgress(this.mScore);
        int r2 = getResultRingColor(r1, r0);
        applyRingState(ringProgress, r2, true);
        applyScoreNumberColor(r2, true);
        updateScoreActionStyle(r1, r0);
        return r2;
    }

    private void animateRingProgressToScore(int color) {
        this.progressBar.setDotColor(color);
        GlowDotRingProg r4 = this.progressBar;
        ObjectAnimator r5 = ObjectAnimator.ofInt(r4, "progress", new int[]{r4.getProgress(), this.mScore}).setDuration(800);
        r5.setInterpolator(this.mInterpolator);
        r5.start();
    }

    private void applyScoreNumberValues() {
        this.mScoreNumberView.setInitialValue(this.mScore);
        this.mScoreNumberViewFull.setInitialValue(this.mScore);
    }

    private void applyScoreNumberColor(int color, boolean includeFullScore) {
        this.mScoreNumberView.onColorUpdate(color);
        if (includeFullScore == false) goto L6;
        this.mScoreNumberViewFull.onColorUpdate(color);
        return;
    }

    private void applyRingState(int progress, int color, boolean finalDotState) {
        this.progressBar.setmProgressmax(this.mMaxScore);
        this.progressBar.setProgress(clampScore(progress));
        this.progressBar.setDotColor(color);
        if (finalDotState == false) goto L6;
        this.progressBar.setScaleAnimationState(false);
        this.progressBar.setDotRadius(1.0f);
        return;
    }

    private int clampScore(int score) {
        return Math.max(0, Math.min(score, this.mMaxScore));
    }

    private float scoreProgress(int score) {
        if (this.mMaxScore > 0) goto L7;
        return 0.0f;
    L7:
        return clampScore(score) / this.mMaxScore;
    }

    private void updateScoreActionStyle(float finalProgress, Resources res) {
        if (this.mScoreText != null) goto L5;
        return;
    L5:
        int r0 = getResultRingColorByProgress(finalProgress, res);
        int r2 = getScoreActionBackgroundColorByProgress(finalProgress, res);
        this.mScoreText.setTextColor(r0);
        this.mScoreText.setBackgroundColor(r2);
    }

    public void setRotateListener(RotateListener listener) {
        this.mRotateListener = listener;
    }

    public void setScoreClickListener(View.OnClickListener listener) {
        this.mScoreClickListener = listener;
    }

    public void onDestory() {
        stopTickHeightScaleAnimation();
        this.mRotatePannelView.onDestory();
    }

    private static String log(String message) {
        return "source=RotatePannelManager " + message;
    }
}
