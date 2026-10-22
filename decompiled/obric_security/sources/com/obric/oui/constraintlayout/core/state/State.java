package com.obric.oui.constraintlayout.core.state;

import com.obric.oui.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import com.obric.oui.constraintlayout.core.state.helpers.AlignVerticallyReference;
import com.obric.oui.constraintlayout.core.state.helpers.BarrierReference;
import com.obric.oui.constraintlayout.core.state.helpers.FlowReference;
import com.obric.oui.constraintlayout.core.state.helpers.GridReference;
import com.obric.oui.constraintlayout.core.state.helpers.GuidelineReference;
import com.obric.oui.constraintlayout.core.state.helpers.HorizontalChainReference;
import com.obric.oui.constraintlayout.core.state.helpers.VerticalChainReference;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = null;
    static final int UNKNOWN = -1;
    ArrayList<Object> mBaselineNeeded;
    ArrayList<ConstraintWidget> mBaselineNeededWidgets;
    boolean mDirtyBaselineNeededWidgets;
    private CorePixelDp mDpToPixel;
    protected HashMap<Object, HelperReference> mHelperReferences;
    private boolean mIsLtr;
    private int mNumHelpers;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences;
    HashMap<String, ArrayList<String>> mTags;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.state.State$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper = null;

        static {
            int[] r0 = new int[Helper.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper = r0;
            r0[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.VERTICAL_CHAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.ALIGN_VERTICALLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.BARRIER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.VERTICAL_FLOW.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.HORIZONTAL_FLOW.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.GRID.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.ROW.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            $SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[Helper.COLUMN.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static final enum Chain extends Enum<Chain> {
        private static final /* synthetic */ Chain[] $VALUES = null;
        public static final Chain PACKED = null;
        public static final Chain SPREAD = null;
        public static final Chain SPREAD_INSIDE = null;
        public static Map<String, Chain> chainMap;
        public static Map<String, Integer> valueMap;

        private Chain(String r1, int r2) {
            super(r1, r2);
        }

        public static Chain valueOf(String r1) {
            return (Chain) Enum.valueOf(Chain.class, r1);
        }

        public static Chain[] values() {
            return (Chain[]) $VALUES.clone();
        }

        static {
            Chain r0 = new Chain("SPREAD", 0);
            SPREAD = r0;
            Chain r1 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r1;
            Chain r3 = new Chain("PACKED", 2);
            PACKED = r3;
            $VALUES = new Chain[]{r0, r1, r3};
            chainMap = new HashMap();
            valueMap = new HashMap();
            chainMap.put("packed", r3);
            chainMap.put("spread_inside", r1);
            chainMap.put(MaterialConfigFormatNames.SPREAD, r0);
            valueMap.put("packed", 2);
            valueMap.put("spread_inside", 1);
            valueMap.put(MaterialConfigFormatNames.SPREAD, 0);
        }

        public static int getValueByString(String r1) {
            if (valueMap.containsKey(r1) == true) goto L5;
            return -1;
        L5:
            return valueMap.get(r1).intValue();
        }

        public static Chain getChainByString(String r1) {
            if (chainMap.containsKey(r1) == true) goto L5;
            return null;
        L5:
            return chainMap.get(r1);
        }
    }

    public static final enum Constraint extends Enum<Constraint> {
        private static final /* synthetic */ Constraint[] $VALUES = null;
        public static final Constraint BASELINE_TO_BASELINE = null;
        public static final Constraint BASELINE_TO_BOTTOM = null;
        public static final Constraint BASELINE_TO_TOP = null;
        public static final Constraint BOTTOM_TO_BASELINE = null;
        public static final Constraint BOTTOM_TO_BOTTOM = null;
        public static final Constraint BOTTOM_TO_TOP = null;
        public static final Constraint CENTER_HORIZONTALLY = null;
        public static final Constraint CENTER_VERTICALLY = null;
        public static final Constraint CIRCULAR_CONSTRAINT = null;
        public static final Constraint END_TO_END = null;
        public static final Constraint END_TO_START = null;
        public static final Constraint LEFT_TO_LEFT = null;
        public static final Constraint LEFT_TO_RIGHT = null;
        public static final Constraint RIGHT_TO_LEFT = null;
        public static final Constraint RIGHT_TO_RIGHT = null;
        public static final Constraint START_TO_END = null;
        public static final Constraint START_TO_START = null;
        public static final Constraint TOP_TO_BASELINE = null;
        public static final Constraint TOP_TO_BOTTOM = null;
        public static final Constraint TOP_TO_TOP = null;

        private Constraint(String r1, int r2) {
            super(r1, r2);
        }

        public static Constraint valueOf(String r1) {
            return (Constraint) Enum.valueOf(Constraint.class, r1);
        }

        public static Constraint[] values() {
            return (Constraint[]) $VALUES.clone();
        }

        static {
            Constraint r0 = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r0;
            Constraint r1 = new Constraint("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r1;
            Constraint r3 = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r3;
            Constraint r5 = new Constraint("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r5;
            Constraint r7 = new Constraint("START_TO_START", 4);
            START_TO_START = r7;
            Constraint r9 = new Constraint("START_TO_END", 5);
            START_TO_END = r9;
            Constraint r11 = new Constraint("END_TO_START", 6);
            END_TO_START = r11;
            Constraint r13 = new Constraint("END_TO_END", 7);
            END_TO_END = r13;
            Constraint r15 = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_TOP = r15;
            Constraint r14 = new Constraint("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r14;
            Constraint r12 = new Constraint("TOP_TO_BASELINE", 10);
            TOP_TO_BASELINE = r12;
            Constraint r10 = new Constraint("BOTTOM_TO_TOP", 11);
            BOTTOM_TO_TOP = r10;
            Constraint r8 = new Constraint("BOTTOM_TO_BOTTOM", 12);
            BOTTOM_TO_BOTTOM = r8;
            Constraint r6 = new Constraint("BOTTOM_TO_BASELINE", 13);
            BOTTOM_TO_BASELINE = r6;
            Constraint r4 = new Constraint("BASELINE_TO_BASELINE", 14);
            BASELINE_TO_BASELINE = r4;
            Constraint r2 = new Constraint("BASELINE_TO_TOP", 15);
            BASELINE_TO_TOP = r2;
            Constraint r16 = new Constraint("BASELINE_TO_BOTTOM", 16);
            BASELINE_TO_BOTTOM = r16;
            Constraint r17 = new Constraint("CENTER_HORIZONTALLY", 17);
            CENTER_HORIZONTALLY = r17;
            Constraint r18 = new Constraint("CENTER_VERTICALLY", 18);
            CENTER_VERTICALLY = r18;
            Constraint r19 = new Constraint("CIRCULAR_CONSTRAINT", 19);
            CIRCULAR_CONSTRAINT = r19;
            $VALUES = new Constraint[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
        }
    }

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction BOTTOM = null;
        public static final Direction END = null;
        public static final Direction LEFT = null;
        public static final Direction RIGHT = null;
        public static final Direction START = null;
        public static final Direction TOP = null;

        private Direction(String r1, int r2) {
            super(r1, r2);
        }

        public static Direction valueOf(String r1) {
            return (Direction) Enum.valueOf(Direction.class, r1);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        static {
            Direction r0 = new Direction("LEFT", 0);
            LEFT = r0;
            Direction r1 = new Direction("RIGHT", 1);
            RIGHT = r1;
            Direction r3 = new Direction("START", 2);
            START = r3;
            Direction r5 = new Direction("END", 3);
            END = r5;
            Direction r7 = new Direction("TOP", 4);
            TOP = r7;
            Direction r9 = new Direction("BOTTOM", 5);
            BOTTOM = r9;
            $VALUES = new Direction[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public static final enum Helper extends Enum<Helper> {
        private static final /* synthetic */ Helper[] $VALUES = null;
        public static final Helper ALIGN_HORIZONTALLY = null;
        public static final Helper ALIGN_VERTICALLY = null;
        public static final Helper BARRIER = null;
        public static final Helper COLUMN = null;
        public static final Helper FLOW = null;
        public static final Helper GRID = null;
        public static final Helper HORIZONTAL_CHAIN = null;
        public static final Helper HORIZONTAL_FLOW = null;
        public static final Helper LAYER = null;
        public static final Helper ROW = null;
        public static final Helper VERTICAL_CHAIN = null;
        public static final Helper VERTICAL_FLOW = null;

        private Helper(String r1, int r2) {
            super(r1, r2);
        }

        public static Helper valueOf(String r1) {
            return (Helper) Enum.valueOf(Helper.class, r1);
        }

        public static Helper[] values() {
            return (Helper[]) $VALUES.clone();
        }

        static {
            Helper r0 = new Helper("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r0;
            Helper r1 = new Helper("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r1;
            Helper r3 = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r3;
            Helper r5 = new Helper("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r5;
            Helper r7 = new Helper("BARRIER", 4);
            BARRIER = r7;
            Helper r9 = new Helper("LAYER", 5);
            LAYER = r9;
            Helper r11 = new Helper("HORIZONTAL_FLOW", 6);
            HORIZONTAL_FLOW = r11;
            Helper r13 = new Helper("VERTICAL_FLOW", 7);
            VERTICAL_FLOW = r13;
            Helper r15 = new Helper("GRID", 8);
            GRID = r15;
            Helper r14 = new Helper("ROW", 9);
            ROW = r14;
            Helper r12 = new Helper("COLUMN", 10);
            COLUMN = r12;
            Helper r10 = new Helper("FLOW", 11);
            FLOW = r10;
            $VALUES = new Helper[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }
    }

    public static final enum Wrap extends Enum<Wrap> {
        private static final /* synthetic */ Wrap[] $VALUES = null;
        public static final Wrap ALIGNED = null;
        public static final Wrap CHAIN = null;
        public static final Wrap NONE = null;
        public static Map<String, Integer> valueMap;
        public static Map<String, Wrap> wrapMap;

        private Wrap(String r1, int r2) {
            super(r1, r2);
        }

        public static Wrap valueOf(String r1) {
            return (Wrap) Enum.valueOf(Wrap.class, r1);
        }

        public static Wrap[] values() {
            return (Wrap[]) $VALUES.clone();
        }

        static {
            Wrap r0 = new Wrap("NONE", 0);
            NONE = r0;
            Wrap r1 = new Wrap("CHAIN", 1);
            CHAIN = r1;
            Wrap r3 = new Wrap("ALIGNED", 2);
            ALIGNED = r3;
            $VALUES = new Wrap[]{r0, r1, r3};
            wrapMap = new HashMap();
            valueMap = new HashMap();
            wrapMap.put("none", r0);
            wrapMap.put("chain", r1);
            wrapMap.put("aligned", r3);
            valueMap.put("none", 0);
            valueMap.put("chain", 3);
            valueMap.put("aligned", 2);
        }

        public static int getValueByString(String r1) {
            if (valueMap.containsKey(r1) == true) goto L5;
            return -1;
        L5:
            return valueMap.get(r1).intValue();
        }

        public static Wrap getChainByString(String r1) {
            if (wrapMap.containsKey(r1) == true) goto L5;
            return null;
        L5:
            return wrapMap.get(r1);
        }
    }

    static {
        PARENT = 0;
    }

    public State() {
        this.mIsLtr = true;
        this.mReferences = new HashMap();
        this.mHelperReferences = new HashMap();
        this.mTags = new HashMap();
        ConstraintReference r1 = new ConstraintReference(this);
        this.mParent = r1;
        this.mNumHelpers = 0;
        this.mBaselineNeeded = new ArrayList();
        this.mBaselineNeededWidgets = new ArrayList();
        this.mDirtyBaselineNeededWidgets = true;
        Integer r0 = PARENT;
        r1.setKey(r0);
        this.mReferences.put(r0, r1);
    }

    CorePixelDp getDpToPixel() {
        return this.mDpToPixel;
    }

    public void setDpToPixel(CorePixelDp r1) {
        this.mDpToPixel = r1;
    }

    @Deprecated
    public void setLtr(boolean r1) {
        this.mIsLtr = r1;
    }

    @Deprecated
    public boolean isLtr() {
        return this.mIsLtr;
    }

    public void setRtl(boolean r1) {
        this.mIsLtr = !r1;
    }

    public boolean isRtl() {
        return !this.mIsLtr;
    }

    public void reset() {
        Iterator<Object> r0 = this.mReferences.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Object r1 = r0.next();
        this.mReferences.get(r1).getConstraintWidget().reset();
        goto L4
    L6:
        this.mReferences.clear();
        this.mReferences.put(PARENT, this.mParent);
        this.mHelperReferences.clear();
        this.mTags.clear();
        this.mBaselineNeeded.clear();
        this.mDirtyBaselineNeededWidgets = true;
    }

    public int convertDimension(Object r1) {
        if ((r1 instanceof Float) == false) goto L7;
        return Math.round(((Float) r1).floatValue());
    L7:
        if ((r1 instanceof Integer) == true) goto L9;
        return 0;
    L9:
        return ((Integer) r1).intValue();
    }

    public ConstraintReference createConstraintReference(Object r1) {
        return new ConstraintReference(this);
    }

    public boolean sameFixedWidth(int r1) {
        return this.mParent.getWidth().equalsFixedValue(r1);
    }

    public boolean sameFixedHeight(int r1) {
        return this.mParent.getHeight().equalsFixedValue(r1);
    }

    public State width(Dimension r1) {
        return setWidth(r1);
    }

    public State height(Dimension r1) {
        return setHeight(r1);
    }

    public State setWidth(Dimension r2) {
        this.mParent.setWidth(r2);
        return this;
    }

    public State setHeight(Dimension r2) {
        this.mParent.setHeight(r2);
        return this;
    }

    Reference reference(Object r1) {
        return this.mReferences.get(r1);
    }

    public ConstraintReference constraints(Object r2) {
        Reference r0 = this.mReferences.get(r2);
        if (r0 != null) goto L6;
        r0 = createConstraintReference(r2);
        this.mReferences.put(r2, r0);
        r0.setKey(r2);
    L6:
        if ((r0 instanceof ConstraintReference) == true) goto L8;
        return null;
    L8:
        return (ConstraintReference) r0;
    }

    private String createHelperKey() {
        StringBuilder r0 = new StringBuilder("__HELPER_KEY_");
        int r1 = this.mNumHelpers;
        this.mNumHelpers = r1 + 1;
        return r0.append(r1).append("__").toString();
    }

    public HelperReference helper(Object r3, Helper r4) {
        if (r3 != null) goto L4;
        r3 = createHelperKey();
    L4:
        HelperReference r0 = this.mHelperReferences.get(r3);
        if (r0 == null) goto L7;
    L18:
        return r0;
    L7:
        switch(AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$state$State$Helper[r4.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L9;
            case 10: goto L9;
            default: goto L8;
        };
    L8:
        r0 = new HelperReference(this, r4);
    L17:
        r0.setKey(r3);
        this.mHelperReferences.put(r3, r0);
        goto L18
    L9:
        r0 = new GridReference(this, r4);
        goto L17
    L10:
        r0 = new FlowReference(this, r4);
        goto L17
    L11:
        HelperReference r5 = new BarrierReference(this);
    L16:
        r0 = r5;
        goto L17
    L12:
        r5 = new AlignVerticallyReference(this);
        goto L16
    L13:
        r5 = new AlignHorizontallyReference(this);
        goto L16
    L14:
        r5 = new VerticalChainReference(this);
        goto L16
    L15:
        r5 = new HorizontalChainReference(this);
        goto L16
    }

    public GuidelineReference horizontalGuideline(Object r2) {
        return guideline(r2, 0);
    }

    public GuidelineReference verticalGuideline(Object r2) {
        return guideline(r2, 1);
    }

    public GuidelineReference guideline(Object r3, int r4) {
        ConstraintReference r0 = constraints(r3);
        if (r0.getFacade() != null) goto L5;
    L6:
        GuidelineReference r1 = new GuidelineReference(this);
        r1.setOrientation(r4);
        r1.setKey(r3);
        r0.setFacade(r1);
    L8:
        return (GuidelineReference) r0.getFacade();
    L5:
        if ((r0.getFacade() instanceof GuidelineReference) == true) goto L8;
        goto L6
    }

    public BarrierReference barrier(Object r2, Direction r3) {
        ConstraintReference r4 = constraints(r2);
        if (r4.getFacade() != null) goto L5;
    L6:
        BarrierReference r0 = new BarrierReference(this);
        r0.setBarrierDirection(r3);
        r4.setFacade(r0);
    L8:
        return (BarrierReference) r4.getFacade();
    L5:
        if ((r4.getFacade() instanceof BarrierReference) == true) goto L8;
        goto L6
    }

    public GridReference getGrid(Object r5, String r6) {
        ConstraintReference r7 = constraints(r5);
        if (r7.getFacade() != null) goto L5;
    L6:
        Helper r0 = Helper.GRID;
        if (r6.charAt(0) != 'r') goto L10;
        r0 = Helper.ROW;
    L12:
        r7.setFacade(new GridReference(this, r0));
    L14:
        return (GridReference) r7.getFacade();
    L10:
        if (r6.charAt(0) != 'c') goto L12;
        r0 = Helper.COLUMN;
        goto L12
    L5:
        if ((r7.getFacade() instanceof GridReference) == true) goto L14;
        goto L6
    }

    public FlowReference getFlow(Object r2, boolean r3) {
        ConstraintReference r4 = constraints(r2);
        if (r4.getFacade() != null) goto L5;
    L6:
        if (r3 == false) goto L8;
        FlowReference r5 = new FlowReference(this, Helper.VERTICAL_FLOW);
    L9:
        r4.setFacade(r5);
    L11:
        return (FlowReference) r4.getFacade();
    L8:
        r5 = new FlowReference(this, Helper.HORIZONTAL_FLOW);
        goto L9
    L5:
        if ((r4.getFacade() instanceof FlowReference) == true) goto L11;
        goto L6
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
    }

    public VerticalChainReference verticalChain(Object... r3) {
        VerticalChainReference r2 = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
        r2.add(r3);
        return r2;
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
    }

    public HorizontalChainReference horizontalChain(Object... r3) {
        HorizontalChainReference r2 = (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
        r2.add(r3);
        return r2;
    }

    public FlowReference getVerticalFlow() {
        return (FlowReference) helper(null, Helper.VERTICAL_FLOW);
    }

    public FlowReference getVerticalFlow(Object... r3) {
        FlowReference r2 = (FlowReference) helper(null, Helper.VERTICAL_FLOW);
        r2.add(r3);
        return r2;
    }

    public FlowReference getHorizontalFlow() {
        return (FlowReference) helper(null, Helper.HORIZONTAL_FLOW);
    }

    public FlowReference getHorizontalFlow(Object... r3) {
        FlowReference r2 = (FlowReference) helper(null, Helper.HORIZONTAL_FLOW);
        r2.add(r3);
        return r2;
    }

    public AlignHorizontallyReference centerHorizontally(Object... r3) {
        AlignHorizontallyReference r2 = (AlignHorizontallyReference) helper(null, Helper.ALIGN_HORIZONTALLY);
        r2.add(r3);
        return r2;
    }

    public AlignVerticallyReference centerVertically(Object... r3) {
        AlignVerticallyReference r2 = (AlignVerticallyReference) helper(null, Helper.ALIGN_VERTICALLY);
        r2.add(r3);
        return r2;
    }

    public void directMapping() {
        Iterator<Object> r0 = this.mReferences.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r1 = r0.next();
        ConstraintReference r2 = constraints(r1);
        if ((r2 instanceof ConstraintReference) == false) goto L4;
        r2.setView(r1);
        goto L4
    }

    public void map(Object r1, Object r2) {
        ConstraintReference r0 = constraints(r1);
        if (r0 == null) goto L6;
        r0.setView(r2);
        return;
    }

    public void setTag(String r3, String r4) {
        ConstraintReference r0 = constraints(r3);
        if ((r0 instanceof ConstraintReference) == false) goto L10;
        r0.setTag(r4);
        if (this.mTags.containsKey(r4) == true) goto L7;
        ArrayList<String> r1 = new ArrayList();
        this.mTags.put(r4, r1);
    L8:
        r1.add(r3);
        return;
    L7:
        r1 = this.mTags.get(r4);
        goto L8
    }

    public ArrayList<String> getIdsForTag(String r2) {
        if (this.mTags.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.mTags.get(r2);
    }

    public void apply(ConstraintWidgetContainer r8) {
        r8.removeAllChildren();
        this.mParent.getWidth().apply(this, r8, 0);
        this.mParent.getHeight().apply(this, r8, 1);
        Iterator<Object> r0 = this.mHelperReferences.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        HelperWidget r2 = this.mHelperReferences.get(r1).getHelperWidget();
        if (r2 == null) goto L4;
        Reference r3 = this.mReferences.get(r1);
        if (r3 != null) goto L10;
        r3 = constraints(r1);
    L10:
        r3.setConstraintWidget(r2);
        goto L4
    L11:
        Iterator<Object> r4 = this.mReferences.keySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();
        Reference r6 = this.mReferences.get(r5);
        if (r6 == this.mParent) goto L13;
        if ((r6.getFacade() instanceof HelperReference) == false) goto L13;
        HelperWidget r7 = ((HelperReference) r6.getFacade()).getHelperWidget();
        if (r7 == null) goto L13;
        Reference r9 = this.mReferences.get(r5);
        if (r9 != null) goto L23;
        r9 = constraints(r5);
    L23:
        r9.setConstraintWidget(r7);
        goto L13
    L24:
        Iterator<Object> r10 = this.mReferences.keySet().iterator();
    L26:
        if (r10.hasNext() == false) goto L34;
        Reference r11 = this.mReferences.get(r10.next());
        if (r11 != this.mParent) goto L29;
        r11.setConstraintWidget(r8);
        goto L26
    L29:
        ConstraintWidget r12 = r11.getConstraintWidget();
        r12.setDebugName(r11.getKey().toString());
        r12.setParent(null);
        if ((r11.getFacade() instanceof GuidelineReference) == false) goto L32;
        r11.apply();
    L32:
        r8.add(r12);
        goto L26
    L34:
        Iterator<Object> r13 = this.mHelperReferences.keySet().iterator();
    L36:
        if (r13.hasNext() == false) goto L45;
        HelperReference r14 = this.mHelperReferences.get(r13.next());
        if (r14.getHelperWidget() != null) goto L39;
        r14.apply();
        goto L36
    L39:
        Iterator<Object> r15 = r14.mReferences.iterator();
    L41:
        if (r15.hasNext() == false) goto L43;
        r14.getHelperWidget().add(this.mReferences.get(r15.next()).getConstraintWidget());
        goto L41
    L43:
        r14.apply();
        goto L36
    L45:
        Iterator<Object> r16 = this.mReferences.keySet().iterator();
    L47:
        if (r16.hasNext() == false) goto L65;
        Reference r17 = this.mReferences.get(r16.next());
        if (r17 == this.mParent) goto L47;
        if ((r17.getFacade() instanceof HelperReference) == false) goto L47;
        HelperReference r18 = (HelperReference) r17.getFacade();
        HelperWidget r19 = r18.getHelperWidget();
        if (r19 == null) goto L47;
        Iterator<Object> r20 = r18.mReferences.iterator();
    L56:
        if (r20.hasNext() == false) goto L64;
        Object r21 = r20.next();
        Reference r22 = this.mReferences.get(r21);
        if (r22 != null) goto L59;
        if ((r21 instanceof Reference) == true) goto L62;
        System.out.println("couldn't find reference for " + r21);
        goto L56
    L62:
        r19.add(((Reference) r21).getConstraintWidget());
        goto L56
    L59:
        r19.add(r22.getConstraintWidget());
        goto L56
    L64:
        r17.apply();
        goto L47
    L65:
        Iterator<Object> r23 = this.mReferences.keySet().iterator();
    L67:
        if (r23.hasNext() == false) goto L72;
        Object r24 = r23.next();
        Reference r25 = this.mReferences.get(r24);
        r25.apply();
        ConstraintWidget r26 = r25.getConstraintWidget();
        if (r26 == null) goto L67;
        if (r24 == null) goto L67;
        r26.stringId = r24.toString();
        goto L67
    }

    public void baselineNeededFor(Object r2) {
        this.mBaselineNeeded.add(r2);
        this.mDirtyBaselineNeededWidgets = true;
    }

    public boolean isBaselineNeeded(ConstraintWidget r4) {
        if (this.mDirtyBaselineNeededWidgets == false) goto L12;
        this.mBaselineNeededWidgets.clear();
        Iterator<Object> r0 = this.mBaselineNeeded.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Object r1 = r0.next();
        ConstraintWidget r2 = this.mReferences.get(r1).getConstraintWidget();
        if (r2 == null) goto L6;
        this.mBaselineNeededWidgets.add(r2);
        goto L6
    L10:
        this.mDirtyBaselineNeededWidgets = false;
    L12:
        return this.mBaselineNeededWidgets.contains(r4);
    }
}
