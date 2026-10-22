package androidx.constraintlayout.core.motion.utils;

import io.reactivex.annotations.SchedulerSupport;

/* JADX INFO: loaded from: classes.dex */
public interface TypedValues {
    public static final int BOOLEAN_MASK = 1;
    public static final int FLOAT_MASK = 4;
    public static final int INT_MASK = 2;
    public static final int STRING_MASK = 8;
    public static final String S_CUSTOM = "CUSTOM";
    public static final int TYPE_FRAME_POSITION = 100;
    public static final int TYPE_TARGET = 101;

    public interface AttributesType {
        public static final String[] KEY_WORDS = null;
        public static final String NAME = "KeyAttributes";
        public static final String S_ALPHA = "alpha";
        public static final String S_CURVE_FIT = "curveFit";
        public static final String S_CUSTOM = "CUSTOM";
        public static final String S_EASING = "easing";
        public static final String S_ELEVATION = "elevation";
        public static final String S_FRAME = "frame";
        public static final String S_PATH_ROTATE = "pathRotate";
        public static final String S_PIVOT_TARGET = "pivotTarget";
        public static final String S_PIVOT_X = "pivotX";
        public static final String S_PIVOT_Y = "pivotY";
        public static final String S_PROGRESS = "progress";
        public static final String S_ROTATION_X = "rotationX";
        public static final String S_ROTATION_Y = "rotationY";
        public static final String S_ROTATION_Z = "rotationZ";
        public static final String S_SCALE_X = "scaleX";
        public static final String S_SCALE_Y = "scaleY";
        public static final String S_TARGET = "target";
        public static final String S_TRANSLATION_X = "translationX";
        public static final String S_TRANSLATION_Y = "translationY";
        public static final String S_TRANSLATION_Z = "translationZ";
        public static final String S_VISIBILITY = "visibility";
        public static final int TYPE_ALPHA = 303;
        public static final int TYPE_CURVE_FIT = 301;
        public static final int TYPE_EASING = 317;
        public static final int TYPE_ELEVATION = 307;
        public static final int TYPE_PATH_ROTATE = 316;
        public static final int TYPE_PIVOT_TARGET = 318;
        public static final int TYPE_PIVOT_X = 313;
        public static final int TYPE_PIVOT_Y = 314;
        public static final int TYPE_PROGRESS = 315;
        public static final int TYPE_ROTATION_X = 308;
        public static final int TYPE_ROTATION_Y = 309;
        public static final int TYPE_ROTATION_Z = 310;
        public static final int TYPE_SCALE_X = 311;
        public static final int TYPE_SCALE_Y = 312;
        public static final int TYPE_TRANSLATION_X = 304;
        public static final int TYPE_TRANSLATION_Y = 305;
        public static final int TYPE_TRANSLATION_Z = 306;
        public static final int TYPE_VISIBILITY = 302;

        static {
            KEY_WORDS = new String[]{"curveFit", "visibility", "alpha", "translationX", "translationY", "translationZ", "elevation", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "pivotX", "pivotY", "progress", "pathRotate", "easing", "CUSTOM", S_FRAME, S_TARGET, S_PIVOT_TARGET};
        }

