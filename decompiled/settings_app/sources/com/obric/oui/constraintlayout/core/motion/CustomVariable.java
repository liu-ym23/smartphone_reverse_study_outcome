package com.obric.oui.constraintlayout.core.motion;

import com.android.settingslib.accessibility.AccessibilityUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CustomVariable {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private int mType;

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
        return (((r12 << 16) + (r2 << 8)) + r4) | (-16777216);
    L19:
        return (((r11 << 16) + (r2 << 8)) + r12) | (-16777216);
    L21:
        return (((r2 << 16) + (r4 << 8)) + r12) | (-16777216);
    L23:
        return (((r2 << 16) + (r12 << 8)) + r11) | (-16777216);
    L25:
        return (((r4 << 16) + (r12 << 8)) + r2) | (-16777216);
    L27:
        return (((r12 << 16) + (r11 << 8)) + r2) | (-16777216);
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public CustomVariable(CustomVariable r2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r2.mName;
        this.mType = r2.mType;
        this.mIntegerValue = r2.mIntegerValue;
        this.mFloatValue = r2.mFloatValue;
        this.mStringValue = r2.mStringValue;
        this.mBooleanValue = r2.mBooleanValue;
    }

    public CustomVariable(String r2, int r3, String r4) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mName = r2;
        this.mType = r3;
        this.mStringValue = r4;
    }

    public CustomVariable(String r2, int r3, int r4) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r2;
        this.mType = r3;
        if (r3 != 901) goto L5;
        this.mFloatValue = r4;
        return;
    L5:
        this.mIntegerValue = r4;
    }

    public CustomVariable(String r2, int r3, float r4) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mStringValue = null;
        this.mName = r2;
        this.mType = r3;
        this.mFloatValue = r4;
    }

    public CustomVariable(String r2, int r3, boolean r4) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r2;
        this.mType = r3;
        this.mBooleanValue = r4;
    }

    public static String colorString(int r2) {
        String r3 = "00000000" + Integer.toHexString(r2);
        return "#" + r3.substring(r3.length() - 8);
    }

    public String toString() {
        String r0 = this.mName + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR;
        switch(this.mType) {
            case 900: goto L17;
            case 901: goto L15;
            case 902: goto L13;
            case 903: goto L11;
            case 904: goto L9;
            case 905: goto L7;
            default: goto L5;
        };
    L5:
        return r0 + "????";
    L7:
        return r0 + this.mFloatValue;
    L9:
        return r0 + Boolean.valueOf(this.mBooleanValue);
    L11:
        return r0 + this.mStringValue;
    L13:
        return r0 + colorString(this.mIntegerValue);
    L15:
        return r0 + this.mFloatValue;
    L17:
        return r0 + this.mIntegerValue;
    }

    public int getType() {
        return this.mType;
    }

    public boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getColorValue() {
        return this.mIntegerValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public boolean isContinuous() {
        int r1 = this.mType;
        if (r1 != 903) goto L5;
        return false;
    L5:
        if (r1 != 904) goto L7;
        return false;
    L7:
        if (r1 == 906) goto L13;
        return true;
    L13:
        return false;
    }

    public void setFloatValue(float r1) {
        this.mFloatValue = r1;
    }

    public void setBooleanValue(boolean r1) {
        this.mBooleanValue = r1;
    }

    public void setIntValue(int r1) {
        this.mIntegerValue = r1;
    }

    public void setStringValue(String r1) {
        this.mStringValue = r1;
    }

    public int numberOfInterpolatedValues() {
        if (this.mType == 902) goto L6;
        return 1;
    L6:
        return 4;
    }

    public float getValueToInterpolate() {
        switch(this.mType) {
            case 900: goto L20;
            case 901: goto L18;
            case 902: goto L16;
            case 903: goto L14;
            case 904: goto L9;
            case 905: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.mFloatValue;
    L9:
        if (this.mBooleanValue == false) goto L11;
        return 1.0f;
    L11:
        return 0.0f;
    L14:
        throw new RuntimeException("Cannot interpolate String");
    L16:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L18:
        return this.mFloatValue;
    L20:
        return this.mIntegerValue;
    }

    public void getValuesToInterpolate(float[] r10) {
        switch(this.mType) {
            case 900: goto L15;
            case 901: goto L14;
            case 902: goto L13;
            case 903: goto L12;
            case 904: goto L7;
            case 905: goto L5;
            default: goto L21;
        };
    L5:
        r10[0] = this.mFloatValue;
        return;
    L13:
        int r9 = this.mIntegerValue;
        int r0 = (r9 >> 24) & 255;
        float r2 = (float) Math.pow(((r9 >> 16) & 255) / 255.0f, 2.2d);
        float r3 = (float) Math.pow(((r9 >> 8) & 255) / 255.0f, 2.2d);
        float r11 = (float) Math.pow((r9 & 255) / 255.0f, 2.2d);
        r10[0] = r2;
        r10[1] = r3;
        r10[2] = r11;
        r10[3] = r0 / 255.0f;
        return;
    L14:
        r10[0] = this.mFloatValue;
        return;
    L15:
        r10[0] = this.mIntegerValue;
        return;
    L21:
        return;
    L7:
        if (this.mBooleanValue == false) goto L9;
        float r12 = 1.0f;
    L10:
        r10[0] = r12;
        return;
    L9:
        r12 = 0.0f;
        goto L10
    L12:
        throw new RuntimeException("Cannot interpolate String");
    }

    public void setValue(float[] r9) {
        boolean r1 = true;
        switch(this.mType) {
            case 900: goto L14;
            case 901: goto L13;
            case 902: goto L12;
            case 903: goto L11;
            case 904: goto L6;
            case 905: goto L13;
            case 906: goto L14;
            default: goto L19;
        };
    L12:
        float r0 = r9[0];
        float r2 = r9[1];
        float r4 = r9[2];
        int r3 = Math.round(((float) Math.pow(r0, 0.5d)) * 255.0f) & 255;
        int r5 = Math.round(((float) Math.pow(r2, 0.5d)) * 255.0f) & 255;
        this.mIntegerValue = ((((Math.round(r9[3] * 255.0f) & 255) << 24) | (r3 << 16)) | (r5 << 8)) | (Math.round(((float) Math.pow(r4, 0.5d)) * 255.0f) & 255);
        return;
    L13:
        this.mFloatValue = r9[0];
        return;
    L14:
        this.mIntegerValue = (int) r9[0];
        return;
    L19:
        return;
    L6:
        if (r9[0] > 0.5d) goto L9;
        r1 = false;
    L9:
        this.mBooleanValue = r1;
        return;
    L11:
        throw new RuntimeException("Cannot interpolate String");
    }

    public boolean diff(CustomVariable r4) {
        if (r4 == null) goto L39;
        int r1 = this.mType;
        if (r1 == r4.mType) goto L8;
        return false;
    L8:
        switch(r1) {
            case 900: goto L31;
            case 901: goto L27;
            case 902: goto L23;
            case 903: goto L19;
            case 904: goto L15;
            case 905: goto L11;
            case 906: goto L31;
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
        if (this.mBooleanValue == r4.mBooleanValue) goto L17;
        return false;
    L17:
        return true;
    L19:
        if (this.mIntegerValue == r4.mIntegerValue) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (this.mIntegerValue == r4.mIntegerValue) goto L25;
        return false;
    L25:
        return true;
    L27:
        if (this.mFloatValue == r4.mFloatValue) goto L29;
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

    public CustomVariable(String r2, int r3) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r2;
        this.mType = r3;
    }

    public CustomVariable(String r2, int r3, Object r4) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r2;
        this.mType = r3;
        setValue(r4);
    }

    public CustomVariable(CustomVariable r2, Object r3) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = r2.mName;
        this.mType = r2.mType;
        setValue(r3);
    }

    public void setValue(Object r2) {
        switch(this.mType) {
            case 900: goto L10;
            case 901: goto L9;
            case 902: goto L8;
            case 903: goto L7;
            case 904: goto L6;
            case 905: goto L5;
            case 906: goto L10;
            default: goto L17;
        };
    L5:
        this.mFloatValue = ((Float) r2).floatValue();
        return;
    L6:
        this.mBooleanValue = ((Boolean) r2).booleanValue();
        return;
    L7:
        this.mStringValue = (String) r2;
        return;
    L8:
        this.mIntegerValue = ((Integer) r2).intValue();
        return;
    L9:
        this.mFloatValue = ((Float) r2).floatValue();
        return;
    L10:
        this.mIntegerValue = ((Integer) r2).intValue();
        return;
    }

    public int getInterpolatedColor(float[] r7) {
        int r6 = clamp((int) (((float) Math.pow(r7[0], 0.45454545454545453d)) * 255.0f));
        int r1 = clamp((int) (((float) Math.pow(r7[1], 0.45454545454545453d)) * 255.0f));
        return (((r6 << 16) | (clamp((int) (r7[3] * 255.0f)) << 24)) | (r1 << 8)) | clamp((int) (((float) Math.pow(r7[2], 0.45454545454545453d)) * 255.0f));
    }

    public void setInterpolatedValue(MotionWidget r9, float[] r10) {
        int r0 = this.mType;
        boolean r1 = true;
        switch(r0) {
            case 900: goto L14;
            case 901: goto L13;
            case 902: goto L12;
            case 903: goto L11;
            case 904: goto L5;
            case 905: goto L13;
            case 906: goto L11;
            default: goto L19;
        };
    L5:
        String r8 = this.mName;
        if (r10[0] > 0.5f) goto L9;
        r1 = false;
    L9:
        r9.setCustomAttribute(r8, r0, r1);
        return;
    L12:
        int r2 = clamp((int) (((float) Math.pow(r10[0], 0.45454545454545453d)) * 255.0f));
        int r3 = clamp((int) (((float) Math.pow(r10[1], 0.45454545454545453d)) * 255.0f));
        r9.setCustomAttribute(this.mName, this.mType, (((clamp((int) (r10[3] * 255.0f)) << 24) | (r2 << 16)) | (r3 << 8)) | clamp((int) (((float) Math.pow(r10[2], 0.45454545454545453d)) * 255.0f)));
        return;
    L13:
        r9.setCustomAttribute(this.mName, r0, r10[0]);
        return;
    L14:
        r9.setCustomAttribute(this.mName, r0, (int) r10[0]);
        return;
    L19:
        return;
    L11:
        throw new RuntimeException("unable to interpolate " + this.mName);
    }

    public static int rgbaTocColor(float r1, float r2, float r3, float r4) {
        int r5 = clamp((int) (r1 * 255.0f));
        int r6 = clamp((int) (r2 * 255.0f));
        int r7 = clamp((int) (r3 * 255.0f));
        int r8 = r5 << 16;
        return ((r8 | (clamp((int) (r4 * 255.0f)) << 24)) | (r6 << 8)) | r7;
    }

    public void applyToWidget(MotionWidget r3) {
        int r0 = this.mType;
        switch(r0) {
            case 900: goto L8;
            case 901: goto L7;
            case 902: goto L8;
            case 903: goto L6;
            case 904: goto L5;
            case 905: goto L7;
            case 906: goto L8;
            default: goto L13;
        };
    L5:
        r3.setCustomAttribute(this.mName, r0, this.mBooleanValue);
        return;
    L6:
        r3.setCustomAttribute(this.mName, r0, this.mStringValue);
        return;
    L7:
        r3.setCustomAttribute(this.mName, r0, this.mFloatValue);
        return;
    L8:
        r3.setCustomAttribute(this.mName, r0, this.mIntegerValue);
        return;
    }

    public String getName() {
        return this.mName;
    }
}
