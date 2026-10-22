package androidx.constraintlayout.widget;

import a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = null;

        static {
            int[] r0 = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = r0;
            r0[AttributeType.REFERENCE_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
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

        private static /* synthetic */ AttributeType[] $values() {
            return new AttributeType[]{INT_TYPE, FLOAT_TYPE, COLOR_TYPE, COLOR_DRAWABLE_TYPE, STRING_TYPE, BOOLEAN_TYPE, DIMENSION_TYPE, REFERENCE_TYPE};
        }

        static {
            INT_TYPE = new AttributeType("INT_TYPE", 0);
            FLOAT_TYPE = new AttributeType("FLOAT_TYPE", 1);
            COLOR_TYPE = new AttributeType("COLOR_TYPE", 2);
            COLOR_DRAWABLE_TYPE = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            STRING_TYPE = new AttributeType("STRING_TYPE", 4);
            BOOLEAN_TYPE = new AttributeType("BOOLEAN_TYPE", 5);
            DIMENSION_TYPE = new AttributeType("DIMENSION_TYPE", 6);
            REFERENCE_TYPE = new AttributeType("REFERENCE_TYPE", 7);
            $VALUES = $values();
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

    public ConstraintAttribute(String r2, AttributeType r3) {
        this.mMethod = false;
        this.mName = r2;
        this.mType = r3;
    }

    private static int clamp(int r1) {
        int r2 = (r1 & (~(r1 >> 31))) - 255;
        return (r2 & (r2 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> r7, View r8) {
        HashMap<String, ConstraintAttribute> r0 = new HashMap();
        Class<?> r1 = r8.getClass();
        Iterator<String> r2 = r7.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L20;
        String r3 = r2.next();
        ConstraintAttribute r4 = r7.get(r3);
    L7:
        if (r3.equals("BackgroundColor") == true) goto L8;
        r0.put(r3, new ConstraintAttribute(r4, r1.getMethod("getMap" + r3, null).invoke(r8, null)));     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
        goto L4
    L8:
        r0.put(r3, new ConstraintAttribute(r4, Integer.valueOf(((ColorDrawable) r8.getBackground()).getColor())));     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L20:
        return r0;
    }

    public static void parse(Context r12, XmlPullParser r13, HashMap<String, ConstraintAttribute> r14) {
        TypedArray r15 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), R.styleable.CustomAttribute);
        int r0 = r15.getIndexCount();
        String r1 = null;
        Object r3 = null;
        AttributeType r4 = null;
        int r5 = 0;
        boolean r6 = false;
    L3:
        if (r5 >= r0) goto L46;
        int r7 = r15.getIndex(r5);
        if (r7 != R.styleable.CustomAttribute_attributeName) goto L12;
        r1 = r15.getString(r7);
        if (r1 == null) goto L45;
        if (r1.length() <= 0) goto L45;
        r1 = Character.toUpperCase(r1.charAt(0)) + r1.substring(1);
    L45:
        r5 = r5 + 1;
        goto L3
    L12:
        if (r7 != R.styleable.CustomAttribute_methodName) goto L15;
        r1 = r15.getString(r7);
        r6 = true;
        goto L45
    L15:
        if (r7 != R.styleable.CustomAttribute_customBoolean) goto L18;
        r3 = Boolean.valueOf(r15.getBoolean(r7, false));
        r4 = AttributeType.BOOLEAN_TYPE;
        goto L45
    L18:
        if (r7 != R.styleable.CustomAttribute_customColorValue) goto L22;
        AttributeType r8 = AttributeType.COLOR_TYPE;
        Object r9 = Integer.valueOf(r15.getColor(r7, 0));
    L20:
        Object r11 = r9;
        r4 = r8;
        r3 = r11;
        goto L45
    L22:
        if (r7 != R.styleable.CustomAttribute_customColorDrawableValue) goto L25;
        r8 = AttributeType.COLOR_DRAWABLE_TYPE;
        r9 = Integer.valueOf(r15.getColor(r7, 0));
        goto L20
    L25:
        if (r7 != R.styleable.CustomAttribute_customPixelDimension) goto L28;
        r8 = AttributeType.DIMENSION_TYPE;
        r9 = Float.valueOf(TypedValue.applyDimension(1, r15.getDimension(r7, 0.0f), r12.getResources().getDisplayMetrics()));
        goto L20
    L28:
        if (r7 != R.styleable.CustomAttribute_customDimension) goto L31;
        r8 = AttributeType.DIMENSION_TYPE;
        r9 = Float.valueOf(r15.getDimension(r7, 0.0f));
        goto L20
    L31:
        if (r7 != R.styleable.CustomAttribute_customFloatValue) goto L34;
        r8 = AttributeType.FLOAT_TYPE;
        r9 = Float.valueOf(r15.getFloat(r7, Float.NaN));
        goto L20
    L34:
        if (r7 != R.styleable.CustomAttribute_customIntegerValue) goto L37;
        r8 = AttributeType.INT_TYPE;
        r9 = Integer.valueOf(r15.getInteger(r7, -1));
        goto L20
    L37:
        if (r7 != R.styleable.CustomAttribute_customStringValue) goto L40;
        r8 = AttributeType.STRING_TYPE;
        r9 = r15.getString(r7);
        goto L20
    L40:
        if (r7 != R.styleable.CustomAttribute_customReference) goto L45;
        r8 = AttributeType.REFERENCE_TYPE;
        int r10 = r15.getResourceId(r7, -1);
        if (r10 != (-1)) goto L44;
        r10 = r15.getInt(r7, -1);
    L44:
        r9 = Integer.valueOf(r10);
        goto L20
    L46:
        if (r1 == null) goto L49;
        if (r3 == null) goto L49;
        r14.put(r1, new ConstraintAttribute(r1, r4, r3, r6));
    L49:
        r15.recycle();
    }

    public static void setAttributes(View r10, HashMap<String, ConstraintAttribute> r11) {
        Class<?> r3 = r10.getClass();
        Iterator<String> r4 = r11.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L30;
        String r5 = r4.next();
        ConstraintAttribute r6 = r11.get(r5);
        if (r6.mMethod == true) goto L8;
        String r7 = a.A("set", r5);
    L31:
    L10:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r6.mType.ordinal()]) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L12;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
    L12:
        r3.getMethod(r7, new Class[]{Float.TYPE}).invoke(r10, new Object[]{Float.valueOf(r6.mFloatValue)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L19:
        r3.getMethod(r7, new Class[]{Float.TYPE}).invoke(r10, new Object[]{Float.valueOf(r6.mFloatValue)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L20:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r6.mIntegerValue)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L21:
        Method r8 = r3.getMethod(r7, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        ColorDrawable r9 = new ColorDrawable();     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        r9.setColor(r6.mColorValue);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        r8.invoke(r10, new Object[]{r9});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L22:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r6.mColorValue)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L23:
        r3.getMethod(r7, new Class[]{CharSequence.class}).invoke(r10, new Object[]{r6.mStringValue});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L24:
        r3.getMethod(r7, new Class[]{Boolean.TYPE}).invoke(r10, new Object[]{Boolean.valueOf(r6.mBooleanValue)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L25:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r6.mIntegerValue)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
    L15:
        e = move-exception;
        StringBuilder r12 = a.u(" Custom Attribute \"", r5, "\" not found on ");
        r12.append(r3.getName());
        Log.e(TAG, r12.toString());
        e.printStackTrace();
    L17:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        Log.e(TAG, " Custom Attribute \"" + r5 + "\" not found on " + r3.getName());
        Log.e(TAG, r3.getName() + " must have a method " + r7);
    L13:
        e = move-exception;
        StringBuilder r13 = a.u(" Custom Attribute \"", r5, "\" not found on ");
        r13.append(r3.getName());
        Log.e(TAG, r13.toString());
        e.printStackTrace();
        goto L4
    L8:
        r7 = r5;
        goto L31
    }

    public void applyCustom(View r9) {
        Class<?> r3 = r9.getClass();
        String r4 = this.mName;
        if (this.mMethod == true) goto L5;
        String r5 = a.A("set", r4);
    L27:
    L12:
        e = move-exception;
        StringBuilder r10 = a.u(" Custom Attribute \"", r4, "\" not found on ");
        r10.append(r3.getName());
        Log.e(TAG, r10.toString());
        e.printStackTrace();
        return;
    L14:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        Log.e(TAG, " Custom Attribute \"" + r4 + "\" not found on " + r3.getName());
        Log.e(TAG, r3.getName() + " must have a method " + r5);
        return;
    L10:
        e = move-exception;
        StringBuilder r11 = a.u(" Custom Attribute \"", r4, "\" not found on ");
        r11.append(r3.getName());
        Log.e(TAG, r11.toString());
        e.printStackTrace();
        return;
    L7:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L21;
            case 7: goto L16;
            case 8: goto L9;
            default: goto L28;
        };     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
    L9:
        r3.getMethod(r5, new Class[]{Float.TYPE}).invoke(r9, new Object[]{Float.valueOf(this.mFloatValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return;
    L16:
        r3.getMethod(r5, new Class[]{Float.TYPE}).invoke(r9, new Object[]{Float.valueOf(this.mFloatValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return;
    L17:
        Method r6 = r3.getMethod(r5, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        ColorDrawable r7 = new ColorDrawable();     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r7.setColor(this.mColorValue);     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r6.invoke(r9, new Object[]{r7});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return;
    L18:
        r3.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r9, new Object[]{Integer.valueOf(this.mColorValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return;
    L19:
        r3.getMethod(r5, new Class[]{CharSequence.class}).invoke(r9, new Object[]{this.mStringValue});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return;
    L20:
        r3.getMethod(r5, new Class[]{Boolean.TYPE}).invoke(r9, new Object[]{Boolean.valueOf(this.mBooleanValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return;
    L21:
        r3.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r9, new Object[]{Integer.valueOf(this.mIntegerValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        return;
    L28:
        return;
    L5:
        r5 = r4;
        goto L27
    }

    public boolean diff(ConstraintAttribute r4) {
        if (r4 == null) goto L39;
        AttributeType r1 = this.mType;
        if (r1 == r4.mType) goto L8;
        return false;
    L8:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r1.ordinal()]) {
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

    public int getColorValue() {
        return this.mColorValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
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
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
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

    public boolean isBooleanValue() {
        return this.mBooleanValue;
    }

    public boolean isContinuous() {
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
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

    public boolean isMethod() {
        return this.mMethod;
    }

    public int numberOfInterpolatedValues() {
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
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

    public void setValue(float[] r7) {
        boolean r1 = false;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L14;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L14;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L20;
        };
    L5:
        this.mFloatValue = r7[0];
        return;
    L6:
        this.mFloatValue = r7[0];
        return;
    L7:
        int r0 = Color.HSVToColor(r7);
        this.mColorValue = r0;
        this.mColorValue = (clamp((int) (r7[3] * 255.0f)) << 24) | (r0 & ViewCompat.MEASURED_SIZE_MASK);
        return;
    L14:
        this.mIntegerValue = (int) r7[0];
        return;
    L20:
        return;
    L9:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L11:
        if (r7[0] <= 0.5d) goto L13;
        r1 = true;
    L13:
        this.mBooleanValue = r1;
    }

    public ConstraintAttribute(String r1, AttributeType r2, Object r3, boolean r4) {
        this.mName = r1;
        this.mType = r2;
        this.mMethod = r4;
        setValue(r3);
    }

    public void setValue(Object r3) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L10;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L17;
        };
    L5:
        this.mFloatValue = ((Float) r3).floatValue();
        return;
    L6:
        this.mFloatValue = ((Float) r3).floatValue();
        return;
    L7:
        this.mColorValue = ((Integer) r3).intValue();
        return;
    L8:
        this.mStringValue = (String) r3;
        return;
    L9:
        this.mBooleanValue = ((Boolean) r3).booleanValue();
        return;
    L10:
        this.mIntegerValue = ((Integer) r3).intValue();
        return;
    }

    public ConstraintAttribute(ConstraintAttribute r2, Object r3) {
        this.mMethod = false;
        this.mName = r2.mName;
        this.mType = r2.mType;
        setValue(r3);
    }
}