        static int getId(String r2) {
            r2.getClass();
            switch(r2.hashCode()) {
                case -1310311125: goto L82;
                case -1249320806: goto L78;
                case -1249320805: goto L74;
                case -1249320804: goto L70;
                case -1225497657: goto L66;
                case -1225497656: goto L62;
                case -1225497655: goto L58;
                case -1001078227: goto L54;
                case -987906986: goto L50;
                case -987906985: goto L46;
                case -908189618: goto L42;
                case -908189617: goto L38;
                case -880905839: goto L34;
                case -4379043: goto L30;
                case 92909918: goto L26;
                case 97692013: goto L22;
                case 579057826: goto L18;
                case 803192288: goto L14;
                case 1167159411: goto L10;
                case 1941332754: goto L6;
                default: goto L4;
            };
        L4:
            byte r3 = -1;
        L85:
            switch(r3) {
                case 0: goto L125;
                case 1: goto L123;
                case 2: goto L121;
                case 3: goto L119;
                case 4: goto L117;
                case 5: goto L115;
                case 6: goto L113;
                case 7: goto L111;
                case 8: goto L109;
                case 9: goto L107;
                case 10: goto L105;
                case 11: goto L103;
                case 12: goto L101;
                case 13: goto L99;
                case 14: goto L97;
                case 15: goto L95;
                case 16: goto L93;
                case 17: goto L91;
                case 18: goto L89;
                case 19: goto L87;
                default: goto L86;
            };
        L86:
            return -1;
        L87:
            return 302;
        L89:
            return TYPE_PIVOT_TARGET;
        L91:
            return TYPE_PATH_ROTATE;
        L93:
            return 301;
        L95:
            return 100;
        L97:
            return 303;
        L99:
            return 307;
        L101:
            return 101;
        L103:
            return 312;
        L105:
            return 311;
        L107:
            return 314;
        L109:
            return 313;
        L111:
            return 315;
        L113:
            return 306;
        L115:
            return 305;
        L117:
            return 304;
        L119:
            return 310;
        L121:
            return 309;
        L123:
            return 308;
        L125:
            return TYPE_EASING;
        L6:
            if (r2.equals("visibility") == false) goto L127;
            r3 = 19;
            goto L85
        L127:
            r3 = -1;
            goto L85
        L10:
            if (r2.equals(S_PIVOT_TARGET) == false) goto L128;
            r3 = 18;
            goto L85
        L128:
            r3 = -1;
            goto L85
        L14:
            if (r2.equals("pathRotate") == false) goto L129;
            r3 = 17;
            goto L85
        L129:
            r3 = -1;
            goto L85
        L18:
            if (r2.equals("curveFit") == false) goto L130;
            r3 = 16;
            goto L85
        L130:
            r3 = -1;
            goto L85
        L22:
            if (r2.equals(S_FRAME) == false) goto L131;
            r3 = 15;
            goto L85
        L131:
            r3 = -1;
            goto L85
        L26:
            if (r2.equals("alpha") == false) goto L132;
            r3 = 14;
            goto L85
        L132:
            r3 = -1;
            goto L85
        L30:
            if (r2.equals("elevation") == false) goto L133;
            r3 = 13;
            goto L85
        L133:
            r3 = -1;
            goto L85
        L34:
            if (r2.equals(S_TARGET) == false) goto L134;
            r3 = 12;
            goto L85
        L134:
            r3 = -1;
            goto L85
        L38:
            if (r2.equals("scaleY") == false) goto L135;
            r3 = 11;
            goto L85
        L135:
            r3 = -1;
            goto L85
        L42:
            if (r2.equals("scaleX") == false) goto L136;
            r3 = 10;
            goto L85
        L136:
            r3 = -1;
            goto L85
        L46:
            if (r2.equals("pivotY") == false) goto L137;
            r3 = 9;
            goto L85
        L137:
            r3 = -1;
            goto L85
        L50:
            if (r2.equals("pivotX") == false) goto L138;
            r3 = 8;
            goto L85
        L138:
            r3 = -1;
            goto L85
        L54:
            if (r2.equals("progress") == false) goto L139;
            r3 = 7;
            goto L85
        L139:
            r3 = -1;
            goto L85
        L58:
            if (r2.equals("translationZ") == false) goto L140;
            r3 = 6;
            goto L85
        L140:
            r3 = -1;
            goto L85
        L62:
            if (r2.equals("translationY") == false) goto L141;
            r3 = 5;
            goto L85
        L141:
            r3 = -1;
            goto L85
        L66:
            if (r2.equals("translationX") == false) goto L142;
            r3 = 4;
            goto L85
        L142:
            r3 = -1;
            goto L85
        L70:
            if (r2.equals("rotationZ") == false) goto L143;
            r3 = 3;
            goto L85
        L143:
            r3 = -1;
            goto L85
        L74:
            if (r2.equals("rotationY") == false) goto L144;
            r3 = 2;
            goto L85
        L144:
            r3 = -1;
            goto L85
        L78:
            if (r2.equals("rotationX") == false) goto L145;
            r3 = 1;
            goto L85
        L145:
            r3 = -1;
            goto L85
        L82:
            if (r2.equals("easing") == false) goto L146;
            r3 = 0;
            goto L85
        L146:
            r3 = -1;
            goto L85
        }

        static int getType(int r1) {
            if (r1 != 100) goto L5;
            return 2;
        L5:
            if (r1 == 101) goto L11;
            switch(r1) {
                case 301: goto L16;
                case 302: goto L16;
                case 303: goto L9;
                case 304: goto L9;
                case 305: goto L9;
                case 306: goto L9;
                case 307: goto L9;
                case 308: goto L9;
                case 309: goto L9;
                case 310: goto L9;
                case 311: goto L9;
                case 312: goto L9;
                case 313: goto L9;
                case 314: goto L9;
                case 315: goto L9;
                case 316: goto L9;
                case 317: goto L15;
                case 318: goto L15;
                default: goto L7;
            };
        L7:
            return -1;
        L9:
            return 4;
        L15:
            return 8;
        L16:
            return 2;
        L11:
            return 8;
        }
    }

    public interface Custom {
        public static final String[] KEY_WORDS = null;
        public static final String NAME = "Custom";
        public static final String S_BOOLEAN = "boolean";
        public static final String S_COLOR = "color";
        public static final String S_DIMENSION = "dimension";
        public static final String S_FLOAT = "float";
        public static final String S_INT = "integer";
        public static final String S_REFERENCE = "refrence";
        public static final String S_STRING = "string";
        public static final int TYPE_BOOLEAN = 904;
        public static final int TYPE_COLOR = 902;
        public static final int TYPE_DIMENSION = 905;
        public static final int TYPE_FLOAT = 901;
        public static final int TYPE_INT = 900;
        public static final int TYPE_REFERENCE = 906;
        public static final int TYPE_STRING = 903;

        static {
            KEY_WORDS = new String[]{"float", S_COLOR, "string", "boolean", S_DIMENSION, S_REFERENCE};
        }

