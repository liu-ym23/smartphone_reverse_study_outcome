package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.core.os.EnvironmentCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class WidgetFrame {
    private static final boolean OLD_SYSTEM = true;
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    public final HashMap<String, CustomVariable> mCustom;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    static {
    }

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap();
        this.name = null;
    }

    public WidgetFrame(WidgetFrame r4) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap();
        this.name = null;
        this.widget = r4.widget;
        this.left = r4.left;
        this.top = r4.top;
        this.right = r4.right;
        this.bottom = r4.bottom;
        updateAttributes(r4);
    }

    public WidgetFrame(ConstraintWidget r4) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap();
        this.name = null;
        this.widget = r4;
    }

    private static void add(StringBuilder r1, String r2, float r3) {
        if (Float.isNaN(r3) == false) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(": ");
        r1.append(r3);
        r1.append(",\n");
    }

    private static void add(StringBuilder r0, String r1, int r2) {
        r0.append(r1);
        r0.append(": ");
        r0.append(r2);
        r0.append(",\n");
    }

    private static float interpolate(float r2, float r3, float r4, float r5) {
        boolean r0 = Float.isNaN(r2);
        boolean r1 = Float.isNaN(r3);
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        return Float.NaN;
    L7:
        if (r0 == false) goto L9;
        r2 = r4;
    L9:
        if (r1 == false) goto L12;
        r3 = r4;
    L12:
        return r2 + (r5 * (r3 - r2));
    }

    public static void interpolate(int r21, int r22, WidgetFrame r23, WidgetFrame r24, WidgetFrame r25, Transition r26, float r27) {
        float r7 = 100.0f * r27;
        int r8 = (int) r7;
        int r9 = r24.left;
        int r10 = r24.top;
        int r11 = r25.left;
        int r12 = r25.top;
        int r13 = r24.right - r9;
        int r14 = r24.bottom - r10;
        int r15 = r25.right - r11;
        int r16 = r25.bottom - r12;
        float r17 = r24.alpha;
        float r6 = r25.alpha;
        if (r24.visibility != 8) goto L8;
        r9 = (int) (r9 - (r15 / 2.0f));
        r10 = (int) (r10 - (r16 / 2.0f));
        if (Float.isNaN(r17) == false) goto L7;
        int r18 = r16;
        int r19 = r15;
        float r110 = 0.0f;
    L10:
        if (r25.visibility != 8) goto L15;
        r11 = (int) (r11 - (r19 / 2.0f));
        r12 = (int) (r12 - (r18 / 2.0f));
        r15 = r19;
        r16 = r18;
        if (Float.isNaN(r6) == false) goto L15;
        r6 = 0.0f;
    L15:
        if (Float.isNaN(r110) == false) goto L20;
        if (Float.isNaN(r6) == true) goto L20;
        r110 = 1.0f;
    L20:
        if (Float.isNaN(r110) == true) goto L25;
        if (Float.isNaN(r6) == false) goto L25;
        r6 = 1.0f;
    L25:
        if (r24.visibility != 4) goto L27;
        float r0 = 0.0f;
    L29:
        if (r25.visibility != 4) goto L31;
        float r20 = 0.0f;
    L33:
        if (r23.widget != null) goto L35;
    L46:
        int r28 = r9;
        float r1 = r27;
    L47:
        int r29 = r28;
        r23.widget = r24.widget;
        int r5 = (int) (r29 + ((r11 - r29) * r1));
        r23.left = r5;
        int r2 = (int) (r10 + (r1 * (r12 - r10)));
        r23.top = r2;
        float r111 = 1.0f - r27;
        r23.right = r5 + ((int) ((r19 * r111) + (r15 * r27)));
        r23.bottom = r2 + ((int) ((r111 * r18) + (r16 * r27)));
        r23.pivotX = interpolate(r24.pivotX, r25.pivotX, 0.5f, r27);
        r23.pivotY = interpolate(r24.pivotY, r25.pivotY, 0.5f, r27);
        r23.rotationX = interpolate(r24.rotationX, r25.rotationX, 0.0f, r27);
        r23.rotationY = interpolate(r24.rotationY, r25.rotationY, 0.0f, r27);
        r23.rotationZ = interpolate(r24.rotationZ, r25.rotationZ, 0.0f, r27);
        r23.scaleX = interpolate(r24.scaleX, r25.scaleX, 1.0f, r27);
        r23.scaleY = interpolate(r24.scaleY, r25.scaleY, 1.0f, r27);
        r23.translationX = interpolate(r24.translationX, r25.translationX, 0.0f, r27);
        r23.translationY = interpolate(r24.translationY, r25.translationY, 0.0f, r27);
        r23.translationZ = interpolate(r24.translationZ, r25.translationZ, 0.0f, r27);
        r23.alpha = interpolate(r0, r20, 1.0f, r27);
        Set<String> r3 = r25.mCustom.keySet();
        r23.mCustom.clear();
        Iterator<String> r4 = r3.iterator();
    L49:
        if (r4.hasNext() == false) goto L59;
        String r30 = r4.next();
        if (r24.mCustom.containsKey(r30) == false) goto L49;
        CustomVariable r31 = r24.mCustom.get(r30);
        CustomVariable r32 = r25.mCustom.get(r30);
        CustomVariable r33 = new CustomVariable(r31);
        r23.mCustom.put(r30, r33);
        if (r31.numberOfInterpolatedValues() != 1) goto L55;
        r33.setValue(Float.valueOf(interpolate(r31.getValueToInterpolate(), r32.getValueToInterpolate(), 0.0f, r27)));
        goto L49
    L55:
        int r34 = r31.numberOfInterpolatedValues();
        float[] r35 = new float[r34];
        float[] r112 = new float[r34];
        r31.getValuesToInterpolate(r35);
        r32.getValuesToInterpolate(r112);
        int r36 = 0;
    L56:
        if (r36 >= r34) goto L49;
        r35[r36] = interpolate(r35[r36], r112[r36], 0.0f, r27);
        r33.setValue(r35);
        r36 = r36 + 1;
        goto L56
    L59:
        return;
    L35:
        if (r26.hasPositionKeyframes() == false) goto L46;
        Transition.KeyPosition r37 = r26.findPreviousPosition(r23.widget.stringId, r8);
        r28 = r9;
        Transition.KeyPosition r38 = r26.findNextPosition(r23.widget.stringId, r8);
        if (r37 != r38) goto L39;
        r38 = null;
    L39:
        if (r37 == null) goto L41;
        r28 = (int) (r37.x * r21);
        int r39 = r22;
        r10 = (int) (r37.y * r39);
        int r40 = r37.frame;
    L42:
        if (r38 == null) goto L44;
        int r41 = (int) (r38.x * r21);
        r11 = r41;
        r12 = (int) (r38.y * r39);
        int r42 = r38.frame;
    L45:
        r1 = (r7 - r40) / (r42 - r40);
        goto L47
    L44:
        r42 = 100;
        goto L45
    L41:
        r39 = r22;
        r40 = 0;
        goto L42
    L31:
        r20 = r6;
        goto L33
    L27:
        r0 = r110;
        goto L29
    L7:
        r110 = r17;
        r19 = r15;
        r18 = r16;
        goto L10
    L8:
        r19 = r13;
        r110 = r17;
        r18 = r14;
        goto L10
    }

    private void serializeAnchor(StringBuilder r2, ConstraintAnchor.Type r3) {
        ConstraintAnchor r1 = this.widget.getAnchor(r3);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.mTarget == null) goto L13;
        r2.append("Anchor");
        r2.append(r3.name());
        r2.append(": ['");
        String r4 = r1.mTarget.getOwner().stringId;
        if (r4 != null) goto L10;
        r4 = "#PARENT";
    L10:
        r2.append(r4);
        r2.append("', '");
        r2.append(r1.mTarget.getType().name());
        r2.append("', '");
        r2.append(r1.mMargin);
        r2.append("'],\n");
        return;
    }

    public void addCustomColor(String r2, int r3) {
        setCustomAttribute(r2, TypedValues.Custom.TYPE_COLOR, r3);
    }

    public void addCustomFloat(String r2, float r3) {
        setCustomAttribute(r2, TypedValues.Custom.TYPE_FLOAT, r3);
    }

    public float centerX() {
        int r0 = this.left;
        return r0 + ((this.right - r0) / 2.0f);
    }

    public float centerY() {
        int r0 = this.top;
        return r0 + ((this.bottom - r0) / 2.0f);
    }

    public CustomVariable getCustomAttribute(String r1) {
        return this.mCustom.get(r1);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String r2) {
        if (this.mCustom.containsKey(r2) == true) goto L5;
        return -21880;
    L5:
        return this.mCustom.get(r2).getColorValue();
    }

    public float getCustomFloat(String r2) {
        if (this.mCustom.containsKey(r2) == true) goto L5;
        return Float.NaN;
    L5:
        return this.mCustom.get(r2).getFloatValue();
    }

    public String getId() {
        ConstraintWidget r0 = this.widget;
        if (r0 != null) goto L7;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L7:
        return r0.stringId;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        if (Float.isNaN(this.rotationX) == true) goto L5;
    L21:
        return false;
    L5:
        if (Float.isNaN(this.rotationY) == false) goto L21;
        if (Float.isNaN(this.rotationZ) == false) goto L21;
        if (Float.isNaN(this.translationX) == false) goto L21;
        if (Float.isNaN(this.translationY) == false) goto L21;
        if (Float.isNaN(this.translationZ) == false) goto L21;
        if (Float.isNaN(this.scaleX) == false) goto L21;
        if (Float.isNaN(this.scaleY) == false) goto L21;
        if (Float.isNaN(this.alpha) == false) goto L21;
        return true;
    }

    void logv(String r4) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = (".(" + r0.getFileName() + ":" + r0.getLineNumber() + ") " + r0.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget == null) goto L5;
        String r3 = r1 + "/" + (this.widget.hashCode() % 1000);
    L6:
        System.out.println(r3 + " " + r4);
        return;
    L5:
        r3 = r1 + "/NULL";
        goto L6
    }

    void parseCustom(CLElement r7) {
        CLObject r8 = (CLObject) r7;
        int r0 = r8.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        CLKey r2 = (CLKey) r8.get(r1);
        r2.content();
        CLElement r3 = r2.getValue();
        String r4 = r3.content();
        if (r4.matches("#[0-9a-fA-F]+") == false) goto L7;
        int r5 = Integer.parseInt(r4.substring(1), 16);
        setCustomAttribute(r2.content(), TypedValues.Custom.TYPE_COLOR, r5);
    L11:
        r1 = r1 + 1;
        goto L3
    L7:
        boolean r6 = r3 instanceof CLNumber;
        String r9 = r2.content();
        if (r6 == false) goto L10;
        setCustomAttribute(r9, TypedValues.Custom.TYPE_FLOAT, r3.getFloat());
        goto L11
    L10:
        setCustomAttribute(r9, TypedValues.Custom.TYPE_STRING, r4);
        goto L11
    }

    void printCustomAttributes() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = (".(" + r0.getFileName() + ":" + r0.getLineNumber() + ") " + r0.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget == null) goto L5;
        String r2 = r1 + "/" + (this.widget.hashCode() % 1000) + " ";
    L6:
        HashMap<String, CustomVariable> r3 = this.mCustom;
        if (r3 == null) goto L12;
        Iterator<String> r4 = r3.keySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        String r5 = r4.next();
        System.out.println(r2 + this.mCustom.get(r5).toString());
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r2 = r1 + "/NULL ";
        goto L6
    }

    public StringBuilder serialize(StringBuilder r2) {
        return serialize(r2, false);
    }

    public StringBuilder serialize(StringBuilder r7, boolean r8) {
        r7.append("{\n");
        add(r7, "left", this.left);
        add(r7, "top", this.top);
        add(r7, "right", this.right);
        add(r7, "bottom", this.bottom);
        add(r7, "pivotX", this.pivotX);
        add(r7, "pivotY", this.pivotY);
        add(r7, "rotationX", this.rotationX);
        add(r7, "rotationY", this.rotationY);
        add(r7, "rotationZ", this.rotationZ);
        add(r7, "translationX", this.translationX);
        add(r7, "translationY", this.translationY);
        add(r7, "translationZ", this.translationZ);
        add(r7, "scaleX", this.scaleX);
        add(r7, "scaleY", this.scaleY);
        add(r7, "alpha", this.alpha);
        add(r7, "visibility", this.visibility);
        add(r7, "interpolatedPos", this.interpolatedPos);
        if (this.widget == null) goto L8;
        ConstraintAnchor.Type[] r0 = ConstraintAnchor.Type.values();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L8;
        serializeAnchor(r7, r0[r2]);
        r2 = r2 + 1;
    L8:
        if (r8 == false) goto L10;
        add(r7, "phone_orientation", phone_orientation);
    L10:
        if (r8 == false) goto L13;
        add(r7, "phone_orientation", phone_orientation);
    L13:
        if (this.mCustom.size() == 0) goto L29;
        r7.append("custom : {\n");
        Iterator<String> r9 = this.mCustom.keySet().iterator();
    L16:
        if (r9.hasNext() == false) goto L28;
        String r3 = r9.next();
        CustomVariable r4 = this.mCustom.get(r3);
        r7.append(r3);
        r7.append(": ");
        switch(r4.getType()) {
            case 900: goto L26;
            case 901: goto L25;
            case 902: goto L22;
            case 903: goto L21;
            case 904: goto L20;
            case 905: goto L25;
            default: goto L16;
        };
    L20:
        r7.append("'");
        r7.append(r4.getBooleanValue());
    L24:
        r7.append("',\n");
        goto L16
    L21:
        r7.append("'");
        String r5 = r4.getStringValue();
    L23:
        r7.append(r5);
        goto L24
    L22:
        r7.append("'");
        r5 = CustomVariable.colorString(r4.getIntegerValue());
        goto L23
    L25:
        r7.append(r4.getFloatValue());
    L27:
        r7.append(",\n");
        goto L16
    L26:
        r7.append(r4.getIntegerValue());
        goto L27
    L28:
        r7.append("}\n");
    L29:
        r7.append("}\n");
        return r7;
    }

    public void setCustomAttribute(String r2, int r3, float r4) {
        boolean r0 = this.mCustom.containsKey(r2);
        HashMap<String, CustomVariable> r1 = this.mCustom;
        if (r0 == false) goto L5;
        r1.get(r2).setFloatValue(r4);
        return;
    L5:
        r1.put(r2, new CustomVariable(r2, r3, r4));
    }

    public void setCustomAttribute(String r2, int r3, int r4) {
        boolean r0 = this.mCustom.containsKey(r2);
        HashMap<String, CustomVariable> r1 = this.mCustom;
        if (r0 == false) goto L5;
        r1.get(r2).setIntValue(r4);
        return;
    L5:
        r1.put(r2, new CustomVariable(r2, r3, r4));
    }

    public void setCustomAttribute(String r2, int r3, String r4) {
        boolean r0 = this.mCustom.containsKey(r2);
        HashMap<String, CustomVariable> r1 = this.mCustom;
        if (r0 == false) goto L5;
        r1.get(r2).setStringValue(r4);
        return;
    L5:
        r1.put(r2, new CustomVariable(r2, r3, r4));
    }

    public void setCustomAttribute(String r2, int r3, boolean r4) {
        boolean r0 = this.mCustom.containsKey(r2);
        HashMap<String, CustomVariable> r1 = this.mCustom;
        if (r0 == false) goto L5;
        r1.get(r2).setBooleanValue(r4);
        return;
    L5:
        r1.put(r2, new CustomVariable(r2, r3, r4));
    }

    public void setCustomValue(CustomAttribute r1, float[] r2) {
    }

    public boolean setValue(String r5, CLElement r6) {
        r5.hashCode();
        byte r3 = -1;
        switch(r5.hashCode()) {
            case -1881940865: goto L74;
            case -1383228885: goto L70;
            case -1349088399: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1249320804: goto L54;
            case -1225497657: goto L50;
            case -1225497656: goto L46;
            case -1225497655: goto L42;
            case -987906986: goto L38;
            case -987906985: goto L34;
            case -908189618: goto L30;
            case -908189617: goto L26;
            case 115029: goto L22;
            case 3317767: goto L18;
            case 92909918: goto L14;
            case 108511772: goto L10;
            case 642850769: goto L6;
            default: goto L77;
        };
    L77:
        switch(r3) {
            case 0: goto L96;
            case 1: goto L95;
            case 2: goto L94;
            case 3: goto L93;
            case 4: goto L92;
            case 5: goto L91;
            case 6: goto L90;
            case 7: goto L89;
            case 8: goto L88;
            case 9: goto L87;
            case 10: goto L86;
            case 11: goto L85;
            case 12: goto L84;
            case 13: goto L83;
            case 14: goto L82;
            case 15: goto L81;
            case 16: goto L80;
            case 17: goto L79;
            default: goto L78;
        };
    L78:
        return false;
    L79:
        this.interpolatedPos = r6.getFloat();
    L97:
        return true;
    L80:
        this.right = r6.getInt();
        goto L97
    L81:
        this.alpha = r6.getFloat();
        goto L97
    L82:
        this.left = r6.getInt();
        goto L97
    L83:
        this.top = r6.getInt();
        goto L97
    L84:
        this.scaleY = r6.getFloat();
        goto L97
    L85:
        this.scaleX = r6.getFloat();
        goto L97
    L86:
        this.pivotY = r6.getFloat();
        goto L97
    L87:
        this.pivotX = r6.getFloat();
        goto L97
    L88:
        this.translationZ = r6.getFloat();
        goto L97
    L89:
        this.translationY = r6.getFloat();
        goto L97
    L90:
        this.translationX = r6.getFloat();
        goto L97
    L91:
        this.rotationZ = r6.getFloat();
        goto L97
    L92:
        this.rotationY = r6.getFloat();
        goto L97
    L93:
        this.rotationX = r6.getFloat();
        goto L97
    L94:
        parseCustom(r6);
        goto L97
    L95:
        this.bottom = r6.getInt();
        goto L97
    L96:
        phone_orientation = r6.getFloat();
        goto L97
    L6:
        if (r5.equals("interpolatedPos") == false) goto L77;
        r3 = 17;
        goto L77
    L10:
        if (r5.equals("right") == false) goto L77;
        r3 = 16;
        goto L77
    L14:
        if (r5.equals("alpha") == false) goto L77;
        r3 = 15;
        goto L77
    L18:
        if (r5.equals("left") == false) goto L77;
        r3 = 14;
        goto L77
    L22:
        if (r5.equals("top") == false) goto L77;
        r3 = 13;
        goto L77
    L26:
        if (r5.equals("scaleY") == false) goto L77;
        r3 = 12;
        goto L77
    L30:
        if (r5.equals("scaleX") == false) goto L77;
        r3 = 11;
        goto L77
    L34:
        if (r5.equals("pivotY") == false) goto L77;
        r3 = 10;
        goto L77
    L38:
        if (r5.equals("pivotX") == false) goto L77;
        r3 = 9;
        goto L77
    L42:
        if (r5.equals("translationZ") == false) goto L77;
        r3 = 8;
        goto L77
    L46:
        if (r5.equals("translationY") == false) goto L77;
        r3 = 7;
        goto L77
    L50:
        if (r5.equals("translationX") == false) goto L77;
        r3 = 6;
        goto L77
    L54:
        if (r5.equals("rotationZ") == false) goto L77;
        r3 = 5;
        goto L77
    L58:
        if (r5.equals("rotationY") == false) goto L77;
        r3 = 4;
        goto L77
    L62:
        if (r5.equals("rotationX") == false) goto L77;
        r3 = 3;
        goto L77
    L66:
        if (r5.equals("custom") == false) goto L77;
        r3 = 2;
        goto L77
    L70:
        if (r5.equals("bottom") == false) goto L77;
        r3 = 1;
        goto L77
    L74:
        if (r5.equals("phone_orientation") == false) goto L77;
        r3 = 0;
        goto L77
    }

    public WidgetFrame update() {
        ConstraintWidget r0 = this.widget;
        if (r0 == null) goto L5;
        this.left = r0.getLeft();
        this.top = this.widget.getTop();
        this.right = this.widget.getRight();
        this.bottom = this.widget.getBottom();
        updateAttributes(this.widget.frame);
    L5:
        return this;
    }

    public WidgetFrame update(ConstraintWidget r1) {
        if (r1 != null) goto L4;
        return this;
    L4:
        this.widget = r1;
        update();
        return this;
    }

    public void updateAttributes(WidgetFrame r4) {
        this.pivotX = r4.pivotX;
        this.pivotY = r4.pivotY;
        this.rotationX = r4.rotationX;
        this.rotationY = r4.rotationY;
        this.rotationZ = r4.rotationZ;
        this.translationX = r4.translationX;
        this.translationY = r4.translationY;
        this.translationZ = r4.translationZ;
        this.scaleX = r4.scaleX;
        this.scaleY = r4.scaleY;
        this.alpha = r4.alpha;
        this.visibility = r4.visibility;
        this.mCustom.clear();
        if (r4 == null) goto L8;
        Iterator<CustomVariable> r5 = r4.mCustom.values().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        CustomVariable r0 = r5.next();
        this.mCustom.put(r0.getName(), r0.copy());
        goto L6
    L10:
        return;
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }
}
