package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public class KeyPosition extends Keys {
    private int mFrame;
    private float mPercentHeight;
    private float mPercentWidth;
    private float mPercentX;
    private float mPercentY;
    private Type mPositionType;
    private String mTarget;
    private String mTransitionEasing;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CARTESIAN = null;
        public static final Type PATH = null;
        public static final Type SCREEN = null;

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            Type r0 = new Type("CARTESIAN", 0);
            CARTESIAN = r0;
            Type r1 = new Type("SCREEN", 1);
            SCREEN = r1;
            Type r3 = new Type("PATH", 2);
            PATH = r3;
            $VALUES = new Type[]{r0, r1, r3};
        }
    }

    public KeyPosition(String r2, int r3) {
        this.mTarget = null;
        this.mTransitionEasing = null;
        this.mFrame = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mPositionType = Type.CARTESIAN;
        this.mTarget = r2;
        this.mFrame = r3;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setTransitionEasing(String r1) {
        this.mTransitionEasing = r1;
    }

    public int getFrames() {
        return this.mFrame;
    }

    public void setFrames(int r1) {
        this.mFrame = r1;
    }

    public float getPercentWidth() {
        return this.mPercentWidth;
    }

    public void setPercentWidth(float r1) {
        this.mPercentWidth = r1;
    }

    public float getPercentHeight() {
        return this.mPercentHeight;
    }

    public void setPercentHeight(float r1) {
        this.mPercentHeight = r1;
    }

    public float getPercentX() {
        return this.mPercentX;
    }

    public void setPercentX(float r1) {
        this.mPercentX = r1;
    }

    public float getPercentY() {
        return this.mPercentY;
    }

    public void setPercentY(float r1) {
        this.mPercentY = r1;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public void setPositionType(Type r1) {
        this.mPositionType = r1;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public void setTarget(String r1) {
        this.mTarget = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("KeyPositions:{\n");
        append(r0, "target", this.mTarget);
        r0.append("frame:").append(this.mFrame).append(",\n");
        if (this.mPositionType == null) goto L5;
        r0.append("type:'").append(this.mPositionType).append("',\n");
    L5:
        append(r0, "easing", this.mTransitionEasing);
        append(r0, "percentX", this.mPercentX);
        append(r0, "percentY", this.mPercentY);
        append(r0, "percentWidth", this.mPercentWidth);
        append(r0, "percentHeight", this.mPercentHeight);
        r0.append("},\n");
        return r0.toString();
    }
}