        static int getId(String r2) {
            r2.getClass();
            switch(r2.hashCode()) {
                case -1095013018: goto L30;
                case -891985903: goto L26;
                case -710953590: goto L22;
                case 64711720: goto L18;
                case 94842723: goto L14;
                case 97526364: goto L10;
                case 1958052158: goto L6;
                default: goto L4;
            };
        L4:
            byte r3 = -1;
        L33:
            switch(r3) {
                case 0: goto L47;
                case 1: goto L45;
                case 2: goto L43;
                case 3: goto L41;
                case 4: goto L39;
                case 5: goto L37;
                case 6: goto L35;
                default: goto L34;
            };
        L34:
            return -1;
        L35:
            return TYPE_INT;
        L37:
            return TYPE_FLOAT;
        L39:
            return TYPE_COLOR;
        L41:
            return TYPE_BOOLEAN;
        L43:
            return TYPE_REFERENCE;
        L45:
            return TYPE_STRING;
        L47:
            return TYPE_DIMENSION;
        L6:
            if (r2.equals("integer") == false) goto L49;
            r3 = 6;
            goto L33
        L49:
            r3 = -1;
            goto L33
        L10:
            if (r2.equals("float") == false) goto L50;
            r3 = 5;
            goto L33
        L50:
            r3 = -1;
            goto L33
        L14:
            if (r2.equals(S_COLOR) == false) goto L51;
            r3 = 4;
            goto L33
        L51:
            r3 = -1;
            goto L33
        L18:
            if (r2.equals("boolean") == false) goto L52;
            r3 = 3;
            goto L33
        L52:
            r3 = -1;
            goto L33
        L22:
            if (r2.equals(S_REFERENCE) == false) goto L53;
            r3 = 2;
            goto L33
        L53:
            r3 = -1;
            goto L33
        L26:
            if (r2.equals("string") == false) goto L54;
            r3 = 1;
            goto L33
        L54:
            r3 = -1;
            goto L33
        L30:
            if (r2.equals(S_DIMENSION) == false) goto L55;
            r3 = 0;
            goto L33
        L55:
            r3 = -1;
            goto L33
        }
    }

    public interface CycleType {
        public static final String[] KEY_WORDS = null;
        public static final String NAME = "KeyCycle";
        public static final String S_ALPHA = "alpha";
        public static final String S_CURVE_FIT = "curveFit";
        public static final String S_CUSTOM_WAVE_SHAPE = "customWave";
        public static final String S_EASING = "easing";
        public static final String S_ELEVATION = "elevation";
        public static final String S_PATH_ROTATE = "pathRotate";
        public static final String S_PIVOT_X = "pivotX";
        public static final String S_PIVOT_Y = "pivotY";
        public static final String S_PROGRESS = "progress";
        public static final String S_ROTATION_X = "rotationX";
        public static final String S_ROTATION_Y = "rotationY";
        public static final String S_ROTATION_Z = "rotationZ";
        public static final String S_SCALE_X = "scaleX";
        public static final String S_SCALE_Y = "scaleY";
        public static final String S_TRANSLATION_X = "translationX";
        public static final String S_TRANSLATION_Y = "translationY";
        public static final String S_TRANSLATION_Z = "translationZ";
        public static final String S_VISIBILITY = "visibility";
        public static final String S_WAVE_OFFSET = "offset";
        public static final String S_WAVE_PERIOD = "period";
        public static final String S_WAVE_PHASE = "phase";
        public static final String S_WAVE_SHAPE = "waveShape";
        public static final int TYPE_ALPHA = 403;
        public static final int TYPE_CURVE_FIT = 401;
        public static final int TYPE_CUSTOM_WAVE_SHAPE = 422;
        public static final int TYPE_EASING = 420;
        public static final int TYPE_ELEVATION = 307;
        public static final int TYPE_PATH_ROTATE = 416;
        public static final int TYPE_PIVOT_X = 313;
        public static final int TYPE_PIVOT_Y = 314;
        public static final int TYPE_PROGRESS = 315;
        public static final int TYPE_ROTATION_X = 308;
        public static final int TYPE_ROTATION_Y = 309;
        public static final int TYPE_ROTATION_Z = 310;
        public static final int TYPE_SCALE_X = 311;
        public static final int TYPE_SCALE_Y = 312;
        public static final int TYPE_TRANSLATION_X = 304;
        public static final int TYPE_TRANSLATION_Y = 305;
        public static final int TYPE_TRANSLATION_Z = 306;
        public static final int TYPE_VISIBILITY = 402;
        public static final int TYPE_WAVE_OFFSET = 424;
        public static final int TYPE_WAVE_PERIOD = 423;
        public static final int TYPE_WAVE_PHASE = 425;
        public static final int TYPE_WAVE_SHAPE = 421;

        static {
            KEY_WORDS = new String[]{"curveFit", "visibility", "alpha", "translationX", "translationY", "translationZ", "elevation", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "pivotX", "pivotY", "progress", "pathRotate", "easing", "waveShape", S_CUSTOM_WAVE_SHAPE, S_WAVE_PERIOD, S_WAVE_OFFSET, S_WAVE_PHASE};
        }

