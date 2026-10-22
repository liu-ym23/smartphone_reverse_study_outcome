package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.core.motion.utils.KeyCache;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.ConstraintSet;
import com.obric.oui.constraintlayout.widget.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class ViewTransition {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    static final int LINEAR = 3;
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "ViewTransition";
    private static final int UNSET = -1;
    static final int VIEWTRANSITIONMODE_ALLSTATES = 1;
    static final int VIEWTRANSITIONMODE_CURRENTSTATE = 0;
    static final int VIEWTRANSITIONMODE_NOSTATE = 2;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";
    private int mClearsTag;
    ConstraintSet.Constraint mConstraintDelta;
    Context mContext;
    private int mDefaultInterpolator;
    private int mDefaultInterpolatorID;
    private String mDefaultInterpolatorString;
    private boolean mDisabled;
    private int mDuration;
    private int mId;
    private int mIfTagNotSet;
    private int mIfTagSet;
    KeyFrames mKeyFrames;
    private int mOnStateTransition;
    private int mPathMotionArc;
    ConstraintSet mSet;
    private int mSetsTag;
    private int mSharedValueCurrent;
    private int mSharedValueID;
    private int mSharedValueTarget;
    private int mTargetId;
    private String mTargetString;
    private int mUpDuration;
    int mViewTransitionMode;

    static class Animate {
        KeyCache mCache;
        private final int mClearsTag;
        float mDpositionDt;
        int mDuration;
        boolean mHoldAt100;
        Interpolator mInterpolator;
        long mLastRender;
        MotionController mMC;
        float mPosition;
        boolean mReverse;
        private final int mSetsTag;
        long mStart;
        Rect mTempRec;
        int mUpDuration;
        ViewTransitionController mVtController;

        Animate(ViewTransitionController r3, MotionController r4, int r5, int r6, int r7, Interpolator r8, int r9, int r10) {
            this.mCache = new KeyCache();
            this.mReverse = false;
            this.mTempRec = new Rect();
            this.mHoldAt100 = false;
            this.mVtController = r3;
            this.mMC = r4;
            this.mDuration = r5;
            this.mUpDuration = r6;
            long r11 = System.nanoTime();
            this.mStart = r11;
            this.mLastRender = r11;
            this.mVtController.addAnimation(this);
            this.mInterpolator = r8;
            this.mSetsTag = r9;
            this.mClearsTag = r10;
            if (r7 != 3) goto L5;
            this.mHoldAt100 = true;
        L5:
            if (r5 != 0) goto L7;
            float r12 = Float.MAX_VALUE;
        L8:
            this.mDpositionDt = r12;
            mutate();
            return;
        L7:
            r12 = 1.0f / r5;
            goto L8
        }

        void reverse(boolean r3) {
            this.mReverse = r3;
            if (r3 == false) goto L10;
            int r4 = this.mUpDuration;
            if (r4 == (-1)) goto L10;
            if (r4 != 0) goto L8;
            float r5 = Float.MAX_VALUE;
        L9:
            this.mDpositionDt = r5;
            goto L10
        L8:
            r5 = 1.0f / r4;
        L10:
            this.mVtController.invalidate();
            this.mLastRender = System.nanoTime();
        }

        void mutate() {
            if (this.mReverse == false) goto L5;
            mutateReverse();
            return;
        L5:
            mutateForward();
        }

        void mutateReverse() {
            long r3 = System.nanoTime();
            long r0 = r3 - this.mLastRender;
            this.mLastRender = r3;
            float r2 = this.mPosition - (((float) (r0 * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = r2;
            if (r2 >= 0.0f) goto L5;
            this.mPosition = 0.0f;
        L5:
            Interpolator r1 = this.mInterpolator;
            if (r1 != null) goto L8;
            float r4 = this.mPosition;
        L9:
            float r5 = r4;
            MotionController r6 = this.mMC;
            boolean r7 = r6.interpolate(r6.mView, r5, r3, this.mCache);
            if (this.mPosition > 0.0f) goto L19;
            if (this.mSetsTag == (-1)) goto L15;
            this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
        L15:
            if (this.mClearsTag == (-1)) goto L17;
            this.mMC.getView().setTag(this.mClearsTag, null);
        L17:
            this.mVtController.removeAnimation(this);
        L19:
            if (this.mPosition > 0.0f) goto L21;
            if (r7 == true) goto L21;
            return;
        L21:
            this.mVtController.invalidate();
            return;
        L8:
            r4 = r1.getInterpolation(this.mPosition);
            goto L9
        }

        void mutateForward() {
            long r3 = System.nanoTime();
            long r0 = r3 - this.mLastRender;
            this.mLastRender = r3;
            float r2 = this.mPosition + (((float) (r0 * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = r2;
            if (r2 < 1.0f) goto L5;
            this.mPosition = 1.0f;
        L5:
            Interpolator r1 = this.mInterpolator;
            if (r1 != null) goto L8;
            float r4 = this.mPosition;
        L9:
            float r5 = r4;
            MotionController r6 = this.mMC;
            boolean r7 = r6.interpolate(r6.mView, r5, r3, this.mCache);
            if (this.mPosition < 1.0f) goto L21;
            if (this.mSetsTag == (-1)) goto L15;
            this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
        L15:
            if (this.mClearsTag == (-1)) goto L18;
            this.mMC.getView().setTag(this.mClearsTag, null);
        L18:
            if (this.mHoldAt100 == true) goto L21;
            this.mVtController.removeAnimation(this);
        L21:
            if (this.mPosition < 1.0f) goto L23;
            if (r7 == true) goto L23;
            return;
        L23:
            this.mVtController.invalidate();
            return;
        L8:
            r4 = r1.getInterpolation(this.mPosition);
            goto L9
        }

        public void reactTo(int r3, float r4, float r5) {
            if (r3 == 1) goto L14;
            if (r3 != 2) goto L19;
            this.mMC.getView().getHitRect(this.mTempRec);
            if (this.mTempRec.contains((int) r4, (int) r5) == false) goto L10;
            return;
        L10:
            if (this.mReverse == true) goto L18;
            reverse(true);
            return;
        L18:
            return;
        L19:
            return;
        L14:
            if (this.mReverse == true) goto L20;
            reverse(true);
            return;
        }
    }

    public int getSharedValueCurrent() {
        return this.mSharedValueCurrent;
    }

    public void setSharedValueCurrent(int r1) {
        this.mSharedValueCurrent = r1;
    }

    public int getStateTransition() {
        return this.mOnStateTransition;
    }

    public void setStateTransition(int r1) {
        this.mOnStateTransition = r1;
    }

    public int getSharedValue() {
        return this.mSharedValueTarget;
    }

    public void setSharedValue(int r1) {
        this.mSharedValueTarget = r1;
    }

    public int getSharedValueID() {
        return this.mSharedValueID;
    }

    public void setSharedValueID(int r1) {
        this.mSharedValueID = r1;
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.mContext, this.mId) + ")";
    }

    Interpolator getInterpolator(Context r3) {
        int r0 = this.mDefaultInterpolator;
        if (r0 == (-2)) goto L34;
        if (r0 == (-1)) goto L31;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L28;
        if (r0 == 2) goto L26;
        if (r0 == 4) goto L24;
        if (r0 == 5) goto L22;
        if (r0 == 6) goto L20;
        return null;
    L20:
        return new AnticipateInterpolator();
    L22:
        return new OvershootInterpolator();
    L24:
        return new BounceInterpolator();
    L26:
        return new DecelerateInterpolator();
    L28:
        return new AccelerateInterpolator();
    L30:
        return new AccelerateDecelerateInterpolator();
    L31:
        final Easing r4 = Easing.getInterpolator(this.mDefaultInterpolatorString);
        return new AnonymousClass1(this, r4);
    L34:
        return AnimationUtils.loadInterpolator(r3, this.mDefaultInterpolatorID);
    }

    ViewTransition(Context r11, XmlPullParser r12) {
        this.mOnStateTransition = -1;
        this.mDisabled = false;
        this.mPathMotionArc = 0;
        this.mDuration = -1;
        this.mUpDuration = -1;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mSetsTag = -1;
        this.mClearsTag = -1;
        this.mIfTagSet = -1;
        this.mIfTagNotSet = -1;
        this.mSharedValueTarget = -1;
        this.mSharedValueID = -1;
        this.mSharedValueCurrent = -1;
        this.mContext = r11;
        int r4 = r12.getEventType();     // Catch: IOException -> L44 XmlPullParserException -> L46
    L5:
        if (r4 == 1) goto L62;
        if (r4 == 2) goto L13;
        if (r4 == 3) goto L11;
    L42:
        r4 = r12.next();     // Catch: IOException -> L44 XmlPullParserException -> L46
    L11:
        if ("ViewTransition".equals(r12.getName()) == false) goto L42;
        return;
    L13:
        String r5 = r12.getName();     // Catch: IOException -> L44 XmlPullParserException -> L46
        switch(r5.hashCode()) {
            case -1962203927: goto L29;
            case -1239391468: goto L26;
            case 61998586: goto L23;
            case 366511058: goto L20;
            case 1791837707: goto L17;
            default: goto L31;
        };     // Catch: IOException -> L44 XmlPullParserException -> L46
    L31:
        byte r8 = -1;
    L32:
        if (r8 == 0) goto L41;
        if (r8 == 1) goto L40;
        if (r8 == 2) goto L39;
        if (r8 == 3) goto L38;
        if (r8 == 4) goto L38;
        Log.e("ViewTransition", Debug.getLoc() + " unknown tag " + r5);     // Catch: IOException -> L44 XmlPullParserException -> L46
        Log.e("ViewTransition", ".xml:" + r12.getLineNumber());     // Catch: IOException -> L44 XmlPullParserException -> L46
    L38:
        ConstraintAttribute.parse(r11, r12, this.mConstraintDelta.mCustomConstraints);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L39:
        this.mConstraintDelta = ConstraintSet.buildDelta(r11, r12);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L40:
        this.mKeyFrames = new KeyFrames(r11, r12);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L41:
        parseViewTransitionTags(r11, r12);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L17:
        if (r5.equals("CustomAttribute") == false) goto L31;
        r8 = 3;
        goto L32
    L20:
        if (r5.equals("CustomMethod") == false) goto L31;
        r8 = 4;
        goto L32
    L23:
        if (r5.equals("ViewTransition") == false) goto L31;
        r8 = 0;
        goto L32
    L26:
        if (r5.equals("KeyFrameSet") == false) goto L31;
        r8 = 1;
        goto L32
    L29:
        if (r5.equals("ConstraintOverride") == false) goto L31;
        r8 = 2;
        goto L32
    L62:
        return;
    L44:
        e = move-exception;
        Log.e("ViewTransition", "Error parsing XML resource", e);
        return;
    L46:
        e = move-exception;
        Log.e("ViewTransition", "Error parsing XML resource", e);
    }

    private void parseViewTransitionTags(Context r9, XmlPullParser r10) {
        TypedArray r11 = r9.obtainStyledAttributes(Xml.asAttributeSet(r10), R.styleable.ViewTransition);
        int r12 = r11.getIndexCount();
        int r0 = 0;
    L3:
        if (r0 >= r12) goto L71;
        int r1 = r11.getIndex(r0);
        if (r1 != R.styleable.ViewTransition_android_id) goto L8;
        this.mId = r11.getResourceId(r1, this.mId);
    L70:
        r0 = r0 + 1;
        goto L3
    L8:
        if (r1 != R.styleable.ViewTransition_motionTarget) goto L19;
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L15;
        int r2 = r11.getResourceId(r1, this.mTargetId);
        this.mTargetId = r2;
        if (r2 != (-1)) goto L70;
        this.mTargetString = r11.getString(r1);
        goto L70
    L15:
        if (r11.peekValue(r1).type != 3) goto L17;
        this.mTargetString = r11.getString(r1);
        goto L70
    L17:
        this.mTargetId = r11.getResourceId(r1, this.mTargetId);
        goto L70
    L19:
        if (r1 != R.styleable.ViewTransition_onStateTransition) goto L22;
        this.mOnStateTransition = r11.getInt(r1, this.mOnStateTransition);
        goto L70
    L22:
        if (r1 != R.styleable.ViewTransition_transitionDisable) goto L25;
        this.mDisabled = r11.getBoolean(r1, this.mDisabled);
        goto L70
    L25:
        if (r1 != R.styleable.ViewTransition_pathMotionArc) goto L28;
        this.mPathMotionArc = r11.getInt(r1, this.mPathMotionArc);
        goto L70
    L28:
        if (r1 != R.styleable.ViewTransition_duration) goto L31;
        this.mDuration = r11.getInt(r1, this.mDuration);
        goto L70
    L31:
        if (r1 != R.styleable.ViewTransition_upDuration) goto L34;
        this.mUpDuration = r11.getInt(r1, this.mUpDuration);
        goto L70
    L34:
        if (r1 != R.styleable.ViewTransition_viewTransitionMode) goto L37;
        this.mViewTransitionMode = r11.getInt(r1, this.mViewTransitionMode);
        goto L70
    L37:
        if (r1 != R.styleable.ViewTransition_motionInterpolator) goto L53;
        TypedValue r3 = r11.peekValue(r1);
        if (r3.type != 1) goto L44;
        int r4 = r11.getResourceId(r1, -1);
        this.mDefaultInterpolatorID = r4;
        if (r4 == (-1)) goto L70;
        this.mDefaultInterpolator = -2;
        goto L70
    L44:
        if (r3.type != 3) goto L51;
        String r5 = r11.getString(r1);
        this.mDefaultInterpolatorString = r5;
        if (r5 != null) goto L48;
    L50:
        this.mDefaultInterpolator = -1;
        goto L70
    L48:
        if (r5.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L50;
        this.mDefaultInterpolatorID = r11.getResourceId(r1, -1);
        this.mDefaultInterpolator = -2;
        goto L70
    L51:
        this.mDefaultInterpolator = r11.getInteger(r1, this.mDefaultInterpolator);
        goto L70
    L53:
        if (r1 != R.styleable.ViewTransition_setsTag) goto L56;
        this.mSetsTag = r11.getResourceId(r1, this.mSetsTag);
        goto L70
    L56:
        if (r1 != R.styleable.ViewTransition_clearsTag) goto L59;
        this.mClearsTag = r11.getResourceId(r1, this.mClearsTag);
        goto L70
    L59:
        if (r1 != R.styleable.ViewTransition_ifTagSet) goto L62;
        this.mIfTagSet = r11.getResourceId(r1, this.mIfTagSet);
        goto L70
    L62:
        if (r1 != R.styleable.ViewTransition_ifTagNotSet) goto L65;
        this.mIfTagNotSet = r11.getResourceId(r1, this.mIfTagNotSet);
        goto L70
    L65:
        if (r1 != R.styleable.ViewTransition_SharedValueId) goto L68;
        this.mSharedValueID = r11.getResourceId(r1, this.mSharedValueID);
        goto L70
    L68:
        if (r1 != R.styleable.ViewTransition_SharedValue) goto L70;
        this.mSharedValueTarget = r11.getInteger(r1, this.mSharedValueTarget);
        goto L70
    L71:
        r11.recycle();
    }

    void applyIndependentTransition(ViewTransitionController r10, MotionLayout r11, View r12) {
        MotionController r6 = new MotionController(r12);
        r6.setBothStates(r12);
        this.mKeyFrames.addAllFrames(r6);
        r6.setup(r11.getWidth(), r11.getHeight(), this.mDuration, System.nanoTime());
        new Animate(r10, r6, this.mDuration, this.mUpDuration, this.mOnStateTransition, getInterpolator(r11.getContext()), this.mSetsTag, this.mClearsTag);
    }

    void applyTransition(ViewTransitionController r8, MotionLayout r9, int r10, ConstraintSet r11, final View... r12) {
        if (this.mDisabled == false) goto L5;
        return;
    L5:
        int r0 = this.mViewTransitionMode;
        int r2 = 0;
        if (r0 != 2) goto L10;
        applyIndependentTransition(r8, r9, r12[0]);
        return;
    L10:
        if (r0 != 1) goto L24;
        int[] r13 = r9.getConstraintSetIds();
        int r1 = 0;
    L13:
        if (r1 >= r13.length) goto L24;
        int r3 = r13[r1];
        if (r3 == r10) goto L23;
        ConstraintSet r4 = r9.getConstraintSet(r3);
        int r5 = r12.length;
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L23;
        ConstraintSet.Constraint r7 = r4.getConstraint(r12[r6].getId());
        ConstraintSet.Constraint r14 = this.mConstraintDelta;
        if (r14 == null) goto L22;
        r14.applyDelta(r7);
        r7.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
    L22:
        r6 = r6 + 1;
    L23:
        r1 = r1 + 1;
    L24:
        ConstraintSet r15 = new ConstraintSet();
        r15.clone(r11);
        int r16 = r12.length;
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L30;
        ConstraintSet.Constraint r18 = r15.getConstraint(r12[r17].getId());
        ConstraintSet.Constraint r19 = this.mConstraintDelta;
        if (r19 == null) goto L29;
        r19.applyDelta(r18);
        r18.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
    L29:
        r17 = r17 + 1;
        goto L25
    L30:
        r9.updateState(r10, r15);
        r9.updateState(R.id.view_transition, r11);
        r9.setState(R.id.view_transition, -1, -1);
        MotionScene.Transition r20 = new MotionScene.Transition(-1, r9.mScene, R.id.view_transition, r10);
        int r110 = r12.length;
    L31:
        if (r2 >= r110) goto L33;
        updateTransition(r20, r12[r2]);
        r2 = r2 + 1;
        goto L31
    L33:
        r9.setTransition(r20);
        r9.transitionToEnd(new ViewTransition$$ExternalSyntheticLambda0(this, r12));
    }

    /* JADX INFO: renamed from: lambda$applyTransition$0$com-obric-oui-constraintlayout-motion-widget-ViewTransition, reason: not valid java name */
    /* synthetic */ void m251xbc42fcb6(View[] r9) {
        int r1 = 0;
        if (this.mSetsTag == (-1)) goto L8;
        int r0 = r9.length;
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L8;
        r9[r3].setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
        r3 = r3 + 1;
    L8:
        if (this.mClearsTag == (-1)) goto L12;
        int r2 = r9.length;
    L10:
        if (r1 >= r2) goto L15;
        r9[r1].setTag(this.mClearsTag, null);
        r1 = r1 + 1;
        goto L10
    L15:
        return;
    }

    private void updateTransition(MotionScene.Transition r5, View r6) {
        int r0 = this.mDuration;
        if (r0 == (-1)) goto L5;
        r5.setDuration(r0);
    L5:
        r5.setPathMotionArc(this.mPathMotionArc);
        r5.setInterpolatorInfo(this.mDefaultInterpolator, this.mDefaultInterpolatorString, this.mDefaultInterpolatorID);
        int r7 = r6.getId();
        KeyFrames r4 = this.mKeyFrames;
        if (r4 == null) goto L14;
        ArrayList<Key> r8 = r4.getKeyFramesForView(-1);
        KeyFrames r1 = new KeyFrames();
        Iterator<Key> r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L11;
        r1.addKey(r9.next().clone().setViewId(r7));
        goto L9
    L11:
        r5.addKeyFrame(r1);
        return;
    }

    int getId() {
        return this.mId;
    }

    void setId(int r1) {
        this.mId = r1;
    }

    boolean matchesView(View r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.mTargetId != (-1)) goto L11;
        if (this.mTargetString != null) goto L11;
        return false;
    L11:
        if (checkTags(r5) == true) goto L14;
        return false;
    L14:
        if (r5.getId() != this.mTargetId) goto L17;
        return true;
    L17:
        if (this.mTargetString != null) goto L20;
        return false;
    L20:
        if ((r5.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        String r6 = ((ConstraintLayout.LayoutParams) r5.getLayoutParams()).constraintTag;
        if (r6 == null) goto L26;
        if (r6.matches(this.mTargetString) == false) goto L26;
        return true;
    L26:
        return false;
    }

    boolean supports(int r4) {
        int r3 = this.mOnStateTransition;
        if (r3 != 1) goto L8;
        if (r4 == 0) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r3 != 2) goto L13;
        if (r4 == 1) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (r3 != 3) goto L19;
        if (r4 == 0) goto L16;
        return false;
    L16:
        return true;
    L19:
        return false;
    }

    boolean isEnabled() {
        return !this.mDisabled;
    }

    void setEnabled(boolean r1) {
        this.mDisabled = !r1;
    }

    boolean checkTags(View r5) {
        int r0 = this.mIfTagSet;
        if (r0 != (-1)) goto L6;
    L4:
        boolean r1 = true;
    L9:
        int r4 = this.mIfTagNotSet;
        if (r4 != (-1)) goto L13;
    L11:
        boolean r6 = true;
    L16:
        if (r1 == false) goto L20;
        if (r6 == true) goto L19;
        return false;
    L19:
        return true;
    L20:
        return false;
    L13:
        if (r5.getTag(r4) == null) goto L11;
        r6 = false;
        goto L16
    L6:
        if (r5.getTag(r0) != null) goto L4;
        r1 = false;
        goto L9
    }
}
