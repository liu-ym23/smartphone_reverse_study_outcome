package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.android.settings.utils.HanziToPinyin;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class KeyTrigger extends Key {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    private static final String TAG = "KeyTrigger";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    RectF mCollisionRect;
    private String mCross;
    private int mCurveFit;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private boolean mFireNegativeReset;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    HashMap<String, Method> mMethodHashMap;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;
    int mViewTransitionOnCross;
    int mViewTransitionOnNegativeCross;
    int mViewTransitionOnPositiveCross;

    private static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static final int VT_CROSS = 12;
        private static final int VT_NEGATIVE_CROSS = 13;
        private static final int VT_POSITIVE_CROSS = 14;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray r0 = new SparseIntArray();
            mAttrMap = r0;
            r0.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            mAttrMap.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void read(KeyTrigger c, TypedArray a, Context context) {
            int r6 = a.getIndexCount();
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L29;
            int r1 = a.getIndex(r0);
            switch(mAttrMap.get(r1)) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L6;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L6:
            Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(r1) + "   " + mAttrMap.get(r1));
        L28:
            r0 = r0 + 1;
            goto L3
        L7:
            c.mViewTransitionOnPositiveCross = a.getResourceId(r1, c.mViewTransitionOnPositiveCross);
            goto L28
        L8:
            c.mViewTransitionOnNegativeCross = a.getResourceId(r1, c.mViewTransitionOnNegativeCross);
            goto L28
        L9:
            c.mViewTransitionOnCross = a.getResourceId(r1, c.mViewTransitionOnCross);
            goto L28
        L10:
            KeyTrigger.access$702(c, a.getResourceId(r1, KeyTrigger.access$700(c)));
            goto L28
        L11:
            KeyTrigger.access$602(c, a.getBoolean(r1, KeyTrigger.access$600(c)));
            goto L28
        L12:
            KeyTrigger.access$502(c, a.getResourceId(r1, KeyTrigger.access$500(c)));
            goto L28
        L13:
            c.mFramePosition = a.getInteger(r1, c.mFramePosition);
            KeyTrigger.access$002(c, (c.mFramePosition + 0.5f) / 100.0f);
            goto L28
        L23:
            KeyTrigger.access$402(c, a.getResourceId(r1, KeyTrigger.access$400(c)));
            goto L28
        L24:
            c.mTriggerSlack = a.getFloat(r1, c.mTriggerSlack);
            goto L28
        L25:
            KeyTrigger.access$302(c, a.getString(r1));
            goto L28
        L26:
            KeyTrigger.access$202(c, a.getString(r1));
            goto L28
        L27:
            KeyTrigger.access$102(c, a.getString(r1));
            goto L28
        L15:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L20;
            c.mTargetId = a.getResourceId(r1, c.mTargetId);
            if (c.mTargetId != (-1)) goto L28;
            c.mTargetString = a.getString(r1);
            goto L28
        L20:
            if (a.peekValue(r1).type != 3) goto L22;
            c.mTargetString = a.getString(r1);
            goto L28
        L22:
            c.mTargetId = a.getResourceId(r1, c.mTargetId);
            goto L28
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> attributes) {
    }

    public KeyTrigger() {
        this.mCurveFit = -1;
        this.mCross = null;
        this.mTriggerReceiver = UNSET;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = UNSET;
        this.mTriggerCollisionId = UNSET;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mViewTransitionOnNegativeCross = UNSET;
        this.mViewTransitionOnPositiveCross = UNSET;
        this.mViewTransitionOnCross = UNSET;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mMethodHashMap = new HashMap();
        this.mType = 5;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$002(KeyTrigger r0, float r1) {
        r0.mFireThreshold = r1;
        return r1;
    }

    static /* synthetic */ String access$102(KeyTrigger r0, String r1) {
        r0.mNegativeCross = r1;
        return r1;
    }

    static /* synthetic */ String access$202(KeyTrigger r0, String r1) {
        r0.mPositiveCross = r1;
        return r1;
    }

    static /* synthetic */ String access$302(KeyTrigger r0, String r1) {
        r0.mCross = r1;
        return r1;
    }

    static /* synthetic */ int access$400(KeyTrigger r0) {
        return r0.mTriggerID;
    }

    static /* synthetic */ int access$402(KeyTrigger r0, int r1) {
        r0.mTriggerID = r1;
        return r1;
    }

    static /* synthetic */ int access$500(KeyTrigger r0) {
        return r0.mTriggerCollisionId;
    }

    static /* synthetic */ int access$502(KeyTrigger r0, int r1) {
        r0.mTriggerCollisionId = r1;
        return r1;
    }

    static /* synthetic */ boolean access$600(KeyTrigger r0) {
        return r0.mPostLayout;
    }

    static /* synthetic */ boolean access$602(KeyTrigger r0, boolean r1) {
        r0.mPostLayout = r1;
        return r1;
    }

    static /* synthetic */ int access$700(KeyTrigger r0) {
        return r0.mTriggerReceiver;
    }

    static /* synthetic */ int access$702(KeyTrigger r0, int r1) {
        r0.mTriggerReceiver = r1;
        return r1;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo12clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyTrigger), context);
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String tag, Object value) {
        tag.hashCode();
        byte r1 = -1;
        switch(tag.hashCode()) {
            case -1594793529: goto L50;
            case -966421266: goto L46;
            case -786670827: goto L42;
            case -648752941: goto L38;
            case -638126837: goto L34;
            case -76025313: goto L30;
            case -9754574: goto L26;
            case 64397344: goto L22;
            case 364489912: goto L18;
            case 1301930599: goto L14;
            case 1401391082: goto L10;
            case 1535404999: goto L6;
            default: goto L53;
        };
    L53:
        switch(r1) {
            case 0: goto L66;
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L61;
            case 6: goto L60;
            case 7: goto L59;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L56;
            case 11: goto L55;
            default: goto L79;
        };
    L55:
        this.mTriggerReceiver = toInt(value);
        return;
    L56:
        this.mPostLayout = toBoolean(value);
        return;
    L57:
        this.mViewTransitionOnCross = toInt(value);
        return;
    L58:
        this.mTriggerSlack = toFloat(value);
        return;
    L59:
        this.mCross = value.toString();
        return;
    L60:
        this.mViewTransitionOnNegativeCross = toInt(value);
        return;
    L61:
        this.mTriggerCollisionView = (View) value;
        return;
    L62:
        this.mNegativeCross = value.toString();
        return;
    L63:
        this.mTriggerID = toInt(value);
        return;
    L64:
        this.mTriggerCollisionId = toInt(value);
        return;
    L65:
        this.mViewTransitionOnPositiveCross = toInt(value);
        return;
    L66:
        this.mPositiveCross = value.toString();
        return;
    L79:
        return;
    L6:
        if (tag.equals("triggerReceiver") == false) goto L53;
        r1 = 11;
        goto L53
    L10:
        if (tag.equals("postLayout") == false) goto L53;
        r1 = 10;
        goto L53
    L14:
        if (tag.equals("viewTransitionOnCross") == false) goto L53;
        r1 = 9;
        goto L53
    L18:
        if (tag.equals("triggerSlack") == false) goto L53;
        r1 = 8;
        goto L53
    L22:
        if (tag.equals("CROSS") == false) goto L53;
        r1 = 7;
        goto L53
    L26:
        if (tag.equals("viewTransitionOnNegativeCross") == false) goto L53;
        r1 = 6;
        goto L53
    L30:
        if (tag.equals("triggerCollisionView") == false) goto L53;
        r1 = 5;
        goto L53
    L34:
        if (tag.equals("negativeCross") == false) goto L53;
        r1 = 4;
        goto L53
    L38:
        if (tag.equals("triggerID") == false) goto L53;
        r1 = 3;
        goto L53
    L42:
        if (tag.equals("triggerCollisionId") == false) goto L53;
        r1 = 2;
        goto L53
    L46:
        if (tag.equals("viewTransitionOnPositiveCross") == false) goto L53;
        r1 = 1;
        goto L53
    L50:
        if (tag.equals("positiveCross") == false) goto L53;
        r1 = 0;
        goto L53
    }

    private void setUpRect(RectF rect, View child, boolean postLayout) {
        rect.top = child.getTop();
        rect.bottom = child.getBottom();
        rect.left = child.getLeft();
        rect.right = child.getRight();
        if (postLayout == false) goto L6;
        child.getMatrix().mapRect(rect);
        return;
    }

    public void conditionallyFire(float pos, View child) {
        if (this.mTriggerCollisionId == UNSET) goto L28;
        if (this.mTriggerCollisionView != null) goto L7;
        this.mTriggerCollisionView = ((ViewGroup) child.getParent()).findViewById(this.mTriggerCollisionId);
    L7:
        setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
        setUpRect(this.mTargetRect, child, this.mPostLayout);
        if (this.mCollisionRect.intersect(this.mTargetRect) == false) goto L19;
        if (this.mFireCrossReset == false) goto L12;
        this.mFireCrossReset = false;
        boolean r0 = true;
    L14:
        if (this.mFirePositiveReset == false) goto L16;
        this.mFirePositiveReset = false;
        boolean r1 = true;
    L17:
        this.mFireNegativeReset = true;
        boolean r4 = r1;
        boolean r2 = false;
    L61:
        this.mFireLastPos = pos;
        if (r2 == true) goto L65;
        if (r0 == true) goto L65;
        if (r4 == true) goto L65;
    L67:
        if (this.mTriggerReceiver != UNSET) goto L69;
        View r10 = child;
    L70:
        if (r2 == false) goto L77;
        String r3 = this.mNegativeCross;
        if (r3 == null) goto L75;
        fire(r3, r10);
    L75:
        if (this.mViewTransitionOnNegativeCross == UNSET) goto L77;
        ((MotionLayout) child.getParent()).viewTransition(this.mViewTransitionOnNegativeCross, new View[]{r10});
    L77:
        if (r4 == false) goto L84;
        String r5 = this.mPositiveCross;
        if (r5 == null) goto L82;
        fire(r5, r10);
    L82:
        if (this.mViewTransitionOnPositiveCross == UNSET) goto L84;
        ((MotionLayout) child.getParent()).viewTransition(this.mViewTransitionOnPositiveCross, new View[]{r10});
    L84:
        if (r0 == false) goto L92;
        String r6 = this.mCross;
        if (r6 == null) goto L89;
        fire(r6, r10);
    L89:
        if (this.mViewTransitionOnCross == UNSET) goto L93;
        ((MotionLayout) child.getParent()).viewTransition(this.mViewTransitionOnCross, new View[]{r10});
        return;
    L93:
        return;
    L92:
        return;
    L69:
        r10 = ((MotionLayout) child.getParent()).findViewById(this.mTriggerReceiver);
    L65:
        ((MotionLayout) child.getParent()).fireTrigger(this.mTriggerID, r4, pos);
        goto L67
    L16:
        r1 = false;
        goto L17
    L12:
        r0 = false;
        goto L14
    L19:
        if (this.mFireCrossReset == true) goto L21;
        this.mFireCrossReset = true;
        r0 = true;
    L23:
        if (this.mFireNegativeReset == false) goto L25;
        this.mFireNegativeReset = false;
        r2 = true;
    L26:
        this.mFirePositiveReset = true;
    L60:
        r4 = false;
        goto L61
    L25:
        r2 = false;
        goto L26
    L21:
        r0 = false;
        goto L23
    L28:
        if (this.mFireCrossReset == false) goto L33;
        float r7 = this.mFireThreshold;
        if (((pos - r7) * (this.mFireLastPos - r7)) >= 0.0f) goto L35;
        this.mFireCrossReset = false;
        r0 = true;
    L37:
        if (this.mFireNegativeReset == false) goto L44;
        float r8 = this.mFireThreshold;
        float r9 = pos - r8;
        if (((this.mFireLastPos - r8) * r9) < 0.0f) goto L41;
    L46:
        boolean r11 = false;
    L48:
        if (this.mFirePositiveReset == false) goto L57;
        float r12 = this.mFireThreshold;
        float r13 = pos - r12;
        if (((this.mFireLastPos - r12) * r13) < 0.0f) goto L52;
    L54:
        boolean r14 = false;
    L55:
        boolean r15 = r11;
        r4 = r14;
        r2 = r15;
        goto L61
    L52:
        if (r13 <= 0.0f) goto L54;
        this.mFirePositiveReset = false;
        r14 = true;
        goto L55
    L57:
        if (Math.abs(pos - this.mFireThreshold) <= this.mTriggerSlack) goto L59;
        this.mFirePositiveReset = true;
    L59:
        r2 = r11;
        goto L60
    L41:
        if (r9 >= 0.0f) goto L46;
        this.mFireNegativeReset = false;
        r11 = true;
        goto L48
    L44:
        if (Math.abs(pos - this.mFireThreshold) <= this.mTriggerSlack) goto L46;
        this.mFireNegativeReset = true;
    L35:
        r0 = false;
        goto L37
    L33:
        if (Math.abs(pos - this.mFireThreshold) <= this.mTriggerSlack) goto L35;
        this.mFireCrossReset = true;
        goto L35
    }

    private void fire(String str, View call) {
        if (str != null) goto L5;
        return;
    L5:
        if (str.startsWith(".") == false) goto L9;
        fireCustom(str, call);
        return;
    L9:
        if (this.mMethodHashMap.containsKey(str) == false) goto L13;
        Method r0 = this.mMethodHashMap.get(str);
        if (r0 != null) goto L15;
        return;
    L15:
        if (r0 != null) goto L26;
        r0 = call.getClass().getMethod(str, new Class[0]);     // Catch: NoSuchMethodException -> L18
        this.mMethodHashMap.put(str, r0);     // Catch: NoSuchMethodException -> L18
    L18:
        this.mMethodHashMap.put(str, null);
        Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + call.getClass().getSimpleName() + HanziToPinyin.Token.SEPARATOR + Debug.getName(call));
        return;
    L26:
        r0.invoke(call, new Object[0]);     // Catch: Exception -> L22
        return;
    L22:
        Log.e("KeyTrigger", "Exception in call \"" + this.mCross + "\"on class " + call.getClass().getSimpleName() + HanziToPinyin.Token.SEPARATOR + Debug.getName(call));
        return;
    L13:
        r0 = null;
        goto L15
    }

    private void fireCustom(String str, View view) {
        if (str.length() != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        str = str.substring(1).toLowerCase(Locale.ROOT);
    L8:
        Iterator<String> r1 = this.mCustomConstraints.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();
        String r3 = r2.toLowerCase(Locale.ROOT);
        if (r0 == true) goto L15;
        if (r3.matches(str) == false) goto L10;
    L15:
        ConstraintAttribute r4 = this.mCustomConstraints.get(r2);
        if (r4 == null) goto L10;
        r4.applyCustom(view);
        goto L10
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyTrigger r2 = (KeyTrigger) src;
        this.mCurveFit = r2.mCurveFit;
        this.mCross = r2.mCross;
        this.mTriggerReceiver = r2.mTriggerReceiver;
        this.mNegativeCross = r2.mNegativeCross;
        this.mPositiveCross = r2.mPositiveCross;
        this.mTriggerID = r2.mTriggerID;
        this.mTriggerCollisionId = r2.mTriggerCollisionId;
        this.mTriggerCollisionView = r2.mTriggerCollisionView;
        this.mTriggerSlack = r2.mTriggerSlack;
        this.mFireCrossReset = r2.mFireCrossReset;
        this.mFireNegativeReset = r2.mFireNegativeReset;
        this.mFirePositiveReset = r2.mFirePositiveReset;
        this.mFireThreshold = r2.mFireThreshold;
        this.mFireLastPos = r2.mFireLastPos;
        this.mPostLayout = r2.mPostLayout;
        this.mCollisionRect = r2.mCollisionRect;
        this.mTargetRect = r2.mTargetRect;
        this.mMethodHashMap = r2.mMethodHashMap;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyTrigger().copy(this);
    }
}