        static int getId(String r2) {
            r2.getClass();
            switch(r2.hashCode()) {
                case -1310311125: goto L66;
                case -1249320806: goto L62;
                case -1249320805: goto L58;
                case -1249320804: goto L54;
                case -1225497657: goto L50;
                case -1225497656: goto L46;
                case -1225497655: goto L42;
                case -1001078227: goto L38;
                case -987906986: goto L34;
                case -987906985: goto L30;
                case -908189618: goto L26;
                case -908189617: goto L22;
                case 92909918: goto L18;
                case 579057826: goto L14;
                case 803192288: goto L10;
                case 1941332754: goto L6;
                default: goto L4;
            };
        L4:
            byte r3 = -1;
        L69:
            switch(r3) {
                case 0: goto L101;
                case 1: goto L99;
                case 2: goto L97;
                case 3: goto L95;
                case 4: goto L93;
                case 5: goto L91;
                case 6: goto L89;
                case 7: goto L87;
                case 8: goto L85;
                case 9: goto L83;
                case 10: goto L81;
                case 11: goto L79;
                case 12: goto L77;
                case 13: goto L75;
                case 14: goto L73;
                case 15: goto L71;
                default: goto L70;
            };
        L70:
            return -1;
        L71:
            return 402;
        L73:
            return 416;
        L75:
            return 401;
        L77:
            return 403;
        L79:
            return 312;
        L81:
            return 311;
        L83:
            return 314;
        L85:
            return 313;
        L87:
            return 315;
        L89:
            return 306;
        L91:
            return 305;
        L93:
            return 304;
        L95:
            return 310;
        L97:
            return 309;
        L99:
            return 308;
        L101:
            return 420;
        L6:
            if (r2.equals("visibility") == false) goto L103;
            r3 = 15;
            goto L69
        L103:
            r3 = -1;
            goto L69
        L10:
            if (r2.equals("pathRotate") == false) goto L104;
            r3 = 14;
            goto L69
        L104:
            r3 = -1;
            goto L69
        L14:
            if (r2.equals("curveFit") == false) goto L105;
            r3 = 13;
            goto L69
        L105:
            r3 = -1;
            goto L69
        L18:
            if (r2.equals("alpha") == false) goto L106;
            r3 = 12;
            goto L69
        L106:
            r3 = -1;
            goto L69
        L22:
            if (r2.equals("scaleY") == false) goto L107;
            r3 = 11;
            goto L69
        L107:
            r3 = -1;
            goto L69
        L26:
            if (r2.equals("scaleX") == false) goto L108;
            r3 = 10;
            goto L69
        L108:
            r3 = -1;
            goto L69
        L30:
            if (r2.equals("pivotY") == false) goto L109;
            r3 = 9;
            goto L69
        L109:
            r3 = -1;
            goto L69
        L34:
            if (r2.equals("pivotX") == false) goto L110;
            r3 = 8;
            goto L69
        L110:
            r3 = -1;
            goto L69
        L38:
            if (r2.equals("progress") == false) goto L111;
            r3 = 7;
            goto L69
        L111:
            r3 = -1;
            goto L69
        L42:
            if (r2.equals("translationZ") == false) goto L112;
            r3 = 6;
            goto L69
        L112:
            r3 = -1;
            goto L69
        L46:
            if (r2.equals("translationY") == false) goto L113;
            r3 = 5;
            goto L69
        L113:
            r3 = -1;
            goto L69
        L50:
            if (r2.equals("translationX") == false) goto L114;
            r3 = 4;
            goto L69
        L114:
            r3 = -1;
            goto L69
        L54:
            if (r2.equals("rotationZ") == false) goto L115;
            r3 = 3;
            goto L69
        L115:
            r3 = -1;
            goto L69
        L58:
            if (r2.equals("rotationY") == false) goto L116;
            r3 = 2;
            goto L69
        L116:
            r3 = -1;
            goto L69
        L62:
            if (r2.equals("rotationX") == false) goto L117;
            r3 = 1;
            goto L69
        L117:
            r3 = -1;
            goto L69
        L66:
            if (r2.equals("easing") == false) goto L118;
            r3 = 0;
            goto L69
        L118:
            r3 = -1;
            goto L69
        }

        static int getType(int r1) {
            if (r1 != 100) goto L5;
            return 2;
        L5:
            if (r1 != 101) goto L7;
            return 8;
        L7:
            if (r1 != 416) goto L9;
            return 4;
        L9:
            if (r1 != 420) goto L11;
            return 8;
        L11:
            if (r1 == 421) goto L27;
            switch(r1) {
                case 304: goto L23;
                case 305: goto L23;
                case 306: goto L23;
                case 307: goto L23;
                case 308: goto L23;
                case 309: goto L23;
                case 310: goto L23;
                case 311: goto L23;
                case 312: goto L23;
                case 313: goto L23;
                case 314: goto L23;
                case 315: goto L23;
                default: goto L13;
            };
        L13:
            switch(r1) {
                case 401: goto L28;
                case 402: goto L28;
                case 403: goto L24;
                default: goto L14;
            };
        L14:
            switch(r1) {
                case 423: goto L25;
                case 424: goto L25;
                case 425: goto L25;
                default: goto L15;
            };
        L15:
            return -1;
        L25:
            return 4;
        L24:
            return 4;
        L28:
            return 2;
        L23:
            return 4;
        L27:
            return 8;
        }
    }

    public interface MotionScene {
        public static final String[] KEY_WORDS = null;
        public static final String NAME = "MotionScene";
        public static final String S_DEFAULT_DURATION = "defaultDuration";
        public static final String S_LAYOUT_DURING_TRANSITION = "layoutDuringTransition";
        public static final int TYPE_DEFAULT_DURATION = 600;
        public static final int TYPE_LAYOUT_DURING_TRANSITION = 601;

        static {
            KEY_WORDS = new String[]{S_DEFAULT_DURATION, S_LAYOUT_DURING_TRANSITION};
        }

        static int getId(String r1) {
            r1.getClass();
            if (r1.equals(S_DEFAULT_DURATION) == false) goto L5;
            return 600;
        L5:
            if (r1.equals(S_LAYOUT_DURING_TRANSITION) == true) goto L8;
            return -1;
        L8:
            return 601;
        }

        static int getType(int r1) {
            if (r1 != 600) goto L5;
            return 2;
        L5:
            if (r1 == 601) goto L8;
            return -1;
        L8:
            return 1;
        }
    }

