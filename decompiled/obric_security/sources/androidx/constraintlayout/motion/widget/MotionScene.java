package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.material.MaterialConfigBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private boolean DEBUG_DESKTOP;
    private ArrayList<Transition> mAbstractTransitionList;
    private HashMap<String, Integer> mConstraintSetIdMap;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    Transition mCurrentTransition;
    private int mDefaultDuration;
    private Transition mDefaultTransition;
    private SparseIntArray mDeriveMap;
    private boolean mDisableAutoTransition;
    private boolean mIgnoreTouch;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private int mLayoutDuringTransition;
    private final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion;
    private boolean mRtl;
    StateSet mStateSet;
    private ArrayList<Transition> mTransitionList;
    private MotionLayout.MotionTracker mVelocityTracker;
    final ViewTransitionController mViewTransitionController;

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTERCEPT_TOUCH = 4;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser parser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray r3 = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.OnClick);
                int r4 = r3.getIndexCount();
                int r5 = 0;
            L3:
                if (r5 >= r4) goto L11;
                int r0 = r3.getIndex(r5);
                if (r0 != R.styleable.OnClick_targetId) goto L8;
                this.mTargetId = r3.getResourceId(r0, this.mTargetId);
            L10:
                r5 = r5 + 1;
                goto L3
            L8:
                if (r0 != R.styleable.OnClick_clickAction) goto L10;
                this.mMode = r3.getInt(r0, this.mMode);
                goto L10
            L11:
                r3.recycle();
            }

            public TransitionOnClick(Transition transition, int id, int action) {
                this.mTransition = transition;
                this.mTargetId = id;
                this.mMode = action;
            }

            public void addOnClickListeners(MotionLayout r7, int r8, Transition r9) {
                int r0 = this.mTargetId;
                MotionLayout r10 = r7;
                if (r0 == (-1)) goto L6;
                r10 = r7.findViewById(r0);
            L6:
                if (r10 != null) goto L9;
                Log.e("MotionScene", "OnClick could not find id " + this.mTargetId);
                return;
            L9:
                int r1 = Transition.access$100(r9);
                int r11 = Transition.access$000(r9);
                if (r1 != (-1)) goto L13;
                r10.setOnClickListener(this);
                return;
            L13:
                int r2 = this.mMode;
                boolean r3 = false;
                if ((r2 & 1) == 0) goto L17;
                if (r8 != r1) goto L17;
                boolean r4 = true;
            L19:
                if ((r2 & 256) == 0) goto L22;
                if (r8 != r1) goto L22;
                boolean r5 = true;
            L23:
                boolean r6 = r4 | r5;
                if ((r2 & 1) == 0) goto L27;
                if (r8 != r1) goto L27;
                boolean r12 = true;
            L28:
                boolean r13 = r12 | r6;
                if ((r2 & 16) == 0) goto L32;
                if (r8 != r11) goto L32;
                boolean r14 = true;
            L33:
                boolean r15 = r13 | r14;
                if ((r2 & 4096) == 0) goto L38;
                if (r8 != r11) goto L38;
                r3 = true;
            L38:
                if ((r15 | r3) == false) goto L41;
                r10.setOnClickListener(this);
                return;
            L41:
                return;
            L32:
                r14 = false;
            L27:
                r12 = false;
            L22:
                r5 = false;
            L17:
                r4 = false;
                goto L19
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int r0 = this.mTargetId;
                if (r0 != (-1)) goto L5;
                return;
            L5:
                View r3 = motionLayout.findViewById(r0);
                if (r3 != null) goto L9;
                Log.e("MotionScene", " (*)  could not find id " + this.mTargetId);
                return;
            L9:
                r3.setOnClickListener(null);
            }

            boolean isTransitionViable(Transition current, MotionLayout tl) {
                Transition r0 = this.mTransition;
                if (r0 != current) goto L5;
                return true;
            L5:
                int r4 = Transition.access$000(r0);
                int r3 = Transition.access$100(this.mTransition);
                if (r3 != (-1)) goto L13;
                if (tl.mCurrentState == r4) goto L11;
                return true;
            L11:
                return false;
            L13:
                if (tl.mCurrentState != r3) goto L15;
                return true;
            L15:
                if (tl.mCurrentState != r4) goto L18;
                return true;
            L18:
                return false;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout r8 = MotionScene.access$700(Transition.access$800(this.mTransition));
                if (r8.isInteractionEnabled() == true) goto L6;
                return;
            L6:
                if (Transition.access$100(this.mTransition) != (-1)) goto L13;
                int r0 = r8.getCurrentState();
                if (r0 != (-1)) goto L11;
                r8.transitionToState(Transition.access$000(this.mTransition));
                return;
            L11:
                Transition r1 = new Transition(Transition.access$800(this.mTransition), this.mTransition);
                Transition.access$102(r1, r0);
                Transition.access$002(r1, Transition.access$000(this.mTransition));
                r8.setTransition(r1);
                r8.transitionToEnd();
                return;
            L13:
                Transition r2 = Transition.access$800(this.mTransition).mCurrentTransition;
                int r3 = this.mMode;
                boolean r4 = false;
                if ((r3 & 1) == 0) goto L16;
            L19:
                boolean r5 = true;
            L21:
                if ((r3 & 16) == 0) goto L23;
            L26:
                boolean r6 = true;
            L27:
                if (r5 == false) goto L30;
                if (r6 == false) goto L30;
                boolean r7 = true;
            L31:
                if (r7 == false) goto L41;
                Transition r9 = Transition.access$800(this.mTransition).mCurrentTransition;
                Transition r10 = this.mTransition;
                if (r9 == r10) goto L36;
                r8.setTransition(r10);
            L36:
                if (r8.getCurrentState() == r8.getEndState()) goto L43;
                if (r8.getProgress() > 0.5f) goto L43;
                r6 = false;
            L43:
                if (isTransitionViable(r2, r8) == false) goto L61;
                if (r4 == true) goto L46;
            L48:
                if (r6 == true) goto L50;
            L52:
                if (r4 == true) goto L54;
            L56:
                if (r6 == true) goto L58;
                return;
            L58:
                if ((this.mMode & 4096) == 0) goto L66;
                r8.setTransition(this.mTransition);
                r8.setProgress(0.0f);
                return;
            L66:
                return;
            L54:
                if ((this.mMode & 256) == 0) goto L56;
                r8.setTransition(this.mTransition);
                r8.setProgress(1.0f);
                return;
            L50:
                if ((this.mMode & 16) == 0) goto L52;
                r8.setTransition(this.mTransition);
                r8.transitionToStart();
                return;
            L46:
                if ((this.mMode & 1) == 0) goto L48;
                r8.setTransition(this.mTransition);
                r8.transitionToEnd();
                return;
            L61:
                return;
            L41:
                r4 = r5;
            L30:
                r7 = false;
                goto L31
            L23:
                if ((r3 & 4096) != 0) goto L26;
                r6 = false;
                goto L27
            L16:
                if ((r3 & 256) != 0) goto L19;
                r5 = false;
                goto L21
            }
        }

        static /* synthetic */ int access$000(Transition r0) {
            return r0.mConstraintSetEnd;
        }

        static /* synthetic */ int access$002(Transition r0, int r1) {
            r0.mConstraintSetEnd = r1;
            return r1;
        }

        static /* synthetic */ int access$100(Transition r0) {
            return r0.mConstraintSetStart;
        }

        static /* synthetic */ int access$102(Transition r0, int r1) {
            r0.mConstraintSetStart = r1;
            return r1;
        }

        static /* synthetic */ boolean access$1300(Transition r0) {
            return r0.mIsAbstract;
        }

        static /* synthetic */ ArrayList access$1400(Transition r0) {
            return r0.mKeyFramesList;
        }

        static /* synthetic */ int access$1500(Transition r0) {
            return r0.mDefaultInterpolator;
        }

        static /* synthetic */ String access$1600(Transition r0) {
            return r0.mDefaultInterpolatorString;
        }

        static /* synthetic */ int access$1700(Transition r0) {
            return r0.mDefaultInterpolatorID;
        }

        static /* synthetic */ int access$1800(Transition r0) {
            return r0.mDuration;
        }

        static /* synthetic */ int access$1900(Transition r0) {
            return r0.mPathMotionArc;
        }

        static /* synthetic */ TouchResponse access$200(Transition r0) {
            return r0.mTouchResponse;
        }

        static /* synthetic */ float access$2000(Transition r0) {
            return r0.mStagger;
        }

        static /* synthetic */ TouchResponse access$202(Transition r0, TouchResponse r1) {
            r0.mTouchResponse = r1;
            return r1;
        }

        static /* synthetic */ int access$300(Transition r0) {
            return r0.mId;
        }

        static /* synthetic */ ArrayList access$400(Transition r0) {
            return r0.mOnClicks;
        }

        static /* synthetic */ boolean access$500(Transition r0) {
            return r0.mDisable;
        }

        static /* synthetic */ int access$600(Transition r0) {
            return r0.mAutoTransition;
        }

        static /* synthetic */ MotionScene access$800(Transition r0) {
            return r0.mMotionScene;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            if (onSwipe != null) goto L4;
            TouchResponse r3 = null;
        L5:
            this.mTouchResponse = r3;
            return;
        L4:
            r3 = new TouchResponse(MotionScene.access$700(this.mMotionScene), onSwipe);
            goto L5
        }

        public void addOnClick(int id, int action) {
            Iterator<TransitionOnClick> r0 = this.mOnClicks.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            TransitionOnClick r1 = r0.next();
            if (r1.mTargetId != id) goto L4;
            r1.mMode = action;
            return;
        L9:
            TransitionOnClick r2 = new TransitionOnClick(this, id, action);
            this.mOnClicks.add(r2);
        }

        public void removeOnClick(int id) {
            Iterator<TransitionOnClick> r0 = this.mOnClicks.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            TransitionOnClick r1 = r0.next();
            if (r1.mTargetId != id) goto L4;
        L9:
            if (r1 == null) goto L15;
            this.mOnClicks.remove(r1);
            return;
        L15:
            return;
        L8:
            r1 = null;
            goto L9
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public void setLayoutDuringTransition(int mode) {
            this.mLayoutDuringTransition = mode;
        }

        public void addOnClick(Context context, XmlPullParser parser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, parser));
        }

        public void setAutoTransition(int type) {
            this.mAutoTransition = type;
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getId() {
            return this.mId;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public void setDuration(int duration) {
            this.mDuration = Math.max(duration, 8);
        }

        public int getDuration() {
            return this.mDuration;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.mKeyFramesList.add(keyFrames);
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public void setStagger(float stagger) {
            this.mStagger = stagger;
        }

        public void setPathMotionArc(int arcMode) {
            this.mPathMotionArc = arcMode;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public void setEnable(boolean enable) {
            setEnabled(enable);
        }

        public void setEnabled(boolean enable) {
            this.mDisable = !enable;
        }

        public String debugString(Context context) {
            if (this.mConstraintSetStart != (-1)) goto L5;
            String r0 = "null";
        L7:
            if (this.mConstraintSetEnd != (-1)) goto L10;
            return r0 + " -> null";
        L10:
            return r0 + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        L5:
            r0 = context.getResources().getResourceEntryName(this.mConstraintSetStart);
            goto L7
        }

        public boolean isTransitionFlag(int flag) {
            if ((this.mTransitionFlags & flag) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void setTransitionFlag(int flag) {
            this.mTransitionFlags = flag;
        }

        public void setOnTouchUp(int touchUpMode) {
            TouchResponse r0 = getTouchResponse();
            if (r0 == null) goto L6;
            r0.setTouchUpMode(touchUpMode);
            return;
        }

        Transition(MotionScene motionScene, Transition global) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            this.mDuration = MotionScene.access$900(motionScene);
            if (global == null) goto L6;
            this.mPathMotionArc = global.mPathMotionArc;
            this.mDefaultInterpolator = global.mDefaultInterpolator;
            this.mDefaultInterpolatorString = global.mDefaultInterpolatorString;
            this.mDefaultInterpolatorID = global.mDefaultInterpolatorID;
            this.mDuration = global.mDuration;
            this.mKeyFramesList = global.mKeyFramesList;
            this.mStagger = global.mStagger;
            this.mLayoutDuringTransition = global.mLayoutDuringTransition;
            return;
        }

        public Transition(int id, MotionScene motionScene, int constraintSetStartId, int constraintSetEndId) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = id;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = constraintSetStartId;
            this.mConstraintSetEnd = constraintSetEndId;
            this.mDuration = MotionScene.access$900(motionScene);
            this.mLayoutDuringTransition = MotionScene.access$1000(motionScene);
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser parser) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = MotionScene.access$900(motionScene);
            this.mLayoutDuringTransition = MotionScene.access$1000(motionScene);
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(parser));
        }

        public void setInterpolatorInfo(int interpolator, String interpolatorString, int interpolatorID) {
            this.mDefaultInterpolator = interpolator;
            this.mDefaultInterpolatorString = interpolatorString;
            this.mDefaultInterpolatorID = interpolatorID;
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attrs) {
            TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.Transition);
            fill(motionScene, context, r4);
            r4.recycle();
        }

        private void fill(MotionScene motionScene, Context context, TypedArray a2) {
            int r0 = a2.getIndexCount();
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L65;
            int r5 = a2.getIndex(r2);
            if (r5 != R.styleable.Transition_constraintSetEnd) goto L14;
            this.mConstraintSetEnd = a2.getResourceId(r5, -1);
            String r3 = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
            if ("layout".equals(r3) == false) goto L11;
            ConstraintSet r4 = new ConstraintSet();
            r4.load(context, this.mConstraintSetEnd);
            MotionScene.access$1100(motionScene).append(this.mConstraintSetEnd, r4);
        L63:
            r2 = r2 + 1;
            goto L4
        L11:
            if (MaterialConfigBuilder.SERIALIZATION_FORMAT_XML.equals(r3) == false) goto L63;
            this.mConstraintSetEnd = MotionScene.access$1200(motionScene, context, this.mConstraintSetEnd);
            goto L63
        L14:
            if (r5 != R.styleable.Transition_constraintSetStart) goto L22;
            this.mConstraintSetStart = a2.getResourceId(r5, this.mConstraintSetStart);
            String r6 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
            if ("layout".equals(r6) == false) goto L19;
            ConstraintSet r7 = new ConstraintSet();
            r7.load(context, this.mConstraintSetStart);
            MotionScene.access$1100(motionScene).append(this.mConstraintSetStart, r7);
            goto L63
        L19:
            if (MaterialConfigBuilder.SERIALIZATION_FORMAT_XML.equals(r6) == false) goto L63;
            this.mConstraintSetStart = MotionScene.access$1200(motionScene, context, this.mConstraintSetStart);
            goto L63
        L22:
            if (r5 != R.styleable.Transition_motionInterpolator) goto L38;
            TypedValue r8 = a2.peekValue(r5);
            if (r8.type != 1) goto L29;
            int r9 = a2.getResourceId(r5, -1);
            this.mDefaultInterpolatorID = r9;
            if (r9 == (-1)) goto L63;
            this.mDefaultInterpolator = -2;
            goto L63
        L29:
            if (r8.type != 3) goto L36;
            String r10 = a2.getString(r5);
            this.mDefaultInterpolatorString = r10;
            if (r10 == null) goto L63;
            if (r10.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L35;
            this.mDefaultInterpolatorID = a2.getResourceId(r5, -1);
            this.mDefaultInterpolator = -2;
            goto L63
        L35:
            this.mDefaultInterpolator = -1;
            goto L63
        L36:
            this.mDefaultInterpolator = a2.getInteger(r5, this.mDefaultInterpolator);
            goto L63
        L38:
            if (r5 != R.styleable.Transition_duration) goto L43;
            int r11 = a2.getInt(r5, this.mDuration);
            this.mDuration = r11;
            if (r11 >= 8) goto L63;
            this.mDuration = 8;
            goto L63
        L43:
            if (r5 != R.styleable.Transition_staggered) goto L46;
            this.mStagger = a2.getFloat(r5, this.mStagger);
            goto L63
        L46:
            if (r5 != R.styleable.Transition_autoTransition) goto L49;
            this.mAutoTransition = a2.getInteger(r5, this.mAutoTransition);
            goto L63
        L49:
            if (r5 != R.styleable.Transition_android_id) goto L52;
            this.mId = a2.getResourceId(r5, this.mId);
            goto L63
        L52:
            if (r5 != R.styleable.Transition_transitionDisable) goto L55;
            this.mDisable = a2.getBoolean(r5, this.mDisable);
            goto L63
        L55:
            if (r5 != R.styleable.Transition_pathMotionArc) goto L58;
            this.mPathMotionArc = a2.getInteger(r5, -1);
            goto L63
        L58:
            if (r5 != R.styleable.Transition_layoutDuringTransition) goto L61;
            this.mLayoutDuringTransition = a2.getInteger(r5, 0);
            goto L63
        L61:
            if (r5 != R.styleable.Transition_transitionFlags) goto L63;
            this.mTransitionFlags = a2.getInteger(r5, 0);
            goto L63
        L65:
            if (this.mConstraintSetStart != (-1)) goto L91;
            this.mIsAbstract = true;
            return;
        }
    }

    public float getPathPercent(View view, int position) {
        return 0.0f;
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    static /* synthetic */ int access$1000(MotionScene r0) {
        return r0.mLayoutDuringTransition;
    }

    static /* synthetic */ SparseArray access$1100(MotionScene r0) {
        return r0.mConstraintSetMap;
    }

    static /* synthetic */ int access$1200(MotionScene r0, Context r1, int r2) {
        return r0.parseInclude(r1, r2);
    }

    static /* synthetic */ MotionLayout access$700(MotionScene r0) {
        return r0.mMotionLayout;
    }

    static /* synthetic */ int access$900(MotionScene r0) {
        return r0.mDefaultDuration;
    }

    void setTransition(int beginId, int endId) {
        StateSet r0 = this.mStateSet;
        if (r0 == null) goto L11;
        int r1 = r0.stateGetConstraintID(beginId, -1, -1);
        if (r1 != (-1)) goto L8;
        r1 = beginId;
    L8:
        int r2 = this.mStateSet.stateGetConstraintID(endId, -1, -1);
        if (r2 != (-1)) goto L13;
    L12:
        r2 = endId;
    L13:
        Transition r3 = this.mCurrentTransition;
        if (r3 != null) goto L16;
    L20:
        Iterator<Transition> r4 = this.mTransitionList.iterator();
    L22:
        if (r4.hasNext() == false) goto L37;
        Transition r5 = r4.next();
        if (Transition.access$000(r5) != r2) goto L28;
        if (Transition.access$100(r5) != r1) goto L28;
    L31:
        this.mCurrentTransition = r5;
        if (r5 != null) goto L34;
        return;
    L34:
        if (Transition.access$200(r5) == null) goto L61;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    L61:
        return;
    L28:
        if (Transition.access$000(r5) != endId) goto L22;
        if (Transition.access$100(r5) != beginId) goto L22;
    L37:
        Transition r7 = this.mDefaultTransition;
        Iterator<Transition> r6 = this.mAbstractTransitionList.iterator();
    L39:
        if (r6.hasNext() == false) goto L43;
        Transition r8 = r6.next();
        if (Transition.access$000(r8) != endId) goto L39;
        r7 = r8;
        goto L39
    L43:
        Transition r9 = new Transition(this, r7);
        Transition.access$102(r9, r1);
        Transition.access$002(r9, r2);
        if (r1 == (-1)) goto L46;
        this.mTransitionList.add(r9);
    L46:
        this.mCurrentTransition = r9;
        return;
    L16:
        if (Transition.access$000(r3) != endId) goto L20;
        if (Transition.access$100(this.mCurrentTransition) != beginId) goto L20;
        return;
    L11:
        r1 = beginId;
        goto L12
    }

    public void addTransition(Transition transition) {
        int r0 = getIndex(transition);
        if (r0 != (-1)) goto L5;
        this.mTransitionList.add(transition);
        return;
    L5:
        this.mTransitionList.set(r0, transition);
    }

    public void removeTransition(Transition transition) {
        int r2 = getIndex(transition);
        if (r2 == (-1)) goto L6;
        this.mTransitionList.remove(r2);
        return;
    }

    private int getIndex(Transition transition) {
        int r4 = Transition.access$300(transition);
        if (r4 == (-1)) goto L13;
        int r1 = 0;
    L6:
        if (r1 >= this.mTransitionList.size()) goto L11;
        if (Transition.access$300(this.mTransitionList.get(r1)) == r4) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return r1;
    L11:
        return -1;
    L13:
        throw new IllegalArgumentException("The transition must have an id");
    }

    public boolean validateLayout(MotionLayout layout) {
        if (layout == this.mMotionLayout) goto L5;
    L7:
        return false;
    L5:
        if (layout.mScene != this) goto L7;
        return true;
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition != null) goto L5;
        return;
    L5:
        if (Transition.access$200(transition) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    private int getRealID(int stateId) {
        StateSet r1 = this.mStateSet;
        if (r1 == null) goto L7;
        int r2 = r1.stateGetConstraintID(stateId, -1, -1);
        if (r2 == (-1)) goto L7;
        return r2;
    L7:
        return stateId;
    }

    public List<Transition> getTransitionsWithState(int stateId) {
        int r4 = getRealID(stateId);
        ArrayList r0 = new ArrayList();
        Iterator<Transition> r3 = this.mTransitionList.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        Transition r1 = r3.next();
        if (Transition.access$100(r1) == r4) goto L9;
        if (Transition.access$000(r1) != r4) goto L4;
    L9:
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }

    public void addOnClickListeners(MotionLayout motionLayout, int currentState) {
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Transition r1 = r0.next();
        if (Transition.access$400(r1).size() <= 0) goto L4;
        Iterator r2 = Transition.access$400(r1).iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        ((Transition.TransitionOnClick) r2.next()).removeOnClickListeners(motionLayout);
        goto L9
    L11:
        Iterator<Transition> r3 = this.mAbstractTransitionList.iterator();
    L13:
        if (r3.hasNext() == false) goto L20;
        Transition r4 = r3.next();
        if (Transition.access$400(r4).size() <= 0) goto L13;
        Iterator r5 = Transition.access$400(r4).iterator();
    L18:
        if (r5.hasNext() == false) goto L13;
        ((Transition.TransitionOnClick) r5.next()).removeOnClickListeners(motionLayout);
        goto L18
    L20:
        Iterator<Transition> r6 = this.mTransitionList.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        Transition r7 = r6.next();
        if (Transition.access$400(r7).size() <= 0) goto L22;
        Iterator r8 = Transition.access$400(r7).iterator();
    L27:
        if (r8.hasNext() == false) goto L22;
        ((Transition.TransitionOnClick) r8.next()).addOnClickListeners(motionLayout, currentState, r7);
        goto L27
    L29:
        Iterator<Transition> r9 = this.mAbstractTransitionList.iterator();
    L31:
        if (r9.hasNext() == false) goto L38;
        Transition r10 = r9.next();
        if (Transition.access$400(r10).size() <= 0) goto L31;
        Iterator r11 = Transition.access$400(r10).iterator();
    L36:
        if (r11.hasNext() == false) goto L31;
        ((Transition.TransitionOnClick) r11.next()).addOnClickListeners(motionLayout, currentState, r10);
        goto L36
    }

    public Transition bestTransitionFor(int currentState, float dx, float dy, MotionEvent lastTouchDown) {
        if (currentState == (-1)) goto L37;
        List<Transition> r4 = getTransitionsWithState(currentState);
        RectF r5 = new RectF();
        Iterator<Transition> r6 = r4.iterator();
        float r7 = 0.0f;
        Transition r8 = null;
    L6:
        if (r6.hasNext() == false) goto L35;
        Transition r9 = r6.next();
        if (Transition.access$500(r9) == true) goto L6;
        if (Transition.access$200(r9) == null) goto L6;
        Transition.access$200(r9).setRTL(this.mRtl);
        RectF r10 = Transition.access$200(r9).getTouchRegion(this.mMotionLayout, r5);
        if (r10 == null) goto L18;
        if (lastTouchDown == null) goto L18;
        if (r10.contains(lastTouchDown.getX(), lastTouchDown.getY()) == false) goto L6;
    L18:
        RectF r11 = Transition.access$200(r9).getLimitBoundsTo(this.mMotionLayout, r5);
        if (r11 == null) goto L24;
        if (lastTouchDown == null) goto L24;
        if (r11.contains(lastTouchDown.getX(), lastTouchDown.getY()) == false) goto L6;
    L24:
        float r12 = Transition.access$200(r9).dot(dx, dy);
        if (Transition.access$200(r9).mIsRotateMode == false) goto L29;
        if (lastTouchDown == null) goto L29;
        float r13 = lastTouchDown.getX() - Transition.access$200(r9).mRotateCenterX;
        float r14 = lastTouchDown.getY() - Transition.access$200(r9).mRotateCenterY;
        r12 = ((float) (Math.atan2(dy + r14, dx + r13) - Math.atan2(r13, r14))) * 10.0f;
    L29:
        if (Transition.access$000(r9) != currentState) goto L31;
        float r15 = -1.0f;
    L32:
        float r16 = r12 * r15;
        if (r16 <= r7) goto L6;
        r8 = r9;
        r7 = r16;
        goto L6
    L31:
        r15 = 1.1f;
        goto L32
    L35:
        return r8;
    L37:
        return this.mCurrentTransition;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public Transition getTransitionById(int id) {
        Iterator<Transition> r2 = this.mTransitionList.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Transition r0 = r2.next();
        if (Transition.access$300(r0) != id) goto L4;
        return r0;
    L8:
        return null;
    }

    public int[] getConstraintSetIds() {
        int r0 = this.mConstraintSetMap.size();
        int[] r1 = new int[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.mConstraintSetMap.keyAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    boolean autoTransition(MotionLayout motionLayout, int currentState) {
        if (isProcessingTouch() == false) goto L6;
        return false;
    L6:
        if (this.mDisableAutoTransition == false) goto L8;
        return false;
    L8:
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L10:
        if (r0.hasNext() == false) goto L41;
        Transition r2 = r0.next();
        if (Transition.access$600(r2) == 0) goto L10;
        Transition r3 = this.mCurrentTransition;
        if (r3 != r2) goto L20;
        if (r3.isTransitionFlag(2) == true) goto L10;
    L20:
        if (currentState != Transition.access$100(r2)) goto L31;
        if (Transition.access$600(r2) == 4) goto L25;
        if (Transition.access$600(r2) != 2) goto L31;
    L25:
        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
        motionLayout.setTransition(r2);
        if (Transition.access$600(r2) != 4) goto L28;
        motionLayout.transitionToEnd();
        motionLayout.setState(MotionLayout.TransitionState.SETUP);
        motionLayout.setState(MotionLayout.TransitionState.MOVING);
    L29:
        return true;
    L28:
        motionLayout.setProgress(1.0f);
        motionLayout.evaluate(true);
        motionLayout.setState(MotionLayout.TransitionState.SETUP);
        motionLayout.setState(MotionLayout.TransitionState.MOVING);
        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
        motionLayout.onNewStateAttachHandlers();
    L31:
        if (currentState != Transition.access$000(r2)) goto L10;
        if (Transition.access$600(r2) == 3) goto L36;
        if (Transition.access$600(r2) != 1) goto L10;
    L36:
        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
        motionLayout.setTransition(r2);
        if (Transition.access$600(r2) != 3) goto L39;
        motionLayout.transitionToStart();
        motionLayout.setState(MotionLayout.TransitionState.SETUP);
        motionLayout.setState(MotionLayout.TransitionState.MOVING);
    L40:
        return true;
    L39:
        motionLayout.setProgress(0.0f);
        motionLayout.evaluate(true);
        motionLayout.setState(MotionLayout.TransitionState.SETUP);
        motionLayout.setState(MotionLayout.TransitionState.MOVING);
        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
        motionLayout.onNewStateAttachHandlers();
        goto L40
    L41:
        return false;
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setRtl(boolean rtl) {
        this.mRtl = rtl;
        Transition r1 = this.mCurrentTransition;
        if (r1 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r1) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        return;
    }

    public void viewTransition(int id, View... view) {
        this.mViewTransitionController.viewTransition(id, view);
    }

    public void enableViewTransition(int id, boolean enable) {
        this.mViewTransitionController.enableViewTransition(id, enable);
    }

    public boolean isViewTransitionEnabled(int id) {
        return this.mViewTransitionController.isViewTransitionEnabled(id);
    }

    public boolean applyViewTransition(int viewTransitionId, MotionController motionController) {
        return this.mViewTransitionController.applyViewTransition(viewTransitionId, motionController);
    }

    public MotionScene(MotionLayout layout) {
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = layout;
        this.mViewTransitionController = new ViewTransitionController(layout);
    }

    MotionScene(Context context, MotionLayout layout, int resourceID) {
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = layout;
        this.mViewTransitionController = new ViewTransitionController(layout);
        load(context, resourceID);
        this.mConstraintSetMap.put(R.id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    private void load(Context context, int resourceId) {
        XmlResourceParser r0 = context.getResources().getXml(resourceId);
        int r1 = r0.getEventType();     // Catch: IOException -> L81 XmlPullParserException -> L83
        Transition r2 = null;
    L4:
        byte r3 = 1;
        if (r1 == 1) goto L117;
        if (r1 != 0) goto L8;
        r0.getName();     // Catch: IOException -> L81 XmlPullParserException -> L83
    L79:
        r1 = r0.next();     // Catch: IOException -> L81 XmlPullParserException -> L83
    L8:
        if (r1 != 2) goto L79;
        String r4 = r0.getName();     // Catch: IOException -> L81 XmlPullParserException -> L83
        if (this.DEBUG_DESKTOP == false) goto L15;
        System.out.println("parsing = " + r4);     // Catch: IOException -> L81 XmlPullParserException -> L83
    L15:
        switch(r4.hashCode()) {
            case -1349929691: goto L45;
            case -1239391468: goto L42;
            case -687739768: goto L39;
            case 61998586: goto L36;
            case 269306229: goto L33;
            case 312750793: goto L30;
            case 327855227: goto L27;
            case 793277014: goto L24;
            case 1382829617: goto L21;
            case 1942574248: goto L18;
            default: goto L115;
        };
    L115:
        r3 = -1;
    L48:
        switch(r3) {
            case 0: goto L77;
            case 1: goto L63;
            case 2: goto L59;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L55;
            case 6: goto L54;
            case 7: goto L54;
            case 8: goto L51;
            case 9: goto L50;
            default: goto L79;
        };     // Catch: IOException -> L81 XmlPullParserException -> L83
    L50:
        this.mViewTransitionController.add(new ViewTransition(context, r0));     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L51:
        KeyFrames r5 = new KeyFrames(context, r0);     // Catch: IOException -> L81 XmlPullParserException -> L83
        if (r2 == null) goto L79;
        Transition.access$1400(r2).add(r5);     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L54:
        parseInclude(context, r0);     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L55:
        parseConstraintSet(context, r0);     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L56:
        this.mStateSet = new StateSet(context, r0);     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L57:
        if (r2 == null) goto L79;
        r2.addOnClick(context, r0);     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L59:
        if (r2 != null) goto L61;
        Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(resourceId) + ".xml:" + r0.getLineNumber() + ")");     // Catch: IOException -> L81 XmlPullParserException -> L83
    L61:
        if (r2 == null) goto L79;
        Transition.access$202(r2, new TouchResponse(context, this.mMotionLayout, r0));     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L63:
        ArrayList<Transition> r6 = this.mTransitionList;     // Catch: IOException -> L81 XmlPullParserException -> L83
        r2 = new Transition(this, context, r0);     // Catch: IOException -> L81 XmlPullParserException -> L83
        r6.add(r2);     // Catch: IOException -> L81 XmlPullParserException -> L83
        if (this.mCurrentTransition != null) goto L71;
        if (Transition.access$1300(r2) == true) goto L71;
        this.mCurrentTransition = r2;     // Catch: IOException -> L81 XmlPullParserException -> L83
        if (Transition.access$200(r2) == null) goto L71;
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);     // Catch: IOException -> L81 XmlPullParserException -> L83
    L71:
        if (Transition.access$1300(r2) == false) goto L79;
        if (Transition.access$000(r2) != (-1)) goto L75;
        this.mDefaultTransition = r2;     // Catch: IOException -> L81 XmlPullParserException -> L83
    L76:
        this.mTransitionList.remove(r2);     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L75:
        this.mAbstractTransitionList.add(r2);     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L76
    L77:
        parseMotionSceneTags(context, r0);     // Catch: IOException -> L81 XmlPullParserException -> L83
        goto L79
    L18:
        if (r4.equals(INCLUDE_TAG) == false) goto L47;
        r3 = 6;
        goto L48
    L47:
        r3 = -1;
        goto L48
    L21:
        if (r4.equals(STATESET_TAG) == false) goto L106;
        r3 = 4;
        goto L48
    L106:
        r3 = -1;
        goto L48
    L24:
        if (r4.equals("MotionScene") == false) goto L107;
        r3 = 0;
        goto L48
    L107:
        r3 = -1;
        goto L48
    L27:
        if (r4.equals(ONSWIPE_TAG) == false) goto L108;
        r3 = 2;
        goto L48
    L108:
        r3 = -1;
        goto L48
    L30:
        if (r4.equals(ONCLICK_TAG) == false) goto L109;
        r3 = 3;
        goto L48
    L109:
        r3 = -1;
        goto L48
    L33:
        if (r4.equals(TRANSITION_TAG) == true) goto L48;
        r3 = -1;
        goto L48
    L36:
        if (r4.equals("ViewTransition") == false) goto L111;
        r3 = 9;
        goto L48
    L111:
        r3 = -1;
        goto L48
    L39:
        if (r4.equals(INCLUDE_TAG_UC) == false) goto L112;
        r3 = 7;
        goto L48
    L112:
        r3 = -1;
        goto L48
    L42:
        if (r4.equals("KeyFrameSet") == false) goto L113;
        r3 = 8;
        goto L48
    L113:
        r3 = -1;
        goto L48
    L45:
        if (r4.equals(CONSTRAINTSET_TAG) == false) goto L114;
        r3 = 5;
        goto L48
    L114:
        r3 = -1;
        goto L48
    L117:
        return;
    L81:
        e = move-exception;
        e.printStackTrace();
        return;
    L83:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseMotionSceneTags(Context context, XmlPullParser parser) {
        TypedArray r5 = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.MotionScene);
        int r6 = r5.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L13;
        int r2 = r5.getIndex(r1);
        if (r2 != R.styleable.MotionScene_defaultDuration) goto L10;
        int r3 = r5.getInt(r2, this.mDefaultDuration);
        this.mDefaultDuration = r3;
        if (r3 >= 8) goto L12;
        this.mDefaultDuration = 8;
    L12:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r2 != R.styleable.MotionScene_layoutDuringTransition) goto L12;
        this.mLayoutDuringTransition = r5.getInteger(r2, 0);
        goto L12
    L13:
        r5.recycle();
    }

    private int getId(Context context, String idString) {
        if (idString.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L7;
        int r6 = context.getResources().getIdentifier(idString.substring(idString.indexOf(47) + 1), SlardarConfigConsts.CONFIG_ID, context.getPackageName());
        if (this.DEBUG_DESKTOP == false) goto L8;
        System.out.println("id getMap res = " + r6);
    L8:
        if (r6 != (-1)) goto L15;
        if (idString != null) goto L11;
    L13:
        Log.e("MotionScene", "error in parsing id");
        return r6;
    L11:
        if (idString.length() <= 1) goto L13;
        return Integer.parseInt(idString.substring(1));
    L15:
        return r6;
    L7:
        r6 = -1;
        goto L8
    }

    private void parseInclude(Context context, XmlPullParser mainParser) {
        TypedArray r6 = context.obtainStyledAttributes(Xml.asAttributeSet(mainParser), R.styleable.include);
        int r0 = r6.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r6.getIndex(r1);
        if (r2 != R.styleable.include_constraintSet) goto L7;
        parseInclude(context, r6.getResourceId(r2, -1));
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        r6.recycle();
    }

    private int parseInclude(Context context, int resourceId) {
        XmlResourceParser r5 = context.getResources().getXml(resourceId);
        int r0 = r5.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L5:
        if (r0 == 1) goto L27;
        String r1 = r5.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (2 != r0) goto L12;
        if (CONSTRAINTSET_TAG.equals(r1) == false) goto L12;
        return parseConstraintSet(context, r5);
    L12:
        r0 = r5.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L5
    L27:
        return -1;
    L14:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    private int parseConstraintSet(Context context, XmlPullParser parser) {
        ConstraintSet r0 = new ConstraintSet();
        r0.setForceId(false);
        int r2 = parser.getAttributeCount();
        int r4 = 0;
        int r5 = -1;
        int r6 = -1;
    L4:
        if (r4 >= r2) goto L60;
        String r8 = parser.getAttributeName(r4);
        String r9 = parser.getAttributeValue(r4);
        if (this.DEBUG_DESKTOP == false) goto L8;
        System.out.println("id string = " + r9);
    L8:
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1496482599: goto L20;
            case -1153153640: goto L16;
            case 3355: goto L12;
            default: goto L10;
        };
    L10:
        byte r10 = -1;
    L23:
        switch(r10) {
            case 0: goto L58;
            case 1: goto L69;
            case 2: goto L25;
            default: goto L59;
        };
    L25:
        r5 = getId(context, r9);
        this.mConstraintSetIdMap.put(stripID(r9), Integer.valueOf(r5));
        r0.mIdString = Debug.getName(context, r5);
        goto L59
    L58:
        r6 = getId(context, r9);
        goto L59
    L69:
        r0.mRotate = Integer.parseInt(r9);     // Catch: NumberFormatException -> L28
    L28:
        r9.hashCode();
        switch(r9.hashCode()) {
            case -768416914: goto L48;
            case 3317767: goto L44;
            case 3387192: goto L40;
            case 108511772: goto L36;
            case 1954540437: goto L32;
            default: goto L30;
        };
    L30:
        byte r11 = -1;
    L51:
        switch(r11) {
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L53;
            default: goto L59;
        };
    L53:
        r0.mRotate = 3;
        goto L59
    L54:
        r0.mRotate = 1;
        goto L59
    L55:
        r0.mRotate = 0;
        goto L59
    L56:
        r0.mRotate = 2;
        goto L59
    L57:
        r0.mRotate = 4;
        goto L59
    L32:
        if (r9.equals("x_right") == false) goto L85;
        r11 = 4;
        goto L51
    L85:
        r11 = -1;
        goto L51
    L36:
        if (r9.equals("right") == false) goto L86;
        r11 = 3;
        goto L51
    L86:
        r11 = -1;
        goto L51
    L40:
        if (r9.equals("none") == false) goto L87;
        r11 = 2;
        goto L51
    L87:
        r11 = -1;
        goto L51
    L44:
        if (r9.equals("left") == false) goto L88;
        r11 = 1;
        goto L51
    L88:
        r11 = -1;
        goto L51
    L48:
        if (r9.equals("x_left") == false) goto L89;
        r11 = 0;
        goto L51
    L89:
        r11 = -1;
    L59:
        r4 = r4 + 1;
        goto L4
    L12:
        if (r8.equals(SlardarConfigConsts.CONFIG_ID) == false) goto L82;
        r10 = 2;
        goto L23
    L82:
        r10 = -1;
        goto L23
    L16:
        if (r8.equals("constraintRotate") == false) goto L83;
        r10 = 1;
        goto L23
    L83:
        r10 = -1;
        goto L23
    L20:
        if (r8.equals("deriveConstraintsFrom") == false) goto L84;
        r10 = 0;
        goto L23
    L84:
        r10 = -1;
        goto L23
    L60:
        if (r5 != (-1)) goto L62;
    L68:
        return r5;
    L62:
        if (this.mMotionLayout.mDebugPath == 0) goto L64;
        r0.setValidateOnParse(true);
    L64:
        r0.load(context, parser);
        if (r6 == (-1)) goto L67;
        this.mDeriveMap.put(r5, r6);
    L67:
        this.mConstraintSetMap.put(r5, r0);
        goto L68
    }

    public ConstraintSet getConstraintSet(Context context, String id) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        System.out.println("id " + id);
        System.out.println("size " + this.mConstraintSetMap.size());
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mConstraintSetMap.size()) goto L16;
        int r1 = this.mConstraintSetMap.keyAt(r0);
        String r2 = context.getResources().getResourceName(r1);
        if (this.DEBUG_DESKTOP == false) goto L12;
        System.out.println("Id for <" + r0 + "> is <" + r2 + "> looking for <" + id + ">");
    L12:
        if (id.equals(r2) == true) goto L14;
        r0 = r0 + 1;
        goto L7
    L14:
        return this.mConstraintSetMap.get(r1);
    L16:
        return null;
    }

    ConstraintSet getConstraintSet(int id) {
        return getConstraintSet(id, -1, -1);
    }

    ConstraintSet getConstraintSet(int id, int width, int height) {
        if (this.DEBUG_DESKTOP == false) goto L5;
        System.out.println("id " + id);
        System.out.println("size " + this.mConstraintSetMap.size());
    L5:
        StateSet r0 = this.mStateSet;
        if (r0 == null) goto L11;
        int r5 = r0.stateGetConstraintID(id, width, height);
        if (r5 == (-1)) goto L11;
        id = r5;
    L11:
        if (this.mConstraintSetMap.get(id) != null) goto L15;
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), id) + " In MotionScene");
        SparseArray<ConstraintSet> r3 = this.mConstraintSetMap;
        return r3.get(r3.keyAt(0));
    L15:
        return this.mConstraintSetMap.get(id);
    }

    public void setConstraintSet(int id, ConstraintSet set) {
        this.mConstraintSetMap.put(id, set);
    }

    public void getKeyFrames(MotionController motionController) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L11;
        Transition r1 = this.mDefaultTransition;
        if (r1 == null) goto L10;
        Iterator r2 = Transition.access$1400(r1).iterator();
    L8:
        if (r2.hasNext() == false) goto L18;
        ((KeyFrames) r2.next()).addFrames(motionController);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r3 = Transition.access$1400(r0).iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        ((KeyFrames) r3.next()).addFrames(motionController);
        goto L13
    }

    Key getKeyFrame(Context context, int type, int target, int position) {
        Transition r5 = this.mCurrentTransition;
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator r6 = Transition.access$1400(r5).iterator();
    L7:
        if (r6.hasNext() == false) goto L21;
        KeyFrames r0 = (KeyFrames) r6.next();
        Iterator<Integer> r1 = r0.getKeys().iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        Integer r2 = r1.next();
        if (target != r2.intValue()) goto L10;
        Iterator<Key> r3 = r0.getKeyFramesForView(r2.intValue()).iterator();
    L15:
        if (r3.hasNext() == false) goto L10;
        Key r4 = r3.next();
        if (r4.mFramePosition != position) goto L15;
        if (r4.mType != type) goto L15;
        return r4;
    L21:
        return null;
    }

    int getTransitionDirection(int stateId) {
        Iterator<Transition> r1 = this.mTransitionList.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (Transition.access$100(r1.next()) != stateId) goto L4;
        return 0;
    L9:
        return 1;
    }

    boolean hasKeyFramePosition(View view, int position) {
        Transition r3 = this.mCurrentTransition;
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator r4 = Transition.access$1400(r3).iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        Iterator<Key> r1 = ((KeyFrames) r4.next()).getKeyFramesForView(view.getId()).iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        if (r1.next().mFramePosition != position) goto L10;
        return true;
    L15:
        return false;
    }

    public void setKeyframe(View view, int position, String name, Object value) {
        Transition r2 = this.mCurrentTransition;
        if (r2 != null) goto L5;
        return;
    L5:
        Iterator r3 = Transition.access$1400(r2).iterator();
    L7:
        if (r3.hasNext() == false) goto L16;
        Iterator<Key> r0 = ((KeyFrames) r3.next()).getKeyFramesForView(view.getId()).iterator();
    L10:
        if (r0.hasNext() == false) goto L7;
        if (r0.next().mFramePosition != position) goto L10;
        if (value == null) goto L15;
        ((Float) value).floatValue();
    L15:
        name.equalsIgnoreCase("app:PerpendicularPath_percent");
        goto L10
    }

    boolean supportTouch() {
        Iterator<Transition> r0 = this.mTransitionList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Transition.access$200(r0.next()) == null) goto L4;
        return true;
    L8:
        Transition r3 = this.mCurrentTransition;
        if (r3 != null) goto L11;
    L13:
        return false;
    L11:
        if (Transition.access$200(r3) == null) goto L13;
        return true;
    }

    void processTouchEvent(MotionEvent event, int currentState, MotionLayout motionLayout) {
        RectF r0 = new RectF();
        if (this.mVelocityTracker != null) goto L5;
        this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
    L5:
        this.mVelocityTracker.addMovement(event);
        if (currentState == (-1)) goto L47;
        int r4 = event.getAction();
        boolean r5 = false;
        if (r4 != 0) goto L10;
        this.mLastTouchX = event.getRawX();
        this.mLastTouchY = event.getRawY();
        this.mLastTouchDown = event;
        this.mIgnoreTouch = false;
        if (Transition.access$200(this.mCurrentTransition) == null) goto L65;
        RectF r12 = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, r0);
        if (r12 != null) goto L35;
    L38:
        RectF r13 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r0);
        if (r13 != null) goto L41;
    L43:
        this.mMotionOutsideRegion = false;
    L44:
        Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
        return;
    L41:
        if (r13.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L43;
        this.mMotionOutsideRegion = true;
        goto L44
    L35:
        if (r12.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L38;
        this.mLastTouchDown = null;
        this.mIgnoreTouch = true;
        return;
    L65:
        return;
    L10:
        if (r4 != 2) goto L47;
        if (this.mIgnoreTouch == true) goto L47;
        float r6 = event.getRawY() - this.mLastTouchY;
        float r7 = event.getRawX() - this.mLastTouchX;
        if (r7 == 0.0d) goto L18;
    L19:
        MotionEvent r8 = this.mLastTouchDown;
        if (r8 == null) goto L64;
        Transition r9 = bestTransitionFor(currentState, r7, r6, r8);
        if (r9 == null) goto L47;
        motionLayout.setTransition(r9);
        RectF r1 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, r0);
        if (r1 != null) goto L27;
    L29:
        this.mMotionOutsideRegion = r5;
        Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
        goto L47
    L27:
        if (r1.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY()) == true) goto L29;
        r5 = true;
        goto L29
    L64:
        return;
    L18:
        if (r6 != 0.0d) goto L19;
        return;
    L47:
        if (this.mIgnoreTouch == false) goto L49;
        return;
    L49:
        Transition r2 = this.mCurrentTransition;
        if (r2 != null) goto L52;
    L56:
        this.mLastTouchX = event.getRawX();
        this.mLastTouchY = event.getRawY();
        if (event.getAction() != 1) goto L66;
        MotionLayout.MotionTracker r14 = this.mVelocityTracker;
        if (r14 == null) goto L67;
        r14.recycle();
        this.mVelocityTracker = null;
        if (motionLayout.mCurrentState == (-1)) goto L68;
        autoTransition(motionLayout, motionLayout.mCurrentState);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L52:
        if (Transition.access$200(r2) == null) goto L56;
        if (this.mMotionOutsideRegion == true) goto L56;
        Transition.access$200(this.mCurrentTransition).processTouchEvent(event, this.mVelocityTracker, currentState, this);
        goto L56
    }

    void processScrollMove(float dx, float dy) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollMove(dx, dy);
        return;
    }

    void processScrollUp(float dx, float dy) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).scrollUp(dx, dy);
        return;
    }

    float getProgressDirection(float dx, float dy) {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getProgressDirection(dx, dy);
    }

    int getStartId() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$100(r0);
    }

    int getEndId() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$000(r0);
    }

    public Interpolator getInterpolator() {
        int r0 = Transition.access$1500(this.mCurrentTransition);
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
        final Easing r1 = Easing.getInterpolator(Transition.access$1600(this.mCurrentTransition));
        return new AnonymousClass1(this, r1);
    L34:
        return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), Transition.access$1700(this.mCurrentTransition));
    }

    public int getDuration() {
        Transition r0 = this.mCurrentTransition;
        if (r0 == null) goto L7;
        return Transition.access$1800(r0);
    L7:
        return this.mDefaultDuration;
    }

    public void setDuration(int duration) {
        Transition r0 = this.mCurrentTransition;
        if (r0 == null) goto L5;
        r0.setDuration(duration);
        return;
    L5:
        this.mDefaultDuration = duration;
    }

    public int gatPathMotionArc() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.access$1900(r0);
    }

    public float getStaggered() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        return Transition.access$2000(r0);
    }

    float getMaxAcceleration() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    float getMaxVelocity() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    float getSpringStiffiness() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringStiffness();
    }

    float getSpringMass() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringMass();
    }

    float getSpringDamping() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringDamping();
    }

    float getSpringStopThreshold() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringStopThreshold();
    }

    int getSpringBoundary() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.access$200(this.mCurrentTransition).getSpringBoundary();
    }

    int getAutoCompleteMode() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.access$200(this.mCurrentTransition).getAutoCompleteMode();
    }

    void setupTouch() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.access$200(r0) == null) goto L9;
        Transition.access$200(this.mCurrentTransition).setupTouch();
        return;
    }

    boolean getMoveWhenScrollAtTop() {
        Transition r0 = this.mCurrentTransition;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Transition.access$200(r0) != null) goto L7;
        return false;
    L7:
        return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    void readFallback(MotionLayout motionLayout) {
        int r0 = 0;
    L4:
        if (r0 >= this.mConstraintSetMap.size()) goto L10;
        int r1 = this.mConstraintSetMap.keyAt(r0);
        if (hasCycleDependency(r1) == true) goto L7;
        readConstraintChain(r1, motionLayout);
        r0 = r0 + 1;
        goto L4
    L7:
        Log.e("MotionScene", "Cannot be derived from yourself");
        return;
    }

    private boolean hasCycleDependency(int key) {
        int r0 = this.mDeriveMap.get(key);
        int r1 = this.mDeriveMap.size();
    L3:
        if (r0 <= 0) goto L11;
        if (r0 == key) goto L6;
        int r3 = r1 - 1;
        if (r1 < 0) goto L9;
        r0 = this.mDeriveMap.get(r0);
        r1 = r3;
        goto L3
    L9:
        return true;
    L6:
        return true;
    L11:
        return false;
    }

    private void readConstraintChain(int key, MotionLayout motionLayout) {
        ConstraintSet r0 = this.mConstraintSetMap.get(key);
        r0.derivedState = r0.mIdString;
        int r3 = this.mDeriveMap.get(key);
        if (r3 <= 0) goto L9;
        readConstraintChain(r3, motionLayout);
        ConstraintSet r4 = this.mConstraintSetMap.get(r3);
        if (r4 != null) goto L8;
        Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), r3));
        return;
    L8:
        r0.derivedState += LibrarianImpl.Constants.SEPARATOR + r4.derivedState;
        r0.readFallback(r4);
    L10:
        r0.applyDeltaFrom(r0);
        return;
    L9:
        r0.derivedState += "  layout";
        r0.readFallback(motionLayout);
        goto L10
    }

    public static String stripID(String id) {
        if (id != null) goto L5;
        return "";
    L5:
        int r0 = id.indexOf(47);
        if (r0 >= 0) goto L9;
        return id;
    L9:
        return id.substring(r0 + 1);
    }

    public int lookUpConstraintId(String id) {
        Integer r0 = this.mConstraintSetIdMap.get(id);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public String lookUpConstraintName(int id) {
        Iterator<Map.Entry<String, Integer>> r2 = this.mConstraintSetIdMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<String, Integer> r0 = r2.next();
        Integer r1 = r0.getValue();
        if (r1 == null) goto L4;
        if (r1.intValue() != id) goto L4;
        return r0.getKey();
    L12:
        return null;
    }

    public void disableAutoTransition(boolean disable) {
        this.mDisableAutoTransition = disable;
    }

    static String getLine(Context context, int resourceId, XmlPullParser pullParser) {
        return ".(" + Debug.getName(context, resourceId) + ".xml:" + pullParser.getLineNumber() + ") \"" + pullParser.getName() + "\"";
    }
}
