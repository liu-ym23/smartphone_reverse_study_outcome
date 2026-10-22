package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* JADX INFO: loaded from: classes.dex */
public class Mask {
    private final boolean inverted;
    private final MaskMode maskMode;
    private final AnimatableShapeValue maskPath;
    private final AnimatableIntegerValue opacity;

    public static final enum MaskMode extends Enum<MaskMode> {
        private static final /* synthetic */ MaskMode[] $VALUES = null;
        public static final MaskMode MASK_MODE_ADD = null;
        public static final MaskMode MASK_MODE_INTERSECT = null;
        public static final MaskMode MASK_MODE_NONE = null;
        public static final MaskMode MASK_MODE_SUBTRACT = null;

        private MaskMode(String r1, int r2) {
            super(r1, r2);
        }

        public static MaskMode valueOf(String r1) {
            return (MaskMode) Enum.valueOf(MaskMode.class, r1);
        }

        public static MaskMode[] values() {
            return (MaskMode[]) $VALUES.clone();
        }

        static {
            MaskMode r0 = new MaskMode("MASK_MODE_ADD", 0);
            MASK_MODE_ADD = r0;
            MaskMode r1 = new MaskMode("MASK_MODE_SUBTRACT", 1);
            MASK_MODE_SUBTRACT = r1;
            MaskMode r3 = new MaskMode("MASK_MODE_INTERSECT", 2);
            MASK_MODE_INTERSECT = r3;
            MaskMode r5 = new MaskMode("MASK_MODE_NONE", 3);
            MASK_MODE_NONE = r5;
            $VALUES = new MaskMode[]{r0, r1, r3, r5};
        }
    }

    public Mask(MaskMode r1, AnimatableShapeValue r2, AnimatableIntegerValue r3, boolean r4) {
        this.maskMode = r1;
        this.maskPath = r2;
        this.opacity = r3;
        this.inverted = r4;
    }

    public MaskMode getMaskMode() {
        return this.maskMode;
    }

    public AnimatableShapeValue getMaskPath() {
        return this.maskPath;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public boolean isInverted() {
        return this.inverted;
    }
}