    public interface MotionType {
        public static final String[] KEY_WORDS = null;
        public static final String NAME = "Motion";
        public static final String S_ANIMATE_CIRCLEANGLE_TO = "AnimateCircleAngleTo";
        public static final String S_ANIMATE_RELATIVE_TO = "AnimateRelativeTo";
        public static final String S_DRAW_PATH = "DrawPath";
        public static final String S_EASING = "TransitionEasing";
        public static final String S_PATHMOTION_ARC = "PathMotionArc";
        public static final String S_PATH_ROTATE = "PathRotate";
        public static final String S_POLAR_RELATIVETO = "PolarRelativeTo";
        public static final String S_QUANTIZE_INTERPOLATOR = "QuantizeInterpolator";
        public static final String S_QUANTIZE_INTERPOLATOR_ID = "QuantizeInterpolatorID";
        public static final String S_QUANTIZE_INTERPOLATOR_TYPE = "QuantizeInterpolatorType";
        public static final String S_QUANTIZE_MOTIONSTEPS = "QuantizeMotionSteps";
        public static final String S_QUANTIZE_MOTION_PHASE = "QuantizeMotionPhase";
        public static final String S_STAGGER = "Stagger";
        public static final int TYPE_ANIMATE_CIRCLEANGLE_TO = 606;
        public static final int TYPE_ANIMATE_RELATIVE_TO = 605;
        public static final int TYPE_DRAW_PATH = 608;
        public static final int TYPE_EASING = 603;
        public static final int TYPE_PATHMOTION_ARC = 607;
        public static final int TYPE_PATH_ROTATE = 601;
        public static final int TYPE_POLAR_RELATIVETO = 609;
        public static final int TYPE_QUANTIZE_INTERPOLATOR = 604;
        public static final int TYPE_QUANTIZE_INTERPOLATOR_ID = 612;
        public static final int TYPE_QUANTIZE_INTERPOLATOR_TYPE = 611;
        public static final int TYPE_QUANTIZE_MOTIONSTEPS = 610;
        public static final int TYPE_QUANTIZE_MOTION_PHASE = 602;
        public static final int TYPE_STAGGER = 600;

        static {
            KEY_WORDS = new String[]{S_STAGGER, S_PATH_ROTATE, S_QUANTIZE_MOTION_PHASE, S_EASING, S_QUANTIZE_INTERPOLATOR, S_ANIMATE_RELATIVE_TO, S_ANIMATE_CIRCLEANGLE_TO, S_PATHMOTION_ARC, S_DRAW_PATH, S_POLAR_RELATIVETO, S_QUANTIZE_MOTIONSTEPS, S_QUANTIZE_INTERPOLATOR_TYPE, S_QUANTIZE_INTERPOLATOR_ID};
        }

        static int getId(String r2) {
            r2.getClass();
            switch(r2.hashCode()) {
                case -2033446275: goto L54;
                case -1532277420: goto L50;
                case -1529145600: goto L46;
                case -1498310144: goto L42;
                case -1030753096: goto L38;
                case -762370135: goto L34;
                case -232872051: goto L30;
                case 1138491429: goto L26;
                case 1539234834: goto L22;
                case 1583722451: goto L18;
                case 1639368448: goto L14;
                case 1900899336: goto L10;
                case 2109694967: goto L6;
                default: goto L4;
            };
        L4:
            byte r3 = -1;
        L57:
            switch(r3) {
                case 0: goto L83;
                case 1: goto L81;
                case 2: goto L79;
                case 3: goto L77;
                case 4: goto L75;
                case 5: goto L73;
                case 6: goto L71;
                case 7: goto L69;
                case 8: goto L67;
                case 9: goto L65;
                case 10: goto L63;
                case 11: goto L61;
                case 12: goto L59;
                default: goto L58;
            };
        L58:
            return -1;
        L59:
            return TYPE_PATHMOTION_ARC;
        L61:
            return TYPE_ANIMATE_RELATIVE_TO;
        L63:
            return TYPE_EASING;
        L65:
            return TYPE_QUANTIZE_INTERPOLATOR_ID;
        L67:
            return TYPE_QUANTIZE_INTERPOLATOR_TYPE;
        L69:
            return TYPE_POLAR_RELATIVETO;
        L71:
            return 600;
        L73:
            return TYPE_DRAW_PATH;
        L75:
            return TYPE_QUANTIZE_INTERPOLATOR;
        L77:
            return 601;
        L79:
            return TYPE_QUANTIZE_MOTIONSTEPS;
        L81:
            return TYPE_QUANTIZE_MOTION_PHASE;
        L83:
            return TYPE_ANIMATE_CIRCLEANGLE_TO;
        L6:
            if (r2.equals(S_PATHMOTION_ARC) == false) goto L85;
            r3 = 12;
            goto L57
        L85:
            r3 = -1;
            goto L57
        L10:
            if (r2.equals(S_ANIMATE_RELATIVE_TO) == false) goto L86;
            r3 = 11;
            goto L57
        L86:
            r3 = -1;
            goto L57
        L14:
            if (r2.equals(S_EASING) == false) goto L87;
            r3 = 10;
            goto L57
        L87:
            r3 = -1;
            goto L57
        L18:
            if (r2.equals(S_QUANTIZE_INTERPOLATOR_ID) == false) goto L88;
            r3 = 9;
            goto L57
        L88:
            r3 = -1;
            goto L57
        L22:
            if (r2.equals(S_QUANTIZE_INTERPOLATOR_TYPE) == false) goto L89;
            r3 = 8;
            goto L57
        L89:
            r3 = -1;
            goto L57
        L26:
            if (r2.equals(S_POLAR_RELATIVETO) == false) goto L90;
            r3 = 7;
            goto L57
        L90:
            r3 = -1;
            goto L57
        L30:
            if (r2.equals(S_STAGGER) == false) goto L91;
            r3 = 6;
            goto L57
        L91:
            r3 = -1;
            goto L57
        L34:
            if (r2.equals(S_DRAW_PATH) == false) goto L92;
            r3 = 5;
            goto L57
        L92:
            r3 = -1;
            goto L57
        L38:
            if (r2.equals(S_QUANTIZE_INTERPOLATOR) == false) goto L93;
            r3 = 4;
            goto L57
        L93:
            r3 = -1;
            goto L57
        L42:
            if (r2.equals(S_PATH_ROTATE) == false) goto L94;
            r3 = 3;
            goto L57
        L94:
            r3 = -1;
            goto L57
        L46:
            if (r2.equals(S_QUANTIZE_MOTIONSTEPS) == false) goto L95;
            r3 = 2;
            goto L57
        L95:
            r3 = -1;
            goto L57
        L50:
            if (r2.equals(S_QUANTIZE_MOTION_PHASE) == false) goto L96;
            r3 = 1;
            goto L57
        L96:
            r3 = -1;
            goto L57
        L54:
            if (r2.equals(S_ANIMATE_CIRCLEANGLE_TO) == false) goto L97;
            r3 = 0;
            goto L57
        L97:
            r3 = -1;
            goto L57
        }
    }

