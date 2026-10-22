package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLNumber extends CLElement {
    float value;

    public CLNumber(char[] r1) {
        super(r1);
        this.value = Float.NaN;
    }

    public CLNumber(float r2) {
        super(null);
        this.value = r2;
    }

    public static CLElement allocate(char[] r1) {
        return new CLNumber(r1);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        float r3 = getFloat();
        int r0 = (int) r3;
        if (r0 != r3) goto L7;
        return "" + r0;
    L7:
        return "" + r3;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
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

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.value) == false) goto L6;
        this.value = Integer.parseInt(content());
    L6:
        return (int) this.value;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.value) == false) goto L6;
        this.value = Float.parseFloat(content());
    L6:
        return this.value;
    }

    public void putValue(float r1) {
        this.value = r1;
    }
}
