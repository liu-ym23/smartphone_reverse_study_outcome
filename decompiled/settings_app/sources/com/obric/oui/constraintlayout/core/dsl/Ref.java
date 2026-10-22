package com.obric.oui.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class Ref {
    private String mId;
    private float mPostMargin;
    private float mPreMargin;
    private float mWeight;

    Ref(String r2) {
        this.mWeight = Float.NaN;
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = r2;
    }

    Ref(String r2, float r3) {
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = r2;
        this.mWeight = r3;
    }

    Ref(String r2, float r3, float r4) {
        this.mPostMargin = Float.NaN;
        this.mId = r2;
        this.mWeight = r3;
        this.mPreMargin = r4;
    }

    Ref(String r1, float r2, float r3, float r4) {
        this.mId = r1;
        this.mWeight = r2;
        this.mPreMargin = r3;
        this.mPostMargin = r4;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String r1) {
        this.mId = r1;
    }

    public float getWeight() {
        return this.mWeight;
    }

    public void setWeight(float r1) {
        this.mWeight = r1;
    }

    public float getPreMargin() {
        return this.mPreMargin;
    }

    public void setPreMargin(float r1) {
        this.mPreMargin = r1;
    }

    public float getPostMargin() {
        return this.mPostMargin;
    }

    public void setPostMargin(float r1) {
        this.mPostMargin = r1;
    }

    public static float parseFloat(Object r0) {
        return Float.parseFloat(r0.toString());
    L4:
        return Float.NaN;
    }

    public static Ref parseStringToRef(String r6) {
        String[] r7 = r6.replaceAll("[\\[\\]\\']", "").split(",");
        if (r7.length != 0) goto L6;
        return null;
    L6:
        Object[] r2 = new Object[4];
        int r4 = 0;
    L8:
        if (r4 >= r7.length) goto L13;
        if (r4 >= 4) goto L13;
        r2[r4] = r7[r4];
        r4 = r4 + 1;
    L13:
        return new Ref(r2[0].toString().replace("'", ""), parseFloat(r2[1]), parseFloat(r2[2]), parseFloat(r2[3]));
    }

    public static void addStringToReferences(String r11, ArrayList<Ref> r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.length() == 0) goto L44;
        Object[] r0 = new Object[4];
        StringBuilder r1 = new StringBuilder();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r3 >= r11.length()) goto L45;
        char r6 = r11.charAt(r3);
        if (r6 == ' ') goto L32;
        if (r6 == '\'') goto L32;
        if (r6 != ',') goto L16;
        if (r4 >= 3) goto L28;
        r0[r4] = r1.toString();
        r1.setLength(0);
        r4 = r4 + 1;
    L28:
        if (r5 != 1) goto L32;
        Object r7 = r0[0];
        if (r7 == null) goto L32;
        r12.add(new Ref(r7.toString()));
        r0[0] = null;
    L24:
        r4 = 0;
        goto L32
    L16:
        if (r6 != '[') goto L18;
        r5 = r5 + 1;
        goto L32
    L18:
        if (r6 == ']') goto L20;
        r1.append(r6);
        goto L32
    L20:
        if (r5 <= 0) goto L32;
        r5 = r5 - 1;
        r0[r4] = r1.toString();
        r1.setLength(0);
        Object r8 = r0[0];
        if (r8 == null) goto L32;
        r12.add(new Ref(r8.toString(), parseFloat(r0[1]), parseFloat(r0[2]), parseFloat(r0[3])));
        Arrays.fill(r0, null);
    L32:
        r3 = r3 + 1;
        goto L8
    L45:
        return;
    }

    public String toString() {
        String r0 = this.mId;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.length() == 0) goto L43;
        StringBuilder r1 = new StringBuilder();
        if (Float.isNaN(this.mWeight) == true) goto L10;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        r1.append("[");
    L18:
        r1.append("'").append(this.mId).append("'");
        float r3 = 0.0f;
        if (Float.isNaN(this.mPostMargin) == true) goto L29;
        StringBuilder r4 = r1.append(",");
        if (Float.isNaN(this.mWeight) == true) goto L23;
        float r5 = this.mWeight;
    L24:
        r4.append(r5).append(",");
        if (Float.isNaN(this.mPreMargin) == true) goto L27;
        r3 = this.mPreMargin;
    L27:
        r1.append(r3).append(",");
        r1.append(this.mPostMargin);
    L37:
        if (r2 == false) goto L39;
        r1.append("]");
    L39:
        r1.append(",");
        return r1.toString();
    L23:
        r5 = 0.0f;
        goto L24
    L29:
        if (Float.isNaN(this.mPreMargin) == true) goto L35;
        StringBuilder r6 = r1.append(",");
        if (Float.isNaN(this.mWeight) == true) goto L33;
        r3 = this.mWeight;
    L33:
        r6.append(r3).append(",");
        r1.append(this.mPreMargin);
        goto L37
    L35:
        if (Float.isNaN(this.mWeight) == true) goto L37;
        r1.append(",").append(this.mWeight);
        goto L37
    L10:
        if (Float.isNaN(this.mPreMargin) == false) goto L15;
        if (Float.isNaN(this.mPostMargin) == false) goto L15;
        r2 = false;
        goto L16
    L43:
        return "";
    }
}