    public interface OnSwipe {
        public static final String AUTOCOMPLETE_MODE = "autocompletemode";
        public static final String[] AUTOCOMPLETE_MODE_ENUM = null;
        public static final String DRAG_DIRECTION = "dragdirection";
        public static final String DRAG_SCALE = "dragscale";
        public static final String DRAG_THRESHOLD = "dragthreshold";
        public static final String LIMIT_BOUNDS_TO = "limitboundsto";
        public static final String MAX_ACCELERATION = "maxacceleration";
        public static final String MAX_VELOCITY = "maxvelocity";
        public static final String MOVE_WHEN_SCROLLAT_TOP = "movewhenscrollattop";
        public static final String NESTED_SCROLL_FLAGS = "nestedscrollflags";
        public static final String[] NESTED_SCROLL_FLAGS_ENUM = null;
        public static final String ON_TOUCH_UP = "ontouchup";
        public static final String[] ON_TOUCH_UP_ENUM = null;
        public static final String ROTATION_CENTER_ID = "rotationcenterid";
        public static final String SPRINGS_TOP_THRESHOLD = "springstopthreshold";
        public static final String SPRING_BOUNDARY = "springboundary";
        public static final String[] SPRING_BOUNDARY_ENUM = null;
        public static final String SPRING_DAMPING = "springdamping";
        public static final String SPRING_MASS = "springmass";
        public static final String SPRING_STIFFNESS = "springstiffness";
        public static final String TOUCH_ANCHOR_ID = "touchanchorid";
        public static final String TOUCH_ANCHOR_SIDE = "touchanchorside";
        public static final String TOUCH_REGION_ID = "touchregionid";

        static {
            ON_TOUCH_UP_ENUM = new String[]{"autoComplete", "autoCompleteToStart", "autoCompleteToEnd", "stop", "decelerate", "decelerateAndComplete", "neverCompleteToStart", "neverCompleteToEnd"};
            SPRING_BOUNDARY_ENUM = new String[]{"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
            AUTOCOMPLETE_MODE_ENUM = new String[]{"continuousVelocity", "spring"};
            NESTED_SCROLL_FLAGS_ENUM = new String[]{SchedulerSupport.NONE, "disablePostScroll", "disableScroll", "supportScrollUp"};
        }
    }

    public interface PositionType {
        public static final String[] KEY_WORDS = null;
        public static final String NAME = "KeyPosition";
        public static final String S_DRAWPATH = "drawPath";
        public static final String S_PERCENT_HEIGHT = "percentHeight";
        public static final String S_PERCENT_WIDTH = "percentWidth";
        public static final String S_PERCENT_X = "percentX";
        public static final String S_PERCENT_Y = "percentY";
        public static final String S_SIZE_PERCENT = "sizePercent";
        public static final String S_TRANSITION_EASING = "transitionEasing";
        public static final int TYPE_CURVE_FIT = 508;
        public static final int TYPE_DRAWPATH = 502;
        public static final int TYPE_PATH_MOTION_ARC = 509;
        public static final int TYPE_PERCENT_HEIGHT = 504;
        public static final int TYPE_PERCENT_WIDTH = 503;
        public static final int TYPE_PERCENT_X = 506;
        public static final int TYPE_PERCENT_Y = 507;
        public static final int TYPE_POSITION_TYPE = 510;
        public static final int TYPE_SIZE_PERCENT = 505;
        public static final int TYPE_TRANSITION_EASING = 501;

        static {
            KEY_WORDS = new String[]{"transitionEasing", "drawPath", "percentWidth", "percentHeight", "sizePercent", "percentX", "percentY"};
        }

        static int getId(String r2) {
            r2.getClass();
            switch(r2.hashCode()) {
                case -1812823328: goto L30;
                case -1127236479: goto L26;
                case -1017587252: goto L22;
                case -827014263: goto L18;
                case -200259324: goto L14;
                case 428090547: goto L10;
                case 428090548: goto L6;
                default: goto L4;
            };
        L4:
            byte r3 = -1;
        L33:
            switch(r3) {
                case 0: goto L47;
                case 1: goto L45;
                case 2: goto L43;
                case 3: goto L41;
                case 4: goto L39;
                case 5: goto L37;
                case 6: goto L35;
                default: goto L34;
            };
        L34:
            return -1;
        L35:
            return 507;
        L37:
            return TYPE_PERCENT_X;
        L39:
            return 505;
        L41:
            return 502;
        L43:
            return 504;
        L45:
            return 503;
        L47:
            return 501;
        L6:
            if (r2.equals("percentY") == false) goto L49;
            r3 = 6;
            goto L33
        L49:
            r3 = -1;
            goto L33
        L10:
            if (r2.equals("percentX") == false) goto L50;
            r3 = 5;
            goto L33
        L50:
            r3 = -1;
            goto L33
        L14:
            if (r2.equals("sizePercent") == false) goto L51;
            r3 = 4;
            goto L33
        L51:
            r3 = -1;
            goto L33
        L18:
            if (r2.equals("drawPath") == false) goto L52;
            r3 = 3;
            goto L33
        L52:
            r3 = -1;
            goto L33
        L22:
            if (r2.equals("percentHeight") == false) goto L53;
            r3 = 2;
            goto L33
        L53:
            r3 = -1;
            goto L33
        L26:
            if (r2.equals("percentWidth") == false) goto L54;
            r3 = 1;
            goto L33
        L54:
            r3 = -1;
            goto L33
        L30:
            if (r2.equals("transitionEasing") == false) goto L55;
            r3 = 0;
            goto L33
        L55:
            r3 = -1;
            goto L33
        }

