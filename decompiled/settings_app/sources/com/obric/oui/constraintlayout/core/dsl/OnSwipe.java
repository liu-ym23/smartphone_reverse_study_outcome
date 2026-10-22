package com.obric.oui.constraintlayout.core.dsl;

import com.android.vcard.VCardConstants;

/* JADX INFO: loaded from: classes4.dex */
public class OnSwipe {
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    private Mode mAutoCompleteMode;
    private Drag mDragDirection;
    private float mDragScale;
    private float mDragThreshold;
    private String mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private TouchUp mOnTouchUp;
    private String mRotationCenterId;
    private Boundary mSpringBoundary;
    private float mSpringDamping;
    private float mSpringMass;
    private float mSpringStiffness;
    private float mSpringStopThreshold;
    private String mTouchAnchorId;
    private Side mTouchAnchorSide;

    public static final enum Boundary extends Enum<Boundary> {
        private static final /* synthetic */ Boundary[] $VALUES = null;
        public static final Boundary BOUNCE_BOTH = null;
        public static final Boundary BOUNCE_END = null;
        public static final Boundary BOUNCE_START = null;
        public static final Boundary OVERSHOOT = null;

        private Boundary(String r1, int r2) {
            super(r1, r2);
        }

        public static Boundary valueOf(String r1) {
            return (Boundary) Enum.valueOf(Boundary.class, r1);
        }

        public static Boundary[] values() {
            return (Boundary[]) $VALUES.clone();
        }

        static {
            Boundary r0 = new Boundary("OVERSHOOT", 0);
            OVERSHOOT = r0;
            Boundary r1 = new Boundary("BOUNCE_START", 1);
            BOUNCE_START = r1;
            Boundary r3 = new Boundary("BOUNCE_END", 2);
            BOUNCE_END = r3;
            Boundary r5 = new Boundary("BOUNCE_BOTH", 3);
            BOUNCE_BOTH = r5;
            $VALUES = new Boundary[]{r0, r1, r3, r5};
        }
    }

    public static final enum Drag extends Enum<Drag> {
        private static final /* synthetic */ Drag[] $VALUES = null;
        public static final Drag ANTICLOCKWISE = null;
        public static final Drag CLOCKWISE = null;
        public static final Drag DOWN = null;
        public static final Drag END = null;
        public static final Drag LEFT = null;
        public static final Drag RIGHT = null;
        public static final Drag START = null;
        public static final Drag UP = null;

        private Drag(String r1, int r2) {
            super(r1, r2);
        }

        public static Drag valueOf(String r1) {
            return (Drag) Enum.valueOf(Drag.class, r1);
        }

        public static Drag[] values() {
            return (Drag[]) $VALUES.clone();
        }

        static {
            Drag r0 = new Drag("UP", 0);
            UP = r0;
            Drag r1 = new Drag("DOWN", 1);
            DOWN = r1;
            Drag r3 = new Drag("LEFT", 2);
            LEFT = r3;
            Drag r5 = new Drag("RIGHT", 3);
            RIGHT = r5;
            Drag r7 = new Drag("START", 4);
            START = r7;
            Drag r9 = new Drag(VCardConstants.PROPERTY_END, 5);
            END = r9;
            Drag r11 = new Drag("CLOCKWISE", 6);
            CLOCKWISE = r11;
            Drag r13 = new Drag("ANTICLOCKWISE", 7);
            ANTICLOCKWISE = r13;
            $VALUES = new Drag[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode SPRING = null;
        public static final Mode VELOCITY = null;

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            Mode r0 = new Mode("VELOCITY", 0);
            VELOCITY = r0;
            Mode r1 = new Mode("SPRING", 1);
            SPRING = r1;
            $VALUES = new Mode[]{r0, r1};
        }
    }

    public static final enum Side extends Enum<Side> {
        private static final /* synthetic */ Side[] $VALUES = null;
        public static final Side BOTTOM = null;
        public static final Side END = null;
        public static final Side LEFT = null;
        public static final Side MIDDLE = null;
        public static final Side RIGHT = null;
        public static final Side START = null;
        public static final Side TOP = null;

        private Side(String r1, int r2) {
            super(r1, r2);
        }

        public static Side valueOf(String r1) {
            return (Side) Enum.valueOf(Side.class, r1);
        }

        public static Side[] values() {
            return (Side[]) $VALUES.clone();
        }

