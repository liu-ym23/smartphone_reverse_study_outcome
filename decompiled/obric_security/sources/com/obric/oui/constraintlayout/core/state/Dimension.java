package com.obric.oui.constraintlayout.core.state;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes3.dex */
public class Dimension {
    public static final Object FIXED_DIMENSION = null;
    public static final Object PARENT_DIMENSION = null;
    public static final Object PERCENT_DIMENSION = null;
    public static final Object RATIO_DIMENSION = null;
    public static final Object SPREAD_DIMENSION = null;
    public static final Object WRAP_DIMENSION = null;
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    String mRatioString;
    int mValue;
    private final int mWrapContent;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FIXED = null;
        public static final Type MATCH_CONSTRAINT = null;
        public static final Type MATCH_PARENT = null;
        public static final Type WRAP = null;

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
            Type r0 = new Type("FIXED", 0);
            FIXED = r0;
            Type r1 = new Type("WRAP", 1);
            WRAP = r1;
            Type r3 = new Type("MATCH_PARENT", 2);
            MATCH_PARENT = r3;
            Type r5 = new Type("MATCH_CONSTRAINT", 3);
            MATCH_CONSTRAINT = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
        }
    }

    static {
        FIXED_DIMENSION = new String("FIXED_DIMENSION");
        WRAP_DIMENSION = new String("WRAP_DIMENSION");
        SPREAD_DIMENSION = new String("SPREAD_DIMENSION");
        PARENT_DIMENSION = new String("PARENT_DIMENSION");
        PERCENT_DIMENSION = new String("PERCENT_DIMENSION");
        RATIO_DIMENSION = new String("RATIO_DIMENSION");
    }

    public boolean equalsFixedValue(int r2) {
        if (this.mInitialValue == null) goto L5;
        return false;
    L5:
        if (this.mValue != r2) goto L10;
        return true;
    L10:
        return false;
    }

    private Dimension() {
        this.mWrapContent = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    private Dimension(Object r3) {
        this.mWrapContent = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mIsSuggested = false;
        this.mInitialValue = r3;
    }

    @Deprecated
    public static Dimension Suggested(int r0) {
        return createSuggested(r0);
    }

    public static Dimension createSuggested(int r1) {
        Dimension r0 = new Dimension();
        r0.suggested(r1);
        return r0;
    }

    @Deprecated
    public static Dimension Suggested(Object r0) {
        return createSuggested(r0);
    }

    public static Dimension createSuggested(Object r1) {
        Dimension r0 = new Dimension();
        r0.suggested(r1);
        return r0;
    }

    @Deprecated
    public static Dimension Fixed(int r0) {
        return createFixed(r0);
    }

    public static Dimension createFixed(int r2) {
        Dimension r0 = new Dimension(FIXED_DIMENSION);
        r0.fixed(r2);
        return r0;
    }

    @Deprecated
    public static Dimension Fixed(Object r2) {
        Dimension r0 = new Dimension(FIXED_DIMENSION);
        r0.fixed(r2);
        return r0;
    }

    public static Dimension createFixed(Object r2) {
        Dimension r0 = new Dimension(FIXED_DIMENSION);
        r0.fixed(r2);
        return r0;
    }

    @Deprecated
    public static Dimension Percent(Object r0, float r1) {
        return createPercent(r0, r1);
    }

    public static Dimension createPercent(Object r2, float r3) {
        Dimension r0 = new Dimension(PERCENT_DIMENSION);
        r0.percent(r2, r3);
        return r0;
    }

    @Deprecated
    public static Dimension Parent() {
        return createParent();
    }

    public static Dimension createParent() {
        return new Dimension(PARENT_DIMENSION);
    }

    @Deprecated
    public static Dimension Wrap() {
        return createWrap();
    }

    public static Dimension createWrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    @Deprecated
    public static Dimension Spread() {
        return createSpread();
    }

    public static Dimension createSpread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    @Deprecated
    public static Dimension Ratio(String r0) {
        return createRatio(r0);
    }

    public static Dimension createRatio(String r2) {
        Dimension r0 = new Dimension(RATIO_DIMENSION);
        r0.ratio(r2);
        return r0;
    }

    public Dimension percent(Object r1, float r2) {
        this.mPercent = r2;
        return this;
    }

    public Dimension min(int r1) {
        if (r1 < 0) goto L4;
        this.mMin = r1;
    L4:
        return this;
    }

    public Dimension min(Object r2) {
        if (r2 != WRAP_DIMENSION) goto L5;
        this.mMin = -2;
    L5:
        return this;
    }

    public Dimension max(int r2) {
        if (this.mMax < 0) goto L5;
        this.mMax = r2;
    L5:
        return this;
    }

    public Dimension max(Object r2) {
        Object r0 = WRAP_DIMENSION;
        if (r2 == r0) goto L5;
    L7:
        return this;
    L5:
        if (this.mIsSuggested == false) goto L7;
        this.mInitialValue = r0;
        this.mMax = Integer.MAX_VALUE;
        goto L7
    }

    public Dimension suggested(int r2) {
        this.mIsSuggested = true;
        if (r2 < 0) goto L5;
        this.mMax = r2;
    L5:
        return this;
    }

    public Dimension suggested(Object r1) {
        this.mInitialValue = r1;
        this.mIsSuggested = true;
        return this;
    }

    public Dimension fixed(Object r2) {
        this.mInitialValue = r2;
        if ((r2 instanceof Integer) == false) goto L5;
        this.mValue = ((Integer) r2).intValue();
        this.mInitialValue = null;
    L5:
        return this;
    }

    public Dimension fixed(int r2) {
        this.mInitialValue = null;
        this.mValue = r2;
        return this;
    }

    public Dimension ratio(String r1) {
        this.mRatioString = r1;
        return this;
    }

    void setValue(int r2) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = r2;
    }

    int getValue() {
        return this.mValue;
    }

    public void apply(State r4, ConstraintWidget r5, int r6) {
        String r7 = this.mRatioString;
        if (r7 == null) goto L5;
        r5.setDimensionRatio(r7);
    L5:
        int r8 = 2;
        if (r6 != 0) goto L32;
        if (this.mIsSuggested == false) goto L17;
        r5.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        Object r9 = this.mInitialValue;
        if (r9 != WRAP_DIMENSION) goto L13;
        r8 = 1;
    L16:
        r5.setHorizontalMatchStyle(r8, this.mMin, this.mMax, this.mPercent);
        return;
    L13:
        if (r9 == PERCENT_DIMENSION) goto L16;
        r8 = 0;
        goto L16
    L17:
        int r10 = this.mMin;
        if (r10 <= 0) goto L20;
        r5.setMinWidth(r10);
    L20:
        int r11 = this.mMax;
        if (r11 >= Integer.MAX_VALUE) goto L23;
        r5.setMaxWidth(r11);
    L23:
        Object r12 = this.mInitialValue;
        if (r12 != WRAP_DIMENSION) goto L27;
        r5.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
    L27:
        if (r12 != PARENT_DIMENSION) goto L29;
        r5.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        return;
    L29:
        if (r12 != null) goto L59;
        r5.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r5.setWidth(this.mValue);
        return;
    L59:
        return;
    L32:
        if (this.mIsSuggested == false) goto L41;
        r5.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        Object r13 = this.mInitialValue;
        if (r13 != WRAP_DIMENSION) goto L37;
        r8 = 1;
    L40:
        r5.setVerticalMatchStyle(r8, this.mMin, this.mMax, this.mPercent);
        return;
    L37:
        if (r13 == PERCENT_DIMENSION) goto L40;
        r8 = 0;
        goto L40
    L41:
        int r14 = this.mMin;
        if (r14 <= 0) goto L44;
        r5.setMinHeight(r14);
    L44:
        int r15 = this.mMax;
        if (r15 >= Integer.MAX_VALUE) goto L47;
        r5.setMaxHeight(r15);
    L47:
        Object r16 = this.mInitialValue;
        if (r16 != WRAP_DIMENSION) goto L51;
        r5.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
    L51:
        if (r16 != PARENT_DIMENSION) goto L53;
        r5.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        return;
    L53:
        if (r16 != null) goto L64;
        r5.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r5.setHeight(this.mValue);
        return;
    }
}
