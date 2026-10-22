package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes4.dex */
public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(char[] r1) {
        super(r1);
        this.mValue = Float.NaN;
    }

    public CLNumber(float r2) {
        super(null);
        this.mValue = r2;
    }

    public static CLElement allocate(char[] r1) {
        return new CLNumber(r1);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        float r3 = getFloat();
        int r0 = (int) r3;
        if (r0 != r3) goto L7;
        return "" + r0;
    L7:
        return "" + r3;
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r2, int r3) {
        StringBuilder r4 = new StringBuilder();
        addIndent(r4, r2);
        float r1 = getFloat();
        int r5 = (int) r1;
        if (r5 != r1) goto L5;
        r4.append(r5);
    L7:
        return r4.toString();
    L5:
        r4.append(r1);
        goto L7
    }

    public boolean isInt() {
        float r1 = getFloat();
        if (((int) r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.mValue) == false) goto L8;
        if (hasContent() == false) goto L8;
        this.mValue = Integer.parseInt(content());
    L8:
        return (int) this.mValue;
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.mValue) == false) goto L8;
        if (hasContent() == false) goto L8;
        this.mValue = Float.parseFloat(content());
    L8:
        return this.mValue;
    }

    public void putValue(float r1) {
        this.mValue = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CLNumber) == false) goto L17;
        float r3 = getFloat();
        float r5 = ((CLNumber) r4).getFloat();
        if (Float.isNaN(r3) == false) goto L13;
        if (Float.isNaN(r5) == false) goto L13;
        return true;
    L13:
        if (r3 != r5) goto L16;
        return true;
    L16:
        return false;
    L17:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        float r2 = this.mValue;
        if (r2 == 0.0f) goto L5;
        int r3 = Float.floatToIntBits(r2);
    L7:
        return r0 + r3;
    L5:
        r3 = 0;
        goto L7
    }
}
