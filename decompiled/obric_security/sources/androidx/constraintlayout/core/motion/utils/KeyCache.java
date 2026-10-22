package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map;

    public KeyCache() {
        this.map = new HashMap();
    }

    public void setFloatValue(Object r3, String r4, int r5, float r6) {
        if (this.map.containsKey(r3) == true) goto L5;
        HashMap<String, float[]> r0 = new HashMap();
        float[] r1 = new float[r5 + 1];
        r1[r5] = r6;
        r0.put(r4, r1);
        this.map.put(r3, r0);
        return;
    L5:
        HashMap<String, float[]> r2 = this.map.get(r3);
        if (r2 != null) goto L9;
        r2 = new HashMap();
    L9:
        if (r2.containsKey(r4) == true) goto L11;
        float[] r7 = new float[r5 + 1];
        r7[r5] = r6;
        r2.put(r4, r7);
        this.map.put(r3, r2);
        return;
    L11:
        float[] r8 = r2.get(r4);
        if (r8 != null) goto L15;
        r8 = new float[0];
    L15:
        if (r8.length > r5) goto L17;
        r8 = Arrays.copyOf(r8, r5 + 1);
    L17:
        r8[r5] = r6;
        r2.put(r4, r8);
    }

    public float getFloatValue(Object r3, String r4, int r5) {
        if (this.map.containsKey(r3) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap<String, float[]> r2 = this.map.get(r3);
        if (r2 != null) goto L8;
    L17:
        return Float.NaN;
    L8:
        if (r2.containsKey(r4) == false) goto L17;
        float[] r6 = r2.get(r4);
        if (r6 != null) goto L14;
        return Float.NaN;
    L14:
        if (r6.length <= r5) goto L17;
        return r6[r5];
    }
}
