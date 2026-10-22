package com.obric.oui.constraintlayout.core.state;

import com.obric.oui.constraintlayout.core.motion.CustomVariable;
import com.obric.oui.constraintlayout.core.motion.utils.TypedBundle;
import com.obric.oui.constraintlayout.core.parser.CLArray;
import com.obric.oui.constraintlayout.core.parser.CLContainer;
import com.obric.oui.constraintlayout.core.parser.CLElement;
import com.obric.oui.constraintlayout.core.parser.CLKey;
import com.obric.oui.constraintlayout.core.parser.CLNumber;
import com.obric.oui.constraintlayout.core.parser.CLObject;
import com.obric.oui.constraintlayout.core.parser.CLParsingException;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes4.dex */
public class TransitionParser {
    public TransitionParser() {
    }

    @Deprecated
    public static void parse(CLObject r0, Transition r1, CorePixelDp r2) throws CLParsingException {
        parse(r0, r1);
    }

    public static void parse(CLObject r10, Transition r11) throws CLParsingException {
        r11.resetProperties();
        String r0 = r10.getStringOrNull("pathMotionArc");
        TypedBundle r1 = new TypedBundle();
        boolean r2 = true;
        boolean r3 = false;
        if (r0 == null) goto L41;
        r0.hashCode();
        byte r9 = -1;
        switch(r0.hashCode()) {
            case -1857024520: goto L28;
            case -1007052250: goto L24;
            case 3145837: goto L20;
            case 3387192: goto L16;
            case 92611485: goto L12;
            case 93621297: goto L8;
            default: goto L32;
        };
    L8:
        if (r0.equals("below") == false) goto L32;
        r9 = 5;
        goto L32
    L12:
        if (r0.equals("above") == false) goto L32;
        r9 = 4;
        goto L32
    L16:
        if (r0.equals("none") == false) goto L32;
        r9 = 3;
        goto L32
    L20:
        if (r0.equals("flip") == false) goto L32;
        r9 = 2;
        goto L32
    L24:
        if (r0.equals("startHorizontal") == false) goto L32;
        r9 = 1;
        goto L32
    L28:
        if (r0.equals("startVertical") == false) goto L32;
        r9 = 0;
    L32:
        switch(r9) {
            case 0: goto L39;
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            default: goto L40;
        };
    L34:
        r1.add(509, 4);
        goto L40
    L35:
        r1.add(509, 5);
        goto L40
    L36:
        r1.add(509, 0);
        goto L40
    L37:
        r1.add(509, 3);
        goto L40
    L38:
        r1.add(509, 2);
        goto L40
    L39:
        r1.add(509, 1);
    L40:
        r3 = true;
    L41:
        String r4 = r10.getStringOrNull("interpolator");
        if (r4 == null) goto L44;
        r1.add(705, r4);
        r3 = true;
    L44:
        float r5 = r10.getFloatOrNaN("staggered");
        if (Float.isNaN(r5) == true) goto L47;
        r1.add(706, r5);
    L48:
        if (r2 == false) goto L50;
        r11.setTransitionProperties(r1);
    L50:
        CLObject r6 = r10.getObjectOrNull("onSwipe");
        if (r6 == null) goto L53;
        parseOnSwipe(r6, r11);
    L53:
        parseKeyFrames(r10, r11);
        return;
    L47:
        r2 = r3;
        goto L48
    }

