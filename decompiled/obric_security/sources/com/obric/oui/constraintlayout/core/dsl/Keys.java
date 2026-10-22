package com.obric.oui.constraintlayout.core.dsl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class Keys {
    public Keys() {
    }

    protected String unpack(String[] r4) {
        StringBuilder r3 = new StringBuilder("[");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        if (r0 != 0) goto L8;
        String r2 = "'";
    L9:
        r3.append(r2);
        r3.append(r4[r0]);
        r3.append("'");
        r0 = r0 + 1;
        goto L4
    L8:
        r2 = ",'";
        goto L9
    L10:
        r3.append("]");
        return r3.toString();
    }

    protected void append(StringBuilder r1, String r2, int r3) {
        if (r3 == Integer.MIN_VALUE) goto L6;
        r1.append(r2);
        r1.append(":'").append(r3).append("',\n");
        return;
    }

    protected void append(StringBuilder r1, String r2, String r3) {
        if (r3 == null) goto L5;
        r1.append(r2);
        r1.append(":'").append(r3).append("',\n");
        return;
    }

    protected void append(StringBuilder r1, String r2, float r3) {
        if (Float.isNaN(r3) == false) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(":").append(r3).append(",\n");
    }

    protected void append(StringBuilder r1, String r2, String[] r3) {
        if (r3 == null) goto L5;
        r1.append(r2);
        r1.append(":").append(unpack(r3)).append(",\n");
        return;
    }

    protected void append(StringBuilder r1, String r2, float[] r3) {
        if (r3 == null) goto L5;
        r1.append(r2);
        r1.append("percentWidth:").append(Arrays.toString(r3)).append(",\n");
        return;
    }
}
