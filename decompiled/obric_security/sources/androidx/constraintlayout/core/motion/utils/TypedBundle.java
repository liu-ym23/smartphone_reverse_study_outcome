package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int mCountBoolean;
    int mCountFloat;
    int mCountInt;
    int mCountString;
    int[] mTypeBoolean;
    int[] mTypeFloat;
    int[] mTypeInt;
    int[] mTypeString;
    boolean[] mValueBoolean;
    float[] mValueFloat;
    int[] mValueInt;
    String[] mValueString;

    public TypedBundle() {
        this.mTypeInt = new int[10];
        this.mValueInt = new int[10];
        this.mCountInt = 0;
        this.mTypeFloat = new int[10];
        this.mValueFloat = new float[10];
        this.mCountFloat = 0;
        this.mTypeString = new int[5];
        this.mValueString = new String[5];
        this.mCountString = 0;
        this.mTypeBoolean = new int[4];
        this.mValueBoolean = new boolean[4];
        this.mCountBoolean = 0;
    }

    public int getInteger(int r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mCountInt) goto L10;
        if (this.mTypeInt[r0] == r3) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return this.mValueInt[r0];
    L10:
        return -1;
    }

    public void add(int r4, int r5) {
        int r0 = this.mCountInt;
        int[] r1 = this.mTypeInt;
        if (r0 < r1.length) goto L5;
        this.mTypeInt = Arrays.copyOf(r1, r1.length * 2);
        int[] r2 = this.mValueInt;
        this.mValueInt = Arrays.copyOf(r2, r2.length * 2);
    L5:
        int[] r3 = this.mTypeInt;
        int r6 = this.mCountInt;
        r3[r6] = r4;
        int[] r7 = this.mValueInt;
        this.mCountInt = r6 + 1;
        r7[r6] = r5;
    }

    public void add(int r4, float r5) {
        int r0 = this.mCountFloat;
        int[] r1 = this.mTypeFloat;
        if (r0 < r1.length) goto L5;
        this.mTypeFloat = Arrays.copyOf(r1, r1.length * 2);
        float[] r2 = this.mValueFloat;
        this.mValueFloat = Arrays.copyOf(r2, r2.length * 2);
    L5:
        int[] r3 = this.mTypeFloat;
        int r6 = this.mCountFloat;
        r3[r6] = r4;
        float[] r7 = this.mValueFloat;
        this.mCountFloat = r6 + 1;
        r7[r6] = r5;
    }

    public void addIfNotNull(int r1, String r2) {
        if (r2 == null) goto L5;
        add(r1, r2);
        return;
    }

    public void add(int r4, String r5) {
        int r0 = this.mCountString;
        int[] r1 = this.mTypeString;
        if (r0 < r1.length) goto L5;
        this.mTypeString = Arrays.copyOf(r1, r1.length * 2);
        String[] r2 = this.mValueString;
        this.mValueString = (String[]) Arrays.copyOf(r2, r2.length * 2);
    L5:
        int[] r3 = this.mTypeString;
        int r6 = this.mCountString;
        r3[r6] = r4;
        String[] r7 = this.mValueString;
        this.mCountString = r6 + 1;
        r7[r6] = r5;
    }

    public void add(int r4, boolean r5) {
        int r0 = this.mCountBoolean;
        int[] r1 = this.mTypeBoolean;
        if (r0 < r1.length) goto L5;
        this.mTypeBoolean = Arrays.copyOf(r1, r1.length * 2);
        boolean[] r2 = this.mValueBoolean;
        this.mValueBoolean = Arrays.copyOf(r2, r2.length * 2);
    L5:
        int[] r3 = this.mTypeBoolean;
        int r6 = this.mCountBoolean;
        r3[r6] = r4;
        boolean[] r7 = this.mValueBoolean;
        this.mCountBoolean = r6 + 1;
        r7[r6] = r5;
    }

    public void applyDelta(TypedValues r5) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.mCountInt) goto L6;
        r5.setValue(this.mTypeInt[r1], this.mValueInt[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        int r2 = 0;
    L8:
        if (r2 >= this.mCountFloat) goto L10;
        r5.setValue(this.mTypeFloat[r2], this.mValueFloat[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        int r3 = 0;
    L12:
        if (r3 >= this.mCountString) goto L15;
        r5.setValue(this.mTypeString[r3], this.mValueString[r3]);
        r3 = r3 + 1;
    L15:
        if (r0 >= this.mCountBoolean) goto L17;
        r5.setValue(this.mTypeBoolean[r0], this.mValueBoolean[r0]);
        r0 = r0 + 1;
        goto L15
    }

    public void applyDelta(TypedBundle r5) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.mCountInt) goto L6;
        r5.add(this.mTypeInt[r1], this.mValueInt[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        int r2 = 0;
    L8:
        if (r2 >= this.mCountFloat) goto L10;
        r5.add(this.mTypeFloat[r2], this.mValueFloat[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        int r3 = 0;
    L12:
        if (r3 >= this.mCountString) goto L15;
        r5.add(this.mTypeString[r3], this.mValueString[r3]);
        r3 = r3 + 1;
    L15:
        if (r0 >= this.mCountBoolean) goto L17;
        r5.add(this.mTypeBoolean[r0], this.mValueBoolean[r0]);
        r0 = r0 + 1;
        goto L15
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }
}