        static int getType(int r1) {
            if (r1 != 100) goto L5;
            return 2;
        L5:
            if (r1 == 101) goto L11;
            switch(r1) {
                case 501: goto L15;
                case 502: goto L15;
                case 503: goto L9;
                case 504: goto L9;
                case 505: goto L9;
                case 506: goto L9;
                case 507: goto L9;
                case 508: goto L16;
                default: goto L7;
            };
        L7:
            return -1;
        L9:
            return 4;
        L15:
            return 8;
        L16:
            return 2;
        L11:
            return 8;
        }
    }

    public interface TransitionType {
        public static final String[] KEY_WORDS = null;
        public static final String NAME = "Transitions";
        public static final String S_AUTO_TRANSITION = "autoTransition";
        public static final String S_DURATION = "duration";
        public static final String S_FROM = "from";
        public static final String S_INTERPOLATOR = "motionInterpolator";
        public static final String S_PATH_MOTION_ARC = "pathMotionArc";
        public static final String S_STAGGERED = "staggered";
        public static final String S_TO = "to";
        public static final String S_TRANSITION_FLAGS = "transitionFlags";
        public static final int TYPE_AUTO_TRANSITION = 704;
        public static final int TYPE_DURATION = 700;
        public static final int TYPE_FROM = 701;
        public static final int TYPE_INTERPOLATOR = 705;
        public static final int TYPE_PATH_MOTION_ARC = 509;
        public static final int TYPE_STAGGERED = 706;
        public static final int TYPE_TO = 702;
        public static final int TYPE_TRANSITION_FLAGS = 707;

        static {
            KEY_WORDS = new String[]{"duration", "from", S_TO, S_PATH_MOTION_ARC, S_AUTO_TRANSITION, S_INTERPOLATOR, S_STAGGERED, "from", S_TRANSITION_FLAGS};
        }

        static int getId(String r2) {
            r2.getClass();
            switch(r2.hashCode()) {
                case -1996906958: goto L34;
                case -1992012396: goto L30;
                case -1357874275: goto L26;
                case -1298065308: goto L22;
                case 3707: goto L18;
                case 3151786: goto L14;
                case 1310733335: goto L10;
                case 1839260940: goto L6;
                default: goto L4;
            };
        L4:
            byte r3 = -1;
        L37:
            switch(r3) {
                case 0: goto L53;
                case 1: goto L51;
                case 2: goto L49;
                case 3: goto L47;
                case 4: goto L45;
                case 5: goto L43;
                case 6: goto L41;
                case 7: goto L39;
                default: goto L38;
            };
        L38:
            return -1;
        L39:
            return TYPE_STAGGERED;
        L41:
            return 509;
        L43:
            return TYPE_FROM;
        L45:
            return TYPE_TO;
        L47:
            return TYPE_AUTO_TRANSITION;
        L49:
            return TYPE_INTERPOLATOR;
        L51:
            return TYPE_DURATION;
        L53:
            return TYPE_TRANSITION_FLAGS;
        L6:
            if (r2.equals(S_STAGGERED) == false) goto L55;
            r3 = 7;
            goto L37
        L55:
            r3 = -1;
            goto L37
        L10:
            if (r2.equals(S_PATH_MOTION_ARC) == false) goto L56;
            r3 = 6;
            goto L37
        L56:
            r3 = -1;
            goto L37
        L14:
            if (r2.equals("from") == false) goto L57;
            r3 = 5;
            goto L37
        L57:
            r3 = -1;
            goto L37
        L18:
            if (r2.equals(S_TO) == false) goto L58;
            r3 = 4;
            goto L37
        L58:
            r3 = -1;
            goto L37
        L22:
            if (r2.equals(S_AUTO_TRANSITION) == false) goto L59;
            r3 = 3;
            goto L37
        L59:
            r3 = -1;
            goto L37
        L26:
            if (r2.equals(S_INTERPOLATOR) == false) goto L60;
            r3 = 2;
            goto L37
        L60:
            r3 = -1;
            goto L37
        L30:
            if (r2.equals("duration") == false) goto L61;
            r3 = 1;
            goto L37
        L61:
            r3 = -1;
            goto L37
        L34:
            if (r2.equals(S_TRANSITION_FLAGS) == false) goto L62;
            r3 = 0;
            goto L37
        L62:
            r3 = -1;
            goto L37
        }

        static int getType(int r1) {
            if (r1 == 509) goto L12;
            switch(r1) {
                case 700: goto L15;
                case 701: goto L10;
                case 702: goto L10;
                default: goto L5;
            };
        L5:
            switch(r1) {
                case 705: goto L14;
                case 706: goto L8;
                case 707: goto L14;
                default: goto L6;
            };
        L6:
            return -1;
        L8:
            return 4;
        L14:
            return 8;
        L10:
            return 8;
        L15:
            return 2;
        L12:
            return 2;
        }
    }