        static {
            Side r0 = new Side("TOP", 0);
            TOP = r0;
            Side r1 = new Side("LEFT", 1);
            LEFT = r1;
            Side r3 = new Side("RIGHT", 2);
            RIGHT = r3;
            Side r5 = new Side("BOTTOM", 3);
            BOTTOM = r5;
            Side r7 = new Side("MIDDLE", 4);
            MIDDLE = r7;
            Side r9 = new Side("START", 5);
            START = r9;
            Side r11 = new Side(VCardConstants.PROPERTY_END, 6);
            END = r11;
            $VALUES = new Side[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public static final enum TouchUp extends Enum<TouchUp> {
        private static final /* synthetic */ TouchUp[] $VALUES = null;
        public static final TouchUp AUTOCOMPLETE = null;
        public static final TouchUp DECELERATE = null;
        public static final TouchUp DECELERATE_COMPLETE = null;
        public static final TouchUp NEVER_COMPLETE_END = null;
        public static final TouchUp NEVER_COMPLETE_START = null;
        public static final TouchUp STOP = null;
        public static final TouchUp TO_END = null;
        public static final TouchUp TO_START = null;

        private TouchUp(String r1, int r2) {
            super(r1, r2);
        }

        public static TouchUp valueOf(String r1) {
            return (TouchUp) Enum.valueOf(TouchUp.class, r1);
        }

        public static TouchUp[] values() {
            return (TouchUp[]) $VALUES.clone();
        }

        static {
            TouchUp r0 = new TouchUp("AUTOCOMPLETE", 0);
            AUTOCOMPLETE = r0;
            TouchUp r1 = new TouchUp("TO_START", 1);
            TO_START = r1;
            TouchUp r3 = new TouchUp("NEVER_COMPLETE_END", 2);
            NEVER_COMPLETE_END = r3;
            TouchUp r5 = new TouchUp("TO_END", 3);
            TO_END = r5;
            TouchUp r7 = new TouchUp("STOP", 4);
            STOP = r7;
            TouchUp r9 = new TouchUp("DECELERATE", 5);
            DECELERATE = r9;
            TouchUp r11 = new TouchUp("DECELERATE_COMPLETE", 6);
            DECELERATE_COMPLETE = r11;
            TouchUp r13 = new TouchUp("NEVER_COMPLETE_START", 7);
            NEVER_COMPLETE_START = r13;
            $VALUES = new TouchUp[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    public OnSwipe() {
        this.mDragDirection = null;
        this.mTouchAnchorSide = null;
        this.mTouchAnchorId = null;
        this.mLimitBoundsTo = null;
        this.mOnTouchUp = null;
        this.mRotationCenterId = null;
        this.mMaxVelocity = Float.NaN;
        this.mMaxAcceleration = Float.NaN;
        this.mDragScale = Float.NaN;
        this.mDragThreshold = Float.NaN;
        this.mSpringDamping = Float.NaN;
        this.mSpringMass = Float.NaN;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = null;
        this.mAutoCompleteMode = null;
    }

    public OnSwipe(String r3, Side r4, Drag r5) {
        this.mLimitBoundsTo = null;
        this.mOnTouchUp = null;
        this.mRotationCenterId = null;
        this.mMaxVelocity = Float.NaN;
        this.mMaxAcceleration = Float.NaN;
        this.mDragScale = Float.NaN;
        this.mDragThreshold = Float.NaN;
        this.mSpringDamping = Float.NaN;
        this.mSpringMass = Float.NaN;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = null;
        this.mAutoCompleteMode = null;
        this.mTouchAnchorId = r3;
        this.mTouchAnchorSide = r4;
        this.mDragDirection = r5;
    }

    public OnSwipe setTouchAnchorId(String r1) {
        this.mTouchAnchorId = r1;
        return this;
    }

    public String getTouchAnchorId() {
        return this.mTouchAnchorId;
    }

    public OnSwipe setTouchAnchorSide(Side r1) {
        this.mTouchAnchorSide = r1;
        return this;
    }

    public Side getTouchAnchorSide() {
        return this.mTouchAnchorSide;
    }

    public OnSwipe setDragDirection(Drag r1) {
        this.mDragDirection = r1;
        return this;
    }

    public Drag getDragDirection() {
        return this.mDragDirection;
    }

    public OnSwipe setMaxVelocity(int r1) {
        this.mMaxVelocity = r1;
        return this;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public OnSwipe setMaxAcceleration(int r1) {
        this.mMaxAcceleration = r1;
        return this;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public OnSwipe setDragScale(int r1) {
        this.mDragScale = r1;
        return this;
    }

    public float getDragScale() {
        return this.mDragScale;
    }

    public OnSwipe setDragThreshold(int r1) {
        this.mDragThreshold = r1;
        return this;
    }

    public float getDragThreshold() {
        return this.mDragThreshold;
    }

    public OnSwipe setOnTouchUp(TouchUp r1) {
        this.mOnTouchUp = r1;
        return this;
    }

    public TouchUp getOnTouchUp() {
        return this.mOnTouchUp;
    }

    public OnSwipe setLimitBoundsTo(String r1) {
        this.mLimitBoundsTo = r1;
        return this;
    }

    public String getLimitBoundsTo() {
        return this.mLimitBoundsTo;
    }

    public OnSwipe setRotateCenter(String r1) {
        this.mRotationCenterId = r1;
        return this;
    }

    public String getRotationCenterId() {
        return this.mRotationCenterId;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public OnSwipe setSpringDamping(float r1) {
        this.mSpringDamping = r1;
        return this;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public OnSwipe setSpringMass(float r1) {
        this.mSpringMass = r1;
        return this;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public OnSwipe setSpringStiffness(float r1) {
        this.mSpringStiffness = r1;
        return this;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    public OnSwipe setSpringStopThreshold(float r1) {
        this.mSpringStopThreshold = r1;
        return this;
    }

    public Boundary getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public OnSwipe setSpringBoundary(Boundary r1) {
        this.mSpringBoundary = r1;
        return this;
    }

    public Mode getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public void setAutoCompleteMode(Mode r1) {
        this.mAutoCompleteMode = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("OnSwipe:{\n");
        if (this.mTouchAnchorId == null) goto L6;
        r0.append("anchor:'").append(this.mTouchAnchorId).append("',\n");
    L6:
        if (this.mDragDirection == null) goto L9;
        r0.append("direction:'").append(this.mDragDirection.toString().toLowerCase()).append("',\n");
    L9:
        if (this.mTouchAnchorSide == null) goto L12;
        r0.append("side:'").append(this.mTouchAnchorSide.toString().toLowerCase()).append("',\n");
    L12:
        if (Float.isNaN(this.mDragScale) == true) goto L15;
        r0.append("scale:'").append(this.mDragScale).append("',\n");
    L15:
        if (Float.isNaN(this.mDragThreshold) == true) goto L18;
        r0.append("threshold:'").append(this.mDragThreshold).append("',\n");
    L18:
        if (Float.isNaN(this.mMaxVelocity) == true) goto L21;
        r0.append("maxVelocity:'").append(this.mMaxVelocity).append("',\n");
    L21:
        if (Float.isNaN(this.mMaxAcceleration) == true) goto L24;
        r0.append("maxAccel:'").append(this.mMaxAcceleration).append("',\n");
    L24:
        if (this.mLimitBoundsTo == null) goto L27;
        r0.append("limitBounds:'").append(this.mLimitBoundsTo).append("',\n");
    L27:
        if (this.mAutoCompleteMode == null) goto L30;
        r0.append("mode:'").append(this.mAutoCompleteMode.toString().toLowerCase()).append("',\n");
    L30:
        if (this.mOnTouchUp == null) goto L33;
        r0.append("touchUp:'").append(this.mOnTouchUp.toString().toLowerCase()).append("',\n");
    L33:
        if (Float.isNaN(this.mSpringMass) == true) goto L36;
        r0.append("springMass:'").append(this.mSpringMass).append("',\n");
    L36:
        if (Float.isNaN(this.mSpringStiffness) == true) goto L39;
        r0.append("springStiffness:'").append(this.mSpringStiffness).append("',\n");
    L39:
        if (Float.isNaN(this.mSpringDamping) == true) goto L42;
        r0.append("springDamping:'").append(this.mSpringDamping).append("',\n");
    L42:
        if (Float.isNaN(this.mSpringStopThreshold) == true) goto L45;
        r0.append("stopThreshold:'").append(this.mSpringStopThreshold).append("',\n");
    L45:
        if (this.mSpringBoundary == null) goto L48;
        r0.append("springBoundary:'").append(this.mSpringBoundary).append("',\n");
    L48:
        if (this.mRotationCenterId == null) goto L50;
        r0.append("around:'").append(this.mRotationCenterId).append("',\n");
    L50:
        r0.append("},\n");
        return r0.toString();
    }
}
