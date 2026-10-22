package com.obric.oui.constraintlayout.core.motion;

import com.obric.oui.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.constraintlayout.core.state.WidgetFrame;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;
    Motion mMotion;
    private float mProgress;
    PropertySet mPropertySet;
    float mTransitionPathRotate;
    WidgetFrame mWidgetFrame;

    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public int mAnimateCircleAngleTo;
        public String mAnimateRelativeTo;
        public int mDrawPath;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;
        public int mPolarRelativeTo;
        public int mQuantizeInterpolatorID;
        public String mQuantizeInterpolatorString;
        public int mQuantizeInterpolatorType;
        public float mQuantizeMotionPhase;
        public int mQuantizeMotionSteps;
        public String mTransitionEasing;

        public Motion() {
            this.mAnimateRelativeTo = null;
            this.mAnimateCircleAngleTo = 0;
            this.mTransitionEasing = null;
            this.mPathMotionArc = -1;
            this.mDrawPath = 0;
            this.mMotionStagger = Float.NaN;
            this.mPolarRelativeTo = -1;
            this.mPathRotate = Float.NaN;
            this.mQuantizeMotionPhase = Float.NaN;
            this.mQuantizeMotionSteps = -1;
            this.mQuantizeInterpolatorString = null;
            this.mQuantizeInterpolatorType = -3;
            this.mQuantizeInterpolatorID = -1;
        }
    }

    public static class PropertySet {
        public float alpha;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public PropertySet() {
            this.visibility = 4;
            this.mVisibilityMode = 0;
            this.alpha = 1.0f;
            this.mProgress = Float.NaN;
        }
    }

    public MotionWidget findViewById(int r1) {
        return null;
    }

    public MotionWidget getParent() {
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return false;
    }

    public MotionWidget() {
        this.mWidgetFrame = new WidgetFrame();
        this.mMotion = new Motion();
        this.mPropertySet = new PropertySet();
    }

    public void setVisibility(int r1) {
        this.mPropertySet.visibility = r1;
    }

    public String getName() {
        return this.mWidgetFrame.getId();
    }

    public void layout(int r1, int r2, int r3, int r4) {
        setBounds(r1, r2, r3, r4);
    }

    public String toString() {
        return this.mWidgetFrame.left + ", " + this.mWidgetFrame.top + ", " + this.mWidgetFrame.right + ", " + this.mWidgetFrame.bottom;
    }

    public void setBounds(int r4, int r5, int r6, int r7) {
        if (this.mWidgetFrame != null) goto L5;
        ConstraintWidget r2 = (ConstraintWidget) null;
        this.mWidgetFrame = new WidgetFrame(null);
    L5:
        this.mWidgetFrame.top = r5;
        this.mWidgetFrame.left = r4;
        this.mWidgetFrame.right = r6;
        this.mWidgetFrame.bottom = r7;
    }

    public MotionWidget(WidgetFrame r2) {
        this.mWidgetFrame = new WidgetFrame();
        this.mMotion = new Motion();
        this.mPropertySet = new PropertySet();
        this.mWidgetFrame = r2;
    }

    public void updateMotion(TypedValues r2) {
        if (this.mWidgetFrame.getMotionProperties() == null) goto L6;
        this.mWidgetFrame.getMotionProperties().applyDelta(r2);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (setValueAttributes(r2, r3) == false) goto L7;
        return true;
    L7:
        return setValueMotion(r2, r3);
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (setValueAttributes(r2, r3) == false) goto L7;
        return true;
    L7:
        return setValueMotion(r2, r3);
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 605) goto L7;
        this.mMotion.mAnimateRelativeTo = r3;
        return true;
    L7:
        return setValueMotion(r2, r3);
    }

    public boolean setValueMotion(int r1, int r2) {
        switch(r1) {
            case 606: goto L11;
            case 607: goto L10;
            case 608: goto L9;
            case 609: goto L8;
            case 610: goto L7;
            case 611: goto L6;
            case 612: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        this.mMotion.mQuantizeInterpolatorID = r2;
        return true;
    L6:
        this.mMotion.mQuantizeInterpolatorType = r2;
        return true;
    L7:
        this.mMotion.mQuantizeMotionSteps = r2;
        return true;
    L8:
        this.mMotion.mPolarRelativeTo = r2;
        return true;
    L9:
        this.mMotion.mDrawPath = r2;
        return true;
    L10:
        this.mMotion.mPathMotionArc = r2;
        return true;
    L11:
        this.mMotion.mAnimateCircleAngleTo = r2;
        return true;
    }

    public boolean setValueMotion(int r2, String r3) {
        if (r2 != 603) goto L5;
        this.mMotion.mTransitionEasing = r3;
        return true;
    L5:
        if (r2 == 604) goto L8;
        return false;
    L8:
        this.mMotion.mQuantizeInterpolatorString = r3;
        return true;
    }

    public boolean setValueMotion(int r1, float r2) {
        switch(r1) {
            case 600: goto L7;
            case 601: goto L6;
            case 602: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        this.mMotion.mQuantizeMotionPhase = r2;
        return true;
    L6:
        this.mMotion.mPathRotate = r2;
        return true;
    L7:
        this.mMotion.mMotionStagger = r2;
        return true;
    }

    public boolean setValueAttributes(int r1, float r2) {
        switch(r1) {
            case 303: goto L17;
            case 304: goto L16;
            case 305: goto L15;
            case 306: goto L14;
            case 307: goto L3;
            case 308: goto L13;
            case 309: goto L12;
            case 310: goto L11;
            case 311: goto L10;
            case 312: goto L9;
            case 313: goto L8;
            case 314: goto L7;
            case 315: goto L6;
            case 316: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        this.mTransitionPathRotate = r2;
        return true;
    L6:
        this.mProgress = r2;
        return true;
    L7:
        this.mWidgetFrame.pivotY = r2;
        return true;
    L8:
        this.mWidgetFrame.pivotX = r2;
        return true;
    L9:
        this.mWidgetFrame.scaleY = r2;
        return true;
    L10:
        this.mWidgetFrame.scaleX = r2;
        return true;
    L11:
        this.mWidgetFrame.rotationZ = r2;
        return true;
    L12:
        this.mWidgetFrame.rotationY = r2;
        return true;
    L13:
        this.mWidgetFrame.rotationX = r2;
        return true;
    L14:
        this.mWidgetFrame.translationZ = r2;
        return true;
    L15:
        this.mWidgetFrame.translationY = r2;
        return true;
    L16:
        this.mWidgetFrame.translationX = r2;
        return true;
    L17:
        this.mWidgetFrame.alpha = r2;
        return true;
    }

    public float getValueAttributes(int r1) {
        switch(r1) {
            case 303: goto L30;
            case 304: goto L28;
            case 305: goto L26;
            case 306: goto L24;
            case 307: goto L3;
            case 308: goto L22;
            case 309: goto L20;
            case 310: goto L18;
            case 311: goto L16;
            case 312: goto L14;
            case 313: goto L12;
            case 314: goto L10;
            case 315: goto L8;
            case 316: goto L6;
            default: goto L3;
        };
    L3:
        return Float.NaN;
    L6:
        return this.mTransitionPathRotate;
    L8:
        return this.mProgress;
    L10:
        return this.mWidgetFrame.pivotY;
    L12:
        return this.mWidgetFrame.pivotX;
    L14:
        return this.mWidgetFrame.scaleY;
    L16:
        return this.mWidgetFrame.scaleX;
    L18:
        return this.mWidgetFrame.rotationZ;
    L20:
        return this.mWidgetFrame.rotationY;
    L22:
        return this.mWidgetFrame.rotationX;
    L24:
        return this.mWidgetFrame.translationZ;
    L26:
        return this.mWidgetFrame.translationY;
    L28:
        return this.mWidgetFrame.translationX;
    L30:
        return this.mWidgetFrame.alpha;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r2) {
        int r1 = TypedValues.AttributesType.getId(r2);
        if (r1 == (-1)) goto L6;
        return r1;
    L6:
        return TypedValues.MotionType.getId(r2);
    }

    public int getTop() {
        return this.mWidgetFrame.top;
    }

    public int getLeft() {
        return this.mWidgetFrame.left;
    }

    public int getBottom() {
        return this.mWidgetFrame.bottom;
    }

    public int getRight() {
        return this.mWidgetFrame.right;
    }

    public void setPivotX(float r1) {
        this.mWidgetFrame.pivotX = r1;
    }

    public void setPivotY(float r1) {
        this.mWidgetFrame.pivotY = r1;
    }

    public float getRotationX() {
        return this.mWidgetFrame.rotationX;
    }

    public void setRotationX(float r1) {
        this.mWidgetFrame.rotationX = r1;
    }

    public float getRotationY() {
        return this.mWidgetFrame.rotationY;
    }

    public void setRotationY(float r1) {
        this.mWidgetFrame.rotationY = r1;
    }

    public float getRotationZ() {
        return this.mWidgetFrame.rotationZ;
    }

    public void setRotationZ(float r1) {
        this.mWidgetFrame.rotationZ = r1;
    }

    public float getTranslationX() {
        return this.mWidgetFrame.translationX;
    }

    public void setTranslationX(float r1) {
        this.mWidgetFrame.translationX = r1;
    }

    public float getTranslationY() {
        return this.mWidgetFrame.translationY;
    }

    public void setTranslationY(float r1) {
        this.mWidgetFrame.translationY = r1;
    }

    public void setTranslationZ(float r1) {
        this.mWidgetFrame.translationZ = r1;
    }

    public float getTranslationZ() {
        return this.mWidgetFrame.translationZ;
    }

    public float getScaleX() {
        return this.mWidgetFrame.scaleX;
    }

    public void setScaleX(float r1) {
        this.mWidgetFrame.scaleX = r1;
    }

    public float getScaleY() {
        return this.mWidgetFrame.scaleY;
    }

    public void setScaleY(float r1) {
        this.mWidgetFrame.scaleY = r1;
    }

    public int getVisibility() {
        return this.mPropertySet.visibility;
    }

    public float getPivotX() {
        return this.mWidgetFrame.pivotX;
    }

    public float getPivotY() {
        return this.mWidgetFrame.pivotY;
    }

    public float getAlpha() {
        return this.mWidgetFrame.alpha;
    }

    public int getX() {
        return this.mWidgetFrame.left;
    }

    public int getY() {
        return this.mWidgetFrame.top;
    }

    public int getWidth() {
        return this.mWidgetFrame.right - this.mWidgetFrame.left;
    }

    public int getHeight() {
        return this.mWidgetFrame.bottom - this.mWidgetFrame.top;
    }

    public WidgetFrame getWidgetFrame() {
        return this.mWidgetFrame;
    }

    public Set<String> getCustomAttributeNames() {
        return this.mWidgetFrame.getCustomAttributeNames();
    }

    public void setCustomAttribute(String r1, int r2, float r3) {
        this.mWidgetFrame.setCustomAttribute(r1, r2, r3);
    }

    public void setCustomAttribute(String r1, int r2, int r3) {
        this.mWidgetFrame.setCustomAttribute(r1, r2, r3);
    }

    public void setCustomAttribute(String r1, int r2, boolean r3) {
        this.mWidgetFrame.setCustomAttribute(r1, r2, r3);
    }

    public void setCustomAttribute(String r1, int r2, String r3) {
        this.mWidgetFrame.setCustomAttribute(r1, r2, r3);
    }

    public CustomVariable getCustomAttribute(String r1) {
        return this.mWidgetFrame.getCustomAttribute(r1);
    }

    public void setInterpolatedValue(CustomAttribute r2, float[] r3) {
        this.mWidgetFrame.setCustomAttribute(r2.mName, 901, r3[0]);
    }
}
