package com.obric.oui.constraintlayout.core.state;

import androidx.slice.core.SliceHints;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.oui.constraintlayout.core.motion.utils.TypedBundle;
import com.obric.oui.constraintlayout.core.parser.CLArray;
import com.obric.oui.constraintlayout.core.parser.CLElement;
import com.obric.oui.constraintlayout.core.parser.CLKey;
import com.obric.oui.constraintlayout.core.parser.CLNumber;
import com.obric.oui.constraintlayout.core.parser.CLObject;
import com.obric.oui.constraintlayout.core.parser.CLParser;
import com.obric.oui.constraintlayout.core.parser.CLParsingException;
import com.obric.oui.constraintlayout.core.parser.CLString;
import com.obric.oui.constraintlayout.core.state.helpers.BarrierReference;
import com.obric.oui.constraintlayout.core.state.helpers.ChainReference;
import com.obric.oui.constraintlayout.core.state.helpers.FlowReference;
import com.obric.oui.constraintlayout.core.state.helpers.GridReference;
import com.obric.oui.constraintlayout.core.state.helpers.GuidelineReference;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes4.dex */
public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        public String getId() {
            return this.mId;
        }

        public String getType() {
            return this.mType;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        DesignElement(String r1, String r2, HashMap<String, String> r3) {
            this.mId = r1;
            this.mType = r2;
            this.mParams = r3;
        }
    }

    static class FiniteGenerator implements GeneratedValue {
        float mCurrent;
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        boolean mStop;
        float mTo;

        FiniteGenerator(float r2, float r3, float r4, String r5, String r6) {
            this.mStop = false;
            this.mCurrent = 0.0f;
            this.mFrom = r2;
            this.mTo = r3;
            this.mStep = r4;
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            this.mPrefix = r5;
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            this.mPostfix = r6;
            this.mMax = r3;
            this.mInitial = r2;
        }

        @Override // com.obric.oui.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            float r0 = this.mCurrent;
            if (r0 < this.mMax) goto L6;
            this.mStop = true;
        L6:
            if (this.mStop == true) goto L9;
            this.mCurrent = r0 + this.mStep;
        L9:
            return this.mCurrent;
        }

        public ArrayList<String> array() {
            ArrayList<String> r0 = new ArrayList();
            int r1 = (int) this.mInitial;
            int r2 = (int) this.mMax;
            int r3 = r1;
        L3:
            if (r1 > r2) goto L5;
            r0.add(this.mPrefix + r3 + this.mPostfix);
            r3 = r3 + ((int) this.mStep);
            r1 = r1 + 1;
            goto L3
        L5:
            return r0;
        }
    }

    interface GeneratedValue {
        float value();
    }

    static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop;

        Generator(float r2, float r3) {
            this.mStop = false;
            this.mStart = r2;
            this.mIncrementBy = r3;
            this.mCurrent = r2;
        }

        @Override // com.obric.oui.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (this.mStop == true) goto L6;
            this.mCurrent += this.mIncrementBy;
        L6:
            return this.mCurrent;
        }
    }

    public static class LayoutVariables {
        HashMap<String, ArrayList<String>> mArrayIds;
        HashMap<String, GeneratedValue> mGenerators;
        HashMap<String, Integer> mMargins;

        public LayoutVariables() {
            this.mMargins = new HashMap();
            this.mGenerators = new HashMap();
            this.mArrayIds = new HashMap();
        }

        void put(String r1, int r2) {
            this.mMargins.put(r1, Integer.valueOf(r2));
        }

        void put(String r2, float r3, float r4) {
            if (this.mGenerators.containsKey(r2) == true) goto L5;
        L7:
            this.mGenerators.put(r2, new Generator(r3, r4));
            return;
        L5:
            if ((this.mGenerators.get(r2) instanceof OverrideValue) == false) goto L7;
        }

        void put(String r8, float r9, float r10, float r11, String r12, String r13) {
            if (this.mGenerators.containsKey(r8) == true) goto L5;
        L7:
            FiniteGenerator r0 = new FiniteGenerator(r9, r10, r11, r12, r13);
            this.mGenerators.put(r8, r0);
            this.mArrayIds.put(r8, r0.array());
            return;
        L5:
            if ((this.mGenerators.get(r8) instanceof OverrideValue) == false) goto L7;
        }

        public void putOverride(String r2, float r3) {
            OverrideValue r0 = new OverrideValue(r3);
            this.mGenerators.put(r2, r0);
        }

        float get(Object r2) {
            if ((r2 instanceof CLString) == false) goto L13;
            String r3 = ((CLString) r2).content();
            if (this.mGenerators.containsKey(r3) == false) goto L9;
            return this.mGenerators.get(r3).value();
        L9:
            if (this.mMargins.containsKey(r3) == true) goto L11;
            return 0.0f;
        L11:
            return this.mMargins.get(r3).floatValue();
        L13:
            if ((r2 instanceof CLNumber) == true) goto L15;
            return 0.0f;
        L15:
            return ((CLNumber) r2).getFloat();
        }

        ArrayList<String> getList(String r2) {
            if (this.mArrayIds.containsKey(r2) == true) goto L5;
            return null;
        L5:
            return this.mArrayIds.get(r2);
        }

        void put(String r1, ArrayList<String> r2) {
            this.mArrayIds.put(r1, r2);
        }
    }

    public static final enum MotionLayoutDebugFlags extends Enum<MotionLayoutDebugFlags> {
        private static final /* synthetic */ MotionLayoutDebugFlags[] $VALUES = null;
        public static final MotionLayoutDebugFlags NONE = null;
        public static final MotionLayoutDebugFlags SHOW_ALL = null;
        public static final MotionLayoutDebugFlags UNKNOWN = null;

        private MotionLayoutDebugFlags(String r1, int r2) {
            super(r1, r2);
        }

        public static MotionLayoutDebugFlags valueOf(String r1) {
            return (MotionLayoutDebugFlags) Enum.valueOf(MotionLayoutDebugFlags.class, r1);
        }

        public static MotionLayoutDebugFlags[] values() {
            return (MotionLayoutDebugFlags[]) $VALUES.clone();
        }

        static {
            MotionLayoutDebugFlags r0 = new MotionLayoutDebugFlags("NONE", 0);
            NONE = r0;
            MotionLayoutDebugFlags r1 = new MotionLayoutDebugFlags("SHOW_ALL", 1);
            SHOW_ALL = r1;
            MotionLayoutDebugFlags r3 = new MotionLayoutDebugFlags(NetworkStackConstant.UNKNOWN_TYPE, 2);
            UNKNOWN = r3;
            $VALUES = new MotionLayoutDebugFlags[]{r0, r1, r3};
        }
    }

    static class OverrideValue implements GeneratedValue {
        float mValue;

        OverrideValue(float r1) {
            this.mValue = r1;
        }

        @Override // com.obric.oui.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            return this.mValue;
        }
    }

    public ConstraintSetParser() {
    }

    public static void parseJSON(String r9, Transition r10, int r11) {
        CLObject r12 = CLParser.parse(r9);     // Catch: CLParsingException -> L24
        ArrayList<String> r0 = r12.names();     // Catch: CLParsingException -> L24
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = r0.iterator();     // Catch: CLParsingException -> L24
    L6:
        if (r1.hasNext() == false) goto L45;
        String r2 = r1.next();     // Catch: CLParsingException -> L24
        CLElement r3 = r12.get(r2);     // Catch: CLParsingException -> L24
        if ((r3 instanceof CLObject) == false) goto L6;
        CLObject r4 = ((CLObject) r3).getObjectOrNull("custom");     // Catch: CLParsingException -> L24
        if (r4 == null) goto L6;
        Iterator<String> r5 = r4.names().iterator();     // Catch: CLParsingException -> L24
    L14:
        if (r5.hasNext() == false) goto L6;
        String r6 = r5.next();     // Catch: CLParsingException -> L24
        CLElement r7 = r4.get(r6);     // Catch: CLParsingException -> L24
        if ((r7 instanceof CLNumber) == true) goto L17;
        if ((r7 instanceof CLString) == false) goto L14;
        long r8 = parseColorString(r7.content());     // Catch: CLParsingException -> L24
        if (r8 == (-1)) goto L14;
        r10.addCustomColor(r11, r2, r6, (int) r8);     // Catch: CLParsingException -> L24
        goto L14
    L17:
        r10.addCustomFloat(r11, r2, r6, r7.getFloat());     // Catch: CLParsingException -> L24
        goto L14
    L45:
        return;
    L24:
        e = move-exception;
        System.err.println("Error parsing JSON " + e);
    }

    public static void parseMotionSceneJSON(CoreMotionScene r7, String r8) {
        CLObject r9 = CLParser.parse(r8);     // Catch: CLParsingException -> L35
        ArrayList<String> r0 = r9.names();     // Catch: CLParsingException -> L35
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = r0.iterator();     // Catch: CLParsingException -> L35
    L6:
        if (r1.hasNext() == false) goto L54;
        String r2 = r1.next();     // Catch: CLParsingException -> L35
        CLElement r3 = r9.get(r2);     // Catch: CLParsingException -> L35
        if ((r3 instanceof CLObject) == false) goto L6;
        CLObject r4 = (CLObject) r3;     // Catch: CLParsingException -> L35
        int r5 = r2.hashCode();     // Catch: CLParsingException -> L35
        if (r5 == (-2137403731)) goto L24;
        if (r5 == (-241441378)) goto L21;
        if (r5 == 1101852654) goto L18;
    L26:
        byte r6 = -1;
    L27:
        if (r6 != 0) goto L28;
        parseConstraintSets(r7, r4);     // Catch: CLParsingException -> L35
        goto L6
    L28:
        if (r6 != 1) goto L29;
        parseTransitions(r7, r4);     // Catch: CLParsingException -> L35
        goto L6
    L29:
        if (r6 != 2) goto L6;
        parseHeader(r7, r4);     // Catch: CLParsingException -> L35
        goto L6
    L18:
        if (r2.equals("ConstraintSets") == false) goto L26;
        r6 = 0;
        goto L27
    L21:
        if (r2.equals("Transitions") == false) goto L26;
        r6 = 1;
        goto L27
    L24:
        if (r2.equals("Header") == false) goto L26;
        r6 = 2;
        goto L27
    L54:
        return;
    L35:
        e = move-exception;
        System.err.println("Error parsing JSON " + e);
    }

    static void parseConstraintSets(CoreMotionScene r8, CLObject r9) throws CLParsingException {
        ArrayList<String> r0 = r9.names();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L28;
        String r2 = r1.next();
        CLObject r3 = r9.getObject(r2);
        String r4 = r3.getStringOrNull("Extends");
        if (r4 == null) goto L25;
        if (r4.isEmpty() == true) goto L25;
        String r5 = r8.getConstraintSet(r4);
        if (r5 == null) goto L7;
        CLObject r6 = CLParser.parse(r5);
        ArrayList<String> r7 = r3.names();
        if (r7 == null) goto L7;
        Iterator<String> r10 = r7.iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        String r11 = r10.next();
        CLElement r12 = r3.get(r11);
        if ((r12 instanceof CLObject) == false) goto L20;
        override(r6, r11, (CLObject) r12);
        goto L20
    L24:
        r8.setConstraintSetContent(r2, r6.toJSON());
        boolean r13 = true;
    L26:
        if (r13 == true) goto L7;
        r8.setConstraintSetContent(r2, r3.toJSON());
    L25:
        r13 = false;
        goto L26
    }

    static void override(CLObject r6, String r7, CLObject r8) throws CLParsingException {
        if (r6.has(r7) == true) goto L5;
        r6.put(r7, r8);
        return;
    L5:
        CLObject r9 = r6.getObject(r7);
        Iterator<String> r10 = r8.names().iterator();
    L7:
        if (r10.hasNext() == false) goto L50;
        String r0 = r10.next();
        if (r0.equals("clear") == false) goto L10;
        CLArray r1 = r8.getArray("clear");
        int r2 = 0;
    L13:
        if (r2 >= r1.size()) goto L7;
        String r3 = r1.getStringOrNull(r2);
        if (r3 == null) goto L37;
        r3.hashCode();
        byte r5 = -1;
        switch(r3.hashCode()) {
            case -1727069561: goto L29;
            case -1606703562: goto L25;
            case 414334925: goto L21;
            default: goto L32;
        };
    L32:
        switch(r5) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            default: goto L33;
        };
    L33:
        r9.remove(r3);
        goto L37
    L34:
        r9.remove(MaterialConfigFormatNames.WIDTH);
        r9.remove(MonthWeekEventsView.VIEW_PARAMS_HEIGHT);
        goto L37
    L35:
        r9.remove("start");
        r9.remove(TraceStatsConsts.STATS_KEY_END);
        r9.remove("top");
        r9.remove("bottom");
        r9.remove("baseline");
        r9.remove("center");
        r9.remove("centerHorizontally");
        r9.remove("centerVertically");
        goto L37
    L36:
        r9.remove("visibility");
        r9.remove("alpha");
        r9.remove("pivotX");
        r9.remove("pivotY");
        r9.remove("rotationX");
        r9.remove("rotationY");
        r9.remove("rotationZ");
        r9.remove("scaleX");
        r9.remove("scaleY");
        r9.remove("translationX");
        r9.remove("translationY");
        goto L37
    L21:
        if (r3.equals("dimensions") == false) goto L32;
        r5 = 2;
        goto L32
    L25:
        if (r3.equals("constraints") == false) goto L32;
        r5 = 1;
        goto L32
    L29:
        if (r3.equals("transforms") == false) goto L32;
        r5 = 0;
    L37:
        r2 = r2 + 1;
        goto L13
    L10:
        r9.put(r0, r8.get(r0));
        goto L7
    }

    static void parseTransitions(CoreMotionScene r3, CLObject r4) throws CLParsingException {
        ArrayList<String> r0 = r4.names();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();
        r3.setTransitionContent(r2, r4.getObject(r2).toJSON());
        goto L7
    }

    static void parseHeader(CoreMotionScene r1, CLObject r2) {
        String r3 = r2.getStringOrNull("export");
        if (r3 == null) goto L6;
        r1.setDebugName(r3);
        return;
    }

    public static void parseJSON(String r1, State r2, LayoutVariables r3) throws CLParsingException {
        populateState(CLParser.parse(r1), r2, r3);     // Catch: CLParsingException -> L4
        return;
    L4:
        e = move-exception;
        System.err.println("Error parsing JSON " + e);
    }

    public static void populateState(CLObject r9, State r10, LayoutVariables r11) throws CLParsingException {
        ArrayList<String> r0 = r9.names();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L91;
        String r2 = r1.next();
        CLElement r3 = r9.get(r2);
        r2.hashCode();
        byte r4 = 2;
        switch(r2.hashCode()) {
            case -1824489883: goto L20;
            case 1875016085: goto L16;
            case 1921490263: goto L12;
            default: goto L10;
        };
    L10:
        byte r5 = -1;
    L23:
        switch(r5) {
            case 0: goto L89;
            case 1: goto L86;
            case 2: goto L83;
            default: goto L25;
        };
    L83:
        if ((r3 instanceof CLObject) == false) goto L7;
        parseVariables(r10, r11, (CLObject) r3);
        goto L7
    L86:
        if ((r3 instanceof CLObject) == false) goto L7;
        parseGenerate(r10, r11, (CLObject) r3);
        goto L7
    L89:
        if ((r3 instanceof CLArray) == false) goto L7;
        parseHelpers(r10, r11, (CLArray) r3);
        goto L7
    L25:
        if ((r3 instanceof CLObject) == true) goto L26;
        if ((r3 instanceof CLNumber) == false) goto L7;
        r11.put(r2, r3.getInt());
        goto L7
    L26:
        CLObject r6 = (CLObject) r3;
        String r7 = lookForType(r6);
        if (r7 != null) goto L28;
        parseWidget(r10, r11, r2, r6);
        goto L7
    L28:
        r7.hashCode();
        switch(r7.hashCode()) {
            case -1785507558: goto L67;
            case -1354837162: goto L63;
            case -1252464839: goto L60;
            case -851656725: goto L56;
            case -333143113: goto L52;
            case 113114: goto L48;
            case 3181382: goto L44;
            case 98238902: goto L40;
            case 111168196: goto L36;
            case 965681512: goto L32;
            default: goto L30;
        };
    L30:
        r4 = -1;
    L70:
        switch(r4) {
            case 0: goto L77;
            case 1: goto L76;
            case 2: goto L75;
            case 3: goto L75;
            case 4: goto L74;
            case 5: goto L76;
            case 6: goto L76;
            case 7: goto L73;
            case 8: goto L73;
            case 9: goto L72;
            default: goto L7;
        };
    L72:
        parseGuidelineParams(0, r10, r2, r6);
        goto L7
    L73:
        parseFlowType(r7, r10, r2, r11, r6);
        goto L7
    L74:
        parseBarrier(r10, r2, r6);
        goto L7
    L75:
        parseChainType(r7, r10, r2, r11, r6);
        goto L7
    L76:
        parseGridType(r7, r10, r2, r11, r6);
        goto L7
    L77:
        parseGuidelineParams(1, r10, r2, r6);
        goto L7
    L32:
        if (r7.equals("hGuideline") == false) goto L131;
        r4 = 9;
        goto L70
    L131:
        r4 = -1;
        goto L70
    L36:
        if (r7.equals("vFlow") == false) goto L132;
        r4 = 8;
        goto L70
    L132:
        r4 = -1;
        goto L70
    L40:
        if (r7.equals("hFlow") == false) goto L133;
        r4 = 7;
        goto L70
    L133:
        r4 = -1;
        goto L70
    L44:
        if (r7.equals("grid") == false) goto L134;
        r4 = 6;
        goto L70
    L134:
        r4 = -1;
        goto L70
    L48:
        if (r7.equals("row") == false) goto L135;
        r4 = 5;
        goto L70
    L135:
        r4 = -1;
        goto L70
    L52:
        if (r7.equals("barrier") == false) goto L136;
        r4 = 4;
        goto L70
    L136:
        r4 = -1;
        goto L70
    L56:
        if (r7.equals("vChain") == false) goto L137;
        r4 = 3;
        goto L70
    L137:
        r4 = -1;
        goto L70
    L60:
        if (r7.equals("hChain") == true) goto L70;
        r4 = -1;
        goto L70
    L63:
        if (r7.equals("column") == false) goto L139;
        r4 = 1;
        goto L70
    L139:
        r4 = -1;
        goto L70
    L67:
        if (r7.equals("vGuideline") == false) goto L140;
        r4 = 0;
        goto L70
    L140:
        r4 = -1;
        goto L70
    L12:
        if (r2.equals("Variables") == false) goto L128;
        r5 = 2;
        goto L23
    L128:
        r5 = -1;
        goto L23
    L16:
        if (r2.equals("Generate") == false) goto L129;
        r5 = 1;
        goto L23
    L129:
        r5 = -1;
        goto L23
    L20:
        if (r2.equals("Helpers") == false) goto L130;
        r5 = 0;
        goto L23
    L130:
        r5 = -1;
        goto L23
    }

    private static void parseVariables(State r9, LayoutVariables r10, CLObject r11) throws CLParsingException {
        ArrayList<String> r0 = r11.names();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L33;
        String r3 = r1.next();
        CLElement r2 = r11.get(r3);
        if ((r2 instanceof CLNumber) == true) goto L10;
        if ((r2 instanceof CLObject) == false) goto L7;
        CLObject r4 = (CLObject) r2;
        if (r4.has("from") == false) goto L19;
        if (r4.has("to") == false) goto L19;
        r10.put(r3, r10.get(r4.get("from")), r10.get(r4.get("to")), 1.0f, r4.getStringOrNull("prefix"), r4.getStringOrNull("postfix"));
    L19:
        if (r4.has("from") == false) goto L24;
        if (r4.has("step") == false) goto L24;
        r10.put(r3, r10.get(r4.get("from")), r10.get(r4.get("step")));
    L24:
        if (r4.has("ids") == true) goto L25;
        if (r4.has("tag") == false) goto L7;
        r10.put(r3, r9.getIdsForTag(r4.getString("tag")));
        goto L7
    L25:
        CLArray r5 = r4.getArray("ids");
        ArrayList<String> r6 = new ArrayList();
        int r7 = 0;
    L27:
        if (r7 >= r5.size()) goto L29;
        r6.add(r5.getString(r7));
        r7 = r7 + 1;
        goto L27
    L29:
        r10.put(r3, r6);
        goto L7
    L10:
        r10.put(r3, r2.getInt());
        goto L7
    }

    public static void parseDesignElementsJSON(String r11, ArrayList<DesignElement> r12) throws CLParsingException {
        CLObject r13 = CLParser.parse(r11);
        ArrayList<String> r0 = r13.names();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.size() <= 0) goto L26;
        String r1 = r0.get(0);
        CLElement r14 = r13.get(r1);
        r1.hashCode();
        if (r1.equals("Design") == true) goto L11;
        return;
    L11:
        if ((r14 instanceof CLObject) == true) goto L13;
        return;
    L13:
        CLObject r15 = (CLObject) r14;
        ArrayList<String> r2 = r15.names();
        int r3 = 0;
    L15:
        if (r3 >= r2.size()) goto L34;
        String r4 = r2.get(r3);
        CLObject r5 = (CLObject) r15.get(r4);
        System.out.printf("element found " + r4 + "", new Object[0]);
        String r6 = r5.getStringOrNull("type");
        if (r6 == null) goto L25;
        HashMap r7 = new HashMap();
        int r8 = r5.size();
        int r9 = 0;
    L19:
        if (r9 >= r8) goto L24;
        CLKey r10 = (CLKey) r5.get(r3);
        String r16 = r10.content();
        String r17 = r10.getValue().content();
        if (r17 == null) goto L23;
        r7.put(r16, r17);
    L23:
        r9 = r9 + 1;
        goto L19
    L24:
        r12.add(new DesignElement(r1, r6, r7));
    L25:
        r3 = r3 + 1;
        goto L15
    L34:
        return;
    }

    static void parseHelpers(State r7, LayoutVariables r8, CLArray r9) throws CLParsingException {
        int r1 = 0;
    L4:
        if (r1 >= r9.size()) goto L35;
        CLElement r2 = r9.get(r1);
        if ((r2 instanceof CLArray) == false) goto L34;
        CLArray r3 = (CLArray) r2;
        if (r3.size() <= 1) goto L34;
        String r4 = r3.getString(0);
        r4.hashCode();
        byte r6 = -1;
        switch(r4.hashCode()) {
            case -1785507558: goto L25;
            case -1252464839: goto L21;
            case -851656725: goto L17;
            case 965681512: goto L13;
            default: goto L28;
        };
    L28:
        switch(r6) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            default: goto L34;
        };
    L30:
        parseGuideline(0, r7, r3);
        goto L34
    L31:
        parseChain(1, r7, r8, r3);
        goto L34
    L32:
        parseChain(0, r7, r8, r3);
        goto L34
    L33:
        parseGuideline(1, r7, r3);
        goto L34
    L13:
        if (r4.equals("hGuideline") == false) goto L28;
        r6 = 3;
        goto L28
    L17:
        if (r4.equals("vChain") == false) goto L28;
        r6 = 2;
        goto L28
    L21:
        if (r4.equals("hChain") == false) goto L28;
        r6 = 1;
        goto L28
    L25:
        if (r4.equals("vGuideline") == false) goto L28;
        r6 = 0;
    L34:
        r1 = r1 + 1;
        goto L4
    }

    static void parseGenerate(State r5, LayoutVariables r6, CLObject r7) throws CLParsingException {
        ArrayList<String> r0 = r7.names();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<String> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        String r2 = r1.next();
        CLElement r3 = r7.get(r2);
        ArrayList<String> r4 = r6.getList(r2);
        if (r4 == null) goto L7;
        if ((r3 instanceof CLObject) == false) goto L7;
        Iterator<String> r8 = r4.iterator();
    L14:
        if (r8.hasNext() == false) goto L7;
        parseWidget(r5, r6, r8.next(), (CLObject) r3);
        goto L14
    }

    static void parseChain(int r6, State r7, LayoutVariables r8, CLArray r9) throws CLParsingException {
        if (r6 != 0) goto L4;
        ChainReference r10 = r7.horizontalChain();
    L5:
        CLElement r1 = r9.get(1);
        if ((r1 instanceof CLArray) == false) goto L38;
        CLArray r2 = (CLArray) r1;
        if (r2.size() < 1) goto L53;
        int r3 = 0;
    L12:
        if (r3 >= r2.size()) goto L15;
        r10.add(new Object[]{r2.getString(r3)});
        r3 = r3 + 1;
        goto L12
    L15:
        if (r9.size() <= 2) goto L52;
        CLElement r11 = r9.get(2);
        if ((r11 instanceof CLObject) == true) goto L19;
        return;
    L19:
        CLObject r12 = (CLObject) r11;
        Iterator<String> r4 = r12.names().iterator();
    L21:
        if (r4.hasNext() == false) goto L54;
        String r5 = r4.next();
        r5.hashCode();
        if (r5.equals("style") == false) goto L24;
        CLElement r13 = r12.get(r5);
        if ((r13 instanceof CLArray) == false) goto L30;
        CLArray r14 = (CLArray) r13;
        if (r14.size() <= 1) goto L30;
        String r15 = r14.getString(0);
        r10.bias(r14.getFloat(1));
    L31:
        r15.hashCode();
        if (r15.equals("packed") == false) goto L34;
        r10.style(State.Chain.PACKED);
        goto L21
    L34:
        if (r15.equals("spread_inside") == false) goto L35;
        r10.style(State.Chain.SPREAD_INSIDE);
        goto L21
    L35:
        r10.style(State.Chain.SPREAD);
    L30:
        r15 = r13.content();
        goto L31
    L24:
        parseConstraint(r7, r8, r12, r10, r5);
        goto L21
    L54:
        return;
    L52:
        return;
    L53:
        return;
    L38:
        return;
    L4:
        r10 = r7.verticalChain();
        goto L5
    }

    private static float toPix(State r0, float r1) {
        return r0.getDpToPixel().toPixels(r1);
    }

    private static void parseChainType(String r21, State r22, String r23, LayoutVariables r24, CLObject r25) throws CLParsingException {
        int r3 = 0;
        if (r21.charAt(0) != 'h') goto L5;
        ChainReference r4 = r22.horizontalChain();
    L6:
        r4.setKey(r23);
        Iterator<String> r12 = r25.names().iterator();
    L8:
        if (r12.hasNext() == false) goto L91;
        String r5 = r12.next();
        r5.hashCode();
        int r13 = 6;
        int r11 = 3;
        int r10 = 2;
        int r9 = 1;
        int r7 = -1;
        switch(r5.hashCode()) {
            case -1383228885: goto L41;
            case -567445985: goto L37;
            case 100571: goto L33;
            case 115029: goto L29;
            case 3317767: goto L25;
            case 108511772: goto L21;
            case 109757538: goto L17;
            case 109780401: goto L13;
            default: goto L44;
        };
    L44:
        switch(r7) {
            case 0: goto L89;
            case 1: goto L59;
            case 2: goto L89;
            case 3: goto L89;
            case 4: goto L89;
            case 5: goto L89;
            case 6: goto L89;
            case 7: goto L46;
            default: goto L45;
        };
    L45:
        int r8 = r3;
    L90:
        r3 = r8;
        goto L8
    L46:
        CLElement r6 = r25.get(r5);
        if ((r6 instanceof CLArray) == false) goto L51;
        CLArray r14 = (CLArray) r6;
        if (r14.size() <= 1) goto L51;
        String r15 = r14.getString(r3);
        r4.bias(r14.getFloat(1));
    L52:
        r15.hashCode();
        if (r15.equals("packed") == false) goto L55;
        r4.style(State.Chain.PACKED);
        goto L45
    L55:
        if (r15.equals("spread_inside") == true) goto L57;
        r4.style(State.Chain.SPREAD);
        goto L45
    L57:
        r4.style(State.Chain.SPREAD_INSIDE);
    L51:
        r15 = r6.content();
        goto L52
    L59:
        CLElement r16 = r25.get(r5);
        if ((r16 instanceof CLArray) == false) goto L87;
        CLArray r17 = (CLArray) r16;
        if (r17.size() < 1) goto L87;
        int r18 = r3;
    L66:
        if (r18 >= r17.size()) goto L45;
        CLElement r19 = r17.get(r18);
        if ((r19 instanceof CLArray) == false) goto L85;
        CLArray r20 = (CLArray) r19;
        if (r20.size() <= 0) goto L83;
        String r26 = r20.get(r3).content();
        int r27 = r20.size();
        float r110 = Float.NaN;
        if (r27 == r10) goto L81;
        if (r27 == r11) goto L80;
        if (r27 == 4) goto L79;
        if (r27 == r13) goto L78;
        float r28 = Float.NaN;
        float r111 = Float.NaN;
    L77:
        float r112 = r111;
        float r113 = r112;
    L82:
        int r29 = r10;
        int r114 = 3;
        r4.addChainElement(r26, r28, r110, r111, r112, r113);
    L84:
        int r30 = 0;
    L86:
        r17 = r17;
        r3 = r30;
        r9 = r9;
        r11 = r114;
        r10 = r29;
        r13 = 6;
        r18 = r18 + 1;
        goto L66
    L78:
        r28 = r20.getFloat(r9);
        float r115 = toPix(r22, r20.getFloat(r10));
        float r116 = toPix(r22, r20.getFloat(r11));
        float r117 = toPix(r22, r20.getFloat(4));
        r113 = toPix(r22, r20.getFloat(5));
        r112 = r117;
        r110 = r115;
        r111 = r116;
        r10 = 2;
        goto L82
    L79:
        r28 = r20.getFloat(r9);
        r10 = 2;
        r112 = Float.NaN;
        r113 = Float.NaN;
        r110 = toPix(r22, r20.getFloat(2));
        r111 = toPix(r22, r20.getFloat(3));
        goto L82
    L80:
        r28 = r20.getFloat(r9);
        r111 = toPix(r22, r20.getFloat(r10));
        r112 = Float.NaN;
        r113 = Float.NaN;
        r110 = r111;
        goto L82
    L81:
        r28 = r20.getFloat(r9);
        r111 = Float.NaN;
        goto L77
    L83:
        r29 = r10;
        r114 = r11;
        goto L84
    L85:
        r18 = r18;
        r17 = r17;
        r9 = r9;
        r29 = r10;
        r114 = r11;
        Object[] r31 = new Object[r9];
        r30 = 0;
        r31[0] = r19.content();
        r4.add(r31);
    L87:
        System.err.println(r23 + " contains should be an array \"" + r16.content() + "\"");
        return;
    L89:
        r8 = r3;
        parseConstraint(r22, r24, r25, r4, r5);
        goto L90
    L13:
        if (r5.equals("style") == false) goto L44;
        r7 = 7;
        goto L44
    L17:
        if (r5.equals("start") == false) goto L44;
        r7 = 6;
        goto L44
    L21:
        if (r5.equals("right") == false) goto L44;
        r7 = 5;
        goto L44
    L25:
        if (r5.equals("left") == false) goto L44;
        r7 = 4;
        goto L44
    L29:
        if (r5.equals("top") == false) goto L44;
        r7 = 3;
        goto L44
    L33:
        if (r5.equals(TraceStatsConsts.STATS_KEY_END) == false) goto L44;
        r7 = 2;
        goto L44
    L37:
        if (r5.equals("contains") == false) goto L44;
        r7 = 1;
        goto L44
    L41:
        if (r5.equals("bottom") == false) goto L44;
        r7 = r3;
        goto L44
    L91:
        return;
    L5:
        r4 = r22.verticalChain();
        goto L6
    }

    private static void parseGridType(String r9, State r10, String r11, LayoutVariables r12, CLObject r13) throws CLParsingException {
        GridReference r14 = r10.getGrid(r11, r9);
        Iterator<String> r0 = r13.names().iterator();
    L4:
        if (r0.hasNext() == false) goto L120;
        String r1 = r0.next();
        r1.hashCode();
        int r6 = 0;
        byte r7 = -1;
        switch(r1.hashCode()) {
            case -1439500848: goto L53;
            case -806339567: goto L49;
            case -567445985: goto L45;
            case 3169614: goto L41;
            case 3506649: goto L37;
            case 3586688: goto L33;
            case 97513095: goto L29;
            case 109497044: goto L25;
            case 109638249: goto L21;
            case 144441793: goto L17;
            case 949721053: goto L13;
            case 2033353925: goto L9;
            default: goto L57;
        };
    L9:
        if (r1.equals("columnWeights") == false) goto L57;
        r7 = 11;
        goto L57
    L13:
        if (r1.equals("columns") == false) goto L57;
        r7 = 10;
        goto L57
    L17:
        if (r1.equals("rowWeights") == false) goto L57;
        r7 = 9;
        goto L57
    L21:
        if (r1.equals(TraceStatsConsts.STATS_KEY_SPANS) == false) goto L57;
        r7 = 8;
        goto L57
    L25:
        if (r1.equals("skips") == false) goto L57;
        r7 = 7;
        goto L57
    L29:
        if (r1.equals(BaseIconCache.IconDB.COLUMN_FLAGS) == false) goto L57;
        r7 = 6;
        goto L57
    L33:
        if (r1.equals("vGap") == false) goto L57;
        r7 = 5;
        goto L57
    L37:
        if (r1.equals("rows") == false) goto L57;
        r7 = 4;
        goto L57
    L41:
        if (r1.equals("hGap") == false) goto L57;
        r7 = 3;
        goto L57
    L45:
        if (r1.equals("contains") == false) goto L57;
        r7 = 2;
        goto L57
    L49:
        if (r1.equals("padding") == false) goto L57;
        r7 = 1;
        goto L57
    L53:
        if (r1.equals("orientation") == false) goto L57;
        r7 = 0;
    L57:
        switch(r7) {
            case 0: goto L119;
            case 1: goto L106;
            case 2: goto L100;
            case 3: goto L99;
            case 4: goto L96;
            case 5: goto L95;
            case 6: goto L82;
            case 7: goto L77;
            case 8: goto L72;
            case 9: goto L67;
            case 10: goto L64;
            case 11: goto L59;
            default: goto L58;
        };
    L59:
        String r2 = r13.get(r1).content();
        if (r2 == null) goto L4;
        if (r2.contains(",") == false) goto L4;
        r14.setColumnWeights(r2);
        goto L4
    L64:
        int r3 = r13.get(r1).getInt();
        if (r3 <= 0) goto L4;
        r14.setColumnsSet(r3);
        goto L4
    L67:
        String r4 = r13.get(r1).content();
        if (r4 == null) goto L4;
        if (r4.contains(",") == false) goto L4;
        r14.setRowWeights(r4);
        goto L4
    L72:
        String r5 = r13.get(r1).content();
        if (r5 == null) goto L4;
        if (r5.contains(":") == false) goto L4;
        r14.setSpans(r5);
        goto L4
    L77:
        String r8 = r13.get(r1).content();
        if (r8 == null) goto L4;
        if (r8.contains(":") == false) goto L4;
        r14.setSkips(r8);
        goto L4
    L82:
        String r15 = "";
        CLElement r16 = r13.get(r1);     // Catch: Exception -> L88
        if ((r16 instanceof CLNumber) == false) goto L86;
        r6 = r16.getInt();     // Catch: Exception -> L88
    L90:
        if (r15 == null) goto L94;
        if (r15.isEmpty() == true) goto L94;
        r14.setFlags(r15);
    L94:
        r14.setFlags(r6);
        goto L4
    L86:
        r15 = r16.content();     // Catch: Exception -> L88
    L88:
        e = move-exception;
        System.err.println("Error parsing grid flags " + e);
        goto L90
    L95:
        r14.setVerticalGaps(toPix(r10, r13.get(r1).getFloat()));
        goto L4
    L96:
        int r17 = r13.get(r1).getInt();
        if (r17 <= 0) goto L4;
        r14.setRowsSet(r17);
        goto L4
    L99:
        r14.setHorizontalGaps(toPix(r10, r13.get(r1).getFloat()));
        goto L4
    L100:
        CLArray r18 = r13.getArrayOrNull(r1);
        if (r18 == null) goto L4;
        int r19 = 0;
    L104:
        if (r19 >= r18.size()) goto L4;
        r14.add(new Object[]{r10.constraints(r18.get(r19).content())});
        r19 = r19 + 1;
        goto L104
    L106:
        CLElement r20 = r13.get(r1);
        if ((r20 instanceof CLArray) == false) goto L117;
        CLArray r21 = (CLArray) r20;
        if (r21.size() <= 1) goto L117;
        float r22 = r21.getInt(0);
        float r23 = r21.getInt(1);
        if (r21.size() <= 2) goto L116;
        float r24 = r21.getInt(2);
        float r25 = ((CLArray) r20).getInt(3);     // Catch: ArrayIndexOutOfBoundsException -> L115
    L118:
        r14.setPaddingStart(Math.round(toPix(r10, r22)));
        r14.setPaddingTop(Math.round(toPix(r10, r23)));
        r14.setPaddingEnd(Math.round(toPix(r10, r24)));
        r14.setPaddingBottom(Math.round(toPix(r10, r25)));
    L115:
        r25 = 0.0f;
        goto L118
    L116:
        r25 = r23;
        r24 = r22;
    L117:
        r22 = r20.getInt();
        r25 = r22;
        r24 = r25;
        r23 = r24;
        goto L118
    L119:
        r14.setOrientation(r13.get(r1).getInt());
        goto L4
    L58:
        applyAttribute(r10, r12, r10.constraints(r11), r13, r1);
        goto L4
    }

    private static void parseFlowType(String r17, State r18, String r19, LayoutVariables r20, CLObject r21) throws CLParsingException {
        if (r17.charAt(0) != 'v') goto L5;
        boolean r4 = true;
    L6:
        FlowReference r5 = r18.getFlow(r19, r4);
        Iterator<String> r6 = r21.names().iterator();
    L8:
        if (r6.hasNext() == false) goto L207;
        String r7 = r6.next();
        r7.hashCode();
        int r9 = 4;
        byte r10 = -1;
        switch(r7.hashCode()) {
            case -1254185091: goto L61;
            case -1237307863: goto L57;
            case -1198076529: goto L53;
            case -853376977: goto L49;
            case -836499749: goto L45;
            case -806339567: goto L41;
            case -732635235: goto L37;
            case -567445985: goto L33;
            case -488900360: goto L29;
            case 3169614: goto L25;
            case 3575610: goto L21;
            case 3586688: goto L17;
            case 3657802: goto L13;
            default: goto L11;
        };
    L11:
        byte r8 = -1;
    L65:
        switch(r8) {
            case 0: goto L200;
            case 1: goto L182;
            case 2: goto L167;
            case 3: goto L147;
            case 4: goto L129;
            case 5: goto L116;
            case 6: goto L101;
            case 7: goto L75;
            case 8: goto L74;
            case 9: goto L73;
            case 10: goto L70;
            case 11: goto L68;
            case 12: goto L67;
            default: goto L66;
        };
    L67:
        r5.setWrapMode(State.Wrap.getValueByString(r21.get(r7).content()));
        goto L8
    L68:
        r5.setVerticalGap(r21.get(r7).getInt());
        goto L8
    L70:
        if (r21.get(r7).content().equals("hFlow") == true) goto L71;
        r5.setOrientation(1);
        goto L8
    L71:
        r5.setOrientation(0);
        goto L8
    L73:
        r5.setHorizontalGap(r21.get(r7).getInt());
        goto L8
    L74:
        r5.setMaxElementsWrap(r21.get(r7).getInt());
        goto L8
    L75:
        CLElement r11 = r21.get(r7);
        if ((r11 instanceof CLArray) == false) goto L99;
        CLArray r12 = (CLArray) r11;
        if (r12.size() < 1) goto L99;
        int r13 = 0;
    L82:
        if (r13 >= r12.size()) goto L8;
        CLElement r14 = r12.get(r13);
        if ((r14 instanceof CLArray) == false) goto L97;
        CLArray r15 = (CLArray) r14;
        if (r15.size() <= 0) goto L98;
        String r16 = r15.get(0).content();
        int r110 = r15.size();
        if (r110 == 2) goto L95;
        if (r110 == 3) goto L93;
        if (r110 == r9) goto L92;
        float r22 = Float.NaN;
        float r111 = Float.NaN;
        float r112 = Float.NaN;
    L96:
        r5.addFlowElement(r16, r111, r112, r22);
        goto L98
    L92:
        float r113 = r15.getFloat(1);
        r112 = toPix(r18, r15.getFloat(2));
        r22 = toPix(r18, r15.getFloat(3));
    L94:
        r111 = r113;
        goto L96
    L93:
        r113 = r15.getFloat(1);
        r22 = toPix(r18, r15.getFloat(2));
        r112 = r22;
        goto L94
    L95:
        r111 = r15.getFloat(1);
        r22 = Float.NaN;
        r112 = Float.NaN;
    L98:
        r13 = r13 + 1;
        r9 = 4;
        goto L82
    L97:
        r5.add(new Object[]{r14.content()});
    L99:
        System.err.println(r19 + " contains should be an array \"" + r11.content() + "\"");
        return;
    L101:
        CLElement r23 = r21.get(r7);
        Float.valueOf(0.5f);
        Float r24 = Float.valueOf(0.5f);
        Float r25 = Float.valueOf(0.5f);
        if ((r23 instanceof CLArray) == false) goto L108;
        CLArray r114 = (CLArray) r23;
        if (r114.size() <= 1) goto L108;
        r24 = Float.valueOf(r114.getFloat(0));
        Float r26 = Float.valueOf(r114.getFloat(1));
        if (r114.size() <= 2) goto L209;
        r25 = Float.valueOf(r114.getFloat(2));
    L209:
        r5.verticalBias(r26.floatValue());     // Catch: NumberFormatException -> L208
        if (r24.floatValue() == 0.5f) goto L113;
        r5.setFirstVerticalBias(r24.floatValue());     // Catch: NumberFormatException -> L208
    L113:
        if (r25.floatValue() == 0.5f) goto L8;
        r5.setLastVerticalBias(r25.floatValue());     // Catch: NumberFormatException -> L208
    L108:
        r26 = Float.valueOf(r23.getFloat());
        goto L209
    L116:
        CLElement r27 = r21.get(r7);
        if ((r27 instanceof CLArray) == false) goto L127;
        CLArray r28 = (CLArray) r27;
        if (r28.size() <= 1) goto L127;
        float r29 = r28.getInt(0);
        float r115 = r28.getInt(1);
        if (r28.size() <= 2) goto L126;
        float r30 = r28.getInt(2);
        float r31 = ((CLArray) r27).getInt(3);     // Catch: ArrayIndexOutOfBoundsException -> L125
    L128:
        r5.setPaddingLeft(Math.round(toPix(r18, r29)));
        r5.setPaddingTop(Math.round(toPix(r18, r115)));
        r5.setPaddingRight(Math.round(toPix(r18, r30)));
        r5.setPaddingBottom(Math.round(toPix(r18, r31)));
    L125:
        r31 = 0.0f;
        goto L128
    L126:
        r30 = r29;
        r31 = r115;
    L127:
        r29 = r27.getInt();
        r31 = r29;
        r30 = r31;
        r115 = r30;
        goto L128
    L129:
        CLElement r32 = r21.get(r7);
        if ((r32 instanceof CLArray) == false) goto L137;
        CLArray r33 = (CLArray) r32;
        if (r33.size() <= 1) goto L137;
        String r34 = r33.getString(0);
        String r35 = r33.getString(1);
        if (r33.size() <= 2) goto L136;
        String r36 = r33.getString(2);
    L139:
        if (r35.equals("") == true) goto L142;
        r5.setVerticalStyle(State.Chain.getValueByString(r35));
    L142:
        if (r34.equals("") == true) goto L145;
        r5.setFirstVerticalStyle(State.Chain.getValueByString(r34));
    L145:
        if (r36.equals("") == true) goto L8;
        r5.setLastVerticalStyle(State.Chain.getValueByString(r36));
        goto L8
    L136:
        r36 = "";
    L137:
        r35 = r32.content();
        r34 = "";
        r36 = r34;
        goto L139
    L147:
        String r37 = r21.get(r7).content();
        r37.hashCode();
        switch(r37.hashCode()) {
            case -1720785339: goto L159;
            case -1383228885: goto L155;
            case 115029: goto L151;
            default: goto L162;
        };
    L162:
        switch(r10) {
            case 0: goto L166;
            case 1: goto L165;
            case 2: goto L164;
            default: goto L163;
        };
    L164:
        r5.setVerticalAlign(0);
        goto L8
    L165:
        r5.setVerticalAlign(1);
        goto L8
    L166:
        r5.setVerticalAlign(3);
        goto L8
    L163:
        r5.setVerticalAlign(2);
        goto L8
    L151:
        if (r37.equals("top") == false) goto L162;
        r10 = 2;
        goto L162
    L155:
        if (r37.equals("bottom") == false) goto L162;
        r10 = 1;
        goto L162
    L159:
        if (r37.equals("baseline") == false) goto L162;
        r10 = 0;
        goto L162
    L167:
        CLElement r38 = r21.get(r7);
        Float.valueOf(0.5f);
        Float r39 = Float.valueOf(0.5f);
        Float r40 = Float.valueOf(0.5f);
        if ((r38 instanceof CLArray) == false) goto L174;
        CLArray r116 = (CLArray) r38;
        if (r116.size() <= 1) goto L174;
        r39 = Float.valueOf(r116.getFloat(0));
        Float r41 = Float.valueOf(r116.getFloat(1));
        if (r116.size() <= 2) goto L175;
        r40 = Float.valueOf(r116.getFloat(2));
    L175:
        r5.horizontalBias(r41.floatValue());     // Catch: NumberFormatException -> L208
        if (r39.floatValue() == 0.5f) goto L179;
        r5.setFirstHorizontalBias(r39.floatValue());     // Catch: NumberFormatException -> L208
    L179:
        if (r40.floatValue() == 0.5f) goto L8;
        r5.setLastHorizontalBias(r40.floatValue());     // Catch: NumberFormatException -> L208
    L174:
        r41 = Float.valueOf(r38.getFloat());
        goto L175
    L182:
        CLElement r42 = r21.get(r7);
        if ((r42 instanceof CLArray) == false) goto L190;
        CLArray r43 = (CLArray) r42;
        if (r43.size() <= 1) goto L190;
        String r44 = r43.getString(0);
        String r45 = r43.getString(1);
        if (r43.size() <= 2) goto L189;
        String r46 = r43.getString(2);
    L192:
        if (r45.equals("") == true) goto L195;
        r5.setHorizontalStyle(State.Chain.getValueByString(r45));
    L195:
        if (r44.equals("") == true) goto L198;
        r5.setFirstHorizontalStyle(State.Chain.getValueByString(r44));
    L198:
        if (r46.equals("") == true) goto L8;
        r5.setLastHorizontalStyle(State.Chain.getValueByString(r46));
        goto L8
    L189:
        r46 = "";
    L190:
        r45 = r42.content();
        r44 = "";
        r46 = r44;
        goto L192
    L200:
        String r47 = r21.get(r7).content();
        r47.hashCode();
        if (r47.equals(TraceStatsConsts.STATS_KEY_END) == false) goto L203;
        r5.setHorizontalAlign(1);
        goto L8
    L203:
        if (r47.equals("start") == false) goto L204;
        r5.setHorizontalAlign(0);
        goto L8
    L204:
        r5.setHorizontalAlign(2);
        goto L8
    L66:
        applyAttribute(r18, r20, r18.constraints(r19), r21, r7);
        goto L8
    L13:
        if (r7.equals("wrap") == false) goto L273;
        r8 = 12;
        goto L65
    L273:
        r8 = -1;
        goto L65
    L17:
        if (r7.equals("vGap") == false) goto L274;
        r8 = 11;
        goto L65
    L274:
        r8 = -1;
        goto L65
    L21:
        if (r7.equals("type") == false) goto L275;
        r8 = 10;
        goto L65
    L275:
        r8 = -1;
        goto L65
    L25:
        if (r7.equals("hGap") == false) goto L276;
        r8 = 9;
        goto L65
    L276:
        r8 = -1;
        goto L65
    L29:
        if (r7.equals("maxElement") == false) goto L277;
        r8 = 8;
        goto L65
    L277:
        r8 = -1;
        goto L65
    L33:
        if (r7.equals("contains") == false) goto L278;
        r8 = 7;
        goto L65
    L278:
        r8 = -1;
        goto L65
    L37:
        if (r7.equals("vFlowBias") == false) goto L279;
        r8 = 6;
        goto L65
    L279:
        r8 = -1;
        goto L65
    L41:
        if (r7.equals("padding") == false) goto L280;
        r8 = 5;
        goto L65
    L280:
        r8 = -1;
        goto L65
    L45:
        if (r7.equals("vStyle") == false) goto L281;
        r8 = 4;
        goto L65
    L281:
        r8 = -1;
        goto L65
    L49:
        if (r7.equals("vAlign") == false) goto L282;
        r8 = 3;
        goto L65
    L282:
        r8 = -1;
        goto L65
    L53:
        if (r7.equals("hFlowBias") == false) goto L283;
        r8 = 2;
        goto L65
    L283:
        r8 = -1;
        goto L65
    L57:
        if (r7.equals("hStyle") == false) goto L284;
        r8 = 1;
        goto L65
    L284:
        r8 = -1;
        goto L65
    L61:
        if (r7.equals("hAlign") == false) goto L285;
        r8 = 0;
        goto L65
    L285:
        r8 = -1;
        goto L65
    L207:
        return;
    L5:
        r4 = false;
        goto L6
    }

    static void parseGuideline(int r1, State r2, CLArray r3) throws CLParsingException {
        CLElement r4 = r3.get(1);
        if ((r4 instanceof CLObject) == true) goto L5;
        return;
    L5:
        CLObject r5 = (CLObject) r4;
        String r0 = r5.getStringOrNull("id");
        if (r0 != null) goto L8;
        return;
    L8:
        parseGuidelineParams(r1, r2, r0, r5);
    }

    static void parseGuidelineParams(int r17, State r18, String r19, CLObject r20) throws CLParsingException {
        ArrayList<String> r2 = r20.names();
        if (r2 != null) goto L5;
        return;
    L5:
        ConstraintReference r3 = r18.constraints(r19);
        if (r17 != 0) goto L8;
        r18.horizontalGuideline(r19);
    L10:
        if (r18.isRtl() == false) goto L14;
        if (r17 == 0) goto L14;
        boolean r4 = false;
    L15:
        GuidelineReference r5 = (GuidelineReference) r3.getFacade();
        Iterator<String> r6 = r2.iterator();
        float r7 = 0.0f;
        boolean r8 = false;
    L16:
        boolean r9 = true;
    L18:
        if (r6.hasNext() == false) goto L79;
        String r10 = r6.next();
        r10.hashCode();
        switch(r10.hashCode()) {
            case -678927291: goto L39;
            case 100571: goto L35;
            case 3317767: goto L31;
            case 108511772: goto L27;
            case 109757538: goto L23;
            default: goto L21;
        };
    L21:
        byte r11 = -1;
    L42:
        switch(r11) {
            case 0: goto L48;
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            default: goto L18;
        };
    L44:
        r7 = toPix(r18, r20.getFloat(r10));
        r9 = r4;
        goto L18
    L45:
        r7 = toPix(r18, r20.getFloat(r10));
        r9 = false;
        goto L18
    L46:
        r7 = toPix(r18, r20.getFloat(r10));
        goto L16
    L47:
        r7 = toPix(r18, r20.getFloat(r10));
        r9 = !r4;
        goto L18
    L48:
        CLArray r12 = r20.getArrayOrNull(r10);
        if (r12 == null) goto L50;
        if (r12.size() <= 1) goto L78;
        String r13 = r12.getString(0);
        float r14 = r12.getFloat(1);
        r13.hashCode();
        switch(r13.hashCode()) {
            case 100571: goto L69;
            case 3317767: goto L65;
            case 108511772: goto L61;
            case 109757538: goto L57;
            default: goto L55;
        };
    L55:
        byte r15 = -1;
    L72:
        switch(r15) {
            case 0: goto L77;
            case 1: goto L76;
            case 2: goto L75;
            case 3: goto L74;
            default: goto L73;
        };
    L73:
        r7 = r14;
        goto L78
    L74:
        r9 = r4;
        goto L73
    L75:
        r9 = false;
        goto L73
    L77:
        r9 = !r4;
        goto L73
    L76:
        r9 = true;
        r7 = r14;
        r8 = true;
        goto L18
    L57:
        if (r13.equals("start") == false) goto L114;
        r15 = 3;
        goto L72
    L114:
        r15 = -1;
        goto L72
    L61:
        if (r13.equals("right") == false) goto L115;
        r15 = 2;
        goto L72
    L115:
        r15 = -1;
        goto L72
    L65:
        if (r13.equals("left") == false) goto L116;
        r15 = 1;
        goto L72
    L116:
        r15 = -1;
        goto L72
    L69:
        if (r13.equals(TraceStatsConsts.STATS_KEY_END) == false) goto L117;
        r15 = 0;
        goto L72
    L117:
        r15 = -1;
    L78:
        r8 = true;
        goto L18
    L50:
        r7 = r20.getFloat(r10);
        r8 = true;
        r9 = true;
        goto L18
    L23:
        if (r10.equals("start") == false) goto L109;
        r11 = 4;
        goto L42
    L109:
        r11 = -1;
        goto L42
    L27:
        if (r10.equals("right") == false) goto L110;
        r11 = 3;
        goto L42
    L110:
        r11 = -1;
        goto L42
    L31:
        if (r10.equals("left") == false) goto L111;
        r11 = 2;
        goto L42
    L111:
        r11 = -1;
        goto L42
    L35:
        if (r10.equals(TraceStatsConsts.STATS_KEY_END) == false) goto L112;
        r11 = 1;
        goto L42
    L112:
        r11 = -1;
        goto L42
    L39:
        if (r10.equals(PowerUsageDetail.EXTRA_PERCENT) == false) goto L113;
        r11 = 0;
        goto L42
    L113:
        r11 = -1;
        goto L42
    L79:
        if (r8 == false) goto L83;
        if (r9 == false) goto L82;
        r5.percent(r7);
        return;
    L82:
        r5.percent(1.0f - r7);
        return;
    L83:
        if (r9 == false) goto L85;
        r5.start(Float.valueOf(r7));
        return;
    L85:
        r5.end(Float.valueOf(r7));
        return;
    L14:
        r4 = true;
        goto L15
    L8:
        r18.verticalGuideline(r19);
        goto L10
    }

    static void parseBarrier(State r8, String r9, CLObject r10) throws CLParsingException {
        boolean r0 = !r8.isRtl();
        BarrierReference r11 = r8.barrier(r9, State.Direction.END);
        ArrayList<String> r2 = r10.names();
        if (r2 != null) goto L5;
        return;
    L5:
        Iterator<String> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L72;
        String r4 = r3.next();
        r4.hashCode();
        byte r5 = 2;
        switch(r4.hashCode()) {
            case -1081309778: goto L20;
            case -962590849: goto L16;
            case -567445985: goto L12;
            default: goto L10;
        };
    L10:
        byte r6 = -1;
    L23:
        switch(r6) {
            case 0: goto L69;
            case 1: goto L31;
            case 2: goto L25;
            default: goto L7;
        };
    L25:
        CLArray r7 = r10.getArrayOrNull(r4);
        if (r7 == null) goto L7;
        int r12 = 0;
    L29:
        if (r12 >= r7.size()) goto L7;
        r11.add(new Object[]{r8.constraints(r7.get(r12).content())});
        r12 = r12 + 1;
        goto L29
    L31:
        String r13 = r10.getString(r4);
        r13.hashCode();
        switch(r13.hashCode()) {
            case -1383228885: goto L54;
            case 100571: goto L50;
            case 115029: goto L47;
            case 3317767: goto L43;
            case 108511772: goto L39;
            case 109757538: goto L35;
            default: goto L33;
        };
    L33:
        r5 = -1;
    L57:
        switch(r5) {
            case 0: goto L68;
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L59;
            default: goto L7;
        };
    L59:
        if (r0 == true) goto L60;
        r11.setBarrierDirection(State.Direction.RIGHT);
        goto L7
    L60:
        r11.setBarrierDirection(State.Direction.LEFT);
        goto L7
    L62:
        r11.setBarrierDirection(State.Direction.RIGHT);
        goto L7
    L63:
        r11.setBarrierDirection(State.Direction.LEFT);
        goto L7
    L64:
        r11.setBarrierDirection(State.Direction.TOP);
        goto L7
    L65:
        if (r0 == true) goto L66;
        r11.setBarrierDirection(State.Direction.LEFT);
        goto L7
    L66:
        r11.setBarrierDirection(State.Direction.RIGHT);
        goto L7
    L68:
        r11.setBarrierDirection(State.Direction.BOTTOM);
        goto L7
    L35:
        if (r13.equals("start") == false) goto L107;
        r5 = 5;
        goto L57
    L107:
        r5 = -1;
        goto L57
    L39:
        if (r13.equals("right") == false) goto L108;
        r5 = 4;
        goto L57
    L108:
        r5 = -1;
        goto L57
    L43:
        if (r13.equals("left") == false) goto L109;
        r5 = 3;
        goto L57
    L109:
        r5 = -1;
        goto L57
    L47:
        if (r13.equals("top") == true) goto L57;
        r5 = -1;
        goto L57
    L50:
        if (r13.equals(TraceStatsConsts.STATS_KEY_END) == false) goto L111;
        r5 = 1;
        goto L57
    L111:
        r5 = -1;
        goto L57
    L54:
        if (r13.equals("bottom") == false) goto L112;
        r5 = 0;
        goto L57
    L112:
        r5 = -1;
        goto L57
    L69:
        float r14 = r10.getFloatOrNaN(r4);
        if (Float.isNaN(r14) == true) goto L7;
        r11.margin(Float.valueOf(toPix(r8, r14)));
        goto L7
    L12:
        if (r4.equals("contains") == false) goto L104;
        r6 = 2;
        goto L23
    L104:
        r6 = -1;
        goto L23
    L16:
        if (r4.equals(MaterialConfigFormatNames.DIRECTION) == false) goto L105;
        r6 = 1;
        goto L23
    L105:
        r6 = -1;
        goto L23
    L20:
        if (r4.equals("margin") == false) goto L106;
        r6 = 0;
        goto L23
    L106:
        r6 = -1;
        goto L23
    }

    static void parseWidget(State r0, LayoutVariables r1, String r2, CLObject r3) throws CLParsingException {
        parseWidget(r0, r1, r0.constraints(r2), r3);
    }

    static void applyAttribute(State r8, LayoutVariables r9, ConstraintReference r10, CLObject r11, String r12) throws CLParsingException {
        r12.hashCode();
        byte r3 = 2;
        switch(r12.hashCode()) {
            case -1448775240: goto L98;
            case -1364013995: goto L94;
            case -1349088399: goto L90;
            case -1249320806: goto L86;
            case -1249320805: goto L82;
            case -1249320804: goto L78;
            case -1225497657: goto L74;
            case -1225497656: goto L70;
            case -1225497655: goto L66;
            case -1221029593: goto L62;
            case -1068318794: goto L58;
            case -987906986: goto L54;
            case -987906985: goto L50;
            case -908189618: goto L46;
            case -908189617: goto L42;
            case -247669061: goto L38;
            case -61505906: goto L34;
            case 92909918: goto L30;
            case 98116417: goto L26;
            case 111045711: goto L22;
            case 113126854: goto L18;
            case 398344448: goto L14;
            case 1404070310: goto L10;
            case 1941332754: goto L6;
            default: goto L4;
        };
    L4:
        byte r0 = -1;
    L102:
        switch(r0) {
            case 0: goto L155;
            case 1: goto L150;
            case 2: goto L149;
            case 3: goto L148;
            case 4: goto L147;
            case 5: goto L146;
            case 6: goto L145;
            case 7: goto L144;
            case 8: goto L143;
            case 9: goto L142;
            case 10: goto L141;
            case 11: goto L140;
            case 12: goto L139;
            case 13: goto L138;
            case 14: goto L137;
            case 15: goto L133;
            case 16: goto L132;
            case 17: goto L131;
            case 18: goto L130;
            case 19: goto L129;
            case 20: goto L128;
            case 21: goto L127;
            case 22: goto L123;
            case 23: goto L104;
            default: goto L103;
        };
    L103:
        parseConstraint(r8, r9, r11, r10, r12);
        return;
    L104:
        String r13 = r11.getString(r12);
        r13.hashCode();
        switch(r13.hashCode()) {
            case -1901805651: goto L115;
            case 3178655: goto L111;
            case 466743410: goto L108;
            default: goto L106;
        };
    L106:
        r3 = -1;
    L118:
        switch(r3) {
            case 0: goto L122;
            case 1: goto L121;
            case 2: goto L120;
            default: goto L213;
        };
    L120:
        r10.visibility(0);
        return;
    L121:
        r10.visibility(8);
        return;
    L122:
        r10.visibility(4);
        r10.alpha(0.0f);
        return;
    L213:
        return;
    L108:
        if (r13.equals("visible") == true) goto L118;
        r3 = -1;
        goto L118
    L111:
        if (r13.equals("gone") == false) goto L185;
        r3 = 1;
        goto L118
    L185:
        r3 = -1;
        goto L118
    L115:
        if (r13.equals("invisible") == false) goto L186;
        r3 = 0;
        goto L118
    L186:
        r3 = -1;
        goto L118
    L123:
        String r14 = r11.getString(r12);
        boolean r15 = r14.equals("parent");
        Object r16 = r14;
        if (r15 == false) goto L126;
        r16 = State.PARENT;
    L126:
        ConstraintReference r17 = r8.constraints(r16);
        r10.startToStart(r17);
        r10.endToEnd(r17);
        return;
    L127:
        r10.setHorizontalChainWeight(r9.get(r11.get(r12)));
        return;
    L128:
        r10.setWidth(parseDimension(r11, r12, r8, r8.getDpToPixel()));
        return;
    L129:
        r10.verticalBias(r9.get(r11.get(r12)));
        return;
    L130:
        r10.horizontalBias(r9.get(r11.get(r12)));
        return;
    L131:
        r10.alpha(r9.get(r11.get(r12)));
        return;
    L132:
        r10.setVerticalChainWeight(r9.get(r11.get(r12)));
        return;
    L133:
        float r18 = r9.get(r11.get(r12));
        if (r8.isRtl() == false) goto L136;
        r18 = 1.0f - r18;
    L136:
        r10.horizontalBias(r18);
        return;
    L137:
        r10.scaleY(r9.get(r11.get(r12)));
        return;
    L138:
        r10.scaleX(r9.get(r11.get(r12)));
        return;
    L139:
        r10.pivotY(r9.get(r11.get(r12)));
        return;
    L140:
        r10.pivotX(r9.get(r11.get(r12)));
        return;
    L141:
        parseMotionProperties(r11.get(r12), r10);
        return;
    L142:
        r10.setHeight(parseDimension(r11, r12, r8, r8.getDpToPixel()));
        return;
    L143:
        r10.translationZ(toPix(r8, r9.get(r11.get(r12))));
        return;
    L144:
        r10.translationY(toPix(r8, r9.get(r11.get(r12))));
        return;
    L145:
        r10.translationX(toPix(r8, r9.get(r11.get(r12))));
        return;
    L146:
        r10.rotationZ(r9.get(r11.get(r12)));
        return;
    L147:
        r10.rotationY(r9.get(r11.get(r12)));
        return;
    L148:
        r10.rotationX(r9.get(r11.get(r12)));
        return;
    L149:
        parseCustomProperties(r11, r10, r12);
        return;
    L150:
        String r19 = r11.getString(r12);
        if (r19.equals("parent") == false) goto L153;
        ConstraintReference r20 = r8.constraints(State.PARENT);
    L154:
        r10.startToStart(r20);
        r10.endToEnd(r20);
        r10.topToTop(r20);
        r10.bottomToBottom(r20);
        return;
    L153:
        r20 = r8.constraints(r19);
        goto L154
    L155:
        String r21 = r11.getString(r12);
        boolean r110 = r21.equals("parent");
        Object r22 = r21;
        if (r110 == false) goto L158;
        r22 = State.PARENT;
    L158:
        ConstraintReference r23 = r8.constraints(r22);
        r10.topToTop(r23);
        r10.bottomToBottom(r23);
        return;
    L6:
        if (r12.equals("visibility") == false) goto L160;
        r0 = 23;
        goto L102
    L160:
        r0 = -1;
        goto L102
    L10:
        if (r12.equals("centerHorizontally") == false) goto L161;
        r0 = 22;
        goto L102
    L161:
        r0 = -1;
        goto L102
    L14:
        if (r12.equals("hWeight") == false) goto L162;
        r0 = 21;
        goto L102
    L162:
        r0 = -1;
        goto L102
    L18:
        if (r12.equals(MaterialConfigFormatNames.WIDTH) == false) goto L163;
        r0 = 20;
        goto L102
    L163:
        r0 = -1;
        goto L102
    L22:
        if (r12.equals("vBias") == false) goto L164;
        r0 = 19;
        goto L102
    L164:
        r0 = -1;
        goto L102
    L26:
        if (r12.equals("hBias") == false) goto L165;
        r0 = 18;
        goto L102
    L165:
        r0 = -1;
        goto L102
    L30:
        if (r12.equals("alpha") == false) goto L166;
        r0 = 17;
        goto L102
    L166:
        r0 = -1;
        goto L102
    L34:
        if (r12.equals("vWeight") == false) goto L167;
        r0 = 16;
        goto L102
    L167:
        r0 = -1;
        goto L102
    L38:
        if (r12.equals("hRtlBias") == false) goto L168;
        r0 = 15;
        goto L102
    L168:
        r0 = -1;
        goto L102
    L42:
        if (r12.equals("scaleY") == false) goto L169;
        r0 = 14;
        goto L102
    L169:
        r0 = -1;
        goto L102
    L46:
        if (r12.equals("scaleX") == false) goto L170;
        r0 = 13;
        goto L102
    L170:
        r0 = -1;
        goto L102
    L50:
        if (r12.equals("pivotY") == false) goto L171;
        r0 = 12;
        goto L102
    L171:
        r0 = -1;
        goto L102
    L54:
        if (r12.equals("pivotX") == false) goto L172;
        r0 = 11;
        goto L102
    L172:
        r0 = -1;
        goto L102
    L58:
        if (r12.equals("motion") == false) goto L173;
        r0 = 10;
        goto L102
    L173:
        r0 = -1;
        goto L102
    L62:
        if (r12.equals(MonthWeekEventsView.VIEW_PARAMS_HEIGHT) == false) goto L174;
        r0 = 9;
        goto L102
    L174:
        r0 = -1;
        goto L102
    L66:
        if (r12.equals("translationZ") == false) goto L175;
        r0 = 8;
        goto L102
    L175:
        r0 = -1;
        goto L102
    L70:
        if (r12.equals("translationY") == false) goto L176;
        r0 = 7;
        goto L102
    L176:
        r0 = -1;
        goto L102
    L74:
        if (r12.equals("translationX") == false) goto L177;
        r0 = 6;
        goto L102
    L177:
        r0 = -1;
        goto L102
    L78:
        if (r12.equals("rotationZ") == false) goto L178;
        r0 = 5;
        goto L102
    L178:
        r0 = -1;
        goto L102
    L82:
        if (r12.equals("rotationY") == false) goto L179;
        r0 = 4;
        goto L102
    L179:
        r0 = -1;
        goto L102
    L86:
        if (r12.equals("rotationX") == false) goto L180;
        r0 = 3;
        goto L102
    L180:
        r0 = -1;
        goto L102
    L90:
        if (r12.equals("custom") == false) goto L181;
        r0 = 2;
        goto L102
    L181:
        r0 = -1;
        goto L102
    L94:
        if (r12.equals("center") == false) goto L182;
        r0 = 1;
        goto L102
    L182:
        r0 = -1;
        goto L102
    L98:
        if (r12.equals("centerVertically") == false) goto L183;
        r0 = 0;
        goto L102
    L183:
        r0 = -1;
        goto L102
    }

    static void parseWidget(State r2, LayoutVariables r3, ConstraintReference r4, CLObject r5) throws CLParsingException {
        if (r4.getWidth() != null) goto L6;
        r4.setWidth(Dimension.createWrap());
    L6:
        if (r4.getHeight() != null) goto L8;
        r4.setHeight(Dimension.createWrap());
    L8:
        ArrayList<String> r0 = r5.names();
        if (r0 != null) goto L11;
        return;
    L11:
        Iterator<String> r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        applyAttribute(r2, r3, r4, r5, r1.next());
        goto L13
    }

    static void parseCustomProperties(CLObject r5, ConstraintReference r6, String r7) throws CLParsingException {
        CLObject r8 = r5.getObjectOrNull(r7);
        if (r8 != null) goto L5;
        return;
    L5:
        ArrayList<String> r9 = r8.names();
        if (r9 != null) goto L8;
        return;
    L8:
        Iterator<String> r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L19;
        String r0 = r10.next();
        CLElement r1 = r8.get(r0);
        if ((r1 instanceof CLNumber) == true) goto L13;
        if ((r1 instanceof CLString) == false) goto L10;
        long r2 = parseColorString(r1.content());
        if (r2 == (-1)) goto L10;
        r6.addCustomColor(r0, (int) r2);
        goto L10
    L13:
        r6.addCustomFloat(r0, r1.getFloat());
        goto L10
    }

    private static int indexOf(String r2, String... r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L9;
        if (r3[r0].equals(r2) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private static void parseMotionProperties(CLElement r12, ConstraintReference r13) throws CLParsingException {
        if ((r12 instanceof CLObject) == true) goto L5;
        return;
    L5:
        CLObject r14 = (CLObject) r12;
        TypedBundle r0 = new TypedBundle();
        ArrayList<String> r1 = r14.names();
        if (r1 != null) goto L8;
        return;
    L8:
        Iterator<String> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L53;
        String r3 = r2.next();
        r3.hashCode();
        switch(r3.hashCode()) {
            case -1897525331: goto L31;
            case -1310311125: goto L27;
            case -1285003983: goto L23;
            case -791482387: goto L19;
            case -236944793: goto L15;
            default: goto L13;
        };
    L13:
        byte r4 = -1;
    L34:
        switch(r4) {
            case 0: goto L52;
            case 1: goto L51;
            case 2: goto L41;
            case 3: goto L37;
            case 4: goto L36;
            default: goto L10;
        };
    L36:
        r0.add(605, r14.getString(r3));
        goto L10
    L37:
        String r5 = r14.getString(r3);
        int r6 = indexOf(r5, new String[]{"none", "startVertical", "startHorizontal", "flip", "below", "above"});
        if (r6 == (-1)) goto L39;
        r0.add(607, r6);
        goto L10
    L39:
        System.err.println(r14.getLine() + " pathArc = '" + r5 + "'");
        goto L10
    L41:
        CLElement r7 = r14.get(r3);
        if ((r7 instanceof CLArray) == true) goto L43;
        r0.add(610, r14.getInt(r3));
        goto L10
    L43:
        CLArray r8 = (CLArray) r7;
        int r9 = r8.size();
        if (r9 <= 0) goto L10;
        r0.add(610, r8.getInt(0));
        if (r9 <= 1) goto L10;
        r0.add(611, r8.getString(1));
        if (r9 <= 2) goto L10;
        r0.add(602, r8.getFloat(2));
        goto L10
    L51:
        r0.add(603, r14.getString(r3));
        goto L10
    L52:
        r0.add(600, r14.getFloat(r3));
        goto L10
    L15:
        if (r3.equals("relativeTo") == false) goto L80;
        r4 = 4;
        goto L34
    L80:
        r4 = -1;
        goto L34
    L19:
        if (r3.equals("pathArc") == false) goto L81;
        r4 = 3;
        goto L34
    L81:
        r4 = -1;
        goto L34
    L23:
        if (r3.equals("quantize") == false) goto L82;
        r4 = 2;
        goto L34
    L82:
        r4 = -1;
        goto L34
    L27:
        if (r3.equals("easing") == false) goto L83;
        r4 = 1;
        goto L34
    L83:
        r4 = -1;
        goto L34
    L31:
        if (r3.equals("stagger") == false) goto L84;
        r4 = 0;
        goto L34
    L84:
        r4 = -1;
        goto L34
    L53:
        r13.mMotionProperties = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    static void parseConstraint(State r20, LayoutVariables r21, CLObject r22, ConstraintReference r23, String r24) throws CLParsingException {
        byte r6 = 1;
        boolean r5 = !r20.isRtl();
        CLArray r7 = r22.getArrayOrNull(r24);
        if (r7 != null) goto L5;
    L158:
        String r2 = r22.getStringOrNull(r24);
        if (r2 != null) goto L161;
        return;
    L161:
        if (r2.equals("parent") == false) goto L163;
        ConstraintReference r3 = r20.constraints(State.PARENT);
    L164:
        r24.hashCode();
        switch(r24.hashCode()) {
            case -1720785339: goto L183;
            case -1383228885: goto L180;
            case 100571: goto L176;
            case 115029: goto L172;
            case 109757538: goto L168;
            default: goto L166;
        };
    L166:
        r6 = -1;
    L186:
        switch(r6) {
            case 0: goto L196;
            case 1: goto L195;
            case 2: goto L192;
            case 3: goto L191;
            case 4: goto L188;
            default: goto L232;
        };
    L188:
        if (r5 == false) goto L190;
        r23.leftToLeft(r3);
        return;
    L190:
        r23.rightToRight(r3);
        return;
    L191:
        r23.topToTop(r3);
        return;
    L192:
        if (r5 == false) goto L194;
        r23.rightToRight(r3);
        return;
    L194:
        r23.leftToLeft(r3);
        return;
    L195:
        r23.bottomToBottom(r3);
        return;
    L196:
        r20.baselineNeededFor(r23.getKey());
        r20.baselineNeededFor(r3.getKey());
        r23.baselineToBaseline(r3);
        return;
    L232:
        return;
    L168:
        if (r24.equals("start") == false) goto L219;
        r6 = 4;
        goto L186
    L219:
        r6 = -1;
        goto L186
    L172:
        if (r24.equals("top") == false) goto L220;
        r6 = 3;
        goto L186
    L220:
        r6 = -1;
        goto L186
    L176:
        if (r24.equals(TraceStatsConsts.STATS_KEY_END) == false) goto L221;
        r6 = 2;
        goto L186
    L221:
        r6 = -1;
        goto L186
    L180:
        if (r24.equals("bottom") == true) goto L186;
        r6 = -1;
        goto L186
    L183:
        if (r24.equals("baseline") == false) goto L223;
        r6 = 0;
        goto L186
    L223:
        r6 = -1;
        goto L186
    L163:
        r3 = r20.constraints(r2);
        goto L164
    L5:
        if (r7.size() <= 1) goto L158;
        String r4 = r7.getString(0);
        String r8 = r7.getStringOrNull(1);
        float r17 = 0.0f;
        if (r7.size() <= 2) goto L9;
        float r9 = toPix(r20, r21.get(r7.getOrNull(2)));
    L10:
        float r25 = r9;
        if (r7.size() <= 3) goto L13;
        float r15 = toPix(r20, r21.get(r7.getOrNull(3)));
    L15:
        if (r4.equals("parent") == false) goto L17;
        ConstraintReference r10 = r20.constraints(State.PARENT);
    L18:
        r24.hashCode();
        float r19 = r15;
        switch(r24.hashCode()) {
            case -1720785339: goto L50;
            case -1498085729: goto L46;
            case -1383228885: goto L42;
            case 100571: goto L38;
            case 115029: goto L34;
            case 3317767: goto L30;
            case 108511772: goto L26;
            case 109757538: goto L22;
            default: goto L20;
        };
    L20:
        byte r11 = -1;
    L53:
        switch(r11) {
            case 0: goto L104;
            case 1: goto L100;
            case 2: goto L80;
            case 3: goto L79;
            case 4: goto L59;
            case 5: goto L57;
            case 6: goto L56;
            case 7: goto L55;
            default: goto L54;
        };
    L54:
        char r1 = 2;
        boolean r12 = true;
    L124:
        boolean r0 = r12;
        boolean r18 = false;
    L125:
        if (r18 == false) goto L157;
        r8.hashCode();
        switch(r8.hashCode()) {
            case 100571: goto L142;
            case 3317767: goto L138;
            case 108511772: goto L134;
            case 109757538: goto L130;
            default: goto L128;
        };
    L128:
        ?? r16 = -1;
    L145:
        switch(r16) {
            case 0: goto L149;
            case 1: goto L146;
            case 2: goto L148;
            case 3: goto L147;
            default: goto L146;
        };
    L146:
        boolean r13 = r12;
    L150:
        if (r0 == false) goto L154;
        if (r13 == false) goto L153;
        r23.leftToLeft(r10);
        goto L157
    L153:
        r23.leftToRight(r10);
        goto L157
    L154:
        if (r13 == false) goto L156;
        r23.rightToLeft(r10);
        goto L157
    L156:
        r23.rightToRight(r10);
        goto L157
    L147:
        r13 = r5;
        goto L150
    L148:
        r13 = false;
        goto L150
    L149:
        r13 = !r5;
        goto L150
    L130:
        if (r8.equals("start") == false) goto L206;
        r16 = 3;
        goto L145
    L206:
        r16 = -1;
        goto L145
    L134:
        if (r8.equals("right") == false) goto L207;
        r16 = r1;
        goto L145
    L207:
        r16 = -1;
        goto L145
    L138:
        if (r8.equals("left") == false) goto L208;
        r16 = r12;
        goto L145
    L208:
        r16 = -1;
        goto L145
    L142:
        if (r8.equals(TraceStatsConsts.STATS_KEY_END) == false) goto L209;
        r16 = 0;
        goto L145
    L209:
        r16 = -1;
    L157:
        r23.margin(Float.valueOf(r25)).marginGone(Float.valueOf(r19));
        return;
    L55:
        r0 = r5;
    L58:
        r1 = 2;
        r12 = true;
        r18 = true;
        goto L125
    L56:
        r0 = false;
        goto L58
    L57:
        r0 = true;
        goto L58
    L59:
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1720785339: goto L71;
            case -1383228885: goto L67;
            case 115029: goto L63;
            default: goto L61;
        };
    L61:
        byte r14 = -1;
    L74:
        switch(r14) {
            case 0: goto L78;
            case 1: goto L77;
            case 2: goto L76;
            default: goto L54;
        };
    L76:
        r23.topToTop(r10);
        goto L54
    L77:
        r23.topToBottom(r10);
        goto L54
    L78:
        r20.baselineNeededFor(r10.getKey());
        r23.topToBaseline(r10);
        goto L54
    L63:
        if (r8.equals("top") == false) goto L210;
        r14 = 2;
        goto L74
    L210:
        r14 = -1;
        goto L74
    L67:
        if (r8.equals("bottom") == false) goto L211;
        r14 = 1;
        goto L74
    L211:
        r14 = -1;
        goto L74
    L71:
        if (r8.equals("baseline") == false) goto L212;
        r14 = 0;
        goto L74
    L212:
        r14 = -1;
        goto L74
    L79:
        r0 = !r5;
        goto L58
    L80:
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1720785339: goto L92;
            case -1383228885: goto L88;
            case 115029: goto L84;
            default: goto L82;
        };
    L82:
        byte r26 = -1;
    L95:
        switch(r26) {
            case 0: goto L99;
            case 1: goto L98;
            case 2: goto L97;
            default: goto L54;
        };
    L97:
        r23.bottomToTop(r10);
        goto L54
    L98:
        r23.bottomToBottom(r10);
        goto L54
    L99:
        r20.baselineNeededFor(r10.getKey());
        r23.bottomToBaseline(r10);
        goto L54
    L84:
        if (r8.equals("top") == false) goto L213;
        r26 = 2;
        goto L95
    L213:
        r26 = -1;
        goto L95
    L88:
        if (r8.equals("bottom") == false) goto L214;
        r26 = 1;
        goto L95
    L214:
        r26 = -1;
        goto L95
    L92:
        if (r8.equals("baseline") == false) goto L215;
        r26 = 0;
        goto L95
    L215:
        r26 = -1;
        goto L95
    L100:
        r12 = true;
        float r27 = r21.get(r7.get(1));
        if (r7.size() <= 2) goto L103;
        r17 = toPix(r20, r21.get(r7.getOrNull(2)));
    L103:
        r23.circularConstraint(r10, r27, r17);
        r1 = 2;
        goto L124
    L104:
        r1 = 2;
        r12 = true;
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1720785339: goto L116;
            case -1383228885: goto L112;
            case 115029: goto L108;
            default: goto L106;
        };
    L106:
        byte r28 = -1;
    L119:
        switch(r28) {
            case 0: goto L123;
            case 1: goto L122;
            case 2: goto L121;
            default: goto L124;
        };
    L121:
        r20.baselineNeededFor(r23.getKey());
        r23.baselineToTop(r10);
        goto L124
    L122:
        r20.baselineNeededFor(r23.getKey());
        r23.baselineToBottom(r10);
        goto L124
    L123:
        r20.baselineNeededFor(r23.getKey());
        r20.baselineNeededFor(r10.getKey());
        r23.baselineToBaseline(r10);
        goto L124
    L108:
        if (r8.equals("top") == false) goto L216;
        r28 = 2;
        goto L119
    L216:
        r28 = -1;
        goto L119
    L112:
        if (r8.equals("bottom") == false) goto L217;
        r28 = 1;
        goto L119
    L217:
        r28 = -1;
        goto L119
    L116:
        if (r8.equals("baseline") == false) goto L218;
        r28 = 0;
        goto L119
    L218:
        r28 = -1;
        goto L119
    L22:
        if (r24.equals("start") == false) goto L198;
        r11 = 7;
        goto L53
    L198:
        r11 = -1;
        goto L53
    L26:
        if (r24.equals("right") == false) goto L199;
        r11 = 6;
        goto L53
    L199:
        r11 = -1;
        goto L53
    L30:
        if (r24.equals("left") == false) goto L200;
        r11 = 5;
        goto L53
    L200:
        r11 = -1;
        goto L53
    L34:
        if (r24.equals("top") == false) goto L201;
        r11 = 4;
        goto L53
    L201:
        r11 = -1;
        goto L53
    L38:
        if (r24.equals(TraceStatsConsts.STATS_KEY_END) == false) goto L202;
        r11 = 3;
        goto L53
    L202:
        r11 = -1;
        goto L53
    L42:
        if (r24.equals("bottom") == false) goto L203;
        r11 = 2;
        goto L53
    L203:
        r11 = -1;
        goto L53
    L46:
        if (r24.equals("circular") == false) goto L204;
        r11 = 1;
        goto L53
    L204:
        r11 = -1;
        goto L53
    L50:
        if (r24.equals("baseline") == false) goto L205;
        r11 = 0;
        goto L53
    L205:
        r11 = -1;
        goto L53
    L17:
        r10 = r20.constraints(r4);
        goto L18
    L13:
        r15 = 0.0f;
        goto L15
    L9:
        r9 = 0.0f;
        goto L10
    }

    static Dimension parseDimensionMode(String r4) {
        Dimension r1 = Dimension.createFixed(0);
        r4.hashCode();
        byte r3 = -1;
        switch(r4.hashCode()) {
            case -1460244870: goto L18;
            case -995424086: goto L14;
            case -895684237: goto L10;
            case 3657802: goto L6;
            default: goto L21;
        };
    L21:
        switch(r3) {
            case 0: goto L32;
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            default: goto L23;
        };
    L23:
        if (r4.endsWith("%") == false) goto L26;
        return Dimension.createPercent(0, Float.parseFloat(r4.substring(0, r4.indexOf(37))) / 100.0f).suggested(0);
    L26:
        if (r4.contains(":") == true) goto L35;
        return r1;
    L35:
        return Dimension.createRatio(r4).suggested(Dimension.SPREAD_DIMENSION);
    L36:
        return Dimension.createWrap();
    L37:
        return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
    L38:
        return Dimension.createParent();
    L32:
        return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
    L6:
        if (r4.equals("wrap") == false) goto L21;
        r3 = 3;
        goto L21
    L10:
        if (r4.equals(MaterialConfigFormatNames.SPREAD) == false) goto L21;
        r3 = 2;
        goto L21
    L14:
        if (r4.equals("parent") == false) goto L21;
        r3 = 1;
        goto L21
    L18:
        if (r4.equals("preferWrap") == false) goto L21;
        r3 = 0;
        goto L21
    }

    static Dimension parseDimension(CLObject r3, String r4, State r5, CorePixelDp r6) throws CLParsingException {
        CLElement r0 = r3.get(r4);
        Dimension r1 = Dimension.createFixed(0);
        if ((r0 instanceof CLString) == false) goto L6;
        return parseDimensionMode(r0.content());
    L6:
        if ((r0 instanceof CLNumber) == false) goto L9;
        return Dimension.createFixed(r5.convertDimension(Float.valueOf(r6.toPixels(r3.getFloat(r4)))));
    L9:
        if ((r0 instanceof CLObject) == false) goto L32;
        CLObject r2 = (CLObject) r0;
        String r7 = r2.getStringOrNull("value");
        if (r7 == null) goto L13;
        r1 = parseDimensionMode(r7);
    L13:
        CLElement r8 = r2.getOrNull(SliceHints.SUBTYPE_MIN);
        if (r8 != null) goto L16;
    L21:
        CLElement r9 = r2.getOrNull("max");
        if (r9 != null) goto L24;
        return r1;
    L24:
        if ((r9 instanceof CLNumber) == false) goto L27;
        r1.max(r5.convertDimension(Float.valueOf(r6.toPixels(((CLNumber) r9).getFloat()))));
        return r1;
    L27:
        if ((r9 instanceof CLString) == false) goto L35;
        r1.max(Dimension.WRAP_DIMENSION);
        return r1;
    L35:
        return r1;
    L16:
        if ((r8 instanceof CLNumber) == false) goto L19;
        r1.min(r5.convertDimension(Float.valueOf(r6.toPixels(((CLNumber) r8).getFloat()))));
        goto L21
    L19:
        if ((r8 instanceof CLString) == false) goto L21;
        r1.min(Dimension.WRAP_DIMENSION);
        goto L21
    L32:
        return r1;
    }

    static long parseColorString(String r2) {
        if (r2.startsWith("#") == false) goto L9;
        String r3 = r2.substring(1);
        if (r3.length() != 6) goto L8;
        r3 = "FF" + r3;
    L8:
        return Long.parseLong(r3, 16);
    L9:
        return -1;
    }

    static String lookForType(CLObject r3) throws CLParsingException {
        Iterator<String> r0 = r3.names().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().equals("type") == false) goto L4;
        return r3.getString("type");
    L9:
        return null;
    }
}
