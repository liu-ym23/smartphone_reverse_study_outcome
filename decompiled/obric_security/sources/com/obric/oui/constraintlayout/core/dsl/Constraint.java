package com.obric.oui.constraintlayout.core.dsl;

import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Constraint {
    public static final Constraint PARENT = null;
    static int UNSET;
    static Map<ChainMode, String> chainModeMap;
    String helperJason;
    String helperType;
    private VAnchor mBaseline;
    private VAnchor mBottom;
    private float mCircleAngle;
    private String mCircleConstraint;
    private int mCircleRadius;
    private boolean mConstrainedHeight;
    private boolean mConstrainedWidth;
    private String mDimensionRatio;
    private int mEditorAbsoluteX;
    private int mEditorAbsoluteY;
    private HAnchor mEnd;
    private int mHeight;
    private Behaviour mHeightDefault;
    private int mHeightMax;
    private int mHeightMin;
    private float mHeightPercent;
    private float mHorizontalBias;
    private ChainMode mHorizontalChainStyle;
    private float mHorizontalWeight;
    private final String mId;
    private HAnchor mLeft;
    private String[] mReferenceIds;
    private HAnchor mRight;
    private HAnchor mStart;
    private VAnchor mTop;
    private float mVerticalBias;
    private ChainMode mVerticalChainStyle;
    private float mVerticalWeight;
    private int mWidth;
    private Behaviour mWidthDefault;
    private int mWidthMax;
    private int mWidthMin;
    private float mWidthPercent;

    public class Anchor {
        Anchor mConnection;
        int mGoneMargin;
        int mMargin;
        final Side mSide;
        final /* synthetic */ Constraint this$0;

        Anchor(Constraint r1, Side r2) {
            this.this$0 = r1;
            this.mConnection = null;
            this.mGoneMargin = Integer.MIN_VALUE;
            this.mSide = r2;
        }

        public String getId() {
            return Constraint.access$000(this.this$0);
        }

        Constraint getParent() {
            return this.this$0;
        }

        public void build(StringBuilder r2) {
            if (this.mConnection == null) goto L6;
            r2.append(this.mSide.toString().toLowerCase()).append(":").append(this).append(",\n");
            return;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("[");
            if (this.mConnection == null) goto L6;
            r0.append("'").append(this.mConnection.getId()).append("','").append(this.mConnection.mSide.toString().toLowerCase()).append("'");
        L6:
            if (this.mMargin == 0) goto L9;
            r0.append(",").append(this.mMargin);
        L9:
            if (this.mGoneMargin != Integer.MIN_VALUE) goto L11;
        L14:
            r0.append("]");
            return r0.toString();
        L11:
            if (this.mMargin != 0) goto L13;
            r0.append(",0,").append(this.mGoneMargin);
            goto L14
        L13:
            r0.append(",").append(this.mGoneMargin);
            goto L14
        }
    }

    public static final enum Behaviour extends Enum<Behaviour> {
        private static final /* synthetic */ Behaviour[] $VALUES = null;
        public static final Behaviour PERCENT = null;
        public static final Behaviour RATIO = null;
        public static final Behaviour RESOLVED = null;
        public static final Behaviour SPREAD = null;
        public static final Behaviour WRAP = null;

        private Behaviour(String r1, int r2) {
            super(r1, r2);
        }

        public static Behaviour valueOf(String r1) {
            return (Behaviour) Enum.valueOf(Behaviour.class, r1);
        }

        public static Behaviour[] values() {
            return (Behaviour[]) $VALUES.clone();
        }

        static {
            Behaviour r0 = new Behaviour("SPREAD", 0);
            SPREAD = r0;
            Behaviour r1 = new Behaviour("WRAP", 1);
            WRAP = r1;
            Behaviour r3 = new Behaviour("PERCENT", 2);
            PERCENT = r3;
            Behaviour r5 = new Behaviour("RATIO", 3);
            RATIO = r5;
            Behaviour r7 = new Behaviour("RESOLVED", 4);
            RESOLVED = r7;
            $VALUES = new Behaviour[]{r0, r1, r3, r5, r7};
        }
    }

    public static final enum ChainMode extends Enum<ChainMode> {
        private static final /* synthetic */ ChainMode[] $VALUES = null;
        public static final ChainMode PACKED = null;
        public static final ChainMode SPREAD = null;
        public static final ChainMode SPREAD_INSIDE = null;

        private ChainMode(String r1, int r2) {
            super(r1, r2);
        }

        public static ChainMode valueOf(String r1) {
            return (ChainMode) Enum.valueOf(ChainMode.class, r1);
        }

        public static ChainMode[] values() {
            return (ChainMode[]) $VALUES.clone();
        }

        static {
            ChainMode r0 = new ChainMode("SPREAD", 0);
            SPREAD = r0;
            ChainMode r1 = new ChainMode("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r1;
            ChainMode r3 = new ChainMode("PACKED", 2);
            PACKED = r3;
            $VALUES = new ChainMode[]{r0, r1, r3};
        }
    }

    public class HAnchor extends Anchor {
        final /* synthetic */ Constraint this$0;

        HAnchor(Constraint r1, HSide r2) {
            this.this$0 = r1;
            super(r1, Side.valueOf(r2.name()));
        }
    }

    public static final enum HSide extends Enum<HSide> {
        private static final /* synthetic */ HSide[] $VALUES = null;
        public static final HSide END = null;
        public static final HSide LEFT = null;
        public static final HSide RIGHT = null;
        public static final HSide START = null;

        private HSide(String r1, int r2) {
            super(r1, r2);
        }

        public static HSide valueOf(String r1) {
            return (HSide) Enum.valueOf(HSide.class, r1);
        }

        public static HSide[] values() {
            return (HSide[]) $VALUES.clone();
        }

        static {
            HSide r0 = new HSide("LEFT", 0);
            LEFT = r0;
            HSide r1 = new HSide("RIGHT", 1);
            RIGHT = r1;
            HSide r3 = new HSide("START", 2);
            START = r3;
            HSide r5 = new HSide("END", 3);
            END = r5;
            $VALUES = new HSide[]{r0, r1, r3, r5};
        }
    }

    public static final enum Side extends Enum<Side> {
        private static final /* synthetic */ Side[] $VALUES = null;
        public static final Side BASELINE = null;
        public static final Side BOTTOM = null;
        public static final Side END = null;
        public static final Side LEFT = null;
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
            Side r0 = new Side("LEFT", 0);
            LEFT = r0;
            Side r1 = new Side("RIGHT", 1);
            RIGHT = r1;
            Side r3 = new Side("TOP", 2);
            TOP = r3;
            Side r5 = new Side("BOTTOM", 3);
            BOTTOM = r5;
            Side r7 = new Side("START", 4);
            START = r7;
            Side r9 = new Side("END", 5);
            END = r9;
            Side r11 = new Side("BASELINE", 6);
            BASELINE = r11;
            $VALUES = new Side[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public class VAnchor extends Anchor {
        final /* synthetic */ Constraint this$0;

        VAnchor(Constraint r1, VSide r2) {
            this.this$0 = r1;
            super(r1, Side.valueOf(r2.name()));
        }
    }

    public static final enum VSide extends Enum<VSide> {
        private static final /* synthetic */ VSide[] $VALUES = null;
        public static final VSide BASELINE = null;
        public static final VSide BOTTOM = null;
        public static final VSide TOP = null;

        private VSide(String r1, int r2) {
            super(r1, r2);
        }

        public static VSide valueOf(String r1) {
            return (VSide) Enum.valueOf(VSide.class, r1);
        }

        public static VSide[] values() {
            return (VSide[]) $VALUES.clone();
        }

        static {
            VSide r0 = new VSide("TOP", 0);
            TOP = r0;
            VSide r1 = new VSide("BOTTOM", 1);
            BOTTOM = r1;
            VSide r3 = new VSide("BASELINE", 2);
            BASELINE = r3;
            $VALUES = new VSide[]{r0, r1, r3};
        }
    }

    static /* synthetic */ String access$000(Constraint r0) {
        return r0.mId;
    }

    static {
        PARENT = new Constraint("parent");
        UNSET = Integer.MIN_VALUE;
        HashMap r0 = new HashMap();
        chainModeMap = r0;
        r0.put(ChainMode.SPREAD, MaterialConfigFormatNames.SPREAD);
        chainModeMap.put(ChainMode.SPREAD_INSIDE, "spread_inside");
        chainModeMap.put(ChainMode.PACKED, "packed");
    }

    public Constraint(String r5) {
        this.helperType = null;
        this.helperJason = null;
        this.mLeft = new HAnchor(this, HSide.LEFT);
        this.mRight = new HAnchor(this, HSide.RIGHT);
        this.mTop = new VAnchor(this, VSide.TOP);
        this.mBottom = new VAnchor(this, VSide.BOTTOM);
        this.mStart = new HAnchor(this, HSide.START);
        this.mEnd = new HAnchor(this, HSide.END);
        this.mBaseline = new VAnchor(this, VSide.BASELINE);
        int r1 = UNSET;
        this.mWidth = r1;
        this.mHeight = r1;
        this.mHorizontalBias = Float.NaN;
        this.mVerticalBias = Float.NaN;
        this.mDimensionRatio = null;
        this.mCircleConstraint = null;
        this.mCircleRadius = Integer.MIN_VALUE;
        this.mCircleAngle = Float.NaN;
        this.mEditorAbsoluteX = Integer.MIN_VALUE;
        this.mEditorAbsoluteY = Integer.MIN_VALUE;
        this.mVerticalWeight = Float.NaN;
        this.mHorizontalWeight = Float.NaN;
        this.mHorizontalChainStyle = null;
        this.mVerticalChainStyle = null;
        this.mWidthDefault = null;
        this.mHeightDefault = null;
        this.mWidthMax = r1;
        this.mHeightMax = r1;
        this.mWidthMin = r1;
        this.mHeightMin = r1;
        this.mWidthPercent = Float.NaN;
        this.mHeightPercent = Float.NaN;
        this.mReferenceIds = null;
        this.mConstrainedWidth = false;
        this.mConstrainedHeight = false;
        this.mId = r5;
    }

    public HAnchor getLeft() {
        return this.mLeft;
    }

    public HAnchor getRight() {
        return this.mRight;
    }

    public VAnchor getTop() {
        return this.mTop;
    }

    public VAnchor getBottom() {
        return this.mBottom;
    }

    public HAnchor getStart() {
        return this.mStart;
    }

    public HAnchor getEnd() {
        return this.mEnd;
    }

    public VAnchor getBaseline() {
        return this.mBaseline;
    }

    public float getHorizontalBias() {
        return this.mHorizontalBias;
    }

    public void setHorizontalBias(float r1) {
        this.mHorizontalBias = r1;
    }

    public float getVerticalBias() {
        return this.mVerticalBias;
    }

    public void setVerticalBias(float r1) {
        this.mVerticalBias = r1;
    }

    public String getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public void setDimensionRatio(String r1) {
        this.mDimensionRatio = r1;
    }

    public String getCircleConstraint() {
        return this.mCircleConstraint;
    }

    public void setCircleConstraint(String r1) {
        this.mCircleConstraint = r1;
    }

    public int getCircleRadius() {
        return this.mCircleRadius;
    }

    public void setCircleRadius(int r1) {
        this.mCircleRadius = r1;
    }

    public float getCircleAngle() {
        return this.mCircleAngle;
    }

    public void setCircleAngle(float r1) {
        this.mCircleAngle = r1;
    }

    public int getEditorAbsoluteX() {
        return this.mEditorAbsoluteX;
    }

    public void setEditorAbsoluteX(int r1) {
        this.mEditorAbsoluteX = r1;
    }

    public int getEditorAbsoluteY() {
        return this.mEditorAbsoluteY;
    }

    public void setEditorAbsoluteY(int r1) {
        this.mEditorAbsoluteY = r1;
    }

    public float getVerticalWeight() {
        return this.mVerticalWeight;
    }

    public void setVerticalWeight(float r1) {
        this.mVerticalWeight = r1;
    }

    public float getHorizontalWeight() {
        return this.mHorizontalWeight;
    }

    public void setHorizontalWeight(float r1) {
        this.mHorizontalWeight = r1;
    }

    public ChainMode getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setHorizontalChainStyle(ChainMode r1) {
        this.mHorizontalChainStyle = r1;
    }

    public ChainMode getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public void setVerticalChainStyle(ChainMode r1) {
        this.mVerticalChainStyle = r1;
    }

    public Behaviour getWidthDefault() {
        return this.mWidthDefault;
    }

    public void setWidthDefault(Behaviour r1) {
        this.mWidthDefault = r1;
    }

    public Behaviour getHeightDefault() {
        return this.mHeightDefault;
    }

    public void setHeightDefault(Behaviour r1) {
        this.mHeightDefault = r1;
    }

    public int getWidthMax() {
        return this.mWidthMax;
    }

    public void setWidthMax(int r1) {
        this.mWidthMax = r1;
    }

    public int getHeightMax() {
        return this.mHeightMax;
    }

    public void setHeightMax(int r1) {
        this.mHeightMax = r1;
    }

    public int getWidthMin() {
        return this.mWidthMin;
    }

    public void setWidthMin(int r1) {
        this.mWidthMin = r1;
    }

    public int getHeightMin() {
        return this.mHeightMin;
    }

    public void setHeightMin(int r1) {
        this.mHeightMin = r1;
    }

    public float getWidthPercent() {
        return this.mWidthPercent;
    }

    public void setWidthPercent(float r1) {
        this.mWidthPercent = r1;
    }

    public float getHeightPercent() {
        return this.mHeightPercent;
    }

    public void setHeightPercent(float r1) {
        this.mHeightPercent = r1;
    }

    public String[] getReferenceIds() {
        return this.mReferenceIds;
    }

    public void setReferenceIds(String[] r1) {
        this.mReferenceIds = r1;
    }

    public boolean isConstrainedWidth() {
        return this.mConstrainedWidth;
    }

    public void setConstrainedWidth(boolean r1) {
        this.mConstrainedWidth = r1;
    }

    public boolean isConstrainedHeight() {
        return this.mConstrainedHeight;
    }

    public void setConstrainedHeight(boolean r1) {
        this.mConstrainedHeight = r1;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int r1) {
        this.mWidth = r1;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int r1) {
        this.mHeight = r1;
    }

    public void linkToTop(VAnchor r2) {
        linkToTop(r2, 0);
    }

    public void linkToLeft(HAnchor r2) {
        linkToLeft(r2, 0);
    }

    public void linkToRight(HAnchor r2) {
        linkToRight(r2, 0);
    }

    public void linkToStart(HAnchor r2) {
        linkToStart(r2, 0);
    }

    public void linkToEnd(HAnchor r2) {
        linkToEnd(r2, 0);
    }

    public void linkToBottom(VAnchor r2) {
        linkToBottom(r2, 0);
    }

    public void linkToBaseline(VAnchor r2) {
        linkToBaseline(r2, 0);
    }

    public void linkToTop(VAnchor r2, int r3) {
        linkToTop(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToLeft(HAnchor r2, int r3) {
        linkToLeft(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToRight(HAnchor r2, int r3) {
        linkToRight(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToStart(HAnchor r2, int r3) {
        linkToStart(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToEnd(HAnchor r2, int r3) {
        linkToEnd(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToBottom(VAnchor r2, int r3) {
        linkToBottom(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToBaseline(VAnchor r2, int r3) {
        linkToBaseline(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToTop(VAnchor r2, int r3, int r4) {
        this.mTop.mConnection = r2;
        this.mTop.mMargin = r3;
        this.mTop.mGoneMargin = r4;
    }

    public void linkToLeft(HAnchor r2, int r3, int r4) {
        this.mLeft.mConnection = r2;
        this.mLeft.mMargin = r3;
        this.mLeft.mGoneMargin = r4;
    }

    public void linkToRight(HAnchor r2, int r3, int r4) {
        this.mRight.mConnection = r2;
        this.mRight.mMargin = r3;
        this.mRight.mGoneMargin = r4;
    }

    public void linkToStart(HAnchor r2, int r3, int r4) {
        this.mStart.mConnection = r2;
        this.mStart.mMargin = r3;
        this.mStart.mGoneMargin = r4;
    }

    public void linkToEnd(HAnchor r2, int r3, int r4) {
        this.mEnd.mConnection = r2;
        this.mEnd.mMargin = r3;
        this.mEnd.mGoneMargin = r4;
    }

    public void linkToBottom(VAnchor r2, int r3, int r4) {
        this.mBottom.mConnection = r2;
        this.mBottom.mMargin = r3;
        this.mBottom.mGoneMargin = r4;
    }

    public void linkToBaseline(VAnchor r2, int r3, int r4) {
        this.mBaseline.mConnection = r2;
        this.mBaseline.mMargin = r3;
        this.mBaseline.mGoneMargin = r4;
    }

    public String convertStringArrayToString(String[] r4) {
        StringBuilder r3 = new StringBuilder("[");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        if (r0 != 0) goto L8;
        String r2 = "'";
    L9:
        r3.append(r2);
        r3.append(r4[r0]);
        r3.append("'");
        r0 = r0 + 1;
        goto L4
    L8:
        r2 = ",'";
        goto L9
    L10:
        r3.append("]");
        return r3.toString();
    }

    protected void append(StringBuilder r1, String r2, float r3) {
        if (Float.isNaN(r3) == false) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(":").append(r3).append(",\n");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.mId + ":{\n");
        this.mLeft.build(r0);
        this.mRight.build(r0);
        this.mTop.build(r0);
        this.mBottom.build(r0);
        this.mStart.build(r0);
        this.mEnd.build(r0);
        this.mBaseline.build(r0);
        if (this.mWidth == UNSET) goto L6;
        r0.append("width:").append(this.mWidth).append(",\n");
    L6:
        if (this.mHeight == UNSET) goto L8;
        r0.append("height:").append(this.mHeight).append(",\n");
    L8:
        append(r0, "horizontalBias", this.mHorizontalBias);
        append(r0, "verticalBias", this.mVerticalBias);
        if (this.mDimensionRatio == null) goto L12;
        r0.append("dimensionRatio:'").append(this.mDimensionRatio).append("',\n");
    L12:
        if (this.mCircleConstraint != null) goto L14;
    L27:
        append(r0, "verticalWeight", this.mVerticalWeight);
        append(r0, "horizontalWeight", this.mHorizontalWeight);
        if (this.mHorizontalChainStyle == null) goto L31;
        r0.append("horizontalChainStyle:'").append(chainModeMap.get(this.mHorizontalChainStyle)).append("',\n");
    L31:
        if (this.mVerticalChainStyle == null) goto L34;
        r0.append("verticalChainStyle:'").append(chainModeMap.get(this.mVerticalChainStyle)).append("',\n");
    L34:
        if (this.mWidthDefault == null) goto L48;
        int r1 = this.mWidthMax;
        int r9 = UNSET;
        if (r1 == r9) goto L38;
    L40:
        r0.append("width:{value:'").append(this.mWidthDefault.toString().toLowerCase()).append("'");
        if (this.mWidthMax == UNSET) goto L44;
        r0.append(",max:").append(this.mWidthMax);
    L44:
        if (this.mWidthMin == UNSET) goto L46;
        r0.append(",min:").append(this.mWidthMin);
    L46:
        r0.append("},\n");
        goto L48
    L38:
        if (this.mWidthMin != r9) goto L40;
        r0.append("width:'").append(this.mWidthDefault.toString().toLowerCase()).append("',\n");
    L48:
        if (this.mHeightDefault == null) goto L62;
        int r2 = this.mHeightMax;
        int r10 = UNSET;
        if (r2 == r10) goto L52;
    L54:
        r0.append("height:{value:'").append(this.mHeightDefault.toString().toLowerCase()).append("'");
        if (this.mHeightMax == UNSET) goto L58;
        r0.append(",max:").append(this.mHeightMax);
    L58:
        if (this.mHeightMin == UNSET) goto L60;
        r0.append(",min:").append(this.mHeightMin);
    L60:
        r0.append("},\n");
        goto L62
    L52:
        if (this.mHeightMin != r10) goto L54;
        r0.append("height:'").append(this.mHeightDefault.toString().toLowerCase()).append("',\n");
    L62:
        if (Double.isNaN(this.mWidthPercent) == true) goto L65;
        r0.append("width:'").append((int) this.mWidthPercent).append("%',\n");
    L65:
        if (Double.isNaN(this.mHeightPercent) == true) goto L68;
        r0.append("height:'").append((int) this.mHeightPercent).append("%',\n");
    L68:
        if (this.mReferenceIds == null) goto L71;
        r0.append("referenceIds:").append(convertStringArrayToString(this.mReferenceIds)).append(",\n");
    L71:
        if (this.mConstrainedWidth == false) goto L74;
        r0.append("constrainedWidth:").append(this.mConstrainedWidth).append(",\n");
    L74:
        if (this.mConstrainedHeight == false) goto L76;
        r0.append("constrainedHeight:").append(this.mConstrainedHeight).append(",\n");
    L76:
        r0.append("},\n");
        return r0.toString();
    L14:
        if (Float.isNaN(this.mCircleAngle) == true) goto L16;
    L17:
        r0.append("circular:['").append(this.mCircleConstraint).append("'");
        if (Float.isNaN(this.mCircleAngle) == true) goto L21;
        r0.append(",").append(this.mCircleAngle);
    L21:
        if (this.mCircleRadius != Integer.MIN_VALUE) goto L23;
    L26:
        r0.append("],\n");
        goto L27
    L23:
        if (Float.isNaN(this.mCircleAngle) == false) goto L25;
        r0.append(",0,").append(this.mCircleRadius);
        goto L26
    L25:
        r0.append(",").append(this.mCircleRadius);
        goto L26
    L16:
        if (this.mCircleRadius == Integer.MIN_VALUE) goto L27;
        goto L17
    }
}