    private static void parseOnSwipe(CLContainer r17, Transition r18) {
        String r1 = r17.getStringOrNull("anchor");
        int r2 = map(r17.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int r3 = map(r17.getStringOrNull(MaterialConfigFormatNames.DIRECTION), Transition.OnSwipe.DIRECTIONS);
        float r4 = r17.getFloatOrNaN("scale");
        float r5 = r17.getFloatOrNaN("threshold");
        float r6 = r17.getFloatOrNaN("maxVelocity");
        float r7 = r17.getFloatOrNaN("maxAccel");
        String r8 = r17.getStringOrNull("limitBounds");
        int r9 = map(r17.getStringOrNull("mode"), Transition.OnSwipe.MODE);
        int r10 = map(r17.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float r11 = r17.getFloatOrNaN("springMass");
        float r12 = r17.getFloatOrNaN("springStiffness");
        float r13 = r17.getFloatOrNaN("springDamping");
        float r14 = r17.getFloatOrNaN("stopThreshold");
        int r15 = map(r17.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String r0 = r17.getStringOrNull("around");
        Transition.OnSwipe r16 = r18.createOnSwipe();
        r16.setAnchorId(r1);
        r16.setAnchorSide(r2);
        r16.setDragDirection(r3);
        r16.setDragScale(r4);
        r16.setDragThreshold(r5);
        r16.setMaxVelocity(r6);
        r16.setMaxAcceleration(r7);
        r16.setLimitBoundsTo(r8);
        r16.setAutoCompleteMode(r9);
        r16.setOnTouchUp(r10);
        r16.setSpringMass(r11);
        r16.setSpringStiffness(r12);
        r16.setSpringDamping(r13);
        r16.setSpringStopThreshold(r14);
        r16.setSpringBoundary(r15);
        r16.setRotationCenterId(r0);
    }

    private static int map(String r3, String... r4) {
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L9;
        if (r4[r1].equals(r3) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return 0;
    }

    private static void map(TypedBundle r2, int r3, String r4, String... r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L9;
        if (r5[r0].equals(r4) == false) goto L8;
        r2.add(r3, r0);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public static void parseKeyFrames(CLObject r5, Transition r6) throws CLParsingException {
        CLObject r7 = r5.getObjectOrNull("KeyFrames");
        if (r7 != null) goto L5;
        return;
    L5:
        CLArray r0 = r7.getArrayOrNull("KeyPositions");
        int r1 = 0;
        if (r0 == null) goto L14;
        int r2 = 0;
    L9:
        if (r2 >= r0.size()) goto L14;
        CLElement r3 = r0.get(r2);
        if ((r3 instanceof CLObject) == false) goto L13;
        parseKeyPosition((CLObject) r3, r6);
    L13:
        r2 = r2 + 1;
    L14:
        CLArray r4 = r7.getArrayOrNull("KeyAttributes");
        if (r4 == null) goto L23;
        int r8 = 0;
    L18:
        if (r8 >= r4.size()) goto L23;
        CLElement r9 = r4.get(r8);
        if ((r9 instanceof CLObject) == false) goto L22;
        parseKeyAttribute((CLObject) r9, r6);
    L22:
        r8 = r8 + 1;
    L23:
        CLArray r10 = r7.getArrayOrNull("KeyCycles");
        if (r10 != null) goto L26;
        return;
    L26:
        if (r1 >= r10.size()) goto L41;
        CLElement r11 = r10.get(r1);
        if ((r11 instanceof CLObject) == false) goto L30;
        parseKeyCycle((CLObject) r11, r6);
    L30:
        r1 = r1 + 1;
        goto L26
    }

    private static void parseKeyPosition(CLObject r21, Transition r22) throws CLParsingException {
        TypedBundle r1 = new TypedBundle();
        CLArray r2 = r21.getArray("target");
        CLArray r3 = r21.getArray("frames");
        CLArray r4 = r21.getArrayOrNull("percentX");
        CLArray r5 = r21.getArrayOrNull("percentY");
        CLArray r6 = r21.getArrayOrNull("percentWidth");
        CLArray r7 = r21.getArrayOrNull("percentHeight");
        String r8 = r21.getStringOrNull("pathMotionArc");
        String r9 = r21.getStringOrNull("transitionEasing");
        String r10 = r21.getStringOrNull("curveFit");
        String r0 = r21.getStringOrNull("type");
        if (r0 != null) goto L5;
        r0 = "parentRelative";
    L5:
        if (r4 != null) goto L7;
    L9:
        if (r5 != null) goto L11;
    L13:
        int r13 = 0;
    L15:
        if (r13 >= r2.size()) goto L27;
        String r14 = r2.getString(r13);
        int r12 = map(r0, new String[]{"deltaRelative", "pathRelative", "parentRelative"});
        r1.clear();
        r1.add(510, r12);
        if (r10 == null) goto L19;
        map(r1, 508, r10, new String[]{"spline", "linear"});
    L19:
        r1.addIfNotNull(501, r9);
        if (r8 == null) goto L22;
        map(r1, 509, r8, new String[]{"none", "startVertical", "startHorizontal", "flip", "below", "above"});
    L22:
        int r15 = 0;
    L24:
        if (r15 >= r3.size()) goto L26;
        r1.add(100, r3.getInt(r15));
        set(r1, 506, r4, r15);
        set(r1, 507, r5, r15);
        set(r1, 503, r6, r15);
        set(r1, 504, r7, r15);
        r22.addKeyPosition(r14, r1);
        r15 = r15 + 1;
        r0 = r0;
        goto L24
    L26:
        r13 = r13 + 1;
        r0 = r0;
        goto L15
    L27:
        return;
    L11:
        if (r3.size() == r5.size()) goto L13;
        return;
    L7:
        if (r3.size() == r4.size()) goto L9;
    }

    private static void set(TypedBundle r0, int r1, CLArray r2, int r3) throws CLParsingException {
        if (r2 == null) goto L5;
        r0.add(r1, r2.getFloat(r3));
        return;
    }

    private static void parseKeyAttribute(CLObject r21, Transition r22) throws CLParsingException {
        CLArray r2 = r21.getArrayOrNull("target");
        if (r2 != null) goto L5;
        return;
    L5:
        CLArray r3 = r21.getArrayOrNull("frames");
        if (r3 != null) goto L8;
        return;
    L8:
        String r4 = r21.getStringOrNull("transitionEasing");
        String[] r5 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
        int r6 = 9;
        int[] r7 = {311, 312, 304, 305, 306, 308, 309, 310, 303};
        boolean[] r8 = {false, false, true, true, true, false, false, false, false};
        int r9 = r3.size();
        TypedBundle[] r10 = new TypedBundle[r9];
        int r12 = 0;
    L10:
        if (r12 >= r3.size()) goto L12;
        r10[r12] = new TypedBundle();
        r12 = r12 + 1;
        goto L10
    L12:
        int r13 = 0;
    L13:
        if (r13 >= r6) goto L37;
        String r14 = r5[r13];
        int r15 = r7[r13];
        boolean r16 = r8[r13];
        CLArray r11 = r21.getArrayOrNull(r14);
        if (r11 != null) goto L17;
    L21:
        if (r11 == null) goto L29;
        int r17 = 0;
    L23:
        if (r17 >= r9) goto L28;
        float r18 = r11.getFloat(r17);
        String[] r19 = r5;
        if (r16 == false) goto L27;
        r18 = r22.mToPixel.toPixels(r18);
    L27:
        r10[r17].add(r15, r18);
        r17 = r17 + 1;
        r5 = r19;
        goto L23
    L28:
        String[] r110 = r5;
    L36:
        r13 = r13 + 1;
        r5 = r110;
        r6 = 9;
        goto L13
    L29:
        r110 = r5;
        float r20 = r21.getFloatOrNaN(r14);
        if (Float.isNaN(r20) == true) goto L36;
        if (r16 == false) goto L33;
        r20 = r22.mToPixel.toPixels(r20);
    L33:
        int r23 = 0;
    L34:
        if (r23 >= r9) goto L36;
        r10[r23].add(r15, r20);
        r23 = r23 + 1;
        goto L34
    L17:
        if (r11.size() == r9) goto L21;
        throw new CLParsingException("incorrect size for " + r14 + " array, not matching targets array!", r21);
    L37:
        CLElement r24 = r21.getOrNull("custom");
        if (r24 != null) goto L40;
    L73:
        CustomVariable[][] r25 = null;
    L74:
        String r0 = r21.getStringOrNull("curveFit");
        int r111 = 0;
    L76:
        if (r111 >= r2.size()) goto L88;
        int r26 = 0;
    L78:
        if (r26 >= r9) goto L87;
        String r27 = r2.getString(r111);
        TypedBundle r28 = r10[r26];
        if (r0 == null) goto L82;
        r28.add(508, map(r0, new String[]{"spline", "linear"}));
    L82:
        r28.addIfNotNull(501, r4);
        r28.add(100, r3.getInt(r26));
        if (r25 == null) goto L85;
        CustomVariable[] r112 = r25[r26];
    L86:
        r22.addKeyAttribute(r27, r28, r112);
        r26 = r26 + 1;
        goto L78
    L85:
        r112 = null;
        goto L86
    L87:
        r111 = r111 + 1;
        goto L76
    L88:
        return;
    L40:
        if ((r24 instanceof CLObject) == false) goto L73;
        CLObject r29 = (CLObject) r24;
        int r30 = r29.size();
        r25 = (CustomVariable[][]) Array.newInstance(CustomVariable.class, new int[]{r3.size(), r30});
        int r113 = 0;
    L42:
        if (r113 >= r30) goto L74;
        CLKey r114 = (CLKey) r29.get(r113);
        String r115 = r114.content();
        if ((r114.getValue() instanceof CLArray) == false) goto L62;
        CLArray r116 = (CLArray) r114.getValue();
        int r117 = r116.size();
        if (r117 != r9) goto L60;
        if (r117 <= 0) goto L60;
        if ((r116.get(0) instanceof CLNumber) == false) goto L53;
        int r118 = 0;
    L51:
        if (r118 >= r9) goto L60;
        r25[r118][r113] = new CustomVariable(r115, 901, r116.get(r118).getFloat());
        r118 = r118 + 1;
        r29 = r29;
        goto L51
    L53:
        CLObject r119 = r29;
        int r31 = 0;
    L54:
        if (r31 >= r9) goto L61;
        long r120 = ConstraintSetParser.parseColorString(r116.get(r31).content());
        if (r120 == (-1)) goto L59;
        r25[r31][r113] = new CustomVariable(r115, 902, (int) r120);
    L59:
        r31 = r31 + 1;
        r30 = r30;
    L61:
        int r210 = r30;
    L72:
        r113 = r113 + 1;
        r29 = r119;
        r30 = r210;
    L60:
        r119 = r29;
        goto L61
    L62:
        r119 = r29;
        r210 = r30;
        CLElement r32 = r114.getValue();
        if ((r32 instanceof CLNumber) == false) goto L67;
        float r33 = r32.getFloat();
        int r34 = 0;
    L65:
        if (r34 >= r9) goto L72;
        r25[r34][r113] = new CustomVariable(r115, 901, r33);
        r34 = r34 + 1;
        goto L65
    L67:
        long r35 = ConstraintSetParser.parseColorString(r32.content());
        if (r35 == (-1)) goto L72;
        int r36 = 0;
    L70:
        if (r36 >= r9) goto L72;
        r25[r36][r113] = new CustomVariable(r115, 902, (int) r35);
        r36 = r36 + 1;
        r35 = r35;
        goto L70
    }

    private static void parseKeyCycle(CLObject r19, Transition r20) throws CLParsingException {
        CLArray r2 = r19.getArray("target");
        CLArray r3 = r19.getArray("frames");
        String r4 = r19.getStringOrNull("transitionEasing");
        String[] r5 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha", "period", "offset", "phase"};
        int r6 = 12;
        int[] r7 = {311, 312, 304, 305, 306, 308, 309, 310, 403, 423, 424, 425};
        int[] r8 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0};
        int r9 = r3.size();
        TypedBundle[] r10 = new TypedBundle[r9];
        int r12 = 0;
    L3:
        if (r12 >= r9) goto L5;
        r10[r12] = new TypedBundle();
        r12 = r12 + 1;
        goto L3
    L5:
        int r13 = 0;
        boolean r14 = false;
    L7:
        if (r13 >= 12) goto L14;
        if (r19.has(r5[r13]) == false) goto L13;
        if (r8[r13] != 1) goto L13;
        r14 = true;
    L13:
        r13 = r13 + 1;
        goto L7
    L14:
        int r15 = 0;
    L15:
        if (r15 >= r6) goto L48;
        String r16 = r5[r15];
        int r11 = r7[r15];
        int r17 = r8[r15];
        CLArray r18 = r19.getArrayOrNull(r16);
        String[] r110 = r5;
        if (r18 != null) goto L19;
    L23:
        if (r18 == null) goto L35;
        int r111 = 0;
    L25:
        if (r111 >= r9) goto L34;
        float r21 = r18.getFloat(r111);
        int[] r112 = r7;
        if (r17 != 1) goto L30;
        r21 = r20.mToPixel.toPixels(r21);
    L33:
        r10[r111].add(r11, r21);
        r111 = r111 + 1;
        r7 = r112;
        goto L25
    L30:
        if (r17 != 2) goto L33;
        if (r14 == false) goto L33;
        r21 = r20.mToPixel.toPixels(r21);
        goto L33
    L34:
        int[] r113 = r7;
    L47:
        r15 = r15 + 1;
        r5 = r110;
        r7 = r113;
        r6 = 12;
        goto L15
    L35:
        r113 = r7;
        float r22 = r19.getFloatOrNaN(r16);
        if (Float.isNaN(r22) == true) goto L47;
        if (r17 != 1) goto L41;
        r22 = r20.mToPixel.toPixels(r22);
    L44:
        int r23 = 0;
    L45:
        if (r23 >= r9) goto L47;
        r10[r23].add(r11, r22);
        r23 = r23 + 1;
        goto L45
    L41:
        if (r17 != 2) goto L44;
        if (r14 == false) goto L44;
        r22 = r20.mToPixel.toPixels(r22);
        goto L44
    L19:
        if (r18.size() == r9) goto L23;
        throw new CLParsingException("incorrect size for $attrName array, not matching targets array!", r19);
    L48:
        String r24 = r19.getStringOrNull("curveFit");
        String r25 = r19.getStringOrNull("easing");
        String r26 = r19.getStringOrNull("waveShape");
        String r0 = r19.getStringOrNull("customWave");
        int r27 = 0;
    L50:
        if (r27 >= r2.size()) goto L72;
        int r114 = 0;
    L52:
        if (r114 >= r9) goto L71;
        String r115 = r2.getString(r27);
        TypedBundle r116 = r10[r114];
        if (r24 == null) goto L63;
        r24.hashCode();
        if (r24.equals("linear") == false) goto L58;
        r116.add(401, 1);
        goto L63
    L58:
        if (r24.equals("spline") == false) goto L63;
        r116.add(401, 0);
    L63:
        r116.addIfNotNull(501, r4);
        if (r25 == null) goto L66;
        r116.add(420, r25);
    L66:
        if (r26 == null) goto L68;
        r116.add(421, r26);
    L68:
        if (r0 == null) goto L70;
        r116.add(422, r0);
    L70:
        r116.add(100, r3.getInt(r114));
        r20.addKeyCycle(r115, r116);
        r114 = r114 + 1;
        goto L52
    L71:
        r27 = r27 + 1;
        goto L50
    }
}
