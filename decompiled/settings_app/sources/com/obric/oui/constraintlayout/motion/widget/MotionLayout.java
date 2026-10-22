package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.utils.HanziToPinyin;
import com.android.vcard.VCardConstants;
import com.obric.oui.constraintlayout.core.motion.utils.KeyCache;
import com.obric.oui.constraintlayout.core.widgets.Barrier;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.Flow;
import com.obric.oui.constraintlayout.core.widgets.Guideline;
import com.obric.oui.constraintlayout.core.widgets.Helper;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;
import com.obric.oui.constraintlayout.core.widgets.Placeholder;
import com.obric.oui.constraintlayout.core.widgets.VirtualLayout;
import com.obric.oui.constraintlayout.motion.utils.StopLogic;
import com.obric.oui.constraintlayout.motion.utils.ViewState;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.ConstraintSet;
import com.obric.oui.constraintlayout.widget.Constraints;
import com.obric.oui.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: loaded from: classes4.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private DecelerateInterpolator mDecelerateLogic;
    private ArrayList<MotionHelper> mDecoratorsHelpers;
    private boolean mDelayedApply;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    boolean mFirstDown;
    HashMap<View, MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    private boolean mInRotation;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    private Matrix mInverseMatrix;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    private float mLastPos;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mLastY;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private Runnable mOnComplete;
    private ArrayList<MotionHelper> mOnHideHelpers;
    private ArrayList<MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    HashMap<View, ViewState> mPreRotate;
    private int mPreRotateHeight;
    private int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator;
    private View mRegionView;
    int mRotatMode;
    MotionScene mScene;
    private int[] mScheduledTransitionTo;
    int mScheduledTransitions;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic;
    Rect mTempRect;
    private boolean mTemporalInterpolator;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private CopyOnWriteArrayList<TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.motion.widget.MotionLayout$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$motion$widget$MotionLayout$TransitionState = null;

        static {
            int[] r0 = new int[TransitionState.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$motion$widget$MotionLayout$TransitionState = r0;
            r0[TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$oui$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$oui$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$oui$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    class DecelerateInterpolator extends MotionInterpolator {
        float mCurrentP;
        float mInitialV;
        float mMaxA;
        final /* synthetic */ MotionLayout this$0;

        DecelerateInterpolator(MotionLayout r1) {
            this.this$0 = r1;
            this.mInitialV = 0.0f;
            this.mCurrentP = 0.0f;
        }

        public void config(float r1, float r2, float r3) {
            this.mInitialV = r1;
            this.mCurrentP = r2;
            this.mMaxA = r3;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float r5) {
            float r0 = this.mInitialV;
            if (r0 <= 0.0f) goto L10;
            float r1 = this.mMaxA;
            if ((r0 / r1) >= r5) goto L7;
            r5 = r0 / r1;
        L7:
            float r2 = r0 - (r1 * r5);
            this.this$0.mLastVelocity = r2;
            float r3 = (this.mInitialV * r5) - (((this.mMaxA * r5) * r5) / 2.0f);
            float r4 = this.mCurrentP;
        L9:
            return r3 + r4;
        L10:
            float r6 = this.mMaxA;
            if (((-r0) / r6) >= r5) goto L13;
            r5 = (-r0) / r6;
        L13:
            float r7 = r0 + (r6 * r5);
            this.this$0.mLastVelocity = r7;
            r3 = (this.mInitialV * r5) + (((this.mMaxA * r5) * r5) / 2.0f);
            r4 = this.mCurrentP;
            goto L9
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return this.this$0.mLastVelocity;
        }
    }

    private class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        Rect mBounds;
        DashPathEffect mDashPathEffect;
        final int mDiamondSize;
        Paint mFillPaint;
        final int mGraphColor;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        final int mKeyframeColor;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        boolean mPresentationMode;
        private float[] mRectangle;
        final int mRedColor;
        final int mShadowColor;
        int mShadowTranslate;
        Paint mTextPaint;
        final /* synthetic */ MotionLayout this$0;

        DevModeDraw(MotionLayout r7) {
            this.this$0 = r7;
            this.mRedColor = -21965;
            this.mKeyframeColor = -2067046;
            this.mGraphColor = -13391360;
            this.mShadowColor = 1996488704;
            this.mDiamondSize = 10;
            this.mBounds = new Rect();
            this.mPresentationMode = false;
            this.mShadowTranslate = 1;
            Paint r4 = new Paint();
            this.mPaint = r4;
            r4.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(Paint.Style.STROKE);
            Paint r0 = new Paint();
            this.mPaintKeyframes = r0;
            r0.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
            Paint r1 = new Paint();
            this.mPaintGraph = r1;
            r1.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(Paint.Style.STROKE);
            Paint r2 = new Paint();
            this.mTextPaint = r2;
            r2.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(r7.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint r8 = new Paint();
            this.mFillPaint = r8;
            r8.setAntiAlias(true);
            DashPathEffect r9 = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = r9;
            this.mPaintGraph.setPathEffect(r9);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode == false) goto L6;
            this.mPaint.setStrokeWidth(8.0f);
            this.mFillPaint.setStrokeWidth(8.0f);
            this.mPaintKeyframes.setStrokeWidth(8.0f);
            this.mShadowTranslate = 4;
            return;
        }

        public void draw(Canvas r6, HashMap<View, MotionController> r7, int r8, int r9) {
            if (r7 != null) goto L4;
            return;
        L4:
            if (r7.size() == 0) goto L42;
            r6.save();
            if (this.this$0.isInEditMode() == false) goto L9;
        L11:
            Iterator<MotionController> r10 = r7.values().iterator();
        L13:
            if (r10.hasNext() == false) goto L30;
            MotionController r0 = r10.next();
            int r1 = r0.getDrawPath();
            if (r9 <= 0) goto L18;
            if (r1 != 0) goto L18;
            r1 = 1;
        L18:
            if (r1 == 0) goto L13;
            this.mKeyFrameCount = r0.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
            if (r1 < 1) goto L13;
            int r2 = r8 / 16;
            float[] r3 = this.mPoints;
            if (r3 != null) goto L25;
        L26:
            this.mPoints = new float[r2 * 2];
            this.mPath = new Path();
        L27:
            int r4 = this.mShadowTranslate;
            r6.translate(r4, r4);
            this.mPaint.setColor(1996488704);
            this.mFillPaint.setColor(1996488704);
            this.mPaintKeyframes.setColor(1996488704);
            this.mPaintGraph.setColor(1996488704);
            r0.buildPath(this.mPoints, r2);
            drawAll(r6, r1, this.mKeyFrameCount, r0);
            this.mPaint.setColor(-21965);
            this.mPaintKeyframes.setColor(-2067046);
            this.mFillPaint.setColor(-2067046);
            this.mPaintGraph.setColor(-13391360);
            int r5 = this.mShadowTranslate;
            r6.translate(-r5, -r5);
            drawAll(r6, r1, this.mKeyFrameCount, r0);
            if (r1 != 5) goto L13;
            drawRectangle(r6, r0);
            goto L13
        L25:
            if (r3.length == (r2 * 2)) goto L27;
        L30:
            r6.restore();
            return;
        L9:
            if ((r9 & 1) != 2) goto L11;
            String r11 = this.this$0.getContext().getResources().getResourceName(MotionLayout.access$100(this.this$0)) + ":" + this.this$0.getProgress();
            r6.drawText(r11, 10.0f, this.this$0.getHeight() - 30, this.mTextPaint);
            r6.drawText(r11, 11.0f, this.this$0.getHeight() - 29, this.mPaint);
            goto L11
        }

        public void drawAll(Canvas r2, int r3, int r4, MotionController r5) {
            if (r3 != 4) goto L6;
            drawPathAsConfigured(r2);
        L6:
            if (r3 != 2) goto L9;
            drawPathRelative(r2);
        L9:
            if (r3 != 3) goto L11;
            drawPathCartesian(r2);
        L11:
            drawBasicPath(r2);
            drawTicks(r2, r3, r4, r5);
        }

        private void drawBasicPath(Canvas r2) {
            r2.drawLines(this.mPoints, this.mPaint);
        }

        private void drawTicks(Canvas r20, int r21, int r22, MotionController r23) {
            if (r23.mView == null) goto L5;
            int r11 = r23.mView.getWidth();
            int r12 = r23.mView.getHeight();
        L6:
            int r14 = 1;
        L8:
            if (r14 >= (r22 - 1)) goto L36;
            if (r21 == 4) goto L12;
        L14:
            float[] r1 = this.mKeyFramePoints;
            int r2 = r14 * 2;
            float r5 = r1[r2];
            float r4 = r1[r2 + 1];
            this.mPath.reset();
            this.mPath.moveTo(r5, r4 + 10.0f);
            this.mPath.lineTo(r5 + 10.0f, r4);
            this.mPath.lineTo(r5, r4 - 10.0f);
            this.mPath.lineTo(r5 - 10.0f, r4);
            this.mPath.close();
            int r3 = r14 - 1;
            r23.getKeyFrame(r3);
            if (r21 != 4) goto L25;
            int r0 = this.mPathMode[r3];
            if (r0 != 1) goto L20;
            drawPathRelativeTicks(r20, r5 - 0.0f, r4 - 0.0f);
        L24:
            r20.drawPath(this.mPath, this.mFillPaint);
        L26:
            if (r21 != 2) goto L29;
            drawPathRelativeTicks(r20, r5 - 0.0f, r4 - 0.0f);
        L29:
            if (r21 != 3) goto L32;
            drawPathCartesianTicks(r20, r5 - 0.0f, r4 - 0.0f);
        L32:
            if (r21 != 6) goto L34;
            drawPathScreenTicks(r20, r5 - 0.0f, r4 - 0.0f, r11, r12);
        L34:
            r20.drawPath(this.mPath, this.mFillPaint);
        L35:
            r14 = r14 + 1;
            goto L8
        L20:
            if (r0 != 0) goto L22;
            drawPathCartesianTicks(r20, r5 - 0.0f, r4 - 0.0f);
            goto L24
        L22:
            if (r0 != 2) goto L24;
            drawPathScreenTicks(r20, r5 - 0.0f, r4 - 0.0f, r11, r12);
            goto L24
        L25:
            r4 = r4;
            r5 = r5;
            goto L26
        L12:
            if (this.mPathMode[r14 - 1] != 0) goto L14;
        L36:
            float[] r6 = this.mPoints;
            if (r6.length <= 1) goto L43;
            r20.drawCircle(r6[0], r6[1], 8.0f, this.mPaintKeyframes);
            float[] r7 = this.mPoints;
            r20.drawCircle(r7[r7.length - 2], r7[r7.length - 1], 8.0f, this.mPaintKeyframes);
            return;
        L43:
            return;
        L5:
            r11 = 0;
            r12 = 0;
            goto L6
        }

        private void drawTranslation(Canvas r8, float r9, float r10, float r11, float r12) {
            r8.drawRect(r9, r10, r11, r12, this.mPaintGraph);
            r8.drawLine(r9, r10, r11, r12, this.mPaintGraph);
        }

        private void drawPathRelative(Canvas r9) {
            float[] r0 = this.mPoints;
            r9.drawLine(r0[0], r0[1], r0[r0.length - 2], r0[r0.length - 1], this.mPaintGraph);
        }

        private void drawPathAsConfigured(Canvas r6) {
            int r0 = 0;
            boolean r1 = false;
            boolean r2 = false;
        L4:
            if (r0 >= this.mKeyFrameCount) goto L11;
            int r3 = this.mPathMode[r0];
            if (r3 != 1) goto L8;
            r1 = true;
        L8:
            if (r3 != 0) goto L10;
            r2 = true;
        L10:
            r0 = r0 + 1;
            goto L4
        L11:
            if (r1 == false) goto L13;
            drawPathRelative(r6);
        L13:
            if (r2 == false) goto L19;
            drawPathCartesian(r6);
            return;
        }

        private void drawPathRelativeTicks(Canvas r13, float r14, float r15) {
            float[] r0 = this.mPoints;
            float r1 = r0[0];
            float r3 = r0[1];
            float r4 = r0[r0.length - 2];
            float r2 = r0[r0.length - 1];
            float r5 = (float) Math.hypot(r1 - r4, r3 - r2);
            float r6 = r4 - r1;
            float r7 = r2 - r3;
            float r8 = (((r14 - r1) * r6) + ((r15 - r3) * r7)) / (r5 * r5);
            float r9 = r1 + (r6 * r8);
            float r10 = r3 + (r8 * r7);
            Path r11 = new Path();
            r11.moveTo(r14, r15);
            r11.lineTo(r9, r10);
            float r12 = (float) Math.hypot(r9 - r14, r10 - r15);
            String r16 = "" + (((int) ((r12 * 100.0f) / r5)) / 100.0f);
            getTextBounds(r16, this.mTextPaint);
            r13.drawTextOnPath(r16, r11, (r12 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            r13.drawLine(r14, r15, r9, r10, this.mPaintGraph);
        }

        void getTextBounds(String r3, Paint r4) {
            r4.getTextBounds(r3, 0, r3.length(), this.mBounds);
        }

        private void drawPathCartesian(Canvas r19) {
            float[] r1 = this.mPoints;
            float r2 = r1[0];
            float r4 = r1[1];
            float r5 = r1[r1.length - 2];
            float r3 = r1[r1.length - 1];
            r19.drawLine(Math.min(r2, r5), Math.max(r4, r3), Math.max(r2, r5), Math.max(r4, r3), this.mPaintGraph);
            r19.drawLine(Math.min(r2, r5), Math.min(r4, r3), Math.min(r2, r5), Math.max(r4, r3), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas r19, float r20, float r21) {
            float[] r1 = this.mPoints;
            float r2 = r1[0];
            float r8 = r1[1];
            float r4 = r1[r1.length - 2];
            float r9 = r1[r1.length - 1];
            float r3 = Math.min(r2, r4);
            float r10 = Math.max(r8, r9);
            float r5 = r20 - Math.min(r2, r4);
            float r11 = Math.max(r8, r9) - r21;
            String r6 = "" + (((int) (((double) ((r5 * 100.0f) / Math.abs(r4 - r2))) + 0.5d)) / 100.0f);
            getTextBounds(r6, this.mTextPaint);
            r19.drawText(r6, ((r5 / 2.0f) - (this.mBounds.width() / 2)) + r3, r21 - 20.0f, this.mTextPaint);
            r19.drawLine(r20, r21, Math.min(r2, r4), r21, this.mPaintGraph);
            String r7 = "" + (((int) (((double) ((r11 * 100.0f) / Math.abs(r9 - r8))) + 0.5d)) / 100.0f);
            getTextBounds(r7, this.mTextPaint);
            r19.drawText(r7, r20 + 5.0f, r10 - ((r11 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            r19.drawLine(r20, r21, r20, Math.max(r8, r9), this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas r16, float r17, float r18, int r19, int r20) {
            String r1 = "" + (((int) (((double) (((r17 - (r19 / 2)) * 100.0f) / (this.this$0.getWidth() - r19))) + 0.5d)) / 100.0f);
            getTextBounds(r1, this.mTextPaint);
            r16.drawText(r1, ((r17 / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, r18 - 20.0f, this.mTextPaint);
            r16.drawLine(r17, r18, Math.min(0.0f, 1.0f), r18, this.mPaintGraph);
            String r2 = "" + (((int) (((double) (((r18 - (r20 / 2)) * 100.0f) / (this.this$0.getHeight() - r20))) + 0.5d)) / 100.0f);
            getTextBounds(r2, this.mTextPaint);
            r16.drawText(r2, r17 + 5.0f, 0.0f - ((r18 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            r16.drawLine(r17, r18, r17, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas r7, MotionController r8) {
            this.mPath.reset();
            int r1 = 0;
        L4:
            if (r1 > 50) goto L6;
            r8.buildRect(r1 / 50, this.mRectangle, 0);
            Path r2 = this.mPath;
            float[] r3 = this.mRectangle;
            r2.moveTo(r3[0], r3[1]);
            Path r4 = this.mPath;
            float[] r5 = this.mRectangle;
            r4.lineTo(r5[2], r5[3]);
            Path r6 = this.mPath;
            float[] r9 = this.mRectangle;
            r6.lineTo(r9[4], r9[5]);
            Path r10 = this.mPath;
            float[] r11 = this.mRectangle;
            r10.lineTo(r11[6], r11[7]);
            this.mPath.close();
            r1 = r1 + 1;
            goto L4
        L6:
            this.mPaint.setColor(1140850688);
            r7.translate(2.0f, 2.0f);
            r7.drawPath(this.mPath, this.mPaint);
            r7.translate(-2.0f, -2.0f);
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            r7.drawPath(this.mPath, this.mPaint);
        }
    }

    class Model {
        ConstraintSet mEnd;
        int mEndId;
        ConstraintWidgetContainer mLayoutEnd;
        ConstraintWidgetContainer mLayoutStart;
        ConstraintSet mStart;
        int mStartId;
        final /* synthetic */ MotionLayout this$0;

        Model(MotionLayout r1) {
            this.this$0 = r1;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mStart = null;
            this.mEnd = null;
        }

        void copy(ConstraintWidgetContainer r4, ConstraintWidgetContainer r5) {
            ArrayList<ConstraintWidget> r3 = r4.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> r0 = new HashMap();
            r0.put(r4, r5);
            r5.getChildren().clear();
            r5.copy(r4, r0);
            Iterator<ConstraintWidget> r6 = r3.iterator();
        L4:
            if (r6.hasNext() == false) goto L22;
            ConstraintWidget r1 = r6.next();
            if ((r1 instanceof Barrier) == false) goto L9;
            ConstraintWidget r2 = new Barrier();
        L21:
            r5.add(r2);
            r0.put(r1, r2);
            goto L4
        L9:
            if ((r1 instanceof Guideline) == false) goto L12;
            r2 = new Guideline();
            goto L21
        L12:
            if ((r1 instanceof Flow) == false) goto L15;
            r2 = new Flow();
            goto L21
        L15:
            if ((r1 instanceof Placeholder) == false) goto L18;
            r2 = new Placeholder();
            goto L21
        L18:
            if ((r1 instanceof HelperWidget) == false) goto L20;
            r2 = new HelperWidget();
            goto L21
        L20:
            r2 = new ConstraintWidget();
            goto L21
        L22:
            Iterator<ConstraintWidget> r7 = r3.iterator();
        L24:
            if (r7.hasNext() == false) goto L26;
            ConstraintWidget r8 = r7.next();
            r0.get(r8).copy(r8, r0);
            goto L24
        }

        void initFrom(ConstraintWidgetContainer r5, ConstraintSet r6, ConstraintSet r7) {
            this.mStart = r6;
            this.mEnd = r7;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.access$400(this.this$0).getMeasurer());
            this.mLayoutEnd.setMeasurer(MotionLayout.access$500(this.this$0).getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(MotionLayout.access$600(this.this$0), this.mLayoutStart);
            copy(MotionLayout.access$700(this.this$0), this.mLayoutEnd);
            if (this.this$0.mTransitionLastPosition <= 0.5d) goto L7;
            if (r6 == null) goto L6;
            setupConstraintWidget(this.mLayoutStart, r6);
        L6:
            setupConstraintWidget(this.mLayoutEnd, r7);
        L10:
            this.mLayoutStart.setRtl(MotionLayout.access$800(this.this$0));
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.access$900(this.this$0));
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams r8 = this.this$0.getLayoutParams();
            if (r8 != null) goto L13;
            return;
        L13:
            if (r8.width != (-2)) goto L16;
            this.mLayoutStart.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            this.mLayoutEnd.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        L16:
            if (r8.height != (-2)) goto L20;
            this.mLayoutStart.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            this.mLayoutEnd.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        L20:
            return;
        L7:
            setupConstraintWidget(this.mLayoutEnd, r7);
            if (r6 == null) goto L10;
            setupConstraintWidget(this.mLayoutStart, r6);
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(ConstraintWidgetContainer r13, ConstraintSet r14) {
            SparseArray<ConstraintWidget> r6 = new SparseArray();
            Constraints.LayoutParams r7 = new Constraints.LayoutParams(-2, -2);
            r6.clear();
            r6.put(0, r13);
            r6.put(this.this$0.getId(), r13);
            if (r14 != null) goto L5;
        L7:
            Iterator<ConstraintWidget> r0 = r13.getChildren().iterator();
        L9:
            if (r0.hasNext() == false) goto L11;
            ConstraintWidget r1 = r0.next();
            r1.setAnimated(true);
            r6.put(((View) r1.getCompanionWidget()).getId(), r1);
            goto L9
        L11:
            Iterator<ConstraintWidget> r9 = r13.getChildren().iterator();
        L13:
            if (r9.hasNext() == false) goto L23;
            ConstraintWidget r10 = r9.next();
            View r11 = (View) r10.getCompanionWidget();
            r14.applyToLayoutParams(r11.getId(), r7);
            r10.setWidth(r14.getWidth(r11.getId()));
            r10.setHeight(r14.getHeight(r11.getId()));
            if ((r11 instanceof ConstraintHelper) == false) goto L19;
            r14.applyToHelper((ConstraintHelper) r11, r10, r7, r6);
            if ((r11 instanceof com.obric.oui.constraintlayout.widget.Barrier) == false) goto L19;
            ((com.obric.oui.constraintlayout.widget.Barrier) r11).validateParams();
        L19:
            r7.resolveLayoutDirection(this.this$0.getLayoutDirection());
            MotionLayout.access$1100(this.this$0, false, r11, r10, r7, r6);
            if (r14.getVisibilityMode(r11.getId()) == 1) goto L21;
            r10.setVisibility(r14.getVisibility(r11.getId()));
            goto L13
        L21:
            r10.setVisibility(r11.getVisibility());
            goto L13
        L23:
            Iterator<ConstraintWidget> r12 = r13.getChildren().iterator();
        L25:
            if (r12.hasNext() == false) goto L29;
            ConstraintWidget r15 = r12.next();
            if ((r15 instanceof VirtualLayout) == false) goto L25;
            ConstraintHelper r2 = (ConstraintHelper) r15.getCompanionWidget();
            Helper r16 = (Helper) r15;
            r2.updatePreLayout(r13, r16, r6);
            ((VirtualLayout) r16).captureWidgets();
            goto L25
        L29:
            return;
        L5:
            if (r14.mRotate == 0) goto L7;
            MotionLayout r3 = this.this$0;
            MotionLayout.access$1000(r3, this.mLayoutEnd, r3.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(this.this$0.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.this$0.getWidth(), 1073741824));
            goto L7
        }

        ConstraintWidget getWidget(ConstraintWidgetContainer r4, View r5) {
            if (r4.getCompanionWidget() != r5) goto L5;
            return r4;
        L5:
            ArrayList<ConstraintWidget> r3 = r4.getChildren();
            int r6 = r3.size();
            int r0 = 0;
        L6:
            if (r0 >= r6) goto L11;
            ConstraintWidget r1 = r3.get(r0);
            if (r1.getCompanionWidget() == r5) goto L9;
            r0 = r0 + 1;
            goto L6
        L9:
            return r1;
        L11:
            return null;
        }

        private void debugLayoutParam(String r4, ConstraintLayout.LayoutParams r5) {
            if (r5.startToStart == (-1)) goto L5;
            String r3 = "SS";
        L6:
            StringBuilder r6 = new StringBuilder().append(HanziToPinyin.Token.SEPARATOR.concat(r3));
            String r2 = "|__";
            if (r5.startToEnd == (-1)) goto L9;
            String r1 = "|SE";
        L10:
            StringBuilder r7 = new StringBuilder().append(r6.append(r1).toString());
            if (r5.endToStart == (-1)) goto L13;
            String r8 = "|ES";
        L14:
            StringBuilder r9 = new StringBuilder().append(r7.append(r8).toString());
            if (r5.endToEnd == (-1)) goto L17;
            String r10 = "|EE";
        L18:
            StringBuilder r11 = new StringBuilder().append(r9.append(r10).toString());
            if (r5.leftToLeft == (-1)) goto L21;
            String r12 = "|LL";
        L22:
            StringBuilder r13 = new StringBuilder().append(r11.append(r12).toString());
            if (r5.leftToRight == (-1)) goto L25;
            String r14 = "|LR";
        L26:
            StringBuilder r15 = new StringBuilder().append(r13.append(r14).toString());
            if (r5.rightToLeft == (-1)) goto L29;
            String r16 = "|RL";
        L30:
            StringBuilder r17 = new StringBuilder().append(r15.append(r16).toString());
            if (r5.rightToRight == (-1)) goto L33;
            String r18 = "|RR";
        L34:
            StringBuilder r19 = new StringBuilder().append(r17.append(r18).toString());
            if (r5.topToTop == (-1)) goto L37;
            String r20 = "|TT";
        L38:
            StringBuilder r21 = new StringBuilder().append(r19.append(r20).toString());
            if (r5.topToBottom == (-1)) goto L41;
            String r22 = "|TB";
        L42:
            StringBuilder r23 = new StringBuilder().append(r21.append(r22).toString());
            if (r5.bottomToTop == (-1)) goto L45;
            String r24 = "|BT";
        L46:
            StringBuilder r25 = new StringBuilder().append(r23.append(r24).toString());
            if (r5.bottomToBottom == (-1)) goto L49;
            r2 = "|BB";
        L49:
            Log.v(MotionLayout.TAG, r4 + r25.append(r2).toString());
            return;
        L45:
            r24 = "|__";
            goto L46
        L41:
            r22 = "|__";
            goto L42
        L37:
            r20 = "|__";
            goto L38
        L33:
            r18 = "|__";
            goto L34
        L29:
            r16 = "|__";
            goto L30
        L25:
            r14 = "|__";
            goto L26
        L21:
            r12 = "|__";
            goto L22
        L17:
            r10 = "|__";
            goto L18
        L13:
            r8 = "|__";
            goto L14
        L9:
            r1 = "|__";
            goto L10
        L5:
            r3 = "__";
            goto L6
        }

        private void debugWidget(String r6, ConstraintWidget r7) {
            StringBuilder r5 = new StringBuilder(HanziToPinyin.Token.SEPARATOR);
            ConstraintAnchor r0 = r7.mTop.mTarget;
            String r1 = ExifInterface.GPS_DIRECTION_TRUE;
            String r3 = "__";
            if (r0 != null) goto L5;
            String r2 = "__";
        L10:
            StringBuilder r8 = new StringBuilder().append(r5.append(r2).toString());
            if (r7.mBottom.mTarget != null) goto L13;
            String r4 = "__";
        L18:
            StringBuilder r9 = new StringBuilder().append(r8.append(r4).toString());
            String r10 = "L";
            if (r7.mLeft.mTarget != null) goto L21;
            String r11 = "__";
        L26:
            StringBuilder r12 = new StringBuilder().append(r9.append(r11).toString());
            if (r7.mRight.mTarget != null) goto L29;
        L33:
            Log.v(MotionLayout.TAG, r6 + r12.append(r3).toString() + " ---  " + r7);
            return;
        L29:
            if (r7.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) goto L32;
            r10 = "R";
        L32:
            r3 = "R".concat(r10);
            goto L33
        L21:
            if (r7.mLeft.mTarget.mType != ConstraintAnchor.Type.LEFT) goto L23;
            String r13 = "L";
        L24:
            r11 = "L".concat(r13);
            goto L26
        L23:
            r13 = "R";
            goto L24
        L13:
            if (r7.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) goto L16;
            r1 = VCardConstants.PARAM_ENCODING_B;
        L16:
            r4 = VCardConstants.PARAM_ENCODING_B.concat(r1);
            goto L18
        L5:
            if (r7.mTop.mTarget.mType != ConstraintAnchor.Type.TOP) goto L7;
            String r14 = ExifInterface.GPS_DIRECTION_TRUE;
        L8:
            r2 = ExifInterface.GPS_DIRECTION_TRUE.concat(r14);
            goto L10
        L7:
            r14 = VCardConstants.PARAM_ENCODING_B;
            goto L8
        }

        private void debugLayout(String r10, ConstraintWidgetContainer r11) {
            String r9 = r10 + HanziToPinyin.Token.SEPARATOR + Debug.getName((View) r11.getCompanionWidget());
            Log.v(MotionLayout.TAG, r9 + "  ========= " + r11);
            int r12 = r11.getChildren().size();
            int r2 = 0;
        L3:
            if (r2 >= r12) goto L23;
            String r3 = r9 + "[" + r2 + "] ";
            ConstraintWidget r4 = r11.getChildren().get(r2);
            String r6 = "_";
            if (r4.mTop.mTarget == null) goto L7;
            String r5 = ExifInterface.GPS_DIRECTION_TRUE;
        L8:
            StringBuilder r7 = new StringBuilder().append(r5);
            if (r4.mBottom.mTarget == null) goto L11;
            String r8 = VCardConstants.PARAM_ENCODING_B;
        L12:
            StringBuilder r13 = new StringBuilder().append(r7.append(r8).toString());
            if (r4.mLeft.mTarget == null) goto L15;
            String r14 = "L";
        L16:
            StringBuilder r15 = new StringBuilder().append(r13.append(r14).toString());
            if (r4.mRight.mTarget == null) goto L19;
            r6 = "R";
        L19:
            String r16 = r15.append(r6).toString();
            View r17 = (View) r4.getCompanionWidget();
            String r18 = Debug.getName(r17);
            if ((r17 instanceof TextView) == false) goto L22;
            r18 = r18 + "(" + ((TextView) r17).getText() + ")";
        L22:
            Log.v(MotionLayout.TAG, r3 + BytedanceJustifyTextView.TWO_BLANK + r18 + HanziToPinyin.Token.SEPARATOR + r4 + HanziToPinyin.Token.SEPARATOR + r16);
            r2 = r2 + 1;
            goto L3
        L15:
            r14 = "_";
            goto L16
        L11:
            r8 = "_";
            goto L12
        L7:
            r5 = "_";
            goto L8
        L23:
            Log.v(MotionLayout.TAG, r9 + " done. ");
        }

        public void reEvaluateState() {
            measure(MotionLayout.access$1200(this.this$0), MotionLayout.access$1300(this.this$0));
            MotionLayout.access$1400(this.this$0);
        }

        public void measure(int r14, int r15) {
            int r0 = View.MeasureSpec.getMode(r14);
            int r1 = View.MeasureSpec.getMode(r15);
            this.this$0.mWidthMeasureMode = r0;
            this.this$0.mHeightMeasureMode = r1;
            computeStartEndSize(r14, r15);
            if ((this.this$0.getParent() instanceof MotionLayout) == true) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L18;
            computeStartEndSize(r14, r15);
            this.this$0.mStartWrapWidth = this.mLayoutStart.getWidth();
            this.this$0.mStartWrapHeight = this.mLayoutStart.getHeight();
            this.this$0.mEndWrapWidth = this.mLayoutEnd.getWidth();
            this.this$0.mEndWrapHeight = this.mLayoutEnd.getHeight();
            MotionLayout r3 = this.this$0;
            if (r3.mStartWrapWidth == this.this$0.mEndWrapWidth) goto L13;
        L16:
            boolean r4 = true;
        L17:
            r3.mMeasureDuringTransition = r4;
            goto L18
        L13:
            if (this.this$0.mStartWrapHeight != this.this$0.mEndWrapHeight) goto L16;
            r4 = false;
        L18:
            int r5 = this.this$0.mStartWrapWidth;
            int r6 = this.this$0.mStartWrapHeight;
            if (this.this$0.mWidthMeasureMode != Integer.MIN_VALUE) goto L21;
        L22:
            r5 = (int) (this.this$0.mStartWrapWidth + (this.this$0.mPostInterpolationPosition * (this.this$0.mEndWrapWidth - this.this$0.mStartWrapWidth)));
        L23:
            int r9 = r5;
            if (this.this$0.mHeightMeasureMode != Integer.MIN_VALUE) goto L26;
        L27:
            r6 = (int) (this.this$0.mStartWrapHeight + (this.this$0.mPostInterpolationPosition * (this.this$0.mEndWrapHeight - this.this$0.mStartWrapHeight)));
        L28:
            int r10 = r6;
            if (this.mLayoutStart.isWidthMeasuredTooSmall() == false) goto L31;
        L34:
            boolean r11 = true;
        L36:
            if (this.mLayoutStart.isHeightMeasuredTooSmall() == false) goto L38;
        L41:
            boolean r12 = true;
        L42:
            MotionLayout.access$1500(this.this$0, r14, r15, r9, r10, r11, r12);
            return;
        L38:
            if (this.mLayoutEnd.isHeightMeasuredTooSmall() == true) goto L41;
            r12 = false;
            goto L42
        L31:
            if (this.mLayoutEnd.isWidthMeasuredTooSmall() == true) goto L34;
            r11 = false;
            goto L36
        L26:
            if (this.this$0.mHeightMeasureMode != 0) goto L28;
        L21:
            if (this.this$0.mWidthMeasureMode != 0) goto L23;
        L5:
            if (r0 != 1073741824) goto L8;
            if (r1 != 1073741824) goto L8;
            r2 = false;
            goto L9
        }

        private void computeStartEndSize(int r6, int r7) {
            int r0 = this.this$0.getOptimizationLevel();
            if (this.this$0.mCurrentState != this.this$0.getStartState()) goto L28;
            MotionLayout r1 = this.this$0;
            ConstraintWidgetContainer r2 = this.mLayoutEnd;
            ConstraintSet r3 = this.mEnd;
            if (r3 != null) goto L7;
        L10:
            int r4 = r6;
        L11:
            ConstraintSet r5 = this.mEnd;
            if (r5 != null) goto L14;
        L17:
            int r8 = r7;
        L18:
            MotionLayout.access$1600(r1, r2, r0, r4, r8);
            ConstraintSet r9 = this.mStart;
            if (r9 == null) goto L53;
            MotionLayout r10 = this.this$0;
            ConstraintWidgetContainer r11 = this.mLayoutStart;
            if (r9.mRotate != 0) goto L23;
            int r12 = r6;
        L25:
            if (this.mStart.mRotate != 0) goto L27;
            r6 = r7;
        L27:
            MotionLayout.access$1700(r10, r11, r0, r12, r6);
            return;
        L23:
            r12 = r7;
            goto L25
        L53:
            return;
        L14:
            if (r5.mRotate == 0) goto L17;
            r8 = r6;
            goto L18
        L7:
            if (r3.mRotate == 0) goto L10;
            r4 = r7;
            goto L11
        L28:
            ConstraintSet r13 = this.mStart;
            if (r13 == null) goto L39;
            MotionLayout r14 = this.this$0;
            ConstraintWidgetContainer r15 = this.mLayoutStart;
            if (r13.mRotate != 0) goto L33;
            int r16 = r6;
        L35:
            if (this.mStart.mRotate != 0) goto L37;
            int r17 = r7;
        L38:
            MotionLayout.access$1800(r14, r15, r0, r16, r17);
            goto L39
        L37:
            r17 = r6;
            goto L38
        L33:
            r16 = r7;
        L39:
            MotionLayout r18 = this.this$0;
            ConstraintWidgetContainer r19 = this.mLayoutEnd;
            ConstraintSet r20 = this.mEnd;
            if (r20 != null) goto L42;
        L45:
            int r21 = r6;
        L46:
            ConstraintSet r22 = this.mEnd;
            if (r22 != null) goto L49;
        L50:
            r6 = r7;
        L51:
            MotionLayout.access$1900(r18, r19, r0, r21, r6);
            return;
        L49:
            if (r22.mRotate != 0) goto L51;
        L42:
            if (r20.mRotate == 0) goto L45;
            r21 = r7;
            goto L46
        }

        public void build() {
            int r1 = this.this$0.getChildCount();
            this.this$0.mFrameArrayList.clear();
            SparseArray r2 = new SparseArray();
            int[] r3 = new int[r1];
            int r5 = 0;
        L3:
            if (r5 >= r1) goto L5;
            View r6 = this.this$0.getChildAt(r5);
            MotionController r7 = new MotionController(r6);
            int r8 = r6.getId();
            r3[r5] = r8;
            r2.put(r8, r7);
            this.this$0.mFrameArrayList.put(r6, r7);
            r5 = r5 + 1;
            goto L3
        L5:
            int r9 = 0;
        L6:
            if (r9 >= r1) goto L31;
            View r10 = this.this$0.getChildAt(r9);
            MotionController r13 = this.this$0.mFrameArrayList.get(r10);
            if (r13 != null) goto L11;
            r2 = r2;
        L30:
            r9 = r9 + 1;
            r2 = r2;
            goto L6
        L11:
            if (this.mStart == null) goto L19;
            ConstraintWidget r11 = getWidget(this.mLayoutStart, r10);
            if (r11 == null) goto L16;
            r13.setStartState(MotionLayout.access$2000(this.this$0, r11), this.mStart, this.this$0.getWidth(), this.this$0.getHeight());
        L23:
            if (this.mEnd == null) goto L30;
            ConstraintWidget r12 = getWidget(this.mLayoutEnd, r10);
            if (r12 == null) goto L28;
            r13.setEndState(MotionLayout.access$2000(this.this$0, r12), this.mEnd, this.this$0.getWidth(), this.this$0.getHeight());
            goto L30
        L28:
            if (this.this$0.mDebugPath == 0) goto L30;
            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(r10) + " (" + r10.getClass().getName() + ")");
            goto L30
        L16:
            if (this.this$0.mDebugPath == 0) goto L23;
            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(r10) + " (" + r10.getClass().getName() + ")");
            goto L23
        L19:
            if (MotionLayout.access$300(this.this$0) == false) goto L23;
            r13.setStartState(this.this$0.mPreRotate.get(r10), r10, this.this$0.mRotatMode, MotionLayout.access$2100(this.this$0), MotionLayout.access$2200(this.this$0));
            goto L23
        L31:
            SparseArray r16 = r2;
            int r4 = 0;
        L32:
            if (r4 >= r1) goto L37;
            SparseArray r14 = r16;
            MotionController r0 = (MotionController) r14.get(r3[r4]);
            int r15 = r0.getAnimateRelativeTo();
            if (r15 == (-1)) goto L36;
            r0.setupRelative((MotionController) r14.get(r15));
        L36:
            r4 = r4 + 1;
            r16 = r14;
            goto L32
        }

        public void setMeasuredId(int r1, int r2) {
            this.mStartId = r1;
            this.mEndId = r2;
        }

        public boolean isNotConfiguredWith(int r2, int r3) {
            if (r2 == this.mStartId) goto L5;
        L8:
            return true;
        L5:
            if (r3 != this.mEndId) goto L8;
            return false;
        }
    }

    protected interface MotionTracker {
        void addMovement(MotionEvent r1);

        void clear();

        void computeCurrentVelocity(int r1);

        void computeCurrentVelocity(int r1, float r2);

        float getXVelocity();

        float getXVelocity(int r1);

        float getYVelocity();

        float getYVelocity(int r1);

        void recycle();
    }

    private static class MyTracker implements MotionTracker {
        private static MyTracker sMe;
        VelocityTracker mTracker;

        private MyTracker() {
        }

        static {
            sMe = new MyTracker();
        }

        public static MyTracker obtain() {
            MyTracker r0 = sMe;
            r0.mTracker = VelocityTracker.obtain();
            return sMe;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker r0 = this.mTracker;
            if (r0 == null) goto L6;
            r0.recycle();
            this.mTracker = null;
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker r0 = this.mTracker;
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent r1) {
            VelocityTracker r0 = this.mTracker;
            if (r0 == null) goto L6;
            r0.addMovement(r1);
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r1) {
            VelocityTracker r0 = this.mTracker;
            if (r0 == null) goto L6;
            r0.computeCurrentVelocity(r1);
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int r1, float r2) {
            VelocityTracker r0 = this.mTracker;
            if (r0 == null) goto L6;
            r0.computeCurrentVelocity(r1, r2);
            return;
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker r0 = this.mTracker;
            if (r0 != null) goto L5;
            return 0.0f;
        L5:
            return r0.getXVelocity();
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker r0 = this.mTracker;
            if (r0 != null) goto L5;
            return 0.0f;
        L5:
            return r0.getYVelocity();
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int r1) {
            VelocityTracker r0 = this.mTracker;
            if (r0 != null) goto L5;
            return 0.0f;
        L5:
            return r0.getXVelocity(r1);
        }

        @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int r2) {
            if (this.mTracker != null) goto L5;
            return 0.0f;
        L5:
            return getYVelocity(r2);
        }
    }

    class StateCache {
        int mEndState;
        final String mKeyEndState;
        final String mKeyProgress;
        final String mKeyStartState;
        final String mKeyVelocity;
        float mProgress;
        int mStartState;
        float mVelocity;
        final /* synthetic */ MotionLayout this$0;

        StateCache(MotionLayout r1) {
            this.this$0 = r1;
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.mStartState = -1;
            this.mEndState = -1;
            this.mKeyProgress = "motion.progress";
            this.mKeyVelocity = "motion.velocity";
            this.mKeyStartState = "motion.StartState";
            this.mKeyEndState = "motion.EndState";
        }

        void apply() {
            int r0 = this.mStartState;
            if (r0 == (-1)) goto L5;
        L6:
            if (r0 != (-1)) goto L8;
            this.this$0.transitionToState(this.mEndState);
        L12:
            this.this$0.setState(TransitionState.SETUP);
        L14:
            if (Float.isNaN(this.mVelocity) == true) goto L16;
            this.this$0.setProgress(this.mProgress, this.mVelocity);
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.mStartState = -1;
            this.mEndState = -1;
            return;
        L16:
            if (Float.isNaN(this.mProgress) == false) goto L18;
            return;
        L18:
            this.this$0.setProgress(this.mProgress);
            return;
        L8:
            int r2 = this.mEndState;
            if (r2 != (-1)) goto L11;
            this.this$0.setState(r0, -1, -1);
            goto L12
        L11:
            this.this$0.setTransition(r0, r2);
            goto L12
        L5:
            if (this.mEndState == (-1)) goto L14;
            goto L6
        }

        public Bundle getTransitionState() {
            Bundle r0 = new Bundle();
            r0.putFloat("motion.progress", this.mProgress);
            r0.putFloat("motion.velocity", this.mVelocity);
            r0.putInt("motion.StartState", this.mStartState);
            r0.putInt("motion.EndState", this.mEndState);
            return r0;
        }

        public void setTransitionState(Bundle r2) {
            this.mProgress = r2.getFloat("motion.progress");
            this.mVelocity = r2.getFloat("motion.velocity");
            this.mStartState = r2.getInt("motion.StartState");
            this.mEndState = r2.getInt("motion.EndState");
        }

        public void setProgress(float r1) {
            this.mProgress = r1;
        }

        public void setEndState(int r1) {
            this.mEndState = r1;
        }

        public void setVelocity(float r1) {
            this.mVelocity = r1;
        }

        public void setStartState(int r1) {
            this.mStartState = r1;
        }

        public void recordState() {
            this.mEndState = MotionLayout.access$100(this.this$0);
            this.mStartState = MotionLayout.access$200(this.this$0);
            this.mVelocity = this.this$0.getVelocity();
            this.mProgress = this.this$0.getProgress();
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout r1, int r2, int r3, float r4);

        void onTransitionCompleted(MotionLayout r1, int r2);

        void onTransitionStarted(MotionLayout r1, int r2, int r3);

        void onTransitionTrigger(MotionLayout r1, int r2, boolean r3, float r4);
    }

    static final enum TransitionState extends Enum<TransitionState> {
        private static final /* synthetic */ TransitionState[] $VALUES = null;
        public static final TransitionState FINISHED = null;
        public static final TransitionState MOVING = null;
        public static final TransitionState SETUP = null;
        public static final TransitionState UNDEFINED = null;

        private TransitionState(String r1, int r2) {
            super(r1, r2);
        }

        public static TransitionState valueOf(String r1) {
            return (TransitionState) Enum.valueOf(TransitionState.class, r1);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) $VALUES.clone();
        }

        static {
            TransitionState r0 = new TransitionState("UNDEFINED", 0);
            UNDEFINED = r0;
            TransitionState r1 = new TransitionState("SETUP", 1);
            SETUP = r1;
            TransitionState r3 = new TransitionState("MOVING", 2);
            MOVING = r3;
            TransitionState r5 = new TransitionState("FINISHED", 3);
            FINISHED = r5;
            $VALUES = new TransitionState[]{r0, r1, r3, r5};
        }
    }

    private static boolean willJump(float r5, float r6, float r7) {
        if (r5 <= 0.0f) goto L9;
        float r0 = r5 / r7;
        if ((r6 + ((r5 * r0) - (((r7 * r0) * r0) / 2.0f))) <= 1.0f) goto L8;
        return true;
    L8:
        return false;
    L9:
        float r1 = (-r5) / r7;
        if ((r6 + ((r5 * r1) + (((r7 * r1) * r1) / 2.0f))) >= 0.0f) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
    }

    static /* synthetic */ StateCache access$000(MotionLayout r0) {
        return r0.mStateCache;
    }

    static /* synthetic */ int access$100(MotionLayout r0) {
        return r0.mEndState;
    }

    static /* synthetic */ void access$1000(MotionLayout r0, ConstraintWidgetContainer r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1100(MotionLayout r0, boolean r1, View r2, ConstraintWidget r3, ConstraintLayout.LayoutParams r4, SparseArray r5) {
        r0.applyConstraintsFromLayoutParams(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ int access$1200(MotionLayout r0) {
        return r0.mLastWidthMeasureSpec;
    }

    static /* synthetic */ int access$1300(MotionLayout r0) {
        return r0.mLastHeightMeasureSpec;
    }

    static /* synthetic */ void access$1400(MotionLayout r0) {
        r0.setupMotionViews();
    }

    static /* synthetic */ void access$1500(MotionLayout r0, int r1, int r2, int r3, int r4, boolean r5, boolean r6) {
        r0.resolveMeasuredDimension(r1, r2, r3, r4, r5, r6);
    }

    static /* synthetic */ void access$1600(MotionLayout r0, ConstraintWidgetContainer r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1700(MotionLayout r0, ConstraintWidgetContainer r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1800(MotionLayout r0, ConstraintWidgetContainer r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1900(MotionLayout r0, ConstraintWidgetContainer r1, int r2, int r3, int r4) {
        r0.resolveSystem(r1, r2, r3, r4);
    }

    static /* synthetic */ int access$200(MotionLayout r0) {
        return r0.mBeginState;
    }

    static /* synthetic */ Rect access$2000(MotionLayout r0, ConstraintWidget r1) {
        return r0.toRect(r1);
    }

    static /* synthetic */ int access$2100(MotionLayout r0) {
        return r0.mPreRotateWidth;
    }

    static /* synthetic */ int access$2200(MotionLayout r0) {
        return r0.mPreRotateHeight;
    }

    static /* synthetic */ boolean access$300(MotionLayout r0) {
        return r0.mInRotation;
    }

    static /* synthetic */ boolean access$302(MotionLayout r0, boolean r1) {
        r0.mInRotation = r1;
        return r1;
    }

    static /* synthetic */ ConstraintWidgetContainer access$400(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ ConstraintWidgetContainer access$500(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ ConstraintWidgetContainer access$600(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ ConstraintWidgetContainer access$700(MotionLayout r0) {
        return r0.mLayoutWidget;
    }

    static /* synthetic */ boolean access$800(MotionLayout r0) {
        return r0.isRtl();
    }

    static /* synthetic */ boolean access$900(MotionLayout r0) {
        return r0.isRtl();
    }

    MotionController getMotionController(int r2) {
        return this.mFrameArrayList.get(findViewById(r2));
    }

    public MotionLayout(Context r6) {
        super(r6);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(null);
    }

    public MotionLayout(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(r7);
    }

    public MotionLayout(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.mProgressInterpolator = null;
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mFirstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mDecoratorsHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mOnComplete = null;
        this.mScheduledTransitionTo = null;
        this.mScheduledTransitions = 0;
        this.mInRotation = false;
        this.mRotatMode = 0;
        this.mPreRotate = new HashMap();
        this.mTempRect = new Rect();
        this.mDelayedApply = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mInverseMatrix = null;
        this.mTransitionCompleted = new ArrayList();
        init(r6);
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    protected MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    public void enableTransition(int r3, boolean r4) {
        MotionScene.Transition r5 = getTransition(r3);
        if (r4 == false) goto L7;
        r5.setEnabled(true);
        return;
    L7:
        if (r5 != this.mScene.mCurrentTransition) goto L14;
        Iterator<MotionScene.Transition> r6 = this.mScene.getTransitionsWithState(this.mCurrentState).iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        MotionScene.Transition r0 = r6.next();
        if (r0.isEnabled() == false) goto L10;
        this.mScene.mCurrentTransition = r0;
    L14:
        r5.setEnabled(false);
    }

    void setState(TransitionState r3) {
        if (r3 == TransitionState.FINISHED) goto L5;
    L7:
        TransitionState r0 = this.mTransitionState;
        this.mTransitionState = r3;
        if (r0 == TransitionState.MOVING) goto L10;
    L12:
        int r1 = AnonymousClass5.$SwitchMap$com$obric$oui$constraintlayout$motion$widget$MotionLayout$TransitionState[r0.ordinal()];
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L20;
        return;
    L20:
        if (r3 != TransitionState.FINISHED) goto L29;
        fireTransitionCompleted();
        return;
    L29:
        return;
    L23:
        if (r3 != TransitionState.MOVING) goto L26;
        fireTransitionChange();
    L26:
        if (r3 != TransitionState.FINISHED) goto L31;
        fireTransitionCompleted();
        return;
    L31:
        return;
    L10:
        if (r3 != TransitionState.MOVING) goto L12;
        fireTransitionChange();
        goto L12
    L5:
        if (this.mCurrentState != (-1)) goto L7;
    }

    void setStartState(int r2) {
        if (isAttachedToWindow() == false) goto L5;
        this.mCurrentState = r2;
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setStartState(r2);
        this.mStateCache.setEndState(r2);
    }

    public void setTransition(int r4, int r5) {
        if (isAttachedToWindow() == false) goto L5;
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L13;
        this.mBeginState = r4;
        this.mEndState = r5;
        r0.setTransition(r4, r5);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(r4), this.mScene.getConstraintSet(r5));
        rebuildScene();
        this.mTransitionLastPosition = 0.0f;
        transitionToStart();
        return;
    L13:
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setStartState(r4);
        this.mStateCache.setEndState(r5);
    }

    public void setTransition(int r8) {
        if (this.mScene == null) goto L35;
        MotionScene.Transition r9 = getTransition(r8);
        this.mBeginState = r9.getStartConstraintSetId();
        this.mEndState = r9.getEndConstraintSetId();
        if (isAttachedToWindow() == false) goto L7;
        int r0 = this.mCurrentState;
        float r3 = 0.0f;
        if (r0 != this.mBeginState) goto L15;
        float r1 = 0.0f;
    L18:
        this.mScene.setTransition(r9);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
        if (this.mTransitionLastPosition == r1) goto L27;
        if (r1 != 0.0f) goto L24;
        endTrigger(true);
        this.mScene.getConstraintSet(this.mBeginState).applyTo(this);
        goto L27
    L24:
        if (r1 != 1.0f) goto L27;
        endTrigger(false);
        this.mScene.getConstraintSet(this.mEndState).applyTo(this);
    L27:
        if (Float.isNaN(r1) == true) goto L30;
        r3 = r1;
    L30:
        this.mTransitionLastPosition = r3;
        if (Float.isNaN(r1) == false) goto L33;
        Log.v(TAG, Debug.getLocation() + " transitionToStart ");
        transitionToStart();
        return;
    L33:
        setProgress(r1);
        return;
    L15:
        if (r0 != this.mEndState) goto L17;
        r1 = 1.0f;
        goto L18
    L17:
        r1 = Float.NaN;
        goto L18
    L7:
        if (this.mStateCache != null) goto L9;
        this.mStateCache = new StateCache(this);
    L9:
        this.mStateCache.setStartState(this.mBeginState);
        this.mStateCache.setEndState(this.mEndState);
        return;
    }

    protected void setTransition(MotionScene.Transition r5) {
        this.mScene.setTransition(r5);
        setState(TransitionState.SETUP);
        if (this.mCurrentState != this.mScene.getEndId()) goto L5;
        this.mTransitionLastPosition = 1.0f;
        this.mTransitionPosition = 1.0f;
        this.mTransitionGoalPosition = 1.0f;
    L7:
        if (r5.isTransitionFlag(1) == false) goto L9;
        long r0 = -1;
    L10:
        this.mTransitionLastTime = r0;
        int r6 = this.mScene.getStartId();
        int r1 = this.mScene.getEndId();
        if (r6 == this.mBeginState) goto L13;
    L15:
        this.mBeginState = r6;
        this.mEndState = r1;
        this.mScene.setTransition(r6, r1);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
        return;
    L13:
        if (r1 != this.mEndState) goto L15;
        return;
    L9:
        r0 = getNanoTime();
        goto L10
    L5:
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        goto L7
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int r5) {
        if (r5 != 0) goto L49;
        this.mScene = null;
        return;
    L49:
        MotionScene r2 = new MotionScene(getContext(), this, r5);     // Catch: Exception -> L43
        this.mScene = r2;     // Catch: Exception -> L43
        if (this.mCurrentState != (-1)) goto L8;
        this.mCurrentState = r2.getStartId();     // Catch: Exception -> L43
        this.mBeginState = this.mScene.getStartId();     // Catch: Exception -> L43
        this.mEndState = this.mScene.getEndId();     // Catch: Exception -> L43
    L8:
        if (isAttachedToWindow() == true) goto L48;
        this.mScene = null;     // Catch: Exception -> L43
        return;
    L48:
        Display r6 = getDisplay();     // Catch: Exception -> L38
        if (r6 != null) goto L12;
        int r7 = 0;
    L13:
        this.mPreviouseRotation = r7;     // Catch: Exception -> L38
        MotionScene r8 = this.mScene;     // Catch: Exception -> L38
        if (r8 == null) goto L24;
        ConstraintSet r9 = r8.getConstraintSet(this.mCurrentState);     // Catch: Exception -> L38
        this.mScene.readFallback(this);     // Catch: Exception -> L38
        ArrayList<MotionHelper> r1 = this.mDecoratorsHelpers;     // Catch: Exception -> L38
        if (r1 == null) goto L21;
        Iterator<MotionHelper> r3 = r1.iterator();     // Catch: Exception -> L38
    L19:
        if (r3.hasNext() == false) goto L21;
        r3.next().onFinishedMotionScene(this);     // Catch: Exception -> L38
    L21:
        if (r9 == null) goto L23;
        r9.applyTo(this);     // Catch: Exception -> L38
    L23:
        this.mBeginState = this.mCurrentState;     // Catch: Exception -> L38
    L24:
        onNewStateAttachHandlers();     // Catch: Exception -> L38
        StateCache r10 = this.mStateCache;     // Catch: Exception -> L38
        if (r10 != null) goto L27;
        MotionScene r11 = this.mScene;     // Catch: Exception -> L38
        if (r11 != null) goto L33;
        return;
    L33:
        if (r11.mCurrentTransition != null) goto L35;
        return;
    L35:
        if (this.mScene.mCurrentTransition.getAutoTransition() != 4) goto L55;
        transitionToEnd();     // Catch: Exception -> L38
        setState(TransitionState.SETUP);     // Catch: Exception -> L38
        setState(TransitionState.MOVING);     // Catch: Exception -> L38
        return;
    L55:
        return;
    L27:
        if (this.mDelayedApply == false) goto L29;
        post(new AnonymousClass1(this));     // Catch: Exception -> L38
        return;
    L29:
        r10.apply();     // Catch: Exception -> L38
        return;
    L12:
        r7 = r6.getRotation();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse MotionScene file", e);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    public void setState(int r2, int r3, int r4) {
        setState(TransitionState.SETUP);
        this.mCurrentState = r2;
        this.mBeginState = -1;
        this.mEndState = -1;
        if (this.mConstraintLayoutSpec == null) goto L5;
        this.mConstraintLayoutSpec.updateConstraints(r2, r3, r4);
        return;
    L5:
        MotionScene r5 = this.mScene;
        if (r5 == null) goto L10;
        r5.getConstraintSet(r2).applyTo(this);
        return;
    }

    public void setInterpolatedProgress(float r2) {
        if (this.mScene == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r0 = this.mScene.getInterpolator();
        if (r0 == null) goto L8;
        setProgress(r0.getInterpolation(r2));
        return;
    L8:
        setProgress(r2);
    }

    public void setProgress(float r3, float r4) {
        if (isAttachedToWindow() == false) goto L5;
        setProgress(r3);
        setState(TransitionState.MOVING);
        this.mLastVelocity = r4;
        float r0 = 0.0f;
        if (r4 == 0.0f) goto L15;
        if (r4 <= 0.0f) goto L13;
        r0 = 1.0f;
    L13:
        animateTo(r0);
        return;
    L15:
        if (r3 != 0.0f) goto L17;
        return;
    L17:
        if (r3 != 1.0f) goto L19;
        return;
    L19:
        if (r3 <= 0.5f) goto L21;
        r0 = 1.0f;
    L21:
        animateTo(r0);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setProgress(r3);
        this.mStateCache.setVelocity(r4);
    }

    public void setTransitionState(Bundle r2) {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new StateCache(this);
    L5:
        this.mStateCache.setTransitionState(r2);
        if (isAttachedToWindow() == false) goto L9;
        this.mStateCache.apply();
        return;
    }

    public Bundle getTransitionState() {
        if (this.mStateCache != null) goto L5;
        this.mStateCache = new StateCache(this);
    L5:
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public void setProgress(float r6) {
        if (r6 >= 0.0f) goto L5;
    L6:
        Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
    L8:
        if (isAttachedToWindow() == false) goto L10;
        if (r6 > 0.0f) goto L24;
        if (this.mTransitionLastPosition == 1.0f) goto L18;
    L20:
        this.mCurrentState = this.mBeginState;
        if (this.mTransitionLastPosition != 0.0f) goto L35;
        setState(TransitionState.FINISHED);
    L35:
        if (this.mScene != null) goto L37;
        return;
    L37:
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = r6;
        this.mTransitionPosition = r6;
        this.mTransitionLastTime = -1;
        this.mAnimationStartTime = -1;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
        return;
    L18:
        if (this.mCurrentState != this.mEndState) goto L20;
        setState(TransitionState.MOVING);
        goto L20
    L24:
        if (r6 >= 1.0f) goto L26;
        this.mCurrentState = -1;
        setState(TransitionState.MOVING);
        goto L35
    L26:
        if (this.mTransitionLastPosition == 0.0f) goto L28;
    L30:
        this.mCurrentState = this.mEndState;
        if (this.mTransitionLastPosition != 1.0f) goto L35;
        setState(TransitionState.FINISHED);
        goto L35
    L28:
        if (this.mCurrentState != this.mBeginState) goto L30;
        setState(TransitionState.MOVING);
        goto L30
    L10:
        if (this.mStateCache != null) goto L12;
        this.mStateCache = new StateCache(this);
    L12:
        this.mStateCache.setProgress(r6);
        return;
    L5:
        if (r6 <= 1.0f) goto L8;
        goto L6
    }

    private void setupMotionViews() {
        int r0 = getChildCount();
        this.mModel.build();
        boolean r1 = true;
        this.mInTransition = true;
        SparseArray r2 = new SparseArray();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L5;
        View r5 = getChildAt(r4);
        r2.put(r5.getId(), this.mFrameArrayList.get(r5));
        r4 = r4 + 1;
        goto L3
    L5:
        int r6 = getWidth();
        int r7 = getHeight();
        int r8 = this.mScene.gatPathMotionArc();
        if (r8 == (-1)) goto L13;
        int r9 = 0;
    L8:
        if (r9 >= r0) goto L13;
        MotionController r10 = this.mFrameArrayList.get(getChildAt(r9));
        if (r10 == null) goto L12;
        r10.setPathMotionArc(r8);
    L12:
        r9 = r9 + 1;
    L13:
        SparseBooleanArray r11 = new SparseBooleanArray();
        int[] r12 = new int[this.mFrameArrayList.size()];
        int r13 = 0;
        int r14 = 0;
    L14:
        if (r13 >= r0) goto L20;
        MotionController r15 = this.mFrameArrayList.get(getChildAt(r13));
        if (r15.getAnimateRelativeTo() == (-1)) goto L18;
        r11.put(r15.getAnimateRelativeTo(), true);
        r12[r14] = r15.getAnimateRelativeTo();
        r14 = r14 + 1;
    L18:
        r13 = r13 + 1;
        goto L14
    L20:
        if (this.mDecoratorsHelpers == null) goto L39;
        int r16 = 0;
    L22:
        if (r16 >= r14) goto L28;
        MotionController r17 = this.mFrameArrayList.get(findViewById(r12[r16]));
        if (r17 == null) goto L27;
        this.mScene.getKeyFrames(r17);
    L27:
        r16 = r16 + 1;
        goto L22
    L28:
        Iterator<MotionHelper> r18 = this.mDecoratorsHelpers.iterator();
    L30:
        if (r18.hasNext() == false) goto L32;
        r18.next().onPreSetup(this, this.mFrameArrayList);
        goto L30
    L32:
        int r19 = 0;
    L33:
        if (r19 >= r14) goto L46;
        MotionController r20 = this.mFrameArrayList.get(findViewById(r12[r19]));
        if (r20 == null) goto L38;
        r20.setup(r6, r7, this.mTransitionDuration, getNanoTime());
    L38:
        r19 = r19 + 1;
    L46:
        int r110 = 0;
    L47:
        if (r110 >= r0) goto L54;
        View r21 = getChildAt(r110);
        MotionController r22 = this.mFrameArrayList.get(r21);
        if (r11.get(r21.getId()) == true) goto L53;
        if (r22 == null) goto L53;
        this.mScene.getKeyFrames(r22);
        r22.setup(r6, r7, this.mTransitionDuration, getNanoTime());
    L53:
        r110 = r110 + 1;
        goto L47
    L54:
        float r23 = this.mScene.getStaggered();
        if (r23 != 0.0f) goto L57;
        return;
    L57:
        if (r23 >= 0.0d) goto L59;
        boolean r24 = true;
    L60:
        float r25 = Math.abs(r23);
        float r26 = -3.4028235E38f;
        float r27 = Float.MAX_VALUE;
        int r28 = 0;
        float r29 = -3.4028235E38f;
        float r30 = Float.MAX_VALUE;
    L61:
        if (r28 >= r0) goto L70;
        MotionController r111 = this.mFrameArrayList.get(getChildAt(r28));
        if (Float.isNaN(r111.mMotionStagger) == false) goto L72;
        float r112 = r111.getFinalX();
        float r113 = r111.getFinalY();
        if (r24 == false) goto L68;
        float r114 = r113 - r112;
    L69:
        r30 = Math.min(r30, r114);
        r29 = Math.max(r29, r114);
        r28 = r28 + 1;
        goto L61
    L68:
        r114 = r113 + r112;
    L72:
        if (r1 == false) goto L87;
        int r31 = 0;
    L74:
        if (r31 >= r0) goto L79;
        MotionController r32 = this.mFrameArrayList.get(getChildAt(r31));
        if (Float.isNaN(r32.mMotionStagger) == true) goto L78;
        r27 = Math.min(r27, r32.mMotionStagger);
        r26 = Math.max(r26, r32.mMotionStagger);
    L78:
        r31 = r31 + 1;
    L79:
        if (r3 >= r0) goto L129;
        MotionController r33 = this.mFrameArrayList.get(getChildAt(r3));
        if (Float.isNaN(r33.mMotionStagger) == true) goto L86;
        r33.mStaggerScale = 1.0f / (1.0f - r25);
        if (r24 == false) goto L85;
        r33.mStaggerOffset = r25 - (((r26 - r33.mMotionStagger) / (r26 - r27)) * r25);
        goto L86
    L85:
        r33.mStaggerOffset = r25 - (((r33.mMotionStagger - r27) * r25) / (r26 - r27));
    L86:
        r3 = r3 + 1;
        goto L79
    L129:
        return;
    L87:
        if (r3 >= r0) goto L130;
        MotionController r34 = this.mFrameArrayList.get(getChildAt(r3));
        float r35 = r34.getFinalX();
        float r36 = r34.getFinalY();
        if (r24 == false) goto L91;
        float r37 = r36 - r35;
    L92:
        r34.mStaggerScale = 1.0f / (1.0f - r25);
        r34.mStaggerOffset = r25 - (((r37 - r30) * r25) / (r29 - r30));
        r3 = r3 + 1;
        goto L87
    L91:
        r37 = r36 + r35;
        goto L92
    L130:
        return;
    L70:
        r1 = false;
        goto L72
    L59:
        r24 = false;
        goto L60
    L39:
        int r115 = 0;
    L40:
        if (r115 >= r14) goto L46;
        MotionController r38 = this.mFrameArrayList.get(findViewById(r12[r115]));
        if (r38 == null) goto L45;
        this.mScene.getKeyFrames(r38);
        r38.setup(r6, r7, this.mTransitionDuration, getNanoTime());
    L45:
        r115 = r115 + 1;
        goto L40
    }

    public void touchAnimateTo(int r10, float r11, float r12) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mTransitionLastPosition != r11) goto L8;
        return;
    L8:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = r11;
        this.mInTransition = true;
        if (r10 == 0) goto L24;
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L24;
        if (r10 != 4) goto L15;
        this.mDecelerateLogic.config(r12, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
        this.mInterpolator = this.mDecelerateLogic;
    L36:
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
        return;
    L15:
        if (r10 == 5) goto L20;
        if (r10 == 6) goto L24;
        if (r10 == 7) goto L24;
    L20:
        if (willJump(r12, this.mTransitionLastPosition, this.mScene.getMaxAcceleration()) == false) goto L22;
        this.mDecelerateLogic.config(r12, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
        this.mInterpolator = this.mDecelerateLogic;
        goto L36
    L22:
        this.mStopLogic.config(this.mTransitionLastPosition, r11, r12, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
        this.mLastVelocity = 0.0f;
        int r13 = this.mCurrentState;
        this.mTransitionGoalPosition = r11;
        this.mCurrentState = r13;
        this.mInterpolator = this.mStopLogic;
    L24:
        if (r10 == 1) goto L30;
        if (r10 == 7) goto L30;
        if (r10 == 2) goto L29;
        if (r10 == 6) goto L29;
    L32:
        if (this.mScene.getAutoCompleteMode() != 0) goto L34;
        this.mStopLogic.config(this.mTransitionLastPosition, r11, r12, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
    L35:
        int r14 = this.mCurrentState;
        this.mTransitionGoalPosition = r11;
        this.mCurrentState = r14;
        this.mInterpolator = this.mStopLogic;
        goto L36
    L34:
        this.mStopLogic.springConfig(this.mTransitionLastPosition, r11, r12, this.mScene.getSpringMass(), this.mScene.getSpringStiffiness(), this.mScene.getSpringDamping(), this.mScene.getSpringStopThreshold(), this.mScene.getSpringBoundary());
    L29:
        r11 = 1.0f;
    L30:
        r11 = 0.0f;
        goto L32
    }

    public void touchSpringTo(float r12, float r13) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mTransitionLastPosition != r12) goto L8;
        return;
    L8:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = r12;
        this.mInTransition = true;
        this.mStopLogic.springConfig(this.mTransitionLastPosition, r12, r13, this.mScene.getSpringMass(), this.mScene.getSpringStiffiness(), this.mScene.getSpringDamping(), this.mScene.getSpringStopThreshold(), this.mScene.getSpringBoundary());
        int r14 = this.mCurrentState;
        this.mTransitionGoalPosition = r12;
        this.mCurrentState = r14;
        this.mInterpolator = this.mStopLogic;
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    void animateTo(float r5) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = this.mTransitionLastPosition;
        float r2 = this.mTransitionPosition;
        if (r1 != r2) goto L8;
    L10:
        float r3 = this.mTransitionLastPosition;
        if (r3 != r5) goto L13;
        return;
    L13:
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = r5;
        this.mTransitionDuration = r0.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = null;
        this.mProgressInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = r3;
        this.mTransitionLastPosition = r3;
        invalidate();
        return;
    L8:
        if (this.mTransitionInstantly == false) goto L10;
        this.mTransitionLastPosition = r2;
        goto L10
    }

    private void computeCurrentPositions() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = getChildAt(r1);
        MotionController r3 = this.mFrameArrayList.get(r2);
        if (r3 == null) goto L8;
        r3.setStartCurrentState(r2);
    L8:
        r1 = r1 + 1;
        goto L3
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToStart(Runnable r2) {
        animateTo(0.0f);
        this.mOnComplete = r2;
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToEnd(Runnable r2) {
        animateTo(1.0f);
        this.mOnComplete = r2;
    }

    public void transitionToState(int r2) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r2, -1, -1);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setEndState(r2);
    }

    public void transitionToState(int r2, int r3) {
        if (isAttachedToWindow() == false) goto L5;
        transitionToState(r2, -1, -1, r3);
        return;
    L5:
        if (this.mStateCache != null) goto L7;
        this.mStateCache = new StateCache(this);
    L7:
        this.mStateCache.setEndState(r2);
    }

    public void transitionToState(int r2, int r3, int r4) {
        transitionToState(r2, r3, r4, -1);
    }

    public void rotateTo(int r6, int r7) {
        int r0 = 1;
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int r1 = getDisplay().getRotation();
        if (((r1 + 1) % 4) > ((this.mPreviouseRotation + 1) % 4)) goto L6;
        r0 = 2;
    L6:
        this.mRotatMode = r0;
        this.mPreviouseRotation = r1;
        int r2 = getChildCount();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        View r4 = getChildAt(r3);
        ViewState r5 = this.mPreRotate.get(r4);
        if (r5 != null) goto L11;
        r5 = new ViewState();
        this.mPreRotate.put(r4, r5);
    L11:
        r5.getState(r4);
        r3 = r3 + 1;
        goto L7
    L12:
        this.mBeginState = -1;
        this.mEndState = r6;
        this.mScene.setTransition(-1, r6);
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(this.mEndState));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new AnonymousClass2(this));
        if (r7 <= 0) goto L19;
        this.mTransitionDuration = r7 / 1000.0f;
        return;
    }

    public boolean isInRotation() {
        return this.mInRotation;
    }

    public void jumpToState(int r2) {
        if (isAttachedToWindow() == true) goto L6;
        this.mCurrentState = r2;
    L6:
        if (this.mBeginState != r2) goto L9;
        setProgress(0.0f);
        return;
    L9:
        if (this.mEndState != r2) goto L11;
        setProgress(1.0f);
        return;
    L11:
        setTransition(r2, r2);
    }

    public void transitionToState(int r11, int r12, int r13, int r14) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
    L9:
        int r15 = this.mCurrentState;
        if (r15 != r11) goto L13;
        return;
    L13:
        if (this.mBeginState != r11) goto L19;
        animateTo(0.0f);
        if (r14 <= 0) goto L90;
        this.mTransitionDuration = r14 / 1000.0f;
        return;
    L90:
        return;
    L19:
        if (this.mEndState != r11) goto L24;
        animateTo(1.0f);
        if (r14 <= 0) goto L91;
        this.mTransitionDuration = r14 / 1000.0f;
        return;
    L91:
        return;
    L24:
        this.mEndState = r11;
        if (r15 == (-1)) goto L30;
        setTransition(r15, r11);
        animateTo(1.0f);
        this.mTransitionLastPosition = 0.0f;
        transitionToEnd();
        if (r14 <= 0) goto L92;
        this.mTransitionDuration = r14 / 1000.0f;
        return;
    L92:
        return;
    L30:
        int r16 = 0;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        if (r14 != (-1)) goto L33;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
    L33:
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        SparseArray r1 = new SparseArray();
        if (r14 != 0) goto L36;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
    L38:
        int r17 = getChildCount();
        this.mFrameArrayList.clear();
        int r2 = 0;
    L39:
        if (r2 >= r17) goto L41;
        View r4 = getChildAt(r2);
        this.mFrameArrayList.put(r4, new MotionController(r4));
        r1.put(r4.getId(), this.mFrameArrayList.get(r4));
        r2 = r2 + 1;
        goto L39
    L41:
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(r11));
        rebuildScene();
        this.mModel.build();
        computeCurrentPositions();
        int r18 = getWidth();
        int r19 = getHeight();
        if (this.mDecoratorsHelpers == null) goto L61;
        int r3 = 0;
    L44:
        if (r3 >= r17) goto L50;
        MotionController r5 = this.mFrameArrayList.get(getChildAt(r3));
        if (r5 == null) goto L49;
        this.mScene.getKeyFrames(r5);
    L49:
        r3 = r3 + 1;
        goto L44
    L50:
        Iterator<MotionHelper> r6 = this.mDecoratorsHelpers.iterator();
    L52:
        if (r6.hasNext() == false) goto L54;
        r6.next().onPreSetup(this, this.mFrameArrayList);
        goto L52
    L54:
        int r7 = 0;
    L55:
        if (r7 >= r17) goto L68;
        MotionController r8 = this.mFrameArrayList.get(getChildAt(r7));
        if (r8 == null) goto L60;
        r8.setup(r18, r19, this.mTransitionDuration, getNanoTime());
    L60:
        r7 = r7 + 1;
    L68:
        float r110 = this.mScene.getStaggered();
        if (r110 == 0.0f) goto L75;
        float r111 = Float.MAX_VALUE;
        float r9 = -3.4028235E38f;
        int r10 = 0;
    L71:
        if (r10 >= r17) goto L73;
        MotionController r20 = this.mFrameArrayList.get(getChildAt(r10));
        float r21 = r20.getFinalY() + r20.getFinalX();
        r111 = Math.min(r111, r21);
        r9 = Math.max(r9, r21);
        r10 = r10 + 1;
    L73:
        if (r16 >= r17) goto L75;
        MotionController r22 = this.mFrameArrayList.get(getChildAt(r16));
        float r23 = r22.getFinalX();
        float r24 = r22.getFinalY();
        r22.mStaggerScale = 1.0f / (1.0f - r110);
        r22.mStaggerOffset = r110 - ((((r23 + r24) - r111) * r110) / (r9 - r111));
        r16 = r16 + 1;
    L75:
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
        return;
    L61:
        int r25 = 0;
    L62:
        if (r25 >= r17) goto L68;
        MotionController r26 = this.mFrameArrayList.get(getChildAt(r25));
        if (r26 == null) goto L67;
        this.mScene.getKeyFrames(r26);
        r26.setup(r18, r19, this.mTransitionDuration, getNanoTime());
    L67:
        r25 = r25 + 1;
        goto L62
    L36:
        if (r14 <= 0) goto L38;
        this.mTransitionDuration = r14 / 1000.0f;
        goto L38
    L5:
        if (r0.mStateSet == null) goto L9;
        int r112 = this.mScene.mStateSet.convertToConstraintSet(this.mCurrentState, r11, r12, r13);
        if (r112 == (-1)) goto L9;
        r11 = r112;
        goto L9
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View r9, float r10, float r11, float[] r12, int r13) {
        float r0 = this.mLastVelocity;
        float r1 = this.mTransitionLastPosition;
        if (this.mInterpolator == null) goto L5;
        float r2 = Math.signum(this.mTransitionGoalPosition - r1);
        float r3 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
        float r4 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
        r0 = (r2 * ((r3 - r4) / EPSILON)) / this.mTransitionDuration;
    L6:
        Interpolator r5 = this.mInterpolator;
        if ((r5 instanceof MotionInterpolator) == false) goto L9;
        r0 = ((MotionInterpolator) r5).getVelocity();
    L9:
        MotionController r6 = this.mFrameArrayList.get(r9);
        if ((r13 & 1) != 0) goto L12;
        r6.getPostLayoutDvDp(r4, r9.getWidth(), r9.getHeight(), r10, r11, r12);
    L14:
        if (r13 >= 2) goto L17;
        r12[0] = r12[0] * r0;
        r12[1] = r12[1] * r0;
        return;
    L17:
        return;
    L12:
        r6.getDpDt(r4, r10, r11, r12);
        goto L14
    L5:
        r4 = r1;
        goto L6
    }

    private Rect toRect(ConstraintWidget r4) {
        Rect r0 = this.mTempRect;
        r0.top = r4.getY();
        Rect r1 = this.mTempRect;
        r1.left = r4.getX();
        Rect r2 = this.mTempRect;
        r2.right = r4.getWidth() + this.mTempRect.left;
        Rect r3 = this.mTempRect;
        r3.bottom = r4.getHeight() + this.mTempRect.top;
        return this.mTempRect;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mMeasureDuringTransition == false) goto L5;
    L19:
        super.requestLayout();
        return;
    L5:
        if (this.mCurrentState != (-1)) goto L19;
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L19;
        if (r0.mCurrentTransition == null) goto L19;
        int r1 = this.mScene.mCurrentTransition.getLayoutDuringTransition();
        if (r1 != 0) goto L14;
        return;
    L14:
        if (r1 != 2) goto L19;
        int r2 = getChildCount();
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L18;
        View r4 = getChildAt(r3);
        this.mFrameArrayList.get(r4).remeasure();
        r3 = r3 + 1;
        goto L16
    }

    @Override // android.view.View
    public String toString() {
        Context r0 = getContext();
        return Debug.getName(r0, this.mBeginState) + "->" + Debug.getName(r0, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r8, int r9) {
        if (this.mScene != null) goto L6;
        super.onMeasure(r8, r9);
        return;
    L6:
        boolean r1 = false;
        if (this.mLastWidthMeasureSpec == r8) goto L9;
    L12:
        boolean r0 = true;
    L14:
        if (this.mNeedsFireTransitionCompleted == false) goto L17;
        this.mNeedsFireTransitionCompleted = false;
        onNewStateAttachHandlers();
        processTransitionCompleted();
        r0 = true;
    L17:
        if (this.mDirtyHierarchy == false) goto L19;
        r0 = true;
    L19:
        this.mLastWidthMeasureSpec = r8;
        this.mLastHeightMeasureSpec = r9;
        int r3 = this.mScene.getStartId();
        int r4 = this.mScene.getEndId();
        if (r0 == true) goto L24;
        if (this.mModel.isNotConfiguredWith(r3, r4) == true) goto L24;
    L26:
        if (r0 == false) goto L28;
        super.onMeasure(r8, r9);
    L28:
        r1 = true;
    L30:
        if (this.mMeasureDuringTransition == true) goto L32;
        if (r1 == true) goto L32;
    L41:
        evaluateLayout();
        return;
    L32:
        int r10 = getPaddingTop() + getPaddingBottom();
        int r2 = this.mLayoutWidget.getWidth() + (getPaddingLeft() + getPaddingRight());
        int r11 = this.mLayoutWidget.getHeight() + r10;
        int r12 = this.mWidthMeasureMode;
        if (r12 == Integer.MIN_VALUE) goto L35;
        if (r12 == 0) goto L35;
    L36:
        int r13 = this.mHeightMeasureMode;
        if (r13 == Integer.MIN_VALUE) goto L39;
        if (r13 == 0) goto L39;
    L40:
        setMeasuredDimension(r2, r11);
    L39:
        int r14 = this.mStartWrapHeight;
        r11 = (int) (r14 + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r14)));
        requestLayout();
    L35:
        int r15 = this.mStartWrapWidth;
        r2 = (int) (r15 + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r15)));
        requestLayout();
    L24:
        if (this.mBeginState == (-1)) goto L26;
        super.onMeasure(r8, r9);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(r3), this.mScene.getConstraintSet(r4));
        this.mModel.reEvaluateState();
        this.mModel.setMeasuredId(r3, r4);
        goto L30
    L9:
        if (this.mLastHeightMeasureSpec != r9) goto L12;
        r0 = false;
        goto L14
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        MotionScene r5 = this.mScene;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.mCurrentTransition != null) goto L7;
        return false;
    L7:
        if (this.mScene.mCurrentTransition.getTouchResponse() != null) goto L9;
        return false;
    L9:
        if ((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r1, View r2, int r3, int r4) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r2, int r3) {
        MotionScene r4 = this.mScene;
        if (r4 == null) goto L9;
        float r5 = this.mScrollTargetDT;
        if (r5 == 0.0f) goto L10;
        r4.processScrollUp(this.mScrollTargetDX / r5, this.mScrollTargetDY / r5);
        return;
    L10:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        if (this.mUndergoingMotion == true) goto L6;
        if (r2 != 0) goto L6;
        if (r3 != 0) goto L6;
    L7:
        this.mUndergoingMotion = false;
        return;
    L6:
        r7[0] = r7[0] + r4;
        r7[1] = r7[1] + r5;
        goto L7
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View r11, int r12, int r13, int[] r14, int r15) {
        MotionScene r16 = this.mScene;
        if (r16 != null) goto L5;
        return;
    L5:
        MotionScene.Transition r0 = r16.mCurrentTransition;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEnabled() == false) goto L58;
        int r2 = -1;
        if (r0.isEnabled() == false) goto L20;
        TouchResponse r1 = r0.getTouchResponse();
        if (r1 == null) goto L20;
        int r3 = r1.getTouchRegionId();
        if (r3 == (-1)) goto L20;
        if (r11.getId() == r3) goto L20;
        return;
    L20:
        if (r16.getMoveWhenScrollAtTop() == false) goto L34;
        TouchResponse r4 = r0.getTouchResponse();
        if (r4 != null) goto L24;
    L26:
        float r5 = this.mTransitionPosition;
        if (r5 == 1.0f) goto L31;
        if (r5 != 0.0f) goto L34;
    L31:
        if (r11.canScrollVertically(r2) == false) goto L34;
        return;
    L24:
        if ((r4.getFlags() & 4) == 0) goto L26;
        r2 = r13;
    L34:
        if (r0.getTouchResponse() != null) goto L36;
    L47:
        float r17 = this.mTransitionPosition;
        long r6 = getNanoTime();
        float r7 = r12;
        this.mScrollTargetDX = r7;
        float r8 = r13;
        this.mScrollTargetDY = r8;
        this.mScrollTargetDT = (float) ((r6 - this.mScrollTargetTime) * 1.0E-9d);
        this.mScrollTargetTime = r6;
        r16.processScrollMove(r7, r8);
        if (r17 == this.mTransitionPosition) goto L50;
        r14[0] = r12;
        r14[1] = r13;
    L50:
        evaluate(false);
        if (r14[0] == 0) goto L53;
    L54:
        this.mUndergoingMotion = true;
        return;
    L53:
        if (r14[1] != 0) goto L54;
        return;
    L36:
        if ((r0.getTouchResponse().getFlags() & 1) == 0) goto L47;
        float r9 = r16.getProgressDirection(r12, r13);
        float r10 = this.mTransitionLastPosition;
        if (r10 > 0.0f) goto L42;
        if (r9 >= 0.0f) goto L42;
    L45:
        r11.setNestedScrollingEnabled(false);
        r11.post(new AnonymousClass3(this, r11));
        return;
    L42:
        if (r10 < 1.0f) goto L47;
        if (r9 <= 0.0f) goto L47;
    }

    private void debugPos() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L6;
        View r1 = getChildAt(r0);
        Log.v(TAG, HanziToPinyin.Token.SEPARATOR + Debug.getLocation() + HanziToPinyin.Token.SEPARATOR + Debug.getName(this) + HanziToPinyin.Token.SEPARATOR + Debug.getName(getContext(), this.mCurrentState) + HanziToPinyin.Token.SEPARATOR + Debug.getName(r1) + r1.getLeft() + HanziToPinyin.Token.SEPARATOR + r1.getTop());
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r10) {
        ArrayList<MotionHelper> r0 = this.mDecoratorsHelpers;
        if (r0 == null) goto L8;
        Iterator<MotionHelper> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().onPreDraw(r10);
    L8:
        evaluate(false);
        MotionScene r2 = this.mScene;
        if (r2 != null) goto L11;
    L13:
        super.dispatchDraw(r10);
        if (this.mScene != null) goto L17;
        return;
    L17:
        if ((this.mDebugPath & 1) != 1) goto L32;
        if (isInEditMode() == true) goto L32;
        this.mFrames++;
        long r3 = getNanoTime();
        long r5 = this.mLastDrawTime;
        if (r5 == (-1)) goto L25;
        long r6 = r3 - r5;
        if (r6 <= 200000000) goto L26;
        this.mLastFps = ((int) ((this.mFrames / (r6 * 1.0E-9f)) * 100.0f)) / 100.0f;
        this.mFrames = 0;
        this.mLastDrawTime = r3;
    L26:
        Paint r4 = new Paint();
        r4.setTextSize(42.0f);
        StringBuilder r7 = new StringBuilder().append(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ").append(Debug.getState(this, this.mEndState)).append(" (progress: ").append(((int) (getProgress() * 1000.0f)) / 10.0f).append(" ) state=");
        int r8 = this.mCurrentState;
        if (r8 != (-1)) goto L29;
        String r9 = "undefined";
    L30:
        String r11 = r7.append(r9).toString();
        r4.setColor(-16777216);
        r10.drawText(r11, 11.0f, getHeight() - 29, r4);
        r4.setColor(-7864184);
        r10.drawText(r11, 10.0f, getHeight() - 30, r4);
        goto L32
    L29:
        r9 = Debug.getState(this, r8);
        goto L30
    L25:
        this.mLastDrawTime = r3;
    L32:
        if (this.mDebugPath > 1) goto L34;
    L37:
        ArrayList<MotionHelper> r12 = this.mDecoratorsHelpers;
        if (r12 == null) goto L43;
        Iterator<MotionHelper> r13 = r12.iterator();
    L41:
        if (r13.hasNext() == false) goto L46;
        r13.next().onPostDraw(r10);
        goto L41
    L46:
        return;
    L43:
        return;
    L34:
        if (this.mDevModeDraw != null) goto L36;
        this.mDevModeDraw = new DevModeDraw(this);
    L36:
        this.mDevModeDraw.draw(r10, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        goto L37
    L11:
        if (r2.mViewTransitionController == null) goto L13;
        this.mScene.mViewTransitionController.animate();
        goto L13
    }

    private void evaluateLayout() {
        float r0 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long r1 = getNanoTime();
        Interpolator r3 = this.mInterpolator;
        if ((r3 instanceof StopLogic) == true) goto L5;
        float r4 = (((r1 - this.mTransitionLastTime) * r0) * 1.0E-9f) / this.mTransitionDuration;
    L6:
        float r7 = this.mTransitionLastPosition + r4;
        if (this.mTransitionInstantly == false) goto L9;
        r7 = this.mTransitionGoalPosition;
    L9:
        int r8 = 0;
        if (r0 <= 0.0f) goto L14;
        if (r7 < this.mTransitionGoalPosition) goto L14;
    L17:
        r7 = this.mTransitionGoalPosition;
        boolean r9 = true;
    L19:
        if (r3 == null) goto L25;
        if (r9 == true) goto L25;
        if (this.mTemporalInterpolator == false) goto L24;
        r7 = r3.getInterpolation((r1 - this.mAnimationStartTime) * 1.0E-9f);
        goto L25
    L24:
        r7 = r3.getInterpolation(r7);
    L25:
        if (r0 <= 0.0f) goto L29;
        if (r7 < this.mTransitionGoalPosition) goto L29;
    L32:
        r7 = this.mTransitionGoalPosition;
    L33:
        this.mPostInterpolationPosition = r7;
        int r2 = getChildCount();
        long r10 = getNanoTime();
        Interpolator r5 = this.mProgressInterpolator;
        if (r5 == null) goto L37;
        r7 = r5.getInterpolation(r7);
    L37:
        if (r8 >= r2) goto L43;
        View r6 = getChildAt(r8);
        MotionController r11 = this.mFrameArrayList.get(r6);
        if (r11 == null) goto L41;
        r11.interpolate(r6, r7, r10, this.mKeyCache);
    L41:
        r8 = r8 + 1;
        goto L37
    L43:
        if (this.mMeasureDuringTransition == false) goto L50;
        requestLayout();
        return;
    L50:
        return;
    L29:
        if (r0 > 0.0f) goto L33;
        if (r7 > this.mTransitionGoalPosition) goto L33;
    L14:
        if (r0 <= 0.0f) goto L16;
    L18:
        r9 = false;
        goto L19
    L16:
        if (r7 > this.mTransitionGoalPosition) goto L18;
    L5:
        r4 = 0.0f;
        goto L6
    }

    void endTrigger(boolean r5) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = getChildAt(r1);
        MotionController r3 = this.mFrameArrayList.get(r2);
        if (r3 == null) goto L7;
        r3.endTrigger(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    void evaluate(boolean r23) {
        if (this.mTransitionLastTime != (-1)) goto L5;
        this.mTransitionLastTime = getNanoTime();
    L5:
        float r1 = this.mTransitionLastPosition;
        if (r1 > 0.0f) goto L8;
    L10:
        boolean r6 = true;
        boolean r7 = false;
        if (this.mKeepAnimating == false) goto L13;
    L17:
        float r2 = Math.signum(this.mTransitionGoalPosition - r1);
        long r8 = getNanoTime();
        Interpolator r3 = this.mInterpolator;
        if ((r3 instanceof MotionInterpolator) == true) goto L20;
        float r10 = (((r8 - this.mTransitionLastTime) * r2) * 1.0E-9f) / this.mTransitionDuration;
    L21:
        float r12 = this.mTransitionLastPosition + r10;
        if (this.mTransitionInstantly == false) goto L25;
        r12 = this.mTransitionGoalPosition;
    L25:
        if (r2 <= 0.0f) goto L29;
        if (r12 < this.mTransitionGoalPosition) goto L29;
    L32:
        r12 = this.mTransitionGoalPosition;
        this.mInTransition = false;
        boolean r14 = true;
    L34:
        this.mTransitionLastPosition = r12;
        this.mTransitionPosition = r12;
        this.mTransitionLastTime = r8;
        if (r3 == null) goto L68;
        if (r14 == true) goto L68;
        if (this.mTemporalInterpolator == false) goto L63;
        float r4 = r3.getInterpolation((r8 - this.mAnimationStartTime) * 1.0E-9f);
        Interpolator r5 = this.mInterpolator;
        StopLogic r9 = this.mStopLogic;
        if (r5 == r9) goto L42;
        char r11 = 0;
    L46:
        this.mTransitionLastPosition = r4;
        this.mTransitionLastTime = r8;
        Interpolator r13 = this.mInterpolator;
        if ((r13 instanceof MotionInterpolator) == false) goto L62;
        float r15 = ((MotionInterpolator) r13).getVelocity();
        this.mLastVelocity = r15;
        if ((Math.abs(r15) * this.mTransitionDuration) > EPSILON) goto L53;
        if (r11 != 2) goto L53;
        this.mInTransition = false;
    L53:
        if (r15 <= 0.0f) goto L58;
        if (r4 < 1.0f) goto L58;
        this.mTransitionLastPosition = 1.0f;
        this.mInTransition = false;
        r4 = 1.0f;
    L58:
        if (r15 >= 0.0f) goto L62;
        if (r4 > 0.0f) goto L62;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = false;
        r12 = 0.0f;
    L71:
        if (Math.abs(this.mLastVelocity) <= EPSILON) goto L73;
        setState(TransitionState.MOVING);
    L73:
        if (r11 == 1) goto L87;
        if (r2 <= 0.0f) goto L78;
        if (r12 < this.mTransitionGoalPosition) goto L78;
    L81:
        r12 = this.mTransitionGoalPosition;
        this.mInTransition = false;
    L83:
        if (r12 < 1.0f) goto L85;
    L86:
        this.mInTransition = false;
        setState(TransitionState.FINISHED);
        goto L87
    L85:
        if (r12 > 0.0f) goto L87;
    L78:
        if (r2 > 0.0f) goto L83;
        if (r12 > this.mTransitionGoalPosition) goto L83;
    L87:
        int r16 = getChildCount();
        this.mKeepAnimating = false;
        long r17 = getNanoTime();
        this.mPostInterpolationPosition = r12;
        Interpolator r18 = this.mProgressInterpolator;
        if (r18 != null) goto L90;
        float r19 = r12;
    L91:
        Interpolator r20 = this.mProgressInterpolator;
        if (r20 == null) goto L94;
        float r21 = r20.getInterpolation((r2 / this.mTransitionDuration) + r12);
        this.mLastVelocity = r21;
        this.mLastVelocity = r21 - this.mProgressInterpolator.getInterpolation(r12);
    L94:
        int r22 = 0;
    L95:
        if (r22 >= r16) goto L100;
        View r110 = getChildAt(r22);
        MotionController r111 = this.mFrameArrayList.get(r110);
        if (r111 == null) goto L99;
        this.mKeepAnimating = r111.interpolate(r110, r19, r17, this.mKeyCache) | this.mKeepAnimating;
    L99:
        r22 = r22 + 1;
        goto L95
    L100:
        if (r2 <= 0.0f) goto L104;
        if (r12 < this.mTransitionGoalPosition) goto L104;
    L107:
        boolean r24 = true;
    L110:
        if (this.mKeepAnimating == true) goto L116;
        if (this.mInTransition == true) goto L116;
        if (r24 == false) goto L116;
        setState(TransitionState.FINISHED);
    L116:
        if (this.mMeasureDuringTransition == false) goto L118;
        requestLayout();
    L118:
        this.mKeepAnimating = (!r24) | this.mKeepAnimating;
        if (r12 > 0.0f) goto L126;
        int r25 = this.mBeginState;
        if (r25 == (-1)) goto L126;
        if (this.mCurrentState == r25) goto L126;
        this.mCurrentState = r25;
        this.mScene.getConstraintSet(r25).applyCustomAttributes(this);
        setState(TransitionState.FINISHED);
        r7 = true;
    L126:
        if (r12 < 1.0d) goto L131;
        int r26 = this.mCurrentState;
        int r27 = this.mEndState;
        if (r26 == r27) goto L131;
        this.mCurrentState = r27;
        this.mScene.getConstraintSet(r27).applyCustomAttributes(this);
        setState(TransitionState.FINISHED);
        r7 = true;
    L131:
        if (this.mKeepAnimating == false) goto L133;
    L143:
        invalidate();
    L145:
        if (this.mKeepAnimating == false) goto L147;
    L156:
        float r28 = this.mTransitionLastPosition;
        if (r28 < 1.0f) goto L165;
        int r29 = this.mCurrentState;
        int r30 = this.mEndState;
        if (r29 != r30) goto L162;
        r6 = r7;
    L162:
        this.mCurrentState = r30;
    L163:
        r7 = r6;
    L171:
        this.mNeedsFireTransitionCompleted |= r7;
        if (r7 == true) goto L174;
    L176:
        this.mTransitionPosition = this.mTransitionLastPosition;
        return;
    L174:
        if (this.mInLayout == true) goto L176;
        requestLayout();
        goto L176
    L165:
        if (r28 > 0.0f) goto L171;
        int r31 = this.mCurrentState;
        int r32 = this.mBeginState;
        if (r31 != r32) goto L170;
        r6 = r7;
    L170:
        this.mCurrentState = r32;
        goto L163
    L147:
        if (this.mInTransition == true) goto L156;
        if (r2 <= 0.0f) goto L152;
        if (r12 != 1.0f) goto L152;
    L155:
        onNewStateAttachHandlers();
    L152:
        if (r2 >= 0.0f) goto L156;
        if (r12 != 0.0f) goto L156;
    L133:
        if (this.mInTransition == true) goto L143;
        if (r2 <= 0.0f) goto L139;
        if (r12 != 1.0f) goto L139;
    L142:
        setState(TransitionState.FINISHED);
    L139:
        if (r2 >= 0.0f) goto L145;
        if (r12 != 0.0f) goto L145;
    L104:
        if (r2 <= 0.0f) goto L106;
    L108:
        r24 = false;
        goto L110
    L106:
        if (r12 > this.mTransitionGoalPosition) goto L108;
    L90:
        r19 = r18.getInterpolation(r12);
    L62:
        r12 = r4;
        goto L71
    L42:
        if (r9.isStopped() == false) goto L44;
        r11 = 2;
        goto L46
    L44:
        r11 = 1;
        goto L46
    L63:
        float r33 = r3.getInterpolation(r12);
        Interpolator r34 = this.mInterpolator;
        if ((r34 instanceof MotionInterpolator) == false) goto L66;
        this.mLastVelocity = ((MotionInterpolator) r34).getVelocity();
    L67:
        r12 = r33;
    L69:
        r11 = 0;
        goto L71
    L66:
        this.mLastVelocity = ((r34.getInterpolation(r12 + r10) - r33) * r2) / r10;
    L68:
        this.mLastVelocity = r10;
    L29:
        if (r2 <= 0.0f) goto L31;
    L33:
        r14 = false;
        goto L34
    L31:
        if (r12 > this.mTransitionGoalPosition) goto L33;
    L20:
        r10 = 0.0f;
        goto L21
    L13:
        if (this.mInTransition == false) goto L156;
        if (r23 == true) goto L17;
        if (this.mTransitionGoalPosition == r1) goto L156;
    L8:
        if (r1 >= 1.0f) goto L10;
        this.mCurrentState = -1;
        goto L10
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        this.mInLayout = true;
    L17:
        th = move-exception;
        this.mInLayout = false;
        throw th;
    L4:
        if (this.mScene != null) goto L8;
        super.onLayout(r4, r5, r6, r7, r8);     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L8:
        int r9 = r7 - r5;
        int r10 = r8 - r6;
        if (this.mLastLayoutWidth == r9) goto L12;
    L13:
        rebuildScene();     // Catch: Throwable -> L17
        evaluate(true);     // Catch: Throwable -> L17
    L14:
        this.mLastLayoutWidth = r9;     // Catch: Throwable -> L17
        this.mLastLayoutHeight = r10;     // Catch: Throwable -> L17
        this.mOldWidth = r9;     // Catch: Throwable -> L17
        this.mOldHeight = r10;     // Catch: Throwable -> L17
        this.mInLayout = false;
        return;
    L12:
        if (this.mLastLayoutHeight == r10) goto L14;
        goto L13
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int r1) {
        this.mConstraintLayoutSpec = null;
    }

    private void init(AttributeSet r10) {
        IS_IN_EDIT_MODE = isInEditMode();
        if (r10 == null) goto L37;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.MotionLayout);
        int r1 = r11.getIndexCount();
        boolean r5 = true;
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L31;
        int r6 = r11.getIndex(r4);
        if (r6 != R.styleable.MotionLayout_layoutDescription) goto L10;
        this.mScene = new MotionScene(getContext(), this, r11.getResourceId(r6, -1));
    L30:
        r4 = r4 + 1;
        goto L5
    L10:
        if (r6 != R.styleable.MotionLayout_currentState) goto L13;
        this.mCurrentState = r11.getResourceId(r6, -1);
        goto L30
    L13:
        if (r6 != R.styleable.MotionLayout_motionProgress) goto L16;
        this.mTransitionGoalPosition = r11.getFloat(r6, 0.0f);
        this.mInTransition = true;
        goto L30
    L16:
        if (r6 != R.styleable.MotionLayout_applyMotionScene) goto L19;
        r5 = r11.getBoolean(r6, r5);
        goto L30
    L19:
        if (r6 != R.styleable.MotionLayout_showPaths) goto L28;
        if (this.mDebugPath != 0) goto L30;
        if (r11.getBoolean(r6, false) == false) goto L25;
        int r7 = 2;
    L26:
        this.mDebugPath = r7;
        goto L30
    L25:
        r7 = 0;
        goto L26
    L28:
        if (r6 != R.styleable.MotionLayout_motionDebug) goto L30;
        this.mDebugPath = r11.getInt(r6, 0);
        goto L30
    L31:
        r11.recycle();
        if (this.mScene != null) goto L34;
        Log.e(TAG, "WARNING NO app:layoutDescription tag");
    L34:
        if (r5 == true) goto L37;
        this.mScene = null;
    L37:
        if (this.mDebugPath == 0) goto L40;
        checkStructure();
    L40:
        if (this.mCurrentState != (-1)) goto L54;
        MotionScene r12 = this.mScene;
        if (r12 == null) goto L55;
        this.mCurrentState = r12.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
        return;
    L55:
        return;
    }

    public void setScene(MotionScene r2) {
        this.mScene = r2;
        r2.setRtl(isRtl());
        rebuildScene();
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    private void checkStructure() {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L6;
        Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
        return;
    L6:
        int r1 = r0.getStartId();
        MotionScene r2 = this.mScene;
        checkStructure(r1, r2.getConstraintSet(r2.getStartId()));
        SparseIntArray r3 = new SparseIntArray();
        SparseIntArray r4 = new SparseIntArray();
        Iterator<MotionScene.Transition> r5 = this.mScene.getDefinedTransitions().iterator();
    L8:
        if (r5.hasNext() == false) goto L24;
        MotionScene.Transition r6 = r5.next();
        if (r6 != this.mScene.mCurrentTransition) goto L12;
        Log.v(TAG, "CHECK: CURRENT");
    L12:
        checkStructure(r6);
        int r7 = r6.getStartConstraintSetId();
        int r8 = r6.getEndConstraintSetId();
        String r9 = Debug.getName(getContext(), r7);
        String r10 = Debug.getName(getContext(), r8);
        if (r3.get(r7) != r8) goto L16;
        Log.e(TAG, "CHECK: two transitions with the same start and end " + r9 + "->" + r10);
    L16:
        if (r4.get(r8) != r7) goto L18;
        Log.e(TAG, "CHECK: you can't have reverse transitions" + r9 + "->" + r10);
    L18:
        r3.put(r7, r8);
        r4.put(r8, r7);
        if (this.mScene.getConstraintSet(r7) != null) goto L22;
        Log.e(TAG, " no such constraintSetStart " + r9);
    L22:
        if (this.mScene.getConstraintSet(r8) != null) goto L8;
        Log.e(TAG, " no such constraintSetEnd " + r9);
        goto L8
    }

    private void checkStructure(int r11, ConstraintSet r12) {
        String r13 = Debug.getName(getContext(), r11);
        int r0 = getChildCount();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L12;
        View r6 = getChildAt(r2);
        int r7 = r6.getId();
        if (r7 != (-1)) goto L9;
        Log.w(TAG, "CHECK: " + r13 + " ALL VIEWS SHOULD HAVE ID's " + r6.getClass().getName() + " does not!");
    L9:
        if (r12.getConstraint(r7) != null) goto L11;
        Log.w(TAG, "CHECK: " + r13 + " NO CONSTRAINTS for " + Debug.getName(r6));
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        int[] r3 = r12.getKnownIds();
    L14:
        if (r1 >= r3.length) goto L25;
        int r4 = r3[r1];
        String r8 = Debug.getName(getContext(), r4);
        if (findViewById(r3[r1]) != null) goto L19;
        Log.w(TAG, "CHECK: " + r13 + " NO View matches id " + r8);
    L19:
        if (r12.getHeight(r4) != (-1)) goto L22;
        Log.w(TAG, "CHECK: " + r13 + "(" + r8 + ") no LAYOUT_HEIGHT");
    L22:
        if (r12.getWidth(r4) != (-1)) goto L24;
        Log.w(TAG, "CHECK: " + r13 + "(" + r8 + ") no LAYOUT_HEIGHT");
    L24:
        r1 = r1 + 1;
        goto L14
    }

    private void checkStructure(MotionScene.Transition r1) {
        if (r1.getStartConstraintSetId() != r1.getEndConstraintSetId()) goto L6;
        Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        return;
    }

    public void setDebugMode(int r1) {
        this.mDebugPath = r1;
        invalidate();
    }

    private boolean callTransformedTouchEvent(View r3, MotionEvent r4, float r5, float r6) {
        Matrix r0 = r3.getMatrix();
        if (r0.isIdentity() == false) goto L6;
        r4.offsetLocation(r5, r6);
        boolean r2 = r3.onTouchEvent(r4);
        r4.offsetLocation(-r5, -r6);
        return r2;
    L6:
        MotionEvent r7 = MotionEvent.obtain(r4);
        r7.offsetLocation(r5, r6);
        if (this.mInverseMatrix != null) goto L9;
        this.mInverseMatrix = new Matrix();
    L9:
        r0.invert(this.mInverseMatrix);
        r7.transform(this.mInverseMatrix);
        boolean r8 = r3.onTouchEvent(r7);
        r7.recycle();
        return r8;
    }

    private boolean handlesTouchEvent(float r8, float r9, View r10, MotionEvent r11) {
        if ((r10 instanceof ViewGroup) == false) goto L10;
        ViewGroup r0 = (ViewGroup) r10;
        int r2 = r0.getChildCount() - 1;
    L5:
        if (r2 < 0) goto L10;
        View r3 = r0.getChildAt(r2);
        if (handlesTouchEvent((r3.getLeft() + r8) - r10.getScrollX(), (r3.getTop() + r9) - r10.getScrollY(), r3, r11) == true) goto L8;
        r2 = r2 - 1;
        goto L5
    L8:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L20;
        this.mBoundsCheck.set(r8, r9, (r10.getRight() + r8) - r10.getLeft(), (r10.getBottom() + r9) - r10.getTop());
        if (r11.getAction() != 0) goto L17;
        if (this.mBoundsCheck.contains(r11.getX(), r11.getY()) == false) goto L20;
    L17:
        if (callTransformedTouchEvent(r10, r11, -r8, -r9) == false) goto L20;
        return true;
    L20:
        return r1;
    L10:
        r1 = false;
        goto L11
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
    L38:
        return false;
    L5:
        if (this.mInteractionEnabled == false) goto L38;
        if (r0.mViewTransitionController == null) goto L10;
        this.mScene.mViewTransitionController.touchEvent(r7);
    L10:
        MotionScene.Transition r1 = this.mScene.mCurrentTransition;
        if (r1 == null) goto L38;
        if (r1.isEnabled() == false) goto L38;
        TouchResponse r2 = r1.getTouchResponse();
        if (r2 == null) goto L38;
        if (r7.getAction() != 0) goto L23;
        RectF r3 = r2.getTouchRegion(this, new RectF());
        if (r3 == null) goto L23;
        if (r3.contains(r7.getX(), r7.getY()) == true) goto L23;
        return false;
    L23:
        int r4 = r2.getTouchRegionId();
        if (r4 == (-1)) goto L38;
        View r5 = this.mRegionView;
        if (r5 != null) goto L28;
    L29:
        this.mRegionView = findViewById(r4);
    L30:
        View r6 = this.mRegionView;
        if (r6 == null) goto L38;
        this.mBoundsCheck.set(r6.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
        if (this.mBoundsCheck.contains(r7.getX(), r7.getY()) == false) goto L38;
        if (handlesTouchEvent(this.mRegionView.getLeft(), this.mRegionView.getTop(), this.mRegionView, r7) == true) goto L38;
        return onTouchEvent(r7);
    L28:
        if (r5.getId() == r4) goto L30;
        goto L29
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L21;
        if (this.mInteractionEnabled == false) goto L21;
        if (r0.supportTouch() == false) goto L21;
        MotionScene.Transition r1 = this.mScene.mCurrentTransition;
        if (r1 != null) goto L11;
    L14:
        this.mScene.processTouchEvent(r3, getCurrentState(), this);
        if (this.mScene.mCurrentTransition.isTransitionFlag(4) == true) goto L17;
        return true;
    L17:
        return this.mScene.mCurrentTransition.getTouchResponse().isDragStarted();
    L11:
        if (r1.isEnabled() == true) goto L14;
        return super.onTouchEvent(r3);
    L21:
        return super.onTouchEvent(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display r0 = getDisplay();
        if (r0 == null) goto L5;
        this.mPreviouseRotation = r0.getRotation();
    L5:
        MotionScene r1 = this.mScene;
        if (r1 == null) goto L18;
        int r2 = this.mCurrentState;
        if (r2 == (-1)) goto L18;
        ConstraintSet r3 = r1.getConstraintSet(r2);
        this.mScene.readFallback(this);
        ArrayList<MotionHelper> r4 = this.mDecoratorsHelpers;
        if (r4 == null) goto L15;
        Iterator<MotionHelper> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        r5.next().onFinishedMotionScene(this);
    L15:
        if (r3 == null) goto L17;
        r3.applyTo(this);
    L17:
        this.mBeginState = this.mCurrentState;
    L18:
        onNewStateAttachHandlers();
        StateCache r6 = this.mStateCache;
        if (r6 != null) goto L21;
        MotionScene r7 = this.mScene;
        if (r7 != null) goto L27;
        return;
    L27:
        if (r7.mCurrentTransition != null) goto L29;
        return;
    L29:
        if (this.mScene.mCurrentTransition.getAutoTransition() != 4) goto L37;
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L37:
        return;
    L21:
        if (this.mDelayedApply == false) goto L23;
        post(new AnonymousClass4(this));
        return;
    L23:
        r6.apply();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r1) {
        MotionScene r2 = this.mScene;
        if (r2 == null) goto L6;
        r2.setRtl(isRtl());
        return;
    }

    void onNewStateAttachHandlers() {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.autoTransition(this, this.mCurrentState) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r1 = this.mCurrentState;
        if (r1 == (-1)) goto L13;
        this.mScene.addOnClickListeners(this, r1);
    L13:
        if (this.mScene.supportTouch() == false) goto L16;
        this.mScene.setupTouch();
        return;
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    void getAnchorDpDt(int r3, float r4, float r5, float r6, float[] r7) {
        HashMap<View, MotionController> r0 = this.mFrameArrayList;
        View r1 = getViewById(r3);
        MotionController r2 = r0.get(r1);
        if (r2 == null) goto L5;
        r2.getDpDt(r4, r5, r6, r7);
        float r8 = r1.getY();
        this.mLastPos = r4;
        this.mLastY = r8;
        return;
    L5:
        if (r1 != null) goto L7;
        String r9 = "" + r3;
    L8:
        Log.w(TAG, "WARNING could not find view id " + r9);
        return;
    L7:
        r9 = r1.getContext().getResources().getResourceName(r3);
        goto L8
    }

    public long getTransitionTimeMs() {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L6;
        this.mTransitionDuration = r0.getDuration() / 1000.0f;
    L6:
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public void setTransitionListener(TransitionListener r1) {
        this.mTransitionListener = r1;
    }

    public void addTransitionListener(TransitionListener r2) {
        if (this.mTransitionListeners != null) goto L5;
        this.mTransitionListeners = new CopyOnWriteArrayList();
    L5:
        this.mTransitionListeners.add(r2);
    }

    public boolean removeTransitionListener(TransitionListener r1) {
        CopyOnWriteArrayList<TransitionListener> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.remove(r1);
    }

    public void fireTrigger(int r3, boolean r4, float r5) {
        TransitionListener r0 = this.mTransitionListener;
        if (r0 == null) goto L5;
        r0.onTransitionTrigger(this, r3, r4, r5);
    L5:
        CopyOnWriteArrayList<TransitionListener> r1 = this.mTransitionListeners;
        if (r1 == null) goto L11;
        Iterator<TransitionListener> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        r2.next().onTransitionTrigger(this, r3, r4, r5);
        goto L9
    L13:
        return;
    }

    private void fireTransitionChange() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<TransitionListener> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.mListenerPosition != this.mTransitionPosition) goto L11;
        return;
    L11:
        if (this.mListenerState == (-1)) goto L13;
        fireTransitionStarted();
        this.mIsAnimating = true;
    L13:
        this.mListenerState = -1;
        float r1 = this.mTransitionPosition;
        this.mListenerPosition = r1;
        TransitionListener r2 = this.mTransitionListener;
        if (r2 == null) goto L16;
        r2.onTransitionChange(this, this.mBeginState, this.mEndState, r1);
    L16:
        CopyOnWriteArrayList<TransitionListener> r3 = this.mTransitionListeners;
        if (r3 == null) goto L22;
        Iterator<TransitionListener> r4 = r3.iterator();
    L20:
        if (r4.hasNext() == false) goto L22;
        r4.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
    L22:
        this.mIsAnimating = true;
    }

    protected void fireTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<TransitionListener> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
    L18:
        processTransitionCompleted();
        Runnable r1 = this.mOnComplete;
        if (r1 == null) goto L21;
        r1.run();
        this.mOnComplete = null;
    L21:
        int[] r2 = this.mScheduledTransitionTo;
        if (r2 != null) goto L24;
        return;
    L24:
        if (this.mScheduledTransitions <= 0) goto L28;
        transitionToState(r2[0]);
        int[] r3 = this.mScheduledTransitionTo;
        System.arraycopy(r3, 1, r3, 0, r3.length - 1);
        this.mScheduledTransitions--;
        return;
    L28:
        return;
    L7:
        if (r0.isEmpty() == true) goto L18;
    L9:
        if (this.mListenerState != (-1)) goto L18;
        this.mListenerState = this.mCurrentState;
        if (this.mTransitionCompleted.isEmpty() == true) goto L13;
        ArrayList<Integer> r4 = this.mTransitionCompleted;
        int r5 = r4.get(r4.size() - 1).intValue();
    L14:
        int r6 = this.mCurrentState;
        if (r5 == r6) goto L18;
        if (r6 == (-1)) goto L18;
        this.mTransitionCompleted.add(Integer.valueOf(r6));
        goto L18
    L13:
        r5 = -1;
        goto L14
    }

    private void processTransitionCompleted() {
        if (this.mTransitionListener != null) goto L9;
        CopyOnWriteArrayList<TransitionListener> r0 = this.mTransitionListeners;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return;
    L9:
        this.mIsAnimating = false;
        Iterator<Integer> r1 = this.mTransitionCompleted.iterator();
    L11:
        if (r1.hasNext() == false) goto L21;
        Integer r2 = r1.next();
        TransitionListener r3 = this.mTransitionListener;
        if (r3 == null) goto L15;
        r3.onTransitionCompleted(this, r2.intValue());
    L15:
        CopyOnWriteArrayList<TransitionListener> r4 = this.mTransitionListeners;
        if (r4 == null) goto L11;
        Iterator<TransitionListener> r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L11;
        r5.next().onTransitionCompleted(this, r2.intValue());
        goto L19
    L21:
        this.mTransitionCompleted.clear();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool != null) goto L6;
        this.mDesignTool = new DesignTool(this);
    L6:
        return this.mDesignTool;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View r2) {
        super.onViewAdded(r2);
        if ((r2 instanceof MotionHelper) == false) goto L26;
        MotionHelper r3 = (MotionHelper) r2;
        if (this.mTransitionListeners != null) goto L7;
        this.mTransitionListeners = new CopyOnWriteArrayList();
    L7:
        this.mTransitionListeners.add(r3);
        if (r3.isUsedOnShow() == false) goto L14;
        if (this.mOnShowHelpers != null) goto L12;
        this.mOnShowHelpers = new ArrayList();
    L12:
        this.mOnShowHelpers.add(r3);
    L14:
        if (r3.isUseOnHide() == false) goto L20;
        if (this.mOnHideHelpers != null) goto L18;
        this.mOnHideHelpers = new ArrayList();
    L18:
        this.mOnHideHelpers.add(r3);
    L20:
        if (r3.isDecorator() == true) goto L22;
        return;
    L22:
        if (this.mDecoratorsHelpers != null) goto L24;
        this.mDecoratorsHelpers = new ArrayList();
    L24:
        this.mDecoratorsHelpers.add(r3);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r2) {
        super.onViewRemoved(r2);
        ArrayList<MotionHelper> r0 = this.mOnShowHelpers;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        ArrayList<MotionHelper> r1 = this.mOnHideHelpers;
        if (r1 == null) goto L9;
        r1.remove(r2);
        return;
    }

    public void setOnShow(float r4) {
        ArrayList<MotionHelper> r0 = this.mOnShowHelpers;
        if (r0 == null) goto L7;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        this.mOnShowHelpers.get(r2).setProgress(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnHide(float r4) {
        ArrayList<MotionHelper> r0 = this.mOnHideHelpers;
        if (r0 == null) goto L7;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        this.mOnHideHelpers.get(r2).setProgress(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public int[] getConstraintSetIds() {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConstraintSetIds();
    }

    public int[] getMatchingConstraintSetIds(String... r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMatchingStateLabels(r1);
    }

    public ConstraintSet getConstraintSet(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConstraintSet(r1);
    }

    public ConstraintSet cloneConstraintSet(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L6;
        return null;
    L6:
        ConstraintSet r2 = r0.getConstraintSet(r1);
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(r2);
        return r3;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public void updateState(int r2, ConstraintSet r3) {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L5;
        r0.setConstraintSet(r2, r3);
    L5:
        updateState();
        if (this.mCurrentState != r2) goto L9;
        r3.applyTo(this);
        return;
    }

    public void updateStateAnimate(int r4, ConstraintSet r5, int r6) {
        if (this.mScene != null) goto L6;
        return;
    L6:
        if (this.mCurrentState != r4) goto L9;
        updateState(R.id.view_transition, getConstraintSet(r4));
        setState(R.id.view_transition, -1, -1);
        updateState(r4, r5);
        MotionScene.Transition r7 = new MotionScene.Transition(-1, this.mScene, R.id.view_transition, r4);
        r7.setDuration(r6);
        setTransition(r7);
        transitionToEnd();
        return;
    }

    public void scheduleTransitionTo(int r4) {
        if (getCurrentState() != (-1)) goto L5;
        transitionToState(r4);
        return;
    L5:
        int[] r0 = this.mScheduledTransitionTo;
        if (r0 != null) goto L9;
        this.mScheduledTransitionTo = new int[4];
    L11:
        int[] r1 = this.mScheduledTransitionTo;
        int r2 = this.mScheduledTransitions;
        this.mScheduledTransitions = r2 + 1;
        r1[r2] = r4;
        return;
    L9:
        if (r0.length > this.mScheduledTransitions) goto L11;
        this.mScheduledTransitionTo = Arrays.copyOf(r0, r0.length * 2);
        goto L11
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDefinedTransitions();
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public void setTransitionDuration(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L6;
        Log.e(TAG, "MotionScene not defined");
        return;
    L6:
        r0.setDuration(r1);
    }

    public MotionScene.Transition getTransition(int r1) {
        return this.mScene.getTransitionById(r1);
    }

    int lookUpConstraintId(String r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.lookUpConstraintId(r1);
    }

    String getConstraintSetNames(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.lookUpConstraintName(r1);
    }

    void disableAutoTransition(boolean r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.disableAutoTransition(r1);
    }

    public void setInteractionEnabled(boolean r1) {
        this.mInteractionEnabled = r1;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    private void fireTransitionStarted() {
        TransitionListener r0 = this.mTransitionListener;
        if (r0 == null) goto L5;
        r0.onTransitionStarted(this, this.mBeginState, this.mEndState);
    L5:
        CopyOnWriteArrayList<TransitionListener> r1 = this.mTransitionListeners;
        if (r1 == null) goto L11;
        Iterator<TransitionListener> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        r2.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
        goto L9
    L13:
        return;
    }

    public void viewTransition(int r1, View... r2) {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L5;
        r0.viewTransition(r1, r2);
        return;
    L5:
        Log.e(TAG, " no motionScene");
    }

    public void enableViewTransition(int r1, boolean r2) {
        MotionScene r0 = this.mScene;
        if (r0 == null) goto L6;
        r0.enableViewTransition(r1, r2);
        return;
    }

    public boolean isViewTransitionEnabled(int r1) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isViewTransitionEnabled(r1);
    }

    public boolean applyViewTransition(int r1, MotionController r2) {
        MotionScene r0 = this.mScene;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.applyViewTransition(r1, r2);
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.mDelayedApply;
    }

    public void setDelayedApplicationOfInitialState(boolean r1) {
        this.mDelayedApply = r1;
    }
}