    public interface TriggerType {
        public static final String CROSS = "CROSS";
        public static final String[] KEY_WORDS = null;
        public static final String NAME = "KeyTrigger";
        public static final String NEGATIVE_CROSS = "negativeCross";
        public static final String POSITIVE_CROSS = "positiveCross";
        public static final String POST_LAYOUT = "postLayout";
        public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
        public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
        public static final String TRIGGER_ID = "triggerID";
        public static final String TRIGGER_RECEIVER = "triggerReceiver";
        public static final String TRIGGER_SLACK = "triggerSlack";
        public static final int TYPE_CROSS = 312;
        public static final int TYPE_NEGATIVE_CROSS = 310;
        public static final int TYPE_POSITIVE_CROSS = 309;
        public static final int TYPE_POST_LAYOUT = 304;
        public static final int TYPE_TRIGGER_COLLISION_ID = 307;
        public static final int TYPE_TRIGGER_COLLISION_VIEW = 306;
        public static final int TYPE_TRIGGER_ID = 308;
        public static final int TYPE_TRIGGER_RECEIVER = 311;
        public static final int TYPE_TRIGGER_SLACK = 305;
        public static final int TYPE_VIEW_TRANSITION_ON_CROSS = 301;
        public static final int TYPE_VIEW_TRANSITION_ON_NEGATIVE_CROSS = 303;
        public static final int TYPE_VIEW_TRANSITION_ON_POSITIVE_CROSS = 302;
        public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
        public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
        public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";

        static {
            KEY_WORDS = new String[]{"viewTransitionOnCross", "viewTransitionOnPositiveCross", "viewTransitionOnNegativeCross", "postLayout", "triggerSlack", "triggerCollisionView", "triggerCollisionId", "triggerID", "positiveCross", "negativeCross", "triggerReceiver", "CROSS"};
        }

        static int getId(String r2) {
            r2.getClass();
            switch(r2.hashCode()) {
                case -1594793529: goto L50;
                case -966421266: goto L46;
                case -786670827: goto L42;
                case -648752941: goto L38;
                case -638126837: goto L34;
                case -76025313: goto L30;
                case -9754574: goto L26;
                case 64397344: goto L22;
                case 364489912: goto L18;
                case 1301930599: goto L14;
                case 1401391082: goto L10;
                case 1535404999: goto L6;
                default: goto L4;
            };
        L4:
            byte r3 = -1;
        L53:
            switch(r3) {
                case 0: goto L77;
                case 1: goto L75;
                case 2: goto L73;
                case 3: goto L71;
                case 4: goto L69;
                case 5: goto L67;
                case 6: goto L65;
                case 7: goto L63;
                case 8: goto L61;
                case 9: goto L59;
                case 10: goto L57;
                case 11: goto L55;
                default: goto L54;
            };
        L54:
            return -1;
        L55:
            return 311;
        L57:
            return 304;
        L59:
            return 301;
        L61:
            return 305;
        L63:
            return 312;
        L65:
            return 303;
        L67:
            return 306;
        L69:
            return 310;
        L71:
            return 308;
        L73:
            return 307;
        L75:
            return 302;
        L77:
            return 309;
        L6:
            if (r2.equals("triggerReceiver") == false) goto L79;
            r3 = 11;
            goto L53
        L79:
            r3 = -1;
            goto L53
        L10:
            if (r2.equals("postLayout") == false) goto L80;
            r3 = 10;
            goto L53
        L80:
            r3 = -1;
            goto L53
        L14:
            if (r2.equals("viewTransitionOnCross") == false) goto L81;
            r3 = 9;
            goto L53
        L81:
            r3 = -1;
            goto L53
        L18:
            if (r2.equals("triggerSlack") == false) goto L82;
            r3 = 8;
            goto L53
        L82:
            r3 = -1;
            goto L53
        L22:
            if (r2.equals("CROSS") == false) goto L83;
            r3 = 7;
            goto L53
        L83:
            r3 = -1;
            goto L53
        L26:
            if (r2.equals("viewTransitionOnNegativeCross") == false) goto L84;
            r3 = 6;
            goto L53
        L84:
            r3 = -1;
            goto L53
        L30:
            if (r2.equals("triggerCollisionView") == false) goto L85;
            r3 = 5;
            goto L53
        L85:
            r3 = -1;
            goto L53
        L34:
            if (r2.equals("negativeCross") == false) goto L86;
            r3 = 4;
            goto L53
        L86:
            r3 = -1;
            goto L53
        L38:
            if (r2.equals("triggerID") == false) goto L87;
            r3 = 3;
            goto L53
        L87:
            r3 = -1;
            goto L53
        L42:
            if (r2.equals("triggerCollisionId") == false) goto L88;
            r3 = 2;
            goto L53
        L88:
            r3 = -1;
            goto L53
        L46:
            if (r2.equals("viewTransitionOnPositiveCross") == false) goto L89;
            r3 = 1;
            goto L53
        L89:
            r3 = -1;
            goto L53
        L50:
            if (r2.equals("positiveCross") == false) goto L90;
            r3 = 0;
            goto L53
        L90:
            r3 = -1;
            goto L53
        }
    }

    int getId(String r1);

    boolean setValue(int r1, float r2);

    boolean setValue(int r1, int r2);

    boolean setValue(int r1, String r2);

    boolean setValue(int r1, boolean r2);
}
