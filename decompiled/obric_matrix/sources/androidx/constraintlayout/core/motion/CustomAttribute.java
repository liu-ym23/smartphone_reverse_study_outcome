package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class CustomAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType = null;

        static {
            int[] r0 = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType = r0;
            r0[AttributeType.REFERENCE_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static final enum AttributeType extends Enum<AttributeType> {
        private static final /* synthetic */ AttributeType[] $VALUES = null;
        public static final AttributeType BOOLEAN_TYPE = null;
        public static final AttributeType COLOR_DRAWABLE_TYPE = null;
        public static final AttributeType COLOR_TYPE = null;
        public static final AttributeType DIMENSION_TYPE = null;
        public static final AttributeType FLOAT_TYPE = null;
        public static final AttributeType INT_TYPE = null;
        public static final AttributeType REFERENCE_TYPE = null;
        public static final AttributeType STRING_TYPE = null;

        static {
            AttributeType r0 = new AttributeType("INT_TYPE", 0);
            INT_TYPE = r0;
            AttributeType r1 = new AttributeType("FLOAT_TYPE", 1);
            FLOAT_TYPE = r1;
            AttributeType r3 = new AttributeType("COLOR_TYPE", 2);
            COLOR_TYPE = r3;
            AttributeType r5 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r5;
            AttributeType r7 = new AttributeType("STRING_TYPE", 4);
            STRING_TYPE = r7;
            AttributeType r9 = new AttributeType("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r9;
            AttributeType r11 = new AttributeType("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r11;
            AttributeType r13 = new AttributeType("REFERENCE_TYPE", 7);
            REFERENCE_TYPE = r13;
            $VALUES = new AttributeType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private AttributeType(String r1, int r2) {
            super(r1, r2);
        }

        public static AttributeType valueOf(String r1) {
            return (AttributeType) Enum.valueOf(AttributeType.class, r1);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) $VALUES.clone();
        }
    }

    public CustomAttribute(CustomAttribute r2, Object r3) {
        this.mMethod = false;
        this.mName = r2.mName;
        this.mType = r2.mType;
        setValue(r3);
    }

    public CustomAttribute(String r2, AttributeType r3) {
        this.mMethod = false;
        this.mName = r2;
        this.mType = r3;
    }

    public CustomAttribute(String r2, AttributeType r3, Object r4, boolean r5) {
        this.mMethod = false;
        this.mName = r2;
        this.mType = r3;
        this.mMethod = r5;
        setValue(r4);
    }

    private static int clamp(int r1) {
        int r2 = (r1 & (~(r1 >> 31))) - 255;
        return (r2 & (r2 >> 31)) + 255;
    }

    public static int hsvToRgb(float r5, float r6, float r7) {
        float r8 = r5 * 6.0f;
        int r0 = (int) r8;
        float r9 = r8 - r0;
        float r10 = r7 * 255.0f;
        int r2 = (int) (((1.0f - r6) * r10) + 0.5f);
        int r4 = (int) (((1.0f - (r9 * r6)) * r10) + 0.5f);
        int r11 = (int) (((1.0f - ((1.0f - r9) * r6)) * r10) + 0.5f);
        int r12 = (int) (r10 + 0.5f);
        if (r0 == 0) goto L27;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L21;
        if (r0 == 4) goto L19;
        if (r0 == 5) goto L17;
        return 0;
    L17:
        return (((r12 << 16) + (r2 << 8)) + r4) | ViewCompat.MEASURED_STATE_MASK;
    L19:
        return (((r11 << 16) + (r2 << 8)) + r12) | ViewCompat.MEASURED_STATE_MASK;
    L21:
        return (((r2 << 16) + (r4 << 8)) + r12) | ViewCompat.MEASURED_STATE_MASK;
    L23:
        return (((r2 << 16) + (r12 << 8)) + r11) | ViewCompat.MEASURED_STATE_MASK;
    L25:
        return (((r4 << 16) + (r12 << 8)) + r2) | ViewCompat.MEASURED_STATE_MASK;
    L27:
        return (((r12 << 16) + (r11 << 8)) + r2) | ViewCompat.MEASURED_STATE_MASK;
    }

    public boolean diff(CustomAttribute r4) {
        if (r4 == null) goto L39;
        AttributeType r1 = this.mType;
        if (r1 == r4.mType) goto L8;
        return false;
    L8:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[r1.ordinal()]) {
            case 1: goto L31;
            case 2: goto L27;
            case 3: goto L23;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L31;
            case 7: goto L15;
            case 8: goto L11;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        if (this.mFloatValue == r4.mFloatValue) goto L13;
        return false;
    L13:
        return true;
    L15:
        if (this.mFloatValue == r4.mFloatValue) goto L17;
        return false;
    L17:
        return true;
    L19:
        if (this.mColorValue == r4.mColorValue) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (this.mIntegerValue == r4.mIntegerValue) goto L25;
        return false;
    L25:
        return true;
    L27:
        if (this.mBooleanValue == r4.mBooleanValue) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (this.mIntegerValue == r4.mIntegerValue) goto L33;
        return false;
    L33:
        return true;
    L39:
        return false;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.mFloatValue;
    L9:
        return this.mFloatValue;
    L11:
        return this.mIntegerValue;
    L13:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L15:
        throw new RuntimeException("Cannot interpolate String");
    L17:
        if (this.mBooleanValue == false) goto L19;
        return 1.0f;
    L19:
        return 0.0f;
    }

    public void getValuesToInterpolate(float[] r10) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L21;
        };
    L5:
        r10[0] = this.mFloatValue;
        return;
    L6:
        r10[0] = this.mFloatValue;
        return;
    L7:
        r10[0] = this.mIntegerValue;
        return;
    L8:
        int r9 = this.mColorValue;
        int r0 = (r9 >> 24) & 255;
        float r2 = (float) Math.pow(((r9 >> 16) & 255) / 255.0f, 2.2d);
        float r3 = (float) Math.pow(((r9 >> 8) & 255) / 255.0f, 2.2d);
        float r11 = (float) Math.pow((r9 & 255) / 255.0f, 2.2d);
        r10[0] = r2;
        r10[1] = r3;
        r10[2] = r11;
        r10[3] = r0 / 255.0f;
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (this.mBooleanValue == false) goto L14;
        float r12 = 1.0f;
    L15:
        r10[0] = r12;
        return;
    L14:
        r12 = 0.0f;
        goto L15
    }

    public boolean isContinuous() {
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()];
        if (r2 != 1) goto L5;
        return false;
    L5:
        if (r2 != 2) goto L7;
        return false;
    L7:
        if (r2 == 3) goto L12;
        return true;
    L12:
        return false;
    }

    public int numberOfInterpolatedValues() {
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()];
        if (r2 != 4) goto L5;
    L8:
        return 4;
    L5:
        if (r2 == 5) goto L8;
        return 1;
    }

    public void setColorValue(int r1) {
        this.mColorValue = r1;
    }

    public void setFloatValue(float r1) {
        this.mFloatValue = r1;
    }

    public void setIntValue(int r1) {
        this.mIntegerValue = r1;
    }

    public void setStringValue(String r1) {
        this.mStringValue = r1;
    }

    public void setValue(Object r3) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L15;
        };
    L5:
        this.mFloatValue = ((Float) r3).floatValue();
        return;
    L6:
        this.mColorValue = ((Integer) r3).intValue();
        return;
    L7:
        this.mStringValue = (String) r3;
        return;
    L8:
        this.mBooleanValue = ((Boolean) r3).booleanValue();
        return;
    L9:
        this.mIntegerValue = ((Integer) r3).intValue();
        return;
    }

    public void setValue(float[] r8) {
        boolean r1 = true;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L16;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L16;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L21;
        };
    L5:
        float r9 = r8[0];
    L7:
        this.mFloatValue = r9;
        return;
    L6:
        r9 = r8[0];
        goto L7
    L8:
        int r0 = hsvToRgb(r8[0], r8[1], r8[2]);
        this.mColorValue = r0;
        this.mColorValue = (clamp((int) (r8[3] * 255.0f)) << 24) | (r0 & ViewCompat.MEASURED_SIZE_MASK);
        return;
    L16:
        this.mIntegerValue = (int) r8[0];
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (r8[0] > 0.5d) goto L15;
        r1 = false;
    L15:
        this.mBooleanValue = r1;
    }
}
