package com.bytedanceos.rotateview;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.securitycenter.MainActivityTemp;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class RotatePannel extends FrameLayout {
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
    private static final String TAG = "RotatePannel";
    public static final int YELLOW = -18650;
    private Animator.AnimatorListener mAlphaAnimationListener;
    private Animator.AnimatorListener mCleanAnimationListener;
    private ImageView mCleanDoneImgView;
    private ColorAnimateHelper mColorAnimateHelper;
    private ColorAnimateHelper.ColorUpdateListener mColorUpdateListener;
    private int mMaxScore;
    private ScrollingNumbersView mProgressNumberView;
    private RatateDataFactory mRatateDataFactory;
    private RotateFanView mRotateFanView;
    private RotateListener mRotateListener;
    private Animator.AnimatorListener mScanAnimationListener;
    private ViewGroup mScanningGroup;
    private ImageView mScanningPieView;
    private TextView mScanningText;
    private int mScore;
    private ViewGroup mScoreGroup;
    private ScrollingNumbersView mScoreNumberView;
    private TextView mScoreText;
    private boolean mSkipClean;
    private volatile State mState;

    public class PauseData {
        public int[] newDatas;
        public List<Integer> puaseDatas;
        final /* synthetic */ RotatePannel this$0;

        public PauseData(final RotatePannel this$0) {
            this.this$0 = this$0;
            this.puaseDatas = new ArrayList();
        }
    }

    private class RatateDataFactory {
        final /* synthetic */ RotatePannel this$0;

        private RatateDataFactory(final RotatePannel this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ RatateDataFactory(RotatePannel r1, AnonymousClass1 r2) {
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

    static /* synthetic */ ImageView access$000(RotatePannel r0) {
        return r0.mScanningPieView;
    }

    static /* synthetic */ TextView access$100(RotatePannel r0) {
        return r0.mScanningText;
    }

    static /* synthetic */ RotateListener access$1000(RotatePannel r0) {
        return r0.mRotateListener;
    }

    static /* synthetic */ boolean access$1100(RotatePannel r0) {
        return r0.mSkipClean;
    }

    static /* synthetic */ Animator.AnimatorListener access$1200(RotatePannel r0) {
        return r0.mAlphaAnimationListener;
    }

    static /* synthetic */ ViewGroup access$1300(RotatePannel r0) {
        return r0.mScanningGroup;
    }

    static /* synthetic */ Animator.AnimatorListener access$1400(RotatePannel r0) {
        return r0.mScanAnimationListener;
    }

    static /* synthetic */ ViewGroup access$1500(RotatePannel r0) {
        return r0.mScoreGroup;
    }

    static /* synthetic */ RotateFanView access$1600(RotatePannel r0) {
        return r0.mRotateFanView;
    }

    static /* synthetic */ ColorAnimateHelper access$1700(RotatePannel r0) {
        return r0.mColorAnimateHelper;
    }

    static /* synthetic */ ImageView access$1800(RotatePannel r0) {
        return r0.mCleanDoneImgView;
    }

    static /* synthetic */ Animator.AnimatorListener access$1900(RotatePannel r0) {
        return r0.mCleanAnimationListener;
    }

    static /* synthetic */ TextView access$200(RotatePannel r0) {
        return r0.mScoreText;
    }

    static /* synthetic */ void access$2000(RotatePannel r0) {
        r0.setColor();
    }

    static /* synthetic */ State access$400(RotatePannel r0) {
        return r0.mState;
    }

    static /* synthetic */ State access$402(RotatePannel r0, State r1) {
        r0.mState = r1;
        return r1;
    }

    static /* synthetic */ int access$500(RotatePannel r0) {
        return r0.mScore;
    }

    static /* synthetic */ int access$600(RotatePannel r0) {
        return r0.mMaxScore;
    }

    static /* synthetic */ void access$700(RotatePannel r0) {
        r0.forceFinish();
    }

    static /* synthetic */ ScrollingNumbersView access$800(RotatePannel r0) {
        return r0.mScoreNumberView;
    }

    static /* synthetic */ ScrollingNumbersView access$900(RotatePannel r0) {
        return r0.mProgressNumberView;
    }

    static {
        SCAN_DATA = new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 99, 100};
    }

    public RotatePannel(Context context) {
        this(context, null);
    }

    public RotatePannel(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotatePannel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
        this.mState = State.NONE;
        this.mScore = 0;
        this.mSkipClean = false;
        this.mMaxScore = 100;
        this.mColorUpdateListener = new AnonymousClass1(this);
        this.mScanAnimationListener = new AnonymousClass9(this);
        this.mCleanAnimationListener = new AnonymousClass10(this);
        this.mAlphaAnimationListener = new AnonymousClass11(this);
        init(context);
    }

    private void init(Context context) {
        this.mRatateDataFactory = new RatateDataFactory(this, null);
        View r3 = LayoutInflater.from(context).inflate(R.layout.rotate_pannel_layout, this, true);
        this.mScanningGroup = (ViewGroup) r3.findViewById(R.id.scanning_group);
        this.mScoreGroup = (ViewGroup) r3.findViewById(R.id.score_group);
        this.mRotateFanView = (RotateFanView) r3.findViewById(R.id.rotate_fan);
        this.mScanningPieView = (ImageView) r3.findViewById(R.id.scanning_pie);
        this.mProgressNumberView = (ScrollingNumbersView) r3.findViewById(R.id.scanning_progress);
        this.mScanningText = (TextView) r3.findViewById(R.id.scanning_text);
        this.mScoreNumberView = (ScrollingNumbersView) r3.findViewById(R.id.score_number);
        this.mScoreText = (TextView) r3.findViewById(R.id.score_text);
        this.mCleanDoneImgView = (ImageView) r3.findViewById(R.id.clean_done_image);
        ColorAnimateHelper r4 = new ColorAnimateHelper();
        this.mColorAnimateHelper = r4;
        r4.addListener(this.mRotateFanView);
        this.mColorAnimateHelper.addListener(this.mProgressNumberView);
        this.mColorAnimateHelper.addListener(this.mScoreNumberView);
        this.mColorAnimateHelper.addListener(this.mColorUpdateListener);
        this.mColorAnimateHelper.setColor(-8618880);
        this.mScoreNumberView.setShowSubTextByLanguage(true);
        this.mScoreGroup.setOnClickListener(new AnonymousClass2(this));
        this.mScoreNumberView.setScrollNumberListener(new AnonymousClass3(this));
        this.mScoreNumberView.setOnTouchListener(new AnonymousClass4(this));
    }

    private void prepare() {
        this.mScanningGroup.setAlpha(1.0f);
        this.mScoreGroup.setAlpha(0.0f);
        this.mScanningText.setAlpha(0.0f);
        this.mCleanDoneImgView.setAlpha(0.0f);
        this.mCleanDoneImgView.setScaleX(0.0f);
        this.mCleanDoneImgView.setScaleY(0.0f);
        this.mProgressNumberView.setAlpha(0.0f);
        this.mProgressNumberView.setNeedPause(true);
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

    private void forceFinish() {
        this.mState = State.CLEAN_END;
        this.mScoreText.setVisibility(8);
        this.mScoreGroup.setOnClickListener(null);
    }

    public void scan() {
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
        this.mColorAnimateHelper.getColorAnimator().setIntValues(new int[]{-8618880, -14322203, -18650, -355840, -2085587});
        long r7 = (-500) + r3;
        this.mColorAnimateHelper.getColorAnimator().setDuration(r7);
        this.mColorAnimateHelper.getColorAnimator().start();
        this.mRotateFanView.setRotateAnimatorDuration(r7);
        this.mRotateFanView.startRotateAnimator(true);
        this.mProgressNumberView.setInitialValue(r1[0]);
        this.mProgressNumberView.addPauseNumber(r0.puaseDatas);
        this.mProgressNumberView.setNumberAnimatorValues(r1);
        this.mProgressNumberView.setNumberAnimatorDuration(r3);
        this.mProgressNumberView.animate().alpha(1.0f).setDuration(300).setListener(new AnonymousClass5(this)).start();
        this.mScanningText.setText(R.string.scaning);
        this.mScanningText.animate().alpha(1.0f).setDuration(300).start();
        this.mProgressNumberView.setScrollNumberListener(new AnonymousClass6(this));
    }

    public void setScore(int score) {
        int r0 = this.mScore;
        boolean r4 = updateScore(score);
        if (this.mState != State.CLEAN_END) goto L5;
    L11:
        int[] r5 = {r0, this.mScore};
        if (this.mState != State.SCAN_END) goto L14;
    L17:
        this.mScoreNumberView.setInitialValue(this.mScore);
    L18:
        setColor();
        return;
    L14:
        if (this.mState == State.CLEAN_END) goto L17;
        this.mScoreNumberView.setInitialValue(r0);
        this.mScoreNumberView.setNumberAnimatorValues(r5);
        this.mScoreNumberView.setNumberAnimatorDuration(200);
        this.mScoreNumberView.startNumberAnimator();
        goto L18
    L5:
        if (this.mState == State.SCAN_END) goto L11;
        if (this.mState != State.SCANNING) goto L20;
        if (r4 == false) goto L21;
        skipClean();
        return;
    L21:
        return;
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

    public void clean() {
        if (this.mState == State.SCAN_END) goto L5;
        return;
    L5:
        this.mState = State.CLEANING;
        prepare();
        PauseData r0 = this.mRatateDataFactory.generatePauseData(SCAN_DATA);
        if (r0 != null) goto L8;
        return;
    L8:
        int[] r1 = r0.newDatas;
        long r3 = Math.abs(r1[0] - r1[r1.length - 1]) * 100;
        long r5 = (-500) + r3;
        this.mColorAnimateHelper.getColorAnimator().setIntValues(new int[]{-2085587, -355840, -18650, -14322203});
        this.mColorAnimateHelper.getColorAnimator().setDuration(r5);
        this.mColorAnimateHelper.getColorAnimator().start();
        this.mRotateFanView.setRotateAnimatorDuration(r5 + 2000);
        this.mRotateFanView.startRotateAnimator(false);
        this.mProgressNumberView.setInitialValue(r1[0]);
        this.mProgressNumberView.addPauseNumber(r0.puaseDatas);
        this.mProgressNumberView.setNumberAnimatorValues(r1);
        this.mProgressNumberView.setNumberAnimatorDuration(r3);
        this.mProgressNumberView.animate().alpha(1.0f).setDuration(300).setListener(new AnonymousClass7(this)).start();
        this.mScanningText.animate().alpha(1.0f).setDuration(300).start();
        this.mScanningText.setText(R.string.cleaning);
        this.mProgressNumberView.setScrollNumberListener(new AnonymousClass8(this));
        RotateListener r10 = this.mRotateListener;
        if (r10 == null) goto L12;
        r10.onCleanStart();
        return;
    }

    private void setColor() {
        int r0 = this.mScore;
        if (r0 >= 60) goto L6;
        this.mColorAnimateHelper.setColor(-2085587);
        return;
    L6:
        if (r0 >= 85) goto L8;
        this.mColorAnimateHelper.setColor(-18650);
        return;
    L8:
        this.mColorAnimateHelper.setColor(-14322203);
    }

    public void onDestory() {
        this.mColorAnimateHelper.destory();
        this.mProgressNumberView.destory();
        this.mRotateFanView.destory();
    }

    public void setRotateListener(RotateListener listener) {
        this.mRotateListener = listener;
    }
}
