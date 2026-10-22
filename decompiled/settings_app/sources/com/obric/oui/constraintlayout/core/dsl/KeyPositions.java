package com.obric.oui.constraintlayout.core.dsl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class KeyPositions extends Keys {
    private int[] mFrames;
    private float[] mPercentHeight;
    private float[] mPercentWidth;
    private float[] mPercentX;
    private float[] mPercentY;
    private Type mPositionType;
    private String[] mTarget;
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

    public KeyPositions(int r3, String... r4) {
        this.mTransitionEasing = null;
        this.mPositionType = null;
        this.mFrames = null;
        this.mPercentWidth = null;
        this.mPercentHeight = null;
        this.mPercentX = null;
        this.mPercentY = null;
        this.mTarget = r4;
        int[] r5 = new int[r3];
        this.mFrames = r5;
        float r6 = 100.0f / (r5.length + 1);
        int r7 = 0;
    L3:
        int[] r0 = this.mFrames;
        if (r7 >= r0.length) goto L6;
        r0[r7] = (int) ((r7 * r6) + r6);
        r7 = r7 + 1;
        goto L3
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setTransitionEasing(String r1) {
        this.mTransitionEasing = r1;
    }

    public int[] getFrames() {
        return this.mFrames;
    }

    public void setFrames(int... r1) {
        this.mFrames = r1;
    }

    public float[] getPercentWidth() {
        return this.mPercentWidth;
    }

    public void setPercentWidth(float... r1) {
        this.mPercentWidth = r1;
    }

    public float[] getPercentHeight() {
        return this.mPercentHeight;
    }

    public void setPercentHeight(float... r1) {
        this.mPercentHeight = r1;
    }

    public float[] getPercentX() {
        return this.mPercentX;
    }

    public void setPercentX(float... r1) {
        this.mPercentX = r1;
    }

    public float[] getPercentY() {
        return this.mPercentY;
    }

    public void setPercentY(float... r1) {
        this.mPercentY = r1;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public void setPositionType(Type r1) {
        this.mPositionType = r1;
    }

    public String[] getTarget() {
        return this.mTarget;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("KeyPositions:{\n");
        append(r0, "target", this.mTarget);
        r0.append("frame:").append(Arrays.toString(this.mFrames)).append(",\n");
        if (this.mPositionType == null) goto L5;
        r0.append("type:'").append(this.mPositionType).append("',\n");
    L5:
        append(r0, "easing", this.mTransitionEasing);
        append(r0, "percentX", this.mPercentX);
        append(r0, "percentX", this.mPercentY);
        append(r0, "percentWidth", this.mPercentWidth);
        append(r0, "percentHeight", this.mPercentHeight);
        r0.append("},\n");
        return r0.toString();
    }
}
